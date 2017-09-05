package net.december1900.douby.net;

import net.december1900.douby.common.model.Actor;
import net.december1900.douby.common.model.Movie;
import net.december1900.douby.common.model.Summary;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by december on 2017/8/20.
 */

public interface RetrofitService {

    @GET("movie/top250")
    Observable<Movie> getMovies(@Query("count") String count);

    @GET("movie/celebrity/{id}")
    Observable<Actor> getActor(@Path("id") String id);

    @GET("movie/subject/{id}")
    Observable<Summary> getSummary(@Path("id") String id);
}
