package com.reactnative.camera.RCTCamera;

import _m_j.wh;
import _m_j.xr;
import _m_j.xu;
import _m_j.xw;
import _m_j.yt;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.util.Log;
import com.drew.imaging.ImageProcessingException;
import com.facebook.react.bridge.ReadableMap;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public final class MutableImage {

    /* renamed from: O000000o  reason: collision with root package name */
    Bitmap f5470O000000o;
    boolean O00000Oo = false;
    private xu O00000o;
    private final byte[] O00000o0;

    public MutableImage(byte[] bArr) {
        this.O00000o0 = bArr;
        this.f5470O000000o = O000000o(bArr);
    }

    private static Bitmap O000000o(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            Bitmap decodeStream = BitmapFactory.decodeStream(byteArrayInputStream);
            byteArrayInputStream.close();
            return decodeStream;
        } catch (IOException e) {
            throw new IllegalStateException("Will not happen", e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00f3, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        android.util.Log.e("RNCamera", "Couldn't write location data", r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x010a, code lost:
        r10 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x010a A[ExcHandler: ImageProcessingException (e com.drew.imaging.ImageProcessingException), Splitter:B:1:0x0019] */
    public final void O000000o(File file, ReadableMap readableMap, int i) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(O000000o(this.f5470O000000o, i));
        fileOutputStream.close();
        try {
            ExifInterface exifInterface = new ExifInterface(file.getAbsolutePath());
            for (xr xrVar : O000000o().f2599O000000o) {
                for (xw next : xrVar.O00000o()) {
                    exifInterface.setAttribute(next.O000000o(), xrVar.O0000o0o(next.f2601O000000o).toString());
                }
            }
            yt ytVar = (yt) O000000o().O000000o(yt.class);
            for (xw next2 : ytVar.O00000o()) {
                exifInterface.setAttribute(next2.O000000o().replaceAll(" ", ""), ytVar.O0000o0o(next2.f2601O000000o).toString());
            }
            if (readableMap.hasKey("metadata")) {
                ReadableMap map = readableMap.getMap("metadata");
                if (map.hasKey("location")) {
                    ReadableMap map2 = map.getMap("location");
                    if (map2.hasKey("coords")) {
                        ReadableMap map3 = map2.getMap("coords");
                        double d = map3.getDouble("latitude");
                        double d2 = map3.getDouble("longitude");
                        exifInterface.setAttribute("GPSLatitude", O000000o.O000000o(d));
                        exifInterface.setAttribute("GPSLatitudeRef", d < 0.0d ? "S" : "N");
                        exifInterface.setAttribute("GPSLongitude", O000000o.O000000o(d2));
                        exifInterface.setAttribute("GPSLongitudeRef", d2 < 0.0d ? "W" : "E");
                    }
                }
            }
            if (this.O00000Oo) {
                exifInterface.setAttribute("Orientation", "1");
            }
            exifInterface.saveAttributes();
        } catch (ImageProcessingException e) {
        } catch (IOException e2) {
            e = e2;
            Log.e("RNCamera", "failed to save exif data", e);
        }
    }

    /* access modifiers changed from: package-private */
    public final xu O000000o() throws ImageProcessingException, IOException {
        if (this.O00000o == null) {
            this.O00000o = wh.O000000o(new BufferedInputStream(new ByteArrayInputStream(this.O00000o0)), (long) this.O00000o0.length);
        }
        return this.O00000o;
    }

    static byte[] O000000o(Bitmap bitmap, int i) throws OutOfMemoryError {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        try {
            return byteArrayOutputStream.toByteArray();
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                Log.e("RNCamera", "problem compressing jpeg", e);
            }
        }
    }

    public static class ImageMutationFailedException extends Exception {
        public ImageMutationFailedException(String str, Throwable th) {
            super(str, th);
        }

        public ImageMutationFailedException(String str) {
            super(str);
        }
    }

    static class O000000o {
        static String O000000o(double d) {
            double abs = Math.abs(d);
            int i = (int) abs;
            double d2 = (double) i;
            Double.isNaN(d2);
            double d3 = (abs * 60.0d) - (d2 * 60.0d);
            int i2 = (int) d3;
            double d4 = (double) i2;
            Double.isNaN(d4);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(i);
            stringBuffer.append("/1,");
            stringBuffer.append(i2);
            stringBuffer.append("/1,");
            stringBuffer.append((int) (((d3 * 60.0d) - (d4 * 60.0d)) * 1000.0d));
            stringBuffer.append("/1000,");
            return stringBuffer.toString();
        }
    }
}
