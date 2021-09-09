package com.xiaomi.smarthome.fastvideo;

import _m_j.ckh;
import _m_j.cki;
import _m_j.ckj;
import _m_j.frx;
import _m_j.fry;
import _m_j.fsa;
import _m_j.fsb;
import _m_j.fsc;
import _m_j.fsd;
import _m_j.fse;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import com.mijia.generalplayer.gl.VideoGlSurfaceViewBase;
import com.xiaomi.smarthome.camera.VideoFrame;
import com.xiaomi.smarthome.fastvideo.decoder.MediaCodecUtil;
import java.util.concurrent.LinkedBlockingQueue;

public class VideoGlSurfaceView extends VideoGlSurfaceViewBase {
    private static int O000o0;
    protected fsa O000o00;
    public LinkedBlockingQueue<VideoFrame> O000o000 = new LinkedBlockingQueue<>(45);
    private boolean O000o00O;
    private int O000o00o;
    private fry O000o0O = new fry();
    private boolean O000o0O0 = true;

    public VideoGlSurfaceView(Context context) {
        super(context);
        O0000Oo0();
    }

    private void O000000o(Context context, AttributeSet attributeSet, boolean z, int i) {
        cki.O00000o("PhotoView", "attrs == null");
        this.O000o00O = z;
        this.O000o00o = i;
        frx.O000000o O000000o2 = frx.O000000o(new MediaCodecUtil.CodecKey(this.O000o00o, 1920, 1080));
        if (ckh.O00000oO) {
            cki.O00000o("PhotoView", "force soft decoder");
            this.O000o00 = new fsd(this, this.O000o00o, false);
        } else if (Build.VERSION.SDK_INT >= 21) {
            if (this.O000OOoo || !fse.O0000OoO()) {
                this.O000o00 = new fsd(this, this.O000o00o, O000000o2 != null && this.O000o00O);
            } else {
                this.O000o00 = new fse(this, O000000o2);
            }
        } else if (!this.O000o00O || O000000o2 == null) {
            this.O000o00 = new fsb(this, this.O000o00o);
            setRenderMode(0);
        } else {
            this.O000o00 = new fsc(this, O000000o2);
            setRenderMode(0);
        }
        cki.O00000o0("PhotoView", "init:%s", this.O000o00.getClass().getName());
        O0000Oo0();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.fastvideo.VideoGlSurfaceView.O000000o(android.content.Context, android.util.AttributeSet, boolean, int):void
     arg types: [android.content.Context, ?[OBJECT, ARRAY], int, int]
     candidates:
      com.mijia.generalplayer.gl.PhotoView.O000000o(float, float, float, boolean):void
      com.xiaomi.smarthome.fastvideo.VideoGlSurfaceView.O000000o(android.content.Context, android.util.AttributeSet, boolean, int):void */
    public VideoGlSurfaceView(Context context, boolean z, int i) {
        super(context, null);
        O000000o(context, (AttributeSet) null, true, 2);
    }

    public VideoGlSurfaceView(Context context, boolean z, int i, boolean z2) {
        super(context, z2, null);
        O000000o(context, (AttributeSet) null, z, i);
    }

    public VideoGlSurfaceView(Context context, boolean z, int i, boolean z2, byte b) {
        super(context, false, null);
        this.O000OOoo = true;
        O000000o(context, (AttributeSet) null, z, i);
    }

    private void O0000Oo0() {
        if (O000o0 != 0) {
            setZOrderOnTop(false);
            setZOrderMediaOverlay(true);
        } else {
            setZOrderOnTop(false);
            setZOrderMediaOverlay(false);
        }
        O000o0++;
    }

    public LinkedBlockingQueue<VideoFrame> getAVFrameQueue() {
        return this.O000o000;
    }

    public final void O000000o(final fsa fsa) {
        if (fsa != this.O000o00) {
            O000000o(new Runnable() {
                /* class com.xiaomi.smarthome.fastvideo.VideoGlSurfaceView.AnonymousClass1 */

                public final void run() {
                    if (VideoGlSurfaceView.this.O000o00 != null) {
                        VideoGlSurfaceView.this.O000o00.O00000oo();
                    }
                    VideoGlSurfaceView videoGlSurfaceView = VideoGlSurfaceView.this;
                    videoGlSurfaceView.O000o00 = fsa;
                    if (videoGlSurfaceView.O000o000 != null) {
                        VideoGlSurfaceView.this.O000o000.clear();
                    }
                    if (VideoGlSurfaceView.this.O000o00 != null) {
                        VideoGlSurfaceView.this.O000o00.O00000oO();
                    }
                }
            });
        }
    }

    public final void O00000Oo() {
        super.O00000Oo();
        cki.O00000o0("PhotoView", "initial firstIn %b", Boolean.valueOf(this.O000o0O0));
        if (this.O000o0O0) {
            this.O000o0O0 = false;
        } else {
            O00000oO();
        }
        fsa fsa = this.O000o00;
        if (fsa != null) {
            fsa.O00000oO();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a6, code lost:
        return;
     */
    public final synchronized void O000000o(VideoFrame videoFrame) {
        ckj O000000o2 = ckj.O000000o();
        O000000o2.O000000o(this, "FIRST_RENDER:drawVideoFrame,iFrame" + videoFrame.isIFrame + "live:" + videoFrame.isReal + ",size:" + this.O000o000.size());
        if (!this.O0000O0o) {
            cki.O0000O0o("PhotoView", "not isInitial");
        }
        if (videoFrame.isIFrame || !this.O0000Oo) {
            try {
                fry fry = this.O000o0O;
                fry.O000000o("PhotoView_drawVideoFrame size:" + this.O000o000.size());
                this.O000o0O.f17039O000000o = System.currentTimeMillis();
                if (this.O000o000.size() > 30) {
                    if (!this.O0000O0o) {
                        cki.O0000O0o("PhotoView", "clearFrames for too much before start");
                        this.O000o000.clear();
                    }
                    this.O0000Oo = true;
                } else {
                    this.O0000Oo = false;
                }
                this.O000o000.put(videoFrame);
                ckj.O000000o().O000000o(this, "FIRST_RENDER:drawVideoFrame put");
                if (!O0000O0o()) {
                    requestRender();
                }
            } catch (InterruptedException e) {
                cki.O00000oO("PhotoView", "drawVideoFrame InterruptedException:" + e.getMessage());
                O00000oO();
            }
        } else {
            cki.O00000oO("PhotoView", "drop frames except IFrame");
        }
    }

    public final void O00000o() {
        super.O00000o();
        fsa fsa = this.O000o00;
        if (fsa != null) {
            fsa.O0000O0o();
        }
    }

    public final void O00000o0() {
        super.O00000o0();
        this.O000o000.clear();
        fsa fsa = this.O000o00;
        if (fsa != null) {
            fsa.O00000oo();
        }
    }

    public int getVideoWidth() {
        fsa fsa = this.O000o00;
        if (fsa != null) {
            return fsa.O0000OOo();
        }
        return 0;
    }

    public int getVideoHeight() {
        fsa fsa = this.O000o00;
        if (fsa != null) {
            return fsa.O0000Oo0();
        }
        return 0;
    }

    public final boolean O0000O0o() {
        fsa fsa = this.O000o00;
        if (fsa == null) {
            return false;
        }
        if (fsa instanceof fsd) {
            return ((fsd) fsa).O0000OoO();
        }
        return fsa instanceof fsc;
    }

    public final void O00000oO() {
        this.O000o000.clear();
        cki.O00000o("PhotoView", "mAVFrameQueue clearQueue");
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        O000o0--;
    }

    public void setFps(int i) {
        fsa fsa = this.O000o00;
        if (fsa != null) {
            fsa.O00000oO = i;
        }
    }

    public final void O0000OOo() {
        O00000oO();
        fsa fsa = this.O000o00;
        if (fsa != null) {
            fsa.O0000Oo();
        }
    }
}
