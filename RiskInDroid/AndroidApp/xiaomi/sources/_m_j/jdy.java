package _m_j;

import com.google.android.exoplayer2.C;
import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.Vector;
import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;

public class jdy {
    static Class O0000OOo;
    private static final String O0000Oo0;

    /* renamed from: O000000o  reason: collision with root package name */
    protected String f1781O000000o;
    protected volatile Level O00000Oo;
    protected ResourceBundle O00000o;
    protected volatile jdy O00000o0;
    protected jfb O00000oO;
    jen O00000oo;
    protected boolean O0000O0o = true;

    static {
        Class cls = O0000OOo;
        if (cls == null) {
            cls = O000000o("_m_j.jdy");
            O0000OOo = cls;
        }
        O0000Oo0 = cls.getName();
    }

    private static Class O000000o(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    protected jdy(String str) {
        this.f1781O000000o = str;
    }

    public synchronized void O000000o(jdx jdx) {
        if (this.O00000oo == null) {
            this.O00000oo = new jen();
        }
        this.O00000oo.O000000o(jdx);
        this.O00000oO.O000000o();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001e, code lost:
        if (r0 != 0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0020, code lost:
        r2.O00000oO.O000000o(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    public void O000000o(LoggingEvent loggingEvent) {
        int i = 0;
        jdy jdy = this;
        while (true) {
            if (jdy == null) {
                break;
            }
            synchronized (jdy) {
                if (jdy.O00000oo != null) {
                    i += jdy.O00000oo.O000000o();
                }
                if (!jdy.O0000O0o) {
                }
            }
            jdy = jdy.O00000o0;
        }
        while (true) {
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void O000000o() {
        Enumeration O00000Oo2 = O00000Oo();
        if (O00000Oo2 != null) {
            while (O00000Oo2.hasMoreElements()) {
                O00000Oo2.nextElement();
            }
        }
    }

    public synchronized Enumeration O00000Oo() {
        if (this.O00000oo == null) {
            return jeq.O000000o();
        }
        return this.O00000oo.O00000Oo();
    }

    public Level O00000o0() {
        for (jdy jdy = this; jdy != null; jdy = jdy.O00000o0) {
            if (jdy.O00000Oo != null) {
                return jdy.O00000Oo;
            }
        }
        return null;
    }

    public final jfb O00000o() {
        return this.O00000oO;
    }

    public final String O00000oO() {
        return this.f1781O000000o;
    }

    public final Level O00000oo() {
        return this.O00000Oo;
    }

    public boolean O0000O0o() {
        if (this.O00000oO.O000000o((int) C.MSG_CUSTOM_BASE)) {
            return false;
        }
        return Level.O00000oo.O000000o(O00000o0());
    }

    public boolean O000000o(jej jej) {
        if (this.O00000oO.O000000o(jej.O0000Oo)) {
            return false;
        }
        return jej.O000000o(O00000o0());
    }

    public boolean O0000OOo() {
        if (this.O00000oO.O000000o(20000)) {
            return false;
        }
        return Level.O00000oO.O000000o(O00000o0());
    }

    public void O000000o(String str, jej jej, Object obj, Throwable th) {
        if (!this.O00000oO.O000000o(jej.O0000Oo) && jej.O000000o(O00000o0())) {
            O000000o(new LoggingEvent(str, this, jej, obj, th));
        }
    }

    private void O00000Oo(jdx jdx) {
        if (jdx != null) {
            jfb jfb = this.O00000oO;
            if (jfb instanceof jec) {
                jec jec = (jec) jfb;
                if (jec.f1784O000000o != null) {
                    int size = jec.f1784O000000o.size();
                    for (int i = 0; i < size; i++) {
                        jec.f1784O000000o.elementAt(i);
                    }
                }
            }
        }
    }

    public synchronized void O0000Oo0() {
        if (this.O00000oo != null) {
            Vector vector = new Vector();
            Enumeration O00000Oo2 = this.O00000oo.O00000Oo();
            while (O00000Oo2 != null && O00000Oo2.hasMoreElements()) {
                vector.add(O00000Oo2.nextElement());
            }
            this.O00000oo.O00000o0();
            Enumeration elements = vector.elements();
            while (elements.hasMoreElements()) {
                O00000Oo((jdx) elements.nextElement());
            }
            this.O00000oo = null;
        }
    }

    public final void O000000o(boolean z) {
        this.O0000O0o = z;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(jfb jfb) {
        this.O00000oO = jfb;
    }

    public void O000000o(Level level) {
        this.O00000Oo = level;
    }

    public void O0000Oo() {
        this.O00000o = null;
    }
}
