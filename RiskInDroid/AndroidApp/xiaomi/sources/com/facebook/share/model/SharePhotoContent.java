package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.SharePhoto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SharePhotoContent extends ShareContent<SharePhotoContent, Builder> {
    public static final Parcelable.Creator<SharePhotoContent> CREATOR = new Parcelable.Creator<SharePhotoContent>() {
        /* class com.facebook.share.model.SharePhotoContent.AnonymousClass1 */

        public final SharePhotoContent createFromParcel(Parcel parcel) {
            return new SharePhotoContent(parcel);
        }

        public final SharePhotoContent[] newArray(int i) {
            return new SharePhotoContent[i];
        }
    };
    private final List<SharePhoto> photos;

    public final int describeContents() {
        return 0;
    }

    private SharePhotoContent(Builder builder) {
        super(builder);
        this.photos = Collections.unmodifiableList(builder.photos);
    }

    SharePhotoContent(Parcel parcel) {
        super(parcel);
        this.photos = Collections.unmodifiableList(SharePhoto.Builder.readPhotoListFrom(parcel));
    }

    public final List<SharePhoto> getPhotos() {
        return this.photos;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        SharePhoto.Builder.writePhotoListTo(parcel, i, this.photos);
    }

    public static class Builder extends ShareContent.Builder<SharePhotoContent, Builder> {
        public final List<SharePhoto> photos = new ArrayList();

        public Builder addPhoto(SharePhoto sharePhoto) {
            if (sharePhoto != null) {
                this.photos.add(new SharePhoto.Builder().readFrom(sharePhoto).build());
            }
            return this;
        }

        public Builder addPhotos(List<SharePhoto> list) {
            if (list != null) {
                for (SharePhoto addPhoto : list) {
                    addPhoto(addPhoto);
                }
            }
            return this;
        }

        public SharePhotoContent build() {
            return new SharePhotoContent(this);
        }

        public Builder readFrom(SharePhotoContent sharePhotoContent) {
            if (sharePhotoContent == null) {
                return this;
            }
            return ((Builder) super.readFrom((ShareContent) sharePhotoContent)).addPhotos(sharePhotoContent.getPhotos());
        }

        public Builder setPhotos(List<SharePhoto> list) {
            this.photos.clear();
            addPhotos(list);
            return this;
        }
    }
}
