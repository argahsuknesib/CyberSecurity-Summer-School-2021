package _m_j;

import java.io.IOException;
import java.util.TimerTask;
import javax.jmdns.impl.JmDNSImpl;

public abstract class ith extends TimerTask {

    /* renamed from: O000000o  reason: collision with root package name */
    public final JmDNSImpl f1625O000000o;

    public abstract String O000000o();

    protected ith(JmDNSImpl jmDNSImpl) {
        this.f1625O000000o = jmDNSImpl;
    }

    public String toString() {
        return O000000o();
    }

    public final isz O000000o(isz isz, ita ita) throws IOException {
        try {
            isz.O000000o(ita);
            return isz;
        } catch (IOException unused) {
            int i = isz.O00000oo;
            boolean z = isz.O00000oO;
            int i2 = isz.O00000o0;
            int O00000o0 = isz.O00000o0();
            isz.O00000oo = i | 512;
            isz.O00000o = O00000o0;
            this.f1625O000000o.O000000o(isz);
            isz isz2 = new isz(i, z, i2);
            isz2.O000000o(ita);
            return isz2;
        }
    }

    public final isz O000000o(isz isz, isw isw, itb itb) throws IOException {
        try {
            isz.O000000o(isw, itb);
            return isz;
        } catch (IOException unused) {
            int i = isz.O00000oo;
            boolean z = isz.O00000oO;
            int i2 = isz.O00000o0;
            int O00000o0 = isz.O00000o0();
            isz.O00000oo = i | 512;
            isz.O00000o = O00000o0;
            this.f1625O000000o.O000000o(isz);
            isz isz2 = new isz(i, z, i2);
            isz2.O000000o(isw, itb);
            return isz2;
        }
    }

    public final isz O000000o(isz isz, itb itb, long j) throws IOException {
        try {
            isz.O000000o(itb, j);
            return isz;
        } catch (IOException unused) {
            int i = isz.O00000oo;
            boolean z = isz.O00000oO;
            int i2 = isz.O00000o0;
            int O00000o0 = isz.O00000o0();
            isz.O00000oo = i | 512;
            isz.O00000o = O00000o0;
            this.f1625O000000o.O000000o(isz);
            isz isz2 = new isz(i, z, i2);
            isz2.O000000o(itb, j);
            return isz2;
        }
    }

    public final isz O000000o(isz isz, itb itb) throws IOException {
        try {
            isz.O000000o(itb);
            return isz;
        } catch (IOException unused) {
            int i = isz.O00000oo;
            boolean z = isz.O00000oO;
            int i2 = isz.O00000o0;
            int O00000o0 = isz.O00000o0();
            isz.O00000oo = i | 512;
            isz.O00000o = O00000o0;
            this.f1625O000000o.O000000o(isz);
            isz isz2 = new isz(i, z, i2);
            isz2.O000000o(itb);
            return isz2;
        }
    }
}
