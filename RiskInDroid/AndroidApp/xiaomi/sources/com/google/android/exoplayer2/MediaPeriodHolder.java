package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.ClippingMediaPeriod;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;

final class MediaPeriodHolder {
    public boolean allRenderersEnabled;
    public boolean hasEnabledTracks;
    public MediaPeriodInfo info;
    private final boolean[] mayRetainStreamFlags;
    public final MediaPeriod mediaPeriod;
    private final MediaSourceList mediaSourceList;
    private MediaPeriodHolder next;
    public boolean prepared;
    private final RendererCapabilities[] rendererCapabilities;
    private long rendererPositionOffsetUs;
    public final SampleStream[] sampleStreams;
    private TrackGroupArray trackGroups = TrackGroupArray.EMPTY;
    private final TrackSelector trackSelector;
    private TrackSelectorResult trackSelectorResult;
    public final Object uid;

    public MediaPeriodHolder(RendererCapabilities[] rendererCapabilitiesArr, long j, TrackSelector trackSelector2, Allocator allocator, MediaSourceList mediaSourceList2, MediaPeriodInfo mediaPeriodInfo, TrackSelectorResult trackSelectorResult2) {
        this.rendererCapabilities = rendererCapabilitiesArr;
        this.rendererPositionOffsetUs = j;
        this.trackSelector = trackSelector2;
        this.mediaSourceList = mediaSourceList2;
        this.uid = mediaPeriodInfo.id.periodUid;
        this.info = mediaPeriodInfo;
        this.trackSelectorResult = trackSelectorResult2;
        this.sampleStreams = new SampleStream[rendererCapabilitiesArr.length];
        this.mayRetainStreamFlags = new boolean[rendererCapabilitiesArr.length];
        this.mediaPeriod = createMediaPeriod(mediaPeriodInfo.id, mediaSourceList2, allocator, mediaPeriodInfo.startPositionUs, mediaPeriodInfo.endPositionUs);
    }

    public final long toRendererTime(long j) {
        return j + getRendererOffset();
    }

    public final long toPeriodTime(long j) {
        return j - getRendererOffset();
    }

    public final long getRendererOffset() {
        return this.rendererPositionOffsetUs;
    }

    public final void setRendererOffset(long j) {
        this.rendererPositionOffsetUs = j;
    }

    public final long getStartPositionRendererTime() {
        return this.info.startPositionUs + this.rendererPositionOffsetUs;
    }

    public final boolean isFullyBuffered() {
        if (this.prepared) {
            return !this.hasEnabledTracks || this.mediaPeriod.getBufferedPositionUs() == Long.MIN_VALUE;
        }
        return false;
    }

    public final long getBufferedPositionUs() {
        if (!this.prepared) {
            return this.info.startPositionUs;
        }
        long bufferedPositionUs = this.hasEnabledTracks ? this.mediaPeriod.getBufferedPositionUs() : Long.MIN_VALUE;
        return bufferedPositionUs == Long.MIN_VALUE ? this.info.durationUs : bufferedPositionUs;
    }

