package com.xiaomi.mico.common.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

public class BitmapUtil {
    public static Bitmap circle(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        int width = (bitmap.getWidth() - min) / 2;
        int height = (bitmap.getHeight() - min) / 2;
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        if (!(width == 0 && height == 0)) {
            Matrix matrix = new Matrix();
            matrix.setTranslate((float) (-width), (float) (-height));
            bitmapShader.setLocalMatrix(matrix);
        }
        paint.setShader(bitmapShader);
        paint.setAntiAlias(true);
        float f = ((float) min) / 2.0f;
        canvas.drawCircle(f, f, f, paint);
        bitmap.recycle();
        return createBitmap;
    }

    public static Bitmap blur(Context context, Bitmap bitmap, int i, int i2) throws RSRuntimeException {
        int width = bitmap.getWidth() / i;
        int height = bitmap.getHeight() / i;
        if (width == 0 || height == 0) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        float f = 1.0f / ((float) i);
        canvas.scale(f, f);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        RenderScript renderScript = null;
        try {
            renderScript = RenderScript.create(context);
            Allocation createFromBitmap = Allocation.createFromBitmap(renderScript, createBitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
            Allocation createTyped = Allocation.createTyped(renderScript, createFromBitmap.getType());
            ScriptIntrinsicBlur create = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
            create.setInput(createFromBitmap);
            create.setRadius((float) i2);
            create.forEach(createTyped);
            createTyped.copyTo(createBitmap);
            bitmap.recycle();
            return createBitmap;
        } finally {
            if (renderScript != null) {
                renderScript.destroy();
            }
        }
    }

    public static Bitmap roundCornerImage(Bitmap bitmap, int i) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        float f = (float) i;
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, (Rect) null, rect, paint);
        bitmap.recycle();
        return createBitmap;
    }

    private static Bitmap.Config getConfig(Bitmap bitmap) {
        Bitmap.Config config = bitmap.getConfig();
        return config == null ? Bitmap.Config.ARGB_8888 : config;
    }

    public static Bitmap resizeBitmapByScale(Bitmap bitmap, float f, float f2, boolean z) {
        int round = Math.round(((float) bitmap.getWidth()) * f);
        int round2 = Math.round(((float) bitmap.getHeight()) * f2);
        if (round == bitmap.getWidth() && round2 == bitmap.getHeight()) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(round, round2, getConfig(bitmap));
        Canvas canvas = new Canvas(createBitmap);
        canvas.scale(f, f2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, new Paint(6));
        if (z) {
            bitmap.recycle();
        }
        return createBitmap;
    }
}
