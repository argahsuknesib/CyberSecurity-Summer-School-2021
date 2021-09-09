package _m_j;

import com.xiaomi.smarthome.camera.VideoFrame;
import com.xiaomi.smarthome.fastvideo.VideoGlSurfaceView;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class fsa {

    /* renamed from: O000000o  reason: collision with root package name */
    protected volatile int f17046O000000o;
    protected volatile int O00000Oo;
    protected boolean O00000o;
    protected volatile VideoGlSurfaceView O00000o0;
    public int O00000oO = 20;
    protected int O00000oo = 1;
    private fry O0000O0o = new fry();

    public void O0000O0o() {
    }

    public void O0000Oo() {
    }

    public fsa(VideoGlSurfaceView videoGlSurfaceView) {
        this.O00000o0 = videoGlSurfaceView;
    }

    public final VideoGlSurfaceView O000000o() {
        return this.O00000o0;
    }

    public final void O00000Oo() {
        if (this.O00000o0 != null && this.O00000o0.getAVFrameQueue().size() > 0) {
            this.O00000o0.requestRender();
        }
    }

    public final void O000000o(cju cju) {
        if (this.O00000o0 != null) {
            this.O00000o0.setPhoto(this.O00000o0.O000000o(cju));
        }
    }

    public final synchronized VideoFrame O000000o(boolean z) throws InterruptedException {
        int i;
        if (this.O00000o0 != null) {
            VideoFrame take = this.O00000o0.getAVFrameQueue().take();
            ckj.O000000o().O000000o(this, "FIRST_RENDER:takeVideoFrame, iFrame:" + take.isIFrame + ",live:" + take.isReal + ",size:" + this.O00000o0.getAVFrameQueue().size());
            this.O00000o0.O00000Oo(take.distrot);
            if (take.isReal) {
                if (!z) {
                    int size = this.O00000o0.getAVFrameQueue().size();
                    int O000000o2 = this.O0000O0o.O000000o("VideoFrameDecoder_takeVideoFrame size:".concat(String.valueOf(size)));
                    int i2 = 1000 / this.O00000oO;
                    if (size > 25) {
                        i = 0;
                    } else if (size > 15) {
                        i = (i2 - size) - 15;
                    } else {
                        if (size > 10) {
                            size *= 2;
                        }
                        i = i2 - size;
                    }
                    if (O000000o2 < i) {
                        try {
                            Thread.sleep((long) (i - O000000o2));
                        } catch (IllegalArgumentException | InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    this.O0000O0o.f17039O000000o = System.currentTimeMillis();
                    return take;
                }
            }
            ckj.O000000o().O000000o(this, "FIRST_RENDER:takeVideoFrame get");
            this.O0000O0o.f17039O000000o = System.currentTimeMillis();
            return take;
        }
        cki.O00000o("VideoFrameDecoder", "mVideoGlSurfaceView == null");
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        return r2;
     */
    public final synchronized VideoFrame O00000o0() {
        if (this.O00000o0 == null) {
            return null;
        }
        LinkedBlockingQueue<VideoFrame> aVFrameQueue = this.O00000o0.getAVFrameQueue();
        int size = aVFrameQueue.size();
        VideoFrame poll = this.O00000o0.getAVFrameQueue().poll();
        if (size == 45) {
            while (true) {
                if (poll != null && poll.isIFrame) {
                    break;
                }
                poll = aVFrameQueue.poll();
            }
        }
        if (poll != null) {
            this.O00000o0.O00000Oo(poll.distrot);
        }
    }

    public final synchronized void O000000o(int i) {
        cki.O00000o("VideoFrameDecoder", "enableFFMPEGDecoder");
        if (this.O00000o0 != null) {
            this.O00000o0.O000000o(new fsb(this.O00000o0, i));
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean O00000o() {
        return this.O00000o;
    }

    public void O00000oO() {
        this.O00000o = true;
    }

    public void O00000oo() {
        cki.O00000o("VideoFrameDecoder", toString() + "release");
        this.O00000o = false;
    }

    public final int O0000OOo() {
        return this.f17046O000000o;
    }

    public final int O0000Oo0() {
        return this.O00000Oo;
    }
}
