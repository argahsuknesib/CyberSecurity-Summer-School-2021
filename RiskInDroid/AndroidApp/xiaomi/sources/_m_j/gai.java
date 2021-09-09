package _m_j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class gai {
    @SuppressLint({"InlinedApi"})

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String[] f17460O000000o = {"FNumber", "DateTime", "DateTimeDigitized", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "ImageLength", "ImageWidth", "ISOSpeedRatings", "Make", "Model", "Orientation", "SubSecTime", "SubSecTimeDigitized", "SubSecTimeOriginal", "WhiteBalance"};

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f17461O000000o = 0;
        public int O00000Oo = 0;
        public int O00000o = 0;
        public int O00000o0 = 0;
        public int O00000oO = 0;
        public int O00000oo = 0;
    }

    public static void O000000o(ReactContext reactContext, String str, File file, O000000o o000000o, gbh<String> gbh) {
        O00000Oo o00000Oo = new O00000Oo(reactContext, str, file, o000000o.f17461O000000o, o000000o.O00000Oo, o000000o.O00000o0, o000000o.O00000o, gbh, (byte) 0);
        if (o000000o.O00000oO > 0 && o000000o.O00000oo > 0) {
            int i = o000000o.O00000oO;
            int i2 = o000000o.O00000oo;
            if (i <= 0 || i2 <= 0) {
                throw new JSApplicationIllegalArgumentException(String.format("Invalid target size: [%d, %d]", Integer.valueOf(i), Integer.valueOf(i2)));
            } else {
                o00000Oo.O0000OOo = i;
                o00000Oo.O0000Oo0 = i2;
            }
        }
        o00000Oo.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    static class O00000Oo extends GuardedAsyncTask<Void, Void> {

        /* renamed from: O000000o  reason: collision with root package name */
        final Context f17462O000000o;
        File O00000Oo;
        final int O00000o;
        File O00000o0;
        final int O00000oO;
        final int O00000oo;
        final int O0000O0o;
        int O0000OOo;
        final gbh<String> O0000Oo;
        int O0000Oo0;

        /* synthetic */ O00000Oo(ReactContext reactContext, String str, File file, int i, int i2, int i3, int i4, gbh gbh, byte b) {
            this(reactContext, str, file, i, i2, i3, i4, gbh);
        }

        private O00000Oo(ReactContext reactContext, String str, File file, int i, int i2, int i3, int i4, gbh<String> gbh) {
            super(reactContext);
            this.O0000OOo = 0;
            this.O0000Oo0 = 0;
            if (i < 0 || i2 < 0 || i3 <= 0 || i4 <= 0) {
                throw new JSApplicationIllegalArgumentException(String.format("Invalid crop rectangle: [%d, %d, %d, %d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)));
            }
            this.f17462O000000o = reactContext;
            this.O00000Oo = file;
            this.O00000o = i;
            this.O00000oO = i2;
            this.O00000oo = i3;
            this.O0000O0o = i4;
            this.O0000Oo = gbh;
            this.O00000o0 = new File(str);
        }

        private InputStream O000000o() throws IOException {
            return new FileInputStream(this.O00000o0);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.graphics.BitmapRegionDecoder.newInstance(java.io.InputStream, boolean):android.graphics.BitmapRegionDecoder throws java.io.IOException}
         arg types: [java.io.InputStream, int]
         candidates:
          ClspMth{android.graphics.BitmapRegionDecoder.newInstance(java.io.FileDescriptor, boolean):android.graphics.BitmapRegionDecoder throws java.io.IOException}
          ClspMth{android.graphics.BitmapRegionDecoder.newInstance(java.lang.String, boolean):android.graphics.BitmapRegionDecoder throws java.io.IOException}
          ClspMth{android.graphics.BitmapRegionDecoder.newInstance(java.io.InputStream, boolean):android.graphics.BitmapRegionDecoder throws java.io.IOException} */
        private Bitmap O000000o(BitmapFactory.Options options) throws IOException {
            InputStream O000000o2 = O000000o();
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(O000000o2, false);
            try {
                return newInstance.decodeRegion(new Rect(this.O00000o, this.O00000oO, this.O00000o + this.O00000oo, this.O00000oO + this.O0000O0o), options);
            } finally {
                O000000o2.close();
                newInstance.recycle();
            }
        }

        /* JADX INFO: finally extract failed */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
         arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
         candidates:
          ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
          ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
        private Bitmap O000000o(int i, int i2, BitmapFactory.Options options) throws IOException {
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            int i3 = i;
            int i4 = i2;
            BitmapFactory.Options options2 = options;
            Assertions.assertNotNull(options);
            int i5 = this.O00000oo;
            int i6 = this.O0000O0o;
            float f6 = (float) i3;
            float f7 = (float) i4;
            float f8 = f6 / f7;
            if (((float) i5) / ((float) i6) > f8) {
                f4 = ((float) i6) * f8;
                f3 = (float) i6;
                f = ((float) this.O00000o) + ((((float) i5) - f4) / 2.0f);
                f5 = (float) this.O00000oO;
                f2 = f7 / ((float) i6);
            } else {
                f4 = (float) i5;
                float f9 = ((float) i5) / f8;
                f = (float) this.O00000o;
                float f10 = (((float) i6) - f9) / 2.0f;
                float f11 = f6 / ((float) i5);
                f3 = f9;
                f2 = f11;
                f5 = f10 + ((float) this.O00000oO);
            }
            options2.inSampleSize = gai.O000000o(this.O00000oo, this.O0000O0o, i3, i4);
            InputStream O000000o2 = O000000o();
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(O000000o2, null, options2);
                if (decodeStream != null) {
                    O000000o2.close();
                    int round = Math.round(f / ((float) options2.inSampleSize));
                    int round2 = Math.round(f5 / ((float) options2.inSampleSize));
                    int round3 = Math.round(f4 / ((float) options2.inSampleSize));
                    int round4 = Math.round(f3 / ((float) options2.inSampleSize));
                    float f12 = f2 * ((float) options2.inSampleSize);
                    Matrix matrix = new Matrix();
                    matrix.setScale(f12, f12);
                    return Bitmap.createBitmap(decodeStream, round, round2, round3, round4, matrix, true);
                }
                throw new IOException("Cannot decode bitmap: " + this.O00000o0);
            } catch (Throwable th) {
                O000000o2.close();
                throw th;
            }
        }

        public final /* synthetic */ void doInBackgroundGuarded(Object[] objArr) {
            Bitmap bitmap;
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                if (this.O0000OOo > 0 && this.O0000Oo0 > 0) {
                    bitmap = O000000o(this.O0000OOo, this.O0000Oo0, options);
                } else {
                    bitmap = O000000o(options);
                }
                String str = options.outMimeType;
                if (str == null || str.isEmpty()) {
                    throw new IOException("Could not determine MIME type");
                }
                gai.O000000o(bitmap, str, this.O00000Oo);
                if (str.equals("image/jpeg")) {
                    gai.O000000o(this.O00000o0, this.O00000Oo);
                }
                this.O0000Oo.O000000o(Uri.fromFile(this.O00000Oo).toString());
            } catch (Exception e) {
                gsy.O00000o0(LogType.PLUGIN, "ImageEditor", e.getMessage());
                this.O0000Oo.O000000o("unknown Error");
            }
        }
    }

    public static void O000000o(File file, File file2) throws IOException {
        if (file != null) {
            ExifInterface exifInterface = new ExifInterface(file.getAbsolutePath());
            ExifInterface exifInterface2 = new ExifInterface(file2.getAbsolutePath());
            for (String str : f17460O000000o) {
                String attribute = exifInterface.getAttribute(str);
                if (attribute != null) {
                    exifInterface2.setAttribute(str, attribute);
                }
            }
            exifInterface2.saveAttributes();
        }
    }

    public static void O000000o(Bitmap bitmap, String str, File file) throws IOException {
        Bitmap.CompressFormat compressFormat;
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            if ("image/png".equals(str)) {
                compressFormat = Bitmap.CompressFormat.PNG;
            } else if ("image/webp".equals(str)) {
                compressFormat = Bitmap.CompressFormat.WEBP;
            } else {
                compressFormat = Bitmap.CompressFormat.JPEG;
            }
            bitmap.compress(compressFormat, 90, fileOutputStream);
        } finally {
            fileOutputStream.close();
        }
    }

    public static int O000000o(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i2 > i4 || i > i3) {
            int i6 = i2 / 2;
            int i7 = i / 2;
            while (i7 / i5 >= i3 && i6 / i5 >= i4) {
                i5 *= 2;
            }
        }
        return i5;
    }

    public static O000000o O000000o(ReadableMap readableMap) {
        ReadableMap map;
        O000000o o000000o = null;
        ReadableMap map2 = readableMap.hasKey("offset") ? readableMap.getMap("offset") : null;
        ReadableMap map3 = readableMap.hasKey("size") ? readableMap.getMap("size") : null;
        if (map2 != null && map3 != null && map2.hasKey("x") && map2.hasKey("y") && map3.hasKey("width") && map3.hasKey("height")) {
            o000000o = new O000000o();
            o000000o.f17461O000000o = (int) map2.getDouble("x");
            o000000o.O00000Oo = (int) map2.getDouble("y");
            o000000o.O00000o0 = (int) map3.getDouble("width");
            o000000o.O00000o = (int) map3.getDouble("height");
            if (readableMap.hasKey("displaySize") && (map = readableMap.getMap("displaySize")) != null) {
                o000000o.O00000oO = (int) map.getDouble("width");
                o000000o.O00000oo = (int) map.getDouble("height");
            }
        }
        return o000000o;
    }
}
