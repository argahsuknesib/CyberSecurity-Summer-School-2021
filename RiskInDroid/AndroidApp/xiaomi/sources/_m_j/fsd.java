package _m_j;

import _m_j.frx;
import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import com.mijia.generalplayer.gl.GlslFilter;
import com.xiaomi.smarthome.camera.VideoFrame;
import com.xiaomi.smarthome.fastvideo.VideoGlSurfaceView;
import com.xiaomi.smarthome.fastvideo.decoder.MediaCodecUtil;
import com.xiaomi.smarthome.mjplayer.NativeDecode;

@TargetApi(21)
public final class fsd extends fsa {
    public volatile Object O0000O0o = new Object();
    int O0000OOo;
    public boolean O0000Oo;
    public volatile boolean O0000Oo0 = false;
    private cju O0000OoO;
    private cju O0000Ooo;
    private float[] O0000o0 = new float[16];
    private GlslFilter O0000o00;
    private volatile O000000o O0000o0O;
    private fry O0000o0o = new fry();

    public final void O00000oO() {
        super.O00000oO();
        this.O0000o00 = new GlslFilter(O000000o().getContext());
        GlslFilter glslFilter = this.O0000o00;
        glslFilter.O00000oO = 36197;
        glslFilter.O00000o();
        this.O0000OOo = cjw.O000000o();
        GLES20.glBindTexture(36197, this.O0000OOo);
        cjw.O000000o("glBindTexture mTextureID");
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        synchronized (this.O0000O0o) {
            this.O0000Oo0 = false;
        }
        cjw.O000000o("surfaceCreated");
        this.O0000o0O = new O000000o();
        this.O0000o0O.start();
    }

    public fsd(VideoGlSurfaceView videoGlSurfaceView, int i, boolean z) {
        super(videoGlSurfaceView);
        this.O00000oo = i;
        this.O0000Oo = z;
    }

    public final void O0000O0o() {
        synchronized (this.O0000O0o) {
            super.O0000O0o();
            try {
                if (this.O0000Oo0) {
                    this.O0000Oo0 = false;
                    if (this.O0000o0O == null) {
                        cki.O00000o("VideoDecoderNative", "mVideoDecodeThread == null");
                        return;
                    }
                    int O000000o2 = this.O0000o0O.O000000o();
                    int O00000Oo = this.O0000o0O.O00000Oo();
                    if (O000000o2 != 0) {
                        if (O00000Oo != 0) {
                            this.O00000o0.O000000o(O000000o2, O00000Oo);
                            if (this.O0000OoO == null) {
                                this.O0000OoO = cju.O000000o(O000000o2, O00000Oo);
                            } else {
                                this.O0000OoO.O00000Oo(O000000o2, O00000Oo);
                            }
                            if (this.O0000Ooo == null) {
                                this.O0000Ooo = new cju(this.O0000OOo, O000000o2, O00000Oo);
                            }
                            O000000o o000000o = this.O0000o0O;
                            float[] fArr = this.O0000o0;
                            if (o000000o.O00000oo != null) {
                                o000000o.O00000oo.updateTexImage();
                                o000000o.O00000oo.getTransformMatrix(fArr);
                            }
                            this.O0000o00.O000000o(this.O0000o0);
                            this.O0000o00.O000000o(this.O0000Ooo, this.O0000OoO);
                            O000000o(this.O0000OoO);
                            ckj.O000000o().O000000o(this, "FIRST_RENDER:drawFrame");
                            this.O0000o0o.O000000o("VideoDecoderNative_render");
                            this.O0000o0o.f17039O000000o = System.currentTimeMillis();
                        }
                    }
                    cki.O00000o("VideoDecoderNative", "videoWith:" + O000000o2 + " videoHeight:" + O00000Oo);
                }
            } catch (Exception e) {
                cki.O00000o("VideoDecoderNative", "drawFrame e:" + e.getLocalizedMessage());
            }
        }
    }

