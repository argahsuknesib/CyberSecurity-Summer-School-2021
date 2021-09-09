package javax.jmdns;

import _m_j.isq;
import java.net.InetAddress;
import java.util.EventObject;

public abstract class ServiceEvent extends EventObject implements Cloneable {
    private static final long serialVersionUID = -8558445644541006271L;
    public InetAddress _source;

    public abstract isq O000000o();

    public abstract String O00000Oo();

    public abstract ServiceInfo O00000o();

    public abstract String O00000o0();

    public ServiceEvent(Object obj) {
        super(obj);
    }

    /* renamed from: O00000oO */
    public ServiceEvent clone() {
        try {
            return (ServiceEvent) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
