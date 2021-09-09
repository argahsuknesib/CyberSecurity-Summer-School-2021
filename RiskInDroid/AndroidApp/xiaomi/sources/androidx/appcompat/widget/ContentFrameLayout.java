package androidx.appcompat.widget;

import _m_j.cb;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;

public class ContentFrameLayout extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private TypedValue f2717O000000o;
    private TypedValue O00000Oo;
    private TypedValue O00000o;
    private TypedValue O00000o0;
    private TypedValue O00000oO;
    private TypedValue O00000oo;
    private final Rect O0000O0o;
    private O000000o O0000OOo;

    public interface O000000o {
        void O000000o();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000O0o = new Rect();
    }

    public final void O000000o(Rect rect) {
        fitSystemWindows(rect);
    }

    public void setAttachListener(O000000o o000000o) {
        this.O0000OOo = o000000o;
    }

    public final void O000000o(int i, int i2, int i3, int i4) {
        this.O0000O0o.set(i, i2, i3, i4);
        if (cb.O000O0oO(this)) {
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    public void onMeasure(int i, int i2) {
        boolean z;
        int i3;
        int measuredWidth;
        TypedValue typedValue;
        int i4;
        float fraction;
        int i5;
        float fraction2;
        int i6;
        float fraction3;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        boolean z2 = true;
        boolean z3 = displayMetrics.widthPixels < displayMetrics.heightPixels;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            TypedValue typedValue2 = z3 ? this.O00000o : this.O00000o0;
            if (!(typedValue2 == null || typedValue2.type == 0)) {
                if (typedValue2.type == 5) {
                    fraction3 = typedValue2.getDimension(displayMetrics);
                } else if (typedValue2.type == 6) {
                    fraction3 = typedValue2.getFraction((float) displayMetrics.widthPixels, (float) displayMetrics.widthPixels);
                } else {
                    i6 = 0;
                    if (i6 > 0) {
                        i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i6 - (this.O0000O0o.left + this.O0000O0o.right), View.MeasureSpec.getSize(i)), 1073741824);
                        z = true;
                        if (mode2 == Integer.MIN_VALUE) {
                            TypedValue typedValue3 = z3 ? this.O00000oO : this.O00000oo;
                            if (!(typedValue3 == null || typedValue3.type == 0)) {
                                if (typedValue3.type == 5) {
                                    fraction2 = typedValue3.getDimension(displayMetrics);
                                } else if (typedValue3.type == 6) {
                                    fraction2 = typedValue3.getFraction((float) displayMetrics.heightPixels, (float) displayMetrics.heightPixels);
                                } else {
                                    i5 = 0;
                                    if (i5 > 0) {
                                        i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i5 - (this.O0000O0o.top + this.O0000O0o.bottom), View.MeasureSpec.getSize(i2)), 1073741824);
                                    }
                                }
                                i5 = (int) fraction2;
                                if (i5 > 0) {
                                }
                            }
                        }
                        super.onMeasure(i3, i2);
                        measuredWidth = getMeasuredWidth();
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                        if (!z && mode == Integer.MIN_VALUE) {
                            typedValue = !z3 ? this.O00000Oo : this.f2717O000000o;
                            if (!(typedValue == null || typedValue.type == 0)) {
                                if (typedValue.type != 5) {
                                    fraction = typedValue.getDimension(displayMetrics);
                                } else if (typedValue.type == 6) {
                                    fraction = typedValue.getFraction((float) displayMetrics.widthPixels, (float) displayMetrics.widthPixels);
                                } else {
                                    i4 = 0;
                                    if (i4 > 0) {
                                        i4 -= this.O0000O0o.left + this.O0000O0o.right;
                                    }
                                    if (measuredWidth < i4) {
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                                        if (z2) {
                                            super.onMeasure(makeMeasureSpec, i2);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                i4 = (int) fraction;
                                if (i4 > 0) {
                                }
                                if (measuredWidth < i4) {
                                }
                            }
                        }
                        z2 = false;
                        if (z2) {
                        }
                    }
                }
                i6 = (int) fraction3;
                if (i6 > 0) {
                }
            }
        }
        i3 = i;
        z = false;
        if (mode2 == Integer.MIN_VALUE) {
        }
        super.onMeasure(i3, i2);
        measuredWidth = getMeasuredWidth();
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        if (!z3) {
        }
        if (typedValue.type != 5) {
        }
        i4 = (int) fraction;
        if (i4 > 0) {
        }
        if (measuredWidth < i4) {
        }
        z2 = false;
        if (z2) {
        }
    }

    public TypedValue getMinWidthMajor() {
        if (this.f2717O000000o == null) {
            this.f2717O000000o = new TypedValue();
        }
        return this.f2717O000000o;
    }

    public TypedValue getMinWidthMinor() {
        if (this.O00000Oo == null) {
            this.O00000Oo = new TypedValue();
        }
        return this.O00000Oo;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.O00000o0 == null) {
            this.O00000o0 = new TypedValue();
        }
        return this.O00000o0;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.O00000o == null) {
            this.O00000o = new TypedValue();
        }
        return this.O00000o;
    }

    public TypedValue getFixedHeightMajor() {
        if (this.O00000oO == null) {
            this.O00000oO = new TypedValue();
        }
        return this.O00000oO;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.O00000oo == null) {
            this.O00000oo = new TypedValue();
        }
        return this.O00000oo;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        O000000o o000000o = this.O0000OOo;
        if (o000000o != null) {
            o000000o.O000000o();
        }
    }
}
