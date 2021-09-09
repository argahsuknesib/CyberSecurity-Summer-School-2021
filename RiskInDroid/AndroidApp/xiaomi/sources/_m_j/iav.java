package _m_j;

import android.text.TextUtils;
import java.io.File;

public final class iav {

    /* renamed from: O000000o  reason: collision with root package name */
    public static volatile boolean f1140O000000o;
    private static final boolean O00000Oo = new File("/data/system/verifaction_staging_preview").exists();

    public static String O000000o(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            return str + str2;
        } else if (f1140O000000o || O00000Oo) {
            return "https://infosec-captcha-staging.pt.xiaomi.com".concat(String.valueOf(str2));
        } else {
            return "https://verify.sec.xiaomi.com".concat(String.valueOf(str2));
        }
    }
}
