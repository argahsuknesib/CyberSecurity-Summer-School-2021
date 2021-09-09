package com.xiaomi.smarthome.uwb.mico;

import android.view.MotionEvent;
import android.widget.SeekBar;

class RelativeSeekBarInjector {
    private float mOffset;
    private SeekBar mSeekBar;
    private boolean mVertical;

    public RelativeSeekBarInjector(SeekBar seekBar, boolean z) {
        this.mSeekBar = seekBar;
        this.mVertical = z;
    }

    public void setVertical(boolean z) {
        this.mVertical = z;
    }

    public void transformTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            computeTouchOffset(motionEvent);
        }
        float f = 0.0f;
        float f2 = this.mVertical ? 0.0f : this.mOffset;
        if (this.mVertical) {
            f = this.mOffset;
        }
        motionEvent.offsetLocation(f2, f);
    }

    private void computeTouchOffset(MotionEvent motionEvent) {
        float f;
        int[] iArr = new int[2];
        this.mSeekBar.getLocationOnScreen(iArr);
        float progress = ((float) this.mSeekBar.getProgress()) / ((float) this.mSeekBar.getMax());
        if (this.mVertical) {
            this.mOffset = (((float) (iArr[1] + this.mSeekBar.getPaddingTop())) + ((1.0f - progress) * ((float) ((this.mSeekBar.getHeight() - this.mSeekBar.getPaddingTop()) - this.mSeekBar.getPaddingBottom())))) - motionEvent.getRawY();
            return;
        }
        int width = (this.mSeekBar.getWidth() - this.mSeekBar.getPaddingStart()) - this.mSeekBar.getPaddingEnd();
        if (this.mSeekBar.getLayoutDirection() == 1) {
            f = ((float) ((iArr[0] + this.mSeekBar.getWidth()) - this.mSeekBar.getPaddingEnd())) - (progress * ((float) width));
        } else {
            f = ((float) (iArr[0] + this.mSeekBar.getPaddingStart())) + (progress * ((float) width));
        }
        this.mOffset = f - motionEvent.getRawX();
    }
}
