package _m_j;

import com.adobe.xmp.XMPException;

public final class mz {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f2190O000000o = 0;
    private String O00000Oo;

    public mz(String str) {
        this.O00000Oo = str;
    }

    public final char O000000o(int i) {
        if (i < this.O00000Oo.length()) {
            return this.O00000Oo.charAt(i);
        }
        return 0;
    }

    public final int O000000o(String str, int i) throws XMPException {
        char O000000o2 = O000000o(this.f2190O000000o);
        int i2 = 0;
        boolean z = false;
        while ('0' <= O000000o2 && O000000o2 <= '9') {
            i2 = (i2 * 10) + (O000000o2 - '0');
            this.f2190O000000o++;
            O000000o2 = O000000o(this.f2190O000000o);
            z = true;
        }
        if (!z) {
            throw new XMPException(str, 5);
        } else if (i2 > i) {
            return i;
        } else {
            if (i2 < 0) {
                return 0;
            }
            return i2;
        }
    }

    public final boolean O000000o() {
        return this.f2190O000000o < this.O00000Oo.length();
    }

    public final char O00000Oo() {
        if (this.f2190O000000o < this.O00000Oo.length()) {
            return this.O00000Oo.charAt(this.f2190O000000o);
        }
        return 0;
    }

    public final void O00000o0() {
        this.f2190O000000o++;
    }
}
