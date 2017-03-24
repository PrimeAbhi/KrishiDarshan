package tcs.krishidarshan;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by rishabh on 25-Mar-17.
 */

public class Market extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market);
        WebView wv=(WebView)findViewById(R.id.mandi);
        wv.loadUrl("http://www.ncdex.com/MarketDataAction_liveSpotPrice.action");

    }
}
