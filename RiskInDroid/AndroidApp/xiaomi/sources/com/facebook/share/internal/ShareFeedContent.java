package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;

public class ShareFeedContent extends ShareContent<ShareFeedContent, Builder> {
    public static final Parcelable.Creator<ShareFeedContent> CREATOR = new Parcelable.Creator<ShareFeedContent>() {
        /* class com.facebook.share.internal.ShareFeedContent.AnonymousClass1 */

        public final ShareFeedContent createFromParcel(Parcel parcel) {
            return new ShareFeedContent(parcel);
        }

        public final ShareFeedContent[] newArray(int i) {
            return new ShareFeedContent[i];
        }
    };
    private final String link;
    private final String linkCaption;
    private final String linkDescription;
    private final String linkName;
    private final String mediaSource;
    private final String picture;
    private final String toId;

    public int describeContents() {
        return 0;
    }

    private ShareFeedContent(Builder builder) {
        super(builder);
        this.toId = builder.toId;
        this.link = builder.link;
        this.linkName = builder.linkName;
        this.linkCaption = builder.linkCaption;
        this.linkDescription = builder.linkDescription;
        this.picture = builder.picture;
        this.mediaSource = builder.mediaSource;
    }

    ShareFeedContent(Parcel parcel) {
        super(parcel);
        this.toId = parcel.readString();
        this.link = parcel.readString();
        this.linkName = parcel.readString();
        this.linkCaption = parcel.readString();
        this.linkDescription = parcel.readString();
        this.picture = parcel.readString();
        this.mediaSource = parcel.readString();
    }

    public String getToId() {
        return this.toId;
    }

    public String getLink() {
        return this.link;
    }

    public String getLinkName() {
        return this.linkName;
    }

    public String getLinkCaption() {
        return this.linkCaption;
    }

    public String getLinkDescription() {
        return this.linkDescription;
    }

    public String getPicture() {
        return this.picture;
    }

    public String getMediaSource() {
        return this.mediaSource;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.toId);
        parcel.writeString(this.link);
        parcel.writeString(this.linkName);
        parcel.writeString(this.linkCaption);
        parcel.writeString(this.linkDescription);
        parcel.writeString(this.picture);
        parcel.writeString(this.mediaSource);
    }

    public static final class Builder extends ShareContent.Builder<ShareFeedContent, Builder> {
        public String link;
        public String linkCaption;
        public String linkDescription;
        public String linkName;
        public String mediaSource;
        public String picture;
        public String toId;

        public final Builder setToId(String str) {
            this.toId = str;
            return this;
        }

        public final Builder setLink(String str) {
            this.link = str;
            return this;
        }

        public final Builder setLinkName(String str) {
            this.linkName = str;
            return this;
        }

        public final Builder setLinkCaption(String str) {
            this.linkCaption = str;
            return this;
        }

        public final Builder setLinkDescription(String str) {
            this.linkDescription = str;
            return this;
        }

        public final Builder setPicture(String str) {
            this.picture = str;
            return this;
        }

        public final Builder setMediaSource(String str) {
            this.mediaSource = str;
            return this;
        }

        public final ShareFeedContent build() {
            return new ShareFeedContent(this);
        }

        public final Builder readFrom(ShareFeedContent shareFeedContent) {
            if (shareFeedContent == null) {
                return this;
            }
            return ((Builder) super.readFrom((ShareContent) shareFeedContent)).setToId(shareFeedContent.getToId()).setLink(shareFeedContent.getLink()).setLinkName(shareFeedContent.getLinkName()).setLinkCaption(shareFeedContent.getLinkCaption()).setLinkDescription(shareFeedContent.getLinkDescription()).setPicture(shareFeedContent.getPicture()).setMediaSource(shareFeedContent.getMediaSource());
        }
    }
}
