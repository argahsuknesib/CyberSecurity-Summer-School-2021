package com.smarthome.connect.view;

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

public class LoopRunView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    int f5634O000000o;
    Direction O00000Oo;
    int O00000o;
    int O00000o0;
    private long O00000oO;
    private Bitmap O00000oo;
    private Paint O0000O0o;
    private Handler O0000OOo;
    private Rect O0000Oo;
    private Rect O0000Oo0;
    private boolean O0000OoO;

    public LoopRunView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    public LoopRunView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public LoopRunView(Context context) {
        super(context);
        O000000o();
    }

    private void O000000o() {
        this.O0000O0o = new Paint(1);
        this.O0000OOo = new Handler(Looper.getMainLooper()) {
            /* class com.smarthome.connect.view.LoopRunView.AnonymousClass1 */

            public final void handleMessage(Message message) {
                LoopRunView loopRunView = LoopRunView.this;
                if (message.what == 1) {
                    if (loopRunView.O00000Oo == Direction.UP) {
                        if (loopRunView.O00000o >= loopRunView.f5634O000000o + loopRunView.O00000o0) {
                            loopRunView.O00000o -= loopRunView.f5634O000000o + loopRunView.O00000o0;
                        }
                        loopRunView.O00000o += 6;
                    } else if (loopRunView.O00000Oo == Direction.DOWN) {
                        if (loopRunView.O00000o <= 0) {
                            loopRunView.O00000o += loopRunView.f5634O000000o + loopRunView.O00000o0;
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
        if (!this.O0000OoO) {
            super.onDraw(canvas);
            return;
        }
        Rect rect = this.O0000Oo0;
        int i = this.O00000o;
        rect.top = i;
        rect.bottom = i + this.f5634O000000o;
        canvas.drawColor(0);
        canvas.drawBitmap(this.O00000oo, this.O0000Oo0, this.O0000Oo, this.O0000O0o);
        super.onDraw(canvas);
        this.O0000OOo.sendEmptyMessageDelayed(1, this.O00000oO);
    }

    public enum Direction {
        UP(0),
        DOWN(1);
        
        int value;

        private Direction(int i) {
            this.value = i;
        }
    }
}
