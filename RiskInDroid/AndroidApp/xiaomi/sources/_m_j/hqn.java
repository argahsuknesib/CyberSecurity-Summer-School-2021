package _m_j;

import _m_j.hof;
import _m_j.hqs;
import android.text.TextUtils;
import android.util.Pair;
import com.xiaomi.smarthome.device.Device;
import java.util.List;

public final class hqn extends hqd implements hpw, hql<hqs.O00000o0, hof.O00000o.O00000Oo> {

    /* renamed from: O000000o  reason: collision with root package name */
    public Device f525O000000o;
    public String O0000OOo;
    public String O0000Oo;
    public String O0000Oo0;
    hra O0000OoO;
    public String O0000Ooo;
    public String O0000o0;
    public String O0000o00;
    private hof.O00000o.O00000Oo O0000o0O;

    public hqn(hof.O00000o.O00000Oo o00000Oo, hra hra, String str, String str2, String str3) {
        this(o00000Oo, hra);
        if (this.f525O000000o == null) {
            this.O0000OOo = str;
            this.O0000Oo0 = str2;
            this.O0000Oo = str3;
        }
    }

    public final int p_() {
        return this.O00000oO == 4 ? -1 : 2;
    }

    public final Device O000000o() {
        return this.f525O000000o;
    }

    public final String O00000Oo() {
        return this.O0000OOo;
    }

    public final String O00000o0() {
        return this.O0000Oo0;
    }

    public final String O00000o() {
        return this.O0000Oo;
    }

    public final String O00000oO() {
        hra hra = this.O0000OoO;
        return hra != null ? hra.O00000oO() : "";
    }

    public final void O000000o(List<Pair<String, String>> list) {
        Pair pair;
        if (this.O0000OoO.O00000oO.contains("left")) {
            pair = list.get(0);
        } else if (this.O0000OoO.O00000oO.contains("right")) {
            pair = list.get(list.size() - 1);
        } else {
            pair = this.O0000OoO.O00000oO.contains("middle") ? list.get(1) : null;
        }
        if (pair != null) {
            String[] split = ((String) pair.first).split("-");
            if (split.length == 2) {
                this.O0000o00 = split[0];
                this.O0000o0 = split[1];
                this.O0000Ooo = (String) pair.second;
            }
        }
    }

    public final String O00000oo() {
        return this.O0000o00;
    }

    public final String O0000O0o() {
        return this.O0000o0;
    }

    public final String O0000OOo() {
        return this.O0000Ooo;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public hqn(hof.O00000o.O00000Oo o00000Oo, hra hra) {
        super(r1, r2, r3, o00000Oo != null ? o00000Oo.O00000o0.intValue() : r0);
        int i;
        int i2;
        int i3;
        int i4 = 0;
        if (o00000Oo == null) {
            i = 0;
        } else {
            i = o00000Oo.O00000Oo.intValue();
        }
        if (o00000Oo == null) {
            i2 = 0;
        } else {
            i2 = o00000Oo.O0000o0.intValue();
        }
        if (o00000Oo == null) {
            i3 = 0;
        } else {
            i3 = o00000Oo.O00000o.intValue();
        }
        this.O0000o0O = o00000Oo;
        this.O0000OoO = hra;
        if (hra != null && !TextUtils.isEmpty(hra.O00000o0)) {
            this.f525O000000o = fno.O000000o().O000000o(hra.O00000o0);
        }
        Device device = this.f525O000000o;
        if (device != null) {
            this.O0000OOo = device.did;
            this.O0000Oo0 = this.f525O000000o.model;
            this.O0000Oo = this.f525O000000o.name;
        }
    }

    public final /* synthetic */ Object o_() {
        hqs.O00000o0 o00000o0 = new hqs.O00000o0();
        o00000o0.O00000Oo = "device";
        o00000o0.f536O000000o = this.O00000Oo;
        o00000o0.O00000o = this.O0000OoO.O000000o();
        hra hra = this.O0000OoO;
        if (hra instanceof hrc) {
            o00000o0.O00000oO = hra.O00000o0();
            o00000o0.O00000oo = this.O0000OoO.O00000o();
        }
        o00000o0.O0000O0o = new hqs.O00000o(this.O0000OOo, this.O0000Oo0, this.O0000Oo);
        return o00000o0;
    }
}
