package _m_j;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import java.io.File;

public final class gpj {
    public static Bitmap O000000o(String str) {
        if (str != null && new File(str).exists()) {
            return BitmapFactory.decodeFile(str);
        }
        return null;
    }

    public static int O00000Oo(String str) {
        ExifInterface exifInterface;
        int attributeInt;
        try {
            exifInterface = new ExifInterface(str);
        } catch (Exception unused) {
            exifInterface = null;
        }
        if (!(exifInterface == null || (attributeInt = exifInterface.getAttributeInt("Orientation", -1)) == -1)) {
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    public static Bitmap O000000o(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        if (width > height) {
            float f = 150.0f / ((float) width);
            matrix.postScale(f, f);
        } else {
            float f2 = 150.0f / ((float) height);
            matrix.postScale(f2, f2);
        }
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }
}
