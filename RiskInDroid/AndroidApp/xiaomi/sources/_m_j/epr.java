package _m_j;

import _m_j.epu;
import android.util.Log;

final class epr {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final boolean f15709O000000o = Log.isLoggable("BCompressed", 3);

    static byte[] O000000o(epq epq, byte[] bArr) {
        try {
            byte[] O000000o2 = epu.O000000o.O000000o(bArr);
            if (f15709O000000o) {
                duv.O000000o("BCompressed", "decompress " + bArr.length + " to " + O000000o2.length + " for " + epq);
                if (epq.O00000o == 1) {
                    duv.O000000o("BCompressed", "decompress not support upStream");
                }
            }
            return O000000o2;
        } catch (Exception e) {
            duv.O000000o("BCompressed", "decompress error ".concat(String.valueOf(e)));
            return bArr;
        }
    }
}
