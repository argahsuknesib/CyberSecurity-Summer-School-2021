package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.IcyDataSource;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class ProgressiveMediaPeriod implements ExtractorOutput, MediaPeriod, SampleQueue.UpstreamFormatChangedListener, Loader.Callback<ExtractingLoadable>, Loader.ReleaseCallback {
    public static final Format ICY_FORMAT = new Format.Builder().setId("icy").setSampleMimeType("application/x-icy").build();
    public static final Map<String, String> ICY_METADATA_HEADERS = createIcyMetadataHeaders();
    private final Allocator allocator;
    private MediaPeriod.Callback callback;
    public final long continueLoadingCheckIntervalBytes;
    public final String customCacheKey;
    private final DataSource dataSource;
    private int dataType;
    private final DrmSessionManager drmSessionManager;
    private long durationUs;
    private int enabledTrackCount;
    private final MediaSourceEventListener.EventDispatcher eventDispatcher;
    private int extractedSamplesCountAtStartOfLoad;
    public final Handler handler;
    private boolean haveAudioVideoTracks;
    public IcyHeaders icyHeaders;
    private boolean isLive;
    private long lastSeekPositionUs;
    private long length;
    private final Listener listener;
    private final ConditionVariable loadCondition;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final Loader loader = new Loader("Loader:ProgressiveMediaPeriod");
    private boolean loadingFinished;
    private final Runnable maybeFinishPrepareRunnable;
    private boolean notifiedReadingStarted;
    private boolean notifyDiscontinuity;
    public final Runnable onContinueLoadingRequestedRunnable;
    private boolean pendingDeferredRetry;
    private long pendingResetPositionUs;
    private boolean prepared;
    private final ProgressiveMediaExtractor progressiveMediaExtractor;
    private boolean released;
    private TrackId[] sampleQueueTrackIds;
    private SampleQueue[] sampleQueues;
    private boolean sampleQueuesBuilt;
    private SeekMap seekMap;
    private boolean seenFirstTrackSelection;
    private TrackState trackState;
    private final Uri uri;

    interface Listener {
        void onSourceInfoRefreshed(long j, boolean z, boolean z2);
    }

    public /* synthetic */ List<StreamKey> getStreamKeys(List<TrackSelection> list) {
        return MediaPeriod.CC.$default$getStreamKeys(this, list);
    }

    public final void reevaluateBuffer(long j) {
    }

    public ProgressiveMediaPeriod(Uri uri2, DataSource dataSource2, Extractor[] extractorArr, DrmSessionManager drmSessionManager2, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, MediaSourceEventListener.EventDispatcher eventDispatcher2, Listener listener2, Allocator allocator2, String str, int i) {
        this.uri = uri2;
        this.dataSource = dataSource2;
        this.drmSessionManager = drmSessionManager2;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.eventDispatcher = eventDispatcher2;
        this.listener = listener2;
        this.allocator = allocator2;
        this.customCacheKey = str;
        this.continueLoadingCheckIntervalBytes = (long) i;
        this.progressiveMediaExtractor = new BundledExtractorsAdapter(extractorArr);
        this.loadCondition = new ConditionVariable();
        this.maybeFinishPrepareRunnable = new Runnable() {
            /* class com.google.android.exoplayer2.source.$$Lambda$ProgressiveMediaPeriod$XtIxRPmKXOyt2tIiDgXldkLBDgg */

            public final void run() {
                ProgressiveMediaPeriod.this.maybeFinishPrepare();
            }
        };
        this.onContinueLoadingRequestedRunnable = new Runnable() {
            /* class com.google.android.exoplayer2.source.$$Lambda$ProgressiveMediaPeriod$XL6L2U3FG8Q9U9Dud8PsJBs494 */

            public final void run() {
                ProgressiveMediaPeriod.this.lambda$new$0$ProgressiveMediaPeriod();
            }
        };
        this.handler = Util.createHandler();
        this.sampleQueueTrackIds = new TrackId[0];
        this.sampleQueues = new SampleQueue[0];
        this.pendingResetPositionUs = -9223372036854775807L;
        this.length = -1;
        this.durationUs = -9223372036854775807L;
        this.dataType = 1;
        eventDispatcher2.mediaPeriodCreated();
    }

    public /* synthetic */ void lambda$new$0$ProgressiveMediaPeriod() {
        if (!this.released) {
            ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
        }
    }

    public final void release() {
        if (this.prepared) {
            for (SampleQueue preRelease : this.sampleQueues) {
                preRelease.preRelease();
            }
        }
        this.loader.release(this);
        this.handler.removeCallbacksAndMessages(null);
        this.callback = null;
        this.released = true;
        this.eventDispatcher.mediaPeriodReleased();
    }

    public final void onLoaderReleased() {
        for (SampleQueue release : this.sampleQueues) {
            release.release();
        }
        this.progressiveMediaExtractor.release();
    }

    public final void prepare(MediaPeriod.Callback callback2, long j) {
        this.callback = callback2;
        this.loadCondition.open();
        startLoading();
    }

    public final void maybeThrowPrepareError() throws IOException {
        maybeThrowError();
        if (this.loadingFinished && !this.prepared) {
            throw new ParserException("Loading finished before preparation is complete.");
        }
    }

    public final TrackGroupArray getTrackGroups() {
        assertPrepared();
        return this.trackState.tracks;
    }

    public final long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        assertPrepared();
        TrackGroupArray trackGroupArray = this.trackState.tracks;
        boolean[] zArr3 = this.trackState.trackEnabledStates;
        int i = this.enabledTrackCount;
        int i2 = 0;
        for (int i3 = 0; i3 < trackSelectionArr.length; i3++) {
            if (sampleStreamArr[i3] != null && (trackSelectionArr[i3] == null || !zArr[i3])) {
                int i4 = ((SampleStreamImpl) sampleStreamArr[i3]).track;
                Assertions.checkState(zArr3[i4]);
                this.enabledTrackCount--;
                zArr3[i4] = false;
                sampleStreamArr[i3] = null;
            }
        }
        boolean z = !this.seenFirstTrackSelection ? j != 0 : i == 0;
        for (int i5 = 0; i5 < trackSelectionArr.length; i5++) {
            if (sampleStreamArr[i5] == null && trackSelectionArr[i5] != null) {
                TrackSelection trackSelection = trackSelectionArr[i5];
                Assertions.checkState(trackSelection.length() == 1);
                Assertions.checkState(trackSelection.getIndexInTrackGroup(0) == 0);
                int indexOf = trackGroupArray.indexOf(trackSelection.getTrackGroup());
                Assertions.checkState(!zArr3[indexOf]);
                this.enabledTrackCount++;
                zArr3[indexOf] = true;
                sampleStreamArr[i5] = new SampleStreamImpl(indexOf);
                zArr2[i5] = true;
                if (!z) {
                    SampleQueue sampleQueue = this.sampleQueues[indexOf];
                    z = !sampleQueue.seekTo(j, true) && sampleQueue.getReadIndex() != 0;
                }
            }
        }
        if (this.enabledTrackCount == 0) {
            this.pendingDeferredRetry = false;
            this.notifyDiscontinuity = false;
            if (this.loader.isLoading()) {
                SampleQueue[] sampleQueueArr = this.sampleQueues;
                int length2 = sampleQueueArr.length;
                while (i2 < length2) {
                    sampleQueueArr[i2].discardToEnd();
                    i2++;
                }
                this.loader.cancelLoading();
            } else {
                SampleQueue[] sampleQueueArr2 = this.sampleQueues;
                int length3 = sampleQueueArr2.length;
                while (i2 < length3) {
                    sampleQueueArr2[i2].reset();
                    i2++;
                }
            }
        } else if (z) {
            j = seekToUs(j);
            while (i2 < sampleStreamArr.length) {
                if (sampleStreamArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.seenFirstTrackSelection = true;
        return j;
    }

    public final void discardBuffer(long j, boolean z) {
        assertPrepared();
        if (!isPendingReset()) {
            boolean[] zArr = this.trackState.trackEnabledStates;
            int length2 = this.sampleQueues.length;
            for (int i = 0; i < length2; i++) {
                this.sampleQueues[i].discardTo(j, z, zArr[i]);
            }
        }
    }

    public final boolean continueLoading(long j) {
        if (this.loadingFinished || this.loader.hasFatalError() || this.pendingDeferredRetry) {
            return false;
        }
        if (this.prepared && this.enabledTrackCount == 0) {
            return false;
        }
        boolean open = this.loadCondition.open();
        if (this.loader.isLoading()) {
            return open;
        }
        startLoading();
        return true;
    }

    public final boolean isLoading() {
        return this.loader.isLoading() && this.loadCondition.isOpen();
    }

    public final long getNextLoadPositionUs() {
        if (this.enabledTrackCount == 0) {
            return Long.MIN_VALUE;
        }
        return getBufferedPositionUs();
    }

    public final long readDiscontinuity() {
        if (!this.notifiedReadingStarted) {
            this.eventDispatcher.readingStarted();
            this.notifiedReadingStarted = true;
        }
        if (!this.notifyDiscontinuity) {
            return -9223372036854775807L;
        }
        if (!this.loadingFinished && getExtractedSamplesCount() <= this.extractedSamplesCountAtStartOfLoad) {
            return -9223372036854775807L;
        }
        this.notifyDiscontinuity = false;
        return this.lastSeekPositionUs;
    }

    public final long getBufferedPositionUs() {
        long j;
        assertPrepared();
        boolean[] zArr = this.trackState.trackIsAudioVideoFlags;
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        if (this.haveAudioVideoTracks) {
            int length2 = this.sampleQueues.length;
            j = Long.MAX_VALUE;
            for (int i = 0; i < length2; i++) {
                if (zArr[i] && !this.sampleQueues[i].isLastSampleQueued()) {
                    j = Math.min(j, this.sampleQueues[i].getLargestQueuedTimestampUs());
                }
            }
        } else {
            j = Long.MAX_VALUE;
        }
        if (j == Long.MAX_VALUE) {
            j = getLargestQueuedTimestampUs();
        }
        return j == Long.MIN_VALUE ? this.lastSeekPositionUs : j;
    }

    public final long seekToUs(long j) {
        assertPrepared();
        boolean[] zArr = this.trackState.trackIsAudioVideoFlags;
        if (!this.seekMap.isSeekable()) {
            j = 0;
        }
        this.notifyDiscontinuity = false;
        this.lastSeekPositionUs = j;
        if (isPendingReset()) {
            this.pendingResetPositionUs = j;
            return j;
        } else if (this.dataType != 7 && seekInsideBufferUs(zArr, j)) {
            return j;
        } else {
            this.pendingDeferredRetry = false;
            this.pendingResetPositionUs = j;
            this.loadingFinished = false;
            if (this.loader.isLoading()) {
                this.loader.cancelLoading();
            } else {
                this.loader.clearFatalError();
                for (SampleQueue reset : this.sampleQueues) {
                    reset.reset();
                }
            }
            return j;
        }
    }

    public final long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        assertPrepared();
        if (!this.seekMap.isSeekable()) {
            return 0;
        }
        SeekMap.SeekPoints seekPoints = this.seekMap.getSeekPoints(j);
        return seekParameters.resolveSeekPositionUs(j, seekPoints.first.timeUs, seekPoints.second.timeUs);
    }

    /* access modifiers changed from: package-private */
    public final boolean isReady(int i) {
        return !suppressRead() && this.sampleQueues[i].isReady(this.loadingFinished);
    }

    /* access modifiers changed from: package-private */
    public final void maybeThrowError(int i) throws IOException {
        this.sampleQueues[i].maybeThrowError();
        maybeThrowError();
    }

    /* access modifiers changed from: package-private */
    public final void maybeThrowError() throws IOException {
        this.loader.maybeThrowError(this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(this.dataType));
    }

    /* access modifiers changed from: package-private */
    public final int readData(int i, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
        if (suppressRead()) {
            return -3;
        }
        maybeNotifyDownstreamFormat(i);
        int read = this.sampleQueues[i].read(formatHolder, decoderInputBuffer, z, this.loadingFinished, this.lastSeekPositionUs);
        if (read == -3) {
            maybeStartDeferredRetry(i);
        }
        return read;
    }

    /* access modifiers changed from: package-private */
    public final int skipData(int i, long j) {
        int i2;
        if (suppressRead()) {
            return 0;
        }
        maybeNotifyDownstreamFormat(i);
        SampleQueue sampleQueue = this.sampleQueues[i];
        if (!this.loadingFinished || j <= sampleQueue.getLargestQueuedTimestampUs()) {
            i2 = sampleQueue.advanceTo(j);
        } else {
            i2 = sampleQueue.advanceToEnd();
        }
        if (i2 == 0) {
            maybeStartDeferredRetry(i);
        }
        return i2;
    }

    private void maybeNotifyDownstreamFormat(int i) {
        assertPrepared();
        boolean[] zArr = this.trackState.trackNotifiedDownstreamFormats;
        if (!zArr[i]) {
            Format format = this.trackState.tracks.get(i).getFormat(0);
            this.eventDispatcher.downstreamFormatChanged(MimeTypes.getTrackType(format.sampleMimeType), format, 0, null, this.lastSeekPositionUs);
            zArr[i] = true;
        }
    }

    private void maybeStartDeferredRetry(int i) {
        assertPrepared();
        boolean[] zArr = this.trackState.trackIsAudioVideoFlags;
        if (this.pendingDeferredRetry && zArr[i]) {
            if (!this.sampleQueues[i].isReady(false)) {
                this.pendingResetPositionUs = 0;
                this.pendingDeferredRetry = false;
                this.notifyDiscontinuity = true;
                this.lastSeekPositionUs = 0;
                this.extractedSamplesCountAtStartOfLoad = 0;
                for (SampleQueue reset : this.sampleQueues) {
                    reset.reset();
                }
                ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
            }
        }
    }

    private boolean suppressRead() {
        return this.notifyDiscontinuity || isPendingReset();
    }

    public final void onLoadCompleted(ExtractingLoadable extractingLoadable, long j, long j2) {
        SeekMap seekMap2;
        ExtractingLoadable extractingLoadable2 = extractingLoadable;
        if (this.durationUs == -9223372036854775807L && (seekMap2 = this.seekMap) != null) {
            boolean isSeekable = seekMap2.isSeekable();
            long largestQueuedTimestampUs = getLargestQueuedTimestampUs();
            this.durationUs = largestQueuedTimestampUs == Long.MIN_VALUE ? 0 : largestQueuedTimestampUs + 10000;
            this.listener.onSourceInfoRefreshed(this.durationUs, isSeekable, this.isLive);
        }
        this.eventDispatcher.loadCompleted(extractingLoadable2.dataSpec, extractingLoadable2.dataSource.getLastOpenedUri(), extractingLoadable2.dataSource.getLastResponseHeaders(), 1, -1, null, 0, null, extractingLoadable2.seekTimeUs, this.durationUs, j, j2, extractingLoadable2.dataSource.getBytesRead());
        copyLengthFromLoader(extractingLoadable);
        this.loadingFinished = true;
        ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
    }

    public final void onLoadCanceled(ExtractingLoadable extractingLoadable, long j, long j2, boolean z) {
        ExtractingLoadable extractingLoadable2 = extractingLoadable;
        this.eventDispatcher.loadCanceled(extractingLoadable2.dataSpec, extractingLoadable2.dataSource.getLastOpenedUri(), extractingLoadable2.dataSource.getLastResponseHeaders(), 1, -1, null, 0, null, extractingLoadable2.seekTimeUs, this.durationUs, j, j2, extractingLoadable2.dataSource.getBytesRead());
        if (!z) {
            copyLengthFromLoader(extractingLoadable);
            for (SampleQueue reset : this.sampleQueues) {
                reset.reset();
            }
            if (this.enabledTrackCount > 0) {
                ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
            }
        }
    }

    public final Loader.LoadErrorAction onLoadError(ExtractingLoadable extractingLoadable, long j, long j2, IOException iOException, int i) {
        Loader.LoadErrorAction loadErrorAction;
        ExtractingLoadable extractingLoadable2 = extractingLoadable;
        copyLengthFromLoader(extractingLoadable);
        long retryDelayMsFor = this.loadErrorHandlingPolicy.getRetryDelayMsFor(this.dataType, j2, iOException, i);
        if (retryDelayMsFor == -9223372036854775807L) {
            loadErrorAction = Loader.DONT_RETRY_FATAL;
        } else {
            int extractedSamplesCount = getExtractedSamplesCount();
            loadErrorAction = configureRetry(extractingLoadable2, extractedSamplesCount) ? Loader.createRetryAction(extractedSamplesCount > this.extractedSamplesCountAtStartOfLoad, retryDelayMsFor) : Loader.DONT_RETRY;
        }
        this.eventDispatcher.loadError(extractingLoadable2.dataSpec, extractingLoadable2.dataSource.getLastOpenedUri(), extractingLoadable2.dataSource.getLastResponseHeaders(), 1, -1, null, 0, null, extractingLoadable2.seekTimeUs, this.durationUs, j, j2, extractingLoadable2.dataSource.getBytesRead(), iOException, !loadErrorAction.isRetry());
        return loadErrorAction;
    }

    public final TrackOutput track(int i, int i2) {
        return prepareTrackOutput(new TrackId(i, false));
    }

    public final void endTracks() {
        this.sampleQueuesBuilt = true;
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    public final void seekMap(SeekMap seekMap2) {
        this.handler.post(new Runnable(seekMap2) {
            /* class com.google.android.exoplayer2.source.$$Lambda$ProgressiveMediaPeriod$g0rAX0fUGYsZNigGuJ9uWsNPk */
            private final /* synthetic */ SeekMap f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                ProgressiveMediaPeriod.this.lambda$seekMap$1$ProgressiveMediaPeriod(this.f$1);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final TrackOutput icyTrack() {
        return prepareTrackOutput(new TrackId(0, true));
    }

    public final void onUpstreamFormatChanged(Format format) {
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    private TrackOutput prepareTrackOutput(TrackId trackId) {
        int length2 = this.sampleQueues.length;
        for (int i = 0; i < length2; i++) {
            if (trackId.equals(this.sampleQueueTrackIds[i])) {
                return this.sampleQueues[i];
            }
        }
        SampleQueue sampleQueue = new SampleQueue(this.allocator, this.drmSessionManager, this.eventDispatcher);
        sampleQueue.setUpstreamFormatChangeListener(this);
        int i2 = length2 + 1;
        TrackId[] trackIdArr = (TrackId[]) Arrays.copyOf(this.sampleQueueTrackIds, i2);
        trackIdArr[length2] = trackId;
        this.sampleQueueTrackIds = (TrackId[]) Util.castNonNullTypeArray(trackIdArr);
        SampleQueue[] sampleQueueArr = (SampleQueue[]) Arrays.copyOf(this.sampleQueues, i2);
        sampleQueueArr[length2] = sampleQueue;
        this.sampleQueues = (SampleQueue[]) Util.castNonNullTypeArray(sampleQueueArr);
        return sampleQueue;
    }

    /* access modifiers changed from: private */
    /* renamed from: setSeekMap */
    public void lambda$seekMap$1$ProgressiveMediaPeriod(SeekMap seekMap2) {
        this.seekMap = this.icyHeaders == null ? seekMap2 : new SeekMap.Unseekable(-9223372036854775807L);
        if (!this.prepared) {
            maybeFinishPrepare();
        }
        this.durationUs = seekMap2.getDurationUs();
        int i = 1;
        this.isLive = this.length == -1 && seekMap2.getDurationUs() == -9223372036854775807L;
        if (this.isLive) {
            i = 7;
        }
        this.dataType = i;
        this.listener.onSourceInfoRefreshed(this.durationUs, seekMap2.isSeekable(), this.isLive);
    }

    /* access modifiers changed from: private */
    public void maybeFinishPrepare() {
        Metadata metadata;
        if (!this.released && !this.prepared && this.sampleQueuesBuilt && this.seekMap != null) {
            SampleQueue[] sampleQueueArr = this.sampleQueues;
            int length2 = sampleQueueArr.length;
            int i = 0;
            while (i < length2) {
                if (sampleQueueArr[i].getUpstreamFormat() != null) {
                    i++;
                } else {
                    return;
                }
            }
            this.loadCondition.close();
            int length3 = this.sampleQueues.length;
            TrackGroup[] trackGroupArr = new TrackGroup[length3];
            boolean[] zArr = new boolean[length3];
            for (int i2 = 0; i2 < length3; i2++) {
                Format format = (Format) Assertions.checkNotNull(this.sampleQueues[i2].getUpstreamFormat());
                String str = format.sampleMimeType;
                boolean isAudio = MimeTypes.isAudio(str);
                boolean z = isAudio || MimeTypes.isVideo(str);
                zArr[i2] = z;
                this.haveAudioVideoTracks = z | this.haveAudioVideoTracks;
                IcyHeaders icyHeaders2 = this.icyHeaders;
                if (icyHeaders2 != null) {
                    if (isAudio || this.sampleQueueTrackIds[i2].isIcyTrack) {
                        Metadata metadata2 = format.metadata;
                        if (metadata2 == null) {
                            metadata = new Metadata(icyHeaders2);
                        } else {
                            metadata = metadata2.copyWithAppendedEntries(icyHeaders2);
                        }
                        format = format.buildUpon().setMetadata(metadata).build();
                    }
                    if (isAudio && format.averageBitrate == -1 && format.peakBitrate == -1 && icyHeaders2.bitrate != -1) {
                        format = format.buildUpon().setAverageBitrate(icyHeaders2.bitrate).build();
                    }
                }
                trackGroupArr[i2] = new TrackGroup(format);
            }
            this.trackState = new TrackState(new TrackGroupArray(trackGroupArr), zArr);
            this.prepared = true;
            ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onPrepared(this);
        }
    }

    private void copyLengthFromLoader(ExtractingLoadable extractingLoadable) {
        if (this.length == -1) {
            this.length = extractingLoadable.length;
        }
    }

    private void startLoading() {
        ExtractingLoadable extractingLoadable = new ExtractingLoadable(this.uri, this.dataSource, this.progressiveMediaExtractor, this, this.loadCondition);
        if (this.prepared) {
            Assertions.checkState(isPendingReset());
            long j = this.durationUs;
            if (j == -9223372036854775807L || this.pendingResetPositionUs <= j) {
                extractingLoadable.setLoadPosition(((SeekMap) Assertions.checkNotNull(this.seekMap)).getSeekPoints(this.pendingResetPositionUs).first.position, this.pendingResetPositionUs);
                this.pendingResetPositionUs = -9223372036854775807L;
            } else {
                this.loadingFinished = true;
                this.pendingResetPositionUs = -9223372036854775807L;
                return;
            }
        }
        this.extractedSamplesCountAtStartOfLoad = getExtractedSamplesCount();
        long startLoading = this.loader.startLoading(extractingLoadable, this, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(this.dataType));
        this.eventDispatcher.loadStarted(extractingLoadable.dataSpec, 1, -1, null, 0, null, extractingLoadable.seekTimeUs, this.durationUs, startLoading);
    }

    private boolean configureRetry(ExtractingLoadable extractingLoadable, int i) {
        SeekMap seekMap2;
        if (this.length == -1 && ((seekMap2 = this.seekMap) == null || seekMap2.getDurationUs() == -9223372036854775807L)) {
            if (!this.prepared || suppressRead()) {
                this.notifyDiscontinuity = this.prepared;
                this.lastSeekPositionUs = 0;
                this.extractedSamplesCountAtStartOfLoad = 0;
                for (SampleQueue reset : this.sampleQueues) {
                    reset.reset();
                }
                extractingLoadable.setLoadPosition(0, 0);
                return true;
            }
            this.pendingDeferredRetry = true;
            return false;
        }
        this.extractedSamplesCountAtStartOfLoad = i;
        return true;
    }

    private boolean seekInsideBufferUs(boolean[] zArr, long j) {
        int length2 = this.sampleQueues.length;
        for (int i = 0; i < length2; i++) {
            if (!this.sampleQueues[i].seekTo(j, false) && (zArr[i] || !this.haveAudioVideoTracks)) {
                return false;
            }
        }
        return true;
    }

    private int getExtractedSamplesCount() {
        int i = 0;
        for (SampleQueue writeIndex : this.sampleQueues) {
            i += writeIndex.getWriteIndex();
        }
        return i;
    }

    public final long getLargestQueuedTimestampUs() {
        long j = Long.MIN_VALUE;
        for (SampleQueue largestQueuedTimestampUs : this.sampleQueues) {
            j = Math.max(j, largestQueuedTimestampUs.getLargestQueuedTimestampUs());
        }
        return j;
    }

    private boolean isPendingReset() {
        return this.pendingResetPositionUs != -9223372036854775807L;
    }

    private void assertPrepared() {
        Assertions.checkState(this.prepared);
        Assertions.checkNotNull(this.trackState);
        Assertions.checkNotNull(this.seekMap);
    }

    final class SampleStreamImpl implements SampleStream {
        public final int track;

        public SampleStreamImpl(int i) {
            this.track = i;
        }

        public final boolean isReady() {
            return ProgressiveMediaPeriod.this.isReady(this.track);
        }

        public final void maybeThrowError() throws IOException {
            ProgressiveMediaPeriod.this.maybeThrowError(this.track);
        }

        public final int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
            return ProgressiveMediaPeriod.this.readData(this.track, formatHolder, decoderInputBuffer, z);
        }

        public final int skipData(long j) {
            return ProgressiveMediaPeriod.this.skipData(this.track, j);
        }
    }

    final class ExtractingLoadable implements IcyDataSource.Listener, Loader.Loadable {
        public final StatsDataSource dataSource;
        public DataSpec dataSpec = buildDataSpec(0);
        private final ExtractorOutput extractorOutput;
        private TrackOutput icyTrackOutput;
        public long length = -1;
        private volatile boolean loadCanceled;
        private final ConditionVariable loadCondition;
        private boolean pendingExtractorSeek = true;
        private final PositionHolder positionHolder = new PositionHolder();
        private final ProgressiveMediaExtractor progressiveMediaExtractor;
        public long seekTimeUs;
        private boolean seenIcyMetadata;
        private final Uri uri;

        public ExtractingLoadable(Uri uri2, DataSource dataSource2, ProgressiveMediaExtractor progressiveMediaExtractor2, ExtractorOutput extractorOutput2, ConditionVariable conditionVariable) {
            this.uri = uri2;
            this.dataSource = new StatsDataSource(dataSource2);
            this.progressiveMediaExtractor = progressiveMediaExtractor2;
            this.extractorOutput = extractorOutput2;
            this.loadCondition = conditionVariable;
        }

        public final void cancelLoad() {
            this.loadCanceled = true;
        }

        public final void load() throws IOException {
            int i = 0;
            while (i == 0 && !this.loadCanceled) {
                try {
                    long j = this.positionHolder.position;
                    this.dataSpec = buildDataSpec(j);
                    this.length = this.dataSource.open(this.dataSpec);
                    if (this.length != -1) {
                        this.length += j;
                    }
                    ProgressiveMediaPeriod.this.icyHeaders = IcyHeaders.parse(this.dataSource.getResponseHeaders());
                    DataReader dataReader = this.dataSource;
                    if (!(ProgressiveMediaPeriod.this.icyHeaders == null || ProgressiveMediaPeriod.this.icyHeaders.metadataInterval == -1)) {
                        dataReader = new IcyDataSource(this.dataSource, ProgressiveMediaPeriod.this.icyHeaders.metadataInterval, this);
                        this.icyTrackOutput = ProgressiveMediaPeriod.this.icyTrack();
                        this.icyTrackOutput.format(ProgressiveMediaPeriod.ICY_FORMAT);
                    }
                    long j2 = j;
                    this.progressiveMediaExtractor.init(dataReader, this.uri, j, this.length, this.extractorOutput);
                    if (ProgressiveMediaPeriod.this.icyHeaders != null) {
                        this.progressiveMediaExtractor.disableSeekingOnMp3Streams();
                    }
                    if (this.pendingExtractorSeek) {
                        this.progressiveMediaExtractor.seek(j2, this.seekTimeUs);
                        this.pendingExtractorSeek = false;
                    }
                    while (i == 0 && !this.loadCanceled) {
                        this.loadCondition.block();
                        i = this.progressiveMediaExtractor.read(this.positionHolder);
                        long currentInputPosition = this.progressiveMediaExtractor.getCurrentInputPosition();
                        if (currentInputPosition > ProgressiveMediaPeriod.this.continueLoadingCheckIntervalBytes + j2) {
                            this.loadCondition.close();
                            ProgressiveMediaPeriod.this.handler.post(ProgressiveMediaPeriod.this.onContinueLoadingRequestedRunnable);
                            j2 = currentInputPosition;
                        }
                    }
                    if (i == 1) {
                        i = 0;
                    } else if (this.progressiveMediaExtractor.getCurrentInputPosition() != -1) {
                        this.positionHolder.position = this.progressiveMediaExtractor.getCurrentInputPosition();
                    }
                    Util.closeQuietly(this.dataSource);
                } catch (InterruptedException unused) {
                    throw new InterruptedIOException();
                } catch (Throwable th) {
                    if (!(i == 1 || this.progressiveMediaExtractor.getCurrentInputPosition() == -1)) {
                        this.positionHolder.position = this.progressiveMediaExtractor.getCurrentInputPosition();
                    }
                    Util.closeQuietly(this.dataSource);
                    throw th;
                }
            }
        }

        public final void onIcyMetadata(ParsableByteArray parsableByteArray) {
            long j;
            if (!this.seenIcyMetadata) {
                j = this.seekTimeUs;
            } else {
                j = Math.max(ProgressiveMediaPeriod.this.getLargestQueuedTimestampUs(), this.seekTimeUs);
            }
            int bytesLeft = parsableByteArray.bytesLeft();
            TrackOutput trackOutput = (TrackOutput) Assertions.checkNotNull(this.icyTrackOutput);
            trackOutput.sampleData(parsableByteArray, bytesLeft);
            trackOutput.sampleMetadata(j, 1, bytesLeft, 0, null);
            this.seenIcyMetadata = true;
        }

        private DataSpec buildDataSpec(long j) {
            return new DataSpec.Builder().setUri(this.uri).setPosition(j).setKey(ProgressiveMediaPeriod.this.customCacheKey).setFlags(6).setHttpRequestHeaders(ProgressiveMediaPeriod.ICY_METADATA_HEADERS).build();
        }

        public final void setLoadPosition(long j, long j2) {
            this.positionHolder.position = j;
            this.seekTimeUs = j2;
            this.pendingExtractorSeek = true;
            this.seenIcyMetadata = false;
        }
    }

    static final class TrackState {
        public final boolean[] trackEnabledStates;
        public final boolean[] trackIsAudioVideoFlags;
        public final boolean[] trackNotifiedDownstreamFormats;
        public final TrackGroupArray tracks;

        public TrackState(TrackGroupArray trackGroupArray, boolean[] zArr) {
            this.tracks = trackGroupArray;
            this.trackIsAudioVideoFlags = zArr;
            this.trackEnabledStates = new boolean[trackGroupArray.length];
            this.trackNotifiedDownstreamFormats = new boolean[trackGroupArray.length];
        }
    }

    static final class TrackId {
        public final int id;
        public final boolean isIcyTrack;

        public TrackId(int i, boolean z) {
            this.id = i;
            this.isIcyTrack = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                TrackId trackId = (TrackId) obj;
                return this.id == trackId.id && this.isIcyTrack == trackId.isIcyTrack;
            }
        }

        public final int hashCode() {
            return (this.id * 31) + (this.isIcyTrack ? 1 : 0);
        }
    }

    private static Map<String, String> createIcyMetadataHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put("Icy-MetaData", "1");
        return Collections.unmodifiableMap(hashMap);
    }
}
