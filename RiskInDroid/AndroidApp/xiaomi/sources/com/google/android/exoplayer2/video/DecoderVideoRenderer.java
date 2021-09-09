package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.Decoder;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.TimedValueQueue;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.video.VideoRendererEventListener;

public abstract class DecoderVideoRenderer extends BaseRenderer {
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private int consecutiveDroppedFrameCount;
    private Decoder<VideoDecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> decoder;
    protected DecoderCounters decoderCounters;
    private DrmSession decoderDrmSession;
    private boolean decoderReceivedBuffers;
    private int decoderReinitializationState;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;
    private final DecoderInputBuffer flagsOnlyBuffer;
    private final TimedValueQueue<Format> formatQueue;
    private VideoFrameMetadataListener frameMetadataListener;
    private long initialPositionUs;
    private VideoDecoderInputBuffer inputBuffer;
    private Format inputFormat;
    private boolean inputStreamEnded;
    private long joiningDeadlineMs = -9223372036854775807L;
    private long lastRenderTimeUs;
    private final int maxDroppedFramesToNotify;
    private boolean mayRenderFirstFrameAfterEnableIfNotStarted;
    private VideoDecoderOutputBuffer outputBuffer;
    private VideoDecoderOutputBufferRenderer outputBufferRenderer;
    private Format outputFormat;
    private int outputMode;
    private boolean outputStreamEnded;
    private long outputStreamOffsetUs;
    private boolean renderedFirstFrameAfterEnable;
    private boolean renderedFirstFrameAfterReset;
    private int reportedHeight;
    private int reportedWidth;
    private DrmSession sourceDrmSession;
    private Surface surface;
    private boolean waitingForFirstSampleInFormat;
    private boolean waitingForKeys;

    private static boolean isBufferLate(long j) {
        return j < -30000;
    }

    private static boolean isBufferVeryLate(long j) {
        return j < -500000;
    }

    /* access modifiers changed from: protected */
    public abstract Decoder<VideoDecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> createDecoder(Format format, ExoMediaCrypto exoMediaCrypto) throws DecoderException;

    /* access modifiers changed from: protected */
    public void onQueueInputBuffer(VideoDecoderInputBuffer videoDecoderInputBuffer) {
    }

    /* access modifiers changed from: protected */
    public abstract void renderOutputBufferToSurface(VideoDecoderOutputBuffer videoDecoderOutputBuffer, Surface surface2) throws DecoderException;

    /* access modifiers changed from: protected */
    public abstract void setDecoderOutputMode(int i);

    protected DecoderVideoRenderer(long j, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        super(2);
        this.allowedJoiningTimeMs = j;
        this.maxDroppedFramesToNotify = i;
        clearReportedVideoSize();
        this.formatQueue = new TimedValueQueue<>();
        this.flagsOnlyBuffer = DecoderInputBuffer.newFlagsOnlyInstance();
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.decoderReinitializationState = 0;
        this.outputMode = -1;
    }

