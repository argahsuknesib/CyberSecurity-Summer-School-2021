package _m_j;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import com.facebook.imagepipeline.request.BasePostprocessor;

public final class gnz extends BasePostprocessor {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f18066O000000o = 1;
    private int O00000Oo;
    private Paint O00000o0 = new Paint();

    public gnz(int i) {
        this.O00000Oo = i;
        this.O00000o0.setColor(this.O00000Oo);
        this.O00000o0.setAntiAlias(true);
        this.O00000o0.setStrokeWidth(1.0f);
        this.O00000o0.setStyle(Paint.Style.STROKE);
    }

    public final void process(Bitmap bitmap, Bitmap bitmap2) {
        int width = bitmap2.getWidth();
        int height = bitmap2.getHeight();
        Canvas canvas = new Canvas(bitmap);
        bitmap.setHasAlpha(true);
        bitmap.eraseColor(0);
        Path path = new Path();
        float f = (float) width;
        float f2 = (float) height;
        path.addCircle((f - 1.0f) / 2.0f, (f2 - 1.0f) / 2.0f, Math.min(f, f2) / 2.0f, Path.Direction.CCW);
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap2, new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight()), new Rect(0, 0, width, height), (Paint) null);
    }
}
