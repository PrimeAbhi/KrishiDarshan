package tcs.krishidarshan.dummy;

/**
 * Created by Abhishek on 19-03-2017.
 */

import java.util.ArrayList;
import java.util.List;

import tcs.krishidarshan.R;

import static tcs.krishidarshan.MyApplication.context;

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
    private static String[] item_names = {context.getResources().getString(R.string.crops), context.getResources().getString(R.string.weather),
            context.getResources().getString(R.string.market), context.getResources().getString(R.string.schemes)};
    private static int[] item_list = {R.drawable.crops, R.drawable.weather_bg, R.drawable.marketlogo, R.drawable.schemelogo};

    //Khariff Items
    public static final List<DummyItem> KHARIFF_ITEMS = new ArrayList<>();
    private static String[] khariff_item_names = {context.getResources().getString(R.string.jowar), context.getResources().getString(R.string.bajra), context.getResources().getString(R.string.rice),
            context.getResources().getString(R.string.maize), context.getResources().getString(R.string.groundnut), context.getResources().getString(R.string.cotton),
            context.getResources().getString(R.string.jute)};
    private static int[] khariff_item_list = {R.drawable.jowar, R.drawable.bajra, R.drawable.basmati, R.drawable.maize, R.drawable.groundnut, R.drawable.cotton, R.drawable.jute};
    private static String[] khariff_item_content = {
            context.getResources().getString(R.string.con_1),
            context.getResources().getString(R.string.con_2),
            context.getResources().getString(R.string.con_3),
            context.getResources().getString(R.string.con_4),
            context.getResources().getString(R.string.con_5),
            context.getResources().getString(R.string.con_6),
            context.getResources().getString(R.string.con_7)
    };
    //Rabi Items
    public static final List<DummyItem> RABI_ITEMS = new ArrayList<>();
    private static String[] rabi_names = {context.getResources().getString(R.string.wheat), context.getResources().getString(R.string.barley), context.getResources().getString(R.string.gram),
            context.getResources().getString(R.string.mustard), context.getResources().getString(R.string.peas), context.getResources().getString(R.string.patato)};
    private static int[] rabi_list = {R.drawable.wheat, R.drawable.barley, R.drawable.gram, R.drawable.mustard, R.drawable.peas, R.drawable.potato};
    private static String[] rabi_content = {
            context.getResources().getString(R.string.con_8),
            context.getResources().getString(R.string.con_9),
            context.getResources().getString(R.string.con_10),
            context.getResources().getString(R.string.con_11),
            context.getResources().getString(R.string.con_12),
            context.getResources().getString(R.string.con_13)
    };

    //Zaid Khariff Items
    public static final List<DummyItem> ZAID_KHARIFF_ITEMS = new ArrayList<>();
    private static String[] zaid_khariff_names = {context.getResources().getString(R.string.asparagus), context.getResources().getString(R.string.muskmelon),
            context.getResources().getString(R.string.onion), context.getResources().getString(R.string.sunflower)};
    private static int[] zaid_khariff_list = {R.drawable.logoasparagus, R.drawable.muskmelon, R.drawable.logoonions, R.drawable.sunflower};
    private static String[] zaid_khariff_content = {
            context.getResources().getString(R.string.con_14),
            context.getResources().getString(R.string.con_15),
            context.getResources().getString(R.string.con_16),
            context.getResources().getString(R.string.con_17)
    };

    //Zaid Rabi Items
    public static final List<DummyItem> ZAID_RABI_ITEMS = new ArrayList<>();
    private static String[] zaid_rabi_names = {context.getResources().getString(R.string.tamato), context.getResources().getString(R.string.watermelon),
            context.getResources().getString(R.string.cucumber), context.getResources().getString(R.string.sugarcane)};
    private static int[] zaid_rabi_list = {R.drawable.logotomato, R.drawable.watermelonimage, R.drawable.cucumberimage, R.drawable.sugarcaneimage};
    private static String[] zaid_rabi_content = {
            context.getResources().getString(R.string.con_18),
            context.getResources().getString(R.string.con_19),
            context.getResources().getString(R.string.con_20),
            context.getResources().getString(R.string.con_21)
    };

    //Schemes
    public static final List<DummyItem> SCHEMES = new ArrayList<>();
    private static String[] schemes_names = {context.getResources().getString(R.string.pmfby), context.getResources().getString(R.string.rkvy),
            context.getResources().getString(R.string.pay), context.getResources().getString(R.string.pmjdy),
    };
    private static int[] schemes_list = {R.drawable.bg, R.drawable.bg, R.drawable.bg, R.drawable.bg};
    private static String[] schemes_content = {
            context.getResources().getString(R.string.pmfby_detail),
            context.getResources().getString(R.string.rkvy_detail),
            context.getResources().getString(R.string.pay_detail),
            context.getResources().getString(R.string.pmjdy_detail)
    };

    private static final int COUNT = 4;
    private static final int COUNT_KHARIFF = 7;
    private static final int COUNT_RABI = 6;
    private static final int COUNT_ZAIDK = 4;
    private static final int COUNT_ZAIDR = 4;
    private static final int COUNT_SCHEME = 4;

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