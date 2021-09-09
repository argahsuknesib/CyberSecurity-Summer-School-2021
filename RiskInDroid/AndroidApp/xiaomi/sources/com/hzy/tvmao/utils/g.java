package com.hzy.tvmao.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

final class g extends ThreadLocal<SimpleDateFormat> {
    g() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final SimpleDateFormat initialValue() {
        return new SimpleDateFormat("HH:mm", Locale.CHINA);
    }
}
