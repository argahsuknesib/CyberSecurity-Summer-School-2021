package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;

public final class ShareMessengerOpenGraphMusicTemplateContent extends ShareContent<ShareMessengerOpenGraphMusicTemplateContent, Builder> {
    public static final Parcelable.Creator<ShareMessengerOpenGraphMusicTemplateContent> CREATOR = new Parcelable.Creator<ShareMessengerOpenGraphMusicTemplateContent>() {
        /* class com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent.AnonymousClass1 */

        public final ShareMessengerOpenGraphMusicTemplateContent createFromParcel(Parcel parcel) {
            return new ShareMessengerOpenGraphMusicTemplateContent(parcel);
        }

        public final ShareMessengerOpenGraphMusicTemplateContent[] newArray(int i) {
            return new ShareMessengerOpenGraphMusicTemplateContent[i];
        }
    };
    private final ShareMessengerActionButton button;
    private final Uri url;

    public final int describeContents() {
        return 0;
    }

    private ShareMessengerOpenGraphMusicTemplateContent(Builder builder) {
        super(builder);
        this.url = builder.url;
        this.button = builder.button;
    }

    ShareMessengerOpenGraphMusicTemplateContent(Parcel parcel) {
        super(parcel);
        this.url = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.button = (ShareMessengerActionButton) parcel.readParcelable(ShareMessengerActionButton.class.getClassLoader());
    }

    public final Uri getUrl() {
        return this.url;
    }

    public final ShareMessengerActionButton getButton() {
        return this.button;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.url, i);
        parcel.writeParcelable(this.button, i);
    }

    public static class Builder extends ShareContent.Builder<ShareMessengerOpenGraphMusicTemplateContent, Builder> {
        public ShareMessengerActionButton button;
        public Uri url;

        public Builder setUrl(Uri uri) {
            this.url = uri;
            return this;
        }

        public Builder setButton(ShareMessengerActionButton shareMessengerActionButton) {
            this.button = shareMessengerActionButton;
            return this;
        }

        public Builder readFrom(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
            if (shareMessengerOpenGraphMusicTemplateContent == null) {
                return this;
            }
            return ((Builder) super.readFrom((ShareContent) shareMessengerOpenGraphMusicTemplateContent)).setUrl(shareMessengerOpenGraphMusicTemplateContent.getUrl()).setButton(shareMessengerOpenGraphMusicTemplateContent.getButton());
        }

        public ShareMessengerOpenGraphMusicTemplateContent build() {
            return new ShareMessengerOpenGraphMusicTemplateContent(this);
        }
    }
}
