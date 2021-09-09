package com.xiaomi.mobilestats.controller;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

public final class a extends LinkedHashMap {
    public a() {
        super(20, 0.75f, true);
    }

    /* access modifiers changed from: protected */
    public final boolean removeEldestEntry(Map.Entry entry) {
        if (size() <= 20) {
            return false;
        }
        File file = (File) entry.getValue();
        if (file == null || !file.exists()) {
            return true;
        }
        file.delete();
        return true;
    }
}
