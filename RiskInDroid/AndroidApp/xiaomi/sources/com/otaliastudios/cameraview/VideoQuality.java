package com.otaliastudios.cameraview;

import _m_j.cps;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class VideoQuality extends Enum<VideoQuality> implements cps {
    private static final /* synthetic */ VideoQuality[] $VALUES;
    static final VideoQuality DEFAULT;
    public static final VideoQuality HIGHEST = new VideoQuality("HIGHEST", 1, 1);
    public static final VideoQuality LOWEST = new VideoQuality("LOWEST", 0, 0);
    public static final VideoQuality MAX_1080P = new VideoQuality("MAX_1080P", 5, 5);
    public static final VideoQuality MAX_2160P = new VideoQuality("MAX_2160P", 6, 6);
    public static final VideoQuality MAX_480P = new VideoQuality("MAX_480P", 3, 3);
    public static final VideoQuality MAX_720P = new VideoQuality("MAX_720P", 4, 4);
    public static final VideoQuality MAX_QVGA = new VideoQuality("MAX_QVGA", 2, 2);
    private int value;

    public static VideoQuality valueOf(String str) {
        return (VideoQuality) Enum.valueOf(VideoQuality.class, str);
    }

    public static VideoQuality[] values() {
        return (VideoQuality[]) $VALUES.clone();
    }

    static {
        VideoQuality videoQuality = MAX_480P;
        $VALUES = new VideoQuality[]{LOWEST, HIGHEST, MAX_QVGA, videoQuality, MAX_720P, MAX_1080P, MAX_2160P};
        DEFAULT = videoQuality;
    }

    private VideoQuality(String str, int i, int i2) {
        this.value = i2;
    }

    /* access modifiers changed from: package-private */
    public final int value() {
        return this.value;
    }

    static VideoQuality fromValue(int i) {
        for (VideoQuality videoQuality : values()) {
            if (videoQuality.value() == i) {
                return videoQuality;
            }
        }
        return null;
    }
}
