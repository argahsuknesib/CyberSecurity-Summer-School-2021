package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareOpenGraphValueContainer;

public final class ShareOpenGraphObject extends ShareOpenGraphValueContainer<ShareOpenGraphObject, Builder> {
    public static final Parcelable.Creator<ShareOpenGraphObject> CREATOR = new Parcelable.Creator<ShareOpenGraphObject>() {
        /* class com.facebook.share.model.ShareOpenGraphObject.AnonymousClass1 */

        public final ShareOpenGraphObject createFromParcel(Parcel parcel) {
            return new ShareOpenGraphObject(parcel);
        }

        public final ShareOpenGraphObject[] newArray(int i) {
            return new ShareOpenGraphObject[i];
        }
    };

    private ShareOpenGraphObject(Builder builder) {
        super(builder);
    }

    ShareOpenGraphObject(Parcel parcel) {
        super(parcel);
    }

    public static final class Builder extends ShareOpenGraphValueContainer.Builder<ShareOpenGraphObject, Builder> {
        public Builder() {
            putBoolean("fbsdk:create_object", true);
        }

        public final ShareOpenGraphObject build() {
            return new ShareOpenGraphObject(this);
        }

        /* access modifiers changed from: package-private */
        public final Builder readFrom(Parcel parcel) {
            return (Builder) readFrom((ShareOpenGraphValueContainer) ((ShareOpenGraphObject) parcel.readParcelable(ShareOpenGraphObject.class.getClassLoader())));
        }
    }
}
