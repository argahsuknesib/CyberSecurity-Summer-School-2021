package _m_j;

import android.widget.FrameLayout;
import com.xiaomi.smarthome.camera.XmVideoViewGl;

public final class cjc implements cjh {

    /* renamed from: O000000o  reason: collision with root package name */
    fsf f13936O000000o;

    public final void O000000o(int i) {
    }

    public final void O0000OOo() {
    }

    public cjc(FrameLayout frameLayout) {
        this.f13936O000000o = new fsf(frameLayout.getContext(), frameLayout);
    }

    public final void O000000o(XmVideoViewGl.OnDirectionCtrlListener onDirectionCtrlListener) {
        fsf fsf = this.f13936O000000o;
        if (fsf != null) {
            fsf.setDirectionCtrlListener(onDirectionCtrlListener);
        }
    }

    public final void O000000o(XmVideoViewGl.IVideoViewListener iVideoViewListener) {
        fsf fsf = this.f13936O000000o;
        if (fsf != null) {
            fsf.setVideoViewListener(iVideoViewListener);
        }
    }

    public final void O000000o() {
        cki.O00000o("SimpleCameraView", "onResume");
        fsf fsf = this.f13936O000000o;
        if (fsf != null) {
            fsf.onResume();
        }
    }

    public final void O000000o(float f) {
        fsf fsf = this.f13936O000000o;
        if (fsf != null) {
            fsf.setDistort(f, 0.04411765f);
        }
    }

    public final void O00000Oo() {
        fsf fsf = this.f13936O000000o;
        if (fsf != null) {
            fsf.setDistort(468, 48);
        }
    }

    public final void O000000o(boolean z) {
        fsf fsf = this.f13936O000000o;
        if (fsf != null) {
            fsf.setIsFull(z);
        }
    }

    public final void O00000Oo(float f) {
        fsf fsf = this.f13936O000000o;
        if (fsf != null) {
            fsf.setScale(f, false);
        }
    }

    public final float O00000o0() {
        fsf fsf = this.f13936O000000o;
        if (fsf != null) {
            return fsf.getMiniScale();
        }
        return 0.0f;
    }

    public final float O00000o() {
        fsf fsf = this.f13936O000000o;
        if (fsf != null) {
            return fsf.getScale();
        }
        return 0.0f;
    }

    public final float O00000oO() {
        fsf fsf = this.f13936O000000o;
        if (fsf == null || fsf.f13958O000000o == null) {
            return 0.0f;
        }
        return fsf.f13958O000000o.getOffsetX();
    }

    public final float O00000oo() {
        fsf fsf = this.f13936O000000o;
        if (fsf == null || fsf.f13958O000000o == null) {
            return 0.0f;
        }
        return fsf.f13958O000000o.getOffsetY();
    }

    public final void O00000o0(float f) {
        fsf fsf = this.f13936O000000o;
        if (fsf != null && fsf.f13958O000000o != null) {
            fsf.f13958O000000o.setOffsetX(f);
        }
    }

    public final void O00000o(float f) {
        fsf fsf = this.f13936O000000o;
        if (fsf != null && fsf.f13958O000000o != null) {
            fsf.f13958O000000o.setOffsetY(f);
        }
    }

    public final void O000000o(XmVideoViewGl.PhotoSnapCallback photoSnapCallback) {
        fsf fsf = this.f13936O000000o;
        if (fsf != null) {
            fsf.snap(photoSnapCallback);
        }
    }

    public final void O000000o(XmVideoViewGl.IVideoViewScaleListener iVideoViewScaleListener) {
        fsf fsf = this.f13936O000000o;
        if (fsf != null) {
            fsf.setVideoViewScaleListener(iVideoViewScaleListener);
        }
    }

    public final void O00000Oo(boolean z) {
        fsf fsf = this.f13936O000000o;
        if (fsf != null) {
            fsf.setMiniScale(z);
        }
    }

    public final void O000000o(XmVideoViewGl.OnScaleListener onScaleListener) {
        fsf fsf = this.f13936O000000o;
        if (fsf != null) {
            fsf.setOnScaleListener(onScaleListener);
        }
    }

    public final void O000000o(float f, float f2, float f3) {
        fsf fsf = this.f13936O000000o;
        if (fsf != null) {
            fsf.setBg(f, f2, f3);
        }
    }

    public final void O00000Oo(float f, float f2) {
        fsf fsf = this.f13936O000000o;
        if (fsf != null) {
            fsf.setMaxScale(f, f2);
        }
    }

    public final void O0000O0o() {
        fsf fsf = this.f13936O000000o;
        if (fsf != null && fsf.f13958O000000o != null) {
            fsf.f13958O000000o.setPartSuperResolutionEnable(true);
        }
    }
}
