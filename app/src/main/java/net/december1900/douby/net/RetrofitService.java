package net.december1900.douby.net;

import net.december1900.douby.common.model.Movie;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by december on 2017/8/20.
 */

public interface RetrofitService {

    @GET("movie/top250")
    Observable<Movie> getMovies(@Query("count") String count);
}
