package pl.droidsonroids.gif;

import _m_j.joa;
import _m_j.jof;
import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.system.ErrnoException;
import android.system.Os;
import android.view.Surface;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class GifInfoHandle {

    /* renamed from: O000000o  reason: collision with root package name */
    volatile long f15482O000000o;

    static native void bindSurface(long j, Surface surface, long[] jArr);

    static native int createTempNativeFileDescriptor() throws GifIOException;

    static native int extractNativeFileDescriptor(FileDescriptor fileDescriptor, boolean z) throws GifIOException;

    private static native void free(long j);

    private static native long getAllocationByteCount(long j);

    private static native String getComment(long j);

    private static native int getCurrentFrameIndex(long j);

    private static native int getCurrentLoop(long j);

    private static native int getCurrentPosition(long j);

    private static native int getDuration(long j);

    private static native int getFrameDuration(long j, int i);

    private static native int getHeight(long j);

    private static native int getLoopCount(long j);

    private static native long getMetadataByteCount(long j);

    private static native int getNativeErrorCode(long j);

    private static native int getNumberOfFrames(long j);

    private static native long[] getSavedState(long j);

    private static native long getSourceLength(long j);

    private static native int getWidth(long j);

    private static native void glTexImage2D(long j, int i, int i2);

    private static native void glTexSubImage2D(long j, int i, int i2);

    private static native void initTexImageDescriptor(long j);

    private static native boolean isAnimationCompleted(long j);

    private static native boolean isOpaque(long j);

    static native long openByteArray(byte[] bArr) throws GifIOException;

    static native long openDirectByteBuffer(ByteBuffer byteBuffer) throws GifIOException;

    static native long openFile(String str) throws GifIOException;

    static native long openNativeFileDescriptor(int i, long j) throws GifIOException;

    static native long openStream(InputStream inputStream) throws GifIOException;

    private static native void postUnbindSurface(long j);

    private static native long renderFrame(long j, Bitmap bitmap);

    private static native boolean reset(long j);

    private static native long restoreRemainder(long j);

    private static native int restoreSavedState(long j, long[] jArr, Bitmap bitmap);

    private static native void saveRemainder(long j);

    private static native void seekToFrame(long j, int i, Bitmap bitmap);

    private static native void seekToFrameGL(long j, int i);

    private static native void seekToTime(long j, int i, Bitmap bitmap);

    private static native void setLoopCount(long j, char c);

    static native void setOptions(long j, char c, boolean z);

    private static native void setSpeedFactor(long j, float f);

    private static native void startDecoderThread(long j);

    private static native void stopDecoderThread(long j);

    GifInfoHandle() {
    }

    public GifInfoHandle(ByteBuffer byteBuffer) throws GifIOException {
        this.f15482O000000o = openDirectByteBuffer(byteBuffer);
    }

    private GifInfoHandle(String str) throws GifIOException {
        this.f15482O000000o = openFile(str);
    }

    public GifInfoHandle(AssetFileDescriptor assetFileDescriptor) throws IOException {
        try {
            this.f15482O000000o = O000000o(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset());
        } finally {
            try {
                assetFileDescriptor.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: pl.droidsonroids.gif.GifInfoHandle.O000000o(java.io.FileDescriptor, boolean):int
     arg types: [java.io.FileDescriptor, int]
     candidates:
      pl.droidsonroids.gif.GifInfoHandle.O000000o(java.io.FileDescriptor, long):long
      pl.droidsonroids.gif.GifInfoHandle.O000000o(android.content.ContentResolver, android.net.Uri):pl.droidsonroids.gif.GifInfoHandle
      pl.droidsonroids.gif.GifInfoHandle.O000000o(long[], android.graphics.Bitmap):int
      pl.droidsonroids.gif.GifInfoHandle.O000000o(int, android.graphics.Bitmap):void
      pl.droidsonroids.gif.GifInfoHandle.O000000o(java.io.FileDescriptor, boolean):int */
    private static long O000000o(FileDescriptor fileDescriptor, long j) throws GifIOException {
        int i;
        if (Build.VERSION.SDK_INT > 27) {
            try {
                i = O000000o(fileDescriptor, false);
            } catch (Exception e) {
                throw new GifIOException(GifError.OPEN_FAILED.errorCode, e.getMessage());
            }
        } else {
            i = extractNativeFileDescriptor(fileDescriptor, false);
        }
        return openNativeFileDescriptor(i, j);
    }

    private static int O000000o(FileDescriptor fileDescriptor, boolean z) throws GifIOException, ErrnoException {
        int createTempNativeFileDescriptor = createTempNativeFileDescriptor();
        Os.dup2(fileDescriptor, createTempNativeFileDescriptor);
        return createTempNativeFileDescriptor;
    }

    public static GifInfoHandle O000000o(ContentResolver contentResolver, Uri uri) throws IOException {
        if ("file".equals(uri.getScheme())) {
            return new GifInfoHandle(uri.getPath());
        }
        AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (openAssetFileDescriptor != null) {
            return new GifInfoHandle(openAssetFileDescriptor);
        }
        throw new IOException("Could not open AssetFileDescriptor for ".concat(String.valueOf(uri)));
    }

    public final synchronized long O000000o(Bitmap bitmap) {
        return renderFrame(this.f15482O000000o, bitmap);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void O000000o() {
        free(this.f15482O000000o);
        this.f15482O000000o = 0;
    }

    public final synchronized long O00000Oo() {
        return restoreRemainder(this.f15482O000000o);
    }

    public final synchronized boolean O00000o0() {
        return reset(this.f15482O000000o);
    }

    public final synchronized void O00000o() {
        saveRemainder(this.f15482O000000o);
    }

    public final synchronized int O00000oO() {
        return getLoopCount(this.f15482O000000o);
    }

    public final void O000000o(int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("Loop count of range <0, 65535>");
        }
        synchronized (this) {
            setLoopCount(this.f15482O000000o, (char) i);
        }
    }

    public final synchronized int O00000oo() {
        return getNativeErrorCode(this.f15482O000000o);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(float f) {
        if (f <= 0.0f || Float.isNaN(f)) {
            throw new IllegalArgumentException("Speed factor is not positive");
        }
        if (f < 4.656613E-10f) {
            f = 4.656613E-10f;
        }
        synchronized (this) {
            setSpeedFactor(this.f15482O000000o, f);
        }
    }

    public final synchronized int O0000O0o() {
        return getDuration(this.f15482O000000o);
    }

    public final synchronized int O0000OOo() {
        return getCurrentPosition(this.f15482O000000o);
    }

    public final synchronized int O0000Oo0() {
        return getCurrentFrameIndex(this.f15482O000000o);
    }

    public final synchronized int O0000Oo() {
        return getCurrentLoop(this.f15482O000000o);
    }

    public final synchronized void O000000o(int i, Bitmap bitmap) {
        seekToTime(this.f15482O000000o, i, bitmap);
    }

    public final synchronized boolean O0000OoO() {
        return this.f15482O000000o == 0;
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        try {
            O000000o();
        } finally {
            super.finalize();
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void O0000Ooo() {
        postUnbindSurface(this.f15482O000000o);
    }

    /* access modifiers changed from: package-private */
    public final synchronized long[] O0000o00() {
        return getSavedState(this.f15482O000000o);
    }

    /* access modifiers changed from: package-private */
    public final synchronized int O000000o(long[] jArr, Bitmap bitmap) {
        return restoreSavedState(this.f15482O000000o, jArr, bitmap);
    }

    public final synchronized int O0000o0() {
        return getWidth(this.f15482O000000o);
    }

    public final synchronized int O0000o0O() {
        return getHeight(this.f15482O000000o);
    }

    public final synchronized int O0000o0o() {
        return getNumberOfFrames(this.f15482O000000o);
    }

    public final synchronized boolean O0000o() {
        return isOpaque(this.f15482O000000o);
    }

    static {
        try {
            System.loadLibrary("pl_droidsonroids_gif");
        } catch (UnsatisfiedLinkError unused) {
            jof.O000000o(joa.O000000o(), "pl_droidsonroids_gif");
        }
    }
}