    public final void O00000oo() {
        super.O00000oo();
        if (this.O0000o0O != null) {
            this.O0000o0O.stopThreadAsyn();
            this.O0000o0O = null;
        }
        cjw.O000000o(this.O0000OOo);
        GlslFilter glslFilter = this.O0000o00;
        if (glslFilter != null) {
            glslFilter.O00000oO();
        }
        cju cju = this.O0000OoO;
        if (cju != null) {
            cju.O000000o();
            this.O0000OoO = null;
        }
    }

    class O000000o extends fsg {

        /* renamed from: O000000o  reason: collision with root package name */
        int f17049O000000o;
        int O00000Oo;
        long O00000o;
        volatile boolean O00000o0 = false;
        Surface O00000oO;
        SurfaceTexture O00000oo;
        boolean O0000O0o;
        private fry O0000Oo = new fry();
        private boolean O0000Oo0 = false;
        private long O0000OoO;

        O000000o() {
            super("VideoDecodeThread");
            cki.O00000o("VideoDecoderNative", "VideoDecodeThread start");
        }

        public final synchronized int O000000o() {
            return fsd.this.f17046O000000o;
        }

        public final synchronized int O00000Oo() {
            return fsd.this.O00000Oo;
        }

        private void O000000o(int i, int i2) {
            boolean z = ckh.O0000Oo;
            cki.O00000o0("VideoDecoderNative", "initNativeDecode %d,%d:%d", Integer.valueOf(fsd.this.O00000oo), Integer.valueOf(i), Integer.valueOf(i2));
            this.f17049O000000o = i;
            this.O00000Oo = i2;
            frx.O000000o O000000o2 = frx.O000000o(new MediaCodecUtil.CodecKey(fsd.this.O00000oo, i, i2));
            if (O000000o2 == null) {
                this.O00000o = NativeDecode.init(z, this.O00000oO, null, null, fsd.this.O00000oo, i, i2, false);
            } else {
                this.O00000o = NativeDecode.init(z, this.O00000oO, O000000o2.f17038O000000o, O000000o2.O000000o(), fsd.this.O00000oo, i, i2, fsd.this.O0000Oo);
            }
            if (fsd.this.O00000o0.getDid() != null) {
                NativeDecode.setDid(this.O00000o, fsd.this.O00000o0.getDid());
            }
        }

