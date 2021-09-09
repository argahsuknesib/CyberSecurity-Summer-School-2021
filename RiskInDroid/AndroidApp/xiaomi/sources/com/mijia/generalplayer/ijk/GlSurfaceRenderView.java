package com.mijia.generalplayer.ijk;

import _m_j.cju;
import _m_j.cjw;
import _m_j.cjy;
import _m_j.cki;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import com.mijia.generalplayer.gl.GlslFilter;
import com.mijia.generalplayer.gl.VideoGlSurfaceViewBase;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tv.danmaku.ijk.media.player.IMediaPlayer;

public class GlSurfaceRenderView extends VideoGlSurfaceViewBase implements cjy {
    private IMediaPlayer O000o;
    private volatile boolean O000o0 = false;
    private cju O000o00;
    private volatile Object O000o000 = new Object();
    private cju O000o00O;
    private int O000o00o;
    private float[] O000o0O = new float[16];
    private GlslFilter O000o0O0;
    private SurfaceTexture O000o0OO;
    private Surface O000o0Oo;
    private int O000o0o;
    private int O000o0o0;
    private int O000o0oo;
    private O00000Oo O000oO0 = new O00000Oo(this);
    private boolean O000oO00;

    public final void O00000o(int i, int i2) {
    }

    public final boolean O0000O0o() {
        return false;
    }

    public View getView() {
        return this;
    }

    public void setAspectRatio(int i) {
    }

    public GlSurfaceRenderView(Context context) {
        super(context);
        getHolder().addCallback(this.O000oO0);
    }

    public void setDistort(int i) {
        this.O000o0o0 = i;
    }

