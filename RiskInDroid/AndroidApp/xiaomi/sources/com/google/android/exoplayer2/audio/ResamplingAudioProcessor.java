package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;

final class ResamplingAudioProcessor extends BaseAudioProcessor {
    ResamplingAudioProcessor() {
    }

    public final AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        int i = audioFormat.encoding;
        if (i == 3 || i == 2 || i == 268435456 || i == 536870912 || i == 805306368 || i == 4) {
            return i != 2 ? new AudioProcessor.AudioFormat(audioFormat.sampleRate, audioFormat.channelCount, 2) : AudioProcessor.AudioFormat.NOT_SET;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a8 A[LOOP:4: B:27:0x00a8->B:28:0x00aa, LOOP_START, PHI: r0 10  PHI: (r0v2 int) = (r0v0 int), (r0v3 int) binds: [B:12:0x0037, B:28:0x00aa] A[DONT_GENERATE, DONT_INLINE]] */
    public final void queueInput(ByteBuffer byteBuffer) {
        int i;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        int i3 = this.inputAudioFormat.encoding;
        if (i3 != 3) {
            if (i3 != 4) {
                if (i3 != 268435456) {
                    if (i3 == 536870912) {
                        i2 /= 3;
                    } else if (i3 != 805306368) {
                        throw new IllegalStateException();
                    }
                }
                ByteBuffer replaceOutputBuffer = replaceOutputBuffer(i2);
                i = this.inputAudioFormat.encoding;
                if (i == 3) {
                    while (position < limit) {
                        replaceOutputBuffer.put((byte) 0);
                        replaceOutputBuffer.put((byte) ((byteBuffer.get(position) & 255) - 128));
                        position++;
                    }
                } else if (i == 4) {
                    while (position < limit) {
                        short s = (short) ((int) (byteBuffer.getFloat(position) * 32767.0f));
                        replaceOutputBuffer.put((byte) (s & 255));
                        replaceOutputBuffer.put((byte) ((s >> 8) & 255));
                        position += 4;
                    }
                } else if (i == 268435456) {
                    while (position < limit) {
                        replaceOutputBuffer.put(byteBuffer.get(position + 1));
                        replaceOutputBuffer.put(byteBuffer.get(position));
                        position += 2;
                    }
                } else if (i == 536870912) {
                    while (position < limit) {
                        replaceOutputBuffer.put(byteBuffer.get(position + 1));
                        replaceOutputBuffer.put(byteBuffer.get(position + 2));
                        position += 3;
                    }
                } else if (i == 805306368) {
                    while (position < limit) {
                        replaceOutputBuffer.put(byteBuffer.get(position + 2));
                        replaceOutputBuffer.put(byteBuffer.get(position + 3));
                        position += 4;
                    }
                } else {
                    throw new IllegalStateException();
                }
                byteBuffer.position(byteBuffer.limit());
                replaceOutputBuffer.flip();
            }
            i2 /= 2;
            ByteBuffer replaceOutputBuffer2 = replaceOutputBuffer(i2);
            i = this.inputAudioFormat.encoding;
            if (i == 3) {
            }
            byteBuffer.position(byteBuffer.limit());
            replaceOutputBuffer2.flip();
        }
        i2 *= 2;
        ByteBuffer replaceOutputBuffer22 = replaceOutputBuffer(i2);
        i = this.inputAudioFormat.encoding;
        if (i == 3) {
        }
        byteBuffer.position(byteBuffer.limit());
        replaceOutputBuffer22.flip();
    }
}
