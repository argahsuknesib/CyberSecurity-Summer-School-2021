package com.mijia.generalplayer.ijk;

import _m_j.cjy;
import _m_j.cjz;
import _m_j.cki;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.ISurfaceTextureHolder;
import tv.danmaku.ijk.media.player.ISurfaceTextureHost;

@TargetApi(14)
public class TextureRenderView extends TextureView implements cjy {

    /* renamed from: O000000o  reason: collision with root package name */
    public O00000Oo f5215O000000o;
    private cjz O00000Oo;

    public final boolean O0000O0o() {
        return false;
    }

    public View getView() {
        return this;
    }

    public TextureRenderView(Context context) {
        super(context);
        O000000o();
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    private void O000000o() {
        this.O00000Oo = new cjz(this);
        this.f5215O000000o = new O00000Oo(this);
        setSurfaceTextureListener(this.f5215O000000o);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        O00000Oo o00000Oo = this.f5215O000000o;
        cki.O00000o("TextureRenderView", "willDetachFromWindow()");
        o00000Oo.O00000oo = true;
        super.onDetachedFromWindow();
        O00000Oo o00000Oo2 = this.f5215O000000o;
        cki.O00000o("TextureRenderView", "didDetachFromWindow()");
        o00000Oo2.O0000O0o = true;
    }

    public final void O00000o0(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.O00000Oo.O000000o(i, i2);
            requestLayout();
        }
    }

    public final void O00000o(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.O00000Oo.O00000Oo(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.O00000Oo.f13960O000000o = i;
        setRotation((float) i);
    }

    public void setAspectRatio(int i) {
        this.O00000Oo.O00000o = i;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.O00000Oo.O00000o0(i, i2);
        setMeasuredDimension(this.O00000Oo.O00000Oo, this.O00000Oo.O00000o0);
    }

    public cjy.O00000Oo getSurfaceHolder() {
        return new O000000o(this, this.f5215O000000o.f5217O000000o, this.f5215O000000o);
    }

    static final class O000000o implements cjy.O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        private TextureRenderView f5216O000000o;
        private SurfaceTexture O00000Oo;
        private ISurfaceTextureHost O00000o0;

        public O000000o(TextureRenderView textureRenderView, SurfaceTexture surfaceTexture, ISurfaceTextureHost iSurfaceTextureHost) {
            this.f5216O000000o = textureRenderView;
            this.O00000Oo = surfaceTexture;
            this.O00000o0 = iSurfaceTextureHost;
        }

        @TargetApi(16)
        public final void O000000o(IMediaPlayer iMediaPlayer) {
            Surface surface;
            if (iMediaPlayer != null) {
                if (Build.VERSION.SDK_INT < 16 || !(iMediaPlayer instanceof ISurfaceTextureHolder)) {
                    SurfaceTexture surfaceTexture = this.O00000Oo;
                    if (surfaceTexture == null) {
                        surface = null;
                    } else {
                        surface = new Surface(surfaceTexture);
                    }
                    iMediaPlayer.setSurface(surface);
                    return;
                }
                ISurfaceTextureHolder iSurfaceTextureHolder = (ISurfaceTextureHolder) iMediaPlayer;
                this.f5216O000000o.f5215O000000o.O00000oO = false;
                SurfaceTexture surfaceTexture2 = iSurfaceTextureHolder.getSurfaceTexture();
                if (surfaceTexture2 != null) {
                    this.f5216O000000o.setSurfaceTexture(surfaceTexture2);
                    return;
                }
                iSurfaceTextureHolder.setSurfaceTexture(this.O00000Oo);
                iSurfaceTextureHolder.setSurfaceTextureHost(this.f5216O000000o.f5215O000000o);
            }
        }

        public final cjy O000000o() {
            return this.f5216O000000o;
        }
    }

    public final void O000000o(cjy.O000000o o000000o) {
        O000000o o000000o2;
        O00000Oo o00000Oo = this.f5215O000000o;
        o00000Oo.O0000Oo0.put(o000000o, o000000o);
        if (o00000Oo.f5217O000000o != null) {
            o000000o2 = new O000000o(o00000Oo.O0000OOo.get(), o00000Oo.f5217O000000o, o00000Oo);
            o000000o.O000000o(o000000o2);
        } else {
            o000000o2 = null;
        }
        if (o00000Oo.O00000Oo) {
            if (o000000o2 == null) {
                o000000o2 = new O000000o(o00000Oo.O0000OOo.get(), o00000Oo.f5217O000000o, o00000Oo);
            }
            o000000o.O000000o(o000000o2, o00000Oo.O00000o0, o00000Oo.O00000o);
        }
    }

