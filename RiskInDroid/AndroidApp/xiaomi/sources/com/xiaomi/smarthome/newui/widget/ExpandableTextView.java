package com.xiaomi.smarthome.newui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class ExpandableTextView extends LinearLayout implements View.OnClickListener {
    private static final String O0000Ooo = "ExpandableTextView";

    /* renamed from: O000000o  reason: collision with root package name */
    protected TextView f10300O000000o;
    protected View O00000Oo;
    public int O00000o;
    public boolean O00000o0;
    public O00000Oo O00000oO;
    public int O00000oo;
    public float O0000O0o;
    public boolean O0000OOo;
    public SparseBooleanArray O0000Oo;
    public O00000o O0000Oo0;
    public int O0000OoO;
    private int O0000o;
    private int O0000o0;
    private boolean O0000o00;
    private int O0000o0O;
    private int O0000o0o;
    private boolean O0000oO;
    private int O0000oO0;

    public interface O00000Oo {
        void O000000o(View view);

        void O000000o(boolean z);
    }

    public interface O00000o {
    }

    public void setOrientation(int i) {
    }

    public ExpandableTextView(Context context) {
        this(context, null);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O00000o0 = true;
        this.O0000o = R.id.expandable_text;
        this.O0000oO0 = R.id.expand_collapse;
        O000000o(attributeSet);
    }

    @TargetApi(11)
    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000o0 = true;
        this.O0000o = R.id.expandable_text;
        this.O0000oO0 = R.id.expand_collapse;
        O000000o(attributeSet);
    }

    public void onClick(View view) {
        O000000o o000000o;
        if (this.O00000Oo.getVisibility() == 0) {
            this.O00000o0 = !this.O00000o0;
            this.O00000oO.O000000o(this.O00000o0);
            SparseBooleanArray sparseBooleanArray = this.O0000Oo;
            if (sparseBooleanArray != null) {
                sparseBooleanArray.put(this.O0000OoO, this.O00000o0);
            }
            this.O0000OOo = true;
            if (this.O00000o0) {
                o000000o = new O000000o(this, getHeight(), this.O0000o0);
            } else {
                o000000o = new O000000o(this, getHeight(), (getHeight() + this.O0000o0O) - this.f10300O000000o.getHeight());
            }
            o000000o.setFillAfter(true);
            o000000o.setAnimationListener(new Animation.AnimationListener() {
                /* class com.xiaomi.smarthome.newui.widget.ExpandableTextView.AnonymousClass1 */

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationStart(Animation animation) {
                    ExpandableTextView.O000000o(ExpandableTextView.this.f10300O000000o, ExpandableTextView.this.O0000O0o);
                }

                public final void onAnimationEnd(Animation animation) {
                    ExpandableTextView.this.clearAnimation();
                    ExpandableTextView.this.O0000OOo = false;
                }
            });
            clearAnimation();
            startAnimation(o000000o);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.O0000OOo;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f10300O000000o = (TextView) findViewById(this.O0000o);
        if (this.O0000oO) {
            this.f10300O000000o.setOnClickListener(this);
        } else {
            this.f10300O000000o.setOnClickListener(null);
        }
        this.O00000Oo = findViewById(this.O0000oO0);
        this.O00000oO.O000000o(this.O00000Oo);
        this.O00000oO.O000000o(this.O00000o0);
        this.O00000Oo.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (!this.O0000o00 || getVisibility() == 8) {
            super.onMeasure(i, i2);
            return;
        }
        this.O0000o00 = false;
        this.O00000Oo.setVisibility(8);
        this.f10300O000000o.setMaxLines(Integer.MAX_VALUE);
        super.onMeasure(i, i2);
        if (this.f10300O000000o.getLineCount() > this.O0000o0o) {
            TextView textView = this.f10300O000000o;
            this.O0000o0O = textView.getLayout().getLineTop(textView.getLineCount()) + textView.getCompoundPaddingTop() + textView.getCompoundPaddingBottom();
            if (this.O00000o0) {
                this.f10300O000000o.setMaxLines(this.O0000o0o);
            }
            this.O00000Oo.setVisibility(0);
            super.onMeasure(i, i2);
            if (this.O00000o0) {
                this.f10300O000000o.post(new Runnable() {
                    /* class com.xiaomi.smarthome.newui.widget.ExpandableTextView.AnonymousClass2 */

                    public final void run() {
                        ExpandableTextView expandableTextView = ExpandableTextView.this;
                        expandableTextView.O00000o = expandableTextView.getHeight() - ExpandableTextView.this.f10300O000000o.getHeight();
                    }
                });
                this.O0000o0 = getMeasuredHeight();
            }
        }
    }

    public void setOnExpandStateChangeListener(O00000o o00000o) {
        this.O0000Oo0 = o00000o;
    }

    public void setText(CharSequence charSequence) {
        this.O0000o00 = true;
        this.f10300O000000o.setText(charSequence);
        setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
        clearAnimation();
        getLayoutParams().height = -2;
        requestLayout();
    }

    public CharSequence getText() {
        TextView textView = this.f10300O000000o;
        if (textView == null) {
            return "";
        }
        return textView.getText();
    }

    private void O000000o(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.animAlphaStart, R.attr.animDuration, R.attr.collapseIndicator, R.attr.expandCollapseToggleId, R.attr.expandIndicator, R.attr.expandToggleOnTextClick, R.attr.expandToggleType, R.attr.expandableTextId, R.attr.maxCollapsedLines});
        this.O0000o0o = obtainStyledAttributes.getInt(8, 8);
        this.O00000oo = obtainStyledAttributes.getInt(1, 300);
        this.O0000O0o = obtainStyledAttributes.getFloat(0, 0.7f);
        this.O0000o = obtainStyledAttributes.getResourceId(7, R.id.expandable_text);
        this.O0000oO0 = obtainStyledAttributes.getResourceId(3, R.id.expand_collapse);
        this.O0000oO = obtainStyledAttributes.getBoolean(5, true);
        this.O00000oO = O000000o(getContext(), obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        setOrientation(0);
        setVisibility(8);
    }

    @TargetApi(21)
    private static Drawable O000000o(Context context, int i) {
        Resources resources = context.getResources();
        if (Build.VERSION.SDK_INT >= 21) {
            return resources.getDrawable(i, context.getTheme());
        }
        return resources.getDrawable(i);
    }

    private static O00000Oo O000000o(Context context, TypedArray typedArray) {
        int i = typedArray.getInt(6, 0);
        if (i == 0) {
            Drawable drawable = typedArray.getDrawable(4);
            Drawable drawable2 = typedArray.getDrawable(2);
            if (drawable == null) {
                drawable = O000000o(context, (int) R.drawable.navi_arrow_down_collapse);
            }
            if (drawable2 == null) {
                drawable2 = O000000o(context, (int) R.drawable.mj_webp_widget_collapse_arrow_nor);
            }
            return new O00000o0(drawable, drawable2);
        } else if (i == 1) {
            return new O0000O0o(typedArray.getString(4), typedArray.getString(2));
        } else {
            throw new IllegalStateException("Must be of enum: ExpandableTextView_expandToggleType, one of EXPAND_INDICATOR_IMAGE_BUTTON or EXPAND_INDICATOR_TEXT_VIEW.");
        }
    }

    class O000000o extends Animation {
        private final View O00000Oo;
        private final int O00000o;
        private final int O00000o0;

        public final boolean willChangeBounds() {
            return true;
        }

        public O000000o(View view, int i, int i2) {
            this.O00000Oo = view;
            this.O00000o0 = i;
            this.O00000o = i2;
            setDuration((long) ExpandableTextView.this.O00000oo);
        }

        /* access modifiers changed from: protected */
        public final void applyTransformation(float f, Transformation transformation) {
            int i = this.O00000o;
            int i2 = this.O00000o0;
            int i3 = (int) ((((float) (i - i2)) * f) + ((float) i2));
            ExpandableTextView.this.f10300O000000o.setMaxHeight(i3 - ExpandableTextView.this.O00000o);
            if (Float.compare(ExpandableTextView.this.O0000O0o, 1.0f) != 0) {
                ExpandableTextView.O000000o(ExpandableTextView.this.f10300O000000o, ExpandableTextView.this.O0000O0o + (f * (1.0f - ExpandableTextView.this.O0000O0o)));
            }
            this.O00000Oo.getLayoutParams().height = i3;
            this.O00000Oo.requestLayout();
        }

        public final void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
        }
    }

    static class O00000o0 implements O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        private final Drawable f10304O000000o;
        private final Drawable O00000Oo;
        private ImageButton O00000o0;

        public O00000o0(Drawable drawable, Drawable drawable2) {
            this.f10304O000000o = drawable;
            this.O00000Oo = drawable2;
        }

        public final void O000000o(boolean z) {
            this.O00000o0.setImageDrawable(z ? this.f10304O000000o : this.O00000Oo);
        }

        public final void O000000o(View view) {
            this.O00000o0 = (ImageButton) view;
        }
    }

    static class O0000O0o implements O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        private final String f10305O000000o;
        private final String O00000Oo;
        private TextView O00000o0;

        public O0000O0o(String str, String str2) {
            this.f10305O000000o = str;
            this.O00000Oo = str2;
        }

        public final void O000000o(boolean z) {
            this.O00000o0.setText(z ? this.f10305O000000o : this.O00000Oo);
        }

        public final void O000000o(View view) {
            this.O00000o0 = (TextView) view;
        }
    }

    @TargetApi(11)
    public static void O000000o(View view, float f) {
        if (Build.VERSION.SDK_INT >= 11) {
            view.setAlpha(f);
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f);
        alphaAnimation.setDuration(0);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }
}
