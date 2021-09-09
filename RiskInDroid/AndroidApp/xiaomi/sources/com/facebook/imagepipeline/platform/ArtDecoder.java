package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import androidx.core.util.Pools;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.streams.TailAppendingInputStream;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

@TargetApi(21)
public class ArtDecoder implements PlatformDecoder {
    private static final byte[] EOI_TAIL = {-1, -39};
    private static final Class<?> TAG = ArtDecoder.class;
    private final BitmapPool mBitmapPool;
    @VisibleForTesting
    final Pools.O00000Oo<ByteBuffer> mDecodeBuffers;

    public ArtDecoder(BitmapPool bitmapPool, int i, Pools.O00000Oo o00000Oo) {
        this.mBitmapPool = bitmapPool;
        this.mDecodeBuffers = o00000Oo;
        for (int i2 = 0; i2 < i; i2++) {
            this.mDecodeBuffers.release(ByteBuffer.allocate(16384));
        }
    }

    public CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, Rect rect) {
        BitmapFactory.Options decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config);
        boolean z = decodeOptionsForStream.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            return decodeStaticImageFromStream(encodedImage.getInputStream(), decodeOptionsForStream, rect);
        } catch (RuntimeException e) {
            if (z) {
                return decodeFromEncodedImage(encodedImage, Bitmap.Config.ARGB_8888, rect);
            }
            throw e;
        }
    }

    public CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, Rect rect, int i) {
        boolean isCompleteAt = encodedImage.isCompleteAt(i);
        BitmapFactory.Options decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config);
        InputStream inputStream = encodedImage.getInputStream();
        Preconditions.checkNotNull(inputStream);
        if (encodedImage.getSize() > i) {
            inputStream = new LimitedInputStream(inputStream, i);
        }
        InputStream tailAppendingInputStream = !isCompleteAt ? new TailAppendingInputStream(inputStream, EOI_TAIL) : inputStream;
        boolean z = decodeOptionsForStream.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            return decodeStaticImageFromStream(tailAppendingInputStream, decodeOptionsForStream, rect);
        } catch (RuntimeException e) {
            if (z) {
                return decodeFromEncodedImage(encodedImage, Bitmap.Config.ARGB_8888, rect);
            }
            throw e;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.BitmapRegionDecoder.newInstance(java.io.InputStream, boolean):android.graphics.BitmapRegionDecoder throws java.io.IOException}
     arg types: [java.io.InputStream, int]
     candidates:
      ClspMth{android.graphics.BitmapRegionDecoder.newInstance(java.io.FileDescriptor, boolean):android.graphics.BitmapRegionDecoder throws java.io.IOException}
      ClspMth{android.graphics.BitmapRegionDecoder.newInstance(java.lang.String, boolean):android.graphics.BitmapRegionDecoder throws java.io.IOException}
      ClspMth{android.graphics.BitmapRegionDecoder.newInstance(java.io.InputStream, boolean):android.graphics.BitmapRegionDecoder throws java.io.IOException} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        com.facebook.common.logging.FLog.e(com.facebook.imagepipeline.platform.ArtDecoder.TAG, "Could not decode region %s, decoding full bitmap instead.", r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0060, code lost:
        if (r0 != null) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r0.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0069, code lost:
        r0.recycle();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0054 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00b7 */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0069 A[Catch:{ IllegalArgumentException -> 0x0099, RuntimeException -> 0x0092, all -> 0x0090, IOException -> 0x00b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070 A[Catch:{ IllegalArgumentException -> 0x0099, RuntimeException -> 0x0092, all -> 0x0090, IOException -> 0x00b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0082  */
    public CloseableReference<Bitmap> decodeStaticImageFromStream(InputStream inputStream, BitmapFactory.Options options, Rect rect) {
        Bitmap bitmap;
        BitmapRegionDecoder bitmapRegionDecoder;
        Preconditions.checkNotNull(inputStream);
        int i = options.outWidth;
        int i2 = options.outHeight;
        if (rect != null) {
            i = rect.width();
            i2 = rect.height();
        }
        Bitmap bitmap2 = (Bitmap) this.mBitmapPool.get(BitmapUtil.getSizeInByteForBitmap(i, i2, options.inPreferredConfig));
        if (bitmap2 != null) {
            options.inBitmap = bitmap2;
            ByteBuffer acquire = this.mDecodeBuffers.acquire();
            if (acquire == null) {
                acquire = ByteBuffer.allocate(16384);
            }
            try {
                options.inTempStorage = acquire.array();
                if (rect != null) {
                    try {
                        bitmap2.reconfigure(i, i2, options.inPreferredConfig);
                        bitmapRegionDecoder = BitmapRegionDecoder.newInstance(inputStream, true);
                        bitmap = bitmapRegionDecoder.decodeRegion(rect, options);
                        if (bitmapRegionDecoder != null) {
                            bitmapRegionDecoder.recycle();
                        }
                    } catch (IOException unused) {
                        bitmapRegionDecoder = null;
                    } catch (Throwable th) {
                        th = th;
                        bitmapRegionDecoder = null;
                        if (bitmapRegionDecoder != null) {
                        }
                        throw th;
                    }
                    if (bitmap == null) {
                        bitmap = BitmapFactory.decodeStream(inputStream, null, options);
                    }
                    this.mDecodeBuffers.release(acquire);
                    if (bitmap2 != bitmap) {
                        return CloseableReference.of(bitmap, this.mBitmapPool);
                    }
                    this.mBitmapPool.release(bitmap2);
                    bitmap.recycle();
                    throw new IllegalStateException();
                }
                bitmap = null;
                if (bitmap == null) {
                }
                this.mDecodeBuffers.release(acquire);
                if (bitmap2 != bitmap) {
                }
            } catch (IllegalArgumentException e) {
                this.mBitmapPool.release(bitmap2);
                inputStream.reset();
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                if (decodeStream != null) {
                    CloseableReference<Bitmap> of = CloseableReference.of(decodeStream, SimpleBitmapReleaser.getInstance());
                    this.mDecodeBuffers.release(acquire);
                    return of;
                }
                throw e;
                throw e;
            } catch (RuntimeException e2) {
                this.mBitmapPool.release(bitmap2);
                throw e2;
            } catch (IOException ) {
                throw e;
            } catch (Throwable th2) {
                this.mDecodeBuffers.release(acquire);
                throw th2;
            }
        } else {
            throw new NullPointerException("BitmapPool.get returned null");
        }
    }

    private static BitmapFactory.Options getDecodeOptionsForStream(EncodedImage encodedImage, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = encodedImage.getSampleSize();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(encodedImage.getInputStream(), null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            throw new IllegalArgumentException();
        }
        options.inJustDecodeBounds = false;
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inMutable = true;
        return options;
    }
}
