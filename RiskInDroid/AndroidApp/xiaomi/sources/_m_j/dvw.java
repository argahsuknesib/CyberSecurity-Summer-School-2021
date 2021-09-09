package _m_j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.BasePostprocessor;
import java.util.HashMap;
import java.util.Map;

public final class dvw extends BasePostprocessor {

    /* renamed from: O000000o  reason: collision with root package name */
    private Map<Class<?>, uu<?>> f14989O000000o = new HashMap();
    private Context O00000Oo;
    private Class O00000o0;

    public dvw(Context context, Map<Class<?>, uu<?>> map, Class cls) {
        this.O00000Oo = context;
        this.f14989O000000o = map;
        this.O00000o0 = cls;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008b  */
    public final CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        CloseableReference<Bitmap> closeableReference = null;
        try {
            uu O000000o2 = O000000o();
            if (O000000o2 != null) {
                copy = (Bitmap) O000000o2.O000000o(this.O00000Oo, new uy(copy), copy.getWidth(), copy.getHeight()).O000000o();
            }
            int width2 = copy.getWidth();
            int height2 = copy.getHeight();
            if (width == width2) {
                if (height == height2) {
                    return super.process(bitmap, platformBitmapFactory);
                }
            }
            CloseableReference<Bitmap> createBitmap = platformBitmapFactory.createBitmap(width2, height2);
            try {
                Bitmap bitmap2 = createBitmap.get();
                new Canvas(bitmap2).drawBitmap(copy, (Rect) null, new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight()), new Paint());
                CloseableReference<Bitmap> cloneOrNull = CloseableReference.cloneOrNull(createBitmap);
                if (createBitmap != null) {
                    CloseableReference.closeSafely(createBitmap);
                }
                return cloneOrNull;
            } catch (Exception e) {
                closeableReference = createBitmap;
                e = e;
                try {
                    e.printStackTrace();
                    CloseableReference<Bitmap> process = super.process(bitmap, platformBitmapFactory);
                    if (closeableReference != null) {
                    }
                    return process;
                } catch (Throwable th) {
                    th = th;
                    if (closeableReference != null) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                closeableReference = createBitmap;
                if (closeableReference != null) {
                    CloseableReference.closeSafely(closeableReference);
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            CloseableReference<Bitmap> process2 = super.process(bitmap, platformBitmapFactory);
            if (closeableReference != null) {
                CloseableReference.closeSafely(closeableReference);
            }
            return process2;
        }
    }

    public final void process(Bitmap bitmap, Bitmap bitmap2) {
        Bitmap bitmap22 = null;
        try {
            uu O000000o2 = O000000o();
            if (O000000o2 != null) {
                bitmap22 = (Bitmap) O000000o2.O000000o(this.O00000Oo, new uy(bitmap22), bitmap22.getWidth(), bitmap22.getHeight()).O000000o();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            super.process(bitmap, bitmap22);
        }
    }

    private <Z> uu<Z> O000000o() {
        uu<Z> uuVar = this.f14989O000000o.get(Drawable.class);
        if (uuVar == null) {
            uuVar = this.f14989O000000o.get(Bitmap.class);
        }
        if (uuVar != null || !this.f14989O000000o.isEmpty()) {
            return uuVar;
        }
        throw new IllegalArgumentException("Missing transformation for " + this.O00000o0 + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }
}
