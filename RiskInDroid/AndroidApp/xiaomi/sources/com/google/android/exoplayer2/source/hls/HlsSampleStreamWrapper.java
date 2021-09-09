package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.hls.HlsChunkSource;
import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class HlsSampleStreamWrapper implements ExtractorOutput, SampleQueue.UpstreamFormatChangedListener, SequenceableLoader, Loader.Callback<Chunk>, Loader.ReleaseCallback {
    private static final Set<Integer> MAPPABLE_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 4)));
    private final Allocator allocator;
    private final Callback callback;
    private final HlsChunkSource chunkSource;
    private Format downstreamTrackFormat;
    private DrmInitData drmInitData;
    private final DrmSessionManager drmSessionManager;
    private TrackOutput emsgUnwrappingTrackOutput;
    private int enabledTrackGroupCount;
    private final MediaSourceEventListener.EventDispatcher eventDispatcher;
    private final Handler handler = Util.createHandler();
    private boolean haveAudioVideoSampleQueues;
    private final ArrayList<HlsSampleStream> hlsSampleStreams = new ArrayList<>();
    private long lastSeekPositionUs;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final Loader loader = new Loader("Loader:HlsSampleStreamWrapper");
    private boolean loadingFinished;
    private final Runnable maybeFinishPrepareRunnable = new Runnable() {
        /* class com.google.android.exoplayer2.source.hls.$$Lambda$HlsSampleStreamWrapper$8JyeEr0irIOShv9LlAxAmgzl5vY */

        public final void run() {
            HlsSampleStreamWrapper.this.maybeFinishPrepare();
        }
    };
    private final ArrayList<HlsMediaChunk> mediaChunks = new ArrayList<>();
    private final int metadataType;
    private final Format muxedAudioFormat;
    private final HlsChunkSource.HlsChunkHolder nextChunkHolder = new HlsChunkSource.HlsChunkHolder();
    private final Runnable onTracksEndedRunnable = new Runnable() {
        /* class com.google.android.exoplayer2.source.hls.$$Lambda$HlsSampleStreamWrapper$afhkI3tagC_MAOTh7FzBWzQsno */

        public final void run() {
            HlsSampleStreamWrapper.this.onTracksEnded();
        }
    };
    private Set<TrackGroup> optionalTrackGroups;
    private final Map<String, DrmInitData> overridingDrmInitData;
    private long pendingResetPositionUs;
    private boolean pendingResetUpstreamFormats;
    private boolean prepared;
    private int primarySampleQueueIndex;
    private int primarySampleQueueType;
    private int primaryTrackGroupIndex;
    private final List<HlsMediaChunk> readOnlyMediaChunks = Collections.unmodifiableList(this.mediaChunks);
    private boolean released;
    private long sampleOffsetUs;
    private SparseIntArray sampleQueueIndicesByType = new SparseIntArray(MAPPABLE_TYPES.size());
    private boolean[] sampleQueueIsAudioVideoFlags = new boolean[0];
    private Set<Integer> sampleQueueMappingDoneByType = new HashSet(MAPPABLE_TYPES.size());
    private int[] sampleQueueTrackIds = new int[0];
    private HlsSampleQueue[] sampleQueues = new HlsSampleQueue[0];
    private boolean sampleQueuesBuilt;
    private boolean[] sampleQueuesEnabledStates = new boolean[0];
    private boolean seenFirstTrackSelection;
    private HlsMediaChunk sourceChunk;
    private int[] trackGroupToSampleQueueIndex;
    private TrackGroupArray trackGroups;
    private final int trackType;
    private boolean tracksEnded;
    private Format upstreamTrackFormat;

    public interface Callback extends SequenceableLoader.Callback<HlsSampleStreamWrapper> {
        void onPlaylistRefreshRequired(Uri uri);

        void onPrepared();
    }

    private static int getTrackTypeScore(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? 0 : 1;
        }
        return 3;
    }

    public final void reevaluateBuffer(long j) {
    }

    public final void seekMap(SeekMap seekMap) {
    }

    public HlsSampleStreamWrapper(int i, Callback callback2, HlsChunkSource hlsChunkSource, Map<String, DrmInitData> map, Allocator allocator2, long j, Format format, DrmSessionManager drmSessionManager2, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, MediaSourceEventListener.EventDispatcher eventDispatcher2, int i2) {
        this.trackType = i;
        this.callback = callback2;
        this.chunkSource = hlsChunkSource;
        this.overridingDrmInitData = map;
        this.allocator = allocator2;
        this.muxedAudioFormat = format;
        this.drmSessionManager = drmSessionManager2;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.eventDispatcher = eventDispatcher2;
        this.metadataType = i2;
        this.lastSeekPositionUs = j;
        this.pendingResetPositionUs = j;
    }

    public final void continuePreparing() {
        if (!this.prepared) {
            continueLoading(this.lastSeekPositionUs);
        }
    }

    public final void prepareWithMasterPlaylistInfo(TrackGroup[] trackGroupArr, int i, int... iArr) {
        this.trackGroups = createTrackGroupArrayWithDrmInfo(trackGroupArr);
        this.optionalTrackGroups = new HashSet();
        for (int i2 : iArr) {
            this.optionalTrackGroups.add(this.trackGroups.get(i2));
        }
        this.primaryTrackGroupIndex = i;
        Handler handler2 = this.handler;
        Callback callback2 = this.callback;
        callback2.getClass();
        handler2.post(new Runnable() {
            /* class com.google.android.exoplayer2.source.hls.$$Lambda$COgt3RAipLG3mXfQxbryzRjBpos */

            public final void run() {
                HlsSampleStreamWrapper.Callback.this.onPrepared();
            }
        });
        setIsPrepared();
    }

    public final void maybeThrowPrepareError() throws IOException {
        maybeThrowError();
        if (this.loadingFinished && !this.prepared) {
            throw new ParserException("Loading finished before preparation is complete.");
        }
    }

    public final TrackGroupArray getTrackGroups() {
        assertIsPrepared();
        return this.trackGroups;
    }

    public final int getPrimaryTrackGroupIndex() {
        return this.primaryTrackGroupIndex;
    }

    public final int bindSampleQueueToSampleStream(int i) {
        assertIsPrepared();
        Assertions.checkNotNull(this.trackGroupToSampleQueueIndex);
        int i2 = this.trackGroupToSampleQueueIndex[i];
        if (i2 != -1) {
            boolean[] zArr = this.sampleQueuesEnabledStates;
            if (zArr[i2]) {
                return -2;
            }
            zArr[i2] = true;
            return i2;
        } else if (this.optionalTrackGroups.contains(this.trackGroups.get(i))) {
            return -3;
        } else {
            return -2;
        }
    }

    public final void unbindSampleQueue(int i) {
        assertIsPrepared();
        Assertions.checkNotNull(this.trackGroupToSampleQueueIndex);
        int i2 = this.trackGroupToSampleQueueIndex[i];
        Assertions.checkState(this.sampleQueuesEnabledStates[i2]);
        this.sampleQueuesEnabledStates[i2] = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0130  */
    public final boolean selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j, boolean z) {
        boolean z2;
        boolean z3;
        TrackSelection[] trackSelectionArr2 = trackSelectionArr;
        SampleStream[] sampleStreamArr2 = sampleStreamArr;
        long j2 = j;
        assertIsPrepared();
        int i = this.enabledTrackGroupCount;
        int i2 = 0;
        for (int i3 = 0; i3 < trackSelectionArr2.length; i3++) {
            HlsSampleStream hlsSampleStream = (HlsSampleStream) sampleStreamArr2[i3];
            if (hlsSampleStream != null && (trackSelectionArr2[i3] == null || !zArr[i3])) {
                this.enabledTrackGroupCount--;
                hlsSampleStream.unbindSampleQueue();
                sampleStreamArr2[i3] = null;
            }
        }
        boolean z4 = z || (!this.seenFirstTrackSelection ? j2 != this.lastSeekPositionUs : i == 0);
        TrackSelection trackSelection = this.chunkSource.getTrackSelection();
        boolean z5 = z4;
        TrackSelection trackSelection2 = trackSelection;
        for (int i4 = 0; i4 < trackSelectionArr2.length; i4++) {
            TrackSelection trackSelection3 = trackSelectionArr2[i4];
            if (trackSelection3 != null) {
                int indexOf = this.trackGroups.indexOf(trackSelection3.getTrackGroup());
                if (indexOf == this.primaryTrackGroupIndex) {
                    this.chunkSource.setTrackSelection(trackSelection3);
                    trackSelection2 = trackSelection3;
                }
                if (sampleStreamArr2[i4] == null) {
                    this.enabledTrackGroupCount++;
                    sampleStreamArr2[i4] = new HlsSampleStream(this, indexOf);
                    zArr2[i4] = true;
                    if (this.trackGroupToSampleQueueIndex != null) {
                        ((HlsSampleStream) sampleStreamArr2[i4]).bindSampleQueue();
                        if (!z5) {
                            HlsSampleQueue hlsSampleQueue = this.sampleQueues[this.trackGroupToSampleQueueIndex[indexOf]];
                            z5 = !hlsSampleQueue.seekTo(j2, true) && hlsSampleQueue.getReadIndex() != 0;
                        }
                    }
                }
            }
        }
        if (this.enabledTrackGroupCount == 0) {
            this.chunkSource.reset();
            this.downstreamTrackFormat = null;
            this.pendingResetUpstreamFormats = true;
            this.mediaChunks.clear();
            if (this.loader.isLoading()) {
                if (this.sampleQueuesBuilt) {
                    HlsSampleQueue[] hlsSampleQueueArr = this.sampleQueues;
                    int length = hlsSampleQueueArr.length;
                    while (i2 < length) {
                        hlsSampleQueueArr[i2].discardToEnd();
                        i2++;
                    }
                }
                this.loader.cancelLoading();
            } else {
                resetSampleQueues();
            }
        } else {
            if (!this.mediaChunks.isEmpty() && !Util.areEqual(trackSelection2, trackSelection)) {
                if (!this.seenFirstTrackSelection) {
                    long j3 = 0;
                    if (j2 < 0) {
                        j3 = -j2;
                    }
                    HlsMediaChunk lastMediaChunk = getLastMediaChunk();
                    TrackSelection trackSelection4 = trackSelection2;
                    trackSelection2.updateSelectedTrack(j, j3, -9223372036854775807L, this.readOnlyMediaChunks, this.chunkSource.createMediaChunkIterators(lastMediaChunk, j2));
                    if (trackSelection4.getSelectedIndexInTrackGroup() == this.chunkSource.getTrackGroup().indexOf(lastMediaChunk.trackFormat)) {
                        z3 = false;
                        if (z3) {
                            this.pendingResetUpstreamFormats = true;
                            z2 = true;
                            z5 = true;
                            if (z5) {
                                seekToUs(j2, z2);
                                while (i2 < sampleStreamArr2.length) {
                                    if (sampleStreamArr2[i2] != null) {
                                        zArr2[i2] = true;
                                    }
                                    i2++;
                                }
                            }
                        }
                    }
                }
                z3 = true;
                if (z3) {
                }
            }
            z2 = z;
            if (z5) {
            }
        }
        updateSampleStreams(sampleStreamArr2);
        this.seenFirstTrackSelection = true;
        return z5;
    }

    public final void discardBuffer(long j, boolean z) {
        if (this.sampleQueuesBuilt && !isPendingReset()) {
            int length = this.sampleQueues.length;
            for (int i = 0; i < length; i++) {
                this.sampleQueues[i].discardTo(j, z, this.sampleQueuesEnabledStates[i]);
            }
        }
    }

    public final boolean seekToUs(long j, boolean z) {
        this.lastSeekPositionUs = j;
        if (isPendingReset()) {
            this.pendingResetPositionUs = j;
            return true;
        } else if (this.sampleQueuesBuilt && !z && seekInsideBufferUs(j)) {
            return false;
        } else {
            this.pendingResetPositionUs = j;
            this.loadingFinished = false;
            this.mediaChunks.clear();
            if (this.loader.isLoading()) {
                this.loader.cancelLoading();
            } else {
                this.loader.clearFatalError();
                resetSampleQueues();
            }
            return true;
        }
    }

    public final void release() {
        if (this.prepared) {
            for (HlsSampleQueue preRelease : this.sampleQueues) {
                preRelease.preRelease();
            }
        }
        this.loader.release(this);
        this.handler.removeCallbacksAndMessages(null);
        this.released = true;
        this.hlsSampleStreams.clear();
    }

    public final void onLoaderReleased() {
        for (HlsSampleQueue release : this.sampleQueues) {
            release.release();
        }
    }

    public final void setIsTimestampMaster(boolean z) {
        this.chunkSource.setIsTimestampMaster(z);
    }

    public final boolean onPlaylistError(Uri uri, long j) {
        return this.chunkSource.onPlaylistError(uri, j);
    }

    public final boolean isReady(int i) {
        return !isPendingReset() && this.sampleQueues[i].isReady(this.loadingFinished);
    }

    public final void maybeThrowError(int i) throws IOException {
        maybeThrowError();
        this.sampleQueues[i].maybeThrowError();
    }

    public final void maybeThrowError() throws IOException {
        this.loader.maybeThrowError();
        this.chunkSource.maybeThrowError();
    }

    public final int readData(int i, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
        Format format;
        if (isPendingReset()) {
            return -3;
        }
        int i2 = 0;
        if (!this.mediaChunks.isEmpty()) {
            int i3 = 0;
            while (i3 < this.mediaChunks.size() - 1 && finishedReadingChunk(this.mediaChunks.get(i3))) {
                i3++;
            }
            Util.removeRange(this.mediaChunks, 0, i3);
            HlsMediaChunk hlsMediaChunk = this.mediaChunks.get(0);
            Format format2 = hlsMediaChunk.trackFormat;
            if (!format2.equals(this.downstreamTrackFormat)) {
                this.eventDispatcher.downstreamFormatChanged(this.trackType, format2, hlsMediaChunk.trackSelectionReason, hlsMediaChunk.trackSelectionData, hlsMediaChunk.startTimeUs);
            }
            this.downstreamTrackFormat = format2;
        }
        int read = this.sampleQueues[i].read(formatHolder, decoderInputBuffer, z, this.loadingFinished, this.lastSeekPositionUs);
        if (read == -5) {
            Format format3 = (Format) Assertions.checkNotNull(formatHolder.format);
            if (i == this.primarySampleQueueIndex) {
                int peekSourceId = this.sampleQueues[i].peekSourceId();
                while (i2 < this.mediaChunks.size() && this.mediaChunks.get(i2).uid != peekSourceId) {
                    i2++;
                }
                if (i2 < this.mediaChunks.size()) {
                    format = this.mediaChunks.get(i2).trackFormat;
                } else {
                    format = (Format) Assertions.checkNotNull(this.upstreamTrackFormat);
                }
                format3 = format3.withManifestFormatInfo(format);
            }
            formatHolder.format = format3;
        }
        return read;
    }

    public final int skipData(int i, long j) {
        if (isPendingReset()) {
            return 0;
        }
        HlsSampleQueue hlsSampleQueue = this.sampleQueues[i];
        if (!this.loadingFinished || j <= hlsSampleQueue.getLargestQueuedTimestampUs()) {
            return hlsSampleQueue.advanceTo(j);
        }
        return hlsSampleQueue.advanceToEnd();
    }

    public final long getBufferedPositionUs() {
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        long j = this.lastSeekPositionUs;
        HlsMediaChunk lastMediaChunk = getLastMediaChunk();
        if (!lastMediaChunk.isLoadCompleted()) {
            if (this.mediaChunks.size() > 1) {
                ArrayList<HlsMediaChunk> arrayList = this.mediaChunks;
                lastMediaChunk = arrayList.get(arrayList.size() - 2);
            } else {
                lastMediaChunk = null;
            }
        }
        if (lastMediaChunk != null) {
            j = Math.max(j, lastMediaChunk.endTimeUs);
        }
        if (this.sampleQueuesBuilt) {
            for (HlsSampleQueue largestQueuedTimestampUs : this.sampleQueues) {
                j = Math.max(j, largestQueuedTimestampUs.getLargestQueuedTimestampUs());
            }
        }
        return j;
    }

    public final long getNextLoadPositionUs() {
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        return getLastMediaChunk().endTimeUs;
    }

    public final boolean continueLoading(long j) {
        List<HlsMediaChunk> list;
        long max;
        if (this.loadingFinished || this.loader.isLoading() || this.loader.hasFatalError()) {
            return false;
        }
        if (isPendingReset()) {
            list = Collections.emptyList();
            max = this.pendingResetPositionUs;
        } else {
            list = this.readOnlyMediaChunks;
            HlsMediaChunk lastMediaChunk = getLastMediaChunk();
            if (lastMediaChunk.isLoadCompleted()) {
                max = lastMediaChunk.endTimeUs;
            } else {
                max = Math.max(this.lastSeekPositionUs, lastMediaChunk.startTimeUs);
            }
        }
        List<HlsMediaChunk> list2 = list;
        this.chunkSource.getNextChunk(j, max, list2, this.prepared || !list2.isEmpty(), this.nextChunkHolder);
        boolean z = this.nextChunkHolder.endOfStream;
        Chunk chunk = this.nextChunkHolder.chunk;
        Uri uri = this.nextChunkHolder.playlistUrl;
        this.nextChunkHolder.clear();
        if (z) {
            this.pendingResetPositionUs = -9223372036854775807L;
            this.loadingFinished = true;
            return true;
        } else if (chunk == null) {
            if (uri != null) {
                this.callback.onPlaylistRefreshRequired(uri);
            }
            return false;
        } else {
            if (isMediaChunk(chunk)) {
                initMediaChunkLoad((HlsMediaChunk) chunk);
            }
            this.eventDispatcher.loadStarted(chunk.dataSpec, chunk.type, this.trackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, this.loader.startLoading(chunk, this, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(chunk.type)));
            return true;
        }
    }

    public final boolean isLoading() {
        return this.loader.isLoading();
    }

    public final void onLoadCompleted(Chunk chunk, long j, long j2) {
        Chunk chunk2 = chunk;
        this.chunkSource.onChunkLoadCompleted(chunk2);
        this.eventDispatcher.loadCompleted(chunk2.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), chunk2.type, this.trackType, chunk2.trackFormat, chunk2.trackSelectionReason, chunk2.trackSelectionData, chunk2.startTimeUs, chunk2.endTimeUs, j, j2, chunk.bytesLoaded());
        if (!this.prepared) {
            continueLoading(this.lastSeekPositionUs);
        } else {
            this.callback.onContinueLoadingRequested(this);
        }
    }

    public final void onLoadCanceled(Chunk chunk, long j, long j2, boolean z) {
        Chunk chunk2 = chunk;
        this.eventDispatcher.loadCanceled(chunk2.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), chunk2.type, this.trackType, chunk2.trackFormat, chunk2.trackSelectionReason, chunk2.trackSelectionData, chunk2.startTimeUs, chunk2.endTimeUs, j, j2, chunk.bytesLoaded());
        if (!z) {
            resetSampleQueues();
            if (this.enabledTrackGroupCount > 0) {
                this.callback.onContinueLoadingRequested(this);
            }
        }
    }

    public final Loader.LoadErrorAction onLoadError(Chunk chunk, long j, long j2, IOException iOException, int i) {
        Loader.LoadErrorAction loadErrorAction;
        Chunk chunk2 = chunk;
        long bytesLoaded = chunk.bytesLoaded();
        boolean isMediaChunk = isMediaChunk(chunk);
        long blacklistDurationMsFor = this.loadErrorHandlingPolicy.getBlacklistDurationMsFor(chunk2.type, j2, iOException, i);
        boolean z = false;
        boolean maybeBlacklistTrack = blacklistDurationMsFor != -9223372036854775807L ? this.chunkSource.maybeBlacklistTrack(chunk2, blacklistDurationMsFor) : false;
        if (maybeBlacklistTrack) {
            if (isMediaChunk && bytesLoaded == 0) {
                ArrayList<HlsMediaChunk> arrayList = this.mediaChunks;
                if (arrayList.remove(arrayList.size() - 1) == chunk2) {
                    z = true;
                }
                Assertions.checkState(z);
                if (this.mediaChunks.isEmpty()) {
                    this.pendingResetPositionUs = this.lastSeekPositionUs;
                }
            }
            loadErrorAction = Loader.DONT_RETRY;
        } else {
            long retryDelayMsFor = this.loadErrorHandlingPolicy.getRetryDelayMsFor(chunk2.type, j2, iOException, i);
            loadErrorAction = retryDelayMsFor != -9223372036854775807L ? Loader.createRetryAction(false, retryDelayMsFor) : Loader.DONT_RETRY_FATAL;
        }
        Loader.LoadErrorAction loadErrorAction2 = loadErrorAction;
        this.eventDispatcher.loadError(chunk2.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), chunk2.type, this.trackType, chunk2.trackFormat, chunk2.trackSelectionReason, chunk2.trackSelectionData, chunk2.startTimeUs, chunk2.endTimeUs, j, j2, bytesLoaded, iOException, !loadErrorAction2.isRetry());
        if (maybeBlacklistTrack) {
            if (!this.prepared) {
                continueLoading(this.lastSeekPositionUs);
            } else {
                this.callback.onContinueLoadingRequested(this);
            }
        }
        return loadErrorAction2;
    }

    private void initMediaChunkLoad(HlsMediaChunk hlsMediaChunk) {
        this.sourceChunk = hlsMediaChunk;
        this.upstreamTrackFormat = hlsMediaChunk.trackFormat;
        this.pendingResetPositionUs = -9223372036854775807L;
        this.mediaChunks.add(hlsMediaChunk);
        hlsMediaChunk.init(this);
        for (HlsSampleQueue sourceChunk2 : this.sampleQueues) {
            sourceChunk2.setSourceChunk(hlsMediaChunk);
        }
        if (hlsMediaChunk.shouldSpliceIn) {
            for (HlsSampleQueue splice : this.sampleQueues) {
                splice.splice();
            }
        }
    }

    public final TrackOutput track(int i, int i2) {
        TrackOutput trackOutput;
        if (!MAPPABLE_TYPES.contains(Integer.valueOf(i2))) {
            int i3 = 0;
            while (true) {
                TrackOutput[] trackOutputArr = this.sampleQueues;
                if (i3 >= trackOutputArr.length) {
                    trackOutput = null;
                    break;
                } else if (this.sampleQueueTrackIds[i3] == i) {
                    trackOutput = trackOutputArr[i3];
                    break;
                } else {
                    i3++;
                }
            }
        } else {
            trackOutput = getMappedTrackOutput(i, i2);
        }
        if (trackOutput == null) {
            if (this.tracksEnded) {
                return createDummyTrackOutput(i, i2);
            }
            trackOutput = createSampleQueue(i, i2);
        }
        if (i2 != 4) {
            return trackOutput;
        }
        if (this.emsgUnwrappingTrackOutput == null) {
            this.emsgUnwrappingTrackOutput = new EmsgUnwrappingTrackOutput(trackOutput, this.metadataType);
        }
        return this.emsgUnwrappingTrackOutput;
    }

    private TrackOutput getMappedTrackOutput(int i, int i2) {
        Assertions.checkArgument(MAPPABLE_TYPES.contains(Integer.valueOf(i2)));
        int i3 = this.sampleQueueIndicesByType.get(i2, -1);
        if (i3 == -1) {
            return null;
        }
        if (this.sampleQueueMappingDoneByType.add(Integer.valueOf(i2))) {
            this.sampleQueueTrackIds[i3] = i;
        }
        if (this.sampleQueueTrackIds[i3] == i) {
            return this.sampleQueues[i3];
        }
        return createDummyTrackOutput(i, i2);
    }

    private SampleQueue createSampleQueue(int i, int i2) {
        int length = this.sampleQueues.length;
        boolean z = true;
        if (!(i2 == 1 || i2 == 2)) {
            z = false;
        }
        HlsSampleQueue hlsSampleQueue = new HlsSampleQueue(this.allocator, this.drmSessionManager, this.eventDispatcher, this.overridingDrmInitData);
        if (z) {
            hlsSampleQueue.setDrmInitData(this.drmInitData);
        }
        hlsSampleQueue.setSampleOffsetUs(this.sampleOffsetUs);
        HlsMediaChunk hlsMediaChunk = this.sourceChunk;
        if (hlsMediaChunk != null) {
            hlsSampleQueue.setSourceChunk(hlsMediaChunk);
        }
        hlsSampleQueue.setUpstreamFormatChangeListener(this);
        int i3 = length + 1;
        this.sampleQueueTrackIds = Arrays.copyOf(this.sampleQueueTrackIds, i3);
        this.sampleQueueTrackIds[length] = i;
        this.sampleQueues = (HlsSampleQueue[]) Util.nullSafeArrayAppend(this.sampleQueues, hlsSampleQueue);
        this.sampleQueueIsAudioVideoFlags = Arrays.copyOf(this.sampleQueueIsAudioVideoFlags, i3);
        boolean[] zArr = this.sampleQueueIsAudioVideoFlags;
        zArr[length] = z;
        this.haveAudioVideoSampleQueues = zArr[length] | this.haveAudioVideoSampleQueues;
        this.sampleQueueMappingDoneByType.add(Integer.valueOf(i2));
        this.sampleQueueIndicesByType.append(i2, length);
        if (getTrackTypeScore(i2) > getTrackTypeScore(this.primarySampleQueueType)) {
            this.primarySampleQueueIndex = length;
            this.primarySampleQueueType = i2;
        }
        this.sampleQueuesEnabledStates = Arrays.copyOf(this.sampleQueuesEnabledStates, i3);
        return hlsSampleQueue;
    }

    public final void endTracks() {
        this.tracksEnded = true;
        this.handler.post(this.onTracksEndedRunnable);
    }

    public final void onUpstreamFormatChanged(Format format) {
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    public final void onNewExtractor() {
        this.sampleQueueMappingDoneByType.clear();
    }

    public final void setSampleOffsetUs(long j) {
        if (this.sampleOffsetUs != j) {
            this.sampleOffsetUs = j;
            for (HlsSampleQueue sampleOffsetUs2 : this.sampleQueues) {
                sampleOffsetUs2.setSampleOffsetUs(j);
            }
        }
    }

    public final void setDrmInitData(DrmInitData drmInitData2) {
        if (!Util.areEqual(this.drmInitData, drmInitData2)) {
            this.drmInitData = drmInitData2;
            int i = 0;
            while (true) {
                HlsSampleQueue[] hlsSampleQueueArr = this.sampleQueues;
                if (i < hlsSampleQueueArr.length) {
                    if (this.sampleQueueIsAudioVideoFlags[i]) {
                        hlsSampleQueueArr[i].setDrmInitData(drmInitData2);
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private void updateSampleStreams(SampleStream[] sampleStreamArr) {
        this.hlsSampleStreams.clear();
        for (SampleStream sampleStream : sampleStreamArr) {
            if (sampleStream != null) {
                this.hlsSampleStreams.add((HlsSampleStream) sampleStream);
            }
        }
    }

    private boolean finishedReadingChunk(HlsMediaChunk hlsMediaChunk) {
        int i = hlsMediaChunk.uid;
        int length = this.sampleQueues.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.sampleQueuesEnabledStates[i2] && this.sampleQueues[i2].peekSourceId() == i) {
                return false;
            }
        }
        return true;
    }

    private void resetSampleQueues() {
        for (HlsSampleQueue reset : this.sampleQueues) {
            reset.reset(this.pendingResetUpstreamFormats);
        }
        this.pendingResetUpstreamFormats = false;
    }

    /* access modifiers changed from: private */
    public void onTracksEnded() {
        this.sampleQueuesBuilt = true;
        maybeFinishPrepare();
    }

    /* access modifiers changed from: private */
    public void maybeFinishPrepare() {
        if (!this.released && this.trackGroupToSampleQueueIndex == null && this.sampleQueuesBuilt) {
            HlsSampleQueue[] hlsSampleQueueArr = this.sampleQueues;
            int length = hlsSampleQueueArr.length;
            int i = 0;
            while (i < length) {
                if (hlsSampleQueueArr[i].getUpstreamFormat() != null) {
                    i++;
                } else {
                    return;
                }
            }
            if (this.trackGroups != null) {
                mapSampleQueuesToMatchTrackGroups();
                return;
            }
            buildTracksFromSampleStreams();
            setIsPrepared();
            this.callback.onPrepared();
        }
    }

    private void mapSampleQueuesToMatchTrackGroups() {
        int i = this.trackGroups.length;
        this.trackGroupToSampleQueueIndex = new int[i];
        Arrays.fill(this.trackGroupToSampleQueueIndex, -1);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = 0;
            while (true) {
                HlsSampleQueue[] hlsSampleQueueArr = this.sampleQueues;
                if (i3 >= hlsSampleQueueArr.length) {
                    break;
                } else if (formatsMatch((Format) Assertions.checkStateNotNull(hlsSampleQueueArr[i3].getUpstreamFormat()), this.trackGroups.get(i2).getFormat(0))) {
                    this.trackGroupToSampleQueueIndex[i2] = i3;
                    break;
                } else {
                    i3++;
                }
            }
        }
        Iterator<HlsSampleStream> it = this.hlsSampleStreams.iterator();
        while (it.hasNext()) {
            it.next().bindSampleQueue();
        }
    }

    private void buildTracksFromSampleStreams() {
        int length = this.sampleQueues.length;
        boolean z = false;
        int i = 0;
        int i2 = 6;
        int i3 = -1;
        while (true) {
            int i4 = 2;
            if (i >= length) {
                break;
            }
            String str = ((Format) Assertions.checkStateNotNull(this.sampleQueues[i].getUpstreamFormat())).sampleMimeType;
            if (!MimeTypes.isVideo(str)) {
                if (MimeTypes.isAudio(str)) {
                    i4 = 1;
                } else {
                    i4 = MimeTypes.isText(str) ? 3 : 6;
                }
            }
            if (getTrackTypeScore(i4) > getTrackTypeScore(i2)) {
                i3 = i;
                i2 = i4;
            } else if (i4 == i2 && i3 != -1) {
                i3 = -1;
            }
            i++;
        }
        TrackGroup trackGroup = this.chunkSource.getTrackGroup();
        int i5 = trackGroup.length;
        this.primaryTrackGroupIndex = -1;
        this.trackGroupToSampleQueueIndex = new int[length];
        for (int i6 = 0; i6 < length; i6++) {
            this.trackGroupToSampleQueueIndex[i6] = i6;
        }
        TrackGroup[] trackGroupArr = new TrackGroup[length];
        for (int i7 = 0; i7 < length; i7++) {
            Format format = (Format) Assertions.checkStateNotNull(this.sampleQueues[i7].getUpstreamFormat());
            if (i7 == i3) {
                Format[] formatArr = new Format[i5];
                if (i5 == 1) {
                    formatArr[0] = format.withManifestFormatInfo(trackGroup.getFormat(0));
                } else {
                    for (int i8 = 0; i8 < i5; i8++) {
                        formatArr[i8] = deriveFormat(trackGroup.getFormat(i8), format, true);
                    }
                }
                trackGroupArr[i7] = new TrackGroup(formatArr);
                this.primaryTrackGroupIndex = i7;
            } else {
                trackGroupArr[i7] = new TrackGroup(deriveFormat((i2 != 2 || !MimeTypes.isAudio(format.sampleMimeType)) ? null : this.muxedAudioFormat, format, false));
            }
        }
        this.trackGroups = createTrackGroupArrayWithDrmInfo(trackGroupArr);
        if (this.optionalTrackGroups == null) {
            z = true;
        }
        Assertions.checkState(z);
        this.optionalTrackGroups = Collections.emptySet();
    }

    private TrackGroupArray createTrackGroupArrayWithDrmInfo(TrackGroup[] trackGroupArr) {
        for (int i = 0; i < trackGroupArr.length; i++) {
            TrackGroup trackGroup = trackGroupArr[i];
            Format[] formatArr = new Format[trackGroup.length];
            for (int i2 = 0; i2 < trackGroup.length; i2++) {
                Format format = trackGroup.getFormat(i2);
                if (format.drmInitData != null) {
                    format = format.copyWithExoMediaCryptoType(this.drmSessionManager.getExoMediaCryptoType(format.drmInitData));
                }
                formatArr[i2] = format;
            }
            trackGroupArr[i] = new TrackGroup(formatArr);
        }
        return new TrackGroupArray(trackGroupArr);
    }

    private HlsMediaChunk getLastMediaChunk() {
        ArrayList<HlsMediaChunk> arrayList = this.mediaChunks;
        return arrayList.get(arrayList.size() - 1);
    }

    private boolean isPendingReset() {
        return this.pendingResetPositionUs != -9223372036854775807L;
    }

    private boolean seekInsideBufferUs(long j) {
        int length = this.sampleQueues.length;
        for (int i = 0; i < length; i++) {
            if (!this.sampleQueues[i].seekTo(j, false) && (this.sampleQueueIsAudioVideoFlags[i] || !this.haveAudioVideoSampleQueues)) {
                return false;
            }
        }
        return true;
    }

    private void setIsPrepared() {
        this.prepared = true;
    }

    private void assertIsPrepared() {
        Assertions.checkState(this.prepared);
        Assertions.checkNotNull(this.trackGroups);
        Assertions.checkNotNull(this.optionalTrackGroups);
    }

    private static Format deriveFormat(Format format, Format format2, boolean z) {
        if (format == null) {
            return format2;
        }
        String codecsOfType = Util.getCodecsOfType(format.codecs, MimeTypes.getTrackType(format2.sampleMimeType));
        String mediaMimeType = MimeTypes.getMediaMimeType(codecsOfType);
        Format.Builder height = format2.buildUpon().setId(format.id).setLabel(format.label).setLanguage(format.language).setSelectionFlags(format.selectionFlags).setAverageBitrate(z ? format.averageBitrate : -1).setPeakBitrate(z ? format.peakBitrate : -1).setCodecs(codecsOfType).setWidth(format.width).setHeight(format.height);
        if (mediaMimeType != null) {
            height.setSampleMimeType(mediaMimeType);
        }
        if (format.channelCount != -1) {
            height.setChannelCount(format.channelCount);
        }
        if (format.metadata != null) {
            Metadata metadata = format.metadata;
            if (format2.metadata != null) {
                metadata = format2.metadata.copyWithAppendedEntriesFrom(metadata);
            }
            height.setMetadata(metadata);
        }
        return height.build();
    }

    private static boolean isMediaChunk(Chunk chunk) {
        return chunk instanceof HlsMediaChunk;
    }

    private static boolean formatsMatch(Format format, Format format2) {
        String str = format.sampleMimeType;
        String str2 = format2.sampleMimeType;
        int trackType2 = MimeTypes.getTrackType(str);
        if (trackType2 != 3) {
            return trackType2 == MimeTypes.getTrackType(str2);
        }
        if (!Util.areEqual(str, str2)) {
            return false;
        }
        return (!"application/cea-608".equals(str) && !"application/cea-708".equals(str)) || format.accessibilityChannel == format2.accessibilityChannel;
    }

    private static DummyTrackOutput createDummyTrackOutput(int i, int i2) {
        Log.w("HlsSampleStreamWrapper", "Unmapped track with id " + i + " of type " + i2);
        return new DummyTrackOutput();
    }

    static final class HlsSampleQueue extends SampleQueue {
        private DrmInitData drmInitData;
        private long maxAllowedSampleTimeUs;
        private long minAllowedSampleTimeUs;
        private final Map<String, DrmInitData> overridingDrmInitData;
        private HlsMediaChunk sourceChunk;
        private long sourceChunkLastSampleTimeUs;

        private HlsSampleQueue(Allocator allocator, DrmSessionManager drmSessionManager, MediaSourceEventDispatcher mediaSourceEventDispatcher, Map<String, DrmInitData> map) {
            super(allocator, drmSessionManager, mediaSourceEventDispatcher);
            this.overridingDrmInitData = map;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.Math.max(long, long):long}
         arg types: [long, int]
         candidates:
          ClspMth{java.lang.Math.max(double, double):double}
          ClspMth{java.lang.Math.max(int, int):int}
          ClspMth{java.lang.Math.max(float, float):float}
          ClspMth{java.lang.Math.max(long, long):long} */
        public final void setSourceChunk(HlsMediaChunk hlsMediaChunk) {
            this.sourceChunk = hlsMediaChunk;
            this.sourceChunkLastSampleTimeUs = -9223372036854775807L;
            sourceId(hlsMediaChunk.uid);
            double d = (double) (hlsMediaChunk.endTimeUs - hlsMediaChunk.startTimeUs);
            Double.isNaN(d);
            long max = Math.max((long) (d * 0.5d), 4000000L);
            this.minAllowedSampleTimeUs = hlsMediaChunk.startTimeUs - max;
            this.maxAllowedSampleTimeUs = hlsMediaChunk.endTimeUs + max;
        }

        public final void setDrmInitData(DrmInitData drmInitData2) {
            this.drmInitData = drmInitData2;
            invalidateUpstreamFormatAdjustment();
        }

        public final Format getAdjustedUpstreamFormat(Format format) {
            DrmInitData drmInitData2;
            DrmInitData drmInitData3 = this.drmInitData;
            if (drmInitData3 == null) {
                drmInitData3 = format.drmInitData;
            }
            if (!(drmInitData3 == null || (drmInitData2 = this.overridingDrmInitData.get(drmInitData3.schemeType)) == null)) {
                drmInitData3 = drmInitData2;
            }
            Metadata adjustedMetadata = getAdjustedMetadata(format.metadata);
            if (!(drmInitData3 == format.drmInitData && adjustedMetadata == format.metadata)) {
                format = format.buildUpon().setDrmInitData(drmInitData3).setMetadata(adjustedMetadata).build();
            }
            return super.getAdjustedUpstreamFormat(format);
        }

        private Metadata getAdjustedMetadata(Metadata metadata) {
            if (metadata == null) {
                return null;
            }
            int length = metadata.length();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    i2 = -1;
                    break;
                }
                Metadata.Entry entry = metadata.get(i2);
                if ((entry instanceof PrivFrame) && "com.apple.streaming.transportStreamTimestamp".equals(((PrivFrame) entry).owner)) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return metadata;
            }
            if (length == 1) {
                return null;
            }
            Metadata.Entry[] entryArr = new Metadata.Entry[(length - 1)];
            while (i < length) {
                if (i != i2) {
                    entryArr[i < i2 ? i : i - 1] = metadata.get(i);
                }
                i++;
            }
            return new Metadata(entryArr);
        }

        public final void sampleMetadata(long j, int i, int i2, int i3, TrackOutput.CryptoData cryptoData) {
            this.sourceChunkLastSampleTimeUs = j;
            super.sampleMetadata(j, i, i2, i3, cryptoData);
        }
    }

    static class EmsgUnwrappingTrackOutput implements TrackOutput {
        private static final Format EMSG_FORMAT = new Format.Builder().setSampleMimeType("application/x-emsg").build();
        private static final Format ID3_FORMAT = new Format.Builder().setSampleMimeType("application/id3").build();
        private byte[] buffer;
        private int bufferPosition;
        private final TrackOutput delegate;
        private final Format delegateFormat;
        private final EventMessageDecoder emsgDecoder = new EventMessageDecoder();
        private Format format;

        public EmsgUnwrappingTrackOutput(TrackOutput trackOutput, int i) {
            this.delegate = trackOutput;
            if (i == 1) {
                this.delegateFormat = ID3_FORMAT;
            } else if (i == 3) {
                this.delegateFormat = EMSG_FORMAT;
            } else {
                throw new IllegalArgumentException("Unknown metadataType: ".concat(String.valueOf(i)));
            }
            this.buffer = new byte[0];
            this.bufferPosition = 0;
        }

        public void format(Format format2) {
            this.format = format2;
            this.delegate.format(this.delegateFormat);
        }

        public int sampleData(DataReader dataReader, int i, boolean z) throws IOException {
            ensureBufferCapacity(this.bufferPosition + i);
            int read = dataReader.read(this.buffer, this.bufferPosition, i);
            if (read != -1) {
                this.bufferPosition += read;
                return read;
            } else if (z) {
                return -1;
            } else {
                throw new EOFException();
            }
        }

        public void sampleData(ParsableByteArray parsableByteArray, int i) {
            ensureBufferCapacity(this.bufferPosition + i);
            parsableByteArray.readBytes(this.buffer, this.bufferPosition, i);
            this.bufferPosition += i;
        }

        public void sampleMetadata(long j, int i, int i2, int i3, TrackOutput.CryptoData cryptoData) {
            Assertions.checkNotNull(this.format);
            ParsableByteArray sampleAndTrimBuffer = getSampleAndTrimBuffer(i2, i3);
            if (!Util.areEqual(this.format.sampleMimeType, this.delegateFormat.sampleMimeType)) {
                if ("application/x-emsg".equals(this.format.sampleMimeType)) {
                    EventMessage decode = this.emsgDecoder.decode(sampleAndTrimBuffer);
                    if (!emsgContainsExpectedWrappedFormat(decode)) {
                        Log.w("EmsgUnwrappingTrackOutput", String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", this.delegateFormat.sampleMimeType, decode.getWrappedMetadataFormat()));
                        return;
                    }
                    sampleAndTrimBuffer = new ParsableByteArray((byte[]) Assertions.checkNotNull(decode.getWrappedMetadataBytes()));
                } else {
                    Log.w("EmsgUnwrappingTrackOutput", "Ignoring sample for unsupported format: " + this.format.sampleMimeType);
                    return;
                }
            }
            int bytesLeft = sampleAndTrimBuffer.bytesLeft();
            this.delegate.sampleData(sampleAndTrimBuffer, bytesLeft);
            this.delegate.sampleMetadata(j, i, bytesLeft, i3, cryptoData);
        }

        private boolean emsgContainsExpectedWrappedFormat(EventMessage eventMessage) {
            Format wrappedMetadataFormat = eventMessage.getWrappedMetadataFormat();
            return wrappedMetadataFormat != null && Util.areEqual(this.delegateFormat.sampleMimeType, wrappedMetadataFormat.sampleMimeType);
        }

        private void ensureBufferCapacity(int i) {
            byte[] bArr = this.buffer;
            if (bArr.length < i) {
                this.buffer = Arrays.copyOf(bArr, i + (i / 2));
            }
        }

        private ParsableByteArray getSampleAndTrimBuffer(int i, int i2) {
            int i3 = this.bufferPosition - i2;
            ParsableByteArray parsableByteArray = new ParsableByteArray(Arrays.copyOfRange(this.buffer, i3 - i, i3));
            byte[] bArr = this.buffer;
            System.arraycopy(bArr, i3, bArr, 0, i2);
            this.bufferPosition = i2;
            return parsableByteArray;
        }
    }
}
