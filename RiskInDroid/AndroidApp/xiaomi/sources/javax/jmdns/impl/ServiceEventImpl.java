package javax.jmdns.impl;

import _m_j.isq;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;

public class ServiceEventImpl extends ServiceEvent {
    private static final long serialVersionUID = 7107973622016897488L;
    private final ServiceInfo _info;
    private final String _name;
    private final String _type;

    public ServiceEventImpl(JmDNSImpl jmDNSImpl, String str, String str2, ServiceInfo serviceInfo) {
        super(jmDNSImpl);
        this._type = str;
        this._name = str2;
        this._info = serviceInfo;
    }

    public final isq O000000o() {
        return (isq) getSource();
    }

    public final String O00000Oo() {
        return this._type;
    }

    public final String O00000o0() {
        return this._name;
    }

    public String toString() {
        return "[" + getClass().getSimpleName() + "@" + System.identityHashCode(this) + " \n\tname: '" + this._name + "' type: '" + this._type + "' info: '" + this._info + "']";
    }

    public final ServiceInfo O00000o() {
        return this._info;
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000oo */
    public ServiceEventImpl clone() {
        return new ServiceEventImpl((JmDNSImpl) ((isq) getSource()), this._type, this._name, new ServiceInfoImpl(this._info));
    }
}
