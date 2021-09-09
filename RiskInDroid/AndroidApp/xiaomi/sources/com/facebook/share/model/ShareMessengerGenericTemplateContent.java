package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;

public final class ShareMessengerGenericTemplateContent extends ShareContent<ShareMessengerGenericTemplateContent, Builder> {
    public static final Parcelable.Creator<ShareMessengerGenericTemplateContent> CREATOR = new Parcelable.Creator<ShareMessengerGenericTemplateContent>() {
        /* class com.facebook.share.model.ShareMessengerGenericTemplateContent.AnonymousClass1 */

        public final ShareMessengerGenericTemplateContent createFromParcel(Parcel parcel) {
            return new ShareMessengerGenericTemplateContent(parcel);
        }

        public final ShareMessengerGenericTemplateContent[] newArray(int i) {
            return new ShareMessengerGenericTemplateContent[i];
        }
    };
    private final ShareMessengerGenericTemplateElement genericTemplateElement;
    private final ImageAspectRatio imageAspectRatio;
    private final boolean isSharable;

    public enum ImageAspectRatio {
        HORIZONTAL,
        SQUARE
    }

    public final int describeContents() {
        return 0;
    }

    protected ShareMessengerGenericTemplateContent(Builder builder) {
        super(builder);
        this.isSharable = builder.isSharable;
        this.imageAspectRatio = builder.imageAspectRatio;
        this.genericTemplateElement = builder.genericTemplateElement;
    }

    ShareMessengerGenericTemplateContent(Parcel parcel) {
        super(parcel);
        this.isSharable = parcel.readByte() != 0;
        this.imageAspectRatio = (ImageAspectRatio) parcel.readSerializable();
        this.genericTemplateElement = (ShareMessengerGenericTemplateElement) parcel.readParcelable(ShareMessengerGenericTemplateElement.class.getClassLoader());
    }

    public final boolean getIsSharable() {
        return this.isSharable;
    }

    public final ImageAspectRatio getImageAspectRatio() {
        return this.imageAspectRatio;
    }

    public final ShareMessengerGenericTemplateElement getGenericTemplateElement() {
        return this.genericTemplateElement;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.isSharable ? (byte) 1 : 0);
        parcel.writeSerializable(this.imageAspectRatio);
        parcel.writeParcelable(this.genericTemplateElement, i);
    }

    public static class Builder extends ShareContent.Builder<ShareMessengerGenericTemplateContent, Builder> {
        public ShareMessengerGenericTemplateElement genericTemplateElement;
        public ImageAspectRatio imageAspectRatio;
        public boolean isSharable;

        public Builder setIsSharable(boolean z) {
            this.isSharable = z;
            return this;
        }

        public Builder setImageAspectRatio(ImageAspectRatio imageAspectRatio2) {
            this.imageAspectRatio = imageAspectRatio2;
            return this;
        }

        public Builder setGenericTemplateElement(ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement) {
            this.genericTemplateElement = shareMessengerGenericTemplateElement;
            return this;
        }

        public ShareMessengerGenericTemplateContent build() {
            return new ShareMessengerGenericTemplateContent(this);
        }

        public Builder readFrom(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
            if (shareMessengerGenericTemplateContent == null) {
                return this;
            }
            return ((Builder) super.readFrom((ShareContent) shareMessengerGenericTemplateContent)).setIsSharable(shareMessengerGenericTemplateContent.getIsSharable()).setImageAspectRatio(shareMessengerGenericTemplateContent.getImageAspectRatio()).setGenericTemplateElement(shareMessengerGenericTemplateContent.getGenericTemplateElement());
        }
    }
}
