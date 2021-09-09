package com.xiaomi.smarthome.newui.card.profile;

import _m_j.gos;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.newui.card.profile.YeelightControlView;
import java.util.Timer;
import java.util.TimerTask;

public class TouchView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f10225O000000o = false;
    public Bitmap O00000Oo;
    public float O00000o = 0.0f;
    public int O00000o0 = 255;
    ValueAnimator O00000oO = null;
    ValueAnimator O00000oo = null;
    protected int O0000O0o;
    protected int O0000OOo;
    private Matrix O0000Oo;
    private ControlMode O0000Oo0 = ControlMode.SUNSHINE;
    private Paint O0000OoO;
    private float O0000Ooo = 0.0f;
    private float O0000o0 = 0.0f;
    private float O0000o00 = 0.0f;
    private boolean O0000o0O = false;

    public enum ControlMode {
        SWITCH,
        COLOR,
        SUNSHINE,
        COLORFLOW,
        NIGHTLIGHT
    }

    public TouchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TouchView(Context context) {
        super(context);
    }

    public void setCurrentMode(ControlMode controlMode) {
        this.O0000Oo0 = controlMode;
        invalidate();
    }

    public ControlMode getCurrentMode() {
        return this.O0000Oo0;
    }

    public final void O000000o(float f, float f2) {
        this.O0000Ooo = f;
        this.O0000o00 = f2;
        this.O00000o0 = 250;
        this.f10225O000000o = true;
        invalidate();
    }

    public final void O000000o() {
        ValueAnimator valueAnimator = this.O00000oO;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.O00000oO = null;
        }
        this.O00000oo = ValueAnimator.ofFloat(this.O00000o, 0.0f);
        this.O00000oo.setDuration(500L);
        this.O00000oo.setInterpolator(new DecelerateInterpolator());
        this.O00000oo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.xiaomi.smarthome.newui.card.profile.TouchView.AnonymousClass2 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TouchView.this.O00000o = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.O00000oo.start();
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            /* class com.xiaomi.smarthome.newui.card.profile.TouchView.AnonymousClass3 */

            public final void run() {
                TouchView touchView = TouchView.this;
                touchView.O00000o0 -= 25;
                if (TouchView.this.O00000o0 <= 5) {
                    TouchView.this.f10225O000000o = false;
                    cancel();
                    timer.cancel();
                }
            }
        }, 0, 30);
    }

    public void setCircleRadio(YeelightControlView.TouchDirection touchDirection) {
        int i = AnonymousClass4.f10229O000000o[touchDirection.ordinal()];
        if (i == 1) {
            this.O00000o = 0.3f;
        } else if (i == 2) {
            this.O00000o = ((1.0f - (this.O0000o00 / ((float) this.O0000OOo))) * 0.099999994f) + 0.3f;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.O0000O0o = View.MeasureSpec.getSize(i);
        this.O0000OOo = View.MeasureSpec.getSize(i2);
        O00000Oo();
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        O00000Oo();
        int i = AnonymousClass4.O00000Oo[this.O0000Oo0.ordinal()];
        if (i != 1) {
            if (i == 2) {
                canvas.drawColor(872414455);
            } else if (i == 3) {
                O000000o(canvas);
                return;
            } else if (i == 4) {
                O000000o(canvas);
                return;
            } else if (i != 5) {
                return;
            }
            O000000o(canvas);
            return;
        }
        O000000o(canvas);
    }

    /* renamed from: com.xiaomi.smarthome.newui.card.profile.TouchView$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f10229O000000o = new int[YeelightControlView.TouchDirection.values().length];
        static final /* synthetic */ int[] O00000Oo = new int[ControlMode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|5|6|7|8|9|10|11|12|13|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0035 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0053 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002a */
        static {
            try {
                O00000Oo[ControlMode.COLORFLOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            O00000Oo[ControlMode.SUNSHINE.ordinal()] = 2;
            O00000Oo[ControlMode.COLOR.ordinal()] = 3;
            O00000Oo[ControlMode.SWITCH.ordinal()] = 4;
            O00000Oo[ControlMode.NIGHTLIGHT.ordinal()] = 5;
            f10229O000000o[YeelightControlView.TouchDirection.HORIZONTAL.ordinal()] = 1;
            f10229O000000o[YeelightControlView.TouchDirection.VERTICAL.ordinal()] = 2;
        }
    }

    private void O00000Oo() {
        this.O0000OoO = new Paint();
        this.O0000Oo = new Matrix();
        if (this.O00000Oo != null) {
            return;
        }
        if (this.O0000o0O) {
            O00000o0();
            return;
        }
        this.O00000Oo = gos.O000000o(getResources(), (int) R.drawable.touch_dot, 50, 50);
        this.O0000o0 = (float) this.O00000Oo.getWidth();
    }

    private void O000000o(Canvas canvas) {
        if (this.f10225O000000o) {
            this.O0000Oo.reset();
            float f = ((float) this.O0000O0o) * this.O00000o;
            Matrix matrix = this.O0000Oo;
            float f2 = this.O0000o0;
            matrix.preScale(f / f2, f / f2);
            int i = (int) (f / 2.0f);
            this.O0000Oo.postTranslate((float) (((int) this.O0000Ooo) - i), (float) (((int) this.O0000o00) - i));
            this.O0000OoO.setAlpha(this.O00000o0);
            Bitmap bitmap = this.O00000Oo;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, this.O0000Oo, this.O0000OoO);
            }
            invalidate();
        }
    }

    private void O00000o0() {
        int i = (int) ((((float) getResources().getDisplayMetrics().widthPixels) / 1080.0f) * 550.0f);
        this.O00000Oo = gos.O000000o(getResources(), (int) R.drawable.touch_bg, i, i);
        this.O0000o0 = (float) this.O00000Oo.getWidth();
        this.O0000o0O = true;
    }
}
