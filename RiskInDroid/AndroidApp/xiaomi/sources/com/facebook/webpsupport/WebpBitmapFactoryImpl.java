package com.facebook.webpsupport;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.util.TypedValue;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.webp.BitmapCreator;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.nativecode.StaticWebpNativeLoader;
import java.io.BufferedInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@DoNotStrip
public class WebpBitmapFactoryImpl implements WebpBitmapFactory {
    public static final boolean IN_BITMAP_SUPPORTED = (Build.VERSION.SDK_INT >= 11);
    private static BitmapCreator mBitmapCreator;
    private static WebpBitmapFactory.WebpErrorLogger mWebpErrorLogger;

    @DoNotStrip
    private static native Bitmap nativeDecodeByteArray(byte[] bArr, int i, int i2, BitmapFactory.Options options, float f, byte[] bArr2);

    @DoNotStrip
    private static native Bitmap nativeDecodeStream(InputStream inputStream, BitmapFactory.Options options, float f, byte[] bArr);

    @DoNotStrip
    private static native long nativeSeek(FileDescriptor fileDescriptor, long j, boolean z);

    public void setBitmapCreator(BitmapCreator bitmapCreator) {
        mBitmapCreator = bitmapCreator;
    }

    private static InputStream wrapToMarkSupportedStream(InputStream inputStream) {
        return !inputStream.markSupported() ? new BufferedInputStream(inputStream, 20) : inputStream;
    }

    private static byte[] getWebpHeader(InputStream inputStream, BitmapFactory.Options options) {
        byte[] bArr;
        inputStream.mark(20);
        if (options == null || options.inTempStorage == null || options.inTempStorage.length < 20) {
            bArr = new byte[20];
        } else {
            bArr = options.inTempStorage;
        }
        try {
            inputStream.read(bArr, 0, 20);
            inputStream.reset();
            return bArr;
        } catch (IOException unused) {
            return null;
        }
    }

    private static void setDensityFromOptions(Bitmap bitmap, BitmapFactory.Options options) {
        if (bitmap != null && options != null) {
            int i = options.inDensity;
            if (i != 0) {
                bitmap.setDensity(i);
                int i2 = options.inTargetDensity;
                if (i2 != 0 && i != i2 && i != options.inScreenDensity && options.inScaled) {
                    bitmap.setDensity(i2);
                }
            } else if (IN_BITMAP_SUPPORTED && options.inBitmap != null) {
                bitmap.setDensity(160);
            }
        }
    }

    public void setWebpErrorLogger(WebpBitmapFactory.WebpErrorLogger webpErrorLogger) {
        mWebpErrorLogger = webpErrorLogger;
    }

