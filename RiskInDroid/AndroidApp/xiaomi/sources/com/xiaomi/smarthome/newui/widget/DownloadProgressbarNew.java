package com.xiaomi.smarthome.newui.widget;

import _m_j.hhi;
import _m_j.hhk;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.xiaomi.smarthome.device.Device;

public class DownloadProgressbarNew extends ProgressBar implements hhk {
    public final void O000000o(Device device) {
    }

    public void setCallback(hhi hhi) {
    }

    public DownloadProgressbarNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setProgress(0);
    }

    public final void O000000o() {
        setProgress(0);
        setVisibility(0);
    }

    public final void O00000Oo() {
        setProgress(0);
        setVisible(false);
    }

    public final void O00000o0() {
        setProgress(0);
        setVisible(false);
    }

    public final void O00000o() {
        setProgress(0);
        setVisible(false);
    }

    public void setVisible(boolean z) {
        setVisibility(z ? 0 : 8);
    }

    public float getPercent() {
        return (float) getProgress();
    }

    public void setPercent(float f) {
        setProgress((int) f);
    }
}
