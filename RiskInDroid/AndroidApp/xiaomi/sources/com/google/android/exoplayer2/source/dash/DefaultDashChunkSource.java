package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.rawcc.RawCcExtractor;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.source.chunk.ContainerMediaChunk;
import com.google.android.exoplayer2.source.chunk.InitializationChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.SingleSampleMediaChunk;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DefaultDashChunkSource implements DashChunkSource {
    private final int[] adaptationSetIndices;
    private final DataSource dataSource;
    private final long elapsedRealtimeOffsetMs;
    private IOException fatalError;
    private long liveEdgeTimeUs = -9223372036854775807L;
    private DashManifest manifest;
    private final LoaderErrorThrower manifestLoaderErrorThrower;
    private final int maxSegmentsPerLoad;
    private boolean missingLastSegment;
    private int periodIndex;
    private final PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler;
    protected final RepresentationHolder[] representationHolders;
    private TrackSelection trackSelection;
    private final int trackType;

    public static final class Factory implements DashChunkSource.Factory {
        private final DataSource.Factory dataSourceFactory;
        private final int maxSegmentsPerLoad;

        public Factory(DataSource.Factory factory) {
            this(factory, 1);
        }

        public Factory(DataSource.Factory factory, int i) {
            this.dataSourceFactory = factory;
            this.maxSegmentsPerLoad = i;
        }

        public final DashChunkSource createDashChunkSource(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, int i, int[] iArr, TrackSelection trackSelection, int i2, long j, boolean z, List<Format> list, PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler, TransferListener transferListener) {
            TransferListener transferListener2 = transferListener;
            DataSource createDataSource = this.dataSourceFactory.createDataSource();
            if (transferListener2 != null) {
                createDataSource.addTransferListener(transferListener2);
            }
            return new DefaultDashChunkSource(loaderErrorThrower, dashManifest, i, iArr, trackSelection, i2, createDataSource, j, this.maxSegmentsPerLoad, z, list, playerTrackEmsgHandler);
        }
    }

    public DefaultDashChunkSource(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, int i, int[] iArr, TrackSelection trackSelection2, int i2, DataSource dataSource2, long j, int i3, boolean z, List<Format> list, PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2) {
        TrackSelection trackSelection3 = trackSelection2;
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.manifest = dashManifest;
        this.adaptationSetIndices = iArr;
        this.trackSelection = trackSelection3;
        this.trackType = i2;
        this.dataSource = dataSource2;
        this.periodIndex = i;
        this.elapsedRealtimeOffsetMs = j;
        this.maxSegmentsPerLoad = i3;
        this.playerTrackEmsgHandler = playerTrackEmsgHandler2;
        long periodDurationUs = dashManifest.getPeriodDurationUs(i);
        ArrayList<Representation> representations = getRepresentations();
        this.representationHolders = new RepresentationHolder[trackSelection2.length()];
        for (int i4 = 0; i4 < this.representationHolders.length; i4++) {
            this.representationHolders[i4] = new RepresentationHolder(periodDurationUs, i2, representations.get(trackSelection3.getIndexInTrackGroup(i4)), z, list, playerTrackEmsgHandler2);
        }
    }

    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        for (RepresentationHolder representationHolder : this.representationHolders) {
            if (representationHolder.segmentIndex != null) {
                long segmentNum = representationHolder.getSegmentNum(j);
                long segmentStartTimeUs = representationHolder.getSegmentStartTimeUs(segmentNum);
                return seekParameters.resolveSeekPositionUs(j, segmentStartTimeUs, (segmentStartTimeUs >= j || segmentNum >= ((long) (representationHolder.getSegmentCount() + -1))) ? segmentStartTimeUs : representationHolder.getSegmentStartTimeUs(segmentNum + 1));
            }
        }
        return j;
    }

    public void updateManifest(DashManifest dashManifest, int i) {
        try {
            this.manifest = dashManifest;
            this.periodIndex = i;
            long periodDurationUs = this.manifest.getPeriodDurationUs(this.periodIndex);
            ArrayList<Representation> representations = getRepresentations();
            for (int i2 = 0; i2 < this.representationHolders.length; i2++) {
                RepresentationHolder[] representationHolderArr = this.representationHolders;
                representationHolderArr[i2] = representationHolderArr[i2].copyWithNewRepresentation(periodDurationUs, representations.get(this.trackSelection.getIndexInTrackGroup(i2)));
            }
        } catch (BehindLiveWindowException e) {
            this.fatalError = e;
        }
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

    public void getNextChunk(long j, long j2, List<? extends MediaChunk> list, ChunkHolder chunkHolder) {
        long j3;
        int i;
        MediaChunkIterator[] mediaChunkIteratorArr;
        ChunkHolder chunkHolder2 = chunkHolder;
        if (this.fatalError == null) {
            long j4 = j2 - j;
            long resolveTimeToLiveEdgeUs = resolveTimeToLiveEdgeUs(j);
            long msToUs = C.msToUs(this.manifest.availabilityStartTimeMs) + C.msToUs(this.manifest.getPeriod(this.periodIndex).startMs) + j2;
            PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2 = this.playerTrackEmsgHandler;
            if (playerTrackEmsgHandler2 == null || !playerTrackEmsgHandler2.maybeRefreshManifestBeforeLoadingNextChunk(msToUs)) {
                long msToUs2 = C.msToUs(Util.getNowUnixTimeMs(this.elapsedRealtimeOffsetMs));
                MediaChunk mediaChunk = list.isEmpty() ? null : (MediaChunk) list.get(list.size() - 1);
                MediaChunkIterator[] mediaChunkIteratorArr2 = new MediaChunkIterator[this.trackSelection.length()];
                int i2 = 0;
                while (i2 < mediaChunkIteratorArr2.length) {
                    RepresentationHolder representationHolder = this.representationHolders[i2];
                    if (representationHolder.segmentIndex == null) {
                        mediaChunkIteratorArr2[i2] = MediaChunkIterator.EMPTY;
                        mediaChunkIteratorArr = mediaChunkIteratorArr2;
                        i = i2;
                        j3 = msToUs2;
                    } else {
                        long firstAvailableSegmentNum = representationHolder.getFirstAvailableSegmentNum(this.manifest, this.periodIndex, msToUs2);
                        long lastAvailableSegmentNum = representationHolder.getLastAvailableSegmentNum(this.manifest, this.periodIndex, msToUs2);
                        RepresentationHolder representationHolder2 = representationHolder;
                        mediaChunkIteratorArr = mediaChunkIteratorArr2;
                        i = i2;
                        j3 = msToUs2;
                        long segmentNum = getSegmentNum(representationHolder, mediaChunk, j2, firstAvailableSegmentNum, lastAvailableSegmentNum);
                        if (segmentNum < firstAvailableSegmentNum) {
                            mediaChunkIteratorArr[i] = MediaChunkIterator.EMPTY;
                        } else {
                            mediaChunkIteratorArr[i] = new RepresentationSegmentIterator(representationHolder2, segmentNum, lastAvailableSegmentNum);
                        }
                    }
                    i2 = i + 1;
                    mediaChunkIteratorArr2 = mediaChunkIteratorArr;
                    msToUs2 = j3;
                }
                long j5 = msToUs2;
                this.trackSelection.updateSelectedTrack(j, j4, resolveTimeToLiveEdgeUs, list, mediaChunkIteratorArr2);
                RepresentationHolder representationHolder3 = this.representationHolders[this.trackSelection.getSelectedIndex()];
                if (representationHolder3.extractorWrapper != null) {
                    Representation representation = representationHolder3.representation;
                    RangedUri initializationUri = representationHolder3.extractorWrapper.getSampleFormats() == null ? representation.getInitializationUri() : null;
                    RangedUri indexUri = representationHolder3.segmentIndex == null ? representation.getIndexUri() : null;
                    if (!(initializationUri == null && indexUri == null)) {
                        chunkHolder2.chunk = newInitializationChunk(representationHolder3, this.dataSource, this.trackSelection.getSelectedFormat(), this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), initializationUri, indexUri);
                        return;
                    }
                }
                long j6 = representationHolder3.periodDurationUs;
                long j7 = -9223372036854775807L;
                boolean z = j6 != -9223372036854775807L;
                if (representationHolder3.getSegmentCount() == 0) {
                    chunkHolder2.endOfStream = z;
                    return;
                }
                long j8 = j5;
                long firstAvailableSegmentNum2 = representationHolder3.getFirstAvailableSegmentNum(this.manifest, this.periodIndex, j8);
                long lastAvailableSegmentNum2 = representationHolder3.getLastAvailableSegmentNum(this.manifest, this.periodIndex, j8);
                updateLiveEdgeTimeUs(representationHolder3, lastAvailableSegmentNum2);
                long j9 = lastAvailableSegmentNum2;
                long segmentNum2 = getSegmentNum(representationHolder3, mediaChunk, j2, firstAvailableSegmentNum2, lastAvailableSegmentNum2);
                if (segmentNum2 < firstAvailableSegmentNum2) {
                    this.fatalError = new BehindLiveWindowException();
                } else if (segmentNum2 > j9 || (this.missingLastSegment && segmentNum2 >= j9)) {
                    chunkHolder2.endOfStream = z;
                } else if (!z || representationHolder3.getSegmentStartTimeUs(segmentNum2) < j6) {
                    int min = (int) Math.min((long) this.maxSegmentsPerLoad, (j9 - segmentNum2) + 1);
                    if (j6 != -9223372036854775807L) {
                        while (min > 1 && representationHolder3.getSegmentStartTimeUs((((long) min) + segmentNum2) - 1) >= j6) {
                            min--;
                        }
                    }
                    int i3 = min;
                    if (list.isEmpty()) {
                        j7 = j2;
                    }
                    chunkHolder2.chunk = newMediaChunk(representationHolder3, this.dataSource, this.trackType, this.trackSelection.getSelectedFormat(), this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), segmentNum2, i3, j7);
                } else {
                    chunkHolder2.endOfStream = true;
                }
            }
        }
    }

    public void onChunkLoadCompleted(Chunk chunk) {
        SeekMap seekMap;
        if (chunk instanceof InitializationChunk) {
            int indexOf = this.trackSelection.indexOf(((InitializationChunk) chunk).trackFormat);
            RepresentationHolder representationHolder = this.representationHolders[indexOf];
            if (representationHolder.segmentIndex == null && (seekMap = representationHolder.extractorWrapper.getSeekMap()) != null) {
                this.representationHolders[indexOf] = representationHolder.copyWithNewSegmentIndex(new DashWrappingSegmentIndex((ChunkIndex) seekMap, representationHolder.representation.presentationTimeOffsetUs));
            }
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2 = this.playerTrackEmsgHandler;
        if (playerTrackEmsgHandler2 != null) {
            playerTrackEmsgHandler2.onChunkLoadCompleted(chunk);
        }
    }

    public boolean onChunkLoadError(Chunk chunk, boolean z, Exception exc, long j) {
        RepresentationHolder representationHolder;
        int segmentCount;
        if (!z) {
            return false;
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2 = this.playerTrackEmsgHandler;
        if (playerTrackEmsgHandler2 != null && playerTrackEmsgHandler2.maybeRefreshManifestOnLoadingError(chunk)) {
            return true;
        }
        if (!this.manifest.dynamic && (chunk instanceof MediaChunk) && (exc instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) exc).responseCode == 404 && (segmentCount = (representationHolder = this.representationHolders[this.trackSelection.indexOf(chunk.trackFormat)]).getSegmentCount()) != -1 && segmentCount != 0) {
            if (((MediaChunk) chunk).getNextChunkIndex() > (representationHolder.getFirstSegmentNum() + ((long) segmentCount)) - 1) {
                this.missingLastSegment = true;
                return true;
            }
        }
        if (j != -9223372036854775807L) {
            TrackSelection trackSelection2 = this.trackSelection;
            if (trackSelection2.blacklist(trackSelection2.indexOf(chunk.trackFormat), j)) {
                return true;
            }
        }
        return false;
    }

    private long getSegmentNum(RepresentationHolder representationHolder, MediaChunk mediaChunk, long j, long j2, long j3) {
        if (mediaChunk != null) {
            return mediaChunk.getNextChunkIndex();
        }
        return Util.constrainValue(representationHolder.getSegmentNum(j), j2, j3);
    }

    private ArrayList<Representation> getRepresentations() {
        List<AdaptationSet> list = this.manifest.getPeriod(this.periodIndex).adaptationSets;
        ArrayList<Representation> arrayList = new ArrayList<>();
        for (int i : this.adaptationSetIndices) {
            arrayList.addAll(list.get(i).representations);
        }
        return arrayList;
    }

    private void updateLiveEdgeTimeUs(RepresentationHolder representationHolder, long j) {
        this.liveEdgeTimeUs = this.manifest.dynamic ? representationHolder.getSegmentEndTimeUs(j) : -9223372036854775807L;
    }

    private long resolveTimeToLiveEdgeUs(long j) {
        if (this.manifest.dynamic && this.liveEdgeTimeUs != -9223372036854775807L) {
            return this.liveEdgeTimeUs - j;
        }
        return -9223372036854775807L;
    }

    /* access modifiers changed from: protected */
    public Chunk newInitializationChunk(RepresentationHolder representationHolder, DataSource dataSource2, Format format, int i, Object obj, RangedUri rangedUri, RangedUri rangedUri2) {
        Representation representation = representationHolder.representation;
        if (rangedUri != null && (rangedUri2 = rangedUri.attemptMerge(rangedUri2, representation.baseUrl)) == null) {
            rangedUri2 = rangedUri;
        }
        return new InitializationChunk(dataSource2, DashUtil.buildDataSpec(representation, rangedUri2), format, i, obj, representationHolder.extractorWrapper);
    }

    /* access modifiers changed from: protected */
    public Chunk newMediaChunk(RepresentationHolder representationHolder, DataSource dataSource2, int i, Format format, int i2, Object obj, long j, int i3, long j2) {
        RepresentationHolder representationHolder2 = representationHolder;
        long j3 = j;
        Representation representation = representationHolder2.representation;
        long segmentStartTimeUs = representationHolder2.getSegmentStartTimeUs(j3);
        RangedUri segmentUrl = representationHolder2.getSegmentUrl(j3);
        String str = representation.baseUrl;
        if (representationHolder2.extractorWrapper == null) {
            return new SingleSampleMediaChunk(dataSource2, DashUtil.buildDataSpec(representation, segmentUrl), format, i2, obj, segmentStartTimeUs, representationHolder2.getSegmentEndTimeUs(j3), j, i, format);
        }
        int i4 = 1;
        RangedUri rangedUri = segmentUrl;
        int i5 = 1;
        int i6 = i3;
        while (i4 < i6) {
            RangedUri attemptMerge = rangedUri.attemptMerge(representationHolder2.getSegmentUrl(((long) i4) + j3), str);
            if (attemptMerge == null) {
                break;
            }
            i5++;
            i4++;
            rangedUri = attemptMerge;
        }
        long segmentEndTimeUs = representationHolder2.getSegmentEndTimeUs((((long) i5) + j3) - 1);
        long j4 = representationHolder2.periodDurationUs;
        long j5 = (j4 == -9223372036854775807L || j4 > segmentEndTimeUs) ? -9223372036854775807L : j4;
        ChunkExtractorWrapper chunkExtractorWrapper = representationHolder2.extractorWrapper;
        return new ContainerMediaChunk(dataSource2, DashUtil.buildDataSpec(representation, rangedUri), format, i2, obj, segmentStartTimeUs, segmentEndTimeUs, j2, j5, j, i5, -representation.presentationTimeOffsetUs, chunkExtractorWrapper);
    }

    public static final class RepresentationSegmentIterator extends BaseMediaChunkIterator {
        private final RepresentationHolder representationHolder;

        public RepresentationSegmentIterator(RepresentationHolder representationHolder2, long j, long j2) {
            super(j, j2);
            this.representationHolder = representationHolder2;
        }

        public final DataSpec getDataSpec() {
            checkInBounds();
            return DashUtil.buildDataSpec(this.representationHolder.representation, this.representationHolder.getSegmentUrl(getCurrentIndex()));
        }

        public final long getChunkStartTimeUs() {
            checkInBounds();
            return this.representationHolder.getSegmentStartTimeUs(getCurrentIndex());
        }

        public final long getChunkEndTimeUs() {
            checkInBounds();
            return this.representationHolder.getSegmentEndTimeUs(getCurrentIndex());
        }
    }

    public static final class RepresentationHolder {
        final ChunkExtractorWrapper extractorWrapper;
        public final long periodDurationUs;
        public final Representation representation;
        public final DashSegmentIndex segmentIndex;
        private final long segmentNumShift;

        RepresentationHolder(long j, int i, Representation representation2, boolean z, List<Format> list, TrackOutput trackOutput) {
            this(j, representation2, createExtractorWrapper(i, representation2, z, list, trackOutput), 0, representation2.getIndex());
        }

        private RepresentationHolder(long j, Representation representation2, ChunkExtractorWrapper chunkExtractorWrapper, long j2, DashSegmentIndex dashSegmentIndex) {
            this.periodDurationUs = j;
            this.representation = representation2;
            this.segmentNumShift = j2;
            this.extractorWrapper = chunkExtractorWrapper;
            this.segmentIndex = dashSegmentIndex;
        }

        /* access modifiers changed from: package-private */
        public final RepresentationHolder copyWithNewRepresentation(long j, Representation representation2) throws BehindLiveWindowException {
            long j2;
            long j3;
            long j4 = j;
            DashSegmentIndex index = this.representation.getIndex();
            DashSegmentIndex index2 = representation2.getIndex();
            if (index == null) {
                return new RepresentationHolder(j, representation2, this.extractorWrapper, this.segmentNumShift, index);
            } else if (!index.isExplicit()) {
                return new RepresentationHolder(j, representation2, this.extractorWrapper, this.segmentNumShift, index2);
            } else {
                int segmentCount = index.getSegmentCount(j4);
                if (segmentCount == 0) {
                    return new RepresentationHolder(j, representation2, this.extractorWrapper, this.segmentNumShift, index2);
                }
                long firstSegmentNum = index.getFirstSegmentNum();
                long timeUs = index.getTimeUs(firstSegmentNum);
                long j5 = (((long) segmentCount) + firstSegmentNum) - 1;
                long timeUs2 = index.getTimeUs(j5) + index.getDurationUs(j5, j4);
                long firstSegmentNum2 = index2.getFirstSegmentNum();
                long j6 = firstSegmentNum;
                long timeUs3 = index2.getTimeUs(firstSegmentNum2);
                long j7 = this.segmentNumShift;
                if (timeUs2 == timeUs3) {
                    j2 = j7 + ((j5 + 1) - firstSegmentNum2);
                } else if (timeUs2 >= timeUs3) {
                    if (timeUs3 < timeUs) {
                        j3 = j7 - (index2.getSegmentNum(timeUs, j) - j6);
                    } else {
                        j3 = (index.getSegmentNum(timeUs3, j) - firstSegmentNum2) + j7;
                    }
                    j2 = j3;
                } else {
                    throw new BehindLiveWindowException();
                }
                return new RepresentationHolder(j, representation2, this.extractorWrapper, j2, index2);
            }
        }

        /* access modifiers changed from: package-private */
        public final RepresentationHolder copyWithNewSegmentIndex(DashSegmentIndex dashSegmentIndex) {
            return new RepresentationHolder(this.periodDurationUs, this.representation, this.extractorWrapper, this.segmentNumShift, dashSegmentIndex);
        }

        public final long getFirstSegmentNum() {
            return this.segmentIndex.getFirstSegmentNum() + this.segmentNumShift;
        }

        public final int getSegmentCount() {
            return this.segmentIndex.getSegmentCount(this.periodDurationUs);
        }

        public final long getSegmentStartTimeUs(long j) {
            return this.segmentIndex.getTimeUs(j - this.segmentNumShift);
        }

        public final long getSegmentEndTimeUs(long j) {
            return getSegmentStartTimeUs(j) + this.segmentIndex.getDurationUs(j - this.segmentNumShift, this.periodDurationUs);
        }

        public final long getSegmentNum(long j) {
            return this.segmentIndex.getSegmentNum(j, this.periodDurationUs) + this.segmentNumShift;
        }

        public final RangedUri getSegmentUrl(long j) {
            return this.segmentIndex.getSegmentUrl(j - this.segmentNumShift);
        }

        public final long getFirstAvailableSegmentNum(DashManifest dashManifest, int i, long j) {
            if (getSegmentCount() != -1 || dashManifest.timeShiftBufferDepthMs == -9223372036854775807L) {
                return getFirstSegmentNum();
            }
            return Math.max(getFirstSegmentNum(), getSegmentNum(((j - C.msToUs(dashManifest.availabilityStartTimeMs)) - C.msToUs(dashManifest.getPeriod(i).startMs)) - C.msToUs(dashManifest.timeShiftBufferDepthMs)));
        }

        public final long getLastAvailableSegmentNum(DashManifest dashManifest, int i, long j) {
            long firstSegmentNum;
            int segmentCount = getSegmentCount();
            if (segmentCount == -1) {
                firstSegmentNum = getSegmentNum((j - C.msToUs(dashManifest.availabilityStartTimeMs)) - C.msToUs(dashManifest.getPeriod(i).startMs));
            } else {
                firstSegmentNum = getFirstSegmentNum() + ((long) segmentCount);
            }
            return firstSegmentNum - 1;
        }

        private static boolean mimeTypeIsWebm(String str) {
            return str.startsWith("video/webm") || str.startsWith("audio/webm") || str.startsWith("application/webm");
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r9v3, types: [com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor] */
        /* JADX WARN: Type inference failed for: r9v6, types: [com.google.android.exoplayer2.extractor.rawcc.RawCcExtractor] */
        /* JADX WARNING: Multi-variable type inference failed */
        private static ChunkExtractorWrapper createExtractorWrapper(int i, Representation representation2, boolean z, List<Format> list, TrackOutput trackOutput) {
            FragmentedMp4Extractor fragmentedMp4Extractor;
            String str = representation2.format.containerMimeType;
            if (MimeTypes.isText(str)) {
                if (!"application/x-rawcc".equals(str)) {
                    return null;
                }
                fragmentedMp4Extractor = new RawCcExtractor(representation2.format);
            } else if (mimeTypeIsWebm(str)) {
                fragmentedMp4Extractor = new MatroskaExtractor(1);
            } else {
                fragmentedMp4Extractor = new FragmentedMp4Extractor(z ? 4 : 0, null, null, list, trackOutput);
            }
            return new ChunkExtractorWrapper(fragmentedMp4Extractor, i, representation2.format);
        }
    }
}
