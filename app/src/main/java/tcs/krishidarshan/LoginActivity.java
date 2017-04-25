package tcs.krishidarshan;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;

import static tcs.krishidarshan.MyApplication.context;

/**
 * Created by Abhishek on 18-09-2016.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 9001;

    private SignInButton signInButton;
    private GoogleSignInOptions gso;
    private GoogleApiClient mGoogleApiClient;
    private ProgressDialog mProgressDialog;
    private EditText your_full_name, city_name;
    private EditText your_mobile;
    private LinearLayout llHindi, llEnglish;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (!preferences.getString("pref_name", "").isEmpty()) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
        //Initializing google signin option
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_WIDE);
        signInButton.setScopes(gso.getScopeArray());
        signInButton.setOnClickListener(this);
        your_full_name = (EditText) findViewById(R.id.your_full_name);
        your_mobile = (EditText) findViewById(R.id.mobile_number);
        city_name = (EditText) findViewById(R.id.city_name);
    }

    public void clicked_signup(View v) {
        your_full_name.setError(null);
        your_mobile.setError(null);
        city_name.setError(null);
        boolean cancel = false;
        View focusView = null;
        String name = your_full_name.getText().toString();
        String mobile = your_mobile.getText().toString();
        String city = city_name.getText().toString();
        if (TextUtils.isEmpty(name)) {
            your_full_name.setError(getResources().getString(R.string.prompt_name));
            focusView = signInButton;
            cancel = true;

        }
        if (TextUtils.isEmpty(mobile)) {
            your_mobile.setError(getResources().getString(R.string.prompt_mobile));
            focusView = signInButton;
            cancel = true;

        }
        if (TextUtils.isEmpty(city)) {
            city_name.setError(getResources().getString(R.string.prompt_city));
            focusView = signInButton;
            cancel = true;

        } else if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(mobile) && !TextUtils.isEmpty(city)) {

            editor.putString("pref_name", name).commit();
            editor.putString("pref_mobile", mobile).commit();
            editor.putString("pref_location_key", city).commit();
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(mGoogleApiClient);
        if (opr.isDone()) {
            Log.d(TAG, "Got cached sign-in");
            GoogleSignInResult result = opr.get();
            handleSignInResult(result);
        } else {
            showProgressDialog();
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(GoogleSignInResult googleSignInResult) {
                    hideProgressDialog();
                    handleSignInResult(googleSignInResult);
                }
            });
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //If signin
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        //If the login succeed
        if (result.isSuccess()) {
            GoogleSignInAccount acct = result.getSignInAccount();
            Intent intent = new Intent(this, MainActivity.class);
            editor.putString("pref_name", acct.getDisplayName()).commit();
            startActivity(intent);
            finish();
        } else {
            //If login fails
            Toast.makeText(this, context.getResources().getString(R.string.login_toast), Toast.LENGTH_LONG).show();
        }
    }

    //This function will option signing intent
    private void signIn() {
        if (mGoogleApiClient != null) {
            mGoogleApiClient.disconnect();
        }
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.d(TAG, "onConnectionFailed:" + connectionResult);
    }

    private void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }
        mProgressDialog.show();
    }

    private void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.hide();
        }
    }

    @Override
    public void onClick(View v) {
        if (v == signInButton) {
            //Calling signin
            signIn();
        }
    }
}
