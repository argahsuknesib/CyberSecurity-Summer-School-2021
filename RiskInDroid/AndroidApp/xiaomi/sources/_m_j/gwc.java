package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class gwc {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Locale f18401O000000o = gpl.f18125O000000o;
    public static final Locale O00000Oo = new Locale("ko", "KR");
    public static final Locale O00000o = new Locale("ru", "RU");
    public static final Locale O00000o0 = new Locale("es", "ES");
    public static final Locale O00000oO = new Locale("pl", "PL");
    public static final Locale O00000oo = new Locale("vi", "VN");
    public static final Locale O0000O0o = new Locale("th", "TH");
    public static final Locale O0000OOo = new Locale("ar", "AE");
    public static final Locale O0000Oo = new Locale("en", "GB");
    public static final Locale O0000Oo0 = new Locale("in", "ID");
    public static final Locale O0000OoO = new Locale("pt", "BR");
    public static final Locale O0000Ooo = new Locale("tr", "TR");
    public static final Set<Locale> O0000o0;
    public static final Locale O0000o00 = new Locale("nl", "NL");

    static {
        HashSet hashSet = new HashSet();
        O0000o0 = hashSet;
        hashSet.add(new Locale("ca", "AD"));
        O0000o0.add(new Locale("ca", "FR"));
        O0000o0.add(new Locale("ca", "ES"));
        O0000o0.add(new Locale("ca", "IT"));
        O0000o0.add(new Locale("sq", "AL"));
        O0000o0.add(new Locale("sq", "MK"));
        O0000o0.add(new Locale("de", "AT"));
        O0000o0.add(new Locale("sv", "AX"));
        O0000o0.add(new Locale("sv", "SE"));
        O0000o0.add(new Locale("sv", "FI"));
        O0000o0.add(new Locale("hr", "BA"));
        O0000o0.add(new Locale("sr", "BA"));
        O0000o0.add(new Locale("nl", "BE"));
        O0000o0.add(new Locale("fr", "BE"));
        O0000o0.add(new Locale("de", "BE"));
        O0000o0.add(new Locale("en", "BE"));
        O0000o0.add(new Locale("bg", "BG"));
        O0000o0.add(new Locale("be", "BY"));
        O0000o0.add(new Locale("de", "CH"));
        O0000o0.add(new Locale("fr", "CH"));
        O0000o0.add(new Locale("it", "CH"));
        O0000o0.add(new Locale("el", "CY"));
        O0000o0.add(new Locale("cs", "CZ"));
        O0000o0.add(new Locale("da", "DK"));
        O0000o0.add(new Locale("et", "EE"));
        O0000o0.add(new Locale("fi", "FI"));
        O0000o0.add(new Locale("fo", "FO"));
        O0000o0.add(new Locale("fr", "GF"));
        O0000o0.add(new Locale("da", "GL"));
        O0000o0.add(new Locale("kl", "GL"));
        O0000o0.add(new Locale("el", "GR"));
        O0000o0.add(new Locale("hr", "HR"));
        O0000o0.add(new Locale("hu", "HU"));
        O0000o0.add(new Locale("ga", "IE"));
        O0000o0.add(new Locale("en", "IE"));
        O0000o0.add(new Locale("en", "IM"));
        O0000o0.add(new Locale("is", "IS"));
        O0000o0.add(new Locale("en", "JE"));
        O0000o0.add(new Locale("de", "LI"));
        O0000o0.add(new Locale("lt", "LT"));
        O0000o0.add(new Locale("fr", "LU"));
        O0000o0.add(new Locale("de", "LU"));
        O0000o0.add(new Locale("lv", "LV"));
        O0000o0.add(new Locale("fr", "MC"));
        O0000o0.add(new Locale("ro", "MD"));
        O0000o0.add(new Locale("ru", "MD"));
        O0000o0.add(new Locale("sr", "ME"));
        O0000o0.add(new Locale("mk", "MK"));
        O0000o0.add(new Locale("mt", "MT"));
        O0000o0.add(new Locale("no", "NO"));
        O0000o0.add(new Locale("nb", "NO"));
        O0000o0.add(new Locale("nn", "NO"));
        O0000o0.add(new Locale("ro", "RO"));
        O0000o0.add(new Locale("sr", "RS"));
        O0000o0.add(new Locale("sl", "SI"));
        O0000o0.add(new Locale("nb", "SJ"));
        O0000o0.add(new Locale("sk", "SK"));
        O0000o0.add(new Locale("it", "SM"));
        O0000o0.add(new Locale("uk", "UA"));
        O0000o0.add(new Locale("it", "VA"));
        O0000o0.add(new Locale("en", "GG"));
        O0000o0.add(new Locale("en", "GB"));
        O0000o0.add(new Locale("pt", "PT"));
    }

    public static boolean O000000o(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.xiaomi.smarthome.globaldynamicsetting", 0);
        String string = sharedPreferences.getString("locale_language", "");
        String string2 = sharedPreferences.getString("locale_country", "");
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            return true;
        }
        return false;
    }

    public static void O000000o() {
        if (CoreApi.O000000o().O00oOooo() == null) {
            O000000o(0, (fsm<Void, fso>) null);
        }
    }

    public static Locale O000000o(int i, fsm<Void, fso> fsm) {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = Resources.getSystem().getConfiguration().getLocales().get(0);
        } else {
            locale = Locale.getDefault();
        }
        switch (i) {
            case 0:
                fdc.O000000o().O000000o((Locale) null, fsm);
                O00000o0(locale);
                return locale;
            case 1:
                fdc.O000000o().O000000o(Locale.CHINA, fsm);
                O00000o0(Locale.CHINA);
                return Locale.CHINA;
            case 2:
                fdc.O000000o().O000000o(Locale.TRADITIONAL_CHINESE, fsm);
                O00000o0(Locale.TRADITIONAL_CHINESE);
                return Locale.TRADITIONAL_CHINESE;
            case 3:
                fdc.O000000o().O000000o(Locale.US, fsm);
                O00000o0(Locale.US);
                return Locale.US;
            case 4:
                fdc.O000000o().O000000o(f18401O000000o, fsm);
                O00000o0(f18401O000000o);
                return f18401O000000o;
            case 5:
                fdc.O000000o().O000000o(O00000Oo, fsm);
                O00000o0(O00000Oo);
                return O00000Oo;
            case 6:
                fdc.O000000o().O000000o(O00000o0, fsm);
                O00000o0(O00000o0);
                return O00000o0;
            case 7:
                fdc.O000000o().O000000o(O00000o, fsm);
                O00000o0(O00000o);
                return O00000o;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                fdc.O000000o().O000000o(Locale.FRANCE, fsm);
                O00000o0(Locale.FRANCE);
                return Locale.FRANCE;
            case 9:
                fdc.O000000o().O000000o(Locale.ITALY, fsm);
                O00000o0(Locale.ITALY);
                return Locale.ITALY;
            case 10:
                fdc.O000000o().O000000o(Locale.GERMANY, fsm);
                O00000o0(Locale.GERMANY);
                return Locale.GERMANY;
            case 11:
                fdc.O000000o().O000000o(O0000Oo0, fsm);
                O00000o0(O0000Oo0);
                return O0000Oo0;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT:
                fdc.O000000o().O000000o(O00000oO, fsm);
                O00000o0(O00000oO);
                return O00000oO;
            case 13:
                fdc.O000000o().O000000o(O00000oo, fsm);
                O00000o0(O00000oo);
                return O00000oo;
            case 14:
                fdc.O000000o().O000000o(Locale.JAPAN, fsm);
                O00000o0(Locale.JAPAN);
                return Locale.JAPAN;
            case GmsLogger.MAX_PII_TAG_LENGTH:
                fdc.O000000o().O000000o(O0000O0o, fsm);
                O00000o0(O0000O0o);
                return O0000O0o;
            case 16:
                fdc.O000000o().O000000o(O0000o00, fsm);
                O00000o0(O0000o00);
                return O0000o00;
            case 17:
                fdc.O000000o().O000000o(O0000OoO, fsm);
                O00000o0(O0000OoO);
                return O0000OoO;
            case 18:
                fdc.O000000o().O000000o(O0000Ooo, fsm);
                O00000o0(O0000Ooo);
                return O0000Ooo;
            default:
                fdc.O000000o().O000000o((Locale) null, fsm);
                O00000o0(locale);
                return locale;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gwc.O000000o(java.util.Locale, boolean):void
     arg types: [java.util.Locale, int]
     candidates:
      _m_j.gwc.O000000o(android.content.Context, java.util.Locale):android.content.Context
      _m_j.gwc.O000000o(android.content.res.Resources, java.util.Locale):android.content.res.Resources
      _m_j.gwc.O000000o(int, java.lang.Object[]):java.lang.String
      _m_j.gwc.O000000o(java.util.Locale, java.lang.String):java.lang.String
      _m_j.gwc.O000000o(int, _m_j.fsm<java.lang.Void, _m_j.fso>):java.util.Locale
      _m_j.gwc.O000000o(java.util.Locale, java.util.Locale):boolean
      _m_j.gwc.O000000o(java.util.Locale, boolean):void */
    private static void O00000o0(Locale locale) {
        if (!O0000o0.contains(O00000Oo()) || !gpl.O000000o(O0000Oo, CommonApplication.getAppContext().getResources().getConfiguration().locale)) {
            boolean O000000o2 = O000000o(CommonApplication.getAppContext());
            if (gpl.O000000o(O0000Oo, CommonApplication.getAppContext().getResources().getConfiguration().locale) && !O000000o2) {
                O000000o(Locale.US, true);
            } else if (!gpl.O000000o(locale, CommonApplication.getAppContext().getResources().getConfiguration().locale)) {
                O000000o(locale, true);
            }
        }
    }

    public static Locale O00000Oo() {
        if (Build.VERSION.SDK_INT >= 24) {
            return Resources.getSystem().getConfiguration().getLocales().get(0);
        }
        return Locale.getDefault();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gwc.O000000o(java.util.Locale, boolean):void
     arg types: [java.util.Locale, int]
     candidates:
      _m_j.gwc.O000000o(android.content.Context, java.util.Locale):android.content.Context
      _m_j.gwc.O000000o(android.content.res.Resources, java.util.Locale):android.content.res.Resources
      _m_j.gwc.O000000o(int, java.lang.Object[]):java.lang.String
      _m_j.gwc.O000000o(java.util.Locale, java.lang.String):java.lang.String
      _m_j.gwc.O000000o(int, _m_j.fsm<java.lang.Void, _m_j.fso>):java.util.Locale
      _m_j.gwc.O000000o(java.util.Locale, java.util.Locale):boolean
      _m_j.gwc.O000000o(java.util.Locale, boolean):void */
    public static void O000000o(Locale locale) {
        O000000o(locale, true);
    }

    private static void O000000o(Locale locale, boolean z) {
        Context appContext = CommonApplication.getAppContext();
        if (appContext != null) {
            boolean O000000o2 = O000000o(appContext);
            if (O0000o0.contains(O00000Oo())) {
                if (O000000o2) {
                    locale = O0000Oo;
                } else if (gpl.O000000o(Locale.US, locale)) {
                    locale = O0000Oo;
                }
            } else if (gpl.O000000o(O0000Oo, locale)) {
                if (O000000o2) {
                    locale = O00000Oo();
                } else {
                    locale = Locale.US;
                }
            }
            try {
                Resources resources = appContext.getResources();
                Configuration configuration = resources.getConfiguration();
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                configuration.locale = locale;
                resources.updateConfiguration(configuration, displayMetrics);
                if (ftm.O000000o(appContext) && z) {
                    fno.O000000o().O0000o0O();
                }
            } catch (Exception unused) {
            }
            Intent intent = new Intent("action_locale_changed");
            intent.putExtra("key_isForeGround", z);
            ft.O000000o(appContext).O000000o(intent);
        }
    }

    public static void O000000o(boolean z) {
        Locale O00000o02 = ftn.O00000o0(CommonApplication.getAppContext());
        if (O00000o02 != null) {
            O000000o(O00000o02, z);
        }
    }

    public static Locale O00000o0() {
        Context appContext = CommonApplication.getAppContext();
        Locale locale = null;
        if (appContext == null) {
            return null;
        }
        if (CoreApi.O000000o().O0000O0o()) {
            locale = CoreApi.O000000o().O00oOooo();
        }
        if (locale == null && appContext != null) {
            locale = ftn.O00000o0(appContext);
        }
        if (locale == null) {
            return locale;
        }
        boolean O000000o2 = O000000o(appContext);
        if (O0000o0.contains(O00000Oo())) {
            if (O000000o2) {
                return O0000Oo;
            }
            if (gpl.O000000o(Locale.US, locale)) {
                return O0000Oo;
            }
            return locale;
        } else if (!gpl.O000000o(O0000Oo, locale)) {
            return locale;
        } else {
            if (O000000o2) {
                return O00000Oo();
            }
            return Locale.US;
        }
    }

    public static Context O000000o(Context context, Locale locale) {
        Configuration configuration = context.getResources().getConfiguration();
        if (Build.VERSION.SDK_INT < 17) {
            return context;
        }
        try {
            configuration.setLocale(locale);
            return context.createConfigurationContext(configuration);
        } catch (Exception unused) {
            return context;
        }
    }

    public static Context O00000Oo(Context context) {
        Context appContext = CommonApplication.getAppContext();
        if (appContext == null) {
            appContext = context;
        }
        if (Build.VERSION.SDK_INT < 17) {
            return context;
        }
        Locale locale = null;
        if (CoreApi.O000000o().O0000O0o()) {
            locale = CoreApi.O000000o().O00oOooo();
        }
        if (locale == null && appContext != null) {
            locale = ftn.O00000o0(appContext);
        }
        if (locale == null) {
            return context;
        }
        boolean O000000o2 = O000000o(appContext);
        if (O0000o0.contains(O00000Oo())) {
            if (O000000o2) {
                locale = O0000Oo;
            } else if (gpl.O000000o(Locale.US, locale)) {
                locale = O0000Oo;
            }
        } else if (gpl.O000000o(O0000Oo, locale)) {
            if (O000000o2) {
                locale = O00000Oo();
            } else {
                locale = Locale.US;
            }
        }
        return O000000o(context, locale);
    }

    public static boolean O000000o(Locale locale, Locale locale2) {
        return gpl.O000000o(locale, locale2);
    }

    public static DateFormat O000000o(Activity activity) {
        return SimpleDateFormat.getDateTimeInstance(3, 3, ftn.O00000o0(activity.getApplicationContext()));
    }

    public static String O00000Oo(Locale locale) {
        return O000000o(locale, "/");
    }

    public static String O000000o(Locale locale, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "/";
        }
        if (gpl.O000000o(locale, Locale.CHINA) || gpl.O000000o(locale, Locale.TRADITIONAL_CHINESE) || gpl.O000000o(locale, f18401O000000o)) {
            return "yyyy年MM月dd日";
        }
        if (gpl.O000000o(locale, O00000Oo)) {
            return "yyyy년MM월dd일";
        }
        if (gpl.O000000o(locale, O00000o0) || gpl.O000000o(locale, O00000oo) || gpl.O000000o(locale, O0000Oo0) || gpl.O000000o(locale, O00000o) || gpl.O000000o(locale, O0000Ooo) || gpl.O000000o(locale, O0000o00) || gpl.O000000o(locale, O0000OoO) || gpl.O000000o(locale, Locale.FRANCE)) {
            return "dd" + str + "MM" + str + "yyyy";
        }
        return "MM" + str + "dd" + str + "yyyy";
    }

    public static Resources O000000o(Resources resources, Locale locale) {
        if (locale == null) {
            return resources;
        }
        try {
            Configuration configuration = new Configuration(resources.getConfiguration());
            configuration.locale = locale;
            return new Resources(resources.getAssets(), resources.getDisplayMetrics(), configuration);
        } catch (Exception unused) {
            return resources;
        }
    }

    public static String O000000o(int i) {
        Locale O00000o02 = ftn.O00000o0(CommonApplication.getAppContext());
        if (O00000o02 == null) {
            return CommonApplication.getAppContext().getResources().getString(i);
        }
        try {
            return O000000o(CommonApplication.getAppContext().getResources(), O00000o02).getString(i);
        } catch (Exception unused) {
            return CommonApplication.getAppContext().getResources().getString(i);
        }
    }

    public static String O000000o(int i, Object... objArr) {
        Locale O00000o02 = ftn.O00000o0(CommonApplication.getAppContext());
        if (O00000o02 == null) {
            return CommonApplication.getAppContext().getResources().getString(i, objArr);
        }
        try {
            return O000000o(CommonApplication.getAppContext().getResources(), O00000o02).getString(i, objArr);
        } catch (Exception unused) {
            return CommonApplication.getAppContext().getResources().getString(i, objArr);
        }
    }

    public static String O00000o() {
        Locale O00000o02 = ftn.O00000o0(CommonApplication.getAppContext());
        O00000Oo();
        String str = gpl.O000000o(O00000o02, Locale.CHINA) ? "zh" : "us";
        return "location" + "/" + str + "/" + "cityWeather.json";
    }
}