    public void render(long j, long j2) throws ExoPlaybackException {
        if (!this.outputStreamEnded) {
            if (this.inputFormat == null) {
                FormatHolder formatHolder = getFormatHolder();
                this.flagsOnlyBuffer.clear();
                int readSource = readSource(formatHolder, this.flagsOnlyBuffer, true);
                if (readSource == -5) {
                    onInputFormatChanged(formatHolder);
                } else if (readSource == -4) {
                    Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
                    this.inputStreamEnded = true;
                    this.outputStreamEnded = true;
                    return;
                } else {
                    return;
                }
            }
            maybeInitDecoder();
            if (this.decoder != null) {
                try {
                    TraceUtil.beginSection("drainAndFeed");
                    do {
                    } while (drainOutputBuffer(j, j2));
                    do {
                    } while (feedInputBuffer());
                    TraceUtil.endSection();
                    this.decoderCounters.ensureUpdated();
                } catch (DecoderException e) {
                    throw createRendererException(e, this.inputFormat);
                }
            }
        }
    }

    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    public boolean isReady() {
        if (this.waitingForKeys) {
            return false;
        }
        if (this.inputFormat != null && ((isSourceReady() || this.outputBuffer != null) && (this.renderedFirstFrameAfterReset || !hasOutput()))) {
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

    public void handleMessage(int i, Object obj) throws ExoPlaybackException {
        if (i == 1) {
            setOutputSurface((Surface) obj);
        } else if (i == 8) {
            setOutputBufferRenderer((VideoDecoderOutputBufferRenderer) obj);
        } else if (i == 6) {
            this.frameMetadataListener = (VideoFrameMetadataListener) obj;
        } else {
            super.handleMessage(i, obj);
        }
    }

    public void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
        this.decoderCounters = new DecoderCounters();
        this.eventDispatcher.enabled(this.decoderCounters);
        this.mayRenderFirstFrameAfterEnableIfNotStarted = z2;
        this.renderedFirstFrameAfterEnable = false;
    }

    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        clearRenderedFirstFrame();
        this.initialPositionUs = -9223372036854775807L;
        this.consecutiveDroppedFrameCount = 0;
        if (this.decoder != null) {
            flushDecoder();
        }
        if (z) {
            setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = -9223372036854775807L;
        }
        this.formatQueue.clear();
    }

    public void onStarted() {
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
    }

    public void onStopped() {
        this.joiningDeadlineMs = -9223372036854775807L;
        maybeNotifyDroppedFrames();
    }

