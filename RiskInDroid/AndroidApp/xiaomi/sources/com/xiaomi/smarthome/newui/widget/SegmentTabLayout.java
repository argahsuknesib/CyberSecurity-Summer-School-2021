package com.xiaomi.smarthome.newui.widget;

import _m_j.ei;
import _m_j.gpe;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.xiaomi.smarthome.R;

public class SegmentTabLayout extends FrameLayout implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f10327O000000o;
    public O00000Oo O00000Oo;
    private String[] O00000o;
    private Context O00000o0;
    private LinearLayout O00000oO;
    private int O00000oo;
    private int O0000O0o;
    private Rect O0000OOo;
    private GradientDrawable O0000Oo;
    private GradientDrawable O0000Oo0;
    private Paint O0000OoO;
    private float O0000Ooo;
    private float O0000o;
    private float O0000o0;
    private boolean O0000o00;
    private int O0000o0O;
    private float O0000o0o;
    private float O0000oO;
    private float O0000oO0;
    private float O0000oOO;
    private float O0000oOo;
    private boolean O0000oo;
    private long O0000oo0;
    private boolean O0000ooO;
    private int O0000ooo;
    private float O000O00o;
    private int O000O0OO;
    private int O000O0Oo;
    private int O000O0o;
    private boolean O000O0o0;
    private int O000O0oO;
    private float O000O0oo;
    private OvershootInterpolator O000OO;
    private int O000OO00;
    private ValueAnimator O000OO0o;
    private gpe O000OOOo;
    private boolean O000OOo;
    private float[] O000OOo0;
    private Paint O000OOoO;
    private SparseArray<Boolean> O000OOoo;
    private O000000o O000Oo0;
    private O000000o O000Oo00;
    private int O00oOoOo;
    private float O00oOooO;
    private float O00oOooo;

    public interface O00000Oo {
    }

    public SegmentTabLayout(Context context) {
        this(context, null, 0);
    }

    public SegmentTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SegmentTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000OOo = new Rect();
        this.O0000Oo0 = new GradientDrawable();
        this.O0000Oo = new GradientDrawable();
        this.O0000OoO = new Paint(1);
        this.O000OO = new OvershootInterpolator(0.8f);
        this.O000OOo0 = new float[8];
        this.O000OOo = true;
        this.O000OOoO = new Paint(1);
        this.O000OOoo = new SparseArray<>();
        this.O000Oo00 = new O000000o();
        this.O000Oo0 = new O000000o();
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.O00000o0 = context;
        this.O00000oO = new LinearLayout(context);
        addView(this.O00000oO);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.tl_bar_color, R.attr.tl_bar_stroke_color, R.attr.tl_bar_stroke_width, R.attr.tl_divider_color, R.attr.tl_divider_padding, R.attr.tl_divider_width, R.attr.tl_indicator_anim_duration, R.attr.tl_indicator_anim_enable, R.attr.tl_indicator_bounce_enable, R.attr.tl_indicator_color, R.attr.tl_indicator_corner_radius, R.attr.tl_indicator_height, R.attr.tl_indicator_margin_bottom, R.attr.tl_indicator_margin_left, R.attr.tl_indicator_margin_right, R.attr.tl_indicator_margin_top, R.attr.tl_tab_padding, R.attr.tl_tab_space_equal, R.attr.tl_tab_width, R.attr.tl_textAllCaps, R.attr.tl_textBold, R.attr.tl_textSelectColor, R.attr.tl_textUnselectColor, R.attr.tl_textsize});
        this.O0000o0O = obtainStyledAttributes.getColor(9, Color.parseColor("#222831"));
        this.O0000o0o = obtainStyledAttributes.getDimension(11, -1.0f);
        this.O0000o = obtainStyledAttributes.getDimension(10, -1.0f);
        this.O0000oO0 = obtainStyledAttributes.getDimension(13, (float) O000000o(0.0f));
        this.O0000oO = obtainStyledAttributes.getDimension(15, 0.0f);
        this.O0000oOO = obtainStyledAttributes.getDimension(14, (float) O000000o(0.0f));
        this.O0000oOo = obtainStyledAttributes.getDimension(12, 0.0f);
        this.O0000oo = obtainStyledAttributes.getBoolean(7, false);
        this.O0000ooO = obtainStyledAttributes.getBoolean(8, true);
        this.O0000oo0 = (long) obtainStyledAttributes.getInt(6, -1);
        this.O0000ooo = obtainStyledAttributes.getColor(3, this.O0000o0O);
        this.O00oOooO = obtainStyledAttributes.getDimension(5, (float) O000000o(1.0f));
        this.O00oOooo = obtainStyledAttributes.getDimension(4, 0.0f);
        this.O000O00o = obtainStyledAttributes.getDimension(23, (float) O00000Oo(13.0f));
        this.O000O0OO = obtainStyledAttributes.getColor(21, Color.parseColor("#ffffff"));
        this.O000O0Oo = obtainStyledAttributes.getColor(22, this.O0000o0O);
        this.O00oOoOo = obtainStyledAttributes.getInt(20, 0);
        this.O000O0o0 = obtainStyledAttributes.getBoolean(19, false);
        this.O0000o00 = obtainStyledAttributes.getBoolean(17, true);
        this.O0000o0 = obtainStyledAttributes.getDimension(18, (float) O000000o(-1.0f));
        this.O0000Ooo = obtainStyledAttributes.getDimension(16, (float) ((this.O0000o00 || this.O0000o0 > 0.0f) ? O000000o(0.0f) : O000000o(10.0f)));
        this.O000O0o = obtainStyledAttributes.getColor(0, 0);
        this.O000O0oO = obtainStyledAttributes.getColor(1, this.O0000o0O);
        this.O000O0oo = obtainStyledAttributes.getDimension(2, (float) O000000o(1.0f));
        obtainStyledAttributes.recycle();
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (!attributeValue.equals("-1") && !attributeValue.equals("-2")) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, new int[]{16842997});
            this.O000OO00 = obtainStyledAttributes2.getDimensionPixelSize(0, -2);
            obtainStyledAttributes2.recycle();
        }
        this.O000OO0o = ValueAnimator.ofObject(new O00000o0(), this.O000Oo0, this.O000Oo00);
        this.O000OO0o.addUpdateListener(this);
    }

    public void setTabData(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalStateException("Titles can not be NULL or EMPTY !");
        }
        this.O00000o = strArr;
        O000000o();
    }

    private void O000000o() {
        this.O00000oO.removeAllViews();
        this.O0000O0o = this.O00000o.length;
        for (int i = 0; i < this.O0000O0o; i++) {
            View inflate = View.inflate(this.O00000o0, R.layout.layout_tab_segment, null);
            inflate.setTag(Integer.valueOf(i));
            ((TextView) inflate.findViewById(R.id.tv_tab_title)).setText(this.O00000o[i]);
            inflate.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.newui.widget.SegmentTabLayout.AnonymousClass1 */

                public final void onClick(View view) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (SegmentTabLayout.this.f10327O000000o != intValue) {
                        SegmentTabLayout.this.setCurrentTab(intValue);
                    }
                }
            });
            LinearLayout.LayoutParams layoutParams = this.O0000o00 ? new LinearLayout.LayoutParams(0, -1, 1.0f) : new LinearLayout.LayoutParams(-2, -1);
            float f = this.O0000o0;
            if (f > 0.0f) {
                layoutParams = new LinearLayout.LayoutParams((int) f, -1);
            }
            this.O00000oO.addView(inflate, i, layoutParams);
        }
        O00000Oo();
    }

    private void O00000Oo() {
        int i = 0;
        while (i < this.O0000O0o) {
            View childAt = this.O00000oO.getChildAt(i);
            float f = this.O0000Ooo;
            childAt.setPadding((int) f, 0, (int) f, 0);
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            textView.setTextColor(i == this.f10327O000000o ? this.O000O0OO : this.O000O0Oo);
            textView.setTextSize(0, this.O000O00o);
            if (this.O000O0o0) {
                textView.setText(textView.getText().toString().toUpperCase());
            }
            int i2 = this.O00oOoOo;
            if (i2 == 2) {
                textView.getPaint().setFakeBoldText(true);
            } else if (i2 == 0) {
                textView.getPaint().setFakeBoldText(false);
            }
            i++;
        }
    }

    private void O000000o(int i) {
        int i2 = 0;
        while (i2 < this.O0000O0o) {
            View childAt = this.O00000oO.getChildAt(i2);
            boolean z = i2 == i;
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            textView.setTextColor(z ? this.O000O0OO : this.O000O0Oo);
            if (this.O00oOoOo == 1) {
                textView.getPaint().setFakeBoldText(z);
            }
            i2++;
        }
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        O000000o o000000o = (O000000o) valueAnimator.getAnimatedValue();
        this.O0000OOo.left = (int) o000000o.f10329O000000o;
        this.O0000OOo.right = (int) o000000o.O00000Oo;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.O0000O0o > 0) {
            int height = getHeight();
            int paddingLeft = getPaddingLeft();
            if (this.O0000o0o < 0.0f) {
                this.O0000o0o = (((float) height) - this.O0000oO) - this.O0000oOo;
            }
            float f = this.O0000o;
            if (f < 0.0f || f > this.O0000o0o / 2.0f) {
                this.O0000o = this.O0000o0o / 2.0f;
            }
            this.O0000Oo.setColor(this.O000O0o);
            this.O0000Oo.setStroke((int) this.O000O0oo, this.O000O0oO);
            this.O0000Oo.setCornerRadius(this.O0000o);
            this.O0000Oo.setBounds(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
            this.O0000Oo.draw(canvas);
            if (!this.O0000oo) {
                float f2 = this.O00oOooO;
                if (f2 > 0.0f) {
                    this.O0000OoO.setStrokeWidth(f2);
                    this.O0000OoO.setColor(this.O0000ooo);
                    for (int i = 0; i < this.O0000O0o - 1; i++) {
                        View childAt = this.O00000oO.getChildAt(i);
                        canvas.drawLine((float) (childAt.getRight() + paddingLeft), this.O00oOooo, (float) (childAt.getRight() + paddingLeft), ((float) height) - this.O00oOooo, this.O0000OoO);
                    }
                }
            }
            if (this.O0000oo) {
                if (this.O000OOo) {
                    this.O000OOo = false;
                }
                this.O0000Oo0.setColor(this.O0000o0O);
                this.O0000Oo0.setBounds(((int) this.O0000oO0) + paddingLeft + this.O0000OOo.left, (int) this.O0000oO, (int) (((float) (paddingLeft + this.O0000OOo.right)) - this.O0000oOO), (int) (this.O0000oO + this.O0000o0o));
                this.O0000Oo0.setCornerRadii(this.O000OOo0);
                this.O0000Oo0.draw(canvas);
            }
            View childAt2 = this.O00000oO.getChildAt(this.f10327O000000o);
            Rect rect = this.O0000OOo;
            rect.left = (int) ((float) childAt2.getLeft());
            rect.right = (int) ((float) childAt2.getRight());
            if (!this.O0000oo) {
                int i2 = this.f10327O000000o;
                if (i2 == 0) {
                    float[] fArr = this.O000OOo0;
                    float f3 = this.O0000o;
                    fArr[0] = f3;
                    fArr[1] = f3;
                    fArr[2] = 0.0f;
                    fArr[3] = 0.0f;
                    fArr[4] = 0.0f;
                    fArr[5] = 0.0f;
                    fArr[6] = f3;
                    fArr[7] = f3;
                } else if (i2 == this.O0000O0o - 1) {
                    float[] fArr2 = this.O000OOo0;
                    fArr2[0] = 0.0f;
                    fArr2[1] = 0.0f;
                    float f4 = this.O0000o;
                    fArr2[2] = f4;
                    fArr2[3] = f4;
                    fArr2[4] = f4;
                    fArr2[5] = f4;
                    fArr2[6] = 0.0f;
                    fArr2[7] = 0.0f;
                } else {
                    float[] fArr3 = this.O000OOo0;
                    fArr3[0] = 0.0f;
                    fArr3[1] = 0.0f;
                    fArr3[2] = 0.0f;
                    fArr3[3] = 0.0f;
                    fArr3[4] = 0.0f;
                    fArr3[5] = 0.0f;
                    fArr3[6] = 0.0f;
                    fArr3[7] = 0.0f;
                }
            } else {
                float[] fArr4 = this.O000OOo0;
                float f5 = this.O0000o;
                fArr4[0] = f5;
                fArr4[1] = f5;
                fArr4[2] = f5;
                fArr4[3] = f5;
                fArr4[4] = f5;
                fArr4[5] = f5;
                fArr4[6] = f5;
                fArr4[7] = f5;
            }
            this.O0000Oo0.setColor(this.O0000o0O);
            this.O0000Oo0.setBounds(((int) this.O0000oO0) + paddingLeft + this.O0000OOo.left, (int) this.O0000oO, (int) (((float) (paddingLeft + this.O0000OOo.right)) - this.O0000oOO), (int) (this.O0000oO + this.O0000o0o));
            this.O0000Oo0.setCornerRadii(this.O000OOo0);
            this.O0000Oo0.draw(canvas);
        }
    }

    public void setCurrentTab(int i) {
        this.O00000oo = this.f10327O000000o;
        this.f10327O000000o = i;
        O000000o(i);
        gpe gpe = this.O000OOOo;
        if (gpe != null) {
            for (int i2 = 0; i2 < gpe.O00000Oo.size(); i2++) {
                ei O000000o2 = gpe.f18116O000000o.O000000o();
                Fragment fragment = gpe.O00000Oo.get(i2);
                if (i2 == i) {
                    O000000o2.O00000o0(fragment);
                } else {
                    O000000o2.O00000Oo(fragment);
                }
                O000000o2.O00000Oo();
            }
            gpe.O00000o0 = i;
        }
        if (this.O0000oo) {
            View childAt = this.O00000oO.getChildAt(this.f10327O000000o);
            this.O000Oo00.f10329O000000o = (float) childAt.getLeft();
            this.O000Oo00.O00000Oo = (float) childAt.getRight();
            View childAt2 = this.O00000oO.getChildAt(this.O00000oo);
            this.O000Oo0.f10329O000000o = (float) childAt2.getLeft();
            this.O000Oo0.O00000Oo = (float) childAt2.getRight();
            if (this.O000Oo0.f10329O000000o == this.O000Oo00.f10329O000000o && this.O000Oo0.O00000Oo == this.O000Oo00.O00000Oo) {
                invalidate();
                return;
            }
            this.O000OO0o.setObjectValues(this.O000Oo0, this.O000Oo00);
            if (this.O0000ooO) {
                this.O000OO0o.setInterpolator(this.O000OO);
            }
            if (this.O0000oo0 < 0) {
                this.O0000oo0 = this.O0000ooO ? 500 : 250;
            }
            this.O000OO0o.setDuration(this.O0000oo0);
            this.O000OO0o.start();
            return;
        }
        invalidate();
    }

    public void setTabPadding(float f) {
        this.O0000Ooo = (float) O000000o(f);
        O00000Oo();
    }

    public void setTabSpaceEqual(boolean z) {
        this.O0000o00 = z;
        O00000Oo();
    }

    public void setTabWidth(float f) {
        this.O0000o0 = (float) O000000o(f);
        O00000Oo();
    }

    public void setIndicatorColor(int i) {
        this.O0000o0O = i;
        invalidate();
    }

    public void setIndicatorHeight(float f) {
        this.O0000o0o = (float) O000000o(f);
        invalidate();
    }

    public void setIndicatorCornerRadius(float f) {
        this.O0000o = (float) O000000o(f);
        invalidate();
    }

    public void setIndicatorAnimDuration(long j) {
        this.O0000oo0 = j;
    }

    public void setIndicatorAnimEnable(boolean z) {
        this.O0000oo = z;
    }

    public void setIndicatorBounceEnable(boolean z) {
        this.O0000ooO = z;
    }

    public void setDividerColor(int i) {
        this.O0000ooo = i;
        invalidate();
    }

    public void setDividerWidth(float f) {
        this.O00oOooO = (float) O000000o(f);
        invalidate();
    }

    public void setDividerPadding(float f) {
        this.O00oOooo = (float) O000000o(f);
        invalidate();
    }

    public void setTextsize(float f) {
        this.O000O00o = (float) O00000Oo(f);
        O00000Oo();
    }

    public void setTextSelectColor(int i) {
        this.O000O0OO = i;
        O00000Oo();
    }

    public void setTextUnselectColor(int i) {
        this.O000O0Oo = i;
        O00000Oo();
    }

    public void setTextBold(int i) {
        this.O00oOoOo = i;
        O00000Oo();
    }

    public void setTextAllCaps(boolean z) {
        this.O000O0o0 = z;
        O00000Oo();
    }

    public int getTabCount() {
        return this.O0000O0o;
    }

    public int getCurrentTab() {
        return this.f10327O000000o;
    }

    public float getTabPadding() {
        return this.O0000Ooo;
    }

    public float getTabWidth() {
        return this.O0000o0;
    }

    public int getIndicatorColor() {
        return this.O0000o0O;
    }

    public float getIndicatorHeight() {
        return this.O0000o0o;
    }

    public float getIndicatorCornerRadius() {
        return this.O0000o;
    }

    public float getIndicatorMarginLeft() {
        return this.O0000oO0;
    }

    public float getIndicatorMarginTop() {
        return this.O0000oO;
    }

    public float getIndicatorMarginRight() {
        return this.O0000oOO;
    }

    public float getIndicatorMarginBottom() {
        return this.O0000oOo;
    }

    public long getIndicatorAnimDuration() {
        return this.O0000oo0;
    }

    public int getDividerColor() {
        return this.O0000ooo;
    }

    public float getDividerWidth() {
        return this.O00oOooO;
    }

    public float getDividerPadding() {
        return this.O00oOooo;
    }

    public float getTextsize() {
        return this.O000O00o;
    }

    public int getTextSelectColor() {
        return this.O000O0OO;
    }

    public int getTextUnselectColor() {
        return this.O000O0Oo;
    }

    public int getTextBold() {
        return this.O00oOoOo;
    }

    public void setOnTabSelectListener(O00000Oo o00000Oo) {
        this.O00000Oo = o00000Oo;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("mCurrentTab", this.f10327O000000o);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f10327O000000o = bundle.getInt("mCurrentTab");
            parcelable = bundle.getParcelable("instanceState");
            if (this.f10327O000000o != 0 && this.O00000oO.getChildCount() > 0) {
                O000000o(this.f10327O000000o);
            }
        }
        super.onRestoreInstanceState(parcelable);
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public float f10329O000000o;
        public float O00000Oo;

        O000000o() {
        }
    }

    class O00000o0 implements TypeEvaluator<O000000o> {
        O00000o0() {
        }

        public final /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
            O000000o o000000o = (O000000o) obj;
            O000000o o000000o2 = (O000000o) obj2;
            float f2 = o000000o.f10329O000000o + ((o000000o2.f10329O000000o - o000000o.f10329O000000o) * f);
            float f3 = o000000o.O00000Oo + (f * (o000000o2.O00000Oo - o000000o.O00000Oo));
            O000000o o000000o3 = new O000000o();
            o000000o3.f10329O000000o = f2;
            o000000o3.O00000Oo = f3;
            return o000000o3;
        }
    }

    private int O000000o(float f) {
        return (int) ((f * this.O00000o0.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private int O00000Oo(float f) {
        return (int) ((f * this.O00000o0.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
