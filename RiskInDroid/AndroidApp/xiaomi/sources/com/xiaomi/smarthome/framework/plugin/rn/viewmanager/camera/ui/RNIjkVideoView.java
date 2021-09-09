package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui;

import _m_j.cja;
import _m_j.ckc;
import _m_j.cki;
import _m_j.ckj;
import _m_j.gcg;
import _m_j.gck;
import _m_j.gcn;
import _m_j.gsy;
import _m_j.hyy;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.xiaomi.smarthome.camera.VideoFrame;
import com.xiaomi.smarthome.camera.XmVideoViewGl;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.Locale;

public class RNIjkVideoView extends RNInternalVideoView {
    private cja O0000O0o;
    private float O0000OOo;
    private float O0000Oo;
    private float O0000Oo0;
    private boolean O0000OoO;
    private ckc O0000Ooo;
    private View O0000o = this.O0000Ooo.O00000Oo();
    private XmVideoViewGl.OnScaleListener O0000o0;
    private View.OnClickListener O0000o00;
    private XmVideoViewGl.OnDirectionCtrlListener O0000o0O;
    private gck O0000o0o;
    private String O0000oO;
    private View O0000oO0 = this.O0000Ooo.O00000o0();

    public final void O000000o() {
    }

    public final void O00000oo() {
    }

    public RNIjkVideoView(Context context) {
        super(context);
        cja cja = new cja(this);
        this.O0000O0o = cja;
        this.O0000Ooo = cja.O00000Oo;
        gsy.O000000o(LogType.CAMERA, "RNIjkVideoView", "create");
    }

    public final void O000000o(gcg gcg) {
        if (gcg instanceof gck) {
            this.O0000o0o = (gck) gcg;
            setOnClickListener(this.O0000o00);
            setOnScaleListener(this.O0000o0);
            setDirectionCtrlListener(this.O0000o0O);
            O0000O0o();
            setVideoUri(this.O00000oO);
            cki.O00000o("RNIjkVideoView", "initInVideoView");
        }
    }

    public void setVideoUri(gcn gcn) {
        cki.O00000o("RNIjkVideoView", "initPlayer：" + gcn.toString());
        this.O0000oO = String.format(Locale.US, "rtmj:did=%1$s&videoType=%2$d&sampleRate=%3$d&audioType=1&channel=1&dataBits=1", this.f8575O000000o, Integer.valueOf(gcn.f17540O000000o), Integer.valueOf(gcn.O00000o == 0 ? 8000 : 16000));
        ckj.O000000o().O000000o(this, "FIRST_RENDER:setVideoUri");
        this.O0000Ooo.O000000o(this.O0000oO, null);
    }

    public void setRotation(float f) {
        gsy.O000000o(4, "RNIjkVideoView", "setRotation: ".concat(String.valueOf(f)));
        cja cja = this.O0000O0o;
        if (cja != null && cja.f13933O000000o != null) {
            cja.f13933O000000o.setRotation((int) f);
        }
    }

