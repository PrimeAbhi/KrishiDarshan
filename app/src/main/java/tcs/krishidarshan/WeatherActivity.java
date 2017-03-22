package tcs.krishidarshan;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ibm.mobilefirstplatform.clientsdk.android.core.api.BMSClient;

import java.io.IOException;
import java.util.List;


/**
 * Created by Abhishek on 19-03-2017.
 */

public class WeatherActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapLongClickListener,
        GoogleMap.OnMapClickListener, GoogleMap.OnMarkerClickListener, GoogleMap.OnInfoWindowClickListener {

    LatLng currentLocation = null;
    private GoogleMap mMap;
    private String username;
    private String password;
    private Marker currentMarker = null;
    private FloatingActionButton fab;
    EditText et_change_location;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    boolean alert_status=true;
    boolean status=true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // Core SDK must be initialized to interact with Bluemix Mobile services.
        BMSClient.getInstance().initialize(getApplicationContext(), BMSClient.REGION_US_SOUTH);

        this.setTitle("Weather");

        fab= (FloatingActionButton) findViewById(R.id.fab);
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor= prefs.edit();

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMapLongClickListener(this);
        mMap.setOnMapClickListener(this);
        mMap.setOnMarkerClickListener(this);
        mMap.setOnInfoWindowClickListener(this);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(true);

        LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;


        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) {
        }

        try {
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception ex) {
        }


        if (!gps_enabled || !network_enabled) {
            // Set current location to Austin TX by default if location services are disabled.
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(getString(R.string.alert_gps_internet_enable));
            builder.setCancelable(false);

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });

            AlertDialog alert = builder.create();
            alert.show();


        } else {

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                currentLocation = new LatLng(28, 77);
            } else {
                GoogleApiClient mGoogleApiClient = new GoogleApiClient.Builder(this)
                        .addApi(LocationServices.API)
                        .build();

                Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
                if (location != null) {
                    currentLocation = new LatLng(location.getLatitude(), location.getLongitude());
                } else {
                    currentLocation = new LatLng(28, 77);
                }
            }

            String defaultLocation = prefs.getString("pref_location_key",getString(R.string.pref_default_location_value));
            setCurrentLocation(this, defaultLocation);

        }

        fab.setOnClickListener(new View.OnClickListener() {

            WeatherActivity s =new WeatherActivity();
            @Override
            public void onClick(View v) {
                et_change_location=(EditText)findViewById(R.id.et_location);
                if(status==true) {
                    et_change_location.setVisibility(View.VISIBLE);
                    status=false;
                }
                else {
                    if(et_change_location.getText().toString().isEmpty()) {
                        Toast.makeText(getApplicationContext(),"khaali",Toast.LENGTH_LONG).show();
                        et_change_location.setVisibility(View.INVISIBLE);
                        status=true;
                        return;
                    }
                    editor.putString("pref_location_key", et_change_location.getText().toString()).commit();
                    //Toast.makeText(getApplicationContext(),"hey",Toast.LENGTH_LONG).show();
                    String defaultLocation = prefs.getString("pref_location_key", getString(R.string.pref_default_location_value));
                    Toast.makeText(getApplicationContext(), defaultLocation, Toast.LENGTH_LONG).show();
                    try {
                        setCurrentLocation(s, defaultLocation);
                    }catch (IllegalArgumentException illegalArgumentException){
                        Toast.makeText(getApplicationContext(),"illegal",Toast.LENGTH_LONG).show();
                        return;
                    }
                    et_change_location.setVisibility(View.INVISIBLE);
                    status = true;

                }
            }
        });


        username = getResources().getString(R.string.weather_username);
        password = getResources().getString(R.string.weather_password);


        // Ensure username and password exist before setting window adapter.
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Failed to connect to the Weather Company Data service due to invalid " +
                    "credentials. Please verify your credentials in the weather_credentials.xml file and " +
                    "rebuild the application. See the README for further assistance.");
            builder.setTitle("Uh Oh!");
            builder.setCancelable(false);

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });

            AlertDialog alert = builder.create();
            alert.show();
        }

        else if(prefs.getBoolean("alert_status",true)){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(getString(R.string.weather_first_time_alert));
            builder.setTitle(getString(R.string.welcome));
            builder.setCancelable(false);

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });

            AlertDialog alert = builder.create();
            alert.show();

            mMap.setInfoWindowAdapter(new tcs.krishidarshan.CurrentConditionsView(this, getApplicationContext(), currentLocation));
            alert_status = false;
            prefs.edit().putBoolean("alert_status", alert_status).commit();
        }
    }


    public void setCurrentLocation(WeatherActivity s,String defaultLocation) {
        try {

            currentLocation = getLocationFromAddress(defaultLocation);
            onMapLongClick(currentLocation);
            currentMarker = mMap.addMarker(new MarkerOptions().position(currentLocation));
            mMap.setInfoWindowAdapter(new tcs.krishidarshan.CurrentConditionsView(s, getApplicationContext(), currentLocation));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 12.0f), new GoogleMap.CancelableCallback() {

                @Override
                public void onFinish() {
                    currentMarker.showInfoWindow();
                }

                @Override
                public void onCancel() {

                }
            });

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onMapLongClick(LatLng latLng) {

        //Toast.makeText(this, "onMapLong", Toast.LENGTH_LONG).show();

        LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;

        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) {
        }

        try {
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception ex) {
        }

        if (!gps_enabled && !network_enabled) {
            // Set current location to Austin TX by default if location services are disabled.

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(getString(R.string.alert_gps_internet_enable));
            builder.setCancelable(false);

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });

            AlertDialog alert = builder.create();
            alert.show();

        }

        if (gps_enabled && network_enabled) {
            if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
                return;
            }
            Marker current = currentMarker;
            mMap.setInfoWindowAdapter(new tcs.krishidarshan.CurrentConditionsView(this, getApplicationContext(), latLng));
            currentMarker = mMap.addMarker(new MarkerOptions().position(latLng));
            //Toast.makeText(this, "marker set", Toast.LENGTH_LONG).show();

            if (current != null) {
                current.remove();
            }
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12.0f), new GoogleMap.CancelableCallback() {

                @Override
                public void onFinish() {
                    currentMarker.showInfoWindow();
                }

                @Override
                public void onCancel() {

                }
            });
        }
    }

    @Override
    public void onMapClick(LatLng latLng) {

        if (currentMarker != null) {
            currentMarker.remove();
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        mMap.animateCamera(CameraUpdateFactory.newLatLng(marker.getPosition()));
        marker.showInfoWindow();

        return true;
    }

    @Override
    public void onInfoWindowClick(Marker marker) {

        Intent forecastIntent = new Intent(this, tcs.krishidarshan.ForecastActivity.class);
        forecastIntent.putExtra("latitude", marker.getPosition().latitude);
        forecastIntent.putExtra("longitude", marker.getPosition().longitude);
        startActivity(forecastIntent);
    }

    public LatLng getLocationFromAddress(String strAddress) {

        Geocoder coder = new Geocoder(this);
        List<Address> address;

        try {
            address = coder.getFromLocationName(strAddress, 5);
            if (address == null) {
                return null;
            }
            Address location = address.get(0);
            location.getLatitude();
            location.getLongitude();

            LatLng latLng = new LatLng((location.getLatitude()),
                    (location.getLongitude()));

            return latLng;
        } catch (IOException ioException) {
            return null;
        } catch (IllegalArgumentException illegalArgumentException) {
            return null;
        }
    }

}