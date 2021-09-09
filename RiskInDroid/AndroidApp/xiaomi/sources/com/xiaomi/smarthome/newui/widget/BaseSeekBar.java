package com.xiaomi.smarthome.newui.widget;

import _m_j.hzf;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ProgressBar;

public class BaseSeekBar extends ProgressBar {

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f10273O000000o;
    private O000000o O00000Oo;
    private float O00000o;
    private int O00000o0;

    public interface O000000o {
        void O000000o(int i);

        void O000000o(BaseSeekBar baseSeekBar);
    }

    public BaseSeekBar(Context context) {
        super(context);
    }

    public BaseSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setCanSeek(boolean z) {
        this.f10273O000000o = z;
    }

    public void setOnSeekBarChangeListener(O000000o o000000o) {
        this.O00000Oo = o000000o;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        O000000o o000000o;
        O000000o o000000o2;
        super.onTouchEvent(motionEvent);
        if (!this.f10273O000000o) {
            return true;
        }
        int progress = getProgress();
        if (motionEvent.getAction() == 0) {
            this.O00000o0 = progress;
            this.O00000o = motionEvent.getX();
            O000000o o000000o3 = this.O00000Oo;
        } else {
            float x = ((float) this.O00000o0) + (((motionEvent.getX() - this.O00000o) / ((float) getWidth())) * ((float) getMax()));
            if (Build.VERSION.SDK_INT >= 26) {
                setProgress((int) Math.min((float) getMax(), Math.max((float) getMin(), x)), false);
            } else {
                setProgress((int) Math.min((float) getMax(), x));
            }
            System.currentTimeMillis();
            if ((getProgress() != progress || motionEvent.getAction() == 1) && hzf.O00000o0(this)) {
                hzf.O00000Oo(this);
            }
            if (!(getProgress() == progress || (o000000o2 = this.O00000Oo) == null)) {
                o000000o2.O000000o(getProgress());
            }
            if (motionEvent.getAction() == 1 && (o000000o = this.O00000Oo) != null) {
                o000000o.O000000o(this);
            }
        }
        return true;
    }
}
