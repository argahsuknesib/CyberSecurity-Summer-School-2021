package _m_j;

import android.content.Context;
import android.widget.FrameLayout;
import com.xiaomi.smarthome.camera.VideoFrame;
import com.xiaomi.smarthome.camera.XmMp4Player;
import com.xiaomi.smarthome.fastvideo.VideoGlSurfaceView;

public final class fsf extends cjx {
    private XmMp4Player O00000Oo;
    private FrameLayout O00000o;
    private VideoGlSurfaceView O00000o0;

    public fsf(Context context, FrameLayout frameLayout) {
        this.O00000o = frameLayout;
        this.O00000o0 = new VideoGlSurfaceView(context, true, 2);
        frameLayout.addView(this.O00000o0, -1, -1);
        O000000o(this.O00000o0);
    }

    public fsf(Context context, FrameLayout frameLayout, boolean z, int i) {
        this.O00000o = frameLayout;
        this.O00000o0 = new VideoGlSurfaceView(context, z, i, true, (byte) 0);
        frameLayout.addView(this.O00000o0, -1, -1);
        O000000o(this.O00000o0);
    }

    public final void drawVideoFrame(VideoFrame videoFrame) {
        VideoGlSurfaceView videoGlSurfaceView = this.O00000o0;
        if (videoGlSurfaceView != null) {
            videoGlSurfaceView.O000000o(videoFrame);
        }
    }

    public final void setDistort(float f, float f2) {
        VideoGlSurfaceView videoGlSurfaceView = this.O00000o0;
        if (videoGlSurfaceView != null) {
            videoGlSurfaceView.O00000o(f, f2);
        }
    }

    public final void setDistort(int i, int i2) {
        VideoGlSurfaceView videoGlSurfaceView = this.O00000o0;
        if (videoGlSurfaceView != null) {
            videoGlSurfaceView.O00000Oo(i, i2);
        }
    }

    public final void setDistort(float f, float f2, float f3) {
        VideoGlSurfaceView videoGlSurfaceView = this.O00000o0;
        if (videoGlSurfaceView != null) {
            videoGlSurfaceView.O00000o0(f, f2);
        }
    }

    public final void release() {
        super.release();
        FrameLayout frameLayout = this.O00000o;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
    }

    public final void releaseOnlySelf() {
        super.releaseOnlySelf();
        FrameLayout frameLayout = this.O00000o;
        if (frameLayout != null) {
            frameLayout.removeView(this.O00000o0);
        }
    }

    public final boolean isGPUDecoder() {
        VideoGlSurfaceView videoGlSurfaceView = this.O00000o0;
        return videoGlSurfaceView != null && videoGlSurfaceView.O0000O0o();
    }

    public final void addMp4Player(XmMp4Player xmMp4Player) {
        this.O00000Oo = xmMp4Player;
    }

    public final XmMp4Player getMp4Player() {
        return this.O00000Oo;
    }

    public final boolean isBufferFull() {
        VideoGlSurfaceView videoGlSurfaceView = this.O00000o0;
        return videoGlSurfaceView != null && videoGlSurfaceView.O000o000.remainingCapacity() == 0;
    }

    public final void setDid(String str) {
        VideoGlSurfaceView videoGlSurfaceView = this.O00000o0;
        if (videoGlSurfaceView != null) {
            videoGlSurfaceView.setDid(str);
        }
    }

    public final String getDid() {
        VideoGlSurfaceView videoGlSurfaceView = this.O00000o0;
        return videoGlSurfaceView != null ? videoGlSurfaceView.getDid() : "";
    }

    public final void setFps(int i) {
        VideoGlSurfaceView videoGlSurfaceView = this.O00000o0;
        if (videoGlSurfaceView != null) {
            videoGlSurfaceView.setFps(i);
        }
    }

    public final void setNeedIFrame() {
        VideoGlSurfaceView videoGlSurfaceView = this.O00000o0;
        if (videoGlSurfaceView != null) {
            videoGlSurfaceView.O0000OOo();
        }
    }
}
