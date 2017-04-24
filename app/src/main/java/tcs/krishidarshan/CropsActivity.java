package tcs.krishidarshan;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import tcs.krishidarshan.dummy.DummyContent;

import static tcs.krishidarshan.MyApplication.context;

public class CropsActivity extends AppCompatActivity implements KhariffFragment.OnListFragmentInteractionListener, RabiFragment.OnListRabiFragmentInteractionListener, ZaidKhariffFragment.OnListZaidKhariffFragmentInteractionListener, ZaidRabiFragment.OnListZaidRabiFragmentInteractionListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crops);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position) {
                case 0:
                    return new KhariffFragment();
                case 1:
                    return new RabiFragment();
                case 2:
                    return new ZaidKhariffFragment();
                case 3:
                    return new ZaidRabiFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return context.getString(R.string.khariff);
                case 1:
                    return context.getString(R.string.rabi);
                case 2:
                    return context.getString(R.string.zaid_khariff);
                case 3:
                    return context.getString(R.string.zaid_rabi);
            }
            return null;
        }
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item, int position) {
        //Title Strings
        String[] str = {context.getString(R.string.jowar), context.getString(R.string.bajra), context.getString(R.string.rice),
                context.getString(R.string.maize), context.getString(R.string.groundnut), context.getString(R.string.cotton), context.getString(R.string.jute)};

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("title", str[position]);
        switch (position) {
            case 0:
                intent.putExtra("url", "file:///android_res/raw/jowar.html");
                break;
            case 1:
                intent.putExtra("url", "file:///android_res/raw/bajra.html");
                break;
            case 2:
                intent.putExtra("url", "file:///android_res/raw/basmatirice.html");
                break;
            case 3:
                intent.putExtra("url", "file:///android_res/raw/maize.html");
                break;
            case 4:
                intent.putExtra("url", "file:///android_res/raw/groundnut.html");
                break;
            case 5:
                intent.putExtra("url", "file:///android_res/raw/cotton.html");
                break;
            case 6:
                intent.putExtra("url", "file:///android_res/raw/jute.html");
                break;
        }
        startActivity(intent);
    }

    @Override
    public void onListRabiFragmentInteraction(DummyContent.DummyItem item, int position) {
        String[] str = {context.getString(R.string.wheat), context.getString(R.string.barley), context.getString(R.string.gram),
                context.getString(R.string.mustard), context.getString(R.string.peas), context.getString(R.string.patato)};

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("title", str[position]);
        switch (position) {
            case 0:
                intent.putExtra("url", "file:///android_res/raw/wheat.html");
                break;
            case 1:
                intent.putExtra("url", "file:///android_res/raw/barley.html");
                break;
            case 2:
                intent.putExtra("url", "file:///android_res/raw/gram.html");
                break;
            case 3:
                intent.putExtra("url", "file:///android_res/raw/mustard.html");

            case 4:
                intent.putExtra("url", "file:///android_res/raw/peas.html");
                break;
            case 5:
                intent.putExtra("url", "file:///android_res/raw/potato.html");
                break;
        }
        startActivity(intent);
    }

    @Override
    public void onListZaidKhariffFragmentInteraction(DummyContent.DummyItem item, int position) {
        String[] str = {context.getString(R.string.asparagus), context.getString(R.string.muskmelon),
                context.getString(R.string.onion), context.getString(R.string.sunflower)};

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("title", str[position]);
        switch (position) {
            case 0:
                intent.putExtra("url", "file:////android_res/raw/asparagus.html");
                break;
            case 1:
                intent.putExtra("url", "file:////android_res/raw/muskmelon.html");
                break;
            case 2:
                intent.putExtra("url", "file:////android_res/raw/onion.html");
                break;
            case 3:
                intent.putExtra("url", "file:////android_res/raw/sunflower.html");
                break;
        }
        startActivity(intent);
    }

    @Override
    public void onListZaidRabiFragmentInteraction(DummyContent.DummyItem item, int position) {
        String[] str = {context.getString(R.string.tamato), context.getString(R.string.watermelon),
                context.getString(R.string.cucumber), context.getString(R.string.sugarcane)};

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("title", str[position]);
        switch (position) {
            case 0:
                intent.putExtra("url", "file:////android_res/raw/tomato.html");
                break;
            case 1:
                intent.putExtra("url", "file:////android_res/raw/watermelon1.html");
                break;
            case 2:
                intent.putExtra("url", "file:////android_res/raw/cucumber.html");
                break;
            case 3:
                intent.putExtra("url", "file:////android_res/raw/sugarcane.html");
                break;
        }
        startActivity(intent);
    }
}