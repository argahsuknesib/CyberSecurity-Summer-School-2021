package _m_j;

import android.util.Log;
import com.amap.location.security.Core;

public final class rc {
    public static op O000000o(re reVar, rg rgVar, int i) {
        op O000000o2 = O000000o(reVar);
        op O000000o3 = O000000o(O000000o2, rgVar, i);
        reVar.O0000Oo0 = O000000o2;
        rgVar.O00000oo = O000000o3;
        if (O000000o3 != null) {
            return O000000o3;
        }
        if (O000000o2 != null) {
            return O000000o2;
        }
        return null;
    }

    private static op O000000o(re reVar) {
        if (!reVar.f2423O000000o || reVar.O00000oO <= 60) {
            return null;
        }
        try {
            String gcl = Core.gcl(reVar.O00000o0, reVar.O00000Oo, reVar.O00000o);
            if (gcl == null) {
                return null;
            }
            String[] split = gcl.split(",");
            op opVar = new op();
            opVar.O00000o = System.currentTimeMillis();
            opVar.O00000o0();
            opVar.O00000oO = "file";
            opVar.O000000o(Double.parseDouble(split[0]));
            opVar.O00000Oo(Double.parseDouble(split[1]));
            opVar.O000000o((float) Integer.parseInt(split[2]));
            return opVar;
        } catch (Throwable th) {
            om.O00000Oo("@_18_2_@", "@_18_2_1_@" + Log.getStackTraceString(th));
            return null;
        }
    }

    private static op O000000o(op opVar, rg rgVar, int i) {
        String str;
        if (rgVar.O00000oO.length() <= 0) {
            return null;
        }
        String sb = rgVar.O00000oO.toString();
        if (opVar == null) {
            str = null;
        } else {
            str = opVar.f2369O000000o + "," + opVar.O00000Oo;
        }
        try {
            String gwl = Core.gwl(sb, rgVar.f2425O000000o, i, str);
            if (gwl == null) {
                return null;
            }
            String[] split = gwl.split(",");
            op opVar2 = new op();
            opVar2.O00000o = System.currentTimeMillis();
            opVar2.O00000o0();
            opVar2.O00000oO = "wifioff";
            opVar2.O000000o(Double.parseDouble(split[0]));
            opVar2.O00000Oo(Double.parseDouble(split[1]));
            opVar2.O000000o((float) Integer.parseInt(split[2]));
            return opVar2;
        } catch (Throwable th) {
            om.O00000Oo("@_18_2_@", "@_18_2_2_@" + Log.getStackTraceString(th));
            return null;
        }
    }
}
