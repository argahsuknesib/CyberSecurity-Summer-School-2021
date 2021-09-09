package com.hzy.tvmao.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

final class e extends ThreadLocal<SimpleDateFormat> {
    e() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final SimpleDateFormat initialValue() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
    }
}
