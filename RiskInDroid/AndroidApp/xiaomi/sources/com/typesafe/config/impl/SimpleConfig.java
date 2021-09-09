package com.typesafe.config.impl;

import _m_j.dry;
import _m_j.dsg;
import _m_j.dsh;
import _m_j.dsm;
import _m_j.dsn;
import _m_j.dso;
import _m_j.dsy;
import _m_j.dtf;
import java.io.ObjectStreamException;
import java.io.Serializable;

public final class SimpleConfig implements dry, dsy, Serializable {

    /* renamed from: O000000o  reason: collision with root package name */
    static final /* synthetic */ boolean f5923O000000o = (!SimpleConfig.class.desiredAssertionStatus());
    private static final long serialVersionUID = 1;
    private final dso object;

    public SimpleConfig(dso dso) {
        this.object = dso;
    }

    private SimpleConfig O000000o(dry dry, dsm dsm) {
        AbstractConfigValue O000000o2 = dtf.O000000o(this.object, ((SimpleConfig) dry).object, dsm);
        if (O000000o2 == this.object) {
            return this;
        }
        return new SimpleConfig((dso) O000000o2);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof SimpleConfig) {
            return this.object.equals(((SimpleConfig) obj).object);
        }
        return false;
    }

    public final int hashCode() {
        return this.object.hashCode() * 41;
    }

    public final String toString() {
        return "Config(" + this.object.toString() + ")";
    }

    private Object writeReplace() throws ObjectStreamException {
        return new SerializedConfigValue(this);
    }

    public final /* bridge */ /* synthetic */ dry O000000o(dsm dsm) {
        return O000000o(this, dsm);
    }

    public final /* synthetic */ dry O00000Oo() {
        return O000000o(this, new dsm());
    }

    public final /* synthetic */ dry O000000o(dsg dsg) {
        return this.object.O00000o0(dsg).config;
    }

    public final /* bridge */ /* synthetic */ dsh O000000o() {
        return this.object;
    }

    public final /* bridge */ /* synthetic */ dsn O00000oo() {
        return this.object;
    }
}
