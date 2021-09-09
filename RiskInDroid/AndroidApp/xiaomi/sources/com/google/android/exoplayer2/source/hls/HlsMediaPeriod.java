package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public final class HlsMediaPeriod implements MediaPeriod, HlsSampleStreamWrapper.Callback, HlsPlaylistTracker.PlaylistEventListener {
    private final Allocator allocator;
    private final boolean allowChunklessPreparation;
    private MediaPeriod.Callback callback;
    private SequenceableLoader compositeSequenceableLoader;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final HlsDataSourceFactory dataSourceFactory;
    private final DrmSessionManager drmSessionManager;
    private HlsSampleStreamWrapper[] enabledSampleStreamWrappers = new HlsSampleStreamWrapper[0];
    private final MediaSourceEventListener.EventDispatcher eventDispatcher;
    private final HlsExtractorFactory extractorFactory;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private int[][] manifestUrlIndicesPerWrapper = new int[0][];
    private final TransferListener mediaTransferListener;
    private final int metadataType;
    private boolean notifiedReadingStarted;
    private int pendingPrepareCount;
    private final HlsPlaylistTracker playlistTracker;
    private HlsSampleStreamWrapper[] sampleStreamWrappers = new HlsSampleStreamWrapper[0];
    private final IdentityHashMap<SampleStream, Integer> streamWrapperIndices = new IdentityHashMap<>();
    private final TimestampAdjusterProvider timestampAdjusterProvider = new TimestampAdjusterProvider();
    private TrackGroupArray trackGroups;
    private final boolean useSessionKeys;

    public final long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        return j;
    }

    public HlsMediaPeriod(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, HlsDataSourceFactory hlsDataSourceFactory, TransferListener transferListener, DrmSessionManager drmSessionManager2, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, MediaSourceEventListener.EventDispatcher eventDispatcher2, Allocator allocator2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2, boolean z, int i, boolean z2) {
        this.extractorFactory = hlsExtractorFactory;
        this.playlistTracker = hlsPlaylistTracker;
        this.dataSourceFactory = hlsDataSourceFactory;
        this.mediaTransferListener = transferListener;
        this.drmSessionManager = drmSessionManager2;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.eventDispatcher = eventDispatcher2;
        this.allocator = allocator2;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory2;
        this.allowChunklessPreparation = z;
        this.metadataType = i;
        this.useSessionKeys = z2;
        this.compositeSequenceableLoader = compositeSequenceableLoaderFactory2.createCompositeSequenceableLoader(new SequenceableLoader[0]);
        eventDispatcher2.mediaPeriodCreated();
    }

    public final void release() {
        this.playlistTracker.removeListener(this);
        for (HlsSampleStreamWrapper release : this.sampleStreamWrappers) {
            release.release();
        }
        this.callback = null;
        this.eventDispatcher.mediaPeriodReleased();
    }

    public final void prepare(MediaPeriod.Callback callback2, long j) {
        this.callback = callback2;
        this.playlistTracker.addListener(this);
        buildAndPrepareSampleStreamWrappers(j);
    }

    public final void maybeThrowPrepareError() throws IOException {
        for (HlsSampleStreamWrapper maybeThrowPrepareError : this.sampleStreamWrappers) {
            maybeThrowPrepareError.maybeThrowPrepareError();
        }
    }

    public final TrackGroupArray getTrackGroups() {
        return (TrackGroupArray) Assertions.checkNotNull(this.trackGroups);
    }

    public final List<StreamKey> getStreamKeys(List<TrackSelection> list) {
        TrackGroupArray trackGroupArray;
        int[] iArr;
        int i;
        HlsMediaPeriod hlsMediaPeriod = this;
        HlsMasterPlaylist hlsMasterPlaylist = (HlsMasterPlaylist) Assertions.checkNotNull(hlsMediaPeriod.playlistTracker.getMasterPlaylist());
        boolean z = !hlsMasterPlaylist.variants.isEmpty();
        int i2 = 0;
        int i3 = z ? 1 : 0;
        int length = hlsMediaPeriod.sampleStreamWrappers.length - hlsMasterPlaylist.subtitles.size();
        if (z) {
            HlsSampleStreamWrapper hlsSampleStreamWrapper = hlsMediaPeriod.sampleStreamWrappers[0];
            iArr = hlsMediaPeriod.manifestUrlIndicesPerWrapper[0];
            trackGroupArray = hlsSampleStreamWrapper.getTrackGroups();
            i = hlsSampleStreamWrapper.getPrimaryTrackGroupIndex();
        } else {
            iArr = new int[0];
            trackGroupArray = TrackGroupArray.EMPTY;
            i = 0;
        }
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        boolean z3 = false;
        for (TrackSelection next : list) {
            TrackGroup trackGroup = next.getTrackGroup();
            int indexOf = trackGroupArray.indexOf(trackGroup);
            if (indexOf == -1) {
                int i4 = i3;
                while (true) {
                    HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = hlsMediaPeriod.sampleStreamWrappers;
                    if (i4 >= hlsSampleStreamWrapperArr.length) {
                        break;
                    } else if (hlsSampleStreamWrapperArr[i4].getTrackGroups().indexOf(trackGroup) != -1) {
                        int i5 = i4 < length ? 1 : 2;
                        int[] iArr2 = hlsMediaPeriod.manifestUrlIndicesPerWrapper[i4];
                        for (int i6 = 0; i6 < next.length(); i6++) {
                            arrayList.add(new StreamKey(i5, iArr2[next.getIndexInTrackGroup(i6)]));
                        }
                    } else {
                        i4++;
                        hlsMediaPeriod = this;
                    }
                }
                i2 = 0;
                hlsMediaPeriod = this;
            } else if (indexOf == i) {
                for (int i7 = 0; i7 < next.length(); i7++) {
                    arrayList.add(new StreamKey(i2, iArr[next.getIndexInTrackGroup(i7)]));
                }
                z3 = true;
            } else {
                z2 = true;
            }
        }
        if (z2 && !z3) {
            int i8 = iArr[0];
            int i9 = hlsMasterPlaylist.variants.get(iArr[0]).format.bitrate;
            for (int i10 = 1; i10 < iArr.length; i10++) {
                int i11 = hlsMasterPlaylist.variants.get(iArr[i10]).format.bitrate;
                if (i11 < i9) {
                    i8 = iArr[i10];
                    i9 = i11;
                }
            }
            arrayList.add(new StreamKey(0, i8));
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00df, code lost:
        if (r5 != r8[0]) goto L_0x00e3;
     */
    public final long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        int i;
        TrackSelection[] trackSelectionArr2 = trackSelectionArr;
        SampleStream[] sampleStreamArr2 = sampleStreamArr;
        int[] iArr = new int[trackSelectionArr2.length];
        int[] iArr2 = new int[trackSelectionArr2.length];
        for (int i2 = 0; i2 < trackSelectionArr2.length; i2++) {
            if (sampleStreamArr2[i2] == null) {
                i = -1;
            } else {
                i = this.streamWrapperIndices.get(sampleStreamArr2[i2]).intValue();
            }
            iArr[i2] = i;
            iArr2[i2] = -1;
            if (trackSelectionArr2[i2] != null) {
                TrackGroup trackGroup = trackSelectionArr2[i2].getTrackGroup();
                int i3 = 0;
                while (true) {
                    HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.sampleStreamWrappers;
                    if (i3 >= hlsSampleStreamWrapperArr.length) {
                        break;
                    } else if (hlsSampleStreamWrapperArr[i3].getTrackGroups().indexOf(trackGroup) != -1) {
                        iArr2[i2] = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        this.streamWrapperIndices.clear();
        SampleStream[] sampleStreamArr3 = new SampleStream[trackSelectionArr2.length];
        SampleStream[] sampleStreamArr4 = new SampleStream[trackSelectionArr2.length];
        TrackSelection[] trackSelectionArr3 = new TrackSelection[trackSelectionArr2.length];
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = new HlsSampleStreamWrapper[this.sampleStreamWrappers.length];
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        while (i5 < this.sampleStreamWrappers.length) {
            for (int i6 = 0; i6 < trackSelectionArr2.length; i6++) {
                TrackSelection trackSelection = null;
                sampleStreamArr4[i6] = iArr[i6] == i5 ? sampleStreamArr2[i6] : null;
                if (iArr2[i6] == i5) {
                    trackSelection = trackSelectionArr2[i6];
                }
                trackSelectionArr3[i6] = trackSelection;
            }
            HlsSampleStreamWrapper hlsSampleStreamWrapper = this.sampleStreamWrappers[i5];
            HlsSampleStreamWrapper hlsSampleStreamWrapper2 = hlsSampleStreamWrapper;
            int i7 = i4;
            HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr3 = hlsSampleStreamWrapperArr2;
            int i8 = i5;
            TrackSelection[] trackSelectionArr4 = trackSelectionArr3;
            boolean selectTracks = hlsSampleStreamWrapper.selectTracks(trackSelectionArr3, zArr, sampleStreamArr4, zArr2, j, z);
            int i9 = 0;
            boolean z2 = false;
            while (true) {
                boolean z3 = true;
                if (i9 >= trackSelectionArr2.length) {
                    break;
                }
                SampleStream sampleStream = sampleStreamArr4[i9];
                if (iArr2[i9] == i8) {
                    Assertions.checkNotNull(sampleStream);
                    sampleStreamArr3[i9] = sampleStream;
                    this.streamWrapperIndices.put(sampleStream, Integer.valueOf(i8));
                    z2 = true;
                } else if (iArr[i9] == i8) {
                    if (sampleStream != null) {
                        z3 = false;
                    }
                    Assertions.checkState(z3);
                }
                i9++;
            }
            if (z2) {
                hlsSampleStreamWrapperArr3[i7] = hlsSampleStreamWrapper2;
                int i10 = i7 + 1;
                if (i7 == 0) {
                    hlsSampleStreamWrapper2.setIsTimestampMaster(true);
                    if (!selectTracks) {
                        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr4 = this.enabledSampleStreamWrappers;
                        if (hlsSampleStreamWrapperArr4.length != 0) {
                        }
                    }
                    this.timestampAdjusterProvider.reset();
                    i4 = i10;
                    z = true;
                } else {
                    hlsSampleStreamWrapper2.setIsTimestampMaster(false);
                }
                i4 = i10;
            } else {
                i4 = i7;
            }
            i5 = i8 + 1;
            sampleStreamArr2 = sampleStreamArr;
            hlsSampleStreamWrapperArr2 = hlsSampleStreamWrapperArr3;
            trackSelectionArr3 = trackSelectionArr4;
        }
        System.arraycopy(sampleStreamArr3, 0, sampleStreamArr, 0, sampleStreamArr3.length);
        this.enabledSampleStreamWrappers = (HlsSampleStreamWrapper[]) Util.nullSafeArrayCopy(hlsSampleStreamWrapperArr2, i4);
        this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(this.enabledSampleStreamWrappers);
        return j;
    }

    public final void discardBuffer(long j, boolean z) {
        for (HlsSampleStreamWrapper discardBuffer : this.enabledSampleStreamWrappers) {
            discardBuffer.discardBuffer(j, z);
        }
    }

    public final void reevaluateBuffer(long j) {
        this.compositeSequenceableLoader.reevaluateBuffer(j);
    }

    public final boolean continueLoading(long j) {
        if (this.trackGroups != null) {
            return this.compositeSequenceableLoader.continueLoading(j);
        }
        for (HlsSampleStreamWrapper continuePreparing : this.sampleStreamWrappers) {
            continuePreparing.continuePreparing();
        }
        return false;
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
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.enabledSampleStreamWrappers;
        if (hlsSampleStreamWrapperArr.length > 0) {
            boolean seekToUs = hlsSampleStreamWrapperArr[0].seekToUs(j, false);
            int i = 1;
            while (true) {
                HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = this.enabledSampleStreamWrappers;
                if (i >= hlsSampleStreamWrapperArr2.length) {
                    break;
                }
                hlsSampleStreamWrapperArr2[i].seekToUs(j, seekToUs);
                i++;
            }
            if (seekToUs) {
                this.timestampAdjusterProvider.reset();
            }
        }
        return j;
    }

    public final void onPrepared() {
        int i = this.pendingPrepareCount - 1;
        this.pendingPrepareCount = i;
        if (i <= 0) {
            int i2 = 0;
            for (HlsSampleStreamWrapper trackGroups2 : this.sampleStreamWrappers) {
                i2 += trackGroups2.getTrackGroups().length;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i2];
            HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.sampleStreamWrappers;
            int length = hlsSampleStreamWrapperArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                HlsSampleStreamWrapper hlsSampleStreamWrapper = hlsSampleStreamWrapperArr[i3];
                int i5 = hlsSampleStreamWrapper.getTrackGroups().length;
                int i6 = i4;
                int i7 = 0;
                while (i7 < i5) {
                    trackGroupArr[i6] = hlsSampleStreamWrapper.getTrackGroups().get(i7);
                    i7++;
                    i6++;
                }
                i3++;
                i4 = i6;
            }
            this.trackGroups = new TrackGroupArray(trackGroupArr);
            this.callback.onPrepared(this);
        }
    }

    public final void onPlaylistRefreshRequired(Uri uri) {
        this.playlistTracker.refreshPlaylist(uri);
    }

    public final void onContinueLoadingRequested(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
        this.callback.onContinueLoadingRequested(this);
    }

    public final void onPlaylistChanged() {
        this.callback.onContinueLoadingRequested(this);
    }

    public final boolean onPlaylistError(Uri uri, long j) {
        boolean z = true;
        for (HlsSampleStreamWrapper onPlaylistError : this.sampleStreamWrappers) {
            z &= onPlaylistError.onPlaylistError(uri, j);
        }
        this.callback.onContinueLoadingRequested(this);
        return z;
    }

    private void buildAndPrepareSampleStreamWrappers(long j) {
        Map<String, DrmInitData> map;
        HlsMasterPlaylist hlsMasterPlaylist = (HlsMasterPlaylist) Assertions.checkNotNull(this.playlistTracker.getMasterPlaylist());
        if (this.useSessionKeys) {
            map = deriveOverridingDrmInitData(hlsMasterPlaylist.sessionKeyDrmInitData);
        } else {
            map = Collections.emptyMap();
        }
        Map<String, DrmInitData> map2 = map;
        boolean z = !hlsMasterPlaylist.variants.isEmpty();
        List<HlsMasterPlaylist.Rendition> list = hlsMasterPlaylist.audios;
        List<HlsMasterPlaylist.Rendition> list2 = hlsMasterPlaylist.subtitles;
        this.pendingPrepareCount = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z) {
            buildAndPrepareMainSampleStreamWrapper(hlsMasterPlaylist, j, arrayList, arrayList2, map2);
        }
        buildAndPrepareAudioSampleStreamWrappers(j, list, arrayList, arrayList2, map2);
        int i = 0;
        while (i < list2.size()) {
            HlsMasterPlaylist.Rendition rendition = list2.get(i);
            int i2 = i;
            HlsSampleStreamWrapper buildSampleStreamWrapper = buildSampleStreamWrapper(3, new Uri[]{rendition.url}, new Format[]{rendition.format}, null, Collections.emptyList(), map2, j);
            arrayList2.add(new int[]{i2});
            arrayList.add(buildSampleStreamWrapper);
            buildSampleStreamWrapper.prepareWithMasterPlaylistInfo(new TrackGroup[]{new TrackGroup(rendition.format)}, 0, new int[0]);
            i = i2 + 1;
        }
        this.sampleStreamWrappers = (HlsSampleStreamWrapper[]) arrayList.toArray(new HlsSampleStreamWrapper[0]);
        this.manifestUrlIndicesPerWrapper = (int[][]) arrayList2.toArray(new int[0][]);
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.sampleStreamWrappers;
        this.pendingPrepareCount = hlsSampleStreamWrapperArr.length;
        hlsSampleStreamWrapperArr[0].setIsTimestampMaster(true);
        for (HlsSampleStreamWrapper continuePreparing : this.sampleStreamWrappers) {
            continuePreparing.continuePreparing();
        }
        this.enabledSampleStreamWrappers = this.sampleStreamWrappers;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0066 A[ADDED_TO_REGION] */
    private void buildAndPrepareMainSampleStreamWrapper(HlsMasterPlaylist hlsMasterPlaylist, long j, List<HlsSampleStreamWrapper> list, List<int[]> list2, Map<String, DrmInitData> map) {
        boolean z;
        boolean z2;
        int i;
        HlsMasterPlaylist hlsMasterPlaylist2 = hlsMasterPlaylist;
        int[] iArr = new int[hlsMasterPlaylist2.variants.size()];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < hlsMasterPlaylist2.variants.size(); i4++) {
            Format format = hlsMasterPlaylist2.variants.get(i4).format;
            if (format.height > 0 || Util.getCodecsOfType(format.codecs, 2) != null) {
                iArr[i4] = 2;
                i2++;
            } else if (Util.getCodecsOfType(format.codecs, 1) != null) {
                iArr[i4] = 1;
                i3++;
            } else {
                iArr[i4] = -1;
            }
        }
        int length = iArr.length;
        if (i2 > 0) {
            z2 = true;
        } else if (i3 < length) {
            i2 = length - i3;
            z2 = false;
            z = true;
            Uri[] uriArr = new Uri[i2];
            Format[] formatArr = new Format[i2];
            int[] iArr2 = new int[i2];
            int i5 = 0;
            for (i = 0; i < hlsMasterPlaylist2.variants.size(); i++) {
                if ((!z2 || iArr[i] == 2) && (!z || iArr[i] != 1)) {
                    HlsMasterPlaylist.Variant variant = hlsMasterPlaylist2.variants.get(i);
                    uriArr[i5] = variant.url;
                    formatArr[i5] = variant.format;
                    iArr2[i5] = i;
                    i5++;
                }
            }
            String str = formatArr[0].codecs;
            HlsSampleStreamWrapper buildSampleStreamWrapper = buildSampleStreamWrapper(0, uriArr, formatArr, hlsMasterPlaylist2.muxedAudioFormat, hlsMasterPlaylist2.muxedCaptionFormats, map, j);
            list.add(buildSampleStreamWrapper);
            list2.add(iArr2);
            if (this.allowChunklessPreparation && str != null) {
                boolean z3 = Util.getCodecsOfType(str, 2) != null;
                boolean z4 = Util.getCodecsOfType(str, 1) != null;
                ArrayList arrayList = new ArrayList();
                if (z3) {
                    Format[] formatArr2 = new Format[i2];
                    for (int i6 = 0; i6 < formatArr2.length; i6++) {
                        formatArr2[i6] = deriveVideoFormat(formatArr[i6]);
                    }
                    arrayList.add(new TrackGroup(formatArr2));
                    if (z4 && (hlsMasterPlaylist2.muxedAudioFormat != null || hlsMasterPlaylist2.audios.isEmpty())) {
                        arrayList.add(new TrackGroup(deriveAudioFormat(formatArr[0], hlsMasterPlaylist2.muxedAudioFormat, false)));
                    }
                    List<Format> list3 = hlsMasterPlaylist2.muxedCaptionFormats;
                    if (list3 != null) {
                        for (int i7 = 0; i7 < list3.size(); i7++) {
                            arrayList.add(new TrackGroup(list3.get(i7)));
                        }
                    }
                } else if (z4) {
                    Format[] formatArr3 = new Format[i2];
                    for (int i8 = 0; i8 < formatArr3.length; i8++) {
                        formatArr3[i8] = deriveAudioFormat(formatArr[i8], hlsMasterPlaylist2.muxedAudioFormat, true);
                    }
                    arrayList.add(new TrackGroup(formatArr3));
                } else {
                    throw new IllegalArgumentException("Unexpected codecs attribute: ".concat(String.valueOf(str)));
                }
                TrackGroup trackGroup = new TrackGroup(new Format.Builder().setId("ID3").setSampleMimeType("application/id3").build());
                arrayList.add(trackGroup);
                buildSampleStreamWrapper.prepareWithMasterPlaylistInfo((TrackGroup[]) arrayList.toArray(new TrackGroup[0]), 0, arrayList.indexOf(trackGroup));
                return;
            }
        } else {
            i2 = length;
            z2 = false;
        }
        z = false;
        Uri[] uriArr2 = new Uri[i2];
        Format[] formatArr4 = new Format[i2];
        int[] iArr22 = new int[i2];
        int i52 = 0;
        while (i < hlsMasterPlaylist2.variants.size()) {
        }
        String str2 = formatArr4[0].codecs;
        HlsSampleStreamWrapper buildSampleStreamWrapper2 = buildSampleStreamWrapper(0, uriArr2, formatArr4, hlsMasterPlaylist2.muxedAudioFormat, hlsMasterPlaylist2.muxedCaptionFormats, map, j);
        list.add(buildSampleStreamWrapper2);
        list2.add(iArr22);
        if (this.allowChunklessPreparation) {
        }
    }

    private void buildAndPrepareAudioSampleStreamWrappers(long j, List<HlsMasterPlaylist.Rendition> list, List<HlsSampleStreamWrapper> list2, List<int[]> list3, Map<String, DrmInitData> map) {
        List<HlsMasterPlaylist.Rendition> list4 = list;
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        ArrayList arrayList3 = new ArrayList(list.size());
        HashSet hashSet = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            String str = list4.get(i).name;
            if (hashSet.add(str)) {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                boolean z = true;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (Util.areEqual(str, list4.get(i2).name)) {
                        HlsMasterPlaylist.Rendition rendition = list4.get(i2);
                        arrayList3.add(Integer.valueOf(i2));
                        arrayList.add(rendition.url);
                        arrayList2.add(rendition.format);
                        z &= rendition.format.codecs != null;
                    }
                }
                HlsSampleStreamWrapper buildSampleStreamWrapper = buildSampleStreamWrapper(1, (Uri[]) arrayList.toArray(Util.castNonNullTypeArray(new Uri[0])), (Format[]) arrayList2.toArray(new Format[0]), null, Collections.emptyList(), map, j);
                list3.add(Util.toArray(arrayList3));
                list2.add(buildSampleStreamWrapper);
                if (this.allowChunklessPreparation && z) {
                    buildSampleStreamWrapper.prepareWithMasterPlaylistInfo(new TrackGroup[]{new TrackGroup((Format[]) arrayList2.toArray(new Format[0]))}, 0, new int[0]);
                }
            }
        }
    }

    private HlsSampleStreamWrapper buildSampleStreamWrapper(int i, Uri[] uriArr, Format[] formatArr, Format format, List<Format> list, Map<String, DrmInitData> map, long j) {
        return new HlsSampleStreamWrapper(i, this, new HlsChunkSource(this.extractorFactory, this.playlistTracker, uriArr, formatArr, this.dataSourceFactory, this.mediaTransferListener, this.timestampAdjusterProvider, list), map, this.allocator, j, format, this.drmSessionManager, this.loadErrorHandlingPolicy, this.eventDispatcher, this.metadataType);
    }

    private static Map<String, DrmInitData> deriveOverridingDrmInitData(List<DrmInitData> list) {
        ArrayList arrayList = new ArrayList(list);
        HashMap hashMap = new HashMap();
        int i = 0;
        while (i < arrayList.size()) {
            DrmInitData drmInitData = list.get(i);
            String str = drmInitData.schemeType;
            i++;
            DrmInitData drmInitData2 = drmInitData;
            int i2 = i;
            while (i2 < arrayList.size()) {
                DrmInitData drmInitData3 = (DrmInitData) arrayList.get(i2);
                if (TextUtils.equals(drmInitData3.schemeType, str)) {
                    drmInitData2 = drmInitData2.merge(drmInitData3);
                    arrayList.remove(i2);
                } else {
                    i2++;
                }
            }
            hashMap.put(str, drmInitData2);
        }
        return hashMap;
    }

    private static Format deriveVideoFormat(Format format) {
        String codecsOfType = Util.getCodecsOfType(format.codecs, 2);
        return new Format.Builder().setId(format.id).setLabel(format.label).setContainerMimeType(format.containerMimeType).setSampleMimeType(MimeTypes.getMediaMimeType(codecsOfType)).setCodecs(codecsOfType).setMetadata(format.metadata).setAverageBitrate(format.averageBitrate).setPeakBitrate(format.peakBitrate).setWidth(format.width).setHeight(format.height).setFrameRate(format.frameRate).setSelectionFlags(format.selectionFlags).setRoleFlags(format.roleFlags).build();
    }

    private static Format deriveAudioFormat(Format format, Format format2, boolean z) {
        String str;
        String str2;
        int i;
        int i2;
        Metadata metadata;
        int i3;
        String str3 = null;
        int i4 = -1;
        if (format2 != null) {
            String str4 = format2.codecs;
            Metadata metadata2 = format2.metadata;
            int i5 = format2.channelCount;
            i2 = format2.selectionFlags;
            i = format2.roleFlags;
            str2 = format2.language;
            String str5 = str4;
            str3 = format2.label;
            str = str5;
            int i6 = i5;
            metadata = metadata2;
            i3 = i6;
        } else {
            str = Util.getCodecsOfType(format.codecs, 1);
            metadata = format.metadata;
            if (z) {
                int i7 = format.channelCount;
                int i8 = format.selectionFlags;
                int i9 = format.roleFlags;
                String str6 = format.language;
                int i10 = i8;
                i3 = i7;
                str3 = format.label;
                str2 = str6;
                i = i9;
                i2 = i10;
            } else {
                str2 = null;
                i3 = -1;
                i2 = 0;
                i = 0;
            }
        }
        String mediaMimeType = MimeTypes.getMediaMimeType(str);
        int i11 = z ? format.averageBitrate : -1;
        if (z) {
            i4 = format.peakBitrate;
        }
        return new Format.Builder().setId(format.id).setLabel(str3).setContainerMimeType(format.containerMimeType).setSampleMimeType(mediaMimeType).setCodecs(str).setMetadata(metadata).setAverageBitrate(i11).setPeakBitrate(i4).setChannelCount(i3).setSelectionFlags(i2).setRoleFlags(i).setLanguage(str2).build();
    }
}
