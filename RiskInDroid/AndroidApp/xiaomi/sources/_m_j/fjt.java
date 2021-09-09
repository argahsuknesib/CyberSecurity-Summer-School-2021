package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class fjt {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f16501O000000o = 1000;
    private static ArrayList<fjt> O00000o = new ArrayList<>();
    private static Map<String, Long> O00000oO = new ConcurrentHashMap();
    private static List<String> O00000oo = new ArrayList();
    private static List<String> O0000O0o = new ArrayList();
    private int O00000Oo;
    private String O00000o0;

    public static int O000000o(int i) {
        if (i == -2000 || i == -2001 || i == -2002 || i == -2003 || i == -30001 || i == -2 || i == -10) {
            return 0;
        }
        return i;
    }

    static {
        O00000o.add(new fjt(-99990000, "ip is empty"));
        O00000o.add(new fjt(-99991000, "Account type not supported!"));
        O00000o.add(new fjt(-99991001, "netRequest is null"));
        O00000o.add(new fjt(-99991002, "not loggedin"));
        O00000o.add(new fjt(-99991003, "uid or serviceToken is null!"));
        O00000o.add(new fjt(-99991004, "pair == null"));
        O00000o.add(new fjt(-99991005, "request == null"));
        O00000o.add(new fjt(-99991006, "net request failure"));
        O00000o.add(new fjt(-99991007, "Unable to resolve host"));
        O00000o.add(new fjt(-99992000, "unknown error"));
        O00000oo.add("lumi.acpartner.v2");
        O00000oo.add("lumi.gateway.v3");
        O00000oo.add("lumi.plug.v1");
        O00000oo.add("lumi.acpartner.v3");
        O00000oo.add("lumi.acpartner.v1");
        O00000oo.add("lumi.ctrl_86plug.v1");
        O00000oo.add("lumi.ctrl_86plug.aq1");
        O00000oo.add("lumi.curtain.v1");
        O00000oo.add("isa.camera.df3");
        O00000oo.add("isa.camera.qf3");
        O00000oo.add("isa.camera.isc5");
        O00000oo.add("isa.camera.isc5c1");
        O00000oo.add("isa.camera.hl5");
        O00000oo.add("nwt.derh.wdh318efw1");
    }

    private fjt(int i, String str) {
        this.O00000Oo = i;
        this.O00000o0 = str;
    }

    public static int O000000o(String str) {
        for (int i = 0; i < O00000o.size(); i++) {
            if (!TextUtils.isEmpty(str) && str.startsWith(O00000o.get(i).O00000o0)) {
                return O00000o.get(i).O00000Oo;
            }
        }
        return -99992000;
    }

    public static int O00000Oo(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str).optInt("code");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f9, code lost:
        return true;
     */
    public static boolean O000000o(String str, String str2, String str3) {
        synchronized (fjt.class) {
            Device O000000o2 = fjd.O000000o().O000000o(str);
            if (O000000o2 != null) {
                if (O00000oo.contains(O000000o2.getModel())) {
                    if (!eyr.O000000o(O000000o2.getModel(), true, 100, eyr.O00000Oo().O0000oOO)) {
                    }
                }
                String str4 = "";
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    str4 = jSONObject.optString("method") + "," + jSONObject.optString("params");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (TextUtils.isEmpty(str4)) {
                    return true;
                }
                String str5 = str + "," + str2 + "," + str4;
                Long valueOf = Long.valueOf(System.currentTimeMillis());
                gsy.O00000Oo(LogType.NETWORK, "checkRpcRequst", "request: " + str5 + ", time = " + valueOf);
                for (Map.Entry next : O00000oO.entrySet()) {
                    Long l = (Long) next.getValue();
                    if (TextUtils.equals(str5, (CharSequence) next.getKey())) {
                        if (!O000000o(O000000o2.getModel(), valueOf, l)) {
                            return false;
                        }
                        next.setValue(valueOf);
                        return true;
                    } else if (O000000o(O000000o2.getModel(), valueOf, l)) {
                        O00000oO.remove(next.getKey());
                    }
                }
                O00000oO.put(str5, valueOf);
                return true;
            }
        }
    }

    private static boolean O000000o(String str, Long l, Long l2) {
        return l.longValue() - l2.longValue() >= ((long) eyr.O00000Oo().O0000OoO(str));
    }

    public static void O00000o0(String str) {
        synchronized (fjt.class) {
            if (!O00000oO(str)) {
                O0000O0o.add(str);
            }
        }
    }

    public static void O00000o(String str) {
        synchronized (fjt.class) {
            if (O00000oO(str)) {
                O0000O0o.remove(str);
            }
        }
    }

    public static boolean O00000oO(String str) {
        boolean contains;
        synchronized (fjt.class) {
            contains = O0000O0o.contains(str);
        }
        return contains;
    }
}
