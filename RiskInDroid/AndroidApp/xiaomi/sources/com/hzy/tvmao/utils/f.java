package com.hzy.tvmao.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

final class f extends ThreadLocal<SimpleDateFormat> {
    f() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final SimpleDateFormat initialValue() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
    }
}
