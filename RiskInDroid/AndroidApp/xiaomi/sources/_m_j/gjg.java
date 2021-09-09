package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class gjg {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Map<String, ServerBean> f17843O000000o = new o0O0OOO0();
    private static final Map<String, ServerBean> O00000Oo = new o0O0OOO0();
    private static final Map<String, ServerBean> O00000o = new o0O0OOO0();
    private static final Map<String, ServerBean> O00000o0 = new o0O0OOO0();
    private static final Map<String, ServerBean> O00000oO = new o0O0OOO0();
    private static final Map<String, ServerBean> O00000oo = new o0O0OOO0();
    private static final Map<String, ServerBean> O0000O0o = new o0O0OOO0();
    private static final Map<String, ServerBean> O0000OOo = new o0O0OOO0();
    private static final Map<String, ServerBean> O0000Oo0 = new o0O0OOO0();

    private static void O00000o0() {
        if (O00000oo.isEmpty()) {
            O00000oO.put("Asia/Taipei".toLowerCase(), ftn.O00000Oo());
            O00000Oo.put("Asia/Hong_Kong".toLowerCase(), ftn.O00000o0());
            O00000o0.put("Asia/Seoul".toLowerCase(), ftn.O0000OOo());
            ServerBean O00000oO2 = ftn.O00000oO();
            O0000O0o.put("Asia/Kathmandu".toLowerCase(), O00000oO2);
            O0000O0o.put("Asia/Kolkata".toLowerCase(), O00000oO2);
            O0000O0o.put("ASIA/CALCUTTA".toLowerCase(), O00000oO2);
            ServerBean O000000o2 = ftn.O000000o();
            f17843O000000o.put("Asia/Shanghai".toLowerCase(), O000000o2);
            f17843O000000o.put("Asia/Chungking".toLowerCase(), O000000o2);
            f17843O000000o.put("Asia/Chongqing".toLowerCase(), O000000o2);
            f17843O000000o.put("Asia/Urumqi".toLowerCase(), O000000o2);
            f17843O000000o.put("Asia/Kashgar".toLowerCase(), O000000o2);
            f17843O000000o.put("Asia/Harbin".toLowerCase(), O000000o2);
            ServerBean O00000oo2 = ftn.O00000oo();
            O0000OOo.put("America/Adak".toLowerCase(), O00000oo2);
            O0000OOo.put("America/Anchorage".toLowerCase(), O00000oo2);
            O0000OOo.put("America/Los_Angeles".toLowerCase(), O00000oo2);
            O0000OOo.put("America/Denver".toLowerCase(), O00000oo2);
            O0000OOo.put("America/Chicago".toLowerCase(), O00000oo2);
            O0000OOo.put("America/New_York".toLowerCase(), O00000oo2);
            O0000OOo.put("America/Yakutat".toLowerCase(), O00000oo2);
            O0000OOo.put("America/Sitka".toLowerCase(), O00000oo2);
            O0000OOo.put("America/Nome".toLowerCase(), O00000oo2);
            O0000OOo.put("America/North_Dakota/New_Salem".toLowerCase(), O00000oo2);
            O0000OOo.put("America/Menominee".toLowerCase(), O00000oo2);
            O0000OOo.put("America/Metlakatla".toLowerCase(), O00000oo2);
            O0000OOo.put("America/Indiana/Vevay".toLowerCase(), O00000oo2);
            O0000OOo.put("America/Indiana/Winamac".toLowerCase(), O00000oo2);
            O0000OOo.put("America/Indiana/Vincennes".toLowerCase(), O00000oo2);
            O0000OOo.put("America/Anchorage".toLowerCase(), O00000oo2);
            O0000OOo.put("America/Juneau".toLowerCase(), O00000oo2);
            O0000OOo.put("America/Detroit".toLowerCase(), O00000oo2);
            O0000OOo.put("America/North_Dakota/Center".toLowerCase(), O00000oo2);
            O0000OOo.put("America/Indiana/Indianapolis".toLowerCase(), O00000oo2);
            O0000OOo.put("America/Phoenix".toLowerCase(), O00000oo2);
            O0000OOo.put("America/Kentucky/Monticello".toLowerCase(), O00000oo2);
            O0000OOo.put("America/Kentucky/Louisville".toLowerCase(), O00000oo2);
            O0000OOo.put("America/Indiana/Marengo".toLowerCase(), O00000oo2);
            O0000OOo.put("America/Honolulu".toLowerCase(), O00000oo2);
            O0000OOo.put("America/Indiana/Petersburg".toLowerCase(), O00000oo2);
            O0000OOo.put("America/Indiana/Tell_City".toLowerCase(), O00000oo2);
            O0000OOo.put("America/Indiana/Knox".toLowerCase(), O00000oo2);
            O0000OOo.put("America/North_Dakota/Beulah".toLowerCase(), O00000oo2);
            O0000OOo.put("America/Boise".toLowerCase(), O00000oo2);
            ServerBean O0000Oo02 = ftn.O0000Oo0();
            O00000o.put("Europe/Volgograd".toLowerCase(), O0000Oo02);
            O00000o.put("Asia/Vladivostok".toLowerCase(), O0000Oo02);
            O00000o.put("Asia/Ust-Nera".toLowerCase(), O0000Oo02);
            O00000o.put("Europe/Simferopol".toLowerCase(), O0000Oo02);
            O00000o.put("Asia/Yekaterinburg".toLowerCase(), O0000Oo02);
            O00000o.put("Asia/Omsk".toLowerCase(), O0000Oo02);
            O00000o.put("Europe/Moscow".toLowerCase(), O0000Oo02);
            O00000o.put("Asia/Irkutsk".toLowerCase(), O0000Oo02);
            O00000o.put("Asia/Krasnoyarsk".toLowerCase(), O0000Oo02);
            O00000o.put("Asia/Magadan".toLowerCase(), O0000Oo02);
            O00000o.put("Asia/Novosibirsk".toLowerCase(), O0000Oo02);
            O00000o.put("Europe/Kaliningrad".toLowerCase(), O0000Oo02);
            O00000o.put("Europe/Samara".toLowerCase(), O0000Oo02);
            O00000o.put("Asia/Sakhalin".toLowerCase(), O0000Oo02);
            O00000o.put("Asia/Khandyga".toLowerCase(), O0000Oo02);
            O00000o.put("Asia/Novokuznetsk".toLowerCase(), O0000Oo02);
            O00000o.put("Asia/Yakutsk".toLowerCase(), O0000Oo02);
            O00000o.put("Asia/Anadyr".toLowerCase(), O0000Oo02);
            O00000o.put("Asia/Kamchatka".toLowerCase(), O0000Oo02);
            ServerBean O0000O0o2 = ftn.O0000O0o();
            O00000oo.put("Europe/Vienna".toLowerCase(), O0000O0o2);
            O00000oo.put("Europe/Brussels".toLowerCase(), O0000O0o2);
            O00000oo.put("Europe/Sofia".toLowerCase(), O0000O0o2);
            O00000oo.put("Asia/Nicosia".toLowerCase(), O0000O0o2);
            O00000oo.put("Europe/Zagreb".toLowerCase(), O0000O0o2);
            O00000oo.put("Europe/Prague".toLowerCase(), O0000O0o2);
            O00000oo.put("Europe/Copenhagen".toLowerCase(), O0000O0o2);
            O00000oo.put("Europe/Tallinn".toLowerCase(), O0000O0o2);
            O00000oo.put("Europe/Helsinki".toLowerCase(), O0000O0o2);
            O00000oo.put("Europe/Paris".toLowerCase(), O0000O0o2);
            O00000oo.put("Europe/Busingen".toLowerCase(), O0000O0o2);
            O00000oo.put("Europe/Berlin".toLowerCase(), O0000O0o2);
            O00000oo.put("Europe/Athens".toLowerCase(), O0000O0o2);
            O00000oo.put("Europe/Budapest".toLowerCase(), O0000O0o2);
            O00000oo.put("Europe/Dublin".toLowerCase(), O0000O0o2);
            O00000oo.put("Europe/Rome".toLowerCase(), O0000O0o2);
            O00000oo.put("Europe/Riga".toLowerCase(), O0000O0o2);
            O00000oo.put("Europe/Vilnius".toLowerCase(), O0000O0o2);
            O00000oo.put("Europe/Luxembourg".toLowerCase(), O0000O0o2);
            O00000oo.put("Europe/Malta".toLowerCase(), O0000O0o2);
            O00000oo.put("Europe/Amsterdam".toLowerCase(), O0000O0o2);
            O00000oo.put("Europe/Warsaw".toLowerCase(), O0000O0o2);
            O00000oo.put("Atlantic/Madeira".toLowerCase(), O0000O0o2);
            O00000oo.put("Europe/Lisbon".toLowerCase(), O0000O0o2);
            O00000oo.put("Atlantic/Azores".toLowerCase(), O0000O0o2);
            O00000oo.put("Europe/Bucharest".toLowerCase(), O0000O0o2);
            O00000oo.put("Europe/Bratislava".toLowerCase(), O0000O0o2);
            O00000oo.put("Europe/Ljubljana".toLowerCase(), O0000O0o2);
            O00000oo.put("Europe/Madrid".toLowerCase(), O0000O0o2);
            O00000oo.put("Atlantic/Canary".toLowerCase(), O0000O0o2);
            O00000oo.put("Africa/Ceuta".toLowerCase(), O0000O0o2);
            O00000oo.put("Europe/Stockholm".toLowerCase(), O0000O0o2);
            O00000oo.put("Europe/London".toLowerCase(), O0000O0o2);
        }
    }

    public static ServerBean O000000o() {
        if (grr.O00000oO() && goy.O000000o()) {
            String O00000o02 = goy.O00000o0();
            if (!"CN".equalsIgnoreCase(O00000o02)) {
                if (!TextUtils.isEmpty(O00000o02)) {
                    for (ServerBean next : ftn.O000000o(ftn.O00000o0(ServiceApplication.getAppContext()), ServiceApplication.getAppContext())) {
                        if (next.O00000Oo.equalsIgnoreCase(O00000o02)) {
                            return next;
                        }
                    }
                }
                return null;
            }
        }
        if (!ftn.O00000o0(O00000o())) {
            return O00000o();
        }
        Locale O00oOooo = CoreApi.O000000o().O00oOooo();
        if (O00oOooo == null) {
            O00oOooo = Locale.getDefault();
        }
        if (O00oOooo == null) {
            return null;
        }
        String country = O00oOooo.getCountry();
        try {
            for (ServerBean next2 : ftn.O000000o(ftn.O00000o0(ServiceApplication.getAppContext()), ServiceApplication.getAppContext())) {
                if (next2.O00000Oo.equalsIgnoreCase(country)) {
                    return (ServerBean) next2.clone();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean O00000Oo() {
        Locale locale;
        if ((grr.O00000oO() && goy.O000000o() && !"CN".equalsIgnoreCase(goy.O00000o0())) || !ftn.O00000o0(O00000o())) {
            return false;
        }
        if (CoreApi.O000000o().O0000O0o()) {
            locale = CoreApi.O000000o().O00oOooo();
        } else {
            locale = ftn.O00000o0(ServiceApplication.getAppContext());
        }
        if (locale == null) {
            locale = Locale.getDefault();
        }
        if (gwc.O000000o(locale, Locale.CHINA) || gwc.O000000o(locale, Locale.CHINESE)) {
            return true;
        }
        return false;
    }

    private static ServerBean O00000o() {
        O00000o0();
        String id = TimeZone.getDefault().getID();
        gsy.O00000Oo("hzd1", "id=".concat(String.valueOf(id)));
        if (TextUtils.isEmpty(id)) {
            return ftn.O000000o();
        }
        String lowerCase = id.toLowerCase();
        if (f17843O000000o.containsKey(lowerCase)) {
            return ftn.O000000o();
        }
        if (O00000oo.containsKey(lowerCase)) {
            return ftn.O0000O0o();
        }
        if (O00000Oo.containsKey(lowerCase)) {
            return ftn.O00000o0();
        }
        if (O0000O0o.containsKey(lowerCase)) {
            return ftn.O00000oO();
        }
        if (O00000o0.containsKey(lowerCase)) {
            return ftn.O0000OOo();
        }
        if (O00000o.containsKey(lowerCase)) {
            return ftn.O0000Oo0();
        }
        if (O00000oO.containsKey(lowerCase)) {
            return ftn.O00000Oo();
        }
        if (O0000OOo.containsKey(lowerCase)) {
            return ftn.O00000oo();
        }
        return ftn.O00000o();
    }
}
