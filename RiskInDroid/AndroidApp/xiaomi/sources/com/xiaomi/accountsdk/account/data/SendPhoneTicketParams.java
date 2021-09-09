package com.xiaomi.accountsdk.account.data;

import android.app.Application;
import com.xiaomi.accountsdk.account.XMPassportSettings;

public class SendPhoneTicketParams {
    public final String action;
    public final ActivatorPhoneInfo activatorPhoneInfo;
    public final String activatorToken;
    public final String captCode;
    public final String captIck;
    public final String deviceId;
    public final String phone;
    public final String phoneHash;
    public final String region;
    public final String serviceId;
    public final String token;

    private SendPhoneTicketParams(Builder builder) {
        this.phone = builder.phone;
        this.activatorPhoneInfo = builder.activatorPhoneInfo;
        ActivatorPhoneInfo activatorPhoneInfo2 = this.activatorPhoneInfo;
        String str = null;
        this.phoneHash = activatorPhoneInfo2 != null ? activatorPhoneInfo2.phoneHash : null;
        ActivatorPhoneInfo activatorPhoneInfo3 = this.activatorPhoneInfo;
        this.activatorToken = activatorPhoneInfo3 != null ? activatorPhoneInfo3.activatorToken : str;
        this.deviceId = builder.deviceId;
        this.serviceId = builder.serviceId;
        this.captCode = builder.captCode;
        this.captIck = builder.captIck;
        this.region = builder.region;
        this.token = builder.token;
        this.action = builder.action;
    }

    public static Builder copyFrom(SendPhoneTicketParams sendPhoneTicketParams) {
        if (sendPhoneTicketParams == null) {
            return null;
        }
        return new Builder().phone(sendPhoneTicketParams.phone).phoneHashActivatorToken(sendPhoneTicketParams.activatorPhoneInfo).serviceId(sendPhoneTicketParams.serviceId).deviceId(sendPhoneTicketParams.deviceId).captchaCode(sendPhoneTicketParams.captCode, sendPhoneTicketParams.captIck).region(sendPhoneTicketParams.region).action(sendPhoneTicketParams.token).token(sendPhoneTicketParams.action);
    }

    public static class Builder {
        public String action;
        public ActivatorPhoneInfo activatorPhoneInfo;
        public String captCode;
        public String captIck;
        public String deviceId;
        public String phone;
        public String region;
        public String serviceId;
        public String token;

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public Builder phoneHashActivatorToken(ActivatorPhoneInfo activatorPhoneInfo2) {
            this.activatorPhoneInfo = activatorPhoneInfo2;
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

        public Builder captchaCode(String str, String str2) {
            this.captCode = str;
            this.captIck = str2;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder action(String str) {
            this.action = str;
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

        public SendPhoneTicketParams build() {
            return new SendPhoneTicketParams(this);
        }
    }
}
