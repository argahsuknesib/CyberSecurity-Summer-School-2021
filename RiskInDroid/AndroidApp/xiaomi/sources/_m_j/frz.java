package _m_j;

import com.xiaomi.smarthome.camera.VideoFrame;
import com.xiaomi.smarthome.mjplayer.NativeDecode;
import java.util.concurrent.LinkedBlockingQueue;

public final class frz {

    /* renamed from: O000000o  reason: collision with root package name */
    protected LinkedBlockingQueue<VideoFrame> f17040O000000o = new LinkedBlockingQueue<>(45);
    protected boolean O00000Oo;
    public O00000Oo O00000o;
    public boolean O00000o0;
    public O000000o O00000oO;
    private fry O00000oo = new fry();

    public interface O000000o {
        void onVideoData(byte[] bArr, int i, int i2);
    }

    public final synchronized void O000000o(VideoFrame videoFrame) {
        ckj.O000000o().O000000o(this, "FIRST_RENDER:drawVideoFrame");
        if (this.O00000o0) {
            if (videoFrame.isIFrame || !this.O00000Oo) {
                try {
                    fry fry = this.O00000oo;
                    fry.O000000o("ExternalVideoDecoder_drawVideoFrame size:" + this.f17040O000000o.size());
                    this.O00000oo.f17039O000000o = System.currentTimeMillis();
                    if (this.f17040O000000o.size() > 30) {
                        this.O00000Oo = true;
                    } else {
                        this.O00000Oo = false;
                    }
                    this.f17040O000000o.put(videoFrame);
                    ckj.O000000o().O000000o(this, "FIRST_RENDER:drawVideoFrame put");
                } catch (InterruptedException e) {
                    cki.O00000oO("ExternalVideoDecoder", "drawVideoFrame InterruptedException:" + e.getMessage());
                    this.f17040O000000o.clear();
                }
            } else {
                cki.O00000oO("ExternalVideoDecoder", "drop frames except IFrame");
            }
        }
    }

    public final synchronized VideoFrame O000000o() {
        VideoFrame poll;
        LinkedBlockingQueue<VideoFrame> linkedBlockingQueue = this.f17040O000000o;
        int size = linkedBlockingQueue.size();
        poll = this.f17040O000000o.poll();
        if (size == 45) {
            while (true) {
                if (poll != null && poll.isIFrame) {
                    break;
                }
                poll = linkedBlockingQueue.poll();
            }
        }
        return poll;
    }

    public class O00000Oo extends fsg {
        private long O00000Oo;
        private int O00000o0 = 2;

        public O00000Oo(String str) {
            super(str);
        }

        /* access modifiers changed from: protected */
        public final int doRepeatWork() throws InterruptedException {
            if (!this.mIsRunning) {
                return 0;
            }
            if (this.O00000Oo == 0) {
                boolean z = ckh.O0000Oo;
                cki.O00000o0("ExternalVideoDecoder", "initNativeDecode %d,%d:%d", Integer.valueOf(this.O00000o0), 640, 360);
                this.O00000Oo = NativeDecode.init(z, null, null, null, this.O00000o0, 640, 360, false);
            }
            VideoFrame O000000o2 = frz.this.O000000o();
            if (O000000o2 == null || O000000o2.data == null) {
                cki.O00000Oo("ExternalVideoDecoder", "frame == null || frame.data == null");
                return 0;
            } else if (O000000o2.width < 0 || O000000o2.height < 0) {
                cki.O00000o("ExternalVideoDecoder", "frame.width < 0 || frame.height < 0");
                return 0;
            } else {
                byte[] decodeYuv = NativeDecode.decodeYuv(this.O00000Oo, O000000o2.data, O000000o2.timeStamp * 1000);
                if (frz.this.O00000oO != null) {
                    frz.this.O00000oO.onVideoData(decodeYuv, O000000o2.width, O000000o2.height);
                }
                return 0;
            }
        }

        /* access modifiers changed from: protected */
        public final void doInitial() {
            frz.this.O000000o();
        }

        /* access modifiers changed from: protected */
        public final void doRelease() {
            NativeDecode.release(this.O00000Oo);
            this.O00000Oo = 0;
        }
    }
}
