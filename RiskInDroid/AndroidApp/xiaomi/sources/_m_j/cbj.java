package _m_j;

import java.util.HashMap;

public final class cbj {

    /* renamed from: O000000o  reason: collision with root package name */
    public float f13593O000000o;
    public float O00000Oo;
    public float O00000o;
    public float O00000o0;
    public HashMap<Integer, Float> O00000oO;
    private float O00000oo;
    private int O0000O0o;
    private float O0000OOo;
    private float O0000Oo0;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static cbj f13594O000000o = new cbj((byte) 0);
    }

    /* synthetic */ cbj(byte b) {
        this();
    }

    private cbj() {
        this.O00000oo = 3.0f;
        this.O0000O0o = 480;
        this.O0000OOo = 1080.0f;
        this.O0000Oo0 = this.O0000OOo / this.O00000oo;
    }

    public final float O000000o(int i) {
        return ((((float) i) * this.O00000oo) * this.O00000o0) / this.O0000OOo;
    }

    public final float O00000Oo(int i) {
        return (((float) i) / this.O0000OOo) * this.O00000o0;
    }

    public final int O00000o0(int i) {
        return (int) (this.O00000oO.get(Integer.valueOf(i)).floatValue() + 0.5f);
    }

    public final int O00000o(int i) {
        return (int) (this.O00000o0 - (((float) i) * this.f13593O000000o));
    }
}
