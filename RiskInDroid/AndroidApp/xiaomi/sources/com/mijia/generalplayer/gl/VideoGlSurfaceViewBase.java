package com.mijia.generalplayer.gl;

import _m_j.cjq;
import _m_j.cju;
import _m_j.cjw;
import _m_j.cki;
import android.content.Context;
import android.util.AttributeSet;

public class VideoGlSurfaceViewBase extends PhotoView {
    public int O000OoOO = 0;
    protected float O000OoOo = 0.0f;
    protected int O000Ooo = 0;
    protected float O000Ooo0 = 0.0f;
    protected int O000OooO = 0;
    public float O000Oooo;
    private String O000o000;

    public void setDistort(int i) {
    }

    public VideoGlSurfaceViewBase(Context context) {
        super(context);
    }

    public VideoGlSurfaceViewBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoGlSurfaceViewBase(Context context, boolean z, AttributeSet attributeSet) {
        super(context, z, null);
    }

    private void setFilter(cjq cjq) {
        if (!this.O0000O0o) {
            this.O0000OOo = cjq;
            return;
        }
        if (this.O0000OOo != null) {
            this.O0000OOo.O00000oO();
        }
        this.O0000OOo = cjq;
        if (this.O0000OOo != null) {
            this.O0000OOo.O00000o();
        }
    }

    public final cju O000000o(cju cju) {
        if (this.O0000OOo == null) {
            return cju;
        }
        if (this.O0000Oo0 != null || cju == null) {
            cju cju2 = this.O0000Oo0;
            int i = cju.O00000Oo;
            int i2 = cju.O00000o0;
            cju2.O00000Oo = i;
            cju2.O00000o0 = i2;
            cjw.O000000o(cju2.f13951O000000o);
            cju2.f13951O000000o = cjw.O000000o();
        } else {
            this.O0000Oo0 = cju.O000000o(cju.O00000Oo, cju.O00000o0);
        }
        this.O0000OOo.O000000o(cju, this.O0000Oo0);
        return this.O0000Oo0;
    }

    /* access modifiers changed from: protected */
    public void O00000Oo() {
        super.O00000Oo();
        if (this.O0000OOo != null) {
            this.O0000OOo.O00000o();
        }
    }

    /* access modifiers changed from: protected */
    public void O00000o0() {
        super.O00000o0();
        if (this.O0000OOo != null) {
            this.O0000OOo.O00000oO();
        }
        if (this.O0000Oo0 != null) {
            this.O0000Oo0.O000000o();
            this.O0000Oo0 = null;
        }
    }

    public void onPause() {
        cki.O00000o("PhotoView", "on pause");
        super.onPause();
    }

    public void onResume() {
        cki.O00000o("PhotoView", "on resume");
        super.onResume();
    }

    public final void O00000o0(float f, float f2) {
        this.O000OoOo = f;
        this.O000Ooo0 = f2;
    }

    public void setDid(String str) {
        this.O000o000 = str;
    }

    public String getDid() {
        return this.O000o000;
    }

    public final void O00000Oo(final int i) {
        O000000o(new Runnable() {
            /* class com.mijia.generalplayer.gl.VideoGlSurfaceViewBase.AnonymousClass1 */

            public final void run() {
                int i = i;
                if (VideoGlSurfaceViewBase.this.O000OoOO != i || VideoGlSurfaceViewBase.this.O000Oooo != VideoGlSurfaceViewBase.this.O000OoOo) {
                    VideoGlSurfaceViewBase videoGlSurfaceViewBase = VideoGlSurfaceViewBase.this;
                    videoGlSurfaceViewBase.O000Oooo = videoGlSurfaceViewBase.O000OoOo;
                    VideoGlSurfaceViewBase.this.O00000o0(i);
                    VideoGlSurfaceViewBase.this.O000OoOO = i;
                }
            }
        });
    }

    public final void O000000o(int i, int i2) {
        O000000o(this.O000OoOO, i, i2);
    }

    public final void O000000o(int i, int i2, int i3) {
        if (this.O000Ooo != 0) {
            int max = Math.max(1920, i2);
            int max2 = Math.max(1080, i3);
            this.O000OoOo = ((float) this.O000Ooo) / ((float) max);
            this.O000Ooo0 = ((float) this.O000OooO) / ((float) max2);
        }
        if (this.O000OoOo != this.O000Oooo || this.O000OoOO != i) {
            O00000Oo(i);
        }
    }

    public final void O00000o0(int i) {
        if (i == 1) {
            CorrectinglensDistortionFilter correctinglensDistortionFilter = new CorrectinglensDistortionFilter(getContext());
            correctinglensDistortionFilter.O000000o(0.0f, 0.0f);
            setFilter(correctinglensDistortionFilter);
        } else if (i == 2) {
            CorrectinglensDistortionFilter correctinglensDistortionFilter2 = new CorrectinglensDistortionFilter(getContext());
            correctinglensDistortionFilter2.O000000o(this.O000OoOo, this.O000Ooo0);
            setFilter(correctinglensDistortionFilter2);
        } else {
            setFilter(null);
        }
    }

    public final void O00000o(float f, float f2) {
        this.O000OoOo = f;
        this.O000Ooo0 = f2;
    }

    public final void O00000Oo(int i, int i2) {
        this.O000Ooo = i;
        this.O000OooO = i2;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        cki.O00000o("PhotoView", "onAttachedToWindow");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        cki.O00000o("PhotoView", "onDetachedFromWindow");
        onPause();
        super.onDetachedFromWindow();
    }
}
