package org.slf4j.helpers;

import _m_j.jmx;
import _m_j.jmy;
import java.io.ObjectStreamException;
import java.io.Serializable;

public abstract class NamedLoggerBase implements jmx, Serializable {
    private static final long serialVersionUID = 7535258609338176893L;
    protected String name;

    NamedLoggerBase() {
    }

    public String O00000oo() {
        return this.name;
    }

    /* access modifiers changed from: protected */
    public Object readResolve() throws ObjectStreamException {
        return jmy.O000000o(O00000oo());
    }
}
