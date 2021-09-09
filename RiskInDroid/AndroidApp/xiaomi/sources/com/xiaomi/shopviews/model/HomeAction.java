package com.xiaomi.shopviews.model;

import java.io.Serializable;

public class HomeAction implements Serializable {
    private static final long serialVersionUID = -1109556628901905801L;
    public String mExtra;
    public boolean mIsNeedLogin;
    public String mLogCode;
    public String mPath;
    public String mType;

    public boolean equals(Object obj) {
        if (this != obj) {
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
            String str2 = this.mLogCode;
            if (str2 == null ? homeAction.mLogCode != null : !str2.equals(homeAction.mLogCode)) {
                return false;
            }
            if (!this.mType.equals(homeAction.mType)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int hashCode = this.mType.hashCode() * 31;
        String str = this.mPath;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.mLogCode;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode2 + i) * 31) + (this.mIsNeedLogin ? 1 : 0);
    }

    public String toString() {
        return "HomeAction{mType='" + this.mType + '\'' + ", mPath='" + this.mPath + '\'' + ", mStatDesc='" + this.mLogCode + '\'' + ", mIsNeedLogin='" + this.mIsNeedLogin + '\'' + '}';
    }
}
