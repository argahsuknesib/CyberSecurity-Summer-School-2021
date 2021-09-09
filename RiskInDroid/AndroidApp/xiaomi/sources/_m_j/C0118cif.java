package _m_j;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Build;
import android.provider.MediaStore;
import com.xiaomi.smarthome.R;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: _m_j.cif  reason: case insensitive filesystem */
public final class C0118cif {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    public static Bitmap O000000o(Bitmap bitmap, Context context) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), R.drawable.mijia_logo);
        if (bitmap.getWidth() <= 640) {
            Matrix matrix = new Matrix();
            matrix.setScale(0.33333334f, 0.33333334f);
            Bitmap createBitmap2 = Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix, true);
            canvas.drawBitmap(createBitmap2, 0.0f, (float) (height - createBitmap2.getHeight()), (Paint) null);
            canvas.save();
            canvas.restore();
            decodeResource.recycle();
            createBitmap2.recycle();
        } else {
            canvas.drawBitmap(decodeResource, 0.0f, (float) (height - decodeResource.getHeight()), (Paint) null);
            canvas.save();
            canvas.restore();
            decodeResource.recycle();
        }
        bitmap.recycle();
        return createBitmap;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.me.O000000o(boolean, java.lang.String):java.lang.String
     arg types: [int, java.lang.String]
     candidates:
      _m_j.me.O000000o(java.lang.String, java.lang.String):java.lang.String
      _m_j.me.O000000o(boolean, java.lang.String):java.lang.String */
    public static String O000000o(Bitmap bitmap, String str) {
        String O000000o2;
        if (bitmap == null || (O000000o2 = me.O000000o(false, str)) == null) {
            return null;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(O000000o2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.close();
            return O000000o2;
        } catch (IOException unused) {
            return null;
        }
    }

    public static boolean O000000o(Context context, String str) {
        ContentValues contentValues = new ContentValues(4);
        contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("_data", str);
        contentValues.put("mime_type", "image/jpeg");
        try {
            if (!Build.MODEL.equals("HM 1SC")) {
                context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            }
            gsy.O00000Oo("BitmapUtils", "snap success");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
