package com.lwansbrough.RCTCamera;

import _m_j.dx;
import _m_j.wh;
import _m_j.xr;
import _m_j.xu;
import _m_j.xw;
import _m_j.ym;
import _m_j.yt;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Base64;
import android.util.Log;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.MetadataException;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.exoplayer2.C;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MutableImage {
    private Bitmap currentRepresentation;
    private boolean hasBeenReoriented = false;
    private boolean hasBeenScaled = false;
    private final byte[] originalImageData;
    private xu originalImageMetaData;

    public MutableImage(byte[] bArr) {
        this.originalImageData = bArr;
        this.currentRepresentation = toBitmap(bArr);
    }

    public int getWidth() {
        return this.currentRepresentation.getWidth();
    }

    public int getHeight() {
        return this.currentRepresentation.getHeight();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    public void mirrorImage() throws ImageMutationFailedException {
        Matrix matrix = new Matrix();
        matrix.preScale(-1.0f, 1.0f);
        Bitmap createBitmap = Bitmap.createBitmap(this.currentRepresentation, 0, 0, getWidth(), getHeight(), matrix, false);
        if (createBitmap != null) {
            this.currentRepresentation = createBitmap;
            return;
        }
        throw new ImageMutationFailedException("failed to mirror");
    }

    public void fixOrientation() throws ImageMutationFailedException {
        int O00000Oo;
        try {
            ym ymVar = (ym) originalImageMetaData().O000000o(ym.class);
            if (ymVar != null && ymVar.O000000o(274) && (O00000Oo = ymVar.O00000Oo(274)) != 1) {
                rotate(O00000Oo);
                ymVar.O000000o(274, 1);
            }
        } catch (ImageProcessingException | MetadataException | IOException e) {
            throw new ImageMutationFailedException("failed to fix orientation", e);
        }
    }

    public void cropToPreview(double d) throws IllegalArgumentException {
        int i;
        int i2;
        int width = getWidth();
        int height = getHeight();
        double d2 = (double) height;
        Double.isNaN(d2);
        double d3 = d2 * d;
        double d4 = (double) width;
        if (d3 > d4) {
            Double.isNaN(d4);
            i = (int) (d4 / d);
            i2 = width;
        } else {
            i2 = (int) d3;
            i = height;
        }
        this.currentRepresentation = Bitmap.createBitmap(this.currentRepresentation, (width - i2) / 2, (height - i) / 2, i2, i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    private void rotate(int i) throws ImageMutationFailedException {
        Matrix matrix = new Matrix();
        switch (i) {
            case 1:
                return;
            case 2:
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.postRotate(180.0f);
                break;
            case 4:
                matrix.postRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.postRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.postRotate(90.0f);
                break;
            case 7:
                matrix.postRotate(270.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                matrix.postRotate(270.0f);
                break;
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.currentRepresentation, 0, 0, getWidth(), getHeight(), matrix, false);
        if (createBitmap != null) {
            this.currentRepresentation = createBitmap;
            this.hasBeenReoriented = true;
            return;
        }
        throw new ImageMutationFailedException("failed to rotate");
    }

    private static Bitmap toBitmap(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            Bitmap decodeStream = BitmapFactory.decodeStream(byteArrayInputStream);
            byteArrayInputStream.close();
            return decodeStream;
        } catch (IOException e) {
            throw new IllegalStateException("Will not happen", e);
        }
    }

    public String toBase64(int i, int i2, int i3) {
        return Base64.encodeToString(toJpeg(this.currentRepresentation, i, i2, i3), 0);
    }

    public void writeDataToFile(File file, ReadableMap readableMap, int i, int i2, int i3) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(toJpeg(this.currentRepresentation, i, i2, i3));
        fileOutputStream.close();
        try {
            dx dxVar = new dx(file.getAbsolutePath());
            for (xr xrVar : originalImageMetaData().f2599O000000o) {
                for (xw next : xrVar.O00000o()) {
                    dxVar.O000000o(next.O000000o(), xrVar.O0000o0o(next.f2601O000000o).toString());
                }
            }
            yt ytVar = (yt) originalImageMetaData().O000000o(yt.class);
            for (xw next2 : ytVar.O00000o()) {
                int i4 = next2.f2601O000000o;
                String replaceAll = next2.O000000o().replaceAll(" ", "");
                Object O0000o0o = ytVar.O0000o0o(i4);
                if (replaceAll.equals("ExposureTime")) {
                    dxVar.O000000o(replaceAll, convertExposureTimeToDoubleFormat(O0000o0o.toString()));
                } else {
                    dxVar.O000000o(replaceAll, O0000o0o.toString());
                }
            }
            writeLocationExifData(readableMap, dxVar);
            if (this.hasBeenReoriented) {
                rewriteOrientation(dxVar);
            }
            dxVar.O000000o();
        } catch (ImageProcessingException | IOException e) {
            Log.e("RNCamera", "failed to save exif data", e);
        }
    }

    private String convertExposureTimeToDoubleFormat(String str) {
        if (!str.contains("/")) {
            return "";
        }
        return Double.toString(1.0d / Double.parseDouble(str.split("/")[1]));
    }

    private void rewriteOrientation(dx dxVar) {
        dxVar.O000000o("Orientation", "1");
    }

    private void writeLocationExifData(ReadableMap readableMap, dx dxVar) {
        if (readableMap.hasKey("metadata")) {
            ReadableMap map = readableMap.getMap("metadata");
            if (map.hasKey("location")) {
                ReadableMap map2 = map.getMap("location");
                if (map2.hasKey("coords")) {
                    try {
                        ReadableMap map3 = map2.getMap("coords");
                        GPS.writeExifData(map3.getDouble("latitude"), map3.getDouble("longitude"), dxVar);
                    } catch (IOException e) {
                        Log.e("RNCamera", "Couldn't write location data", e);
                    }
                }
            }
        }
    }

    private xu originalImageMetaData() throws ImageProcessingException, IOException {
        if (this.originalImageMetaData == null) {
            this.originalImageMetaData = wh.O000000o(new BufferedInputStream(new ByteArrayInputStream(this.originalImageData)), (long) this.originalImageData.length);
        }
        return this.originalImageMetaData;
    }

    private byte[] toJpeg(Bitmap bitmap, int i, int i2, int i3) throws OutOfMemoryError {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (i3 <= 0 || i2 <= 0) {
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        } else {
            Bitmap scale = scale(bitmap, i2, i3);
            scale.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
            this.currentRepresentation = scale;
            this.hasBeenScaled = true;
        }
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

    public static Bitmap scale(Bitmap bitmap, int i, int i2) throws OutOfMemoryError {
        float max = (i2 <= 0 || i <= 0) ? 1.0f : Math.max(((float) bitmap.getWidth()) / ((float) i), ((float) bitmap.getHeight()) / ((float) i2));
        if (max <= 1.0f) {
            return bitmap;
        }
        int width = (int) (((float) bitmap.getWidth()) / max);
        int height = (int) (((float) bitmap.getHeight()) / max);
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        new Canvas(createBitmap).drawBitmap(bitmap, (Rect) null, new Rect(0, 0, width, height), (Paint) null);
        return createBitmap;
    }

    public static class ImageMutationFailedException extends Exception {
        public ImageMutationFailedException(String str, Throwable th) {
            super(str, th);
        }

        public ImageMutationFailedException(String str) {
            super(str);
        }
    }

    static class GPS {
        private static String latitudeRef(double d) {
            return d < 0.0d ? "S" : "N";
        }

        private static String longitudeRef(double d) {
            return d < 0.0d ? "W" : "E";
        }

        private GPS() {
        }

        public static void writeExifData(double d, double d2, dx dxVar) throws IOException {
            dxVar.O000000o("GPSLatitude", toDegreeMinuteSecods(d));
            dxVar.O000000o("GPSLatitudeRef", latitudeRef(d));
            dxVar.O000000o("GPSLongitude", toDegreeMinuteSecods(d2));
            dxVar.O000000o("GPSLongitudeRef", longitudeRef(d2));
        }

        private static String toDegreeMinuteSecods(double d) {
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
