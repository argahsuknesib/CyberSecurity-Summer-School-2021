package com.ta.utdid2.a.a;

import java.util.regex.Pattern;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f5800a = Pattern.compile("([\t\r\n])+");

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m101a(String str) {
        return str == null || str.length() <= 0;
    }

    public static int a(String str) {
        if (str.length() <= 0) {
            return 0;
        }
        int i = 0;
        for (char c : str.toCharArray()) {
            i = (i * 31) + c;
        }
        return i;
    }
}
