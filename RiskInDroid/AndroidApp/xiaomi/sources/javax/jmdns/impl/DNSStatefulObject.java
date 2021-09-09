package javax.jmdns.impl;

import _m_j.ith;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jmdns.impl.constants.DNSState;

public interface DNSStatefulObject {
    boolean advanceState(ith ith);

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private static Logger f15359O000000o = Logger.getLogger(O000000o.class.getName());
        private final String O00000Oo;
        private final ConcurrentMap<Thread, Semaphore> O00000o0 = new ConcurrentHashMap(50);

        public O000000o(String str) {
            this.O00000Oo = str;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
         arg types: [java.util.logging.Level, java.lang.String, java.lang.InterruptedException]
         candidates:
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
        public final void O000000o(long j) {
            Thread currentThread = Thread.currentThread();
            if (this.O00000o0.get(currentThread) == null) {
                Semaphore semaphore = new Semaphore(1, true);
                semaphore.drainPermits();
                this.O00000o0.putIfAbsent(currentThread, semaphore);
            }
            try {
                this.O00000o0.get(currentThread).tryAcquire(j, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                f15359O000000o.log(Level.FINER, "Exception ", (Throwable) e);
            }
        }

        public final void O000000o() {
            Collection<Semaphore> values = this.O00000o0.values();
            for (Semaphore next : values) {
                next.release();
                values.remove(next);
            }
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(1000);
            sb.append("Semaphore: ");
            sb.append(this.O00000Oo);
            if (this.O00000o0.size() == 0) {
                sb.append(" no semaphores.");
            } else {
                sb.append(" semaphores:\n");
                for (Thread next : this.O00000o0.keySet()) {
                    sb.append("\tThread: ");
                    sb.append(next.getName());
                    sb.append(' ');
                    sb.append(this.O00000o0.get(next));
                    sb.append(10);
                }
            }
            return sb.toString();
        }
    }

    public static class DefaultImplementation extends ReentrantLock implements DNSStatefulObject {
        private static Logger logger = Logger.getLogger(DefaultImplementation.class.getName());
        private static final long serialVersionUID = -3264781576883412227L;
        private final O000000o _announcing = new O000000o("Announce");
        private final O000000o _canceling = new O000000o("Cancel");
        private volatile JmDNSImpl _dns = null;
        protected volatile DNSState _state = DNSState.PROBING_1;
        protected volatile ith _task = null;

        public JmDNSImpl getDns() {
            return this._dns;
        }

        /* access modifiers changed from: protected */
        public void setDns(JmDNSImpl jmDNSImpl) {
            this._dns = jmDNSImpl;
        }

        public void associateWithTask(ith ith, DNSState dNSState) {
            if (this._task == null && this._state == dNSState) {
                lock();
                try {
                    if (this._task == null && this._state == dNSState) {
                        setTask(ith);
                    }
                } finally {
                    unlock();
                }
            }
        }

        public void removeAssociationWithTask(ith ith) {
            if (this._task == ith) {
                lock();
                try {
                    if (this._task == ith) {
                        setTask(null);
                    }
                } finally {
                    unlock();
                }
            }
        }

        public boolean isAssociatedWithTask(ith ith, DNSState dNSState) {
            lock();
            try {
                return this._task == ith && this._state == dNSState;
            } finally {
                unlock();
            }
        }

        /* access modifiers changed from: protected */
        public void setTask(ith ith) {
            this._task = ith;
        }

        /* access modifiers changed from: protected */
        public void setState(DNSState dNSState) {
            lock();
            try {
                this._state = dNSState;
                if (isAnnounced()) {
                    this._announcing.O000000o();
                }
                if (isCanceled()) {
                    this._canceling.O000000o();
                    this._announcing.O000000o();
                }
            } finally {
                unlock();
            }
        }

        public boolean advanceState(ith ith) {
            if (this._task != ith) {
                return true;
            }
            lock();
            try {
                if (this._task == ith) {
                    setState(this._state.advance());
                } else {
                    Logger logger2 = logger;
                    logger2.warning("Trying to advance state whhen not the owner. owner: " + this._task + " perpetrator: " + ith);
                }
                return true;
            } finally {
                unlock();
            }
        }

        public boolean revertState() {
            if (willCancel()) {
                return true;
            }
            lock();
            try {
                if (!willCancel()) {
                    setState(this._state.revert());
                    setTask(null);
                }
                return true;
            } finally {
                unlock();
            }
        }

        public boolean cancelState() {
            boolean z = false;
            if (!willCancel()) {
                lock();
                try {
                    if (!willCancel()) {
                        setState(DNSState.CANCELING_1);
                        setTask(null);
                        z = true;
                    }
                } finally {
                    unlock();
                }
            }
            return z;
        }

        public boolean closeState() {
            boolean z = false;
            if (!willClose()) {
                lock();
                try {
                    if (!willClose()) {
                        setState(DNSState.CLOSING);
                        setTask(null);
                        z = true;
                    }
                } finally {
                    unlock();
                }
            }
            return z;
        }

        /* JADX INFO: finally extract failed */
        public boolean recoverState() {
            lock();
            try {
                setState(DNSState.PROBING_1);
                setTask(null);
                unlock();
                return false;
            } catch (Throwable th) {
                unlock();
                throw th;
            }
        }

        public boolean isProbing() {
            return this._state.isProbing();
        }

        public boolean isAnnouncing() {
            return this._state.isAnnouncing();
        }

        public boolean isAnnounced() {
            return this._state.isAnnounced();
        }

        public boolean isCanceling() {
            return this._state.isCanceling();
        }

        public boolean isCanceled() {
            return this._state.isCanceled();
        }

        public boolean isClosing() {
            return this._state.isClosing();
        }

        public boolean isClosed() {
            return this._state.isClosed();
        }

        private boolean willCancel() {
            return this._state.isCanceled() || this._state.isCanceling();
        }

        private boolean willClose() {
            return this._state.isClosed() || this._state.isClosing();
        }

        public boolean waitForAnnounced(long j) {
            if (!isAnnounced() && !willCancel()) {
                this._announcing.O000000o(j);
            }
            if (!isAnnounced()) {
                if (willCancel() || willClose()) {
                    logger.fine("Wait for announced cancelled: ".concat(String.valueOf(this)));
                } else {
                    logger.warning("Wait for announced timed out: ".concat(String.valueOf(this)));
                }
            }
            return isAnnounced();
        }

        public boolean waitForCanceled(long j) {
            if (!isCanceled()) {
                this._canceling.O000000o(j);
            }
            if (!isCanceled() && !willClose()) {
                logger.warning("Wait for canceled timed out: ".concat(String.valueOf(this)));
            }
            return isCanceled();
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            if (this._dns != null) {
                str = "DNS: " + this._dns.O0000o0O;
            } else {
                str = "NO DNS";
            }
            sb.append(str);
            sb.append(" state: ");
            sb.append(this._state);
            sb.append(" task: ");
            sb.append(this._task);
            return sb.toString();
        }
    }
}
