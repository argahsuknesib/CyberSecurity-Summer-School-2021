package _m_j;

import android.text.TextUtils;

public abstract class hxo {

    /* renamed from: O000000o  reason: collision with root package name */
    hyg f956O000000o = new hyg("page");

    public final long O000000o(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            str = hyg.O000000o(obj);
        }
        return this.f956O000000o.O000000o("page_start", "name", str);
    }

    public final long O000000o(Object obj, long j, String str) {
        if (TextUtils.isEmpty(str)) {
            str = hyg.O000000o(obj);
        }
        return this.f956O000000o.O000000o("page_end", "name", str, "stay_time", Long.valueOf((System.currentTimeMillis() - j) / 1000));
    }
}
