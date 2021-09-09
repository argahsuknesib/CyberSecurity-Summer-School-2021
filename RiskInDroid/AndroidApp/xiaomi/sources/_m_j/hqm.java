package _m_j;

import _m_j.hof;
import _m_j.hqs;
import android.text.TextUtils;
import android.util.Pair;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.scene.ConstantType;
import java.util.ArrayList;
import java.util.List;

public final class hqm extends hqc implements hpw, hql<hqs.O000000o, hof.O00000o0.O00000Oo> {
    public Device O0000OOo;
    public String O0000Oo;
    public String O0000Oo0;
    public String O0000OoO;
    public hra O0000Ooo;
    public String O0000o0;
    public String O0000o00;
    public String O0000o0O;
    private hof.O00000o0.O00000Oo O0000o0o;

    public hqm(int i, hof.O00000o0.O00000Oo o00000Oo, hra hra, String str, String str2, String str3) {
        this(i, o00000Oo, hra);
        if (this.O0000OOo == null) {
            this.O0000Oo0 = str;
            this.O0000Oo = str2;
            this.O0000OoO = str3;
        }
    }

    public final Device O000000o() {
        return this.O0000OOo;
    }

    public final String O00000Oo() {
        return this.O0000Oo0;
    }

    public final String O00000o0() {
        return this.O0000Oo;
    }

    public final String O00000o() {
        return this.O0000OoO;
    }

    public final String O00000oO() {
        hra hra = this.O0000Ooo;
        return hra != null ? hra.O00000oO() : "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public final void O000000o(List<Pair<String, String>> list) {
        Pair pair;
        String[] split;
        if (list != null) {
            if (list.size() == 2) {
                if (this.O0000Ooo.O00000oO.contains("left")) {
                    pair = list.get(0);
                } else if (this.O0000Ooo.O00000oO.contains("right")) {
                    pair = list.get(1);
                }
                if (pair == null && (split = ((String) pair.first).split("-")) != null && split.length == 2) {
                    this.O0000o0 = split[0];
                    this.O0000o0O = split[1];
                    this.O0000o00 = (String) pair.second;
                    return;
                }
                return;
            } else if (list.size() == 3) {
                if (this.O0000Ooo.O00000oO.contains("left")) {
                    pair = list.get(0);
                } else if (this.O0000Ooo.O00000oO.contains("right")) {
                    pair = list.get(2);
                } else if (this.O0000Ooo.O00000oO.contains("middle")) {
                    pair = list.get(1);
                }
                if (pair == null) {
                    return;
                }
                return;
            }
        }
        pair = null;
        if (pair == null) {
        }
    }

    public final String O00000oo() {
        return this.O0000o0;
    }

    public final String O0000O0o() {
        return this.O0000o0O;
    }

    public final String O0000OOo() {
        return this.O0000o00;
    }

    public final int p_() {
        return this.O00000oO == 4 ? -1 : 2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public hqm(int i, hof.O00000o0.O00000Oo o00000Oo, hra hra) {
        super(r1, r2, o00000Oo == null ? 0 : o00000Oo.O00000o0, o00000Oo != null ? o00000Oo.O00000o.intValue() : r0);
        int i2;
        int i3 = 0;
        int i4 = o00000Oo == null ? 0 : o00000Oo.O00000Oo;
        if (o00000Oo == null) {
            i2 = 0;
        } else {
            i2 = o00000Oo.O0000OoO;
        }
        this.f521O000000o = i;
        this.O0000o0o = o00000Oo;
        this.O0000Ooo = hra;
        if (hra != null && !TextUtils.isEmpty(hra.O00000o0)) {
            this.O0000OOo = fno.O000000o().O000000o(hra.O00000o0);
        }
        Device device = this.O0000OOo;
        if (device != null) {
            this.O0000Oo0 = device.did;
            this.O0000Oo = this.O0000OOo.model;
            this.O0000OoO = this.O0000OOo.name;
        }
    }

    public final /* synthetic */ Object o_() {
        hqs.O000000o o000000o = new hqs.O000000o();
        o000000o.f530O000000o = this.O00000Oo;
        o000000o.O00000Oo = this.f521O000000o;
        o000000o.O00000o0 = ConstantType.PayloadType.RPC;
        hqs.O000000o.O00000o0 o00000o0 = new hqs.O000000o.O00000o0();
        o00000o0.O00000oO = this.O0000Oo;
        o00000o0.O00000Oo = this.O0000Oo0;
        o00000o0.O00000oo = this.O0000OoO;
        hra hra = this.O0000Ooo;
        if (hra instanceof hrc) {
            o00000o0.O00000o0 = ConstantType.RpcMethod.PROPERTY;
            hrc hrc = (hrc) this.O0000Ooo;
            o00000o0.O0000O0o = new ArrayList<>();
            o00000o0.O0000O0o.add(new hqs.O000000o.O00000o0.O00000Oo(hrc.O00000o0, hrc.O00000o, hrc.f543O000000o, hrc.O0000O0o));
        } else if (hra instanceof hqz) {
            o00000o0.O00000o0 = ConstantType.RpcMethod.ACION;
            hqz hqz = (hqz) this.O0000Ooo;
            o00000o0.O0000OOo = new hqs.O000000o.O00000o0.C0003O000000o();
            o00000o0.O0000OOo.f532O000000o = hqz.O00000o0;
            o00000o0.O0000OOo.O00000Oo = hqz.O00000o;
            o00000o0.O0000OOo.O00000o0 = hqz.f541O000000o;
            if (hqz.O00000Oo != null && hqz.O00000Oo.size() > 0) {
                o00000o0.O0000OOo.O00000o = new ArrayList<>();
                for (int i = 0; i < hqz.O00000Oo.size(); i++) {
                    o00000o0.O0000OOo.O00000o.add(new hqs.O000000o.O00000o0.O00000Oo(hqz.O00000Oo.get(i).O00000o0, hqz.O00000Oo.get(i).O00000o, hqz.O00000Oo.get(i).f543O000000o, hqz.O00000Oo.get(i).O0000O0o));
                }
            }
        }
        o000000o.O00000oO = o00000o0;
        return o000000o;
    }
}
