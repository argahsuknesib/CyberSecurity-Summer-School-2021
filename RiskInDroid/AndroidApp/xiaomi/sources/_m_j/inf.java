package _m_j;

import android.os.Handler;
import android.os.Looper;
import com.yanzhenjie.permission.PermissionActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class inf implements ini, PermissionActivity.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final inu f1494O000000o = new ins();
    private static final inu O00000o = new iob();
    private static final Handler O00000o0 = new Handler(Looper.getMainLooper());
    public ioh O00000Oo;
    private String[] O00000oO;
    private inh O00000oo;
    private inc O0000O0o;
    private inc O0000OOo;
    private String[] O0000Oo0;

    inf(ioh ioh) {
        this.O00000Oo = ioh;
    }

    public final ini O000000o(String... strArr) {
        this.O00000oO = strArr;
        return this;
    }

    public final ini O000000o(inh inh) {
        this.O00000oo = null;
        return this;
    }

    public final ini O000000o(inc inc) {
        this.O0000O0o = inc;
        return this;
    }

    public final ini O00000Oo(inc inc) {
        this.O0000OOo = inc;
        return this;
    }

    public final void O000000o() {
        if (this.O00000Oo.O000000o().getApplicationInfo().targetSdkVersion < 23) {
            O000000o(O000000o(O00000o, this.O00000Oo, this.O00000oO));
            return;
        }
        List<String> O000000o2 = O000000o(O00000o, this.O00000Oo, this.O00000oO);
        this.O0000Oo0 = (String[]) O000000o2.toArray(new String[O000000o2.size()]);
        String[] strArr = this.O0000Oo0;
        if (strArr.length > 0) {
            ioh ioh = this.O00000Oo;
            ArrayList arrayList = new ArrayList(1);
            for (String str : strArr) {
                if (ioh.O000000o(str)) {
                    arrayList.add(str);
                }
            }
            if (arrayList.size() <= 0 || this.O00000oo == null) {
                PermissionActivity.requestPermission(this.O00000Oo.O000000o(), this.O0000Oo0, this);
                return;
            }
            return;
        }
        O00000Oo();
    }

    public final void O00000Oo(final String[] strArr) {
        O00000o0.postDelayed(new Runnable() {
            /* class _m_j.inf.AnonymousClass1 */

            public final void run() {
                List<String> O000000o2 = inf.O000000o(inf.f1494O000000o, inf.this.O00000Oo, strArr);
                if (O000000o2.isEmpty()) {
                    inf.this.O00000Oo();
                } else {
                    inf.this.O000000o(O000000o2);
                }
            }
        }, 250);
    }

    public final void O00000Oo() {
        if (this.O0000O0o != null) {
            List asList = Arrays.asList(this.O00000oO);
            try {
                this.O0000O0o.onAction(asList);
            } catch (Exception unused) {
                inc inc = this.O0000OOo;
                if (inc != null) {
                    inc.onAction(asList);
                }
            }
        }
    }

    public final void O000000o(List<String> list) {
        inc inc = this.O0000OOo;
        if (inc != null) {
            inc.onAction(list);
        }
    }

    public static List<String> O000000o(inu inu, ioh ioh, String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!inu.O000000o(ioh.O000000o(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
