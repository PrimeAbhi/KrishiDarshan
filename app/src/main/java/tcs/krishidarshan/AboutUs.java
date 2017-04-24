package tcs.krishidarshan;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by rishabh on 25-Mar-17.
 */

public class AboutUs extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        WebView webView=(WebView)findViewById(R.id.about_us);
        webView.loadUrl("file:////android_res/raw/about.html");
    }
}
