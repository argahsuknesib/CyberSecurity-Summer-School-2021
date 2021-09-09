package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.TimedValueQueue;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public abstract class MediaCodecRenderer extends BaseRenderer {
    private static final byte[] ADAPTATION_WORKAROUND_BUFFER = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    private final float assumedMinimumCodecOperatingRate;
    private ArrayDeque<MediaCodecInfo> availableCodecInfos;
    private final DecoderInputBuffer buffer = new DecoderInputBuffer(0);
    private MediaCodec codec;
    private int codecAdaptationWorkaroundMode;
    private MediaCodecAdapter codecAdapter;
    private int codecDrainAction;
    private int codecDrainState;
    private DrmSession codecDrmSession;
    private Format codecFormat;
    private boolean codecHasOutputMediaFormat;
    private long codecHotswapDeadlineMs;
    private MediaCodecInfo codecInfo;
    private boolean codecNeedsAdaptationWorkaroundBuffer;
    private boolean codecNeedsDiscardToSpsWorkaround;
    private boolean codecNeedsEosFlushWorkaround;
    private boolean codecNeedsEosOutputExceptionWorkaround;
    private boolean codecNeedsEosPropagation;
    private boolean codecNeedsFlushWorkaround;
    private boolean codecNeedsMonoChannelCountWorkaround;
    private boolean codecNeedsReconfigureWorkaround;
    private boolean codecNeedsSosFlushWorkaround;
    private float codecOperatingRate;
    private boolean codecReceivedBuffers;
    private boolean codecReceivedEos;
    private int codecReconfigurationState;
    private boolean codecReconfigured;
    private final ArrayList<Long> decodeOnlyPresentationTimestamps = new ArrayList<>();
    protected DecoderCounters decoderCounters;
    private final boolean enableDecoderFallback;
    private final DecoderInputBuffer flagsOnlyBuffer = DecoderInputBuffer.newFlagsOnlyInstance();
    private final TimedValueQueue<Format> formatQueue = new TimedValueQueue<>();
    private ByteBuffer[] inputBuffers;
    private Format inputFormat;
    private int inputIndex;
    private boolean inputStreamEnded;
    private boolean isDecodeOnlyOutputBuffer;
    private boolean isLastOutputBuffer;
    private long largestQueuedPresentationTimeUs;
    private long lastBufferInStreamPresentationTimeUs;
    private int mediaCodecOperationMode = 0;
    private final MediaCodecSelector mediaCodecSelector;
    private MediaCrypto mediaCrypto;
    private boolean mediaCryptoRequiresSecureDecoder;
    private ByteBuffer outputBuffer;
    private final MediaCodec.BufferInfo outputBufferInfo = new MediaCodec.BufferInfo();
    private ByteBuffer[] outputBuffers;
    private Format outputFormat;
    private int outputIndex;
    private boolean outputStreamEnded;
    private long outputStreamOffsetUs = -9223372036854775807L;
    private boolean pendingOutputEndOfStream;
    private int pendingOutputStreamOffsetCount;
    private final long[] pendingOutputStreamOffsetsUs = new long[10];
    private final long[] pendingOutputStreamSwitchTimesUs = new long[10];
    private DecoderInitializationException preferredDecoderInitializationException;
    private long renderTimeLimitMs = -9223372036854775807L;
    private float rendererOperatingRate = 1.0f;
    private boolean shouldSkipAdaptationWorkaroundOutputBuffer;
    private DrmSession sourceDrmSession;
    private boolean waitingForFirstSampleInFormat;
    private boolean waitingForFirstSyncSample;
    private boolean waitingForKeys;

    @Documented
    @Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaCodecOperationMode {
    }

    /* access modifiers changed from: protected */
    public int canKeepCodec(MediaCodec mediaCodec, MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public abstract void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto2, float f);

    /* access modifiers changed from: protected */
    public boolean getCodecNeedsEosPropagation() {
        return false;
    }

    /* access modifiers changed from: protected */
    public float getCodecOperatingRateV23(float f, Format format, Format[] formatArr) {
        return -1.0f;
    }

    /* access modifiers changed from: protected */
    public abstract List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector2, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException;

    /* access modifiers changed from: protected */
    public void handleInputBufferSupplementalData(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void onCodecInitialized(String str, long j, long j2) {
    }

    /* access modifiers changed from: protected */
    public void onOutputMediaFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void onProcessedStreamChange() {
    }

    /* access modifiers changed from: protected */
    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
    }

    public void onStarted() {
    }

    public void onStopped() {
    }

    /* access modifiers changed from: protected */
    public abstract boolean processOutputBuffer(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, Format format) throws ExoPlaybackException;

    /* access modifiers changed from: protected */
    public void renderToEndOfStream() throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract int supportsFormat(MediaCodecSelector mediaCodecSelector2, Format format) throws MediaCodecUtil.DecoderQueryException;

    public final int supportsMixedMimeTypeAdaptation() {
        return 8;
    }

    public static class DecoderInitializationException extends Exception {
        public final MediaCodecInfo codecInfo;
        public final String diagnosticInfo;
        public final DecoderInitializationException fallbackDecoderInitializationException;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        public DecoderInitializationException(Format format, Throwable th, boolean z, int i) {
            this("Decoder init failed: [" + i + "], " + format, th, format.sampleMimeType, z, null, buildCustomDiagnosticInfo(i), null);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        public DecoderInitializationException(Format format, Throwable th, boolean z, MediaCodecInfo mediaCodecInfo) {
            this(r3, th, r5, z, mediaCodecInfo, r11, null);
            String str;
            String str2 = "Decoder init failed: " + mediaCodecInfo.name + ", " + format;
            String str3 = format.sampleMimeType;
            if (Util.SDK_INT >= 21) {
                str = getDiagnosticInfoV21(th);
            } else {
                str = null;
            }
        }

        private DecoderInitializationException(String str, Throwable th, String str2, boolean z, MediaCodecInfo mediaCodecInfo, String str3, DecoderInitializationException decoderInitializationException) {
            super(str, th);
            this.mimeType = str2;
            this.secureDecoderRequired = z;
            this.codecInfo = mediaCodecInfo;
            this.diagnosticInfo = str3;
            this.fallbackDecoderInitializationException = decoderInitializationException;
        }

        public DecoderInitializationException copyWithFallbackException(DecoderInitializationException decoderInitializationException) {
            return new DecoderInitializationException(getMessage(), getCause(), this.mimeType, this.secureDecoderRequired, this.codecInfo, this.diagnosticInfo, decoderInitializationException);
        }

        private static String getDiagnosticInfoV21(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        private static String buildCustomDiagnosticInfo(int i) {
            String str = i < 0 ? "neg_" : "";
            return "com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_" + str + Math.abs(i);
        }
    }

    public MediaCodecRenderer(int i, MediaCodecSelector mediaCodecSelector2, boolean z, float f) {
        super(i);
        this.mediaCodecSelector = (MediaCodecSelector) Assertions.checkNotNull(mediaCodecSelector2);
        this.enableDecoderFallback = z;
        this.assumedMinimumCodecOperatingRate = f;
        resetCodecStateForRelease();
    }

    public void experimental_setRenderTimeLimitMs(long j) {
        this.renderTimeLimitMs = j;
    }

    public void experimental_setMediaCodecOperationMode(int i) {
        this.mediaCodecOperationMode = i;
    }

    public final int supportsFormat(Format format) throws ExoPlaybackException {
        try {
            return supportsFormat(this.mediaCodecSelector, format);
        } catch (MediaCodecUtil.DecoderQueryException e) {
            throw createRendererException(e, format);
        }
    }

    /* access modifiers changed from: protected */
    public final void maybeInitCodec() throws ExoPlaybackException {
        if (this.codec == null && this.inputFormat != null) {
            setCodecDrmSession(this.sourceDrmSession);
            String str = this.inputFormat.sampleMimeType;
            DrmSession drmSession = this.codecDrmSession;
            if (drmSession != null) {
                if (this.mediaCrypto == null) {
                    FrameworkMediaCrypto frameworkMediaCrypto = getFrameworkMediaCrypto(drmSession);
                    if (frameworkMediaCrypto != null) {
                        try {
                            this.mediaCrypto = new MediaCrypto(frameworkMediaCrypto.uuid, frameworkMediaCrypto.sessionId);
                            this.mediaCryptoRequiresSecureDecoder = !frameworkMediaCrypto.forceAllowInsecureDecoderComponents && this.mediaCrypto.requiresSecureDecoderComponent(str);
                        } catch (MediaCryptoException e) {
                            throw createRendererException(e, this.inputFormat);
                        }
                    } else if (this.codecDrmSession.getError() == null) {
                        return;
                    }
                }
                if (FrameworkMediaCrypto.WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC) {
                    int state = this.codecDrmSession.getState();
                    if (state == 1) {
                        throw createRendererException(this.codecDrmSession.getError(), this.inputFormat);
                    } else if (state != 4) {
                        return;
                    }
                }
            }
            try {
                maybeInitCodecWithFallback(this.mediaCrypto, this.mediaCryptoRequiresSecureDecoder);
            } catch (DecoderInitializationException e2) {
                throw createRendererException(e2, this.inputFormat);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Format updateOutputFormatForTime(long j) {
        Format pollFloor = this.formatQueue.pollFloor(j);
        if (pollFloor != null) {
            this.outputFormat = pollFloor;
        }
        return pollFloor;
    }

    /* access modifiers changed from: protected */
    public final Format getCurrentOutputFormat() {
        return this.outputFormat;
    }

    /* access modifiers changed from: protected */
    public final MediaCodec getCodec() {
        return this.codec;
    }

    /* access modifiers changed from: protected */
    public final MediaCodecInfo getCodecInfo() {
        return this.codecInfo;
    }

    public void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
        this.decoderCounters = new DecoderCounters();
    }

    public void onStreamChanged(Format[] formatArr, long j) throws ExoPlaybackException {
        if (this.outputStreamOffsetUs == -9223372036854775807L) {
            this.outputStreamOffsetUs = j;
            return;
        }
        int i = this.pendingOutputStreamOffsetCount;
        if (i == this.pendingOutputStreamOffsetsUs.length) {
            Log.w("MediaCodecRenderer", "Too many stream changes, so dropping offset: " + this.pendingOutputStreamOffsetsUs[this.pendingOutputStreamOffsetCount - 1]);
        } else {
            this.pendingOutputStreamOffsetCount = i + 1;
        }
        long[] jArr = this.pendingOutputStreamOffsetsUs;
        int i2 = this.pendingOutputStreamOffsetCount;
        jArr[i2 - 1] = j;
        this.pendingOutputStreamSwitchTimesUs[i2 - 1] = this.largestQueuedPresentationTimeUs;
    }

    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        this.pendingOutputEndOfStream = false;
        flushOrReinitializeCodec();
        if (this.formatQueue.size() > 0) {
            this.waitingForFirstSampleInFormat = true;
        }
        this.formatQueue.clear();
        int i = this.pendingOutputStreamOffsetCount;
        if (i != 0) {
            this.outputStreamOffsetUs = this.pendingOutputStreamOffsetsUs[i - 1];
            this.pendingOutputStreamOffsetCount = 0;
        }
    }

    public final void setOperatingRate(float f) throws ExoPlaybackException {
        this.rendererOperatingRate = f;
        if (this.codec != null && this.codecDrainAction != 3 && getState() != 0) {
            updateCodecOperatingRate();
        }
    }

    public void onDisabled() {
        this.inputFormat = null;
        this.outputStreamOffsetUs = -9223372036854775807L;
        this.pendingOutputStreamOffsetCount = 0;
        if (this.sourceDrmSession == null && this.codecDrmSession == null) {
            flushOrReleaseCodec();
        } else {
            onReset();
        }
    }

    public void onReset() {
        try {
            releaseCodec();
        } finally {
            setSourceDrmSession(null);
        }
    }

    /* access modifiers changed from: protected */
    public void releaseCodec() {
        try {
            if (this.codecAdapter != null) {
                this.codecAdapter.shutdown();
            }
            if (this.codec != null) {
                this.decoderCounters.decoderReleaseCount++;
                this.codec.release();
            }
            this.codec = null;
            this.codecAdapter = null;
            try {
                if (this.mediaCrypto != null) {
                    this.mediaCrypto.release();
                }
            } finally {
                this.mediaCrypto = null;
                setCodecDrmSession(null);
                resetCodecStateForRelease();
            }
        } catch (Throwable th) {
            this.codec = null;
            this.codecAdapter = null;
            if (this.mediaCrypto != null) {
                this.mediaCrypto.release();
            }
            throw th;
        } finally {
            this.mediaCrypto = null;
            setCodecDrmSession(null);
            resetCodecStateForRelease();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034 A[Catch:{ IllegalStateException -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0040 A[Catch:{ IllegalStateException -> 0x005e }] */
    public void render(long j, long j2) throws ExoPlaybackException {
        if (this.pendingOutputEndOfStream) {
            this.pendingOutputEndOfStream = false;
            processEndOfStream();
        }
        try {
            if (this.outputStreamEnded) {
                renderToEndOfStream();
            } else if (this.inputFormat != null || readToFlagsOnlyBuffer(true)) {
                maybeInitCodec();
                if (this.codec != null) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    TraceUtil.beginSection("drainAndFeed");
                    while (drainOutputBuffer(j, j2) && shouldContinueRendering(elapsedRealtime)) {
                        while (drainOutputBuffer(j, j2)) {
                            while (drainOutputBuffer(j, j2)) {
                            }
                        }
                    }
                    while (feedInputBuffer() && shouldContinueRendering(elapsedRealtime)) {
                        while (feedInputBuffer()) {
                            while (feedInputBuffer()) {
                            }
                        }
                    }
                    TraceUtil.endSection();
                } else {
                    this.decoderCounters.skippedInputBufferCount += skipSource(j);
                    readToFlagsOnlyBuffer(false);
                }
                this.decoderCounters.ensureUpdated();
            }
        } catch (IllegalStateException e) {
            if (isMediaCodecException(e)) {
                throw createRendererException(e, this.inputFormat);
            }
            throw e;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean flushOrReinitializeCodec() throws ExoPlaybackException {
        boolean flushOrReleaseCodec = flushOrReleaseCodec();
        if (flushOrReleaseCodec) {
            maybeInitCodec();
        }
        return flushOrReleaseCodec;
    }

    /* access modifiers changed from: protected */
    public boolean flushOrReleaseCodec() {
        if (this.codec == null) {
            return false;
        }
        if (this.codecDrainAction == 3 || this.codecNeedsFlushWorkaround || ((this.codecNeedsSosFlushWorkaround && !this.codecHasOutputMediaFormat) || (this.codecNeedsEosFlushWorkaround && this.codecReceivedEos))) {
            releaseCodec();
            return true;
        }
        try {
            this.codecAdapter.flush();
            return false;
        } finally {
            resetCodecStateForFlush();
        }
    }

    /* access modifiers changed from: protected */
    public void resetCodecStateForFlush() {
        resetInputBuffer();
        resetOutputBuffer();
        this.codecHotswapDeadlineMs = -9223372036854775807L;
        this.codecReceivedEos = false;
        this.codecReceivedBuffers = false;
        this.waitingForFirstSyncSample = true;
        this.codecNeedsAdaptationWorkaroundBuffer = false;
        this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
        this.isDecodeOnlyOutputBuffer = false;
        this.isLastOutputBuffer = false;
        this.waitingForKeys = false;
        this.decodeOnlyPresentationTimestamps.clear();
        this.largestQueuedPresentationTimeUs = -9223372036854775807L;
        this.lastBufferInStreamPresentationTimeUs = -9223372036854775807L;
        this.codecDrainState = 0;
        this.codecDrainAction = 0;
        this.codecReconfigurationState = this.codecReconfigured ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    public void resetCodecStateForRelease() {
        resetCodecStateForFlush();
        this.availableCodecInfos = null;
        this.codecInfo = null;
        this.codecFormat = null;
        this.codecHasOutputMediaFormat = false;
        this.codecOperatingRate = -1.0f;
        this.codecAdaptationWorkaroundMode = 0;
        this.codecNeedsReconfigureWorkaround = false;
        this.codecNeedsDiscardToSpsWorkaround = false;
        this.codecNeedsFlushWorkaround = false;
        this.codecNeedsSosFlushWorkaround = false;
        this.codecNeedsEosFlushWorkaround = false;
        this.codecNeedsEosOutputExceptionWorkaround = false;
        this.codecNeedsMonoChannelCountWorkaround = false;
        this.codecNeedsEosPropagation = false;
        this.codecReconfigured = false;
        this.codecReconfigurationState = 0;
        resetCodecBuffers();
        this.mediaCryptoRequiresSecureDecoder = false;
    }

    /* access modifiers changed from: protected */
    public MediaCodecDecoderException createDecoderException(Throwable th, MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecDecoderException(th, mediaCodecInfo);
    }

    private boolean readToFlagsOnlyBuffer(boolean z) throws ExoPlaybackException {
        FormatHolder formatHolder = getFormatHolder();
        this.flagsOnlyBuffer.clear();
        int readSource = readSource(formatHolder, this.flagsOnlyBuffer, z);
        if (readSource == -5) {
            onInputFormatChanged(formatHolder);
            return true;
        } else if (readSource != -4 || !this.flagsOnlyBuffer.isEndOfStream()) {
            return false;
        } else {
            this.inputStreamEnded = true;
            processEndOfStream();
            return false;
        }
    }

    private void maybeInitCodecWithFallback(MediaCrypto mediaCrypto2, boolean z) throws DecoderInitializationException {
        if (this.availableCodecInfos == null) {
            try {
                List<MediaCodecInfo> availableCodecInfos2 = getAvailableCodecInfos(z);
                this.availableCodecInfos = new ArrayDeque<>();
                if (this.enableDecoderFallback) {
                    this.availableCodecInfos.addAll(availableCodecInfos2);
                } else if (!availableCodecInfos2.isEmpty()) {
                    this.availableCodecInfos.add(availableCodecInfos2.get(0));
                }
                this.preferredDecoderInitializationException = null;
            } catch (MediaCodecUtil.DecoderQueryException e) {
                throw new DecoderInitializationException(this.inputFormat, e, z, -49998);
            }
        }
        if (!this.availableCodecInfos.isEmpty()) {
            while (this.codec == null) {
                MediaCodecInfo peekFirst = this.availableCodecInfos.peekFirst();
                if (shouldInitCodec(peekFirst)) {
                    try {
                        initCodec(peekFirst, mediaCrypto2);
                    } catch (Exception e2) {
                        Log.w("MediaCodecRenderer", "Failed to initialize decoder: ".concat(String.valueOf(peekFirst)), e2);
                        this.availableCodecInfos.removeFirst();
                        DecoderInitializationException decoderInitializationException = new DecoderInitializationException(this.inputFormat, e2, z, peekFirst);
                        DecoderInitializationException decoderInitializationException2 = this.preferredDecoderInitializationException;
                        if (decoderInitializationException2 == null) {
                            this.preferredDecoderInitializationException = decoderInitializationException;
                        } else {
                            this.preferredDecoderInitializationException = decoderInitializationException2.copyWithFallbackException(decoderInitializationException);
                        }
                        if (this.availableCodecInfos.isEmpty()) {
                            throw this.preferredDecoderInitializationException;
                        }
                    }
                } else {
                    return;
                }
            }
            this.availableCodecInfos = null;
            return;
        }
        throw new DecoderInitializationException(this.inputFormat, (Throwable) null, z, -49999);
    }

    private List<MediaCodecInfo> getAvailableCodecInfos(boolean z) throws MediaCodecUtil.DecoderQueryException {
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(this.mediaCodecSelector, this.inputFormat, z);
        if (decoderInfos.isEmpty() && z) {
            decoderInfos = getDecoderInfos(this.mediaCodecSelector, this.inputFormat, false);
            if (!decoderInfos.isEmpty()) {
                Log.w("MediaCodecRenderer", "Drm session requires secure decoder for " + this.inputFormat.sampleMimeType + ", but no secure decoder available. Trying to proceed with " + decoderInfos + ".");
            }
        }
        return decoderInfos;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x014a  */
    private void initCodec(MediaCodecInfo mediaCodecInfo, MediaCrypto mediaCrypto2) throws Exception {
        float f;
        MediaCodec mediaCodec;
        MediaCodecAdapter synchronousMediaCodecAdapter;
        MediaCodecInfo mediaCodecInfo2 = mediaCodecInfo;
        String str = mediaCodecInfo2.name;
        if (Util.SDK_INT < 23) {
            f = -1.0f;
        } else {
            f = getCodecOperatingRateV23(this.rendererOperatingRate, this.inputFormat, getStreamFormats());
        }
        float f2 = f <= this.assumedMinimumCodecOperatingRate ? -1.0f : f;
        MediaCodecAdapter mediaCodecAdapter = null;
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            TraceUtil.beginSection("createCodec:".concat(String.valueOf(str)));
            mediaCodec = MediaCodec.createByCodecName(str);
            try {
                if (this.mediaCodecOperationMode == 1 && Util.SDK_INT >= 21) {
                    synchronousMediaCodecAdapter = new AsynchronousMediaCodecAdapter(mediaCodec);
                } else if (this.mediaCodecOperationMode == 2 && Util.SDK_INT >= 23) {
                    synchronousMediaCodecAdapter = new DedicatedThreadAsyncMediaCodecAdapter(mediaCodec, getTrackType());
                } else if (this.mediaCodecOperationMode == 3 && Util.SDK_INT >= 23) {
                    synchronousMediaCodecAdapter = new MultiLockAsyncMediaCodecAdapter(mediaCodec, getTrackType());
                } else if (this.mediaCodecOperationMode == 4 && Util.SDK_INT >= 23) {
                    synchronousMediaCodecAdapter = new DedicatedThreadAsyncMediaCodecAdapter(mediaCodec, true, getTrackType());
                } else if (this.mediaCodecOperationMode != 5 || Util.SDK_INT < 23) {
                    synchronousMediaCodecAdapter = new SynchronousMediaCodecAdapter(mediaCodec);
                } else {
                    synchronousMediaCodecAdapter = new MultiLockAsyncMediaCodecAdapter(mediaCodec, true, getTrackType());
                }
                MediaCodecAdapter mediaCodecAdapter2 = synchronousMediaCodecAdapter;
                try {
                    TraceUtil.endSection();
                    TraceUtil.beginSection("configureCodec");
                    configureCodec(mediaCodecInfo, mediaCodec, this.inputFormat, mediaCrypto2, f2);
                    TraceUtil.endSection();
                    TraceUtil.beginSection("startCodec");
                    mediaCodecAdapter2.start();
                    TraceUtil.endSection();
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    getCodecBuffers(mediaCodec);
                    this.codec = mediaCodec;
                    this.codecAdapter = mediaCodecAdapter2;
                    this.codecInfo = mediaCodecInfo2;
                    this.codecOperatingRate = f2;
                    this.codecFormat = this.inputFormat;
                    this.codecAdaptationWorkaroundMode = codecAdaptationWorkaroundMode(str);
                    this.codecNeedsReconfigureWorkaround = codecNeedsReconfigureWorkaround(str);
                    this.codecNeedsDiscardToSpsWorkaround = codecNeedsDiscardToSpsWorkaround(str, this.codecFormat);
                    this.codecNeedsFlushWorkaround = codecNeedsFlushWorkaround(str);
                    this.codecNeedsSosFlushWorkaround = codecNeedsSosFlushWorkaround(str);
                    this.codecNeedsEosFlushWorkaround = codecNeedsEosFlushWorkaround(str);
                    this.codecNeedsEosOutputExceptionWorkaround = codecNeedsEosOutputExceptionWorkaround(str);
                    this.codecNeedsMonoChannelCountWorkaround = codecNeedsMonoChannelCountWorkaround(str, this.codecFormat);
                    this.codecNeedsEosPropagation = codecNeedsEosPropagationWorkaround(mediaCodecInfo) || getCodecNeedsEosPropagation();
                    if (getState() == 2) {
                        this.codecHotswapDeadlineMs = SystemClock.elapsedRealtime() + 1000;
                    }
                    this.decoderCounters.decoderInitCount++;
                    onCodecInitialized(str, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                } catch (Exception e) {
                    e = e;
                    mediaCodecAdapter = mediaCodecAdapter2;
                    if (mediaCodecAdapter != null) {
                    }
                    if (mediaCodec != null) {
                    }
                    throw e;
                }
            } catch (Exception e2) {
                e = e2;
                if (mediaCodecAdapter != null) {
                }
                if (mediaCodec != null) {
                }
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            mediaCodec = null;
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.shutdown();
            }
            if (mediaCodec != null) {
                resetCodecBuffers();
                mediaCodec.release();
            }
            throw e;
        }
    }

    private boolean shouldContinueRendering(long j) {
        return this.renderTimeLimitMs == -9223372036854775807L || SystemClock.elapsedRealtime() - j < this.renderTimeLimitMs;
    }

    private void getCodecBuffers(MediaCodec mediaCodec) {
        if (Util.SDK_INT < 21) {
            this.inputBuffers = mediaCodec.getInputBuffers();
            this.outputBuffers = mediaCodec.getOutputBuffers();
        }
    }

    private void resetCodecBuffers() {
        if (Util.SDK_INT < 21) {
            this.inputBuffers = null;
            this.outputBuffers = null;
        }
    }

    private ByteBuffer getInputBuffer(int i) {
        if (Util.SDK_INT >= 21) {
            return this.codec.getInputBuffer(i);
        }
        return this.inputBuffers[i];
    }

    private ByteBuffer getOutputBuffer(int i) {
        if (Util.SDK_INT >= 21) {
            return this.codec.getOutputBuffer(i);
        }
        return this.outputBuffers[i];
    }

    private boolean hasOutputBuffer() {
        return this.outputIndex >= 0;
    }

    private void resetInputBuffer() {
        this.inputIndex = -1;
        this.buffer.data = null;
    }

    private void resetOutputBuffer() {
        this.outputIndex = -1;
        this.outputBuffer = null;
    }

    private void setSourceDrmSession(DrmSession drmSession) {
        DrmSession.CC.replaceSession(this.sourceDrmSession, drmSession);
        this.sourceDrmSession = drmSession;
    }

    private void setCodecDrmSession(DrmSession drmSession) {
        DrmSession.CC.replaceSession(this.codecDrmSession, drmSession);
        this.codecDrmSession = drmSession;
    }

    private boolean feedInputBuffer() throws ExoPlaybackException {
        int i;
        int i2;
        if (this.codec == null || this.codecDrainState == 2 || this.inputStreamEnded) {
            return false;
        }
        if (this.inputIndex < 0) {
            this.inputIndex = this.codecAdapter.dequeueInputBufferIndex();
            int i3 = this.inputIndex;
            if (i3 < 0) {
                return false;
            }
            this.buffer.data = getInputBuffer(i3);
            this.buffer.clear();
        }
        if (this.codecDrainState == 1) {
            if (!this.codecNeedsEosPropagation) {
                this.codecReceivedEos = true;
                this.codecAdapter.queueInputBuffer(this.inputIndex, 0, 0, 0, 4);
                resetInputBuffer();
            }
            this.codecDrainState = 2;
            return false;
        } else if (this.codecNeedsAdaptationWorkaroundBuffer) {
            this.codecNeedsAdaptationWorkaroundBuffer = false;
            this.buffer.data.put(ADAPTATION_WORKAROUND_BUFFER);
            this.codecAdapter.queueInputBuffer(this.inputIndex, 0, ADAPTATION_WORKAROUND_BUFFER.length, 0, 0);
            resetInputBuffer();
            this.codecReceivedBuffers = true;
            return true;
        } else {
            FormatHolder formatHolder = getFormatHolder();
            if (this.waitingForKeys) {
                i2 = -4;
                i = 0;
            } else {
                if (this.codecReconfigurationState == 1) {
                    for (int i4 = 0; i4 < this.codecFormat.initializationData.size(); i4++) {
                        this.buffer.data.put(this.codecFormat.initializationData.get(i4));
                    }
                    this.codecReconfigurationState = 2;
                }
                i = this.buffer.data.position();
                i2 = readSource(formatHolder, this.buffer, false);
            }
            if (hasReadStreamToEnd()) {
                this.lastBufferInStreamPresentationTimeUs = this.largestQueuedPresentationTimeUs;
            }
            if (i2 == -3) {
                return false;
            }
            if (i2 == -5) {
                if (this.codecReconfigurationState == 2) {
                    this.buffer.clear();
                    this.codecReconfigurationState = 1;
                }
                onInputFormatChanged(formatHolder);
                return true;
            } else if (this.buffer.isEndOfStream()) {
                if (this.codecReconfigurationState == 2) {
                    this.buffer.clear();
                    this.codecReconfigurationState = 1;
                }
                this.inputStreamEnded = true;
                if (!this.codecReceivedBuffers) {
                    processEndOfStream();
                    return false;
                }
                try {
                    if (!this.codecNeedsEosPropagation) {
                        this.codecReceivedEos = true;
                        this.codecAdapter.queueInputBuffer(this.inputIndex, 0, 0, 0, 4);
                        resetInputBuffer();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e) {
                    throw createRendererException(e, this.inputFormat);
                }
            } else if (!this.waitingForFirstSyncSample || this.buffer.isKeyFrame()) {
                this.waitingForFirstSyncSample = false;
                boolean isEncrypted = this.buffer.isEncrypted();
                this.waitingForKeys = shouldWaitForKeys(isEncrypted);
                if (this.waitingForKeys) {
                    return false;
                }
                if (this.codecNeedsDiscardToSpsWorkaround && !isEncrypted) {
                    NalUnitUtil.discardToSps(this.buffer.data);
                    if (this.buffer.data.position() == 0) {
                        return true;
                    }
                    this.codecNeedsDiscardToSpsWorkaround = false;
                }
                try {
                    long j = this.buffer.timeUs;
                    if (this.buffer.isDecodeOnly()) {
                        this.decodeOnlyPresentationTimestamps.add(Long.valueOf(j));
                    }
                    if (this.waitingForFirstSampleInFormat) {
                        this.formatQueue.add(j, this.inputFormat);
                        this.waitingForFirstSampleInFormat = false;
                    }
                    this.largestQueuedPresentationTimeUs = Math.max(this.largestQueuedPresentationTimeUs, j);
                    this.buffer.flip();
                    if (this.buffer.hasSupplementalData()) {
                        handleInputBufferSupplementalData(this.buffer);
                    }
                    onQueueInputBuffer(this.buffer);
                    if (isEncrypted) {
                        CryptoInfo cryptoInfo = this.buffer.cryptoInfo;
                        cryptoInfo.increaseClearDataFirstSubSampleBy(i);
                        this.codecAdapter.queueSecureInputBuffer(this.inputIndex, 0, cryptoInfo, j, 0);
                    } else {
                        this.codecAdapter.queueInputBuffer(this.inputIndex, 0, this.buffer.data.limit(), j, 0);
                    }
                    resetInputBuffer();
                    this.codecReceivedBuffers = true;
                    this.codecReconfigurationState = 0;
                    this.decoderCounters.inputBufferCount++;
                    return true;
                } catch (MediaCodec.CryptoException e2) {
                    throw createRendererException(e2, this.inputFormat);
                }
            } else {
                this.buffer.clear();
                if (this.codecReconfigurationState == 2) {
                    this.codecReconfigurationState = 1;
                }
                return true;
            }
        }
    }

    private boolean shouldWaitForKeys(boolean z) throws ExoPlaybackException {
        DrmSession drmSession = this.codecDrmSession;
        if (drmSession == null || (!z && drmSession.playClearSamplesWithoutKeys())) {
            return false;
        }
        int state = this.codecDrmSession.getState();
        if (state == 1) {
            throw createRendererException(this.codecDrmSession.getError(), this.inputFormat);
        } else if (state != 4) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
        boolean z = true;
        this.waitingForFirstSampleInFormat = true;
        Format format = (Format) Assertions.checkNotNull(formatHolder.format);
        setSourceDrmSession(formatHolder.drmSession);
        this.inputFormat = format;
        if (this.codec == null) {
            maybeInitCodec();
        } else if ((this.sourceDrmSession != null || this.codecDrmSession == null) && ((this.sourceDrmSession == null || this.codecDrmSession != null) && ((this.sourceDrmSession == this.codecDrmSession || this.codecInfo.secure || !maybeRequiresSecureDecoder(this.sourceDrmSession, format)) && (Util.SDK_INT >= 23 || this.sourceDrmSession == this.codecDrmSession)))) {
            int canKeepCodec = canKeepCodec(this.codec, this.codecInfo, this.codecFormat, format);
            if (canKeepCodec == 0) {
                drainAndReinitializeCodec();
            } else if (canKeepCodec == 1) {
                this.codecFormat = format;
                updateCodecOperatingRate();
                if (this.sourceDrmSession != this.codecDrmSession) {
                    drainAndUpdateCodecDrmSession();
                } else {
                    drainAndFlushCodec();
                }
            } else if (canKeepCodec != 2) {
                if (canKeepCodec == 3) {
                    this.codecFormat = format;
                    updateCodecOperatingRate();
                    if (this.sourceDrmSession != this.codecDrmSession) {
                        drainAndUpdateCodecDrmSession();
                        return;
                    }
                    return;
                }
                throw new IllegalStateException();
            } else if (this.codecNeedsReconfigureWorkaround) {
                drainAndReinitializeCodec();
            } else {
                this.codecReconfigured = true;
                this.codecReconfigurationState = 1;
                int i = this.codecAdaptationWorkaroundMode;
                if (!(i == 2 || (i == 1 && format.width == this.codecFormat.width && format.height == this.codecFormat.height))) {
                    z = false;
                }
                this.codecNeedsAdaptationWorkaroundBuffer = z;
                this.codecFormat = format;
                updateCodecOperatingRate();
                if (this.sourceDrmSession != this.codecDrmSession) {
                    drainAndUpdateCodecDrmSession();
                }
            }
        } else {
            drainAndReinitializeCodec();
        }
    }

    /* access modifiers changed from: protected */
    public void onProcessedOutputBuffer(long j) {
        while (true) {
            int i = this.pendingOutputStreamOffsetCount;
            if (i != 0 && j >= this.pendingOutputStreamSwitchTimesUs[0]) {
                long[] jArr = this.pendingOutputStreamOffsetsUs;
                this.outputStreamOffsetUs = jArr[0];
                this.pendingOutputStreamOffsetCount = i - 1;
                System.arraycopy(jArr, 1, jArr, 0, this.pendingOutputStreamOffsetCount);
                long[] jArr2 = this.pendingOutputStreamSwitchTimesUs;
                System.arraycopy(jArr2, 1, jArr2, 0, this.pendingOutputStreamOffsetCount);
                onProcessedStreamChange();
            } else {
                return;
            }
        }
    }

    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    public boolean isReady() {
        if (this.inputFormat == null || this.waitingForKeys) {
            return false;
        }
        if (isSourceReady() || hasOutputBuffer()) {
            return true;
        }
        return this.codecHotswapDeadlineMs != -9223372036854775807L && SystemClock.elapsedRealtime() < this.codecHotswapDeadlineMs;
    }

    private void updateCodecOperatingRate() throws ExoPlaybackException {
        if (Util.SDK_INT >= 23) {
            float codecOperatingRateV23 = getCodecOperatingRateV23(this.rendererOperatingRate, this.codecFormat, getStreamFormats());
            float f = this.codecOperatingRate;
            if (f == codecOperatingRateV23) {
                return;
            }
            if (codecOperatingRateV23 == -1.0f) {
                drainAndReinitializeCodec();
            } else if (f != -1.0f || codecOperatingRateV23 > this.assumedMinimumCodecOperatingRate) {
                Bundle bundle = new Bundle();
                bundle.putFloat("operating-rate", codecOperatingRateV23);
                this.codec.setParameters(bundle);
                this.codecOperatingRate = codecOperatingRateV23;
            }
        }
    }

    private void drainAndFlushCodec() {
        if (this.codecReceivedBuffers) {
            this.codecDrainState = 1;
            this.codecDrainAction = 1;
        }
    }

    private void drainAndUpdateCodecDrmSession() throws ExoPlaybackException {
        if (Util.SDK_INT < 23) {
            drainAndReinitializeCodec();
        } else if (this.codecReceivedBuffers) {
            this.codecDrainState = 1;
            this.codecDrainAction = 2;
        } else {
            updateDrmSessionOrReinitializeCodecV23();
        }
    }

    private void drainAndReinitializeCodec() throws ExoPlaybackException {
        if (this.codecReceivedBuffers) {
            this.codecDrainState = 1;
            this.codecDrainAction = 3;
            return;
        }
        reinitializeCodec();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, long):void}
      ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, boolean):void} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00e9  */
    private boolean drainOutputBuffer(long j, long j2) throws ExoPlaybackException {
        boolean z;
        boolean z2;
        int i;
        if (!hasOutputBuffer()) {
            if (!this.codecNeedsEosOutputExceptionWorkaround || !this.codecReceivedEos) {
                i = this.codecAdapter.dequeueOutputBufferIndex(this.outputBufferInfo);
            } else {
                try {
                    i = this.codecAdapter.dequeueOutputBufferIndex(this.outputBufferInfo);
                } catch (IllegalStateException unused) {
                    processEndOfStream();
                    if (this.outputStreamEnded) {
                        releaseCodec();
                    }
                    return false;
                }
            }
            if (i < 0) {
                if (i == -2) {
                    processOutputMediaFormat();
                    return true;
                } else if (i == -3) {
                    processOutputBuffersChanged();
                    return true;
                } else {
                    if (this.codecNeedsEosPropagation && (this.inputStreamEnded || this.codecDrainState == 2)) {
                        processEndOfStream();
                    }
                    return false;
                }
            } else if (this.shouldSkipAdaptationWorkaroundOutputBuffer) {
                this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
                this.codec.releaseOutputBuffer(i, false);
                return true;
            } else if (this.outputBufferInfo.size != 0 || (this.outputBufferInfo.flags & 4) == 0) {
                this.outputIndex = i;
                this.outputBuffer = getOutputBuffer(i);
                ByteBuffer byteBuffer = this.outputBuffer;
                if (byteBuffer != null) {
                    byteBuffer.position(this.outputBufferInfo.offset);
                    this.outputBuffer.limit(this.outputBufferInfo.offset + this.outputBufferInfo.size);
                }
                this.isDecodeOnlyOutputBuffer = isDecodeOnlyBuffer(this.outputBufferInfo.presentationTimeUs);
                this.isLastOutputBuffer = this.lastBufferInStreamPresentationTimeUs == this.outputBufferInfo.presentationTimeUs;
                updateOutputFormatForTime(this.outputBufferInfo.presentationTimeUs);
            } else {
                processEndOfStream();
                return false;
            }
        }
        if (!this.codecNeedsEosOutputExceptionWorkaround || !this.codecReceivedEos) {
            z = false;
            z2 = processOutputBuffer(j, j2, this.codec, this.outputBuffer, this.outputIndex, this.outputBufferInfo.flags, 1, this.outputBufferInfo.presentationTimeUs, this.isDecodeOnlyOutputBuffer, this.isLastOutputBuffer, this.outputFormat);
        } else {
            try {
                z = false;
                try {
                    z2 = processOutputBuffer(j, j2, this.codec, this.outputBuffer, this.outputIndex, this.outputBufferInfo.flags, 1, this.outputBufferInfo.presentationTimeUs, this.isDecodeOnlyOutputBuffer, this.isLastOutputBuffer, this.outputFormat);
                } catch (IllegalStateException unused2) {
                    processEndOfStream();
                    if (this.outputStreamEnded) {
                    }
                    return z;
                }
            } catch (IllegalStateException unused3) {
                z = false;
                processEndOfStream();
                if (this.outputStreamEnded) {
                    releaseCodec();
                }
                return z;
            }
        }
        if (z2) {
            onProcessedOutputBuffer(this.outputBufferInfo.presentationTimeUs);
            boolean z3 = (this.outputBufferInfo.flags & 4) != 0;
            resetOutputBuffer();
            if (!z3) {
                return true;
            }
            processEndOfStream();
        }
        return z;
    }

    private void processOutputMediaFormat() throws ExoPlaybackException {
        this.codecHasOutputMediaFormat = true;
        MediaFormat outputFormat2 = this.codecAdapter.getOutputFormat();
        if (this.codecAdaptationWorkaroundMode != 0 && outputFormat2.getInteger("width") == 32 && outputFormat2.getInteger("height") == 32) {
            this.shouldSkipAdaptationWorkaroundOutputBuffer = true;
            return;
        }
        if (this.codecNeedsMonoChannelCountWorkaround) {
            outputFormat2.setInteger("channel-count", 1);
        }
        onOutputMediaFormatChanged(this.codec, outputFormat2);
    }

    private void processOutputBuffersChanged() {
        if (Util.SDK_INT < 21) {
            this.outputBuffers = this.codec.getOutputBuffers();
        }
    }

    @TargetApi(23)
    private void processEndOfStream() throws ExoPlaybackException {
        int i = this.codecDrainAction;
        if (i == 1) {
            flushOrReinitializeCodec();
        } else if (i == 2) {
            updateDrmSessionOrReinitializeCodecV23();
        } else if (i != 3) {
            this.outputStreamEnded = true;
            renderToEndOfStream();
        } else {
            reinitializeCodec();
        }
    }

    /* access modifiers changed from: protected */
    public final void setPendingOutputEndOfStream() {
        this.pendingOutputEndOfStream = true;
    }

    /* access modifiers changed from: protected */
    public final long getLargestQueuedPresentationTimeUs() {
        return this.largestQueuedPresentationTimeUs;
    }

    /* access modifiers changed from: protected */
    public final long getOutputStreamOffsetUs() {
        return this.outputStreamOffsetUs;
    }

    protected static boolean supportsFormatDrm(Format format) {
        return format.drmInitData == null || FrameworkMediaCrypto.class.equals(format.exoMediaCryptoType);
    }

    private boolean maybeRequiresSecureDecoder(DrmSession drmSession, Format format) throws ExoPlaybackException {
        FrameworkMediaCrypto frameworkMediaCrypto = getFrameworkMediaCrypto(drmSession);
        if (frameworkMediaCrypto == null) {
            return true;
        }
        if (frameworkMediaCrypto.forceAllowInsecureDecoderComponents) {
            return false;
        }
        try {
            MediaCrypto mediaCrypto2 = new MediaCrypto(frameworkMediaCrypto.uuid, frameworkMediaCrypto.sessionId);
            try {
                return mediaCrypto2.requiresSecureDecoderComponent(format.sampleMimeType);
            } finally {
                mediaCrypto2.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    private void reinitializeCodec() throws ExoPlaybackException {
        releaseCodec();
        maybeInitCodec();
    }

    private boolean isDecodeOnlyBuffer(long j) {
        int size = this.decodeOnlyPresentationTimestamps.size();
        for (int i = 0; i < size; i++) {
            if (this.decodeOnlyPresentationTimestamps.get(i).longValue() == j) {
                this.decodeOnlyPresentationTimestamps.remove(i);
                return true;
            }
        }
        return false;
    }

    private void updateDrmSessionOrReinitializeCodecV23() throws ExoPlaybackException {
        FrameworkMediaCrypto frameworkMediaCrypto = getFrameworkMediaCrypto(this.sourceDrmSession);
        if (frameworkMediaCrypto == null) {
            reinitializeCodec();
        } else if (C.PLAYREADY_UUID.equals(frameworkMediaCrypto.uuid)) {
            reinitializeCodec();
        } else if (!flushOrReinitializeCodec()) {
            try {
                this.mediaCrypto.setMediaDrmSession(frameworkMediaCrypto.sessionId);
                setCodecDrmSession(this.sourceDrmSession);
                this.codecDrainState = 0;
                this.codecDrainAction = 0;
            } catch (MediaCryptoException e) {
                throw createRendererException(e, this.inputFormat);
            }
        }
    }

    private FrameworkMediaCrypto getFrameworkMediaCrypto(DrmSession drmSession) throws ExoPlaybackException {
        ExoMediaCrypto mediaCrypto2 = drmSession.getMediaCrypto();
        if (mediaCrypto2 == null || (mediaCrypto2 instanceof FrameworkMediaCrypto)) {
            return (FrameworkMediaCrypto) mediaCrypto2;
        }
        throw createRendererException(new IllegalArgumentException("Expecting FrameworkMediaCrypto but found: ".concat(String.valueOf(mediaCrypto2))), this.inputFormat);
    }

    private static boolean isMediaCodecException(IllegalStateException illegalStateException) {
        if (Util.SDK_INT >= 21 && isMediaCodecExceptionV21(illegalStateException)) {
            return true;
        }
        StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
        if (stackTrace.length <= 0 || !stackTrace[0].getClassName().equals("android.media.MediaCodec")) {
            return false;
        }
        return true;
    }

    private static boolean isMediaCodecExceptionV21(IllegalStateException illegalStateException) {
        return illegalStateException instanceof MediaCodec.CodecException;
    }

    private static boolean codecNeedsFlushWorkaround(String str) {
        if (Util.SDK_INT < 18) {
            return true;
        }
        if (Util.SDK_INT == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) {
            return true;
        }
        if (Util.SDK_INT != 19 || !Util.MODEL.startsWith("SM-G800")) {
            return false;
        }
        return "OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str);
    }

    private int codecAdaptationWorkaroundMode(String str) {
        if (Util.SDK_INT <= 25 && "OMX.Exynos.avc.dec.secure".equals(str) && (Util.MODEL.startsWith("SM-T585") || Util.MODEL.startsWith("SM-A510") || Util.MODEL.startsWith("SM-A520") || Util.MODEL.startsWith("SM-J700"))) {
            return 2;
        }
        if (Util.SDK_INT >= 24) {
            return 0;
        }
        if ("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) {
            return ("flounder".equals(Util.DEVICE) || "flounder_lte".equals(Util.DEVICE) || "grouper".equals(Util.DEVICE) || "tilapia".equals(Util.DEVICE)) ? 1 : 0;
        }
        return 0;
    }

    private static boolean codecNeedsReconfigureWorkaround(String str) {
        return Util.MODEL.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    private static boolean codecNeedsDiscardToSpsWorkaround(String str, Format format) {
        return Util.SDK_INT < 21 && format.initializationData.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private static boolean codecNeedsEosPropagationWorkaround(MediaCodecInfo mediaCodecInfo) {
        String str = mediaCodecInfo.name;
        if (Util.SDK_INT <= 25 && "OMX.rk.video_decoder.avc".equals(str)) {
            return true;
        }
        if (Util.SDK_INT > 17 || !"OMX.allwinner.video.decoder.avc".equals(str)) {
            return "Amazon".equals(Util.MANUFACTURER) && "AFTS".equals(Util.MODEL) && mediaCodecInfo.secure;
        }
        return true;
    }

    private static boolean codecNeedsEosFlushWorkaround(String str) {
        if (Util.SDK_INT <= 23 && "OMX.google.vorbis.decoder".equals(str)) {
            return true;
        }
        if (Util.SDK_INT > 19) {
            return false;
        }
        if ("hb2000".equals(Util.DEVICE) || "stvm8".equals(Util.DEVICE)) {
            return "OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str);
        }
        return false;
    }

    private static boolean codecNeedsEosOutputExceptionWorkaround(String str) {
        return Util.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private static boolean codecNeedsMonoChannelCountWorkaround(String str, Format format) {
        if (Util.SDK_INT > 18 || format.channelCount != 1 || !"OMX.MTK.AUDIO.DECODER.MP3".equals(str)) {
            return false;
        }
        return true;
    }

    private static boolean codecNeedsSosFlushWorkaround(String str) {
        return Util.SDK_INT == 29 && "c2.android.aac.decoder".equals(str);
    }
}
