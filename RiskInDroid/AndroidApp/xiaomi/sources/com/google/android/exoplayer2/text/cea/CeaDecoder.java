package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.text.cea.CeaDecoder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

abstract class CeaDecoder implements SubtitleDecoder {
    private final ArrayDeque<CeaInputBuffer> availableInputBuffers = new ArrayDeque<>();
    private final ArrayDeque<SubtitleOutputBuffer> availableOutputBuffers;
    private CeaInputBuffer dequeuedInputBuffer;
    private long playbackPositionUs;
    private long queuedInputBufferCount;
    private final PriorityQueue<CeaInputBuffer> queuedInputBuffers;

    /* access modifiers changed from: protected */
    public abstract Subtitle createSubtitle();

    /* access modifiers changed from: protected */
    public abstract void decode(SubtitleInputBuffer subtitleInputBuffer);

    public abstract String getName();

    /* access modifiers changed from: protected */
    public abstract boolean isNewSubtitleDataAvailable();

    public void release() {
    }

    public CeaDecoder() {
        for (int i = 0; i < 10; i++) {
            this.availableInputBuffers.add(new CeaInputBuffer());
        }
        this.availableOutputBuffers = new ArrayDeque<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.availableOutputBuffers.add(new CeaOutputBuffer(new OutputBuffer.Owner() {
                /* class com.google.android.exoplayer2.text.cea.$$Lambda$U1BC5HyvT8rXefchROWTJPMwzY */

                public final void releaseOutputBuffer(OutputBuffer outputBuffer) {
                    CeaDecoder.this.releaseOutputBuffer((CeaDecoder.CeaOutputBuffer) outputBuffer);
                }
            }));
        }
        this.queuedInputBuffers = new PriorityQueue<>();
    }

    public void setPositionUs(long j) {
        this.playbackPositionUs = j;
    }

    public SubtitleInputBuffer dequeueInputBuffer() throws SubtitleDecoderException {
        Assertions.checkState(this.dequeuedInputBuffer == null);
        if (this.availableInputBuffers.isEmpty()) {
            return null;
        }
        this.dequeuedInputBuffer = this.availableInputBuffers.pollFirst();
        return this.dequeuedInputBuffer;
    }

    public void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        Assertions.checkArgument(subtitleInputBuffer == this.dequeuedInputBuffer);
        CeaInputBuffer ceaInputBuffer = (CeaInputBuffer) subtitleInputBuffer;
        if (ceaInputBuffer.isDecodeOnly()) {
            releaseInputBuffer(ceaInputBuffer);
        } else {
            long j = this.queuedInputBufferCount;
            this.queuedInputBufferCount = 1 + j;
            ceaInputBuffer.queuedInputBufferCount = j;
            this.queuedInputBuffers.add(ceaInputBuffer);
        }
        this.dequeuedInputBuffer = null;
    }

    public SubtitleOutputBuffer dequeueOutputBuffer() throws SubtitleDecoderException {
        if (this.availableOutputBuffers.isEmpty()) {
            return null;
        }
        while (!this.queuedInputBuffers.isEmpty() && ((CeaInputBuffer) Util.castNonNull(this.queuedInputBuffers.peek())).timeUs <= this.playbackPositionUs) {
            CeaInputBuffer ceaInputBuffer = (CeaInputBuffer) Util.castNonNull(this.queuedInputBuffers.poll());
            if (ceaInputBuffer.isEndOfStream()) {
                SubtitleOutputBuffer subtitleOutputBuffer = (SubtitleOutputBuffer) Util.castNonNull(this.availableOutputBuffers.pollFirst());
                subtitleOutputBuffer.addFlag(4);
                releaseInputBuffer(ceaInputBuffer);
                return subtitleOutputBuffer;
            }
            decode(ceaInputBuffer);
            if (isNewSubtitleDataAvailable()) {
                Subtitle createSubtitle = createSubtitle();
                if (!ceaInputBuffer.isDecodeOnly()) {
                    SubtitleOutputBuffer subtitleOutputBuffer2 = (SubtitleOutputBuffer) Util.castNonNull(this.availableOutputBuffers.pollFirst());
                    subtitleOutputBuffer2.setContent(ceaInputBuffer.timeUs, createSubtitle, Long.MAX_VALUE);
                    releaseInputBuffer(ceaInputBuffer);
                    return subtitleOutputBuffer2;
                }
            }
            releaseInputBuffer(ceaInputBuffer);
        }
        return null;
    }

    private void releaseInputBuffer(CeaInputBuffer ceaInputBuffer) {
        ceaInputBuffer.clear();
        this.availableInputBuffers.add(ceaInputBuffer);
    }

    /* access modifiers changed from: protected */
    public void releaseOutputBuffer(SubtitleOutputBuffer subtitleOutputBuffer) {
        subtitleOutputBuffer.clear();
        this.availableOutputBuffers.add(subtitleOutputBuffer);
    }

    public void flush() {
        this.queuedInputBufferCount = 0;
        this.playbackPositionUs = 0;
        while (!this.queuedInputBuffers.isEmpty()) {
            releaseInputBuffer((CeaInputBuffer) Util.castNonNull(this.queuedInputBuffers.poll()));
        }
        CeaInputBuffer ceaInputBuffer = this.dequeuedInputBuffer;
        if (ceaInputBuffer != null) {
            releaseInputBuffer(ceaInputBuffer);
            this.dequeuedInputBuffer = null;
        }
    }

    static final class CeaInputBuffer extends SubtitleInputBuffer implements Comparable<CeaInputBuffer> {
        public long queuedInputBufferCount;

        private CeaInputBuffer() {
        }

        public final int compareTo(CeaInputBuffer ceaInputBuffer) {
            if (isEndOfStream() != ceaInputBuffer.isEndOfStream()) {
                return isEndOfStream() ? 1 : -1;
            }
            long j = this.timeUs - ceaInputBuffer.timeUs;
            if (j == 0) {
                j = this.queuedInputBufferCount - ceaInputBuffer.queuedInputBufferCount;
                if (j == 0) {
                    return 0;
                }
            }
            return j > 0 ? 1 : -1;
        }
    }

    static final class CeaOutputBuffer extends SubtitleOutputBuffer {
        private OutputBuffer.Owner<CeaOutputBuffer> owner;

        public CeaOutputBuffer(OutputBuffer.Owner<CeaOutputBuffer> owner2) {
            this.owner = owner2;
        }

        public final void release() {
            this.owner.releaseOutputBuffer(this);
        }
    }
}
