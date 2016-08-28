package sarojsharma.com.popularmovies;

/**
 * this Adapter is used to switch between tabs
 * Created by Sarojsharma on 25.08.2016.
 */


 import android.support.v4.app.FragmentManager;
 import android.support.v4.app.FragmentPagerAdapter;

    public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Top Rated fragment activity
                return new TopRatedFragment();
            case 1:
                // Popular movie fragment activity
                return new PopularMovieFragment();

        }

        return null;
    }

    @Override
    public int getCount() {
       //no of tabs
            return 2;


    }

}