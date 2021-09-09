package com.xiaomi.accountsdk.account.data;

import android.app.Application;
import com.xiaomi.accountsdk.account.XMPassportSettings;

public class CheckRegPhoneParams {
    public final String deviceId;
    public final String hashedSimId;
    public final String phone;
    public final String region;
    public final String ticket;
    public final String vKey2;
    public final String vKey2Nonce;

    private CheckRegPhoneParams(Builder builder) {
        this.phone = builder.phone;
        this.ticket = builder.ticket;
        this.hashedSimId = builder.hashedSimId;
        this.vKey2 = builder.vKey2;
        this.vKey2Nonce = builder.vKey2Nonce;
        this.deviceId = builder.deviceId;
        this.region = builder.region;
    }

    public static class Builder {
        public String deviceId;
        public String hashedSimId;
        public String phone;
        public String region;
        public String ticket;
        public String vKey2;
        public String vKey2Nonce;

        public Builder phoneTicket(String str, String str2) {
            this.phone = str;
            this.ticket = str2;
            return this;
        }

        public Builder activatedPhone(String str, String str2, String str3) {
            this.hashedSimId = str;
            this.vKey2 = str2;
            this.vKey2Nonce = str3;
            return this;
        }

        public Builder deviceId(String str) {
            this.deviceId = str;
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

        public CheckRegPhoneParams build() {
            return new CheckRegPhoneParams(this);
        }
    }
}
