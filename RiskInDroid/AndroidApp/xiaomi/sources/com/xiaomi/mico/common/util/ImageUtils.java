package com.xiaomi.mico.common.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.ExifInterface;

public class ImageUtils {
    private ImageUtils() {
    }

    public static Bitmap reduceBitmapSize(long j, Bitmap bitmap) {
        try {
            int rowBytes = bitmap.getRowBytes() * bitmap.getHeight();
            double d = 1.0d;
            Bitmap bitmap2 = null;
            while (((long) rowBytes) > j) {
                if (bitmap2 != null && !bitmap2.equals(bitmap)) {
                    bitmap2.recycle();
                }
                double width = (double) bitmap.getWidth();
                Double.isNaN(width);
                int i = (int) (width * d);
                double height = (double) bitmap.getHeight();
                Double.isNaN(height);
                bitmap2 = Bitmap.createScaledBitmap(bitmap, i, (int) (height * d), true);
                rowBytes = bitmap2.getRowBytes() * bitmap2.getHeight();
                d *= 0.8999999761581421d;
            }
            return bitmap2 == null ? bitmap : bitmap2;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    public static Bitmap getRotatedBitmap(String str, Bitmap bitmap) {
        int i = 0;
        try {
            i = (int) ImageExifUtils.exifOrientationToDegrees(new ExifInterface(str).getAttributeInt("Orientation", 1));
        } catch (Exception e) {
            new Object[1][0] = e.getMessage();
        }
        if (i == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (createBitmap == bitmap) {
            return createBitmap;
        }
        bitmap.recycle();
        return createBitmap;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    public static Bitmap rotate(Bitmap bitmap, int i) {
        int i2 = i % 360;
        if (i2 == 0 || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate((float) i2, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (bitmap == createBitmap) {
                return bitmap;
            }
            bitmap.recycle();
            return createBitmap;
        } catch (OutOfMemoryError unused) {
            return bitmap;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c7  */
    public static Bitmap transform(Matrix matrix, Bitmap bitmap, int i, int i2, boolean z) {
        Matrix matrix2;
        Bitmap bitmap2;
        Matrix matrix3 = matrix;
        Bitmap bitmap3 = bitmap;
        int i3 = i;
        int i4 = i2;
        int width = bitmap.getWidth() - i3;
        int height = bitmap.getHeight() - i4;
        if (z || (width >= 0 && height >= 0)) {
            float width2 = (float) bitmap.getWidth();
            float height2 = (float) bitmap.getHeight();
            float f = (float) i3;
            float f2 = (float) i4;
            if (width2 / height2 > f / f2) {
                float f3 = f2 / height2;
                if (f3 < 0.9f || f3 > 1.0f) {
                    matrix.setScale(f3, f3);
                    matrix2 = matrix3;
                    if (matrix2 != null) {
                        bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix2, true);
                    } else {
                        bitmap2 = bitmap3;
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap2, Math.max(0, bitmap2.getWidth() - i3) / 2, Math.max(0, bitmap2.getHeight() - i4) / 2, i3, i4);
                    if (bitmap2 != bitmap3) {
                        bitmap2.recycle();
                    }
                    return createBitmap;
                }
            } else {
                float f4 = f / width2;
                if (f4 < 0.9f || f4 > 1.0f) {
                    matrix.setScale(f4, f4);
                    matrix2 = matrix3;
                    if (matrix2 != null) {
                    }
                    Bitmap createBitmap2 = Bitmap.createBitmap(bitmap2, Math.max(0, bitmap2.getWidth() - i3) / 2, Math.max(0, bitmap2.getHeight() - i4) / 2, i3, i4);
                    if (bitmap2 != bitmap3) {
                    }
                    return createBitmap2;
                }
            }
            matrix2 = null;
            if (matrix2 != null) {
            }
            Bitmap createBitmap22 = Bitmap.createBitmap(bitmap2, Math.max(0, bitmap2.getWidth() - i3) / 2, Math.max(0, bitmap2.getHeight() - i4) / 2, i3, i4);
            if (bitmap2 != bitmap3) {
            }
            return createBitmap22;
        }
        Bitmap createBitmap3 = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap3);
        int max = Math.max(0, width / 2);
        int max2 = Math.max(0, height / 2);
        Rect rect = new Rect(max, max2, Math.min(i3, bitmap.getWidth()) + max, Math.min(i4, bitmap.getHeight()) + max2);
        int width3 = (i3 - rect.width()) / 2;
        int height3 = (i4 - rect.height()) / 2;
        canvas.drawBitmap(bitmap, rect, new Rect(width3, height3, i3 - width3, i4 - height3), (Paint) null);
        return createBitmap3;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public static <T> int indexOf(T[] r2, T r3) {
        /*
            r0 = 0
        L_0x0001:
            int r1 = r2.length
            if (r0 >= r1) goto L_0x0010
            r1 = r2[r0]
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x000d
            return r0
        L_0x000d:
            int r0 = r0 + 1
            goto L_0x0001
        L_0x0010:
            r2 = -1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mico.common.util.ImageUtils.indexOf(java.lang.Object[], java.lang.Object):int");
    }

    public static boolean floatEquals(float f, float f2) {
        return Math.abs(f - f2) <= 1.0E-7f;
    }

    public static boolean doubleEquals(double d, double d2) {
        return Math.abs(d - d2) <= 1.0E-7d;
    }

    public static boolean isGif(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return "image/gif".equals(options.outMimeType);
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 >= i2 && i7 / i5 >= i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    public static Bitmap decodeSampledBitmapFromResource(String str, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = calculateInSampleSize(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }
}
