

package com.example.uehnews.utils;

/**
 * Store Constants for the NewsFeed app.
 */

public class Constants {

    /**
     * Create a private constructor because no one should ever create a {@link Constants} object.
     */
    private Constants() {
    }

    public static final String FIREBASE_DATABASE = "https://news-5681d-default-rtdb.asia-southeast1.firebasedatabase.app/";

    /** Default number to set the image on the top of the textView */
    public static final int DEFAULT_NUMBER = 0;

    /** Constants value for each fragment */
    public static final int HOME = 0;
    public static final int WORLD = 1;
    public static final int SCIENCE = 2;
    public static final int SPORT = 3;
    public static final int ENVIRONMENT = 4;
    public static final int SOCIETY = 5;
    public static final int FASHION = 6;
    public static final int BUSINESS = 7;
    public static final int CULTURE = 8;

}
