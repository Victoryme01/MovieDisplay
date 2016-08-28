package sarojsharma.com.popularmovies;

/**
 * This Activity display the search result.
 * */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class SearchActivity extends AppCompatActivity {
    private android.support.v7.app.ActionBar actionBar;
    private MovieAdapter nAdapter;
    private RecyclerView mRecyclerView;

   private String searchName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_movie_result);
        nAdapter = new MovieAdapter(this);
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerView.setHasFixedSize(true);
        nAdapter = new MovieAdapter(this);
        mRecyclerView.setAdapter(nAdapter);
        actionBar = getSupportActionBar();

        //get the intent from another activity
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            searchName = bundle.getString("searchName");
        }

        //get string from intent
        searchMovies(searchName);

    }

    //mehtod to search for movies based on the given keyword

    private void searchMovies(final String search) {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://api.themoviedb.org/3")
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {

                        request.addEncodedQueryParam("api_key", "38254af8f915133808b416c41ded2702");
                        request.addEncodedQueryParam("query", search);
                    }
                })
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        MoviesApiService service = restAdapter.create(MoviesApiService.class);
        service.searchMovie(new Callback<Movie.MovieResult>() {
            @Override
            public void success(Movie.MovieResult movieResult, Response response) {
                nAdapter.setMovieList(movieResult.getResults());
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });
    }


















}
