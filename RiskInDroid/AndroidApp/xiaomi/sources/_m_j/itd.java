package _m_j;

import java.util.EventListener;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;

public class itd<T extends EventListener> {

    /* renamed from: O000000o  reason: collision with root package name */
    final T f1621O000000o;
    public final boolean O00000Oo;

    public static class O000000o extends itd<iss> {
        private static Logger O00000o0 = Logger.getLogger(O000000o.class.getName());
        private final ConcurrentMap<String, ServiceInfo> O00000o = new ConcurrentHashMap(32);

        public O000000o(iss iss, boolean z) {
            super(iss, z);
        }

        public final void O000000o(ServiceEvent serviceEvent) {
            if (this.O00000o.putIfAbsent(serviceEvent.O00000o0() + "." + serviceEvent.O00000Oo(), serviceEvent.O00000o().clone()) == null) {
                ((iss) this.f1621O000000o).O000000o(serviceEvent);
                ServiceInfo O00000o2 = serviceEvent.O00000o();
                if (O00000o2 != null && O00000o2.O000000o()) {
                    ((iss) this.f1621O000000o).O00000o0(serviceEvent);
                    return;
                }
                return;
            }
            O00000o0.finer("Service Added called for a service already added: ".concat(String.valueOf(serviceEvent)));
        }

        public final void O00000Oo(ServiceEvent serviceEvent) {
            String str = serviceEvent.O00000o0() + "." + serviceEvent.O00000Oo();
            ConcurrentMap<String, ServiceInfo> concurrentMap = this.O00000o;
            if (concurrentMap.remove(str, concurrentMap.get(str))) {
                ((iss) this.f1621O000000o).O00000Oo(serviceEvent);
            } else {
                O00000o0.finer("Service Removed called for a service already removed: ".concat(String.valueOf(serviceEvent)));
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0073, code lost:
            return;
         */
        public final synchronized void O00000o0(ServiceEvent serviceEvent) {
            ServiceInfo O00000o2 = serviceEvent.O00000o();
            if (O00000o2 == null || !O00000o2.O000000o()) {
                O00000o0.warning("Service Resolved called for an unresolved event: ".concat(String.valueOf(serviceEvent)));
                return;
            }
            String str = serviceEvent.O00000o0() + "." + serviceEvent.O00000Oo();
            ServiceInfo serviceInfo = this.O00000o.get(str);
            if (O000000o(O00000o2, serviceInfo)) {
                O00000o0.finer("Service Resolved called for a service already resolved: ".concat(String.valueOf(serviceEvent)));
            } else if (serviceInfo == null) {
                if (this.O00000o.putIfAbsent(str, O00000o2.clone()) == null) {
                    ((iss) this.f1621O000000o).O00000o0(serviceEvent);
                }
            } else if (this.O00000o.replace(str, serviceInfo, O00000o2.clone())) {
                ((iss) this.f1621O000000o).O00000o0(serviceEvent);
            }
        }

        private static boolean O000000o(ServiceInfo serviceInfo, ServiceInfo serviceInfo2) {
            if (serviceInfo == null || serviceInfo2 == null || !serviceInfo.equals(serviceInfo2)) {
                return false;
            }
            byte[] O0000Ooo = serviceInfo.O0000Ooo();
            byte[] O0000Ooo2 = serviceInfo2.O0000Ooo();
            if (O0000Ooo.length != O0000Ooo2.length) {
                return false;
            }
            for (int i = 0; i < O0000Ooo.length; i++) {
                if (O0000Ooo[i] != O0000Ooo2[i]) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(2048);
            sb.append("[Status for ");
            sb.append(((iss) this.f1621O000000o).toString());
            if (this.O00000o.isEmpty()) {
                sb.append(" no type event ");
            } else {
                sb.append(" (");
                for (String append : this.O00000o.keySet()) {
                    sb.append(append);
                    sb.append(", ");
                }
                sb.append(") ");
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static class O00000Oo extends itd<ist> {
        public static Logger O00000o0 = Logger.getLogger(O00000Oo.class.getName());
        public final ConcurrentMap<String, String> O00000o;

        public String toString() {
            StringBuilder sb = new StringBuilder(2048);
            sb.append("[Status for ");
            sb.append(((ist) this.f1621O000000o).toString());
            if (this.O00000o.isEmpty()) {
                sb.append(" no type event ");
            } else {
                sb.append(" (");
                for (String append : this.O00000o.keySet()) {
                    sb.append(append);
                    sb.append(", ");
                }
                sb.append(") ");
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public itd(T t, boolean z) {
        this.f1621O000000o = t;
        this.O00000Oo = z;
    }

    public boolean equals(Object obj) {
        return (obj instanceof itd) && this.f1621O000000o.equals(((itd) obj).f1621O000000o);
    }

    public String toString() {
        return "[Status for " + this.f1621O000000o.toString() + "]";
    }

    public int hashCode() {
        return this.f1621O000000o.hashCode();
    }
}
