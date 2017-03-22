package tcs.krishidarshan;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by rishabh on 22-Mar-17.
 */

public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
        setContentView(R.layout.launcher);

    }

    public void clickedSignup(View v){
        startActivity(new Intent(this,MainActivity.class));

    }

}
