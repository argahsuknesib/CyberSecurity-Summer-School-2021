package _m_j;

import _m_j.duw;
import _m_j.elo;
import android.content.Context;
import com.xiaomi.push.br;
import com.xiaomi.push.bs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class dvb {
    private static volatile dvb O0000Oo;
    private static final int O0000Oo0 = (esl.O000000o() ? 30 : 10);

    /* renamed from: O000000o  reason: collision with root package name */
    public ExecutorService f14966O000000o = Executors.newSingleThreadExecutor();
    HashMap<String, HashMap<String, duz>> O00000Oo = new HashMap<>();
    public Context O00000o;
    HashMap<String, ArrayList<duz>> O00000o0 = new HashMap<>();
    public duw O00000oO;
    public String O00000oo;
    public dvk O0000O0o;
    public dvl O0000OOo;

    private dvb(Context context) {
        this.O00000o = context;
    }

    public static dvb O000000o(Context context) {
        if (O0000Oo == null) {
            synchronized (dvb.class) {
                if (O0000Oo == null) {
                    O0000Oo = new dvb(context);
                }
            }
        }
        return O0000Oo;
    }

    private void O000000o(elo.O000000o o000000o, int i) {
        elo.O000000o(this.O00000o).O000000o(o000000o, i);
    }

    /* access modifiers changed from: private */
    public void O00000o() {
        try {
            this.O0000O0o.O00000Oo();
        } catch (Exception e) {
            duv.O00000o("we: " + e.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void O00000oO() {
        try {
            this.O0000OOo.O00000Oo();
        } catch (Exception e) {
            duv.O00000o("wp: " + e.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public int O00000oo() {
        HashMap<String, ArrayList<duz>> hashMap = this.O00000o0;
        if (hashMap == null) {
            return 0;
        }
        int i = 0;
        for (String str : hashMap.keySet()) {
            ArrayList arrayList = this.O00000o0.get(str);
            i += arrayList != null ? arrayList.size() : 0;
        }
        return i;
    }

    /* access modifiers changed from: private */
    public int O0000O0o() {
        HashMap<String, HashMap<String, duz>> hashMap = this.O00000Oo;
        int i = 0;
        if (hashMap != null) {
            for (String str : hashMap.keySet()) {
                HashMap hashMap2 = this.O00000Oo.get(str);
                if (hashMap2 != null) {
                    for (String str2 : hashMap2.keySet()) {
                        duz duz = (duz) hashMap2.get(str2);
                        if (duz instanceof duy) {
                            i = (int) (((long) i) + ((duy) duz).O00000Oo);
                        }
                    }
                }
            }
        }
        return i;
    }

    public final synchronized duw O000000o() {
        if (this.O00000oO == null) {
            Context context = this.O00000o;
            duw.O000000o O000000o2 = new duw.O000000o().O000000o(true);
            O000000o2.O00000o = emn.O000000o(context);
            O000000o2.O00000oO = 1048576;
            duw.O000000o O00000Oo2 = O000000o2.O00000Oo(false);
            O00000Oo2.O00000oo = 86400;
            duw.O000000o O00000o02 = O00000Oo2.O00000o0(false);
            O00000o02.O0000O0o = 86400;
            this.O00000oO = O00000o02.O000000o(context);
        }
        return this.O00000oO;
    }

    public final void O00000Oo() {
        if (O000000o(this.O00000o).O000000o().O00000Oo) {
            br brVar = new br(this.O00000o);
            int i = (int) O000000o(this.O00000o).O000000o().O00000oO;
            int i2 = 1800;
            if (i >= 1800) {
                i2 = i;
            }
            if (System.currentTimeMillis() - emq.O000000o(this.O00000o).O000000o("sp_client_report_status", "event_last_upload_time") > ((long) (i2 * 1000))) {
                elo.O000000o(this.O00000o).O000000o(new dvi(this, brVar), 10);
            }
            synchronized (dvb.class) {
                if (!elo.O000000o(this.O00000o).O000000o(brVar, i2, 0)) {
                    elo.O000000o(this.O00000o).O000000o("100886");
                    elo.O000000o(this.O00000o).O000000o(brVar, i2, 0);
                }
            }
        }
    }

    public final void O00000o0() {
        if (O000000o(this.O00000o).O000000o().O00000o0) {
            bs bsVar = new bs(this.O00000o);
            int i = (int) O000000o(this.O00000o).O000000o().O00000oo;
            int i2 = 1800;
            if (i >= 1800) {
                i2 = i;
            }
            if (System.currentTimeMillis() - emq.O000000o(this.O00000o).O000000o("sp_client_report_status", "perf_last_upload_time") > ((long) (i2 * 1000))) {
                elo.O000000o(this.O00000o).O000000o(new dvj(this, bsVar), 15);
            }
            synchronized (dvb.class) {
                if (!elo.O000000o(this.O00000o).O000000o(bsVar, i2, 0)) {
                    elo.O000000o(this.O00000o).O000000o("100887");
                    elo.O000000o(this.O00000o).O000000o(bsVar, i2, 0);
                }
            }
        }
    }

    public final dux O000000o(String str) {
        dux dux = new dux();
        dux.O00000o = str;
        dux.O00000o0 = System.currentTimeMillis();
        dux.O00000Oo = 5001;
        dux.f14963O000000o = eml.O000000o(6);
        dux.O00000oO = 1000;
        dux.O0000O0o = 1001;
        dux.O00000oo = "E100004";
        dux.O0000OOo = this.O00000o.getPackageName();
        dux.O0000Oo0 = this.O00000oo;
        return dux;
    }

    static /* synthetic */ void O000000o(dvb dvb, dux dux) {
        dvk dvk = dvb.O0000O0o;
        if (dvk != null) {
            dvk.O000000o(dux);
            if (dvb.O00000oo() >= 10) {
                dvb.O00000o();
                elo.O000000o(dvb.O00000o).O000000o("100888");
                return;
            }
            dvb.O000000o(new dve(dvb), O0000Oo0);
        }
    }

    static /* synthetic */ void O000000o(dvb dvb, duy duy) {
        dvl dvl = dvb.O0000OOo;
        if (dvl != null) {
            dvl.O000000o(duy);
            if (dvb.O0000O0o() >= 10) {
                dvb.O00000oO();
                elo.O000000o(dvb.O00000o).O000000o("100889");
                return;
            }
            dvb.O000000o(new dvg(dvb), O0000Oo0);
        }
    }
}
