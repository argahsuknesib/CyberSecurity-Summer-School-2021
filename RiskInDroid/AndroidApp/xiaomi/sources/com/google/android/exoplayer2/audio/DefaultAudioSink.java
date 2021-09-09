package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.AudioTrackPositionTracker;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.common.internal.GmsLogger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class DefaultAudioSink implements AudioSink {
    public static boolean enablePreV21AudioSessionWorkaround = false;
    public static boolean failOnSpuriousAudioTimestamp = false;
    private AudioProcessor[] activeAudioProcessors;
    private MediaPositionParameters afterDrainParameters;
    private AudioAttributes audioAttributes;
    private final AudioCapabilities audioCapabilities;
    private final AudioProcessorChain audioProcessorChain;
    private int audioSessionId;
    private AudioTrack audioTrack;
    private final AudioTrackPositionTracker audioTrackPositionTracker;
    private AuxEffectInfo auxEffectInfo;
    private ByteBuffer avSyncHeader;
    private int bytesUntilNextAvSync;
    private final ChannelMappingAudioProcessor channelMappingAudioProcessor;
    private Configuration configuration;
    private int drainingAudioProcessorIndex;
    private final boolean enableFloatOutput;
    private int framesPerEncodedSample;
    private boolean handledEndOfStream;
    private ByteBuffer inputBuffer;
    private int inputBufferAccessUnitCount;
    private AudioTrack keepSessionIdAudioTrack;
    public long lastFeedElapsedRealtimeMs;
    public AudioSink.Listener listener;
    private MediaPositionParameters mediaPositionParameters;
    private final ArrayDeque<MediaPositionParameters> mediaPositionParametersCheckpoints;
    private ByteBuffer outputBuffer;
    private ByteBuffer[] outputBuffers;
    private Configuration pendingConfiguration;
    private boolean playing;
    private byte[] preV21OutputBuffer;
    private int preV21OutputBufferOffset;
    public final ConditionVariable releasingConditionVariable;
    private long startMediaTimeUs;
    private boolean startMediaTimeUsNeedsSync;
    private boolean stoppedAudioTrack;
    private long submittedEncodedFrames;
    private long submittedPcmBytes;
    private final AudioProcessor[] toFloatPcmAvailableAudioProcessors;
    private final AudioProcessor[] toIntPcmAvailableAudioProcessors;
    private final TrimmingAudioProcessor trimmingAudioProcessor;
    private boolean tunneling;
    private float volume;
    private long writtenEncodedFrames;
    private long writtenPcmBytes;

    public interface AudioProcessorChain {
        @Deprecated
        PlaybackParameters applyPlaybackParameters(PlaybackParameters playbackParameters);

        float applyPlaybackSpeed(float f);

        boolean applySkipSilenceEnabled(boolean z);

        AudioProcessor[] getAudioProcessors();

        long getMediaDuration(long j);

        long getSkippedOutputFrameCount();
    }

    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        private InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    public static class DefaultAudioProcessorChain implements AudioProcessorChain {
        private final AudioProcessor[] audioProcessors;
        private final SilenceSkippingAudioProcessor silenceSkippingAudioProcessor = new SilenceSkippingAudioProcessor();
        private final SonicAudioProcessor sonicAudioProcessor = new SonicAudioProcessor();

        public DefaultAudioProcessorChain(AudioProcessor... audioProcessorArr) {
            this.audioProcessors = new AudioProcessor[(audioProcessorArr.length + 2)];
            System.arraycopy(audioProcessorArr, 0, this.audioProcessors, 0, audioProcessorArr.length);
            AudioProcessor[] audioProcessorArr2 = this.audioProcessors;
            audioProcessorArr2[audioProcessorArr.length] = this.silenceSkippingAudioProcessor;
            audioProcessorArr2[audioProcessorArr.length + 1] = this.sonicAudioProcessor;
        }

        public AudioProcessor[] getAudioProcessors() {
            return this.audioProcessors;
        }

        @Deprecated
        public PlaybackParameters applyPlaybackParameters(PlaybackParameters playbackParameters) {
            return new PlaybackParameters(applyPlaybackSpeed(playbackParameters.speed));
        }

        public float applyPlaybackSpeed(float f) {
            return this.sonicAudioProcessor.setSpeed(f);
        }

        public boolean applySkipSilenceEnabled(boolean z) {
            this.silenceSkippingAudioProcessor.setEnabled(z);
            return z;
        }

        public long getMediaDuration(long j) {
            return this.sonicAudioProcessor.scaleDurationForSpeedup(j);
        }

        public long getSkippedOutputFrameCount() {
            return this.silenceSkippingAudioProcessor.getSkippedFrames();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.exoplayer2.audio.DefaultAudioSink.<init>(com.google.android.exoplayer2.audio.AudioCapabilities, com.google.android.exoplayer2.audio.AudioProcessor[], boolean):void
     arg types: [com.google.android.exoplayer2.audio.AudioCapabilities, com.google.android.exoplayer2.audio.AudioProcessor[], int]
     candidates:
      com.google.android.exoplayer2.audio.DefaultAudioSink.<init>(com.google.android.exoplayer2.audio.AudioCapabilities, com.google.android.exoplayer2.audio.DefaultAudioSink$AudioProcessorChain, boolean):void
      com.google.android.exoplayer2.audio.DefaultAudioSink.<init>(com.google.android.exoplayer2.audio.AudioCapabilities, com.google.android.exoplayer2.audio.AudioProcessor[], boolean):void */
    public DefaultAudioSink(AudioCapabilities audioCapabilities2, AudioProcessor[] audioProcessorArr) {
        this(audioCapabilities2, audioProcessorArr, false);
    }

    public DefaultAudioSink(AudioCapabilities audioCapabilities2, AudioProcessor[] audioProcessorArr, boolean z) {
        this(audioCapabilities2, new DefaultAudioProcessorChain(audioProcessorArr), z);
    }

    public DefaultAudioSink(AudioCapabilities audioCapabilities2, AudioProcessorChain audioProcessorChain2, boolean z) {
        this.audioCapabilities = audioCapabilities2;
        this.audioProcessorChain = (AudioProcessorChain) Assertions.checkNotNull(audioProcessorChain2);
        this.enableFloatOutput = z;
        this.releasingConditionVariable = new ConditionVariable(true);
        this.audioTrackPositionTracker = new AudioTrackPositionTracker(new PositionTrackerListener());
        this.channelMappingAudioProcessor = new ChannelMappingAudioProcessor();
        this.trimmingAudioProcessor = new TrimmingAudioProcessor();
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new ResamplingAudioProcessor(), this.channelMappingAudioProcessor, this.trimmingAudioProcessor);
        Collections.addAll(arrayList, audioProcessorChain2.getAudioProcessors());
        this.toIntPcmAvailableAudioProcessors = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[0]);
        this.toFloatPcmAvailableAudioProcessors = new AudioProcessor[]{new FloatResamplingAudioProcessor()};
        this.volume = 1.0f;
        this.audioAttributes = AudioAttributes.DEFAULT;
        this.audioSessionId = 0;
        this.auxEffectInfo = new AuxEffectInfo(0, 0.0f);
        this.mediaPositionParameters = new MediaPositionParameters(1.0f, false, 0, 0);
        this.drainingAudioProcessorIndex = -1;
        this.activeAudioProcessors = new AudioProcessor[0];
        this.outputBuffers = new ByteBuffer[0];
        this.mediaPositionParametersCheckpoints = new ArrayDeque<>();
    }

    public final void setListener(AudioSink.Listener listener2) {
        this.listener = listener2;
    }

    public final boolean supportsOutput(int i, int i2) {
        if (Util.isEncodingLinearPcm(i2)) {
            return i2 != 4 || Util.SDK_INT >= 21;
        }
        AudioCapabilities audioCapabilities2 = this.audioCapabilities;
        return audioCapabilities2 != null && audioCapabilities2.supportsEncoding(i2) && (i == -1 || i <= this.audioCapabilities.getMaxChannelCount());
    }

    public final long getCurrentPositionUs(boolean z) {
        if (!isInitialized()) {
            return Long.MIN_VALUE;
        }
        return applySkipping(applyMediaPositionParameters(Math.min(this.audioTrackPositionTracker.getCurrentPositionUs(z), this.configuration.framesToDurationUs(getWrittenFrames()))));
    }

    public final void configure(int i, int i2, int i3, int i4, int[] iArr, int i5, int i6) throws AudioSink.ConfigurationException {
        int[] iArr2;
        int i7;
        int i8;
        int i9;
        int i10 = i2;
        boolean z = false;
        if (Util.SDK_INT < 21 && i10 == 8 && iArr == null) {
            iArr2 = new int[6];
            for (int i11 = 0; i11 < 6; i11++) {
                iArr2[i11] = i11;
            }
        } else {
            iArr2 = iArr;
        }
        boolean isEncodingLinearPcm = Util.isEncodingLinearPcm(i);
        boolean z2 = this.enableFloatOutput && supportsOutput(i10, 4) && Util.isEncodingHighResolutionPcm(i);
        AudioProcessor[] audioProcessorArr = z2 ? this.toFloatPcmAvailableAudioProcessors : this.toIntPcmAvailableAudioProcessors;
        if (isEncodingLinearPcm) {
            this.trimmingAudioProcessor.setTrimFrameCount(i5, i6);
            this.channelMappingAudioProcessor.setChannelMap(iArr2);
            AudioProcessor.AudioFormat audioFormat = new AudioProcessor.AudioFormat(i3, i10, i);
            int length = audioProcessorArr.length;
            AudioProcessor.AudioFormat audioFormat2 = audioFormat;
            int i12 = 0;
            while (i12 < length) {
                AudioProcessor audioProcessor = audioProcessorArr[i12];
                try {
                    AudioProcessor.AudioFormat configure = audioProcessor.configure(audioFormat2);
                    if (audioProcessor.isActive()) {
                        audioFormat2 = configure;
                    }
                    i12++;
                } catch (AudioProcessor.UnhandledAudioFormatException e) {
                    throw new AudioSink.ConfigurationException(e);
                }
            }
            int i13 = audioFormat2.sampleRate;
            i9 = audioFormat2.channelCount;
            i8 = i13;
            i7 = audioFormat2.encoding;
        } else {
            i9 = i10;
            i7 = i;
            i8 = i3;
        }
        int channelConfig = getChannelConfig(i9, isEncodingLinearPcm);
        if (channelConfig != 0) {
            int pcmFrameSize = isEncodingLinearPcm ? Util.getPcmFrameSize(i, i2) : -1;
            int pcmFrameSize2 = isEncodingLinearPcm ? Util.getPcmFrameSize(i7, i9) : -1;
            if (isEncodingLinearPcm && !z2) {
                z = true;
            }
            Configuration configuration2 = new Configuration(isEncodingLinearPcm, pcmFrameSize, i3, pcmFrameSize2, i8, channelConfig, i7, i4, isEncodingLinearPcm, z, audioProcessorArr);
            if (isInitialized()) {
                this.pendingConfiguration = configuration2;
            } else {
                this.configuration = configuration2;
            }
        } else {
            throw new AudioSink.ConfigurationException("Unsupported channel count: ".concat(String.valueOf(i9)));
        }
    }

    private void setupAudioProcessors() {
        AudioProcessor[] audioProcessorArr = this.configuration.availableAudioProcessors;
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : audioProcessorArr) {
            if (audioProcessor.isActive()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.activeAudioProcessors = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.outputBuffers = new ByteBuffer[size];
        flushAudioProcessors();
    }

    private void flushAudioProcessors() {
        int i = 0;
        while (true) {
            AudioProcessor[] audioProcessorArr = this.activeAudioProcessors;
            if (i < audioProcessorArr.length) {
                AudioProcessor audioProcessor = audioProcessorArr[i];
                audioProcessor.flush();
                this.outputBuffers[i] = audioProcessor.getOutput();
                i++;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    private void initialize(long j) throws AudioSink.InitializationException {
        this.releasingConditionVariable.block();
        this.audioTrack = ((Configuration) Assertions.checkNotNull(this.configuration)).buildAudioTrack(this.tunneling, this.audioAttributes, this.audioSessionId);
        int audioSessionId2 = this.audioTrack.getAudioSessionId();
        if (enablePreV21AudioSessionWorkaround && Util.SDK_INT < 21) {
            AudioTrack audioTrack2 = this.keepSessionIdAudioTrack;
            if (!(audioTrack2 == null || audioSessionId2 == audioTrack2.getAudioSessionId())) {
                releaseKeepSessionIdAudioTrack();
            }
            if (this.keepSessionIdAudioTrack == null) {
                this.keepSessionIdAudioTrack = initializeKeepSessionIdAudioTrack(audioSessionId2);
            }
        }
        if (this.audioSessionId != audioSessionId2) {
            this.audioSessionId = audioSessionId2;
            AudioSink.Listener listener2 = this.listener;
            if (listener2 != null) {
                listener2.onAudioSessionId(audioSessionId2);
            }
        }
        this.startMediaTimeUs = Math.max(0L, j);
        this.startMediaTimeUsNeedsSync = false;
        applyPlaybackSpeedAndSkipSilence(j);
        this.audioTrackPositionTracker.setAudioTrack(this.audioTrack, this.configuration.outputEncoding, this.configuration.outputPcmFrameSize, this.configuration.bufferSize);
        setVolumeInternal();
        if (this.auxEffectInfo.effectId != 0) {
            this.audioTrack.attachAuxEffect(this.auxEffectInfo.effectId);
            this.audioTrack.setAuxEffectSendLevel(this.auxEffectInfo.sendLevel);
        }
    }

    public final void play() {
        this.playing = true;
        if (isInitialized()) {
            this.audioTrackPositionTracker.start();
            this.audioTrack.play();
        }
    }

    public final void handleDiscontinuity() {
        this.startMediaTimeUsNeedsSync = true;
    }

    public final boolean handleBuffer(ByteBuffer byteBuffer, long j, int i) throws AudioSink.InitializationException, AudioSink.WriteException {
        ByteBuffer byteBuffer2 = this.inputBuffer;
        Assertions.checkArgument(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.pendingConfiguration != null) {
            if (!drainToEndOfStream()) {
                return false;
            }
            if (!this.pendingConfiguration.canReuseAudioTrack(this.configuration)) {
                playPendingData();
                if (hasPendingData()) {
                    return false;
                }
                flush();
            } else {
                this.configuration = this.pendingConfiguration;
                this.pendingConfiguration = null;
            }
            applyPlaybackSpeedAndSkipSilence(j);
        }
        if (!isInitialized()) {
            initialize(j);
            if (this.playing) {
                play();
            }
        }
        if (!this.audioTrackPositionTracker.mayHandleBuffer(getWrittenFrames())) {
            return false;
        }
        if (this.inputBuffer == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (!this.configuration.isInputPcm && this.framesPerEncodedSample == 0) {
                this.framesPerEncodedSample = getFramesPerEncodedSample(this.configuration.outputEncoding, byteBuffer);
                if (this.framesPerEncodedSample == 0) {
                    return true;
                }
            }
            if (this.afterDrainParameters != null) {
                if (!drainToEndOfStream()) {
                    return false;
                }
                applyPlaybackSpeedAndSkipSilence(j);
                this.afterDrainParameters = null;
            }
            long inputFramesToDurationUs = this.startMediaTimeUs + this.configuration.inputFramesToDurationUs(getSubmittedFrames() - this.trimmingAudioProcessor.getTrimmedFrameCount());
            if (!this.startMediaTimeUsNeedsSync && Math.abs(inputFramesToDurationUs - j) > 200000) {
                Log.e("AudioTrack", "Discontinuity detected [expected " + inputFramesToDurationUs + ", got " + j + "]");
                this.startMediaTimeUsNeedsSync = true;
            }
            if (this.startMediaTimeUsNeedsSync) {
                if (!drainToEndOfStream()) {
                    return false;
                }
                long j2 = j - inputFramesToDurationUs;
                this.startMediaTimeUs += j2;
                this.startMediaTimeUsNeedsSync = false;
                applyPlaybackSpeedAndSkipSilence(j);
                AudioSink.Listener listener2 = this.listener;
                if (!(listener2 == null || j2 == 0)) {
                    listener2.onPositionDiscontinuity();
                }
            }
            if (this.configuration.isInputPcm) {
                this.submittedPcmBytes += (long) byteBuffer.remaining();
            } else {
                this.submittedEncodedFrames += (long) (this.framesPerEncodedSample * i);
            }
            this.inputBuffer = byteBuffer;
            this.inputBufferAccessUnitCount = i;
        }
        processBuffers(j);
        if (!this.inputBuffer.hasRemaining()) {
            this.inputBuffer = null;
            this.inputBufferAccessUnitCount = 0;
            return true;
        } else if (!this.audioTrackPositionTracker.isStalled(getWrittenFrames())) {
            return false;
        } else {
            Log.w("AudioTrack", "Resetting stalled audio track");
            flush();
            return true;
        }
    }

    private void processBuffers(long j) throws AudioSink.WriteException {
        ByteBuffer byteBuffer;
        int length = this.activeAudioProcessors.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.outputBuffers[i - 1];
            } else {
                byteBuffer = this.inputBuffer;
                if (byteBuffer == null) {
                    byteBuffer = AudioProcessor.EMPTY_BUFFER;
                }
            }
            if (i == length) {
                writeBuffer(byteBuffer, j);
            } else {
                AudioProcessor audioProcessor = this.activeAudioProcessors[i];
                audioProcessor.queueInput(byteBuffer);
                ByteBuffer output = audioProcessor.getOutput();
                this.outputBuffers[i] = output;
                if (output.hasRemaining()) {
                    i++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i--;
            } else {
                return;
            }
        }
    }

    private void writeBuffer(ByteBuffer byteBuffer, long j) throws AudioSink.WriteException {
        int i;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.outputBuffer;
            boolean z = true;
            if (byteBuffer2 != null) {
                Assertions.checkArgument(byteBuffer2 == byteBuffer);
            } else {
                this.outputBuffer = byteBuffer;
                if (Util.SDK_INT < 21) {
                    int remaining = byteBuffer.remaining();
                    byte[] bArr = this.preV21OutputBuffer;
                    if (bArr == null || bArr.length < remaining) {
                        this.preV21OutputBuffer = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.preV21OutputBuffer, 0, remaining);
                    byteBuffer.position(position);
                    this.preV21OutputBufferOffset = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (Util.SDK_INT < 21) {
                int availableBufferSize = this.audioTrackPositionTracker.getAvailableBufferSize(this.writtenPcmBytes);
                if (availableBufferSize > 0) {
                    i = this.audioTrack.write(this.preV21OutputBuffer, this.preV21OutputBufferOffset, Math.min(remaining2, availableBufferSize));
                    if (i > 0) {
                        this.preV21OutputBufferOffset += i;
                        byteBuffer.position(byteBuffer.position() + i);
                    }
                } else {
                    i = 0;
                }
            } else if (this.tunneling) {
                Assertions.checkState(j != -9223372036854775807L);
                i = writeNonBlockingWithAvSyncV21(this.audioTrack, byteBuffer, remaining2, j);
            } else {
                i = writeNonBlockingV21(this.audioTrack, byteBuffer, remaining2);
            }
            this.lastFeedElapsedRealtimeMs = SystemClock.elapsedRealtime();
            if (i >= 0) {
                if (this.configuration.isInputPcm) {
                    this.writtenPcmBytes += (long) i;
                }
                if (i == remaining2) {
                    if (!this.configuration.isInputPcm) {
                        if (byteBuffer != this.inputBuffer) {
                            z = false;
                        }
                        Assertions.checkState(z);
                        this.writtenEncodedFrames += (long) (this.framesPerEncodedSample * this.inputBufferAccessUnitCount);
                    }
                    this.outputBuffer = null;
                    return;
                }
                return;
            }
            throw new AudioSink.WriteException(i);
        }
    }

    public final void playToEndOfStream() throws AudioSink.WriteException {
        if (!this.handledEndOfStream && isInitialized() && drainToEndOfStream()) {
            playPendingData();
            this.handledEndOfStream = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003e  */
    private boolean drainToEndOfStream() throws AudioSink.WriteException {
        boolean z;
        int i;
        AudioProcessor[] audioProcessorArr;
        ByteBuffer byteBuffer;
        if (this.drainingAudioProcessorIndex == -1) {
            this.drainingAudioProcessorIndex = this.configuration.processingEnabled ? 0 : this.activeAudioProcessors.length;
        } else {
            z = false;
            i = this.drainingAudioProcessorIndex;
            audioProcessorArr = this.activeAudioProcessors;
            if (i >= audioProcessorArr.length) {
                AudioProcessor audioProcessor = audioProcessorArr[i];
                if (z) {
                    audioProcessor.queueEndOfStream();
                }
                processBuffers(-9223372036854775807L);
                if (!audioProcessor.isEnded()) {
                    return false;
                }
                this.drainingAudioProcessorIndex++;
                return false;
            }
            byteBuffer = this.outputBuffer;
            if (byteBuffer != null) {
                writeBuffer(byteBuffer, -9223372036854775807L);
                if (this.outputBuffer != null) {
                    return false;
                }
            }
            this.drainingAudioProcessorIndex = -1;
            return true;
        }
        z = true;
        i = this.drainingAudioProcessorIndex;
        audioProcessorArr = this.activeAudioProcessors;
        if (i >= audioProcessorArr.length) {
            byteBuffer = this.outputBuffer;
        }
        byteBuffer = this.outputBuffer;
        if (byteBuffer != null) {
        }
        this.drainingAudioProcessorIndex = -1;
        return true;
    }

    public final boolean isEnded() {
        if (isInitialized()) {
            return this.handledEndOfStream && !hasPendingData();
        }
        return true;
    }

    public final boolean hasPendingData() {
        return isInitialized() && this.audioTrackPositionTracker.hasPendingData(getWrittenFrames());
    }

    @Deprecated
    public final void setPlaybackParameters(PlaybackParameters playbackParameters) {
        setPlaybackSpeedAndSkipSilence(playbackParameters.speed, getSkipSilenceEnabled());
    }

    @Deprecated
    public final PlaybackParameters getPlaybackParameters() {
        return new PlaybackParameters(getMediaPositionParameters().playbackSpeed);
    }

    public final void setPlaybackSpeed(float f) {
        setPlaybackSpeedAndSkipSilence(f, getSkipSilenceEnabled());
    }

    public final float getPlaybackSpeed() {
        return getMediaPositionParameters().playbackSpeed;
    }

    public final void setSkipSilenceEnabled(boolean z) {
        setPlaybackSpeedAndSkipSilence(getPlaybackSpeed(), z);
    }

    public final boolean getSkipSilenceEnabled() {
        return getMediaPositionParameters().skipSilence;
    }

    public final void setAudioAttributes(AudioAttributes audioAttributes2) {
        if (!this.audioAttributes.equals(audioAttributes2)) {
            this.audioAttributes = audioAttributes2;
            if (!this.tunneling) {
                flush();
                this.audioSessionId = 0;
            }
        }
    }

    public final void setAudioSessionId(int i) {
        if (this.audioSessionId != i) {
            this.audioSessionId = i;
            flush();
        }
    }

    public final void setAuxEffectInfo(AuxEffectInfo auxEffectInfo2) {
        if (!this.auxEffectInfo.equals(auxEffectInfo2)) {
            int i = auxEffectInfo2.effectId;
            float f = auxEffectInfo2.sendLevel;
            if (this.audioTrack != null) {
                if (this.auxEffectInfo.effectId != i) {
                    this.audioTrack.attachAuxEffect(i);
                }
                if (i != 0) {
                    this.audioTrack.setAuxEffectSendLevel(f);
                }
            }
            this.auxEffectInfo = auxEffectInfo2;
        }
    }

    public final void enableTunnelingV21(int i) {
        Assertions.checkState(Util.SDK_INT >= 21);
        if (!this.tunneling || this.audioSessionId != i) {
            this.tunneling = true;
            this.audioSessionId = i;
            flush();
        }
    }

    public final void disableTunneling() {
        if (this.tunneling) {
            this.tunneling = false;
            this.audioSessionId = 0;
            flush();
        }
    }

    public final void setVolume(float f) {
        if (this.volume != f) {
            this.volume = f;
            setVolumeInternal();
        }
    }

    private void setVolumeInternal() {
        if (!isInitialized()) {
            return;
        }
        if (Util.SDK_INT >= 21) {
            setVolumeInternalV21(this.audioTrack, this.volume);
        } else {
            setVolumeInternalV3(this.audioTrack, this.volume);
        }
    }

    public final void pause() {
        this.playing = false;
        if (isInitialized() && this.audioTrackPositionTracker.pause()) {
            this.audioTrack.pause();
        }
    }

    public final void flush() {
        if (isInitialized()) {
            this.submittedPcmBytes = 0;
            this.submittedEncodedFrames = 0;
            this.writtenPcmBytes = 0;
            this.writtenEncodedFrames = 0;
            this.framesPerEncodedSample = 0;
            this.mediaPositionParameters = new MediaPositionParameters(getPlaybackSpeed(), getSkipSilenceEnabled(), 0, 0);
            this.startMediaTimeUs = 0;
            this.afterDrainParameters = null;
            this.mediaPositionParametersCheckpoints.clear();
            this.trimmingAudioProcessor.resetTrimmedFrameCount();
            flushAudioProcessors();
            this.inputBuffer = null;
            this.inputBufferAccessUnitCount = 0;
            this.outputBuffer = null;
            this.stoppedAudioTrack = false;
            this.handledEndOfStream = false;
            this.drainingAudioProcessorIndex = -1;
            this.avSyncHeader = null;
            this.bytesUntilNextAvSync = 0;
            if (this.audioTrackPositionTracker.isPlaying()) {
                this.audioTrack.pause();
            }
            final AudioTrack audioTrack2 = this.audioTrack;
            this.audioTrack = null;
            Configuration configuration2 = this.pendingConfiguration;
            if (configuration2 != null) {
                this.configuration = configuration2;
                this.pendingConfiguration = null;
            }
            this.audioTrackPositionTracker.reset();
            this.releasingConditionVariable.close();
            new Thread("ExoPlayer:AudioTrackReleaseThread") {
                /* class com.google.android.exoplayer2.audio.DefaultAudioSink.AnonymousClass1 */

                public void run() {
                    try {
                        audioTrack2.flush();
                        audioTrack2.release();
                    } finally {
                        DefaultAudioSink.this.releasingConditionVariable.open();
                    }
                }
            }.start();
        }
    }

    public final void reset() {
        flush();
        releaseKeepSessionIdAudioTrack();
        for (AudioProcessor reset : this.toIntPcmAvailableAudioProcessors) {
            reset.reset();
        }
        for (AudioProcessor reset2 : this.toFloatPcmAvailableAudioProcessors) {
            reset2.reset();
        }
        this.audioSessionId = 0;
        this.playing = false;
    }

    private void releaseKeepSessionIdAudioTrack() {
        final AudioTrack audioTrack2 = this.keepSessionIdAudioTrack;
        if (audioTrack2 != null) {
            this.keepSessionIdAudioTrack = null;
            new Thread() {
                /* class com.google.android.exoplayer2.audio.DefaultAudioSink.AnonymousClass2 */

                public void run() {
                    audioTrack2.release();
                }
            }.start();
        }
    }

    private void setPlaybackSpeedAndSkipSilence(float f, boolean z) {
        MediaPositionParameters mediaPositionParameters2 = getMediaPositionParameters();
        if (f != mediaPositionParameters2.playbackSpeed || z != mediaPositionParameters2.skipSilence) {
            MediaPositionParameters mediaPositionParameters3 = new MediaPositionParameters(f, z, -9223372036854775807L, -9223372036854775807L);
            if (isInitialized()) {
                this.afterDrainParameters = mediaPositionParameters3;
            } else {
                this.mediaPositionParameters = mediaPositionParameters3;
            }
        }
    }

    private MediaPositionParameters getMediaPositionParameters() {
        MediaPositionParameters mediaPositionParameters2 = this.afterDrainParameters;
        if (mediaPositionParameters2 != null) {
            return mediaPositionParameters2;
        }
        return !this.mediaPositionParametersCheckpoints.isEmpty() ? this.mediaPositionParametersCheckpoints.getLast() : this.mediaPositionParameters;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    private void applyPlaybackSpeedAndSkipSilence(long j) {
        float applyPlaybackSpeed = this.configuration.canApplyPlaybackParameters ? this.audioProcessorChain.applyPlaybackSpeed(getPlaybackSpeed()) : 1.0f;
        boolean applySkipSilenceEnabled = this.configuration.canApplyPlaybackParameters ? this.audioProcessorChain.applySkipSilenceEnabled(getSkipSilenceEnabled()) : false;
        this.mediaPositionParametersCheckpoints.add(new MediaPositionParameters(applyPlaybackSpeed, applySkipSilenceEnabled, Math.max(0L, j), this.configuration.framesToDurationUs(getWrittenFrames())));
        setupAudioProcessors();
        AudioSink.Listener listener2 = this.listener;
        if (listener2 != null) {
            listener2.onSkipSilenceEnabledChanged(applySkipSilenceEnabled);
        }
    }

    private long applyMediaPositionParameters(long j) {
        while (!this.mediaPositionParametersCheckpoints.isEmpty() && j >= this.mediaPositionParametersCheckpoints.getFirst().audioTrackPositionUs) {
            this.mediaPositionParameters = this.mediaPositionParametersCheckpoints.remove();
        }
        long j2 = j - this.mediaPositionParameters.audioTrackPositionUs;
        if (this.mediaPositionParameters.playbackSpeed != 1.0f) {
            if (this.mediaPositionParametersCheckpoints.isEmpty()) {
                j2 = this.audioProcessorChain.getMediaDuration(j2);
            } else {
                j2 = Util.getMediaDurationForPlayoutDuration(j2, this.mediaPositionParameters.playbackSpeed);
            }
        }
        return this.mediaPositionParameters.mediaTimeUs + j2;
    }

    private long applySkipping(long j) {
        return j + this.configuration.framesToDurationUs(this.audioProcessorChain.getSkippedOutputFrameCount());
    }

    private boolean isInitialized() {
        return this.audioTrack != null;
    }

    public final long getSubmittedFrames() {
        return this.configuration.isInputPcm ? this.submittedPcmBytes / ((long) this.configuration.inputPcmFrameSize) : this.submittedEncodedFrames;
    }

    public final long getWrittenFrames() {
        return this.configuration.isInputPcm ? this.writtenPcmBytes / ((long) this.configuration.outputPcmFrameSize) : this.writtenEncodedFrames;
    }

    private static AudioTrack initializeKeepSessionIdAudioTrack(int i) {
        return new AudioTrack(3, 4000, 4, 2, 2, 0, i);
    }

    private static int getChannelConfig(int i, boolean z) {
        if (Util.SDK_INT <= 28 && !z) {
            if (i == 7) {
                i = 8;
            } else if (i == 3 || i == 4 || i == 5) {
                i = 6;
            }
        }
        if (Util.SDK_INT <= 26 && "fugu".equals(Util.DEVICE) && !z && i == 1) {
            i = 2;
        }
        return Util.getAudioTrackChannelConfig(i);
    }

    public static int getMaximumEncodedRateBytesPerSecond(int i) {
        switch (i) {
            case 5:
                return 80000;
            case 6:
            case 18:
                return 768000;
            case 7:
                return 192000;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return 7000;
            case 13:
            default:
                throw new IllegalArgumentException();
            case 14:
                return 3062500;
            case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                return 8000;
            case 16:
                return 256000;
            case 17:
                return 336000;
        }
    }

    private static int getFramesPerEncodedSample(int i, ByteBuffer byteBuffer) {
        switch (i) {
            case 5:
            case 6:
            case 18:
                return Ac3Util.parseAc3SyncframeAudioSampleCount(byteBuffer);
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return DtsUtil.parseDtsAudioSampleCount(byteBuffer);
            case 9:
                return MpegAudioUtil.parseMpegAudioFrameSampleCount(byteBuffer.get(byteBuffer.position()));
            case 10:
                return 1024;
            case 11:
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return 2048;
            case 13:
            default:
                throw new IllegalStateException("Unexpected audio encoding: ".concat(String.valueOf(i)));
            case 14:
                int findTrueHdSyncframeOffset = Ac3Util.findTrueHdSyncframeOffset(byteBuffer);
                if (findTrueHdSyncframeOffset == -1) {
                    return 0;
                }
                return Ac3Util.parseTrueHdSyncframeAudioSampleCount(byteBuffer, findTrueHdSyncframeOffset) * 16;
            case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                return 512;
            case 16:
                return 1024;
            case 17:
                return Ac4Util.parseAc4SyncframeAudioSampleCount(byteBuffer);
        }
    }

    private static int writeNonBlockingV21(AudioTrack audioTrack2, ByteBuffer byteBuffer, int i) {
        return audioTrack2.write(byteBuffer, i, 1);
    }

    private int writeNonBlockingWithAvSyncV21(AudioTrack audioTrack2, ByteBuffer byteBuffer, int i, long j) {
        if (Util.SDK_INT >= 26) {
            return audioTrack2.write(byteBuffer, i, 1, j * 1000);
        }
        if (this.avSyncHeader == null) {
            this.avSyncHeader = ByteBuffer.allocate(16);
            this.avSyncHeader.order(ByteOrder.BIG_ENDIAN);
            this.avSyncHeader.putInt(1431633921);
        }
        if (this.bytesUntilNextAvSync == 0) {
            this.avSyncHeader.putInt(4, i);
            this.avSyncHeader.putLong(8, j * 1000);
            this.avSyncHeader.position(0);
            this.bytesUntilNextAvSync = i;
        }
        int remaining = this.avSyncHeader.remaining();
        if (remaining > 0) {
            int write = audioTrack2.write(this.avSyncHeader, remaining, 1);
            if (write < 0) {
                this.bytesUntilNextAvSync = 0;
                return write;
            } else if (write < remaining) {
                return 0;
            }
        }
        int writeNonBlockingV21 = writeNonBlockingV21(audioTrack2, byteBuffer, i);
        if (writeNonBlockingV21 < 0) {
            this.bytesUntilNextAvSync = 0;
            return writeNonBlockingV21;
        }
        this.bytesUntilNextAvSync -= writeNonBlockingV21;
        return writeNonBlockingV21;
    }

    private static void setVolumeInternalV21(AudioTrack audioTrack2, float f) {
        audioTrack2.setVolume(f);
    }

    private static void setVolumeInternalV3(AudioTrack audioTrack2, float f) {
        audioTrack2.setStereoVolume(f, f);
    }

    private void playPendingData() {
        if (!this.stoppedAudioTrack) {
            this.stoppedAudioTrack = true;
            this.audioTrackPositionTracker.handleEndOfStream(getWrittenFrames());
            this.audioTrack.stop();
            this.bytesUntilNextAvSync = 0;
        }
    }

    static final class MediaPositionParameters {
        public final long audioTrackPositionUs;
        public final long mediaTimeUs;
        public final float playbackSpeed;
        public final boolean skipSilence;

        private MediaPositionParameters(float f, boolean z, long j, long j2) {
            this.playbackSpeed = f;
            this.skipSilence = z;
            this.mediaTimeUs = j;
            this.audioTrackPositionUs = j2;
        }
    }

    final class PositionTrackerListener implements AudioTrackPositionTracker.Listener {
        private PositionTrackerListener() {
        }

        public final void onPositionFramesMismatch(long j, long j2, long j3, long j4) {
            String str = "Spurious audio timestamp (frame position mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + DefaultAudioSink.this.getSubmittedFrames() + ", " + DefaultAudioSink.this.getWrittenFrames();
            if (!DefaultAudioSink.failOnSpuriousAudioTimestamp) {
                Log.w("AudioTrack", str);
                return;
            }
            throw new InvalidAudioTrackTimestampException(str);
        }

        public final void onSystemTimeUsMismatch(long j, long j2, long j3, long j4) {
            String str = "Spurious audio timestamp (system clock mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + DefaultAudioSink.this.getSubmittedFrames() + ", " + DefaultAudioSink.this.getWrittenFrames();
            if (!DefaultAudioSink.failOnSpuriousAudioTimestamp) {
                Log.w("AudioTrack", str);
                return;
            }
            throw new InvalidAudioTrackTimestampException(str);
        }

        public final void onInvalidLatency(long j) {
            Log.w("AudioTrack", "Ignoring impossibly large audio latency: ".concat(String.valueOf(j)));
        }

        public final void onUnderrun(int i, long j) {
            if (DefaultAudioSink.this.listener != null) {
                DefaultAudioSink.this.listener.onUnderrun(i, j, SystemClock.elapsedRealtime() - DefaultAudioSink.this.lastFeedElapsedRealtimeMs);
            }
        }
    }

    static final class Configuration {
        public final AudioProcessor[] availableAudioProcessors;
        public final int bufferSize;
        public final boolean canApplyPlaybackParameters;
        public final int inputPcmFrameSize;
        public final int inputSampleRate;
        public final boolean isInputPcm;
        public final int outputChannelConfig;
        public final int outputEncoding;
        public final int outputPcmFrameSize;
        public final int outputSampleRate;
        public final boolean processingEnabled;

        public Configuration(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z2, boolean z3, AudioProcessor[] audioProcessorArr) {
            this.isInputPcm = z;
            this.inputPcmFrameSize = i;
            this.inputSampleRate = i2;
            this.outputPcmFrameSize = i3;
            this.outputSampleRate = i4;
            this.outputChannelConfig = i5;
            this.outputEncoding = i6;
            this.bufferSize = i7 == 0 ? getDefaultBufferSize() : i7;
            this.processingEnabled = z2;
            this.canApplyPlaybackParameters = z3;
            this.availableAudioProcessors = audioProcessorArr;
        }

        public final boolean canReuseAudioTrack(Configuration configuration) {
            return configuration.outputEncoding == this.outputEncoding && configuration.outputSampleRate == this.outputSampleRate && configuration.outputChannelConfig == this.outputChannelConfig;
        }

        public final long inputFramesToDurationUs(long j) {
            return (j * 1000000) / ((long) this.inputSampleRate);
        }

        public final long framesToDurationUs(long j) {
            return (j * 1000000) / ((long) this.outputSampleRate);
        }

        public final long durationUsToFrames(long j) {
            return (j * ((long) this.outputSampleRate)) / 1000000;
        }

        public final AudioTrack buildAudioTrack(boolean z, AudioAttributes audioAttributes, int i) throws AudioSink.InitializationException {
            AudioTrack audioTrack;
            if (Util.SDK_INT >= 21) {
                audioTrack = createAudioTrackV21(z, audioAttributes, i);
            } else {
                int streamTypeForAudioUsage = Util.getStreamTypeForAudioUsage(audioAttributes.usage);
                if (i == 0) {
                    audioTrack = new AudioTrack(streamTypeForAudioUsage, this.outputSampleRate, this.outputChannelConfig, this.outputEncoding, this.bufferSize, 1);
                } else {
                    audioTrack = new AudioTrack(streamTypeForAudioUsage, this.outputSampleRate, this.outputChannelConfig, this.outputEncoding, this.bufferSize, 1, i);
                }
            }
            int state = audioTrack.getState();
            if (state == 1) {
                return audioTrack;
            }
            try {
                audioTrack.release();
            } catch (Exception unused) {
            }
            throw new AudioSink.InitializationException(state, this.outputSampleRate, this.outputChannelConfig, this.bufferSize);
        }

        private AudioTrack createAudioTrackV21(boolean z, AudioAttributes audioAttributes, int i) {
            AudioAttributes audioAttributes2;
            if (z) {
                audioAttributes2 = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
            } else {
                audioAttributes2 = audioAttributes.getAudioAttributesV21();
            }
            return new AudioTrack(audioAttributes2, new AudioFormat.Builder().setChannelMask(this.outputChannelConfig).setEncoding(this.outputEncoding).setSampleRate(this.outputSampleRate).build(), this.bufferSize, 1, i != 0 ? i : 0);
        }

        private int getDefaultBufferSize() {
            if (this.isInputPcm) {
                int minBufferSize = AudioTrack.getMinBufferSize(this.outputSampleRate, this.outputChannelConfig, this.outputEncoding);
                Assertions.checkState(minBufferSize != -2);
                return Util.constrainValue(minBufferSize * 4, ((int) durationUsToFrames(250000)) * this.outputPcmFrameSize, (int) Math.max((long) minBufferSize, durationUsToFrames(750000) * ((long) this.outputPcmFrameSize)));
            }
            int maximumEncodedRateBytesPerSecond = DefaultAudioSink.getMaximumEncodedRateBytesPerSecond(this.outputEncoding);
            if (this.outputEncoding == 5) {
                maximumEncodedRateBytesPerSecond *= 2;
            }
            return (int) ((((long) maximumEncodedRateBytesPerSecond) * 250000) / 1000000);
        }
    }
}