    public void setFullscreenState(final boolean z) {
        Context context;
        this.O0000OoO = z;
        cja cja = this.O0000O0o;
        if (cja != null) {
            cja.O000000o(z);
        }
        if (z && (context = getContext()) != null && (context instanceof Activity)) {
            ((Activity) context).getWindow().clearFlags(2048);
        }
        if (getContext() != null && (getContext() instanceof ReactContext) && ((ReactContext) getContext()).getCurrentActivity() != null) {
            post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.RNIjkVideoView.AnonymousClass1 */

                public final void run() {
                    hyy.O000000o(((ReactContext) RNIjkVideoView.this.getContext()).getCurrentActivity(), z);
                }
            });
        }
    }

    public void setIsFullExpand(boolean z) {
        cja cja = this.O0000O0o;
        if (cja != null) {
            cja.O00000Oo(!z);
        }
    }

    public void setCorrectRadius(float f) {
        this.O0000Oo = f;
        O0000O0o();
    }

    public void setOsdx(float f) {
        this.O0000OOo = f;
        O0000O0o();
    }

    public void setOsdy(float f) {
        this.O0000Oo0 = f;
        O0000O0o();
    }

    private void O0000O0o() {
        cja cja = this.O0000O0o;
        if (cja != null) {
            cja.O000000o(this.O0000OOo, this.O0000Oo0);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.mijia.generalplayer.gl.PhotoView.O000000o(float, boolean):void
     arg types: [float, int]
     candidates:
      com.mijia.generalplayer.gl.VideoGlSurfaceViewBase.O000000o(int, int):void
      com.mijia.generalplayer.gl.PhotoView.O000000o(float, float):void
      com.mijia.generalplayer.gl.PhotoView.O000000o(float, boolean):void */
    public void setScale(float f) {
        cja cja = this.O0000O0o;
        if (cja != null && cja.f13933O000000o != null) {
            float O00000o0 = cja.O00000o0();
            if (f > 0.0f && O00000o0 > 0.0f) {
                cja.f13933O000000o.O000000o(f * O00000o0, false);
            }
        }
    }

    public void setMaxScale(float f) {
        cja cja = this.O0000O0o;
        if (cja != null) {
            cja.O00000Oo(f, f);
        }
    }

    public final void O00000Oo() {
        gck gck = this.O0000o0o;
        if (gck != null) {
            gck.O00000Oo(this.O0000Ooo);
        }
    }

    public final void O00000o0() {
        gck gck = this.O0000o0o;
        if (gck != null) {
            gck.O000000o(this.O0000Ooo);
        }
        View view = this.O0000oO0;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.O0000o;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        cja cja = this.O0000O0o;
        if (cja != null) {
            cja.O000000o(0.0f, 0.0f, 0.0f);
        }
    }

    public final void O00000oO() {
        gck gck = this.O0000o0o;
        if (gck != null) {
            gck.O0000o0();
        }
        ckc ckc = this.O0000Ooo;
        if (ckc != null) {
            ckc.O0000Oo();
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.O0000o00 = onClickListener;
        cja cja = this.O0000O0o;
        if (cja != null) {
            cja.O000000o(new XmVideoViewGl.IVideoViewListener() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.$$Lambda$RNIjkVideoView$6JIyGONod6e8MN9487jxgkKoMVc */

                public final void onVideoViewClick() {
                    RNIjkVideoView.this.O0000OOo();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000OOo() {
        View.OnClickListener onClickListener = this.O0000o00;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void setOnScaleListener(XmVideoViewGl.OnScaleListener onScaleListener) {
        this.O0000o0 = onScaleListener;
        cja cja = this.O0000O0o;
        if (cja != null && cja.f13933O000000o != null) {
            cja.f13933O000000o.setOnScaleListener(new XmVideoViewGl.OnScaleListener(onScaleListener) {
                /* class _m_j.cja.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                final XmVideoViewGl.OnScaleListener f13934O000000o = this.O00000Oo;
                final /* synthetic */ XmVideoViewGl.OnScaleListener O00000Oo;

                {
                    this.O00000Oo = r2;
                }

                public final void onScaleChage(float f) {
                    if (this.f13934O000000o != null && cja.this.f13933O000000o != null && f > 0.0f) {
                        float minScale = cja.this.f13933O000000o.getMinScale();
                        if (f > 0.0f && minScale > 0.0f) {
                            this.f13934O000000o.onScaleChage(f / minScale);
                        }
                    }
                }

                public final void onFirstVideoShow() {
                    XmVideoViewGl.OnScaleListener onScaleListener = this.f13934O000000o;
                    if (onScaleListener != null) {
                        onScaleListener.onFirstVideoShow();
                    }
                }
            });
        }
    }

    public void setDirectionCtrlListener(XmVideoViewGl.OnDirectionCtrlListener onDirectionCtrlListener) {
        this.O0000o0O = onDirectionCtrlListener;
        cja cja = this.O0000O0o;
        if (cja != null) {
            cja.O000000o(onDirectionCtrlListener);
        }
    }

    public final void O000000o(XmVideoViewGl.PhotoSnapCallback photoSnapCallback) {
        this.O0000O0o.O000000o(photoSnapCallback);
    }

    public final void O00000o() {
        View view = this.O0000oO0;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.O0000o;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        gsy.O000000o(LogType.CAMERA, "RNIjkVideoView", "hideVideoView");
    }

    public final void O000000o(VideoFrame videoFrame) {
        cja cja = this.O0000O0o;
        if (cja != null) {
            cja.O000000o(videoFrame.distrot);
        }
    }

    public void setWhiteBackground(boolean z) {
        cki.O00000o0("RNIjkVideoView", "setWhiteBackground %b", Boolean.valueOf(z));
        cja cja = this.O0000O0o;
        if (cja == null) {
            return;
        }
        if (z) {
            cja.O000000o(255.0f, 255.0f, 255.0f);
        } else {
            cja.O000000o(0.0f, 0.0f, 0.0f);
        }
    }
}
