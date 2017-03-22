package tcs.krishidarshan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.view.MenuItem;

/**
 * Created by Abhishek on 22-03-2017.
 */

public class DetailActivity extends AppCompatActivity {
    String title, url;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webView = (WebView) findViewById(R.id.webview);
        Bundle data = getIntent().getExtras();
        if (data != null) {
            title = data.getString("title");
            url = data.getString("url");
            setTitle(title);
            WebSettings webSettings = this.webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webSettings.setBuiltInZoomControls(true);
            webSettings.setSupportZoom(true);
            webView.loadDataWithBaseURL(null, url, "text/html", "UTF-8", null);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
