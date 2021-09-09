package _m_j;

import java.util.Random;

public final class avq implements avp {

    /* renamed from: O000000o  reason: collision with root package name */
    private O000000o f12645O000000o = new O000000o();

    public final String O00000Oo() {
        return String.valueOf(O00000o0().longValue() + ((long) this.f12645O000000o.f12646O000000o.nextInt()));
    }

    public final String O000000o() {
        return String.valueOf(O00000o0());
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final Random f12646O000000o = new Random();

        O000000o() {
        }
    }

    private static Long O00000o0() {
        return Long.valueOf(System.currentTimeMillis() / 1000);
    }
}
