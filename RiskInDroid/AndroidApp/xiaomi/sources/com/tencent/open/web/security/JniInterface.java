package com.tencent.open.web.security;

import _m_j.dii;
import _m_j.diz;
import _m_j.djk;
import android.content.Context;
import java.io.File;

public class JniInterface {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f5882O000000o = false;

    public static native boolean BackSpaceChar(boolean z, int i);

    public static native boolean clearAllPWD();

    public static native String d1(String str);

    public static native String d2(String str);

    public static native String getPWDKeyToMD5(String str);

    public static native boolean insetTextToArray(int i, String str, int i2);

    public static void O000000o() {
        if (!f5882O000000o) {
            try {
                Context O000000o2 = djk.O000000o();
                if (O000000o2 != null) {
                    if (new File(O000000o2.getFilesDir().toString() + "/" + dii.O00000Oo).exists()) {
                        System.load(O000000o2.getFilesDir().toString() + "/" + dii.O00000Oo);
                        f5882O000000o = true;
                        StringBuilder sb = new StringBuilder("-->load lib success:");
                        sb.append(dii.O00000Oo);
                        diz.O00000o0("openSDK_LOG.JniInterface", sb.toString());
                        return;
                    }
                    diz.O00000o0("openSDK_LOG.JniInterface", "-->fail, because so is not exists:" + dii.O00000Oo);
                    return;
                }
                diz.O00000o0("openSDK_LOG.JniInterface", "-->load lib fail, because context is null:" + dii.O00000Oo);
            } catch (Throwable th) {
                diz.O00000Oo("openSDK_LOG.JniInterface", "-->load lib error:" + dii.O00000Oo, th);
            }
        }
    }
}
