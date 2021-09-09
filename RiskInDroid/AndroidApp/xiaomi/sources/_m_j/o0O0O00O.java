package _m_j;

import _m_j.o0O0O0o0;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public class o0O0O00O implements o0O0oo0o {

    /* renamed from: O000000o  reason: collision with root package name */
    final RectF f2233O000000o = new RectF();

    public final void O0000O0o(o0oO0O0o o0oo0o0o) {
    }

    public void O000000o() {
        o0O0O0o0.f2236O000000o = new o0O0O0o0.O000000o() {
            /* class _m_j.o0O0O00O.AnonymousClass1 */

            public final void O000000o(Canvas canvas, RectF rectF, float f, Paint paint) {
                Canvas canvas2 = canvas;
                RectF rectF2 = rectF;
                float f2 = 2.0f * f;
                float width = (rectF.width() - f2) - 1.0f;
                float height = (rectF.height() - f2) - 1.0f;
                if (f >= 1.0f) {
                    float f3 = f + 0.5f;
                    float f4 = -f3;
                    o0O0O00O.this.f2233O000000o.set(f4, f4, f3, f3);
                    int save = canvas.save();
                    canvas2.translate(rectF2.left + f3, rectF2.top + f3);
                    Paint paint2 = paint;
                    canvas.drawArc(o0O0O00O.this.f2233O000000o, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(width, 0.0f);
                    canvas2.rotate(90.0f);
                    canvas.drawArc(o0O0O00O.this.f2233O000000o, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(height, 0.0f);
                    canvas2.rotate(90.0f);
                    canvas.drawArc(o0O0O00O.this.f2233O000000o, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(width, 0.0f);
                    canvas2.rotate(90.0f);
                    canvas.drawArc(o0O0O00O.this.f2233O000000o, 180.0f, 90.0f, true, paint2);
                    canvas2.restoreToCount(save);
                    canvas.drawRect((rectF2.left + f3) - 1.0f, rectF2.top, (rectF2.right - f3) + 1.0f, rectF2.top + f3, paint2);
                    canvas.drawRect((rectF2.left + f3) - 1.0f, rectF2.bottom - f3, (rectF2.right - f3) + 1.0f, rectF2.bottom, paint2);
                }
                canvas.drawRect(rectF2.left, rectF2.top + f, rectF2.right, rectF2.bottom - f, paint);
            }
        };
    }

    public final void O00000oo(o0oO0O0o o0oo0o0o) {
        Rect rect = new Rect();
        O0000Oo(o0oo0o0o).getPadding(rect);
        o0oo0o0o.O000000o((int) Math.ceil((double) O0000Oo(o0oo0o0o).O000000o()), (int) Math.ceil((double) O0000Oo(o0oo0o0o).O00000Oo()));
        o0oo0o0o.O000000o(rect.left, rect.top, rect.right, rect.bottom);
    }

    public final void O0000OOo(o0oO0O0o o0oo0o0o) {
        O0000Oo(o0oo0o0o).O000000o(o0oo0o0o.O00000Oo());
        O00000oo(o0oo0o0o);
    }

    public final void O000000o(o0oO0O0o o0oo0o0o, ColorStateList colorStateList) {
        o0O0O0o0 O0000Oo = O0000Oo(o0oo0o0o);
        O0000Oo.O000000o(colorStateList);
        O0000Oo.invalidateSelf();
    }

    public final ColorStateList O0000Oo0(o0oO0O0o o0oo0o0o) {
        return O0000Oo(o0oo0o0o).O00000oO;
    }

    public final void O000000o(o0oO0O0o o0oo0o0o, float f) {
        o0O0O0o0 O0000Oo = O0000Oo(o0oo0o0o);
        if (f >= 0.0f) {
            float f2 = (float) ((int) (f + 0.5f));
            if (O0000Oo.O00000Oo != f2) {
                O0000Oo.O00000Oo = f2;
                O0000Oo.O00000oo = true;
                O0000Oo.invalidateSelf();
            }
            O00000oo(o0oo0o0o);
            return;
        }
        throw new IllegalArgumentException("Invalid radius " + f + ". Must be >= 0");
    }

    public final float O00000o(o0oO0O0o o0oo0o0o) {
        return O0000Oo(o0oo0o0o).O00000Oo;
    }

    public final void O00000o0(o0oO0O0o o0oo0o0o, float f) {
        o0O0O0o0 O0000Oo = O0000Oo(o0oo0o0o);
        O0000Oo.O000000o(f, O0000Oo.O00000o0);
    }

    public final float O00000oO(o0oO0O0o o0oo0o0o) {
        return O0000Oo(o0oo0o0o).O00000o;
    }

    public final void O00000Oo(o0oO0O0o o0oo0o0o, float f) {
        o0O0O0o0 O0000Oo = O0000Oo(o0oo0o0o);
        O0000Oo.O000000o(O0000Oo.O00000o, f);
        O00000oo(o0oo0o0o);
    }

    public final float O000000o(o0oO0O0o o0oo0o0o) {
        return O0000Oo(o0oo0o0o).O00000o0;
    }

    public final float O00000Oo(o0oO0O0o o0oo0o0o) {
        return O0000Oo(o0oo0o0o).O000000o();
    }

    public final float O00000o0(o0oO0O0o o0oo0o0o) {
        return O0000Oo(o0oo0o0o).O00000Oo();
    }

    private static o0O0O0o0 O0000Oo(o0oO0O0o o0oo0o0o) {
        return (o0O0O0o0) o0oo0o0o.O00000o0();
    }

    public final void O000000o(o0oO0O0o o0oo0o0o, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        o0O0O0o0 o0o0o0o0 = new o0O0O0o0(context.getResources(), colorStateList, f, f2, f3);
        o0o0o0o0.O000000o(o0oo0o0o.O00000Oo());
        o0oo0o0o.O000000o(o0o0o0o0);
        O00000oo(o0oo0o0o);
    }
}
