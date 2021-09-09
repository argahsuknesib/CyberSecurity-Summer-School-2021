package _m_j;

public final class boc implements bny {

    /* renamed from: O000000o  reason: collision with root package name */
    private volatile int f13154O000000o;
    private volatile int O00000Oo;
    private volatile int O00000o;
    private volatile int O00000o0;
    private volatile bnv[] O00000oO;

    public boc(int i) {
        if (i > 0) {
            this.O00000o = i;
            this.O00000oO = new bnv[(i + 1)];
            this.O00000Oo = 0;
            this.O00000o0 = 0;
        }
        this.f13154O000000o = 2;
    }

    public final void O000000o(bnv[] bnvArr) {
        this.O00000Oo = 0;
        if (bnvArr != null) {
            for (int i = 0; i < bnvArr.length; i++) {
                this.O00000oO[i] = bnvArr[i];
            }
            this.O00000o0 = bnvArr.length;
        } else {
            this.O00000o0 = 0;
        }
        this.f13154O000000o = 1;
    }

    public final void O000000o() {
        this.f13154O000000o = 2;
    }

    public final bnv O00000Oo() {
        while (1 == this.f13154O000000o) {
            if (this.O00000Oo != this.O00000o0) {
                bnv bnv = this.O00000oO[this.O00000Oo];
                this.O00000Oo++;
                if (this.O00000Oo <= this.O00000o) {
                    return bnv;
                }
                this.O00000Oo = 0;
                return bnv;
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public final boolean O000000o(bnv bnv) {
        while (1 == this.f13154O000000o) {
            int i = this.O00000o0 + 1;
            if (i > this.O00000o) {
                i = 0;
            }
            if (i != this.O00000Oo) {
                this.O00000oO[this.O00000o0] = bnv;
                this.O00000o0 = i;
                return true;
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
