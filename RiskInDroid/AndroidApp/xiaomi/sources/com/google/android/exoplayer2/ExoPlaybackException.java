package com.google.android.exoplayer2;

import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ExoPlaybackException extends Exception {
    private final Throwable cause;
    public final Format rendererFormat;
    public final int rendererFormatSupport;
    public final int rendererIndex;
    public final String rendererName;
    public final long timestampMs;
    public final int type;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    public static ExoPlaybackException createForSource(IOException iOException) {
        return new ExoPlaybackException(0, iOException);
    }

    public static ExoPlaybackException createForRenderer(Exception exc, String str, int i, Format format, int i2) {
        return new ExoPlaybackException(1, exc, null, str, i, format, format == null ? 4 : i2);
    }

    public static ExoPlaybackException createForUnexpected(RuntimeException runtimeException) {
        return new ExoPlaybackException(2, runtimeException);
    }

    public static ExoPlaybackException createForRemote(String str) {
        return new ExoPlaybackException(3, str);
    }

    public static ExoPlaybackException createForOutOfMemoryError(OutOfMemoryError outOfMemoryError) {
        return new ExoPlaybackException(4, outOfMemoryError);
    }

    private ExoPlaybackException(int i, Throwable th) {
        this(i, th, null, null, -1, null, 4);
    }

    private ExoPlaybackException(int i, String str) {
        this(i, null, str, null, -1, null, 4);
    }

    private ExoPlaybackException(int i, Throwable th, String str, String str2, int i2, Format format, int i3) {
        super(deriveMessage(i, str, str2, i2, format, i3), th);
        this.type = i;
        this.cause = th;
        this.rendererName = str2;
        this.rendererIndex = i2;
        this.rendererFormat = format;
        this.rendererFormatSupport = i3;
        this.timestampMs = SystemClock.elapsedRealtime();
    }

    public final IOException getSourceException() {
        Assertions.checkState(this.type == 0);
        return (IOException) Assertions.checkNotNull(this.cause);
    }

    public final Exception getRendererException() {
        boolean z = true;
        if (this.type != 1) {
            z = false;
        }
        Assertions.checkState(z);
        return (Exception) Assertions.checkNotNull(this.cause);
    }

    public final RuntimeException getUnexpectedException() {
        Assertions.checkState(this.type == 2);
        return (RuntimeException) Assertions.checkNotNull(this.cause);
    }

    public final OutOfMemoryError getOutOfMemoryError() {
        Assertions.checkState(this.type == 4);
        return (OutOfMemoryError) Assertions.checkNotNull(this.cause);
    }

    private static String deriveMessage(int i, String str, String str2, int i2, Format format, int i3) {
        String str3;
        if (i == 0) {
            str3 = "Source error";
        } else if (i != 1) {
            str3 = i != 3 ? i != 4 ? "Unexpected runtime error" : "Out of memory error" : "Remote error";
        } else {
            str3 = str2 + " error, index=" + i2 + ", format=" + format + ", format_supported=" + RendererCapabilities.CC.getFormatSupportString(i3);
        }
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        return str3 + ": " + str;
    }
}
