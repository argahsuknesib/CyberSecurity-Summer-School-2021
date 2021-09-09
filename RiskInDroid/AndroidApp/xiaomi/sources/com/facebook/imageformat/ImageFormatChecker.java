package com.facebook.imageformat;

import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.imageformat.ImageFormat;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ImageFormatChecker {
    private static ImageFormatChecker sInstance;
    private List<ImageFormat.FormatChecker> mCustomImageFormatCheckers;
    private final ImageFormat.FormatChecker mDefaultFormatChecker = new DefaultImageFormatChecker();
    private int mMaxHeaderLength;

    private ImageFormatChecker() {
        updateMaxHeaderLength();
    }

    public void setCustomImageFormatCheckers(List<ImageFormat.FormatChecker> list) {
        this.mCustomImageFormatCheckers = list;
        updateMaxHeaderLength();
    }

    public ImageFormat determineImageFormat(InputStream inputStream) throws IOException {
        Preconditions.checkNotNull(inputStream);
        int i = this.mMaxHeaderLength;
        byte[] bArr = new byte[i];
        int readHeaderFromStream = readHeaderFromStream(i, inputStream, bArr);
        ImageFormat determineFormat = this.mDefaultFormatChecker.determineFormat(bArr, readHeaderFromStream);
        if (determineFormat != null && determineFormat != ImageFormat.UNKNOWN) {
            return determineFormat;
        }
        List<ImageFormat.FormatChecker> list = this.mCustomImageFormatCheckers;
        if (list != null) {
            for (ImageFormat.FormatChecker determineFormat2 : list) {
                ImageFormat determineFormat3 = determineFormat2.determineFormat(bArr, readHeaderFromStream);
                if (determineFormat3 != null && determineFormat3 != ImageFormat.UNKNOWN) {
                    return determineFormat3;
                }
            }
        }
        return ImageFormat.UNKNOWN;
    }

    private void updateMaxHeaderLength() {
        this.mMaxHeaderLength = this.mDefaultFormatChecker.getHeaderSize();
        List<ImageFormat.FormatChecker> list = this.mCustomImageFormatCheckers;
        if (list != null) {
            for (ImageFormat.FormatChecker headerSize : list) {
                this.mMaxHeaderLength = Math.max(this.mMaxHeaderLength, headerSize.getHeaderSize());
            }
        }
    }

    private static int readHeaderFromStream(int i, InputStream inputStream, byte[] bArr) throws IOException {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(bArr);
        Preconditions.checkArgument(bArr.length >= i);
        if (!inputStream.markSupported()) {
            return ByteStreams.read(inputStream, bArr, 0, i);
        }
        try {
            inputStream.mark(i);
            return ByteStreams.read(inputStream, bArr, 0, i);
        } finally {
            inputStream.reset();
        }
    }

    public static synchronized ImageFormatChecker getInstance() {
        ImageFormatChecker imageFormatChecker;
        synchronized (ImageFormatChecker.class) {
            if (sInstance == null) {
                sInstance = new ImageFormatChecker();
            }
            imageFormatChecker = sInstance;
        }
        return imageFormatChecker;
    }

    public static ImageFormat getImageFormat(InputStream inputStream) throws IOException {
        return getInstance().determineImageFormat(inputStream);
    }

    public static ImageFormat getImageFormat_WrapIOException(InputStream inputStream) {
        try {
            return getImageFormat(inputStream);
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:10|9|12|13|14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
        r2 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0015 */
    public static ImageFormat getImageFormat(String str) {
        FileInputStream fileInputStream = null;
        FileInputStream fileInputStream2 = new FileInputStream(str);
        try {
            ImageFormat imageFormat = getImageFormat(fileInputStream2);
            Closeables.closeQuietly(fileInputStream2);
            return imageFormat;
        } catch (IOException unused) {
            fileInputStream = fileInputStream2;
            ImageFormat imageFormat2 = ImageFormat.UNKNOWN;
            Closeables.closeQuietly(fileInputStream);
            return imageFormat2;
        } catch (Throwable th) {
            th = th;
            fileInputStream = fileInputStream2;
            Closeables.closeQuietly(fileInputStream);
            throw th;
        }
    }
}
