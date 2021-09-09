package _m_j;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.BasePostprocessor;

public class gny extends BasePostprocessor {
    public void process(Bitmap bitmap, Bitmap bitmap2) {
        int width = bitmap2.getWidth();
        int height = bitmap2.getHeight();
        bitmap.setHasAlpha(true);
        bitmap.eraseColor(0);
        Canvas canvas = new Canvas(bitmap);
        Path path = new Path();
        float f = (float) width;
        float f2 = (float) height;
        path.addCircle((f - 1.0f) / 2.0f, (f2 - 1.0f) / 2.0f, Math.min(f, f2) / 2.0f, Path.Direction.CCW);
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap2, new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight()), new Rect(0, 0, width, height), (Paint) null);
    }

    public CacheKey getPostprocessorCacheKey() {
        return new O000000o(gny.class.getName());
    }

    class O000000o implements CacheKey {

        /* renamed from: O000000o  reason: collision with root package name */
        String f18065O000000o;

        public final boolean containsUri(Uri uri) {
            return false;
        }

        public final String getUriString() {
            return null;
        }

        O000000o(String str) {
            this.f18065O000000o = String.valueOf(str);
        }

        public final boolean equals(Object obj) {
            if (obj instanceof O000000o) {
                return this.f18065O000000o.equalsIgnoreCase(((O000000o) obj).f18065O000000o);
            }
            return false;
        }

        public final int hashCode() {
            return this.f18065O000000o.hashCode();
        }
    }
}
