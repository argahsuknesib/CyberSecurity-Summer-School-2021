package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareMedia;
import java.util.ArrayList;
import java.util.List;

public final class SharePhoto extends ShareMedia {
    public static final Parcelable.Creator<SharePhoto> CREATOR = new Parcelable.Creator<SharePhoto>() {
        /* class com.facebook.share.model.SharePhoto.AnonymousClass1 */

        public final SharePhoto createFromParcel(Parcel parcel) {
            return new SharePhoto(parcel);
        }

        public final SharePhoto[] newArray(int i) {
            return new SharePhoto[i];
        }
    };
    private final Bitmap bitmap;
    private final String caption;
    private final Uri imageUrl;
    private final boolean userGenerated;

    public final int describeContents() {
        return 0;
    }

    private SharePhoto(Builder builder) {
        super(builder);
        this.bitmap = builder.bitmap;
        this.imageUrl = builder.imageUrl;
        this.userGenerated = builder.userGenerated;
        this.caption = builder.caption;
    }

    SharePhoto(Parcel parcel) {
        super(parcel);
        this.bitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.imageUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.userGenerated = parcel.readByte() != 0;
        this.caption = parcel.readString();
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final Uri getImageUrl() {
        return this.imageUrl;
    }

    public final boolean getUserGenerated() {
        return this.userGenerated;
    }

    public final String getCaption() {
        return this.caption;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.bitmap, 0);
        parcel.writeParcelable(this.imageUrl, 0);
        parcel.writeByte(this.userGenerated ? (byte) 1 : 0);
        parcel.writeString(this.caption);
    }

    public final ShareMedia.Type getMediaType() {
        return ShareMedia.Type.PHOTO;
    }

    public static final class Builder extends ShareMedia.Builder<SharePhoto, Builder> {
        public Bitmap bitmap;
        public String caption;
        public Uri imageUrl;
        public boolean userGenerated;

        public final Builder setBitmap(Bitmap bitmap2) {
            this.bitmap = bitmap2;
            return this;
        }

        public final Builder setImageUrl(Uri uri) {
            this.imageUrl = uri;
            return this;
        }

        public final Builder setUserGenerated(boolean z) {
            this.userGenerated = z;
            return this;
        }

        public final Builder setCaption(String str) {
            this.caption = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public final Uri getImageUrl() {
            return this.imageUrl;
        }

        /* access modifiers changed from: package-private */
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final SharePhoto build() {
            return new SharePhoto(this);
        }

        public final Builder readFrom(SharePhoto sharePhoto) {
            if (sharePhoto == null) {
                return this;
            }
            return ((Builder) super.readFrom((ShareMedia) sharePhoto)).setBitmap(sharePhoto.getBitmap()).setImageUrl(sharePhoto.getImageUrl()).setUserGenerated(sharePhoto.getUserGenerated()).setCaption(sharePhoto.getCaption());
        }

        /* access modifiers changed from: package-private */
        public final Builder readFrom(Parcel parcel) {
            return readFrom((SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader()));
        }

        static void writePhotoListTo(Parcel parcel, int i, List<SharePhoto> list) {
            ShareMedia[] shareMediaArr = new ShareMedia[list.size()];
            for (int i2 = 0; i2 < list.size(); i2++) {
                shareMediaArr[i2] = list.get(i2);
            }
            parcel.writeParcelableArray(shareMediaArr, i);
        }

        static List<SharePhoto> readPhotoListFrom(Parcel parcel) {
            List<ShareMedia> readListFrom = readListFrom(parcel);
            ArrayList arrayList = new ArrayList();
            for (ShareMedia next : readListFrom) {
                if (next instanceof SharePhoto) {
                    arrayList.add((SharePhoto) next);
                }
            }
            return arrayList;
        }
    }
}
