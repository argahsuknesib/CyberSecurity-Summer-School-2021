package _m_j;

import android.content.res.ColorStateList;
import android.util.StateSet;
import java.util.Locale;

public class dbv {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f14461O000000o = "_m_j.dbv";
    private static final String[] O00000Oo = {"drawable-xxhdpi", "drawable-xhdpi", "drawable-hdpi", "drawable-mdpi", "drawable-ldpi", "drawable"};

    public static ColorStateList O000000o() {
        return new ColorStateList(new int[][]{new int[]{16842919}, new int[]{16842913}, new int[]{16842908}, StateSet.WILD_CARD}, new int[]{1728020992, 1728020992, 1728020992, -32256});
    }

    public static String O000000o(String str, String str2, String str3) {
        Locale locale = Locale.getDefault();
        if (!Locale.SIMPLIFIED_CHINESE.equals(locale) && !Locale.TRADITIONAL_CHINESE.equals(locale) && (!locale.getLanguage().equals("zh") || (!locale.getCountry().contains("CN") && !locale.getCountry().contains("TW")))) {
            locale = Locale.ENGLISH;
        }
        if (Locale.SIMPLIFIED_CHINESE.equals(locale) || ("zh".equals(locale.getLanguage()) && locale.getCountry().contains("CN"))) {
            return str2;
        }
        return (Locale.TRADITIONAL_CHINESE.equals(locale) || ("zh".equals(locale.getLanguage()) && locale.getCountry().contains("TW"))) ? str3 : str;
    }
}
