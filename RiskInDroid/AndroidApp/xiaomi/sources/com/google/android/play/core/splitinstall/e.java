package com.google.android.play.core.splitinstall;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Map<String, String>> f3813a = new HashMap();

    public final f a() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f3813a.entrySet()) {
            hashMap.put((String) next.getKey(), Collections.unmodifiableMap(new HashMap((Map) next.getValue())));
        }
        return new f(Collections.unmodifiableMap(hashMap));
    }

    public final void a(String str, String str2, String str3) {
        if (!this.f3813a.containsKey(str2)) {
            this.f3813a.put(str2, new HashMap());
        }
        this.f3813a.get(str2).put(str, str3);
    }
}
