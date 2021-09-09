package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;

public final class ShareMessengerMediaTemplateContent extends ShareContent<ShareMessengerMediaTemplateContent, Builder> {
    public static final Parcelable.Creator<ShareMessengerMediaTemplateContent> CREATOR = new Parcelable.Creator<ShareMessengerMediaTemplateContent>() {
        /* class com.facebook.share.model.ShareMessengerMediaTemplateContent.AnonymousClass1 */

        public final ShareMessengerMediaTemplateContent createFromParcel(Parcel parcel) {
            return new ShareMessengerMediaTemplateContent(parcel);
        }

        public final ShareMessengerMediaTemplateContent[] newArray(int i) {
            return new ShareMessengerMediaTemplateContent[i];
        }
    };
    private final String attachmentId;
    private final ShareMessengerActionButton button;
    private final MediaType mediaType;
    private final Uri mediaUrl;

    public enum MediaType {
        IMAGE,
        VIDEO
    }

    public final int describeContents() {
        return 0;
    }

    private ShareMessengerMediaTemplateContent(Builder builder) {
        super(builder);
        this.mediaType = builder.mediaType;
        this.attachmentId = builder.attachmentId;
        this.mediaUrl = builder.mediaUrl;
        this.button = builder.button;
    }

    ShareMessengerMediaTemplateContent(Parcel parcel) {
        super(parcel);
        this.mediaType = (MediaType) parcel.readSerializable();
        this.attachmentId = parcel.readString();
        this.mediaUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.button = (ShareMessengerActionButton) parcel.readParcelable(ShareMessengerActionButton.class.getClassLoader());
    }

    public final MediaType getMediaType() {
        return this.mediaType;
    }

    public final String getAttachmentId() {
        return this.attachmentId;
    }

    public final Uri getMediaUrl() {
        return this.mediaUrl;
    }

    public final ShareMessengerActionButton getButton() {
        return this.button;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.mediaType);
        parcel.writeString(this.attachmentId);
        parcel.writeParcelable(this.mediaUrl, i);
        parcel.writeParcelable(this.button, i);
    }

    public static class Builder extends ShareContent.Builder<ShareMessengerMediaTemplateContent, Builder> {
        public String attachmentId;
        public ShareMessengerActionButton button;
        public MediaType mediaType;
        public Uri mediaUrl;

        public Builder setMediaType(MediaType mediaType2) {
            this.mediaType = mediaType2;
            return this;
        }

        public Builder setAttachmentId(String str) {
            this.attachmentId = str;
            return this;
        }

        public Builder setMediaUrl(Uri uri) {
            this.mediaUrl = uri;
            return this;
        }

        public Builder setButton(ShareMessengerActionButton shareMessengerActionButton) {
            this.button = shareMessengerActionButton;
            return this;
        }

        public Builder readFrom(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
            if (shareMessengerMediaTemplateContent == null) {
                return this;
            }
            return ((Builder) super.readFrom((ShareContent) shareMessengerMediaTemplateContent)).setMediaType(shareMessengerMediaTemplateContent.getMediaType()).setAttachmentId(shareMessengerMediaTemplateContent.getAttachmentId()).setMediaUrl(shareMessengerMediaTemplateContent.getMediaUrl()).setButton(shareMessengerMediaTemplateContent.getButton());
        }

        public ShareMessengerMediaTemplateContent build() {
            return new ShareMessengerMediaTemplateContent(this);
        }
    }
}
