package com.mibi.sdk.common.account;

import android.text.TextUtils;

public class ExtendedAuthToken {
    public final String authToken;
    public final String security;

    private ExtendedAuthToken(String str, String str2) {
        this.authToken = str;
        this.security = str2;
    }

    public static ExtendedAuthToken build(String str, String str2) {
        return new ExtendedAuthToken(str, str2);
    }

    public static ExtendedAuthToken parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(",");
        if (split.length != 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) {
            return null;
        }
        return new ExtendedAuthToken(split[0], split[1]);
    }

    public String toPlain() {
        return this.authToken + "," + this.security;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ExtendedAuthToken extendedAuthToken = (ExtendedAuthToken) obj;
            String str = this.authToken;
            if (str != null) {
                if (!str.equals(extendedAuthToken.authToken)) {
                    return false;
                }
            } else if (extendedAuthToken.authToken != null) {
                return false;
            }
            String str2 = this.security;
            if (str2 != null) {
                if (str2.equals(extendedAuthToken.security)) {
                    return true;
                }
            } else if (extendedAuthToken.security == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.authToken;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.security;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }
}
