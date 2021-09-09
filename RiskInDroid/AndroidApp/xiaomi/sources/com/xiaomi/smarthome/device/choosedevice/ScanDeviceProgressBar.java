package com.xiaomi.smarthome.device.choosedevice;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.R;
import java.util.Timer;
import java.util.TimerTask;

public class ScanDeviceProgressBar extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public ClipDrawable f7259O000000o;
    ImageView O00000Oo;
    public int O00000o;
    public O000000o O00000o0;
    public int O00000oO;
    public Timer O00000oo;
    public int O0000O0o;

    public interface O000000o {
        void onTimeOut();
    }

    public ScanDeviceProgressBar(Context context) {
        this(context, null);
    }

    public ScanDeviceProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScanDeviceProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000o = 30000;
        this.O00000oO = 0;
        this.O0000O0o = 50;
        O00000o();
    }

    private void O00000o() {
        ImageView imageView = this.O00000Oo;
        if (imageView != null) {
            removeView(imageView);
        }
        setBackgroundDrawable(getResources().getDrawable(R.drawable.scan_progress_bg));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.O00000Oo = new ImageView(getContext());
        this.O00000Oo.setImageDrawable(getResources().getDrawable(R.drawable.scan_progress_clip_drawable));
        this.f7259O000000o = (ClipDrawable) this.O00000Oo.getDrawable();
        addView(this.O00000Oo, layoutParams);
    }

    public void setTime(int i) {
        this.O00000o = i;
    }

    public void setPercent(int i) {
        this.O00000oO = i;
        this.f7259O000000o.setLevel((i * C.MSG_CUSTOM_BASE) / 100);
    }

    public final void O000000o() {
        if (this.O00000oo == null) {
            this.O00000oo = new Timer();
            this.O00000oo.schedule(new TimerTask() {
                /* class com.xiaomi.smarthome.device.choosedevice.ScanDeviceProgressBar.AnonymousClass1 */

                public final void run() {
                    ScanDeviceProgressBar.this.post(new Runnable() {
                        /* class com.xiaomi.smarthome.device.choosedevice.ScanDeviceProgressBar.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            int level = ScanDeviceProgressBar.this.f7259O000000o.getLevel() + ((ScanDeviceProgressBar.this.O0000O0o * C.MSG_CUSTOM_BASE) / ScanDeviceProgressBar.this.O00000o);
                            if (level < 10000) {
                                ScanDeviceProgressBar.this.f7259O000000o.setLevel(level);
                                ScanDeviceProgressBar.this.O00000oO = (level * 100) / C.MSG_CUSTOM_BASE;
                            } else if (ScanDeviceProgressBar.this.f7259O000000o.getLevel() < 10000) {
                                ScanDeviceProgressBar.this.f7259O000000o.setLevel(C.MSG_CUSTOM_BASE);
                                if (ScanDeviceProgressBar.this.O00000oo != null) {
                                    ScanDeviceProgressBar.this.O00000oo.cancel();
                                }
                                ScanDeviceProgressBar scanDeviceProgressBar = ScanDeviceProgressBar.this;
                                if (scanDeviceProgressBar.O00000Oo != null) {
                                    scanDeviceProgressBar.removeView(scanDeviceProgressBar.O00000Oo);
                                }
                                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                                scanDeviceProgressBar.O00000Oo = new ImageView(scanDeviceProgressBar.getContext());
                                scanDeviceProgressBar.O00000Oo.setImageDrawable(scanDeviceProgressBar.getResources().getDrawable(R.drawable.scan_progress_clip_timeout_drawable));
                                scanDeviceProgressBar.f7259O000000o = (ClipDrawable) scanDeviceProgressBar.O00000Oo.getDrawable();
                                scanDeviceProgressBar.setPercent(100);
                                scanDeviceProgressBar.addView(scanDeviceProgressBar.O00000Oo, layoutParams);
                                if (ScanDeviceProgressBar.this.O00000o0 != null) {
                                    ScanDeviceProgressBar.this.O00000o0.onTimeOut();
                                }
                            }
                        }
                    });
                }
            }, 0, (long) this.O0000O0o);
        }
    }

    public final void O00000Oo() {
        Timer timer = this.O00000oo;
        if (timer != null) {
            timer.cancel();
            this.O00000oo = null;
        }
    }

    public final void O00000o0() {
        O00000Oo();
        O00000o();
        this.f7259O000000o.setLevel(0);
        this.O00000oO = 0;
    }

    public int getPercent() {
        return this.O00000oO;
    }
}
