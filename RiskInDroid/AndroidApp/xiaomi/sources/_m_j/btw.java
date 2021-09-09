package _m_j;

public abstract class btw {

    /* renamed from: O000000o  reason: collision with root package name */
    btw f13277O000000o;

    public btw() {
    }

    public btw(btw btw) {
        this.f13277O000000o = btw;
    }

    public void O000000o(int i) {
        btw btw = this.f13277O000000o;
        if (btw != null) {
            btw.O000000o(i);
        }
    }

    public void O000000o(boolean z) {
        btw btw = this.f13277O000000o;
        if (btw != null) {
            btw.O000000o(z);
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean O000000o();

    public int O00000Oo() {
        btw btw = this.f13277O000000o;
        return Math.min(Integer.MAX_VALUE, btw != null ? btw.O00000Oo() : Integer.MAX_VALUE);
    }

    public final boolean O00000o0() {
        btw btw = this.f13277O000000o;
        if (!(btw != null ? btw.O00000o0() : true)) {
            return false;
        }
        return O000000o();
    }
}
