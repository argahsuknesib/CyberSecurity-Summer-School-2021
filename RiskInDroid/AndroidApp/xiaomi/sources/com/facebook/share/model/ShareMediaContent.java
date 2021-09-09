package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.ShareVideo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ShareMediaContent extends ShareContent<ShareMediaContent, Builder> {
    public static final Parcelable.Creator<ShareMediaContent> CREATOR = new Parcelable.Creator<ShareMediaContent>() {
        /* class com.facebook.share.model.ShareMediaContent.AnonymousClass1 */

        public final ShareMediaContent createFromParcel(Parcel parcel) {
            return new ShareMediaContent(parcel);
        }

        public final ShareMediaContent[] newArray(int i) {
            return new ShareMediaContent[i];
        }
    };
    private final List<ShareMedia> media;

    public final int describeContents() {
        return 0;
    }

    private ShareMediaContent(Builder builder) {
        super(builder);
        this.media = Collections.unmodifiableList(builder.media);
    }

    ShareMediaContent(Parcel parcel) {
        super(parcel);
        this.media = Arrays.asList((ShareMedia[]) parcel.readParcelableArray(ShareMedia.class.getClassLoader()));
    }

    public final List<ShareMedia> getMedia() {
        return this.media;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelableArray((ShareMedia[]) this.media.toArray(), i);
    }

    public static class Builder extends ShareContent.Builder<ShareMediaContent, Builder> {
        public final List<ShareMedia> media = new ArrayList();

        public Builder addMedium(ShareMedia shareMedia) {
            Object obj;
            if (shareMedia != null) {
                if (shareMedia instanceof SharePhoto) {
                    obj = new SharePhoto.Builder().readFrom((SharePhoto) shareMedia).build();
                } else if (shareMedia instanceof ShareVideo) {
                    obj = new ShareVideo.Builder().readFrom((ShareVideo) shareMedia).build();
                } else {
                    throw new IllegalArgumentException("medium must be either a SharePhoto or ShareVideo");
                }
                this.media.add(obj);
            }
            return this;
        }

        public Builder addMedia(List<ShareMedia> list) {
            if (list != null) {
                for (ShareMedia addMedium : list) {
                    addMedium(addMedium);
                }
            }
            return this;
        }

        public ShareMediaContent build() {
            return new ShareMediaContent(this);
        }

        public Builder readFrom(ShareMediaContent shareMediaContent) {
            if (shareMediaContent == null) {
                return this;
            }
            return ((Builder) super.readFrom((ShareContent) shareMediaContent)).addMedia(shareMediaContent.getMedia());
        }

        public Builder setMedia(List<ShareMedia> list) {
            this.media.clear();
            addMedia(list);
            return this;
        }
    }
}
