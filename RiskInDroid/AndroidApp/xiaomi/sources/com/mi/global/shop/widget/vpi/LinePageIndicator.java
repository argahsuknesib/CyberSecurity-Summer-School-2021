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

public class LinePageIndicator extends View implements ccm {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Paint f5056O000000o;
    private final Paint O00000Oo;
    private ViewPager.O0000O0o O00000o;
    private ViewPager O00000o0;
    private int O00000oO;
    private boolean O00000oo;
    private float O0000O0o;
    private float O0000OOo;
    private int O0000Oo;
    private float O0000Oo0;
    private float O0000OoO;
    private int O0000Ooo;
    private int O0000o0;
    private boolean O0000o00;

    public LinePageIndicator(Context context) {
        this(context, null);
    }

    public LinePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.vpiLinePageIndicatorStyle);
    }

    public LinePageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5056O000000o = new Paint(1);
        this.O00000Oo = new Paint(1);
        this.O0000OoO = -1.0f;
        this.O0000Ooo = -1;
        if (!isInEditMode()) {
            Resources resources = getResources();
            int color = resources.getColor(R.color.default_line_indicator_selected_color);
            int color2 = resources.getColor(R.color.default_line_indicator_unselected_color);
            float dimension = resources.getDimension(R.dimen.default_line_indicator_line_width);
            float dimension2 = resources.getDimension(R.dimen.default_line_indicator_line_height);
            float dimension3 = resources.getDimension(R.dimen.default_line_indicator_gap_width);
            float dimension4 = resources.getDimension(R.dimen.default_line_indicator_stroke_width);
            boolean z = resources.getBoolean(R.bool.default_line_indicator_centered);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842964, R.attr.centered, R.attr.gapWidth, R.attr.lineHeight, R.attr.lineWidth, R.attr.selectedColor, R.attr.strokeWidth, R.attr.unselectedColor}, i, 0);
            this.O00000oo = obtainStyledAttributes.getBoolean(1, z);
            this.O0000O0o = obtainStyledAttributes.getDimension(4, dimension);
            this.O0000OOo = obtainStyledAttributes.getDimension(3, dimension2);
            this.O0000Oo0 = obtainStyledAttributes.getDimension(2, dimension3);
            setStrokeWidth(obtainStyledAttributes.getDimension(6, dimension4));
            this.f5056O000000o.setColor(obtainStyledAttributes.getColor(7, color2));
            this.O00000Oo.setColor(obtainStyledAttributes.getColor(5, color));
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            if (drawable != null) {
                setBackgroundDrawable(drawable);
            }
            obtainStyledAttributes.recycle();
            this.O0000Oo = cc.O000000o(ViewConfiguration.get(context));
        }
    }

    public void setCentered(boolean z) {
        this.O00000oo = z;
        invalidate();
    }

    public void setRealCount(int i) {
        this.O0000o0 = i;
    }

    public void setUnselectedColor(int i) {
        this.f5056O000000o.setColor(i);
        invalidate();
    }

    public int getUnselectedColor() {
        return this.f5056O000000o.getColor();
    }

    public void setSelectedColor(int i) {
        this.O00000Oo.setColor(i);
        invalidate();
    }

    public int getSelectedColor() {
        return this.O00000Oo.getColor();
    }

    public void setLineWidth(float f) {
        this.O0000O0o = f;
        invalidate();
    }

    public float getLineWidth() {
        return this.O0000O0o;
    }

    public void setStrokeWidth(float f) {
        this.O00000Oo.setStrokeWidth(f);
        this.f5056O000000o.setStrokeWidth(f);
        invalidate();
    }

    public float getStrokeWidth() {
        return this.O00000Oo.getStrokeWidth();
    }

    public void setGapWidth(float f) {
        this.O0000Oo0 = f;
        invalidate();
    }

    public float getGapWidth() {
        return this.O0000Oo0;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        ViewPager viewPager = this.O00000o0;
        if (viewPager != null) {
            if (viewPager.getAdapter() instanceof BasePageIndicatorAdapter) {
                i = ((BasePageIndicatorAdapter) this.O00000o0.getAdapter()).O000000o();
            } else {
                i = this.O00000o0.getAdapter().getCount();
            }
            if (i != 0) {
                this.O0000o0 = i;
                if (this.O00000oO >= i) {
                    setCurrentItem(i - 1);
                    return;
                }
                float f = this.O0000O0o;
                float f2 = this.O0000Oo0;
                float f3 = f + f2;
                float f4 = (((float) i) * f3) - f2;
                float paddingTop = (float) getPaddingTop();
                float paddingLeft = (float) getPaddingLeft();
                float paddingRight = (float) getPaddingRight();
                float height = paddingTop + (((((float) getHeight()) - paddingTop) - ((float) getPaddingBottom())) / 2.0f);
                if (this.O00000oo) {
                    paddingLeft += (((((float) getWidth()) - paddingLeft) - paddingRight) / 2.0f) - (f4 / 2.0f);
                }
                int i2 = 0;
                while (i2 < i) {
                    float f5 = paddingLeft + (((float) i2) * f3);
                    canvas.drawRect(f5, height, f5 + this.O0000O0o, height + this.O0000OOo, i2 == this.O00000oO ? this.O00000Oo : this.f5056O000000o);
                    i2++;
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        ViewPager viewPager = this.O00000o0;
        int i = 0;
        if (viewPager == null || viewPager.getAdapter().getCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x = motionEvent.getX(motionEvent.findPointerIndex(this.O0000Ooo));
                    float f = x - this.O0000OoO;
                    if (!this.O0000o00 && Math.abs(f) > ((float) this.O0000Oo)) {
                        this.O0000o00 = true;
                    }
                    if (this.O0000o00) {
                        this.O0000OoO = x;
                        if (this.O00000o0.isFakeDragging() || this.O00000o0.beginFakeDrag()) {
                            this.O00000o0.fakeDragBy(f);
                        }
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        this.O0000OoO = motionEvent.getX(actionIndex);
                        this.O0000Ooo = motionEvent.getPointerId(actionIndex);
                    } else if (action == 6) {
                        int actionIndex2 = motionEvent.getActionIndex();
                        if (motionEvent.getPointerId(actionIndex2) == this.O0000Ooo) {
                            if (actionIndex2 == 0) {
                                i = 1;
                            }
                            this.O0000Ooo = motionEvent.getPointerId(i);
                        }
                        this.O0000OoO = motionEvent.getX(motionEvent.findPointerIndex(this.O0000Ooo));
                    }
                }
            }
            if (!this.O0000o00) {
                int count = this.O00000o0.getAdapter().getCount();
                float width = (float) getWidth();
                float f2 = width / 2.0f;
                float f3 = width / 6.0f;
                if (this.O00000oO > 0 && motionEvent.getX() < f2 - f3) {
                    if (action != 3) {
                        this.O00000o0.setCurrentItem(this.O00000oO - 1);
                    }
                    return true;
                } else if (this.O00000oO < count - 1 && motionEvent.getX() > f2 + f3) {
                    if (action != 3) {
                        this.O00000o0.setCurrentItem(this.O00000oO + 1);
                    }
                    return true;
                }
            }
            this.O0000o00 = false;
            this.O0000Ooo = -1;
            try {
                if (this.O00000o0.isFakeDragging()) {
                    this.O00000o0.endFakeDrag();
                }
            } catch (NullPointerException unused) {
            }
        } else {
            this.O0000Ooo = motionEvent.getPointerId(0);
            this.O0000OoO = motionEvent.getX();
        }
        return true;
    }

    public void setViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.O00000o0;
        if (viewPager2 != viewPager) {
            if (viewPager2 != null) {
                viewPager2.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() != null) {
                this.O00000o0 = viewPager;
                this.O00000o0.setOnPageChangeListener(this);
                invalidate();
                return;
            }
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
    }

    public void setCurrentItem(int i) {
        ViewPager viewPager = this.O00000o0;
        if (viewPager != null) {
            viewPager.setCurrentItem(i);
            this.O00000oO = i;
            invalidate();
            return;
        }
        throw new IllegalStateException("ViewPager has not been bound.");
    }

    public void onPageScrollStateChanged(int i) {
        ViewPager.O0000O0o o0000O0o = this.O00000o;
        if (o0000O0o != null) {
            o0000O0o.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.O0000O0o o0000O0o = this.O00000o;
        if (o0000O0o != null) {
            o0000O0o.onPageScrolled(i, f, i2);
        }
    }

    public void onPageSelected(int i) {
        this.O00000oO = i % this.O0000o0;
        invalidate();
        ViewPager.O0000O0o o0000O0o = this.O00000o;
        if (o0000O0o != null) {
            o0000O0o.onPageSelected(i);
        }
    }

    public void setOnPageChangeListener(ViewPager.O0000O0o o0000O0o) {
        this.O00000o = o0000O0o;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.O00000oO = savedState.f5057O000000o;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f5057O000000o = this.O00000oO;
        return savedState;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.mi.global.shop.widget.vpi.LinePageIndicator.SavedState.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (byte) 0);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        int f5057O000000o;

        /* synthetic */ SavedState(Parcel parcel, byte b) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f5057O000000o = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f5057O000000o);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        float f;
        float f2;
        ViewPager viewPager;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824 || (viewPager = this.O00000o0) == null) {
            f = (float) size;
        } else {
            int count = viewPager.getAdapter().getCount();
            f = ((float) (getPaddingLeft() + getPaddingRight())) + (((float) count) * this.O0000O0o) + (((float) (count - 1)) * this.O0000Oo0);
            if (mode == Integer.MIN_VALUE) {
                f = Math.min(f, (float) size);
            }
        }
        int ceil = (int) Math.ceil((double) f);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == 1073741824) {
            f2 = (float) size2;
        } else {
            float strokeWidth = this.O00000Oo.getStrokeWidth() + ((float) getPaddingTop()) + ((float) getPaddingBottom());
            f2 = mode2 == Integer.MIN_VALUE ? Math.min(strokeWidth, (float) size2) : strokeWidth;
        }
        setMeasuredDimension(ceil, (int) Math.ceil((double) f2));
    }
}
