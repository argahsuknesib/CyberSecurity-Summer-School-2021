package _m_j;

public abstract class avk {

    /* renamed from: O000000o  reason: collision with root package name */
    private static avk f12644O000000o;

    public abstract String O000000o(byte[] bArr);

    public abstract String O00000o0();

    public static avk O000000o() {
        avk avk;
        synchronized (avk.class) {
            if (f12644O000000o == null) {
                if (avl.O00000o()) {
                    avk = new avl();
                } else {
                    avk = new avm();
                }
                f12644O000000o = avk;
            }
        }
        return f12644O000000o;
    }

    public static String O00000Oo() {
        return O000000o().O00000o0();
    }
}
