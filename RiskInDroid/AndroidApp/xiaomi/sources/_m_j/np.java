package _m_j;

import com.adobe.xmp.XMPException;
import java.util.Map;

public abstract class np {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f2207O000000o = 0;
    private Map O00000Oo = null;

    public np() {
    }

    public np(int i) throws XMPException {
        O00000o(i);
        O00000Oo(i);
    }

    private void O00000o(int i) throws XMPException {
        int O00000oO = (O00000oO() ^ -1) & i;
        if (O00000oO == 0) {
            O00000o0(i);
            return;
        }
        throw new XMPException("The option bit(s) 0x" + Integer.toHexString(O00000oO) + " are invalid!", 103);
    }

    public final void O000000o(int i, boolean z) {
        int i2;
        if (z) {
            i2 = i | this.f2207O000000o;
        } else {
            i2 = (i ^ -1) & this.f2207O000000o;
        }
        this.f2207O000000o = i2;
    }

    /* access modifiers changed from: protected */
    public final boolean O000000o(int i) {
        return (i & this.f2207O000000o) != 0;
    }

    public final void O00000Oo(int i) throws XMPException {
        O00000o(i);
        this.f2207O000000o = i;
    }

    /* access modifiers changed from: protected */
    public void O00000o0(int i) throws XMPException {
    }

    /* access modifiers changed from: protected */
    public abstract int O00000oO();

    public String toString() {
        return "0x" + Integer.toHexString(this.f2207O000000o);
    }

    public boolean equals(Object obj) {
        return this.f2207O000000o == ((np) obj).f2207O000000o;
    }

    public int hashCode() {
        return this.f2207O000000o;
    }
}
