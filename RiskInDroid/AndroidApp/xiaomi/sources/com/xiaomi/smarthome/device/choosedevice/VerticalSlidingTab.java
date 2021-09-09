package com.xiaomi.smarthome.device.choosedevice;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import java.util.List;
import java.util.Locale;

public class VerticalSlidingTab extends ScrollView {

    /* renamed from: O000000o  reason: collision with root package name */
    public LinearLayout f7275O000000o;
    public int O00000Oo;
    private LinearLayout.LayoutParams O00000o;
    public O000000o O00000o0;
    private RelativeLayout O00000oO;
    private int O00000oo;
    private int O0000O0o;
    private boolean O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;
    private int O0000OoO;
    private int O0000Ooo;
    private int O0000o;
    private Typeface O0000o0;
    private int O0000o00;
    private int O0000o0O;
    private int O0000o0o;
    private Scroller O0000oO;
    private Locale O0000oO0;
    private List<String> O0000oOO;

    public interface O000000o {
    }

    public VerticalSlidingTab(Context context) {
        this(context, null);
    }

    public VerticalSlidingTab(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerticalSlidingTab(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000Oo = 0;
        this.O0000O0o = -10066330;
        this.O0000OOo = false;
        this.O0000Oo0 = 100;
        this.O0000Oo = 0;
        this.O0000OoO = 0;
        this.O0000Ooo = 0;
        this.O0000o00 = 12;
        this.O0000o0 = null;
        this.O0000o0O = 0;
        this.O0000o0o = 0;
        this.O0000o = R.drawable.background_tab;
        setFillViewport(true);
        setWillNotDraw(false);
        this.O00000oO = new RelativeLayout(context);
        this.O00000oO.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.O00000oO);
        this.f7275O000000o = new LinearLayout(context);
        this.f7275O000000o.setOrientation(1);
        this.f7275O000000o.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.O00000oO.addView(this.f7275O000000o);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.O0000Oo0 = (int) TypedValue.applyDimension(1, (float) this.O0000Oo0, displayMetrics);
        this.O0000Oo = (int) TypedValue.applyDimension(1, (float) this.O0000Oo, displayMetrics);
        this.O0000OoO = (int) TypedValue.applyDimension(1, (float) this.O0000OoO, displayMetrics);
        this.O0000Ooo = (int) TypedValue.applyDimension(1, (float) this.O0000Ooo, displayMetrics);
        this.O0000o00 = (int) TypedValue.applyDimension(2, (float) this.O0000o00, displayMetrics);
        this.O0000Oo0 = (int) (((float) displayMetrics.heightPixels) * 0.5f);
        this.O00000o = new LinearLayout.LayoutParams(-1, -1);
        if (this.O0000oO0 == null) {
            this.O0000oO0 = getResources().getConfiguration().locale;
        }
        this.O0000oO = new Scroller(context);
    }

    public void setOnTabPositionChangeListener(O000000o o000000o) {
        this.O00000o0 = o000000o;
    }

    public final void O000000o() {
        for (int i = 0; i < this.O00000oo; i++) {
            View childAt = ((ViewGroup) this.f7275O000000o.getChildAt(i)).getChildAt(0);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (i == this.O00000Oo) {
                    textView.setTextColor(getResources().getColor(R.color.mj_color_white));
                    textView.setBackgroundResource(R.drawable.radius_13_blue_shaper);
                } else {
                    textView.setTextColor(getResources().getColor(R.color.mj_color_black));
                    textView.setBackgroundColor(0);
                }
            }
        }
    }

    public int getCurrentPosition() {
        return this.O00000Oo;
    }

    public final void O000000o(int i) {
        int i2;
        if (this.O00000oo != 0) {
            O000000o();
            int top = this.f7275O000000o.getChildAt(i).getTop();
            int i3 = this.O0000o0o;
            if ((top <= i3 || top <= this.O0000Oo0) && (top >= (i3 = this.O0000o0o) || top >= this.O0000Oo0)) {
                i2 = 0;
            } else {
                i2 = top - i3;
            }
            scrollTo(0, top - this.O0000Oo0);
            this.O0000o0o = top;
            if (i2 != 0) {
                this.O0000oO.startScroll(getScrollX(), getScrollY(), 0, i2, 300);
                invalidate();
            }
        }
    }

    public void computeScroll() {
        if (this.O0000oO.computeScrollOffset()) {
            scrollTo(this.O0000oO.getCurrX(), this.O0000oO.getCurrY());
            postInvalidate();
            return;
        }
        super.computeScroll();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.widget.LinearLayout, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void setTabNames(List<String> list) {
        this.O0000oOO = list;
        this.f7275O000000o.removeAllViews();
        this.O00000oo = this.O0000oOO.size();
        for (final int i = 0; i < this.O00000oo; i++) {
            View inflate = LayoutInflater.from(getContext()).inflate((int) R.layout.choose_device_left_list_item, (ViewGroup) this.f7275O000000o, false);
            ((TextView) inflate.findViewById(R.id.name)).setText(this.O0000oOO.get(i));
            inflate.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.device.choosedevice.VerticalSlidingTab.AnonymousClass1 */

                public final void onClick(View view) {
                    VerticalSlidingTab verticalSlidingTab = VerticalSlidingTab.this;
                    int i = i;
                    verticalSlidingTab.f7275O000000o.getChildAt(i).getHeight();
                    verticalSlidingTab.O000000o(i);
                    VerticalSlidingTab verticalSlidingTab2 = VerticalSlidingTab.this;
                    verticalSlidingTab2.O00000Oo = i;
                    verticalSlidingTab2.O000000o();
                }
            });
            this.f7275O000000o.addView(inflate, i);
        }
        O000000o();
    }

    public void setCurrentPosition(int i) {
        if (i != this.O00000Oo) {
            this.O00000Oo = i;
            if (this.f7275O000000o.getChildCount() != 0) {
                this.f7275O000000o.getChildAt(i).getHeight();
                O000000o(i);
            }
        }
    }

    public void setIndicatorColor(int i) {
        this.O0000O0o = i;
        invalidate();
    }

    public void setIndicatorColorResource(int i) {
        this.O0000O0o = getResources().getColor(i);
        invalidate();
    }

    public int getIndicatorColor() {
        return this.O0000O0o;
    }

    public void setIndicatorWidth(int i) {
        this.O0000Oo = i;
        invalidate();
    }

    public int getIndicatorWidth() {
        return this.O0000Oo;
    }

    public void setScrollOffset(int i) {
        this.O0000Oo0 = i;
        invalidate();
    }

    public int getScrollOffset() {
        return this.O0000Oo0;
    }

    public void setShouldExpand(boolean z) {
        this.O0000OOo = z;
        requestLayout();
    }

    public boolean getShouldExpand() {
        return this.O0000OOo;
    }

    public void setTextSize(int i) {
        this.O0000o00 = i;
        O000000o();
    }

    public int getTextSize() {
        return this.O0000o00;
    }

    public void setTabBackground(int i) {
        this.O0000o = i;
    }

    public int getTabBackground() {
        return this.O0000o;
    }

    public void setTabPaddingLeftRight(int i) {
        this.O0000OoO = i;
        O000000o();
    }

    public int getTabPaddingLeftRight() {
        return this.O0000OoO;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.O00000Oo = savedState.f7277O000000o;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f7277O000000o = this.O00000Oo;
        return savedState;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.xiaomi.smarthome.device.choosedevice.VerticalSlidingTab.SavedState.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (byte) 0);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        int f7277O000000o;

        /* synthetic */ SavedState(Parcel parcel, byte b) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f7277O000000o = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f7277O000000o);
        }
    }
}
