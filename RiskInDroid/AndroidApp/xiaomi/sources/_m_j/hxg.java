package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.onetrack.Configuration;
import com.xiaomi.onetrack.DataConverter;
import com.xiaomi.onetrack.OneTrack;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class hxg {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f948O000000o = "frame_index";
    static hya O00000Oo = new hya() {
        /* class _m_j.hxg.AnonymousClass1 */

        public final void O000000o(String str, JSONObject jSONObject, String str2, String str3) {
        }

        public final boolean O000000o() {
            return false;
        }

        public final void O000000o(String str, JSONObject jSONObject, String str2) {
            try {
                if (TextUtils.equals(str, "pgv2")) {
                    str = "view";
                }
                String O000000o2 = hxz.O000000o().O000000o(str, str2);
                if (TextUtils.isEmpty(O000000o2)) {
                    return;
                }
                if (!TextUtils.equals(str2, O000000o2)) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("tip", O000000o2);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (TextUtils.equals(next, hxg.f948O000000o)) {
                            int optInt = jSONObject.optInt(next, -1);
                            if (optInt >= 0) {
                                O000000o2 = hxg.O000000o(O000000o2, optInt);
                                jSONObject2.put("tip", O000000o2);
                            }
                        } else {
                            jSONObject2.put(next, jSONObject.opt(next));
                        }
                    }
                    hxg.O000000o(str, DataConverter.fromJson(jSONObject2));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private static OneTrack O00000o;
    private static final AtomicBoolean O00000o0 = new AtomicBoolean(false);
    private static OneTrack O00000oO;

    public static String O000000o(String str, int i) {
        String[] split = str.split("\\.");
        split[3] = String.valueOf(i);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < split.length; i2++) {
            sb.append(split[i2]);
            if (i2 < split.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    public static void O000000o(Context context) {
        if (O00000o0.compareAndSet(false, true)) {
            O00000o = OneTrack.createInstance(context, new Configuration.Builder().setAppId("2882303761517233197").setChannel(gfr.O0000o0O).setExceptionCatcherEnable(true).setMode(OneTrack.Mode.APP).build());
            O00000oO = OneTrack.createInstance(context, new Configuration.Builder().setAppId("2882303761517233197").setChannel(gfr.O0000o0O).setMode(OneTrack.Mode.PLUGIN).build());
            OneTrack.setDebugMode(gfr.f17662O000000o);
            gsy.O00000Oo(LogType.GENERAL, "OneTrackAnalytics", "init");
        }
    }

    public static void O000000o() {
        if (!OneTrack.isDisable() && O00000o0.get()) {
            O00000o.login(fcn.O000000o().O00000Oo(), OneTrack.UserIdType.XIAOMI, new HashMap());
            O00000oO.login(fcn.O000000o().O00000Oo(), OneTrack.UserIdType.XIAOMI, new HashMap());
        }
        LogType logType = LogType.GENERAL;
        gsy.O00000Oo(logType, "OneTrack", "login: isDisable = " + OneTrack.isDisable());
    }

    public static void O00000Oo() {
        if (O00000o0.get()) {
            O00000o.logout();
            O00000oO.logout();
        }
        LogType logType = LogType.GENERAL;
        gsy.O00000Oo(logType, "OneTrack", "logout: isDisable = " + OneTrack.isDisable());
    }

    public static void O000000o(String str, Map<String, Object> map) {
        try {
            if (O00000o0.get()) {
                O00000o.track(str, map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void O000000o(String str, String str2, Map<String, Object> map) {
        try {
            if (O00000o0.get()) {
                O00000oO.trackPluginEvent(str, str2, map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
