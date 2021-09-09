package com.miui.tsmclient.account;

import android.content.Intent;
import android.text.TextUtils;

public class AccountInfo {
    private String mAuthToken;
    private Intent mIntent;
    private String mPh;
    private String mSecurity;
    private String mServiceToken;
    private String mUserId;

    public String getSecurity() {
        return this.mSecurity;
    }

    public void setSecurity(String str) {
        this.mSecurity = str;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public String getServiceToken() {
        return this.mServiceToken;
    }

    public void setServiceToken(String str) {
        this.mServiceToken = str;
    }

    public String getAuthToken() {
        return this.mAuthToken;
    }

    public void setAuthToken(String str) {
        this.mAuthToken = str;
    }

    public String getPh() {
        return this.mPh;
    }

    public void setPh(String str) {
        this.mPh = str;
    }

    public void setIntent(Intent intent) {
        this.mIntent = intent;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.mUserId) && !TextUtils.isEmpty(this.mAuthToken);
    }
}
