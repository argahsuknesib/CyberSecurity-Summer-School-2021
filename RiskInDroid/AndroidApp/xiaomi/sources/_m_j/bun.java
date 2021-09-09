package _m_j;

import android.content.Context;
import com.loc.dq;
import java.util.ArrayList;

public class bun implements buo {

    /* renamed from: O000000o  reason: collision with root package name */
    static bun f13293O000000o = null;
    private static buf O00000o = null;
    private static buq O00000o0 = buq.O000000o();
    private boolean O00000Oo = false;

    private bun() {
    }

    public static buo O000000o(Context context, String str) {
        if (f13293O000000o == null) {
            synchronized (bun.class) {
                if (f13293O000000o == null) {
                    if (!buv.O000000o()) {
                        Thread thread = new Thread(new bus(context));
                        thread.setUncaughtExceptionHandler(new buw());
                        thread.start();
                    }
                    buy.O000000o(context);
                    dq.a(context);
                    but.O000000o(str);
                    f13293O000000o = new bun();
                }
            }
        }
        return f13293O000000o;
    }

    public final void O000000o() {
        this.O00000Oo = true;
    }

    public final void O000000o(ArrayList arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            String str = (String) arrayList.get(i);
            if (!buq.O000000o(str)) {
                bup.O000000o().submit(new dq(str));
            }
        }
    }
}
