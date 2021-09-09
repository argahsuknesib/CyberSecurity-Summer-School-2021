package _m_j;

import _m_j.frx;
import android.content.Context;
import android.opengl.GLES20;
import android.util.Log;
import com.xiaomi.smarthome.camera.VideoFrame;
import com.xiaomi.smarthome.fastvideo.VideoGlSurfaceView;
import com.xiaomi.smarthome.fastvideo.YUVFilter;
import com.xiaomi.smarthome.fastvideo.decoder.MediaCodecUtil;
import com.xiaomi.smarthome.mjplayer.NativeDecode;
import java.io.File;

public final class fse extends fsa {
    public volatile long O0000O0o;
    frx.O000000o O0000OOo;
    private cju O0000Oo;
    private YUVFilter O0000Oo0;
    private int[] O0000OoO;
    private volatile O000000o O0000Ooo;
    private String O0000o0;
    private String O0000o00;
    private boolean O0000o0O;

    public fse(VideoGlSurfaceView videoGlSurfaceView, frx.O000000o o000000o) {
        super(videoGlSurfaceView);
        this.O00000oo = o000000o.O00000o0;
        Context context = videoGlSurfaceView.getContext();
        this.O0000o00 = context.getApplicationInfo().nativeLibraryDir;
        this.O0000o0 = context.getApplicationInfo().dataDir + File.separator + "vespcn_int8.dlc";
        if (!ckn.O00000Oo(this.O0000o0)) {
            ckn.O000000o(context, "vespcn_int8.dlc", this.O0000o0);
        }
    }

    public static boolean O0000OoO() {
        if (ckh.O0000OOo == ckh.O00000o0) {
            return false;
        }
        if (ckh.O0000OOo == ckh.f13966O000000o && !ckh.O0000Oo0) {
            return false;
        }
        try {
            System.loadLibrary("super_resolution");
            return true;
        } catch (Throwable th) {
            Log.e("VideoDecoderYuv", "can not load resolution" + th.toString());
            return false;
        }
    }

    public final void O00000oO() {
        super.O00000oO();
        this.O0000Oo0 = new YUVFilter(O000000o().getContext());
        this.O0000Oo0.O00000o();
        this.O0000OoO = new int[3];
        int[] iArr = this.O0000OoO;
        GLES20.glGenTextures(iArr.length, iArr, 0);
        this.O0000Oo0.O00000o = this.O0000OoO;
        this.O0000Ooo = new O000000o();
        this.O0000Ooo.start();
    }

    public final void O000000o(int i, int i2) {
        boolean z = ckh.O0000Oo;
        this.O0000OOo = frx.O000000o(new MediaCodecUtil.CodecKey(this.O00000oo, i, i2));
        this.O0000O0o = NativeDecode.init(z, null, this.O0000OOo.f17038O000000o, this.O0000OOo.O000000o(), this.O00000oo, i, i2, false);
        NativeDecode.setSuperResolutionPath(this.O0000O0o, ckn.O00000Oo(this.O0000o0), this.O0000o0, this.O0000o00);
    }

    public final void O0000O0o() {
        int i;
        int i2;
        super.O0000O0o();
        if (this.O0000Ooo == null) {
            cki.O00000o("VideoDecoderYuv", "mVideoDecodeThread is null");
            return;
        }
        int O000000o2 = this.O0000Ooo.O000000o();
        int O00000Oo = this.O0000Ooo.O00000Oo();
        if (O000000o2 == 0 || O00000Oo == 0) {
            cki.O00000o("VideoDecoderYuv", "drawFrame videoWith:" + O000000o2 + " videoHeight:" + O00000Oo);
        } else if (this.O0000O0o == 0) {
            cki.O00000o("VideoDecoderYuv", "mNativeObj is null");
        } else {
            VideoGlSurfaceView videoGlSurfaceView = this.O00000o0;
            boolean z = (videoGlSurfaceView.O0000oO0 > 0 && videoGlSurfaceView.O00O0Oo && (videoGlSurfaceView.O00000o > videoGlSurfaceView.getMaxScale() ? 1 : (videoGlSurfaceView.O00000o == videoGlSurfaceView.getMaxScale() ? 0 : -1)) >= 0 && !videoGlSurfaceView.O00000oo()) && O000000o2 == 1920;
            if (z) {
                int round = Math.round(O000000o().getRatioOffsetX() * ((float) O000000o2));
                int i3 = O000000o2 - 640;
                if (this.O00000o0.getOffsetX() >= 0.0f) {
                    i2 = Math.min(round, i3);
                } else {
                    i2 = Math.min(i3 - round, i3);
                }
                int round2 = Math.round(O000000o().getRatioOffsetY() * ((float) O00000Oo));
                i = this.O00000o0.getFixOffsetY() >= 0.0f ? Math.min(720 - round2, 720) : Math.min(round2, 720);
            } else {
                i2 = 0;
                i = 0;
            }
            cki.O00000o("VideoDecoderYuv", "drawFrame toTexture x:" + i2 + " y:" + i + ":" + this.O0000o0O + ":" + z);
            long j = this.O0000O0o;
            int[] iArr = this.O0000OoO;
            int[] texture = NativeDecode.toTexture(j, iArr[0], iArr[1], iArr[2], z, i2, i);
            if (texture == null) {
                cki.O00000Oo("VideoDecoderYuv", "toTexture failed");
                return;
            }
            if (texture[0] != 1) {
                this.O0000o0O = false;
            } else if (z) {
                this.O0000o0O = true;
            } else {
                this.O0000o0O = false;
            }
            O000000o().setInSuperResolution(this.O0000o0O);
            int i4 = texture[1];
            int i5 = texture[2];
            if (i4 == 0 || i5 == 0) {
                cki.O00000o("VideoDecoderYuv", "drawFrame videoWith:" + i4 + " videoHeight:" + i5);
                return;
            }
            this.O00000o0.O000000o(i4, i5);
            cju cju = this.O0000Oo;
            if (cju == null) {
                this.O0000Oo = cju.O000000o(i4, i5);
            } else {
                cju.O00000Oo(i4, i5);
            }
            try {
                this.O0000Oo0.O000000o((cju) null, this.O0000Oo);
            } catch (Exception e) {
                this.O0000Oo = null;
                cki.O00000oO("VideoDecoderYuv", "Exception:" + e.getLocalizedMessage());
            }
            cju cju2 = this.O0000Oo;
            if (cju2 == null) {
                cki.O00000o("VideoDecoderYuv", "mPhoto == null");
            } else if (this.O0000o0O) {
                this.O00000o0.setPhoto(this.O0000Oo);
            } else {
                O000000o(cju2);
            }
            ckj.O000000o().O000000o(this, "FIRST_RENDER:drawFrame");
        }
    }

