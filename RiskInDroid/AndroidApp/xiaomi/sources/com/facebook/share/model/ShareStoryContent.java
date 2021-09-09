package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ShareStoryContent extends ShareContent<ShareStoryContent, Builder> {
    public static final Parcelable.Creator<ShareStoryContent> CREATOR = new Parcelable.Creator<ShareStoryContent>() {
        /* class com.facebook.share.model.ShareStoryContent.AnonymousClass1 */

        public final ShareStoryContent createFromParcel(Parcel parcel) {
            return new ShareStoryContent(parcel);
        }

        public final ShareStoryContent[] newArray(int i) {
            return new ShareStoryContent[i];
        }
    };
    private final String mAttributionLink;
    private final ShareMedia mBackgroundAsset;
    private final List<String> mBackgroundColorList;
    private final SharePhoto mStickerAsset;

    public final int describeContents() {
        return 0;
    }

    private ShareStoryContent(Builder builder) {
        super(builder);
        this.mBackgroundAsset = builder.mBackgroundAsset;
        this.mStickerAsset = builder.mStickerAsset;
        this.mBackgroundColorList = builder.mBackgroundColorList;
        this.mAttributionLink = builder.mAttributionLink;
    }

    ShareStoryContent(Parcel parcel) {
        super(parcel);
        this.mBackgroundAsset = (ShareMedia) parcel.readParcelable(ShareMedia.class.getClassLoader());
        this.mStickerAsset = (SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader());
        this.mBackgroundColorList = readUnmodifiableStringList(parcel);
        this.mAttributionLink = parcel.readString();
    }

    public final ShareMedia getBackgroundAsset() {
        return this.mBackgroundAsset;
    }

    public final SharePhoto getStickerAsset() {
        return this.mStickerAsset;
    }

    public final List<String> getBackgroundColorList() {
        List<String> list = this.mBackgroundColorList;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public final String getAttributionLink() {
        return this.mAttributionLink;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.mBackgroundAsset, 0);
        parcel.writeParcelable(this.mStickerAsset, 0);
        parcel.writeStringList(this.mBackgroundColorList);
        parcel.writeString(this.mAttributionLink);
    }

    private List<String> readUnmodifiableStringList(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        if (arrayList.isEmpty()) {
            return null;
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static final class Builder extends ShareContent.Builder<ShareStoryContent, Builder> {
        static final String TAG = "Builder";
        public String mAttributionLink;
        public ShareMedia mBackgroundAsset;
        public List<String> mBackgroundColorList;
        public SharePhoto mStickerAsset;

        public final Builder setBackgroundAsset(ShareMedia shareMedia) {
            this.mBackgroundAsset = shareMedia;
            return this;
        }

        public final Builder setStickerAsset(SharePhoto sharePhoto) {
            this.mStickerAsset = sharePhoto;
            return this;
        }

        public final Builder setBackgroundColorList(List<String> list) {
            this.mBackgroundColorList = list;
            return this;
        }

        public final Builder setAttributionLink(String str) {
            this.mAttributionLink = str;
            return this;
        }

        public final ShareStoryContent build() {
            return new ShareStoryContent(this);
        }

        public final Builder readFrom(ShareStoryContent shareStoryContent) {
            if (shareStoryContent == null) {
                return this;
            }
            return ((Builder) super.readFrom((ShareContent) shareStoryContent)).setBackgroundAsset(shareStoryContent.getBackgroundAsset()).setStickerAsset(shareStoryContent.getStickerAsset()).setBackgroundColorList(shareStoryContent.getBackgroundColorList()).setAttributionLink(shareStoryContent.getAttributionLink());
        }
    }
}
