package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.facebook.share.model.ShareContent;

public final class ShareLinkContent extends ShareContent<ShareLinkContent, Builder> {
    public static final Parcelable.Creator<ShareLinkContent> CREATOR = new Parcelable.Creator<ShareLinkContent>() {
        /* class com.facebook.share.model.ShareLinkContent.AnonymousClass1 */

        public final ShareLinkContent createFromParcel(Parcel parcel) {
            return new ShareLinkContent(parcel);
        }

        public final ShareLinkContent[] newArray(int i) {
            return new ShareLinkContent[i];
        }
    };
    @Deprecated
    private final String contentDescription;
    @Deprecated
    private final String contentTitle;
    @Deprecated
    private final Uri imageUrl;
    private final String quote;

    public final int describeContents() {
        return 0;
    }

    private ShareLinkContent(Builder builder) {
        super(builder);
        this.contentDescription = builder.contentDescription;
        this.contentTitle = builder.contentTitle;
        this.imageUrl = builder.imageUrl;
        this.quote = builder.quote;
    }

    ShareLinkContent(Parcel parcel) {
        super(parcel);
        this.contentDescription = parcel.readString();
        this.contentTitle = parcel.readString();
        this.imageUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.quote = parcel.readString();
    }

    @Deprecated
    public final String getContentDescription() {
        return this.contentDescription;
    }

    @Deprecated
    public final String getContentTitle() {
        return this.contentTitle;
    }

    @Deprecated
    public final Uri getImageUrl() {
        return this.imageUrl;
    }

    public final String getQuote() {
        return this.quote;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.contentDescription);
        parcel.writeString(this.contentTitle);
        parcel.writeParcelable(this.imageUrl, 0);
        parcel.writeString(this.quote);
    }

    public static final class Builder extends ShareContent.Builder<ShareLinkContent, Builder> {
        static final String TAG = "Builder";
        @Deprecated
        public String contentDescription;
        @Deprecated
        public String contentTitle;
        @Deprecated
        public Uri imageUrl;
        public String quote;

        @Deprecated
        public final Builder setContentDescription(String str) {
            Log.w(TAG, "This method does nothing. ContentDescription is deprecated in Graph API 2.9.");
            return this;
        }

        @Deprecated
        public final Builder setContentTitle(String str) {
            Log.w(TAG, "This method does nothing. ContentTitle is deprecated in Graph API 2.9.");
            return this;
        }

        @Deprecated
        public final Builder setImageUrl(Uri uri) {
            Log.w(TAG, "This method does nothing. ImageUrl is deprecated in Graph API 2.9.");
            return this;
        }

        public final Builder setQuote(String str) {
            this.quote = str;
            return this;
        }

        public final ShareLinkContent build() {
            return new ShareLinkContent(this);
        }

        public final Builder readFrom(ShareLinkContent shareLinkContent) {
            if (shareLinkContent == null) {
                return this;
            }
            return ((Builder) super.readFrom((ShareContent) shareLinkContent)).setContentDescription(shareLinkContent.getContentDescription()).setImageUrl(shareLinkContent.getImageUrl()).setContentTitle(shareLinkContent.getContentTitle()).setQuote(shareLinkContent.getQuote());
        }
    }
}
