package com.madv.soundtouch;

public final class SoundTouch {
    private static SoundTouch O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public long f4548O000000o;

    private final native void deleteInstance(long j);

    private final native void flush(long j);

    public static final native String getErrorString();

    public static final native String getVersionString();

    private static final native long newInstance();

    private final native int processFile(long j, String str, String str2);

    private final native void setPitch(long j, double d);

    private final native void setPitchOctaves(long j, float f);

    private final native void setRate(long j, float f);

    private final native void setRateChange(long j, float f);

    private final native void setTempo(long j, float f);

    private final native void setTempoChange(long j, float f);

    public final native void putSamples(long j, byte[] bArr, int i);

    public final native int receiveSamples(long j, byte[] bArr, int i);

    public final native void setChannels(long j, int i);

    public final native void setPitchSemiTones(long j, float f);

    public final native void setSampleRate(long j, int i);

    public static SoundTouch O000000o() {
        if (O00000Oo == null) {
            synchronized (SoundTouch.class) {
                if (O00000Oo == null) {
                    O00000Oo = new SoundTouch();
                }
            }
        }
        return O00000Oo;
    }

    public SoundTouch() {
        this.f4548O000000o = 0;
        this.f4548O000000o = newInstance();
    }

    static {
        try {
            System.loadLibrary("soundtouch");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
