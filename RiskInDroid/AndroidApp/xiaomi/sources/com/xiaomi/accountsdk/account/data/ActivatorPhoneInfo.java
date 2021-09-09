package com.xiaomi.accountsdk.account.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class ActivatorPhoneInfo implements Parcelable {
    public static final Parcelable.Creator<ActivatorPhoneInfo> CREATOR = new Parcelable.Creator<ActivatorPhoneInfo>() {
        /* class com.xiaomi.accountsdk.account.data.ActivatorPhoneInfo.AnonymousClass1 */

        public final ActivatorPhoneInfo createFromParcel(Parcel parcel) {
            Bundle readBundle = parcel.readBundle();
            if (readBundle == null) {
                return null;
            }
            return new Builder().phone(readBundle.getString("phone")).phoneHash(readBundle.getString("phone_hash")).activatorToken(readBundle.getString("activator_token")).slotId(readBundle.getInt("slot_id")).copyWriter(readBundle.getString("copy_writer")).operatorLink(readBundle.getString("operator_link")).needVerify(readBundle.getBoolean("need_verify")).isVerified(readBundle.getBoolean("is_verified")).build();
        }

        public final ActivatorPhoneInfo[] newArray(int i) {
            return new ActivatorPhoneInfo[i];
        }
    };
    public final String activatorToken;
    public final String copyWriter;
    public final boolean isVerified;
    public final boolean needVerify;
    public final String operatorLink;
    public final String phone;
    public final String phoneHash;
    public final int slotId;

    public int describeContents() {
        return 0;
    }

    public ActivatorPhoneInfo(Builder builder) {
        this.phone = builder.phone;
        this.phoneHash = builder.phoneHash;
        this.activatorToken = builder.activatorToken;
        this.slotId = builder.slotId;
        this.copyWriter = builder.copyWriter;
        this.operatorLink = builder.operatorLink;
        this.needVerify = builder.needVerify;
        this.isVerified = builder.isVerified;
    }

    public boolean needVerifyPhone() {
        return !this.isVerified && this.needVerify;
    }

    public static final class Builder {
        public String activatorToken;
        public String copyWriter;
        public boolean isVerified = false;
        public boolean needVerify = true;
        public String operatorLink;
        public String phone;
        public String phoneHash;
        public int slotId;

        public final Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public final Builder phoneHash(String str) {
            this.phoneHash = str;
            return this;
        }

        public final Builder activatorToken(String str) {
            this.activatorToken = str;
            return this;
        }

        public final Builder slotId(int i) {
            this.slotId = i;
            return this;
        }

        public final Builder copyWriter(String str) {
            this.copyWriter = str;
            return this;
        }

        public final Builder operatorLink(String str) {
            this.operatorLink = str;
            return this;
        }

        public final Builder needVerify(boolean z) {
            this.needVerify = z;
            return this;
        }

        public final Builder isVerified(boolean z) {
            this.isVerified = z;
            return this;
        }

        public final ActivatorPhoneInfo build() {
            return new ActivatorPhoneInfo(this);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("phone", this.phone);
        bundle.putString("phone_hash", this.phoneHash);
        bundle.putString("activator_token", this.activatorToken);
        bundle.putInt("slot_id", this.slotId);
        bundle.putString("copy_writer", this.copyWriter);
        bundle.putString("operator_link", this.operatorLink);
        bundle.putBoolean("need_verify", this.needVerify);
        bundle.putBoolean("is_verified", this.isVerified);
        parcel.writeBundle(bundle);
    }
}
