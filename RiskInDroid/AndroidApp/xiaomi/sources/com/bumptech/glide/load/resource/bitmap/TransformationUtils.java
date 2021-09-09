package com.bumptech.glide.load.resource.bitmap;

import _m_j.gsy;
import _m_j.ux;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class TransformationUtils {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Paint f3572O000000o = new Paint(6);
    private static final Paint O00000Oo = new Paint(7);
    private static final Set<String> O00000o;
    private static final Paint O00000o0;
    private static final Lock O00000oO;

    static {
        HashSet hashSet = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));
        O00000o = hashSet;
        O00000oO = hashSet.contains(Build.MODEL) ? new ReentrantLock() : new NoLock();
        Paint paint = new Paint(7);
        O00000o0 = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public static Bitmap O000000o(ux uxVar, Bitmap bitmap, int i, int i2) {
        float f;
        float f2;
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f3 = 0.0f;
        if (bitmap.getWidth() * i2 > bitmap.getHeight() * i) {
            f2 = ((float) i2) / ((float) bitmap.getHeight());
            f = (((float) i) - (((float) bitmap.getWidth()) * f2)) * 0.5f;
        } else {
            f2 = ((float) i) / ((float) bitmap.getWidth());
            f3 = (((float) i2) - (((float) bitmap.getHeight()) * f2)) * 0.5f;
            f = 0.0f;
        }
        matrix.setScale(f2, f2);
        matrix.postTranslate((float) ((int) (f + 0.5f)), (float) ((int) (f3 + 0.5f)));
        Bitmap O000000o2 = uxVar.O000000o(i, i2, O00000Oo(bitmap));
        O000000o(bitmap, O000000o2);
        O000000o(bitmap, O000000o2, matrix);
        return O000000o2;
    }

    public static Bitmap O00000Oo(ux uxVar, Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                gsy.O000000o(2, "TransformationUtils", "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float min = Math.min(((float) i) / ((float) bitmap.getWidth()), ((float) i2) / ((float) bitmap.getHeight()));
        int round = Math.round(((float) bitmap.getWidth()) * min);
        int round2 = Math.round(((float) bitmap.getHeight()) * min);
        if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                gsy.O000000o(2, "TransformationUtils", "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap O000000o2 = uxVar.O000000o((int) (((float) bitmap.getWidth()) * min), (int) (((float) bitmap.getHeight()) * min), O00000Oo(bitmap));
        O000000o(bitmap, O000000o2);
        if (Log.isLoggable("TransformationUtils", 2)) {
            gsy.O000000o(2, "TransformationUtils", "request: " + i + "x" + i2);
            gsy.O000000o(2, "TransformationUtils", "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
            gsy.O000000o(2, "TransformationUtils", "toReuse: " + O000000o2.getWidth() + "x" + O000000o2.getHeight());
            gsy.O000000o(2, "TransformationUtils", "minPct:   ".concat(String.valueOf(min)));
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        O000000o(bitmap, O000000o2, matrix);
        return O000000o2;
    }

    public static Bitmap O00000o0(ux uxVar, Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                gsy.O000000o(2, "TransformationUtils", "requested target size too big for input, fit centering instead");
            }
            return O00000Oo(uxVar, bitmap, i, i2);
        }
        if (Log.isLoggable("TransformationUtils", 2)) {
            gsy.O000000o(2, "TransformationUtils", "requested target size larger or equal to input, returning input");
        }
        return bitmap;
    }

    private static void O000000o(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }

    /* JADX INFO: finally extract failed */
    public static Bitmap O00000o(ux uxVar, Bitmap bitmap, int i, int i2) {
        Bitmap bitmap2;
        int min = Math.min(i, i2);
        float f = (float) min;
        float f2 = f / 2.0f;
        float width = (float) bitmap.getWidth();
        float height = (float) bitmap.getHeight();
        float max = Math.max(f / width, f / height);
        float f3 = width * max;
        float f4 = max * height;
        float f5 = (f - f3) / 2.0f;
        float f6 = (f - f4) / 2.0f;
        RectF rectF = new RectF(f5, f6, f3 + f5, f4 + f6);
        Bitmap.Config O000000o2 = O000000o(bitmap);
        if (O000000o2.equals(bitmap.getConfig())) {
            bitmap2 = bitmap;
        } else {
            bitmap2 = uxVar.O000000o(bitmap.getWidth(), bitmap.getHeight(), O000000o2);
            new Canvas(bitmap2).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
        Bitmap O000000o3 = uxVar.O000000o(min, min, O000000o(bitmap));
        O000000o3.setHasAlpha(true);
        O00000oO.lock();
        try {
            Canvas canvas = new Canvas(O000000o3);
            canvas.drawCircle(f2, f2, f2, O00000Oo);
            canvas.drawBitmap(bitmap2, (Rect) null, rectF, O00000o0);
            canvas.setBitmap(null);
            O00000oO.unlock();
            bitmap2.equals(bitmap);
            return O000000o3;
        } catch (Throwable th) {
            O00000oO.unlock();
            throw th;
        }
    }

    private static Bitmap.Config O000000o(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) {
            return Bitmap.Config.ARGB_8888;
        }
        return Bitmap.Config.RGBA_F16;
    }

    private static Bitmap.Config O00000Oo(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    private static void O000000o(Bitmap bitmap, Bitmap bitmap2, Matrix matrix) {
        O00000oO.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f3572O000000o);
            canvas.setBitmap(null);
        } finally {
            O00000oO.unlock();
        }
    }

    static final class NoLock implements Lock {
        public final void lock() {
        }

        public final void lockInterruptibly() throws InterruptedException {
        }

        public final boolean tryLock() {
            return true;
        }

        public final boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        public final void unlock() {
        }

        NoLock() {
        }

        public final Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }
    }
}
