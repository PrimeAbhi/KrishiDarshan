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
import android.view.Menu;
import android.view.MenuItem;

import tcs.krishidarshan.dummy.DummyCrops;

public class CropsActivity extends AppCompatActivity implements KhariffFragment.OnListFragmentInteractionListener {

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_crops, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
            return new KhariffFragment();
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
                    return "Khariff";
                case 1:
                    return "Rabi";
                case 2:
                    return "Zaid (Khariff)";
                case 3:
                    return "Zaid (Rabi)";
            }
            return null;
        }
    }

    @Override
    public void onListFragmentInteraction(DummyCrops.DummyItem item, int position) {
        String[] str = {"Har Ki Pauri", "Mansa Devi Temple", "Bharat Mata Mandir", "Chandi Devi Temple",
                "Vaishno Devi Temple", "Daksha Temple", "Shantikunj", "Gau Ghat",
                "Kushavarta Ghat", "Vishnu Ghat", "Asthi Pravah Ghat", "Subhash Ghat", "GKV", "FET,GKV"};

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("title", str[position]);
        switch (position) {
            case 0:
                intent.putExtra("url", "<html><body><img style=\"width:100%;\" src=\"file:///android_res/drawable/bg.jpg\"/><p style=\"color:#646464;\">Har Ki Pauri is a famous ghat on the banks of the Ganges in Haridwar in Uttarakhand state in India. This revered place is the major landmark of the holy city of Haridwar.<br/>Har Ki Pauri is also the area where thousands of pilgrims converge and the festivities commence during the Kumbha Mela, which takes place every twelve years, and the Ardh Kumbh Mela, which takes place every six years and the Punjabi festival of Vaisakhi, a harvest festival occurring every year in the month of April .</p><h3 style=\"text-align:center; color:#03A9F4;\">The Ganga Aarti</h3><img style=\"width:100%;\" src=\"file:///android_res/drawable/bg.jpg\"/><p style=\"color:#646464;\">Each evening at sunset priests perform Ganga Aarti here, when lights are set on the water to drift downstream. A large number of people gather on both the banks of river Ganges to sing its praises. The priests hold large fire bowls in their hands, the gongs in the temples at the Ghat start ringing and the chants flowing out of lips fill the air. People float earthen Diyas, with burning flickers and flowers in them as a symbol of hope and wishes .The golden hues of floral diyas reflected in the river Ganges presents spectacular view.</p><strong><p style=\"color:#646464;\">Keep Ganga Clean.<br/>Take a pledge to protect your local water bodies and environment, and to inspire your friends, family and community to do the same.</br></br></br></br></p></strong></body></html>");
                break;
        }
        startActivity(intent);
    }

}
