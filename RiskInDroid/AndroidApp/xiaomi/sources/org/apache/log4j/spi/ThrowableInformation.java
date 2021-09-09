package org.apache.log4j.spi;

import _m_j.jdy;
import _m_j.jeb;
import _m_j.jfb;
import _m_j.jfi;
import _m_j.jfj;
import java.io.Serializable;

public class ThrowableInformation implements Serializable {
    static final long serialVersionUID = -4748765566864322735L;

    /* renamed from: O000000o  reason: collision with root package name */
    private transient Throwable f15438O000000o;
    private transient jdy O00000Oo;
    private String[] rep;

    public ThrowableInformation(Throwable th, jdy jdy) {
        this.f15438O000000o = th;
        this.O00000Oo = jdy;
    }

    public final synchronized String[] O000000o() {
        if (this.rep == null) {
            jfi jfi = null;
            if (this.O00000Oo != null) {
                jfb O00000o = this.O00000Oo.O00000o();
                if (O00000o instanceof jfj) {
                    jfi = ((jfj) O00000o).O00000oo();
                }
            }
            if (jfi == null) {
                this.rep = jeb.O00000Oo(this.f15438O000000o);
            } else {
                this.rep = jfi.O000000o(this.f15438O000000o);
            }
        }
        return (String[]) this.rep.clone();
    }
}
