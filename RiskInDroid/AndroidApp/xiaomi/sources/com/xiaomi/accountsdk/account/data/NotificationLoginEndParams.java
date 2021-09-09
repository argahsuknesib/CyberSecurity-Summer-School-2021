package com.xiaomi.accountsdk.account.data;

import android.os.Parcel;
import android.os.Parcelable;

public class NotificationLoginEndParams implements Parcelable {
    public static final Parcelable.Creator<NotificationLoginEndParams> CREATOR = new Parcelable.Creator<NotificationLoginEndParams>() {
        /* class com.xiaomi.accountsdk.account.data.NotificationLoginEndParams.AnonymousClass1 */

        public final NotificationLoginEndParams createFromParcel(Parcel parcel) {
            return new NotificationLoginEndParams(parcel);
        }

        public final NotificationLoginEndParams[] newArray(int i) {
            return new NotificationLoginEndParams[i];
        }
    };
    public final String passToken;
    public final String serviceId;
    public final String userId;

    public int describeContents() {
        return 0;
    }

    public static class Builder {
        private String passToken;
        private String serviceId;
        private String userId;

        public Builder setUserId(String str) {
            this.userId = str;
            return this;
        }

        public Builder setPassToken(String str) {
            this.passToken = str;
            return this;
        }

        public Builder setServiceId(String str) {
            this.serviceId = str;
            return this;
        }

        public NotificationLoginEndParams build() {
            return new NotificationLoginEndParams(this.userId, this.passToken, this.serviceId);
        }
    }

    private NotificationLoginEndParams(String str, String str2, String str3) {
        this.userId = str;
        this.passToken = str2;
        this.serviceId = str3;
    }

    public NotificationLoginEndParams(Parcel parcel) {
        this.userId = parcel.readString();
        this.passToken = parcel.readString();
        this.serviceId = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.userId);
        parcel.writeString(this.passToken);
        parcel.writeString(this.serviceId);
    }
}
