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
        String[] str = {"Jowar", "Bajra", "Rice", "Maize",
                "Vaishno Devi Temple", "Daksha Temple", "Shantikunj", "Gau Ghat",
                "Kushavarta Ghat", "Vishnu Ghat", "Asthi Pravah Ghat", "Subhash Ghat", "GKV", "FET,GKV"};

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("title", str[position]);
        switch (position) {
            case 0:
                intent.putExtra("url", "<html><body>\n" + "<h2><span style=\"color: #008000;\">Black Gram Cultivation (Urad Dal) Information:</span></h2><figure id=\"attachment_1337\" style=\"width: 600px\" class=\"wp-caption \n" + "alignnone\"><a href=\"http://agrifarming.in/wp-content/uploads/2015/04/Black-Gram-Cultivation1.jpg\" target=\"_blank\"><img class=\"size-full wp-image-1337 tie-appear\" \n" + "src=\"http://agrifarming.in/wp-content/uploads/2015/04/Black-Gram-Cultivation1.jpg\" alt=\"Black Gram Cultivation\" width=\"300\" height=\"300\" \n" + "srcset=\"http://www.agrifarming.in/wp-content/uploads/2015/04/Black-Gram-Cultivation1.jpg 600w, http://www.agrifarming.in/wp-content/uploads/2015/04/Black-Gram-\n" +
                        "Cultivation1-300x225.jpg 300w\" sizes=\"(max-width: 600px) 100vw, 600px\"></a><figcaption class=\"wp-caption-text\">Black Gram Cultivation.</figcaption></figure>\n" +
                        "<p \n" +
                        "style=\"user-select: text;\"><span style=\"color: #0000ff;\"><strong>Introduction:-&nbsp;</strong></span>Black gram (Vigna Mungo L.) is popularly known as “Urad”, is one \n" +
                        "of the most&nbsp;important pulses crop, grown across India. The Urad crop is resistant to adverse climatic&nbsp;conditions and improve the soil fertility by fixing \n" +
                        "atmospheric nitrogen in the soil.</p>\n" +
                        "<p>This crop is grown&nbsp;primarily for its protein rich seeds and used as daal and as main ingredient in breakfast \n" +
                        "snacks&nbsp;like dosa,idli, vada &amp; papad.</p>\n" +
                        "<p style=\"user-select: text;\"><strong><span style=\"color: #0000ff;\">Local Names for&nbsp;Black&nbsp;Gram (Urad Dal) in \n" +
                        "India:-</span></strong>&nbsp;Urad Dal (Hindi), Minumulu (Telugu),Ulundu Paruppu (Tamil), Uzhunnu Parippu (Malayalam), Uddina bele (Kannada),&nbsp;Masakalai dala \n" +
                        "(Bengali), Biri dali (Oriya), Kaali Dal(Marathi), Adad Dal (Gujarati).</p>\n" +
                        "<p><span style=\"color: #0000ff;\"><strong>Commercial Varities of Black Gram in India:-\n" +
                        "&nbsp;</strong> </span>LBG-20,T-9, Uttara, LBG-623, KU-91-2, Vamban-2,&nbsp;Azad Urid-2, KU-3-1, WBG-26, WBU-108 , TU-94-2,ADT-5, Azad-1, Azad-3, M-391,DU-1, IPU 2-\n" +
                        "43,&nbsp;Mash-114, Mash-479, WBU-109,PU-31, PU-40, Sekhar-1, Sekhar-2, Sekhar-3, LBG-7658, LBG-752.</p>\n" +
                        "<p><span style=\"color: #0000ff;\"><strong>Crop Calender in Black \n" +
                        "Gram Cultivation:-</strong></span></p>\n" +
                        "<figure id=\"attachment_1339\" style=\"width: 611px\" class=\"wp-caption alignnone\"><a href=\"./Black Gram Cultivation (Urad Dal) Guide \n" +
                        "_ Agrifarming.in_files/Crop-Calnder-for-Urad-Dal-Black-Gram.gif\" target=\"_blank\"><img class=\"size-full wp-image-1339 tie-appear\" src=\"http://agrifarming.in/wp-content/uploads/2015/04/Crop-Calnder-for-Urad-Dal-Black-Gram.gif\" alt=\"Crop Calnder for Urad Dal-Black Gram\" width=\"611\" height=\"222\"></a><figcaption \n" +
                        "class=\"wp-caption-text\">Crop Calendar for Urad Dal-Black Gram.</figcaption></figure>\n" +
                        "<p style=\"user-select: text;\"><span style=\"color: #0000ff;\"><strong>Agro-Climate \n" +
                        "required in Black Gram Cultivation:-</strong> </span>This crop prefers dry whether condition with ideal &nbsp;temperature range between 25 C to 35 C. Maturity crop \n" +
                        "period should coincide with the dry &nbsp;whether condition for high yield and good quality seeds, this is one of the main criteria to decide&nbsp;time of \n" +
                        "planting.</p>\n" +
                        "<p style=\"user-select: text;\"><span style=\"color: #0000ff;\"><strong>Soil requirement in Black Gram Cultivation:-</strong> </span>Soil in Black Gram \n" +
                        "cultivation should have neutral pH.&nbsp;Loam or clay loam soils are best suited soils for it’s cultivation. Adding higher organic matter in&nbsp;soil will result in \n" +
                        "vigorous seed production.</p><div class=\"code-block code-block-9\" style=\"margin: 8px 0;\"></div>\n" +
                        "\n" +
                        "<p style=\"user-select: text;\"><strong><span style=\"color: #0000ff;\">Selection of land and it’s Preparation in&nbsp;Black&nbsp;Gram Cultivation:-\n" +
                        "</span></strong><span style=\"color: #0000ff;\">&nbsp;</span>The field selected for seed&nbsp;production must not have been sown with black gram in the previous years. \n" +
                        "This is done to avoid&nbsp;volunteer plants that cause admixture. Fields continuously cultivated with black gram may harbour&nbsp;root rot or wilt pathogen.</p>\n" +
                        "<p><span style=\"color: #0000ff;\"><strong>Seed selection in Black Gram Cultivation:-</strong></span> Seeds used in sowing must be from an authorised&nbsp;source. Seeds \n" +
                        "must be genetically pure and having fine quality. Seeds used for sowing in Black&nbsp;Gram cultivation must also be vigorous so that we can obtain a good field stand. \n" +
                        "Seeds must be&nbsp;thoroughly checked for diseased seeds,hard seeds,shrunken,deformed seeds,and immature seeds.</p>\n" +
                        "<p><span style=\"color: #0000ff;\"><strong>Seed rate \n" +
                        "and Treatment in Black Gram Cultivation:-</strong></span> Seed rate depends on the variety the seed&nbsp;selected. Usually an average of 8 to 10 kg per acre is \n" +
                        "sufficient.</p>\n" +
                        "<p style=\"user-select: text;\">Black gram seeds should be treated&nbsp;with seed treating fungicide to reduce infection by fungal pathogens from the \n" +
                        "soil. Black gram&nbsp;seeds are treated with Bavistin 2 grams for every kg of seeds. Organic fungicide like Trichoderma&nbsp;viridi is also available for pulses @ 4 \n" +
                        "grams/kg.</p>\n" +
                        "<p><span style=\"color: #0000ff;\"><strong>Sowing and Spacing in Black Gram Seed Cultivation:-&nbsp;</strong></span>The Black Gram seeds are sown @ 2 cm \n" +
                        "depth &nbsp;with a spacing of 10 cm and 30 cm between rows in main field.&nbsp;Irrigation management in Black Gram Cultivation:-&nbsp;Irrigation/Water management in \n" +
                        "Black Gram Cultivation:- Black gram crop is very sensitive to&nbsp;irrigation. Fields must be constantly monitored for any drought conditions. If this crop is not \n" +
                        "irrigated &nbsp;properly, pulse crop shed flowers. Plants without water produce seeds that are small and hard with &nbsp;low vigor. Because of this problem Black \n" +
                        "Gram&nbsp;crop must have sufficient water supply.</p>\n" +
                        "<p>Field should be irrigated immediately after sowing followed by lite irrigation on 3rd day. \n" +
                        "Then,&nbsp;irrigation should be carried out based on the need (Usually when field becomes dry). Water supply&nbsp;during flowering of the crop, pod formation &amp; \n" +
                        "seed development must be provided for quality<br>\n" +
                        "output.</p>\n" +
                        "<p><span style=\"color: #0000ff;\"><strong>Fertilizers in Black Gram cultivation:-</strong> </span>Basal \n" +
                        "fertilizers application alone may not be sufficient for&nbsp;the seed crop. It is mandatory to provide nutrition during the heavy growth of crop and \n" +
                        "seed&nbsp;formation period. The nutrient needed by the rapidly developing pulse seeds are provided&nbsp;through&nbsp;foliar feeding.</p>\n" +
                        "<p>Nutrient solution \n" +
                        "preparation is done by soaking the following chemicals in water&nbsp;(100 lit). This solution is sprayed 25 to 35 days after seed sowing followed by another spray in \n" +
                        "40&nbsp;to 50 days.&nbsp;Below table lists the items for preparing nutrient solution.</p>\n" +
                        "<table border=\"1\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
                        "<tbody>\n" +
                        "<tr>\n" +
                        "<td class=\"style12\" valign=\"top\" width=\"129\"><span style=\"color: #ff0000;\"><strong>Chemicals / Fertilizers</strong></span></td>\n" +
                        "<td class=\"style12\" valign=\"top\" \n" +
                        "width=\"108\"><span style=\"color: #ff0000;\"><strong>Quantity to be soaked in 100 Litre</strong></span></td>\n" +
                        "</tr>\n" +
                        "<tr>\n" +
                        "<td class=\"style12\" valign=\"top\" width=\"129\">\n" +
                        "<p \n" +
                        "align=\"left\">1. Urea</p>\n" +
                        "</td>\n" +
                        "<td class=\"style12\" valign=\"top\" width=\"108\">\n" +
                        "<p align=\"center\">4.0</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "<tr>\n" +
                        "<td class=\"style12\" valign=\"top\" width=\"129\">\n" +
                        "<p \n" +
                        "align=\"left\">2. D.A.P.</p>\n" +
                        "</td>\n" +
                        "<td class=\"style12\" valign=\"top\" width=\"108\">\n" +
                        "<p align=\"center\">1.0</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "<tr>\n" +
                        "<td class=\"style12\" valign=\"top\" width=\"129\">\n" +
                        "<p \n" +
                        "align=\"left\">3. Muriate of Potash</p>\n" +
                        "</td>\n" +
                        "<td class=\"style12\" valign=\"top\" width=\"108\">\n" +
                        "<p align=\"center\">0.6</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "<tr>\n" +
                        "<td class=\"style12\" valign=\"top\" \n" +
                        "width=\"129\">\n" +
                        "<p align=\"left\">4. Potassium sulphate</p>\n" +
                        "</td>\n" +
                        "<td class=\"style12\" valign=\"top\" width=\"108\">\n" +
                        "<p align=\"center\">0.02</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "<tr>\n" +
                        "<td class=\"style12\" \n" +
                        "valign=\"top\" width=\"129\">\n" +
                        "<p align=\"left\">5. Succinic acid</p>\n" +
                        "</td>\n" +
                        "<td class=\"style12\" valign=\"top\" width=\"108\">\n" +
                        "<p align=\"center\">0.02</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "<tr>\n" +
                        "<td \n" +
                        "class=\"style12\" valign=\"top\" width=\"129\">\n" +
                        "<p align=\"left\">6. Teepol</p>\n" +
                        "</td>\n" +
                        "<td class=\"style12\" valign=\"top\" width=\"108\">\n" +
                        "<p align=\"center\">0.04 ml</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</tbody>\n" +
                        "</table>\n" +
                        "<p><span style=\"color: #0000ff;\"><strong>Weed control in Black Gram cultivation:-</strong> </span>Immediately after sowing and watering, Basalin \n" +
                        "weedicide&nbsp;is sprayed by dissolving 2 ml of Basalin/liter water. The weedicide spraying must be done within 3&nbsp;days of sowing. If it is done later, it can \n" +
                        "damage the crop. Applying weedicide will control the&nbsp;early growth weeds, to control later emerging weeds in the crop, manual weeding should be done&nbsp;after 2 \n" +
                        "weeks.</p>\n" +
                        "<p><span style=\"color: #0000ff;\"><strong>Pests and Diseases in Black Gram cultivation:-</strong></span> The main pest in the Black Gram crop is stem \n" +
                        "fly.&nbsp;This pest affects the crop at the early stages by causing drying and withering plants. During the&nbsp;growth phase, major pests like leaf hopper, aphid, \n" +
                        "white fly affect the field crop. These pests<br>\n" +
                        "should be controlled by spraying either dimethoate, phosphomidan or mehyldematan, @ 2&nbsp;ml/litre.</p>\n" +
                        "<p>During the \n" +
                        "growing phases of the seed crop incidence of yellow mosaic can be observed. The affected crop&nbsp;shows yellow mottled symptoms. These plants can be rouged out as and \n" +
                        "when they are seen.&nbsp;White fly is the culprit in spreading &nbsp;this disease, removal of the affected plants is followed&nbsp;by an insecticide spray as mentioned \n" +
                        "above. Apart from this, black gram crop is also affected by&nbsp;root rot, wilt &nbsp;and these are to be removed and the affected area of the field &nbsp;should be \n" +
                        "sprayed using 0.1%&nbsp;Bavistin solution. Rarely the Black Gram crop is affected by Powdery mildew and it is noticed by the&nbsp;presence of white powder deposits on \n" +
                        "the leaves. Leaf spot of &nbsp;Cercospora &nbsp;can be noticed by the&nbsp;presence of brown spots. The Powdery mildew and cercospora can be controlled by spraying \n" +
                        "1%&nbsp;Bavistin solution.</p><div class=\"code-block code-block-10\" style=\"margin: 8px 0;\">\n" +
                        "</div>\n" +
                        "\n" +
                        "<p><span style=\"color: #0000ff;\"><strong>Harvesting of black gram crop:-</strong></span> The ripened pods can be collected from the plants in one or \n" +
                        "two&nbsp;pickings and dried on the floor. In case, If the&nbsp;&nbsp; plants come to &nbsp;harvest, then the crop &nbsp;should cut and &nbsp;the plants spread over the \n" +
                        "floor to dry. The plants becomes dry and turn into black and pods may start&nbsp;splitting. The plants should be beaten using pliable sticks to prevent damage to \n" +
                        "seeds. Then seeds&nbsp;are separated from pods. These plants after harvesting can be used as <a href=\"http://www.agrifarming.in/tag/fodder/\">fodder</a> for \n" +
                        "animals.</p>\n" +
                        "<figure id=\"attachment_1338\" style=\"width: 300px\" class=\"wp-caption alignnone\"><a href=\"http://agrifarming.in/wp-content/uploads/2015/04/Black-Gram-Seeds-\n" +
                        "Urad-Dal-seeds.jpg\" target=\"_blank\"><img class=\"size-medium wp-image-1338 tie-appear\" src=\"http://agrifarming.in/wp-content/uploads/2015/04/Black-Gram-Seeds-Urad-Dal-\n" +
                        "seeds-300x173.jpg\" alt=\"Black Gram Seeds - (Urad Dal seeds)\" width=\"300\" height=\"173\" srcset=\"http://www.agrifarming.in/wp-content/uploads/2015/04/Black-Gram-Seeds-\n" +
                        "Urad-Dal-seeds-300x173.jpg 300w, http://www.agrifarming.in/wp-content/uploads/2015/04/Black-Gram-Seeds-Urad-Dal-seeds-1024x591.jpg 1024w\" sizes=\"(max-width: 300px) \n" +
                        "100vw, 300px\"></a><figcaption class=\"wp-caption-text\">Black Gram Seeds – (<a href=\"http://www.agrifarming.in/tag/urad-dal-seeds/\">Urad Dal \n" +
                        "seeds</a>)</figcaption></figure>\n" +
                        "<p style=\"user-select: text;\"><strong><span style=\"color: #0000ff;\">Yield of&nbsp;Black&nbsp;Gram :</span></strong>– Basically Yield \n" +
                        "depends on the variety of seed selected and field management,&nbsp;with hybrid varieties it is possible to achieve yield form 800 kg -1100 kg /acre.</p></body></html>");
                break;
        }
        startActivity(intent);
    }

}
