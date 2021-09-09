package _m_j;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.xiaomi.smarthome.svg.PreserveAspectRatio;
import com.xiaomi.smarthome.svg.SVG;

public class hyn extends Drawable {

    /* renamed from: O000000o  reason: collision with root package name */
    private final SVG f993O000000o;
    private PreserveAspectRatio O00000Oo = PreserveAspectRatio.O00000o;
    private hyj O00000o0;

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public hyn(SVG svg) {
        this.f993O000000o = svg;
    }

    public hyn(Context context, int i) {
        SVG svg;
        try {
            svg = SVG.O000000o(context, i);
        } catch (Exception unused) {
            svg = new SVG();
        }
        this.f993O000000o = svg;
    }

    public void draw(Canvas canvas) {
        SVG svg = this.f993O000000o;
        if (svg != null) {
            PreserveAspectRatio preserveAspectRatio = this.O00000Oo;
            RectF rectF = new RectF(getBounds());
            hyj hyj = this.O00000o0;
            if (hyj == null) {
                hyj = hyj.O00000o0;
            }
            svg.O000000o(canvas, preserveAspectRatio, rectF, hyj);
        }
    }

    public hyn O000000o(hyj hyj) {
        this.O00000o0 = hyj;
        return this;
    }

    public int getIntrinsicWidth() {
        SVG svg = this.f993O000000o;
        if (svg == null) {
            return 0;
        }
        return (int) svg.O000000o();
    }

    public int getIntrinsicHeight() {
        SVG svg = this.f993O000000o;
        if (svg == null) {
            return 0;
        }
        return (int) svg.O00000Oo();
    }
}
