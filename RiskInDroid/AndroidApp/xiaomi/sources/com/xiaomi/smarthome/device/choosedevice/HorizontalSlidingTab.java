package com.xiaomi.smarthome.device.choosedevice;

import _m_j.gpc;
import _m_j.hxi;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.xiaomi.smarthome.R;
import java.util.Locale;

public class HorizontalSlidingTab extends HorizontalScrollView {

    /* renamed from: O000000o  reason: collision with root package name */
    public RelativeLayout.LayoutParams f7252O000000o;
    public ViewPager.O0000O0o O00000Oo;
    public LinearLayout O00000o;
    public RelativeLayout O00000o0;
    public ViewPager O00000oO;
    public int O00000oo;
    public float O0000O0o;
    public int O0000OOo;
    private final O000000o O0000Oo;
    public TextView O0000Oo0;
    private int O0000OoO;
    private Paint O0000Ooo;
    private int O0000o;
    private int O0000o0;
    private int O0000o00;
    private int O0000o0O;
    private int O0000o0o;
    private int O0000oO;
    private int O0000oO0;
    private Typeface O0000oOO;
    private int O0000oOo;
    private Locale O0000oo;
    private int O0000oo0;
    private int O0000ooO;

    public HorizontalSlidingTab(Context context) {
        this(context, null);
    }