    public final void O00000Oo(cjy.O000000o o000000o) {
        this.f5215O000000o.O0000Oo0.remove(o000000o);
    }

    static final class O00000Oo implements TextureView.SurfaceTextureListener, ISurfaceTextureHost {

        /* renamed from: O000000o  reason: collision with root package name */
        public SurfaceTexture f5217O000000o;
        boolean O00000Oo;
        int O00000o;
        int O00000o0;
        boolean O00000oO = true;
        boolean O00000oo = false;
        boolean O0000O0o = false;
        WeakReference<TextureRenderView> O0000OOo;
        Map<cjy.O000000o, Object> O0000Oo0 = new ConcurrentHashMap();

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public O00000Oo(TextureRenderView textureRenderView) {
            this.O0000OOo = new WeakReference<>(textureRenderView);
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f5217O000000o = surfaceTexture;
            this.O00000Oo = false;
            this.O00000o0 = 0;
            this.O00000o = 0;
            O000000o o000000o = new O000000o(this.O0000OOo.get(), surfaceTexture, this);
            for (cjy.O000000o O000000o2 : this.O0000Oo0.keySet()) {
                O000000o2.O000000o(o000000o);
            }
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f5217O000000o = surfaceTexture;
            this.O00000Oo = true;
            this.O00000o0 = i;
            this.O00000o = i2;
            O000000o o000000o = new O000000o(this.O0000OOo.get(), surfaceTexture, this);
            for (cjy.O000000o O000000o2 : this.O0000Oo0.keySet()) {
                O000000o2.O000000o(o000000o, i, i2);
            }
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f5217O000000o = surfaceTexture;
            this.O00000Oo = false;
            this.O00000o0 = 0;
            this.O00000o = 0;
            O000000o o000000o = new O000000o(this.O0000OOo.get(), surfaceTexture, this);
            for (cjy.O000000o O00000Oo2 : this.O0000Oo0.keySet()) {
                O00000Oo2.O00000Oo(o000000o);
            }
            cki.O00000o("TextureRenderView", "onSurfaceTextureDestroyed: destroy: " + this.O00000oO);
            return this.O00000oO;
        }

        public final void releaseSurfaceTexture(SurfaceTexture surfaceTexture) {
            if (surfaceTexture == null) {
                cki.O00000o("TextureRenderView", "releaseSurfaceTexture: null");
            } else if (this.O0000O0o) {
                if (surfaceTexture != this.f5217O000000o) {
                    cki.O00000o("TextureRenderView", "releaseSurfaceTexture: didDetachFromWindow(): release different SurfaceTexture");
                    surfaceTexture.release();
                } else if (!this.O00000oO) {
                    cki.O00000o("TextureRenderView", "releaseSurfaceTexture: didDetachFromWindow(): release detached SurfaceTexture");
                    surfaceTexture.release();
                } else {
                    cki.O00000o("TextureRenderView", "releaseSurfaceTexture: didDetachFromWindow(): already released by TextureView");
                }
            } else if (this.O00000oo) {
                if (surfaceTexture != this.f5217O000000o) {
                    cki.O00000o("TextureRenderView", "releaseSurfaceTexture: willDetachFromWindow(): release different SurfaceTexture");
                    surfaceTexture.release();
                } else if (!this.O00000oO) {
                    cki.O00000o("TextureRenderView", "releaseSurfaceTexture: willDetachFromWindow(): re-attach SurfaceTexture to TextureView");
                    this.O00000oO = true;
                } else {
                    cki.O00000o("TextureRenderView", "releaseSurfaceTexture: willDetachFromWindow(): will released by TextureView");
                }
            } else if (surfaceTexture != this.f5217O000000o) {
                cki.O00000o("TextureRenderView", "releaseSurfaceTexture: alive: release different SurfaceTexture");
                surfaceTexture.release();
            } else if (!this.O00000oO) {
                cki.O00000o("TextureRenderView", "releaseSurfaceTexture: alive: re-attach SurfaceTexture to TextureView");
                this.O00000oO = true;
            } else {
                cki.O00000o("TextureRenderView", "releaseSurfaceTexture: alive: will released by TextureView");
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(TextureRenderView.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TextureRenderView.class.getName());
    }
}
