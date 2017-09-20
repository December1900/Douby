package net.december1900.douby;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by december on 2017/9/5.
 */

public class App extends Application{

    public static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        Fresco.initialize(this);
    }

    public static Context getContext() {
        return sContext;
    }
}
