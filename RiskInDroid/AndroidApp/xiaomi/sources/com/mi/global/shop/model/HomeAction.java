package com.mi.global.shop.model;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class HomeAction implements Serializable {
    private static final long serialVersionUID = -1109556628901905801L;
    @SerializedName("login")
    public boolean mIsNeedLogin;
    @SerializedName("path")
    public String mPath;
    @SerializedName("stat")
    public String mStatDesc;
    @SerializedName("type")
    public String mType;

    public boolean isNeedLogin() {
        return this.mIsNeedLogin;
    }

    public boolean isEmpty() {
        return TextUtils.isEmpty(this.mType) || TextUtils.isEmpty(this.mPath);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HomeAction homeAction = (HomeAction) obj;
        if (this.mIsNeedLogin != homeAction.mIsNeedLogin) {
            return false;
        }
        String str = this.mPath;
        if (str == null ? homeAction.mPath != null : !str.equals(homeAction.mPath)) {
            return false;
        }
        String str2 = this.mStatDesc;
        if (str2 == null ? homeAction.mStatDesc == null : str2.equals(homeAction.mStatDesc)) {
            return this.mType.equals(homeAction.mType);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.mType.hashCode() * 31;
        String str = this.mPath;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.mStatDesc;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode2 + i) * 31) + (this.mIsNeedLogin ? 1 : 0);
    }

    public String toString() {
        return "HomeAction{mType='" + this.mType + '\'' + ", mPath='" + this.mPath + '\'' + ", mStatDesc='" + this.mStatDesc + '\'' + ", mIsNeedLogin='" + this.mIsNeedLogin + '\'' + '}';
    }
}
