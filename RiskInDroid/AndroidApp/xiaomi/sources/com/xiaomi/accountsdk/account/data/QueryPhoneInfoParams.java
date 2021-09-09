package com.xiaomi.accountsdk.account.data;

public class QueryPhoneInfoParams {
    public final ActivatorPhoneInfo activatorPhoneInfo;
    public final String activatorToken;
    public final String deviceId;
    public final String phone;
    public final String phoneHash;
    public final String serviceId;
    public final String subId;
    public final String ticket;

    private QueryPhoneInfoParams(Builder builder) {
        this.phone = builder.phone;
        this.deviceId = builder.deviceId;
        this.ticket = builder.ticket;
        this.activatorToken = builder.activatorToken;
        this.phoneHash = builder.phoneHash;
        this.activatorPhoneInfo = builder.activatorPhoneInfo;
        this.serviceId = builder.serviceId;
        this.subId = builder.subId;
    }

    public static class Builder {
        public ActivatorPhoneInfo activatorPhoneInfo;
        public String activatorToken;
        public String deviceId;
        public String phone;
        public String phoneHash;
        public String serviceId;
        public String subId;
        public String ticket;

        public Builder deviceId(String str) {
            this.deviceId = str;
            return this;
        }

        public Builder phoneTicket(String str, String str2) {
            this.phone = str;
            this.ticket = str2;
            return this;
        }

        public Builder serviceId(String str) {
            this.serviceId = str;
            return this;
        }

        public Builder subId(String str) {
            this.subId = str;
            return this;
        }

        public Builder phoneHashActivatorToken(ActivatorPhoneInfo activatorPhoneInfo2) {
            this.activatorPhoneInfo = activatorPhoneInfo2;
            if (activatorPhoneInfo2 != null) {
                this.phoneHash = activatorPhoneInfo2.phoneHash;
                this.activatorToken = activatorPhoneInfo2.activatorToken;
            }
            return this;
        }

        public QueryPhoneInfoParams build() {
            return new QueryPhoneInfoParams(this);
        }
    }
}
