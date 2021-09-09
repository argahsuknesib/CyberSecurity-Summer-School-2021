package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.DisplayMetrics;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;

public abstract class PlatformBitmapFactory {
    private static BitmapCreationObserver sBitmapCreationObserver;

    public interface BitmapCreationObserver {
        void onBitmapCreated(Bitmap bitmap, Object obj);
    }

    public abstract CloseableReference<Bitmap> createBitmapInternal(int i, int i2, Bitmap.Config config);

    public CloseableReference<Bitmap> createBitmap(int i, int i2, Bitmap.Config config) {
        return createBitmap(i, i2, config, (Object) null);
    }

    public CloseableReference<Bitmap> createBitmap(int i, int i2) {
        return createBitmap(i, i2, Bitmap.Config.ARGB_8888);
    }

    public CloseableReference<Bitmap> createBitmap(int i, int i2, Bitmap.Config config, Object obj) {
        CloseableReference<Bitmap> createBitmapInternal = createBitmapInternal(i, i2, config);
        addBitmapReference(createBitmapInternal.get(), obj);
        return createBitmapInternal;
    }

    public CloseableReference<Bitmap> createBitmap(int i, int i2, Object obj) {
        return createBitmap(i, i2, Bitmap.Config.ARGB_8888, obj);
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap) {
        return createBitmap(bitmap, (Object) null);
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap, Object obj) {
        return createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), obj);
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap, int i, int i2, int i3, int i4) {
        return createBitmap(bitmap, i, i2, i3, i4, (Object) null);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean, java.lang.Object):com.facebook.common.references.CloseableReference<android.graphics.Bitmap>
     arg types: [android.graphics.Bitmap, int, int, int, int, ?[OBJECT, ARRAY], int, java.lang.Object]
     candidates:
      com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config, java.lang.Object):com.facebook.common.references.CloseableReference<android.graphics.Bitmap>
      com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean, java.lang.Object):com.facebook.common.references.CloseableReference<android.graphics.Bitmap> */
    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap, int i, int i2, int i3, int i4, Object obj) {
        return createBitmap(bitmap, i, i2, i3, i4, (Matrix) null, false, obj);
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap, int i, int i2, int i3, int i4, Matrix matrix, boolean z) {
        return createBitmap(bitmap, i, i2, i3, i4, matrix, z, (Object) null);
    }

    public CloseableReference<Bitmap> createScaledBitmap(Bitmap bitmap, int i, int i2, boolean z) {
        return createScaledBitmap(bitmap, i, i2, z, null);
    }

    public CloseableReference<Bitmap> createScaledBitmap(Bitmap bitmap, int i, int i2, boolean z, Object obj) {
        checkWidthHeight(i, i2);
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        matrix.setScale(((float) i) / ((float) width), ((float) i2) / ((float) height));
        return createBitmap(bitmap, 0, 0, width, height, matrix, z, obj);
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap, int i, int i2, int i3, int i4, Matrix matrix, boolean z, Object obj) {
        CloseableReference<Bitmap> closeableReference;
        Paint paint;
        Bitmap bitmap2 = bitmap;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        Matrix matrix2 = matrix;
        Preconditions.checkNotNull(bitmap2, "Source bitmap cannot be null");
        checkXYSign(i, i2);
        checkWidthHeight(i3, i4);
        checkFinalImageBounds(bitmap, i, i2, i3, i4);
        Canvas canvas = new Canvas();
        Rect rect = new Rect(i5, i6, i5 + i7, i6 + i8);
        RectF rectF = new RectF(0.0f, 0.0f, (float) i7, (float) i8);
        Bitmap.Config suitableBitmapConfig = getSuitableBitmapConfig(bitmap);
        if (matrix2 == null || matrix.isIdentity()) {
            closeableReference = createBitmap(i3, i4, suitableBitmapConfig, bitmap.hasAlpha(), obj);
            paint = null;
        } else {
            boolean z2 = !matrix.rectStaysRect();
            RectF rectF2 = new RectF();
            matrix2.mapRect(rectF2, rectF);
            int round = Math.round(rectF2.width());
            int round2 = Math.round(rectF2.height());
            if (z2) {
                suitableBitmapConfig = Bitmap.Config.ARGB_8888;
            }
            closeableReference = createBitmap(round, round2, suitableBitmapConfig, z2 || bitmap.hasAlpha(), obj);
            canvas.translate(-rectF2.left, -rectF2.top);
            canvas.concat(matrix2);
            paint = new Paint();
            paint.setFilterBitmap(z);
            if (z2) {
                paint.setAntiAlias(true);
            }
        }
        Bitmap bitmap3 = closeableReference.get();
        bitmap3.setDensity(bitmap.getDensity());
        if (Build.VERSION.SDK_INT >= 12) {
            bitmap3.setHasAlpha(bitmap.hasAlpha());
        }
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap3.setPremultiplied(bitmap.isPremultiplied());
        }
        canvas.setBitmap(bitmap3);
        canvas.drawBitmap(bitmap2, rect, rectF, paint);
        canvas.setBitmap(null);
        return closeableReference;
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int i, int i2, Bitmap.Config config) {
        return createBitmap(displayMetrics, i, i2, config, (Object) null);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory.createBitmap(android.util.DisplayMetrics, int, int, android.graphics.Bitmap$Config, boolean, java.lang.Object):com.facebook.common.references.CloseableReference<android.graphics.Bitmap>
     arg types: [android.util.DisplayMetrics, int, int, android.graphics.Bitmap$Config, int, java.lang.Object]
     candidates:
      com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory.createBitmap(android.graphics.Bitmap, int, int, int, int, java.lang.Object):com.facebook.common.references.CloseableReference<android.graphics.Bitmap>
      com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory.createBitmap(android.util.DisplayMetrics, int[], int, int, android.graphics.Bitmap$Config, java.lang.Object):com.facebook.common.references.CloseableReference<android.graphics.Bitmap>
      com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory.createBitmap(android.util.DisplayMetrics, int, int, android.graphics.Bitmap$Config, boolean, java.lang.Object):com.facebook.common.references.CloseableReference<android.graphics.Bitmap> */
    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int i, int i2, Bitmap.Config config, Object obj) {
        return createBitmap(displayMetrics, i, i2, config, true, obj);
    }

    private CloseableReference<Bitmap> createBitmap(int i, int i2, Bitmap.Config config, boolean z) {
        return createBitmap(i, i2, config, z, (Object) null);
    }

    private CloseableReference<Bitmap> createBitmap(int i, int i2, Bitmap.Config config, boolean z, Object obj) {
        return createBitmap((DisplayMetrics) null, i, i2, config, z, obj);
    }

    private CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int i, int i2, Bitmap.Config config, boolean z) {
        return createBitmap(displayMetrics, i, i2, config, z, (Object) null);
    }

    private CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int i, int i2, Bitmap.Config config, boolean z, Object obj) {
        checkWidthHeight(i, i2);
        CloseableReference<Bitmap> createBitmapInternal = createBitmapInternal(i, i2, config);
        Bitmap bitmap = createBitmapInternal.get();
        if (displayMetrics != null) {
            bitmap.setDensity(displayMetrics.densityDpi);
        }
        if (Build.VERSION.SDK_INT >= 12) {
            bitmap.setHasAlpha(z);
        }
        if (config == Bitmap.Config.ARGB_8888 && !z) {
            bitmap.eraseColor(-16777216);
        }
        addBitmapReference(createBitmapInternal.get(), obj);
        return createBitmapInternal;
    }

    public CloseableReference<Bitmap> createBitmap(int[] iArr, int i, int i2, Bitmap.Config config) {
        return createBitmap(iArr, i, i2, config, (Object) null);
    }

    public CloseableReference<Bitmap> createBitmap(int[] iArr, int i, int i2, Bitmap.Config config, Object obj) {
        CloseableReference<Bitmap> createBitmapInternal = createBitmapInternal(i, i2, config);
        createBitmapInternal.get().setPixels(iArr, 0, i, 0, 0, i, i2);
        addBitmapReference(createBitmapInternal.get(), obj);
        return createBitmapInternal;
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int[] iArr, int i, int i2, Bitmap.Config config) {
        return createBitmap(displayMetrics, iArr, i, i2, config, (Object) null);
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int[] iArr, int i, int i2, Bitmap.Config config, Object obj) {
        return createBitmap(displayMetrics, iArr, 0, i, i, i2, config, obj);
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int[] iArr, int i, int i2, int i3, int i4, Bitmap.Config config) {
        return createBitmap(displayMetrics, iArr, i, i2, i3, i4, config, (Object) null);
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int[] iArr, int i, int i2, int i3, int i4, Bitmap.Config config, Object obj) {
        CloseableReference<Bitmap> createBitmap = createBitmap(displayMetrics, i3, i4, config, obj);
        createBitmap.get().setPixels(iArr, i, i2, 0, 0, i3, i4);
        return createBitmap;
    }

    private static Bitmap.Config getSuitableBitmapConfig(Bitmap bitmap) {
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Bitmap.Config config2 = bitmap.getConfig();
        if (config2 == null) {
            return config;
        }
        int i = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config2.ordinal()];
        if (i == 1) {
            return Bitmap.Config.RGB_565;
        }
        if (i != 2) {
            return Bitmap.Config.ARGB_8888;
        }
        return Bitmap.Config.ALPHA_8;
    }

    /* renamed from: com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config = new int[Bitmap.Config.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 1;
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ALPHA_8.ordinal()] = 2;
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_8888.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private static void checkWidthHeight(int i, int i2) {
        boolean z = true;
        Preconditions.checkArgument(i > 0, "width must be > 0");
        if (i2 <= 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "height must be > 0");
    }

    private static void checkXYSign(int i, int i2) {
        boolean z = true;
        Preconditions.checkArgument(i >= 0, "x must be >= 0");
        if (i2 < 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "y must be >= 0");
    }

    private static void checkFinalImageBounds(Bitmap bitmap, int i, int i2, int i3, int i4) {
        boolean z = true;
        Preconditions.checkArgument(i + i3 <= bitmap.getWidth(), "x + width must be <= bitmap.width()");
        if (i2 + i4 > bitmap.getHeight()) {
            z = false;
        }
        Preconditions.checkArgument(z, "y + height must be <= bitmap.height()");
    }

    public void setCreationListener(BitmapCreationObserver bitmapCreationObserver) {
        if (sBitmapCreationObserver == null) {
            sBitmapCreationObserver = bitmapCreationObserver;
        }
    }

    public void addBitmapReference(Bitmap bitmap, Object obj) {
        BitmapCreationObserver bitmapCreationObserver = sBitmapCreationObserver;
        if (bitmapCreationObserver != null) {
            bitmapCreationObserver.onBitmapCreated(bitmap, obj);
        }
    }
}
