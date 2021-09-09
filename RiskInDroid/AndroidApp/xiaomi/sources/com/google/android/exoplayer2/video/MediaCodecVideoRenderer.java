package com.google.android.exoplayer2.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.MediaFormatUtil;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class MediaCodecVideoRenderer extends MediaCodecRenderer {
    private static final int[] STANDARD_LONG_EDGE_VIDEO_PX = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static boolean deviceNeedsSetOutputSurfaceWorkaround;
    private static boolean evaluatedDeviceNeedsSetOutputSurfaceWorkaround;
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private boolean codecHandlesHdr10PlusOutOfBandMetadata;
    private CodecMaxValues codecMaxValues;
    private boolean codecNeedsSetOutputSurfaceWorkaround;
    private int consecutiveDroppedFrameCount;
    private final Context context;
    private int currentHeight;
    private MediaFormat currentMediaFormat;
    private float currentPixelWidthHeightRatio;
    private int currentUnappliedRotationDegrees;
    private int currentWidth;
    private final boolean deviceNeedsNoPostProcessWorkaround;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private Surface dummySurface;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;
    private VideoFrameMetadataListener frameMetadataListener;
    private final VideoFrameReleaseTimeHelper frameReleaseTimeHelper;
    private long initialPositionUs;
    private long joiningDeadlineMs;
    private long lastRenderTimeUs;
    private final int maxDroppedFramesToNotify;
    private boolean mayRenderFirstFrameAfterEnableIfNotStarted;
    private float pendingPixelWidthHeightRatio;
    private int pendingRotationDegrees;
    private boolean renderedFirstFrameAfterEnable;
    private boolean renderedFirstFrameAfterReset;
    private int reportedHeight;
    private float reportedPixelWidthHeightRatio;
    private int reportedUnappliedRotationDegrees;
    private int reportedWidth;
    private int scalingMode;
    private Surface surface;
    private long totalVideoFrameProcessingOffsetUs;
    private boolean tunneling;
    private int tunnelingAudioSessionId;
    OnFrameRenderedListenerV23 tunnelingOnFrameRenderedListener;
    private int videoFrameProcessingOffsetCount;

    private static boolean isBufferLate(long j) {
        return j < -30000;
    }

    private static boolean isBufferVeryLate(long j) {
        return j < -500000;
    }

    public String getName() {
        return "MediaCodecVideoRenderer";
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector) {
        this(context2, mediaCodecSelector, 0);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j) {
        this(context2, mediaCodecSelector, j, null, null, -1);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        this(context2, mediaCodecSelector, j, false, handler, videoRendererEventListener, i);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        super(2, mediaCodecSelector, z, 30.0f);
        this.allowedJoiningTimeMs = j;
        this.maxDroppedFramesToNotify = i;
        this.context = context2.getApplicationContext();
        this.frameReleaseTimeHelper = new VideoFrameReleaseTimeHelper(this.context);
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.deviceNeedsNoPostProcessWorkaround = deviceNeedsNoPostProcessWorkaround();
        this.joiningDeadlineMs = -9223372036854775807L;
        this.currentWidth = -1;
        this.currentHeight = -1;
        this.currentPixelWidthHeightRatio = -1.0f;
        this.pendingPixelWidthHeightRatio = -1.0f;
        this.scalingMode = 1;
        clearReportedVideoSize();
    }

    public int supportsFormat(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        int i = 0;
        if (!MimeTypes.isVideo(format.sampleMimeType)) {
            return RendererCapabilities.CC.create(0);
        }
        boolean z = format.drmInitData != null;
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(mediaCodecSelector, format, z, false);
        if (z && decoderInfos.isEmpty()) {
            decoderInfos = getDecoderInfos(mediaCodecSelector, format, false, false);
        }
        if (decoderInfos.isEmpty()) {
            return RendererCapabilities.CC.create(1);
        }
        if (!supportsFormatDrm(format)) {
            return RendererCapabilities.CC.create(2);
        }
        MediaCodecInfo mediaCodecInfo = decoderInfos.get(0);
        boolean isFormatSupported = mediaCodecInfo.isFormatSupported(format);
        int i2 = mediaCodecInfo.isSeamlessAdaptationSupported(format) ? 16 : 8;
        if (isFormatSupported) {
            List<MediaCodecInfo> decoderInfos2 = getDecoderInfos(mediaCodecSelector, format, z, true);
            if (!decoderInfos2.isEmpty()) {
                MediaCodecInfo mediaCodecInfo2 = decoderInfos2.get(0);
                if (mediaCodecInfo2.isFormatSupported(format) && mediaCodecInfo2.isSeamlessAdaptationSupported(format)) {
                    i = 32;
                }
            }
        }
        return RendererCapabilities.CC.create(isFormatSupported ? 4 : 3, i2, i);
    }

    public List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        return getDecoderInfos(mediaCodecSelector, format, z, this.tunneling);
    }

    private static List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z, boolean z2) throws MediaCodecUtil.DecoderQueryException {
        Pair<Integer, Integer> codecProfileAndLevel;
        String str = format.sampleMimeType;
        if (str == null) {
            return Collections.emptyList();
        }
        List<MediaCodecInfo> decoderInfosSortedByFormatSupport = MediaCodecUtil.getDecoderInfosSortedByFormatSupport(mediaCodecSelector.getDecoderInfos(str, z, z2), format);
        if ("video/dolby-vision".equals(str) && (codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format)) != null) {
            int intValue = ((Integer) codecProfileAndLevel.first).intValue();
            if (intValue == 16 || intValue == 256) {
                decoderInfosSortedByFormatSupport.addAll(mediaCodecSelector.getDecoderInfos("video/hevc", z, z2));
            } else if (intValue == 512) {
                decoderInfosSortedByFormatSupport.addAll(mediaCodecSelector.getDecoderInfos("video/avc", z, z2));
            }
        }
        return Collections.unmodifiableList(decoderInfosSortedByFormatSupport);
    }

    public void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
        super.onEnabled(z, z2);
        int i = this.tunnelingAudioSessionId;
        this.tunnelingAudioSessionId = getConfiguration().tunnelingAudioSessionId;
        this.tunneling = this.tunnelingAudioSessionId != 0;
        if (this.tunnelingAudioSessionId != i) {
            releaseCodec();
        }
        this.eventDispatcher.enabled(this.decoderCounters);
        this.frameReleaseTimeHelper.enable();
        this.mayRenderFirstFrameAfterEnableIfNotStarted = z2;
        this.renderedFirstFrameAfterEnable = false;
    }

    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        super.onPositionReset(j, z);
        clearRenderedFirstFrame();
        this.initialPositionUs = -9223372036854775807L;
        this.consecutiveDroppedFrameCount = 0;
        if (z) {
            setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = -9223372036854775807L;
        }
    }

    public boolean isReady() {
        Surface surface2;
        if (super.isReady() && (this.renderedFirstFrameAfterReset || (((surface2 = this.dummySurface) != null && this.surface == surface2) || getCodec() == null || this.tunneling))) {
            this.joiningDeadlineMs = -9223372036854775807L;
            return true;
        } else if (this.joiningDeadlineMs == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.joiningDeadlineMs) {
                return true;
            }
            this.joiningDeadlineMs = -9223372036854775807L;
            return false;
        }
    }

    public void onStarted() {
        super.onStarted();
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
        this.totalVideoFrameProcessingOffsetUs = 0;
        this.videoFrameProcessingOffsetCount = 0;
    }

    public void onStopped() {
        this.joiningDeadlineMs = -9223372036854775807L;
        maybeNotifyDroppedFrames();
        maybeNotifyVideoFrameProcessingOffset();
        super.onStopped();
    }

    public void onDisabled() {
        this.currentMediaFormat = null;
        clearReportedVideoSize();
        clearRenderedFirstFrame();
        this.frameReleaseTimeHelper.disable();
        this.tunnelingOnFrameRenderedListener = null;
        try {
            super.onDisabled();
        } finally {
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    public void onReset() {
        try {
            super.onReset();
        } finally {
            Surface surface2 = this.dummySurface;
            if (surface2 != null) {
                if (this.surface == surface2) {
                    this.surface = null;
                }
                this.dummySurface.release();
                this.dummySurface = null;
            }
        }
    }

    public void handleMessage(int i, Object obj) throws ExoPlaybackException {
        if (i == 1) {
            setSurface((Surface) obj);
        } else if (i == 4) {
            this.scalingMode = ((Integer) obj).intValue();
            MediaCodec codec = getCodec();
            if (codec != null) {
                codec.setVideoScalingMode(this.scalingMode);
            }
        } else if (i == 6) {
            this.frameMetadataListener = (VideoFrameMetadataListener) obj;
        } else {
            super.handleMessage(i, obj);
        }
    }

    private void setSurface(Surface surface2) throws ExoPlaybackException {
        if (surface2 == null) {
            Surface surface3 = this.dummySurface;
            if (surface3 != null) {
                surface2 = surface3;
            } else {
                MediaCodecInfo codecInfo = getCodecInfo();
                if (codecInfo != null && shouldUseDummySurface(codecInfo)) {
                    this.dummySurface = DummySurface.newInstanceV17(this.context, codecInfo.secure);
                    surface2 = this.dummySurface;
                }
            }
        }
        if (this.surface != surface2) {
            this.surface = surface2;
            int state = getState();
            MediaCodec codec = getCodec();
            if (codec != null) {
                if (Util.SDK_INT < 23 || surface2 == null || this.codecNeedsSetOutputSurfaceWorkaround) {
                    releaseCodec();
                    maybeInitCodec();
                } else {
                    setOutputSurfaceV23(codec, surface2);
                }
            }
            if (surface2 == null || surface2 == this.dummySurface) {
                clearReportedVideoSize();
                clearRenderedFirstFrame();
                return;
            }
            maybeRenotifyVideoSizeChanged();
            clearRenderedFirstFrame();
            if (state == 2) {
                setJoiningDeadlineMs();
            }
        } else if (surface2 != null && surface2 != this.dummySurface) {
            maybeRenotifyVideoSizeChanged();
            maybeRenotifyRenderedFirstFrame();
        }
    }

    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return this.surface != null || shouldUseDummySurface(mediaCodecInfo);
    }

    public boolean getCodecNeedsEosPropagation() {
        return this.tunneling && Util.SDK_INT < 23;
    }

    public void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto, float f) {
        String str = mediaCodecInfo.codecMimeType;
        this.codecMaxValues = getCodecMaxValues(mediaCodecInfo, format, getStreamFormats());
        MediaFormat mediaFormat = getMediaFormat(format, str, this.codecMaxValues, f, this.deviceNeedsNoPostProcessWorkaround, this.tunnelingAudioSessionId);
        if (this.surface == null) {
            if (shouldUseDummySurface(mediaCodecInfo)) {
                if (this.dummySurface == null) {
                    this.dummySurface = DummySurface.newInstanceV17(this.context, mediaCodecInfo.secure);
                }
                this.surface = this.dummySurface;
            } else {
                throw new IllegalStateException();
            }
        }
        mediaCodec.configure(mediaFormat, this.surface, mediaCrypto, 0);
        if (Util.SDK_INT >= 23 && this.tunneling) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(mediaCodec);
        }
    }

    public int canKeepCodec(MediaCodec mediaCodec, MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        if (!mediaCodecInfo.isSeamlessAdaptationSupported(format, format2, true) || format2.width > this.codecMaxValues.width || format2.height > this.codecMaxValues.height || getMaxInputSize(mediaCodecInfo, format2) > this.codecMaxValues.inputSize) {
            return 0;
        }
        return format.initializationDataEquals(format2) ? 3 : 2;
    }

    public void resetCodecStateForFlush() {
        super.resetCodecStateForFlush();
        this.buffersInCodecCount = 0;
    }

    public float getCodecOperatingRateV23(float f, Format format, Format[] formatArr) {
        float f2 = -1.0f;
        for (Format format2 : formatArr) {
            float f3 = format2.frameRate;
            if (f3 != -1.0f) {
                f2 = Math.max(f2, f3);
            }
        }
        if (f2 == -1.0f) {
            return -1.0f;
        }
        return f2 * f;
    }

    public void onCodecInitialized(String str, long j, long j2) {
        this.eventDispatcher.decoderInitialized(str, j, j2);
        this.codecNeedsSetOutputSurfaceWorkaround = codecNeedsSetOutputSurfaceWorkaround(str);
        this.codecHandlesHdr10PlusOutOfBandMetadata = ((MediaCodecInfo) Assertions.checkNotNull(getCodecInfo())).isHdr10PlusOutOfBandMetadataSupported();
    }

    public void onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
        super.onInputFormatChanged(formatHolder);
        Format format = formatHolder.format;
        this.eventDispatcher.inputFormatChanged(format);
        this.pendingPixelWidthHeightRatio = format.pixelWidthHeightRatio;
        this.pendingRotationDegrees = format.rotationDegrees;
    }

    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        if (!this.tunneling) {
            this.buffersInCodecCount++;
        }
        if (Util.SDK_INT < 23 && this.tunneling) {
            onProcessedTunneledBuffer(decoderInputBuffer.timeUs);
        }
    }

    public void onOutputMediaFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i;
        int i2;
        this.currentMediaFormat = mediaFormat;
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z) {
            i = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            i = mediaFormat.getInteger("width");
        }
        if (z) {
            i2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            i2 = mediaFormat.getInteger("height");
        }
        processOutputFormat(mediaCodec, i, i2);
        maybeNotifyVideoFrameProcessingOffset();
    }

    @TargetApi(29)
    public void handleInputBufferSupplementalData(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (this.codecHandlesHdr10PlusOutOfBandMetadata) {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(decoderInputBuffer.supplementalData);
            if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b == -75 && s == 60 && s2 == 1 && b2 == 4 && b3 == 0) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    setHdr10PlusInfoV29(getCodec(), bArr);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0087, code lost:
        if (shouldForceRenderOutputBuffer(r3, r13) != false) goto L_0x008c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c4  */
    public boolean processOutputBuffer(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, Format format) throws ExoPlaybackException {
        long j4;
        boolean z3;
        long j5;
        boolean z4;
        long j6 = j;
        MediaCodec mediaCodec2 = mediaCodec;
        int i4 = i;
        long j7 = j3;
        if (this.initialPositionUs == -9223372036854775807L) {
            this.initialPositionUs = j6;
        }
        long outputStreamOffsetUs = getOutputStreamOffsetUs();
        long j8 = j7 - outputStreamOffsetUs;
        if (!z || z2) {
            long j9 = j7 - j6;
            if (this.surface != this.dummySurface) {
                long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
                long j10 = j9;
                long j11 = elapsedRealtime - this.lastRenderTimeUs;
                boolean z5 = getState() == 2;
                if (this.renderedFirstFrameAfterEnable ? this.renderedFirstFrameAfterReset : !z5 && !this.mayRenderFirstFrameAfterEnableIfNotStarted) {
                    j4 = elapsedRealtime;
                    z3 = false;
                } else {
                    j4 = elapsedRealtime;
                    z3 = true;
                }
                if (this.joiningDeadlineMs == -9223372036854775807L && j6 >= outputStreamOffsetUs) {
                    if (z3) {
                        j5 = j10;
                    } else if (z5) {
                        j5 = j10;
                    }
                    z4 = true;
                    if (!z4) {
                        long nanoTime = System.nanoTime();
                        long j12 = j5;
                        notifyFrameMetadataListener(j8, nanoTime, format, this.currentMediaFormat);
                        if (Util.SDK_INT >= 21) {
                            renderOutputBufferV21(mediaCodec, i, j8, nanoTime);
                        } else {
                            renderOutputBuffer(mediaCodec2, i4, j8);
                        }
                        this.decoderCounters.addVideoFrameProcessingOffsetSample(j12);
                        return true;
                    }
                    long j13 = j5;
                    if (z5 && j6 != this.initialPositionUs) {
                        long nanoTime2 = System.nanoTime();
                        long adjustReleaseTime = this.frameReleaseTimeHelper.adjustReleaseTime(j3, ((j13 - (j4 - j2)) * 1000) + nanoTime2);
                        long j14 = (adjustReleaseTime - nanoTime2) / 1000;
                        boolean z6 = this.joiningDeadlineMs != -9223372036854775807L;
                        long j15 = j14;
                        if (shouldDropBuffersToKeyframe(j14, j2, z2) && maybeDropBuffersToKeyframe(mediaCodec, i, j8, j, z6)) {
                            return false;
                        }
                        if (shouldDropOutputBuffer(j15, j2, z2)) {
                            if (z6) {
                                skipOutputBuffer(mediaCodec2, i4, j8);
                            } else {
                                dropOutputBuffer(mediaCodec2, i4, j8);
                            }
                            this.decoderCounters.addVideoFrameProcessingOffsetSample(j15);
                            return true;
                        }
                        long j16 = j15;
                        if (Util.SDK_INT < 21) {
                            long j17 = j16;
                            if (j17 < DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS) {
                                if (j17 > 11000) {
                                    try {
                                        Thread.sleep((j17 - 10000) / 1000);
                                    } catch (InterruptedException unused) {
                                        Thread.currentThread().interrupt();
                                        return false;
                                    }
                                }
                                notifyFrameMetadataListener(j8, adjustReleaseTime, format, this.currentMediaFormat);
                                renderOutputBuffer(mediaCodec, i, j8);
                                this.decoderCounters.addVideoFrameProcessingOffsetSample(j17);
                                return true;
                            }
                        } else if (j16 < 50000) {
                            notifyFrameMetadataListener(j8, adjustReleaseTime, format, this.currentMediaFormat);
                            renderOutputBufferV21(mediaCodec, i, j8, adjustReleaseTime);
                            this.decoderCounters.addVideoFrameProcessingOffsetSample(j16);
                            return true;
                        }
                    }
                    return false;
                }
                j5 = j10;
                z4 = false;
                if (!z4) {
                }
            } else if (!isBufferLate(j9)) {
                return false;
            } else {
                skipOutputBuffer(mediaCodec2, i4, j8);
                this.decoderCounters.addVideoFrameProcessingOffsetSample(j9);
                return true;
            }
        } else {
            skipOutputBuffer(mediaCodec2, i4, j8);
            return true;
        }
    }

    private void processOutputFormat(MediaCodec mediaCodec, int i, int i2) {
        this.currentWidth = i;
        this.currentHeight = i2;
        this.currentPixelWidthHeightRatio = this.pendingPixelWidthHeightRatio;
        if (Util.SDK_INT >= 21) {
            int i3 = this.pendingRotationDegrees;
            if (i3 == 90 || i3 == 270) {
                int i4 = this.currentWidth;
                this.currentWidth = this.currentHeight;
                this.currentHeight = i4;
                this.currentPixelWidthHeightRatio = 1.0f / this.currentPixelWidthHeightRatio;
            }
        } else {
            this.currentUnappliedRotationDegrees = this.pendingRotationDegrees;
        }
        mediaCodec.setVideoScalingMode(this.scalingMode);
    }

    private void notifyFrameMetadataListener(long j, long j2, Format format, MediaFormat mediaFormat) {
        VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j, j2, format, mediaFormat);
        }
    }

    /* access modifiers changed from: protected */
    public void onProcessedTunneledBuffer(long j) {
        Format updateOutputFormatForTime = updateOutputFormatForTime(j);
        if (updateOutputFormatForTime != null) {
            processOutputFormat(getCodec(), updateOutputFormatForTime.width, updateOutputFormatForTime.height);
        }
        maybeNotifyVideoSizeChanged();
        this.decoderCounters.renderedOutputBufferCount++;
        maybeNotifyRenderedFirstFrame();
        onProcessedOutputBuffer(j);
    }

    public void onProcessedTunneledEndOfStream() {
        setPendingOutputEndOfStream();
    }

    public void onProcessedOutputBuffer(long j) {
        super.onProcessedOutputBuffer(j);
        if (!this.tunneling) {
            this.buffersInCodecCount--;
        }
    }

    public void onProcessedStreamChange() {
        super.onProcessedStreamChange();
        clearRenderedFirstFrame();
    }

    /* access modifiers changed from: protected */
    public boolean shouldDropOutputBuffer(long j, long j2, boolean z) {
        return isBufferLate(j) && !z;
    }

    /* access modifiers changed from: protected */
    public boolean shouldDropBuffersToKeyframe(long j, long j2, boolean z) {
        return isBufferVeryLate(j) && !z;
    }

    /* access modifiers changed from: protected */
    public boolean shouldForceRenderOutputBuffer(long j, long j2) {
        return isBufferLate(j) && j2 > 100000;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, long):void}
      ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, boolean):void} */
    /* access modifiers changed from: protected */
    public void skipOutputBuffer(MediaCodec mediaCodec, int i, long j) {
        TraceUtil.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        this.decoderCounters.skippedOutputBufferCount++;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, long):void}
      ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, boolean):void} */
    /* access modifiers changed from: protected */
    public void dropOutputBuffer(MediaCodec mediaCodec, int i, long j) {
        TraceUtil.beginSection("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        updateDroppedBufferCounters(1);
    }

    /* access modifiers changed from: protected */
    public boolean maybeDropBuffersToKeyframe(MediaCodec mediaCodec, int i, long j, long j2, boolean z) throws ExoPlaybackException {
        int skipSource = skipSource(j2);
        if (skipSource == 0) {
            return false;
        }
        this.decoderCounters.droppedToKeyframeCount++;
        int i2 = this.buffersInCodecCount + skipSource;
        if (z) {
            this.decoderCounters.skippedOutputBufferCount += i2;
        } else {
            updateDroppedBufferCounters(i2);
        }
        flushOrReinitializeCodec();
        return true;
    }

    /* access modifiers changed from: protected */
    public void updateDroppedBufferCounters(int i) {
        this.decoderCounters.droppedBufferCount += i;
        this.droppedFrames += i;
        this.consecutiveDroppedFrameCount += i;
        this.decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(this.consecutiveDroppedFrameCount, this.decoderCounters.maxConsecutiveDroppedBufferCount);
        int i2 = this.maxDroppedFramesToNotify;
        if (i2 > 0 && this.droppedFrames >= i2) {
            maybeNotifyDroppedFrames();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, long):void}
      ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, boolean):void} */
    /* access modifiers changed from: protected */
    public void renderOutputBuffer(MediaCodec mediaCodec, int i, long j) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        TraceUtil.endSection();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    /* access modifiers changed from: protected */
    public void renderOutputBufferV21(MediaCodec mediaCodec, int i, long j, long j2) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        TraceUtil.endSection();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    private boolean shouldUseDummySurface(MediaCodecInfo mediaCodecInfo) {
        if (Util.SDK_INT < 23 || this.tunneling || codecNeedsSetOutputSurfaceWorkaround(mediaCodecInfo.name)) {
            return false;
        }
        return !mediaCodecInfo.secure || DummySurface.isSecureSupported(this.context);
    }

    private void setJoiningDeadlineMs() {
        this.joiningDeadlineMs = this.allowedJoiningTimeMs > 0 ? SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs : -9223372036854775807L;
    }

    private void clearRenderedFirstFrame() {
        MediaCodec codec;
        this.renderedFirstFrameAfterReset = false;
        if (Util.SDK_INT >= 23 && this.tunneling && (codec = getCodec()) != null) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(codec);
        }
    }

    /* access modifiers changed from: package-private */
    public void maybeNotifyRenderedFirstFrame() {
        this.renderedFirstFrameAfterEnable = true;
        if (!this.renderedFirstFrameAfterReset) {
            this.renderedFirstFrameAfterReset = true;
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    private void maybeRenotifyRenderedFirstFrame() {
        if (this.renderedFirstFrameAfterReset) {
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    private void clearReportedVideoSize() {
        this.reportedWidth = -1;
        this.reportedHeight = -1;
        this.reportedPixelWidthHeightRatio = -1.0f;
        this.reportedUnappliedRotationDegrees = -1;
    }

    private void maybeNotifyVideoSizeChanged() {
        if (this.currentWidth != -1 || this.currentHeight != -1) {
            if (this.reportedWidth != this.currentWidth || this.reportedHeight != this.currentHeight || this.reportedUnappliedRotationDegrees != this.currentUnappliedRotationDegrees || this.reportedPixelWidthHeightRatio != this.currentPixelWidthHeightRatio) {
                this.eventDispatcher.videoSizeChanged(this.currentWidth, this.currentHeight, this.currentUnappliedRotationDegrees, this.currentPixelWidthHeightRatio);
                this.reportedWidth = this.currentWidth;
                this.reportedHeight = this.currentHeight;
                this.reportedUnappliedRotationDegrees = this.currentUnappliedRotationDegrees;
                this.reportedPixelWidthHeightRatio = this.currentPixelWidthHeightRatio;
            }
        }
    }

    private void maybeRenotifyVideoSizeChanged() {
        if (this.reportedWidth != -1 || this.reportedHeight != -1) {
            this.eventDispatcher.videoSizeChanged(this.reportedWidth, this.reportedHeight, this.reportedUnappliedRotationDegrees, this.reportedPixelWidthHeightRatio);
        }
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, elapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = elapsedRealtime;
        }
    }

    private void maybeNotifyVideoFrameProcessingOffset() {
        Format currentOutputFormat = getCurrentOutputFormat();
        if (currentOutputFormat != null) {
            long j = this.decoderCounters.totalVideoFrameProcessingOffsetUs - this.totalVideoFrameProcessingOffsetUs;
            int i = this.decoderCounters.videoFrameProcessingOffsetCount - this.videoFrameProcessingOffsetCount;
            if (i != 0) {
                this.eventDispatcher.reportVideoFrameProcessingOffset(j, i, currentOutputFormat);
                this.totalVideoFrameProcessingOffsetUs = this.decoderCounters.totalVideoFrameProcessingOffsetUs;
                this.videoFrameProcessingOffsetCount = this.decoderCounters.videoFrameProcessingOffsetCount;
            }
        }
    }

    private static void setHdr10PlusInfoV29(MediaCodec mediaCodec, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        mediaCodec.setParameters(bundle);
    }

    private static void setOutputSurfaceV23(MediaCodec mediaCodec, Surface surface2) {
        mediaCodec.setOutputSurface(surface2);
    }

    private static void configureTunnelingV21(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"InlinedApi"})
    @TargetApi(21)
    public MediaFormat getMediaFormat(Format format, String str, CodecMaxValues codecMaxValues2, float f, boolean z, int i) {
        Pair<Integer, Integer> codecProfileAndLevel;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", format.width);
        mediaFormat.setInteger("height", format.height);
        MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        MediaFormatUtil.maybeSetFloat(mediaFormat, "frame-rate", format.frameRate);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "rotation-degrees", format.rotationDegrees);
        MediaFormatUtil.maybeSetColorInfo(mediaFormat, format.colorInfo);
        if ("video/dolby-vision".equals(format.sampleMimeType) && (codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format)) != null) {
            MediaFormatUtil.maybeSetInteger(mediaFormat, "profile", ((Integer) codecProfileAndLevel.first).intValue());
        }
        mediaFormat.setInteger("max-width", codecMaxValues2.width);
        mediaFormat.setInteger("max-height", codecMaxValues2.height);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", codecMaxValues2.inputSize);
        if (Util.SDK_INT >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (z) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            configureTunnelingV21(mediaFormat, i);
        }
        return mediaFormat;
    }

    /* access modifiers changed from: protected */
    public CodecMaxValues getCodecMaxValues(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) {
        int codecMaxInputSize;
        int i = format.width;
        int i2 = format.height;
        int maxInputSize = getMaxInputSize(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            if (!(maxInputSize == -1 || (codecMaxInputSize = getCodecMaxInputSize(mediaCodecInfo, format.sampleMimeType, format.width, format.height)) == -1)) {
                maxInputSize = Math.min((int) (((float) maxInputSize) * 1.5f), codecMaxInputSize);
            }
            return new CodecMaxValues(i, i2, maxInputSize);
        }
        int i3 = i2;
        int i4 = maxInputSize;
        boolean z = false;
        int i5 = i;
        for (Format format2 : formatArr) {
            if (mediaCodecInfo.isSeamlessAdaptationSupported(format, format2, false)) {
                z |= format2.width == -1 || format2.height == -1;
                i5 = Math.max(i5, format2.width);
                i3 = Math.max(i3, format2.height);
                i4 = Math.max(i4, getMaxInputSize(mediaCodecInfo, format2));
            }
        }
        if (z) {
            Log.w("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + i5 + "x" + i3);
            Point codecMaxSize = getCodecMaxSize(mediaCodecInfo, format);
            if (codecMaxSize != null) {
                i5 = Math.max(i5, codecMaxSize.x);
                i3 = Math.max(i3, codecMaxSize.y);
                i4 = Math.max(i4, getCodecMaxInputSize(mediaCodecInfo, format.sampleMimeType, i5, i3));
                Log.w("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + i5 + "x" + i3);
            }
        }
        return new CodecMaxValues(i5, i3, i4);
    }

    public MediaCodecDecoderException createDecoderException(Throwable th, MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecVideoDecoderException(th, mediaCodecInfo, this.surface);
    }

    private static Point getCodecMaxSize(MediaCodecInfo mediaCodecInfo, Format format) {
        boolean z = format.height > format.width;
        int i = z ? format.height : format.width;
        int i2 = z ? format.width : format.height;
        float f = ((float) i2) / ((float) i);
        for (int i3 : STANDARD_LONG_EDGE_VIDEO_PX) {
            int i4 = (int) (((float) i3) * f);
            if (i3 <= i || i4 <= i2) {
                break;
            }
            if (Util.SDK_INT >= 21) {
                int i5 = z ? i4 : i3;
                if (!z) {
                    i3 = i4;
                }
                Point alignVideoSizeV21 = mediaCodecInfo.alignVideoSizeV21(i5, i3);
                if (mediaCodecInfo.isVideoSizeAndRateSupportedV21(alignVideoSizeV21.x, alignVideoSizeV21.y, (double) format.frameRate)) {
                    return alignVideoSizeV21;
                }
            } else {
                try {
                    int ceilDivide = Util.ceilDivide(i3, 16) * 16;
                    int ceilDivide2 = Util.ceilDivide(i4, 16) * 16;
                    if (ceilDivide * ceilDivide2 <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                        int i6 = z ? ceilDivide2 : ceilDivide;
                        if (!z) {
                            ceilDivide = ceilDivide2;
                        }
                        return new Point(i6, ceilDivide);
                    }
                } catch (MediaCodecUtil.DecoderQueryException unused) {
                }
            }
        }
        return null;
    }

    private static int getMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        if (format.maxInputSize == -1) {
            return getCodecMaxInputSize(mediaCodecInfo, format.sampleMimeType, format.width, format.height);
        }
        int size = format.initializationData.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += format.initializationData.get(i2).length;
        }
        return format.maxInputSize + i;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static int getCodecMaxInputSize(MediaCodecInfo mediaCodecInfo, String str, int i, int i2) {
        char c;
        int i3;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        int i4 = 4;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (!(c == 0 || c == 1)) {
            if (c != 2) {
                if (c != 3) {
                    if (c != 4 && c != 5) {
                        return -1;
                    }
                    i3 = i * i2;
                    return (i3 * 3) / (i4 * 2);
                }
            } else if ("BRAVIA 4K 2015".equals(Util.MODEL) || ("Amazon".equals(Util.MANUFACTURER) && ("KFSOWI".equals(Util.MODEL) || ("AFTS".equals(Util.MODEL) && mediaCodecInfo.secure)))) {
                return -1;
            } else {
                i3 = Util.ceilDivide(i, 16) * Util.ceilDivide(i2, 16) * 16 * 16;
                i4 = 2;
                return (i3 * 3) / (i4 * 2);
            }
        }
        i3 = i * i2;
        i4 = 2;
        return (i3 * 3) / (i4 * 2);
    }

    private static boolean deviceNeedsNoPostProcessWorkaround() {
        return "NVIDIA".equals(Util.MANUFACTURER);
    }

    /* access modifiers changed from: protected */
    public boolean codecNeedsSetOutputSurfaceWorkaround(String str) {
        char c;
        char c2 = 0;
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (MediaCodecVideoRenderer.class) {
            if (!evaluatedDeviceNeedsSetOutputSurfaceWorkaround) {
                if (!"dangal".equals(Util.DEVICE) && (Util.SDK_INT > 27 || !"HWEML".equals(Util.DEVICE))) {
                    if (Util.SDK_INT < 27) {
                        String str2 = Util.DEVICE;
                        switch (str2.hashCode()) {
                            case -2144781245:
                                if (str2.equals("GIONEE_SWW1609")) {
                                    c = '+';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -2144781185:
                                if (str2.equals("GIONEE_SWW1627")) {
                                    c = ',';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -2144781160:
                                if (str2.equals("GIONEE_SWW1631")) {
                                    c = '-';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -2097309513:
                                if (str2.equals("K50a40")) {
                                    c = '?';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -2022874474:
                                if (str2.equals("CP8676_I02")) {
                                    c = 19;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1978993182:
                                if (str2.equals("NX541J")) {
                                    c = 'M';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1978990237:
                                if (str2.equals("NX573J")) {
                                    c = 'N';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1936688988:
                                if (str2.equals("PGN528")) {
                                    c = 'X';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1936688066:
                                if (str2.equals("PGN610")) {
                                    c = 'Y';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1936688065:
                                if (str2.equals("PGN611")) {
                                    c = 'Z';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1931988508:
                                if (str2.equals("AquaPowerM")) {
                                    c = 11;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1696512866:
                                if (str2.equals("XT1663")) {
                                    c = '{';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1680025915:
                                if (str2.equals("ComioS1")) {
                                    c = 18;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1615810839:
                                if (str2.equals("Phantom6")) {
                                    c = '[';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1554255044:
                                if (str2.equals("vernee_M5")) {
                                    c = 't';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1481772737:
                                if (str2.equals("panell_dl")) {
                                    c = 'T';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1481772730:
                                if (str2.equals("panell_ds")) {
                                    c = 'U';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1481772729:
                                if (str2.equals("panell_dt")) {
                                    c = 'V';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1320080169:
                                if (str2.equals("GiONEE_GBL7319")) {
                                    c = ')';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1217592143:
                                if (str2.equals("BRAVIA_ATV2")) {
                                    c = 15;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1180384755:
                                if (str2.equals("iris60")) {
                                    c = ';';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1139198265:
                                if (str2.equals("Slate_Pro")) {
                                    c = 'h';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1052835013:
                                if (str2.equals("namath")) {
                                    c = 'K';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -993250464:
                                if (str2.equals("A10-70F")) {
                                    c = 3;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -993250458:
                                if (str2.equals("A10-70L")) {
                                    c = 4;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -965403638:
                                if (str2.equals("s905x018")) {
                                    c = 'j';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -958336948:
                                if (str2.equals("ELUGA_Ray_X")) {
                                    c = 29;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -879245230:
                                if (str2.equals("tcl_eu")) {
                                    c = 'p';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -842500323:
                                if (str2.equals("nicklaus_f")) {
                                    c = 'L';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -821392978:
                                if (str2.equals("A7000-a")) {
                                    c = 7;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -797483286:
                                if (str2.equals("SVP-DTV15")) {
                                    c = 'i';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -794946968:
                                if (str2.equals("watson")) {
                                    c = 'u';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -788334647:
                                if (str2.equals("whyred")) {
                                    c = 'v';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -782144577:
                                if (str2.equals("OnePlus5T")) {
                                    c = 'O';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -575125681:
                                if (str2.equals("GiONEE_CBL7513")) {
                                    c = '(';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -521118391:
                                if (str2.equals("GIONEE_GBL7360")) {
                                    c = '*';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -430914369:
                                if (str2.equals("Pixi4-7_3G")) {
                                    c = '\\';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -290434366:
                                if (str2.equals("taido_row")) {
                                    c = 'k';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -282781963:
                                if (str2.equals("BLACK-1X")) {
                                    c = 14;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -277133239:
                                if (str2.equals("Z12_PRO")) {
                                    c = '|';
                                    break;
                                }
                                c = 65535;
                                break;
                            case -173639913:
                                if (str2.equals("ELUGA_A3_Pro")) {
                                    c = 26;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -56598463:
                                if (str2.equals("woods_fn")) {
                                    c = 'x';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2126:
                                if (str2.equals("C1")) {
                                    c = 17;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2564:
                                if (str2.equals("Q5")) {
                                    c = 'd';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2715:
                                if (str2.equals("V1")) {
                                    c = 'q';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2719:
                                if (str2.equals("V5")) {
                                    c = 's';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 3483:
                                if (str2.equals("mh")) {
                                    c = 'H';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 73405:
                                if (str2.equals("JGZ")) {
                                    c = '>';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 75739:
                                if (str2.equals("M5c")) {
                                    c = 'D';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 76779:
                                if (str2.equals("MX6")) {
                                    c = 'J';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 78669:
                                if (str2.equals("P85")) {
                                    c = 'R';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 79305:
                                if (str2.equals("PLE")) {
                                    c = '^';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 80618:
                                if (str2.equals("QX1")) {
                                    c = 'f';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 88274:
                                if (str2.equals("Z80")) {
                                    c = '}';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 98846:
                                if (str2.equals("cv1")) {
                                    c = 22;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 98848:
                                if (str2.equals("cv3")) {
                                    c = 23;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 99329:
                                if (str2.equals("deb")) {
                                    c = 24;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 101481:
                                if (str2.equals("flo")) {
                                    c = '&';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1513190:
                                if (str2.equals("1601")) {
                                    c = 0;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1514184:
                                if (str2.equals("1713")) {
                                    c = 1;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1514185:
                                if (str2.equals("1714")) {
                                    c = 2;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2436959:
                                if (str2.equals("P681")) {
                                    c = 'Q';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2463773:
                                if (str2.equals("Q350")) {
                                    c = '`';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2464648:
                                if (str2.equals("Q427")) {
                                    c = 'b';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2689555:
                                if (str2.equals("XE2X")) {
                                    c = 'z';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 3154429:
                                if (str2.equals("fugu")) {
                                    c = '\'';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 3284551:
                                if (str2.equals("kate")) {
                                    c = '@';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 3351335:
                                if (str2.equals("mido")) {
                                    c = 'I';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 3386211:
                                if (str2.equals("p212")) {
                                    c = 'P';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 41325051:
                                if (str2.equals("MEIZU_M5")) {
                                    c = 'G';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 55178625:
                                if (str2.equals("Aura_Note_2")) {
                                    c = 13;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 61542055:
                                if (str2.equals("A1601")) {
                                    c = 5;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 65355429:
                                if (str2.equals("E5643")) {
                                    c = 25;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 66214468:
                                if (str2.equals("F3111")) {
                                    c = 31;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 66214470:
                                if (str2.equals("F3113")) {
                                    c = ' ';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 66214473:
                                if (str2.equals("F3116")) {
                                    c = '!';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 66215429:
                                if (str2.equals("F3211")) {
                                    c = '\"';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 66215431:
                                if (str2.equals("F3213")) {
                                    c = '#';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 66215433:
                                if (str2.equals("F3215")) {
                                    c = '$';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 66216390:
                                if (str2.equals("F3311")) {
                                    c = '%';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 76402249:
                                if (str2.equals("PRO7S")) {
                                    c = '_';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 76404105:
                                if (str2.equals("Q4260")) {
                                    c = 'a';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 76404911:
                                if (str2.equals("Q4310")) {
                                    c = 'c';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 80963634:
                                if (str2.equals("V23GB")) {
                                    c = 'r';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 82882791:
                                if (str2.equals("X3_HK")) {
                                    c = 'y';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 98715550:
                                if (str2.equals("i9031")) {
                                    c = '8';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 101370885:
                                if (str2.equals("l5460")) {
                                    c = 'A';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 102844228:
                                if (str2.equals("le_x6")) {
                                    c = 'B';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 165221241:
                                if (str2.equals("A2016a40")) {
                                    c = 6;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 182191441:
                                if (str2.equals("CPY83_I00")) {
                                    c = 21;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 245388979:
                                if (str2.equals("marino_f")) {
                                    c = 'F';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 287431619:
                                if (str2.equals("griffin")) {
                                    c = '1';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 307593612:
                                if (str2.equals("A7010a48")) {
                                    c = 9;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 308517133:
                                if (str2.equals("A7020a48")) {
                                    c = 10;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 316215098:
                                if (str2.equals("TB3-730F")) {
                                    c = 'l';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 316215116:
                                if (str2.equals("TB3-730X")) {
                                    c = 'm';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 316246811:
                                if (str2.equals("TB3-850F")) {
                                    c = 'n';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 316246818:
                                if (str2.equals("TB3-850M")) {
                                    c = 'o';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 407160593:
                                if (str2.equals("Pixi5-10_4G")) {
                                    c = ']';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 507412548:
                                if (str2.equals("QM16XE_U")) {
                                    c = 'e';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 793982701:
                                if (str2.equals("GIONEE_WBL5708")) {
                                    c = '.';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 794038622:
                                if (str2.equals("GIONEE_WBL7365")) {
                                    c = '/';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 794040393:
                                if (str2.equals("GIONEE_WBL7519")) {
                                    c = '0';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 835649806:
                                if (str2.equals("manning")) {
                                    c = 'E';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 917340916:
                                if (str2.equals("A7000plus")) {
                                    c = 8;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 958008161:
                                if (str2.equals("j2xlteins")) {
                                    c = '=';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1060579533:
                                if (str2.equals("panell_d")) {
                                    c = 'S';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1150207623:
                                if (str2.equals("LS-5017")) {
                                    c = 'C';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1176899427:
                                if (str2.equals("itel_S41")) {
                                    c = '<';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1280332038:
                                if (str2.equals("hwALE-H")) {
                                    c = '3';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1306947716:
                                if (str2.equals("EverStar_S")) {
                                    c = 30;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1349174697:
                                if (str2.equals("htc_e56ml_dtul")) {
                                    c = '2';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1522194893:
                                if (str2.equals("woods_f")) {
                                    c = 'w';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1691543273:
                                if (str2.equals("CPH1609")) {
                                    c = 20;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1709443163:
                                if (str2.equals("iball8735_9806")) {
                                    c = '9';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1865889110:
                                if (str2.equals("santoni")) {
                                    c = 'g';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1906253259:
                                if (str2.equals("PB2-670M")) {
                                    c = 'W';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1977196784:
                                if (str2.equals("Infinix-X572")) {
                                    c = ':';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2006372676:
                                if (str2.equals("BRAVIA_ATV3_4K")) {
                                    c = 16;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2029784656:
                                if (str2.equals("HWBLN-H")) {
                                    c = '4';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2030379515:
                                if (str2.equals("HWCAM-H")) {
                                    c = '5';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2033393791:
                                if (str2.equals("ASUS_X00AD_2")) {
                                    c = 12;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2047190025:
                                if (str2.equals("ELUGA_Note")) {
                                    c = 27;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2047252157:
                                if (str2.equals("ELUGA_Prim")) {
                                    c = 28;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2048319463:
                                if (str2.equals("HWVNS-H")) {
                                    c = '6';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2048855701:
                                if (str2.equals("HWWAS-H")) {
                                    c = '7';
                                    break;
                                }
                                c = 65535;
                                break;
                            default:
                                c = 65535;
                                break;
                        }
                        switch (c) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            case 9:
                            case 10:
                            case 11:
                            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            case 13:
                            case 14:
                            case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                            case 16:
                            case 17:
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case ' ':
                            case '!':
                            case '\"':
                            case '#':
                            case '$':
                            case '%':
                            case '&':
                            case '\'':
                            case '(':
                            case ')':
                            case '*':
                            case '+':
                            case ',':
                            case '-':
                            case '.':
                            case '/':
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                            case ':':
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                            case '?':
                            case '@':
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                            case 'G':
                            case 'H':
                            case 'I':
                            case 'J':
                            case 'K':
                            case 'L':
                            case 'M':
                            case 'N':
                            case 'O':
                            case 'P':
                            case 'Q':
                            case XiaomiOAuthConstants.VERSION_MINOR /*82*/:
                            case 'S':
                            case 'T':
                            case 'U':
                            case 'V':
                            case 'W':
                            case 'X':
                            case 'Y':
                            case 'Z':
                            case '[':
                            case '\\':
                            case ']':
                            case '^':
                            case '_':
                            case '`':
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                            case 'g':
                            case 'h':
                            case 'i':
                            case 'j':
                            case 'k':
                            case 'l':
                            case 'm':
                            case 'n':
                            case 'o':
                            case 'p':
                            case 'q':
                            case 'r':
                            case 's':
                            case 't':
                            case 'u':
                            case 'v':
                            case 'w':
                            case 'x':
                            case 'y':
                            case 'z':
                            case '{':
                            case '|':
                            case '}':
                                deviceNeedsSetOutputSurfaceWorkaround = true;
                                break;
                        }
                        String str3 = Util.MODEL;
                        int hashCode = str3.hashCode();
                        if (hashCode != -594534941) {
                            if (hashCode != 2006354) {
                                if (hashCode == 2006367) {
                                    if (str3.equals("AFTN")) {
                                        c2 = 1;
                                        if (!(c2 == 0 || c2 == 1 || c2 == 2)) {
                                        }
                                    }
                                }
                            } else if (str3.equals("AFTA")) {
                            }
                        } else if (str3.equals("JSN-L21")) {
                            c2 = 2;
                        }
                        c2 = 65535;
                    }
                    evaluatedDeviceNeedsSetOutputSurfaceWorkaround = true;
                }
                deviceNeedsSetOutputSurfaceWorkaround = true;
                evaluatedDeviceNeedsSetOutputSurfaceWorkaround = true;
            }
        }
        return deviceNeedsSetOutputSurfaceWorkaround;
    }

    /* access modifiers changed from: protected */
    public Surface getSurface() {
        return this.surface;
    }

    public static final class CodecMaxValues {
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.inputSize = i3;
        }
    }

    final class OnFrameRenderedListenerV23 implements MediaCodec.OnFrameRenderedListener, Handler.Callback {
        private final Handler handler = Util.createHandler(this);

        public OnFrameRenderedListenerV23(MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, this.handler);
        }

        public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
            if (Util.SDK_INT < 30) {
                this.handler.sendMessageAtFrontOfQueue(Message.obtain(this.handler, 0, (int) (j >> 32), (int) j));
                return;
            }
            handleFrameRendered(j);
        }

        public final boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            handleFrameRendered(Util.toLong(message.arg1, message.arg2));
            return true;
        }

        private void handleFrameRendered(long j) {
            if (this == MediaCodecVideoRenderer.this.tunnelingOnFrameRenderedListener) {
                if (j == Long.MAX_VALUE) {
                    MediaCodecVideoRenderer.this.onProcessedTunneledEndOfStream();
                } else {
                    MediaCodecVideoRenderer.this.onProcessedTunneledBuffer(j);
                }
            }
        }
    }
}
