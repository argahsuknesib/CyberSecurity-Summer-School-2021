package _m_j;

import _m_j.dpf;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tmall.wireless.vaf.framework.VafContext;

public final class dqe extends dqc {
    protected Bitmap O000o0;
    private dpf.O00000o0 O000o0O = new dpf.O00000o0();
    protected Matrix O000o0O0 = new Matrix();

    public final void onComLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public dqe(VafContext vafContext, dpg dpg) {
        super(vafContext, dpg);
        this.O000o0O.O000000o(this);
    }

    public final void O00000o() {
        super.O00000o();
        this.O000o0O.O00000Oo();
        this.O000o0 = null;
    }

    public final void O000OOOo() {
        if (this.O000o0 != null) {
            if (this.O000OoO == null) {
                this.O000OoO = new Rect(0, 0, this.O000o0.getWidth(), this.O000o0.getHeight());
            } else {
                this.O000OoO.set(0, 0, this.O000o0.getWidth(), this.O000o0.getHeight());
            }
        } else if (this.O000OOo0 > 0 && this.O000OOo > 0 && !TextUtils.isEmpty(this.O000o00O)) {
            O00000o0(this.O000o00O);
        }
    }

    public final void O000000o(Bitmap bitmap) {
        this.O000o0 = bitmap;
        this.O000OoO = null;
        O000O0OO();
    }

    public final void O00000o0(String str) {
        if (this.O000OOo0 > 0 && this.O000OOo > 0) {
            this.O000OoO0.O00000o().O000000o(str, this);
        }
    }

    public final void O00000Oo(Canvas canvas) {
        super.O00000Oo(canvas);
        if (this.O000OoO == null) {
            O000OOOo();
        }
        if (this.O000OoO != null) {
            int i = this.O000o00o;
            if (i == 0) {
                canvas.drawBitmap(this.O000o0, 0.0f, 0.0f, this.O0000Oo0);
            } else if (i == 1) {
                this.O000o0O0.setScale(((float) this.O000OOo0) / ((float) this.O000OoO.width()), ((float) this.O000OOo) / ((float) this.O000OoO.height()));
                canvas.drawBitmap(this.O000o0, this.O000o0O0, this.O0000Oo0);
            } else if (i == 2) {
                this.O000o0O0.setScale(((float) this.O000OOo0) / ((float) this.O000OoO.width()), ((float) this.O000OOo) / ((float) this.O000OoO.height()));
                canvas.drawBitmap(this.O000o0, this.O000o0O0, this.O0000Oo0);
            }
        }
    }

    public final void O00000oO() {
        super.O00000oO();
        this.O0000Oo0.setFilterBitmap(true);
        O00000o0(this.O000o00O);
    }

    public final void onComMeasure(int i, int i2) {
        this.O000o0O.onComMeasure(i, i2);
    }

    public final void measureComponent(int i, int i2) {
        this.O000o0O.measureComponent(i, i2);
    }

    public static class O000000o implements dpf.O000000o {
        public final dpf O000000o(VafContext vafContext, dpg dpg) {
            return new dqe(vafContext, dpg);
        }
    }
}
