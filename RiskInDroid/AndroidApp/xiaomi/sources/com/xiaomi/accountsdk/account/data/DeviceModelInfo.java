package com.xiaomi.accountsdk.account.data;

public class DeviceModelInfo {
    private String mDefaultDeviceName;
    private String mImageUrl;
    private String mModel;
    private String mModelName;

    public DeviceModelInfo(String str) {
        this.mModel = str;
    }

    public String getModel() {
        return this.mModel;
    }

    public void setImageUrl(String str) {
        this.mImageUrl = str;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public void setDefaultDeviceName(String str) {
        this.mDefaultDeviceName = str;
    }

    public String getDefaultDeviceName() {
        return this.mDefaultDeviceName;
    }

    public void setModelName(String str) {
        this.mModelName = str;
    }

    public String getModelName() {
        return this.mModelName;
    }
}
