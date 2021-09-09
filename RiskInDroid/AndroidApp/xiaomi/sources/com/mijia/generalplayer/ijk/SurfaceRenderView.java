package com.mijia.generalplayer.ijk;

import _m_j.cjy;
import _m_j.cjz;
import _m_j.cki;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.ISurfaceTextureHolder;

public class SurfaceRenderView extends SurfaceView implements cjy {

    /* renamed from: O000000o  reason: collision with root package name */
    private cjz f5212O000000o;
    private O00000Oo O00000Oo;

    public final boolean O0000O0o() {
        return true;
    }

    public View getView() {
        return this;
    }

    public SurfaceRenderView(Context context) {
        super(context);
        O000000o();
    }

    public SurfaceRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public SurfaceRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    private void O000000o() {
        this.f5212O000000o = new cjz(this);
        this.O00000Oo = new O00000Oo(this);
        getHolder().addCallback(this.O00000Oo);
        getHolder().setType(0);
    }

    public final void O00000o0(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.f5212O000000o.O000000o(i, i2);
            getHolder().setFixedSize(i, i2);
            requestLayout();
        }
    }

    public final void O00000o(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.f5212O000000o.O00000Oo(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        cki.O00000oO("", "SurfaceView doesn't support rotation (" + i + ")!\n");
    }

    public void setAspectRatio(int i) {
        this.f5212O000000o.O00000o = i;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.f5212O000000o.O00000o0(i, i2);
        setMeasuredDimension(this.f5212O000000o.O00000Oo, this.f5212O000000o.O00000o0);
    }

    static final class O000000o implements cjy.O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        private SurfaceRenderView f5213O000000o;
        private SurfaceHolder O00000Oo;

        public O000000o(SurfaceRenderView surfaceRenderView, SurfaceHolder surfaceHolder) {
            this.f5213O000000o = surfaceRenderView;
            this.O00000Oo = surfaceHolder;
        }

        public final void O000000o(IMediaPlayer iMediaPlayer) {
            if (iMediaPlayer != null) {
                if (Build.VERSION.SDK_INT >= 16 && (iMediaPlayer instanceof ISurfaceTextureHolder)) {
                    ((ISurfaceTextureHolder) iMediaPlayer).setSurfaceTexture(null);
                }
                iMediaPlayer.setDisplay(this.O00000Oo);
            }
        }

        public final cjy O000000o() {
            return this.f5213O000000o;
        }
    }

    public final void O000000o(cjy.O000000o o000000o) {
        O000000o o000000o2;
        O00000Oo o00000Oo = this.O00000Oo;
        o00000Oo.O00000oo.put(o000000o, o000000o);
        if (o00000Oo.f5214O000000o != null) {
            o000000o2 = new O000000o(o00000Oo.O00000oO.get(), o00000Oo.f5214O000000o);
            o000000o.O000000o(o000000o2);
        } else {
            o000000o2 = null;
        }
        if (o00000Oo.O00000Oo) {
            if (o000000o2 == null) {
                o000000o2 = new O000000o(o00000Oo.O00000oO.get(), o00000Oo.f5214O000000o);
            }
            o000000o.O000000o(o000000o2, o00000Oo.O00000o0, o00000Oo.O00000o);
        }
    }

    public final void O00000Oo(cjy.O000000o o000000o) {
        this.O00000Oo.O00000oo.remove(o000000o);
    }

    static final class O00000Oo implements SurfaceHolder.Callback {

        /* renamed from: O000000o  reason: collision with root package name */
        SurfaceHolder f5214O000000o;
        boolean O00000Oo;
        int O00000o;
        int O00000o0;
        WeakReference<SurfaceRenderView> O00000oO;
        Map<cjy.O000000o, Object> O00000oo = new ConcurrentHashMap();
        private int O0000O0o;

        public O00000Oo(SurfaceRenderView surfaceRenderView) {
            this.O00000oO = new WeakReference<>(surfaceRenderView);
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            this.f5214O000000o = surfaceHolder;
            this.O00000Oo = false;
            this.O0000O0o = 0;
            this.O00000o0 = 0;
            this.O00000o = 0;
            O000000o o000000o = new O000000o(this.O00000oO.get(), this.f5214O000000o);
            for (cjy.O000000o O000000o2 : this.O00000oo.keySet()) {
                O000000o2.O000000o(o000000o);
            }
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.f5214O000000o = null;
            this.O00000Oo = false;
            this.O0000O0o = 0;
            this.O00000o0 = 0;
            this.O00000o = 0;
            O000000o o000000o = new O000000o(this.O00000oO.get(), this.f5214O000000o);
            for (cjy.O000000o O00000Oo2 : this.O00000oo.keySet()) {
                O00000Oo2.O00000Oo(o000000o);
            }
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            this.f5214O000000o = surfaceHolder;
            this.O00000Oo = true;
            this.O0000O0o = i;
            this.O00000o0 = i2;
            this.O00000o = i3;
            O000000o o000000o = new O000000o(this.O00000oO.get(), this.f5214O000000o);
            for (cjy.O000000o O000000o2 : this.O00000oo.keySet()) {
                O000000o2.O000000o(o000000o, i2, i3);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(SurfaceRenderView.class.getName());
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (Build.VERSION.SDK_INT >= 14) {
            accessibilityNodeInfo.setClassName(SurfaceRenderView.class.getName());
        }
    }
}
