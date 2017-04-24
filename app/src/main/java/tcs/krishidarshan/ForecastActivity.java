package tcs.krishidarshan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ibm.mobilefirstplatform.clientsdk.android.core.api.Request;
import com.ibm.mobilefirstplatform.clientsdk.android.core.api.Response;
import com.ibm.mobilefirstplatform.clientsdk.android.core.api.ResponseListener;

import org.json.JSONObject;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import tcs.krishidarshan.model.DailyForecast;

import static tcs.krishidarshan.MyApplication.context;

/**
 * Displays ten day forecast for current location.
 */
public class ForecastActivity extends AppCompatActivity {

    private String basePath;
    private ListView mListView;
    private Gson gson;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        this.setTitle(context.getString(R.string.forecast));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls();
        gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        gson = gsonBuilder.create();

        mListView = (ListView) findViewById(R.id.ten_day_forecast);
        double latitude = this.getIntent().getExtras().getDouble("latitude");
        double longitude = this.getIntent().getExtras().getDouble("longitude");
        basePath = "https://" + getResources().getString(R.string.weather_host) + "/api/weather";
        username = getResources().getString(R.string.weather_username);
        password = getResources().getString(R.string.weather_password);
        setTenDayForecast(new LatLng(latitude, longitude));
    }

    /**
     * Send REST request to Weather service to display ten day forecast.
     *
     * @param coordinate latitude and longitude of selected location.
     */
    private void setTenDayForecast(LatLng coordinate) {
        String path = "/v1/geocode/{latitude}/{longitude}/forecast/daily/10day.json"
                .replaceAll("\\{latitude\\}", ((Double) coordinate.latitude).toString())
                .replaceAll("\\{longitude\\}", ((Double) coordinate.longitude).toString());

        String basicAuthString = username + ":" + password;
        byte[] encodedString = Base64.encode(basicAuthString.getBytes(), Base64.NO_WRAP);
        String credentials = "Basic " + new String(encodedString);
        Map<String, List<String>> headers = Collections.singletonMap("Authorization", Collections.singletonList(credentials));
        Map<String, String> queryParameters = Collections.singletonMap("language", "en-US");

        Request request = new Request(this.basePath + path, Request.GET);
        request.setQueryParameters(queryParameters);
        request.setHeaders(headers);
        request.send(this, new ResponseListener() {

            @Override
            public void onSuccess(Response response) {
                DailyForecast dailyForecast = gson.fromJson(response.getResponseText(), DailyForecast.class);
                final ForecastAdapter forecastAdapter = new ForecastAdapter(getApplicationContext(), dailyForecast);
                mListView.post(new Runnable() {
                    @Override
                    public void run() {
                        mListView.setAdapter(forecastAdapter);
                    }
                });
            }

            @Override
            public void onFailure(Response response, Throwable t, JSONObject extendedInfo) {
                if (response.getStatus() == 401) {
                } else if (response.getStatus() == 400) {
                    return;
                }
            }
        });
    }
}