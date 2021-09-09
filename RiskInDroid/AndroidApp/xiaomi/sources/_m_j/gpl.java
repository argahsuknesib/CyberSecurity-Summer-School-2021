package _m_j;

import android.util.Log;
import com.xiaomi.smarthome.application.CommonApplication;
import java.util.Locale;
import org.json.JSONObject;

public final class gpl {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Locale f18125O000000o = new Locale("zh", "HK");

    public static String O000000o(JSONObject jSONObject) {
        return (String) O000000o(jSONObject, $$Lambda$gpl$Z54jTSkJ52PvkL0Fm6NsX8bAqD8.INSTANCE);
    }

    public static <T, E> T O000000o(Object obj, flg flg) {
        T t = null;
        if (obj == null) {
            return null;
        }
        Locale O00000o0 = ftn.O00000o0(CommonApplication.getAppContext());
        try {
            if (O000000o(O00000o0, Locale.CHINA)) {
                t = flg.getItem(obj, "zh_CN");
            } else if (O000000o(O00000o0, Locale.TRADITIONAL_CHINESE)) {
                t = flg.getItem(obj, "zh_TW");
            } else if (O000000o(O00000o0, f18125O000000o)) {
                t = flg.getItem(obj, "zh_HK");
            } else {
                t = flg.getItem(obj, O00000o0.getLanguage() + "_" + O00000o0.getCountry());
            }
            if (t == null) {
                if (O000000o(O00000o0, Locale.CHINA)) {
                    t = flg.getItem(obj, "zh_cn");
                } else if (O000000o(O00000o0, Locale.TRADITIONAL_CHINESE)) {
                    t = flg.getItem(obj, "zh_tw");
                } else if (O000000o(O00000o0, f18125O000000o)) {
                    t = flg.getItem(obj, "zh_hk");
                } else {
                    t = flg.getItem(obj, O00000o0.getLanguage() + "_" + O00000o0.getCountry());
                }
            }
            if (t == null) {
                String language = O00000o0.getLanguage();
                gsy.O00000Oo("LanguageUtils", "CardItem.getLanguageName loading getLanguage:".concat(String.valueOf(language)));
                t = flg.getItem(obj, language);
            }
            if (t == null) {
                String iSO3Language = O00000o0.getISO3Language();
                gsy.O00000Oo("LanguageUtils", "CardItem.getLanguageName loading iso3Language:".concat(String.valueOf(iSO3Language)));
                t = flg.getItem(obj, iSO3Language);
            }
            if (t == null) {
                String lowerCase = O00000o0.getCountry().toLowerCase(Locale.ENGLISH);
                gsy.O00000Oo("LanguageUtils", "CardItem.getLanguageName loading country:".concat(String.valueOf(lowerCase)));
                t = flg.getItem(obj, lowerCase);
            }
        } catch (Exception e) {
            gsy.O00000Oo("LanguageUtils", "CardItem.getLanguageName error:" + Log.getStackTraceString(e));
        }
        if (t == null) {
            T item = flg.getItem(obj, "en");
            gsy.O00000Oo("LanguageUtils", "CardItem.getLanguageName not match return default en:".concat(String.valueOf(item)));
            return item;
        }
        gsy.O00000Oo("LanguageUtils", "CardItem.getLanguageName match result:".concat(String.valueOf(t)));
        return t;
    }

    public static boolean O000000o(Locale locale, Locale locale2) {
        if (locale == locale2) {
            return true;
        }
        return locale != null && locale2 != null && locale.getLanguage().equalsIgnoreCase(locale2.getLanguage()) && locale.getCountry().equalsIgnoreCase(locale2.getCountry());
    }
}
