package net.december1900.douby.net;

/**
 * Created by december on 2017/8/20.
 */

public class NetFactory {

    public static RetrofitService sRetrofitService = null;

    public static RetrofitService getRetrofitService() {
        RetrofitService retrofitService = sRetrofitService;
        if (retrofitService == null) {
            synchronized (NetFactory.class) {
                retrofitService = sRetrofitService;
                if (retrofitService == null) {
                    sRetrofitService = new RetrofitClient().getRetrofitService();
                    retrofitService = sRetrofitService;
                }
            }
        }
        return retrofitService;
    }

}