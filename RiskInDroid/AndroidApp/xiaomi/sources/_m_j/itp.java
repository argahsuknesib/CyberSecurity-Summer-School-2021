package _m_j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jmdns.ServiceInfo;
import javax.jmdns.impl.DNSStatefulObject;
import javax.jmdns.impl.JmDNSImpl;
import javax.jmdns.impl.ServiceInfoImpl;
import javax.jmdns.impl.constants.DNSState;

public abstract class itp extends ith {
    static Logger O00000o0 = Logger.getLogger(itp.class.getName());
    static int O00000oO = 3600;
    final int O00000o;
    DNSState O00000oo = null;

    /* access modifiers changed from: protected */
    public abstract isz O000000o(isz isz) throws IOException;

    /* access modifiers changed from: protected */
    public abstract isz O000000o(ServiceInfoImpl serviceInfoImpl, isz isz) throws IOException;

    public abstract String O00000Oo();

    /* access modifiers changed from: protected */
    public abstract isz O00000o();

    /* access modifiers changed from: protected */
    public abstract boolean O00000o0();

    /* access modifiers changed from: protected */
    public abstract void O00000oO();

    /* access modifiers changed from: protected */
    public abstract void O00000oo();

    public itp(JmDNSImpl jmDNSImpl, int i) {
        super(jmDNSImpl);
        this.O00000o = i;
    }

    public void run() {
        isz O00000o2 = O00000o();
        try {
            if (!O00000o0()) {
                cancel();
                return;
            }
            ArrayList arrayList = new ArrayList();
            synchronized (this.f1625O000000o) {
                JmDNSImpl jmDNSImpl = this.f1625O000000o;
                if (jmDNSImpl.O0000Oo0.O00000o.isAssociatedWithTask(this, this.O00000oo)) {
                    Logger logger = O00000o0;
                    logger.finer(O000000o() + ".run() JmDNS " + O00000Oo() + " " + this.f1625O000000o.O0000o0O);
                    arrayList.add(this.f1625O000000o);
                    O00000o2 = O000000o(O00000o2);
                }
            }
            Iterator<ServiceInfo> it = this.f1625O000000o.O00000oo.values().iterator();
            while (it.hasNext()) {
                ServiceInfoImpl serviceInfoImpl = (ServiceInfoImpl) it.next();
                synchronized (serviceInfoImpl) {
                    if (serviceInfoImpl.O0000OOo.isAssociatedWithTask(this, this.O00000oo)) {
                        Logger logger2 = O00000o0;
                        logger2.fine(O000000o() + ".run() JmDNS " + O00000Oo() + " " + serviceInfoImpl.O00000o());
                        arrayList.add(serviceInfoImpl);
                        O00000o2 = O000000o(serviceInfoImpl, O00000o2);
                    }
                }
            }
            if (!O00000o2.O0000o0O()) {
                Logger logger3 = O00000o0;
                logger3.finer(O000000o() + ".run() JmDNS " + O00000Oo() + " #" + this.O00000oo);
                this.f1625O000000o.O000000o(O00000o2);
                O000000o(arrayList);
                O00000oo();
                return;
            }
            O000000o(arrayList);
            cancel();
        } catch (Throwable th) {
            Logger logger4 = O00000o0;
            Level level = Level.WARNING;
            logger4.log(level, O000000o() + ".run() exception ", th);
            O00000oO();
        }
    }

    private void O000000o(List<DNSStatefulObject> list) {
        for (DNSStatefulObject next : list) {
            synchronized (next) {
                next.advanceState(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o(DNSState dNSState) {
        synchronized (this.f1625O000000o) {
            this.f1625O000000o.O000000o(this, dNSState);
        }
        Iterator<ServiceInfo> it = this.f1625O000000o.O00000oo.values().iterator();
        while (it.hasNext()) {
            ((ServiceInfoImpl) it.next()).O000000o(this, dNSState);
        }
    }

    /* access modifiers changed from: protected */
    public final void O0000O0o() {
        synchronized (this.f1625O000000o) {
            this.f1625O000000o.O000000o(this);
        }
        Iterator<ServiceInfo> it = this.f1625O000000o.O00000oo.values().iterator();
        while (it.hasNext()) {
            ((ServiceInfoImpl) it.next()).O000000o(this);
        }
    }
}
