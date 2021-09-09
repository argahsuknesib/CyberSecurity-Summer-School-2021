package _m_j;

import android.opengl.GLES20;
import com.xiaomi.smarthome.camera.VideoFrame;
import com.xiaomi.smarthome.fastvideo.VideoGlSurfaceView;
import com.xiaomi.smarthome.fastvideo.YUVFilter;
import com.xiaomi.smarthome.fastvideo.decoder.H264Decoder;

public final class fsb extends fsa {
    H264Decoder O0000O0o;
    private YUVFilter O0000OOo;
    private int O0000Oo;
    private cju O0000Oo0;
    private int O0000OoO;
    private int[] O0000Ooo;
    private boolean O0000o0 = false;
    private long O0000o00 = 0;

    public fsb(VideoGlSurfaceView videoGlSurfaceView, int i) {
        super(videoGlSurfaceView);
        this.O00000oo = i;
    }

    public final void O00000oO() {
        super.O00000oO();
        this.O0000OOo = new YUVFilter(O000000o().getContext());
        this.O0000OOo.O00000o();
        this.O0000Ooo = new int[3];
        int[] iArr = this.O0000Ooo;
        GLES20.glGenTextures(iArr.length, iArr, 0);
        this.O0000OOo.O00000o = this.O0000Ooo;
    }

    public final synchronized void O0000O0o() {
        super.O0000O0o();
        if (!O00000o()) {
            cki.O00000o("VideoFFMPEG", "!isInitialed()");
            return;
        }
        VideoFrame O00000o0 = O00000o0();
        if (O00000o0 != null) {
            if (O00000o0.data != null) {
                if (O00000o0.width >= 0) {
                    if (O00000o0.height >= 0) {
                        if (this.O0000O0o != null || O00000o0.isIFrame) {
                            if (!(this.O0000O0o != null && O00000o0.width == this.O0000Oo && O00000o0.height == this.O0000OoO && this.O00000oo == O00000o0.videoType)) {
                                this.O0000Oo = O00000o0.width;
                                this.O0000OoO = O00000o0.height;
                                this.O00000oo = O00000o0.videoType;
                                if (this.O0000O0o != null) {
                                    this.O0000O0o.release();
                                }
                                this.O0000O0o = new H264Decoder(this.O00000oo);
                            }
                            if (this.O0000o0) {
                                if (O00000o0.isIFrame) {
                                    this.O0000o0 = false;
                                } else {
                                    cki.O00000o("VideoFFMPEG", "mNeedIFrame true");
                                    return;
                                }
                            }
                            if (O00000o0.num - this.O0000o00 <= 5 || O00000o0.isIFrame) {
                                this.O0000o00 = O00000o0.num;
                                ckj.O000000o().O000000o(this, "FIRST_RENDER:decode start");
                                if (this.O0000O0o.decode(O00000o0.data, O00000o0.data.length, O00000o0.timeStamp)) {
                                    if (this.O0000O0o.toTexture(this.O0000Ooo[0], this.O0000Ooo[1], this.O0000Ooo[2]) < 0) {
                                        cki.O00000o("VideoFFMPEG", "toTexture failed");
                                        return;
                                    }
                                    this.f17046O000000o = this.O0000O0o.getWidth();
                                    this.O00000Oo = this.O0000O0o.getHeight();
                                    if (this.O0000Oo0 == null) {
                                        this.O0000Oo0 = cju.O000000o(this.O0000O0o.getWidth(), this.O0000O0o.getHeight());
                                    } else {
                                        this.O0000Oo0.O00000Oo(this.O0000O0o.getWidth(), this.O0000O0o.getHeight());
                                    }
                                    try {
                                        this.O0000OOo.O000000o((cju) null, this.O0000Oo0);
                                    } catch (Exception e) {
                                        this.O0000Oo0 = null;
                                        cki.O00000o("VideoFFMPEG", "Exception:" + e.getLocalizedMessage());
                                    }
                                    if (this.O0000Oo0 != null) {
                                        O000000o(this.O0000Oo0);
                                    } else {
                                        cki.O00000o("VideoFFMPEG", "mPhoto == null");
                                    }
                                }
                                O00000Oo();
                                ckj.O000000o().O000000o(this, "FIRST_RENDER:decode done");
                                return;
                            }
                            this.O0000o00 = O00000o0.num;
                            this.O0000o0 = true;
                            cki.O00000o("VideoFFMPEG", "mNeedIFrame true 2");
                            return;
                        }
                        cki.O00000o("VideoFFMPEG", "videoDecoder == null && !frame.isIFrame");
                        return;
                    }
                }
                cki.O00000o("VideoFFMPEG", "frame.width < 0 || frame.height < 0");
                return;
            }
        }
        cki.O00000Oo("VideoFFMPEG", "frame == null || frame.data == null");
    }

    public final void O00000oo() {
        super.O00000oo();
        H264Decoder h264Decoder = this.O0000O0o;
        if (h264Decoder != null) {
            h264Decoder.release();
            this.O0000O0o = null;
        }
        YUVFilter yUVFilter = this.O0000OOo;
        if (yUVFilter != null) {
            yUVFilter.O00000oO();
            this.O0000OOo = null;
            int[] iArr = this.O0000Ooo;
            if (iArr != null) {
                GLES20.glDeleteTextures(iArr.length, iArr, 0);
            }
        }
        cju cju = this.O0000Oo0;
        if (cju != null) {
            cju.O000000o();
            this.O0000Oo0 = null;
        }
    }
}
