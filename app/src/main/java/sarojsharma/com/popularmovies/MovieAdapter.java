package sarojsharma.com.popularmovies;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sarojsharma on 25.08.2016.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    private List<Movie> mMovieList;
    private LayoutInflater mInflater;
    private Context mContext;
    private String[] mDataset;

    public MovieAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_movie, parent, false);

        final MovieViewHolder viewHolder = new MovieViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewHolder.getAdapterPosition();
                Intent intent = new Intent(mContext, MovieDetailActivity.class);
                intent.putExtra(MovieDetailActivity.EXTRA_MOVIE, mMovieList.get(position));
                mContext.startActivity(intent);
            }
        });
        return viewHolder;


}

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {

        Movie movie = mMovieList.get(position);
        Picasso.with(mContext)
                .load(movie.getPoster())
                .placeholder(R.color.colorPrimary)
                .into(holder.imageView);

        holder.text.setText(movie.getTitle());


    }

    @Override
    public int getItemCount() {
        return (mMovieList == null) ? 0 : mMovieList.size();

    }

    public void setMovieList(List<Movie> movieList) {
        this.mMovieList = new ArrayList<>();
        this.mMovieList.addAll(movieList);
        notifyDataSetChanged();
    }
}