package _m_j;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.push.r;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class esl {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile int f15773O000000o = 0;
    private static int O00000Oo = -1;
    private static Map<String, r> O00000o0;

    public static String O000000o(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.toString() + " " + O000000o(intent.getExtras());
    }

    private static String O000000o(Bundle bundle) {
        String O000000o2;
        StringBuilder sb = new StringBuilder("Bundle[");
        if (bundle == null) {
            sb.append("null");
        } else {
            boolean z = true;
            for (String next : bundle.keySet()) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(next);
                sb.append('=');
                Object obj = bundle.get(next);
                if (obj instanceof int[]) {
                    O000000o2 = Arrays.toString((int[]) obj);
                } else if (obj instanceof byte[]) {
                    O000000o2 = Arrays.toString((byte[]) obj);
                } else if (obj instanceof boolean[]) {
                    O000000o2 = Arrays.toString((boolean[]) obj);
                } else if (obj instanceof short[]) {
                    O000000o2 = Arrays.toString((short[]) obj);
                } else if (obj instanceof long[]) {
                    O000000o2 = Arrays.toString((long[]) obj);
                } else if (obj instanceof float[]) {
                    O000000o2 = Arrays.toString((float[]) obj);
                } else if (obj instanceof double[]) {
                    O000000o2 = Arrays.toString((double[]) obj);
                } else if (obj instanceof String[]) {
                    O000000o2 = Arrays.toString((String[]) obj);
                } else if (obj instanceof CharSequence[]) {
                    O000000o2 = Arrays.toString((CharSequence[]) obj);
                } else if (obj instanceof Parcelable[]) {
                    O000000o2 = Arrays.toString((Parcelable[]) obj);
                } else if (obj instanceof Bundle) {
                    O000000o2 = O000000o((Bundle) obj);
                } else {
                    sb.append(obj);
                    z = false;
                }
                sb.append(O000000o2);
                z = false;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static String O000000o(String str) {
        try {
            return (String) emg.O000000o("android.os.SystemProperties", "get", str, "");
        } catch (Exception e) {
            duv.O00000o("fail to get property. ".concat(String.valueOf(e)));
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean O000000o() {
        return O0000Oo0() == 1;
    }

    public static boolean O00000Oo() {
        return O0000Oo0() == 2;
    }

    public static boolean O00000Oo(Context context) {
        if (context == null || !O000000o(context)) {
            return false;
        }
        String absolutePath = context.getFilesDir().getAbsolutePath();
        if (!TextUtils.isEmpty(absolutePath)) {
            File file = new File(absolutePath + "/debug_for_xmsf");
            return file.exists() && !file.isDirectory();
        }
    }

    public static boolean O00000o() {
        if (O00000Oo < 0) {
            O00000Oo = O0000Oo() ^ true ? 1 : 0;
        }
        return O00000Oo > 0;
    }

    public static String O00000o0() {
        int O00000Oo2 = esu.O00000Oo();
        return (!O000000o() || O00000Oo2 <= 0) ? "" : O00000Oo2 < 2 ? "alpha" : O00000Oo2 < 3 ? "development" : "stable";
    }

    public static boolean O00000oo() {
        return !r.f6460a.name().equalsIgnoreCase(O00000Oo(O00000oO()).name());
    }

    public static int O0000O0o() {
        String O000000o2 = O000000o("ro.miui.ui.version.code");
        if (TextUtils.isEmpty(O000000o2) || !TextUtils.isDigitsOnly(O000000o2)) {
            return 0;
        }
        return Integer.parseInt(O000000o2);
    }

    public static String O0000OOo() {
        return O000000o("ro.miui.ui.version.name");
    }

    private static boolean O0000Oo() {
        String str = "";
        try {
            str = est.O000000o("ro.miui.ui.version.code", str);
        } catch (Exception unused) {
        }
        return !TextUtils.isEmpty(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0024 A[Catch:{ Throwable -> 0x0029 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025 A[Catch:{ Throwable -> 0x0029 }] */
    private static int O0000Oo0() {
        boolean z;
        if (f15773O000000o == 0) {
            try {
                int i = 1;
                if (TextUtils.isEmpty(O000000o("ro.miui.ui.version.code"))) {
                    if (TextUtils.isEmpty(O000000o("ro.miui.ui.version.name"))) {
                        z = false;
                        if (z) {
                            i = 2;
                        }
                        f15773O000000o = i;
                        duv.O00000Oo("isMIUI's value is: " + f15773O000000o);
                    }
                }
                z = true;
                if (z) {
                }
                f15773O000000o = i;
            } catch (Throwable th) {
                duv.O000000o("get isMIUI failed", th);
                f15773O000000o = 0;
            }
            duv.O00000Oo("isMIUI's value is: " + f15773O000000o);
        }
        return f15773O000000o;
    }

    public static boolean O000000o(Context context) {
        return context != null && "com.xiaomi.xmsf".equals(context.getPackageName());
    }

    public static String O00000oO() {
        String O000000o2 = est.O000000o("ro.miui.region", "");
        if (TextUtils.isEmpty(O000000o2)) {
            O000000o2 = est.O000000o("persist.sys.oppo.region", "");
        }
        if (TextUtils.isEmpty(O000000o2)) {
            O000000o2 = est.O000000o("ro.oppo.regionmark", "");
        }
        if (TextUtils.isEmpty(O000000o2)) {
            O000000o2 = est.O000000o("ro.vendor.oplus.regionmark", "");
        }
        if (TextUtils.isEmpty(O000000o2)) {
            O000000o2 = est.O000000o("ro.hw.country", "");
        }
        if (TextUtils.isEmpty(O000000o2)) {
            O000000o2 = est.O000000o("ro.csc.countryiso_code", "");
        }
        if (TextUtils.isEmpty(O000000o2)) {
            O000000o2 = est.O000000o("ro.product.country.region", "");
            if (!TextUtils.isEmpty(O000000o2)) {
                String[] split = O000000o2.split("-");
                if (split.length > 0) {
                    O000000o2 = split[0];
                }
            }
        }
        if (TextUtils.isEmpty(O000000o2)) {
            O000000o2 = est.O000000o("gsm.vivo.countrycode", "");
        }
        if (TextUtils.isEmpty(O000000o2)) {
            O000000o2 = est.O000000o("persist.sys.oem.region", "");
        }
        if (TextUtils.isEmpty(O000000o2)) {
            O000000o2 = est.O000000o("ro.product.locale.region", "");
        }
        if (TextUtils.isEmpty(O000000o2)) {
            O000000o2 = est.O000000o("persist.sys.country", "");
        }
        if (!TextUtils.isEmpty(O000000o2)) {
            duv.O000000o("get region from system, region = ".concat(String.valueOf(O000000o2)));
        }
        if (!TextUtils.isEmpty(O000000o2)) {
            return O000000o2;
        }
        String country = Locale.getDefault().getCountry();
        duv.O000000o("locale.default.country = ".concat(String.valueOf(country)));
        return country;
    }

    public static r O00000Oo(String str) {
        if (O00000o0 == null) {
            HashMap hashMap = new HashMap();
            O00000o0 = hashMap;
            hashMap.put("CN", r.f6460a);
            O00000o0.put("FI", r.c);
            O00000o0.put("SE", r.c);
            O00000o0.put("NO", r.c);
            O00000o0.put("FO", r.c);
            O00000o0.put("EE", r.c);
            O00000o0.put("LV", r.c);
            O00000o0.put("LT", r.c);
            O00000o0.put("BY", r.c);
            O00000o0.put("MD", r.c);
            O00000o0.put("UA", r.c);
            O00000o0.put("PL", r.c);
            O00000o0.put("CZ", r.c);
            O00000o0.put("SK", r.c);
            O00000o0.put("HU", r.c);
            O00000o0.put("DE", r.c);
            O00000o0.put("AT", r.c);
            O00000o0.put("CH", r.c);
            O00000o0.put("LI", r.c);
            O00000o0.put("GB", r.c);
            O00000o0.put("IE", r.c);
            O00000o0.put("NL", r.c);
            O00000o0.put("BE", r.c);
            O00000o0.put("LU", r.c);
            O00000o0.put("FR", r.c);
            O00000o0.put("RO", r.c);
            O00000o0.put("BG", r.c);
            O00000o0.put("RS", r.c);
            O00000o0.put("MK", r.c);
            O00000o0.put("AL", r.c);
            O00000o0.put("GR", r.c);
            O00000o0.put("SI", r.c);
            O00000o0.put("HR", r.c);
            O00000o0.put("IT", r.c);
            O00000o0.put("SM", r.c);
            O00000o0.put("MT", r.c);
            O00000o0.put("ES", r.c);
            O00000o0.put("PT", r.c);
            O00000o0.put("AD", r.c);
            O00000o0.put("CY", r.c);
            O00000o0.put("DK", r.c);
            O00000o0.put("RU", r.d);
            O00000o0.put("IN", r.e);
        }
        r rVar = O00000o0.get(str.toUpperCase());
        return rVar == null ? r.b : rVar;
    }
}