    public final void O00000Oo() {
        IMediaPlayer iMediaPlayer;
        super.O00000Oo();
        this.O000o0O0 = new GlslFilter(getContext());
        GlslFilter glslFilter = this.O000o0O0;
        glslFilter.O00000oO = 36197;
        glslFilter.O00000o();
        this.O000o00o = cjw.O000000o();
        GLES20.glBindTexture(36197, this.O000o00o);
        cjw.O000000o("glBindTexture mTextureID");
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        synchronized (this.O000o000) {
            this.O000o0 = false;
        }
        cjw.O000000o("surfaceCreated");
        if (this.O000o0Oo == null && this.O000o0O0 != null) {
            this.O000o0OO = new SurfaceTexture(this.O000o00o);
            this.O000o0Oo = new Surface(this.O000o0OO);
            this.O000o0OO.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
                /* class com.mijia.generalplayer.ijk.$$Lambda$GlSurfaceRenderView$cmrRzago_5dJnxM_BGH2jvRPmw */

                public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
                    GlSurfaceRenderView.this.O000000o(surfaceTexture);
                }
            });
            if (this.O000oO00 && (iMediaPlayer = this.O000o) != null) {
                iMediaPlayer.setSurface(this.O000o0Oo);
                this.O000oO00 = false;
            }
        }
        cki.O00000o("GlSurfaceRenderView", "initial");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(SurfaceTexture surfaceTexture) {
        synchronized (this.O000o000) {
            this.O000o0 = true;
            requestRender();
        }
    }

    public void setPlayer(IMediaPlayer iMediaPlayer) {
        Surface surface = this.O000o0Oo;
        if (surface != null) {
            iMediaPlayer.setSurface(surface);
            return;
        }
        this.O000o = iMediaPlayer;
        this.O000oO00 = true;
    }

    public final void O00000o() {
        synchronized (this.O000o000) {
            super.O00000o();
            try {
                if (this.O000o0) {
                    this.O000o0 = false;
                    int i = this.O000o0o;
                    int i2 = this.O000o0oo;
                    if (i == 640 && i2 == 368) {
                        i2 = 360;
                    }
                    if (i == 640 && i2 == 384) {
                        i2 = 360;
                    }
                    if (i == 1920 && i2 == 1088) {
                        i2 = 1080;
                    }
                    if (i == 1280) {
                        i2 = 720;
                    }
                    if (i == 2304) {
                        i2 = 1296;
                    }
                    if (i != 0) {
                        if (i2 != 0) {
                            O000000o(this.O000o0o0, i, i2);
                            if (this.O000o00 == null) {
                                this.O000o00 = cju.O000000o(i, i2);
                            } else {
                                this.O000o00.O00000Oo(i, i2);
                            }
                            if (this.O000o00O == null) {
                                this.O000o00O = new cju(this.O000o00o, i, i2);
                            }
                            this.O000o0OO.updateTexImage();
                            this.O000o0OO.getTransformMatrix(this.O000o0O);
                            this.O000o0O0.O000000o(this.O000o0O);
                            this.O000o0O0.O000000o(this.O000o00O, this.O000o00);
                            setPhoto(O000000o(this.O000o00));
                        }
                    }
                    cki.O00000o("GlSurfaceRenderView", "videoWith:" + i + " videoHeight:" + i2);
                }
            } catch (Exception e) {
                cki.O00000oO("GlSurfaceRenderView", "drawFrame e:" + e.getLocalizedMessage());
            }
        }
    }

    public final void O00000o0() {
        super.O00000o0();
        cki.O0000O0o("GlSurfaceRenderView", "release");
        cjw.O000000o(this.O000o00o);
        this.O000o0O0.O00000oO();
        this.O000o0O0 = null;
        this.O000o0OO.setOnFrameAvailableListener(null);
        this.O000o0OO.release();
        this.O000o0OO = null;
        this.O000o0Oo.release();
        this.O000o0Oo = null;
        cju cju = this.O000o00;
        if (cju != null) {
            cju.O000000o();
            this.O000o00 = null;
        }
        cju cju2 = this.O000o00O;
        if (cju2 != null) {
            cju2.O000000o();
            this.O000o00O = null;
        }
        this.O000o = null;
    }

    public final void O00000o0(int i, int i2) {
        this.O000o0o = i;
        this.O000o0oo = i2;
        cki.O00000o("GlSurfaceRenderView", "setVideoSize" + i + ":" + i2);
    }

    public void setVideoRotation(int i) {
        cki.O00000oO("GlSurfaceRenderView", "SurfaceView doesn't support rotation (" + i + ")!\n");
    }

    static final class O000000o implements cjy.O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        private GlSurfaceRenderView f5201O000000o;

        O000000o(GlSurfaceRenderView glSurfaceRenderView) {
            this.f5201O000000o = glSurfaceRenderView;
        }

        public final void O000000o(IMediaPlayer iMediaPlayer) {
            cki.O00000o("GlSurfaceRenderView", "bindToMediaPlayer");
            if (iMediaPlayer != null) {
                this.f5201O000000o.setPlayer(iMediaPlayer);
            }
        }

        public final cjy O000000o() {
            return this.f5201O000000o;
        }
    }

    public final void O000000o(cjy.O000000o o000000o) {
        O000000o o000000o2;
        O00000Oo o00000Oo = this.O000oO0;
        o00000Oo.O00000oo.put(o000000o, o000000o);
        if (o00000Oo.f5202O000000o != null) {
            o000000o2 = new O000000o(o00000Oo.O00000oO.get());
            o000000o.O000000o(o000000o2);
        } else {
            o000000o2 = null;
        }
        if (o00000Oo.O00000Oo) {
            if (o000000o2 == null) {
                o000000o2 = new O000000o(o00000Oo.O00000oO.get());
            }
            o000000o.O000000o(o000000o2, o00000Oo.O00000o0, o00000Oo.O00000o);
        }
    }

    public final void O00000Oo(cjy.O000000o o000000o) {
        this.O000oO0.O00000oo.remove(o000000o);
    }

    static final class O00000Oo implements SurfaceHolder.Callback {

        /* renamed from: O000000o  reason: collision with root package name */
        SurfaceHolder f5202O000000o;
        boolean O00000Oo;
        int O00000o;
        int O00000o0;
        WeakReference<GlSurfaceRenderView> O00000oO;
        Map<cjy.O000000o, Object> O00000oo = new ConcurrentHashMap();
        private int O0000O0o;

        O00000Oo(GlSurfaceRenderView glSurfaceRenderView) {
            this.O00000oO = new WeakReference<>(glSurfaceRenderView);
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            this.f5202O000000o = surfaceHolder;
            this.O00000Oo = false;
            this.O0000O0o = 0;
            this.O00000o0 = 0;
            this.O00000o = 0;
            O000000o o000000o = new O000000o(this.O00000oO.get());
            for (cjy.O000000o O000000o2 : this.O00000oo.keySet()) {
                O000000o2.O000000o(o000000o);
            }
            cki.O00000o("GlSurfaceRenderView", "surfaceCreated");
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.O00000Oo = false;
            this.O0000O0o = 0;
            this.O00000o0 = 0;
            this.O00000o = 0;
            O000000o o000000o = new O000000o(this.O00000oO.get());
            for (cjy.O000000o O00000Oo2 : this.O00000oo.keySet()) {
                O00000Oo2.O00000Oo(o000000o);
            }
            cki.O00000o("GlSurfaceRenderView", "surfaceDestroyed");
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            this.O00000Oo = true;
            this.O0000O0o = i;
            this.O00000o0 = i2;
            this.O00000o = i3;
            cki.O00000o("GlSurfaceRenderView", "surfaceChanged:" + this.O00000o0 + ":" + this.O00000o);
            O000000o o000000o = new O000000o(this.O00000oO.get());
            for (cjy.O000000o O000000o2 : this.O00000oo.keySet()) {
                O000000o2.O000000o(o000000o, i2, i3);
            }
        }
    }
}
