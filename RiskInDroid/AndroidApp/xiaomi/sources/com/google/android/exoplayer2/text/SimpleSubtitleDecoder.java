package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.decoder.SimpleDecoder;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;

public abstract class SimpleSubtitleDecoder extends SimpleDecoder<SubtitleInputBuffer, SubtitleOutputBuffer, SubtitleDecoderException> implements SubtitleDecoder {
    private final String name;

    /* access modifiers changed from: protected */
    public abstract Subtitle decode(byte[] bArr, int i, boolean z) throws SubtitleDecoderException;

    public void setPositionUs(long j) {
    }

    protected SimpleSubtitleDecoder(String str) {
        super(new SubtitleInputBuffer[2], new SubtitleOutputBuffer[2]);
        this.name = str;
        setInitialInputBufferSize(1024);
    }

    public final String getName() {
        return this.name;
    }

    /* access modifiers changed from: protected */
    public final SubtitleInputBuffer createInputBuffer() {
        return new SubtitleInputBuffer();
    }

    /* access modifiers changed from: protected */
    public final SubtitleOutputBuffer createOutputBuffer() {
        return new SimpleSubtitleOutputBuffer(new OutputBuffer.Owner() {
            /* class com.google.android.exoplayer2.text.$$Lambda$SimpleSubtitleDecoder$cR7ghIaQcX1GxB6N6TkZ4Ji2lk */

            public final void releaseOutputBuffer(OutputBuffer outputBuffer) {
                SimpleSubtitleDecoder.this.releaseOutputBuffer((SubtitleOutputBuffer) outputBuffer);
            }
        });
    }

    /* access modifiers changed from: protected */
    public final SubtitleDecoderException createUnexpectedDecodeException(Throwable th) {
        return new SubtitleDecoderException("Unexpected decode error", th);
    }

    /* access modifiers changed from: protected */
    public final SubtitleDecoderException decode(SubtitleInputBuffer subtitleInputBuffer, SubtitleOutputBuffer subtitleOutputBuffer, boolean z) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(subtitleInputBuffer.data);
            SubtitleOutputBuffer subtitleOutputBuffer2 = subtitleOutputBuffer;
            subtitleOutputBuffer2.setContent(subtitleInputBuffer.timeUs, decode(byteBuffer.array(), byteBuffer.limit(), z), subtitleInputBuffer.subsampleOffsetUs);
            subtitleOutputBuffer.clearFlag(Integer.MIN_VALUE);
            return null;
        } catch (SubtitleDecoderException e) {
            return e;
        }
    }
}
