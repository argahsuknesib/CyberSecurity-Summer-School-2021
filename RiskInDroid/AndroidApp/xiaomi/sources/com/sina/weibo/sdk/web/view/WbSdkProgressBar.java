package com.sina.weibo.sdk.web.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;

public class WbSdkProgressBar extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f5621O000000o;
    int O00000Oo;
    private int O00000o;
    private int O00000o0;
    private int O00000oO;
    private RectF O00000oo;
    private Paint O0000O0o;
    private float O0000OOo;
    private final int O0000Oo;
    private final int O0000Oo0;
    private float O0000OoO;
    private long O0000Ooo;
    private double O0000o;
    private long O0000o0;
    private float O0000o00;
    private long O0000o0O;
    private double O0000o0o;
    private Handler O0000oO;
    private boolean O0000oO0;

    public WbSdkProgressBar(Context context) {
        this(context, null);
    }

    public WbSdkProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WbSdkProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000Oo0 = 20;
        this.O0000Oo = 300;
        this.O0000Ooo = 0;
        this.O0000o00 = 200.0f;
        this.O0000o0 = 180;
        this.O0000o0O = 0;
        this.O0000o0o = 490.0d;
        this.O0000oO0 = false;
        this.f5621O000000o = true;
        this.O00000Oo = 0;
        this.O0000oO = new Handler() {
            /* class com.sina.weibo.sdk.web.view.WbSdkProgressBar.AnonymousClass1 */

            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 0) {
                    WbSdkProgressBar.this.f5621O000000o = false;
                }
            }
        };
        this.O00000o0 = O000000o(context, 50);
        this.O00000o = O000000o(context, 5);
        this.O00000oO = O000000o(context, 3);
        this.O0000O0o = new Paint();
        this.O0000O0o.setAntiAlias(true);
        this.O0000O0o.setColor(-48861);
        this.O0000O0o.setStyle(Paint.Style.STROKE);
        this.O0000O0o.setStrokeWidth((float) this.O00000o);
        int i2 = this.O00000oO;
        int i3 = this.O00000o0;
        this.O00000oo = new RectF((float) i2, (float) i2, (float) (i3 - i2), (float) (i3 - i2));
    }

    private static int O000000o(Context context, int i) {
        return (int) (context.getResources().getDisplayMetrics().density * ((float) i));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00bd, code lost:
        return;
     */
    public synchronized void onDraw(Canvas canvas) {
        long abs = Math.abs(SystemClock.uptimeMillis() - this.O0000Ooo) % 360;
        float f = (this.O0000o00 * ((float) abs)) / 1000.0f;
        if (this.O0000o0O >= this.O0000o0) {
            double d = this.O0000o;
            double d2 = (double) abs;
            Double.isNaN(d2);
            this.O0000o = d + d2;
            if (this.O0000o >= this.O0000o0o) {
                this.O0000o -= this.O0000o0o;
                this.O0000o0O = 0;
                this.O0000oO0 = !this.O0000oO0;
            }
            float cos = (((float) Math.cos(((this.O0000o / this.O0000o0o) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
            if (!this.O0000oO0) {
                this.O0000OoO = cos * 280.0f;
            } else {
                float f2 = (1.0f - cos) * 280.0f;
                this.O0000OOo += this.O0000OoO - f2;
                this.O0000OoO = f2;
            }
        } else {
            this.O0000o0O += abs;
        }
        this.O0000Ooo = SystemClock.uptimeMillis();
        this.O0000OOo += f;
        if (this.O0000OOo >= 360.0f) {
            this.O0000OOo -= 360.0f;
        }
        canvas.drawArc(this.O00000oo, this.O0000OOo - 90.0f, this.O0000OoO + 20.0f, false, this.O0000O0o);
        if (this.f5621O000000o) {
            if (Build.VERSION.SDK_INT >= 21) {
                postInvalidate();
                return;
            }
            invalidate();
        }
    }

    public void setProgressColor(int i) {
        this.O0000O0o.setColor(i);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 8) {
            this.O0000oO.sendEmptyMessageDelayed(0, 1000);
        } else if (i == 0 && getVisibility() == 0) {
            this.O0000oO.removeMessages(0);
            this.f5621O000000o = true;
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.O00000o0;
        setMeasuredDimension(i3, i3);
    }
}
