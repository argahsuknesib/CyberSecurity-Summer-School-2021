package _m_j;

import _m_j.izx;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;

public final class jaf extends izx.O00000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    private Path f1694O000000o;
    private float[] O00000Oo;

    public jaf(float[] fArr) {
        this.O00000Oo = fArr;
    }

    public final void O000000o(int i, int i2) {
        if (this.O00000Oo == null) {
            this.f1694O000000o = null;
            return;
        }
        Path path = this.f1694O000000o;
        if (path == null) {
            this.f1694O000000o = new Path();
        } else {
            path.reset();
        }
        if (Build.VERSION.SDK_INT < 21) {
            this.f1694O000000o.addRoundRect(new RectF(0.0f, 0.0f, (float) i, (float) i2), this.O00000Oo, Path.Direction.CW);
        } else {
            this.f1694O000000o.addRoundRect(0.0f, 0.0f, (float) i, (float) i2, this.O00000Oo, Path.Direction.CW);
        }
    }

    public final boolean O000000o(Canvas canvas) {
        return canvas.clipPath(this.f1694O000000o);
    }
}
