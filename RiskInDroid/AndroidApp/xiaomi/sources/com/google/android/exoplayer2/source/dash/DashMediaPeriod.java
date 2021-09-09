package com.google.android.exoplayer2.source.dash;

import android.util.Pair;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.Descriptor;
import com.google.android.exoplayer2.source.dash.manifest.EventStream;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class DashMediaPeriod implements MediaPeriod, SequenceableLoader.Callback<ChunkSampleStream<DashChunkSource>>, ChunkSampleStream.ReleaseCallback<DashChunkSource> {
    private static final Pattern CEA608_SERVICE_DESCRIPTOR_REGEX = Pattern.compile("CC([1-4])=(.+)");
    private final Allocator allocator;
    private MediaPeriod.Callback callback;
    private final DashChunkSource.Factory chunkSourceFactory;
    private SequenceableLoader compositeSequenceableLoader;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final DrmSessionManager drmSessionManager;
    private final long elapsedRealtimeOffsetMs;
    private final MediaSourceEventListener.EventDispatcher eventDispatcher;
    private EventSampleStream[] eventSampleStreams = new EventSampleStream[0];
    private List<EventStream> eventStreams;
    final int id;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private DashManifest manifest;
    private final LoaderErrorThrower manifestLoaderErrorThrower;
    private boolean notifiedReadingStarted;
    private int periodIndex;
    private final PlayerEmsgHandler playerEmsgHandler;
    private ChunkSampleStream<DashChunkSource>[] sampleStreams = newSampleStreamArray(0);
    private final IdentityHashMap<ChunkSampleStream<DashChunkSource>, PlayerEmsgHandler.PlayerTrackEmsgHandler> trackEmsgHandlerBySampleStream = new IdentityHashMap<>();
    private final TrackGroupInfo[] trackGroupInfos;
    private final TrackGroupArray trackGroups;
    private final TransferListener transferListener;

    public final /* bridge */ /* synthetic */ void onContinueLoadingRequested(SequenceableLoader sequenceableLoader) {
        onContinueLoadingRequested((ChunkSampleStream<DashChunkSource>) ((ChunkSampleStream) sequenceableLoader));
    }

    public DashMediaPeriod(int i, DashManifest dashManifest, int i2, DashChunkSource.Factory factory, TransferListener transferListener2, DrmSessionManager drmSessionManager2, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, MediaSourceEventListener.EventDispatcher eventDispatcher2, long j, LoaderErrorThrower loaderErrorThrower, Allocator allocator2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2, PlayerEmsgHandler.PlayerEmsgCallback playerEmsgCallback) {
        this.id = i;
        this.manifest = dashManifest;
        this.periodIndex = i2;
        this.chunkSourceFactory = factory;
        this.transferListener = transferListener2;
        this.drmSessionManager = drmSessionManager2;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.eventDispatcher = eventDispatcher2;
        this.elapsedRealtimeOffsetMs = j;
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.allocator = allocator2;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory2;
        this.playerEmsgHandler = new PlayerEmsgHandler(dashManifest, playerEmsgCallback, allocator2);
        this.compositeSequenceableLoader = compositeSequenceableLoaderFactory2.createCompositeSequenceableLoader(this.sampleStreams);
        Period period = dashManifest.getPeriod(i2);
        this.eventStreams = period.eventStreams;
        Pair<TrackGroupArray, TrackGroupInfo[]> buildTrackGroups = buildTrackGroups(drmSessionManager2, period.adaptationSets, this.eventStreams);
        this.trackGroups = (TrackGroupArray) buildTrackGroups.first;
        this.trackGroupInfos = (TrackGroupInfo[]) buildTrackGroups.second;
        eventDispatcher2.mediaPeriodCreated();
    }

    public final void updateManifest(DashManifest dashManifest, int i) {
        this.manifest = dashManifest;
        this.periodIndex = i;
        this.playerEmsgHandler.updateManifest(dashManifest);
        ChunkSampleStream<DashChunkSource>[] chunkSampleStreamArr = this.sampleStreams;
        if (chunkSampleStreamArr != null) {
            for (ChunkSampleStream<DashChunkSource> chunkSource : chunkSampleStreamArr) {
                chunkSource.getChunkSource().updateManifest(dashManifest, i);
            }
            this.callback.onContinueLoadingRequested(this);
        }
        this.eventStreams = dashManifest.getPeriod(i).eventStreams;
        for (EventSampleStream eventSampleStream : this.eventSampleStreams) {
            Iterator<EventStream> it = this.eventStreams.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                EventStream next = it.next();
                if (next.id().equals(eventSampleStream.eventStreamId())) {
                    boolean z = true;
                    int periodCount = dashManifest.getPeriodCount() - 1;
                    if (!dashManifest.dynamic || i != periodCount) {
                        z = false;
                    }
                    eventSampleStream.updateEventStream(next, z);
                }
            }
        }
    }

    public final void release() {
        this.playerEmsgHandler.release();
        for (ChunkSampleStream<DashChunkSource> release : this.sampleStreams) {
            release.release(this);
        }
        this.callback = null;
        this.eventDispatcher.mediaPeriodReleased();
    }

    public final synchronized void onSampleStreamReleased(ChunkSampleStream<DashChunkSource> chunkSampleStream) {
        PlayerEmsgHandler.PlayerTrackEmsgHandler remove = this.trackEmsgHandlerBySampleStream.remove(chunkSampleStream);
        if (remove != null) {
            remove.release();
        }
    }

    public final void prepare(MediaPeriod.Callback callback2, long j) {
        this.callback = callback2;
        callback2.onPrepared(this);
    }

    public final void maybeThrowPrepareError() throws IOException {
        this.manifestLoaderErrorThrower.maybeThrowError();
    }

    public final TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    public final List<StreamKey> getStreamKeys(List<TrackSelection> list) {
        List<AdaptationSet> list2 = this.manifest.getPeriod(this.periodIndex).adaptationSets;
        ArrayList arrayList = new ArrayList();
        for (TrackSelection next : list) {
            TrackGroupInfo trackGroupInfo = this.trackGroupInfos[this.trackGroups.indexOf(next.getTrackGroup())];
            if (trackGroupInfo.trackGroupCategory == 0) {
                int[] iArr = trackGroupInfo.adaptationSetIndices;
                int[] iArr2 = new int[next.length()];
                for (int i = 0; i < next.length(); i++) {
                    iArr2[i] = next.getIndexInTrackGroup(i);
                }
                Arrays.sort(iArr2);
                int size = list2.get(iArr[0]).representations.size();
                int i2 = size;
                int i3 = 0;
                int i4 = 0;
                for (int i5 : iArr2) {
                    while (true) {
                        int i6 = i4 + i2;
                        if (i5 < i6) {
                            break;
                        }
                        i3++;
                        i2 = list2.get(iArr[i3]).representations.size();
                        i4 = i6;
                    }
                    arrayList.add(new StreamKey(this.periodIndex, iArr[i3], i5 - i4));
                }
            }
        }
        return arrayList;
    }

    public final long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        int[] streamIndexToTrackGroupIndex = getStreamIndexToTrackGroupIndex(trackSelectionArr);
        releaseDisabledStreams(trackSelectionArr, zArr, sampleStreamArr);
        releaseOrphanEmbeddedStreams(trackSelectionArr, sampleStreamArr, streamIndexToTrackGroupIndex);
        selectNewStreams(trackSelectionArr, sampleStreamArr, zArr2, j, streamIndexToTrackGroupIndex);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (SampleStream sampleStream : sampleStreamArr) {
            if (sampleStream instanceof ChunkSampleStream) {
                arrayList.add((ChunkSampleStream) sampleStream);
            } else if (sampleStream instanceof EventSampleStream) {
                arrayList2.add((EventSampleStream) sampleStream);
            }
        }
        this.sampleStreams = newSampleStreamArray(arrayList.size());
        arrayList.toArray(this.sampleStreams);
        this.eventSampleStreams = new EventSampleStream[arrayList2.size()];
        arrayList2.toArray(this.eventSampleStreams);
        this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(this.sampleStreams);
        return j;
    }

    public final void discardBuffer(long j, boolean z) {
        for (ChunkSampleStream<DashChunkSource> discardBuffer : this.sampleStreams) {
            discardBuffer.discardBuffer(j, z);
        }
    }

    public final void reevaluateBuffer(long j) {
        this.compositeSequenceableLoader.reevaluateBuffer(j);
    }

    public final boolean continueLoading(long j) {
        return this.compositeSequenceableLoader.continueLoading(j);
    }

    public final boolean isLoading() {
        return this.compositeSequenceableLoader.isLoading();
    }

    public final long getNextLoadPositionUs() {
        return this.compositeSequenceableLoader.getNextLoadPositionUs();
    }

    public final long readDiscontinuity() {
        if (this.notifiedReadingStarted) {
            return -9223372036854775807L;
        }
        this.eventDispatcher.readingStarted();
        this.notifiedReadingStarted = true;
        return -9223372036854775807L;
    }

    public final long getBufferedPositionUs() {
        return this.compositeSequenceableLoader.getBufferedPositionUs();
    }

    public final long seekToUs(long j) {
        for (ChunkSampleStream<DashChunkSource> seekToUs : this.sampleStreams) {
            seekToUs.seekToUs(j);
        }
        for (EventSampleStream seekToUs2 : this.eventSampleStreams) {
            seekToUs2.seekToUs(j);
        }
        return j;
    }

    public final long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.sampleStreams) {
            if (chunkSampleStream.primaryTrackType == 2) {
                return chunkSampleStream.getAdjustedSeekPositionUs(j, seekParameters);
            }
        }
        return j;
    }

    public final void onContinueLoadingRequested(ChunkSampleStream<DashChunkSource> chunkSampleStream) {
        this.callback.onContinueLoadingRequested(this);
    }

    private int[] getStreamIndexToTrackGroupIndex(TrackSelection[] trackSelectionArr) {
        int[] iArr = new int[trackSelectionArr.length];
        for (int i = 0; i < trackSelectionArr.length; i++) {
            if (trackSelectionArr[i] != null) {
                iArr[i] = this.trackGroups.indexOf(trackSelectionArr[i].getTrackGroup());
            } else {
                iArr[i] = -1;
            }
        }
        return iArr;
    }

    private void releaseDisabledStreams(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr) {
        for (int i = 0; i < trackSelectionArr.length; i++) {
            if (trackSelectionArr[i] == null || !zArr[i]) {
                if (sampleStreamArr[i] instanceof ChunkSampleStream) {
                    ((ChunkSampleStream) sampleStreamArr[i]).release(this);
                } else if (sampleStreamArr[i] instanceof ChunkSampleStream.EmbeddedSampleStream) {
                    ((ChunkSampleStream.EmbeddedSampleStream) sampleStreamArr[i]).release();
                }
                sampleStreamArr[i] = null;
            }
        }
    }

    private void releaseOrphanEmbeddedStreams(TrackSelection[] trackSelectionArr, SampleStream[] sampleStreamArr, int[] iArr) {
        boolean z;
        for (int i = 0; i < trackSelectionArr.length; i++) {
            if ((sampleStreamArr[i] instanceof EmptySampleStream) || (sampleStreamArr[i] instanceof ChunkSampleStream.EmbeddedSampleStream)) {
                int primaryStreamIndex = getPrimaryStreamIndex(i, iArr);
                if (primaryStreamIndex == -1) {
                    z = sampleStreamArr[i] instanceof EmptySampleStream;
                } else {
                    z = (sampleStreamArr[i] instanceof ChunkSampleStream.EmbeddedSampleStream) && ((ChunkSampleStream.EmbeddedSampleStream) sampleStreamArr[i]).parent == sampleStreamArr[primaryStreamIndex];
                }
                if (!z) {
                    if (sampleStreamArr[i] instanceof ChunkSampleStream.EmbeddedSampleStream) {
                        ((ChunkSampleStream.EmbeddedSampleStream) sampleStreamArr[i]).release();
                    }
                    sampleStreamArr[i] = null;
                }
            }
        }
    }

    private void selectNewStreams(TrackSelection[] trackSelectionArr, SampleStream[] sampleStreamArr, boolean[] zArr, long j, int[] iArr) {
        for (int i = 0; i < trackSelectionArr.length; i++) {
            TrackSelection trackSelection = trackSelectionArr[i];
            if (trackSelection != null) {
                if (sampleStreamArr[i] == null) {
                    zArr[i] = true;
                    TrackGroupInfo trackGroupInfo = this.trackGroupInfos[iArr[i]];
                    if (trackGroupInfo.trackGroupCategory == 0) {
                        sampleStreamArr[i] = buildSampleStream(trackGroupInfo, trackSelection, j);
                    } else if (trackGroupInfo.trackGroupCategory == 2) {
                        sampleStreamArr[i] = new EventSampleStream(this.eventStreams.get(trackGroupInfo.eventStreamGroupIndex), trackSelection.getTrackGroup().getFormat(0), this.manifest.dynamic);
                    }
                } else if (sampleStreamArr[i] instanceof ChunkSampleStream) {
                    ((DashChunkSource) ((ChunkSampleStream) sampleStreamArr[i]).getChunkSource()).updateTrackSelection(trackSelection);
                }
            }
        }
        for (int i2 = 0; i2 < trackSelectionArr.length; i2++) {
            if (sampleStreamArr[i2] == null && trackSelectionArr[i2] != null) {
                TrackGroupInfo trackGroupInfo2 = this.trackGroupInfos[iArr[i2]];
                if (trackGroupInfo2.trackGroupCategory == 1) {
                    int primaryStreamIndex = getPrimaryStreamIndex(i2, iArr);
                    if (primaryStreamIndex == -1) {
                        sampleStreamArr[i2] = new EmptySampleStream();
                    } else {
                        sampleStreamArr[i2] = ((ChunkSampleStream) sampleStreamArr[primaryStreamIndex]).selectEmbeddedTrack(j, trackGroupInfo2.trackType);
                    }
                }
            }
        }
    }

    private int getPrimaryStreamIndex(int i, int[] iArr) {
        int i2 = iArr[i];
        if (i2 == -1) {
            return -1;
        }
        int i3 = this.trackGroupInfos[i2].primaryTrackGroupIndex;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            int i5 = iArr[i4];
            if (i5 == i3 && this.trackGroupInfos[i5].trackGroupCategory == 0) {
                return i4;
            }
        }
        return -1;
    }

    private static Pair<TrackGroupArray, TrackGroupInfo[]> buildTrackGroups(DrmSessionManager drmSessionManager2, List<AdaptationSet> list, List<EventStream> list2) {
        int[][] groupedAdaptationSetIndices = getGroupedAdaptationSetIndices(list);
        int length = groupedAdaptationSetIndices.length;
        boolean[] zArr = new boolean[length];
        Format[][] formatArr = new Format[length][];
        int identifyEmbeddedTracks = identifyEmbeddedTracks(length, list, groupedAdaptationSetIndices, zArr, formatArr) + length + list2.size();
        TrackGroup[] trackGroupArr = new TrackGroup[identifyEmbeddedTracks];
        TrackGroupInfo[] trackGroupInfoArr = new TrackGroupInfo[identifyEmbeddedTracks];
        buildManifestEventTrackGroupInfos(list2, trackGroupArr, trackGroupInfoArr, buildPrimaryAndEmbeddedTrackGroupInfos(drmSessionManager2, list, groupedAdaptationSetIndices, length, zArr, formatArr, trackGroupArr, trackGroupInfoArr));
        return Pair.create(new TrackGroupArray(trackGroupArr), trackGroupInfoArr);
    }

    private static int[][] getGroupedAdaptationSetIndices(List<AdaptationSet> list) {
        int size = list.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        for (int i = 0; i < size; i++) {
            sparseIntArray.put(list.get(i).id, i);
        }
        int[][] iArr = new int[size][];
        boolean[] zArr = new boolean[size];
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (!zArr[i3]) {
                zArr[i3] = true;
                Descriptor findAdaptationSetSwitchingProperty = findAdaptationSetSwitchingProperty(list.get(i3).supplementalProperties);
                if (findAdaptationSetSwitchingProperty == null) {
                    iArr[i2] = new int[]{i3};
                    i2++;
                } else {
                    String[] split = Util.split(findAdaptationSetSwitchingProperty.value, ",");
                    int[] iArr2 = new int[(split.length + 1)];
                    iArr2[0] = i3;
                    int i4 = 1;
                    for (String parseInt : split) {
                        int i5 = sparseIntArray.get(Integer.parseInt(parseInt), -1);
                        if (i5 != -1) {
                            zArr[i5] = true;
                            iArr2[i4] = i5;
                            i4++;
                        }
                    }
                    if (i4 < iArr2.length) {
                        iArr2 = Arrays.copyOf(iArr2, i4);
                    }
                    iArr[i2] = iArr2;
                    i2++;
                }
            }
        }
        return i2 < size ? (int[][]) Arrays.copyOf(iArr, i2) : iArr;
    }

    private static int identifyEmbeddedTracks(int i, List<AdaptationSet> list, int[][] iArr, boolean[] zArr, Format[][] formatArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (hasEventMessageTrack(list, iArr[i3])) {
                zArr[i3] = true;
                i2++;
            }
            formatArr[i3] = getCea608TrackFormats(list, iArr[i3]);
            if (formatArr[i3].length != 0) {
                i2++;
            }
        }
        return i2;
    }

    private static int buildPrimaryAndEmbeddedTrackGroupInfos(DrmSessionManager drmSessionManager2, List<AdaptationSet> list, int[][] iArr, int i, boolean[] zArr, Format[][] formatArr, TrackGroup[] trackGroupArr, TrackGroupInfo[] trackGroupInfoArr) {
        int i2;
        int i3;
        int i4 = i;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i4) {
            int[] iArr2 = iArr[i5];
            ArrayList arrayList = new ArrayList();
            for (int i7 : iArr2) {
                arrayList.addAll(list.get(i7).representations);
            }
            Format[] formatArr2 = new Format[arrayList.size()];
            for (int i8 = 0; i8 < formatArr2.length; i8++) {
                Format format = ((Representation) arrayList.get(i8)).format;
                DrmInitData drmInitData = format.drmInitData;
                if (drmInitData != null) {
                    format = format.copyWithExoMediaCryptoType(drmSessionManager2.getExoMediaCryptoType(drmInitData));
                }
                formatArr2[i8] = format;
            }
            AdaptationSet adaptationSet = list.get(iArr2[0]);
            int i9 = i6 + 1;
            if (zArr[i5]) {
                i2 = i9 + 1;
            } else {
                i2 = i9;
                i9 = -1;
            }
            if (formatArr[i5].length != 0) {
                i3 = i2 + 1;
            } else {
                i3 = i2;
                i2 = -1;
            }
            trackGroupArr[i6] = new TrackGroup(formatArr2);
            trackGroupInfoArr[i6] = TrackGroupInfo.primaryTrack(adaptationSet.type, iArr2, i6, i9, i2);
            if (i9 != -1) {
                trackGroupArr[i9] = new TrackGroup(new Format.Builder().setId(adaptationSet.id + ":emsg").setSampleMimeType("application/x-emsg").build());
                trackGroupInfoArr[i9] = TrackGroupInfo.embeddedEmsgTrack(iArr2, i6);
            }
            if (i2 != -1) {
                trackGroupArr[i2] = new TrackGroup(formatArr[i5]);
                trackGroupInfoArr[i2] = TrackGroupInfo.embeddedCea608Track(iArr2, i6);
            }
            i5++;
            i6 = i3;
        }
        return i6;
    }

    private static void buildManifestEventTrackGroupInfos(List<EventStream> list, TrackGroup[] trackGroupArr, TrackGroupInfo[] trackGroupInfoArr, int i) {
        int i2 = i;
        int i3 = 0;
        while (i3 < list.size()) {
            trackGroupArr[i2] = new TrackGroup(new Format.Builder().setId(list.get(i3).id()).setSampleMimeType("application/x-emsg").build());
            trackGroupInfoArr[i2] = TrackGroupInfo.mpdEventTrack(i3);
            i3++;
            i2++;
        }
    }

    private ChunkSampleStream<DashChunkSource> buildSampleStream(TrackGroupInfo trackGroupInfo, TrackSelection trackSelection, long j) {
        TrackGroup trackGroup;
        int i;
        TrackGroup trackGroup2;
        int i2;
        TrackGroupInfo trackGroupInfo2 = trackGroupInfo;
        boolean z = trackGroupInfo2.embeddedEventMessageTrackGroupIndex != -1;
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = null;
        if (z) {
            trackGroup = this.trackGroups.get(trackGroupInfo2.embeddedEventMessageTrackGroupIndex);
            i = 1;
        } else {
            trackGroup = null;
            i = 0;
        }
        boolean z2 = trackGroupInfo2.embeddedCea608TrackGroupIndex != -1;
        if (z2) {
            trackGroup2 = this.trackGroups.get(trackGroupInfo2.embeddedCea608TrackGroupIndex);
            i += trackGroup2.length;
        } else {
            trackGroup2 = null;
        }
        Format[] formatArr = new Format[i];
        int[] iArr = new int[i];
        if (z) {
            formatArr[0] = trackGroup.getFormat(0);
            iArr[0] = 4;
            i2 = 1;
        } else {
            i2 = 0;
        }
        ArrayList arrayList = new ArrayList();
        if (z2) {
            for (int i3 = 0; i3 < trackGroup2.length; i3++) {
                formatArr[i2] = trackGroup2.getFormat(i3);
                iArr[i2] = 3;
                arrayList.add(formatArr[i2]);
                i2++;
            }
        }
        if (this.manifest.dynamic && z) {
            playerTrackEmsgHandler = this.playerEmsgHandler.newPlayerTrackEmsgHandler();
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2 = playerTrackEmsgHandler;
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler3 = playerTrackEmsgHandler2;
        ChunkSampleStream chunkSampleStream = new ChunkSampleStream(trackGroupInfo2.trackType, iArr, formatArr, this.chunkSourceFactory.createDashChunkSource(this.manifestLoaderErrorThrower, this.manifest, this.periodIndex, trackGroupInfo2.adaptationSetIndices, trackSelection, trackGroupInfo2.trackType, this.elapsedRealtimeOffsetMs, z, arrayList, playerTrackEmsgHandler2, this.transferListener), this, this.allocator, j, this.drmSessionManager, this.loadErrorHandlingPolicy, this.eventDispatcher);
        synchronized (this) {
            this.trackEmsgHandlerBySampleStream.put(chunkSampleStream, playerTrackEmsgHandler3);
        }
        return chunkSampleStream;
    }

    private static Descriptor findAdaptationSetSwitchingProperty(List<Descriptor> list) {
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = list.get(i);
            if ("urn:mpeg:dash:adaptation-set-switching:2016".equals(descriptor.schemeIdUri)) {
                return descriptor;
            }
        }
        return null;
    }

    private static boolean hasEventMessageTrack(List<AdaptationSet> list, int[] iArr) {
        for (int i : iArr) {
            List<Representation> list2 = list.get(i).representations;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (!list2.get(i2).inbandEventStreams.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Format[] getCea608TrackFormats(List<AdaptationSet> list, int[] iArr) {
        for (int i : iArr) {
            AdaptationSet adaptationSet = list.get(i);
            List<Descriptor> list2 = list.get(i).accessibilityDescriptors;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                Descriptor descriptor = list2.get(i2);
                if ("urn:scte:dash:cc:cea-608:2015".equals(descriptor.schemeIdUri)) {
                    String str = descriptor.value;
                    if (str == null) {
                        return new Format[]{buildCea608TrackFormat(adaptationSet.id)};
                    }
                    String[] split = Util.split(str, ";");
                    Format[] formatArr = new Format[split.length];
                    for (int i3 = 0; i3 < split.length; i3++) {
                        Matcher matcher = CEA608_SERVICE_DESCRIPTOR_REGEX.matcher(split[i3]);
                        if (!matcher.matches()) {
                            return new Format[]{buildCea608TrackFormat(adaptationSet.id)};
                        }
                        formatArr[i3] = buildCea608TrackFormat(adaptationSet.id, matcher.group(2), Integer.parseInt(matcher.group(1)));
                    }
                    return formatArr;
                }
            }
        }
        return new Format[0];
    }

    private static Format buildCea608TrackFormat(int i) {
        return buildCea608TrackFormat(i, null, -1);
    }

    private static Format buildCea608TrackFormat(int i, String str, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(":cea608");
        sb.append(i2 != -1 ? ":".concat(String.valueOf(i2)) : "");
        return new Format.Builder().setId(sb.toString()).setSampleMimeType("application/cea-608").setLanguage(str).setAccessibilityChannel(i2).build();
    }

    private static ChunkSampleStream<DashChunkSource>[] newSampleStreamArray(int i) {
        return new ChunkSampleStream[i];
    }

    static final class TrackGroupInfo {
        public final int[] adaptationSetIndices;
        public final int embeddedCea608TrackGroupIndex;
        public final int embeddedEventMessageTrackGroupIndex;
        public final int eventStreamGroupIndex;
        public final int primaryTrackGroupIndex;
        public final int trackGroupCategory;
        public final int trackType;

        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface TrackGroupCategory {
        }

        public static TrackGroupInfo primaryTrack(int i, int[] iArr, int i2, int i3, int i4) {
            return new TrackGroupInfo(i, 0, iArr, i2, i3, i4, -1);
        }

        public static TrackGroupInfo embeddedEmsgTrack(int[] iArr, int i) {
            return new TrackGroupInfo(4, 1, iArr, i, -1, -1, -1);
        }

        public static TrackGroupInfo embeddedCea608Track(int[] iArr, int i) {
            return new TrackGroupInfo(3, 1, iArr, i, -1, -1, -1);
        }

        public static TrackGroupInfo mpdEventTrack(int i) {
            return new TrackGroupInfo(4, 2, new int[0], -1, -1, -1, i);
        }

        private TrackGroupInfo(int i, int i2, int[] iArr, int i3, int i4, int i5, int i6) {
            this.trackType = i;
            this.adaptationSetIndices = iArr;
            this.trackGroupCategory = i2;
            this.primaryTrackGroupIndex = i3;
            this.embeddedEventMessageTrackGroupIndex = i4;
            this.embeddedCea608TrackGroupIndex = i5;
            this.eventStreamGroupIndex = i6;
        }
    }
}