    public final long getNextLoadPositionUs() {
        if (!this.prepared) {
            return 0;
        }
        return this.mediaPeriod.getNextLoadPositionUs();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    public final void handlePrepared(float f, Timeline timeline) throws ExoPlaybackException {
        this.prepared = true;
        this.trackGroups = this.mediaPeriod.getTrackGroups();
        TrackSelectorResult selectTracks = selectTracks(f, timeline);
        long j = this.info.startPositionUs;
        if (this.info.durationUs != -9223372036854775807L && j >= this.info.durationUs) {
            j = Math.max(0L, this.info.durationUs - 1);
        }
        long applyTrackSelection = applyTrackSelection(selectTracks, j, false);
        this.rendererPositionOffsetUs += this.info.startPositionUs - applyTrackSelection;
        this.info = this.info.copyWithStartPositionUs(applyTrackSelection);
    }

    public final void reevaluateBuffer(long j) {
        Assertions.checkState(isLoadingMediaPeriod());
        if (this.prepared) {
            this.mediaPeriod.reevaluateBuffer(toPeriodTime(j));
        }
    }

    public final void continueLoading(long j) {
        Assertions.checkState(isLoadingMediaPeriod());
        this.mediaPeriod.continueLoading(toPeriodTime(j));
    }

    public final TrackSelectorResult selectTracks(float f, Timeline timeline) throws ExoPlaybackException {
        TrackSelectorResult selectTracks = this.trackSelector.selectTracks(this.rendererCapabilities, getTrackGroups(), this.info.id, timeline);
        for (TrackSelection trackSelection : selectTracks.selections.getAll()) {
            if (trackSelection != null) {
                trackSelection.onPlaybackSpeed(f);
            }
        }
        return selectTracks;
    }

    public final long applyTrackSelection(TrackSelectorResult trackSelectorResult2, long j, boolean z) {
        return applyTrackSelection(trackSelectorResult2, j, z, new boolean[this.rendererCapabilities.length]);
    }

    public final long applyTrackSelection(TrackSelectorResult trackSelectorResult2, long j, boolean z, boolean[] zArr) {
        TrackSelectorResult trackSelectorResult3 = trackSelectorResult2;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= trackSelectorResult3.length) {
                break;
            }
            boolean[] zArr2 = this.mayRetainStreamFlags;
            if (z || !trackSelectorResult2.isEquivalent(this.trackSelectorResult, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        disassociateNoSampleRenderersWithEmptySampleStream(this.sampleStreams);
        disableTrackSelectionsInResult();
        this.trackSelectorResult = trackSelectorResult3;
        enableTrackSelectionsInResult();
        TrackSelectionArray trackSelectionArray = trackSelectorResult3.selections;
        long selectTracks = this.mediaPeriod.selectTracks(trackSelectionArray.getAll(), this.mayRetainStreamFlags, this.sampleStreams, zArr, j);
        associateNoSampleRenderersWithEmptySampleStream(this.sampleStreams);
        this.hasEnabledTracks = false;
        int i2 = 0;
        while (true) {
            SampleStream[] sampleStreamArr = this.sampleStreams;
            if (i2 >= sampleStreamArr.length) {
                return selectTracks;
            }
            if (sampleStreamArr[i2] != null) {
                Assertions.checkState(trackSelectorResult2.isRendererEnabled(i2));
                if (this.rendererCapabilities[i2].getTrackType() != 6) {
                    this.hasEnabledTracks = true;
                }
            } else {
                Assertions.checkState(trackSelectionArray.get(i2) == null);
            }
            i2++;
        }
    }

    public final void release() {
        disableTrackSelectionsInResult();
        releaseMediaPeriod(this.info.endPositionUs, this.mediaSourceList, this.mediaPeriod);
    }

    public final void setNext(MediaPeriodHolder mediaPeriodHolder) {
        if (mediaPeriodHolder != this.next) {
            disableTrackSelectionsInResult();
            this.next = mediaPeriodHolder;
            enableTrackSelectionsInResult();
        }
    }

    public final MediaPeriodHolder getNext() {
        return this.next;
    }

    public final TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    public final TrackSelectorResult getTrackSelectorResult() {
        return this.trackSelectorResult;
    }

    private void enableTrackSelectionsInResult() {
        if (isLoadingMediaPeriod()) {
            for (int i = 0; i < this.trackSelectorResult.length; i++) {
                boolean isRendererEnabled = this.trackSelectorResult.isRendererEnabled(i);
                TrackSelection trackSelection = this.trackSelectorResult.selections.get(i);
                if (isRendererEnabled && trackSelection != null) {
                    trackSelection.enable();
                }
            }
        }
    }

    private void disableTrackSelectionsInResult() {
        if (isLoadingMediaPeriod()) {
            for (int i = 0; i < this.trackSelectorResult.length; i++) {
                boolean isRendererEnabled = this.trackSelectorResult.isRendererEnabled(i);
                TrackSelection trackSelection = this.trackSelectorResult.selections.get(i);
                if (isRendererEnabled && trackSelection != null) {
                    trackSelection.disable();
                }
            }
        }
    }

    private void disassociateNoSampleRenderersWithEmptySampleStream(SampleStream[] sampleStreamArr) {
        int i = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.rendererCapabilities;
            if (i < rendererCapabilitiesArr.length) {
                if (rendererCapabilitiesArr[i].getTrackType() == 6) {
                    sampleStreamArr[i] = null;
                }
                i++;
            } else {
                return;
            }
        }
    }

    private void associateNoSampleRenderersWithEmptySampleStream(SampleStream[] sampleStreamArr) {
        int i = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.rendererCapabilities;
            if (i < rendererCapabilitiesArr.length) {
                if (rendererCapabilitiesArr[i].getTrackType() == 6 && this.trackSelectorResult.isRendererEnabled(i)) {
                    sampleStreamArr[i] = new EmptySampleStream();
                }
                i++;
            } else {
                return;
            }
        }
    }

    private boolean isLoadingMediaPeriod() {
        return this.next == null;
    }

    private static MediaPeriod createMediaPeriod(MediaSource.MediaPeriodId mediaPeriodId, MediaSourceList mediaSourceList2, Allocator allocator, long j, long j2) {
        MediaPeriod createPeriod = mediaSourceList2.createPeriod(mediaPeriodId, allocator, j);
        return (j2 == -9223372036854775807L || j2 == Long.MIN_VALUE) ? createPeriod : new ClippingMediaPeriod(createPeriod, true, 0, j2);
    }

    private static void releaseMediaPeriod(long j, MediaSourceList mediaSourceList2, MediaPeriod mediaPeriod2) {
        if (j == -9223372036854775807L || j == Long.MIN_VALUE) {
            mediaSourceList2.releasePeriod(mediaPeriod2);
            return;
        }
        try {
            mediaSourceList2.releasePeriod(((ClippingMediaPeriod) mediaPeriod2).mediaPeriod);
        } catch (RuntimeException e) {
            Log.e("MediaPeriodHolder", "Period release failed.", e);
        }
    }
}
