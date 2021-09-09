package com.miui.tsmclient.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class UserExceptionLogInfo implements Parcelable {
    public static final Parcelable.Creator<UserExceptionLogInfo> CREATOR = new Parcelable.Creator<UserExceptionLogInfo>() {
        /* class com.miui.tsmclient.entity.UserExceptionLogInfo.AnonymousClass1 */

        public final UserExceptionLogInfo createFromParcel(Parcel parcel) {
            return new UserExceptionLogInfo(parcel);
        }

        public final UserExceptionLogInfo[] newArray(int i) {
            return new UserExceptionLogInfo[i];
        }
    };
    private String mCoreOperation;
    private int mErrorCode;
    private String mErrorDesc;
    private String mExtra;
    private String mObjectName;
    private String mSessionId;

    public int describeContents() {
        return 0;
    }

    public UserExceptionLogInfo() {
    }

    protected UserExceptionLogInfo(Parcel parcel) {
        this.mSessionId = parcel.readString();
        this.mErrorCode = parcel.readInt();
        this.mErrorDesc = parcel.readString();
        this.mObjectName = parcel.readString();
        this.mCoreOperation = parcel.readString();
        this.mExtra = parcel.readString();
    }

    public void setSessionId(String str) {
        this.mSessionId = str;
    }

    public String getSessionId() {
        return this.mSessionId;
    }

    public void setErrorCode(int i) {
        this.mErrorCode = i;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public void setErrorDesc(String str) {
        this.mErrorDesc = str;
    }

    public String getErrorDesc() {
        return this.mErrorDesc;
    }

    public void setObjectName(String str) {
        this.mObjectName = str;
    }

    public String getObjectName() {
        return this.mObjectName;
    }

    public void setCoreOperation(String str) {
        this.mCoreOperation = str;
    }

    public String getCoreOperation() {
        return this.mCoreOperation;
    }

    public void setExtra(String str) {
        this.mExtra = str;
    }

    public String getExtra() {
        return this.mExtra;
    }

    public Map<String, String> getParams() {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.mSessionId)) {
            hashMap.put("sessionId", this.mSessionId);
        }
        hashMap.put("errorCode", String.valueOf(this.mErrorCode));
        hashMap.put("errorDesc", this.mErrorDesc);
        if (!TextUtils.isEmpty(this.mObjectName)) {
            hashMap.put("appName", this.mObjectName);
        }
        if (!TextUtils.isEmpty(this.mCoreOperation)) {
            hashMap.put("coreOperation", this.mCoreOperation);
        }
        if (!TextUtils.isEmpty(this.mExtra)) {
            hashMap.put("extra", this.mExtra);
        }
        return hashMap;
    }

    public boolean needUpload() {
        return this.mErrorCode != 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mSessionId);
        parcel.writeInt(this.mErrorCode);
        parcel.writeString(this.mErrorDesc);
        parcel.writeString(this.mObjectName);
        parcel.writeString(this.mCoreOperation);
        parcel.writeString(this.mExtra);
    }
}