        /* access modifiers changed from: protected */
        public final int doRepeatWork() throws InterruptedException {
            if (!this.mIsRunning) {
                return 0;
            }
            if (this.O00000o == 0) {
                O000000o(640, 360);
            }
            VideoFrame O000000o2 = fsd.this.O000000o(!this.O0000Oo0);
            ckj O000000o3 = ckj.O000000o();
            O000000o3.O000000o(this, "FIRST_RENDER:get video frame:" + O000000o2.isIFrame + ",num:" + O000000o2.num);
            if (!(this.O0000OoO == 0 || O000000o2.num == this.O0000OoO + 1)) {
                cki.O00000o0("VideoDecoderNative", "wrong num %d:%d", Long.valueOf(O000000o2.num), Long.valueOf(this.O0000OoO));
            }
            this.O0000OoO = O000000o2.num;
            if (!this.mIsRunning) {
                cki.O00000o("VideoDecoderNative", "!mIsRunning");
                return 0;
            } else if (O000000o2 == null || O000000o2.data == null) {
                cki.O00000o("VideoDecoderNative", "frame == null || frame.data == null");
                return 0;
            } else if (this.O00000o0) {
                cki.O00000o("VideoDecoderNative", "mInitialError");
                return 0;
            } else if (!this.O0000O0o || O000000o2.isIFrame) {
                this.O0000O0o = false;
                if (!this.O0000Oo0 && !O000000o2.isIFrame) {
                    cki.O00000o("VideoDecoderNative", "decoder == null && !frame.isIFrame");
                    return 0;
                } else if (O000000o2.width <= 0 || O000000o2.height <= 0) {
                    cki.O00000o("VideoDecoderNative", "frame.width < 0 || frame.height < 0");
                    return 0;
                } else if (this.f17049O000000o == O000000o2.width || O000000o2.isIFrame) {
                    ckj.O000000o().O000000o(this, "FIRST_RENDER:init start");
                    if (!this.O0000Oo0) {
                        cki.O00000o("VideoDecoderNative", "init");
                        this.O0000Oo0 = true;
                    }
                    if (!(O000000o2.videoType == fsd.this.O00000oo && O000000o2.width == this.f17049O000000o && (O000000o2.height == this.O00000Oo || !fsd.this.O0000Oo))) {
                        cki.O00000o("VideoDecoderNative", "change video type to:" + O000000o2.videoType + " video size:" + O000000o2.width + ":" + O000000o2.height);
                        fsd.this.O00000oo = O000000o2.videoType;
                        NativeDecode.release(this.O00000o);
                        O000000o(O000000o2.width, O000000o2.height);
                    }
                    if (fsd.this.f17046O000000o == 0 && fsd.this.O00000Oo == 0) {
                        fsd.this.f17046O000000o = O000000o2.width;
                        fsd.this.O00000Oo = O000000o2.height;
                    }
                    ckj O000000o4 = ckj.O000000o();
                    O000000o4.O000000o(this, "FIRST_RENDER:decode start:" + (O000000o2.timeStamp * 1000));
                    int[] decode = NativeDecode.decode(this.O00000o, O000000o2.data, O000000o2.timeStamp * 1000);
                    if (decode == null || decode[0] < 0) {
                        cki.O00000o("VideoDecoderNative", "decode error");
                        cki.O0000OOo(O000000o2.isReal ? "2000.2.2" : "2000.3.2", "decode error");
                    } else if (decode[1] != O000000o2.width) {
                        fsd fsd = fsd.this;
                        fsd.f17046O000000o = decode[1];
                        fsd.O00000Oo = decode[2];
                    } else {
                        fsd.this.f17046O000000o = O000000o2.width;
                        fsd.this.O00000Oo = O000000o2.height;
                    }
                    ckj.O000000o().O000000o(this, "FIRST_RENDER:decode done");
                    this.O0000Oo.O000000o("VideoDecoderNative_decode");
                    this.O0000Oo.f17039O000000o = System.currentTimeMillis();
                    return 0;
                } else {
                    cki.O00000o("VideoDecoderNative", "change size ignore width" + O000000o2.width);
                    return 0;
                }
            } else {
                cki.O00000o0("VideoDecoderNative", "decoder need iFrame and receive non iFrame");
                return 0;
            }
        }

        /* access modifiers changed from: protected */
        public final void doInitial() {
            cki.O00000o("VideoDecoderNative", "doInitial");
            this.f17049O000000o = 0;
            this.O00000Oo = 0;
            this.O00000oo = new SurfaceTexture(fsd.this.O0000OOo);
            this.O00000oo.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
                /* class _m_j.fsd.O000000o.AnonymousClass1 */

                public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
                    synchronized (fsd.this.O0000O0o) {
                        fsd.this.O0000Oo0 = true;
                        fsd.this.O00000Oo();
                    }
                }
            });
            this.O00000oO = new Surface(this.O00000oo);
            this.O00000o0 = false;
        }

        /* access modifiers changed from: protected */
        public final void doRelease() {
            this.O00000oo.setOnFrameAvailableListener(null);
            this.O00000oo.release();
            this.O00000oO.release();
            NativeDecode.release(this.O00000o);
            this.O00000o = 0;
            this.O0000Oo0 = false;
            cki.O00000o("VideoDecoderNative", "VideoDecodeThread stop");
        }
    }

    public final boolean O0000OoO() {
        if (this.O0000o0O != null) {
            O000000o o000000o = this.O0000o0O;
            if (o000000o.O00000o != 0) {
                return NativeDecode.isGPUDecode(o000000o.O00000o);
            }
        }
        return true;
    }

    public final void O0000Oo() {
        if (this.O0000o0O != null) {
            this.O0000o0O.O0000O0o = true;
        }
    }
}
