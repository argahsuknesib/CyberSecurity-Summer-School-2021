package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui;

import _m_j.frz;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import com.xiaomi.smarthome.camera.VideoFrame;
import com.xiaomi.smarthome.camera.XmVideoViewGl;
import com.xiaovv.player.HSVideoView;
import java.util.HashMap;

public class RNHSVideoView extends AbsRNVideoView {
    HSVideoView O0000O0o;
    private frz O0000OOo = new frz();

    public final void O00000Oo() {
    }

    public final void O00000o() {
    }

    public final void O00000o0() {
    }

    public final void O00000oO() {
    }

    public View getView() {
        return this;
    }

    public void setDirectionCtrlListener(XmVideoViewGl.OnDirectionCtrlListener onDirectionCtrlListener) {
    }

    public void setOnScaleListener(XmVideoViewGl.OnScaleListener onScaleListener) {
    }

    public RNHSVideoView(Context context) {
        super(context);
        setBackgroundColor(Color.parseColor("#000000"));
        this.O0000O0o = new HSVideoView(context);
        frz frz = this.O0000OOo;
        frz.O00000oO = new frz.O000000o() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.$$Lambda$RNHSVideoView$_J_mABrQieifiFIP00ONbZizWA0 */

            public final void onVideoData(byte[] bArr, int i, int i2) {
                RNHSVideoView.this.O000000o(bArr, i, i2);
            }
        };
        frz.O00000o = new frz.O00000Oo("ExternalVideoDecoder");
        frz.O00000o.start();
        frz.O00000o0 = true;
        addView(this.O0000O0o, 0, new FrameLayout.LayoutParams(-1, -1));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(byte[] bArr, int i, int i2) {
        this.O0000O0o.O000000o(bArr, i, i2);
    }

    public void setExternalParams(HashMap hashMap) {
        this.O0000O0o.setExternalParams(hashMap);
    }

    public final void O000000o(XmVideoViewGl.PhotoSnapCallback photoSnapCallback) {
        if (photoSnapCallback != null) {
            photoSnapCallback.onSnap(this.O0000O0o.O00000o0());
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.O0000O0o.setOnVideoViewListener(new HSVideoView.O000000o(onClickListener) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.$$Lambda$RNHSVideoView$LbvjRQzTeXg9tul_sumQaeD5dI */
            private final /* synthetic */ View.OnClickListener f$0;

            {
                this.f$0 = r1;
            }

            public final void onVideoViewClick() {
                RNHSVideoView.O000000o(this.f$0);
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            onClickListener.onClick(null);
        }
    }

    public final void O000000o(VideoFrame videoFrame) {
        frz frz = this.O0000OOo;
        if (frz != null) {
            frz.O000000o(videoFrame);
        }
    }
}
