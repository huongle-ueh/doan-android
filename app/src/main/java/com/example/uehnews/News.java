

package com.example.uehnews;

import android.util.Log;

/**
 * An {@link News} object contains information related to a single news.
 */

public class News {

    /** Title of the article */
    private String mTitle;

    /** Section name of the article*/
    private String mSection;

    /** Website URL of the article */
    private String mUrl;

    /** Thumbnail of the article */
    private String mThumbnail;

    /** TrailText of the article with string type Html */
    private String mdescription;

    public News() {
        // Required empty constructor for Firebase
    }

    /**
     * Constructs a new {@link News} object.
     *
     * @param title is the title of the article
     * @param section is the section name of the article
     * @param url is the website URL to find more details about the article
     * @param thumbnail is the thumbnail of the article
     * @param description is trail text of the article with string type Html
     */
    public News(String title, String section, String url, String thumbnail, String description) {
        this.mTitle = title;
        this.mSection = section;
        this.mUrl = url;
        this.mThumbnail = thumbnail;
        this.mdescription = description;
    }

    /**
     * Returns the title of the article
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Returns the section name of the article.
     */
    public String getSection() {
        return mSection;
    }

    /**
     * Returns the website URL to find more information about the news.
     */
    public String getUrl() {
        return mUrl;
    }

    /**
     * Returns the thumbnail of the article
     */
    public String getThumbnail() {
        return mThumbnail;
    }

    /**
     * Returns the TrailText of the article with string type Html
     */
    public String getDescription() {
        return mdescription;
    }


    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setSection(String mSection) {
        this.mSection = mSection;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public void setThumbnail(String mThumbnail) {
        this.mThumbnail = mThumbnail;
    }

    public void setDescription(String description) {
        this.mdescription = description;
    }

    @Override
    public String toString() {
        return "Title:" + mTitle + " mSection:" + mSection + " mThumbnail:" + mThumbnail + " mDescription:" + mdescription;
    }
}
