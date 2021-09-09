package _m_j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public final class izq extends izr {
    private static int O0000O0o = 56;
    private int O0000OOo;
    private RectF O0000Oo = new RectF();
    private int O0000Oo0;
    private float O0000OoO = 0.0f;
    private float O0000Ooo = 0.0f;
    private int O0000o00 = -3;

    public izq() {
        int i = O0000O0o;
        this.O0000OOo = i;
        this.O0000Oo0 = i;
        this.f1674O000000o.setStrokeCap(Paint.Cap.ROUND);
    }

    public izq(int i, int i2) {
        int i3 = O0000O0o;
        this.O0000OOo = i3;
        this.O0000Oo0 = i3;
        this.O0000OOo = i;
        this.O0000Oo0 = i2;
    }

    public final int getIntrinsicHeight() {
        return Math.min(this.O0000Oo0, Math.max((int) ((Math.max(this.O00000Oo.getStrokeWidth(), this.f1674O000000o.getStrokeWidth()) * 2.0f) + 10.0f), this.O0000OOo));
    }

    public final int getIntrinsicWidth() {
        return Math.min(this.O0000Oo0, Math.max((int) ((Math.max(this.O00000Oo.getStrokeWidth(), this.f1674O000000o.getStrokeWidth()) * 2.0f) + 10.0f), this.O0000OOo));
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (rect.left != 0 || rect.top != 0 || rect.right != 0 || rect.bottom != 0) {
            int centerX = rect.centerX();
            int centerY = rect.centerY();
            int min = (Math.min(rect.height(), rect.width()) >> 1) - ((((int) Math.max(O00000o0(), O00000Oo())) >> 1) + 1);
            this.O0000Oo.set((float) (centerX - min), (float) (centerY - min), (float) (centerX + min), (float) (centerY + min));
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o(float f) {
        this.O0000OoO = 0.0f;
        this.O0000Ooo = f * 360.0f;
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        this.O0000OoO += 5.0f;
        float f = this.O0000OoO;
        if (f > 360.0f) {
            this.O0000OoO = f - 360.0f;
        }
        float f2 = this.O0000Ooo;
        if (f2 > 255.0f) {
            this.O0000o00 = -this.O0000o00;
        } else if (f2 < 3.0f) {
            this.O0000Ooo = 3.0f;
            return;
        } else if (f2 == 3.0f) {
            this.O0000o00 = -this.O0000o00;
            O00000oO();
        }
        this.O0000Ooo += (float) this.O0000o00;
    }

    /* access modifiers changed from: protected */
    public final void O000000o(Canvas canvas, Paint paint) {
        canvas.drawArc(this.O0000Oo, 0.0f, 360.0f, false, paint);
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(Canvas canvas, Paint paint) {
        canvas.drawArc(this.O0000Oo, this.O0000OoO, -this.O0000Ooo, false, paint);
    }
}
