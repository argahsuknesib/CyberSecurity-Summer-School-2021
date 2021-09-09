package _m_j;

import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import java.util.Locale;
import org.json.JSONObject;

public final class flk {
    public static Locale O000000o() {
        Locale O00000Oo = fcr.O000000o().O00000Oo();
        return O00000Oo == null ? O00000Oo() : O00000Oo;
    }

    public static Locale O00000Oo() {
        if (Build.VERSION.SDK_INT >= 24) {
            return CommonApplication.getAppContext().getResources().getConfiguration().getLocales().get(0);
        }
        return Locale.getDefault();
    }

    public static String O000000o(Locale locale) {
        if (locale == null) {
            return "";
        }
        String language = locale.getLanguage();
        if (TextUtils.equals("iw", language)) {
            language = "he";
        } else if (TextUtils.equals("ji", language)) {
            language = "yi";
        } else if (TextUtils.equals("in", language)) {
            language = "id";
        }
        String country = locale.getCountry();
        if (TextUtils.isEmpty(country)) {
            return language;
        }
        return language + "_" + country;
    }

    public static String O000000o(JSONObject jSONObject) {
        Locale O000000o2 = O000000o();
        String language = O000000o2.getLanguage();
        String country = O000000o2.getCountry();
        String optString = jSONObject.optString(language + "_" + country.toUpperCase(Locale.ENGLISH));
        if (!TextUtils.isEmpty(optString)) {
            return optString;
        }
        String optString2 = jSONObject.optString(language + "_" + country.toLowerCase(Locale.ENGLISH));
        if (!TextUtils.isEmpty(optString2)) {
            return optString2;
        }
        String optString3 = jSONObject.optString(language);
        if (!TextUtils.isEmpty(optString3)) {
            return optString3;
        }
        String optString4 = jSONObject.optString(O000000o2.getISO3Language());
        if (!TextUtils.isEmpty(optString4)) {
            return optString4;
        }
        String optString5 = jSONObject.optString(country);
        return TextUtils.isEmpty(optString5) ? jSONObject.optString("en") : optString5;
    }
}
