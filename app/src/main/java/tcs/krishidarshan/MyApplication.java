package tcs.krishidarshan;

import android.app.Application;
import android.content.Context;

/**
 * Created by Abhishek on 24-04-2017.
 */

public class MyApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
