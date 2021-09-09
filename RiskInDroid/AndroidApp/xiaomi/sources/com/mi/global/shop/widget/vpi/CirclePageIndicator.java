package com.mi.global.shop.widget.vpi;

import _m_j.cc;
import _m_j.ccm;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.viewpager.widget.ViewPager;
import com.mi.global.shop.adapter.BasePageIndicatorAdapter;
import com.xiaomi.smarthome.R;

public class CirclePageIndicator extends View implements ccm {

    /* renamed from: O000000o  reason: collision with root package name */
    private float f5054O000000o;
    private final Paint O00000Oo;
    private final Paint O00000o;
    private final Paint O00000o0;
    private ViewPager O00000oO;
    private ViewPager.O0000O0o O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private int O0000Oo;
    private float O0000Oo0;
    private int O0000OoO;
    private boolean O0000Ooo;
    private int O0000o;
    private boolean O0000o0;
    private boolean O0000o00;
    private int O0000o0O;
    private float O0000o0o;
    private int O0000oO;
    private boolean O0000oO0;

    public CirclePageIndicator(Context context) {
        this(context, null);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.vpiCirclePageIndicatorStyle);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000Oo = new Paint(1);
        this.O00000o0 = new Paint(1);
        this.O00000o = new Paint(1);
        this.O0000o0o = -1.0f;
        this.O0000o = -1;
        if (!isInEditMode()) {
            Resources resources = getResources();
            int color = resources.getColor(R.color.default_circle_indicator_page_color);
            int color2 = resources.getColor(R.color.default_circle_indicator_fill_color);
            int integer = resources.getInteger(R.integer.default_circle_indicator_orientation);
            int color3 = resources.getColor(R.color.default_circle_indicator_stroke_color);
            float dimension = resources.getDimension(R.dimen.default_circle_indicator_stroke_width);
            float dimension2 = resources.getDimension(R.dimen.default_circle_indicator_radius);
            boolean z = resources.getBoolean(R.bool.default_circle_indicator_centered);
            boolean z2 = resources.getBoolean(R.bool.default_circle_indicator_snap);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842948, 16842964, R.attr.centered, R.attr.fillColor, R.attr.pageColor, R.attr.radius, R.attr.snap, R.attr.strokeColor, R.attr.strokeWidth}, i, 0);
            this.O0000Ooo = obtainStyledAttributes.getBoolean(2, z);
            this.O0000OoO = obtainStyledAttributes.getInt(0, integer);
            this.O00000Oo.setStyle(Paint.Style.FILL);
            this.O00000Oo.setColor(obtainStyledAttributes.getColor(4, color));
            this.O00000o0.setStyle(Paint.Style.STROKE);
            this.O00000o0.setColor(obtainStyledAttributes.getColor(7, color3));
            this.O00000o0.setStrokeWidth(obtainStyledAttributes.getDimension(8, dimension));
            this.O00000o.setStyle(Paint.Style.FILL);
            this.O00000o.setColor(obtainStyledAttributes.getColor(3, color2));
            this.f5054O000000o = obtainStyledAttributes.getDimension(5, dimension2);
            this.O0000o0 = obtainStyledAttributes.getBoolean(6, z2);
            Drawable drawable = obtainStyledAttributes.getDrawable(1);
            if (drawable != null) {
                setBackgroundDrawable(drawable);
            }
            obtainStyledAttributes.recycle();
            this.O0000o0O = cc.O000000o(ViewConfiguration.get(context));
        }
    }

    public void setRealCount(int i) {
        this.O0000oO = i;
    }

    public void setCentered(boolean z) {
        this.O0000Ooo = z;
        invalidate();
    }

    public void setRighted(boolean z) {
        this.O0000o00 = z;
        invalidate();
    }

    public void setPageColor(int i) {
        this.O00000Oo.setColor(i);
        invalidate();
    }

    public int getPageColor() {
        return this.O00000Oo.getColor();
    }

    public void setFillColor(int i) {
        this.O00000o.setColor(i);
        invalidate();
    }

    public int getFillColor() {
        return this.O00000o.getColor();
    }

    public void setOrientation(int i) {
        if (i == 0 || i == 1) {
            this.O0000OoO = i;
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
    }

    public int getOrientation() {
        return this.O0000OoO;
    }

    public void setStrokeColor(int i) {
        this.O00000o0.setColor(i);
        invalidate();
    }

    public int getStrokeColor() {
        return this.O00000o0.getColor();
    }

    public void setStrokeWidth(float f) {
        this.O00000o0.setStrokeWidth(f);
        invalidate();
    }

    public float getStrokeWidth() {
        return this.O00000o0.getStrokeWidth();
    }

    public void setRadius(float f) {
        this.f5054O000000o = f;
        invalidate();
    }

    public float getRadius() {
        return this.f5054O000000o;
    }

    public void setSnap(boolean z) {
        this.O0000o0 = z;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        float f;
        float f2;
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        ViewPager viewPager = this.O00000oO;
        if (viewPager != null) {
            if (viewPager.getAdapter() instanceof BasePageIndicatorAdapter) {
                i = ((BasePageIndicatorAdapter) this.O00000oO.getAdapter()).O000000o();
            } else {
                i = this.O00000oO.getAdapter().getCount();
            }
            this.O0000oO = i;
            if (i != 0) {
                if (this.O0000O0o >= i) {
                    setCurrentItem(i - 1);
                    return;
                }
                if (this.O0000OoO == 0) {
                    i5 = getWidth();
                    i4 = getPaddingLeft();
                    i3 = getPaddingRight();
                    i2 = getPaddingTop();
                } else {
                    i5 = getHeight();
                    i4 = getPaddingTop();
                    i3 = getPaddingBottom();
                    i2 = getPaddingLeft();
                }
                float f3 = this.f5054O000000o;
                double d = (double) f3;
                Double.isNaN(d);
                float f4 = (float) (d * 3.618d);
                float f5 = ((float) i2) + f3;
                float f6 = ((float) i4) + f3;
                if (this.O0000Ooo) {
                    double d2 = (double) f6;
                    double d3 = (double) (((float) i) * f4);
                    double d4 = (double) (((float) ((i5 - i4) - i3)) / 2.0f);
                    double d5 = (double) f3;
                    Double.isNaN(d5);
                    Double.isNaN(d3);
                    Double.isNaN(d4);
                    Double.isNaN(d2);
                    f6 = (float) (d2 + (d4 - ((d3 - (d5 * 1.618d)) / 2.0d)));
                }
                if (this.O0000o00) {
                    f6 += ((float) ((i5 - i4) - i3)) - (((float) i) * f4);
                }
                float f7 = this.f5054O000000o;
                if (this.O00000o0.getStrokeWidth() > 0.0f) {
                    f7 -= this.O00000o0.getStrokeWidth() / 2.0f;
                }
                for (int i6 = 0; i6 < i; i6++) {
                    float f8 = (((float) i6) * f4) + f6;
                    if (this.O0000OoO == 0) {
                        f2 = f5;
                    } else {
                        f2 = f8;
                        f8 = f5;
                    }
                    if (this.O00000Oo.getAlpha() > 0) {
                        canvas2.drawCircle(f8, f2, f7, this.O00000Oo);
                    }
                    float f9 = this.f5054O000000o;
                    if (f7 != f9) {
                        canvas2.drawCircle(f8, f2, f9, this.O00000o0);
                    }
                }
                float f10 = ((float) (this.O0000o0 ? this.O0000OOo : this.O0000O0o)) * f4;
                if (!this.O0000o0) {
                    f10 += this.O0000Oo0 * f4;
                }
                if (this.O0000OoO == 0) {
                    f = f10 + f6;
                } else {
                    float f11 = f5;
                    f5 = f10 + f6;
                    f = f11;
                }
                canvas2.drawCircle(f, f5, this.f5054O000000o, this.O00000o);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        ViewPager viewPager = this.O00000oO;
        int i = 0;
        if (viewPager == null || viewPager.getAdapter().getCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x = motionEvent.getX(motionEvent.findPointerIndex(this.O0000o));
                    float f = x - this.O0000o0o;
                    if (!this.O0000oO0 && Math.abs(f) > ((float) this.O0000o0O)) {
                        this.O0000oO0 = true;
                    }
                    if (this.O0000oO0) {
                        this.O0000o0o = x;
                        if (this.O00000oO.isFakeDragging() || this.O00000oO.beginFakeDrag()) {
                            this.O00000oO.fakeDragBy(f);
                        }
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        this.O0000o0o = motionEvent.getX(actionIndex);
                        this.O0000o = motionEvent.getPointerId(actionIndex);
                    } else if (action == 6) {
                        int actionIndex2 = motionEvent.getActionIndex();
                        if (motionEvent.getPointerId(actionIndex2) == this.O0000o) {
                            if (actionIndex2 == 0) {
                                i = 1;
                            }
                            this.O0000o = motionEvent.getPointerId(i);
                        }
                        this.O0000o0o = motionEvent.getX(motionEvent.findPointerIndex(this.O0000o));
                    }
                }
            }
            if (!this.O0000oO0) {
                int count = this.O00000oO.getAdapter().getCount();
                float width = (float) getWidth();
                float f2 = width / 2.0f;
                float f3 = width / 6.0f;
                if (this.O0000O0o > 0 && motionEvent.getX() < f2 - f3) {
                    if (action != 3) {
                        this.O00000oO.setCurrentItem(this.O0000O0o - 1);
                    }
                    return true;
                } else if (this.O0000O0o < count - 1 && motionEvent.getX() > f2 + f3) {
                    if (action != 3) {
                        this.O00000oO.setCurrentItem(this.O0000O0o + 1);
                    }
                    return true;
                }
            }
            this.O0000oO0 = false;
            this.O0000o = -1;
            if (this.O00000oO.isFakeDragging()) {
                this.O00000oO.endFakeDrag();
            }
        } else {
            this.O0000o = motionEvent.getPointerId(0);
            this.O0000o0o = motionEvent.getX();
        }
        return true;
    }

    public void setViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.O00000oO;
        if (viewPager2 != viewPager) {
            if (viewPager2 != null) {
                viewPager2.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() != null) {
                this.O00000oO = viewPager;
                this.O00000oO.setOnPageChangeListener(this);
                invalidate();
                return;
            }
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
    }

    public void setCurrentItem(int i) {
        ViewPager viewPager = this.O00000oO;
        if (viewPager != null) {
            viewPager.setCurrentItem(i);
            this.O0000O0o = i;
            invalidate();
            return;
        }
        throw new IllegalStateException("ViewPager has not been bound.");
    }

    public void onPageScrollStateChanged(int i) {
        this.O0000Oo = i;
        ViewPager.O0000O0o o0000O0o = this.O00000oo;
        if (o0000O0o != null) {
            o0000O0o.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        this.O0000O0o = i % this.O0000oO;
        this.O0000Oo0 = f;
        invalidate();
        ViewPager.O0000O0o o0000O0o = this.O00000oo;
        if (o0000O0o != null) {
            o0000O0o.onPageScrolled(i, f, i2);
        }
    }

    public void onPageSelected(int i) {
        if (this.O0000o0 || this.O0000Oo == 0) {
            int i2 = this.O0000oO;
            this.O0000O0o = i % i2;
            this.O0000OOo = i % i2;
            invalidate();
        }
        ViewPager.O0000O0o o0000O0o = this.O00000oo;
        if (o0000O0o != null) {
            o0000O0o.onPageSelected(i % this.O0000oO);
        }
    }

    public void setOnPageChangeListener(ViewPager.O0000O0o o0000O0o) {
        this.O00000oo = o0000O0o;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.O0000OoO == 0) {
            setMeasuredDimension(O000000o(i), O00000Oo(i2));
        } else {
            setMeasuredDimension(O00000Oo(i), O000000o(i2));
        }
    }

    private int O000000o(int i) {
        ViewPager viewPager;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824 || (viewPager = this.O00000oO) == null) {
            return size;
        }
        int count = viewPager.getAdapter().getCount();
        float f = this.f5054O000000o;
        int paddingLeft = (int) (((float) (getPaddingLeft() + getPaddingRight())) + (((float) (count * 2)) * f) + (((float) (count - 1)) * f) + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingLeft, size) : paddingLeft;
    }

    private int O00000Oo(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = (int) ((this.f5054O000000o * 2.0f) + ((float) getPaddingTop()) + ((float) getPaddingBottom()) + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.O0000O0o = savedState.f5055O000000o;
        this.O0000OOo = savedState.f5055O000000o;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f5055O000000o = this.O0000O0o;
        return savedState;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.mi.global.shop.widget.vpi.CirclePageIndicator.SavedState.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (byte) 0);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        int f5055O000000o;

        /* synthetic */ SavedState(Parcel parcel, byte b) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f5055O000000o = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f5055O000000o);
        }
    }
}
