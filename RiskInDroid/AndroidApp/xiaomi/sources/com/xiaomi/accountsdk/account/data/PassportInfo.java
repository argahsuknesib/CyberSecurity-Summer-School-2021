package com.xiaomi.accountsdk.account.data;

public class PassportInfo {
    private final String encryptedUserId;
    private String security;
    private final String serviceId;
    private String serviceToken;
    private final String userId;

    public PassportInfo(String str, String str2, String str3, String str4, String str5) {
        this.userId = str;
        this.encryptedUserId = str2;
        this.serviceId = str3;
        this.serviceToken = str4;
        this.security = str5;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getEncryptedUserId() {
        return this.encryptedUserId;
    }

    public String getServiceId() {
        return this.serviceId;
    }

    public String getServiceToken() {
        return this.serviceToken;
    }

    public String getSecurity() {
        return this.security;
    }

    public void setServiceToken(String str) {
        this.serviceToken = str;
    }

    public void setSecurity(String str) {
        this.security = str;
    }
}
