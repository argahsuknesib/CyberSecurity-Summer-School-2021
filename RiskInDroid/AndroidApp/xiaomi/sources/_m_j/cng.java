package _m_j;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.regex.Pattern;

public final class cng implements Closeable {

    /* renamed from: O000000o  reason: collision with root package name */
    static final Pattern f14139O000000o = Pattern.compile("[a-z0-9_-]{1,64}");
    public static final OutputStream O0000Ooo = new OutputStream() {
        /* class _m_j.cng.AnonymousClass1 */

        public final void write(int i) throws IOException {
        }
    };
    public final File O00000Oo;
    public final File O00000o;
    public final File O00000o0;
    public final File O00000oO;
    public final int O00000oo;
    public final int O0000O0o;
    public Writer O0000OOo;
    public int O0000Oo;
    public final LinkedHashMap<String, O00000Oo> O0000Oo0;
    final ThreadPoolExecutor O0000OoO;
    private long O0000o0;
    private long O0000o00;
    private final Callable<Void> O0000o0O;

    public final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final O00000Oo f14140O000000o;
        final /* synthetic */ cng O00000Oo;
    }

    private static void O000000o(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void O000000o(File file, File file2, boolean z) throws IOException {
        if (z) {
            O000000o(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private void O000000o(O000000o o000000o) throws IOException {
        O00000Oo o00000Oo = o000000o.f14140O000000o;
        if (o00000Oo.O00000o == o000000o) {
            for (int i = 0; i < this.O0000O0o; i++) {
                O000000o(new File(o00000Oo.O00000oO.O00000Oo, o00000Oo.f14141O000000o + "." + i + ".tmp"));
            }
            this.O0000Oo++;
            o00000Oo.O00000o = null;
            if (false || o00000Oo.O00000o0) {
                o00000Oo.O00000o0 = true;
                this.O0000OOo.write("CLEAN " + o00000Oo.f14141O000000o + o00000Oo.O000000o() + 10);
            } else {
                this.O0000Oo0.remove(o00000Oo.f14141O000000o);
                this.O0000OOo.write("REMOVE " + o00000Oo.f14141O000000o + 10);
            }
            this.O0000OOo.flush();
            if (this.O0000o0 > this.O0000o00 || O000000o()) {
                this.O0000OoO.submit(this.O0000o0O);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public final boolean O000000o() {
        int i = this.O0000Oo;
        return i >= 2000 && i >= this.O0000Oo0.size();
    }

    public final synchronized void close() throws IOException {
        if (this.O0000OOo != null) {
            Iterator it = new ArrayList(this.O0000Oo0.values()).iterator();
            while (it.hasNext()) {
                O00000Oo o00000Oo = (O00000Oo) it.next();
                if (o00000Oo.O00000o != null) {
                    O000000o o000000o = o00000Oo.O00000o;
                    o000000o.O00000Oo.O000000o(o000000o);
                }
            }
            O00000Oo();
            this.O0000OOo.close();
            this.O0000OOo = null;
        }
    }

    public final void O00000Oo() throws IOException {
        while (this.O0000o0 > this.O0000o00) {
            String str = (String) this.O0000Oo0.entrySet().iterator().next().getKey();
            if (this.O0000OOo == null) {
                throw new IllegalStateException("cache is closed");
            } else if (f14139O000000o.matcher(str).matches()) {
                O00000Oo o00000Oo = this.O0000Oo0.get(str);
                if (o00000Oo != null && o00000Oo.O00000o == null) {
                    int i = 0;
                    while (i < this.O0000O0o) {
                        File file = new File(o00000Oo.O00000oO.O00000Oo, o00000Oo.f14141O000000o + "." + i);
                        if (!file.exists() || file.delete()) {
                            this.O0000o0 -= o00000Oo.O00000Oo[i];
                            o00000Oo.O00000Oo[i] = 0;
                            i++;
                        } else {
                            throw new IOException("failed to delete ".concat(String.valueOf(file)));
                        }
                    }
                    this.O0000Oo++;
                    this.O0000OOo.append((CharSequence) ("REMOVE " + str + 10));
                    this.O0000Oo0.remove(str);
                    if (O000000o()) {
                        this.O0000OoO.submit(this.O0000o0O);
                    }
                }
            } else {
                throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + jdn.f1779O000000o);
            }
        }
    }

    public final class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public final String f14141O000000o;
        public final long[] O00000Oo;
        public O000000o O00000o;
        public boolean O00000o0;
        final /* synthetic */ cng O00000oO;

        public final String O000000o() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long append : this.O00000Oo) {
                sb.append(' ');
                sb.append(append);
            }
            return sb.toString();
        }
    }
}
