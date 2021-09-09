package _m_j;

import android.app.ActivityManager;
import android.content.Context;
import com.google.protobuf.ByteString;
import com.xiaomi.mobilestats.data.ProtoMsg$StatsMsg;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ebv {
    public static ProtoMsg$StatsMsg.CrashMsg O000000o(Context context, String str) {
        String str2;
        try {
            ecy O00000o0 = ProtoMsg$StatsMsg.CrashMsg.O00000o0();
            ecx O0000oOo = ProtoMsg$StatsMsg.Crash.O0000oOo();
            ecx O00000o02 = O0000oOo.O000000o("crash").O00000Oo(ecp.O000000o(context)).O00000o0(ecp.O00000Oo(context));
            StringBuilder sb = new StringBuilder();
            sb.append(ecp.O00000oo(context));
            ecx O0000Oo = O00000o02.O00000o(sb.toString()).O000000o(System.currentTimeMillis()).O00000oO(ebu.O000000o().O000000o(context)).O000000o(ecp.O00000o(context)).O0000O0o(ecp.O00000oO(context)).O00000oo(str).O0000OOo(ecp.O0000O0o(context)).O0000Oo0(ebs.O000000o()).O0000Oo("android");
            String str3 = "Unkown";
            if (context == null) {
                str2 = "";
            } else {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (activityManager != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(activityManager.getMemoryClass());
                    str2 = sb2.toString();
                } else {
                    str2 = str3;
                }
            }
            ecx O0000OoO = O0000Oo.O0000OoO(str2);
            if (context == null) {
                str3 = "";
            } else {
                ActivityManager activityManager2 = (ActivityManager) context.getSystemService("activity");
                if (activityManager2 != null) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(activityManager2.getLargeMemoryClass());
                    str3 = sb3.toString();
                }
            }
            O0000OoO.O0000Ooo(str3).O0000o00(ecd.O00000Oo(str)).O00000Oo(1).O0000o0(ecp.O0000OOo(context)).O0000o0O("mishopsdk_20170414");
            ebp.O000000o();
            HashMap O00000Oo = ebp.O00000Oo();
            if (O00000Oo != null && !O00000Oo.isEmpty()) {
                for (Map.Entry entry : O00000Oo.entrySet()) {
                    edn O00000o = ProtoMsg$StatsMsg.ProtoMap.O00000o();
                    O00000o.O000000o((String) entry.getKey());
                    O00000o.O00000Oo((String) entry.getValue());
                    O0000oOo.O000000o(O00000o);
                }
            }
            O00000o0.O000000o(O0000oOo);
            return O00000o0.build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ProtoMsg$StatsMsg.Crash O000000o(ProtoMsg$StatsMsg.Crash crash, int i) {
        ProtoMsg$StatsMsg.Crash crash2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        if (crash == null) {
            return crash;
        }
        try {
            ecx O0000oOo = ProtoMsg$StatsMsg.Crash.O0000oOo();
            ecx O000000o2 = O0000oOo.O000000o("crash");
            Object obj = crash.aD;
            if (obj instanceof String) {
                str = (String) obj;
            } else {
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    crash.aD = stringUtf8;
                }
                str = stringUtf8;
            }
            ecx O00000Oo = O000000o2.O00000Oo(str);
            Object obj2 = crash.aE;
            if (obj2 instanceof String) {
                str2 = (String) obj2;
            } else {
                ByteString byteString2 = (ByteString) obj2;
                String stringUtf82 = byteString2.toStringUtf8();
                if (byteString2.isValidUtf8()) {
                    crash.aE = stringUtf82;
                }
                str2 = stringUtf82;
            }
            ecx O00000o0 = O00000Oo.O00000o0(str2);
            Object obj3 = crash.aF;
            if (obj3 instanceof String) {
                str3 = (String) obj3;
            } else {
                ByteString byteString3 = (ByteString) obj3;
                String stringUtf83 = byteString3.toStringUtf8();
                if (byteString3.isValidUtf8()) {
                    crash.aF = stringUtf83;
                }
                str3 = stringUtf83;
            }
            ecx O000000o3 = O00000o0.O00000o(str3).O000000o(crash.bb);
            Object obj4 = crash.aG;
            if (obj4 instanceof String) {
                str4 = (String) obj4;
            } else {
                ByteString byteString4 = (ByteString) obj4;
                String stringUtf84 = byteString4.toStringUtf8();
                if (byteString4.isValidUtf8()) {
                    crash.aG = stringUtf84;
                }
                str4 = stringUtf84;
            }
            ecx O000000o4 = O000000o3.O00000oO(str4).O000000o(crash.aI);
            Object obj5 = crash.aJ;
            if (obj5 instanceof String) {
                str5 = (String) obj5;
            } else {
                ByteString byteString5 = (ByteString) obj5;
                String stringUtf85 = byteString5.toStringUtf8();
                if (byteString5.isValidUtf8()) {
                    crash.aJ = stringUtf85;
                }
                str5 = stringUtf85;
            }
            ecx O0000O0o = O000000o4.O0000O0o(str5);
            Object obj6 = crash.bv;
            if (obj6 instanceof String) {
                str6 = (String) obj6;
            } else {
                ByteString byteString6 = (ByteString) obj6;
                String stringUtf86 = byteString6.toStringUtf8();
                if (byteString6.isValidUtf8()) {
                    crash.bv = stringUtf86;
                }
                str6 = stringUtf86;
            }
            ecx O00000oo = O0000O0o.O00000oo(str6);
            Object obj7 = crash.aH;
            if (obj7 instanceof String) {
                str7 = (String) obj7;
            } else {
                ByteString byteString7 = (ByteString) obj7;
                String stringUtf87 = byteString7.toStringUtf8();
                if (byteString7.isValidUtf8()) {
                    crash.aH = stringUtf87;
                }
                str7 = stringUtf87;
            }
            ecx O0000OOo = O00000oo.O0000OOo(str7);
            Object obj8 = crash.aP;
            if (obj8 instanceof String) {
                str8 = (String) obj8;
            } else {
                ByteString byteString8 = (ByteString) obj8;
                String stringUtf88 = byteString8.toStringUtf8();
                if (byteString8.isValidUtf8()) {
                    crash.aP = stringUtf88;
                }
                str8 = stringUtf88;
            }
            ecx O0000Oo = O0000OOo.O0000Oo0(str8).O0000Oo("android");
            Object obj9 = crash.bx;
            if (obj9 instanceof String) {
                str9 = (String) obj9;
            } else {
                ByteString byteString9 = (ByteString) obj9;
                String stringUtf89 = byteString9.toStringUtf8();
                if (byteString9.isValidUtf8()) {
                    crash.bx = stringUtf89;
                }
                str9 = stringUtf89;
            }
            ecx O0000OoO = O0000Oo.O0000OoO(str9);
            Object obj10 = crash.by;
            if (obj10 instanceof String) {
                str10 = (String) obj10;
            } else {
                ByteString byteString10 = (ByteString) obj10;
                String stringUtf810 = byteString10.toStringUtf8();
                if (byteString10.isValidUtf8()) {
                    crash.by = stringUtf810;
                }
                str10 = stringUtf810;
            }
            ecx O00000Oo2 = O0000OoO.O0000Ooo(str10).O0000o00(crash.O0000oO0()).O00000Oo(i);
            Object obj11 = crash.bh;
            if (obj11 instanceof String) {
                str11 = (String) obj11;
            } else {
                ByteString byteString11 = (ByteString) obj11;
                String stringUtf811 = byteString11.toStringUtf8();
                if (byteString11.isValidUtf8()) {
                    crash.bh = stringUtf811;
                }
                str11 = stringUtf811;
            }
            O00000Oo2.O0000o0(str11).O0000o0O("mishopsdk_20170414");
            List<ProtoMsg$StatsMsg.ProtoMap> list = crash.bw;
            if (list != null && list.size() > 0) {
                for (ProtoMsg$StatsMsg.ProtoMap O000000o5 : list) {
                    O0000oOo.O000000o(O000000o5);
                }
            }
            crash2 = O0000oOo.build();
        } catch (Exception e) {
            e.printStackTrace();
            crash2 = null;
        }
        return crash2 == null ? crash : crash2;
    }
}
