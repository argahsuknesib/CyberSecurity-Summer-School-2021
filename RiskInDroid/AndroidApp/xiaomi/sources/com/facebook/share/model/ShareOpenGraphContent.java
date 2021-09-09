package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareOpenGraphAction;

public final class ShareOpenGraphContent extends ShareContent<ShareOpenGraphContent, Builder> {
    public static final Parcelable.Creator<ShareOpenGraphContent> CREATOR = new Parcelable.Creator<ShareOpenGraphContent>() {
        /* class com.facebook.share.model.ShareOpenGraphContent.AnonymousClass1 */

        public final ShareOpenGraphContent createFromParcel(Parcel parcel) {
            return new ShareOpenGraphContent(parcel);
        }

        public final ShareOpenGraphContent[] newArray(int i) {
            return new ShareOpenGraphContent[i];
        }
    };
    private final ShareOpenGraphAction action;
    private final String previewPropertyName;

    public final int describeContents() {
        return 0;
    }

    private ShareOpenGraphContent(Builder builder) {
        super(builder);
        this.action = builder.action;
        this.previewPropertyName = builder.previewPropertyName;
    }

    ShareOpenGraphContent(Parcel parcel) {
        super(parcel);
        this.action = new ShareOpenGraphAction.Builder().readFrom(parcel).build();
        this.previewPropertyName = parcel.readString();
    }

    public final ShareOpenGraphAction getAction() {
        return this.action;
    }

    public final String getPreviewPropertyName() {
        return this.previewPropertyName;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.action, 0);
        parcel.writeString(this.previewPropertyName);
    }

    public static final class Builder extends ShareContent.Builder<ShareOpenGraphContent, Builder> {
        public ShareOpenGraphAction action;
        public String previewPropertyName;

        public final Builder setAction(ShareOpenGraphAction shareOpenGraphAction) {
            ShareOpenGraphAction shareOpenGraphAction2;
            if (shareOpenGraphAction == null) {
                shareOpenGraphAction2 = null;
            } else {
                shareOpenGraphAction2 = new ShareOpenGraphAction.Builder().readFrom(shareOpenGraphAction).build();
            }
            this.action = shareOpenGraphAction2;
            return this;
        }

        public final Builder setPreviewPropertyName(String str) {
            this.previewPropertyName = str;
            return this;
        }

        public final ShareOpenGraphContent build() {
            return new ShareOpenGraphContent(this);
        }

        public final Builder readFrom(ShareOpenGraphContent shareOpenGraphContent) {
            if (shareOpenGraphContent == null) {
                return this;
            }
            return ((Builder) super.readFrom((ShareContent) shareOpenGraphContent)).setAction(shareOpenGraphContent.getAction()).setPreviewPropertyName(shareOpenGraphContent.getPreviewPropertyName());
        }
    }
}
