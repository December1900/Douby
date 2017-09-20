package net.december1900.douby.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import net.december1900.douby.App;

/**
 * Created by december on 2017/9/18.
 */

public class NetUtil {

    private static NetworkInfo getNetworkInfo() {
        ConnectivityManager cm = (ConnectivityManager) App.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo();
    }

    public static boolean isConnected() {
        NetworkInfo netInfo = getNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public static boolean isWifi() {
        NetworkInfo netInfo = getNetworkInfo();
        return netInfo != null && netInfo.getType() == ConnectivityManager.TYPE_WIFI;
    }

}
