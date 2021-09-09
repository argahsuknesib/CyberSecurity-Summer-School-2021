package _m_j;

import android.text.TextUtils;
import android.util.Log;

public final class doh extends dnh {
    public final int O000000o(Object obj) {
        short s;
        int O000000o2 = super.O000000o(obj);
        dmr dmr = this.O0000Oo;
        if (dmr.f14792O000000o == null || dmr.O00000Oo >= dmr.f14792O000000o.O00000o0 - 1) {
            Log.e("CodeReader", "readShort error mCode:" + dmr.f14792O000000o + "  mCurIndex:" + dmr.O00000Oo);
            s = 0;
        } else {
            byte[] bArr = dmr.f14792O000000o.f13148O000000o;
            int i = dmr.O00000Oo;
            dmr.O00000Oo = i + 1;
            byte[] bArr2 = dmr.f14792O000000o.f13148O000000o;
            int i2 = dmr.O00000Oo;
            dmr.O00000Oo = i2 + 1;
            s = (short) ((((short) bArr2[i2]) << 8) | ((short) (bArr[i] & 255)));
        }
        short s2 = s & 7;
        int i3 = (s >> 3) & 7;
        int i4 = (s >> 6) & 7;
        dmx O000000o3 = O000000o(s2);
        dmx O000000o4 = O000000o(i3);
        dmx O000000o5 = O000000o(i4);
        if (!(4 == s2 || 4 == i3 || 4 == i4)) {
            this.O00000Oo = this.O0000Oo.O000000o();
        }
        dmx O000000o6 = this.O0000OoO.O000000o(this.O00000Oo);
        if (O000000o6 == null) {
            return O000000o2;
        }
        int i5 = O000000o3.O00000Oo;
        if (i5 != 1) {
            if (i5 == 2) {
                double O00000Oo = (double) O000000o3.O00000Oo();
                if (O00000Oo > 1.0E-7d || O00000Oo < -1.0E-7d) {
                    O000000o6.O000000o(O000000o4);
                } else {
                    O000000o6.O000000o(O000000o5);
                }
            } else if (i5 != 3) {
                Log.e("TerExecutor_TMTEST", "type error:".concat(String.valueOf((int) s2)));
                return 2;
            } else if (!TextUtils.isEmpty(O000000o3.O00000o0())) {
                O000000o6.O000000o(O000000o4);
            } else {
                O000000o6.O000000o(O000000o5);
            }
        } else if (O000000o3.O000000o() != 0) {
            O000000o6.O000000o(O000000o4);
        } else {
            O000000o6.O000000o(O000000o5);
        }
        return 1;
    }
}
