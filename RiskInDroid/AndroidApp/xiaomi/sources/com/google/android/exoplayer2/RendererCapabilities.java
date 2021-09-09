package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface RendererCapabilities {

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AdaptiveSupport {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Capabilities {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FormatSupport {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface TunnelingSupport {
    }

    String getName();

    int getTrackType();

    int supportsFormat(Format format) throws ExoPlaybackException;

    int supportsMixedMimeTypeAdaptation() throws ExoPlaybackException;

    /* renamed from: com.google.android.exoplayer2.RendererCapabilities$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        @SuppressLint({"WrongConstant"})
        public static int create(int i, int i2, int i3) {
            return i | i2 | i3;
        }

        @SuppressLint({"WrongConstant"})
        public static int getAdaptiveSupport(int i) {
            return i & 24;
        }

        @SuppressLint({"WrongConstant"})
        public static int getFormatSupport(int i) {
            return i & 7;
        }

        @SuppressLint({"WrongConstant"})
        public static int getTunnelingSupport(int i) {
            return i & 32;
        }

        public static int create(int i) {
            return create(i, 0, 0);
        }

        public static String getFormatSupportString(int i) {
            if (i == 0) {
                return "NO";
            }
            if (i == 1) {
                return "NO_UNSUPPORTED_TYPE";
            }
            if (i == 2) {
                return "NO_UNSUPPORTED_DRM";
            }
            if (i == 3) {
                return "NO_EXCEEDS_CAPABILITIES";
            }
            if (i == 4) {
                return "YES";
            }
            throw new IllegalStateException();
        }
    }
}
