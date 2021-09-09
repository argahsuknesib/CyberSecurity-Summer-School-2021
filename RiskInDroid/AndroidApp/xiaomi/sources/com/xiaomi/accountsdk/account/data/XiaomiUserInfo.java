package com.xiaomi.accountsdk.account.data;

import android.graphics.Bitmap;
import java.util.ArrayList;

public class XiaomiUserInfo {
    private Bitmap mAvatar;
    private String mAvatarAddress;
    private String mEmail;
    private String mNickName;
    private String mPhone;
    private ArrayList<String> mPhoneList;
    private String mUserId;
    private String mUserName;

    public XiaomiUserInfo(String str) {
        this.mUserId = str;
    }

    public XiaomiUserInfo(String str, XiaomiUserCoreInfo xiaomiUserCoreInfo) {
        this.mUserId = str;
        if (xiaomiUserCoreInfo != null) {
            this.mUserName = xiaomiUserCoreInfo.userName;
            this.mNickName = xiaomiUserCoreInfo.nickName;
            this.mAvatarAddress = xiaomiUserCoreInfo.avatarAddress;
            this.mPhone = xiaomiUserCoreInfo.safePhone;
            this.mPhoneList = xiaomiUserCoreInfo.phoneList;
            this.mEmail = xiaomiUserCoreInfo.emailAddress;
        }
    }

    public String getUserName() {
        return this.mUserName;
    }

    public void setUserName(String str) {
        this.mUserName = str;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public String getAvatarAddress() {
        return this.mAvatarAddress;
    }

    public void setAvatarAddress(String str) {
        this.mAvatarAddress = str;
    }

    public String getPhone() {
        return this.mPhone;
    }

    public void setPhone(String str) {
        this.mPhone = str;
    }

    public ArrayList<String> getPhoneList() {
        return this.mPhoneList;
    }

    public void setPhoneList(ArrayList<String> arrayList) {
        this.mPhoneList = arrayList;
    }

    public String getEmail() {
        return this.mEmail;
    }

    public void setEmail(String str) {
        this.mEmail = str;
    }

    public String getNickName() {
        return this.mNickName;
    }

    public void setNickName(String str) {
        this.mNickName = str;
    }

    public Bitmap getAvatar() {
        return this.mAvatar;
    }

    public void setAvatar(Bitmap bitmap) {
        this.mAvatar = bitmap;
    }
}
