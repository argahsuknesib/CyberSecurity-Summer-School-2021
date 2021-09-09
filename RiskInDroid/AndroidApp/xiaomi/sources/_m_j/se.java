package _m_j;

import _m_j.sk;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import com.amap.openapi.da;

public class se {
    private static volatile se O00000o;

    /* renamed from: O000000o  reason: collision with root package name */
    sl f2452O000000o;
    public sk O00000Oo;
    si O00000o0;
    private so O00000oO;
    private sn O00000oo;
    private sp O0000O0o;

    public static se O000000o(Context context) {
        if (O00000o == null) {
            synchronized (se.class) {
                if (O00000o == null) {
                    O00000o = new se(context);
                }
            }
        }
        return O00000o;
    }

    public final void O000000o(sh shVar) {
        sp spVar;
        if (shVar != null && (spVar = this.O0000O0o) != null) {
            spVar.O000000o(shVar);
        }
    }

    public final boolean O000000o(sh shVar, Looper looper) {
        sp spVar;
        return (shVar == null || (spVar = this.O0000O0o) == null || !spVar.O000000o(shVar, looper)) ? false : true;
    }

    public final boolean O000000o(String str) {
        sl slVar = this.f2452O000000o;
        if (slVar == null) {
            return false;
        }
        return slVar.O000000o(str);
    }

    private se(Context context) {
        this.f2452O000000o = new da(context.getApplicationContext());
        this.O0000O0o = new sp(this.f2452O000000o, context);
        if (Build.VERSION.SDK_INT >= 24) {
            this.O00000oo = new sn(this.f2452O000000o, context);
        }
        this.O00000oO = new so(this.f2452O000000o, context);
        this.O00000Oo = new sk(this.f2452O000000o);
        this.O00000o0 = new si(this.f2452O000000o, context.getApplicationContext());
    }

    public final void O000000o(sf sfVar) {
        if (sfVar != null) {
            sk skVar = this.O00000Oo;
            if (sfVar != null) {
                synchronized (skVar.f2459O000000o) {
                    sk.O000000o O000000o2 = skVar.O000000o(sfVar);
                    if (O000000o2 != null) {
                        skVar.f2459O000000o.remove(O000000o2);
                        if (skVar.f2459O000000o.size() == 0) {
                            if (Build.VERSION.SDK_INT >= 24) {
                                if (skVar.O00000o0 != null) {
                                    skVar.O00000Oo.O00000Oo(skVar.O00000o0);
                                }
                            } else if (skVar.O00000o != null) {
                                skVar.O00000Oo.O00000Oo(skVar.O00000o);
                            }
                        }
                    }
                }
            }
        }
    }
}
