package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class SingleSampleMediaPeriod implements MediaPeriod, Loader.Callback<SourceLoadable> {
    private final DataSource.Factory dataSourceFactory;
    private final DataSpec dataSpec;
    private final long durationUs;
    public final MediaSourceEventListener.EventDispatcher eventDispatcher;
    final Format format;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    final Loader loader = new Loader("Loader:SingleSampleMediaPeriod");
    boolean loadingFinished;
    boolean notifiedReadingStarted;
    byte[] sampleData;
    int sampleSize;
    private final ArrayList<SampleStreamImpl> sampleStreams = new ArrayList<>();
    private final TrackGroupArray tracks;
    private final TransferListener transferListener;
    final boolean treatLoadErrorsAsEndOfStream;

    public final void discardBuffer(long j, boolean z) {
    }

    public final long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        return j;
    }

    public /* synthetic */ List<StreamKey> getStreamKeys(List<TrackSelection> list) {
        return MediaPeriod.CC.$default$getStreamKeys(this, list);
    }

    public final void maybeThrowPrepareError() {
    }

    public final void reevaluateBuffer(long j) {
    }

    public SingleSampleMediaPeriod(DataSpec dataSpec2, DataSource.Factory factory, TransferListener transferListener2, Format format2, long j, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, MediaSourceEventListener.EventDispatcher eventDispatcher2, boolean z) {
        this.dataSpec = dataSpec2;
        this.dataSourceFactory = factory;
        this.transferListener = transferListener2;
        this.format = format2;
        this.durationUs = j;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.eventDispatcher = eventDispatcher2;
        this.treatLoadErrorsAsEndOfStream = z;
        this.tracks = new TrackGroupArray(new TrackGroup(format2));
        eventDispatcher2.mediaPeriodCreated();
    }

    public final void release() {
        this.loader.release();
        this.eventDispatcher.mediaPeriodReleased();
    }

    public final void prepare(MediaPeriod.Callback callback, long j) {
        callback.onPrepared(this);
    }

    public final TrackGroupArray getTrackGroups() {
        return this.tracks;
    }

    public final long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        for (int i = 0; i < trackSelectionArr.length; i++) {
            if (sampleStreamArr[i] != null && (trackSelectionArr[i] == null || !zArr[i])) {
                this.sampleStreams.remove(sampleStreamArr[i]);
                sampleStreamArr[i] = null;
            }
            if (sampleStreamArr[i] == null && trackSelectionArr[i] != null) {
                SampleStreamImpl sampleStreamImpl = new SampleStreamImpl();
                this.sampleStreams.add(sampleStreamImpl);
                sampleStreamArr[i] = sampleStreamImpl;
                zArr2[i] = true;
            }
        }
        return j;
    }

    public final boolean continueLoading(long j) {
        if (this.loadingFinished || this.loader.isLoading() || this.loader.hasFatalError()) {
            return false;
        }
        DataSource createDataSource = this.dataSourceFactory.createDataSource();
        TransferListener transferListener2 = this.transferListener;
        if (transferListener2 != null) {
            createDataSource.addTransferListener(transferListener2);
        }
        this.eventDispatcher.loadStarted(this.dataSpec, 1, -1, this.format, 0, null, 0, this.durationUs, this.loader.startLoading(new SourceLoadable(this.dataSpec, createDataSource), this, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(1)));
        return true;
    }

    public final boolean isLoading() {
        return this.loader.isLoading();
    }

    public final long readDiscontinuity() {
        if (this.notifiedReadingStarted) {
            return -9223372036854775807L;
        }
        this.eventDispatcher.readingStarted();
        this.notifiedReadingStarted = true;
        return -9223372036854775807L;
    }

    public final long getNextLoadPositionUs() {
        return (this.loadingFinished || this.loader.isLoading()) ? Long.MIN_VALUE : 0;
    }

    public final long getBufferedPositionUs() {
        return this.loadingFinished ? Long.MIN_VALUE : 0;
    }

    public final long seekToUs(long j) {
        for (int i = 0; i < this.sampleStreams.size(); i++) {
            this.sampleStreams.get(i).reset();
        }
        return j;
    }

    public final void onLoadCompleted(SourceLoadable sourceLoadable, long j, long j2) {
        SourceLoadable sourceLoadable2 = sourceLoadable;
        this.sampleSize = (int) sourceLoadable2.dataSource.getBytesRead();
        this.sampleData = (byte[]) Assertions.checkNotNull(sourceLoadable2.sampleData);
        this.loadingFinished = true;
        this.eventDispatcher.loadCompleted(sourceLoadable2.dataSpec, sourceLoadable2.dataSource.getLastOpenedUri(), sourceLoadable2.dataSource.getLastResponseHeaders(), 1, -1, this.format, 0, null, 0, this.durationUs, j, j2, (long) this.sampleSize);
    }

    public final void onLoadCanceled(SourceLoadable sourceLoadable, long j, long j2, boolean z) {
        SourceLoadable sourceLoadable2 = sourceLoadable;
        this.eventDispatcher.loadCanceled(sourceLoadable2.dataSpec, sourceLoadable2.dataSource.getLastOpenedUri(), sourceLoadable2.dataSource.getLastResponseHeaders(), 1, -1, null, 0, null, 0, this.durationUs, j, j2, sourceLoadable2.dataSource.getBytesRead());
    }

    public final Loader.LoadErrorAction onLoadError(SourceLoadable sourceLoadable, long j, long j2, IOException iOException, int i) {
        Loader.LoadErrorAction loadErrorAction;
        SourceLoadable sourceLoadable2 = sourceLoadable;
        long retryDelayMsFor = this.loadErrorHandlingPolicy.getRetryDelayMsFor(1, j2, iOException, i);
        boolean z = retryDelayMsFor == -9223372036854775807L || i >= this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(1);
        if (!this.treatLoadErrorsAsEndOfStream || !z) {
            loadErrorAction = retryDelayMsFor != -9223372036854775807L ? Loader.createRetryAction(false, retryDelayMsFor) : Loader.DONT_RETRY_FATAL;
        } else {
            this.loadingFinished = true;
            loadErrorAction = Loader.DONT_RETRY;
        }
        this.eventDispatcher.loadError(sourceLoadable2.dataSpec, sourceLoadable2.dataSource.getLastOpenedUri(), sourceLoadable2.dataSource.getLastResponseHeaders(), 1, -1, this.format, 0, null, 0, this.durationUs, j, j2, sourceLoadable2.dataSource.getBytesRead(), iOException, !loadErrorAction.isRetry());
        return loadErrorAction;
    }

    final class SampleStreamImpl implements SampleStream {
        private boolean notifiedDownstreamFormat;
        private int streamState;

        private SampleStreamImpl() {
        }

        public final void reset() {
            if (this.streamState == 2) {
                this.streamState = 1;
            }
        }

        public final boolean isReady() {
            return SingleSampleMediaPeriod.this.loadingFinished;
        }

        public final void maybeThrowError() throws IOException {
            if (!SingleSampleMediaPeriod.this.treatLoadErrorsAsEndOfStream) {
                SingleSampleMediaPeriod.this.loader.maybeThrowError();
            }
        }

        public final int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
            maybeNotifyDownstreamFormat();
            int i = this.streamState;
            if (i == 2) {
                decoderInputBuffer.addFlag(4);
                return -4;
            } else if (z || i == 0) {
                formatHolder.format = SingleSampleMediaPeriod.this.format;
                this.streamState = 1;
                return -5;
            } else if (!SingleSampleMediaPeriod.this.loadingFinished) {
                return -3;
            } else {
                if (SingleSampleMediaPeriod.this.sampleData != null) {
                    decoderInputBuffer.addFlag(1);
                    decoderInputBuffer.timeUs = 0;
                    if (decoderInputBuffer.isFlagsOnly()) {
                        return -4;
                    }
                    decoderInputBuffer.ensureSpaceForWrite(SingleSampleMediaPeriod.this.sampleSize);
                    decoderInputBuffer.data.put(SingleSampleMediaPeriod.this.sampleData, 0, SingleSampleMediaPeriod.this.sampleSize);
                } else {
                    decoderInputBuffer.addFlag(4);
                }
                this.streamState = 2;
                return -4;
            }
        }

        public final int skipData(long j) {
            maybeNotifyDownstreamFormat();
            if (j <= 0 || this.streamState == 2) {
                return 0;
            }
            this.streamState = 2;
            return 1;
        }

        private void maybeNotifyDownstreamFormat() {
            if (!this.notifiedDownstreamFormat) {
                SingleSampleMediaPeriod.this.eventDispatcher.downstreamFormatChanged(MimeTypes.getTrackType(SingleSampleMediaPeriod.this.format.sampleMimeType), SingleSampleMediaPeriod.this.format, 0, null, 0);
                this.notifiedDownstreamFormat = true;
            }
        }
    }

    static final class SourceLoadable implements Loader.Loadable {
        public final StatsDataSource dataSource;
        public final DataSpec dataSpec;
        public byte[] sampleData;

        public final void cancelLoad() {
        }

        public SourceLoadable(DataSpec dataSpec2, DataSource dataSource2) {
            this.dataSpec = dataSpec2;
            this.dataSource = new StatsDataSource(dataSource2);
        }

        public final void load() throws IOException {
            this.dataSource.resetBytesRead();
            try {
                this.dataSource.open(this.dataSpec);
                int i = 0;
                while (i != -1) {
                    int bytesRead = (int) this.dataSource.getBytesRead();
                    if (this.sampleData == null) {
                        this.sampleData = new byte[1024];
                    } else if (bytesRead == this.sampleData.length) {
                        this.sampleData = Arrays.copyOf(this.sampleData, this.sampleData.length * 2);
                    }
                    i = this.dataSource.read(this.sampleData, bytesRead, this.sampleData.length - bytesRead);
                }
            } finally {
                Util.closeQuietly(this.dataSource);
            }
        }
    }
}
