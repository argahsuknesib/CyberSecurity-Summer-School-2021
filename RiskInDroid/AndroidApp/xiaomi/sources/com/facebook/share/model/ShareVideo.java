package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareMedia;

public final class ShareVideo extends ShareMedia {
    public static final Parcelable.Creator<ShareVideo> CREATOR = new Parcelable.Creator<ShareVideo>() {
        /* class com.facebook.share.model.ShareVideo.AnonymousClass1 */

        public final ShareVideo createFromParcel(Parcel parcel) {
            return new ShareVideo(parcel);
        }

        public final ShareVideo[] newArray(int i) {
            return new ShareVideo[i];
        }
    };
    private final Uri localUrl;

    public final int describeContents() {
        return 0;
    }

    private ShareVideo(Builder builder) {
        super(builder);
        this.localUrl = builder.localUrl;
    }

    ShareVideo(Parcel parcel) {
        super(parcel);
        this.localUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }

    public final Uri getLocalUrl() {
        return this.localUrl;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.localUrl, 0);
    }

    public final ShareMedia.Type getMediaType() {
        return ShareMedia.Type.VIDEO;
    }

    public static final class Builder extends ShareMedia.Builder<ShareVideo, Builder> {
        public Uri localUrl;

        public final Builder setLocalUrl(Uri uri) {
            this.localUrl = uri;
            return this;
        }

        public final ShareVideo build() {
            return new ShareVideo(this);
        }

        public final Builder readFrom(ShareVideo shareVideo) {
            if (shareVideo == null) {
                return this;
            }
            return ((Builder) super.readFrom((ShareMedia) shareVideo)).setLocalUrl(shareVideo.getLocalUrl());
        }

        /* access modifiers changed from: package-private */
        public final Builder readFrom(Parcel parcel) {
            return readFrom((ShareVideo) parcel.readParcelable(ShareVideo.class.getClassLoader()));
        }
    }
}
