package com.ximalaya.ting.android.opensdk.auth.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;

public class LoadingBar extends TextView {
    /* access modifiers changed from: private */
    public int c;
    private int d;
    private Paint e;
    private Handler f;
    private Runnable g = new Runnable() {
        /* class com.ximalaya.ting.android.opensdk.auth.view.LoadingBar.AnonymousClass1 */

        public final void run() {
            LoadingBar loadingBar = LoadingBar.this;
            int unused = loadingBar.c = loadingBar.c + 1;
            LoadingBar loadingBar2 = LoadingBar.this;
            loadingBar2.a(loadingBar2.c);
        }
    };

    public LoadingBar(Context context) {
        super(context);
        a();
    }

    public LoadingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public LoadingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.f = new Handler();
        this.e = new Paint();
        this.d = -498622;
    }

    private void b() {
        this.d = -498622;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.e.setColor(this.d);
        canvas.drawRect(getRect(), this.e);
    }

    private Rect getRect() {
        int left = getLeft();
        int top = getTop();
        return new Rect(0, 0, (getLeft() + (((getRight() - getLeft()) * this.c) / 100)) - left, getBottom() - top);
    }

    public final void a(int i) {
        if (i < 7) {
            this.f.postDelayed(this.g, 70);
        } else {
            this.f.removeCallbacks(this.g);
            this.c = i;
        }
        invalidate();
    }
}
