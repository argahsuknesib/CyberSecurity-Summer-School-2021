package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.hp;
import com.xiaomi.push.hz;
import com.xiaomi.push.il;
import com.xiaomi.push.io;
import java.util.HashMap;

public class ebk {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile ebk f15148O000000o;
    private final Context O00000Oo;

    private ebk(Context context) {
        this.O00000Oo = context.getApplicationContext();
    }

    private static ebk O000000o(Context context) {
        if (f15148O000000o == null) {
            synchronized (ebk.class) {
                if (f15148O000000o == null) {
                    f15148O000000o = new ebk(context);
                }
            }
        }
        return f15148O000000o;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ebk.O000000o(com.xiaomi.push.il, int, boolean):void
     arg types: [com.xiaomi.push.il, int, int]
     candidates:
      _m_j.ebk.O000000o(android.content.Context, com.xiaomi.push.il, boolean):void
      _m_j.ebk.O000000o(com.xiaomi.push.il, int, boolean):void */
    public static void O000000o(Context context, il ilVar) {
        O000000o(context).O000000o(ilVar, 0, true);
    }

    public static void O000000o(Context context, il ilVar, boolean z) {
        O000000o(context).O000000o(ilVar, 1, z);
    }

    public static void O00000Oo(Context context, il ilVar, boolean z) {
        O000000o(context).O000000o(ilVar, 2, z);
    }

    public static void O00000o(Context context, il ilVar, boolean z) {
        O000000o(context).O000000o(ilVar, 4, z);
    }

    public static void O00000o0(Context context, il ilVar, boolean z) {
        O000000o(context).O000000o(ilVar, 3, z);
    }

    public static void O00000oO(Context context, il ilVar, boolean z) {
        ebk O000000o2;
        int i;
        b O000000o3 = b.O000000o(context);
        if (TextUtils.isEmpty(O000000o3.O00000Oo.O00000o0) || TextUtils.isEmpty(O000000o3.O00000Oo.O00000o)) {
            O000000o2 = O000000o(context);
            i = 6;
        } else if (O000000o3.O00000Oo()) {
            O000000o2 = O000000o(context);
            i = 7;
        } else {
            O000000o2 = O000000o(context);
            i = 5;
        }
        O000000o2.O000000o(ilVar, i, z);
    }

    private void O000000o(il ilVar, int i, boolean z) {
        if (!esl.O000000o(this.O00000Oo) && esl.O000000o() && ilVar != null && ilVar.f6426a == hp.e && ilVar.f122a != null && z) {
            duv.O000000o("click to start activity result:" + String.valueOf(i));
            io ioVar = new io(ilVar.f122a.f84a, false);
            ioVar.d = hz.ae.f70a;
            ioVar.c = ilVar.f124a;
            ioVar.f = ilVar.b;
            ioVar.f133a = new HashMap();
            ioVar.f133a.put("result", String.valueOf(i));
            eao.O000000o(this.O00000Oo).O000000o(ioVar, hp.i, false, false, null, true, ilVar.b, ilVar.f124a, true, false);
        }
    }
}
