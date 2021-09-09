package com.tencent.mm.sdk.c;

import android.net.Uri;
import android.provider.BaseColumns;

public final class a {

    /* renamed from: com.tencent.mm.sdk.c.a$a  reason: collision with other inner class name */
    public static final class C0051a {
        public static Object a(int i, String str) {
            switch (i) {
                case 1:
                    return Integer.valueOf(str);
                case 2:
                    return Long.valueOf(str);
                case 3:
                    return str;
                case 4:
                    return Boolean.valueOf(str);
                case 5:
                    return Float.valueOf(str);
                case 6:
                    try {
                        return Double.valueOf(str);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                default:
                    com.tencent.mm.sdk.b.b.b("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
                    return null;
            }
        }
    }

    public static final class b implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");
    }
}
