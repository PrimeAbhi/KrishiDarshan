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
public class DummyCrops {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<>();
    private static final int COUNT = 4;
    private static String[] item_names = {"Jowar", "Bazra", "Rice", "Maize"};
    private static int[] item_list = {R.drawable.jowar_bg, R.drawable.bg, R.drawable.bg, R.drawable.bg};
    private static String [] item_content = {
    "Jowar is one of the important food and fodder cereal crops cultivated across India, Sorghum popularly known as “Jowar” in India.",
    "Bajra is the Second most important millet which is used as food in drier parts of the country. It is also widely used as fodder as its stalks are fed to cattle.",
    "Rice is one of the chief grains of India. Moreover, this country has the largest area under rice cultivation, as it is one of the principal food crops. It is in fact the dominant crop of the country.",
    "Maize is grown throughout the year in India. It is predominantly a kharif crop with 85 per cent of the area under cultivation in the season. Maize is the third most important cereal crop in India after rice and wheat. "

    };

    static {
        // Add some sample items.
        for (int i = 0; i < COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(item_list[position], item_names[position],item_content[position]);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final int id;
        public final String content;
        public final String content_detail;

        public DummyItem(int id, String content,String content_detail) {
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