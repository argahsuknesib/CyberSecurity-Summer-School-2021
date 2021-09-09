package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.chunk.ChunkSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChunkSampleStream<T extends ChunkSource> implements SampleStream, SequenceableLoader, Loader.Callback<Chunk>, Loader.ReleaseCallback {
    private final SequenceableLoader.Callback<ChunkSampleStream<T>> callback;
    private final BaseMediaChunkOutput chunkOutput;
    private final T chunkSource;
    long decodeOnlyUntilPositionUs;
    private final SampleQueue[] embeddedSampleQueues;
    public final Format[] embeddedTrackFormats;
    public final int[] embeddedTrackTypes;
    public final boolean[] embeddedTracksSelected;
    public final MediaSourceEventListener.EventDispatcher eventDispatcher;
    public long lastSeekPositionUs;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final Loader loader;
    boolean loadingFinished;
    private final ArrayList<BaseMediaChunk> mediaChunks;
    private final ChunkHolder nextChunkHolder;
    private int nextNotifyPrimaryFormatMediaChunkIndex;
    private long pendingResetPositionUs;
    private Format primaryDownstreamTrackFormat;
    private final SampleQueue primarySampleQueue;
    public final int primaryTrackType;
    private final List<BaseMediaChunk> readOnlyMediaChunks;
    private ReleaseCallback<T> releaseCallback;

    public interface ReleaseCallback<T extends ChunkSource> {
        void onSampleStreamReleased(ChunkSampleStream<T> chunkSampleStream);
    }

    public ChunkSampleStream(int i, int[] iArr, Format[] formatArr, T t, SequenceableLoader.Callback<ChunkSampleStream<T>> callback2, Allocator allocator, long j, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, MediaSourceEventListener.EventDispatcher eventDispatcher2) {
        this.primaryTrackType = i;
        int i2 = 0;
        this.embeddedTrackTypes = iArr == null ? new int[0] : iArr;
        this.embeddedTrackFormats = formatArr == null ? new Format[0] : formatArr;
        this.chunkSource = t;
        this.callback = callback2;
        this.eventDispatcher = eventDispatcher2;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.loader = new Loader("Loader:ChunkSampleStream");
        this.nextChunkHolder = new ChunkHolder();
        this.mediaChunks = new ArrayList<>();
        this.readOnlyMediaChunks = Collections.unmodifiableList(this.mediaChunks);
        int length = this.embeddedTrackTypes.length;
        this.embeddedSampleQueues = new SampleQueue[length];
        this.embeddedTracksSelected = new boolean[length];
        int i3 = length + 1;
        int[] iArr2 = new int[i3];
        SampleQueue[] sampleQueueArr = new SampleQueue[i3];
        this.primarySampleQueue = new SampleQueue(allocator, drmSessionManager, eventDispatcher2);
        iArr2[0] = i;
        sampleQueueArr[0] = this.primarySampleQueue;
        while (i2 < length) {
            SampleQueue sampleQueue = new SampleQueue(allocator, DrmSessionManager.CC.getDummyDrmSessionManager(), eventDispatcher2);
            this.embeddedSampleQueues[i2] = sampleQueue;
            int i4 = i2 + 1;
            sampleQueueArr[i4] = sampleQueue;
            iArr2[i4] = this.embeddedTrackTypes[i2];
            i2 = i4;
        }
        this.chunkOutput = new BaseMediaChunkOutput(iArr2, sampleQueueArr);
        this.pendingResetPositionUs = j;
        this.lastSeekPositionUs = j;
    }

    public void discardBuffer(long j, boolean z) {
        if (!isPendingReset()) {
            int firstIndex = this.primarySampleQueue.getFirstIndex();
            this.primarySampleQueue.discardTo(j, z, true);
            int firstIndex2 = this.primarySampleQueue.getFirstIndex();
            if (firstIndex2 > firstIndex) {
                long firstTimestampUs = this.primarySampleQueue.getFirstTimestampUs();
                int i = 0;
                while (true) {
                    SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
                    if (i >= sampleQueueArr.length) {
                        break;
                    }
                    sampleQueueArr[i].discardTo(firstTimestampUs, z, this.embeddedTracksSelected[i]);
                    i++;
                }
            }
            discardDownstreamMediaChunks(firstIndex2);
        }
    }

    public ChunkSampleStream<T>.EmbeddedSampleStream selectEmbeddedTrack(long j, int i) {
        for (int i2 = 0; i2 < this.embeddedSampleQueues.length; i2++) {
            if (this.embeddedTrackTypes[i2] == i) {
                Assertions.checkState(!this.embeddedTracksSelected[i2]);
                this.embeddedTracksSelected[i2] = true;
                this.embeddedSampleQueues[i2].seekTo(j, true);
                return new EmbeddedSampleStream(this, this.embeddedSampleQueues[i2], i2);
            }
        }
        throw new IllegalStateException();
    }

    public T getChunkSource() {
        return this.chunkSource;
    }

    public long getBufferedPositionUs() {
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        long j = this.lastSeekPositionUs;
        BaseMediaChunk lastMediaChunk = getLastMediaChunk();
        if (!lastMediaChunk.isLoadCompleted()) {
            if (this.mediaChunks.size() > 1) {
                ArrayList<BaseMediaChunk> arrayList = this.mediaChunks;
                lastMediaChunk = arrayList.get(arrayList.size() - 2);
            } else {
                lastMediaChunk = null;
            }
        }
        if (lastMediaChunk != null) {
            j = Math.max(j, lastMediaChunk.endTimeUs);
        }
        return Math.max(j, this.primarySampleQueue.getLargestQueuedTimestampUs());
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public long getAdjustedSeekPositionUs(long r2, com.google.android.exoplayer2.SeekParameters r4) {
        /*
            r1 = this;
            T r0 = r1.chunkSource
            long r2 = r0.getAdjustedSeekPositionUs(r2, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.chunk.ChunkSampleStream.getAdjustedSeekPositionUs(long, com.google.android.exoplayer2.SeekParameters):long");
    }

    public void seekToUs(long j) {
        boolean z;
        this.lastSeekPositionUs = j;
        if (isPendingReset()) {
            this.pendingResetPositionUs = j;
            return;
        }
        BaseMediaChunk baseMediaChunk = null;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= this.mediaChunks.size()) {
                break;
            }
            BaseMediaChunk baseMediaChunk2 = this.mediaChunks.get(i2);
            long j2 = baseMediaChunk2.startTimeUs;
            if (j2 != j || baseMediaChunk2.clippedStartTimeUs != -9223372036854775807L) {
                if (j2 > j) {
                    break;
                }
                i2++;
            } else {
                baseMediaChunk = baseMediaChunk2;
                break;
            }
        }
        if (baseMediaChunk != null) {
            z = this.primarySampleQueue.seekTo(baseMediaChunk.getFirstSampleIndex(0));
            this.decodeOnlyUntilPositionUs = 0;
        } else {
            z = this.primarySampleQueue.seekTo(j, j < getNextLoadPositionUs());
            this.decodeOnlyUntilPositionUs = this.lastSeekPositionUs;
        }
        if (z) {
            this.nextNotifyPrimaryFormatMediaChunkIndex = primarySampleIndexToMediaChunkIndex(this.primarySampleQueue.getReadIndex(), 0);
            SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
            int length = sampleQueueArr.length;
            while (i < length) {
                sampleQueueArr[i].seekTo(j, true);
                i++;
            }
            return;
        }
        this.pendingResetPositionUs = j;
        this.loadingFinished = false;
        this.mediaChunks.clear();
        this.nextNotifyPrimaryFormatMediaChunkIndex = 0;
        if (this.loader.isLoading()) {
            this.loader.cancelLoading();
            return;
        }
        this.loader.clearFatalError();
        this.primarySampleQueue.reset();
        SampleQueue[] sampleQueueArr2 = this.embeddedSampleQueues;
        int length2 = sampleQueueArr2.length;
        while (i < length2) {
            sampleQueueArr2[i].reset();
            i++;
        }
    }

    public void release() {
        release(null);
    }

    public void release(ReleaseCallback<T> releaseCallback2) {
        this.releaseCallback = releaseCallback2;
        this.primarySampleQueue.preRelease();
        for (SampleQueue preRelease : this.embeddedSampleQueues) {
            preRelease.preRelease();
        }
        this.loader.release(this);
    }

    public void onLoaderReleased() {
        this.primarySampleQueue.release();
        for (SampleQueue release : this.embeddedSampleQueues) {
            release.release();
        }
        ReleaseCallback<T> releaseCallback2 = this.releaseCallback;
        if (releaseCallback2 != null) {
            releaseCallback2.onSampleStreamReleased(this);
        }
    }

    public boolean isReady() {
        return !isPendingReset() && this.primarySampleQueue.isReady(this.loadingFinished);
    }

    public void maybeThrowError() throws IOException {
        this.loader.maybeThrowError();
        this.primarySampleQueue.maybeThrowError();
        if (!this.loader.isLoading()) {
            this.chunkSource.maybeThrowError();
        }
    }

    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
        if (isPendingReset()) {
            return -3;
        }
        maybeNotifyPrimaryTrackFormatChanged();
        return this.primarySampleQueue.read(formatHolder, decoderInputBuffer, z, this.loadingFinished, this.decodeOnlyUntilPositionUs);
    }

    public int skipData(long j) {
        int i;
        if (isPendingReset()) {
            return 0;
        }
        if (!this.loadingFinished || j <= this.primarySampleQueue.getLargestQueuedTimestampUs()) {
            i = this.primarySampleQueue.advanceTo(j);
        } else {
            i = this.primarySampleQueue.advanceToEnd();
        }
        maybeNotifyPrimaryTrackFormatChanged();
        return i;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public void onLoadCompleted(com.google.android.exoplayer2.source.chunk.Chunk r22, long r23, long r25) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r15 = r23
            r17 = r25
            T r2 = r0.chunkSource
            r2.onChunkLoadCompleted(r1)
            com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher r2 = r0.eventDispatcher
            com.google.android.exoplayer2.upstream.DataSpec r3 = r1.dataSpec
            android.net.Uri r4 = r22.getUri()
            java.util.Map r5 = r22.getResponseHeaders()
            int r6 = r1.type
            int r7 = r0.primaryTrackType
            com.google.android.exoplayer2.Format r8 = r1.trackFormat
            int r9 = r1.trackSelectionReason
            java.lang.Object r10 = r1.trackSelectionData
            long r11 = r1.startTimeUs
            long r13 = r1.endTimeUs
            long r19 = r22.bytesLoaded()
            r2.loadCompleted(r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r15, r17, r19)
            com.google.android.exoplayer2.source.SequenceableLoader$Callback<com.google.android.exoplayer2.source.chunk.ChunkSampleStream<T>> r1 = r0.callback
            r1.onContinueLoadingRequested(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.chunk.ChunkSampleStream.onLoadCompleted(com.google.android.exoplayer2.source.chunk.Chunk, long, long):void");
    }

    public void onLoadCanceled(Chunk chunk, long j, long j2, boolean z) {
        Chunk chunk2 = chunk;
        this.eventDispatcher.loadCanceled(chunk2.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), chunk2.type, this.primaryTrackType, chunk2.trackFormat, chunk2.trackSelectionReason, chunk2.trackSelectionData, chunk2.startTimeUs, chunk2.endTimeUs, j, j2, chunk.bytesLoaded());
        if (!z) {
            this.primarySampleQueue.reset();
            for (SampleQueue reset : this.embeddedSampleQueues) {
                reset.reset();
            }
            this.callback.onContinueLoadingRequested(this);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public com.google.android.exoplayer2.upstream.Loader.LoadErrorAction onLoadError(com.google.android.exoplayer2.source.chunk.Chunk r30, long r31, long r33, java.io.IOException r35, int r36) {
        /*
            r29 = this;
            r0 = r29
            r7 = r30
            long r25 = r30.bytesLoaded()
            boolean r8 = r29.isMediaChunk(r30)
            java.util.ArrayList<com.google.android.exoplayer2.source.chunk.BaseMediaChunk> r1 = r0.mediaChunks
            int r1 = r1.size()
            r9 = 1
            int r10 = r1 + -1
            r11 = 0
            r1 = 0
            int r3 = (r25 > r1 ? 1 : (r25 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x0027
            if (r8 == 0) goto L_0x0027
            boolean r1 = r0.haveReadFromMediaChunk(r10)
            if (r1 != 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r12 = 0
            goto L_0x0028
        L_0x0027:
            r12 = 1
        L_0x0028:
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r12 == 0) goto L_0x003f
            com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy r1 = r0.loadErrorHandlingPolicy
            int r2 = r7.type
            r3 = r33
            r5 = r35
            r6 = r36
            long r1 = r1.getBlacklistDurationMsFor(r2, r3, r5, r6)
            r5 = r1
            goto L_0x0040
        L_0x003f:
            r5 = r13
        L_0x0040:
            r15 = 0
            T r1 = r0.chunkSource
            r2 = r30
            r3 = r12
            r4 = r35
            boolean r1 = r1.onChunkLoadError(r2, r3, r4, r5)
            if (r1 == 0) goto L_0x0074
            if (r12 == 0) goto L_0x006d
            com.google.android.exoplayer2.upstream.Loader$LoadErrorAction r15 = com.google.android.exoplayer2.upstream.Loader.DONT_RETRY
            if (r8 == 0) goto L_0x0074
            com.google.android.exoplayer2.source.chunk.BaseMediaChunk r1 = r0.discardUpstreamMediaChunksFromIndex(r10)
            if (r1 != r7) goto L_0x005c
            r1 = 1
            goto L_0x005d
        L_0x005c:
            r1 = 0
        L_0x005d:
            com.google.android.exoplayer2.util.Assertions.checkState(r1)
            java.util.ArrayList<com.google.android.exoplayer2.source.chunk.BaseMediaChunk> r1 = r0.mediaChunks
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0074
            long r1 = r0.lastSeekPositionUs
            r0.pendingResetPositionUs = r1
            goto L_0x0074
        L_0x006d:
            java.lang.String r1 = "ChunkSampleStream"
            java.lang.String r2 = "Ignoring attempt to cancel non-cancelable load."
            com.google.android.exoplayer2.util.Log.w(r1, r2)
        L_0x0074:
            if (r15 != 0) goto L_0x0090
            com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy r1 = r0.loadErrorHandlingPolicy
            int r2 = r7.type
            r3 = r33
            r5 = r35
            r6 = r36
            long r1 = r1.getRetryDelayMsFor(r2, r3, r5, r6)
            int r3 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r3 == 0) goto L_0x008d
            com.google.android.exoplayer2.upstream.Loader$LoadErrorAction r1 = com.google.android.exoplayer2.upstream.Loader.createRetryAction(r11, r1)
            goto L_0x008f
        L_0x008d:
            com.google.android.exoplayer2.upstream.Loader$LoadErrorAction r1 = com.google.android.exoplayer2.upstream.Loader.DONT_RETRY_FATAL
        L_0x008f:
            r15 = r1
        L_0x0090:
            r1 = r15
            boolean r2 = r1.isRetry()
            r2 = r2 ^ r9
            r28 = r2
            com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher r8 = r0.eventDispatcher
            com.google.android.exoplayer2.upstream.DataSpec r9 = r7.dataSpec
            android.net.Uri r10 = r30.getUri()
            java.util.Map r11 = r30.getResponseHeaders()
            int r12 = r7.type
            int r13 = r0.primaryTrackType
            com.google.android.exoplayer2.Format r14 = r7.trackFormat
            int r15 = r7.trackSelectionReason
            java.lang.Object r3 = r7.trackSelectionData
            r16 = r3
            long r3 = r7.startTimeUs
            r17 = r3
            long r3 = r7.endTimeUs
            r19 = r3
            r21 = r31
            r23 = r33
            r27 = r35
            r8.loadError(r9, r10, r11, r12, r13, r14, r15, r16, r17, r19, r21, r23, r25, r27, r28)
            if (r2 == 0) goto L_0x00c8
            com.google.android.exoplayer2.source.SequenceableLoader$Callback<com.google.android.exoplayer2.source.chunk.ChunkSampleStream<T>> r2 = r0.callback
            r2.onContinueLoadingRequested(r0)
        L_0x00c8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.chunk.ChunkSampleStream.onLoadError(com.google.android.exoplayer2.source.chunk.Chunk, long, long, java.io.IOException, int):com.google.android.exoplayer2.upstream.Loader$LoadErrorAction");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public boolean continueLoading(long r22) {
        /*
            r21 = this;
            r0 = r21
            boolean r1 = r0.loadingFinished
            r2 = 0
            if (r1 != 0) goto L_0x00b3
            com.google.android.exoplayer2.upstream.Loader r1 = r0.loader
            boolean r1 = r1.isLoading()
            if (r1 != 0) goto L_0x00b3
            com.google.android.exoplayer2.upstream.Loader r1 = r0.loader
            boolean r1 = r1.hasFatalError()
            if (r1 == 0) goto L_0x0019
            goto L_0x00b3
        L_0x0019:
            boolean r1 = r21.isPendingReset()
            if (r1 == 0) goto L_0x0026
            java.util.List r3 = java.util.Collections.emptyList()
            long r4 = r0.pendingResetPositionUs
            goto L_0x002e
        L_0x0026:
            java.util.List<com.google.android.exoplayer2.source.chunk.BaseMediaChunk> r3 = r0.readOnlyMediaChunks
            com.google.android.exoplayer2.source.chunk.BaseMediaChunk r4 = r21.getLastMediaChunk()
            long r4 = r4.endTimeUs
        L_0x002e:
            r11 = r3
            r9 = r4
            T r6 = r0.chunkSource
            com.google.android.exoplayer2.source.chunk.ChunkHolder r12 = r0.nextChunkHolder
            r7 = r22
            r6.getNextChunk(r7, r9, r11, r12)
            com.google.android.exoplayer2.source.chunk.ChunkHolder r3 = r0.nextChunkHolder
            boolean r3 = r3.endOfStream
            com.google.android.exoplayer2.source.chunk.ChunkHolder r4 = r0.nextChunkHolder
            com.google.android.exoplayer2.source.chunk.Chunk r4 = r4.chunk
            com.google.android.exoplayer2.source.chunk.ChunkHolder r5 = r0.nextChunkHolder
            r5.clear()
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = 1
            if (r3 == 0) goto L_0x0053
            r0.pendingResetPositionUs = r5
            r0.loadingFinished = r7
            return r7
        L_0x0053:
            if (r4 != 0) goto L_0x0056
            return r2
        L_0x0056:
            boolean r3 = r0.isMediaChunk(r4)
            if (r3 == 0) goto L_0x0080
            r3 = r4
            com.google.android.exoplayer2.source.chunk.BaseMediaChunk r3 = (com.google.android.exoplayer2.source.chunk.BaseMediaChunk) r3
            if (r1 == 0) goto L_0x0075
            long r8 = r3.startTimeUs
            long r10 = r0.pendingResetPositionUs
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r1 != 0) goto L_0x006a
            r2 = 1
        L_0x006a:
            if (r2 == 0) goto L_0x006f
            r1 = 0
            goto L_0x0071
        L_0x006f:
            long r1 = r0.pendingResetPositionUs
        L_0x0071:
            r0.decodeOnlyUntilPositionUs = r1
            r0.pendingResetPositionUs = r5
        L_0x0075:
            com.google.android.exoplayer2.source.chunk.BaseMediaChunkOutput r1 = r0.chunkOutput
            r3.init(r1)
            java.util.ArrayList<com.google.android.exoplayer2.source.chunk.BaseMediaChunk> r1 = r0.mediaChunks
            r1.add(r3)
            goto L_0x008c
        L_0x0080:
            boolean r1 = r4 instanceof com.google.android.exoplayer2.source.chunk.InitializationChunk
            if (r1 == 0) goto L_0x008c
            r1 = r4
            com.google.android.exoplayer2.source.chunk.InitializationChunk r1 = (com.google.android.exoplayer2.source.chunk.InitializationChunk) r1
            com.google.android.exoplayer2.source.chunk.BaseMediaChunkOutput r2 = r0.chunkOutput
            r1.init(r2)
        L_0x008c:
            com.google.android.exoplayer2.upstream.Loader r1 = r0.loader
            com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy r2 = r0.loadErrorHandlingPolicy
            int r3 = r4.type
            int r2 = r2.getMinimumLoadableRetryCount(r3)
            long r19 = r1.startLoading(r4, r0, r2)
            com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher r8 = r0.eventDispatcher
            com.google.android.exoplayer2.upstream.DataSpec r9 = r4.dataSpec
            int r10 = r4.type
            int r11 = r0.primaryTrackType
            com.google.android.exoplayer2.Format r12 = r4.trackFormat
            int r13 = r4.trackSelectionReason
            java.lang.Object r14 = r4.trackSelectionData
            long r1 = r4.startTimeUs
            long r3 = r4.endTimeUs
            r15 = r1
            r17 = r3
            r8.loadStarted(r9, r10, r11, r12, r13, r14, r15, r17, r19)
            return r7
        L_0x00b3:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.chunk.ChunkSampleStream.continueLoading(long):boolean");
    }

    public boolean isLoading() {
        return this.loader.isLoading();
    }

    public long getNextLoadPositionUs() {
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        return getLastMediaChunk().endTimeUs;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public void reevaluateBuffer(long r7) {
        /*
            r6 = this;
            com.google.android.exoplayer2.upstream.Loader r0 = r6.loader
            boolean r0 = r0.isLoading()
            if (r0 != 0) goto L_0x005a
            com.google.android.exoplayer2.upstream.Loader r0 = r6.loader
            boolean r0 = r0.hasFatalError()
            if (r0 != 0) goto L_0x005a
            boolean r0 = r6.isPendingReset()
            if (r0 == 0) goto L_0x0017
            goto L_0x005a
        L_0x0017:
            java.util.ArrayList<com.google.android.exoplayer2.source.chunk.BaseMediaChunk> r0 = r6.mediaChunks
            int r0 = r0.size()
            T r1 = r6.chunkSource
            java.util.List<com.google.android.exoplayer2.source.chunk.BaseMediaChunk> r2 = r6.readOnlyMediaChunks
            int r7 = r1.getPreferredQueueSize(r7, r2)
            if (r0 > r7) goto L_0x0028
            return
        L_0x0028:
            if (r7 >= r0) goto L_0x0034
            boolean r8 = r6.haveReadFromMediaChunk(r7)
            if (r8 != 0) goto L_0x0031
            goto L_0x0035
        L_0x0031:
            int r7 = r7 + 1
            goto L_0x0028
        L_0x0034:
            r7 = r0
        L_0x0035:
            if (r7 != r0) goto L_0x0038
            return
        L_0x0038:
            com.google.android.exoplayer2.source.chunk.BaseMediaChunk r8 = r6.getLastMediaChunk()
            long r4 = r8.endTimeUs
            com.google.android.exoplayer2.source.chunk.BaseMediaChunk r7 = r6.discardUpstreamMediaChunksFromIndex(r7)
            java.util.ArrayList<com.google.android.exoplayer2.source.chunk.BaseMediaChunk> r8 = r6.mediaChunks
            boolean r8 = r8.isEmpty()
            if (r8 == 0) goto L_0x004e
            long r0 = r6.lastSeekPositionUs
            r6.pendingResetPositionUs = r0
        L_0x004e:
            r8 = 0
            r6.loadingFinished = r8
            com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher r0 = r6.eventDispatcher
            int r1 = r6.primaryTrackType
            long r2 = r7.startTimeUs
            r0.upstreamDiscarded(r1, r2, r4)
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.chunk.ChunkSampleStream.reevaluateBuffer(long):void");
    }

    private boolean isMediaChunk(Chunk chunk) {
        return chunk instanceof BaseMediaChunk;
    }

    private boolean haveReadFromMediaChunk(int i) {
        int readIndex;
        BaseMediaChunk baseMediaChunk = this.mediaChunks.get(i);
        if (this.primarySampleQueue.getReadIndex() > baseMediaChunk.getFirstSampleIndex(0)) {
            return true;
        }
        int i2 = 0;
        do {
            SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
            if (i2 >= sampleQueueArr.length) {
                return false;
            }
            readIndex = sampleQueueArr[i2].getReadIndex();
            i2++;
        } while (readIndex <= baseMediaChunk.getFirstSampleIndex(i2));
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean isPendingReset() {
        return this.pendingResetPositionUs != -9223372036854775807L;
    }

    private void discardDownstreamMediaChunks(int i) {
        int min = Math.min(primarySampleIndexToMediaChunkIndex(i, 0), this.nextNotifyPrimaryFormatMediaChunkIndex);
        if (min > 0) {
            Util.removeRange(this.mediaChunks, 0, min);
            this.nextNotifyPrimaryFormatMediaChunkIndex -= min;
        }
    }

    private void maybeNotifyPrimaryTrackFormatChanged() {
        int primarySampleIndexToMediaChunkIndex = primarySampleIndexToMediaChunkIndex(this.primarySampleQueue.getReadIndex(), this.nextNotifyPrimaryFormatMediaChunkIndex - 1);
        while (true) {
            int i = this.nextNotifyPrimaryFormatMediaChunkIndex;
            if (i <= primarySampleIndexToMediaChunkIndex) {
                this.nextNotifyPrimaryFormatMediaChunkIndex = i + 1;
                maybeNotifyPrimaryTrackFormatChanged(i);
            } else {
                return;
            }
        }
    }

    private void maybeNotifyPrimaryTrackFormatChanged(int i) {
        BaseMediaChunk baseMediaChunk = this.mediaChunks.get(i);
        Format format = baseMediaChunk.trackFormat;
        if (!format.equals(this.primaryDownstreamTrackFormat)) {
            this.eventDispatcher.downstreamFormatChanged(this.primaryTrackType, format, baseMediaChunk.trackSelectionReason, baseMediaChunk.trackSelectionData, baseMediaChunk.startTimeUs);
        }
        this.primaryDownstreamTrackFormat = format;
    }

    private int primarySampleIndexToMediaChunkIndex(int i, int i2) {
        do {
            i2++;
            if (i2 >= this.mediaChunks.size()) {
                return this.mediaChunks.size() - 1;
            }
        } while (this.mediaChunks.get(i2).getFirstSampleIndex(0) <= i);
        return i2 - 1;
    }

    private BaseMediaChunk getLastMediaChunk() {
        ArrayList<BaseMediaChunk> arrayList = this.mediaChunks;
        return arrayList.get(arrayList.size() - 1);
    }

    private BaseMediaChunk discardUpstreamMediaChunksFromIndex(int i) {
        BaseMediaChunk baseMediaChunk = this.mediaChunks.get(i);
        ArrayList<BaseMediaChunk> arrayList = this.mediaChunks;
        Util.removeRange(arrayList, i, arrayList.size());
        this.nextNotifyPrimaryFormatMediaChunkIndex = Math.max(this.nextNotifyPrimaryFormatMediaChunkIndex, this.mediaChunks.size());
        int i2 = 0;
        this.primarySampleQueue.discardUpstreamSamples(baseMediaChunk.getFirstSampleIndex(0));
        while (true) {
            SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
            if (i2 >= sampleQueueArr.length) {
                return baseMediaChunk;
            }
            SampleQueue sampleQueue = sampleQueueArr[i2];
            i2++;
            sampleQueue.discardUpstreamSamples(baseMediaChunk.getFirstSampleIndex(i2));
        }
    }

    public final class EmbeddedSampleStream implements SampleStream {
        private final int index;
        private boolean notifiedDownstreamFormat;
        public final ChunkSampleStream<T> parent;
        private final SampleQueue sampleQueue;

        public final void maybeThrowError() {
        }

        public EmbeddedSampleStream(ChunkSampleStream<T> chunkSampleStream, SampleQueue sampleQueue2, int i) {
            this.parent = chunkSampleStream;
            this.sampleQueue = sampleQueue2;
            this.index = i;
        }

        public final boolean isReady() {
            return !ChunkSampleStream.this.isPendingReset() && this.sampleQueue.isReady(ChunkSampleStream.this.loadingFinished);
        }

        public final int skipData(long j) {
            if (ChunkSampleStream.this.isPendingReset()) {
                return 0;
            }
            maybeNotifyDownstreamFormat();
            if (!ChunkSampleStream.this.loadingFinished || j <= this.sampleQueue.getLargestQueuedTimestampUs()) {
                return this.sampleQueue.advanceTo(j);
            }
            return this.sampleQueue.advanceToEnd();
        }

        public final int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
            if (ChunkSampleStream.this.isPendingReset()) {
                return -3;
            }
            maybeNotifyDownstreamFormat();
            return this.sampleQueue.read(formatHolder, decoderInputBuffer, z, ChunkSampleStream.this.loadingFinished, ChunkSampleStream.this.decodeOnlyUntilPositionUs);
        }

        public final void release() {
            Assertions.checkState(ChunkSampleStream.this.embeddedTracksSelected[this.index]);
            ChunkSampleStream.this.embeddedTracksSelected[this.index] = false;
        }

        private void maybeNotifyDownstreamFormat() {
            if (!this.notifiedDownstreamFormat) {
                ChunkSampleStream.this.eventDispatcher.downstreamFormatChanged(ChunkSampleStream.this.embeddedTrackTypes[this.index], ChunkSampleStream.this.embeddedTrackFormats[this.index], 0, null, ChunkSampleStream.this.lastSeekPositionUs);
                this.notifiedDownstreamFormat = true;
            }
        }
    }
}
