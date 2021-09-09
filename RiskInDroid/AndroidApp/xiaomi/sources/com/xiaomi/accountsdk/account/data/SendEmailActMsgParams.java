package com.xiaomi.accountsdk.account.data;

public class SendEmailActMsgParams {
    public final String captIck;
    public final String captcha;
    public final String deviceId;
    public final String email;
    public final String identityAuthToken;
    public final PassportInfo passportInfo;

    private SendEmailActMsgParams(Builder builder) {
        this.passportInfo = builder.passportInfo;
        this.identityAuthToken = builder.identityAuthToken;
        this.email = builder.email;
        this.deviceId = builder.deviceId;
        this.captcha = builder.captcha;
        this.captIck = builder.captIck;
    }

    public static class Builder {
        public String captIck;
        public String captcha;
        public String deviceId;
        public String email;
        public String identityAuthToken;
        public PassportInfo passportInfo;

        public Builder passportInfo(PassportInfo passportInfo2) {
            this.passportInfo = passportInfo2;
            return this;
        }

        public Builder identityAuthToken(String str) {
            this.identityAuthToken = str;
            return this;
        }

        public Builder emailAddress(String str) {
            this.email = str;
            return this;
        }

        public Builder deviceId(String str) {
            this.deviceId = str;
            return this;
        }

        public Builder captcha(String str, String str2) {
            this.captcha = str;
            this.captIck = str2;
            return this;
        }

        public SendEmailActMsgParams build() {
            return new SendEmailActMsgParams(this);
        }
    }
}