    public void onDisabled() {
        this.inputFormat = null;
        this.waitingForKeys = false;
        clearReportedVideoSize();
        clearRenderedFirstFrame();
        try {
            setSourceDrmSession(null);
            releaseDecoder();
        } finally {
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    public void onStreamChanged(Format[] formatArr, long j) throws ExoPlaybackException {
        this.outputStreamOffsetUs = j;
        super.onStreamChanged(formatArr, j);
    }

    /* access modifiers changed from: protected */
    public void onDecoderInitialized(String str, long j, long j2) {
        this.eventDispatcher.decoderInitialized(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public void flushDecoder() throws ExoPlaybackException {
        this.waitingForKeys = false;
        this.buffersInCodecCount = 0;
        if (this.decoderReinitializationState != 0) {
            releaseDecoder();
            maybeInitDecoder();
            return;
        }
        this.inputBuffer = null;
        VideoDecoderOutputBuffer videoDecoderOutputBuffer = this.outputBuffer;
        if (videoDecoderOutputBuffer != null) {
            videoDecoderOutputBuffer.release();
            this.outputBuffer = null;
        }
        this.decoder.flush();
        this.decoderReceivedBuffers = false;
    }

    /* access modifiers changed from: protected */
    public void releaseDecoder() {
        this.inputBuffer = null;
        this.outputBuffer = null;
        this.decoderReinitializationState = 0;
        this.decoderReceivedBuffers = false;
        this.buffersInCodecCount = 0;
        Decoder<VideoDecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> decoder2 = this.decoder;
        if (decoder2 != null) {
            decoder2.release();
            this.decoder = null;
            this.decoderCounters.decoderReleaseCount++;
        }
        setDecoderDrmSession(null);
    }

    /* access modifiers changed from: protected */
    public void onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
        this.waitingForFirstSampleInFormat = true;
        setSourceDrmSession(formatHolder.drmSession);
        this.inputFormat = (Format) Assertions.checkNotNull(formatHolder.format);
        if (this.sourceDrmSession != this.decoderDrmSession) {
            if (this.decoderReceivedBuffers) {
                this.decoderReinitializationState = 1;
            } else {
                releaseDecoder();
                maybeInitDecoder();
            }
        }
        this.eventDispatcher.inputFormatChanged(this.inputFormat);
    }

    /* access modifiers changed from: protected */
    public void onProcessedOutputBuffer(long j) {
        this.buffersInCodecCount--;
    }

    /* access modifiers changed from: protected */
    public boolean shouldDropOutputBuffer(long j, long j2) {
        return isBufferLate(j);
    }

    /* access modifiers changed from: protected */
    public boolean shouldDropBuffersToKeyframe(long j, long j2) {
        return isBufferVeryLate(j);
    }

    /* access modifiers changed from: protected */
    public boolean shouldForceRenderOutputBuffer(long j, long j2) {
        return isBufferLate(j) && j2 > 100000;
    }

    /* access modifiers changed from: protected */
    public void skipOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        this.decoderCounters.skippedOutputBufferCount++;
        videoDecoderOutputBuffer.release();
    }

    /* access modifiers changed from: protected */
    public void dropOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        updateDroppedBufferCounters(1);
        videoDecoderOutputBuffer.release();
    }

    /* access modifiers changed from: protected */
    public boolean maybeDropBuffersToKeyframe(long j) throws ExoPlaybackException {
        int skipSource = skipSource(j);
        if (skipSource == 0) {
            return false;
        }
        this.decoderCounters.droppedToKeyframeCount++;
        updateDroppedBufferCounters(this.buffersInCodecCount + skipSource);
        flushDecoder();
        return true;
    }

    /* access modifiers changed from: protected */
    public void updateDroppedBufferCounters(int i) {
        this.decoderCounters.droppedBufferCount += i;
        this.droppedFrames += i;
        this.consecutiveDroppedFrameCount += i;
        DecoderCounters decoderCounters2 = this.decoderCounters;
        decoderCounters2.maxConsecutiveDroppedBufferCount = Math.max(this.consecutiveDroppedFrameCount, decoderCounters2.maxConsecutiveDroppedBufferCount);
        int i2 = this.maxDroppedFramesToNotify;
        if (i2 > 0 && this.droppedFrames >= i2) {
            maybeNotifyDroppedFrames();
        }
    }

    /* access modifiers changed from: protected */
    public void renderOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer, long j, Format format) throws DecoderException {
        VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j, System.nanoTime(), format, null);
        }
        this.lastRenderTimeUs = C.msToUs(SystemClock.elapsedRealtime() * 1000);
        int i = videoDecoderOutputBuffer.mode;
        boolean z = i == 1 && this.surface != null;
        boolean z2 = i == 0 && this.outputBufferRenderer != null;
        if (z2 || z) {
            maybeNotifyVideoSizeChanged(videoDecoderOutputBuffer.width, videoDecoderOutputBuffer.height);
            if (z2) {
                this.outputBufferRenderer.setOutputBuffer(videoDecoderOutputBuffer);
            } else {
                renderOutputBufferToSurface(videoDecoderOutputBuffer, this.surface);
            }
            this.consecutiveDroppedFrameCount = 0;
            this.decoderCounters.renderedOutputBufferCount++;
            maybeNotifyRenderedFirstFrame();
            return;
        }
        dropOutputBuffer(videoDecoderOutputBuffer);
    }

    /* access modifiers changed from: protected */
    public final void setOutputSurface(Surface surface2) {
        if (this.surface != surface2) {
            this.surface = surface2;
            if (surface2 != null) {
                this.outputBufferRenderer = null;
                this.outputMode = 1;
                if (this.decoder != null) {
                    setDecoderOutputMode(this.outputMode);
                }
                onOutputChanged();
                return;
            }
            this.outputMode = -1;
            onOutputRemoved();
        } else if (surface2 != null) {
            onOutputReset();
        }
    }

    /* access modifiers changed from: protected */
    public final void setOutputBufferRenderer(VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer) {
        if (this.outputBufferRenderer != videoDecoderOutputBufferRenderer) {
            this.outputBufferRenderer = videoDecoderOutputBufferRenderer;
            if (videoDecoderOutputBufferRenderer != null) {
                this.surface = null;
                this.outputMode = 0;
                if (this.decoder != null) {
                    setDecoderOutputMode(this.outputMode);
                }
                onOutputChanged();
                return;
            }
            this.outputMode = -1;
            onOutputRemoved();
        } else if (videoDecoderOutputBufferRenderer != null) {
            onOutputReset();
        }
    }

    private void setSourceDrmSession(DrmSession drmSession) {
        DrmSession.CC.replaceSession(this.sourceDrmSession, drmSession);
        this.sourceDrmSession = drmSession;
    }

    private void setDecoderDrmSession(DrmSession drmSession) {
        DrmSession.CC.replaceSession(this.decoderDrmSession, drmSession);
        this.decoderDrmSession = drmSession;
    }

    private void maybeInitDecoder() throws ExoPlaybackException {
        if (this.decoder == null) {
            setDecoderDrmSession(this.sourceDrmSession);
            ExoMediaCrypto exoMediaCrypto = null;
            DrmSession drmSession = this.decoderDrmSession;
            if (drmSession == null || (exoMediaCrypto = drmSession.getMediaCrypto()) != null || this.decoderDrmSession.getError() != null) {
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    this.decoder = createDecoder(this.inputFormat, exoMediaCrypto);
                    setDecoderOutputMode(this.outputMode);
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    onDecoderInitialized(this.decoder.getName(), elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                    this.decoderCounters.decoderInitCount++;
                } catch (DecoderException e) {
                    throw createRendererException(e, this.inputFormat);
                }
            }
        }
    }

    private boolean feedInputBuffer() throws DecoderException, ExoPlaybackException {
        int i;
        Decoder<VideoDecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> decoder2 = this.decoder;
        if (decoder2 == null || this.decoderReinitializationState == 2 || this.inputStreamEnded) {
            return false;
        }
        if (this.inputBuffer == null) {
            this.inputBuffer = decoder2.dequeueInputBuffer();
            if (this.inputBuffer == null) {
                return false;
            }
        }
        if (this.decoderReinitializationState == 1) {
            this.inputBuffer.setFlags(4);
            this.decoder.queueInputBuffer(this.inputBuffer);
            this.inputBuffer = null;
            this.decoderReinitializationState = 2;
            return false;
        }
        FormatHolder formatHolder = getFormatHolder();
        if (this.waitingForKeys) {
            i = -4;
        } else {
            i = readSource(formatHolder, this.inputBuffer, false);
        }
        if (i == -3) {
            return false;
        }
        if (i == -5) {
            onInputFormatChanged(formatHolder);
            return true;
        } else if (this.inputBuffer.isEndOfStream()) {
            this.inputStreamEnded = true;
            this.decoder.queueInputBuffer(this.inputBuffer);
            this.inputBuffer = null;
            return false;
        } else {
            this.waitingForKeys = shouldWaitForKeys(this.inputBuffer.isEncrypted());
            if (this.waitingForKeys) {
                return false;
            }
            if (this.waitingForFirstSampleInFormat) {
                this.formatQueue.add(this.inputBuffer.timeUs, this.inputFormat);
                this.waitingForFirstSampleInFormat = false;
            }
            this.inputBuffer.flip();
            this.inputBuffer.colorInfo = this.inputFormat.colorInfo;
            onQueueInputBuffer(this.inputBuffer);
            this.decoder.queueInputBuffer(this.inputBuffer);
            this.buffersInCodecCount++;
            this.decoderReceivedBuffers = true;
            this.decoderCounters.inputBufferCount++;
            this.inputBuffer = null;
            return true;
        }
    }

    private boolean drainOutputBuffer(long j, long j2) throws ExoPlaybackException, DecoderException {
        if (this.outputBuffer == null) {
            this.outputBuffer = (VideoDecoderOutputBuffer) this.decoder.dequeueOutputBuffer();
            if (this.outputBuffer == null) {
                return false;
            }
            this.decoderCounters.skippedOutputBufferCount += this.outputBuffer.skippedOutputBufferCount;
            this.buffersInCodecCount -= this.outputBuffer.skippedOutputBufferCount;
        }
        if (this.outputBuffer.isEndOfStream()) {
            if (this.decoderReinitializationState == 2) {
                releaseDecoder();
                maybeInitDecoder();
            } else {
                this.outputBuffer.release();
                this.outputBuffer = null;
                this.outputStreamEnded = true;
            }
            return false;
        }
        boolean processOutputBuffer = processOutputBuffer(j, j2);
        if (processOutputBuffer) {
            onProcessedOutputBuffer(this.outputBuffer.timeUs);
            this.outputBuffer = null;
        }
        return processOutputBuffer;
    }

    private boolean processOutputBuffer(long j, long j2) throws ExoPlaybackException, DecoderException {
        if (this.initialPositionUs == -9223372036854775807L) {
            this.initialPositionUs = j;
        }
        long j3 = this.outputBuffer.timeUs - j;
        if (hasOutput()) {
            long j4 = this.outputBuffer.timeUs - this.outputStreamOffsetUs;
            Format pollFloor = this.formatQueue.pollFloor(j4);
            if (pollFloor != null) {
                this.outputFormat = pollFloor;
            }
            long elapsedRealtime = (SystemClock.elapsedRealtime() * 1000) - this.lastRenderTimeUs;
            boolean z = getState() == 2;
            if ((this.renderedFirstFrameAfterEnable ? !this.renderedFirstFrameAfterReset : !(!z && !this.mayRenderFirstFrameAfterEnableIfNotStarted)) || (z && shouldForceRenderOutputBuffer(j3, elapsedRealtime))) {
                renderOutputBuffer(this.outputBuffer, j4, this.outputFormat);
                return true;
            } else if (!z || j == this.initialPositionUs || (shouldDropBuffersToKeyframe(j3, j2) && maybeDropBuffersToKeyframe(j))) {
                return false;
            } else {
                if (shouldDropOutputBuffer(j3, j2)) {
                    dropOutputBuffer(this.outputBuffer);
                    return true;
                }
                if (j3 < DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS) {
                    renderOutputBuffer(this.outputBuffer, j4, this.outputFormat);
                    return true;
                }
                return false;
            }
        } else if (!isBufferLate(j3)) {
            return false;
        } else {
            skipOutputBuffer(this.outputBuffer);
            return true;
        }
    }

    private boolean hasOutput() {
        return this.outputMode != -1;
    }

    private void onOutputChanged() {
        maybeRenotifyVideoSizeChanged();
        clearRenderedFirstFrame();
        if (getState() == 2) {
            setJoiningDeadlineMs();
        }
    }

    private void onOutputRemoved() {
        clearReportedVideoSize();
        clearRenderedFirstFrame();
    }

    private void onOutputReset() {
        maybeRenotifyVideoSizeChanged();
        maybeRenotifyRenderedFirstFrame();
    }

    private boolean shouldWaitForKeys(boolean z) throws ExoPlaybackException {
        DrmSession drmSession = this.decoderDrmSession;
        if (drmSession == null || (!z && drmSession.playClearSamplesWithoutKeys())) {
            return false;
        }
        int state = drmSession.getState();
        if (state == 1) {
            throw createRendererException(drmSession.getError(), this.inputFormat);
        } else if (state != 4) {
            return true;
        } else {
            return false;
        }
    }

    private void setJoiningDeadlineMs() {
        this.joiningDeadlineMs = this.allowedJoiningTimeMs > 0 ? SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs : -9223372036854775807L;
    }

    private void clearRenderedFirstFrame() {
        this.renderedFirstFrameAfterReset = false;
    }

    private void maybeNotifyRenderedFirstFrame() {
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
    }

    private void maybeNotifyVideoSizeChanged(int i, int i2) {
        if (this.reportedWidth != i || this.reportedHeight != i2) {
            this.reportedWidth = i;
            this.reportedHeight = i2;
            this.eventDispatcher.videoSizeChanged(i, i2, 0, 1.0f);
        }
    }

    private void maybeRenotifyVideoSizeChanged() {
        if (this.reportedWidth != -1 || this.reportedHeight != -1) {
            this.eventDispatcher.videoSizeChanged(this.reportedWidth, this.reportedHeight, 0, 1.0f);
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
}
