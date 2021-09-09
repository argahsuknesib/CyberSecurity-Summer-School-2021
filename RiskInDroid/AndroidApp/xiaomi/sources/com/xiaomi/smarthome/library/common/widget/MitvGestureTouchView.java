package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.xiaomi.smarthome.R;

public class MitvGestureTouchView extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    O000000o f9222O000000o;
    GestureDetector O00000Oo;
    int O00000o;
    ImageView O00000o0;
    GestureDetector.OnGestureListener O00000oO = new GestureDetector.OnGestureListener() {
        /* class com.xiaomi.smarthome.library.common.widget.MitvGestureTouchView.AnonymousClass1 */

        public final boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        public final void onLongPress(MotionEvent motionEvent) {
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        public final void onShowPress(MotionEvent motionEvent) {
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (Math.abs(f) > Math.abs(f2)) {
                if (f > 0.0f) {
                    MitvGestureTouchView.this.O000000o((int) motionEvent2.getX(), (int) motionEvent2.getY(), 1);
                } else {
                    MitvGestureTouchView.this.O000000o((int) motionEvent2.getX(), (int) motionEvent2.getY(), 0);
                }
            } else if (f2 > 0.0f) {
                MitvGestureTouchView.this.O000000o((int) motionEvent2.getX(), (int) motionEvent2.getY(), 3);
            } else {
                MitvGestureTouchView.this.O000000o((int) motionEvent2.getX(), (int) motionEvent2.getY(), 2);
            }
            return true;
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            MitvGestureTouchView.this.O000000o((int) motionEvent.getX(), (int) motionEvent.getY(), 4);
            return true;
        }
    };

    public interface O000000o {
    }

    public void setStyle(int i) {
        this.O00000o = i;
    }

    public void setOnGestureTouchEvent(O000000o o000000o) {
        this.f9222O000000o = o000000o;
    }

    public MitvGestureTouchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.O00000o0 = (ImageView) findViewById(R.id.circle_view);
        this.O00000Oo = new GestureDetector(getContext(), this.O00000oO);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.O00000Oo.onTouchEvent(motionEvent);
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.O00000Oo.onTouchEvent(motionEvent);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.O00000o0.getLayoutParams();
        layoutParams.setMargins(i - (this.O00000o0.getWidth() / 2), i2 - (this.O00000o0.getHeight() / 2), 0, 0);
        this.O00000o0.setLayoutParams(layoutParams);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setDuration(500);
        animationSet.setInterpolator(new LinearInterpolator());
        animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
        this.O00000o0.setVisibility(0);
        if (i3 == 0) {
            if (this.O00000o == R.layout.sm_widget_mitv_page_white) {
                this.O00000o0.setImageResource(R.drawable.mitv_left);
            } else {
                this.O00000o0.setImageResource(R.drawable.mitv_left_black);
            }
            animationSet.addAnimation(new TranslateAnimation(0.0f, -60.0f, 0.0f, 0.0f));
        } else if (i3 == 1) {
            if (this.O00000o == R.layout.sm_widget_mitv_page_white) {
                this.O00000o0.setImageResource(R.drawable.mitv_right);
            } else {
                this.O00000o0.setImageResource(R.drawable.mitv_right_black);
            }
            animationSet.addAnimation(new TranslateAnimation(0.0f, 60.0f, 0.0f, 0.0f));
        } else if (i3 == 2) {
            if (this.O00000o == R.layout.sm_widget_mitv_page_white) {
                this.O00000o0.setImageResource(R.drawable.mitv_up);
            } else {
                this.O00000o0.setImageResource(R.drawable.mitv_up_black);
            }
            animationSet.addAnimation(new TranslateAnimation(0.0f, 0.0f, 0.0f, -60.0f));
        } else if (i3 == 3) {
            if (this.O00000o == R.layout.sm_widget_mitv_page_white) {
                this.O00000o0.setImageResource(R.drawable.mitv_down);
            } else {
                this.O00000o0.setImageResource(R.drawable.mitv_down_black);
            }
            animationSet.addAnimation(new TranslateAnimation(0.0f, 0.0f, 0.0f, 60.0f));
        } else {
            this.O00000o0.setVisibility(8);
            return;
        }
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            /* class com.xiaomi.smarthome.library.common.widget.MitvGestureTouchView.AnonymousClass2 */

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                MitvGestureTouchView.this.O00000o0.setVisibility(8);
            }
        });
        requestLayout();
        this.O00000o0.startAnimation(animationSet);
    }
}
