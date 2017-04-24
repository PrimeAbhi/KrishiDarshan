package tcs.krishidarshan.dummy;

/**
 * Created by Abhishek on 19-03-2017.
 */

import java.util.ArrayList;
import java.util.List;

import tcs.krishidarshan.R;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {
    /**
     * An array of sample (dummy) items.
     */
    //Main Activity Items
    public static final List<DummyItem> ITEMS = new ArrayList<>();
    private static String[] item_names = {"Crops", "Weather", "Market", "Schemes"};
    private static int[] item_list = {R.drawable.crops, R.drawable.weather_bg, R.drawable.marketlogo, R.drawable.schemelogo};

    //Khariff Items

    public static final List<DummyItem> KHARIFF_ITEMS = new ArrayList<>();
    private static String[] khariff_item_names = {"Jowar", "Bajra", "Rice", "Maize", "Groundnut", "Cotton","Jute"};
    private static int[] khariff_item_list = {R.drawable.jowar, R.drawable.bajra, R.drawable.basmati, R.drawable.maize,R.drawable.groundnut,R.drawable.cotton,R.drawable.jute};
    private static String[] khariff_item_content = {
                   "Time Required:65-75  Days  \n"+"Temperature   :77-89  °F",
                   "Time Required:75-90  Days  \n"+"Temperature   :68-86  °F",
                   "Time Required:35-40  Days  \n"+"Temperature   :68-95  °F",
                   "Time Required:00-00  Days  \n"+"Temperature   :72-86  °F",
                   "Time Required:30-50  Days  \n"+"Temperature   :80-86  °F",
                   "Time Required:130-160 Days  \n"+"Temperature   :75-77      °F",
                   "Time Required:122-150 Days  \n"+"Temperature   :77-86      °F"};

    //Rabi Items
    public static final List<DummyItem> RABI_ITEMS = new ArrayList<>();
    private static String[] rabi_names = {"Wheat", "Barley", "Gram", "Mustard","Peas","Potato"};
    private static int[] rabi_list = {R.drawable.wheat, R.drawable.barley, R.drawable.gram, R.drawable.mustard,R.drawable.peas,R.drawable.potato};
    private static String[] rabi_content = {
            "Time Required:40-45  Days  \n"+"Temperature   :57-64  °F",
            "Time Required:75-90  Days  \n"+"Temperature   :54-61  °F",
            "Time Required:30-40  Days  \n"+"Temperature   :77-95  °F",
            "Time Required:20-30  Days  \n"+"Temperature   :72-86  °F",
            "Time Required:30-50  Days  \n"+"Temperature   :80-86  °F",
            "Time Required:130-160 Days  \n"+"Temperature   :75-77      °F"
    };

    //Zaid Khariff Items
    public static final List<DummyItem> ZAID_KHARIFF_ITEMS = new ArrayList<>();
    private static String[] zaid_khariff_names = {"Asparagus", "Muskmelon", "Onion","Sunflower"};
    private static int[] zaid_khariff_list = {R.drawable.logoasparagus, R.drawable.muskmelon, R.drawable.logoonions, R.drawable.sunflower};
    private static String[] zaid_khariff_content = {
            "Time Required:65-75  Days  \n"+"Temperature   :77-89  °F",
            "Time Required:75-90  Days  \n"+"Temperature   :68-86  °F",
            "Time Required:35-40  Days  \n"+"Temperature   :68-95  °F",
            "Time Required:30-50  Days  \n"+"Temperature   :80-86  °F"
    };


    //Zaid Rabi Items
    public static final List<DummyItem> ZAID_RABI_ITEMS = new ArrayList<>();
    private static String[] zaid_rabi_names = {"Tomato", "Watermelon", "Cucumber", "Sugarcane"};
    private static int[] zaid_rabi_list = {R.drawable.logotomato, R.drawable.watermelonimage, R.drawable.cucumberimage, R.drawable.sugarcaneimage};
    private static String[] zaid_rabi_content = {
            "Time Required:65-75  Days  \n"+"Temperature   :77-89  °F",
            "Time Required:75-90  Days  \n"+"Temperature   :68-86  °F",
            "Time Required:35-40  Days  \n"+"Temperature   :68-95  °F",
            "Time Required:30-50  Days  \n"+"Temperature   :80-86  °F"

    };



    //Schemes
    public static final List<DummyItem> SCHEMES = new ArrayList<>();
    private static String[] schemes_names = {"PradhanMantri Fasal Bima Yojna", "Rashtriya Krishi Vikas Yojana", "PradhanMantri Awas Yojana", "Pradhan Mantri Jan Dhan Yojana"};
    private static int[] schemes_list = {R.drawable.bg, R.drawable.bg, R.drawable.bg, R.drawable.bg};
    private static String[] schemes_content = {
            "The PMFBY will replace the existing two schemes National Agricultural Insurance Scheme as well as the Modified NAIS.",
            "Achieve 4% annual growth in agriculture through development of Agriculture and its allied sectors during the XI Plan period",
            "Provides financial assistance to rural poor for constructing their houses themselves.",
            "National Mission for Financial Inclusion to ensure access to financial services, namely Banking Savings & Deposit Accounts, Remittance, Credit, Insurance, Pension in an affordable manner"
    };

    private static final int COUNT = 4;
    private static final int COUNT_KHARIFF = 7;
    private static final int COUNT_RABI = 6;
    private static final int COUNT_ZAIDK = 4;
    private static final int COUNT_ZAIDR = 4;
    private static final int COUNT_SCHEME=4;

    static {
        // Add some sample items.
        for (int i = 0; i < COUNT; i++) {
            addItem(createDummyItem(i));

        }
        for (int i = 0; i < COUNT_KHARIFF; i++) {
            addItemForKhariff(createDummyItemForKhariff(i));
        }
        for (int i = 0; i < COUNT_RABI; i++) {
            addItemForRabi(createDummyItemForRabi(i));
        }
        for (int i = 0; i < COUNT_ZAIDK; i++) {
            addItemForZaidKhariff(createDummyItemForZaidKhariff(i));

        }

        for (int i = 0; i < COUNT_SCHEME; i++) {
            addItemForSchemes(createDummyItemForSchemes(i));

        }

        for (int i = 0; i < COUNT_ZAIDR; i++) {
            addItemForZaidRabi(createDummyItemForZaidRabi(i));

        }

    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
    }

    private static void addItemForKhariff(DummyItem khariffItem) {
        KHARIFF_ITEMS.add(khariffItem);
    }

    private static void addItemForRabi(DummyItem rabiItem) {
        RABI_ITEMS.add(rabiItem);
    }

    private static void addItemForZaidRabi(DummyItem zaidrabiItem) {
        ZAID_RABI_ITEMS.add(zaidrabiItem);
    }

    private static void addItemForZaidKhariff(DummyItem zaidrabiItem) {
        ZAID_KHARIFF_ITEMS.add(zaidrabiItem);
    }

    private static void addItemForSchemes(DummyItem schemes) {
        SCHEMES.add(schemes);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(item_list[position], item_names[position], null);
    }

    private static DummyItem createDummyItemForKhariff(int position) {
        return new DummyItem(khariff_item_list[position], khariff_item_names[position], khariff_item_content[position]);
    }

    private static DummyItem createDummyItemForRabi(int position) {
        return new DummyItem(rabi_list[position], rabi_names[position], rabi_content[position]);
    }

    private static DummyItem createDummyItemForZaidRabi(int position) {
        return new DummyItem(zaid_rabi_list[position], zaid_rabi_names[position], zaid_rabi_content[position]);
    }

    private static DummyItem createDummyItemForZaidKhariff(int position) {
        return new DummyItem(zaid_khariff_list[position], zaid_khariff_names[position], zaid_khariff_content[position]);
    }

    private static DummyItem createDummyItemForSchemes(int position) {
        return new DummyItem(schemes_list[position], schemes_names[position], schemes_content[position]);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final int id;
        public final String content;
        public final String content_detail;

        public DummyItem(int id, String content, String content_detail) {
            this.id = id;
            this.content = content;
            this.content_detail = content_detail;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}