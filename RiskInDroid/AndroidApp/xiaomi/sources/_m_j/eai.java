package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.mipush.sdk.e;
import com.xiaomi.mipush.sdk.u;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hp;
import com.xiaomi.push.ie;
import com.xiaomi.push.ig;
import com.xiaomi.push.ik;
import com.xiaomi.push.il;
import com.xiaomi.push.io;
import com.xiaomi.push.iq;
import com.xiaomi.push.ir;
import com.xiaomi.push.is;
import com.xiaomi.push.iu;
import com.xiaomi.push.iw;
import com.xiaomi.push.iy;
import com.xiaomi.push.ja;
import java.nio.ByteBuffer;

public final class eai {
    protected static <T extends ja<T, ?>> il O000000o(Context context, T t, hp hpVar, boolean z, String str, String str2) {
        return O000000o(context, t, hpVar, z, str, str2, true);
    }

    protected static <T extends ja<T, ?>> il O00000Oo(Context context, T t, hp hpVar, boolean z, String str, String str2) {
        return O000000o(context, t, hpVar, z, str, str2, false);
    }

    protected static <T extends ja<T, ?>> il O000000o(Context context, T t, hp hpVar) {
        return O000000o(context, t, hpVar, !hpVar.equals(hp.f6389a), context.getPackageName(), b.O000000o(context).O00000Oo.f6054O000000o);
    }

    private static <T extends ja<T, ?>> il O000000o(Context context, T t, hp hpVar, boolean z, String str, String str2, boolean z2) {
        byte[] O000000o2 = eru.O000000o(t);
        if (O000000o2 == null) {
            duv.O000000o("invoke convertThriftObjectToBytes method, return null.");
            return null;
        }
        il ilVar = new il();
        if (z) {
            String str3 = b.O000000o(context).O00000Oo.O00000o;
            if (TextUtils.isEmpty(str3)) {
                duv.O000000o("regSecret is empty, return null");
                return null;
            }
            try {
                O000000o2 = ert.O00000Oo(emi.O00000Oo(str3), O000000o2);
            } catch (Exception unused) {
                duv.O00000o("encryption error. ");
            }
        }
        ie ieVar = new ie();
        ieVar.f6412a = 5;
        ieVar.f94a = "fakeid";
        ilVar.f123a = ieVar;
        ilVar.f125a = ByteBuffer.wrap(O000000o2);
        ilVar.f6426a = hpVar;
        ilVar.O00000Oo(z2);
        ilVar.b = str;
        ilVar.O000000o(z);
        ilVar.f124a = str2;
        return ilVar;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    public static ja O000000o(Context context, il ilVar) {
        byte[] bArr;
        ik ikVar;
        if (ilVar.f127a) {
            byte[] O000000o2 = ebb.O000000o(context, ilVar, e.b);
            if (O000000o2 == null) {
                O000000o2 = emi.O00000Oo(b.O000000o(context).O00000Oo.O00000o);
            }
            try {
                bArr = ert.O000000o(O000000o2, ilVar.O000000o());
            } catch (Exception e) {
                throw new u("the aes decrypt failed.", e);
            }
        } else {
            bArr = ilVar.O000000o();
        }
        hp hpVar = ilVar.f6426a;
        boolean z = ilVar.f128b;
        switch (eaj.f15123O000000o[hpVar.ordinal()]) {
            case 1:
                ikVar = new iq();
                break;
            case 2:
                ikVar = new iw();
                break;
            case 3:
                ikVar = new iu();
                break;
            case 4:
                ikVar = new iy();
                break;
            case 5:
                ikVar = new is();
                break;
            case 6:
                ikVar = new Cif();
                break;
            case 7:
                ikVar = new ik();
                break;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                ikVar = new ir();
                break;
            case 9:
                if (!z) {
                    ig igVar = new ig();
                    igVar.O00000Oo();
                    ikVar = igVar;
                    break;
                } else {
                    ikVar = new io();
                    break;
                }
            case 10:
                ikVar = new ik();
                break;
            default:
                ikVar = null;
                break;
        }
        if (ikVar != null) {
            eru.O000000o(ikVar, bArr);
        }
        return ikVar;
    }
}
