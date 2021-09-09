package com.xiaomi.smarthome.device.choosedevice;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class FitLineLinearLayout extends ViewGroup {

    /* renamed from: O000000o  reason: collision with root package name */
    public O000000o f7249O000000o;
    private List<O00000Oo> O00000Oo;

    public FitLineLinearLayout(Context context) {
        this(context, null);
    }

    public FitLineLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.WarpLinearLayoutDefault);
    }

    public FitLineLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7249O000000o = new O000000o(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int childCount = getChildCount();
        measureChildren(i, i2);
        if (mode == Integer.MIN_VALUE) {
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                if (i4 != 0) {
                    i3 = (int) (((float) i3) + this.f7249O000000o.O00000Oo);
                }
                i3 += getChildAt(i4).getMeasuredWidth();
            }
            int paddingLeft = getPaddingLeft() + getPaddingRight() + i3;
            if (paddingLeft <= size) {
                size = paddingLeft;
            }
        } else if (mode == 0) {
            int i5 = 0;
            for (int i6 = 0; i6 < childCount; i6++) {
                if (i6 != 0) {
                    i5 = (int) (((float) i5) + this.f7249O000000o.O00000Oo);
                }
                i5 += getChildAt(i6).getMeasuredWidth();
            }
            size = i5 + getPaddingLeft() + getPaddingRight();
        }
        O00000Oo o00000Oo = new O00000Oo(this, (byte) 0);
        this.O00000Oo = new ArrayList();
        O00000Oo o00000Oo2 = o00000Oo;
        for (int i7 = 0; i7 < childCount; i7++) {
            if (((float) (o00000Oo2.O00000Oo + getChildAt(i7).getMeasuredWidth())) + this.f7249O000000o.O00000Oo > ((float) size)) {
                if (o00000Oo2.f7251O000000o.size() == 0) {
                    o00000Oo2.O000000o(getChildAt(i7));
                    this.O00000Oo.add(o00000Oo2);
                    o00000Oo2 = new O00000Oo(this, (byte) 0);
                } else {
                    this.O00000Oo.add(o00000Oo2);
                    o00000Oo2 = new O00000Oo(this, (byte) 0);
                }
            }
            o00000Oo2.O000000o(getChildAt(i7));
        }
        if (o00000Oo2.f7251O000000o.size() > 0 && !this.O00000Oo.contains(o00000Oo2)) {
            this.O00000Oo.add(o00000Oo2);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        for (int i8 = 0; i8 < this.O00000Oo.size(); i8++) {
            if (i8 != 0) {
                paddingTop = (int) (((float) paddingTop) + this.f7249O000000o.O00000o0);
            }
            paddingTop += this.O00000Oo.get(i8).O00000o0;
        }
        if (mode2 == Integer.MIN_VALUE ? paddingTop > size2 : mode2 == 1073741824) {
            paddingTop = size2;
        }
        setMeasuredDimension(size, paddingTop);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        float measuredWidth;
        float f2;
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < this.O00000Oo.size(); i5++) {
            int paddingLeft = getPaddingLeft();
            O00000Oo o00000Oo = this.O00000Oo.get(i5);
            int measuredWidth2 = getMeasuredWidth() - o00000Oo.O00000Oo;
            int i6 = paddingLeft;
            for (int i7 = 0; i7 < o00000Oo.f7251O000000o.size(); i7++) {
                View view = o00000Oo.f7251O000000o.get(i7);
                if (this.f7249O000000o.O00000o) {
                    view.layout(i6, paddingTop, view.getMeasuredWidth() + i6 + (measuredWidth2 / o00000Oo.f7251O000000o.size()), view.getMeasuredHeight() + paddingTop);
                    f = (float) i6;
                    measuredWidth = ((float) view.getMeasuredWidth()) + this.f7249O000000o.O00000Oo;
                    f2 = (float) (measuredWidth2 / o00000Oo.f7251O000000o.size());
                } else {
                    int grivate = getGrivate();
                    if (grivate == 0) {
                        int i8 = i6 + measuredWidth2;
                        view.layout(i8, paddingTop, view.getMeasuredWidth() + i8, view.getMeasuredHeight() + paddingTop);
                    } else if (grivate != 2) {
                        view.layout(i6, paddingTop, view.getMeasuredWidth() + i6, view.getMeasuredHeight() + paddingTop);
                    } else {
                        int i9 = (measuredWidth2 / 2) + i6;
                        view.layout(i9, paddingTop, view.getMeasuredWidth() + i9, view.getMeasuredHeight() + paddingTop);
                    }
                    f = (float) i6;
                    measuredWidth = (float) view.getMeasuredWidth();
                    f2 = this.f7249O000000o.O00000Oo;
                }
                i6 = (int) (f + measuredWidth + f2);
            }
            paddingTop = (int) (((float) paddingTop) + ((float) o00000Oo.O00000o0) + this.f7249O000000o.O00000o0);
        }
    }

    final class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public List<View> f7251O000000o;
        public int O00000Oo;
        public int O00000o0;

        private O00000Oo() {
            this.f7251O000000o = new ArrayList();
            this.O00000Oo = FitLineLinearLayout.this.getPaddingLeft() + FitLineLinearLayout.this.getPaddingRight();
            this.O00000o0 = 0;
        }

        /* synthetic */ O00000Oo(FitLineLinearLayout fitLineLinearLayout, byte b) {
            this();
        }

        public final void O000000o(View view) {
            if (this.f7251O000000o.size() != 0) {
                this.O00000Oo = (int) (((float) this.O00000Oo) + FitLineLinearLayout.this.f7249O000000o.O00000Oo);
            }
            this.O00000o0 = this.O00000o0 > view.getMeasuredHeight() ? this.O00000o0 : view.getMeasuredHeight();
            this.O00000Oo += view.getMeasuredWidth();
            this.f7251O000000o.add(view);
        }
    }

    static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f7250O000000o;
        public float O00000Oo;
        public boolean O00000o;
        public float O00000o0;

        O000000o(Context context, AttributeSet attributeSet) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.grivate, R.attr.horizontal_Space, R.attr.isFull, R.attr.vertical_Space});
                this.f7250O000000o = obtainStyledAttributes.getInt(0, this.f7250O000000o);
                this.O00000Oo = obtainStyledAttributes.getDimension(1, this.O00000Oo);
                this.O00000o0 = obtainStyledAttributes.getDimension(3, this.O00000o0);
                this.O00000o = obtainStyledAttributes.getBoolean(2, this.O00000o);
            }
        }
    }

    public int getGrivate() {
        return this.f7249O000000o.f7250O000000o;
    }

    public float getHorizontal_Space() {
        return this.f7249O000000o.O00000Oo;
    }

    public float getVertical_Space() {
        return this.f7249O000000o.O00000o0;
    }

    public void setGrivate(int i) {
        this.f7249O000000o.f7250O000000o = i;
    }

    public void setHorizontal_Space(float f) {
        this.f7249O000000o.O00000Oo = f;
    }

    public void setVertical_Space(float f) {
        this.f7249O000000o.O00000o0 = f;
    }

    public void setIsFull(boolean z) {
        this.f7249O000000o.O00000o = z;
    }
}
