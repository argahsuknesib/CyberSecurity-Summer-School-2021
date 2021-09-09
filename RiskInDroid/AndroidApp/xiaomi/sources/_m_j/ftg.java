package _m_j;

import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.Arrays;

public final class ftg {
    public static void O000000o(NetRequest netRequest, fso fso) {
        String str;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(">>>request fail start\n");
            sb.append("path=" + netRequest.O00000Oo + "\n");
            StringBuilder sb2 = new StringBuilder("query params=");
            String str2 = null;
            if (netRequest.O00000oO == null) {
                str = null;
            } else {
                str = Arrays.toString(netRequest.O00000oO.toArray());
            }
            sb2.append(str);
            sb2.append("\n");
            sb.append(sb2.toString());
            StringBuilder sb3 = new StringBuilder("headers=");
            if (netRequest.O00000o != null) {
                str2 = Arrays.toString(netRequest.O00000o.toArray());
            }
            sb3.append(str2);
            sb3.append("\n");
            sb.append(sb3.toString());
            StringBuilder sb4 = new StringBuilder("error=");
            sb4.append(fso.f17063O000000o + "," + fso.O00000Oo);
            sb4.append("\n");
            sb.append(sb4.toString());
            sb.append("<<<request fail end\n");
            gsy.O00000o0(LogType.NETWORK, "MyLogHelper", sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            try {
                gsy.O00000o0(LogType.NETWORK, "MyLogHelper", e.getMessage());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void O000000o(String str, fso fso) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(">>>request fail start\n");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(" error=");
            sb2.append(fso.f17063O000000o + "," + fso.O00000Oo);
            sb2.append("\n");
            sb.append(sb2.toString());
            sb.append("<<<request fail end\n");
            gsy.O00000o0(LogType.NETWORK, "MyLogHelper", sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            try {
                gsy.O00000o0(LogType.NETWORK, "MyLogHelper", e.getMessage());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
