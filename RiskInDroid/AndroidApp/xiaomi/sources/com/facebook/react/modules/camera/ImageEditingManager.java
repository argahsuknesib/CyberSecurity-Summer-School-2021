package com.facebook.react.modules.camera;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@ReactModule(name = "ImageEditingManager")
public class ImageEditingManager extends ReactContextBaseJavaModule {
    @SuppressLint({"InlinedApi"})
    private static final String[] EXIF_ATTRIBUTES = {"FNumber", "DateTime", "DateTimeDigitized", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "ImageLength", "ImageWidth", "ISOSpeedRatings", "Make", "Model", "Orientation", "SubSecTime", "SubSecTimeDigitized", "SubSecTimeOriginal", "WhiteBalance"};
    private static final List<String> LOCAL_URI_PREFIXES = Arrays.asList("file://", "content://");

    public String getName() {
        return "ImageEditingManager";
    }

    public ImageEditingManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        new CleanTask(getReactApplicationContext()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public Map<String, Object> getConstants() {
        return Collections.emptyMap();
    }

    public void onCatalystInstanceDestroy() {
        new CleanTask(getReactApplicationContext()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    static class CleanTask extends GuardedAsyncTask<Void, Void> {
        private final Context mContext;

        private CleanTask(ReactContext reactContext) {
            super(reactContext);
            this.mContext = reactContext;
        }

        /* access modifiers changed from: protected */
        public void doInBackgroundGuarded(Void... voidArr) {
            cleanDirectory(this.mContext.getCacheDir());
            File externalCacheDir = this.mContext.getExternalCacheDir();
            if (externalCacheDir != null) {
                cleanDirectory(externalCacheDir);
            }
        }

        private void cleanDirectory(File file) {
            File[] listFiles = file.listFiles(new FilenameFilter() {
                /* class com.facebook.react.modules.camera.ImageEditingManager.CleanTask.AnonymousClass1 */

                public boolean accept(File file, String str) {
                    return str.startsWith("ReactNative_cropped_image_");
                }
            });
            if (listFiles != null) {
                for (File delete : listFiles) {
                    delete.delete();
                }
            }
        }
    }

    @ReactMethod
    public void cropImage(String str, ReadableMap readableMap, Callback callback, Callback callback2) {
        ReadableMap readableMap2 = readableMap;
        ReadableMap readableMap3 = null;
        ReadableMap map = readableMap2.hasKey("offset") ? readableMap2.getMap("offset") : null;
        if (readableMap2.hasKey("size")) {
            readableMap3 = readableMap2.getMap("size");
        }
        if (map == null || readableMap3 == null || !map.hasKey("x") || !map.hasKey("y") || !readableMap3.hasKey("width") || !readableMap3.hasKey("height")) {
            throw new JSApplicationIllegalArgumentException("Please specify offset and size");
        } else if (str == null || str.isEmpty()) {
            throw new JSApplicationIllegalArgumentException("Please specify a URI");
        } else {
            CropTask cropTask = new CropTask(getReactApplicationContext(), str, (int) map.getDouble("x"), (int) map.getDouble("y"), (int) readableMap3.getDouble("width"), (int) readableMap3.getDouble("height"), callback, callback2);
            if (readableMap2.hasKey("displaySize")) {
                ReadableMap map2 = readableMap2.getMap("displaySize");
                cropTask.setTargetSize((int) map2.getDouble("width"), (int) map2.getDouble("height"));
            }
            cropTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    static class CropTask extends GuardedAsyncTask<Void, Void> {
        final Context mContext;
        final Callback mError;
        final int mHeight;
        final Callback mSuccess;
        int mTargetHeight;
        int mTargetWidth;
        final String mUri;
        final int mWidth;
        final int mX;
        final int mY;

        private CropTask(ReactContext reactContext, String str, int i, int i2, int i3, int i4, Callback callback, Callback callback2) {
            super(reactContext);
            this.mTargetWidth = 0;
            this.mTargetHeight = 0;
            if (i < 0 || i2 < 0 || i3 <= 0 || i4 <= 0) {
                throw new JSApplicationIllegalArgumentException(String.format("Invalid crop rectangle: [%d, %d, %d, %d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)));
            }
            this.mContext = reactContext;
            this.mUri = str;
            this.mX = i;
            this.mY = i2;
            this.mWidth = i3;
            this.mHeight = i4;
            this.mSuccess = callback;
            this.mError = callback2;
        }

        public void setTargetSize(int i, int i2) {
            if (i <= 0 || i2 <= 0) {
                throw new JSApplicationIllegalArgumentException(String.format("Invalid target size: [%d, %d]", Integer.valueOf(i), Integer.valueOf(i2)));
            }
            this.mTargetWidth = i;
            this.mTargetHeight = i2;
        }

        private InputStream openBitmapInputStream() throws IOException {
            InputStream inputStream;
            if (ImageEditingManager.isLocalUri(this.mUri)) {
                inputStream = this.mContext.getContentResolver().openInputStream(Uri.parse(this.mUri));
            } else {
                inputStream = new URL(this.mUri).openConnection().getInputStream();
            }
            if (inputStream != null) {
                return inputStream;
            }
            throw new IOException("Cannot open bitmap: " + this.mUri);
        }

        /* access modifiers changed from: protected */
        public void doInBackgroundGuarded(Void... voidArr) {
            Bitmap bitmap;
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                if (this.mTargetWidth > 0 && this.mTargetHeight > 0) {
                    bitmap = cropAndResize(this.mTargetWidth, this.mTargetHeight, options);
                } else {
                    bitmap = crop(options);
                }
                String str = options.outMimeType;
                if (str == null || str.isEmpty()) {
                    throw new IOException("Could not determine MIME type");
                }
                File createTempFile = ImageEditingManager.createTempFile(this.mContext, str);
                ImageEditingManager.writeCompressedBitmapToFile(bitmap, str, createTempFile);
                if (str.equals("image/jpeg")) {
                    ImageEditingManager.copyExif(this.mContext, Uri.parse(this.mUri), createTempFile);
                }
                this.mSuccess.invoke(Uri.fromFile(createTempFile).toString());
            } catch (Exception e) {
                this.mError.invoke(e.getMessage());
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.graphics.BitmapRegionDecoder.newInstance(java.io.InputStream, boolean):android.graphics.BitmapRegionDecoder throws java.io.IOException}
         arg types: [java.io.InputStream, int]
         candidates:
          ClspMth{android.graphics.BitmapRegionDecoder.newInstance(java.io.FileDescriptor, boolean):android.graphics.BitmapRegionDecoder throws java.io.IOException}
          ClspMth{android.graphics.BitmapRegionDecoder.newInstance(java.lang.String, boolean):android.graphics.BitmapRegionDecoder throws java.io.IOException}
          ClspMth{android.graphics.BitmapRegionDecoder.newInstance(java.io.InputStream, boolean):android.graphics.BitmapRegionDecoder throws java.io.IOException} */
        private Bitmap crop(BitmapFactory.Options options) throws IOException {
            InputStream openBitmapInputStream = openBitmapInputStream();
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(openBitmapInputStream, false);
            try {
                return newInstance.decodeRegion(new Rect(this.mX, this.mY, this.mX + this.mWidth, this.mY + this.mHeight), options);
            } finally {
                if (openBitmapInputStream != null) {
                    openBitmapInputStream.close();
                }
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
        private Bitmap cropAndResize(int i, int i2, BitmapFactory.Options options) throws IOException {
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            int i3 = i;
            int i4 = i2;
            BitmapFactory.Options options2 = options;
            Assertions.assertNotNull(options);
            BitmapFactory.Options options3 = new BitmapFactory.Options();
            options3.inJustDecodeBounds = true;
            InputStream openBitmapInputStream = openBitmapInputStream();
            try {
                BitmapFactory.decodeStream(openBitmapInputStream, null, options3);
                if (openBitmapInputStream != null) {
                    openBitmapInputStream.close();
                }
                int i5 = this.mWidth;
                int i6 = this.mHeight;
                float f6 = (float) i3;
                float f7 = (float) i4;
                float f8 = f6 / f7;
                if (((float) i5) / ((float) i6) > f8) {
                    f4 = ((float) i6) * f8;
                    f3 = (float) i6;
                    f = ((float) this.mX) + ((((float) i5) - f4) / 2.0f);
                    f5 = (float) this.mY;
                    f2 = f7 / ((float) i6);
                } else {
                    f4 = (float) i5;
                    float f9 = ((float) i5) / f8;
                    f = (float) this.mX;
                    float f10 = (((float) i6) - f9) / 2.0f;
                    float f11 = f6 / ((float) i5);
                    f3 = f9;
                    f2 = f11;
                    f5 = f10 + ((float) this.mY);
                }
                options2.inSampleSize = ImageEditingManager.getDecodeSampleSize(this.mWidth, this.mHeight, i3, i4);
                options3.inJustDecodeBounds = false;
                InputStream openBitmapInputStream2 = openBitmapInputStream();
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(openBitmapInputStream2, null, options2);
                    if (decodeStream != null) {
                        float f12 = f2 * ((float) options2.inSampleSize);
                        Matrix matrix = new Matrix();
                        matrix.setScale(f12, f12);
                        return Bitmap.createBitmap(decodeStream, (int) Math.floor((double) (f / ((float) options2.inSampleSize))), (int) Math.floor((double) (f5 / ((float) options2.inSampleSize))), (int) Math.floor((double) (f4 / ((float) options2.inSampleSize))), (int) Math.floor((double) (f3 / ((float) options2.inSampleSize))), matrix, true);
                    }
                    throw new IOException("Cannot decode bitmap: " + this.mUri);
                } finally {
                    if (openBitmapInputStream2 != null) {
                        openBitmapInputStream2.close();
                    }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                if (openBitmapInputStream != null) {
                    openBitmapInputStream.close();
                }
                throw th2;
            }
        }
    }

    public static void copyExif(Context context, Uri uri, File file) throws IOException {
        File fileFromUri = getFileFromUri(context, uri);
        if (fileFromUri == null) {
            FLog.w("ReactNative", "Couldn't get real path for uri: ".concat(String.valueOf(uri)));
            return;
        }
        ExifInterface exifInterface = new ExifInterface(fileFromUri.getAbsolutePath());
        ExifInterface exifInterface2 = new ExifInterface(file.getAbsolutePath());
        for (String str : EXIF_ATTRIBUTES) {
            String attribute = exifInterface.getAttribute(str);
            if (attribute != null) {
                exifInterface2.setAttribute(str, attribute);
            }
        }
        exifInterface2.saveAttributes();
    }

    private static File getFileFromUri(Context context, Uri uri) {
        Cursor query;
        if (uri.getScheme().equals("file")) {
            return new File(uri.getPath());
        }
        if (!uri.getScheme().equals("content") || (query = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null)) == null) {
            return null;
        }
        try {
            if (query.moveToFirst()) {
                String string = query.getString(0);
                if (!TextUtils.isEmpty(string)) {
                    return new File(string);
                }
            }
            query.close();
            return null;
        } finally {
            query.close();
        }
    }

    public static boolean isLocalUri(String str) {
        for (String startsWith : LOCAL_URI_PREFIXES) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    private static String getFileExtensionForType(String str) {
        if ("image/png".equals(str)) {
            return ".png";
        }
        return "image/webp".equals(str) ? ".webp" : ".jpg";
    }

    private static Bitmap.CompressFormat getCompressFormatForType(String str) {
        if ("image/png".equals(str)) {
            return Bitmap.CompressFormat.PNG;
        }
        if ("image/webp".equals(str)) {
            return Bitmap.CompressFormat.WEBP;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    public static void writeCompressedBitmapToFile(Bitmap bitmap, String str, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            bitmap.compress(getCompressFormatForType(str), 90, fileOutputStream);
        } finally {
            fileOutputStream.close();
        }
    }

    public static File createTempFile(Context context, String str) throws IOException {
        File externalCacheDir = context.getExternalCacheDir();
        File cacheDir = context.getCacheDir();
        if (externalCacheDir == null && cacheDir == null) {
            throw new IOException("No cache directory available");
        }
        if (externalCacheDir != null && (cacheDir == null || externalCacheDir.getFreeSpace() > cacheDir.getFreeSpace())) {
            cacheDir = externalCacheDir;
        }
        return File.createTempFile("ReactNative_cropped_image_", getFileExtensionForType(str), cacheDir);
    }

    public static int getDecodeSampleSize(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i2 > i3 || i > i4) {
            int i6 = i2 / 2;
            int i7 = i / 2;
            while (i7 / i5 >= i3 && i6 / i5 >= i4) {
                i5 *= 2;
            }
        }
        return i5;
    }
}
