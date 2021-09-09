package _m_j;

import _m_j.hof;
import android.text.TextUtils;
import com.xiaomi.smarthome.scene.ConstantType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class hrh {
    private static hrh O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public hoh f558O000000o;
    private hof O00000o;
    private String O00000o0;
    private Map<String, hof.O0000O0o.O00000Oo> O00000oO = new HashMap();
    private Map<String, hof.O00000o.O00000Oo> O00000oo = new HashMap();
    private Map<String, hof.O00000o0.O00000Oo> O0000O0o = new HashMap();
    private Map<String, hof.O00000o0.O0000O0o> O0000OOo = new HashMap();
    private hqs O0000Oo0;

    private hrh() {
    }

    public static hrh O000000o() {
        if (O00000Oo == null) {
            O00000Oo = new hrh();
        }
        return O00000Oo;
    }

    public final synchronized hof O00000Oo() {
        return this.O00000o;
    }

    public final synchronized String O00000o0() {
        return this.O00000o0;
    }

    public final synchronized hof.O0000O0o.O00000Oo O000000o(long j, int i) {
        Map<String, hof.O0000O0o.O00000Oo> map;
        map = this.O00000oO;
        return map.get(j + "-" + i);
    }

    public final synchronized hof.O00000o.O00000Oo O00000Oo(long j, int i) {
        Map<String, hof.O00000o.O00000Oo> map;
        map = this.O00000oo;
        return map.get(j + "-" + i);
    }

    public final synchronized hof.O00000o0.O00000Oo O000000o(long j, int i, int i2) {
        Map<String, hof.O00000o0.O00000Oo> map;
        map = this.O0000O0o;
        return map.get(j + "-" + i + "-" + i2);
    }

    public final synchronized ArrayList<hof.O00000o0.O0000O0o> O00000o() {
        return this.O00000o.O0000oo.O00000oO;
    }

    public final synchronized void O000000o(hqs hqs) {
        this.O0000Oo0 = hqs;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0050, code lost:
        return r0;
     */
    public final synchronized hoh O00000oO() {
        hoh hoh = new hoh();
        if (this.O0000Oo0 == null) {
            return hoh;
        }
        hoh.O00000Oo = this.O0000Oo0.f529O000000o;
        hoh.O00000o0 = this.O0000Oo0.O0000O0o;
        hoh.f444O000000o = this.O0000Oo0.O00000Oo;
        int i = 0;
        while (true) {
            if (i >= (this.O0000Oo0.O0000o00 != null ? this.O0000Oo0.O0000o00.size() : 0)) {
                break;
            } else if (TextUtils.equals(ConstantType.TriggerConditionType.CLICK.key, this.O0000Oo0.O0000o00.get(i).O00000oo)) {
                hoh.O00000o = true;
                break;
            } else {
                i++;
            }
        }
    }

    public final synchronized void O000000o(String str, hof hof) {
        this.O00000o = hof;
        this.O00000o0 = str;
        long longValue = hof.O00000Oo.longValue();
        hof.O0000O0o o0000O0o = hof.O0000oOo;
        if (!(o0000O0o == null || o0000O0o.O00000o0 == null)) {
            for (int i = 0; i < o0000O0o.O00000o0.size(); i++) {
                Map<String, hof.O0000O0o.O00000Oo> map = this.O00000oO;
                map.put(longValue + "-" + o0000O0o.O00000o0.get(i).O00000Oo, o0000O0o.O00000o0.get(i));
            }
        }
        hof.O00000o o00000o = hof.O0000oo0;
        if (!(o00000o == null || o00000o.O00000o0 == null)) {
            for (int i2 = 0; i2 < o00000o.O00000o0.size(); i2++) {
                Map<String, hof.O00000o.O00000Oo> map2 = this.O00000oo;
                map2.put(longValue + "-" + o00000o.O00000o0.get(i2).O00000Oo, o00000o.O00000o0.get(i2));
            }
        }
        hof.O00000o0 o00000o0 = hof.O0000oo;
        if (!(o00000o0 == null || o00000o0.O00000oO == null)) {
            for (int i3 = 0; i3 < o00000o0.O00000oO.size(); i3++) {
                if (o00000o0.O00000oO.get(i3).O00000oO != null) {
                    int intValue = o00000o0.O00000oO.get(i3).O00000Oo.intValue();
                    Map<String, hof.O00000o0.O0000O0o> map3 = this.O0000OOo;
                    map3.put(longValue + "-" + intValue, o00000o0.O00000oO.get(i3));
                    for (int i4 = 0; i4 < o00000o0.O00000oO.get(i3).O00000oO.size(); i4++) {
                        Map<String, hof.O00000o0.O00000Oo> map4 = this.O0000O0o;
                        map4.put(longValue + "-" + intValue + "-" + o00000o0.O00000oO.get(i3).O00000oO.get(i4).O00000Oo, o00000o0.O00000oO.get(i3).O00000oO.get(i4));
                    }
                }
            }
        }
    }
}
