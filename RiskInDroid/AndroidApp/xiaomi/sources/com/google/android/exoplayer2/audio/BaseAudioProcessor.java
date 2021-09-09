package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class BaseAudioProcessor implements AudioProcessor {
    private ByteBuffer buffer = EMPTY_BUFFER;
    protected AudioProcessor.AudioFormat inputAudioFormat = AudioProcessor.AudioFormat.NOT_SET;
    private boolean inputEnded;
    protected AudioProcessor.AudioFormat outputAudioFormat = AudioProcessor.AudioFormat.NOT_SET;
    private ByteBuffer outputBuffer = EMPTY_BUFFER;
    private AudioProcessor.AudioFormat pendingInputAudioFormat = AudioProcessor.AudioFormat.NOT_SET;
    private AudioProcessor.AudioFormat pendingOutputAudioFormat = AudioProcessor.AudioFormat.NOT_SET;

    /* access modifiers changed from: protected */
    public void onFlush() {
    }

    /* access modifiers changed from: protected */
    public void onQueueEndOfStream() {
    }

    /* access modifiers changed from: protected */
    public void onReset() {
    }

    public final AudioProcessor.AudioFormat configure(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        this.pendingInputAudioFormat = audioFormat;
        this.pendingOutputAudioFormat = onConfigure(audioFormat);
        return isActive() ? this.pendingOutputAudioFormat : AudioProcessor.AudioFormat.NOT_SET;
    }

    public boolean isActive() {
        return this.pendingOutputAudioFormat != AudioProcessor.AudioFormat.NOT_SET;
    }

    public final void queueEndOfStream() {
        this.inputEnded = true;
        onQueueEndOfStream();
    }

    public ByteBuffer getOutput() {
        ByteBuffer byteBuffer = this.outputBuffer;
        this.outputBuffer = EMPTY_BUFFER;
        return byteBuffer;
    }

    public boolean isEnded() {
        return this.inputEnded && this.outputBuffer == EMPTY_BUFFER;
    }

    public final void flush() {
        this.outputBuffer = EMPTY_BUFFER;
        this.inputEnded = false;
        this.inputAudioFormat = this.pendingInputAudioFormat;
        this.outputAudioFormat = this.pendingOutputAudioFormat;
        onFlush();
    }

    public final void reset() {
        flush();
        this.buffer = EMPTY_BUFFER;
        this.pendingInputAudioFormat = AudioProcessor.AudioFormat.NOT_SET;
        this.pendingOutputAudioFormat = AudioProcessor.AudioFormat.NOT_SET;
        this.inputAudioFormat = AudioProcessor.AudioFormat.NOT_SET;
        this.outputAudioFormat = AudioProcessor.AudioFormat.NOT_SET;
        onReset();
    }

    /* access modifiers changed from: protected */
    public final ByteBuffer replaceOutputBuffer(int i) {
        if (this.buffer.capacity() < i) {
            this.buffer = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.buffer.clear();
        }
        ByteBuffer byteBuffer = this.buffer;
        this.outputBuffer = byteBuffer;
        return byteBuffer;
    }

    /* access modifiers changed from: protected */
    public final boolean hasPendingOutput() {
        return this.outputBuffer.hasRemaining();
    }

    /* access modifiers changed from: protected */
    public AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        return AudioProcessor.AudioFormat.NOT_SET;
    }
}
