package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareOpenGraphValueContainer;

public final class ShareOpenGraphAction extends ShareOpenGraphValueContainer<ShareOpenGraphAction, Builder> {
    public static final Parcelable.Creator<ShareOpenGraphAction> CREATOR = new Parcelable.Creator<ShareOpenGraphAction>() {
        /* class com.facebook.share.model.ShareOpenGraphAction.AnonymousClass1 */

        public final ShareOpenGraphAction createFromParcel(Parcel parcel) {
            return new ShareOpenGraphAction(parcel);
        }

        public final ShareOpenGraphAction[] newArray(int i) {
            return new ShareOpenGraphAction[i];
        }
    };

    private ShareOpenGraphAction(Builder builder) {
        super(builder);
    }

    ShareOpenGraphAction(Parcel parcel) {
        super(parcel);
    }

    public final String getActionType() {
        return getString("og:type");
    }

    public static final class Builder extends ShareOpenGraphValueContainer.Builder<ShareOpenGraphAction, Builder> {
        public final Builder setActionType(String str) {
            putString("og:type", str);
            return this;
        }

        public final ShareOpenGraphAction build() {
            return new ShareOpenGraphAction(this);
        }

        public final Builder readFrom(ShareOpenGraphAction shareOpenGraphAction) {
            if (shareOpenGraphAction == null) {
                return this;
            }
            return ((Builder) super.readFrom((ShareOpenGraphValueContainer) shareOpenGraphAction)).setActionType(shareOpenGraphAction.getActionType());
        }

        /* access modifiers changed from: package-private */
        public final Builder readFrom(Parcel parcel) {
            return readFrom((ShareOpenGraphAction) parcel.readParcelable(ShareOpenGraphAction.class.getClassLoader()));
        }
    }
}
