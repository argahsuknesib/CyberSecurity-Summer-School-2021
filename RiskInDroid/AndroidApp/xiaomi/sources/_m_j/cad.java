package _m_j;

import _m_j.cbm;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class cad {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f13513O000000o = null;
    public static String O00000Oo = null;
    public static String O00000o = "in";
    public static String O00000o0 = "none";
    public static String O00000oO = "tw";
    public static String O00000oo = "hk";
    public static String O0000O0o = "id";
    public static String O0000OOo = "es";
    public static String O0000Oo = "it";
    public static String O0000Oo0 = "fr";
    public static String O0000OoO = "ru";
    public static String O0000Ooo = "uk";
    public static final String[][] O0000o0;
    public static String O0000o00 = "gb";
    public static final String[][] O0000o0O;

    static {
        String str = O00000o;
        String str2 = O00000oO;
        String str3 = O00000oo;
        String str4 = O0000OOo;
        String str5 = O0000Oo0;
        String str6 = O0000O0o;
        String str7 = O0000OoO;
        String str8 = O0000Oo;
        String str9 = O0000Ooo;
        O0000o0 = new String[][]{new String[]{str, "en", "India"}, new String[]{str2, "zh", "Taiwan 繁體中文"}, new String[]{str3, "zh", "Hong Kong 繁體中文"}, new String[]{str4, "es", "España"}, new String[]{str5, "fr", "France"}, new String[]{str6, "id", "Indonesia"}, new String[]{str7, "ru", "Россия"}, new String[]{str8, "it", "Italy"}, new String[]{str9, "en", "United Kingdom"}};
        O0000o0O = new String[][]{new String[]{str, "i18n_in_mo_pro"}, new String[]{str2, "mi_mo_overseatw"}, new String[]{str3, "mi_mo_overseahk"}, new String[]{str4, "mi_mo_overseaes"}, new String[]{str5, "mi_mo_overseafr"}, new String[]{str6, "mi_mo_overseaid_new"}, new String[]{str7, "i18n_ru_mo_pro"}, new String[]{str8, "mi_mo_overseait"}, new String[]{str9, "mi_mo_overseauk"}};
    }

    public static void O000000o(String str) {
        String str2;
        TelephonyManager telephonyManager;
        if (!TextUtils.isEmpty(str)) {
            int i = 0;
            while (true) {
                String[][] strArr = O0000o0;
                if (i >= strArr.length) {
                    break;
                } else if (strArr[i][0].equals(str)) {
                    String[][] strArr2 = O0000o0;
                    f13513O000000o = strArr2[i][0];
                    O00000Oo = strArr2[i][1];
                    cbm.O00000o0.O000000o(byl.O00000oO(), "pref_locale", f13513O000000o);
                    cbm.O00000o0.O000000o(byl.O00000oO(), "pref_lang", O00000Oo);
                    cbm.O00000o0.O00000Oo(byl.O00000oO(), "pref_key_user_center_list");
                    break;
                } else {
                    i++;
                }
            }
        }
        if (f13513O000000o == null || O00000Oo == null) {
            f13513O000000o = cbm.O00000o0.O00000Oo(byl.O00000oO(), "pref_locale", (String) null);
            O00000Oo = cbm.O00000o0.O00000Oo(byl.O00000oO(), "pref_lang", (String) null);
        }
        if (f13513O000000o == null || O00000Oo == null) {
            try {
                str2 = (String) Class.forName("miui.os.Build").getMethod("getRegion", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
                str2 = null;
            }
            if (str2 == null) {
                str2 = byl.O00000oO().getResources().getConfiguration().locale.getCountry();
            }
            ccr.O00000Oo("applocale", " current country is :".concat(String.valueOf(str2)));
            for (String[] strArr3 : O0000o0) {
                if (strArr3[0].equalsIgnoreCase(str2) || (strArr3[0].equalsIgnoreCase(O0000Ooo) && O0000o00.equalsIgnoreCase(str2))) {
                    f13513O000000o = strArr3[0];
                    O00000Oo = strArr3[1];
                }
            }
            if ((f13513O000000o == null || O00000Oo == null) && (telephonyManager = (TelephonyManager) byl.O00000oO().getSystemService("phone")) != null) {
                String simCountryIso = telephonyManager.getSimCountryIso();
                for (String[] strArr4 : O0000o0) {
                    if (strArr4[0].equalsIgnoreCase(simCountryIso)) {
                        f13513O000000o = strArr4[0];
                        O00000Oo = strArr4[1];
                    }
                }
            }
            if (f13513O000000o == null || O00000Oo == null) {
                f13513O000000o = O00000o;
                O00000Oo = "en";
            }
            cbm.O00000o0.O000000o(byl.O00000oO(), "pref_locale", f13513O000000o);
            cbm.O00000o0.O000000o(byl.O00000oO(), "pref_lang", O00000Oo);
        }
        ccr.O00000Oo("applocale", " locale is :" + f13513O000000o);
        ccr.O00000Oo("applocale", " lang is :" + O00000Oo);
    }

    public static String O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int i = 0;
        while (true) {
            String[][] strArr = O0000o0O;
            if (i >= strArr.length) {
                return "";
            }
            if (strArr[i][0].equals(str)) {
                return O0000o0O[i][1];
            }
            i++;
        }
    }

    public static String O000000o() {
        if (O0000O0o()) {
            return "in_ID";
        }
        return O00000Oo + "_" + f13513O000000o.toUpperCase();
    }

    public static String O00000Oo() {
        if (f13513O000000o.equalsIgnoreCase(O00000o)) {
            return "/register?callback=http%3A%2F%2Fm.buy.mi.com%2Fin%2Flogin%2Fcallback%3Ffollowup%3Dhttp%253A%252F%252Fm.buy.mi.com%252Fin%252Fuser%252F%26sign%3DODhhODI4YjA0ZmYxMDM5MTgwOGQ4YjBjODE1MjU4MzhlMTNkNTQ0Yg%2C%2C&sid=mi_mo_overseain&_locale=en_IN&";
        }
        if (f13513O000000o.equalsIgnoreCase(O00000oO)) {
            return "/register?callback=http%3A%2F%2Fm.buy.mi.com%2Ftw%2Flogin%2Fcallback%3Ffollowup%3Dhttp%253A%252F%252Fm.buy.mi.com%252Ftw%252Fuser%252F%26sign%3DNTMyZDQ2MGNmM2RiMjg5MTU3MDAwOTA2MjFlNmYyZmYxZTlmOTE2NA%2C%2C&sid=mi_mo_overseatw&_locale=zh_TW&";
        }
        if (f13513O000000o.equalsIgnoreCase(O0000O0o)) {
            return "/register?callback=http%3A%2F%2Fm.buy.mi.com%2Fid%2Flogin%2Fcallback%3Ffollowup%3Dhttp%253A%252F%252Fm.buy.mi.com%252Fid%252Fuser%252F%26sign%3DODhlODBhMWExZWRjNjI1ODMzMzc0ODk1MzdjYTdmZDlmMmIwOGIxMw%2C%2C&sid=mi_mo_overseaid&_locale=in_ID&";
        }
        return "/register?callback=http%3A%2F%2Fm.buy.mi.com%2Fin%2Flogin%2Fcallback%3Ffollowup%3Dhttp%253A%252F%252Fm.buy.mi.com%252Fin%252Fuser%252F%26sign%3DODhhODI4YjA0ZmYxMDM5MTgwOGQ4YjBjODE1MjU4MzhlMTNkNTQ0Yg%2C%2C&sid=mi_mo_overseain&_locale=en_IN&";
    }

    public static String O00000o0() {
        if (f13513O000000o.equalsIgnoreCase(O00000o)) {
            return "₹";
        }
        if (f13513O000000o.equalsIgnoreCase(O00000oO)) {
            return "NT$ ";
        }
        if (f13513O000000o.equalsIgnoreCase(O0000O0o)) {
            return "Rp ";
        }
        if (f13513O000000o.equalsIgnoreCase(O00000oo)) {
            return "HK$ ";
        }
        if (f13513O000000o.equalsIgnoreCase(O0000OOo) || f13513O000000o.equalsIgnoreCase(O0000Oo0)) {
            return "€ ";
        }
        if (f13513O000000o.equalsIgnoreCase(O0000OoO)) {
            return "₽ ";
        }
        if (f13513O000000o.equalsIgnoreCase(O0000Oo)) {
            return "€ ";
        }
        return f13513O000000o.equalsIgnoreCase(O0000Ooo) ? "£ " : "";
    }

    public static String O00000o0(String str) {
        String str2 = "#,### ";
        if (f13513O000000o.equalsIgnoreCase(O00000o)) {
            str2 = "#,###";
        } else if (!f13513O000000o.equalsIgnoreCase(O00000oO) && !f13513O000000o.equalsIgnoreCase(O00000oo) && !f13513O000000o.equalsIgnoreCase(O0000OOo) && !f13513O000000o.equalsIgnoreCase(O0000Oo0)) {
            str2 = "#,###.00";
        }
        return new DecimalFormat(str2).format(Double.parseDouble(str));
    }

    public static String O000000o(Long l) {
        String format = new SimpleDateFormat(O00000o() ? "dd MMM, KK:mm a" : "yyyy-MM-dd HH:mm").format(new Date(l.longValue()));
        return O00000o() ? format.replace("pm", "PM").replace("am", "AM") : format;
    }

    public static boolean O00000o() {
        return O00000o.equalsIgnoreCase(f13513O000000o);
    }

    public static boolean O00000oO() {
        return O00000oO.equalsIgnoreCase(f13513O000000o);
    }

    public static boolean O00000oo() {
        return O00000oo.equalsIgnoreCase(f13513O000000o);
    }

    public static boolean O0000O0o() {
        return O0000O0o.equalsIgnoreCase(f13513O000000o);
    }

    public static boolean O0000OOo() {
        return O0000OOo.equalsIgnoreCase(f13513O000000o);
    }

    public static boolean O0000Oo0() {
        return O0000Oo0.equalsIgnoreCase(f13513O000000o);
    }

    public static boolean O0000Oo() {
        return O0000Oo.equalsIgnoreCase(f13513O000000o);
    }

    public static boolean O0000OoO() {
        return O0000OoO.equalsIgnoreCase(f13513O000000o);
    }

    public static boolean O0000Ooo() {
        return O0000Ooo.equalsIgnoreCase(f13513O000000o);
    }

    public static boolean O0000o00() {
        return !O0000O0o();
    }

    public static boolean O0000o0() {
        return O0000OOo() || O0000Oo0() || O0000Oo() || O0000Ooo();
    }
}
