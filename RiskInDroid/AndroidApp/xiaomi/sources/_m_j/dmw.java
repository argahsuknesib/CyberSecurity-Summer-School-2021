package _m_j;

public final class dmw {

    /* renamed from: O000000o  reason: collision with root package name */
    private dmx[] f14797O000000o = new dmx[20];

    public dmw() {
        for (int i = 0; i < 20; i++) {
            this.f14797O000000o[i] = new dmx();
        }
    }

    public final dmx O000000o(int i) {
        if (i < 0 || i >= 20) {
            return null;
        }
        return this.f14797O000000o[i];
    }
}
