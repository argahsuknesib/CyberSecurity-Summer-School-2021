package _m_j;

import _m_j.hcc;
import _m_j.hee;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.card.State;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class hed extends hcc.O000000o<String> implements Cloneable {
    public String O0000OOo;
    public long O0000Oo;
    public String O0000Oo0;
    public long O0000OoO;
    public String O0000Ooo;
    public int O0000o0;
    public String O0000o00;
    private double O0000o0O;
    private String O0000o0o;

    public final /* synthetic */ hdj O000000o(Object obj, Object obj2, Device device) {
        return O00000Oo(obj2);
    }

    public final /* synthetic */ String O000000o(Device device, Object obj) {
        return O0000OOo();
    }

    public final /* synthetic */ String O000000o(Device device, Object obj, Object obj2) {
        return O00000o0(obj2);
    }

    public final /* synthetic */ void O000000o(hdb hdb, Device device, Object obj, Object obj2, fsm fsm) {
        String str = (String) obj;
        if (hdb == null) {
            LogType logType = LogType.CARD;
            gsy.O00000o0(logType, "mijia-card", "ProfileCardType.sendRequest operation null device:" + device + " prop:" + str + " value:" + obj2);
            return;
        }
        hcv.getInstance().setDeviceProp(device, this, hdb.O00000o, hdb.O00000oO, obj2, fsm);
    }

    public final /* synthetic */ Object O00000Oo(Device device, Object obj) {
        return O000000o(this, device, (String) obj);
    }

    public final /* synthetic */ String O00000Oo(Device device, Object obj, Object obj2) {
        return O00000o(obj2);
    }

    public final /* synthetic */ Object O00000o0(Device device, Object obj) {
        String str = (String) obj;
        Object O000000o2 = O000000o(this, device, str);
        hdb O000000o3 = hdb.O000000o(this.O00000o, O000000o2);
        if (O000000o3 != null) {
            return O000000o3.O000000o(this.O00000o);
        }
        if (O000000o2 instanceof Boolean) {
            return Boolean.valueOf(!((Boolean) O000000o2).booleanValue());
        }
        if (!(O000000o2 instanceof Number)) {
            return ("0".equals(String.valueOf(str)) || "false".equals(String.valueOf(str))) ? "1" : "0";
        }
        int i = 0;
        if (hhc.O000000o(O000000o2, 0) != 1) {
            i = 1;
        }
        return Integer.valueOf(i);
    }

    public final /* synthetic */ long O00000oO(Device device, Object obj) {
        return O00000Oo(device, (String) obj);
    }

    private hed(int i, String str, List<hdb> list, double d, String str2, hee hee) {
        super(i, str, list, d, str2, hee);
    }

    public static hed O000000o(Map<String, hee> map, JSONObject jSONObject) {
        return new hed(map, jSONObject);
    }

    private static long O00000Oo(Device device, String str) {
        return hcg.O000000o(hcv.getInstance().getPropsMap(device.did), str);
    }

    public final hdj O00000Oo(Object obj) {
        double parseDouble;
        double d;
        Pair<String, fkv<Object, Object>> O00000Oo = fju.O000000o().O00000Oo(this.O0000o0o);
        String str = (String) O00000Oo.first;
        Object call = ((fkv) O00000Oo.second).call(obj);
        if (call == null || "null".equals(call)) {
            return new hdj("", str);
        }
        if (call instanceof Number) {
            parseDouble = ((Number) call).doubleValue();
            d = this.O0000o0O;
        } else {
            String valueOf = String.valueOf(call);
            try {
                parseDouble = Double.parseDouble(valueOf);
                d = this.O0000o0O;
            } catch (NumberFormatException unused) {
                return new hdj(valueOf, str);
            }
        }
        double d2 = parseDouble * d;
        if (this.O00000oo != null && !TextUtils.isEmpty(this.O00000oo.O00000oO)) {
            return new hdj(String.format(hcg.O00000Oo, this.O00000oo.O00000oO, Double.valueOf(d2)), str);
        } else if (this.O0000o0O == 1.0d) {
            return new hdj(String.valueOf(call), str);
        } else {
            return new hdj(String.valueOf(d2), str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: O0000Oo0 */
    public hed clone() {
        try {
            return (hed) super.clone();
        } catch (CloneNotSupportedException unused) {
            hed hed = new hed(this.O00000Oo, this.O00000o0, this.O00000o, this.f18769O000000o, this.O00000oO, this.O00000oo);
            hed.O0000OOo = this.O0000OOo;
            hed.O0000Oo0 = this.O0000Oo0;
            hed.O0000OoO = this.O0000OoO;
            hed.O0000Oo = this.O0000Oo;
            hed.O0000Ooo = this.O0000Ooo;
            hed.O0000o00 = this.O0000o00;
            return hed;
        }
    }

    public final String O0000OOo() {
        String str;
        hee O000000o2 = O000000o();
        if (O000000o2 == null || (str = O000000o2.O00000o0) == null) {
            return "";
        }
        return str;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hhc.O000000o(java.lang.Object, double):double
     arg types: [java.lang.String, int]
     candidates:
      _m_j.hhc.O000000o(java.lang.Object, int):int
      _m_j.hhc.O000000o(java.lang.Object, double):double */
    public final String O00000o0(Object obj) {
        if (obj == null || obj.toString().equals("null")) {
            return "";
        }
        hee O000000o2 = O000000o();
        if (O000000o2 == null) {
            return String.valueOf(obj);
        }
        List<hee.O00000Oo> list = O000000o2.O0000OOo;
        if (!(this.O00000o == null || this.O00000o.size() == 0)) {
            hdb hdb = null;
            for (hdb hdb2 : this.O00000o) {
                if (hdb2.O000000o(String.valueOf(obj))) {
                    hdb = hdb2;
                }
            }
            if (hdb == null && this.O00000o.size() > 1) {
                hdb = (hdb) this.O00000o.get(1);
            }
            if (hdb != null) {
                return hdb.f18806O000000o;
            }
        }
        if (list != null) {
            for (hee.O00000Oo next : list) {
                if (next.f18837O000000o == null) {
                    try {
                        double O000000o3 = hhc.O000000o((Object) String.valueOf(obj), 0.0d);
                        if (O000000o3 >= next.O00000o0 && O000000o3 <= next.O00000o) {
                            return next.O00000Oo;
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                } else if (String.valueOf(next.f18837O000000o).equals(String.valueOf(obj))) {
                    return next.O00000Oo;
                }
            }
        }
        return O0000OOo();
    }

    public final String O000000o(Device device, String str, Object obj, State state) {
        String str2;
        while (this.O00000o != null) {
            for (hdb hdb : this.O00000o) {
                if (hdb.O000000o(String.valueOf(obj))) {
                    int i = AnonymousClass1.f18835O000000o[state.ordinal()];
                    if (i == 1) {
                        str2 = hdb.O0000OOo;
                    } else if (i == 2) {
                        str2 = hdb.O0000Oo0;
                    } else if (i != 3) {
                        str2 = hdb.O0000OOo;
                    } else {
                        str2 = hdb.O0000Oo;
                    }
                    String cardIconPath = hcv.getInstance().getCardIconPath(hcv.getInstance().translateName(str2));
                    if (cardIconPath != null) {
                        return cardIconPath;
                    }
                    if (state != State.NOR) {
                        state = State.NOR;
                    }
                }
            }
            return new StringBuilder("res://drawable/2132083811").toString();
        }
        return new StringBuilder("res://drawable/2132083811").toString();
    }

    /* renamed from: _m_j.hed$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f18835O000000o = new int[State.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            f18835O000000o[State.NOR.ordinal()] = 1;
            f18835O000000o[State.SELECTED.ordinal()] = 2;
            try {
                f18835O000000o[State.UNABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static Object O000000o(hed hed, Device device, String str) {
        boolean z;
        if (device == null) {
            return "";
        }
        if (device.pid != Device.PID_BLUETOOTH) {
            z = false;
        } else {
            heb cardInfo = hcv.getInstance().getCardInfo(device.model);
            if (cardInfo == null) {
                return Boolean.FALSE;
            }
            z = cardInfo.O00000o;
        }
        if (z) {
            Map<String, hdi> propsMap = hcv.getInstance().getPropsMap(device.did);
            if (propsMap != null) {
                hdi hdi = propsMap.get(str);
                if (!hcf.O000000o(hdi)) {
                    return hcf.O000000o(hdi.f18812O000000o.toString());
                }
            }
            return null;
        }
        hee O000000o2 = hed.O000000o();
        if (O000000o2 == null) {
            return null;
        }
        if (O000000o2.O00000o.size() > 0) {
            Pair<Object, Long> O000000o3 = hed.O00000o(device, str);
            if (O000000o3 == null) {
                return null;
            }
            return O000000o3.first;
        }
        Map<String, hdi> propsMap2 = hcv.getInstance().getPropsMap(device.did);
        if (propsMap2 != null) {
            hdi hdi2 = propsMap2.get(str);
            if (!hcf.O000000o(hdi2)) {
                hdc hdc = O000000o2.O0000Oo;
                if (hdc == null) {
                    return hdi2.f18812O000000o;
                }
                Object obj = hdi2.f18812O000000o;
                if (hdc.f18807O000000o == null || hdc.f18807O000000o.size() == 0) {
                    return obj;
                }
                gsy.O00000Oo("mijia-card", "parsePropValue:".concat(String.valueOf(obj)));
                Object obj2 = obj;
                for (int i = 0; i < hdc.f18807O000000o.size(); i++) {
                    obj2 = hdc.O000000o(hdc.f18807O000000o.get(i), obj2);
                    if (obj2 == null) {
                        if (i != 0) {
                            return null;
                        }
                        obj2 = obj;
                    }
                }
                return obj2;
            }
        }
        return null;
    }

    /* renamed from: O000000o */
    public final Pair<Object, Long> O00000o(Device device, String str) {
        Object obj;
        long j;
        if (device == null) {
            return null;
        }
        try {
            Map<String, hdi> propsMap = hcv.getInstance().getPropsMap(device.did);
            if (propsMap == null) {
                return null;
            }
            if (this.O00000oo == null || this.O00000oo.O00000o == null || this.O00000oo.O00000o.size() == 0) {
                j = O00000Oo(device, str);
                hdi hdi = propsMap.get(str);
                if (hdi == null) {
                    obj = null;
                } else {
                    obj = hdi.f18812O000000o;
                }
            } else {
                String str2 = "";
                j = 0;
                for (Map.Entry next : this.O00000oo.O00000o.entrySet()) {
                    long O00000Oo = O00000Oo(device, (String) next.getKey());
                    if (O00000Oo != 0 && O00000Oo > j) {
                        str2 = (String) next.getKey();
                        j = O00000Oo;
                    }
                }
                obj = this.O00000oo.O00000o.get(str2);
            }
            if (j == 0) {
                return null;
            }
            return new Pair<>(obj, Long.valueOf(j));
        } catch (Exception e) {
            Log.e("mijia-card", "profile getLatestEvent", e);
            return null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hhc.O000000o(java.lang.Object, double):double
     arg types: [java.lang.String, int]
     candidates:
      _m_j.hhc.O000000o(java.lang.Object, int):int
      _m_j.hhc.O000000o(java.lang.Object, double):double */
    private String O00000o(Object obj) {
        List<hee.O00000Oo> list;
        if (O000000o() == null || (list = O000000o().O0000OOo) == null) {
            return null;
        }
        for (hee.O00000Oo next : list) {
            if (next.f18837O000000o == null) {
                try {
                    double O000000o2 = hhc.O000000o((Object) String.valueOf(obj), 0.0d);
                    if (O000000o2 >= next.O00000o0 && O000000o2 <= next.O00000o) {
                        return next.O00000oO;
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            } else if (String.valueOf(next.f18837O000000o).equals(String.valueOf(obj))) {
                return next.O00000oO;
            }
        }
        return null;
    }

    public final boolean O000000o(Device device, hdb hdb) {
        boolean z;
        if (hdb == null) {
            return false;
        }
        List<Pair<String, Object>> list = hdb.O00000oo;
        List<Pair<String, Object>> list2 = hdb.O0000O0o;
        if (list == null && list2 == null) {
            return true;
        }
        ArrayMap arrayMap = new ArrayMap();
        heb cardInfo = hcv.getInstance().getCardInfo(device.model);
        if (cardInfo != null) {
            for (hed hed : cardInfo.O00000Oo()) {
                arrayMap.put(hed.O00000o0, hed);
            }
        }
        ArrayMap arrayMap2 = new ArrayMap();
        if (list != null) {
            for (Pair next : list) {
                Object obj = next.second;
                Object O000000o2 = O000000o(arrayMap2, device, arrayMap, (String) next.first);
                gsy.O00000Oo("mijia-card", "isEnable profile prop:" + ((String) next.first) + " current desc:" + O000000o2 + ", enable desc:" + obj);
                if (String.valueOf(obj).equals(String.valueOf(O000000o2)) || ((obj instanceof Boolean) && String.valueOf(((Boolean) obj).booleanValue() ? 1 : 0).equals(String.valueOf(O000000o2)))) {
                    return true;
                }
            }
            z = false;
        } else {
            z = true;
        }
        if (list2 == null) {
            return z;
        }
        for (Pair next2 : list2) {
            Object obj2 = next2.second;
            Object O000000o3 = O000000o(arrayMap2, device, arrayMap, (String) next2.first);
            gsy.O00000Oo("mijia-card", "isEnable profile prop:" + ((String) next2.first) + " current desc:" + O000000o3 + ", disable desc:" + obj2);
            if (String.valueOf(obj2).equals(String.valueOf(O000000o3)) || ((obj2 instanceof Boolean) && String.valueOf(((Boolean) obj2).booleanValue() ? 1 : 0).equals(String.valueOf(O000000o3)))) {
                return false;
            }
        }
        return true;
    }

    private static Object O000000o(ArrayMap<String, Object> arrayMap, Device device, ArrayMap<String, hed> arrayMap2, String str) {
        Object O000000o2;
        Object obj = arrayMap.get(str);
        if (obj != null) {
            return obj;
        }
        for (Map.Entry next : arrayMap2.entrySet()) {
            hed hed = (hed) next.getValue();
            if (hed != null && ((TextUtils.equals((CharSequence) next.getKey(), str) || TextUtils.equals(hed.O0000OOo, str)) && (O000000o2 = O000000o(hed, device, (String) next.getKey())) != null)) {
                arrayMap.put(str, O000000o2);
                return O000000o2;
            }
        }
        return null;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public hed(Map<String, hee> map, JSONObject jSONObject) {
        super(jSONObject, r5);
        hee hee;
        if (map == null || jSONObject == null) {
            hee = null;
        } else {
            hee = map.get(jSONObject.optString("prop_key"));
            String optString = jSONObject.optString("sub_prop_key", null);
            if (!(optString == null || hee == null || hee.O00000Oo == null)) {
                hee = hee.O00000Oo.get(optString);
            }
        }
        if (jSONObject != null) {
            this.O0000OOo = jSONObject.optString("sub_prop_key", null);
            this.O0000Oo0 = jSONObject.optString("prop_status_key", null);
            JSONObject optJSONObject = jSONObject.optJSONObject("param_range");
            if (optJSONObject != null) {
                this.O0000Oo = optJSONObject.optLong("min");
                this.O0000OoO = optJSONObject.optLong("max");
            } else {
                this.O0000Oo = 0;
                this.O0000OoO = 0;
            }
            this.O0000Ooo = jSONObject.optString("start_color");
            this.O0000o00 = jSONObject.optString("end_color");
            this.O0000o0 = jSONObject.optInt("supportGrid", 0);
            if (this.O00000oo != null) {
                this.O0000o0o = this.O00000oo.O00000oo.O00000o0;
                this.O0000o0O = this.O00000oo.O00000oo.f18783O000000o;
                return;
            }
            this.O0000o0o = null;
            this.O0000o0O = 1.0d;
        }
    }

    public final /* synthetic */ Object O000000o(Object obj, int i) {
        double d = (double) i;
        double d2 = this.f18769O000000o;
        Double.isNaN(d);
        double d3 = d * d2;
        double d4 = (double) this.O0000Oo;
        Double.isNaN(d4);
        return Double.valueOf(d3 + d4);
    }

    public final /* bridge */ /* synthetic */ int O000000o(Object obj) {
        double d = (double) (this.O0000OoO - this.O0000Oo);
        double d2 = this.f18769O000000o;
        Double.isNaN(d);
        return (int) ((d / d2) + 1.0d);
    }
}
