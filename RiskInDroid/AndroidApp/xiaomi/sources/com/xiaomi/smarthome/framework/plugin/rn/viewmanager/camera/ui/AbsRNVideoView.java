package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui;

import _m_j.gcm;
import _m_j.gcn;
import _m_j.gsy;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.widget.FrameLayout;
import java.util.HashMap;

public abstract class AbsRNVideoView extends FrameLayout implements gcm {

    /* renamed from: O000000o  reason: collision with root package name */
    protected String f8575O000000o;
    int O00000Oo;
    int O00000o;
    int O00000o0;
    protected gcn O00000oO;
    Runnable O00000oo = new Runnable() {
        /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.$$Lambda$AbsRNVideoView$j8REJWBhuFAZ7h5IU1rUOuB39yE */

        public final void run() {
            AbsRNVideoView.this.O00000oo();
        }
    };
    private int O0000O0o = 0;
    private int O0000OOo = 0;

    public View getView() {
        return this;
    }

    public void setExternalParams(HashMap hashMap) {
    }

    public AbsRNVideoView(Context context) {
        super(context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000oo() {
        measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
        layout(getLeft(), getTop(), getRight(), getBottom());
    }

    public void requestLayout() {
        gsy.O00000Oo("RNVideoView", "requestLayout");
        super.requestLayout();
        removeCallbacks(this.O00000oo);
        postDelayed(this.O00000oo, 100);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        gsy.O00000Oo("RNVideoView", "onSizeChanged, previous width:" + this.O0000O0o + " previous height:" + this.O0000OOo + " current Width:" + i + " currentHeight:" + i2);
        this.O0000O0o = i;
        this.O0000OOo = i2;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        boolean z = true;
        if (configuration.orientation != 1) {
            z = false;
        }
        gsy.O00000Oo("RNVideoView", "onConfigurationChanged, current Orientation is portrait?:".concat(String.valueOf(z)));
    }

    public String getDid() {
        return this.f8575O000000o;
    }

    public void setDid(String str) {
        this.f8575O000000o = str;
    }

    public int getRecordingVideoWidth() {
        return this.O00000Oo;
    }

    public int getRecordingVideoHeight() {
        return this.O00000o0;
    }

    public int getFps() {
        return this.O00000o;
    }

    public void setVideoParams(gcn gcn) {
        this.O00000oO = gcn;
    }

    public int getVideoCodec() {
        gcn gcn = this.O00000oO;
        if (gcn == null) {
            return 1;
        }
        return gcn.f17540O000000o;
    }
}
