package _m_j;

import android.widget.FrameLayout;
import com.mijia.generalplayer.gl.VideoGlSurfaceViewBase;
import com.mijia.generalplayer.ijk.GlSurfaceRenderView;
import com.mijia.generalplayer.player.GeneralIjkPlayer;
import com.xiaomi.smarthome.camera.XmVideoViewGl;

public final class cja implements cjh {

    /* renamed from: O000000o  reason: collision with root package name */
    public VideoGlSurfaceViewBase f13933O000000o = ((GlSurfaceRenderView) this.O00000Oo.O00000o0());
    public ckc O00000Oo;
    private cjv O00000o0;

    public final void O0000O0o() {
    }

    public cja(FrameLayout frameLayout) {
        this.O00000Oo = new GeneralIjkPlayer(frameLayout.getContext(), 3);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.setBackgroundColor(-16777216);
        frameLayout.addView(this.O00000Oo.O00000Oo(), layoutParams);
        cki.O00000o0("GeneralCameraView", "create GeneralCameraView");
        this.O00000o0 = new cjv(this.f13933O000000o);
    }

    public final void O000000o(XmVideoViewGl.OnDirectionCtrlListener onDirectionCtrlListener) {
        cjv cjv = this.O00000o0;
        if (cjv != null) {
            cjv.O0000OoO = onDirectionCtrlListener;
        }
    }

    public final void O000000o() {
        cki.O00000o("GeneralCameraView", "onResume");
        VideoGlSurfaceViewBase videoGlSurfaceViewBase = this.f13933O000000o;
        if (videoGlSurfaceViewBase != null) {
            videoGlSurfaceViewBase.onResume();
        }
    }

    public final void O000000o(float f) {
        VideoGlSurfaceViewBase videoGlSurfaceViewBase = this.f13933O000000o;
        if (videoGlSurfaceViewBase != null) {
            videoGlSurfaceViewBase.O00000o(f, 0.04411765f);
        }
    }

    public final void O00000Oo() {
        VideoGlSurfaceViewBase videoGlSurfaceViewBase = this.f13933O000000o;
        if (videoGlSurfaceViewBase != null) {
            videoGlSurfaceViewBase.O00000Oo(468, 48);
        }
    }

    public final void O000000o(float f, float f2) {
        VideoGlSurfaceViewBase videoGlSurfaceViewBase = this.f13933O000000o;
        if (videoGlSurfaceViewBase != null) {
            videoGlSurfaceViewBase.O00000o0(f, f2);
        }
    }

