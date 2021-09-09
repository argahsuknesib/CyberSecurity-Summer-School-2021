package _m_j;

import com.amap.location.security.Core;
import java.util.HashMap;

public final class tj {
    public static boolean O000000o(ox oxVar, String str, byte[] bArr, int i) {
        try {
            byte[] O000000o2 = pc.O000000o(bArr);
            if (O000000o2 != null) {
                if (O000000o2.length != 0) {
                    byte[] xxt = Core.xxt(O000000o2, 1);
                    if (xxt != null) {
                        if (xxt.length != 0) {
                            if (oxVar != null) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("ext", "120");
                                ov ovVar = new ov();
                                ovVar.f2376O000000o = str;
                                ovVar.O00000Oo = hashMap;
                                ovVar.O00000o0 = xxt;
                                ovVar.O00000o = i;
                                ow O000000o3 = oxVar.O000000o(ovVar);
                                if (O000000o3 != null) {
                                    if (O000000o3.O00000o0 != null) {
                                        return O000000o3.f2377O000000o == 200 && "true".equals(new String(O000000o3.O00000o0, "UTF-8"));
                                    }
                                }
                            }
                        }
                    }
                    om.O00000Oo("HttpRequestHelper", "xxt is null");
                    return false;
                }
            }
            om.O00000Oo("HttpRequestHelper", "gzip is null");
        } catch (Throwable unused) {
        }
        return false;
    }
}
