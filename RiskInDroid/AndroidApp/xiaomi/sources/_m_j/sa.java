package _m_j;

import android.text.TextUtils;
import com.amap.location.security.Core;

public final class sa {
    public static long O000000o(long j) {
        try {
            return Core.encMac(pe.O000000o(j));
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static long O000000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Core.encMac(str);
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    public static String O000000o(or orVar) {
        StringBuilder sb;
        int i;
        if (!(orVar == null || orVar.O00000o == null)) {
            oq oqVar = orVar.O00000o;
            if (oqVar.f2370O000000o == 2) {
                sb = new StringBuilder();
                sb.append(oqVar.O00000oo);
                sb.append(":");
                sb.append(oqVar.O0000O0o);
                sb.append(":");
                i = oqVar.O0000OOo;
            } else if (!(oqVar.f2370O000000o == 0 || oqVar.O00000Oo == 0 || oqVar.O00000Oo == 65535)) {
                sb = new StringBuilder();
                sb.append(oqVar.O00000Oo);
                sb.append(":");
                sb.append(oqVar.O00000o0);
                sb.append(":");
                sb.append(oqVar.O00000o);
                sb.append(":");
                i = oqVar.O00000oO;
            }
            sb.append(i);
            return sb.toString();
        }
        return "";
    }
}
