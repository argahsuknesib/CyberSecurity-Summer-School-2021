package com.xiaomi.smarthome.infrared.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import java.util.Timer;
import java.util.TimerTask;

@SuppressLint({"AppCompatCustomView"})
public class LongPressButton extends ImageView {
    private boolean isRunning;
    private O000000o mLongPressChangeListener;
    private Timer mTimer;
    Runnable runnable = new Runnable() {
        /* class com.xiaomi.smarthome.infrared.widget.LongPressButton.AnonymousClass1 */

        public final void run() {
            LongPressButton.this.startTimerInterval();
        }
    };

    public interface O000000o {
    }

    private void notifyFinish() {
    }

    private void notifyStartPress() {
    }

    public void notifyChangeInterVal() {
    }

    public LongPressButton(Context context) {
        super(context);
    }

    public LongPressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LongPressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            startLongPress();
        } else if (action == 1 || action == 3) {
            stopLongPress();
        }
        return super.onTouchEvent(motionEvent);
    }

    private void startLongPress() {
        notifyStartPress();
        startTimerInterval();
        postDelayed(this.runnable, 200);
    }

    private void stopLongPress() {
        notifyFinish();
        stopIntervalTimer();
        removeCallbacks(this.runnable);
    }

    public synchronized void stopIntervalTimer() {
        if (this.isRunning) {
            this.isRunning = false;
            if (this.mTimer != null) {
                try {
                    this.mTimer.cancel();
                } catch (Exception unused) {
                }
            }
        }
    }

    public void setLongPressChangeListener(O000000o o000000o) {
        this.mLongPressChangeListener = o000000o;
    }

    public void startTimerInterval() {
        if (!this.isRunning) {
            this.isRunning = true;
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() {
                /* class com.xiaomi.smarthome.infrared.widget.LongPressButton.AnonymousClass2 */

                public final void run() {
                    LongPressButton.this.notifyChangeInterVal();
                }
            }, 0, 800);
        }
    }
}
