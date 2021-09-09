package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public final class ShareMessengerGenericTemplateElement implements ShareModel {
    public static final Parcelable.Creator<ShareMessengerGenericTemplateElement> CREATOR = new Parcelable.Creator<ShareMessengerGenericTemplateElement>() {
        /* class com.facebook.share.model.ShareMessengerGenericTemplateElement.AnonymousClass1 */

        public final ShareMessengerGenericTemplateElement createFromParcel(Parcel parcel) {
            return new ShareMessengerGenericTemplateElement(parcel);
        }

        public final ShareMessengerGenericTemplateElement[] newArray(int i) {
            return new ShareMessengerGenericTemplateElement[i];
        }
    };
    public final ShareMessengerActionButton button;
    public final ShareMessengerActionButton defaultAction;
    public final Uri imageUrl;
    public final String subtitle;
    public final String title;

    public final int describeContents() {
        return 0;
    }

    private ShareMessengerGenericTemplateElement(Builder builder) {
        this.title = builder.title;
        this.subtitle = builder.subtitle;
        this.imageUrl = builder.imageUrl;
        this.defaultAction = builder.defaultAction;
        this.button = builder.button;
    }

    ShareMessengerGenericTemplateElement(Parcel parcel) {
        this.title = parcel.readString();
        this.subtitle = parcel.readString();
        this.imageUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.defaultAction = (ShareMessengerActionButton) parcel.readParcelable(ShareMessengerActionButton.class.getClassLoader());
        this.button = (ShareMessengerActionButton) parcel.readParcelable(ShareMessengerActionButton.class.getClassLoader());
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final Uri getImageUrl() {
        return this.imageUrl;
    }

    public final ShareMessengerActionButton getDefaultAction() {
        return this.defaultAction;
    }

    public final ShareMessengerActionButton getButton() {
        return this.button;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        parcel.writeParcelable(this.imageUrl, i);
        parcel.writeParcelable(this.defaultAction, i);
        parcel.writeParcelable(this.button, i);
    }

    public static class Builder implements ShareModelBuilder<ShareMessengerGenericTemplateElement, Builder> {
        public ShareMessengerActionButton button;
        public ShareMessengerActionButton defaultAction;
        public Uri imageUrl;
        public String subtitle;
        public String title;

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public Builder setSubtitle(String str) {
            this.subtitle = str;
            return this;
        }

        public Builder setImageUrl(Uri uri) {
            this.imageUrl = uri;
            return this;
        }

        public Builder setDefaultAction(ShareMessengerActionButton shareMessengerActionButton) {
            this.defaultAction = shareMessengerActionButton;
            return this;
        }

        public Builder setButton(ShareMessengerActionButton shareMessengerActionButton) {
            this.button = shareMessengerActionButton;
            return this;
        }

        public ShareMessengerGenericTemplateElement build() {
            return new ShareMessengerGenericTemplateElement(this);
        }

        public Builder readFrom(ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement) {
            if (shareMessengerGenericTemplateElement == null) {
                return this;
            }
            return setTitle(shareMessengerGenericTemplateElement.title).setSubtitle(shareMessengerGenericTemplateElement.subtitle).setImageUrl(shareMessengerGenericTemplateElement.imageUrl).setDefaultAction(shareMessengerGenericTemplateElement.defaultAction).setButton(shareMessengerGenericTemplateElement.button);
        }

        /* access modifiers changed from: package-private */
        public Builder readFrom(Parcel parcel) {
            return readFrom((ShareMessengerGenericTemplateElement) parcel.readParcelable(ShareMessengerGenericTemplateElement.class.getClassLoader()));
        }
    }
}
