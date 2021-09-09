package _m_j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.mipush.sdk.au;
import com.xiaomi.mipush.sdk.e;
import java.util.HashMap;

final class eap extends Handler {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ eao f15129O000000o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    eap(eao eao, Looper looper) {
        super(looper);
        this.f15129O000000o = eao;
    }

    public final void dispatchMessage(Message message) {
        eao eao;
        au auVar;
        HashMap<String, String> O00000Oo;
        eao eao2;
        au auVar2;
        if (message.what == 19) {
            String str = (String) message.obj;
            int i = message.arg1;
            synchronized (eah.class) {
                if (eah.O000000o(this.f15129O000000o.f15127O000000o).O00000oO(str)) {
                    if (eah.O000000o(this.f15129O000000o.f15127O000000o).O00000o0(str) < 10) {
                        if (au.f6052a.ordinal() == i && "syncing".equals(eah.O000000o(this.f15129O000000o.f15127O000000o).O000000o(au.f6052a))) {
                            eao2 = this.f15129O000000o;
                            auVar2 = au.f6052a;
                        } else if (au.b.ordinal() != i || !"syncing".equals(eah.O000000o(this.f15129O000000o.f15127O000000o).O000000o(au.b))) {
                            if (au.c.ordinal() == i && "syncing".equals(eah.O000000o(this.f15129O000000o.f15127O000000o).O000000o(au.c))) {
                                eao = this.f15129O000000o;
                                auVar = au.c;
                                O00000Oo = ebb.O00000Oo(this.f15129O000000o.f15127O000000o, e.f6055a);
                            } else if (au.d.ordinal() == i && "syncing".equals(eah.O000000o(this.f15129O000000o.f15127O000000o).O000000o(au.d))) {
                                eao = this.f15129O000000o;
                                auVar = au.d;
                                O00000Oo = ebb.O00000Oo(this.f15129O000000o.f15127O000000o, e.b);
                            } else if (au.e.ordinal() != i || !"syncing".equals(eah.O000000o(this.f15129O000000o.f15127O000000o).O000000o(au.e))) {
                                if (au.f.ordinal() == i && "syncing".equals(eah.O000000o(this.f15129O000000o.f15127O000000o).O000000o(au.f))) {
                                    eao = this.f15129O000000o;
                                    auVar = au.f;
                                    O00000Oo = ebb.O00000Oo(this.f15129O000000o.f15127O000000o, e.d);
                                }
                                eah.O000000o(this.f15129O000000o.f15127O000000o).O00000Oo(str);
                            } else {
                                eao = this.f15129O000000o;
                                auVar = au.e;
                                O00000Oo = ebb.O00000Oo(this.f15129O000000o.f15127O000000o, e.c);
                            }
                            eao.O000000o(str, auVar, false, O00000Oo);
                            eah.O000000o(this.f15129O000000o.f15127O000000o).O00000Oo(str);
                        } else {
                            eao2 = this.f15129O000000o;
                            auVar2 = au.b;
                        }
                        eao2.O000000o(str, auVar2, true, null);
                        eah.O000000o(this.f15129O000000o.f15127O000000o).O00000Oo(str);
                    } else {
                        eah.O000000o(this.f15129O000000o.f15127O000000o).O00000o(str);
                    }
                }
            }
        }
    }
}
