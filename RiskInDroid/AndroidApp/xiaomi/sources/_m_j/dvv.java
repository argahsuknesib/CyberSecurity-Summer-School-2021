package _m_j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.BaseRepeatedPostProcessor;
import com.squareup.picasso.Transformation;
import com.xiaomi.image.ImageLoaderOptions;
import java.util.List;

public final class dvv extends BaseRepeatedPostProcessor {

    /* renamed from: O000000o  reason: collision with root package name */
    private List<Transformation> f14988O000000o;
    private Context O00000Oo;
    private View O00000o;
    private String O00000o0;
    private ImageLoaderOptions O00000oO;
    private CacheKey O00000oo;

    public dvv(Context context, List<Transformation> list, String str, View view, ImageLoaderOptions imageLoaderOptions) {
        this.O00000Oo = context;
        this.f14988O000000o = list;
        this.O00000o0 = str;
        this.O00000o = view;
        this.O00000oO = imageLoaderOptions;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0107  */
    public final CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
        CloseableReference<Bitmap> closeableReference;
        float f;
        float f2;
        float f3;
        float f4;
        int i;
        int i2;
        int i3;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        int width2 = copy.getWidth();
        int height2 = copy.getHeight();
        Matrix matrix = new Matrix();
        if (this.O00000oO.O0000O0o != null && this.O00000oO.O0000O0o.f5979O000000o > 0 && this.O00000oO.O0000O0o.O00000Oo > 0) {
            int i4 = this.O00000oO.O0000O0o.f5979O000000o;
            int i5 = this.O00000oO.O0000O0o.O00000Oo;
            if (i4 != 0) {
                f2 = (float) i4;
                f = (float) width2;
            } else {
                f2 = (float) i5;
                f = (float) height2;
            }
            float f5 = f2 / f;
            if (i5 != 0) {
                f4 = (float) i5;
                f3 = (float) height2;
            } else {
                f4 = (float) i4;
                f3 = (float) width2;
            }
            float f6 = f4 / f3;
            if (f5 > f6) {
                int ceil = (int) Math.ceil((double) (((float) height2) * (f6 / f5)));
                f6 = ((float) i5) / ((float) ceil);
                i2 = (height2 - ceil) / 2;
                i = ceil;
                i3 = 0;
            } else {
                if (f5 < f6) {
                    int ceil2 = (int) Math.ceil((double) (((float) width2) * (f5 / f6)));
                    f5 = ((float) i4) / ((float) ceil2);
                    i3 = (width2 - ceil2) / 2;
                    i = height2;
                    width2 = ceil2;
                } else {
                    i = height2;
                    f5 = f6;
                    i3 = 0;
                }
                i2 = 0;
            }
            matrix.preScale(f5, f6);
            Bitmap createBitmap = Bitmap.createBitmap(copy, i3, i2, width2, i, matrix, true);
            if (createBitmap != copy) {
                copy.recycle();
                copy = createBitmap;
            }
        }
        try {
            for (Transformation next : this.f14988O000000o) {
                if (next != null) {
                    copy = next.transform(copy);
                }
            }
            int width3 = copy.getWidth();
            int height3 = copy.getHeight();
            if (width == width3) {
                if (height == height3) {
                    return super.process(bitmap, platformBitmapFactory);
                }
            }
            closeableReference = platformBitmapFactory.createBitmap(copy.getWidth(), copy.getHeight());
            try {
                Bitmap bitmap2 = closeableReference.get();
                new Canvas(bitmap2).drawBitmap(copy, (Rect) null, new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight()), new Paint());
                CloseableReference<Bitmap> cloneOrNull = CloseableReference.cloneOrNull(closeableReference);
                if (closeableReference != null) {
                    CloseableReference.closeSafely(closeableReference);
                }
                return cloneOrNull;
            } catch (Throwable th) {
                th = th;
                if (closeableReference != null) {
                    CloseableReference.closeSafely(closeableReference);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            closeableReference = null;
            if (closeableReference != null) {
            }
            throw th;
        }
    }

    public final void process(Bitmap bitmap, Bitmap bitmap2) {
        Bitmap bitmap22 = bitmap22.copy(bitmap22.getConfig(), true);
        try {
            for (Transformation next : this.f14988O000000o) {
                if (next != null) {
                    bitmap22 = next.transform(bitmap22);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            super.process(bitmap, bitmap22);
        }
    }

    public final CacheKey getPostprocessorCacheKey() {
        if (this.O00000oo == null) {
            this.O00000oo = new SimpleCacheKey("PicassoTransformPostprocessor" + this.f14988O000000o.get(0).key() + this.f14988O000000o.size() + " url: " + this.O00000o0);
        }
        return this.O00000oo;
    }
}
