package _m_j;

import _m_j.dpf;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import com.tmall.wireless.vaf.framework.VafContext;

public final class dqi extends dqf {
    protected dpf.O00000o0 O000o0O = new dpf.O00000o0();
    protected Path O000o0OO;

    public final void onComLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public dqi(VafContext vafContext, dpg dpg) {
        super(vafContext, dpg);
        this.O000o0O.O000000o();
        this.O000o0O.O000000o(this);
        this.O0000Oo0.setColor(-16777216);
    }

    public final void O00000oO() {
        super.O00000oO();
        this.O0000Oo0.setStrokeWidth((float) this.O000o00o);
        this.O0000Oo0.setColor(this.O000o00O);
        int i = this.O000o0;
        if (i == 1) {
            this.O0000Oo0.setStyle(Paint.Style.FILL);
        } else if (i == 2) {
            if (this.O000o0OO == null) {
                this.O000o0OO = new Path();
            }
            this.O000o0OO.reset();
            this.O0000Oo0.setStyle(Paint.Style.STROKE);
            this.O0000Oo0.setPathEffect(new DashPathEffect(this.O000o0O0, 1.0f));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0085  */
    public final void O00000Oo(Canvas canvas) {
        int i;
        int i2;
        super.O00000Oo(canvas);
        int strokeWidth = (int) this.O0000Oo0.getStrokeWidth();
        if (this.f14849O000000o) {
            if ((this.O000OOOo & 32) != 0) {
                strokeWidth = this.O000OOo;
            } else if ((this.O000OOOo & 16) != 0) {
                i2 = this.O000OOo - (strokeWidth >> 1);
                if (this.O000o0 != 1) {
                    float f = (float) i2;
                    canvas.drawLine((float) this.O000O0oo, f, (float) (this.O000OOo0 - this.O000OO00), f, this.O0000Oo0);
                    return;
                } else if (this.O000o0 == 2) {
                    float f2 = (float) i2;
                    this.O000o0OO.moveTo((float) this.O000O0oo, f2);
                    this.O000o0OO.lineTo((float) (this.O000OOo0 - this.O000OO00), f2);
                    canvas.drawPath(this.O000o0OO, this.O0000Oo0);
                    return;
                } else {
                    return;
                }
            }
            i2 = strokeWidth >> 1;
            if (this.O000o0 != 1) {
            }
        } else {
            if ((this.O000OOOo & 4) != 0) {
                strokeWidth = this.O000OOo0;
            } else if ((this.O000OOOo & 2) != 0) {
                i = this.O000OOo0 - (strokeWidth >> 1);
                if (this.O000o0 != 1) {
                    float f3 = (float) i;
                    canvas.drawLine(f3, (float) this.O000OO0o, f3, (float) (this.O000OOo - this.O000OO), this.O0000Oo0);
                    return;
                } else if (this.O000o0 == 2) {
                    float f4 = (float) i;
                    this.O000o0OO.moveTo(f4, (float) this.O000OO0o);
                    this.O000o0OO.lineTo(f4, (float) (this.O000OOo - this.O000OO));
                    canvas.drawPath(this.O000o0OO, this.O0000Oo0);
                    return;
                } else {
                    return;
                }
            }
            i = strokeWidth >> 1;
            if (this.O000o0 != 1) {
            }
        }
    }

    public final void onComMeasure(int i, int i2) {
        this.O000o0O.onComMeasure(i, i2);
    }

    public final void measureComponent(int i, int i2) {
        this.O000o0O.measureComponent(i, i2);
    }

    public static class O000000o implements dpf.O000000o {
        public final dpf O000000o(VafContext vafContext, dpg dpg) {
            return new dqi(vafContext, dpg);
        }
    }
}
