package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.MemoryFile;
import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;

public class GingerbreadPurgeableDecoder extends DalvikPurgeableDecoder {
    private static Method sGetFileDescriptorMethod;

    public /* bridge */ /* synthetic */ CloseableReference decodeFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, Rect rect) {
        return super.decodeFromEncodedImage(encodedImage, config, rect);
    }

    public /* bridge */ /* synthetic */ CloseableReference decodeJPEGFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, Rect rect, int i) {
        return super.decodeJPEGFromEncodedImage(encodedImage, config, rect, i);
    }

    public /* bridge */ /* synthetic */ CloseableReference pinBitmap(Bitmap bitmap) {
        return super.pinBitmap(bitmap);
    }

    /* access modifiers changed from: protected */
    public Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, BitmapFactory.Options options) {
        return decodeFileDescriptorAsPurgeable(closeableReference, closeableReference.get().size(), null, options);
    }

    /* access modifiers changed from: protected */
    public Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, int i, BitmapFactory.Options options) {
        return decodeFileDescriptorAsPurgeable(closeableReference, i, endsWithEOI(closeableReference, i) ? null : EOI, options);
    }

    private static MemoryFile copyToMemoryFile(CloseableReference<PooledByteBuffer> closeableReference, int i, byte[] bArr) throws IOException {
        Closeable closeable;
        PooledByteBufferInputStream pooledByteBufferInputStream;
        LimitedInputStream limitedInputStream = null;
        MemoryFile memoryFile = new MemoryFile(null, (bArr == null ? 0 : bArr.length) + i);
        memoryFile.allowPurging(false);
        try {
            pooledByteBufferInputStream = new PooledByteBufferInputStream(closeableReference.get());
            try {
                LimitedInputStream limitedInputStream2 = new LimitedInputStream(pooledByteBufferInputStream, i);
                try {
                    OutputStream outputStream = memoryFile.getOutputStream();
                    ByteStreams.copy(limitedInputStream2, outputStream);
                    if (bArr != null) {
                        memoryFile.writeBytes(bArr, 0, i, bArr.length);
                    }
                    CloseableReference.closeSafely(closeableReference);
                    Closeables.closeQuietly(pooledByteBufferInputStream);
                    Closeables.closeQuietly(limitedInputStream2);
                    Closeables.close(outputStream, true);
                    return memoryFile;
                } catch (Throwable th) {
                    th = th;
                    closeable = null;
                    limitedInputStream = limitedInputStream2;
                    CloseableReference.closeSafely(closeableReference);
                    Closeables.closeQuietly(pooledByteBufferInputStream);
                    Closeables.closeQuietly(limitedInputStream);
                    Closeables.close(closeable, true);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                closeable = null;
                CloseableReference.closeSafely(closeableReference);
                Closeables.closeQuietly(pooledByteBufferInputStream);
                Closeables.closeQuietly(limitedInputStream);
                Closeables.close(closeable, true);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            pooledByteBufferInputStream = null;
            CloseableReference.closeSafely(closeableReference);
            Closeables.closeQuietly(pooledByteBufferInputStream);
            Closeables.closeQuietly(limitedInputStream);
            Closeables.close(closeable, true);
            throw th;
        }
    }

    private synchronized Method getFileDescriptorMethod() {
        if (sGetFileDescriptorMethod == null) {
            try {
                sGetFileDescriptorMethod = MemoryFile.class.getDeclaredMethod("getFileDescriptor", new Class[0]);
            } catch (Exception e) {
                throw Throwables.propagate(e);
            }
        }
        return sGetFileDescriptorMethod;
    }

    private FileDescriptor getMemoryFileDescriptor(MemoryFile memoryFile) {
        try {
            return (FileDescriptor) getFileDescriptorMethod().invoke(memoryFile, new Object[0]);
        } catch (Exception e) {
            throw Throwables.propagate(e);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002d  */
    public Bitmap decodeFileDescriptorAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, int i, byte[] bArr, BitmapFactory.Options options) {
        MemoryFile memoryFile = null;
        try {
            MemoryFile memoryFile2 = copyToMemoryFile(closeableReference, i, bArr);
            try {
                Bitmap bitmap = (Bitmap) Preconditions.checkNotNull(WebpSupportStatus.sWebpBitmapFactory.decodeFileDescriptor(getMemoryFileDescriptor(memoryFile2), null, options), "BitmapFactory returned null");
                if (memoryFile2 != null) {
                    memoryFile2.close();
                }
                return bitmap;
            } catch (IOException e) {
                e = e;
                memoryFile = memoryFile2;
                try {
                    throw Throwables.propagate(e);
                } catch (Throwable th) {
                    th = th;
                    memoryFile2 = memoryFile;
                    if (memoryFile2 != null) {
                        memoryFile2.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (memoryFile2 != null) {
                }
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            throw Throwables.propagate(e);
        }
    }
}
