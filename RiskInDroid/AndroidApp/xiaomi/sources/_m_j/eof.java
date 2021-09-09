package _m_j;

import _m_j.eoe;
import android.content.Context;
import com.xiaomi.push.service.bd;
import java.io.File;
import java.util.Date;

public final class eof extends eoe.O00000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    File f15672O000000o;
    final /* synthetic */ int O00000o;
    final /* synthetic */ Date O00000oO;
    final /* synthetic */ Date O00000oo;
    final /* synthetic */ String O0000O0o;
    final /* synthetic */ String O0000OOo;
    final /* synthetic */ eoe O0000Oo;
    final /* synthetic */ boolean O0000Oo0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public eof(eoe eoe, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.O0000Oo = eoe;
        this.O00000o = i;
        this.O00000oO = date;
        this.O00000oo = date2;
        this.O0000O0o = str;
        this.O0000OOo = str2;
        this.O0000Oo0 = z;
    }

    public final void c() {
        File file = this.f15672O000000o;
        if (file != null && file.exists()) {
            this.O0000Oo.f15669O000000o.add(new eoe.O00000o0(this.O0000O0o, this.O0000OOo, this.f15672O000000o, this.O0000Oo0));
        }
        this.O0000Oo.O00000Oo(0);
    }

    public final void b() {
        File file;
        File file2;
        File file3;
        String format;
        if (elg.O00000o0()) {
            try {
                File file4 = new File(this.O0000Oo.O00000Oo.getExternalFilesDir(null) + "/.logcache");
                file4.mkdirs();
                if (file4.isDirectory()) {
                    eod eod = new eod();
                    int i = this.O00000o;
                    if (i != 0) {
                        eod.O00000oO = i;
                    }
                    Context O000000o2 = this.O0000Oo.O00000Oo;
                    Date date = this.O00000oO;
                    Date date2 = this.O00000oo;
                    if ("com.xiaomi.xmsf".equalsIgnoreCase(O000000o2.getPackageName())) {
                        file = new File(O000000o2.getExternalFilesDir(null), bd.M);
                        if (!file.exists()) {
                            file = new File(O000000o2.getFilesDir(), bd.M);
                        }
                        if (!file.exists()) {
                            file = O000000o2.getFilesDir();
                        }
                        eod.O000000o(new File(file, "xmsf.log.1"));
                        file2 = new File(file, "xmsf.log");
                    } else {
                        file = new File(O000000o2.getExternalFilesDir(null) + eod.O00000Oo);
                        eod.O000000o(new File(file, "log0.txt"));
                        file2 = new File(file, "log1.txt");
                    }
                    eod.O000000o(file2);
                    if (file.isDirectory()) {
                        file3 = new File(file4, date.getTime() + "-" + date2.getTime() + ".zip");
                        if (!file3.exists()) {
                            if (date.after(date2)) {
                                eod.O00000o0 = eod.f15668O000000o.format(date2);
                                format = eod.f15668O000000o.format(date);
                            } else {
                                eod.O00000o0 = eod.f15668O000000o.format(date);
                                format = eod.f15668O000000o.format(date2);
                            }
                            eod.O00000o = format;
                            long currentTimeMillis = System.currentTimeMillis();
                            File file5 = new File(file4, "log.txt");
                            eod.O00000Oo(file5);
                            duv.O00000o0("LOG: filter cost = " + (System.currentTimeMillis() - currentTimeMillis));
                            if (file5.exists()) {
                                long currentTimeMillis2 = System.currentTimeMillis();
                                ele.O000000o(file3, file5);
                                duv.O00000o0("LOG: zip cost = " + (System.currentTimeMillis() - currentTimeMillis2));
                                file5.delete();
                                if (file3.exists()) {
                                    this.f15672O000000o = file3;
                                }
                            }
                        }
                    }
                    file3 = null;
                    this.f15672O000000o = file3;
                }
            } catch (NullPointerException unused) {
            }
        }
    }
}
