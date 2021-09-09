package _m_j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jmdns.impl.JmDNSImpl;
import javax.jmdns.impl.ServiceInfoImpl;

public interface itc {
    void O000000o();

    void O000000o(isw isw, int i);

    void O000000o(String str);

    void O000000o(ServiceInfoImpl serviceInfoImpl);

    void O00000Oo();

    void O00000o();

    void O00000o0();

    void O00000oO();

    void O00000oo();

    void O0000O0o();

    void O0000OOo();

    void O0000Oo0();

    public static final class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        private static volatile O00000Oo f1620O000000o;
        private static final AtomicReference<O000000o> O00000o0 = new AtomicReference<>();
        private final ConcurrentMap<JmDNSImpl, itc> O00000Oo = new ConcurrentHashMap(20);

        public interface O000000o {
            itc O000000o();
        }

        private O00000Oo() {
        }

        public static O00000Oo O000000o() {
            if (f1620O000000o == null) {
                synchronized (O00000Oo.class) {
                    if (f1620O000000o == null) {
                        f1620O000000o = new O00000Oo();
                    }
                }
            }
            return f1620O000000o;
        }

        public final itc O000000o(JmDNSImpl jmDNSImpl) {
            itc itc = this.O00000Oo.get(jmDNSImpl);
            if (itc != null) {
                return itc;
            }
            ConcurrentMap<JmDNSImpl, itc> concurrentMap = this.O00000Oo;
            itc itc2 = null;
            O000000o o000000o = O00000o0.get();
            if (o000000o != null) {
                itc2 = o000000o.O000000o();
            }
            if (itc2 == null) {
                itc2 = new O000000o(jmDNSImpl);
            }
            concurrentMap.putIfAbsent(jmDNSImpl, itc2);
            return this.O00000Oo.get(jmDNSImpl);
        }
    }

    public static final class O000000o implements itc {

        /* renamed from: O000000o  reason: collision with root package name */
        private final JmDNSImpl f1618O000000o;
        private final Timer O00000Oo = new C0007O000000o("JmDNS(" + this.f1618O000000o.O0000o0O + ").Timer", true);
        private final Timer O00000o0 = new C0007O000000o("JmDNS(" + this.f1618O000000o.O0000o0O + ").State.Timer", false);

        /* renamed from: _m_j.itc$O000000o$O000000o  reason: collision with other inner class name */
        public static class C0007O000000o extends Timer {

            /* renamed from: O000000o  reason: collision with root package name */
            private volatile boolean f1619O000000o = false;

            public C0007O000000o() {
            }

            public C0007O000000o(String str, boolean z) {
                super(str, z);
            }

            public final synchronized void cancel() {
                if (!this.f1619O000000o) {
                    this.f1619O000000o = true;
                    super.cancel();
                }
            }

            public final synchronized void schedule(TimerTask timerTask, long j) {
                if (!this.f1619O000000o) {
                    super.schedule(timerTask, j);
                }
            }

            public final synchronized void schedule(TimerTask timerTask, Date date) {
                if (!this.f1619O000000o) {
                    super.schedule(timerTask, date);
                }
            }

            public final synchronized void schedule(TimerTask timerTask, long j, long j2) {
                if (!this.f1619O000000o) {
                    super.schedule(timerTask, j, j2);
                }
            }

            public final synchronized void schedule(TimerTask timerTask, Date date, long j) {
                if (!this.f1619O000000o) {
                    super.schedule(timerTask, date, j);
                }
            }

            public final synchronized void scheduleAtFixedRate(TimerTask timerTask, long j, long j2) {
                if (!this.f1619O000000o) {
                    super.scheduleAtFixedRate(timerTask, j, j2);
                }
            }

            public final synchronized void scheduleAtFixedRate(TimerTask timerTask, Date date, long j) {
                if (!this.f1619O000000o) {
                    super.scheduleAtFixedRate(timerTask, date, j);
                }
            }
        }

        public O000000o(JmDNSImpl jmDNSImpl) {
            this.f1618O000000o = jmDNSImpl;
        }

        public final void O000000o() {
            this.O00000Oo.purge();
        }

        public final void O00000Oo() {
            this.O00000o0.purge();
        }

        public final void O00000o0() {
            this.O00000Oo.cancel();
        }

        public final void O00000o() {
            this.O00000o0.cancel();
        }

        public final void O00000oO() {
            itq itq = new itq(this.f1618O000000o);
            Timer timer = this.O00000o0;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - itq.f1625O000000o.O0000OoO < 5000) {
                itq.f1625O000000o.O0000Oo++;
            } else {
                itq.f1625O000000o.O0000Oo = 1;
            }
            itq.f1625O000000o.O0000OoO = currentTimeMillis;
            if (itq.f1625O000000o.O0000Oo0.O00000o.isAnnounced() && itq.f1625O000000o.O0000Oo < 10) {
                timer.schedule(itq, (long) JmDNSImpl.O0000oOo().nextInt(251), 250);
            } else if (!itq.f1625O000000o.O0000Oo0.O00000o.isCanceling() && !itq.f1625O000000o.O0000Oo0.O00000o.isCanceled()) {
                timer.schedule(itq, 1000, 1000);
            }
        }

        public final void O00000oo() {
            itn itn = new itn(this.f1618O000000o);
            Timer timer = this.O00000o0;
            if (!itn.f1625O000000o.O0000Oo0.O00000o.isCanceling() && !itn.f1625O000000o.O0000Oo0.O00000o.isCanceled()) {
                timer.schedule(itn, 1000, 1000);
            }
        }

        public final void O0000O0o() {
            itr itr = new itr(this.f1618O000000o);
            Timer timer = this.O00000o0;
            if (!itr.f1625O000000o.O0000Oo0.O00000o.isCanceling() && !itr.f1625O000000o.O0000Oo0.O00000o.isCanceled()) {
                timer.schedule(itr, 1800000, 1800000);
            }
        }

        public final void O0000OOo() {
            this.O00000o0.schedule(new ito(this.f1618O000000o), 0, 1000);
        }

        public final void O0000Oo0() {
            iti iti = new iti(this.f1618O000000o);
            Timer timer = this.O00000Oo;
            if (!iti.f1625O000000o.O0000Oo0.O00000o.isCanceling() && !iti.f1625O000000o.O0000Oo0.O00000o.isCanceled()) {
                timer.schedule(iti, 10000, 10000);
            }
        }

        public final void O000000o(ServiceInfoImpl serviceInfoImpl) {
            new itl(this.f1618O000000o, serviceInfoImpl).O000000o(this.O00000Oo);
        }

        public final void O000000o(String str) {
            new itm(this.f1618O000000o, str).O000000o(this.O00000Oo);
        }

        public final void O000000o(isw isw, int i) {
            int i2;
            itj itj = new itj(this.f1618O000000o, isw, i);
            Timer timer = this.O00000Oo;
            boolean z = true;
            for (ita ita : itj.O00000o0.O00000o()) {
                if (itj.O00000Oo.isLoggable(Level.FINEST)) {
                    Logger logger = itj.O00000Oo;
                    logger.finest(itj.O000000o() + "start() question=" + ita);
                }
                z = ita.O000000o(itj.f1625O000000o);
                if (!z) {
                    break;
                }
            }
            int i3 = 0;
            if (!z || itj.O00000o0.O0000o00()) {
                i2 = (JmDNSImpl.O0000oOo().nextInt(96) + 20) - ((int) (System.currentTimeMillis() - itj.O00000o0.O00000Oo));
            } else {
                i2 = 0;
            }
            if (i2 >= 0) {
                i3 = i2;
            }
            if (itj.O00000Oo.isLoggable(Level.FINEST)) {
                Logger logger2 = itj.O00000Oo;
                logger2.finest(itj.O000000o() + "start() Responder chosen delay=" + i3);
            }
            if (!itj.f1625O000000o.O0000Oo0.O00000o.isCanceling() && !itj.f1625O000000o.O0000Oo0.O00000o.isCanceled()) {
                timer.schedule(itj, (long) i3);
            }
        }
    }
}
