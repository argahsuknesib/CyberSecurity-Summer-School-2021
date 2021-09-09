package com.xiaomi.push.service;

import _m_j.eml;
import android.text.TextUtils;

public class aw {

    /* renamed from: a  reason: collision with root package name */
    private static long f6509a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static String f263a = "";

    public static String a() {
        if (TextUtils.isEmpty(f263a)) {
            f263a = eml.O000000o(4);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f263a);
        long j = f6509a;
        f6509a = 1 + j;
        sb.append(j);
        return sb.toString();
    }
}
