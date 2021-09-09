package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

public class WaveView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f9291O000000o = 0;
    public int O00000Oo = 0;
    public boolean O00000o = true;
    public boolean O00000o0 = false;
    public int O00000oO = 0;
    public int O00000oo = 0;
    public int O0000O0o = 0;
    long O0000OOo = 300;
    long O0000Oo = 16;
    long O0000Oo0 = 800;
    public long O0000OoO = 0;
    public long O0000Ooo = 0;
    Paint O0000o0 = new Paint();
    long O0000o00 = 0;
    public Handler O0000o0O = new Handler() {
        /* class com.xiaomi.smarthome.library.common.widget.WaveView.AnonymousClass1 */

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                WaveView.this.O0000o0O.sendEmptyMessage(2);
            } else if (i == 2) {
                WaveView.this.invalidate();
                WaveView.this.O0000o0O.sendEmptyMessageDelayed(2, WaveView.this.O0000Oo);
            } else if (i == 3) {
                WaveView waveView = WaveView.this;
                waveView.O00000o = true;
                waveView.O0000Ooo = System.currentTimeMillis();
                WaveView.this.O0000o0O.sendEmptyMessageDelayed(4, WaveView.this.O0000Oo0 - ((WaveView.this.O0000Ooo - WaveView.this.O0000OoO) % WaveView.this.O0000OOo));
                WaveView.this.invalidate();
            } else if (i == 4) {
                WaveView waveView2 = WaveView.this;
                waveView2.O00000o0 = false;
                waveView2.O0000o0O.removeMessages(2);
                WaveView.this.invalidate();
            }
        }
    };

    public WaveView(Context context) {
        super(context);
        O000000o();
    }

    public WaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public WaveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    private void O000000o() {
        this.O0000o0.setAntiAlias(true);
        this.O0000o0.setStyle(Paint.Style.STROKE);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        double d;
        super.onDraw(canvas);
        if (this.O00000o0) {
            this.O0000o00 = System.currentTimeMillis();
            long j = this.O0000o00;
            long j2 = this.O0000OoO;
            long j3 = j - j2;
            if (!this.O00000o) {
                double d2 = (double) j3;
                double d3 = (double) this.O0000OOo;
                Double.isNaN(d2);
                Double.isNaN(d3);
                d = Math.floor(d2 / d3);
            } else {
                double d4 = (double) (this.O0000Ooo - j2);
                double d5 = (double) this.O0000OOo;
                Double.isNaN(d4);
                Double.isNaN(d5);
                d = Math.floor(d4 / d5);
            }
            int i = ((int) d) + 1;
            double d6 = (double) (this.O00000oo - this.O00000oO);
            double d7 = (double) this.O0000Oo0;
            Double.isNaN(d6);
            Double.isNaN(d7);
            double d8 = d6 / d7;
            while (i > 0) {
                double d9 = (double) (j3 - (this.O0000OOo * ((long) (i - 1))));
                Double.isNaN(d9);
                int i2 = (int) (d9 * d8);
                int i3 = this.O00000oo;
                int i4 = this.O00000oO;
                if (i2 < i3 - i4) {
                    this.O0000o0.setColor(((((int) ((1.0f - (((float) i2) / ((float) (i3 - i4)))) * 255.0f)) & 255) << 24) | this.O0000O0o);
                    canvas.drawCircle(((float) this.f9291O000000o) / 2.0f, ((float) this.O00000Oo) / 2.0f, (float) (i2 + i4), this.O0000o0);
                    i--;
                } else {
                    return;
                }
            }
        }
    }
}
