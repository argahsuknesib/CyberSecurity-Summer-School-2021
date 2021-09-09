package _m_j;

import com.xiaomi.smarthome.framework.statistic.BindStep;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class hxc {
    private static volatile hxc O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public Map<String, O000000o> f940O000000o = new HashMap();

    private hxc() {
    }

    public static hxc O000000o() {
        if (O00000Oo == null) {
            synchronized (hxc.class) {
                if (O00000Oo == null) {
                    O00000Oo = new hxc();
                }
            }
        }
        return O00000Oo;
    }

    public static boolean O000000o(String str) {
        return flu.O00000oO().O00000Oo(str);
    }

    public final void O00000Oo(String str) {
        if (str != null) {
            this.f940O000000o.remove(str);
        }
    }

    public final void O00000o0(String str, BindStep bindStep) {
        O000000o(str, bindStep, (Integer) null, (String) null);
    }

    public final void O000000o(String str, BindStep bindStep, String str2) {
        O000000o(str, bindStep, (Integer) null, str2);
    }

    public final void O000000o(String str, BindStep bindStep, int i, String str2) {
        O000000o(str, bindStep, Integer.valueOf(i), str2);
    }

    /* renamed from: _m_j.hxc$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f941O000000o = new int[BindStep.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f941O000000o[BindStep.STEP_RESET_DEVICE.ordinal()] = 1;
            f941O000000o[BindStep.STEP_SCAN_DEVICE.ordinal()] = 2;
            f941O000000o[BindStep.STEP_INPUT_CONFIG.ordinal()] = 3;
            f941O000000o[BindStep.STEP_TRANSFER_CONFIG.ordinal()] = 4;
            f941O000000o[BindStep.STEP_CHECK_BIND.ordinal()] = 5;
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        String f942O000000o;
        int O00000Oo;
        public Map<BindStep, O00000Oo> O00000o = new HashMap();
        int O00000o0;
        List<O00000Oo> O00000oO = new ArrayList();

        private static JSONObject O000000o(O00000Oo o00000Oo) {
            int i = AnonymousClass1.f941O000000o[o00000Oo.f943O000000o.ordinal()];
            String str = i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "t5" : "t4" : "t3" : "t2" : "t1";
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("t", str);
                jSONObject.put("spending", o00000Oo.O00000o0 - o00000Oo.O00000o);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("start_time", o00000Oo.O00000Oo);
                jSONObject2.put("end_time", o00000Oo.O00000o0);
                if (o00000Oo.O00000oo != null) {
                    jSONObject2.put("error_code", o00000Oo.O00000oo);
                }
                if (o00000Oo.O0000O0o != null) {
                    jSONObject2.put("error_message", o00000Oo.O0000O0o);
                }
                jSONObject.put("extra", jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }

        O000000o(String str, int i) {
            this.f942O000000o = str;
            this.O00000Oo = i;
            this.O00000o0 = flu.O00000oO().O000000o(str);
        }

        /* access modifiers changed from: package-private */
        public final JSONObject O000000o() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("model", this.f942O000000o);
                jSONObject.put("sc_type", this.O00000o0);
                jSONObject.put("source", this.O00000Oo);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.O00000oO.size(); i++) {
                jSONArray.put(O000000o(this.O00000oO.get(i)));
            }
            try {
                jSONObject.put("step", jSONArray);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        BindStep f943O000000o;
        long O00000Oo = 0;
        long O00000o = 0;
        long O00000o0 = 0;
        public long O00000oO = 0;
        Integer O00000oo = null;
        String O0000O0o = null;

        O00000Oo(BindStep bindStep) {
            this.f943O000000o = bindStep;
        }
    }

    public final void O000000o(String str, int i) {
        if (flu.O00000oO().O00000Oo(str)) {
            O00000Oo(str);
            this.f940O000000o.put(str, new O000000o(str, i));
        }
    }

    public final void O000000o(String str, BindStep bindStep) {
        O000000o o000000o;
        if (flu.O00000oO().O00000Oo(str) && (o000000o = this.f940O000000o.get(str)) != null) {
            O00000Oo o00000Oo = new O00000Oo(bindStep);
            o000000o.O00000o.put(bindStep, o00000Oo);
            o00000Oo.O00000Oo = System.currentTimeMillis();
            o00000Oo.O00000o = o00000Oo.O00000Oo;
            o00000Oo.O00000oO = 0;
        }
    }

    public final void O00000Oo(String str, BindStep bindStep) {
        O000000o o000000o;
        O00000Oo o00000Oo;
        if (flu.O00000oO().O00000Oo(str) && (o000000o = this.f940O000000o.get(str)) != null && (o00000Oo = o000000o.O00000o.get(bindStep)) != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (o00000Oo.O00000oO != 0 && o00000Oo.O00000oO > o00000Oo.O00000o && o00000Oo.O00000oO < currentTimeMillis) {
                o00000Oo.O00000o = currentTimeMillis - (o00000Oo.O00000oO - o00000Oo.O00000o);
            }
            o00000Oo.O00000oO = 0;
        }
    }

    private void O000000o(String str, BindStep bindStep, Integer num, String str2) {
        O000000o o000000o;
        O00000Oo o00000Oo;
        if (flu.O00000oO().O00000Oo(str) && (o000000o = this.f940O000000o.get(str)) != null && (o00000Oo = o000000o.O00000o.get(bindStep)) != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis >= o00000Oo.O00000Oo && currentTimeMillis >= o00000Oo.O00000o) {
                o00000Oo.O00000o0 = currentTimeMillis;
                o00000Oo.O00000oo = num;
                o00000Oo.O0000O0o = str2;
                o000000o.O00000oO.add(o00000Oo);
                o000000o.O00000o.remove(bindStep);
            }
        }
    }

    public final void O000000o(String str, BindStep bindStep, long j, long j2) {
        O000000o o000000o;
        if (flu.O00000oO().O00000Oo(str) && (o000000o = this.f940O000000o.get(str)) != null && j <= j2) {
            O00000Oo o00000Oo = new O00000Oo(bindStep);
            o00000Oo.O00000Oo = j;
            o00000Oo.O00000o = j;
            o00000Oo.O00000o0 = j2;
            o000000o.O00000oO.add(o00000Oo);
        }
    }

    public final void O00000o0(String str) {
        O000000o o000000o;
        if (!flu.O00000oO().O00000Oo(str) || (o000000o = this.f940O000000o.get(str)) == null) {
            return;
        }
        if (o000000o.O00000oO.size() == 0) {
            gsy.O000000o(6, "DeviceBindTimeStat", "no complete bind phase");
            return;
        }
        hxi.O0000Oo.O000000o(o000000o.O000000o());
        O00000Oo(str);
    }
}
