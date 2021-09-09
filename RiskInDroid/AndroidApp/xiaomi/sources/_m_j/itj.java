package _m_j;

import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jmdns.impl.JmDNSImpl;

public class itj extends ith {
    public static Logger O00000Oo = Logger.getLogger(itj.class.getName());
    private final boolean O00000o;
    public final isw O00000o0;

    public itj(JmDNSImpl jmDNSImpl, isw isw, int i) {
        super(jmDNSImpl);
        this.O00000o0 = isw;
        this.O00000o = i != itg.f1624O000000o;
    }

    public final String O000000o() {
        String str;
        StringBuilder sb = new StringBuilder("Responder(");
        if (this.f1625O000000o != null) {
            str = this.f1625O000000o.O0000o0O;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(")");
        return sb.toString();
    }

    public String toString() {
        return super.toString() + " incomming: " + this.O00000o0;
    }

    /* JADX INFO: finally extract failed */
    public void run() {
        JmDNSImpl jmDNSImpl = this.f1625O000000o;
        isw isw = this.O00000o0;
        jmDNSImpl.O0000o00.lock();
        try {
            if (jmDNSImpl.O0000o0 == isw) {
                jmDNSImpl.O0000o0 = null;
            }
            jmDNSImpl.O0000o00.unlock();
            HashSet<ita> hashSet = new HashSet<>();
            HashSet<itb> hashSet2 = new HashSet<>();
            if (this.f1625O000000o.O0000OoO()) {
                try {
                    for (ita ita : this.O00000o0.O00000o()) {
                        if (O00000Oo.isLoggable(Level.FINER)) {
                            Logger logger = O00000Oo;
                            logger.finer(O000000o() + "run() JmDNS responding to: " + ita);
                        }
                        if (this.O00000o) {
                            hashSet.add(ita);
                        }
                        ita.O000000o(this.f1625O000000o, hashSet2);
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    for (itb itb : this.O00000o0.O0000O0o()) {
                        if (itb.O00000o0(currentTimeMillis)) {
                            hashSet2.remove(itb);
                            if (O00000Oo.isLoggable(Level.FINER)) {
                                Logger logger2 = O00000Oo;
                                logger2.finer(O000000o() + "JmDNS Responder Known Answer Removed");
                            }
                        }
                    }
                    if (!hashSet2.isEmpty()) {
                        if (O00000Oo.isLoggable(Level.FINER)) {
                            Logger logger3 = O00000Oo;
                            logger3.finer(O000000o() + "run() JmDNS responding");
                        }
                        isz isz = new isz(33792, !this.O00000o, this.O00000o0.O00000o0);
                        isz.O00000o = this.O00000o0.O00000o0();
                        for (ita ita2 : hashSet) {
                            if (ita2 != null) {
                                isz = O000000o(isz, ita2);
                            }
                        }
                        for (itb itb2 : hashSet2) {
                            if (itb2 != null) {
                                isz = O000000o(isz, this.O00000o0, itb2);
                            }
                        }
                        if (!isz.O0000o0O()) {
                            this.f1625O000000o.O000000o(isz);
                        }
                    }
                } catch (Throwable th) {
                    Logger logger4 = O00000Oo;
                    Level level = Level.WARNING;
                    logger4.log(level, O000000o() + "run() exception ", th);
                    this.f1625O000000o.close();
                }
            }
        } catch (Throwable th2) {
            jmDNSImpl.O0000o00.unlock();
            throw th2;
        }
    }
}
