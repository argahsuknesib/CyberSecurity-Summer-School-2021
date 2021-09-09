package com.xiaomi.accountsdk.account.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class PasswordLoginParams implements Parcelable {
    public static final Parcelable.Creator<PasswordLoginParams> CREATOR = new Parcelable.Creator<PasswordLoginParams>() {
        /* class com.xiaomi.accountsdk.account.data.PasswordLoginParams.AnonymousClass1 */

        public final PasswordLoginParams createFromParcel(Parcel parcel) {
            return new PasswordLoginParams(parcel);
        }

        public final PasswordLoginParams[] newArray(int i) {
            return new PasswordLoginParams[i];
        }
    };
    public ActivatorPhoneInfo activatorPhoneInfo;
    public final String captCode;
    public final String captIck;
    public String countryCode;
    public String deviceId;
    public String[] hashedEnvFactors;
    public MetaLoginData metaLoginData;
    public boolean needProcessNotification;
    public final String password;
    public boolean returnStsUrl;
    public final String serviceId;
    public String ticketToken;
    public final String userId;

    public int describeContents() {
        return 0;
    }

    public static class Builder {
        public ActivatorPhoneInfo activatorPhoneInfo;
        public String captCode;
        public String captIck;
        public String countryCode;
        public String deviceId;
        public String[] hashedEnvFactors;
        public MetaLoginData metaLoginData;
        public boolean needProcessNotification = true;
        public String password;
        public boolean returnStsUrl = false;
        public String serviceId;
        public String ticketToken;
        public String userId;

        public Builder setUserId(String str) {
            this.userId = str;
            return this;
        }

        public Builder setPassword(String str) {
            this.password = str;
            return this;
        }

        public Builder setServiceId(String str) {
            this.serviceId = str;
            return this;
        }

        public Builder setCaptCode(String str) {
            this.captCode = str;
            return this;
        }

        public Builder setCaptIck(String str) {
            this.captIck = str;
            return this;
        }

        public Builder setDeviceId(String str) {
            this.deviceId = str;
            return this;
        }

        public Builder setTicketToken(String str) {
            this.ticketToken = str;
            return this;
        }

        public Builder setMetaLoginData(MetaLoginData metaLoginData2) {
            this.metaLoginData = metaLoginData2;
            return this;
        }

        public Builder setIsReturnStsUrl(boolean z) {
            this.returnStsUrl = z;
            return this;
        }

        public Builder setNeedProcessNotification(boolean z) {
            this.needProcessNotification = z;
            return this;
        }

        public Builder setHashedEnvFactors(String[] strArr) {
            this.hashedEnvFactors = strArr;
            return this;
        }

        public Builder setActivatorPhone(ActivatorPhoneInfo activatorPhoneInfo2) {
            this.activatorPhoneInfo = activatorPhoneInfo2;
            return this;
        }

        public Builder setCountryCode(String str) {
            this.countryCode = str;
            return this;
        }

        public PasswordLoginParams build() {
            return new PasswordLoginParams(this);
        }
    }

    public static Builder copyFrom(PasswordLoginParams passwordLoginParams) {
        if (passwordLoginParams == null) {
            return null;
        }
        return new Builder().setUserId(passwordLoginParams.userId).setPassword(passwordLoginParams.password).setServiceId(passwordLoginParams.serviceId).setCaptCode(passwordLoginParams.captCode).setCaptIck(passwordLoginParams.captIck).setDeviceId(passwordLoginParams.deviceId).setTicketToken(passwordLoginParams.ticketToken).setMetaLoginData(passwordLoginParams.metaLoginData).setIsReturnStsUrl(passwordLoginParams.returnStsUrl).setNeedProcessNotification(passwordLoginParams.needProcessNotification).setHashedEnvFactors(passwordLoginParams.hashedEnvFactors).setCountryCode(passwordLoginParams.countryCode).setActivatorPhone(passwordLoginParams.activatorPhoneInfo);
    }

    private PasswordLoginParams(Builder builder) {
        this.userId = builder.userId;
        this.password = builder.password;
        this.serviceId = builder.serviceId;
        this.captCode = builder.captCode;
        this.captIck = builder.captIck;
        this.deviceId = builder.deviceId;
        this.ticketToken = builder.ticketToken;
        this.metaLoginData = builder.metaLoginData;
        this.returnStsUrl = builder.returnStsUrl;
        this.needProcessNotification = builder.needProcessNotification;
        this.hashedEnvFactors = builder.hashedEnvFactors;
        this.activatorPhoneInfo = builder.activatorPhoneInfo;
        this.countryCode = builder.countryCode;
    }

    public PasswordLoginParams(Parcel parcel) {
        this.userId = parcel.readString();
        this.password = parcel.readString();
        this.serviceId = parcel.readString();
        this.captCode = parcel.readString();
        this.captIck = parcel.readString();
        Bundle readBundle = parcel.readBundle();
        if (readBundle != null) {
            this.deviceId = readBundle.getString("deviceId");
            this.ticketToken = readBundle.getString("ticketToken");
            this.metaLoginData = (MetaLoginData) readBundle.getParcelable("metaLoginData");
            this.returnStsUrl = readBundle.getBoolean("returnStsUrl", false);
            this.needProcessNotification = readBundle.getBoolean("needProcessNotification", true);
            this.hashedEnvFactors = readBundle.getStringArray("hashedEnvFactors");
            this.activatorPhoneInfo = (ActivatorPhoneInfo) readBundle.getParcelable("activatorPhoneInfo");
            this.countryCode = readBundle.getString("countryCode");
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.userId);
        parcel.writeString(this.password);
        parcel.writeString(this.serviceId);
        parcel.writeString(this.captCode);
        parcel.writeString(this.captIck);
        Bundle bundle = new Bundle();
        bundle.putString("deviceId", this.deviceId);
        bundle.putString("ticketToken", this.ticketToken);
        bundle.putParcelable("metaLoginData", this.metaLoginData);
        bundle.putBoolean("returnStsUrl", this.returnStsUrl);
        bundle.putBoolean("needProcessNotification", this.needProcessNotification);
        bundle.putStringArray("hashedEnvFactors", this.hashedEnvFactors);
        bundle.putParcelable("activatorPhoneInfo", this.activatorPhoneInfo);
        bundle.putString("countryCode", this.countryCode);
        parcel.writeBundle(bundle);
    }
}
