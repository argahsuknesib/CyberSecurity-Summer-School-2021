package _m_j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import com.wx.wheelview.widget.WheelView;

public final class dtu extends dtw {
    private static final int[] O00000o = {-15658735, 11184810, 11184810};
    private GradientDrawable O00000oO = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, O00000o);
    private GradientDrawable O00000oo = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, O00000o);
    private Paint O0000O0o;
    private Paint O0000OOo;
    private Paint O0000Oo;
    private Paint O0000Oo0;
    private int O0000OoO;
    private int O0000Ooo;

    public dtu(int i, int i2, WheelView.O00000o0 o00000o0, int i3, int i4) {
        super(i, i2, o00000o0);
        this.O0000OoO = i3;
        this.O0000Ooo = i4;
        this.O0000O0o = new Paint();
        this.O0000O0o.setColor(this.O00000o0.f5949O000000o != -1 ? this.O00000o0.f5949O000000o : dtt.f14938O000000o);
        this.O0000OOo = new Paint();
        this.O0000OOo.setColor(dtt.O00000o0);
        this.O0000Oo0 = new Paint();
        this.O0000Oo0.setColor(dtt.O00000o);
        this.O0000Oo0.setStrokeWidth(2.0f);
        this.O0000Oo = new Paint();
        this.O0000Oo.setStrokeWidth(6.0f);
        this.O0000Oo.setColor(dtt.O00000oO);
    }

    public final void draw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, (float) this.f14939O000000o, (float) this.O00000Oo, this.O0000O0o);
        int i = this.O0000Ooo;
        if (i != 0) {
            canvas.drawRect(0.0f, (float) (i * (this.O0000OoO / 2)), (float) this.f14939O000000o, (float) (this.O0000Ooo * ((this.O0000OoO / 2) + 1)), this.O0000OOo);
            canvas.drawLine(0.0f, (float) (this.O0000Ooo * (this.O0000OoO / 2)), (float) this.f14939O000000o, (float) (this.O0000Ooo * (this.O0000OoO / 2)), this.O0000Oo0);
            canvas.drawLine(0.0f, (float) (this.O0000Ooo * ((this.O0000OoO / 2) + 1)), (float) this.f14939O000000o, (float) (this.O0000Ooo * ((this.O0000OoO / 2) + 1)), this.O0000Oo0);
            this.O00000oO.setBounds(0, 0, this.f14939O000000o, this.O0000Ooo);
            this.O00000oO.draw(canvas);
            this.O00000oo.setBounds(0, this.O00000Oo - this.O0000Ooo, this.f14939O000000o, this.O00000Oo);
            this.O00000oo.draw(canvas);
            Canvas canvas2 = canvas;
            canvas2.drawLine(0.0f, 0.0f, 0.0f, (float) this.O00000Oo, this.O0000Oo);
            canvas2.drawLine((float) this.f14939O000000o, 0.0f, (float) this.f14939O000000o, (float) this.O00000Oo, this.O0000Oo);
        }
    }
}
