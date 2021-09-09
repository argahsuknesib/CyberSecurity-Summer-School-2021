package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.source.chunk.ContainerMediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.List;

public class DefaultSsChunkSource implements SsChunkSource {
    private int currentManifestChunkOffset;
    private final DataSource dataSource;
    private final ChunkExtractorWrapper[] extractorWrappers;
    private IOException fatalError;
    private SsManifest manifest;
    private final LoaderErrorThrower manifestLoaderErrorThrower;
    private final int streamElementIndex;
    private TrackSelection trackSelection;

    public void onChunkLoadCompleted(Chunk chunk) {
    }

    public static final class Factory implements SsChunkSource.Factory {
        private final DataSource.Factory dataSourceFactory;

        public Factory(DataSource.Factory factory) {
            this.dataSourceFactory = factory;
        }

        public final SsChunkSource createChunkSource(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int i, TrackSelection trackSelection, TransferListener transferListener) {
            DataSource createDataSource = this.dataSourceFactory.createDataSource();
            if (transferListener != null) {
                createDataSource.addTransferListener(transferListener);
            }
            return new DefaultSsChunkSource(loaderErrorThrower, ssManifest, i, trackSelection, createDataSource);
        }
    }

    public DefaultSsChunkSource(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int i, TrackSelection trackSelection2, DataSource dataSource2) {
        SsManifest ssManifest2 = ssManifest;
        int i2 = i;
        TrackSelection trackSelection3 = trackSelection2;
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.manifest = ssManifest2;
        this.streamElementIndex = i2;
        this.trackSelection = trackSelection3;
        this.dataSource = dataSource2;
        SsManifest.StreamElement streamElement = ssManifest2.streamElements[i2];
        this.extractorWrappers = new ChunkExtractorWrapper[trackSelection2.length()];
        int i3 = 0;
        while (i3 < this.extractorWrappers.length) {
            int indexInTrackGroup = trackSelection3.getIndexInTrackGroup(i3);
            Format format = streamElement.formats[indexInTrackGroup];
            int i4 = i3;
            Track track = r7;
            Track track2 = new Track(indexInTrackGroup, streamElement.type, streamElement.timescale, -9223372036854775807L, ssManifest2.durationUs, format, 0, format.drmInitData != null ? ((SsManifest.ProtectionElement) Assertions.checkNotNull(ssManifest2.protectionElement)).trackEncryptionBoxes : null, streamElement.type == 2 ? 4 : 0, null, null);
            this.extractorWrappers[i4] = new ChunkExtractorWrapper(new FragmentedMp4Extractor(3, null, track), streamElement.type, format);
            i3 = i4 + 1;
        }
    }

    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        SsManifest.StreamElement streamElement = this.manifest.streamElements[this.streamElementIndex];
        int chunkIndex = streamElement.getChunkIndex(j);
        long startTimeUs = streamElement.getStartTimeUs(chunkIndex);
        return seekParameters.resolveSeekPositionUs(j, startTimeUs, (startTimeUs >= j || chunkIndex >= streamElement.chunkCount + -1) ? startTimeUs : streamElement.getStartTimeUs(chunkIndex + 1));
    }

    public void updateManifest(SsManifest ssManifest) {
        SsManifest.StreamElement streamElement = this.manifest.streamElements[this.streamElementIndex];
        int i = streamElement.chunkCount;
        SsManifest.StreamElement streamElement2 = ssManifest.streamElements[this.streamElementIndex];
        if (i == 0 || streamElement2.chunkCount == 0) {
            this.currentManifestChunkOffset += i;
        } else {
            int i2 = i - 1;
            long startTimeUs = streamElement2.getStartTimeUs(0);
            if (streamElement.getStartTimeUs(i2) + streamElement.getChunkDurationUs(i2) <= startTimeUs) {
                this.currentManifestChunkOffset += i;
            } else {
                this.currentManifestChunkOffset += streamElement.getChunkIndex(startTimeUs);
            }
        }
        this.manifest = ssManifest;
    }

    public void updateTrackSelection(TrackSelection trackSelection2) {
        this.trackSelection = trackSelection2;
    }

    public void maybeThrowError() throws IOException {
        IOException iOException = this.fatalError;
        if (iOException == null) {
            this.manifestLoaderErrorThrower.maybeThrowError();
            return;
        }
        throw iOException;
    }

    public int getPreferredQueueSize(long j, List<? extends MediaChunk> list) {
        if (this.fatalError != null || this.trackSelection.length() < 2) {
            return list.size();
        }
        return this.trackSelection.evaluateQueueSize(j, list);
    }

    public final void getNextChunk(long j, long j2, List<? extends MediaChunk> list, ChunkHolder chunkHolder) {
        int i;
        long j3 = j2;
        ChunkHolder chunkHolder2 = chunkHolder;
        if (this.fatalError == null) {
            SsManifest.StreamElement streamElement = this.manifest.streamElements[this.streamElementIndex];
            if (streamElement.chunkCount == 0) {
                chunkHolder2.endOfStream = !this.manifest.isLive;
                return;
            }
            if (list.isEmpty()) {
                i = streamElement.getChunkIndex(j3);
            } else {
                i = (int) (((MediaChunk) list.get(list.size() - 1)).getNextChunkIndex() - ((long) this.currentManifestChunkOffset));
                if (i < 0) {
                    this.fatalError = new BehindLiveWindowException();
                    return;
                }
            }
            if (i >= streamElement.chunkCount) {
                chunkHolder2.endOfStream = !this.manifest.isLive;
                return;
            }
            long j4 = j3 - j;
            long resolveTimeToLiveEdgeUs = resolveTimeToLiveEdgeUs(j);
            MediaChunkIterator[] mediaChunkIteratorArr = new MediaChunkIterator[this.trackSelection.length()];
            for (int i2 = 0; i2 < mediaChunkIteratorArr.length; i2++) {
                mediaChunkIteratorArr[i2] = new StreamElementIterator(streamElement, this.trackSelection.getIndexInTrackGroup(i2), i);
            }
            this.trackSelection.updateSelectedTrack(j, j4, resolveTimeToLiveEdgeUs, list, mediaChunkIteratorArr);
            long startTimeUs = streamElement.getStartTimeUs(i);
            long chunkDurationUs = startTimeUs + streamElement.getChunkDurationUs(i);
            if (!list.isEmpty()) {
                j3 = -9223372036854775807L;
            }
            long j5 = j3;
            int i3 = i + this.currentManifestChunkOffset;
            int selectedIndex = this.trackSelection.getSelectedIndex();
            ChunkExtractorWrapper chunkExtractorWrapper = this.extractorWrappers[selectedIndex];
            Uri buildRequestUri = streamElement.buildRequestUri(this.trackSelection.getIndexInTrackGroup(selectedIndex), i);
            chunkHolder2.chunk = newMediaChunk(this.trackSelection.getSelectedFormat(), this.dataSource, buildRequestUri, i3, startTimeUs, chunkDurationUs, j5, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), chunkExtractorWrapper);
        }
    }

    public boolean onChunkLoadError(Chunk chunk, boolean z, Exception exc, long j) {
        if (!z || j == -9223372036854775807L) {
            return false;
        }
        TrackSelection trackSelection2 = this.trackSelection;
        return trackSelection2.blacklist(trackSelection2.indexOf(chunk.trackFormat), j);
    }

    private static MediaChunk newMediaChunk(Format format, DataSource dataSource2, Uri uri, int i, long j, long j2, long j3, int i2, Object obj, ChunkExtractorWrapper chunkExtractorWrapper) {
        DataSource dataSource3 = dataSource2;
        long j4 = j2;
        long j5 = j3;
        int i3 = i2;
        Object obj2 = obj;
        DataSpec dataSpec = r0;
        DataSpec dataSpec2 = new DataSpec(uri);
        return new ContainerMediaChunk(dataSource3, dataSpec, format, i3, obj2, j, j4, j5, -9223372036854775807L, (long) i, 1, j, chunkExtractorWrapper);
    }

    private long resolveTimeToLiveEdgeUs(long j) {
        if (!this.manifest.isLive) {
            return -9223372036854775807L;
        }
        SsManifest.StreamElement streamElement = this.manifest.streamElements[this.streamElementIndex];
        int i = streamElement.chunkCount - 1;
        return (streamElement.getStartTimeUs(i) + streamElement.getChunkDurationUs(i)) - j;
    }

    static final class StreamElementIterator extends BaseMediaChunkIterator {
        private final SsManifest.StreamElement streamElement;
        private final int trackIndex;

        public StreamElementIterator(SsManifest.StreamElement streamElement2, int i, int i2) {
            super((long) i2, (long) (streamElement2.chunkCount - 1));
            this.streamElement = streamElement2;
            this.trackIndex = i;
        }

        public final DataSpec getDataSpec() {
            checkInBounds();
            return new DataSpec(this.streamElement.buildRequestUri(this.trackIndex, (int) getCurrentIndex()));
        }

        public final long getChunkStartTimeUs() {
            checkInBounds();
            return this.streamElement.getStartTimeUs((int) getCurrentIndex());
        }

        public final long getChunkEndTimeUs() {
            return getChunkStartTimeUs() + this.streamElement.getChunkDurationUs((int) getCurrentIndex());
        }
    }
}
