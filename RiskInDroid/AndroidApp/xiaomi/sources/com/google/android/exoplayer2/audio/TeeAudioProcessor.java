package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class TeeAudioProcessor extends BaseAudioProcessor {
    private final AudioBufferSink audioBufferSink;

    public interface AudioBufferSink {
        void flush(int i, int i2, int i3);

        void handleBuffer(ByteBuffer byteBuffer);
    }

    public final AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat audioFormat) {
        return audioFormat;
    }

    public TeeAudioProcessor(AudioBufferSink audioBufferSink2) {
        this.audioBufferSink = (AudioBufferSink) Assertions.checkNotNull(audioBufferSink2);
    }

    public final void queueInput(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        if (remaining != 0) {
            this.audioBufferSink.handleBuffer(byteBuffer.asReadOnlyBuffer());
            replaceOutputBuffer(remaining).put(byteBuffer).flip();
        }
    }

    /* access modifiers changed from: protected */
    public final void onFlush() {
        flushSinkIfActive();
    }

    /* access modifiers changed from: protected */
    public final void onQueueEndOfStream() {
        flushSinkIfActive();
    }

    /* access modifiers changed from: protected */
    public final void onReset() {
        flushSinkIfActive();
    }

    private void flushSinkIfActive() {
        if (isActive()) {
            this.audioBufferSink.flush(this.inputAudioFormat.sampleRate, this.inputAudioFormat.channelCount, this.inputAudioFormat.encoding);
        }
    }

    public static final class WavFileAudioBufferSink implements AudioBufferSink {
        private int bytesWritten;
        private int channelCount;
        private int counter;
        private int encoding;
        private final String outputFileNamePrefix;
        private RandomAccessFile randomAccessFile;
        private int sampleRateHz;
        private final byte[] scratchBuffer = new byte[1024];
        private final ByteBuffer scratchByteBuffer = ByteBuffer.wrap(this.scratchBuffer).order(ByteOrder.LITTLE_ENDIAN);

        public WavFileAudioBufferSink(String str) {
            this.outputFileNamePrefix = str;
        }

        public final void flush(int i, int i2, int i3) {
            try {
                reset();
            } catch (IOException e) {
                Log.e("WaveFileAudioBufferSink", "Error resetting", e);
            }
            this.sampleRateHz = i;
            this.channelCount = i2;
            this.encoding = i3;
        }

        public final void handleBuffer(ByteBuffer byteBuffer) {
            try {
                maybePrepareFile();
                writeBuffer(byteBuffer);
            } catch (IOException e) {
                Log.e("WaveFileAudioBufferSink", "Error writing data", e);
            }
        }

        private void maybePrepareFile() throws IOException {
            if (this.randomAccessFile == null) {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(getNextOutputFileName(), "rw");
                writeFileHeader(randomAccessFile2);
                this.randomAccessFile = randomAccessFile2;
                this.bytesWritten = 44;
            }
        }

        private void writeFileHeader(RandomAccessFile randomAccessFile2) throws IOException {
            randomAccessFile2.writeInt(1380533830);
            randomAccessFile2.writeInt(-1);
            randomAccessFile2.writeInt(1463899717);
            randomAccessFile2.writeInt(1718449184);
            this.scratchByteBuffer.clear();
            this.scratchByteBuffer.putInt(16);
            this.scratchByteBuffer.putShort((short) WavUtil.getTypeForPcmEncoding(this.encoding));
            this.scratchByteBuffer.putShort((short) this.channelCount);
            this.scratchByteBuffer.putInt(this.sampleRateHz);
            int pcmFrameSize = Util.getPcmFrameSize(this.encoding, this.channelCount);
            this.scratchByteBuffer.putInt(this.sampleRateHz * pcmFrameSize);
            this.scratchByteBuffer.putShort((short) pcmFrameSize);
            this.scratchByteBuffer.putShort((short) ((pcmFrameSize * 8) / this.channelCount));
            randomAccessFile2.write(this.scratchBuffer, 0, this.scratchByteBuffer.position());
            randomAccessFile2.writeInt(1684108385);
            randomAccessFile2.writeInt(-1);
        }

        private void writeBuffer(ByteBuffer byteBuffer) throws IOException {
            RandomAccessFile randomAccessFile2 = (RandomAccessFile) Assertions.checkNotNull(this.randomAccessFile);
            while (byteBuffer.hasRemaining()) {
                int min = Math.min(byteBuffer.remaining(), this.scratchBuffer.length);
                byteBuffer.get(this.scratchBuffer, 0, min);
                randomAccessFile2.write(this.scratchBuffer, 0, min);
                this.bytesWritten += min;
            }
        }

        private void reset() throws IOException {
            RandomAccessFile randomAccessFile2 = this.randomAccessFile;
            if (randomAccessFile2 != null) {
                try {
                    this.scratchByteBuffer.clear();
                    this.scratchByteBuffer.putInt(this.bytesWritten - 8);
                    randomAccessFile2.seek(4);
                    randomAccessFile2.write(this.scratchBuffer, 0, 4);
                    this.scratchByteBuffer.clear();
                    this.scratchByteBuffer.putInt(this.bytesWritten - 44);
                    randomAccessFile2.seek(40);
                    randomAccessFile2.write(this.scratchBuffer, 0, 4);
                } catch (IOException e) {
                    Log.w("WaveFileAudioBufferSink", "Error updating file size", e);
                }
                try {
                    randomAccessFile2.close();
                } finally {
                    this.randomAccessFile = null;
                }
            }
        }

        private String getNextOutputFileName() {
            int i = this.counter;
            this.counter = i + 1;
            return Util.formatInvariant("%s-%04d.wav", this.outputFileNamePrefix, Integer.valueOf(i));
        }
    }
}
