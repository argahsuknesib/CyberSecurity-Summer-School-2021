package com.google.android.gms.internal.vision;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public final class zzm {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    public static Bitmap zzb(Bitmap bitmap, zzk zzk) {
        int i;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (zzk.rotation != 0) {
            Matrix matrix = new Matrix();
            int i2 = zzk.rotation;
            if (i2 == 0) {
                i = 0;
            } else if (i2 == 1) {
                i = 90;
            } else if (i2 == 2) {
                i = 180;
            } else if (i2 == 3) {
                i = 270;
            } else {
                throw new IllegalArgumentException("Unsupported rotation degree.");
            }
            matrix.postRotate((float) i);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        }
        if (zzk.rotation == 1 || zzk.rotation == 3) {
            zzk.width = height;
            zzk.height = width;
        }
        return bitmap;
    }
}
