package _m_j;

import _m_j.hof;
import _m_j.hqs;
import android.text.TextUtils;
import android.util.Pair;
import com.xiaomi.smarthome.device.Device;
import java.util.List;

public final class hqo extends hqe implements hpw, hql<hqs.O0000Oo0, hof.O0000O0o.O00000Oo> {

    /* renamed from: O000000o  reason: collision with root package name */
    public Device f526O000000o;
    public String O0000OOo;
    public String O0000Oo;
    public String O0000Oo0;
    hra O0000OoO;
    public String O0000Ooo;
    public String O0000o0;
    public String O0000o00;
    public hof.O0000O0o.O00000Oo O0000o0O;

    public hqo(hof.O0000O0o.O00000Oo o00000Oo, hra hra, String str, String str2, String str3) {
        this(o00000Oo, hra);
        if (this.f526O000000o == null) {
            this.O0000OOo = str;
            this.O0000Oo0 = str2;
            this.O0000Oo = str3;
        }
    }

    public final int p_() {
        return this.O00000oO == 4 ? -1 : 2;
    }

    public final Device O000000o() {
        return this.f526O000000o;
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
        String[] split;
        if (this.O0000OoO.O00000oO.contains("left")) {
            pair = list.get(0);
        } else if (this.O0000OoO.O00000oO.contains("right")) {
            pair = list.get(list.size() - 1);
        } else {
            pair = this.O0000OoO.O00000oO.contains("middle") ? list.get(1) : null;
        }
        if (pair != null && (split = ((String) pair.first).split("-")) != null && split.length == 2) {
            this.O0000o00 = split[0];
            this.O0000o0 = split[1];
            this.O0000Ooo = (String) pair.second;
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
    public hqo(hof.O0000O0o.O00000Oo o00000Oo, hra hra) {
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
            this.f526O000000o = fno.O000000o().O000000o(hra.O00000o0);
        }
        Device device = this.f526O000000o;
        if (device != null) {
            this.O0000OOo = device.did;
            this.O0000Oo0 = this.f526O000000o.model;
            this.O0000Oo = this.f526O000000o.name;
        }
    }

    public final /* synthetic */ Object o_() {
        hqs.O0000Oo0 o0000Oo0 = new hqs.O0000Oo0();
        o0000Oo0.O00000Oo = "device";
        o0000Oo0.f538O000000o = this.O00000Oo;
        o0000Oo0.O00000oo = this.O0000OoO.O000000o();
        hra hra = this.O0000OoO;
        if (hra instanceof hrc) {
            hrc hrc = (hrc) hra;
            if (hrc.O0000O0o != null) {
                o0000Oo0.O00000o = hrc.O0000O0o;
                o0000Oo0.O00000oO = hrc.O00000Oo;
            }
        }
        o0000Oo0.O0000O0o = new hqs.O00000o(this.O0000OOo, this.O0000Oo0, this.O0000Oo);
        return o0000Oo0;
    }
}
