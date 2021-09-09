package _m_j;

import _m_j.jof;
import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public final class jog {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final Set<String> f1994O000000o;
    protected final jof.O00000Oo O00000Oo;
    protected boolean O00000o;
    protected final jof.O000000o O00000o0;
    protected boolean O00000oO;

    protected jog() {
        this(new joh(), new joe());
    }

    private jog(jof.O00000Oo o00000Oo, jof.O000000o o000000o) {
        this.f1994O000000o = new HashSet();
        this.O00000Oo = o00000Oo;
        this.O00000o0 = o000000o;
    }

    public final void O000000o(Context context, String str, String str2, jof.O00000o0 o00000o0) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        } else if (!joi.O000000o(str)) {
            O000000o("Beginning load of %s...", str);
            O000000o(context, str, null);
        } else {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
    }

    public final void O000000o(Context context, String str, String str2) {
        joo joo;
        joo joo2;
        if (!this.f1994O000000o.contains(str) || this.O00000o) {
            try {
                this.O00000Oo.O000000o(str);
                this.f1994O000000o.add(str);
                O000000o("%s (%s) was loaded normally!", str, str2);
            } catch (UnsatisfiedLinkError e) {
                O000000o("Loading the library normally failed: %s", Log.getStackTraceString(e));
                O000000o("%s (%s) was not loaded normally, re-linking...", str, str2);
                File O00000Oo2 = O00000Oo(context, str, str2);
                if (!O00000Oo2.exists() || this.O00000o) {
                    if (this.O00000o) {
                        O000000o("Forcing a re-link of %s (%s)...", str, str2);
                    }
                    File dir = context.getDir("lib", 0);
                    File O00000Oo3 = O00000Oo(context, str, str2);
                    final String O00000o02 = this.O00000Oo.O00000o0(str);
                    File[] listFiles = dir.listFiles(new FilenameFilter() {
                        /* class _m_j.jog.AnonymousClass1 */

                        public final boolean accept(File file, String str) {
                            return str.startsWith(O00000o02);
                        }
                    });
                    if (listFiles != null) {
                        for (File file : listFiles) {
                            if (this.O00000o || !file.getAbsolutePath().equals(O00000Oo3.getAbsolutePath())) {
                                file.delete();
                            }
                        }
                    }
                    this.O00000o0.O000000o(context, this.O00000Oo.O000000o(), this.O00000Oo.O00000o0(str), O00000Oo2, this);
                }
                try {
                    if (this.O00000oO) {
                        joo = null;
                        joo2 = new joo(O00000Oo2);
                        List<String> O000000o2 = joo2.O000000o();
                        joo2.close();
                        for (String O00000o2 : O000000o2) {
                            O000000o(context, this.O00000Oo.O00000o(O00000o2), null, null);
                        }
                    }
                } catch (IOException unused) {
                }
                this.O00000Oo.O00000Oo(O00000Oo2.getAbsolutePath());
                this.f1994O000000o.add(str);
                O000000o("%s (%s) was re-linked!", str, str2);
            } catch (Throwable th) {
                th = th;
                joo = joo2;
                joo.close();
                throw th;
            }
        } else {
            O000000o("%s already loaded previously!", str);
        }
    }

    private File O00000Oo(Context context, String str, String str2) {
        String O00000o02 = this.O00000Oo.O00000o0(str);
        if (joi.O000000o(str2)) {
            return new File(context.getDir("lib", 0), O00000o02);
        }
        File dir = context.getDir("lib", 0);
        return new File(dir, O00000o02 + "." + str2);
    }

    public static void O000000o(String str, Object... objArr) {
        String.format(Locale.US, str, objArr);
    }
}
