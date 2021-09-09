package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui;

import _m_j.gcg;
import _m_j.gsy;
import _m_j.hyy;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.xiaomi.smarthome.camera.VideoFrame;
import com.xiaomi.smarthome.camera.XmVideoViewGl;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import java.util.HashMap;
import java.util.Map;

public class RNVideoViewEx extends RNInternalVideoView {
    protected static Map<String, Integer> O0000O0o = new HashMap();
    private XmVideoViewGl O0000OOo;
    private boolean O0000Oo = false;
    private boolean O0000Oo0;
    private View.OnClickListener O0000OoO;
    private XmVideoViewGl.OnScaleListener O0000Ooo;
    private float O0000o = -1.0f;
    private float O0000o0 = -1.0f;
    private XmVideoViewGl.OnDirectionCtrlListener O0000o00;
    private float O0000o0O = -1.0f;
    private float O0000o0o = -1.0f;
    private boolean O0000oO;
    private float O0000oO0;
    private boolean O0000oOO;
    private float O0000oOo;

    public final void O000000o(gcg gcg) {
    }

    public RNVideoViewEx(Context context) {
        super(context);
        setBackgroundColor(Color.parseColor("#000000"));
    }

    public void setDid(String str) {
        super.setDid(str);
        XmVideoViewGl xmVideoViewGl = this.O0000OOo;
        if (xmVideoViewGl != null) {
            xmVideoViewGl.setDid(str);
        }
    }

    public final void O00000oo() {
        if (this.O0000OOo == null) {
            this.O0000OOo = XmPluginHostApi.instance().createVideoViewOnFront(getContext(), this, !this.O00000oO.O0000O0o, this.O00000oO.f17540O000000o);
            this.O0000OOo.initial();
            this.O0000OOo.clearQueue();
            this.O0000OOo.setDid(this.f8575O000000o);
            this.O0000OOo.setMiniScale(true);
            setOnClickListener(this.O0000OoO);
            setOnScaleListener(this.O0000Ooo);
            setDirectionCtrlListener(this.O0000o00);
            setDid(this.f8575O000000o);
            setRotation(this.O0000oO0);
            O0000O0o();
            setScale(this.O0000o0);
            setFullscreenState(this.O0000Oo0);
            setIsFullExpand(this.O0000oO);
            setWhiteBackground(this.O0000oOO);
            O000000o();
            setMaxScale(this.O0000oOo);
        }
    }

    public final void O000000o() {
        XmVideoViewGl xmVideoViewGl = this.O0000OOo;
        if (xmVideoViewGl != null) {
            xmVideoViewGl.setFps(this.O00000oO.O00000Oo);
        }
    }

    public void setRotation(float f) {
        gsy.O000000o(4, "RNVideoView", "setRotation: ".concat(String.valueOf(f)));
        this.O0000oO0 = f;
        XmVideoViewGl xmVideoViewGl = this.O0000OOo;
        if (xmVideoViewGl != null) {
            xmVideoViewGl.setRotation((int) f);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        XmVideoViewGl xmVideoViewGl;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && mode2 == 1073741824 && (xmVideoViewGl = this.O0000OOo) != null) {
            xmVideoViewGl.setWidth(size);
            this.O0000OOo.setHeight(size2);
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        gsy.O00000Oo("rn camera", "attached to window ");
    }

    private void O0000O0o() {
        XmVideoViewGl xmVideoViewGl = this.O0000OOo;
        if (xmVideoViewGl != null) {
            xmVideoViewGl.setDistort(this.O0000o0O, this.O0000o0o, this.O0000o);
        }
    }

    public void setScale(float f) {
        this.O0000o0 = f;
        XmVideoViewGl xmVideoViewGl = this.O0000OOo;
        if (xmVideoViewGl != null) {
            xmVideoViewGl.setRNScale(f, false);
        }
    }

    public void setMaxScale(float f) {
        this.O0000oOo = f;
        XmVideoViewGl xmVideoViewGl = this.O0000OOo;
        if (xmVideoViewGl != null) {
            xmVideoViewGl.setMaxScale(f, f);
        }
    }

    public final void O00000oO() {
        XmVideoViewGl xmVideoViewGl = this.O0000OOo;
        if (xmVideoViewGl != null) {
            xmVideoViewGl.release();
            this.O0000OOo = null;
        }
    }

    public final void O000000o(VideoFrame videoFrame) {
        XmVideoViewGl xmVideoViewGl;
        if (this.O0000Oo && (xmVideoViewGl = this.O0000OOo) != null) {
            xmVideoViewGl.drawVideoFrame(videoFrame);
        }
    }

    public void setFullscreenState(final boolean z) {
        Context context;
        this.O0000Oo0 = z;
        XmVideoViewGl xmVideoViewGl = this.O0000OOo;
        if (xmVideoViewGl != null) {
            xmVideoViewGl.setIsFullForRN(z);
            if (z && (context = getContext()) != null && (context instanceof Activity)) {
                ((Activity) context).getWindow().clearFlags(2048);
            }
            if (getContext() != null && (getContext() instanceof ReactContext) && ((ReactContext) getContext()).getCurrentActivity() != null) {
                post(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.RNVideoViewEx.AnonymousClass1 */

                    public final void run() {
                        hyy.O000000o(((ReactContext) RNVideoViewEx.this.getContext()).getCurrentActivity(), z);
                    }
                });
            }
        }
    }

