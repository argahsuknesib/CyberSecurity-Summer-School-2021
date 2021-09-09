package com.xiaomi.smarthome.device;

import _m_j.bs;
import _m_j.cb;
import _m_j.gpc;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import com.xiaomi.smarthome.R;

public class BleGatewayNestedScrollingParent extends LinearLayout implements bs {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f6895O000000o;
    private static int O00000oO;
    private static int O00000oo;
    public boolean O00000Oo = false;
    public FrameLayout O00000o;
    public O000000o O00000o0;
    private LinearLayout O0000O0o;
    private HeightChangeableView O0000OOo;
    private LinearLayout O0000Oo;
    private OverScroller O0000Oo0;
    private boolean O0000OoO = false;
    private boolean O0000Ooo = true;
    private boolean O0000o0 = false;
    private Handler O0000o00 = new Handler() {
        /* class com.xiaomi.smarthome.device.BleGatewayNestedScrollingParent.AnonymousClass2 */

        public final void handleMessage(Message message) {
            if (message.what == 100) {
                BleGatewayNestedScrollingParent.this.O00000o0.O000000o();
            }
        }
    };

    public interface O000000o {
        void O000000o();
    }

    public int getNestedScrollAxes() {
        return 0;
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return false;
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public void setCanScrollUp(boolean z) {
    }

    public void setIsMesh(boolean z) {
        this.O0000OoO = z;
    }

    public void setOnRefreshListener(O000000o o000000o) {
        this.O00000o0 = o000000o;
    }

    public BleGatewayNestedScrollingParent(Context context) {
        super(context);
        O00000Oo();
    }

    public BleGatewayNestedScrollingParent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O00000Oo();
    }

    public BleGatewayNestedScrollingParent(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O00000Oo();
    }

    private void O00000Oo() {
        this.O0000Oo0 = new OverScroller(getContext());
        final DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        O00000oO = (int) ((displayMetrics.density * 40.0f) + 0.5f);
        O00000oo = (int) ((displayMetrics.density * 50.0f) + 0.5f);
        post(new Runnable() {
            /* class com.xiaomi.smarthome.device.BleGatewayNestedScrollingParent.AnonymousClass1 */
            private boolean O00000o0 = false;

            public final void run() {
                if (!this.O00000o0) {
                    this.O00000o0 = true;
                    if (BleGatewayNestedScrollingParent.this.O00000o != null) {
                        BleGatewayNestedScrollingParent.f6895O000000o = BleGatewayNestedScrollingParent.this.O00000o.getMeasuredHeight();
                        BleGatewayNestedScrollingParent.this.O000000o();
                        return;
                    }
                    BleGatewayNestedScrollingParent.f6895O000000o = (int) ((displayMetrics.density * 258.33f) + 0.5f);
                    BleGatewayNestedScrollingParent.this.O000000o();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.O0000O0o = (LinearLayout) findViewById(R.id.head);
        this.O0000Oo = (LinearLayout) findViewById(R.id.content);
        this.O0000OOo = (HeightChangeableView) findViewById(R.id.refresh_wrapper);
        this.O00000o = (FrameLayout) findViewById(R.id.head_frame);
    }

    public void onStopNestedScroll(View view) {
        if (this.O0000o0) {
            this.O0000o0 = false;
        } else if (this.O0000OOo.getHeight() > 0) {
            if (this.O0000OOo.getHeight() >= O00000oO && !this.O00000Oo) {
                this.O00000Oo = true;
                this.O0000o00.sendEmptyMessage(100);
            }
            HeightChangeableView heightChangeableView = this.O0000OOo;
            ObjectAnimator ofInt = ObjectAnimator.ofInt(heightChangeableView, "height", heightChangeableView.getHeight(), 0);
            ofInt.setDuration(300L);
            ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
            ofInt.start();
        } else if (getScrollY() != 0 && getScrollY() != f6895O000000o && getScrollY() != 0) {
            if (getScrollY() > gpc.O000000o(150.0f)) {
                this.O0000Oo0.startScroll(0, getScrollY(), 0, f6895O000000o - getScrollY(), 300);
                invalidate();
                return;
            }
            this.O0000Oo0.startScroll(0, getScrollY(), 0, -getScrollY(), 300);
            invalidate();
        }
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        if (f2 <= 1500.0f || getScrollY() >= f6895O000000o) {
            return false;
        }
        this.O0000o0 = true;
        this.O0000Oo0.startScroll(0, getScrollY(), 0, f6895O000000o - getScrollY(), 300);
        invalidate();
        return true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        LinearLayout linearLayout = this.O0000O0o;
        if (linearLayout != null && linearLayout.getHeight() != 0) {
            boolean z = i2 > 0 && this.O0000Ooo && getScrollY() < f6895O000000o;
            boolean z2 = i2 < 0 && getScrollY() >= 0 && !cb.O00000Oo(view, -1);
            if (z) {
                if (this.O0000OOo.getHeight() > 0) {
                    int height = this.O0000OOo.getHeight() > i2 ? i2 : this.O0000OOo.getHeight();
                    if (height == this.O0000OOo.getHeight()) {
                        this.O0000OOo.setHeight(0);
                    } else {
                        HeightChangeableView heightChangeableView = this.O0000OOo;
                        heightChangeableView.setHeight(heightChangeableView.getHeight() - ((int) (((float) height) * 0.5f)));
                    }
                    if (height < i2) {
                        scrollBy(0, i2 - height);
                        this.O0000O0o.scrollBy(0, height - i2);
                        O00000o0();
                    } else {
                        i2 = height;
                    }
                } else {
                    if (i2 > f6895O000000o - getScrollY()) {
                        i2 = f6895O000000o - getScrollY();
                    }
                    scrollBy(0, i2);
                    this.O0000O0o.scrollBy(0, -i2);
                    O00000o0();
                }
            } else if (z2) {
                if (getScrollY() == 0) {
                    int height2 = this.O0000OOo.getHeight();
                    if (height2 < O00000oo) {
                        this.O0000OOo.setHeight(height2 - ((int) (((float) i2) * 0.5f)));
                    } else {
                        i2 = 0;
                    }
                } else {
                    if (Math.abs(i2) > getScrollY()) {
                        i2 = -getScrollY();
                    }
                    scrollBy(0, i2);
                    this.O0000O0o.scrollBy(0, -i2);
                    O00000o0();
                }
                i2 = -i2;
            } else {
                i2 = 0;
            }
            iArr[1] = i2;
        }
    }

    private void O00000o0() {
        this.O00000o.setAlpha(1.0f - (((float) getScrollY()) / ((float) f6895O000000o)));
    }

    public final void O000000o() {
        this.O0000Oo.getLayoutParams().height = ((gpc.O000000o(getContext()).y - gpc.O00000o0(getContext(), 318.33f)) + f6895O000000o) - gpc.O00000o0(getContext(), this.O0000OoO ? 84.0f : 20.0f);
        this.O0000Oo.requestLayout();
    }

    public void computeScroll() {
        super.computeScroll();
        if (this.O0000Oo0.computeScrollOffset()) {
            scrollTo(0, this.O0000Oo0.getCurrY());
            this.O0000O0o.scrollTo(0, -this.O0000Oo0.getCurrY());
            O00000o0();
            invalidate();
        }
    }
}
