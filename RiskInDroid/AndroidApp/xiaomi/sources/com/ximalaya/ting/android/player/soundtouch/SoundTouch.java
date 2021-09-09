package com.ximalaya.ting.android.player.soundtouch;

public final class SoundTouch {
    public static boolean O00000Oo = true;
    private static SoundTouch O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public long f12235O000000o;

    private final native void deleteInstance(long j);

    public static final native String getErrorString();

    public static final native String getVersionString();

    private static final native long newInstance(int i, int i2);

    private final native int processBytes(long j, SoundTouchDataModel soundTouchDataModel);

    private final native void setPitch(long j, float f);

    public final native void setPitchSemiTones(long j, float f);

    public final native void setRate(long j, float f);

    public final native void setTempo(long j, float f);

    private SoundTouch() {
        this.f12235O000000o = 0;
        this.f12235O000000o = newInstance(44100, 2);
        O00000Oo = true;
    }

    public static SoundTouch O000000o() {
        if (O00000o0 == null) {
            synchronized (SoundTouch.class) {
                if (O00000o0 == null) {
                    O00000o0 = new SoundTouch();
                }
            }
        }
        return O00000o0;
    }

    public final int O000000o(SoundTouchDataModel soundTouchDataModel) {
        return processBytes(this.f12235O000000o, soundTouchDataModel);
    }

    static {
        try {
            System.loadLibrary("soundtouch");
        } catch (Exception unused) {
            O00000Oo = false;
        } catch (Throwable unused2) {
            O00000Oo = false;
        }
    }
}
