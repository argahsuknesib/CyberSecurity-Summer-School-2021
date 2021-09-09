package com.xiaomi.onetrack.h;

import android.text.TextUtils;
import android.util.LruCache;
import com.xiaomi.onetrack.h.l;

final class m extends LruCache<String, l.a> {
    m(int i) {
        super(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final int sizeOf(String str, l.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.f6176a)) {
            return 0;
        }
        return aVar.f6176a.length();
    }
}
