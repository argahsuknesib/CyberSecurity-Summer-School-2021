package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.loc.cg;
import java.lang.ref.WeakReference;

public class btd {

    /* renamed from: O000000o  reason: collision with root package name */
    static WeakReference<btb> f13261O000000o;

    public static void O000000o(final Context context) {
        bsf.O00000o().submit(new Runnable() {
            /* class _m_j.btd.AnonymousClass1 */

            public final void run() {
                synchronized (btd.class) {
                    btb O000000o2 = bti.O000000o(btd.f13261O000000o);
                    bti.O000000o(context, O000000o2, bsd.O0000Oo, 50, 102400, "10");
                    if (O000000o2.O0000O0o == null) {
                        String O00000Oo = btd.O00000Oo(context);
                        O000000o2.O0000O0o = new btm(new btl(context, new btr(), new brv(new brz(new brx())), "WImFwcG5hbWUiOiIlcyIsInBrZyI6IiVzIiwiZGl1IjoiJXMi", bwt.O00000Oo(context), bwt.O00000o0(context), O00000Oo));
                    }
                    O000000o2.O0000OOo = 14400000;
                    if (TextUtils.isEmpty(O000000o2.O0000Oo0)) {
                        O000000o2.O0000Oo0 = "eKey";
                    }
                    if (O000000o2.O00000oo == null) {
                        O000000o2.O00000oo = new btv(context, O000000o2.O0000OOo, O000000o2.O0000Oo0, new bts(5, O000000o2.f13260O000000o, new cg(context)));
                    }
                    btc.O000000o(O000000o2);
                }
            }
        });
    }

    static /* synthetic */ String O00000Oo(Context context) {
        String O0000oOo = bww.O0000oOo(context);
        if (!TextUtils.isEmpty(O0000oOo)) {
            return O0000oOo;
        }
        String O0000O0o = bww.O0000O0o(context);
        if (!TextUtils.isEmpty(O0000O0o)) {
            return O0000O0o;
        }
        String O0000Ooo = bww.O0000Ooo(context);
        return !TextUtils.isEmpty(O0000Ooo) ? O0000Ooo : bww.O000000o(context);
    }
}
