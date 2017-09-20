package net.december1900.douby.net;

import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by december on 2017/9/18.
 */

public class CacheInterceptor implements Interceptor {

    private static final String TAG = "CacheInterceptor";

    @Override
    public Response intercept(Chain chain) throws IOException {
//        Request request = chain.request();
//        if (!NetUtil.isConnected()) {
//            request = request.newBuilder()
//                    .cacheControl(CacheControl.FORCE_CACHE)
//                    .build();
//            Log.d(TAG, "no network");
//        }
//
//        Response response = chain.proceed(request);
//        if (NetUtil.isConnected()) {
//            int maxAge = 2 * 60;
//            Log.d(TAG, "android has maxAge :" + maxAge);
//            response.newBuilder()
//                    .header("Cache-Control", "public ,max-age=" + maxAge)
//                    .removeHeader("Pragma")
//                    .build();
//        } else {
//            Log.d(TAG, "no network");
//            int maxStale = 60 * 60 * 24 * 28;
//            response.newBuilder()
//                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
//                    .removeHeader("Pragma)
//                    .build();
//            Log.d(TAG, "android has maxStale :" + maxStale);
//
//        }

        Request request = chain.request();
        Log.i(TAG, "request=" + request);
        Response response = chain.proceed(request);
        Log.i(TAG, "response=" + response);

        String cacheControl = request.cacheControl().toString();
        if (TextUtils.isEmpty(cacheControl)) {
            cacheControl = "public, max-age=120";
        }
        return response.newBuilder()
                .header("Cache-Control", cacheControl)
                .removeHeader("Pragma")
                .build();


    }
}