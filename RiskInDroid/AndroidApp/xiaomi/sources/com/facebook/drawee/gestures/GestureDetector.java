package com.facebook.drawee.gestures;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.facebook.common.internal.VisibleForTesting;

public class GestureDetector {
    @VisibleForTesting
    long mActionDownTime;
    @VisibleForTesting
    float mActionDownX;
    @VisibleForTesting
    float mActionDownY;
    @VisibleForTesting
    ClickListener mClickListener;
    @VisibleForTesting
    boolean mIsCapturingGesture;
    @VisibleForTesting
    boolean mIsClickCandidate;
    @VisibleForTesting
    final float mSingleTapSlopPx;

    public interface ClickListener {
        boolean onClick();
    }

    public GestureDetector(Context context) {
        this.mSingleTapSlopPx = (float) ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static GestureDetector newInstance(Context context) {
        return new GestureDetector(context);
    }

    public void init() {
        this.mClickListener = null;
        reset();
    }

    public void reset() {
        this.mIsCapturingGesture = false;
        this.mIsClickCandidate = false;
    }

    public void setClickListener(ClickListener clickListener) {
        this.mClickListener = clickListener;
    }

    public boolean isCapturingGesture() {
        return this.mIsCapturingGesture;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ClickListener clickListener;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.mIsCapturingGesture = false;
                if (Math.abs(motionEvent.getX() - this.mActionDownX) > this.mSingleTapSlopPx || Math.abs(motionEvent.getY() - this.mActionDownY) > this.mSingleTapSlopPx) {
                    this.mIsClickCandidate = false;
                }
                if (this.mIsClickCandidate && motionEvent.getEventTime() - this.mActionDownTime <= ((long) ViewConfiguration.getLongPressTimeout()) && (clickListener = this.mClickListener) != null) {
                    clickListener.onClick();
                }
            } else if (action != 2) {
                if (action == 3) {
                    this.mIsCapturingGesture = false;
                }
            } else if (Math.abs(motionEvent.getX() - this.mActionDownX) > this.mSingleTapSlopPx || Math.abs(motionEvent.getY() - this.mActionDownY) > this.mSingleTapSlopPx) {
                this.mIsClickCandidate = false;
            }
            this.mIsClickCandidate = false;
        } else {
            this.mIsCapturingGesture = true;
            this.mIsClickCandidate = true;
            this.mActionDownTime = motionEvent.getEventTime();
            this.mActionDownX = motionEvent.getX();
            this.mActionDownY = motionEvent.getY();
        }
        return true;
    }
}
