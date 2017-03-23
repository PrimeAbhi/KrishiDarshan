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
    public static final List<DummyItem> ITEMS = new ArrayList<>();
    private static String[] item_names = {"Crops", "Weather", "Market Price", "Schemes"};
    private static int[] item_list = {R.drawable.bg, R.drawable.weather_bg, R.drawable.bg, R.drawable.bg};

    public static final List<DummyItem> KHARIFF_ITEMS = new ArrayList<>();
    private static String[] khariff_item_names = {"Crops", "Weather", "Market Price", "ABC"};
    private static int[] khariff_item_list = {R.drawable.bg, R.drawable.bg, R.drawable.bg, R.drawable.bg};
    private static String[] khariff_item_content = {"Hello", "Abhishek", "How", "Are"};

    public static final List<DummyItem> RABI_ITEMS = new ArrayList<>();
    private static String[] rabi_names = {"Crops", "Weather", "Market Price", "ABC"};
    private static int[] rabi_list = {R.drawable.bg, R.drawable.bg, R.drawable.bg, R.drawable.bg};
    private static String[] rabi_content = {"Hello", "Rishabh", "How", "Are"};


    private static final int COUNT = 4;

    static {
        // Add some sample items.
        for (int i = 0; i < COUNT; i++) {
            addItem(createDummyItem(i));
            addItemForKhariff(createDummyItemForKhariff(i));
            addItemForRabi(createDummyItemForRabi(i));
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


    private static DummyItem createDummyItem(int position) {
        return new DummyItem(item_list[position], item_names[position], null);
    }

    private static DummyItem createDummyItemForKhariff(int position) {
        return new DummyItem(khariff_item_list[position], khariff_item_names[position], khariff_item_content[position]);
    }

    private static DummyItem createDummyItemForRabi(int position) {
        return new DummyItem(rabi_list[position], rabi_names[position], rabi_content[position]);
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