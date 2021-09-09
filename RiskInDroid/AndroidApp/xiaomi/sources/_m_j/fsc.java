package _m_j;

import _m_j.frx;
import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Build;
import android.view.Surface;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.mijia.generalplayer.gl.GlslFilter;
import com.xiaomi.smarthome.camera.VideoFrame;
import com.xiaomi.smarthome.fastvideo.VideoGlSurfaceView;
import com.xiaomi.smarthome.fastvideo.decoder.MediaCodecUtil;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class fsc extends fsa {
    public volatile Object O0000O0o = new Object();
    int O0000OOo;
    private cju O0000Oo;
    public volatile boolean O0000Oo0 = false;
    private cju O0000OoO;
    private GlslFilter O0000Ooo;
    private volatile O000000o O0000o0;
    private float[] O0000o00 = new float[16];
    private frx.O000000o O0000o0O;

    public final void O00000oO() {
        super.O00000oO();
        this.O0000Ooo = new GlslFilter(O000000o().getContext());
        GlslFilter glslFilter = this.O0000Ooo;
        glslFilter.O00000oO = 36197;
        glslFilter.O00000o();
        this.O0000OOo = cjw.O000000o();
        GLES20.glBindTexture(36197, this.O0000OOo);
        cjw.O000000o("glBindTexture mTextureID");
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        this.O0000Oo0 = false;
        cjw.O000000o("surfaceCreated");
        this.O0000o0 = new O000000o();
        this.O0000o0.start();
    }

    public fsc(VideoGlSurfaceView videoGlSurfaceView, frx.O000000o o000000o) {
        super(videoGlSurfaceView);
        this.O0000o0O = o000000o;
        this.O00000oo = o000000o.O00000o0;
    }

    public final void O0000O0o() {
        super.O0000O0o();
        synchronized (this.O0000O0o) {
            try {
                if (this.O0000Oo0) {
                    this.O0000Oo0 = false;
                    if (this.O0000o0 == null) {
                        cki.O00000o("VideoGPU", "mVideoDecodeThread == null");
                        return;
                    }
                    int O000000o2 = this.O0000o0.O000000o();
                    int O00000Oo = this.O0000o0.O00000Oo();
                    if (O000000o2 != 0) {
                        if (O00000Oo != 0) {
                            if (this.O0000Oo == null) {
                                this.O0000Oo = cju.O000000o(O000000o2, O00000Oo);
                            } else {
                                this.O0000Oo.O00000Oo(O000000o2, O00000Oo);
                            }
                            if (this.O0000OoO == null) {
                                this.O0000OoO = new cju(this.O0000OOo, O000000o2, O00000Oo);
                            }
                            O000000o o000000o = this.O0000o0;
                            float[] fArr = this.O0000o00;
                            if (o000000o.O0000O0o != null) {
                                o000000o.O0000O0o.updateTexImage();
                                o000000o.O0000O0o.getTransformMatrix(fArr);
                            }
                            this.O0000Ooo.O000000o(this.O0000o00);
                            this.O0000Ooo.O000000o(this.O0000OoO, this.O0000Oo);
                            O000000o(this.O0000Oo);
                        }
                    }
                    cki.O00000o("VideoGPU", "videoWith:" + O000000o2 + " videoHeight:" + O00000Oo);
                }
            } catch (Exception e) {
                cki.O00000o("VideoGPU", "drawFrame e:" + e.getLocalizedMessage());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void O00000oo() {
        super.O00000oo();
        if (this.O0000o0 != null) {
            this.O0000o0.stopThreadAsyn();
        }
        this.O0000o0 = null;
        cjw.O000000o(this.O0000OOo);
        GlslFilter glslFilter = this.O0000Ooo;
        if (glslFilter != null) {
            glslFilter.O00000oO();
        }
        cju cju = this.O0000Oo;
        if (cju != null) {
            cju.O000000o();
            this.O0000Oo = null;
        }
    }

    class O000000o extends fsg {

        /* renamed from: O000000o  reason: collision with root package name */
        int f17047O000000o;
        int O00000Oo;
        MediaCodec.BufferInfo O00000o = new MediaCodec.BufferInfo();
        VideoFrame O00000o0;
        volatile boolean O00000oO = false;
        Surface O00000oo;
        SurfaceTexture O0000O0o;
        private MediaCodec O0000Oo;
        private frx.O000000o O0000Oo0;
        private ByteBuffer[] O0000OoO;
        private int O0000Ooo = 0;
        private boolean O0000o00 = false;

        public O000000o() {
            super("VideoDecodeThread");
            cki.O00000o("VideoGPU", "VideoDecodeThread start");
        }

        public final int O000000o() {
            return fsc.this.f17046O000000o;
        }

        public final int O00000Oo() {
            return fsc.this.O00000Oo;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.Math.max(long, long):long}
         arg types: [long, int]
         candidates:
          ClspMth{java.lang.Math.max(double, double):double}
          ClspMth{java.lang.Math.max(int, int):int}
          ClspMth{java.lang.Math.max(float, float):float}
          ClspMth{java.lang.Math.max(long, long):long} */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, boolean):void}
         arg types: [int, int]
         candidates:
          ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, long):void}
          ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, boolean):void} */
        /* access modifiers changed from: protected */
        public final int doRepeatWork() throws InterruptedException {
            ByteBuffer byteBuffer;
            if (!this.mIsRunning) {
                return 0;
            }
            VideoFrame videoFrame = this.O00000o0;
            if (videoFrame != null) {
                this.O00000o0 = null;
            } else {
                videoFrame = fsc.this.O000000o(this.O0000Oo == null);
            }
            VideoFrame videoFrame2 = videoFrame;
            ckj.O000000o().O000000o(this, "FIRST_RENDER:get video frame");
            if (videoFrame2 == null || videoFrame2.data == null) {
                cki.O00000o("VideoGPU", "frame == null || frame.data == null");
                return 0;
            } else if (this.O00000oO) {
                cki.O00000o("VideoGPU", "mInitialError");
                return 0;
            } else if (this.O0000Oo == null && !videoFrame2.isIFrame) {
                cki.O00000o("VideoGPU", "decoder == null && !frame.isIFrame");
                return 0;
            } else if (videoFrame2.width <= 0 || videoFrame2.height <= 0) {
                cki.O00000o("VideoGPU", "frame.width <= 0 || frame.height <= 0");
                return 0;
            } else {
                try {
                    if (!(this.O0000Oo != null && videoFrame2.width == this.f17047O000000o && videoFrame2.height == this.O00000Oo && fsc.this.O00000oo == videoFrame2.videoType)) {
                        this.f17047O000000o = videoFrame2.width;
                        this.O00000Oo = videoFrame2.height;
                        fsc.this.O00000oo = videoFrame2.videoType;
                        O00000o0();
                        int i = this.f17047O000000o;
                        int i2 = this.O00000Oo;
                        cki.O00000o("VideoGPU", "configureMediaDecode width:" + i + " height:" + i2);
                        try {
                            frx.O000000o O000000o2 = frx.O000000o(new MediaCodecUtil.CodecKey(fsc.this.O00000oo, i, i2));
                            if (O000000o2 != null) {
                                this.O0000Oo0 = O000000o2;
                                MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.O0000Oo0.O000000o(), i, i2);
                                cki.O00000o("VideoGPU", "configureMediaDecode:" + createVideoFormat.toString());
                                this.O0000Oo = MediaCodec.createByCodecName(this.O0000Oo0.f17038O000000o);
                                if (Build.VERSION.SDK_INT <= 16) {
                                    createVideoFormat.setInteger("max-input-size", 0);
                                }
                                this.O0000Oo.configure(createVideoFormat, this.O00000oo, (MediaCrypto) null, 0);
                                this.O0000Oo.start();
                                this.O0000o00 = true;
                                if (Build.VERSION.SDK_INT < 21) {
                                    this.O0000OoO = this.O0000Oo.getInputBuffers();
                                }
                            } else {
                                this.O00000oO = true;
                                fsc.this.O0000OoO();
                            }
                        } catch (Exception e) {
                            cki.O00000o("VideoGPU", "configureMediaDecode:" + e.getLocalizedMessage());
                            this.O00000oO = true;
                            O00000o0();
                            fsc.this.O0000OoO();
                        }
                    }
                    if (this.O0000Oo == null) {
                        cki.O00000o("VideoGPU", "decoder == null");
                        return 0;
                    }
                    ckj.O000000o().O000000o(this, "FIRST_RENDER:decode start");
                    int dequeueInputBuffer = this.O0000Oo.dequeueInputBuffer(DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
                    if (dequeueInputBuffer >= 0) {
                        if (Build.VERSION.SDK_INT < 21) {
                            byteBuffer = this.O0000OoO[dequeueInputBuffer];
                        } else {
                            byteBuffer = this.O0000Oo.getInputBuffer(dequeueInputBuffer);
                        }
                        byteBuffer.rewind();
                        byteBuffer.put(videoFrame2.data);
                        this.O0000Oo.queueInputBuffer(dequeueInputBuffer, 0, videoFrame2.data.length, Math.max(videoFrame2.timeStamp, 0L) * 1000, 0);
                        this.O0000Ooo = 0;
                    } else {
                        cki.O00000o("VideoGPU", "dequeue input buffer time out:" + this.O0000Ooo);
                        this.O00000o0 = videoFrame2;
                        this.O0000Ooo = this.O0000Ooo + 1;
                    }
                    if (this.O0000Ooo >= 5) {
                        this.O0000Ooo = 0;
                        O00000o0();
                        fsc.this.O0000OoO();
                        cki.O00000o("VideoGPU", "dequeueFailCount >= 5");
                        return 0;
                    }
                    while (this.mIsRunning) {
                        System.currentTimeMillis();
                        int dequeueOutputBuffer = this.O0000Oo.dequeueOutputBuffer(this.O00000o, DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
                        if (dequeueOutputBuffer >= 0) {
                            MediaFormat outputFormat = this.O0000Oo.getOutputFormat();
                            fsc.this.f17046O000000o = outputFormat.getInteger("width");
                            fsc.this.O00000Oo = outputFormat.getInteger("height");
                            if (outputFormat.containsKey("crop-left") && outputFormat.containsKey("crop-right")) {
                                fsc.this.f17046O000000o = (outputFormat.getInteger("crop-right") + 1) - outputFormat.getInteger("crop-left");
                            }
                            if (outputFormat.containsKey("crop-top") && outputFormat.containsKey("crop-bottom")) {
                                fsc.this.O00000Oo = (outputFormat.getInteger("crop-bottom") + 1) - outputFormat.getInteger("crop-top");
                            }
                            this.O0000Oo.releaseOutputBuffer(dequeueOutputBuffer, true);
                        } else if (dequeueOutputBuffer != -2) {
                            ckj.O000000o().O000000o(this, "FIRST_RENDER:decode done");
                            return 0;
                        }
                    }
                    cki.O00000o("VideoGPU", "!mIsRunning");
                    return 0;
                } catch (Exception unused) {
                    fsc.this.O0000OoO();
                    cki.O00000o("VideoGPU", "Exception changeDecode()");
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void doInitial() {
            cki.O00000o("VideoGPU", "doInitial");
            this.f17047O000000o = 0;
            this.O00000Oo = 0;
            this.O0000O0o = new SurfaceTexture(fsc.this.O0000OOo);
            this.O0000O0o.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
                /* class _m_j.fsc.O000000o.AnonymousClass1 */

                public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
                    synchronized (fsc.this.O0000O0o) {
                        fsc.this.O0000Oo0 = true;
                        fsc.this.O00000Oo();
                    }
                }
            });
            this.O00000oo = new Surface(this.O0000O0o);
            this.O00000oO = false;
        }

        /* access modifiers changed from: protected */
        public final void doRelease() {
            this.O0000O0o.setOnFrameAvailableListener(null);
            this.O0000O0o.release();
            this.O00000oo.release();
            O00000o0();
            cki.O00000o("VideoGPU", "VideoDecodeThread stop");
        }

        private boolean O00000o0() {
            boolean z = false;
            this.O0000o00 = false;
            cki.O00000o("VideoGPU", "releaseMediaDecode");
            MediaCodec mediaCodec = this.O0000Oo;
            if (mediaCodec != null) {
                try {
                    mediaCodec.flush();
                    this.O0000Oo.stop();
                    this.O0000Oo.release();
                    this.O0000Oo = null;
                    z = true;
                    cki.O00000o("VideoGPU", "Release decoder success");
                    return true;
                } catch (Exception e) {
                    this.O0000Oo = null;
                    cki.O00000o("VideoGPU", "Release decoder error:" + e.getMessage());
                    return z;
                }
            } else {
                cki.O00000o("VideoGPU", "releaseMediaDecode decoder null");
                return false;
            }
        }
    }

    public final void O0000OoO() {
        O00000oo();
        O000000o(this.O00000oo);
    }
}
