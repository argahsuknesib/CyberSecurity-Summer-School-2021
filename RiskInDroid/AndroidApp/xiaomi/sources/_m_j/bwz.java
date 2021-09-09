package _m_j;

import com.madv.soundtouch.SoundTouch;

public class bwz {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f13372O000000o = "bwz";
    private static volatile bwz O0000O0o;
    public SoundTouch O00000Oo = SoundTouch.O000000o();
    public byte[] O00000o = new byte[640];
    public boolean O00000o0;
    public byte[] O00000oO = new byte[640];
    public int O00000oo;

    public interface O000000o {
        void O000000o(byte[] bArr);
    }

    public static bwz O000000o() {
        if (O0000O0o == null) {
            synchronized (bwz.class) {
                if (O0000O0o == null) {
                    O0000O0o = new bwz();
                }
            }
        }
        return O0000O0o;
    }

    public final void O000000o(int i) {
        SoundTouch soundTouch = this.O00000Oo;
        soundTouch.setPitchSemiTones(soundTouch.f4548O000000o, (float) i);
    }
}
