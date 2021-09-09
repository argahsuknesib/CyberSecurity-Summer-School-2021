package miuix.smooth;

import _m_j.ize;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.xiaomi.smarthome.R;

public class SmoothFrameLayout extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final PorterDuffXfermode f15390O000000o = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
    private static final PorterDuffXfermode O00000Oo = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    private Rect O00000o;
    private ize O00000o0;
    private RectF O00000oO;

    public SmoothFrameLayout(Context context) {
        this(context, null);
    }

    public SmoothFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SmoothFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000o = new Rect();
        this.O00000oO = new RectF();
        this.O00000o0 = new ize();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843176, 16843177, 16843178, 16843179, 16843180, R.attr.miuix_strokeColor, R.attr.miuix_strokeWidth});
        setCornerRadius((float) obtainStyledAttributes.getDimensionPixelSize(0, 0));
        if (obtainStyledAttributes.hasValue(1) || obtainStyledAttributes.hasValue(2) || obtainStyledAttributes.hasValue(4) || obtainStyledAttributes.hasValue(3)) {
            float dimensionPixelSize = (float) obtainStyledAttributes.getDimensionPixelSize(1, 0);
            float dimensionPixelSize2 = (float) obtainStyledAttributes.getDimensionPixelSize(2, 0);
            float dimensionPixelSize3 = (float) obtainStyledAttributes.getDimensionPixelSize(4, 0);
            float dimensionPixelSize4 = (float) obtainStyledAttributes.getDimensionPixelSize(3, 0);
            setCornerRadii(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize4, dimensionPixelSize4});
        }
        setStrokeWidth(obtainStyledAttributes.getDimensionPixelSize(6, 0));
        setStrokeColor(obtainStyledAttributes.getColor(5, 0));
        obtainStyledAttributes.recycle();
    }

    public void setStrokeWidth(int i) {
        if (this.O00000o0.f1664O000000o != i) {
            this.O00000o0.f1664O000000o = i;
            O000000o();
        }
    }

    public int getStrokeWidth() {
        return this.O00000o0.f1664O000000o;
    }

    public void setStrokeColor(int i) {
        if (this.O00000o0.O00000Oo != i) {
            this.O00000o0.O00000Oo = i;
            O000000o();
        }
    }

    public int getStrokeColor() {
        return this.O00000o0.O00000Oo;
    }

    public void setCornerRadii(float[] fArr) {
        ize ize = this.O00000o0;
        ize.O00000o0 = fArr;
        if (fArr == null) {
            ize.O00000o = 0.0f;
        }
        O000000o();
    }

    public float[] getCornerRadii() {
        if (this.O00000o0.O00000o0 == null) {
            return null;
        }
        return (float[]) this.O00000o0.O00000o0.clone();
    }

    public void setCornerRadius(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        ize ize = this.O00000o0;
        ize.O00000o = f;
        ize.O00000o0 = null;
        O000000o();
    }

    public float getCornerRadius() {
        return this.O00000o0.O00000o;
    }

    private void O000000o() {
        O00000Oo();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.O00000o.set(0, 0, i, i2);
        this.O00000oO.set(0.0f, 0.0f, (float) i, (float) i2);
        O00000Oo();
    }

    private void O00000Oo() {
        this.O00000o0.O000000o(this.O00000o);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        int saveLayer = canvas.saveLayer(this.O00000oO, null, 31);
        super.dispatchDraw(canvas);
        this.O00000o0.O000000o(canvas, O00000Oo);
        canvas.restoreToCount(saveLayer);
        this.O00000o0.O000000o(canvas);
    }

    public void draw(Canvas canvas) {
        int saveLayer = canvas.saveLayer(this.O00000oO, null, 31);
        super.draw(canvas);
        this.O00000o0.O000000o(canvas, f15390O000000o);
        canvas.restoreToCount(saveLayer);
        this.O00000o0.O000000o(canvas);
    }
}