    public final void O00000oo() {
        super.O00000oo();
        cki.O00000o("VideoDecoderYuv", "release");
        if (this.O0000Ooo != null) {
            this.O0000Ooo.stopThreadAsyn();
            this.O0000Ooo = null;
        }
        YUVFilter yUVFilter = this.O0000Oo0;
        if (yUVFilter != null) {
            yUVFilter.O00000oO();
            this.O0000Oo0 = null;
            int[] iArr = this.O0000OoO;
            if (iArr != null) {
                GLES20.glDeleteTextures(iArr.length, iArr, 0);
            }
        }
        cju cju = this.O0000Oo;
        if (cju != null) {
            cju.O000000o();
            this.O0000Oo = null;
        }
    }

    class O000000o extends fsg {

        /* renamed from: O000000o  reason: collision with root package name */
        int f17051O000000o;
        int O00000Oo;
        private boolean O00000o = false;

        O000000o() {
            super("VideoDecodeThread");
        }

        public final synchronized int O000000o() {
            return fse.this.f17046O000000o;
        }

        public final synchronized int O00000Oo() {
            return fse.this.O00000Oo;
        }

        /* access modifiers changed from: protected */
        public final int doRepeatWork() throws InterruptedException {
            if (!this.mIsRunning) {
                return 0;
            }
            VideoFrame O000000o2 = fse.this.O000000o(!this.O00000o);
            ckj.O000000o().O000000o(this, "FIRST_RENDER:get video frame");
            if (!this.mIsRunning) {
                cki.O00000o("VideoDecoderYuv", "!mIsRunning");
                return 0;
            } else if (O000000o2 == null || O000000o2.data == null) {
                cki.O00000o("VideoDecoderYuv", "frame == null || frame.data == null");
                return 0;
            } else if (O000000o2.width < 0 || O000000o2.height < 0) {
                cki.O00000o("VideoDecoderYuv", "frame.width < 0 || frame.height < 0");
                return 0;
            } else if (this.f17051O000000o != O000000o2.width && !O000000o2.isIFrame) {
                cki.O00000o("VideoDecoderYuv", "change size ignore width" + O000000o2.width);
                return 0;
            } else if (this.O00000o || O000000o2.isIFrame) {
                if (!this.O00000o || O000000o2.videoType != fse.this.O00000oo) {
                    if (!this.O00000o || fse.this.O0000O0o == 0) {
                        cki.O00000o("VideoDecoderYuv", "init width:" + O000000o2.width + ":" + O000000o2.height);
                        this.O00000o = true;
                    } else {
                        cki.O00000o("VideoDecoderYuv", "change video type to:" + O000000o2.videoType + " video size:" + O000000o2.width + ":" + O000000o2.height);
                        fse fse = fse.this;
                        fse.O0000O0o = 0;
                        NativeDecode.release(fse.O0000O0o);
                    }
                    fse.this.O00000oo = O000000o2.videoType;
                    fse.this.O000000o(O000000o2.width, O000000o2.height);
                }
                ckj.O000000o().O000000o(this, "FIRST_RENDER:decode start");
                int[] decode = NativeDecode.decode(fse.this.O0000O0o, O000000o2.data, O000000o2.timeStamp * 1000);
                this.f17051O000000o = O000000o2.width;
                this.O00000Oo = O000000o2.height;
                if (decode == null || decode[0] < 0) {
                    cki.O00000o("VideoDecoderYuv", "decode error");
                } else if (decode[1] != O000000o2.width) {
                    fse fse2 = fse.this;
                    fse2.f17046O000000o = decode[1];
                    fse2.O00000Oo = decode[2];
                } else {
                    fse.this.f17046O000000o = O000000o2.width;
                    fse.this.O00000Oo = O000000o2.height;
                }
                ckj.O000000o().O000000o(this, "FIRST_RENDER:decode done");
                return 0;
            } else {
                cki.O00000o("VideoDecoderYuv", "videoDecoder == null && !frame.isIFrame");
                return 0;
            }
        }

        /* access modifiers changed from: protected */
        public final void doInitial() {
            cki.O00000o("VideoDecoderYuv", "doInitial");
            this.f17051O000000o = 0;
            this.O00000Oo = 0;
        }

        /* access modifiers changed from: protected */
        public final void doRelease() {
            this.O00000o = false;
            cki.O00000o("VideoDecoderYuv", "VideoDecodeThread stop");
            NativeDecode.release(fse.this.O0000O0o);
            fse.this.O0000O0o = 0;
        }
    }
}
