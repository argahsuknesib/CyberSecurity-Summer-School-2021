package _m_j;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

public abstract class daf extends Drawable {
    protected Paint O0000o00 = new Paint();

    public int getOpacity() {
        return -3;
    }

    protected daf() {
        this.O0000o00.setStyle(Paint.Style.FILL);
        this.O0000o00.setAntiAlias(true);
        this.O0000o00.setColor(-5592406);
    }

    public final void O00000Oo(int i) {
        this.O0000o00.setColor(i);
    }

    public void setAlpha(int i) {
        this.O0000o00.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.O0000o00.setColorFilter(colorFilter);
    }
}
