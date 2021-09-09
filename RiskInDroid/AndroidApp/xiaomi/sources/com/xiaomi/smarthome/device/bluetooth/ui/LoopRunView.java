package com.xiaomi.smarthome.device.bluetooth.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class LoopRunView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    int f7193O000000o;
    Direction O00000Oo;
    int O00000o;
    int O00000o0;
    private int O00000oO;
    private long O00000oo;
    private long O0000O0o;
    private Bitmap O0000OOo;
    private Paint O0000Oo;
    private Bitmap O0000Oo0;
    private Handler O0000OoO;
    private Rect O0000Ooo;
    private boolean O0000o0;
    private Rect O0000o00;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public long f7195O000000o;
        public Direction O00000Oo;
        public int O00000o0;
    }

    public LoopRunView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O00000Oo();
    }

    public LoopRunView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O00000Oo();
    }

    public LoopRunView(Context context) {
        super(context);
        O00000Oo();
    }

    private void O00000Oo() {
        this.O0000Oo = new Paint(1);
        this.O0000OoO = new Handler(Looper.getMainLooper()) {
            /* class com.xiaomi.smarthome.device.bluetooth.ui.LoopRunView.AnonymousClass1 */

            public final void handleMessage(Message message) {
                LoopRunView loopRunView = LoopRunView.this;
                if (message.what == 1) {
                    if (loopRunView.O00000Oo == Direction.UP) {
                        if (loopRunView.O00000o >= loopRunView.f7193O000000o + loopRunView.O00000o0) {
                            loopRunView.O00000o -= loopRunView.f7193O000000o + loopRunView.O00000o0;
                        }
                        loopRunView.O00000o += 6;
                    } else if (loopRunView.O00000Oo == Direction.DOWN) {
                        if (loopRunView.O00000o <= 0) {
                            loopRunView.O00000o += loopRunView.f7193O000000o + loopRunView.O00000o0;
                        }
                        loopRunView.O00000o -= 6;
                    } else {
                        return;
                    }
                    loopRunView.invalidate();
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!this.O0000o0) {
            super.onDraw(canvas);
            return;
        }
        Rect rect = this.O0000Ooo;
        int i = this.O00000o;
        rect.top = i;
        rect.bottom = i + this.f7193O000000o;
        canvas.drawColor(0);
        canvas.drawBitmap(this.O0000Oo0, this.O0000Ooo, this.O0000o00, this.O0000Oo);
        super.onDraw(canvas);
        this.O0000OoO.sendEmptyMessageDelayed(1, this.O0000O0o);
    }

    public enum Direction {
        UP(0),
        DOWN(1);
        
        int value;

        private Direction(int i) {
            this.value = i;
        }
    }

    public final void O000000o(Bitmap bitmap, O000000o o000000o) {
        this.O0000OOo = bitmap;
        this.O00000oo = o000000o.f7195O000000o;
        this.O00000Oo = o000000o.O00000Oo;
        this.O00000o0 = o000000o.O00000o0;
        this.O00000oO = this.O0000OOo.getWidth();
        this.f7193O000000o = this.O0000OOo.getHeight();
        int i = this.f7193O000000o;
        int i2 = this.O00000o0;
        this.O0000O0o = (this.O00000oo * 6) / ((long) (i + i2));
        this.O0000Oo0 = Bitmap.createBitmap(this.O00000oO, (i * 2) + i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.O0000Oo0);
        Paint paint = new Paint(1);
        Rect rect = new Rect(0, 0, this.O00000oO, this.f7193O000000o);
        canvas.drawBitmap(this.O0000OOo, rect, new Rect(0, 0, this.O00000oO, this.f7193O000000o), paint);
        int i3 = this.f7193O000000o;
        int i4 = this.O00000o0;
        canvas.drawBitmap(this.O0000OOo, rect, new Rect(0, i3 + i4, this.O00000oO, (i3 * 2) + i4), paint);
        if (this.O00000Oo == Direction.UP) {
            this.O00000o = 0;
        } else if (this.O00000Oo == Direction.DOWN) {
            this.O00000o = this.f7193O000000o + this.O00000o0;
        }
        this.O0000Ooo = new Rect(0, 0, this.O00000oO, this.f7193O000000o);
        this.O0000o00 = new Rect(0, 0, this.O00000oO, this.f7193O000000o);
        this.O0000o0 = true;
        O00000o0();
        invalidate();
    }

    private void O00000o0() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
        layoutParams.width = this.O00000oO;
        layoutParams.height = this.f7193O000000o;
        setLayoutParams(layoutParams);
    }

    public final void O000000o() {
        this.O0000OoO.removeCallbacksAndMessages(null);
    }
}
