package _m_j;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.wx.wheelview.widget.WheelView;

public final class dtv extends dtw {
    private Paint O00000o = new Paint();
    private Paint O00000oO;
    private int O00000oo;
    private int O0000O0o;

    public dtv(int i, int i2, WheelView.O00000o0 o00000o0, int i3, int i4) {
        super(i, i2, o00000o0);
        this.O00000oo = i3;
        this.O0000O0o = i4;
        this.O00000o.setColor(this.O00000o0.f5949O000000o != -1 ? this.O00000o0.f5949O000000o : -1);
        this.O00000oO = new Paint();
        this.O00000oO.setStrokeWidth(3.0f);
        this.O00000oO.setColor(this.O00000o0.O00000Oo != -1 ? this.O00000o0.O00000Oo : dtt.O00000Oo);
    }

    public final void draw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, (float) this.f14939O000000o, (float) this.O00000Oo, this.O00000o);
        int i = this.O0000O0o;
        if (i != 0) {
            canvas.drawLine(0.0f, (float) (i * (this.O00000oo / 2)), (float) this.f14939O000000o, (float) (this.O0000O0o * (this.O00000oo / 2)), this.O00000oO);
            canvas.drawLine(0.0f, (float) (this.O0000O0o * ((this.O00000oo / 2) + 1)), (float) this.f14939O000000o, (float) (this.O0000O0o * ((this.O00000oo / 2) + 1)), this.O00000oO);
        }
    }
}
