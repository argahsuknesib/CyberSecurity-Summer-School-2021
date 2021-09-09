package com.xiaomi.mico.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import okhttp3.Cookie;

class CacheCookie {
    private Cookie mCookie;

    static List<CacheCookie> decorateCookies(Collection<Cookie> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Cookie cacheCookie : collection) {
            arrayList.add(new CacheCookie(cacheCookie));
        }
        return arrayList;
    }

    private CacheCookie(Cookie cookie) {
        this.mCookie = cookie;
    }

    /* access modifiers changed from: package-private */
    public Cookie getCookie() {
        return this.mCookie;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CacheCookie)) {
            return false;
        }
        CacheCookie cacheCookie = (CacheCookie) obj;
        if (!cacheCookie.mCookie.name().equals(this.mCookie.name()) || !cacheCookie.mCookie.domain().equals(this.mCookie.domain()) || !cacheCookie.mCookie.path().equals(this.mCookie.path()) || cacheCookie.mCookie.secure() != this.mCookie.secure() || cacheCookie.mCookie.hostOnly() != this.mCookie.hostOnly()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((((this.mCookie.name().hashCode() + 527) * 31) + this.mCookie.domain().hashCode()) * 31) + this.mCookie.path().hashCode()) * 31) + (this.mCookie.secure() ^ true ? 1 : 0)) * 31) + (this.mCookie.hostOnly() ^ true ? 1 : 0);
    }
}
