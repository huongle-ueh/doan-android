

package com.example.uehnews.utils;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.uehnews.News;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Helper methods related to requesting and receiving news data from news.
 */
public class QueryUtils {

    /**
     * Create a private constructor because no one should ever create a {@link QueryUtils} object.
     */
    private QueryUtils() {
    }

    /**
     * Query the news data set and return a list of {@link News} objects.
     */
    public static List<News> fetchNewsData(String requestUrl) {
        List<News> newsList = new ArrayList<>();
        Query query;
        DatabaseReference databaseRef = FirebaseDatabase.getInstance(Constants.FIREBASE_DATABASE).getReference();

        if (requestUrl == "") {
            query = databaseRef.limitToFirst(100);
        } else {
            query = databaseRef.orderByChild("section").equalTo(requestUrl.trim()).limitToFirst(100);
        }

        final CountDownLatch latch = new CountDownLatch(1);

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                newsList.clear();
                for (DataSnapshot newsSnapshot : snapshot.getChildren()) {
                    News news = newsSnapshot.getValue(News.class);
                    newsList.add(news);
                }
                latch.countDown();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                latch.countDown();
            }
        });

        try {
            latch.await();
        } catch (InterruptedException e) {
            Log.e("TAG", "InterruptedException", e);
        }
        return newsList;
    }
}
