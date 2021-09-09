package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.mapsweeper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import java.util.Map;

public class ZoomMapSweeperView extends RelativeLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    float f8605O000000o;
    float O00000Oo;
    float O00000o;
    float O00000o0;
    float O00000oO;
    float O00000oo;
    float O0000O0o;
    O000000o O0000OOo;
    private boolean O0000Oo;
    public boolean O0000Oo0;
    private float O0000OoO;
    private float O0000Ooo;
    private float O0000o;
    private float O0000o0;
    private float O0000o00;
    private float O0000o0O;
    private boolean O0000o0o;
    private float O0000oO;
    private float O0000oO0;
    private float O0000oOO;
    private float O0000oOo;
    private final Paint O0000oo;
    private final Matrix O0000oo0;
    private Bitmap O0000ooO;
    private MapSweeperView O0000ooo;
    private int O00oOooO;
    private Handler O00oOooo;

    public interface O000000o {
    }

    public ZoomMapSweeperView(Context context) {
        this(context, null);
    }

    public ZoomMapSweeperView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZoomMapSweeperView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8605O000000o = 1.0f;
        this.O00000Oo = 10.0f;
        this.O00000o0 = 1.0f;
        this.O0000oo0 = new Matrix();
        this.O0000oo = new Paint();
        this.O0000Oo0 = true;
        this.O00oOooo = new Handler() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.mapsweeper.ZoomMapSweeperView.AnonymousClass1 */

            public final void handleMessage(Message message) {
                if (message != null && message.what == 1001) {
                    ZoomMapSweeperView.this.O0000Oo0 = true;
                }
            }
        };
        this.O0000ooo = new MapSweeperView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        addView(this.O0000ooo, layoutParams);
    }

    public MapSweeperView getMapSweeperView() {
        return this.O0000ooo;
    }

    public void setScreenWidth(int i) {
        this.O00oOooO = i;
    }

    public float getZoom() {
        return this.f8605O000000o;
    }

    public float getMaxZoom() {
        return this.O00000Oo;
    }

    public void setMaxZoom(float f) {
        if (f < 1.0f || f > 10.0f) {
            this.O00000Oo = 10.0f;
        } else {
            this.O00000Oo = f;
        }
    }

    public final void O000000o(float f, float f2, float f3) {
        this.f8605O000000o = Math.min(f, this.O00000Oo);
        this.O00000o = f2;
        this.O00000oO = f3;
        O00000Oo(this.f8605O000000o, f2, f3);
    }

    private void O00000Oo(float f, float f2, float f3) {
        this.O00000o0 = O00000o0(1.0f, f, this.O00000Oo);
        this.O00000oo = f2;
        this.O0000O0o = f3;
    }

    public O000000o getListener() {
        return this.O0000OOo;
    }

    public void setListner(O000000o o000000o) {
        this.O0000OOo = o000000o;
    }

    public float getZoomFocusX() {
        return this.O00000o * this.f8605O000000o;
    }

    public float getZoomFocusY() {
        return this.O00000oO * this.f8605O000000o;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() >= 2 || this.f8605O000000o > 1.0f) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0040, code lost:
        if (r13 != 4) goto L_0x0078;
     */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        if (motionEvent.getPointerCount() == 1) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            float hypot = (float) Math.hypot((double) (x - this.O0000OoO), (double) (y - this.O0000Ooo));
            float f = x - this.O0000o00;
            float f2 = y - this.O0000o0;
            this.O0000o00 = x;
            this.O0000o0 = y;
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (this.O0000Oo || hypot > 30.0f) {
                            if (!this.O0000Oo) {
                                this.O0000Oo = true;
                                motionEvent2.setAction(3);
                                super.dispatchTouchEvent(motionEvent);
                            }
                            float f3 = this.O00000oo;
                            float f4 = this.f8605O000000o;
                            this.O00000oo = f3 - (f / f4);
                            this.O0000O0o -= f2 / f4;
                        }
                    }
                }
                if (hypot < 30.0f) {
                    performClick();
                }
            } else {
                this.O0000OoO = x;
                this.O0000Ooo = y;
                this.O0000o00 = x;
                this.O0000o0 = y;
                this.O0000Oo = false;
            }
            motionEvent2.setLocation(this.O00000o + ((x - (((float) getWidth()) * 0.5f)) / this.f8605O000000o), this.O00000oO + ((y - (((float) getHeight()) * 0.5f)) / this.f8605O000000o));
            super.dispatchTouchEvent(motionEvent);
        }
        if (motionEvent.getPointerCount() == 2) {
            float x2 = motionEvent2.getX(0);
            float f5 = x2 - this.O0000oO0;
            this.O0000oO0 = x2;
            float y2 = motionEvent2.getY(0);
            float f6 = y2 - this.O0000oO;
            this.O0000oO = y2;
            float x3 = motionEvent2.getX(1);
            float f7 = x3 - this.O0000oOO;
            this.O0000oOO = x3;
            float y3 = motionEvent2.getY(1);
            float f8 = y3 - this.O0000oOo;
            this.O0000oOo = y3;
            float hypot2 = (float) Math.hypot((double) (x3 - x2), (double) (y3 - y2));
            float f9 = hypot2 - this.O0000o;
            this.O0000o = hypot2;
            float abs = Math.abs(hypot2 - this.O0000o0O);
            int action2 = motionEvent.getAction();
            if (action2 != 0) {
                if (action2 != 2) {
                    if (action2 == 6 || action2 == 262) {
                        getMapSweeperView().O000000o(150L);
                    }
                } else if (this.O0000o0o || abs > 30.0f) {
                    this.O0000o0o = true;
                    float max = Math.max(1.0f, (this.f8605O000000o * hypot2) / (hypot2 - f9));
                    float f10 = this.O00000o;
                    float f11 = this.f8605O000000o;
                    O00000Oo(max, f10 - (((f5 + f7) * 0.5f) / f11), this.O00000oO - (((f6 + f8) * 0.5f) / f11));
                }
                motionEvent2.setAction(3);
                super.dispatchTouchEvent(motionEvent);
            } else {
                this.O0000o0O = hypot2;
            }
            this.O0000o0o = false;
            motionEvent2.setAction(3);
            super.dispatchTouchEvent(motionEvent);
        }
        int action3 = motionEvent.getAction();
        if (action3 != 0) {
            if (action3 == 1) {
                this.O00oOooo.sendEmptyMessageDelayed(1001, 10000);
            }
        } else if (motionEvent.getPointerCount() == 2) {
            this.O0000Oo0 = false;
        }
        getRootView().invalidate();
        invalidate();
        return true;
    }

    private static float O00000o0(float f, float f2, float f3) {
        return Math.max(f, Math.min(f2, f3));
    }

    private static float O00000o(float f, float f2, float f3) {
        float f4 = f2 - f;
        return Math.abs(f4) >= f3 ? f + (f3 * Math.signum(f4)) : f2;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (getChildCount() != 0) {
            float O00000o2 = O00000o(this.f8605O000000o, this.O00000o0, 0.05f);
            this.f8605O000000o = O00000o2 + ((this.O00000o0 - O00000o2) * 0.2f);
            this.O00000oo = O00000o0((((float) getWidth()) * 0.5f) / this.O00000o0, this.O00000oo, ((float) getWidth()) - ((((float) getWidth()) * 0.5f) / this.O00000o0));
            this.O0000O0o = O00000o0((((float) getHeight()) * 0.5f) / this.O00000o0, this.O0000O0o, ((float) getHeight()) - ((((float) getHeight()) * 0.5f) / this.O00000o0));
            float O00000o3 = O00000o(this.O00000o, this.O00000oo, 0.1f);
            this.O00000o = O00000o3 + ((this.O00000oo - O00000o3) * 0.35f);
            float O00000o4 = O00000o(this.O00000oO, this.O0000O0o, 0.1f);
            this.O00000oO = O00000o4 + ((this.O0000O0o - O00000o4) * 0.35f);
            this.O0000oo0.setTranslate(((float) getWidth()) * 0.5f, ((float) getHeight()) * 0.5f);
            Matrix matrix = this.O0000oo0;
            float f = this.f8605O000000o;
            matrix.preScale(f, f);
            this.O0000oo0.preTranslate(-O00000o0((((float) getWidth()) * 0.5f) / this.f8605O000000o, this.O00000o, ((float) getWidth()) - ((((float) getWidth()) * 0.5f) / this.f8605O000000o)), -O00000o0((((float) getHeight()) * 0.5f) / this.f8605O000000o, this.O00000oO, ((float) getHeight()) - ((((float) getHeight()) * 0.5f) / this.f8605O000000o)));
            View childAt = getChildAt(0);
            this.O0000oo0.preTranslate((float) childAt.getLeft(), (float) childAt.getTop());
            MapSweeperView mapSweeperView = this.O0000ooo;
            if (mapSweeperView != null) {
                float f2 = this.f8605O000000o;
                if (mapSweeperView.f8599O000000o != null) {
                    for (Map.Entry<String, CommonSweeperView> value : mapSweeperView.f8599O000000o.entrySet()) {
                        CommonSweeperView commonSweeperView = (CommonSweeperView) value.getValue();
                        if (commonSweeperView != null) {
                            commonSweeperView.setZoom(f2);
                        }
                    }
                }
            }
            this.O0000ooO = null;
            canvas.save();
            canvas.concat(this.O0000oo0);
            childAt.draw(canvas);
            canvas.restore();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3 = this.O00oOooO;
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        if (mode == 1073741824 && (mode2 == 1073741824 || mode2 == Integer.MIN_VALUE)) {
            i3 = size <= size2 ? size : size2;
        }
        this.O0000ooo.setHeight(i3);
        this.O0000ooo.setWidth(i3);
        super.onMeasure(i, i2);
    }
}
