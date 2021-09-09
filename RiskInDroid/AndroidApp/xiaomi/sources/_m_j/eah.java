package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.mipush.sdk.au;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class eah {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile eah f15122O000000o;
    private Context O00000Oo;
    private List<ebm> O00000o0 = new ArrayList();

    private eah(Context context) {
        this.O00000Oo = context.getApplicationContext();
        if (this.O00000Oo == null) {
            this.O00000Oo = context;
        }
    }

    public static eah O000000o(Context context) {
        if (f15122O000000o == null) {
            synchronized (eah.class) {
                if (f15122O000000o == null) {
                    f15122O000000o = new eah(context);
                }
            }
        }
        return f15122O000000o;
    }

    public final synchronized String O000000o(au auVar) {
        return this.O00000Oo.getSharedPreferences("mipush_extra", 0).getString(auVar.name(), "");
    }

    public final synchronized void O000000o(au auVar, String str) {
        SharedPreferences sharedPreferences = this.O00000Oo.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(auVar.name(), str).commit();
    }

    public final void O000000o(String str) {
        synchronized (this.O00000o0) {
            ebm ebm = new ebm();
            ebm.f15150O000000o = 0;
            ebm.O00000Oo = str;
            if (this.O00000o0.contains(ebm)) {
                this.O00000o0.remove(ebm);
            }
            this.O00000o0.add(ebm);
        }
    }

    public final void O00000Oo(String str) {
        synchronized (this.O00000o0) {
            ebm ebm = new ebm();
            ebm.O00000Oo = str;
            if (this.O00000o0.contains(ebm)) {
                Iterator<ebm> it = this.O00000o0.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ebm next = it.next();
                    if (ebm.equals(next)) {
                        ebm = next;
                        break;
                    }
                }
            }
            ebm.f15150O000000o++;
            this.O00000o0.remove(ebm);
            this.O00000o0.add(ebm);
        }
    }

    public final void O00000o(String str) {
        synchronized (this.O00000o0) {
            ebm ebm = new ebm();
            ebm.O00000Oo = str;
            if (this.O00000o0.contains(ebm)) {
                this.O00000o0.remove(ebm);
            }
        }
    }

    public final int O00000o0(String str) {
        synchronized (this.O00000o0) {
            ebm ebm = new ebm();
            ebm.O00000Oo = str;
            if (this.O00000o0.contains(ebm)) {
                for (ebm next : this.O00000o0) {
                    if (next.equals(ebm)) {
                        int i = next.f15150O000000o;
                        return i;
                    }
                }
            }
            return 0;
        }
    }

    public final boolean O00000oO(String str) {
        synchronized (this.O00000o0) {
            ebm ebm = new ebm();
            ebm.O00000Oo = str;
            return this.O00000o0.contains(ebm);
        }
    }
}
