package com.xiaomi.accountsdk.account.data;

public class PassTokenLoginParams {
    public final String deviceId;
    public final boolean isGetPhoneTicketLoginMetaData;
    public final String loginRequestUrl;
    public final String packageName;
    public final String passToken;
    public final boolean returnStsUrl;
    public final String serviceId;
    public final String uDevId;
    public final String userId;

    private PassTokenLoginParams(Builder builder) {
        this.userId = builder.userId;
        this.passToken = builder.passToken;
        this.serviceId = builder.serviceId;
        this.loginRequestUrl = builder.loginRequestUrl;
        this.deviceId = builder.deviceId;
        this.uDevId = builder.uDevId;
        this.returnStsUrl = builder.returnStsUrl;
        this.isGetPhoneTicketLoginMetaData = builder.isGetPhoneTicketLoginMetaData;
        this.packageName = builder.packageName;
    }

    public static Builder buildUpon(PassTokenLoginParams passTokenLoginParams) {
        return new Builder().userId(passTokenLoginParams.userId).passToken(passTokenLoginParams.passToken).serviceId(passTokenLoginParams.serviceId).loginRequestUrl(passTokenLoginParams.loginRequestUrl).deviceId(passTokenLoginParams.deviceId).uDevId(passTokenLoginParams.uDevId).isReturnStsUrl(passTokenLoginParams.returnStsUrl).isGetPhoneTicketLoginMetaData(passTokenLoginParams.isGetPhoneTicketLoginMetaData).packageName(passTokenLoginParams.packageName);
    }

    public static class Builder {
        public String deviceId;
        public boolean isGetPhoneTicketLoginMetaData = false;
        public String loginRequestUrl;
        public String packageName;
        public String passToken;
        public boolean returnStsUrl = false;
        public String serviceId;
        public String uDevId;
        public String userId;

        public Builder userId(String str) {
            this.userId = str;
            return this;
        }

        public Builder passToken(String str) {
            this.passToken = str;
            return this;
        }

        public Builder serviceId(String str) {
            this.serviceId = str;
            return this;
        }

        public Builder loginRequestUrl(String str) {
            this.loginRequestUrl = str;
            return this;
        }

        public Builder deviceId(String str) {
            this.deviceId = str;
            return this;
        }

        public Builder uDevId(String str) {
            this.uDevId = str;
            return this;
        }

        public Builder packageName(String str) {
            this.packageName = str;
            return this;
        }

        public Builder isReturnStsUrl(boolean z) {
            this.returnStsUrl = z;
            return this;
        }

        public Builder isGetPhoneTicketLoginMetaData(boolean z) {
            this.isGetPhoneTicketLoginMetaData = z;
            return this;
        }

        public PassTokenLoginParams build() {
            return new PassTokenLoginParams(this);
        }
    }
}
