package com.miui.tsmclient.common.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.YuvImage;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.Log;
import android.view.View;
import com.miui.tsmclient.util.IOUtils;
import com.miui.tsmclient.util.LogUtils;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ImageUtils {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    private ImageUtils() {
    }

    public static int parseImageDegree(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return 270;
        } catch (Exception e) {
            Log.e(com.xiaomi.smarthome.miio.camera.face.util.ImageUtils.TAG, "parseImageDegree: ".concat(String.valueOf(e)));
            return 0;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    public static Bitmap rotate(Bitmap bitmap, int i) {
        Bitmap bitmap2;
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        try {
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError e) {
            LogUtils.e("rotate failed", e);
            bitmap2 = null;
        }
        if (bitmap2 == null) {
            bitmap2 = bitmap;
        }
        if (bitmap != bitmap2) {
            bitmap.recycle();
        }
        return bitmap2;
    }

    public static byte[] rotate(byte[] bArr, int i, int i2, int i3) {
        if (i3 == 0) {
            return bArr;
        }
        if (i3 == 90) {
            return rotateYUV420Degree90(bArr, i, i2);
        }
        if (i3 == 180) {
            return rotateYUV420Degree180(bArr, i, i2);
        }
        if (i3 == 270) {
            return rotateYUV420Degree270(bArr, i, i2);
        }
        throw new IllegalArgumentException("invalid rotate angle");
    }

    public static byte[] rotateYUV420Degree90(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = (i3 * 3) / 2;
        byte[] bArr2 = new byte[i4];
        int i5 = 0;
        for (int i6 = 0; i6 < i; i6++) {
            for (int i7 = i2 - 1; i7 >= 0; i7--) {
                bArr2[i5] = bArr[(i7 * i) + i6];
                i5++;
            }
        }
        int i8 = i4 - 1;
        int i9 = i - 1;
        while (i9 > 0) {
            int i10 = i8;
            for (int i11 = 0; i11 < i2 / 2; i11++) {
                int i12 = (i11 * i) + i3;
                bArr2[i10] = bArr[i12 + i9];
                int i13 = i10 - 1;
                bArr2[i13] = bArr[i12 + (i9 - 1)];
                i10 = i13 - 1;
            }
            i9 -= 2;
            i8 = i10;
        }
        return bArr2;
    }

    public static byte[] rotateYUV420Degree180(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = (i3 * 3) / 2;
        byte[] bArr2 = new byte[i4];
        int i5 = 0;
        for (int i6 = i3 - 1; i6 >= 0; i6--) {
            bArr2[i5] = bArr[i6];
            i5++;
        }
        for (int i7 = i4 - 1; i7 >= i3; i7 -= 2) {
            int i8 = i5 + 1;
            bArr2[i5] = bArr[i7 - 1];
            i5 = i8 + 1;
            bArr2[i8] = bArr[i7];
        }
        return bArr2;
    }

    public static byte[] rotateYUV420Degree270(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        byte[] bArr2 = new byte[((i3 * 3) / 2)];
        int i4 = i - 1;
        int i5 = i4;
        int i6 = 0;
        while (i5 >= 0) {
            int i7 = i6;
            int i8 = 0;
            for (int i9 = 0; i9 < i2; i9++) {
                bArr2[i7] = bArr[i8 + i5];
                i7++;
                i8 += i;
            }
            i5--;
            i6 = i7;
        }
        int i10 = i3;
        while (i4 > 0) {
            int i11 = i3;
            int i12 = i10;
            for (int i13 = 0; i13 < i2 / 2; i13++) {
                bArr2[i12] = bArr[(i4 - 1) + i11];
                int i14 = i12 + 1;
                bArr2[i14] = bArr[i11 + i4];
                i12 = i14 + 1;
                i11 += i;
            }
            i4 -= 2;
            i10 = i12;
        }
        return bArr2;
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    public static byte[] bmpToByteArray(Bitmap bitmap) {
        return bmpToByteArray(bitmap, 80);
    }

    public static byte[] bmpToByteArray(Bitmap bitmap, int i) {
        if (bitmap == null || bitmap.isRecycled()) {
            return EMPTY_BYTE_ARRAY;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            Log.e(com.xiaomi.smarthome.miio.camera.face.util.ImageUtils.TAG, "bmp2byteArr failed", e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static Bitmap clipToRoundRectBitmap(Bitmap bitmap, int i, int i2, int i3) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        RectF rectF = new RectF(0.0f, 0.0f, (float) i, (float) i2);
        Paint paint = new Paint(1);
        paint.setColor(-65536);
        float f = (float) i3;
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        bitmapDrawable.setBounds(0, 0, i, i2);
        canvas.saveLayer(rectF, paint, 31);
        bitmapDrawable.draw(canvas);
        canvas.restore();
        return createBitmap;
    }

    public static Bitmap compressBitmap(Context context, Uri uri, int i, int i2) throws IOException {
        InputStream openInputStream = context.getContentResolver().openInputStream(uri);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(openInputStream, null, options);
        openInputStream.close();
        if (options.outWidth == -1 || options.outHeight == -1) {
            return null;
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inSampleSize = calculateInSampleSize(options, i, i2);
        InputStream openInputStream2 = context.getContentResolver().openInputStream(uri);
        Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream2, null, options2);
        openInputStream2.close();
        return decodeStream;
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 > i2 && i7 / i5 > i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003b, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003c, code lost:
        r5 = r11;
        r8 = r4;
        r4 = r10;
        r10 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0044, code lost:
        r10 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0045, code lost:
        r5 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0072, code lost:
        android.util.Log.e(com.xiaomi.smarthome.miio.camera.face.util.ImageUtils.TAG, "saveJPEG error, remove the output file.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x007d, code lost:
        android.util.Log.e(com.xiaomi.smarthome.miio.camera.face.util.ImageUtils.TAG, "delete file failed");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:5:0x0019] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0072 A[Catch:{ Exception -> 0x0081 }] */
    public boolean save(Bitmap bitmap, String str) {
        File file;
        BufferedOutputStream bufferedOutputStream;
        boolean z = false;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            file = new File(str);
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            } catch (Exception e) {
                e = e;
                try {
                    Log.e(com.xiaomi.smarthome.miio.camera.face.util.ImageUtils.TAG, "save bitmap exception", e);
                    try {
                        IOUtils.closeQuietly((OutputStream) bufferedOutputStream2);
                        Log.e(com.xiaomi.smarthome.miio.camera.face.util.ImageUtils.TAG, "saveJPEG error, remove the output file.");
                        Log.e(com.xiaomi.smarthome.miio.camera.face.util.ImageUtils.TAG, "delete file failed");
                    } catch (Exception e2) {
                        Log.e(com.xiaomi.smarthome.miio.camera.face.util.ImageUtils.TAG, "close BufferedOutputStream exception", e2);
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    try {
                        IOUtils.closeQuietly((OutputStream) bufferedOutputStream2);
                        if (!z) {
                        }
                    } catch (Exception e3) {
                        Log.e(com.xiaomi.smarthome.miio.camera.face.util.ImageUtils.TAG, "close BufferedOutputStream exception", e3);
                    }
                    throw th;
                }
            }
            try {
                boolean compress = bitmap.compress(Bitmap.CompressFormat.JPEG, 90, bufferedOutputStream);
                bufferedOutputStream.flush();
                try {
                    IOUtils.closeQuietly((OutputStream) bufferedOutputStream);
                    if (compress) {
                        return compress;
                    }
                    Log.e(com.xiaomi.smarthome.miio.camera.face.util.ImageUtils.TAG, "saveJPEG error, remove the output file.");
                    if (file.delete()) {
                        return compress;
                    }
                    Log.e(com.xiaomi.smarthome.miio.camera.face.util.ImageUtils.TAG, "delete file failed");
                    return compress;
                } catch (Exception e4) {
                    Log.e(com.xiaomi.smarthome.miio.camera.face.util.ImageUtils.TAG, "close BufferedOutputStream exception", e4);
                    return compress;
                }
            } catch (Exception e5) {
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream2 = bufferedOutputStream;
                IOUtils.closeQuietly((OutputStream) bufferedOutputStream2);
                if (!z) {
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            file = null;
            Log.e(com.xiaomi.smarthome.miio.camera.face.util.ImageUtils.TAG, "save bitmap exception", e);
            IOUtils.closeQuietly((OutputStream) bufferedOutputStream2);
            Log.e(com.xiaomi.smarthome.miio.camera.face.util.ImageUtils.TAG, "saveJPEG error, remove the output file.");
            Log.e(com.xiaomi.smarthome.miio.camera.face.util.ImageUtils.TAG, "delete file failed");
            return false;
        } catch (Throwable th3) {
            th = th3;
            file = null;
            IOUtils.closeQuietly((OutputStream) bufferedOutputStream2);
            if (!z) {
            }
            throw th;
        }
    }

    public static Bitmap fastBlur(Context context, Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        RenderScript create = RenderScript.create(context);
        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
        Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
        Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
        create2.setRadius(25.0f);
        create2.setInput(createFromBitmap);
        create2.forEach(createFromBitmap2);
        createFromBitmap2.copyTo(createBitmap);
        create.destroy();
        return createBitmap;
    }

    public static Bitmap getScreenShot(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public static boolean saveN21(byte[] bArr, int i, int i2, String str) {
        boolean z = false;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(new File(str)));
            try {
                z = yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 90, bufferedOutputStream2);
                IOUtils.closeQuietly((OutputStream) bufferedOutputStream2);
            } catch (FileNotFoundException e) {
                e = e;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    LogUtils.e("saveN21 error occurred", e);
                    IOUtils.closeQuietly((OutputStream) bufferedOutputStream);
                    return z;
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuietly((OutputStream) bufferedOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = bufferedOutputStream2;
                IOUtils.closeQuietly((OutputStream) bufferedOutputStream);
                throw th;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
            LogUtils.e("saveN21 error occurred", e);
            IOUtils.closeQuietly((OutputStream) bufferedOutputStream);
            return z;
        }
        return z;
    }
}
