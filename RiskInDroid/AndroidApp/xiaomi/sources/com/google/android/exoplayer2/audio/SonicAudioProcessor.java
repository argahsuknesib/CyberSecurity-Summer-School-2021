package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class SonicAudioProcessor implements AudioProcessor {
    private ByteBuffer buffer = EMPTY_BUFFER;
    private AudioProcessor.AudioFormat inputAudioFormat = AudioProcessor.AudioFormat.NOT_SET;
    private long inputBytes;
    private boolean inputEnded;
    private AudioProcessor.AudioFormat outputAudioFormat = AudioProcessor.AudioFormat.NOT_SET;
    private ByteBuffer outputBuffer = EMPTY_BUFFER;
    private long outputBytes;
    private AudioProcessor.AudioFormat pendingInputAudioFormat = AudioProcessor.AudioFormat.NOT_SET;
    private AudioProcessor.AudioFormat pendingOutputAudioFormat = AudioProcessor.AudioFormat.NOT_SET;
    private int pendingOutputSampleRate = -1;
    private boolean pendingSonicRecreation;
    private ShortBuffer shortBuffer = this.buffer.asShortBuffer();
    private Sonic sonic;
    private float speed = 1.0f;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.exoplayer2.util.Util.constrainValue(float, float, float):float
     arg types: [float, int, int]
     candidates:
      com.google.android.exoplayer2.util.Util.constrainValue(int, int, int):int
      com.google.android.exoplayer2.util.Util.constrainValue(long, long, long):long
      com.google.android.exoplayer2.util.Util.constrainValue(float, float, float):float */
    public final float setSpeed(float f) {
        float constrainValue = Util.constrainValue(f, 0.1f, 8.0f);
        if (this.speed != constrainValue) {
            this.speed = constrainValue;
            this.pendingSonicRecreation = true;
        }
        return constrainValue;
    }

    public final void setOutputSampleRateHz(int i) {
        this.pendingOutputSampleRate = i;
    }

    public final long scaleDurationForSpeedup(long j) {
        if (this.outputBytes < 1024) {
            double d = (double) this.speed;
            double d2 = (double) j;
            Double.isNaN(d);
            Double.isNaN(d2);
            return (long) (d * d2);
        } else if (this.outputAudioFormat.sampleRate == this.inputAudioFormat.sampleRate) {
            return Util.scaleLargeTimestamp(j, this.inputBytes, this.outputBytes);
        } else {
            return Util.scaleLargeTimestamp(j, this.inputBytes * ((long) this.outputAudioFormat.sampleRate), this.outputBytes * ((long) this.inputAudioFormat.sampleRate));
        }
    }

    public final AudioProcessor.AudioFormat configure(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.encoding == 2) {
            int i = this.pendingOutputSampleRate;
            if (i == -1) {
                i = audioFormat.sampleRate;
            }
            this.pendingInputAudioFormat = audioFormat;
            this.pendingOutputAudioFormat = new AudioProcessor.AudioFormat(i, audioFormat.channelCount, 2);
            this.pendingSonicRecreation = true;
            return this.pendingOutputAudioFormat;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    public final boolean isActive() {
        if (this.pendingOutputAudioFormat.sampleRate != -1) {
            return Math.abs(this.speed - 1.0f) >= 0.01f || this.pendingOutputAudioFormat.sampleRate != this.pendingInputAudioFormat.sampleRate;
        }
        return false;
    }

    public final void queueInput(ByteBuffer byteBuffer) {
        Sonic sonic2 = (Sonic) Assertions.checkNotNull(this.sonic);
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.inputBytes += (long) remaining;
            sonic2.queueInput(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int outputSize = sonic2.getOutputSize();
        if (outputSize > 0) {
            if (this.buffer.capacity() < outputSize) {
                this.buffer = ByteBuffer.allocateDirect(outputSize).order(ByteOrder.nativeOrder());
                this.shortBuffer = this.buffer.asShortBuffer();
            } else {
                this.buffer.clear();
                this.shortBuffer.clear();
            }
            sonic2.getOutput(this.shortBuffer);
            this.outputBytes += (long) outputSize;
            this.buffer.limit(outputSize);
            this.outputBuffer = this.buffer;
        }
    }

    public final void queueEndOfStream() {
        Sonic sonic2 = this.sonic;
        if (sonic2 != null) {
            sonic2.queueEndOfStream();
        }
        this.inputEnded = true;
    }

    public final ByteBuffer getOutput() {
        ByteBuffer byteBuffer = this.outputBuffer;
        this.outputBuffer = EMPTY_BUFFER;
        return byteBuffer;
    }

    public final boolean isEnded() {
        if (!this.inputEnded) {
            return false;
        }
        Sonic sonic2 = this.sonic;
        return sonic2 == null || sonic2.getOutputSize() == 0;
    }

    public final void flush() {
        if (isActive()) {
            this.inputAudioFormat = this.pendingInputAudioFormat;
            this.outputAudioFormat = this.pendingOutputAudioFormat;
            if (this.pendingSonicRecreation) {
                this.sonic = new Sonic(this.inputAudioFormat.sampleRate, this.inputAudioFormat.channelCount, this.speed, this.outputAudioFormat.sampleRate);
            } else {
                Sonic sonic2 = this.sonic;
                if (sonic2 != null) {
                    sonic2.flush();
                }
            }
        }
        this.outputBuffer = EMPTY_BUFFER;
        this.inputBytes = 0;
        this.outputBytes = 0;
        this.inputEnded = false;
    }

    public final void reset() {
        this.speed = 1.0f;
        this.pendingInputAudioFormat = AudioProcessor.AudioFormat.NOT_SET;
        this.pendingOutputAudioFormat = AudioProcessor.AudioFormat.NOT_SET;
        this.inputAudioFormat = AudioProcessor.AudioFormat.NOT_SET;
        this.outputAudioFormat = AudioProcessor.AudioFormat.NOT_SET;
        this.buffer = EMPTY_BUFFER;
        this.shortBuffer = this.buffer.asShortBuffer();
        this.outputBuffer = EMPTY_BUFFER;
        this.pendingOutputSampleRate = -1;
        this.pendingSonicRecreation = false;
        this.sonic = null;
        this.inputBytes = 0;
        this.outputBytes = 0;
        this.inputEnded = false;
    }
}