    public Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        return hookDecodeFileDescriptor(fileDescriptor, rect, options);
    }

    public Bitmap decodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        return hookDecodeStream(inputStream, rect, options);
    }

    public Bitmap decodeFile(String str, BitmapFactory.Options options) {
        return hookDecodeFile(str, options);
    }

    public Bitmap decodeByteArray(byte[] bArr, int i, int i2, BitmapFactory.Options options) {
        return hookDecodeByteArray(bArr, i, i2, options);
    }

    @DoNotStrip
    public static Bitmap hookDecodeByteArray(byte[] bArr, int i, int i2, BitmapFactory.Options options) {
        Bitmap bitmap;
        StaticWebpNativeLoader.ensure();
        if (!WebpSupportStatus.sIsWebpSupportRequired || !WebpSupportStatus.isWebpHeader(bArr, i, i2)) {
            bitmap = originalDecodeByteArray(bArr, i, i2, options);
            if (bitmap == null) {
                sendWebpErrorLog("webp_direct_decode_array_failed_on_no_webp");
            }
        } else {
            bitmap = nativeDecodeByteArray(bArr, i, i2, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
            if (bitmap == null) {
                sendWebpErrorLog("webp_direct_decode_array");
            }
            setWebpBitmapOptions(bitmap, options);
        }
        return bitmap;
    }

    @DoNotStrip
    private static Bitmap originalDecodeByteArray(byte[] bArr, int i, int i2, BitmapFactory.Options options) {
        return BitmapFactory.decodeByteArray(bArr, i, i2, options);
    }

    @DoNotStrip
    public static Bitmap hookDecodeByteArray(byte[] bArr, int i, int i2) {
        return hookDecodeByteArray(bArr, i, i2, null);
    }

    @DoNotStrip
    private static Bitmap originalDecodeByteArray(byte[] bArr, int i, int i2) {
        return BitmapFactory.decodeByteArray(bArr, i, i2);
    }

    @DoNotStrip
    public static Bitmap hookDecodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        Bitmap bitmap;
        StaticWebpNativeLoader.ensure();
        InputStream wrapToMarkSupportedStream = wrapToMarkSupportedStream(inputStream);
        byte[] webpHeader = getWebpHeader(wrapToMarkSupportedStream, options);
        if (!WebpSupportStatus.sIsWebpSupportRequired || !WebpSupportStatus.isWebpHeader(webpHeader, 0, 20)) {
            bitmap = originalDecodeStream(wrapToMarkSupportedStream, rect, options);
            if (bitmap == null) {
                sendWebpErrorLog("webp_direct_decode_stream_failed_on_no_webp");
            }
        } else {
            bitmap = nativeDecodeStream(wrapToMarkSupportedStream, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
            if (bitmap == null) {
                sendWebpErrorLog("webp_direct_decode_stream");
            }
            setWebpBitmapOptions(bitmap, options);
            setPaddingDefaultValues(rect);
        }
        return bitmap;
    }

    @DoNotStrip
    private static Bitmap originalDecodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        return BitmapFactory.decodeStream(inputStream, rect, options);
    }

    @DoNotStrip
    public static Bitmap hookDecodeStream(InputStream inputStream) {
        return hookDecodeStream(inputStream, null, null);
    }

    @DoNotStrip
    private static Bitmap originalDecodeStream(InputStream inputStream) {
        return BitmapFactory.decodeStream(inputStream);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0014, code lost:
        r2 = r4;
        r4 = r3;
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000f, code lost:
        r4 = null;
     */
    @DoNotStrip
    public static Bitmap hookDecodeFile(String str, BitmapFactory.Options options) {
        FileInputStream fileInputStream;
        Throwable th;
        Throwable th2;
        Bitmap bitmap = null;
        try {
            fileInputStream = new FileInputStream(str);
            bitmap = hookDecodeStream(fileInputStream, null, options);
            fileInputStream.close();
        } catch (Exception unused) {
        }
        return bitmap;
        throw th2;
        if (th != null) {
            try {
                fileInputStream.close();
            } catch (Throwable th3) {
                th.addSuppressed(th3);
            }
        } else {
            fileInputStream.close();
        }
        throw th2;
    }

    @DoNotStrip
    public static Bitmap hookDecodeFile(String str) {
        return hookDecodeFile(str, null);
    }

    @DoNotStrip
    public static Bitmap hookDecodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        if (options.inDensity == 0 && typedValue != null) {
            int i = typedValue.density;
            if (i == 0) {
                options.inDensity = 160;
            } else if (i != 65535) {
                options.inDensity = i;
            }
        }
        if (options.inTargetDensity == 0 && resources != null) {
            options.inTargetDensity = resources.getDisplayMetrics().densityDpi;
        }
        return hookDecodeStream(inputStream, rect, options);
    }

    @DoNotStrip
    private static Bitmap originalDecodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        return BitmapFactory.decodeResourceStream(resources, typedValue, inputStream, rect, options);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
        r2 = r0;
        r0 = r3;
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0014, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        r0 = null;
     */
    @DoNotStrip
    public static Bitmap hookDecodeResource(Resources resources, int i, BitmapFactory.Options options) {
        InputStream openRawResource;
        Throwable th;
        Throwable th2;
        TypedValue typedValue = new TypedValue();
        Bitmap bitmap = null;
        try {
            openRawResource = resources.openRawResource(i, typedValue);
            bitmap = hookDecodeResourceStream(resources, typedValue, openRawResource, null, options);
            if (openRawResource != null) {
                openRawResource.close();
            }
        } catch (Exception unused) {
        }
        if (!IN_BITMAP_SUPPORTED || bitmap != null || options == null || options.inBitmap == null) {
            return bitmap;
        }
        throw new IllegalArgumentException("Problem decoding into existing bitmap");
        if (openRawResource != null) {
            if (th2 != null) {
                try {
                    openRawResource.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            } else {
                openRawResource.close();
            }
        }
        throw th;
        throw th;
    }

    @DoNotStrip
    private static Bitmap originalDecodeResource(Resources resources, int i, BitmapFactory.Options options) {
        return BitmapFactory.decodeResource(resources, i, options);
    }

    @DoNotStrip
    public static Bitmap hookDecodeResource(Resources resources, int i) {
        return hookDecodeResource(resources, i, null);
    }

    @DoNotStrip
    private static Bitmap originalDecodeResource(Resources resources, int i) {
        return BitmapFactory.decodeResource(resources, i);
    }

    @DoNotStrip
    private static boolean setOutDimensions(BitmapFactory.Options options, int i, int i2) {
        if (options == null || !options.inJustDecodeBounds) {
            return false;
        }
        options.outWidth = i;
        options.outHeight = i2;
        return true;
    }

    @DoNotStrip
    private static void setPaddingDefaultValues(Rect rect) {
        if (rect != null) {
            rect.top = -1;
            rect.left = -1;
            rect.bottom = -1;
            rect.right = -1;
        }
    }

    @DoNotStrip
    private static void setBitmapSize(BitmapFactory.Options options, int i, int i2) {
        if (options != null) {
            options.outWidth = i;
            options.outHeight = i2;
        }
    }

    @DoNotStrip
    private static Bitmap originalDecodeFile(String str, BitmapFactory.Options options) {
        return BitmapFactory.decodeFile(str, options);
    }

    @DoNotStrip
    private static Bitmap originalDecodeFile(String str) {
        return BitmapFactory.decodeFile(str);
    }

    @DoNotStrip
    public static Bitmap hookDecodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        Bitmap bitmap;
        StaticWebpNativeLoader.ensure();
        long nativeSeek = nativeSeek(fileDescriptor, 0, false);
        if (nativeSeek != -1) {
            InputStream wrapToMarkSupportedStream = wrapToMarkSupportedStream(new FileInputStream(fileDescriptor));
            try {
                byte[] webpHeader = getWebpHeader(wrapToMarkSupportedStream, options);
                if (!WebpSupportStatus.sIsWebpSupportRequired || !WebpSupportStatus.isWebpHeader(webpHeader, 0, 20)) {
                    nativeSeek(fileDescriptor, nativeSeek, true);
                    bitmap = originalDecodeFileDescriptor(fileDescriptor, rect, options);
                    if (bitmap == null) {
                        sendWebpErrorLog("webp_direct_decode_fd_failed_on_no_webp");
                    }
                } else {
                    bitmap = nativeDecodeStream(wrapToMarkSupportedStream, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
                    if (bitmap == null) {
                        sendWebpErrorLog("webp_direct_decode_fd");
                    }
                    setPaddingDefaultValues(rect);
                    setWebpBitmapOptions(bitmap, options);
                }
                try {
                    wrapToMarkSupportedStream.close();
                    return bitmap;
                } catch (Throwable unused) {
                    return bitmap;
                }
            } catch (Throwable unused2) {
            }
        } else {
            Bitmap hookDecodeStream = hookDecodeStream(new FileInputStream(fileDescriptor), rect, options);
            setPaddingDefaultValues(rect);
            return hookDecodeStream;
        }
        throw th;
    }

    @DoNotStrip
    private static Bitmap originalDecodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
    }

    @DoNotStrip
    public static Bitmap hookDecodeFileDescriptor(FileDescriptor fileDescriptor) {
        return hookDecodeFileDescriptor(fileDescriptor, null, null);
    }

    @DoNotStrip
    private static Bitmap originalDecodeFileDescriptor(FileDescriptor fileDescriptor) {
        return BitmapFactory.decodeFileDescriptor(fileDescriptor);
    }

    private static void setWebpBitmapOptions(Bitmap bitmap, BitmapFactory.Options options) {
        setDensityFromOptions(bitmap, options);
        if (options != null) {
            options.outMimeType = "image/webp";
        }
    }

    @SuppressLint({"NewApi"})
    @DoNotStrip
    private static boolean shouldPremultiply(BitmapFactory.Options options) {
        if (Build.VERSION.SDK_INT < 19 || options == null) {
            return true;
        }
        return options.inPremultiplied;
    }

    @DoNotStrip
    private static Bitmap createBitmap(int i, int i2, BitmapFactory.Options options) {
        if (!IN_BITMAP_SUPPORTED || options == null || options.inBitmap == null || !options.inBitmap.isMutable()) {
            return mBitmapCreator.createNakedBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        return options.inBitmap;
    }

    @DoNotStrip
    private static byte[] getInTempStorageFromOptions(BitmapFactory.Options options) {
        if (options == null || options.inTempStorage == null) {
            return new byte[8192];
        }
        return options.inTempStorage;
    }

    @DoNotStrip
    private static float getScaleFromOptions(BitmapFactory.Options options) {
        float f = 1.0f;
        if (options == null) {
            return 1.0f;
        }
        int i = options.inSampleSize;
        if (i > 1) {
            f = 1.0f / ((float) i);
        }
        if (!options.inScaled) {
            return f;
        }
        int i2 = options.inDensity;
        int i3 = options.inTargetDensity;
        return (i2 == 0 || i3 == 0 || i2 == options.inScreenDensity) ? f : ((float) i3) / ((float) i2);
    }

    private static void sendWebpErrorLog(String str) {
        WebpBitmapFactory.WebpErrorLogger webpErrorLogger = mWebpErrorLogger;
        if (webpErrorLogger != null) {
            webpErrorLogger.onWebpErrorLog(str, "decoding_failure");
        }
    }
}
