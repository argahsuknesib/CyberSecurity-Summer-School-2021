package com.xiaomi.accountsdk.account.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class Step2LoginParams implements Parcelable {
    public static final Parcelable.Creator<Step2LoginParams> CREATOR = new Parcelable.Creator<Step2LoginParams>() {
        /* class com.xiaomi.accountsdk.account.data.Step2LoginParams.AnonymousClass1 */

        public final Step2LoginParams createFromParcel(Parcel parcel) {
            return new Step2LoginParams(parcel);
        }

        public final Step2LoginParams[] newArray(int i) {
            return new Step2LoginParams[i];
        }
    };
    public String deviceId;
    public final MetaLoginData metaLoginData;
    public boolean returnStsUrl;
    public final String serviceId;
    public final String step1Token;
    public final String step2code;
    public final boolean trust;
    public final String userId;

    public int describeContents() {
        return 0;
    }

    public static class Builder {
        public String deviceId;
        public MetaLoginData metaLoginData;
        public boolean returnStsUrl;
        public String serviceId;
        public String step1Token;
        public String step2code;
        public boolean trust;
        public String userId;

        public Builder setUserId(String str) {
            this.userId = str;
            return this;
        }

        public Builder setStep1Token(String str) {
            this.step1Token = str;
            return this;
        }

        public Builder setServiceId(String str) {
            this.serviceId = str;
            return this;
        }

        public Builder setStep2code(String str) {
            this.step2code = str;
            return this;
        }

        public Builder setMetaLoginData(MetaLoginData metaLoginData2) {
            this.metaLoginData = metaLoginData2;
            return this;
        }

        public Builder setTrust(boolean z) {
            this.trust = z;
            return this;
        }

        public Builder setDeviceId(String str) {
            this.deviceId = str;
            return this;
        }

        public Builder setReturnStsUrl(boolean z) {
            this.returnStsUrl = z;
            return this;
        }

        public Step2LoginParams build() {
            return new Step2LoginParams(this);
        }
    }

    private Step2LoginParams(Builder builder) {
        this.userId = builder.userId;
        this.serviceId = builder.serviceId;
        this.step1Token = builder.step1Token;
        this.step2code = builder.step2code;
        this.metaLoginData = builder.metaLoginData;
        this.trust = builder.trust;
        this.returnStsUrl = builder.returnStsUrl;
        this.deviceId = builder.deviceId;
    }

    public Step2LoginParams(Parcel parcel) {
        this.userId = parcel.readString();
        this.serviceId = parcel.readString();
        this.step1Token = parcel.readString();
        this.step2code = parcel.readString();
        this.trust = parcel.readInt() != 0;
        this.metaLoginData = (MetaLoginData) parcel.readParcelable(MetaLoginData.class.getClassLoader());
        Bundle readBundle = parcel.readBundle();
        if (readBundle != null) {
            this.returnStsUrl = readBundle.getBoolean("returnStsUrl", false);
            this.deviceId = readBundle.getString("deviceId");
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.userId);
        parcel.writeString(this.serviceId);
        parcel.writeString(this.step1Token);
        parcel.writeString(this.step2code);
        parcel.writeInt(this.trust ? 1 : 0);
        parcel.writeParcelable(this.metaLoginData, i);
        Bundle bundle = new Bundle();
        bundle.putBoolean("returnStsUrl", this.returnStsUrl);
        bundle.putString("deviceId", this.deviceId);
        parcel.writeBundle(bundle);
    }
}
