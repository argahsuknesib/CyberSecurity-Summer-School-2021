package com.tencent.mm.sdk.b;

import java.util.TimeZone;

public final class h {
    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    public static final long[] bh = {300, 200, 300, 200};
    private static final long[] bi = {300, 50, 300, 50};
    private static final char[] bj = {'<', '>', '\"', '\'', '&', 13, 10, ' ', 9};
    private static final String[] bk = {"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&#x0D;", "&#x0A;", "&#x20;", "&#x09;"};

    public static boolean h(String str) {
        return str == null || str.length() <= 0;
    }

    public static f u() {
        return new f();
    }
}
