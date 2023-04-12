

package com.example.uehnews;

import android.content.Context;

public final class NewsPreferences {

    /**
     * Get String based on stored SharedPreferences.
     * @param context Context used to access SharedPreferences
     * @return empty String
     */
    public static String getPreferredUri(Context context) {
        return "";
    }

    /**
     * Returns String section for query
     * @param context Context used to access getPreferredUri method
     * @param section News section
     */
    public static String getPreferredUrl(Context context, String section) {
        return section;
    }
}
