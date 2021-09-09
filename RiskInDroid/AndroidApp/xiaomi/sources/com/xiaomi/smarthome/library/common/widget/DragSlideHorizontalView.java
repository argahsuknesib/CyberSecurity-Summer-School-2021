package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.HorizontalScrollView;
import com.xiaomi.smarthome.R;

public class DragSlideHorizontalView extends HorizontalScrollView {

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f9175O000000o = false;
    private View O00000Oo;
    private View O00000o;
    private View O00000o0;
    private VelocityTracker O00000oO;
    private boolean O00000oo;
    private boolean O0000O0o;

    public DragSlideHorizontalView(Context context) {
        super(context);
    }

    public DragSlideHorizontalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DragSlideHorizontalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    public void setPaddingView(View view) {
        this.O00000o = view;
    }

    public void setAboveView(View view) {
        this.O00000Oo = view;
    }

    public void setBehindView(View view) {
        this.O00000o0 = view;
        this.f9175O000000o = false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        View view;
        if (this.O0000O0o) {
            if (motionEvent.getAction() == 1) {
                performClick();
            }
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            VelocityTracker velocityTracker = this.O00000oO;
            if (velocityTracker == null) {
                this.O00000oO = VelocityTracker.obtain();
            } else {
                velocityTracker.clear();
            }
            if (this.f9175O000000o && ((float) getWidth()) - motionEvent.getX() <= ((float) this.O00000o0.getWidth())) {
                this.O00000oo = true;
            }
        } else if (action != 1) {
            if (action == 2) {
                this.O00000oO.addMovement(motionEvent);
            } else if (action == 3) {
                if (this.f9175O000000o) {
                    O000000o();
                }
                this.O00000oo = false;
            }
        } else if (!this.O00000oo) {
            this.O00000oO.addMovement(motionEvent);
            this.O00000oO.computeCurrentVelocity(1000);
            if (this.O00000oO.getXVelocity() > 300.0f) {
                O000000o();
            } else {
                if (this.O00000oO.getXVelocity() >= -300.0f && (this.O00000o == null || computeHorizontalScrollOffset() <= this.O00000o.getWidth() / 2 || this.f9175O000000o)) {
                    if (this.O00000o != null && computeHorizontalScrollOffset() < this.O00000o.getWidth() / 2 && this.f9175O000000o) {
                        O000000o();
                    } else if (this.f9175O000000o) {
                        O000000o();
                    }
                }
                if (!this.f9175O000000o && (view = this.O00000o) != null) {
                    smoothScrollTo(view.getWidth(), 0);
                    this.f9175O000000o = true;
                    this.O00000o0.setVisibility(0);
                    this.O00000o0.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.mj_slide_in_right));
                }
            }
            return true;
        } else {
            this.O00000oo = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void O000000o() {
        if (this.f9175O000000o) {
            smoothScrollTo(0, 0);
            this.f9175O000000o = false;
            this.O00000o0.setVisibility(4);
            this.O00000o0.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_right));
        }
    }
}
