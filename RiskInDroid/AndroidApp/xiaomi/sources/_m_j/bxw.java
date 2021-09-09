package _m_j;

import _m_j.byb;
import android.os.Environment;
import android.os.Looper;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class bxw {
    public static long O00000o = 3000;
    private static bxw O00000oo;
    private static bxv O0000O0o;

    /* renamed from: O000000o  reason: collision with root package name */
    public byb f13394O000000o = new byb(new byb.O000000o() {
        /* class _m_j.bxw.AnonymousClass1 */

        public final void O000000o(long j, long j2, long j3, long j4) {
            ArrayList<String> O000000o2 = byc.O000000o(j, j2);
            if (!O000000o2.isEmpty()) {
                bye O000000o3 = bye.O000000o();
                O000000o3.O0000Oo0 = j2 - j;
                O000000o3.O0000Oo = j4 - j3;
                O000000o3.O0000OoO = String.valueOf(j);
                O000000o3.O0000Ooo = String.valueOf(j2);
                O000000o3.O0000o00 = bxw.this.O00000o0.O000000o(j, j2);
                O000000o3.O0000o0 = bxw.this.O00000o0.O00000o();
                O000000o3.O0000o0O = O000000o2;
                bye O00000Oo = O000000o3.O00000Oo();
                bxv.O00000oO();
                if (bxw.this.O00000oO.size() != 0) {
                    for (bxx O000000o4 : bxw.this.O00000oO) {
                        bxw.O00000Oo();
                        bxv.O00000oo();
                        O000000o4.O000000o(O00000Oo);
                    }
                }
            }
        }
    }, O00000o, O0000O0o.O00000o());
    byc O00000Oo = new byc(Looper.getMainLooper().getThread(), O00000o);
    bxy O00000o0 = new bxy(O00000o);
    public List<bxx> O00000oO = new LinkedList();

    public bxw() {
        bya.O000000o();
    }

    static bxw O000000o() {
        if (O00000oo == null) {
            synchronized (bxw.class) {
                if (O00000oo == null) {
                    O00000oo = new bxw();
                }
            }
        }
        return O00000oo;
    }

    public static void O000000o(bxv bxv) {
        O0000O0o = bxv;
    }

    public static bxv O00000Oo() {
        return O0000O0o;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(bxx bxx) {
        this.O00000oO.add(bxx);
    }

    static class O000000o implements FilenameFilter {

        /* renamed from: O000000o  reason: collision with root package name */
        private String f13396O000000o = ".log";

        O000000o() {
        }

        public final boolean accept(File file, String str) {
            return str.endsWith(this.f13396O000000o);
        }
    }

    public static File[] O00000o0() {
        String str;
        String externalStorageState = Environment.getExternalStorageState();
        String O0000O0o2 = O0000O0o == null ? "" : bxv.O0000O0o();
        if (!"mounted".equals(externalStorageState) || !Environment.getExternalStorageDirectory().canWrite()) {
            str = bxv.O00000oo().getFilesDir() + bxv.O0000O0o();
        } else {
            str = Environment.getExternalStorageDirectory().getPath() + O0000O0o2;
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        return file.listFiles(new O000000o());
    }
}
