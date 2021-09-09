package _m_j;

import android.media.AudioTrack;

public final class boa {

    /* renamed from: O000000o  reason: collision with root package name */
    volatile int f13152O000000o;
    boolean O00000Oo;
    O000000o O00000o;
    O00000Oo O00000o0;
    AudioTrack O00000oO;
    private int O00000oo = 44100;
    private int O0000O0o = 4;
    private int O0000OOo = 2;
    private int O0000Oo0;

    public interface O000000o {
        void O000000o(bnv bnv);

        bnv O00000Oo();
    }

    public interface O00000Oo {
        void O00000o0();
    }

    public boa(O000000o o000000o, int i, int i2) {
        this.O0000Oo0 = i2;
        this.O00000o = o000000o;
        this.f13152O000000o = 2;
        this.O00000oO = new AudioTrack(3, this.O00000oo, this.O0000O0o, this.O0000OOo, this.O0000Oo0 * 3, 1);
    }

    public final void O000000o() {
        if (1 == this.f13152O000000o) {
            this.f13152O000000o = 2;
        }
    }
}
