package sarojsharma.com.popularmovies;
import retrofit.Callback;
import retrofit.http.GET;


/**
 * Created by Sarojsharma on 25.08.2016.
 * this interface is used to make get requests to the remote database
 */

public interface MoviesApiService {
    @GET("/movie/popular")
    void getPopularMovies(Callback<Movie.MovieResult> cb);
    @GET("/movie/top_rated")
    void getTopRatedMovies(Callback<Movie.MovieResult> cb);
    @GET("/search/movie")
    void searchMovie(Callback<Movie.MovieResult> cb);

}
