package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.ShareVideo;

public final class ShareVideoContent extends ShareContent<ShareVideoContent, Builder> implements ShareModel {
    public static final Parcelable.Creator<ShareVideoContent> CREATOR = new Parcelable.Creator<ShareVideoContent>() {
        /* class com.facebook.share.model.ShareVideoContent.AnonymousClass1 */

        public final ShareVideoContent createFromParcel(Parcel parcel) {
            return new ShareVideoContent(parcel);
        }

        public final ShareVideoContent[] newArray(int i) {
            return new ShareVideoContent[i];
        }
    };
    private final String contentDescription;
    private final String contentTitle;
    private final SharePhoto previewPhoto;
    private final ShareVideo video;

    public final int describeContents() {
        return 0;
    }

    private ShareVideoContent(Builder builder) {
        super(builder);
        this.contentDescription = builder.contentDescription;
        this.contentTitle = builder.contentTitle;
        this.previewPhoto = builder.previewPhoto;
        this.video = builder.video;
    }

    ShareVideoContent(Parcel parcel) {
        super(parcel);
        this.contentDescription = parcel.readString();
        this.contentTitle = parcel.readString();
        SharePhoto.Builder readFrom = new SharePhoto.Builder().readFrom(parcel);
        if (readFrom.getImageUrl() == null && readFrom.getBitmap() == null) {
            this.previewPhoto = null;
        } else {
            this.previewPhoto = readFrom.build();
        }
        this.video = new ShareVideo.Builder().readFrom(parcel).build();
    }

    public final String getContentDescription() {
        return this.contentDescription;
    }

    public final String getContentTitle() {
        return this.contentTitle;
    }

    public final SharePhoto getPreviewPhoto() {
        return this.previewPhoto;
    }

    public final ShareVideo getVideo() {
        return this.video;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.contentDescription);
        parcel.writeString(this.contentTitle);
        parcel.writeParcelable(this.previewPhoto, 0);
        parcel.writeParcelable(this.video, 0);
    }

    public static final class Builder extends ShareContent.Builder<ShareVideoContent, Builder> {
        public String contentDescription;
        public String contentTitle;
        public SharePhoto previewPhoto;
        public ShareVideo video;

        public final Builder setContentDescription(String str) {
            this.contentDescription = str;
            return this;
        }

        public final Builder setContentTitle(String str) {
            this.contentTitle = str;
            return this;
        }

        public final Builder setPreviewPhoto(SharePhoto sharePhoto) {
            SharePhoto sharePhoto2;
            if (sharePhoto == null) {
                sharePhoto2 = null;
            } else {
                sharePhoto2 = new SharePhoto.Builder().readFrom(sharePhoto).build();
            }
            this.previewPhoto = sharePhoto2;
            return this;
        }

        public final Builder setVideo(ShareVideo shareVideo) {
            if (shareVideo == null) {
                return this;
            }
            this.video = new ShareVideo.Builder().readFrom(shareVideo).build();
            return this;
        }

        public final ShareVideoContent build() {
            return new ShareVideoContent(this);
        }

        public final Builder readFrom(ShareVideoContent shareVideoContent) {
            if (shareVideoContent == null) {
                return this;
            }
            return ((Builder) super.readFrom((ShareContent) shareVideoContent)).setContentDescription(shareVideoContent.getContentDescription()).setContentTitle(shareVideoContent.getContentTitle()).setPreviewPhoto(shareVideoContent.getPreviewPhoto()).setVideo(shareVideoContent.getVideo());
        }
    }
}
