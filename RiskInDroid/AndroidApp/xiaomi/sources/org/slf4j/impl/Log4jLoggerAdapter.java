package org.slf4j.impl;

import _m_j.jef;
import _m_j.jej;
import _m_j.jne;
import java.io.Serializable;
import org.apache.log4j.Level;
import org.slf4j.helpers.MarkerIgnoringBase;

public final class Log4jLoggerAdapter extends MarkerIgnoringBase implements jne, Serializable {
    static final String O00000Oo = "org.slf4j.impl.Log4jLoggerAdapter";
    private static final long serialVersionUID = 6182834493563598289L;

    /* renamed from: O000000o  reason: collision with root package name */
    final transient jef f15481O000000o;
    final boolean traceCapable = O0000O0o();

    public Log4jLoggerAdapter(jef jef) {
        this.f15481O000000o = jef;
        this.name = jef.O00000oO();
    }

    private boolean O0000O0o() {
        try {
            this.f15481O000000o.O0000OoO();
            return true;
        } catch (NoSuchMethodError unused) {
            return false;
        }
    }

    public final boolean O000000o() {
        if (this.traceCapable) {
            return this.f15481O000000o.O0000OoO();
        }
        return this.f15481O000000o.O0000O0o();
    }

    public final void O000000o(String str) {
        this.f15481O000000o.O000000o(O00000Oo, this.traceCapable ? Level.O0000O0o : Level.O00000oo, str, null);
    }

    public final void O000000o(String str, Throwable th) {
        this.f15481O000000o.O000000o(O00000Oo, this.traceCapable ? Level.O0000O0o : Level.O00000oo, str, th);
    }

    public final boolean O00000Oo() {
        return this.f15481O000000o.O0000O0o();
    }

    public final void O00000Oo(String str) {
        this.f15481O000000o.O000000o(O00000Oo, Level.O00000oo, str, null);
    }

    public final void O00000Oo(String str, Throwable th) {
        this.f15481O000000o.O000000o(O00000Oo, Level.O00000oo, str, th);
    }

    public final boolean O00000o0() {
        return this.f15481O000000o.O0000OOo();
    }

    public final void O00000o0(String str) {
        this.f15481O000000o.O000000o(O00000Oo, Level.O00000oO, str, null);
    }

    public final void O00000o0(String str, Throwable th) {
        this.f15481O000000o.O000000o(O00000Oo, Level.O00000oO, str, th);
    }

    public final boolean O00000o() {
        return this.f15481O000000o.O000000o((jej) Level.O00000o);
    }

    public final void O00000o(String str) {
        this.f15481O000000o.O000000o(O00000Oo, Level.O00000o, str, null);
    }

    public final void O00000o(String str, Throwable th) {
        this.f15481O000000o.O000000o(O00000Oo, Level.O00000o, str, th);
    }

    public final boolean O00000oO() {
        return this.f15481O000000o.O000000o((jej) Level.O00000o0);
    }

    public final void O00000oO(String str) {
        this.f15481O000000o.O000000o(O00000Oo, Level.O00000o0, str, null);
    }

    public final void O00000oO(String str, Throwable th) {
        this.f15481O000000o.O000000o(O00000Oo, Level.O00000o0, str, th);
    }
}
