package _m_j;

public abstract class bmg<T> implements Runnable {
    public boolean O00000o = false;
    public int O00000o0 = -1;
    public boolean O00000oO = false;
    public long O00000oo = 0;
    public boolean O0000O0o = false;
    public T O0000OOo = null;

    public bmg(boolean z, int i) {
        this.O00000o = z;
        this.O00000o0 = i;
        this.O00000oO = false;
        this.O00000oo = 0;
        this.O0000O0o = false;
    }

    public bmg(boolean z, int i, boolean z2, long j, boolean z3) {
        this.O00000o = z;
        this.O00000o0 = i;
        this.O00000oO = z2;
        this.O00000oo = j;
        this.O0000O0o = z3;
    }

    public final void O000000o() {
        if (!this.O00000o) {
            run();
        } else {
            bmf.O00000Oo().O000000o(this, this.O00000o0, this.O00000oO, this.O00000oo, this.O0000O0o);
        }
    }
}
