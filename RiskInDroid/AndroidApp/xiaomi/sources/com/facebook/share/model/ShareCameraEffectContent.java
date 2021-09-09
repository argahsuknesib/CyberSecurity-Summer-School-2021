package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.CameraEffectArguments;
import com.facebook.share.model.CameraEffectTextures;
import com.facebook.share.model.ShareContent;

public class ShareCameraEffectContent extends ShareContent<ShareCameraEffectContent, Builder> {
    public static final Parcelable.Creator<ShareCameraEffectContent> CREATOR = new Parcelable.Creator<ShareCameraEffectContent>() {
        /* class com.facebook.share.model.ShareCameraEffectContent.AnonymousClass1 */

        public final ShareCameraEffectContent createFromParcel(Parcel parcel) {
            return new ShareCameraEffectContent(parcel);
        }

        public final ShareCameraEffectContent[] newArray(int i) {
            return new ShareCameraEffectContent[i];
        }
    };
    private CameraEffectArguments arguments;
    private String effectId;
    private CameraEffectTextures textures;

    private ShareCameraEffectContent(Builder builder) {
        super(builder);
        this.effectId = builder.effectId;
        this.arguments = builder.arguments;
        this.textures = builder.textures;
    }

    ShareCameraEffectContent(Parcel parcel) {
        super(parcel);
        this.effectId = parcel.readString();
        this.arguments = new CameraEffectArguments.Builder().readFrom(parcel).build();
        this.textures = new CameraEffectTextures.Builder().readFrom(parcel).build();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.effectId);
        parcel.writeParcelable(this.arguments, 0);
        parcel.writeParcelable(this.textures, 0);
    }

    public String getEffectId() {
        return this.effectId;
    }

    public CameraEffectArguments getArguments() {
        return this.arguments;
    }

    public CameraEffectTextures getTextures() {
        return this.textures;
    }

    public static final class Builder extends ShareContent.Builder<ShareCameraEffectContent, Builder> {
        public CameraEffectArguments arguments;
        public String effectId;
        public CameraEffectTextures textures;

        public final Builder setEffectId(String str) {
            this.effectId = str;
            return this;
        }

        public final Builder setArguments(CameraEffectArguments cameraEffectArguments) {
            this.arguments = cameraEffectArguments;
            return this;
        }

        public final Builder setTextures(CameraEffectTextures cameraEffectTextures) {
            this.textures = cameraEffectTextures;
            return this;
        }

        public final ShareCameraEffectContent build() {
            return new ShareCameraEffectContent(this);
        }

        public final Builder readFrom(ShareCameraEffectContent shareCameraEffectContent) {
            if (shareCameraEffectContent == null) {
                return this;
            }
            return ((Builder) super.readFrom((ShareContent) shareCameraEffectContent)).setEffectId(this.effectId).setArguments(this.arguments);
        }
    }
}
