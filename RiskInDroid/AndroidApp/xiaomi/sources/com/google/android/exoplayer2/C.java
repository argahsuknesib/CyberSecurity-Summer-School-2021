package com.google.android.exoplayer2;

import android.content.Context;
import android.media.AudioManager;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.UUID;

public final class C {
    public static final UUID CLEARKEY_UUID = new UUID(-2129748144642739255L, 8654423357094679310L);
    public static final UUID COMMON_PSSH_UUID = new UUID(1186680826959645954L, -5988876978535335093L);
    @Deprecated
    public static final int MSG_CUSTOM_BASE = 10000;
    @Deprecated
    public static final int MSG_SET_AUDIO_ATTRIBUTES = 3;
    @Deprecated
    public static final int MSG_SET_AUX_EFFECT_INFO = 5;
    @Deprecated
    public static final int MSG_SET_CAMERA_MOTION_LISTENER = 7;
    @Deprecated
    public static final int MSG_SET_SCALING_MODE = 4;
    @Deprecated
    public static final int MSG_SET_SURFACE = 1;
    @Deprecated
    public static final int MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER = 8;
    @Deprecated
    public static final int MSG_SET_VIDEO_FRAME_METADATA_LISTENER = 6;
    @Deprecated
    public static final int MSG_SET_VOLUME = 2;
    public static final UUID PLAYREADY_UUID = new UUID(-7348484286925749626L, -6083546864340672619L);
    public static final UUID UUID_NIL = new UUID(0, 0);
    @Deprecated
    public static final int VIDEO_SCALING_MODE_DEFAULT = 1;
    @Deprecated
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT = 1;
    @Deprecated
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING = 2;
    public static final UUID WIDEVINE_UUID = new UUID(-1301668207276963122L, -6645017420763422227L);

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AudioAllowedCapturePolicy {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AudioContentType {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AudioFlags {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AudioFocusGain {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AudioUsage {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface BufferFlags {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorRange {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorSpace {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorTransfer {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ContentType {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface CryptoMode {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Encoding {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface NetworkType {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PcmEncoding {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Projection {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface RoleFlags {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface SelectionFlags {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface StereoMode {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface StreamType {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface VideoOutputMode {
    }

    @Documented
    @Deprecated
    @Retention(RetentionPolicy.SOURCE)
    public @interface VideoScalingMode {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface WakeMode {
    }

    public static long msToUs(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j * 1000;
    }

    private C() {
    }

    public static long usToMs(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j / 1000;
    }

    public static int generateAudioSessionIdV21(Context context) {
        return ((AudioManager) context.getSystemService("audio")).generateAudioSessionId();
    }
}
