package androidx.appcompat.widget;

import _m_j.OOOOo0;
import _m_j.Oo000;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.xiaomi.smarthome.R;

public class AppCompatSeekBar extends SeekBar {
    private final OOOOo0 mAppCompatSeekBarHelper;

    public AppCompatSeekBar(Context context) {
        this(context, null);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.seekBarStyle);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Oo000.O000000o(this, getContext());
        this.mAppCompatSeekBarHelper = new OOOOo0(this);
        this.mAppCompatSeekBarHelper.O000000o(attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        OOOOo0 oOOOo0 = this.mAppCompatSeekBarHelper;
        if (oOOOo0.O00000o0 != null) {
            int max = oOOOo0.O00000Oo.getMax();
            int i = 1;
            if (max > 1) {
                int intrinsicWidth = oOOOo0.O00000o0.getIntrinsicWidth();
                int intrinsicHeight = oOOOo0.O00000o0.getIntrinsicHeight();
                int i2 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i = intrinsicHeight / 2;
                }
                oOOOo0.O00000o0.setBounds(-i2, -i, i2, i);
                float width = ((float) ((oOOOo0.O00000Oo.getWidth() - oOOOo0.O00000Oo.getPaddingLeft()) - oOOOo0.O00000Oo.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) oOOOo0.O00000Oo.getPaddingLeft(), (float) (oOOOo0.O00000Oo.getHeight() / 2));
                for (int i3 = 0; i3 <= max; i3++) {
                    oOOOo0.O00000o0.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        OOOOo0 oOOOo0 = this.mAppCompatSeekBarHelper;
        Drawable drawable = oOOOo0.O00000o0;
        if (drawable != null && drawable.isStateful() && drawable.setState(oOOOo0.O00000Oo.getDrawableState())) {
            oOOOo0.O00000Oo.invalidateDrawable(drawable);
        }
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        OOOOo0 oOOOo0 = this.mAppCompatSeekBarHelper;
        if (oOOOo0.O00000o0 != null) {
            oOOOo0.O00000o0.jumpToCurrentState();
        }
    }
}
