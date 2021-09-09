package com.hzy.tvmao.ir;

import com.hzy.tvmao.utils.LogUtil;
import com.hzy.tvmao.utils.StringUtil;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f4421a;
    private boolean b = false;

    public void a(int i, int[] iArr, long j) {
    }

    public static a a() {
        if (f4421a == null) {
            f4421a = new a();
        }
        return f4421a;
    }

    public void a(int i, String str) {
        a(i, str, 0);
    }

    public void a(int i, String str, long j) {
        String str2;
        if (str != null && str.contains("&")) {
            String[] split = str.split("&");
            if (split.length > 1) {
                if (this.b) {
                    str2 = split[1];
                    LogUtil.d(this.b + split[1]);
                    this.b = false;
                } else {
                    str2 = split[0];
                    LogUtil.d(this.b + split[0]);
                    this.b = true;
                }
                str = str2;
            } else {
                str = null;
            }
        }
        int[] parseIntArray = StringUtil.parseIntArray(str);
        if (parseIntArray != null) {
            a(i, parseIntArray, j);
        }
    }
}
