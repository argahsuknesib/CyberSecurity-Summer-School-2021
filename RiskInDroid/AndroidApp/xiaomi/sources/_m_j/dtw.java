package _m_j;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.wx.wheelview.widget.WheelView;

public class dtw extends Drawable {

    /* renamed from: O000000o  reason: collision with root package name */
    protected int f14939O000000o;
    protected int O00000Oo;
    private Paint O00000o = new Paint();
    protected WheelView.O00000o0 O00000o0;

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public dtw(int i, int i2, WheelView.O00000o0 o00000o0) {
        this.f14939O000000o = i;
        this.O00000Oo = i2;
        this.O00000o0 = o00000o0;
        this.O00000o.setColor(this.O00000o0.f5949O000000o != -1 ? this.O00000o0.f5949O000000o : -1);
    }

    public void draw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, (float) this.f14939O000000o, (float) this.O00000Oo, this.O00000o);
    }
}
