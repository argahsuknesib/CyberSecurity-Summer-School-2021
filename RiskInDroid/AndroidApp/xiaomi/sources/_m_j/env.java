package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.xiaomi.push.ff;
import com.xiaomi.push.hp;
import com.xiaomi.push.hz;
import com.xiaomi.push.ig;
import com.xiaomi.push.ij;
import com.xiaomi.push.ik;
import com.xiaomi.push.il;
import com.xiaomi.push.io;
import com.xiaomi.push.ja;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class env {
    private static int O000000o(Context context, int i) {
        int O00000Oo = erf.O00000Oo(context);
        if (-1 == O00000Oo) {
            return -1;
        }
        return (i * (O00000Oo == 0 ? 13 : 11)) / 10;
    }

    private static void O000000o(String str, Context context, int i, int i2) {
        if (i > 0 && i2 > 0) {
            int O000000o2 = O000000o(context, i2);
            if (i != epi.O000000o(hz.B)) {
                epj.O000000o(context.getApplicationContext()).O000000o(str, i, (long) O000000o2);
            }
        }
    }

    public static void O000000o(String str, Context context, ja jaVar, hp hpVar, int i) {
        O000000o(str, context, O000000o(jaVar, hpVar), i);
    }

    private static int O000000o(ja jaVar, hp hpVar) {
        int O00000Oo;
        int O000000o2;
        switch (enw.f15660O000000o[hpVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
            case 9:
            case 10:
                return epi.O00000Oo(hpVar.a());
            case 11:
                O00000Oo = epi.O00000Oo(hpVar.a());
                if (jaVar != null) {
                    try {
                        if (jaVar instanceof ig) {
                            String str = ((ig) jaVar).d;
                            if (!TextUtils.isEmpty(str) && epi.O000000o(epi.O000000o(str)) != -1) {
                                O000000o2 = epi.O000000o(epi.O000000o(str));
                                return O000000o2;
                            }
                        } else if (jaVar instanceof io) {
                            String str2 = ((io) jaVar).d;
                            if (!TextUtils.isEmpty(str2)) {
                                if (epi.O000000o(epi.O000000o(str2)) != -1) {
                                    O00000Oo = epi.O000000o(epi.O000000o(str2));
                                }
                                if (hz.B.equals(epi.O000000o(str2))) {
                                    return -1;
                                }
                            }
                        }
                    } catch (Exception unused) {
                        int i = O00000Oo;
                        duv.O00000o("PERF_ERROR : parse Notification type error");
                        return i;
                    }
                }
                return O00000Oo;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT:
                O00000Oo = epi.O00000Oo(hpVar.a());
                if (jaVar != null) {
                    try {
                        if (jaVar instanceof ik) {
                            String str3 = ((ik) jaVar).c;
                            if (!TextUtils.isEmpty(str3) && ff.a(str3) != -1) {
                                O000000o2 = ff.a(str3);
                                return O000000o2;
                            }
                        } else if (jaVar instanceof ij) {
                            String str4 = ((ij) jaVar).c;
                            if (!TextUtils.isEmpty(str4) && ff.a(str4) != -1) {
                                O000000o2 = ff.a(str4);
                                return O000000o2;
                            }
                        }
                    } catch (Exception unused2) {
                        duv.O00000o("PERF_ERROR : parse Command type error");
                    }
                }
                return O00000Oo;
            default:
                return -1;
        }
    }

    public static void O000000o(String str, Context context, il ilVar, int i) {
        hp hpVar;
        if (context != null && ilVar != null && (hpVar = ilVar.f6426a) != null) {
            int O00000Oo = epi.O00000Oo(hpVar.a());
            if (i <= 0) {
                byte[] O000000o2 = eru.O000000o(ilVar);
                i = O000000o2 != null ? O000000o2.length : 0;
            }
            O000000o(str, context, O00000Oo, i);
        }
    }
}
