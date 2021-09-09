package com.xiaomi.onetrack.h;

import java.util.Comparator;

final class i implements Comparator<String> {
    i() {
    }

    /* renamed from: a */
    public final int compare(String str, String str2) {
        return str.compareToIgnoreCase(str2);
    }
}
