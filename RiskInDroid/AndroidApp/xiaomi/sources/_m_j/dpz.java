package _m_j;

import _m_j.dpf;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tmall.wireless.vaf.framework.VafContext;

public final class dpz extends dph {
    protected int O000o0;
    protected RectF O000o00O;
    protected int O000o00o;
    protected int O000o0O = 1;
    protected int O000o0O0;

    public dpz(VafContext vafContext, dpg dpg) {
        super(vafContext, dpg);
        this.f14836O000000o.O000000o();
    }

    public final void O000OOOo() {
        if (this.O000OoO == null) {
            this.O000OoO = new Rect(0, 0, this.O000o0, this.O000o0O0);
        } else {
            this.O000OoO.set(0, 0, this.O000o0, this.O000o0O0);
        }
    }

    public final void O00000Oo(Canvas canvas) {
        super.O00000Oo(canvas);
        int i = this.O000O0oo;
        int i2 = this.O000o0;
        int i3 = this.O000o0O0;
        if (i2 <= 0) {
            i2 = (this.O000OOo0 - this.O000O0oo) - this.O000OO00;
        } else if ((this.O000OOOo & 2) != 0) {
            i = (this.O000OOo0 - this.O000OO00) - this.O000o0;
        } else if ((this.O000OOOo & 4) != 0) {
            i = (this.O000OOo0 - this.O000o0) >> 1;
        }
        int i4 = this.O000OO0o;
        if (this.O000o0O0 <= 0) {
            i3 = (this.O000OOo - this.O000OO0o) - this.O000OO;
        } else if ((this.O000OOOo & 16) != 0) {
            i4 = (this.O000OOo - this.O000OO) - this.O000o0O0;
        } else if ((this.O000OOOo & 32) != 0) {
            i4 = (this.O000OOo - this.O000o0O0) >> 1;
        }
        int i5 = this.O000o0O;
        if (i5 == 1) {
            int i6 = i2 >> 1;
            canvas.drawCircle((float) (i + i6), (float) (i4 + i6), (float) i6, this.O0000Oo0);
        } else if (i5 == 2) {
            canvas.drawRect((float) i, (float) i4, (float) (i + i2), (float) (i4 + i3), this.O0000Oo0);
        } else if (i5 == 3) {
            if (this.O000o00O == null) {
                this.O000o00O = new RectF();
            }
            this.O000o00O.set((float) i, (float) i4, (float) (i + i2), (float) (i4 + i3));
            canvas.drawOval(this.O000o00O, this.O0000Oo0);
        }
    }

    public final void O00000oO() {
        super.O00000oO();
        if (1 == this.O000o0O) {
            this.O000o0O0 = this.O000o0;
        }
        this.O0000Oo0.setColor(this.O000o00o);
    }

    public final boolean O00000Oo(int i, float f) {
        boolean O00000Oo = super.O00000Oo(i, f);
        if (O00000Oo) {
            return O00000Oo;
        }
        switch (i) {
            case 793104392:
                this.O0000Oo0.setStrokeWidth((float) bns.O00000Oo((double) f));
                return true;
            case 1360592235:
                this.O000o0 = bns.O00000Oo((double) f);
                return true;
            case 1360592236:
                this.O000o0O0 = bns.O00000Oo((double) f);
                return true;
            default:
                return false;
        }
    }

    public final boolean O00000o0(int i, int i2) {
        boolean O00000o0 = super.O00000o0(i, i2);
        if (O00000o0) {
            return O00000o0;
        }
        switch (i) {
            case 3575610:
                this.O000o0O = i2;
                break;
            case 94842723:
                this.O000o00o = i2;
                break;
            case 789757939:
                if (i2 != 1) {
                    if (i2 == 2) {
                        this.O0000Oo0.setStyle(Paint.Style.FILL);
                        break;
                    }
                } else {
                    this.O0000Oo0.setStyle(Paint.Style.STROKE);
                    break;
                }
                break;
            case 793104392:
                this.O0000Oo0.setStrokeWidth((float) bns.O00000Oo((double) i2));
                break;
            case 1360592235:
                this.O000o0 = bns.O00000Oo((double) i2);
                break;
            case 1360592236:
                this.O000o0O0 = bns.O00000Oo((double) i2);
                break;
            default:
                return false;
        }
        return true;
    }

    public static class O000000o implements dpf.O000000o {
        public final dpf O000000o(VafContext vafContext, dpg dpg) {
            return new dpz(vafContext, dpg);
        }
    }
}
