package _m_j;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ActionBarContainer;

public final class OOO0O0O extends Drawable {

    /* renamed from: O000000o  reason: collision with root package name */
    final ActionBarContainer f12315O000000o;

    public final int getOpacity() {
        return 0;
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public OOO0O0O(ActionBarContainer actionBarContainer) {
        this.f12315O000000o = actionBarContainer;
    }

    public final void draw(Canvas canvas) {
        if (!this.f12315O000000o.O00000o) {
            if (this.f12315O000000o.f2682O000000o != null) {
                this.f12315O000000o.f2682O000000o.draw(canvas);
            }
            if (this.f12315O000000o.O00000Oo != null && this.f12315O000000o.O00000oO) {
                this.f12315O000000o.O00000Oo.draw(canvas);
            }
        } else if (this.f12315O000000o.O00000o0 != null) {
            this.f12315O000000o.O00000o0.draw(canvas);
        }
    }

    public final void getOutline(Outline outline) {
        if (this.f12315O000000o.O00000o) {
            if (this.f12315O000000o.O00000o0 != null) {
                this.f12315O000000o.O00000o0.getOutline(outline);
            }
        } else if (this.f12315O000000o.f2682O000000o != null) {
            this.f12315O000000o.f2682O000000o.getOutline(outline);
        }
    }
}
