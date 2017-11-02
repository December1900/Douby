package net.december1900.douby.net;

/**
 * Created by december on 2017/8/20.
 */

public class NetFactory {

    private static class RetrofitHelper {
        private final static RetrofitService service = new RetrofitClient().getRetrofitService();
    }

    public static RetrofitService getRetrofitService() {
        return RetrofitHelper.service;
    }

}