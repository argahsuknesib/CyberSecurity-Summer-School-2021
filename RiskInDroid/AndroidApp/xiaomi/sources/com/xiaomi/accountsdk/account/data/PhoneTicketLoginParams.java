package com.xiaomi.accountsdk.account.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class PhoneTicketLoginParams implements Parcelable {
    public static final Parcelable.Creator<PhoneTicketLoginParams> CREATOR = new Parcelable.Creator<PhoneTicketLoginParams>() {
        /* class com.xiaomi.accountsdk.account.data.PhoneTicketLoginParams.AnonymousClass1 */

        public final PhoneTicketLoginParams createFromParcel(Parcel parcel) {
            Bundle readBundle = parcel.readBundle();
            if (readBundle == null) {
                return null;
            }
            String string = readBundle.getString("phone");
            String string2 = readBundle.getString("ticket_token");
            ActivatorPhoneInfo activatorPhoneInfo = (ActivatorPhoneInfo) readBundle.getParcelable("activator_phone_info");
            return new Builder().phoneTicketToken(string, string2).verifiedActivatorPhone(activatorPhoneInfo).activatorPhoneTicket(activatorPhoneInfo, readBundle.getString("ticket")).deviceId(readBundle.getString("device_id")).serviceId(readBundle.getString("service_id")).hashedEnvFactors(readBundle.getStringArray("hash_env")).returnStsUrl(readBundle.getBoolean("return_sts_url", false)).build();
        }

        public final PhoneTicketLoginParams[] newArray(int i) {
            return new PhoneTicketLoginParams[0];
        }
    };
    public final ActivatorPhoneInfo activatorPhoneInfo;
    public final String activatorToken;
    public final String deviceId;
    public final String[] hashedEnvFactors;
    public final String phone;
    public final String phoneHash;
    public final boolean returnStsUrl;
    public final String serviceId;
    public final String ticket;
    public final String ticketToken;

    public int describeContents() {
        return 0;
    }

    private PhoneTicketLoginParams(Builder builder) {
        this.phone = builder.phone;
        this.ticketToken = builder.ticketToken;
        this.activatorPhoneInfo = builder.activatorPhoneInfo;
        ActivatorPhoneInfo activatorPhoneInfo2 = this.activatorPhoneInfo;
        String str = null;
        this.phoneHash = activatorPhoneInfo2 != null ? activatorPhoneInfo2.phoneHash : null;
        ActivatorPhoneInfo activatorPhoneInfo3 = this.activatorPhoneInfo;
        this.activatorToken = activatorPhoneInfo3 != null ? activatorPhoneInfo3.activatorToken : str;
        this.ticket = builder.ticket;
        this.deviceId = builder.deviceId;
        this.serviceId = builder.serviceId;
        this.hashedEnvFactors = builder.hashedEnvFactors;
        this.returnStsUrl = builder.returnStsUrl;
    }

    public static Builder copyFrom(PhoneTicketLoginParams phoneTicketLoginParams) {
        if (phoneTicketLoginParams == null) {
            return null;
        }
        return new Builder().phoneTicketToken(phoneTicketLoginParams.phone, phoneTicketLoginParams.ticketToken).verifiedActivatorPhone(phoneTicketLoginParams.activatorPhoneInfo).activatorPhoneTicket(phoneTicketLoginParams.activatorPhoneInfo, phoneTicketLoginParams.ticket).deviceId(phoneTicketLoginParams.deviceId).serviceId(phoneTicketLoginParams.serviceId).hashedEnvFactors(phoneTicketLoginParams.hashedEnvFactors).returnStsUrl(phoneTicketLoginParams.returnStsUrl);
    }

    public static class Builder {
        public ActivatorPhoneInfo activatorPhoneInfo;
        public String deviceId;
        public String[] hashedEnvFactors;
        public String phone;
        public boolean returnStsUrl = false;
        public String serviceId;
        public String ticket;
        public String ticketToken;

        public Builder phoneTicketToken(String str, String str2) {
            this.phone = str;
            this.ticketToken = str2;
            return this;
        }

        public Builder verifiedActivatorPhone(ActivatorPhoneInfo activatorPhoneInfo2) {
            this.activatorPhoneInfo = activatorPhoneInfo2;
            return this;
        }

        public Builder activatorPhoneTicket(ActivatorPhoneInfo activatorPhoneInfo2, String str) {
            this.activatorPhoneInfo = activatorPhoneInfo2;
            this.ticket = str;
            return this;
        }

        public Builder deviceId(String str) {
            this.deviceId = str;
            return this;
        }

        public Builder serviceId(String str) {
            this.serviceId = str;
            return this;
        }

        public Builder hashedEnvFactors(String[] strArr) {
            this.hashedEnvFactors = strArr;
            return this;
        }

        public Builder returnStsUrl(boolean z) {
            this.returnStsUrl = z;
            return this;
        }

        public PhoneTicketLoginParams build() {
            return new PhoneTicketLoginParams(this);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("phone", this.phone);
        bundle.putString("ticket_token", this.ticketToken);
        bundle.putParcelable("activator_phone_info", this.activatorPhoneInfo);
        bundle.putString("ticket", this.ticket);
        bundle.putString("device_id", this.deviceId);
        bundle.putString("service_id", this.serviceId);
        bundle.putStringArray("hash_env", this.hashedEnvFactors);
        bundle.putBoolean("return_sts_url", this.returnStsUrl);
        parcel.writeBundle(bundle);
    }
}