    public final void O00000o0() {
        this.O0000Oo = true;
        XmVideoViewGl xmVideoViewGl = this.O0000OOo;
        if (xmVideoViewGl != null) {
            xmVideoViewGl.setVisible(true);
        }
    }

    public final void O00000Oo() {
        this.O0000Oo = false;
        XmVideoViewGl xmVideoViewGl = this.O0000OOo;
        if (xmVideoViewGl != null) {
            xmVideoViewGl.setNeedIFrame();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        gsy.O00000Oo("rn camera", "deattached from window view ");
    }

    public final void O000000o(XmVideoViewGl.PhotoSnapCallback photoSnapCallback) {
        XmVideoViewGl xmVideoViewGl = this.O0000OOo;
        if (xmVideoViewGl != null) {
            xmVideoViewGl.snap(photoSnapCallback);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.O0000OoO = onClickListener;
        XmVideoViewGl xmVideoViewGl = this.O0000OOo;
        if (xmVideoViewGl != null) {
            xmVideoViewGl.setVideoViewListener(new XmVideoViewGl.IVideoViewListener(onClickListener) {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.$$Lambda$RNVideoViewEx$f4Kin5p5mjHahg0pfQFMeeQfTw0 */
                private final /* synthetic */ View.OnClickListener f$1;

                {
                    this.f$1 = r2;
                }

                public final void onVideoViewClick() {
                    RNVideoViewEx.this.O000000o(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void setOnScaleListener(XmVideoViewGl.OnScaleListener onScaleListener) {
        this.O0000Ooo = onScaleListener;
        XmVideoViewGl xmVideoViewGl = this.O0000OOo;
        if (xmVideoViewGl != null) {
            xmVideoViewGl.setOnRNScaleListener(onScaleListener);
        }
    }

    public void setDirectionCtrlListener(XmVideoViewGl.OnDirectionCtrlListener onDirectionCtrlListener) {
        this.O0000o00 = onDirectionCtrlListener;
        XmVideoViewGl xmVideoViewGl = this.O0000OOo;
        if (xmVideoViewGl != null) {
            xmVideoViewGl.setDirectionCtrlListener(onDirectionCtrlListener);
        }
    }

    public void setOsdy(float f) {
        this.O0000o0o = f;
        if (this.O0000OOo != null) {
            O0000O0o();
        }
    }

    public void setOsdx(float f) {
        this.O0000o0O = f;
        if (this.O0000OOo != null) {
            O0000O0o();
        }
    }

    public void setCorrectRadius(float f) {
        this.O0000o = f;
        if (this.O0000OOo != null) {
            O0000O0o();
        }
    }

    public void setIsFullExpand(boolean z) {
        this.O0000oO = z;
        XmVideoViewGl xmVideoViewGl = this.O0000OOo;
        if (xmVideoViewGl != null) {
            xmVideoViewGl.setMiniScale(!z);
        }
    }

    public void setWhiteBackground(boolean z) {
        this.O0000oOO = z;
        XmVideoViewGl xmVideoViewGl = this.O0000OOo;
        if (xmVideoViewGl == null) {
            return;
        }
        if (z) {
            xmVideoViewGl.setBg(255.0f, 255.0f, 255.0f);
        } else {
            xmVideoViewGl.setBg(0.0f, 0.0f, 0.0f);
        }
    }

    public final void O00000o() {
        XmVideoViewGl xmVideoViewGl = this.O0000OOo;
        if (xmVideoViewGl != null) {
            xmVideoViewGl.setVisible(false);
        }
    }
}
