package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.DataChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class HlsChunkSource {
    private final DataSource encryptionDataSource;
    private Uri expectedPlaylistUrl;
    private final HlsExtractorFactory extractorFactory;
    private IOException fatalError;
    private boolean independentSegments;
    private boolean isTimestampMaster;
    private final FullSegmentEncryptionKeyCache keyCache = new FullSegmentEncryptionKeyCache(4);
    private long liveEdgeInPeriodTimeUs = -9223372036854775807L;
    private final DataSource mediaDataSource;
    private final List<Format> muxedCaptionFormats;
    private final Format[] playlistFormats;
    private final HlsPlaylistTracker playlistTracker;
    private final Uri[] playlistUrls;
    private byte[] scratchSpace = Util.EMPTY_BYTE_ARRAY;
    private boolean seenExpectedPlaylistError;
    private final TimestampAdjusterProvider timestampAdjusterProvider;
    private final TrackGroup trackGroup;
    private TrackSelection trackSelection;

    public static final class HlsChunkHolder {
        public Chunk chunk;
        public boolean endOfStream;
        public Uri playlistUrl;

        public HlsChunkHolder() {
            clear();
        }

        public final void clear() {
            this.chunk = null;
            this.endOfStream = false;
            this.playlistUrl = null;
        }
    }

    public HlsChunkSource(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, Uri[] uriArr, Format[] formatArr, HlsDataSourceFactory hlsDataSourceFactory, TransferListener transferListener, TimestampAdjusterProvider timestampAdjusterProvider2, List<Format> list) {
        this.extractorFactory = hlsExtractorFactory;
        this.playlistTracker = hlsPlaylistTracker;
        this.playlistUrls = uriArr;
        this.playlistFormats = formatArr;
        this.timestampAdjusterProvider = timestampAdjusterProvider2;
        this.muxedCaptionFormats = list;
        this.mediaDataSource = hlsDataSourceFactory.createDataSource(1);
        if (transferListener != null) {
            this.mediaDataSource.addTransferListener(transferListener);
        }
        this.encryptionDataSource = hlsDataSourceFactory.createDataSource(3);
        this.trackGroup = new TrackGroup(formatArr);
        int[] iArr = new int[uriArr.length];
        for (int i = 0; i < uriArr.length; i++) {
            iArr[i] = i;
        }
        this.trackSelection = new InitializationTrackSelection(this.trackGroup, iArr);
    }

    public void maybeThrowError() throws IOException {
        IOException iOException = this.fatalError;
        if (iOException == null) {
            Uri uri = this.expectedPlaylistUrl;
            if (uri != null && this.seenExpectedPlaylistError) {
                this.playlistTracker.maybeThrowPlaylistRefreshError(uri);
                return;
            }
            return;
        }
        throw iOException;
    }

    public TrackGroup getTrackGroup() {
        return this.trackGroup;
    }

    public void setTrackSelection(TrackSelection trackSelection2) {
        this.trackSelection = trackSelection2;
    }

    public TrackSelection getTrackSelection() {
        return this.trackSelection;
    }

    public void reset() {
        this.fatalError = null;
    }

    public void setIsTimestampMaster(boolean z) {
        this.isTimestampMaster = z;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008e  */
    public void getNextChunk(long j, long j2, List<HlsMediaChunk> list, boolean z, HlsChunkHolder hlsChunkHolder) {
        int i;
        long j3;
        long j4;
        Uri uri;
        Uri uri2;
        HlsMediaPlaylist hlsMediaPlaylist;
        int i2;
        long j5 = j2;
        HlsChunkHolder hlsChunkHolder2 = hlsChunkHolder;
        HlsMediaChunk hlsMediaChunk = list.isEmpty() ? null : list.get(list.size() - 1);
        if (hlsMediaChunk == null) {
            i = -1;
        } else {
            i = this.trackGroup.indexOf(hlsMediaChunk.trackFormat);
        }
        long j6 = j5 - j;
        long resolveTimeToLiveEdgeUs = resolveTimeToLiveEdgeUs(j);
        if (hlsMediaChunk != null && !this.independentSegments) {
            long durationUs = hlsMediaChunk.getDurationUs();
            j6 = Math.max(0L, j6 - durationUs);
            if (resolveTimeToLiveEdgeUs != -9223372036854775807L) {
                j4 = j6;
                j3 = Math.max(0L, resolveTimeToLiveEdgeUs - durationUs);
                this.trackSelection.updateSelectedTrack(j, j4, j3, list, createMediaChunkIterators(hlsMediaChunk, j5));
                int selectedIndexInTrackGroup = this.trackSelection.getSelectedIndexInTrackGroup();
                boolean z2 = i == selectedIndexInTrackGroup;
                uri = this.playlistUrls[selectedIndexInTrackGroup];
                if (this.playlistTracker.isSnapshotValid(uri)) {
                    hlsChunkHolder2.playlistUrl = uri;
                    this.seenExpectedPlaylistError &= uri.equals(this.expectedPlaylistUrl);
                    this.expectedPlaylistUrl = uri;
                    return;
                }
                HlsMediaPlaylist playlistSnapshot = this.playlistTracker.getPlaylistSnapshot(uri, true);
                Assertions.checkNotNull(playlistSnapshot);
                this.independentSegments = playlistSnapshot.hasIndependentSegments;
                updateLiveEdgeTimeUs(playlistSnapshot);
                long initialStartTimeUs = playlistSnapshot.startTimeUs - this.playlistTracker.getInitialStartTimeUs();
                HlsMediaChunk hlsMediaChunk2 = hlsMediaChunk;
                int i3 = i;
                long chunkMediaSequence = getChunkMediaSequence(hlsMediaChunk, z2, playlistSnapshot, initialStartTimeUs, j2);
                if (chunkMediaSequence >= playlistSnapshot.mediaSequence || hlsMediaChunk2 == null || !z2) {
                    uri2 = uri;
                    hlsMediaPlaylist = playlistSnapshot;
                } else {
                    Uri uri3 = this.playlistUrls[i3];
                    HlsMediaPlaylist playlistSnapshot2 = this.playlistTracker.getPlaylistSnapshot(uri3, true);
                    Assertions.checkNotNull(playlistSnapshot2);
                    initialStartTimeUs = playlistSnapshot2.startTimeUs - this.playlistTracker.getInitialStartTimeUs();
                    selectedIndexInTrackGroup = i3;
                    uri2 = uri3;
                    hlsMediaPlaylist = playlistSnapshot2;
                    chunkMediaSequence = hlsMediaChunk2.getNextChunkIndex();
                }
                if (chunkMediaSequence < hlsMediaPlaylist.mediaSequence) {
                    this.fatalError = new BehindLiveWindowException();
                    return;
                }
                int i4 = (int) (chunkMediaSequence - hlsMediaPlaylist.mediaSequence);
                int size = hlsMediaPlaylist.segments.size();
                if (i4 < size) {
                    i2 = i4;
                } else if (!hlsMediaPlaylist.hasEndTag) {
                    hlsChunkHolder2.playlistUrl = uri2;
                    this.seenExpectedPlaylistError &= uri2.equals(this.expectedPlaylistUrl);
                    this.expectedPlaylistUrl = uri2;
                    return;
                } else if (z || size == 0) {
                    hlsChunkHolder2.endOfStream = true;
                    return;
                } else {
                    i2 = size - 1;
                }
                this.seenExpectedPlaylistError = false;
                this.expectedPlaylistUrl = null;
                HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.segments.get(i2);
                Uri fullEncryptionKeyUri = getFullEncryptionKeyUri(hlsMediaPlaylist, segment.initializationSegment);
                hlsChunkHolder2.chunk = maybeCreateEncryptionChunkFor(fullEncryptionKeyUri, selectedIndexInTrackGroup);
                if (hlsChunkHolder2.chunk == null) {
                    Uri fullEncryptionKeyUri2 = getFullEncryptionKeyUri(hlsMediaPlaylist, segment);
                    hlsChunkHolder2.chunk = maybeCreateEncryptionChunkFor(fullEncryptionKeyUri2, selectedIndexInTrackGroup);
                    if (hlsChunkHolder2.chunk == null) {
                        hlsChunkHolder2.chunk = HlsMediaChunk.createInstance(this.extractorFactory, this.mediaDataSource, this.playlistFormats[selectedIndexInTrackGroup], initialStartTimeUs, hlsMediaPlaylist, i2, uri2, this.muxedCaptionFormats, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), this.isTimestampMaster, this.timestampAdjusterProvider, hlsMediaChunk2, this.keyCache.get(fullEncryptionKeyUri2), this.keyCache.get(fullEncryptionKeyUri));
                        return;
                    }
                    return;
                }
                return;
            }
        }
        j4 = j6;
        j3 = resolveTimeToLiveEdgeUs;
        this.trackSelection.updateSelectedTrack(j, j4, j3, list, createMediaChunkIterators(hlsMediaChunk, j5));
        int selectedIndexInTrackGroup2 = this.trackSelection.getSelectedIndexInTrackGroup();
        if (i == selectedIndexInTrackGroup2) {
        }
        uri = this.playlistUrls[selectedIndexInTrackGroup2];
        if (this.playlistTracker.isSnapshotValid(uri)) {
        }
    }

    public void onChunkLoadCompleted(Chunk chunk) {
        if (chunk instanceof EncryptionKeyChunk) {
            EncryptionKeyChunk encryptionKeyChunk = (EncryptionKeyChunk) chunk;
            this.scratchSpace = encryptionKeyChunk.getDataHolder();
            this.keyCache.put(encryptionKeyChunk.dataSpec.uri, (byte[]) Assertions.checkNotNull(encryptionKeyChunk.getResult()));
        }
    }

    public boolean maybeBlacklistTrack(Chunk chunk, long j) {
        TrackSelection trackSelection2 = this.trackSelection;
        return trackSelection2.blacklist(trackSelection2.indexOf(this.trackGroup.indexOf(chunk.trackFormat)), j);
    }

    public boolean onPlaylistError(Uri uri, long j) {
        int indexOf;
        int i = 0;
        while (true) {
            Uri[] uriArr = this.playlistUrls;
            if (i >= uriArr.length) {
                i = -1;
                break;
            } else if (uriArr[i].equals(uri)) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1 || (indexOf = this.trackSelection.indexOf(i)) == -1) {
            return true;
        }
        this.seenExpectedPlaylistError = uri.equals(this.expectedPlaylistUrl) | this.seenExpectedPlaylistError;
        if (j == -9223372036854775807L || this.trackSelection.blacklist(indexOf, j)) {
            return true;
        }
        return false;
    }

    public MediaChunkIterator[] createMediaChunkIterators(HlsMediaChunk hlsMediaChunk, long j) {
        HlsMediaChunk hlsMediaChunk2 = hlsMediaChunk;
        int indexOf = hlsMediaChunk2 == null ? -1 : this.trackGroup.indexOf(hlsMediaChunk2.trackFormat);
        MediaChunkIterator[] mediaChunkIteratorArr = new MediaChunkIterator[this.trackSelection.length()];
        for (int i = 0; i < mediaChunkIteratorArr.length; i++) {
            int indexInTrackGroup = this.trackSelection.getIndexInTrackGroup(i);
            Uri uri = this.playlistUrls[indexInTrackGroup];
            if (!this.playlistTracker.isSnapshotValid(uri)) {
                mediaChunkIteratorArr[i] = MediaChunkIterator.EMPTY;
            } else {
                HlsMediaPlaylist playlistSnapshot = this.playlistTracker.getPlaylistSnapshot(uri, false);
                Assertions.checkNotNull(playlistSnapshot);
                long initialStartTimeUs = playlistSnapshot.startTimeUs - this.playlistTracker.getInitialStartTimeUs();
                long j2 = initialStartTimeUs;
                long chunkMediaSequence = getChunkMediaSequence(hlsMediaChunk, indexInTrackGroup != indexOf, playlistSnapshot, initialStartTimeUs, j);
                if (chunkMediaSequence < playlistSnapshot.mediaSequence) {
                    mediaChunkIteratorArr[i] = MediaChunkIterator.EMPTY;
                } else {
                    mediaChunkIteratorArr[i] = new HlsMediaPlaylistSegmentIterator(playlistSnapshot, j2, (int) (chunkMediaSequence - playlistSnapshot.mediaSequence));
                }
            }
        }
        return mediaChunkIteratorArr;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.exoplayer2.util.Util.binarySearchFloor(java.util.List, java.lang.Comparable, boolean, boolean):int
     arg types: [java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment>, java.lang.Long, int, boolean]
     candidates:
      com.google.android.exoplayer2.util.Util.binarySearchFloor(com.google.android.exoplayer2.util.LongArray, long, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchFloor(int[], int, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchFloor(long[], long, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchFloor(java.util.List, java.lang.Comparable, boolean, boolean):int */
    private long getChunkMediaSequence(HlsMediaChunk hlsMediaChunk, boolean z, HlsMediaPlaylist hlsMediaPlaylist, long j, long j2) {
        long binarySearchFloor;
        long j3;
        if (hlsMediaChunk != null && !z) {
            return hlsMediaChunk.getNextChunkIndex();
        }
        long j4 = hlsMediaPlaylist.durationUs + j;
        if (hlsMediaChunk != null && !this.independentSegments) {
            j2 = hlsMediaChunk.startTimeUs;
        }
        if (hlsMediaPlaylist.hasEndTag || j2 < j4) {
            binarySearchFloor = (long) Util.binarySearchFloor((List) hlsMediaPlaylist.segments, (Comparable) Long.valueOf(j2 - j), true, !this.playlistTracker.isLive() || hlsMediaChunk == null);
            j3 = hlsMediaPlaylist.mediaSequence;
        } else {
            binarySearchFloor = hlsMediaPlaylist.mediaSequence;
            j3 = (long) hlsMediaPlaylist.segments.size();
        }
        return binarySearchFloor + j3;
    }

    private long resolveTimeToLiveEdgeUs(long j) {
        if (this.liveEdgeInPeriodTimeUs != -9223372036854775807L) {
            return this.liveEdgeInPeriodTimeUs - j;
        }
        return -9223372036854775807L;
    }

    private void updateLiveEdgeTimeUs(HlsMediaPlaylist hlsMediaPlaylist) {
        long j;
        if (hlsMediaPlaylist.hasEndTag) {
            j = -9223372036854775807L;
        } else {
            j = hlsMediaPlaylist.getEndTimeUs() - this.playlistTracker.getInitialStartTimeUs();
        }
        this.liveEdgeInPeriodTimeUs = j;
    }

    private Chunk maybeCreateEncryptionChunkFor(Uri uri, int i) {
        if (uri == null) {
            return null;
        }
        byte[] remove = this.keyCache.remove(uri);
        if (remove != null) {
            this.keyCache.put(uri, remove);
            return null;
        }
        return new EncryptionKeyChunk(this.encryptionDataSource, new DataSpec.Builder().setUri(uri).setFlags(1).build(), this.playlistFormats[i], this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), this.scratchSpace);
    }

    private static Uri getFullEncryptionKeyUri(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist.Segment segment) {
        if (segment == null || segment.fullSegmentEncryptionKeyUri == null) {
            return null;
        }
        return UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, segment.fullSegmentEncryptionKeyUri);
    }

    static final class InitializationTrackSelection extends BaseTrackSelection {
        private int selectedIndex;

        public final Object getSelectionData() {
            return null;
        }

        public final int getSelectionReason() {
            return 0;
        }

        public InitializationTrackSelection(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
            this.selectedIndex = indexOf(trackGroup.getFormat(0));
        }

        public final void updateSelectedTrack(long j, long j2, long j3, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (isBlacklisted(this.selectedIndex, elapsedRealtime)) {
                for (int i = this.length - 1; i >= 0; i--) {
                    if (!isBlacklisted(i, elapsedRealtime)) {
                        this.selectedIndex = i;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        public final int getSelectedIndex() {
            return this.selectedIndex;
        }
    }

    static final class EncryptionKeyChunk extends DataChunk {
        private byte[] result;

        public EncryptionKeyChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, byte[] bArr) {
            super(dataSource, dataSpec, 3, format, i, obj, bArr);
        }

        public final void consume(byte[] bArr, int i) {
            this.result = Arrays.copyOf(bArr, i);
        }

        public final byte[] getResult() {
            return this.result;
        }
    }

    static final class HlsMediaPlaylistSegmentIterator extends BaseMediaChunkIterator {
        private final HlsMediaPlaylist playlist;
        private final long startOfPlaylistInPeriodUs;

        public HlsMediaPlaylistSegmentIterator(HlsMediaPlaylist hlsMediaPlaylist, long j, int i) {
            super((long) i, (long) (hlsMediaPlaylist.segments.size() - 1));
            this.playlist = hlsMediaPlaylist;
            this.startOfPlaylistInPeriodUs = j;
        }

        public final DataSpec getDataSpec() {
            checkInBounds();
            HlsMediaPlaylist.Segment segment = this.playlist.segments.get((int) getCurrentIndex());
            return new DataSpec(UriUtil.resolveToUri(this.playlist.baseUri, segment.url), segment.byteRangeOffset, segment.byteRangeLength);
        }

        public final long getChunkStartTimeUs() {
            checkInBounds();
            return this.startOfPlaylistInPeriodUs + this.playlist.segments.get((int) getCurrentIndex()).relativeStartTimeUs;
        }

        public final long getChunkEndTimeUs() {
            checkInBounds();
            HlsMediaPlaylist.Segment segment = this.playlist.segments.get((int) getCurrentIndex());
            return this.startOfPlaylistInPeriodUs + segment.relativeStartTimeUs + segment.durationUs;
        }
    }
}
