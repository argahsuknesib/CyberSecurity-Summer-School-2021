package com.google.android.exoplayer2.source;

import android.os.Looper;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public class SampleQueue implements TrackOutput {
    private int absoluteFirstIndex;
    private int capacity = 1000;
    private TrackOutput.CryptoData[] cryptoDatas;
    private DrmSession currentDrmSession;
    private Format downstreamFormat;
    private final DrmSessionManager drmSessionManager;
    private final MediaSourceEventDispatcher eventDispatcher;
    private final SampleExtrasHolder extrasHolder = new SampleExtrasHolder();
    private int[] flags;
    private Format[] formats;
    private boolean isLastSampleQueued;
    private long largestDiscardedTimestampUs;
    private long largestQueuedTimestampUs;
    private int length;
    private long[] offsets;
    private boolean pendingSplice;
    private int readPosition;
    private int relativeFirstIndex;
    private final SampleDataQueue sampleDataQueue;
    private long sampleOffsetUs;
    private int[] sizes;
    private int[] sourceIds;
    private long[] timesUs;
    private Format unadjustedUpstreamFormat;
    private Format upstreamCommittedFormat;
    private Format upstreamFormat;
    private boolean upstreamFormatAdjustmentRequired;
    private UpstreamFormatChangedListener upstreamFormatChangeListener;
    private boolean upstreamFormatRequired;
    private boolean upstreamKeyframeRequired;
    private int upstreamSourceId;

    public interface UpstreamFormatChangedListener {
        void onUpstreamFormatChanged(Format format);
    }

    public SampleQueue(Allocator allocator, DrmSessionManager drmSessionManager2, MediaSourceEventDispatcher mediaSourceEventDispatcher) {
        this.sampleDataQueue = new SampleDataQueue(allocator);
        this.drmSessionManager = drmSessionManager2;
        this.eventDispatcher = mediaSourceEventDispatcher;
        int i = this.capacity;
        this.sourceIds = new int[i];
        this.offsets = new long[i];
        this.timesUs = new long[i];
        this.flags = new int[i];
        this.sizes = new int[i];
        this.cryptoDatas = new TrackOutput.CryptoData[i];
        this.formats = new Format[i];
        this.largestDiscardedTimestampUs = Long.MIN_VALUE;
        this.largestQueuedTimestampUs = Long.MIN_VALUE;
        this.upstreamFormatRequired = true;
        this.upstreamKeyframeRequired = true;
    }

    public void release() {
        reset(true);
        releaseDrmSessionReferences();
    }

    public final void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        this.sampleDataQueue.reset();
        this.length = 0;
        this.absoluteFirstIndex = 0;
        this.relativeFirstIndex = 0;
        this.readPosition = 0;
        this.upstreamKeyframeRequired = true;
        this.largestDiscardedTimestampUs = Long.MIN_VALUE;
        this.largestQueuedTimestampUs = Long.MIN_VALUE;
        this.isLastSampleQueued = false;
        this.upstreamCommittedFormat = null;
        if (z) {
            this.unadjustedUpstreamFormat = null;
            this.upstreamFormat = null;
            this.upstreamFormatRequired = true;
        }
    }

    public final void sourceId(int i) {
        this.upstreamSourceId = i;
    }

    public final void splice() {
        this.pendingSplice = true;
    }

    public final int getWriteIndex() {
        return this.absoluteFirstIndex + this.length;
    }

    public final void discardUpstreamSamples(int i) {
        this.sampleDataQueue.discardUpstreamSampleBytes(discardUpstreamSampleMetadata(i));
    }

    public void preRelease() {
        discardToEnd();
        releaseDrmSessionReferences();
    }

    public void maybeThrowError() throws IOException {
        DrmSession drmSession = this.currentDrmSession;
        if (drmSession != null && drmSession.getState() == 1) {
            throw ((DrmSession.DrmSessionException) Assertions.checkNotNull(this.currentDrmSession.getError()));
        }
    }

    public final int getFirstIndex() {
        return this.absoluteFirstIndex;
    }

    public final int getReadIndex() {
        return this.absoluteFirstIndex + this.readPosition;
    }

    public final synchronized int peekSourceId() {
        int relativeIndex = getRelativeIndex(this.readPosition);
        if (hasNextSample()) {
            return this.sourceIds[relativeIndex];
        }
        return this.upstreamSourceId;
    }

    public final synchronized Format getUpstreamFormat() {
        if (this.upstreamFormatRequired) {
            return null;
        }
        return this.upstreamFormat;
    }

    public final synchronized long getLargestQueuedTimestampUs() {
        return this.largestQueuedTimestampUs;
    }

    public final synchronized boolean isLastSampleQueued() {
        return this.isLastSampleQueued;
    }

    public final synchronized long getFirstTimestampUs() {
        if (this.length == 0) {
            return Long.MIN_VALUE;
        }
        return this.timesUs[this.relativeFirstIndex];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001d, code lost:
        return true;
     */
    public synchronized boolean isReady(boolean z) {
        if (hasNextSample()) {
            int relativeIndex = getRelativeIndex(this.readPosition);
            if (this.formats[relativeIndex] != this.downstreamFormat) {
                return true;
            }
            return mayReadSample(relativeIndex);
        } else if (!z && !this.isLastSampleQueued && (this.upstreamFormat == null || this.upstreamFormat == this.downstreamFormat)) {
            return false;
        }
    }

    public int read(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z, boolean z2, long j) {
        int readSampleMetadata = readSampleMetadata(formatHolder, decoderInputBuffer, z, z2, j, this.extrasHolder);
        if (readSampleMetadata == -4 && !decoderInputBuffer.isEndOfStream() && !decoderInputBuffer.isFlagsOnly()) {
            this.sampleDataQueue.readToBuffer(decoderInputBuffer, this.extrasHolder);
        }
        return readSampleMetadata;
    }

    public final synchronized boolean seekTo(int i) {
        rewind();
        if (i >= this.absoluteFirstIndex) {
            if (i <= this.absoluteFirstIndex + this.length) {
                this.readPosition = i - this.absoluteFirstIndex;
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003d, code lost:
        return false;
     */
    public final synchronized boolean seekTo(long j, boolean z) {
        rewind();
        int relativeIndex = getRelativeIndex(this.readPosition);
        if (hasNextSample() && j >= this.timesUs[relativeIndex]) {
            if (j <= this.largestQueuedTimestampUs || z) {
                int findSampleBefore = findSampleBefore(relativeIndex, this.length - this.readPosition, j, true);
                if (findSampleBefore == -1) {
                    return false;
                }
                this.readPosition += findSampleBefore;
                return true;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        return 0;
     */
    public final synchronized int advanceTo(long j) {
        int relativeIndex = getRelativeIndex(this.readPosition);
        if (hasNextSample()) {
            if (j >= this.timesUs[relativeIndex]) {
                int findSampleBefore = findSampleBefore(relativeIndex, this.length - this.readPosition, j, true);
                if (findSampleBefore == -1) {
                    return 0;
                }
                this.readPosition += findSampleBefore;
                return findSampleBefore;
            }
        }
    }

    public final synchronized int advanceToEnd() {
        int i;
        i = this.length - this.readPosition;
        this.readPosition = this.length;
        return i;
    }

    public final void discardTo(long j, boolean z, boolean z2) {
        this.sampleDataQueue.discardDownstreamTo(discardSampleMetadataTo(j, z, z2));
    }

    public final void discardToRead() {
        this.sampleDataQueue.discardDownstreamTo(discardSampleMetadataToRead());
    }

    public final void discardToEnd() {
        this.sampleDataQueue.discardDownstreamTo(discardSampleMetadataToEnd());
    }

    public final void setSampleOffsetUs(long j) {
        if (this.sampleOffsetUs != j) {
            this.sampleOffsetUs = j;
            invalidateUpstreamFormatAdjustment();
        }
    }

    public final void setUpstreamFormatChangeListener(UpstreamFormatChangedListener upstreamFormatChangedListener) {
        this.upstreamFormatChangeListener = upstreamFormatChangedListener;
    }

    public final void format(Format format) {
        Format adjustedUpstreamFormat = getAdjustedUpstreamFormat(format);
        this.upstreamFormatAdjustmentRequired = false;
        this.unadjustedUpstreamFormat = format;
        boolean upstreamFormat2 = setUpstreamFormat(adjustedUpstreamFormat);
        UpstreamFormatChangedListener upstreamFormatChangedListener = this.upstreamFormatChangeListener;
        if (upstreamFormatChangedListener != null && upstreamFormat2) {
            upstreamFormatChangedListener.onUpstreamFormatChanged(adjustedUpstreamFormat);
        }
    }

    public final int sampleData(DataReader dataReader, int i, boolean z) throws IOException {
        return this.sampleDataQueue.sampleData(dataReader, i, z);
    }

    public final void sampleData(ParsableByteArray parsableByteArray, int i) {
        this.sampleDataQueue.sampleData(parsableByteArray, i);
    }

    public void sampleMetadata(long j, int i, int i2, int i3, TrackOutput.CryptoData cryptoData) {
        if (this.upstreamFormatAdjustmentRequired) {
            format((Format) Assertions.checkStateNotNull(this.unadjustedUpstreamFormat));
        }
        long j2 = j + this.sampleOffsetUs;
        if (this.pendingSplice) {
            if ((i & 1) != 0 && attemptSplice(j2)) {
                this.pendingSplice = false;
            } else {
                return;
            }
        }
        commitSample(j2, i, (this.sampleDataQueue.getTotalBytesWritten() - ((long) i2)) - ((long) i3), i2, cryptoData);
    }

    /* access modifiers changed from: protected */
    public final void invalidateUpstreamFormatAdjustment() {
        this.upstreamFormatAdjustmentRequired = true;
    }

    /* access modifiers changed from: protected */
    public Format getAdjustedUpstreamFormat(Format format) {
        return (this.sampleOffsetUs == 0 || format.subsampleOffsetUs == Long.MAX_VALUE) ? format : format.buildUpon().setSubsampleOffsetUs(format.subsampleOffsetUs + this.sampleOffsetUs).build();
    }

    private synchronized void rewind() {
        this.readPosition = 0;
        this.sampleDataQueue.rewind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0052, code lost:
        return -3;
     */
    private synchronized int readSampleMetadata(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z, boolean z2, long j, SampleExtrasHolder sampleExtrasHolder) {
        boolean hasNextSample;
        decoderInputBuffer.waitingForKeys = false;
        int i = -1;
        while (true) {
            hasNextSample = hasNextSample();
            if (!hasNextSample) {
                break;
            }
            i = getRelativeIndex(this.readPosition);
            if (this.timesUs[i] >= j || !MimeTypes.allSamplesAreSyncSamples(this.formats[i].sampleMimeType)) {
                break;
            }
            this.readPosition++;
        }
        if (!hasNextSample) {
            if (!z2) {
                if (!this.isLastSampleQueued) {
                    if (this.upstreamFormat != null && (z || this.upstreamFormat != this.downstreamFormat)) {
                        onFormatResult((Format) Assertions.checkNotNull(this.upstreamFormat), formatHolder);
                        return -5;
                    }
                }
            }
            decoderInputBuffer.setFlags(4);
            return -4;
        }
        if (!z) {
            if (this.formats[i] == this.downstreamFormat) {
                if (!mayReadSample(i)) {
                    decoderInputBuffer.waitingForKeys = true;
                    return -3;
                }
                decoderInputBuffer.setFlags(this.flags[i]);
                decoderInputBuffer.timeUs = this.timesUs[i];
                if (decoderInputBuffer.timeUs < j) {
                    decoderInputBuffer.addFlag(Integer.MIN_VALUE);
                }
                if (decoderInputBuffer.isFlagsOnly()) {
                    return -4;
                }
                sampleExtrasHolder.size = this.sizes[i];
                sampleExtrasHolder.offset = this.offsets[i];
                sampleExtrasHolder.cryptoData = this.cryptoDatas[i];
                this.readPosition++;
                return -4;
            }
        }
        onFormatResult(this.formats[i], formatHolder);
        return -5;
    }

    private synchronized boolean setUpstreamFormat(Format format) {
        this.upstreamFormatRequired = false;
        if (Util.areEqual(format, this.upstreamFormat)) {
            return false;
        }
        if (Util.areEqual(format, this.upstreamCommittedFormat)) {
            this.upstreamFormat = this.upstreamCommittedFormat;
            return true;
        }
        this.upstreamFormat = format;
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0037, code lost:
        return -1;
     */
    private synchronized long discardSampleMetadataTo(long j, boolean z, boolean z2) {
        if (this.length != 0) {
            if (j >= this.timesUs[this.relativeFirstIndex]) {
                int findSampleBefore = findSampleBefore(this.relativeFirstIndex, (!z2 || this.readPosition == this.length) ? this.length : this.readPosition + 1, j, z);
                if (findSampleBefore == -1) {
                    return -1;
                }
                return discardSamples(findSampleBefore);
            }
        }
    }

    public synchronized long discardSampleMetadataToRead() {
        if (this.readPosition == 0) {
            return -1;
        }
        return discardSamples(this.readPosition);
    }

    private synchronized long discardSampleMetadataToEnd() {
        if (this.length == 0) {
            return -1;
        }
        return discardSamples(this.length);
    }

    private void releaseDrmSessionReferences() {
        DrmSession drmSession = this.currentDrmSession;
        if (drmSession != null) {
            drmSession.release(this.eventDispatcher);
            this.currentDrmSession = null;
            this.downstreamFormat = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00e0, code lost:
        return;
     */
    private synchronized void commitSample(long j, int i, long j2, int i2, TrackOutput.CryptoData cryptoData) {
        if (this.upstreamKeyframeRequired) {
            if ((i & 1) != 0) {
                this.upstreamKeyframeRequired = false;
            } else {
                return;
            }
        }
        Assertions.checkState(!this.upstreamFormatRequired);
        this.isLastSampleQueued = (536870912 & i) != 0;
        this.largestQueuedTimestampUs = Math.max(this.largestQueuedTimestampUs, j);
        int relativeIndex = getRelativeIndex(this.length);
        this.timesUs[relativeIndex] = j;
        this.offsets[relativeIndex] = j2;
        this.sizes[relativeIndex] = i2;
        this.flags[relativeIndex] = i;
        this.cryptoDatas[relativeIndex] = cryptoData;
        this.formats[relativeIndex] = this.upstreamFormat;
        this.sourceIds[relativeIndex] = this.upstreamSourceId;
        this.upstreamCommittedFormat = this.upstreamFormat;
        this.length++;
        if (this.length == this.capacity) {
            int i3 = this.capacity + 1000;
            int[] iArr = new int[i3];
            long[] jArr = new long[i3];
            long[] jArr2 = new long[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            TrackOutput.CryptoData[] cryptoDataArr = new TrackOutput.CryptoData[i3];
            Format[] formatArr = new Format[i3];
            int i4 = this.capacity - this.relativeFirstIndex;
            System.arraycopy(this.offsets, this.relativeFirstIndex, jArr, 0, i4);
            System.arraycopy(this.timesUs, this.relativeFirstIndex, jArr2, 0, i4);
            System.arraycopy(this.flags, this.relativeFirstIndex, iArr2, 0, i4);
            System.arraycopy(this.sizes, this.relativeFirstIndex, iArr3, 0, i4);
            System.arraycopy(this.cryptoDatas, this.relativeFirstIndex, cryptoDataArr, 0, i4);
            System.arraycopy(this.formats, this.relativeFirstIndex, formatArr, 0, i4);
            System.arraycopy(this.sourceIds, this.relativeFirstIndex, iArr, 0, i4);
            int i5 = this.relativeFirstIndex;
            System.arraycopy(this.offsets, 0, jArr, i4, i5);
            System.arraycopy(this.timesUs, 0, jArr2, i4, i5);
            System.arraycopy(this.flags, 0, iArr2, i4, i5);
            System.arraycopy(this.sizes, 0, iArr3, i4, i5);
            System.arraycopy(this.cryptoDatas, 0, cryptoDataArr, i4, i5);
            System.arraycopy(this.formats, 0, formatArr, i4, i5);
            System.arraycopy(this.sourceIds, 0, iArr, i4, i5);
            this.offsets = jArr;
            this.timesUs = jArr2;
            this.flags = iArr2;
            this.sizes = iArr3;
            this.cryptoDatas = cryptoDataArr;
            this.formats = formatArr;
            this.sourceIds = iArr;
            this.relativeFirstIndex = 0;
            this.capacity = i3;
        }
    }

    private synchronized boolean attemptSplice(long j) {
        if (this.length == 0) {
            return j > this.largestDiscardedTimestampUs;
        }
        if (Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(this.readPosition)) >= j) {
            return false;
        }
        int i = this.length;
        int relativeIndex = getRelativeIndex(this.length - 1);
        while (i > this.readPosition && this.timesUs[relativeIndex] >= j) {
            i--;
            relativeIndex--;
            if (relativeIndex == -1) {
                relativeIndex = this.capacity - 1;
            }
        }
        discardUpstreamSampleMetadata(this.absoluteFirstIndex + i);
        return true;
    }

    private long discardUpstreamSampleMetadata(int i) {
        int writeIndex = getWriteIndex() - i;
        boolean z = false;
        Assertions.checkArgument(writeIndex >= 0 && writeIndex <= this.length - this.readPosition);
        this.length -= writeIndex;
        this.largestQueuedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(this.length));
        if (writeIndex == 0 && this.isLastSampleQueued) {
            z = true;
        }
        this.isLastSampleQueued = z;
        int i2 = this.length;
        if (i2 == 0) {
            return 0;
        }
        int relativeIndex = getRelativeIndex(i2 - 1);
        return this.offsets[relativeIndex] + ((long) this.sizes[relativeIndex]);
    }

    private boolean hasNextSample() {
        return this.readPosition != this.length;
    }

    private void onFormatResult(Format format, FormatHolder formatHolder) {
        DrmInitData drmInitData;
        DrmSession drmSession;
        formatHolder.format = format;
        boolean z = this.downstreamFormat == null;
        if (z) {
            drmInitData = null;
        } else {
            drmInitData = this.downstreamFormat.drmInitData;
        }
        this.downstreamFormat = format;
        DrmInitData drmInitData2 = format.drmInitData;
        formatHolder.drmSession = this.currentDrmSession;
        if (z || !Util.areEqual(drmInitData, drmInitData2)) {
            DrmSession drmSession2 = this.currentDrmSession;
            Looper looper = (Looper) Assertions.checkNotNull(Looper.myLooper());
            if (drmInitData2 != null) {
                drmSession = this.drmSessionManager.acquireSession(looper, this.eventDispatcher, drmInitData2);
            } else {
                drmSession = this.drmSessionManager.acquirePlaceholderSession(looper, MimeTypes.getTrackType(format.sampleMimeType));
            }
            this.currentDrmSession = drmSession;
            formatHolder.drmSession = this.currentDrmSession;
            if (drmSession2 != null) {
                drmSession2.release(this.eventDispatcher);
            }
        }
    }

    private boolean mayReadSample(int i) {
        DrmSession drmSession = this.currentDrmSession;
        if (drmSession == null || drmSession.getState() == 4) {
            return true;
        }
        return (this.flags[i] & 1073741824) == 0 && this.currentDrmSession.playClearSamplesWithoutKeys();
    }

    private int findSampleBefore(int i, int i2, long j, boolean z) {
        int i3 = i;
        int i4 = -1;
        for (int i5 = 0; i5 < i2 && this.timesUs[i3] <= j; i5++) {
            if (!z || (this.flags[i3] & 1) != 0) {
                i4 = i5;
            }
            i3++;
            if (i3 == this.capacity) {
                i3 = 0;
            }
        }
        return i4;
    }

    private long discardSamples(int i) {
        this.largestDiscardedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(i));
        this.length -= i;
        this.absoluteFirstIndex += i;
        this.relativeFirstIndex += i;
        int i2 = this.relativeFirstIndex;
        int i3 = this.capacity;
        if (i2 >= i3) {
            this.relativeFirstIndex = i2 - i3;
        }
        this.readPosition -= i;
        if (this.readPosition < 0) {
            this.readPosition = 0;
        }
        if (this.length != 0) {
            return this.offsets[this.relativeFirstIndex];
        }
        int i4 = this.relativeFirstIndex;
        if (i4 == 0) {
            i4 = this.capacity;
        }
        int i5 = i4 - 1;
        return this.offsets[i5] + ((long) this.sizes[i5]);
    }

    private long getLargestTimestamp(int i) {
        long j = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int relativeIndex = getRelativeIndex(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            j = Math.max(j, this.timesUs[relativeIndex]);
            if ((this.flags[relativeIndex] & 1) != 0) {
                break;
            }
            relativeIndex--;
            if (relativeIndex == -1) {
                relativeIndex = this.capacity - 1;
            }
        }
        return j;
    }

    private int getRelativeIndex(int i) {
        int i2 = this.relativeFirstIndex + i;
        int i3 = this.capacity;
        return i2 < i3 ? i2 : i2 - i3;
    }

    static final class SampleExtrasHolder {
        public TrackOutput.CryptoData cryptoData;
        public long offset;
        public int size;

        SampleExtrasHolder() {
        }
    }
}
