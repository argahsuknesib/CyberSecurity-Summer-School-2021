package com.google.android.exoplayer2.ext.ffmpeg;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.decoder.Decoder;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.DecoderVideoRenderer;
import com.google.android.exoplayer2.video.VideoDecoderInputBuffer;
import com.google.android.exoplayer2.video.VideoDecoderOutputBuffer;
import com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final class FfmpegVideoRenderer extends DecoderVideoRenderer {
    private static final int DEFAULT_INPUT_BUFFER_SIZE = (((Util.ceilDivide(1280, 64) * Util.ceilDivide(720, 64)) * 6144) / 2);
    private FfmpegVideoDecoder decoder;
    private final int numInputBuffers;
    private final int numOutputBuffers;
    private final int threads;
    private VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer;

    public final String getName() {
        return "FfmpegVideoRenderer";
    }

    public FfmpegVideoRenderer(long j, Handler handler, VideoRendererEventListener videoRendererEventListener, int i, VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer2) {
        this(j, handler, videoRendererEventListener, i);
        this.videoDecoderOutputBufferRenderer = videoDecoderOutputBufferRenderer2;
    }

    public FfmpegVideoRenderer(long j, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        this(j, handler, videoRendererEventListener, i, Runtime.getRuntime().availableProcessors(), 4, 4);
    }

    public FfmpegVideoRenderer(long j, Handler handler, VideoRendererEventListener videoRendererEventListener, int i, int i2, int i3, int i4) {
        super(j, handler, videoRendererEventListener, i);
        this.threads = i2;
        this.numInputBuffers = i3;
        this.numOutputBuffers = i4;
    }

    public final int supportsFormat(Format format) {
        String str = (String) Assertions.checkNotNull(format.sampleMimeType);
        if (!FfmpegLibrary.isAvailable() || !MimeTypes.isVideo(str)) {
            return 0;
        }
        if (!FfmpegLibrary.supportsFormat(format.sampleMimeType)) {
            return RendererCapabilities.CC.create(1);
        }
        if (format.drmInitData == null || format.exoMediaCryptoType != null) {
            return RendererCapabilities.CC.create(4, 16, 0);
        }
        return RendererCapabilities.CC.create(2);
    }

    public final Decoder<VideoDecoderInputBuffer, VideoDecoderOutputBuffer, FfmpegDecoderException> createDecoder(Format format, ExoMediaCrypto exoMediaCrypto) throws FfmpegDecoderException {
        TraceUtil.beginSection("createFfmpegVideoDecoder");
        FfmpegVideoDecoder ffmpegVideoDecoder = new FfmpegVideoDecoder(this.numInputBuffers, this.numOutputBuffers, format.maxInputSize != -1 ? format.maxInputSize : DEFAULT_INPUT_BUFFER_SIZE, this.threads, format);
        this.decoder = ffmpegVideoDecoder;
        TraceUtil.endSection();
        if (this.videoDecoderOutputBufferRenderer != null) {
            ffmpegVideoDecoder.setHSVideo(true);
            setOutputBufferRenderer(this.videoDecoderOutputBufferRenderer);
        }
        return ffmpegVideoDecoder;
    }

    public final void renderOutputBufferToSurface(VideoDecoderOutputBuffer videoDecoderOutputBuffer, Surface surface) throws FfmpegDecoderException {
        FfmpegVideoDecoder ffmpegVideoDecoder = this.decoder;
        if (ffmpegVideoDecoder != null) {
            ffmpegVideoDecoder.renderToSurface(videoDecoderOutputBuffer, surface);
            videoDecoderOutputBuffer.release();
            return;
        }
        throw new FfmpegDecoderException("Failed to render output buffer to surface: decoder is not initialized.");
    }

    public final void setDecoderOutputMode(int i) {
        FfmpegVideoDecoder ffmpegVideoDecoder = this.decoder;
        if (ffmpegVideoDecoder != null) {
            ffmpegVideoDecoder.setOutputMode(i);
        }
    }
}
