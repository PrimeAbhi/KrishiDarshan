package tcs.krishidarshan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import tcs.krishidarshan.dummy.DummyContent;

import static tcs.krishidarshan.MyApplication.context;

public class MainActivity extends AppCompatActivity {
private static boolean welcome=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Showing Images
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.tile1), 5000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.tile2), 5000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.tile3), 5000);
        animationDrawable.setOneShot(false);
        ImageView imageView = (ImageView) findViewById(R.id.main_image);
        imageView.setBackgroundDrawable(animationDrawable);
        animationDrawable.start();
        initViews();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String n = prefs.getString("pref_name", "@string/pref_name");
        if(welcome) {
            Toast.makeText(this, context.getResources().getString(R.string.welcome), Toast.LENGTH_LONG).show();
            welcome=false;
        }
    }

    private void initViews() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new DataAdapter(DummyContent.ITEMS));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
        if (id == R.id.about_us) {
            startActivity(new Intent(this, AboutUs.class));
        }
        if (id == R.id.alert) {
            startActivity(new Intent(this, Alert.class));
        }
        return super.onOptionsItemSelected(item);
    }
}