package com.xiaomi.accountsdk.account.data;

import java.util.Calendar;

public class XiaomiUserProfile {
    private Calendar mBirthday;
    private Gender mGender;
    private String mUserId;
    private String mUserName;

    public XiaomiUserProfile(String str) {
        this(str, null, null, null);
    }

    public XiaomiUserProfile(String str, XiaomiUserCoreInfo xiaomiUserCoreInfo) {
        this.mUserId = str;
        if (xiaomiUserCoreInfo != null) {
            this.mUserName = xiaomiUserCoreInfo.userName;
            this.mGender = xiaomiUserCoreInfo.gender;
            this.mBirthday = xiaomiUserCoreInfo.birthday;
        }
    }

    public XiaomiUserProfile(String str, String str2, Calendar calendar, Gender gender) {
        this.mUserId = str;
        this.mUserName = str2;
        this.mGender = gender;
        this.mBirthday = calendar;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public Gender getGender() {
        return this.mGender;
    }

    public void setGender(Gender gender) {
        this.mGender = gender;
    }

    public Calendar getBirthday() {
        return this.mBirthday;
    }

    public void setBirthday(Calendar calendar) {
        this.mBirthday = calendar;
    }

    public void setUserName(String str) {
        this.mUserName = str;
    }

    public String getUserName() {
        return this.mUserName;
    }
}
