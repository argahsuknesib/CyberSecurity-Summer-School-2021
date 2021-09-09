package com.xiaomi.smarthome.newui.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.common.ConnectionResult;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class RippleLayout extends FrameLayout implements Animator.AnimatorListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public float f10322O000000o = 50.0f;
    public float O00000Oo = 6.0f;
    public boolean O00000o = false;
    public float O00000o0;
    public boolean O00000oO = false;
    public Paint O00000oo = new Paint();
    public Paint O0000O0o = new Paint();
    public Paint O0000OOo = new Paint();
    private int O0000Oo = -16776961;
    public ArrayList<Animator> O0000Oo0 = new ArrayList<>();
    private int O0000OoO = -16776961;
    private int O0000Ooo;
    private int O0000o;
    private int O0000o0 = -16777216;
    private int O0000o00;
    private float O0000o0O;
    private int O0000o0o = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
    private float O0000oO = 0.0f;
    private int O0000oO0;
    private float O0000oOO = 12.0f;
    private int O0000oOo;
    private int O0000oo = 2;
    private boolean O0000oo0 = false;
    private int O0000ooO;
    private TextView O0000ooo;
    private O000000o O000O00o;
    private boolean O000O0OO = false;
    private Shader O000O0Oo;
    private Shader O000O0o;
    private Shader O000O0o0;
    private AnimatorSet O000O0oO = new AnimatorSet();
    private FrameLayout.LayoutParams O000O0oo;
    private O00000o O000OO00;
    private Shader O00oOoOo;
    private String O00oOooO;
    private String O00oOooo;

    public interface O000000o {
    }

    public interface O00000o {
        void O00000Oo();
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }

    public RippleLayout(Context context) {
        super(context);
        O000000o(context, (AttributeSet) null);
    }

    public RippleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context, attributeSet);
    }

    public RippleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context, attributeSet);
    }

    public void setTouchListener(O00000o o00000o) {
        this.O000OO00 = o00000o;
    }

    private void O000000o() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).invalidate();
        }
    }

    public void setSending(boolean z) {
        this.O0000oo0 = z;
        if (z) {
            this.O0000ooo.setText(this.O00oOooo);
            Shader shader = this.O00oOoOo;
            if (shader != null) {
                this.O00000oo.setShader(shader);
            }
            Shader shader2 = this.O000O0o;
            if (shader2 != null) {
                this.O0000OOo.setShader(shader2);
            }
        } else {
            this.O0000ooo.setText(this.O00oOooO);
            Shader shader3 = this.O000O0Oo;
            if (shader3 != null) {
                this.O00000oo.setShader(shader3);
            }
            Shader shader4 = this.O000O0o0;
            if (shader4 != null) {
                this.O0000OOo.setShader(shader4);
            }
        }
        O000000o();
        this.O0000ooo.invalidate();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            float width = (float) (getWidth() / 2);
            float height = (float) (getHeight() / 2);
            if (Math.sqrt((double) ((Math.abs(motionEvent.getX() - width) * Math.abs(motionEvent.getX() - width)) + (Math.abs(motionEvent.getY() - height) * Math.abs(motionEvent.getY() - height)))) <= ((double) this.f10322O000000o)) {
                this.O000O0OO = true;
                return true;
            }
        }
        if (motionEvent.getAction() == 1 && this.O000O0OO) {
            float width2 = (float) (getWidth() / 2);
            float height2 = (float) (getHeight() / 2);
            if (Math.sqrt((double) ((Math.abs(motionEvent.getX() - width2) * Math.abs(motionEvent.getX() - width2)) + (Math.abs(motionEvent.getY() - height2) * Math.abs(motionEvent.getY() - height2)))) <= ((double) this.f10322O000000o)) {
                O00000o o00000o = this.O000OO00;
                if (o00000o != null) {
                    o00000o.O00000Oo();
                }
                this.O000O0OO = false;
                return true;
            }
        }
        if (motionEvent.getAction() != 3) {
            return super.onTouchEvent(motionEvent);
        }
        this.O000O0OO = false;
        return true;
    }

    private void O000000o(Context context, AttributeSet attributeSet) {
        if (!isInEditMode()) {
            if (attributeSet != null) {
                O00000Oo(context, attributeSet);
            }
            O00000oO();
            O00000o();
            O00000Oo();
        }
    }

    private void O000000o(O00000o0 o00000o0, int i) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(o00000o0, PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.0f), PropertyValuesHolder.ofFloat("radius", o00000o0.f10324O000000o, this.O00000o0 + (this.O0000oOO * ((float) ((this.O0000o - 1) - i)))));
        ofPropertyValuesHolder.setDuration((long) this.O0000o0o);
        ofPropertyValuesHolder.setRepeatCount(-1);
        ofPropertyValuesHolder.setRepeatMode(1);
        ofPropertyValuesHolder.addListener(this);
        this.O0000Oo0.add(ofPropertyValuesHolder);
    }

    private void O00000Oo() {
        O00000oo();
        O00000o0();
        for (int i = 0; i < this.O0000o; i++) {
            O00000o0 o00000o0 = new O00000o0(this, getContext(), (byte) 0);
            o00000o0.O000000o((this.f10322O000000o - (this.O0000oOO * ((float) i))) - this.O00000Oo);
            addView(o00000o0, this.O000O0oo);
            O000000o(o00000o0, i);
        }
        addView(new O00000Oo(getContext(), this.f10322O000000o));
        this.O0000ooo = new TextView(getContext());
        this.O0000ooo.setTextSize(this.O0000o0O);
        this.O0000ooo.setTextColor(this.O0000o0);
        this.O0000ooo.setText(this.O00oOooO);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        layoutParams.gravity = 17;
        this.O0000ooo.setLayoutParams(layoutParams);
        addView(this.O0000ooo);
    }

    public void setAnimListener(O000000o o000000o) {
        this.O000O00o = o000000o;
    }

    private void O00000o0() {
        this.O000O0oO.setDuration((long) this.O0000o0o);
        this.O000O0oO.setInterpolator(new AccelerateDecelerateInterpolator());
    }

    private void O00000o() {
        float f = this.O00000o0;
        float f2 = this.f10322O000000o + this.O0000oOO;
        int i = 0;
        while (this.O00000Oo + f2 < f) {
            f2 += this.O0000oOO;
            i++;
        }
        int i2 = this.O0000oO0;
        if (i < i2) {
            this.O0000o = i;
        } else {
            this.O0000o = i2;
        }
        int i3 = (int) ((this.O00000o0 + this.O00000Oo) * 2.0f);
        this.O000O0oo = new FrameLayout.LayoutParams(i3, i3);
        this.O000O0oo.setMargins(0, 0, 0, 0);
        this.O000O0oo.gravity = 17;
    }

    private void O00000oO() {
        this.O00000oo.setAntiAlias(true);
        this.O00000oo.setStyle(Paint.Style.FILL);
        this.O00000oo.setColor(this.O0000Oo);
        this.O0000O0o.setAntiAlias(true);
        this.O0000O0o.setStyle(Paint.Style.FILL);
        this.O0000O0o.setColor(-1);
        this.O0000OOo.setAntiAlias(true);
        this.O0000OOo.setStyle(Paint.Style.FILL);
    }

    private void O00000oo() {
        this.O0000oOo = (int) ((((float) this.O0000o0o) * this.O0000oOO) / (this.O00000o0 - this.f10322O000000o));
    }

    private void O00000Oo(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.msradius, R.attr.msstrokeWidth, R.attr.rippleColor, R.attr.rippleColorEnd, R.attr.rippleColorSending, R.attr.rippleColorSendingEnd, R.attr.rippleNums, R.attr.rippleTextColor, R.attr.rippleTextNor, R.attr.rippleTextSending, R.attr.rippleTextSize, R.attr.ripple_maxRadius, R.attr.ripple_padding, R.attr.ripple_thickness, R.attr.rpduration});
        this.O0000Oo = obtainStyledAttributes.getColor(2, -16776961);
        this.O0000Ooo = obtainStyledAttributes.getColor(3, -16776961);
        this.O0000OoO = obtainStyledAttributes.getColor(4, -16776961);
        this.O0000o00 = obtainStyledAttributes.getColor(5, -16776961);
        this.O0000o0 = obtainStyledAttributes.getColor(7, -16777216);
        this.O0000oO = obtainStyledAttributes.getDimension(1, 0.0f);
        this.O00000Oo = obtainStyledAttributes.getDimension(13, 6.0f);
        this.f10322O000000o = obtainStyledAttributes.getDimension(0, 50.0f);
        this.O0000o0o = obtainStyledAttributes.getInt(14, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
        this.O0000oO0 = obtainStyledAttributes.getInt(6, 4);
        this.O00000o0 = obtainStyledAttributes.getDimension(11, 75.0f);
        this.O0000o0O = obtainStyledAttributes.getDimension(10, context.getResources().getDimension(R.dimen.font_size_8sp));
        this.O00oOooO = obtainStyledAttributes.getString(8);
        this.O00oOooo = obtainStyledAttributes.getString(9);
        this.O0000oOO = obtainStyledAttributes.getDimension(12, this.O00000Oo * 3.0f);
        obtainStyledAttributes.recycle();
    }

    public void onAnimationRepeat(Animator animator) {
        if (this.O00000oO) {
            animator.cancel();
            this.O0000ooO++;
            if (this.O0000ooO >= this.O0000oo) {
                Shader shader = this.O000O0Oo;
                if (shader != null) {
                    this.O00000oo.setShader(shader);
                }
                this.O0000ooO = 0;
                this.O00000o = false;
                O000000o();
            }
        }
    }

    class O00000o0 extends View {

        /* renamed from: O000000o  reason: collision with root package name */
        float f10324O000000o;
        private Paint O00000o;
        private float O00000o0;
        private Paint O00000oO;

        public final void O000000o(float f) {
            this.f10324O000000o = f;
            if (f <= RippleLayout.this.f10322O000000o) {
                this.O00000o0 = RippleLayout.this.O00000Oo;
            } else {
                this.O00000o0 = RippleLayout.this.O00000Oo * (1.0f - ((f - RippleLayout.this.f10322O000000o) / (RippleLayout.this.O00000o0 - RippleLayout.this.f10322O000000o)));
            }
            invalidate();
        }

        private O00000o0(Context context) {
            super(context);
            this.O00000o0 = RippleLayout.this.O00000Oo;
            this.f10324O000000o = RippleLayout.this.f10322O000000o;
            this.O00000oO = RippleLayout.this.O00000oo;
            this.O00000o = RippleLayout.this.O0000O0o;
        }

        public O00000o0(RippleLayout rippleLayout, Context context, byte b) {
            this(context);
        }

        /* access modifiers changed from: protected */
        public final void onDraw(Canvas canvas) {
            float min = (float) (Math.min(getWidth(), getHeight()) / 2);
            canvas.drawCircle(min, min, this.f10324O000000o + this.O00000o0, this.O00000oO);
            canvas.drawCircle(min, min, this.f10324O000000o, this.O00000o);
        }
    }

    class O00000Oo extends View {

        /* renamed from: O000000o  reason: collision with root package name */
        float f10323O000000o;

        O00000Oo(Context context, float f) {
            super(context);
            this.f10323O000000o = f;
        }

        /* access modifiers changed from: protected */
        public final void onDraw(Canvas canvas) {
            float min = (float) (Math.min(getWidth(), getHeight()) / 2);
            canvas.drawCircle(min, min, this.f10323O000000o, RippleLayout.this.O0000OOo);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int, int, android.graphics.Shader$TileMode):void}
     arg types: [int, int, float, float, int, int, android.graphics.Shader$TileMode]
     candidates:
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int[], float[], android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, long, long, android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, long[], float[], android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int, int, android.graphics.Shader$TileMode):void} */
    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        super.onSizeChanged(i, i2, i3, i4);
        if (i5 > 0 && i6 > 0) {
            float f = (float) i5;
            float f2 = (float) i6;
            this.O000O0Oo = new LinearGradient(0.0f, 0.0f, f, f2, this.O0000Ooo, this.O0000Oo, Shader.TileMode.CLAMP);
            int i7 = this.O0000o00;
            float f3 = f;
            this.O00oOoOo = new LinearGradient(0.0f, 0.0f, f, f2, i7, this.O0000OoO, Shader.TileMode.CLAMP);
            float f4 = f3 / 2.0f;
            float f5 = this.f10322O000000o;
            float f6 = f2 / 2.0f;
            int i8 = this.O0000Ooo;
            this.O000O0o0 = new LinearGradient(f4 - f5, f6 - f5, f4 + f5, f6 + f5, i8, this.O0000Oo, Shader.TileMode.CLAMP);
            float f7 = this.f10322O000000o;
            this.O000O0o = new LinearGradient(f4 - f7, f6 - f7, f4 + f7, f6 + f7, this.O0000o00, this.O0000OoO, Shader.TileMode.CLAMP);
            if (this.O0000oo0) {
                this.O00000oo.setShader(this.O00oOoOo);
                this.O0000OOo.setShader(this.O000O0o);
                return;
            }
            this.O00000oo.setShader(this.O000O0Oo);
            this.O0000OOo.setShader(this.O000O0o0);
        }
    }
}
