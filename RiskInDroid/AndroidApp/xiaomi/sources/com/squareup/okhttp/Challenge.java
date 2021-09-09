package com.squareup.okhttp;

import _m_j.jdn;
import com.squareup.okhttp.internal.Util;

public final class Challenge {
    private final String realm;
    private final String scheme;

    public Challenge(String str, String str2) {
        this.scheme = str;
        this.realm = str2;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final String getRealm() {
        return this.realm;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Challenge)) {
            return false;
        }
        Challenge challenge = (Challenge) obj;
        return Util.equal(this.scheme, challenge.scheme) && Util.equal(this.realm, challenge.realm);
    }

    public final int hashCode() {
        String str = this.realm;
        int i = 0;
        int hashCode = ((str != null ? str.hashCode() : 0) + 899) * 31;
        String str2 = this.scheme;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        return this.scheme + " realm=\"" + this.realm + jdn.f1779O000000o;
    }
}
