package com.xiaomi.accountsdk.account.data;

public class MiCloudAuthInfo {
    private String mAccessToken;
    private String mCode;
    private int mExpires;
    private String mMacAlgorithm;
    private String mMacKey;
    private String mScope;
    private String mTokenType;

    public String getAccessToken() {
        return this.mAccessToken;
    }

    public void setAccessToken(String str) {
        this.mAccessToken = str;
    }

    public int getExpires() {
        return this.mExpires;
    }

    public void setExpires(int i) {
        this.mExpires = i;
    }

    public String getScope() {
        return this.mScope;
    }

    public void setScope(String str) {
        this.mScope = str;
    }

    public String getTokenType() {
        return this.mTokenType;
    }

    public void setTokenType(String str) {
        this.mTokenType = str;
    }

    public String getMacKey() {
        return this.mMacKey;
    }

    public void setMacKey(String str) {
        this.mMacKey = str;
    }

    public String getMacAlgorithm() {
        return this.mMacAlgorithm;
    }

    public void setMacAlgorithm(String str) {
        this.mMacAlgorithm = str;
    }

    public String getCode() {
        return this.mCode;
    }

    public void setCode(String str) {
        this.mCode = str;
    }
}
