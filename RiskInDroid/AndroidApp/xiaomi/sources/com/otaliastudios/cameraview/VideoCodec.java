package com.otaliastudios.cameraview;

import _m_j.cps;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class VideoCodec extends Enum<VideoCodec> implements cps {
    private static final /* synthetic */ VideoCodec[] $VALUES;
    static final VideoCodec DEFAULT;
    public static final VideoCodec DEVICE_DEFAULT = new VideoCodec("DEVICE_DEFAULT", 0, 0);
    public static final VideoCodec H_263 = new VideoCodec("H_263", 1, 1);
    public static final VideoCodec H_264 = new VideoCodec("H_264", 2, 2);
    private int value;

    public static VideoCodec valueOf(String str) {
        return (VideoCodec) Enum.valueOf(VideoCodec.class, str);
    }

    public static VideoCodec[] values() {
        return (VideoCodec[]) $VALUES.clone();
    }

    static {
        VideoCodec videoCodec = DEVICE_DEFAULT;
        $VALUES = new VideoCodec[]{videoCodec, H_263, H_264};
        DEFAULT = videoCodec;
    }

    private VideoCodec(String str, int i, int i2) {
        this.value = i2;
    }

    /* access modifiers changed from: package-private */
    public final int value() {
        return this.value;
    }

    static VideoCodec fromValue(int i) {
        for (VideoCodec videoCodec : values()) {
            if (videoCodec.value() == i) {
                return videoCodec;
            }
        }
        return null;
    }
}
