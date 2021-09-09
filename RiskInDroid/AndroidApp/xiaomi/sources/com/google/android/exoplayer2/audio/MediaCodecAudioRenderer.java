package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.MediaFormatUtil;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MediaCodecAudioRenderer extends MediaCodecRenderer implements MediaClock {
    private boolean allowFirstBufferPositionDiscontinuity;
    public boolean allowPositionDiscontinuity;
    private final AudioSink audioSink;
    private int codecMaxInputSize;
    private boolean codecNeedsDiscardChannelsWorkaround;
    private boolean codecNeedsEosBufferTimestampWorkaround;
    private final Context context;
    private long currentPositionUs;
    public final AudioRendererEventListener.EventDispatcher eventDispatcher;
    private Format inputFormat;
    private boolean passthroughEnabled;
    private MediaFormat passthroughMediaFormat;

    public MediaClock getMediaClock() {
        return this;
    }

    public String getName() {
        return "MediaCodecAudioRenderer";
    }

    /* access modifiers changed from: protected */
    public void onAudioSessionId(int i) {
    }

    /* access modifiers changed from: protected */
    public void onAudioTrackPositionDiscontinuity() {
    }

    /* access modifiers changed from: protected */
    public void onAudioTrackSkipSilenceEnabledChanged(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void onAudioTrackUnderrun(int i, long j, long j2) {
    }

    public MediaCodecAudioRenderer(Context context2, MediaCodecSelector mediaCodecSelector) {
        this(context2, mediaCodecSelector, null, null);
    }

    public MediaCodecAudioRenderer(Context context2, MediaCodecSelector mediaCodecSelector, Handler handler, AudioRendererEventListener audioRendererEventListener) {
        this(context2, mediaCodecSelector, handler, audioRendererEventListener, (AudioCapabilities) null, new AudioProcessor[0]);
    }

    public MediaCodecAudioRenderer(Context context2, MediaCodecSelector mediaCodecSelector, Handler handler, AudioRendererEventListener audioRendererEventListener, AudioCapabilities audioCapabilities, AudioProcessor... audioProcessorArr) {
        this(context2, mediaCodecSelector, handler, audioRendererEventListener, new DefaultAudioSink(audioCapabilities, audioProcessorArr));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.<init>(android.content.Context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector, boolean, android.os.Handler, com.google.android.exoplayer2.audio.AudioRendererEventListener, com.google.android.exoplayer2.audio.AudioSink):void
     arg types: [android.content.Context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector, int, android.os.Handler, com.google.android.exoplayer2.audio.AudioRendererEventListener, com.google.android.exoplayer2.audio.AudioSink]
     candidates:
      com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.<init>(android.content.Context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector, android.os.Handler, com.google.android.exoplayer2.audio.AudioRendererEventListener, com.google.android.exoplayer2.audio.AudioCapabilities, com.google.android.exoplayer2.audio.AudioProcessor[]):void
      com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.<init>(android.content.Context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector, boolean, android.os.Handler, com.google.android.exoplayer2.audio.AudioRendererEventListener, com.google.android.exoplayer2.audio.AudioSink):void */
    public MediaCodecAudioRenderer(Context context2, MediaCodecSelector mediaCodecSelector, Handler handler, AudioRendererEventListener audioRendererEventListener, AudioSink audioSink2) {
        this(context2, mediaCodecSelector, false, handler, audioRendererEventListener, audioSink2);
    }

    public MediaCodecAudioRenderer(Context context2, MediaCodecSelector mediaCodecSelector, boolean z, Handler handler, AudioRendererEventListener audioRendererEventListener, AudioSink audioSink2) {
        super(1, mediaCodecSelector, z, 44100.0f);
        this.context = context2.getApplicationContext();
        this.audioSink = audioSink2;
        this.eventDispatcher = new AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
        audioSink2.setListener(new AudioSinkListener());
    }

    public int supportsFormat(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        String str = format.sampleMimeType;
        if (!MimeTypes.isAudio(str)) {
            return RendererCapabilities.CC.create(0);
        }
        int i = Util.SDK_INT >= 21 ? 32 : 0;
        boolean supportsFormatDrm = supportsFormatDrm(format);
        int i2 = 8;
        int i3 = 4;
        if (supportsFormatDrm && usePassthrough(format.channelCount, str)) {
            return RendererCapabilities.CC.create(4, 8, i);
        }
        if (("audio/raw".equals(str) && !this.audioSink.supportsOutput(format.channelCount, format.pcmEncoding)) || !this.audioSink.supportsOutput(format.channelCount, 2)) {
            return RendererCapabilities.CC.create(1);
        }
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(mediaCodecSelector, format, false);
        if (decoderInfos.isEmpty()) {
            return RendererCapabilities.CC.create(1);
        }
        if (!supportsFormatDrm) {
            return RendererCapabilities.CC.create(2);
        }
        MediaCodecInfo mediaCodecInfo = decoderInfos.get(0);
        boolean isFormatSupported = mediaCodecInfo.isFormatSupported(format);
        if (isFormatSupported && mediaCodecInfo.isSeamlessAdaptationSupported(format)) {
            i2 = 16;
        }
        if (!isFormatSupported) {
            i3 = 3;
        }
        return RendererCapabilities.CC.create(i3, i2, i);
    }

    public List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        String str = format.sampleMimeType;
        if (str == null) {
            return Collections.emptyList();
        }
        if (usePassthrough(format.channelCount, str)) {
            return Collections.singletonList(MediaCodecUtil.getPassthroughDecoderInfo());
        }
        List<MediaCodecInfo> decoderInfosSortedByFormatSupport = MediaCodecUtil.getDecoderInfosSortedByFormatSupport(mediaCodecSelector.getDecoderInfos(str, z, false), format);
        if ("audio/eac3-joc".equals(str)) {
            ArrayList arrayList = new ArrayList(decoderInfosSortedByFormatSupport);
            arrayList.addAll(mediaCodecSelector.getDecoderInfos("audio/eac3", z, false));
            decoderInfosSortedByFormatSupport = arrayList;
        }
        return Collections.unmodifiableList(decoderInfosSortedByFormatSupport);
    }

    /* access modifiers changed from: protected */
    public boolean usePassthrough(int i, String str) throws MediaCodecUtil.DecoderQueryException {
        return (getPassthroughEncoding(i, str) == 0 || MediaCodecUtil.getPassthroughDecoderInfo() == null) ? false : true;
    }

    public void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto, float f) {
        this.codecMaxInputSize = getCodecMaxInputSize(mediaCodecInfo, format, getStreamFormats());
        this.codecNeedsDiscardChannelsWorkaround = codecNeedsDiscardChannelsWorkaround(mediaCodecInfo.name);
        this.codecNeedsEosBufferTimestampWorkaround = codecNeedsEosBufferTimestampWorkaround(mediaCodecInfo.name);
        this.passthroughEnabled = "audio/raw".equals(mediaCodecInfo.mimeType) && !"audio/raw".equals(format.sampleMimeType);
        MediaFormat mediaFormat = getMediaFormat(format, mediaCodecInfo.codecMimeType, this.codecMaxInputSize, f);
        mediaCodec.configure(mediaFormat, (Surface) null, mediaCrypto, 0);
        if (this.passthroughEnabled) {
            this.passthroughMediaFormat = mediaFormat;
            this.passthroughMediaFormat.setString("mime", format.sampleMimeType);
            return;
        }
        this.passthroughMediaFormat = null;
    }

    public int canKeepCodec(MediaCodec mediaCodec, MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        if (getCodecMaxInputSize(mediaCodecInfo, format2) <= this.codecMaxInputSize && format.encoderDelay == 0 && format.encoderPadding == 0 && format2.encoderDelay == 0 && format2.encoderPadding == 0) {
            if (mediaCodecInfo.isSeamlessAdaptationSupported(format, format2, true)) {
                return 3;
            }
            if (canKeepCodecWithFlush(format, format2)) {
                return 1;
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean canKeepCodecWithFlush(Format format, Format format2) {
        return Util.areEqual(format.sampleMimeType, format2.sampleMimeType) && format.channelCount == format2.channelCount && format.sampleRate == format2.sampleRate && format.pcmEncoding == format2.pcmEncoding && format.initializationDataEquals(format2) && !"audio/opus".equals(format.sampleMimeType);
    }

    public float getCodecOperatingRateV23(float f, Format format, Format[] formatArr) {
        int i = -1;
        for (Format format2 : formatArr) {
            int i2 = format2.sampleRate;
            if (i2 != -1) {
                i = Math.max(i, i2);
            }
        }
        if (i == -1) {
            return -1.0f;
        }
        return ((float) i) * f;
    }

    public void onCodecInitialized(String str, long j, long j2) {
        this.eventDispatcher.decoderInitialized(str, j, j2);
    }

    public void onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
        super.onInputFormatChanged(formatHolder);
        this.inputFormat = formatHolder.format;
        this.eventDispatcher.inputFormatChanged(this.inputFormat);
    }

    public void onOutputMediaFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ExoPlaybackException {
        int i;
        int[] iArr;
        int i2;
        MediaFormat mediaFormat2 = this.passthroughMediaFormat;
        if (mediaFormat2 != null) {
            i = getPassthroughEncoding(mediaFormat2.getInteger("channel-count"), mediaFormat2.getString("mime"));
            mediaFormat = mediaFormat2;
        } else {
            if (mediaFormat.containsKey("v-bits-per-sample")) {
                i2 = Util.getPcmEncoding(mediaFormat.getInteger("v-bits-per-sample"));
            } else {
                i2 = getPcmEncoding(this.inputFormat);
            }
            i = i2;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (!this.codecNeedsDiscardChannelsWorkaround || integer != 6 || this.inputFormat.channelCount >= 6) {
            iArr = null;
        } else {
            iArr = new int[this.inputFormat.channelCount];
            for (int i3 = 0; i3 < this.inputFormat.channelCount; i3++) {
                iArr[i3] = i3;
            }
        }
        try {
            this.audioSink.configure(i, integer, integer2, 0, iArr, this.inputFormat.encoderDelay, this.inputFormat.encoderPadding);
        } catch (AudioSink.ConfigurationException e) {
            throw createRendererException(e, this.inputFormat);
        }
    }

    /* access modifiers changed from: protected */
    public int getPassthroughEncoding(int i, String str) {
        if ("audio/raw".equals(str)) {
            return 0;
        }
        if ("audio/eac3-joc".equals(str)) {
            if (this.audioSink.supportsOutput(-1, 18)) {
                return MimeTypes.getEncoding("audio/eac3-joc");
            }
            str = "audio/eac3";
        }
        int encoding = MimeTypes.getEncoding(str);
        if (this.audioSink.supportsOutput(i, encoding)) {
            return encoding;
        }
        return 0;
    }

    public void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
        super.onEnabled(z, z2);
        this.eventDispatcher.enabled(this.decoderCounters);
        int i = getConfiguration().tunnelingAudioSessionId;
        if (i != 0) {
            this.audioSink.enableTunnelingV21(i);
        } else {
            this.audioSink.disableTunneling();
        }
    }

    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        super.onPositionReset(j, z);
        this.audioSink.flush();
        this.currentPositionUs = j;
        this.allowFirstBufferPositionDiscontinuity = true;
        this.allowPositionDiscontinuity = true;
    }

    public void onStarted() {
        super.onStarted();
        this.audioSink.play();
    }

    public void onStopped() {
        updateCurrentPosition();
        this.audioSink.pause();
        super.onStopped();
    }

    public void onDisabled() {
        try {
            this.audioSink.flush();
            try {
                super.onDisabled();
            } finally {
                this.eventDispatcher.disabled(this.decoderCounters);
            }
        } catch (Throwable th) {
            super.onDisabled();
            throw th;
        } finally {
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    public void onReset() {
        try {
            super.onReset();
        } finally {
            this.audioSink.reset();
        }
    }

    public boolean isEnded() {
        return super.isEnded() && this.audioSink.isEnded();
    }

    public boolean isReady() {
        return this.audioSink.hasPendingData() || super.isReady();
    }

    public long getPositionUs() {
        if (getState() == 2) {
            updateCurrentPosition();
        }
        return this.currentPositionUs;
    }

    public void setPlaybackSpeed(float f) {
        this.audioSink.setPlaybackSpeed(f);
    }

    public float getPlaybackSpeed() {
        return this.audioSink.getPlaybackSpeed();
    }

    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        if (this.allowFirstBufferPositionDiscontinuity && !decoderInputBuffer.isDecodeOnly()) {
            if (Math.abs(decoderInputBuffer.timeUs - this.currentPositionUs) > 500000) {
                this.currentPositionUs = decoderInputBuffer.timeUs;
            }
            this.allowFirstBufferPositionDiscontinuity = false;
        }
    }

    public void onProcessedStreamChange() {
        super.onProcessedStreamChange();
        this.audioSink.handleDiscontinuity();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, long):void}
      ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, boolean):void} */
    public boolean processOutputBuffer(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, Format format) throws ExoPlaybackException {
        if (this.codecNeedsEosBufferTimestampWorkaround && j3 == 0 && (i2 & 4) != 0 && getLargestQueuedPresentationTimeUs() != -9223372036854775807L) {
            j3 = getLargestQueuedPresentationTimeUs();
        }
        if (this.passthroughEnabled && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.decoderCounters.skippedOutputBufferCount++;
            this.audioSink.handleDiscontinuity();
            return true;
        } else {
            try {
                if (!this.audioSink.handleBuffer(byteBuffer, j3, i3)) {
                    return false;
                }
                mediaCodec.releaseOutputBuffer(i, false);
                this.decoderCounters.renderedOutputBufferCount++;
                return true;
            } catch (AudioSink.InitializationException | AudioSink.WriteException e) {
                throw createRendererException(e, this.inputFormat);
            }
        }
    }

    public void renderToEndOfStream() throws ExoPlaybackException {
        try {
            this.audioSink.playToEndOfStream();
        } catch (AudioSink.WriteException e) {
            throw createRendererException(e, this.inputFormat);
        }
    }

    public void handleMessage(int i, Object obj) throws ExoPlaybackException {
        if (i == 2) {
            this.audioSink.setVolume(((Float) obj).floatValue());
        } else if (i == 3) {
            this.audioSink.setAudioAttributes((AudioAttributes) obj);
        } else if (i == 5) {
            this.audioSink.setAuxEffectInfo((AuxEffectInfo) obj);
        } else if (i == 101) {
            this.audioSink.setSkipSilenceEnabled(((Boolean) obj).booleanValue());
        } else if (i != 102) {
            super.handleMessage(i, obj);
        } else {
            this.audioSink.setAudioSessionId(((Integer) obj).intValue());
        }
    }

    /* access modifiers changed from: protected */
    public int getCodecMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) {
        int codecMaxInputSize2 = getCodecMaxInputSize(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            return codecMaxInputSize2;
        }
        int i = codecMaxInputSize2;
        for (Format format2 : formatArr) {
            if (mediaCodecInfo.isSeamlessAdaptationSupported(format, format2, false)) {
                i = Math.max(i, getCodecMaxInputSize(mediaCodecInfo, format2));
            }
        }
        return i;
    }

    private int getCodecMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        if (!"OMX.google.raw.decoder".equals(mediaCodecInfo.name) || Util.SDK_INT >= 24 || (Util.SDK_INT == 23 && Util.isTv(this.context))) {
            return format.maxInputSize;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"InlinedApi"})
    public MediaFormat getMediaFormat(Format format, String str, int i, float f) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", format.channelCount);
        mediaFormat.setInteger("sample-rate", format.sampleRate);
        MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", i);
        if (Util.SDK_INT >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f && !deviceDoesntSupportOperatingRate()) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (Util.SDK_INT <= 28 && "audio/ac4".equals(format.sampleMimeType)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        return mediaFormat;
    }

    private void updateCurrentPosition() {
        long currentPositionUs2 = this.audioSink.getCurrentPositionUs(isEnded());
        if (currentPositionUs2 != Long.MIN_VALUE) {
            if (!this.allowPositionDiscontinuity) {
                currentPositionUs2 = Math.max(this.currentPositionUs, currentPositionUs2);
            }
            this.currentPositionUs = currentPositionUs2;
            this.allowPositionDiscontinuity = false;
        }
    }

    private static boolean deviceDoesntSupportOperatingRate() {
        if (Util.SDK_INT == 23) {
            return "ZTE B2017G".equals(Util.MODEL) || "AXON 7 mini".equals(Util.MODEL);
        }
        return false;
    }

    private static boolean codecNeedsDiscardChannelsWorkaround(String str) {
        if (Util.SDK_INT >= 24 || !"OMX.SEC.aac.dec".equals(str) || !"samsung".equals(Util.MANUFACTURER)) {
            return false;
        }
        return Util.DEVICE.startsWith("zeroflte") || Util.DEVICE.startsWith("herolte") || Util.DEVICE.startsWith("heroqlte");
    }

    private static boolean codecNeedsEosBufferTimestampWorkaround(String str) {
        if (Util.SDK_INT >= 21 || !"OMX.SEC.mp3.dec".equals(str) || !"samsung".equals(Util.MANUFACTURER)) {
            return false;
        }
        return Util.DEVICE.startsWith("baffin") || Util.DEVICE.startsWith("grand") || Util.DEVICE.startsWith("fortuna") || Util.DEVICE.startsWith("gprimelte") || Util.DEVICE.startsWith("j2y18lte") || Util.DEVICE.startsWith("ms01");
    }

    private static int getPcmEncoding(Format format) {
        if ("audio/raw".equals(format.sampleMimeType)) {
            return format.pcmEncoding;
        }
        return 2;
    }

    final class AudioSinkListener implements AudioSink.Listener {
        private AudioSinkListener() {
        }

        public final void onAudioSessionId(int i) {
            MediaCodecAudioRenderer.this.eventDispatcher.audioSessionId(i);
            MediaCodecAudioRenderer.this.onAudioSessionId(i);
        }

        public final void onPositionDiscontinuity() {
            MediaCodecAudioRenderer.this.onAudioTrackPositionDiscontinuity();
            MediaCodecAudioRenderer.this.allowPositionDiscontinuity = true;
        }

        public final void onUnderrun(int i, long j, long j2) {
            MediaCodecAudioRenderer.this.eventDispatcher.audioTrackUnderrun(i, j, j2);
            MediaCodecAudioRenderer.this.onAudioTrackUnderrun(i, j, j2);
        }

        public final void onSkipSilenceEnabledChanged(boolean z) {
            MediaCodecAudioRenderer.this.eventDispatcher.skipSilenceEnabledChanged(z);
            MediaCodecAudioRenderer.this.onAudioTrackSkipSilenceEnabledChanged(z);
        }
    }
}
