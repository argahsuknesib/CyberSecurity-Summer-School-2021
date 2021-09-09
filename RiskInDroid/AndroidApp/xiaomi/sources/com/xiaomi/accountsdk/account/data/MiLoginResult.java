package com.xiaomi.accountsdk.account.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.accountsdk.account.ServerError;

public class MiLoginResult implements Parcelable {
    public static final Parcelable.Creator<MiLoginResult> CREATOR = new Parcelable.Creator<MiLoginResult>() {
        /* class com.xiaomi.accountsdk.account.data.MiLoginResult.AnonymousClass1 */

        public final MiLoginResult createFromParcel(Parcel parcel) {
            return new MiLoginResult(parcel);
        }

        public final MiLoginResult[] newArray(int i) {
            return new MiLoginResult[i];
        }
    };
    @Deprecated
    public static final int ERROR_SSL_HAND_SHAKE = 10;
    public final AccountInfo accountInfo;
    public final String captchaUrl;
    public final boolean hasPwd;
    public boolean isStsCallbackError;
    public final MetaLoginData metaLoginData;
    public final String notificationUrl;
    public final int resultCode;
    public ServerError serverError;
    public final String serviceId;
    public final String step1Token;
    public final String userId;

    public int describeContents() {
        return 0;
    }

    public MiLoginResult(Parcel parcel) {
        this.userId = parcel.readString();
        this.serviceId = parcel.readString();
        this.accountInfo = (AccountInfo) parcel.readParcelable(AccountInfo.class.getClassLoader());
        this.captchaUrl = parcel.readString();
        this.notificationUrl = parcel.readString();
        this.metaLoginData = (MetaLoginData) parcel.readParcelable(MetaLoginData.class.getClassLoader());
        this.step1Token = parcel.readString();
        this.resultCode = parcel.readInt();
        Bundle readBundle = parcel.readBundle();
        this.hasPwd = readBundle != null ? readBundle.getBoolean("has_pwd") : true;
        this.isStsCallbackError = readBundle != null ? readBundle.getBoolean("sts_error") : false;
        this.serverError = (ServerError) parcel.readParcelable(ServerError.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.userId);
        parcel.writeString(this.serviceId);
        parcel.writeParcelable(this.accountInfo, i);
        parcel.writeString(this.captchaUrl);
        parcel.writeString(this.notificationUrl);
        parcel.writeParcelable(this.metaLoginData, i);
        parcel.writeString(this.step1Token);
        parcel.writeInt(this.resultCode);
        Bundle bundle = new Bundle();
        bundle.putBoolean("has_pwd", this.hasPwd);
        bundle.putBoolean("sts_error", this.isStsCallbackError);
        parcel.writeBundle(bundle);
        parcel.writeParcelable(this.serverError, i);
    }

    private MiLoginResult(Builder builder) {
        this.userId = builder.userId;
        this.serviceId = builder.serviceId;
        this.accountInfo = builder.accountInfo;
        this.captchaUrl = builder.captchaUrl;
        this.notificationUrl = builder.notificationUrl;
        this.metaLoginData = builder.metaLoginData;
        this.step1Token = builder.step1Token;
        this.resultCode = builder.resultCode;
        this.hasPwd = builder.hasPwd;
        this.isStsCallbackError = builder.isStsCallbackError;
        this.serverError = builder.serverError;
    }

    public static class Builder {
        public AccountInfo accountInfo;
        public String captchaUrl;
        public boolean hasPwd;
        public boolean isStsCallbackError;
        public MetaLoginData metaLoginData;
        public String notificationUrl;
        public int resultCode;
        public ServerError serverError;
        public final String serviceId;
        public String step1Token;
        public final String userId;

        public Builder(String str, String str2) {
            this.userId = str;
            this.serviceId = str2;
        }

        public Builder setAccountInfo(AccountInfo accountInfo2) {
            this.accountInfo = accountInfo2;
            return this;
        }

        public Builder setMetaLoginData(MetaLoginData metaLoginData2) {
            this.metaLoginData = metaLoginData2;
            return this;
        }

        public Builder setStep1Token(String str) {
            this.step1Token = str;
            return this;
        }

        public Builder setCaptchaUrl(String str) {
            this.captchaUrl = str;
            return this;
        }

        public Builder setNotificationUrl(String str) {
            this.notificationUrl = str;
            return this;
        }

        public Builder setResultCode(int i) {
            this.resultCode = i;
            return this;
        }

        public Builder setHasPwd(boolean z) {
            this.hasPwd = z;
            return this;
        }

        public Builder setIsStsCallbackError(boolean z) {
            this.isStsCallbackError = z;
            return this;
        }

        public Builder setServerError(ServerError serverError2) {
            this.serverError = serverError2;
            return this;
        }

        public MiLoginResult build() {
            return new MiLoginResult(this);
        }
    }
}
