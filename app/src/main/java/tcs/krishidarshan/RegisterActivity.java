package tcs.krishidarshan;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * Created by Abhishek on 16-03-2017.
 */

public class RegisterActivity extends AppCompatActivity implements LoaderCallbacks<Cursor> {
    Spinner spinner1, spinner2, spinner3;
    Button register;
    String[] spndata1 = {"Select Language", "English", "हिंदी", "ગુજરાતી", "ਪੰਜਾਬੀ", "தமிழ்"};
    String[] spndata2 = {"Select State", "Andaman and Nicobar Island", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chandigarh", "Chhattisgarh", "Dadra and Nagar Haveli", "Daman and Diu", "National Capital Territory of Delhi", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and" +
            " Kashmir", "Jharkhand", "Karnataka", "Kerala", "Lakshadweep", "Madhya Pradesh", "Maharashtra", "Manipur", "Manipur", "Mizoram", "Nagaland", "Odisha", "Puducherry", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttar Pradesh", "Uttarakhand", "West Bengal"};
    String[] spndata3 = {"Choose City"};

    ArrayList<String> a = new ArrayList<>();
    ArrayList<String> b = new ArrayList<>();
    ArrayList<String> c = new ArrayList<>();
    ArrayList<String> d = new ArrayList<>();
    ArrayList<String> e = new ArrayList<>();
    ArrayList<String> f = new ArrayList<>();
    ArrayList<String> g = new ArrayList<>();
    ArrayList<String> h = new ArrayList<>();
    ArrayList<String> i = new ArrayList<>();
    ArrayList<String> j = new ArrayList<>();
    ArrayList<String> k = new ArrayList<>();
    ArrayList<String> l = new ArrayList<>();
    ArrayList<String> m = new ArrayList<>();
    ArrayList<String> n = new ArrayList<>();
    ArrayList<String> o = new ArrayList<>();
    ArrayList<String> p = new ArrayList<>();
    ArrayList<String> q = new ArrayList<>();
    ArrayList<String> r = new ArrayList<>();
    ArrayList<String> s = new ArrayList<>();
    ArrayList<String> t = new ArrayList<>();
    ArrayList<String> u = new ArrayList<>();
    ArrayList<String> v = new ArrayList<>();
    ArrayList<String> w = new ArrayList<>();
    ArrayList<String> x = new ArrayList<>();
    ArrayList<String> y = new ArrayList<>();
    ArrayList<String> z = new ArrayList<>();
    ArrayList<String> z1 = new ArrayList<>();
    ArrayList<String> z2 = new ArrayList<>();
    ArrayList<String> z3 = new ArrayList<>();

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    private RegisterActivity.UserLoginTask mAuthTask = null;

    // UI references.
    private EditText mEmailView;
    private EditText mPasswordView;
    private View mProgressView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_form);

        spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);

        // Set up the login form.
        mEmailView = (EditText) findViewById(R.id.reg_email);
        populateAutoComplete();

        mPasswordView = (EditText) findViewById(R.id.reg_pass);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin();
            }
        });
        mProgressView = findViewById(R.id.login_progress1);

        /*Spinner 1 selected Code----Start*/
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, R.layout.support_simple_spinner_dropdown_item, spndata1);

        fillarray();
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                position = spinner1.getSelectedItemPosition();
                if (position == 0) {
                } else {
                    Toast.makeText(getApplicationContext(), "You have selected Language " + spndata1[+position], Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        /*End of Spinner 1*/
        /*Start of Spinner2 */
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(
                this, R.layout.support_simple_spinner_dropdown_item, spndata2);

        spinner2.setAdapter(adapter1);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, a));
                        break;
                    case 2:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, b));
                        break;
                    case 3:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, c));
                        break;
                    case 4:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, d));
                        break;
                    case 5:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, e));
                        break;
                    case 6:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, f));
                        break;
                    case 7:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, g));
                        break;
                    case 8:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, h));
                        break;
                    case 9:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, i));
                        break;
                    case 10:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, j));
                        break;
                    case 11:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, k));
                        break;
                    case 12:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, l));
                        break;
                    case 13:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, m));
                        break;
                    case 14:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, n));
                        break;
                    case 15:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, o));
                        break;
                    case 16:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, p));
                        break;
                    case 17:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, q));
                        break;
                    case 18:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, r));
                        break;
                    case 19:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, s));
                        break;
                    case 20:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, t));
                        break;
                    case 21:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, u));
                        break;
                    case 22:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, v));
                        break;
                    case 23:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, w));
                        break;
                    case 24:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, x));
                        break;
                    case 25:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, y));
                        break;
                    case 26:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, z));
                        break;
                    case 27:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, z1));
                        break;
                    case 28:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, z2));
                        break;
                    case 29:
                        spinner3.setAdapter(new ArrayAdapter<>(
                                RegisterActivity.this, R.layout.support_simple_spinner_dropdown_item, z3));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        /*End of Spinner2*/
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(
                this, R.layout.support_simple_spinner_dropdown_item, spndata3);

        spinner3.setAdapter(adapter2);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void fillarray() {
        a.clear();
        a.add("NICOBAR");
        a.add("NORTH AND MIDDLE ANDAMAN");
        a.add("SOUTH ANDAMAN");

        b.clear();
        b.add("ANANTPUR");
        b.add("CHITTOOR");
        b.add("CUDDEPAH");
        b.add("EAST GODAVRI");
        b.add("GUNTUR");
        b.add("KRISHNA");
        b.add("KURNOOL");
        b.add("NELLORE");
        b.add("PRAKASAM");
        b.add("SRIKAKULAM");
        b.add("VISAKHAPATNAM");
        b.add("VIZIANAGARM");
        b.add("WEST GODAVRI");

        c.clear();
        c.add("BAKSA");
        c.add("BARPETA");
        c.add("BONGAIGAON");
        c.add("Cachar");
        c.add("Darrang");
        c.add("Dhemaji");
        c.add("Dhubri");
        c.add("Dibrugarh");
        c.add("Goalpara");
        c.add("Golaghat");
        c.add("Hailakandi");
        c.add("Jorhat");
        c.add("Kamrup");
        c.add("KAMRUP-ANGLONG");
        c.add("Karbi Anglong");
        c.add("Karimganj");
        c.add("Kokrajhar");
        c.add("Lakhimpur");
        c.add("Marigaon");
        c.add("Nagaon");
        c.add("Nalbari");
        c.add("NORTH CACHAR HILLS");
        c.add("Sivasagar");
        c.add("Sonitpur");
        c.add("Tinsukia");
        c.add("Udalguri");
    }

    private void populateAutoComplete() {
        if (!mayRequestContacts()) {
            return;
        }
        getLoaderManager().initLoader(0, null, this);
    }

    private boolean mayRequestContacts() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        if (checkSelfPermission(READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        if (shouldShowRequestPermissionRationale(READ_CONTACTS)) {
            Snackbar.make(mEmailView, R.string.permission_rationale, Snackbar.LENGTH_INDEFINITE)
                    .setAction(android.R.string.ok, new View.OnClickListener() {
                        @Override
                        @TargetApi(Build.VERSION_CODES.M)
                        public void onClick(View v) {
                            requestPermissions(new String[]{READ_CONTACTS}, REQUEST_READ_CONTACTS);
                        }
                    });
        } else {
            requestPermissions(new String[]{READ_CONTACTS}, REQUEST_READ_CONTACTS);
        }
        return false;
    }

    /**
     * Callback received when a permissions request has been completed.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == REQUEST_READ_CONTACTS) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                populateAutoComplete();
            }
        }
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password)) {
            mPasswordView.setError(getString(R.string.error_field_required));
            focusView = mPasswordView;
            cancel = true;
        } else if (!isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            mAuthTask = new UserLoginTask(email, password);
            mAuthTask.execute((Void) null);
            Intent i = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(i);
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 5;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this,
                // Retrieve data rows for the device user's 'profile' contact.
                Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI,
                        ContactsContract.Contacts.Data.CONTENT_DIRECTORY), RegisterActivity.ProfileQuery.PROJECTION,

                // Select only email addresses.
                ContactsContract.Contacts.Data.MIMETYPE +
                        " = ?", new String[]{ContactsContract.CommonDataKinds.Email
                .CONTENT_ITEM_TYPE},

                // Show primary email addresses first. Note that there won't be
                // a primary email address if the user hasn't specified one.
                ContactsContract.Contacts.Data.IS_PRIMARY + " DESC");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        List<String> emails = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            emails.add(cursor.getString(RegisterActivity.ProfileQuery.ADDRESS));
            cursor.moveToNext();
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {

    }

    private interface ProfileQuery {
        String[] PROJECTION = {
                ContactsContract.CommonDataKinds.Email.ADDRESS,
                ContactsContract.CommonDataKinds.Email.IS_PRIMARY,
        };

        int ADDRESS = 0;
        int IS_PRIMARY = 1;
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

            for (String credential : DUMMY_CREDENTIALS) {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(mEmail)) {
                    // Account exists, return true if the password matches.
                    return pieces[1].equals(mPassword);
                }
            }

            // TODO: register the new account here.
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
            showProgress(false);

            if (success) {
                finish();
            } else {
                mPasswordView.setError(getString(R.string.error_incorrect_password));
                mPasswordView.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }
}

