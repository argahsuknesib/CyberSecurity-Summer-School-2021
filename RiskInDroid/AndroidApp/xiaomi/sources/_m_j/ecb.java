package _m_j;

import com.xiaomi.mobilestats.data.ProtoMsg$StatsMsg;
import java.io.File;
import java.io.FileInputStream;

public final class ecb {
    private static String O000000o(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return "";
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            StringBuffer stringBuffer = new StringBuffer();
            byte[] bArr = new byte[1014];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    stringBuffer.append(new String(bArr, 0, read));
                } else {
                    String stringBuffer2 = stringBuffer.toString();
                    fileInputStream.close();
                    return stringBuffer2;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static een O000000o(int i, String str) {
        een een;
        byte[] O000000o2;
        ProtoMsg$StatsMsg.PageMsg O000000o3;
        byte[] O000000o4;
        ProtoMsg$StatsMsg.EventMsg O000000o5;
        byte[] O000000o6;
        ProtoMsg$StatsMsg.ClientMsg O000000o7;
        byte[] O000000o8;
        ProtoMsg$StatsMsg.ErrorMsg O000000o9;
        byte[] O000000o10;
        ProtoMsg$StatsMsg.CrashMsg O000000o11;
        ProtoMsg$StatsMsg.Crash O000000o12;
        byte[] O000000o13;
        ProtoMsg$StatsMsg.ViewMsg O000000o14;
        een een2 = null;
        if (ecd.O000000o(str)) {
            return null;
        }
        try {
            if (new File(str).length() > 16384) {
                return null;
            }
            String O000000o15 = O000000o(str);
            if (ecd.O000000o(O000000o15)) {
                return null;
            }
            String[] split = O000000o15.split("\n");
            if (i == 5) {
                edi O00000o0 = ProtoMsg$StatsMsg.PageMsg.O00000o0();
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (!(ecd.O000000o(split[i2]) || (O000000o2 = ebr.O000000o(split[i2])) == null || (O000000o3 = ProtoMsg$StatsMsg.PageMsg.O000000o(O000000o2)) == null)) {
                        O00000o0.O000000o(O000000o3.O000000o(0));
                    }
                }
                ProtoMsg$StatsMsg.PageMsg O000000o16 = O00000o0.build();
                if (O000000o16 != null) {
                    if (O000000o16.O00000Oo() > 0) {
                        return eca.O000000o(5, ecd.O000000o(O000000o16.toByteArray()));
                    }
                    een = new een();
                    een.f15191O000000o = true;
                    return een;
                }
                return een2;
            } else if (i == 7) {
                ede O00000o02 = ProtoMsg$StatsMsg.EventMsg.O00000o0();
                for (int i3 = 0; i3 < split.length; i3++) {
                    if (!(ecd.O000000o(split[i3]) || (O000000o4 = ebr.O000000o(split[i3])) == null || (O000000o5 = ProtoMsg$StatsMsg.EventMsg.O000000o(O000000o4)) == null)) {
                        O00000o02.O000000o(O000000o5.O000000o(0));
                    }
                }
                ProtoMsg$StatsMsg.EventMsg O000000o17 = O00000o02.build();
                if (O000000o17 != null) {
                    if (O000000o17.O00000Oo() > 0) {
                        return eca.O000000o(7, ecd.O000000o(O000000o17.toByteArray()));
                    }
                    een = new een();
                    een.f15191O000000o = true;
                    return een;
                }
                return een2;
            } else if (i == 9) {
                ecu O00000o03 = ProtoMsg$StatsMsg.ClientMsg.O00000o0();
                for (int i4 = 0; i4 < split.length; i4++) {
                    if (!(ecd.O000000o(split[i4]) || (O000000o6 = ebr.O000000o(split[i4])) == null || (O000000o7 = ProtoMsg$StatsMsg.ClientMsg.O000000o(O000000o6)) == null)) {
                        O00000o03.O000000o(O000000o7.O000000o(0));
                    }
                }
                ProtoMsg$StatsMsg.ClientMsg O000000o18 = O00000o03.build();
                if (O000000o18 != null) {
                    if (O000000o18.O00000Oo() > 0) {
                        return eca.O000000o(9, ecd.O000000o(O000000o18.toByteArray()));
                    }
                    een = new een();
                    een.f15191O000000o = true;
                    return een;
                }
                return een2;
            } else if (i == 11) {
                edb O00000o04 = ProtoMsg$StatsMsg.ErrorMsg.O00000o0();
                for (int i5 = 0; i5 < split.length; i5++) {
                    if (!(ecd.O000000o(split[i5]) || (O000000o8 = ebr.O000000o(split[i5])) == null || (O000000o9 = ProtoMsg$StatsMsg.ErrorMsg.O000000o(O000000o8)) == null)) {
                        O00000o04.O000000o(O000000o9.O000000o(0));
                    }
                }
                ProtoMsg$StatsMsg.ErrorMsg O000000o19 = O00000o04.build();
                if (O000000o19 != null) {
                    if (O000000o19.O00000Oo() > 0) {
                        return eca.O000000o(11, ecd.O000000o(O000000o19.toByteArray()));
                    }
                    een = new een();
                    een.f15191O000000o = true;
                    return een;
                }
                return een2;
            } else if (i != 13) {
                if (i == 17) {
                    edq O00000o05 = ProtoMsg$StatsMsg.ViewMsg.O00000o0();
                    for (int i6 = 0; i6 < split.length; i6++) {
                        if (!(ecd.O000000o(split[i6]) || (O000000o13 = ebr.O000000o(split[i6])) == null || (O000000o14 = ProtoMsg$StatsMsg.ViewMsg.O000000o(O000000o13)) == null)) {
                            O00000o05.O000000o(O000000o14.O000000o(0));
                        }
                    }
                    ProtoMsg$StatsMsg.ViewMsg O000000o20 = O00000o05.build();
                    if (O000000o20 != null) {
                        if (O000000o20.O00000Oo() > 0) {
                            return eca.O000000o(17, ecd.O000000o(O000000o20.toByteArray()));
                        }
                        een = new een();
                        try {
                            een.f15191O000000o = true;
                            return een;
                        } catch (Exception e) {
                            een2 = een;
                            e = e;
                        }
                    }
                }
                return een2;
            } else {
                ecy O00000o06 = ProtoMsg$StatsMsg.CrashMsg.O00000o0();
                for (int i7 = 0; i7 < split.length; i7++) {
                    if (!(ecd.O000000o(split[i7]) || (O000000o10 = ebr.O000000o(split[i7])) == null || (O000000o11 = ProtoMsg$StatsMsg.CrashMsg.O000000o(O000000o10)) == null || (O000000o12 = O000000o11.O000000o(0)) == null)) {
                        int O000000o21 = ebt.O000000o().O000000o(O000000o12.O0000oO0());
                        if (O000000o21 > 1) {
                            O000000o12 = ebv.O000000o(O000000o12, O000000o21);
                        }
                        O00000o06.O000000o(O000000o12);
                    }
                }
                ProtoMsg$StatsMsg.CrashMsg O000000o22 = O00000o06.build();
                if (O000000o22 != null) {
                    if (O000000o22.O00000Oo() > 0) {
                        een = eca.O000000o(13, ecd.O000000o(O000000o22.toByteArray()));
                    } else {
                        een = new een();
                        een.f15191O000000o = true;
                    }
                    een2 = een;
                }
                if (een2 != null) {
                    if (een2.f15191O000000o) {
                        ebt.O000000o().O00000Oo();
                    }
                }
                return een2;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return een2;
        }
    }
}
