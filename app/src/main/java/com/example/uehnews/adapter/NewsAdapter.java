

package com.example.uehnews.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.preference.PreferenceManager;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.text.Html;
import android.text.format.DateUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.uehnews.DisplayActivity;
import com.example.uehnews.News;
import com.example.uehnews.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/**
 * A {@link NewsAdapter} can provide a card item layout for each news in the data source
 * ( a list of {@link News} objects).
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private Context mContext;
    private List<News> mNewsList;
    private SharedPreferences sharedPrefs;

    /**
     * Constructs a new {@link NewsAdapter}
     * @param context of the app
     * @param newsList is the list of news, which is the data source of the adapter
     */
    public NewsAdapter(Context context, List<News> newsList) {
        mContext = context;
        mNewsList = newsList;
    }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView sectionTextView;
        private ImageView thumbnailImageView;
        private TextView trailTextView;
        private CardView cardView;

        ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title_card);
            sectionTextView = itemView.findViewById(R.id.section_card);
            thumbnailImageView = itemView.findViewById(R.id.thumbnail_image_card);
            trailTextView = itemView.findViewById(R.id.trail_text_card);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);

        // Change the color theme of Title TextView by using the user's stored preferences
        setColorTheme(holder);

        // Change text size of TextView by using the user's stored preferences
        setTextSize(holder);

        // Find the current news that was clicked on
        final News currentNews = mNewsList.get(position);

        holder.titleTextView.setText(currentNews.getTitle());
        holder.sectionTextView.setText(currentNews.getSection());

        // Get string of the trailTextHTML and convert Html text to plain text
        // and set the plain text on the textView
        String trailTextHTML = currentNews.getDescription();
        holder.trailTextView.setText(Html.fromHtml(trailTextHTML).toString());

        // Set an OnClickListener to open a website with more information about the selected article
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), DisplayActivity.class);
                intent.putExtra("image", currentNews.getThumbnail());
                intent.putExtra("title", currentNews.getTitle());
                intent.putExtra("content", currentNews.getDescription());
                view.getContext().startActivity(intent);
            }
        });

        if (currentNews.getThumbnail() == null) {
            holder.thumbnailImageView.setVisibility(View.GONE);
        } else {
            holder.thumbnailImageView.setVisibility(View.VISIBLE);
            // Load thumbnail with glide
            Glide.with(mContext.getApplicationContext())
                    .load(currentNews.getThumbnail())
                    .into(holder.thumbnailImageView);
        }
    }

    /**
     * Set the user preferred color theme
     */
    private void setColorTheme(ViewHolder holder) {
        // Get the color theme string from SharedPreferences and check for the value associated with the key
        String colorTheme = sharedPrefs.getString(
                mContext.getString(R.string.settings_color_key),
                mContext.getString(R.string.settings_color_default));

        // Change the background color of titleTextView by using the user's stored preferences
        if (colorTheme.equals(mContext.getString(R.string.settings_color_white_value))) {
            holder.titleTextView.setBackgroundResource(R.color.white);
            holder.titleTextView.setTextColor(Color.BLACK);
        }else if (colorTheme.equals(mContext.getString(R.string.settings_color_sky_blue_value))) {
            holder.titleTextView.setBackgroundResource(R.color.nav_bar_start);
            holder.titleTextView.setTextColor(Color.WHITE);
        } else if (colorTheme.equals(mContext.getString(R.string.settings_color_dark_blue_value))) {
            holder.titleTextView.setBackgroundResource(R.color.color_app_bar_text);
            holder.titleTextView.setTextColor(Color.WHITE);
        } else if (colorTheme.equals(mContext.getString(R.string.settings_color_violet_value))) {
            holder.titleTextView.setBackgroundResource(R.color.violet);
            holder.titleTextView.setTextColor(Color.WHITE);
        } else if (colorTheme.equals(mContext.getString(R.string.settings_color_light_green_value))) {
            holder.titleTextView.setBackgroundResource(R.color.light_green);
            holder.titleTextView.setTextColor(Color.WHITE);
        } else if (colorTheme.equals(mContext.getString(R.string.settings_color_green_value))) {
            holder.titleTextView.setBackgroundResource(R.color.color_section);
            holder.titleTextView.setTextColor(Color.WHITE);
        }
    }

    /**
     * Set the text size to the text size the user choose.
     */
    private void setTextSize(ViewHolder holder) {
        // Get the text size string from SharedPreferences and check for the value associated with the key
        String textSize = sharedPrefs.getString(
                mContext.getString(R.string.settings_text_size_key),
                mContext.getString(R.string.settings_text_size_default));

        // Change text size of TextView by using the user's stored preferences
        if(textSize.equals(mContext.getString(R.string.settings_text_size_medium_value))) {
            holder.titleTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                    mContext.getResources().getDimension(R.dimen.sp22));
            holder.sectionTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                    mContext.getResources().getDimension(R.dimen.sp14));
            holder.trailTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                    mContext.getResources().getDimension(R.dimen.sp16));
        } else if(textSize.equals(mContext.getString(R.string.settings_text_size_small_value))) {
            holder.titleTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                    mContext.getResources().getDimension(R.dimen.sp20));
            holder.sectionTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                    mContext.getResources().getDimension(R.dimen.sp12));
            holder.trailTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                    mContext.getResources().getDimension(R.dimen.sp14));
        } else if(textSize.equals(mContext.getString(R.string.settings_text_size_large_value))) {
            holder.titleTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                    mContext.getResources().getDimension(R.dimen.sp24));
            holder.sectionTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                    mContext.getResources().getDimension(R.dimen.sp16));
            holder.trailTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                    mContext.getResources().getDimension(R.dimen.sp18));
        }
    }

    /**
     *  Clear all data (a list of {@link News} objects)
     */
    public void clearAll() {
        mNewsList.clear();
        notifyDataSetChanged();
    }

    /**
     * Add  a list of {@link News}
     * @param newsList is the list of news, which is the data source of the adapter
     */
    public void addAll(List<News> newsList) {
        mNewsList.clear();
        mNewsList.addAll(newsList);
        notifyDataSetChanged();
    }
}
