

package com.example.uehnews;

import androidx.loader.content.AsyncTaskLoader;
import android.content.Context;

import com.example.uehnews.utils.QueryUtils;

import java.util.List;

/**
 * Loads a list of news by using an AsyncTask to perform the network request to the given URL.
 */
public class NewsLoader extends AsyncTaskLoader<List<News>> {

    /** Tag for log messages */
    private static final String LOG_TAG = NewsLoader.class.getName();

    /** Query Categoty */
    private String mCategory;

    /**
     * Constructs a new {@link NewsLoader}.
     *
     * @param context of the activity
     * @param category to load data from
     */
    public NewsLoader(Context context, String category) {
        super(context);
        mCategory = category;
    }

    @Override
    protected void onStartLoading() {
        // Trigger the loadInBackground() method to execute.
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<News> loadInBackground() {
        if (mCategory == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of news.
        List<News> newsData = QueryUtils.fetchNewsData(mCategory);
        return newsData;
    }
}