    public HorizontalSlidingTab(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalSlidingTab(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000Oo = new O000000o(this, (byte) 0);
        this.O00000oo = 0;
        this.O0000O0o = 0.0f;
        this.O0000o00 = 6710886;
        this.O0000o0 = 52;
        this.O0000o0O = 2;
        this.O0000o0o = 12;
        this.O0000OOo = 24;
        this.O0000o = 15;
        this.O0000oO0 = -8421505;
        this.O0000oO = -16737793;
        this.O0000oOO = null;
        this.O0000oOo = 0;
        this.O0000oo0 = 0;
        this.O0000ooO = 0;
        setFillViewport(true);
        setWillNotDraw(false);
        this.O00000o0 = new RelativeLayout(context);
        this.O00000o0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.O00000o0);
        this.O00000o = new LinearLayout(context);
        this.O00000o.setOrientation(0);
        this.O00000o.setGravity(16);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(13);
        this.O00000o.setLayoutParams(layoutParams);
        this.O00000o0.addView(this.O00000o);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.O0000o0 = (int) TypedValue.applyDimension(1, (float) this.O0000o0, displayMetrics);
        this.O0000o0O = (int) TypedValue.applyDimension(1, (float) this.O0000o0O, displayMetrics);
        this.O0000o0o = (int) TypedValue.applyDimension(1, (float) this.O0000o0o, displayMetrics);
        this.O0000OOo = (int) TypedValue.applyDimension(1, (float) this.O0000OOo, displayMetrics);
        this.O0000o = (int) TypedValue.applyDimension(1, (float) this.O0000o, displayMetrics);
        this.O0000Ooo = new Paint();
        this.O0000Ooo.setAntiAlias(true);
        this.O0000Ooo.setStyle(Paint.Style.FILL);
        this.O0000Oo0 = new TextView(context);
        this.O0000Oo0.setTextColor(-1);
        this.O0000Oo0.setTextSize(2, 10.0f);
        this.O0000Oo0.setGravity(17);
        this.O0000Oo0.setBackgroundResource(R.drawable.number_icon_nor_3x);
        this.f7252O000000o = new RelativeLayout.LayoutParams(-2, -2);
        if (this.O0000oo == null) {
            this.O0000oo = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.O00000oO = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.O0000Oo);
            O00000Oo();
            return;
        }
        throw new IllegalStateException("ViewPager does not have adapter instance.");
    }

    public void setOnPageChangeListener(ViewPager.O0000O0o o0000O0o) {
        this.O00000Oo = o0000O0o;
    }

    private void O00000Oo() {
        this.O00000o.removeAllViews();
        this.O0000OoO = this.O00000oO.getAdapter().getCount();
        final int i = 0;
        while (i < this.O0000OoO) {
            String charSequence = this.O00000oO.getAdapter().getPageTitle(i).toString();
            TextView textView = new TextView(getContext());
            textView.setText(charSequence);
            textView.setFocusable(true);
            textView.setMaxLines(2);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.device.choosedevice.HorizontalSlidingTab.AnonymousClass2 */

                public final void onClick(View view) {
                    if (i == 0) {
                        hxi.O00000o.f952O000000o.O000000o("add_navigation_near", new Object[0]);
                    } else {
                        hxi.O00000o.f952O000000o.O000000o("add_navigation_add", new Object[0]);
                    }
                    HorizontalSlidingTab.this.O00000oO.setCurrentItem(i);
                }
            });
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getWidth() / 2, -2);
            layoutParams.gravity = 16;
            if (i == 0) {
                textView.setPadding(0, 0, this.O0000OOo, 0);
            } else {
                textView.setPadding(this.O0000OOo, 0, 0, 0);
            }
            textView.setGravity(i == 0 ? 8388613 : 8388611);
            textView.setLayoutParams(layoutParams);
            this.O00000o.addView(textView, i);
            i++;
        }
        O000000o();
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.xiaomi.smarthome.device.choosedevice.HorizontalSlidingTab.AnonymousClass1 */

            @SuppressLint({"NewApi"})
            public final void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < 16) {
                    HorizontalSlidingTab.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    HorizontalSlidingTab.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                HorizontalSlidingTab.this.f7252O000000o.setMargins((HorizontalSlidingTab.this.O00000o.getChildAt(0).getRight() + gpc.O000000o(2.0f)) - HorizontalSlidingTab.this.O0000OOo, HorizontalSlidingTab.this.O00000o.getChildAt(0).getBottom() - gpc.O000000o(23.0f), 0, 0);
                HorizontalSlidingTab.this.O00000o0.addView(HorizontalSlidingTab.this.O0000Oo0, HorizontalSlidingTab.this.f7252O000000o);
                HorizontalSlidingTab.this.O0000Oo0.setVisibility(4);
                HorizontalSlidingTab horizontalSlidingTab = HorizontalSlidingTab.this;
                horizontalSlidingTab.O00000oo = horizontalSlidingTab.O00000oO.getCurrentItem();
                HorizontalSlidingTab horizontalSlidingTab2 = HorizontalSlidingTab.this;
                horizontalSlidingTab2.O000000o(horizontalSlidingTab2.O00000oo, 0);
            }
        });
    }

    public final void O000000o() {
        for (int i = 0; i < this.O0000OoO; i++) {
            View childAt = this.O00000o.getChildAt(i);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                textView.setTextSize(0, (float) this.O0000o);
                textView.setTypeface(this.O0000oOO, this.O0000oOo);
                if (i == this.O00000oo) {
                    textView.setTextColor(this.O0000oO);
                } else {
                    textView.setTextColor(this.O0000oO0);
                }
            }
            if (i == 0 && this.O0000Oo0.getParent() != null) {
                if (this.O0000ooO == 0) {
                    this.O0000Oo0.setVisibility(4);
                } else {
                    this.O0000Oo0.setVisibility(0);
                    this.O0000Oo0.setText(String.valueOf(this.O0000ooO));
                }
            }
        }
    }

    public final void O000000o(int i, int i2) {
        if (this.O0000OoO != 0) {
            int left = this.O00000o.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.O0000o0;
            }
            if (left != this.O0000oo0) {
                this.O0000oo0 = left;
                scrollTo(left, 0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (!isInEditMode() && this.O0000OoO != 0) {
            int height = getHeight();
            this.O0000Ooo.setColor(this.O0000o00);
            View childAt = this.O00000o.getChildAt(this.O00000oo);
            float left = (float) childAt.getLeft();
            float right = (float) childAt.getRight();
            if (this.O0000O0o > 0.0f && (i = this.O00000oo) < this.O0000OoO - 1) {
                View childAt2 = this.O00000o.getChildAt(i + 1);
                float f = this.O0000O0o;
                left = (((float) childAt2.getLeft()) * f) + ((1.0f - f) * left);
                right = (((float) childAt2.getRight()) * f) + ((1.0f - f) * right);
            }
            canvas.drawRect(left, (float) (height - this.O0000o0O), right, (float) height, this.O0000Ooo);
        }
    }

    class O000000o implements ViewPager.O0000O0o {
        private O000000o() {
        }

        /* synthetic */ O000000o(HorizontalSlidingTab horizontalSlidingTab, byte b) {
            this();
        }

        public final void onPageScrolled(int i, float f, int i2) {
            HorizontalSlidingTab horizontalSlidingTab = HorizontalSlidingTab.this;
            horizontalSlidingTab.O00000oo = i;
            horizontalSlidingTab.O0000O0o = f;
            horizontalSlidingTab.O000000o(i, (int) (((float) horizontalSlidingTab.O00000o.getChildAt(i).getWidth()) * f));
            HorizontalSlidingTab.this.invalidate();
            if (HorizontalSlidingTab.this.O00000Oo != null) {
                HorizontalSlidingTab.this.O00000Oo.onPageScrolled(i, f, i2);
            }
        }

        public final void onPageScrollStateChanged(int i) {
            if (i == 0) {
                HorizontalSlidingTab horizontalSlidingTab = HorizontalSlidingTab.this;
                horizontalSlidingTab.O000000o(horizontalSlidingTab.O00000oO.getCurrentItem(), 0);
            }
            if (HorizontalSlidingTab.this.O00000Oo != null) {
                HorizontalSlidingTab.this.O00000Oo.onPageScrollStateChanged(i);
            }
        }

        public final void onPageSelected(int i) {
            HorizontalSlidingTab horizontalSlidingTab = HorizontalSlidingTab.this;
            horizontalSlidingTab.O00000oo = i;
            horizontalSlidingTab.O000000o();
            if (HorizontalSlidingTab.this.O00000Oo != null) {
                HorizontalSlidingTab.this.O00000Oo.onPageSelected(i);
            }
        }
    }

    public int getPosition() {
        return this.O00000oo;
    }

    public void setDividerPadding(int i) {
        this.O0000o0o = i;
        invalidate();
    }

    public int getDividerPadding() {
        return this.O0000o0o;
    }

    public void setScanDeviceCount(int i) {
        this.O0000ooO = i;
        O000000o();
    }

    public void setTextSize(int i) {
        this.O0000o = i;
        O000000o();
    }

    public int getTextSize() {
        return this.O0000o;
    }

    public void setTextColor(int i) {
        this.O0000oO0 = i;
        O000000o();
    }

    public int getTextColor() {
        return this.O0000oO0;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.O00000oo = savedState.f7256O000000o;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f7256O000000o = this.O00000oo;
        return savedState;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.xiaomi.smarthome.device.choosedevice.HorizontalSlidingTab.SavedState.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (byte) 0);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        int f7256O000000o;

        /* synthetic */ SavedState(Parcel parcel, byte b) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f7256O000000o = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f7256O000000o);
        }
    }
}
