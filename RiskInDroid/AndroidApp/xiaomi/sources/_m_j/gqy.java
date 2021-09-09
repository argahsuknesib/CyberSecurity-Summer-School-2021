package _m_j;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import com.xiaomi.smarthome.application.ServiceApplication;
import java.io.Closeable;
import java.io.File;

public final class gqy {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f18166O000000o = new File(ServiceApplication.getApplication().getExternalFilesDir(".temp"), "cropTemp.jpg").getAbsolutePath();

    public static void O000000o(Activity activity, String str, Runnable runnable, Handler handler) {
        new Thread(new O000000o(activity, runnable, ProgressDialog.show(activity, null, str, true, false), handler)).start();
    }

    static class O000000o implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        public final ProgressDialog f18167O000000o;
        private final Activity O00000Oo;
        private final Handler O00000o;
        private final Runnable O00000o0;
        private final Runnable O00000oO = new Runnable() {
            /* class _m_j.gqy.O000000o.AnonymousClass1 */

            public final void run() {
                if (O000000o.this.f18167O000000o.getWindow() != null) {
                    O000000o.this.f18167O000000o.dismiss();
                }
            }
        };

        public O000000o(Activity activity, Runnable runnable, ProgressDialog progressDialog, Handler handler) {
            this.O00000Oo = activity;
            this.f18167O000000o = progressDialog;
            this.O00000o0 = runnable;
            this.O00000o = handler;
        }

        public final void run() {
            try {
                this.O00000o0.run();
            } finally {
                this.O00000o.post(this.O00000oO);
            }
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
    public static Bitmap O000000o(Matrix matrix, Bitmap bitmap, int i, int i2, boolean z) {
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

    public static void O000000o(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
