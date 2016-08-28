package sarojsharma.com.popularmovies;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Sarojsharma on 25.08.2016.
 * holder to hold image and text
 */
public class MovieViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView text;
    public MovieViewHolder(View itemView) {
        super(itemView);
        text = (TextView) itemView.findViewById(R.id.title);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);

    }
}