    public final void O000000o(boolean z) {
        cjv cjv = this.O00000o0;
        if (cjv != null) {
            cjv.O00000oO = z;
        }
        VideoGlSurfaceViewBase videoGlSurfaceViewBase = this.f13933O000000o;
        if (videoGlSurfaceViewBase != null) {
            videoGlSurfaceViewBase.setIsFull(z);
        }
        cjv cjv2 = this.O00000o0;
        if (cjv2 != null) {
            cjv2.O00000Oo(3);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.mijia.generalplayer.gl.PhotoView.O000000o(float, boolean):void
     arg types: [float, int]
     candidates:
      com.mijia.generalplayer.gl.VideoGlSurfaceViewBase.O000000o(int, int):void
      com.mijia.generalplayer.gl.PhotoView.O000000o(float, float):void
      com.mijia.generalplayer.gl.PhotoView.O000000o(float, boolean):void */
    public final void O00000Oo(float f) {
        VideoGlSurfaceViewBase videoGlSurfaceViewBase = this.f13933O000000o;
        if (videoGlSurfaceViewBase != null) {
            videoGlSurfaceViewBase.O000000o(f, false);
        }
    }

    public final float O00000o0() {
        VideoGlSurfaceViewBase videoGlSurfaceViewBase = this.f13933O000000o;
        if (videoGlSurfaceViewBase != null) {
            return videoGlSurfaceViewBase.getMinScale();
        }
        return 0.0f;
    }

    public final float O00000o() {
        VideoGlSurfaceViewBase videoGlSurfaceViewBase = this.f13933O000000o;
        if (videoGlSurfaceViewBase != null) {
            return videoGlSurfaceViewBase.O00000o;
        }
        return 0.0f;
    }

    public final float O00000oO() {
        VideoGlSurfaceViewBase videoGlSurfaceViewBase = this.f13933O000000o;
        if (videoGlSurfaceViewBase != null) {
            return videoGlSurfaceViewBase.getOffsetX();
        }
        return 0.0f;
    }

    public final float O00000oo() {
        VideoGlSurfaceViewBase videoGlSurfaceViewBase = this.f13933O000000o;
        if (videoGlSurfaceViewBase != null) {
            return videoGlSurfaceViewBase.getOffsetY();
        }
        return 0.0f;
    }

    public final void O00000o0(float f) {
        VideoGlSurfaceViewBase videoGlSurfaceViewBase = this.f13933O000000o;
        if (videoGlSurfaceViewBase != null) {
            videoGlSurfaceViewBase.setOffsetX(f);
        }
    }

    public final void O00000o(float f) {
        VideoGlSurfaceViewBase videoGlSurfaceViewBase = this.f13933O000000o;
        if (videoGlSurfaceViewBase != null) {
            videoGlSurfaceViewBase.setOffsetY(f);
        }
    }

    public final void O000000o(XmVideoViewGl.PhotoSnapCallback photoSnapCallback) {
        VideoGlSurfaceViewBase videoGlSurfaceViewBase = this.f13933O000000o;
        if (videoGlSurfaceViewBase != null) {
            videoGlSurfaceViewBase.O000000o(photoSnapCallback);
        }
    }

    public final void O000000o(XmVideoViewGl.IVideoViewScaleListener iVideoViewScaleListener) {
        cjv cjv = this.O00000o0;
        if (cjv != null) {
            cjv.O0000Oo = iVideoViewScaleListener;
        }
    }

    public final void O00000Oo(boolean z) {
        VideoGlSurfaceViewBase videoGlSurfaceViewBase = this.f13933O000000o;
        if (videoGlSurfaceViewBase != null) {
            videoGlSurfaceViewBase.setMinScale(z);
        }
    }

    public final void O000000o(int i) {
        VideoGlSurfaceViewBase videoGlSurfaceViewBase = this.f13933O000000o;
        if (videoGlSurfaceViewBase != null) {
            videoGlSurfaceViewBase.setDistort(i);
        }
    }

    public final void O000000o(XmVideoViewGl.OnScaleListener onScaleListener) {
        VideoGlSurfaceViewBase videoGlSurfaceViewBase = this.f13933O000000o;
        if (videoGlSurfaceViewBase != null) {
            videoGlSurfaceViewBase.setOnScaleListener(onScaleListener);
        }
    }

    public final void O000000o(float f, float f2, float f3) {
        VideoGlSurfaceViewBase videoGlSurfaceViewBase = this.f13933O000000o;
        if (videoGlSurfaceViewBase != null) {
            videoGlSurfaceViewBase.O000000o(f, f2, f3);
        }
    }

    public final void O00000Oo(float f, float f2) {
        VideoGlSurfaceViewBase videoGlSurfaceViewBase = this.f13933O000000o;
        if (videoGlSurfaceViewBase != null) {
            videoGlSurfaceViewBase.O000000o(f, f2);
        }
    }

    public final void O000000o(XmVideoViewGl.IVideoViewListener iVideoViewListener) {
        cjv cjv = this.O00000o0;
        if (cjv != null) {
            cjv.O0000Oo0 = iVideoViewListener;
        }
    }

    public final void O0000OOo() {
        ckc ckc = this.O00000Oo;
        if (ckc != null) {
            ckc.O0000Oo();
        }
    }
}
