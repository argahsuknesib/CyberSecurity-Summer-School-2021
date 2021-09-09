package net.qiujuer.genius.ui.widget;

import _m_j.izh;
import _m_j.izi;
import _m_j.izn;
import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class BalloonMarker extends ViewGroup implements izn.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    izn f15398O000000o;
    public TextView O00000Oo;
    private int O00000o;
    private int O00000o0;

    public BalloonMarker(Context context) {
        this(context, null);
    }

    public BalloonMarker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.gBalloonMarkerStyle);
    }

    public BalloonMarker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Typeface O000000o2;
        this.f15398O000000o = new izn(ColorStateList.valueOf(0));
        Resources resources = getResources();
        float f = resources.getDisplayMetrics().density;
        this.O00000Oo = new TextView(context);
        this.O00000Oo.setGravity(17);
        this.O00000Oo.setText("0");
        this.O00000Oo.setMaxLines(1);
        this.O00000Oo.setSingleLine(true);
        TextView textView = this.O00000Oo;
        if (Build.VERSION.SDK_INT >= 17) {
            textView.setTextDirection(5);
        }
        this.O00000Oo.setVisibility(4);
        O000000o("0");
        this.O00000o = (int) (0.0f * f);
        this.f15398O000000o = new izn(ColorStateList.valueOf(0));
        this.f15398O000000o.setCallback(this);
        izn izn = this.f15398O000000o;
        izn.O0000Oo = this;
        izn.O0000Oo0 = getPaddingBottom();
        izn izn2 = this.f15398O000000o;
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new ViewOutlineProvider(izn2) {
                /* class _m_j.izk.AnonymousClass1 */

                /* renamed from: O000000o */
                final /* synthetic */ izn f1667O000000o;

                {
                    this.f1667O000000o = r1;
                }

                public final void getOutline(View view, Outline outline) {
                    outline.setConvexPath(this.f1667O000000o.f1670O000000o);
                }
            });
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.gFont, R.attr.gMarkerBackgroundColor, R.attr.gMarkerElevation, R.attr.gMarkerSeparation, R.attr.gMarkerTextAppearance, R.attr.gMarkerTextPadding}, i, 2132738377);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(5, resources.getDimensionPixelSize(R.dimen.g_balloonMarker_textPadding));
            int resourceId = obtainStyledAttributes.getResourceId(4, 2132738378);
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(1);
            String string = obtainStyledAttributes.getString(0);
            this.O00000o = obtainStyledAttributes.getDimensionPixelSize(3, resources.getDimensionPixelSize(R.dimen.g_balloonMarker_separation));
            obtainStyledAttributes.recycle();
            setTextPadding(dimensionPixelSize);
            setTextAppearance(resourceId);
            setBackgroundColor(colorStateList);
            if (Build.VERSION.SDK_INT >= 21) {
                setElevation(obtainStyledAttributes.getDimension(2, f * 8.0f));
            }
            if (!isInEditMode() && string != null && string.length() > 0 && (O000000o2 = izh.O000000o(getContext(), string)) != null) {
                setTypeface(O000000o2);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(BalloonMarker.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(BalloonMarker.class.getName());
    }

    public void setSeparation(int i) {
        this.O00000o = i;
    }

    public void setTextPadding(int i) {
        this.O00000Oo.setPadding(i, 0, i, 0);
    }

    public void setTypeface(Typeface typeface) {
        this.O00000Oo.setTypeface(typeface);
    }

    public void setTextAppearance(int i) {
        this.O00000Oo.setTextAppearance(getContext(), i);
    }

    public ColorStateList getBackgroundColor() {
        return this.f15398O000000o.O0000Ooo;
    }

    public void setBackgroundColor(ColorStateList colorStateList) {
        this.f15398O000000o.O000000o(colorStateList);
    }

    public void setClosedSize(float f) {
        this.f15398O000000o.O0000OOo = f;
    }

    public final void O000000o(String str) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.O00000Oo.setText(String.format("-%s", str));
        this.O00000Oo.measure(View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, Integer.MIN_VALUE));
        this.O00000o0 = Math.max(this.O00000Oo.getMeasuredWidth(), this.O00000Oo.getMeasuredHeight());
        removeView(this.O00000Oo);
        TextView textView = this.O00000Oo;
        int i = this.O00000o0;
        addView(textView, new FrameLayout.LayoutParams(i, i, 51));
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        izn izn = this.f15398O000000o;
        if (izn != null) {
            izn.O0000Oo0 = i4;
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        this.f15398O000000o.draw(canvas);
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        measureChildren(i, i2);
        int paddingLeft = this.O00000o0 + getPaddingLeft() + getPaddingRight();
        int paddingTop = this.O00000o0 + getPaddingTop() + getPaddingBottom();
        int i3 = this.O00000o0;
        setMeasuredDimension(paddingLeft, paddingTop + (((int) ((((float) i3) * 1.41f) - ((float) i3))) / 2) + this.O00000o);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        TextView textView = this.O00000Oo;
        int i5 = this.O00000o0;
        textView.layout(paddingLeft, paddingTop, paddingLeft + i5, i5 + paddingTop);
        this.f15398O000000o.setBounds(paddingLeft, paddingTop, width, height);
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f15398O000000o || super.verifyDrawable(drawable);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        O00000o0();
    }

    public CharSequence getValue() {
        return this.O00000Oo.getText();
    }

    public void setValue(CharSequence charSequence) {
        this.O00000Oo.setText(charSequence);
    }

    public final void O00000o0() {
        this.f15398O000000o.stop();
        this.f15398O000000o.O000000o();
    }

    @TargetApi(16)
    public final void O00000o() {
        this.f15398O000000o.stop();
        ViewPropertyAnimator animate = this.O00000Oo.animate();
        animate.alpha(0.0f);
        animate.setDuration(100);
        if (Build.VERSION.SDK_INT >= 16) {
            animate.withEndAction(new Runnable() {
                /* class net.qiujuer.genius.ui.widget.BalloonMarker.AnonymousClass1 */

                public final void run() {
                    BalloonMarker.this.O00000Oo.setVisibility(4);
                    BalloonMarker.this.f15398O000000o.O00000Oo();
                }
            });
        } else {
            animate.setListener(new izi() {
                /* class net.qiujuer.genius.ui.widget.BalloonMarker.AnonymousClass2 */

                public final void onAnimationEnd(Animator animator) {
                    BalloonMarker.this.O00000Oo.setVisibility(4);
                    BalloonMarker.this.f15398O000000o.O00000Oo();
                }
            });
        }
        animate.start();
    }

    public final void O00000Oo() {
        this.O00000Oo.setVisibility(0);
        ViewPropertyAnimator animate = this.O00000Oo.animate();
        animate.alpha(1.0f);
        animate.setDuration(100);
        animate.start();
        if (getParent() instanceof izn.O000000o) {
            ((izn.O000000o) getParent()).O00000Oo();
        }
    }

    public final void O000000o() {
        if (getParent() instanceof izn.O000000o) {
            ((izn.O000000o) getParent()).O000000o();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f15398O000000o.stop();
    }
}
