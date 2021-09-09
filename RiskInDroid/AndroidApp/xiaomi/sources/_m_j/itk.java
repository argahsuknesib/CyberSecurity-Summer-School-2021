package _m_j;

import java.io.IOException;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jmdns.impl.JmDNSImpl;

public abstract class itk extends ith {
    private static Logger O00000o0 = Logger.getLogger(itk.class.getName());
    protected int O00000Oo = 0;

    /* access modifiers changed from: protected */
    public abstract isz O000000o(isz isz) throws IOException;

    /* access modifiers changed from: protected */
    public abstract isz O00000Oo(isz isz) throws IOException;

    /* access modifiers changed from: protected */
    public abstract String O00000Oo();

    public itk(JmDNSImpl jmDNSImpl) {
        super(jmDNSImpl);
    }

    public String toString() {
        return super.toString() + " count: " + this.O00000Oo;
    }

    public final void O000000o(Timer timer) {
        if (!this.f1625O000000o.O0000Ooo() && !this.f1625O000000o.O0000o00()) {
            timer.schedule(this, 225, 225);
        }
    }

    public void run() {
        try {
            if (!this.f1625O000000o.O0000Ooo()) {
                if (!this.f1625O000000o.O0000o00()) {
                    int i = this.O00000Oo;
                    this.O00000Oo = i + 1;
                    if (i < 3) {
                        if (O00000o0.isLoggable(Level.FINER)) {
                            Logger logger = O00000o0;
                            logger.finer(O000000o() + ".run() JmDNS " + O00000Oo());
                        }
                        isz O000000o2 = O000000o(new isz(0));
                        if (this.f1625O000000o.O0000OoO()) {
                            O000000o2 = O00000Oo(O000000o2);
                        }
                        if (!O000000o2.O0000o0O()) {
                            this.f1625O000000o.O000000o(O000000o2);
                            return;
                        }
                        return;
                    }
                    cancel();
                    return;
                }
            }
            cancel();
        } catch (Throwable th) {
            Logger logger2 = O00000o0;
            Level level = Level.WARNING;
            logger2.log(level, O000000o() + ".run() exception ", th);
            this.f1625O000000o.O0000oO0();
        }
    }
}
