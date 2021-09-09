package _m_j;

import java.util.Locale;
import org.json.JSONObject;

public final class bvm {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f13313O000000o = 0;
    public int O00000Oo = 0;
    public int O00000o = 0;
    public int O00000o0 = 0;
    public int O00000oO = 0;
    public int O00000oo = 0;
    public int O0000O0o = 0;
    public int O0000OOo = 0;
    public int O0000Oo = -113;
    public int O0000Oo0 = 0;
    public int O0000OoO = 0;
    public short O0000Ooo = 0;
    public boolean O0000o0 = false;
    public long O0000o00 = 0;
    public int O0000o0O = 32767;
    public boolean O0000o0o = true;

    public bvm(int i, boolean z) {
        this.O0000OoO = i;
        this.O0000o0 = z;
    }

    public final JSONObject O000000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.O0000OoO);
            jSONObject.put("registered", this.O0000o0);
            jSONObject.put("mcc", this.f13313O000000o);
            jSONObject.put("mnc", this.O00000Oo);
            jSONObject.put("lac", this.O00000o0);
            jSONObject.put("cid", this.O00000o);
            jSONObject.put("sid", this.O0000O0o);
            jSONObject.put("nid", this.O0000OOo);
            jSONObject.put("bid", this.O0000Oo0);
            jSONObject.put("sig", this.O0000Oo);
            jSONObject.put("pci", this.O0000o0O);
        } catch (Throwable th) {
            bvz.O000000o(th, "cgi", "toJson");
        }
        return jSONObject;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof bvm)) {
            bvm bvm = (bvm) obj;
            int i = bvm.O0000OoO;
            if (i != 1) {
                return i != 2 ? i != 3 ? i == 4 && this.O0000OoO == 4 && bvm.O00000o0 == this.O00000o0 && bvm.O00000o == this.O00000o && bvm.O00000Oo == this.O00000Oo : this.O0000OoO == 3 && bvm.O00000o0 == this.O00000o0 && bvm.O00000o == this.O00000o && bvm.O00000Oo == this.O00000Oo : this.O0000OoO == 2 && bvm.O0000Oo0 == this.O0000Oo0 && bvm.O0000OOo == this.O0000OOo && bvm.O0000O0o == this.O0000O0o;
            }
            if (this.O0000OoO == 1 && bvm.O00000o0 == this.O00000o0 && bvm.O00000o == this.O00000o && bvm.O00000Oo == this.O00000Oo) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int i2;
        int hashCode = String.valueOf(this.O0000OoO).hashCode();
        if (this.O0000OoO == 2) {
            i2 = String.valueOf(this.O0000Oo0).hashCode() + String.valueOf(this.O0000OOo).hashCode();
            i = this.O0000O0o;
        } else {
            i2 = String.valueOf(this.O00000o0).hashCode() + String.valueOf(this.O00000o).hashCode();
            i = this.O00000Oo;
        }
        return hashCode + i2 + String.valueOf(i).hashCode();
    }

    public final String toString() {
        int i = this.O0000OoO;
        if (i == 1) {
            return String.format(Locale.CHINA, "GSM lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b", Integer.valueOf(this.O00000o0), Integer.valueOf(this.O00000o), Integer.valueOf(this.O00000Oo), Boolean.valueOf(this.O0000o0o), Integer.valueOf(this.O0000Oo), Short.valueOf(this.O0000Ooo), Boolean.valueOf(this.O0000o0));
        } else if (i == 2) {
            return String.format(Locale.CHINA, "CDMA bid=%d, nid=%d, sid=%d, valid=%b, sig=%d, age=%d, reg=%b", Integer.valueOf(this.O0000Oo0), Integer.valueOf(this.O0000OOo), Integer.valueOf(this.O0000O0o), Boolean.valueOf(this.O0000o0o), Integer.valueOf(this.O0000Oo), Short.valueOf(this.O0000Ooo), Boolean.valueOf(this.O0000o0));
        } else if (i == 3) {
            return String.format(Locale.CHINA, "LTE lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b, pci=%d", Integer.valueOf(this.O00000o0), Integer.valueOf(this.O00000o), Integer.valueOf(this.O00000Oo), Boolean.valueOf(this.O0000o0o), Integer.valueOf(this.O0000Oo), Short.valueOf(this.O0000Ooo), Boolean.valueOf(this.O0000o0), Integer.valueOf(this.O0000o0O));
        } else if (i != 4) {
            return "unknown";
        } else {
            return String.format(Locale.CHINA, "WCDMA lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b, pci=%d", Integer.valueOf(this.O00000o0), Integer.valueOf(this.O00000o), Integer.valueOf(this.O00000Oo), Boolean.valueOf(this.O0000o0o), Integer.valueOf(this.O0000Oo), Short.valueOf(this.O0000Ooo), Boolean.valueOf(this.O0000o0), Integer.valueOf(this.O0000o0O));
        }
    }
}
