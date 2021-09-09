package _m_j;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;

public final class dad extends daf {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f14415O000000o = 0;
    private int O00000Oo = 0;
    private Path O00000o0 = new Path();

    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (!(this.f14415O000000o == width && this.O00000Oo == height)) {
            int i = (width * 30) / 225;
            this.O00000o0.reset();
            double d = (double) i;
            double sin = Math.sin(0.7853981633974483d);
            Double.isNaN(d);
            float f = (float) (sin * d);
            double sin2 = Math.sin(0.7853981633974483d);
            Double.isNaN(d);
            int i2 = width / 2;
            float f2 = (float) height;
            this.O00000o0.moveTo((float) i2, f2);
            float f3 = (float) (height / 2);
            this.O00000o0.lineTo(0.0f, f3);
            float f4 = f3 - f;
            this.O00000o0.lineTo(f, f4);
            int i3 = i / 2;
            float f5 = (float) (i2 - i3);
            float f6 = (f2 - ((float) (d / sin2))) - ((float) i3);
            this.O00000o0.lineTo(f5, f6);
            this.O00000o0.lineTo(f5, 0.0f);
            float f7 = (float) (i2 + i3);
            this.O00000o0.lineTo(f7, 0.0f);
            this.O00000o0.lineTo(f7, f6);
            float f8 = (float) width;
            this.O00000o0.lineTo(f8 - f, f4);
            this.O00000o0.lineTo(f8, f3);
            this.O00000o0.close();
            this.f14415O000000o = width;
            this.O00000Oo = height;
        }
        canvas.drawPath(this.O00000o0, this.O0000o00);
    }
}
