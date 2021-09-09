package com.mi.global.shop.base.request;

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
        if (split.length != 2) {
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
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ExtendedAuthToken extendedAuthToken = (ExtendedAuthToken) obj;
        String str = this.authToken;
        if (str == null ? extendedAuthToken.authToken != null : !str.equals(extendedAuthToken.authToken)) {
            return false;
        }
        String str2 = this.security;
        return str2 == null ? extendedAuthToken.security == null : str2.equals(extendedAuthToken.security);
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
