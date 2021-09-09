package com.xiaomi.smarthome.miio.camera.face.util;

import _m_j.civ;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.View;
import com.xiaomi.smarthome.miio.camera.face.widget.CameraCircleView;

public class ImageUtils {
    public static final String TAG = "ImageUtils";

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    public static Bitmap getRotatedBitmap(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
    }

    public static Bitmap getCroped(Bitmap bitmap, CameraCircleView cameraCircleView, View view) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        String str = TAG;
        civ.O000000o(str, width + "-" + height);
        if (height > width) {
            civ.O000000o(TAG, "diff=".concat(String.valueOf((((float) height) * cameraCircleView.offset) / ((float) view.getMeasuredHeight()))));
            return Bitmap.createBitmap(bitmap, 0, 0, width, width);
        }
        int i = (width - height) / 2;
        civ.O000000o(TAG, "diff=".concat(String.valueOf(i)));
        return Bitmap.createBitmap(bitmap, i, 0, height, height);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    public static Bitmap getFlipBitmap(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.setScale(-1.0f, 1.0f);
        matrix.postTranslate((float) bitmap.getWidth(), 0.0f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
    }
}
