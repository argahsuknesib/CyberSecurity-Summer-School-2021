package com.xiaomi.accountsdk.account.data;

import android.os.Parcel;
import android.os.Parcelable;

public class NotificationAuthResult implements Parcelable {
    public static final Parcelable.Creator<NotificationAuthResult> CREATOR = new Parcelable.Creator<NotificationAuthResult>() {
        /* class com.xiaomi.accountsdk.account.data.NotificationAuthResult.AnonymousClass1 */

        public final NotificationAuthResult createFromParcel(Parcel parcel) {
            return new NotificationAuthResult(parcel);
        }

        public final NotificationAuthResult[] newArray(int i) {
            return new NotificationAuthResult[i];
        }
    };
    public String pSecurity_ph;
    public String pSecurity_slh;
    public String serviceToken;
    public String userId;

    public int describeContents() {
        return 0;
    }

    public static class Builder {
        private String pSecurity_ph;
        private String pSecurity_slh;
        private String serviceToken;
        private String userId;

        public Builder setUserId(String str) {
            this.userId = str;
            return this;
        }

        public Builder setServiceToken(String str) {
            this.serviceToken = str;
            return this;
        }

        public Builder setPSecurity_ph(String str) {
            this.pSecurity_ph = str;
            return this;
        }

        public Builder setPSecurity_slh(String str) {
            this.pSecurity_slh = str;
            return this;
        }

        public NotificationAuthResult build() {
            return new NotificationAuthResult(this.userId, this.serviceToken, this.pSecurity_ph, this.pSecurity_slh);
        }
    }

    private NotificationAuthResult(String str, String str2, String str3, String str4) {
        this.userId = str;
        this.serviceToken = str2;
        this.pSecurity_ph = str3;
        this.pSecurity_slh = str4;
    }

    public NotificationAuthResult(Parcel parcel) {
        this.userId = parcel.readString();
        this.serviceToken = parcel.readString();
        this.pSecurity_ph = parcel.readString();
        this.pSecurity_slh = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.userId);
        parcel.writeString(this.serviceToken);
        parcel.writeString(this.pSecurity_ph);
        parcel.writeString(this.pSecurity_slh);
    }
}
