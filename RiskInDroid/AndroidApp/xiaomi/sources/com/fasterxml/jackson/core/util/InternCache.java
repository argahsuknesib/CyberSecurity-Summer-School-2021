package com.fasterxml.jackson.core.util;

import java.util.LinkedHashMap;
import java.util.Map;

public final class InternCache extends LinkedHashMap<String, String> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final InternCache f3599O000000o = new InternCache();

    private InternCache() {
        super(192, 0.8f, true);
    }

    /* access modifiers changed from: protected */
    public final boolean removeEldestEntry(Map.Entry<String, String> entry) {
        return size() > 192;
    }

    public final synchronized String O000000o(String str) {
        String str2;
        str2 = (String) get(str);
        if (str2 == null) {
            str2 = str.intern();
            put(str2, str2);
        }
        return str2;
    }
}
