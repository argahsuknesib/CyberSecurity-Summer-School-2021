package com.xiaomi.accountsdk.account.data;

import android.app.Application;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.accountsdk.account.XMPassportSettings;

public class PhoneTokenRegisterParams implements Parcelable {
    public static final Parcelable.Creator<PhoneTokenRegisterParams> CREATOR = new Parcelable.Creator<PhoneTokenRegisterParams>() {
        /* class com.xiaomi.accountsdk.account.data.PhoneTokenRegisterParams.AnonymousClass1 */

        public final PhoneTokenRegisterParams createFromParcel(Parcel parcel) {
            Bundle readBundle = parcel.readBundle();
            if (readBundle == null) {
                return null;
            }
            String string = readBundle.getString("phone");
            String string2 = readBundle.getString("password");
            String string3 = readBundle.getString("ticket_token");
            String string4 = readBundle.getString("region");
            return new Builder().phoneTicketToken(string, string3).phoneHashActivatorToken((ActivatorPhoneInfo) readBundle.getParcelable("activator_phone_info")).password(string2).region(string4).serviceId(readBundle.getString("service_id")).build();
        }

        public final PhoneTokenRegisterParams[] newArray(int i) {
            return new PhoneTokenRegisterParams[0];
        }
    };
    public final ActivatorPhoneInfo activatorPhoneInfo;
    public final String activatorToken;
    public final boolean noPwd;
    public final String password;
    public final String phone;
    public final String phoneHash;
    public final String region;
    public final String serviceId;
    public final String ticketToken;

    public int describeContents() {
        return 0;
    }

    private PhoneTokenRegisterParams(Builder builder) {
        this.phone = builder.phone;
        this.ticketToken = builder.ticketToken;
        this.activatorPhoneInfo = builder.activatorPhoneInfo;
        ActivatorPhoneInfo activatorPhoneInfo2 = this.activatorPhoneInfo;
        String str = null;
        this.phoneHash = activatorPhoneInfo2 != null ? activatorPhoneInfo2.phoneHash : null;
        ActivatorPhoneInfo activatorPhoneInfo3 = this.activatorPhoneInfo;
        this.activatorToken = activatorPhoneInfo3 != null ? activatorPhoneInfo3.activatorToken : str;
        this.password = builder.password;
        this.noPwd = builder.noPwd;
        this.region = builder.region;
        this.serviceId = builder.serviceId;
    }

    public static Builder copyFrom(PhoneTokenRegisterParams phoneTokenRegisterParams) {
        if (phoneTokenRegisterParams == null) {
            return null;
        }
        return new Builder().phoneTicketToken(phoneTokenRegisterParams.phone, phoneTokenRegisterParams.ticketToken).phoneHashActivatorToken(phoneTokenRegisterParams.activatorPhoneInfo).password(phoneTokenRegisterParams.password).region(phoneTokenRegisterParams.region).serviceId(phoneTokenRegisterParams.serviceId);
    }

    public static class Builder {
        public ActivatorPhoneInfo activatorPhoneInfo;
        public boolean noPwd;
        public String password;
        public String phone;
        public String region;
        public String serviceId;
        public String ticketToken;

        public Builder phoneTicketToken(String str, String str2) {
            this.phone = str;
            this.ticketToken = str2;
            return this;
        }

        public Builder phoneHashActivatorToken(ActivatorPhoneInfo activatorPhoneInfo2) {
            this.activatorPhoneInfo = activatorPhoneInfo2;
            return this;
        }

        public Builder password(String str) {
            this.password = str;
            return this;
        }

        public Builder region(String str) {
            this.region = str;
            return this;
        }

        public Builder application(Application application) {
            XMPassportSettings.setApplicationContext(application);
            return this;
        }

        public Builder serviceId(String str) {
            this.serviceId = str;
            return this;
        }

        public PhoneTokenRegisterParams build() {
            this.noPwd = TextUtils.isEmpty(this.password);
            return new PhoneTokenRegisterParams(this);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("phone", this.phone);
        bundle.putString("ticket_token", this.ticketToken);
        bundle.putParcelable("activator_phone_info", this.activatorPhoneInfo);
        bundle.putString("password", this.password);
        bundle.putString("region", this.region);
        bundle.putBoolean("is_no_password", this.noPwd);
        bundle.putString("password", this.password);
        bundle.putString("region", this.region);
        bundle.putString("service_id", this.serviceId);
        parcel.writeBundle(bundle);
    }
}
