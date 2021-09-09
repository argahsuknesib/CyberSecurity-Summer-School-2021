package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

final class MergingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private MediaPeriod.Callback callback;
    private final ArrayList<MediaPeriod> childrenPendingPreparation = new ArrayList<>();
    private SequenceableLoader compositeSequenceableLoader;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private MediaPeriod[] enabledPeriods;
    private final MediaPeriod[] periods;
    private final IdentityHashMap<SampleStream, Integer> streamPeriodIndices;
    private TrackGroupArray trackGroups;

    public /* synthetic */ List<StreamKey> getStreamKeys(List<TrackSelection> list) {
        return MediaPeriod.CC.$default$getStreamKeys(this, list);
    }

    public MergingMediaPeriod(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2, long[] jArr, MediaPeriod... mediaPeriodArr) {
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory2;
        this.periods = mediaPeriodArr;
        this.compositeSequenceableLoader = compositeSequenceableLoaderFactory2.createCompositeSequenceableLoader(new SequenceableLoader[0]);
        this.streamPeriodIndices = new IdentityHashMap<>();
        this.enabledPeriods = new MediaPeriod[0];
        for (int i = 0; i < mediaPeriodArr.length; i++) {
            if (jArr[i] != 0) {
                this.periods[i] = new TimeOffsetMediaPeriod(mediaPeriodArr[i], jArr[i]);
            }
        }
    }

    public final MediaPeriod getChildPeriod(int i) {
        MediaPeriod[] mediaPeriodArr = this.periods;
        return mediaPeriodArr[i] instanceof TimeOffsetMediaPeriod ? ((TimeOffsetMediaPeriod) mediaPeriodArr[i]).mediaPeriod : mediaPeriodArr[i];
    }

    public final void prepare(MediaPeriod.Callback callback2, long j) {
        this.callback = callback2;
        Collections.addAll(this.childrenPendingPreparation, this.periods);
        for (MediaPeriod prepare : this.periods) {
            prepare.prepare(this, j);
        }
    }

    public final void maybeThrowPrepareError() throws IOException {
        for (MediaPeriod maybeThrowPrepareError : this.periods) {
            maybeThrowPrepareError.maybeThrowPrepareError();
        }
    }

    public final TrackGroupArray getTrackGroups() {
        return (TrackGroupArray) Assertions.checkNotNull(this.trackGroups);
    }

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
                i = this.streamPeriodIndices.get(sampleStreamArr2[i2]).intValue();
            }
            iArr[i2] = i;
            iArr2[i2] = -1;
            if (trackSelectionArr2[i2] != null) {
                TrackGroup trackGroup = trackSelectionArr2[i2].getTrackGroup();
                int i3 = 0;
                while (true) {
                    MediaPeriod[] mediaPeriodArr = this.periods;
                    if (i3 >= mediaPeriodArr.length) {
                        break;
                    } else if (mediaPeriodArr[i3].getTrackGroups().indexOf(trackGroup) != -1) {
                        iArr2[i2] = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        this.streamPeriodIndices.clear();
        SampleStream[] sampleStreamArr3 = new SampleStream[trackSelectionArr2.length];
        SampleStream[] sampleStreamArr4 = new SampleStream[trackSelectionArr2.length];
        TrackSelection[] trackSelectionArr3 = new TrackSelection[trackSelectionArr2.length];
        ArrayList arrayList = new ArrayList(this.periods.length);
        long j2 = j;
        int i4 = 0;
        while (i4 < this.periods.length) {
            for (int i5 = 0; i5 < trackSelectionArr2.length; i5++) {
                TrackSelection trackSelection = null;
                sampleStreamArr4[i5] = iArr[i5] == i4 ? sampleStreamArr2[i5] : null;
                if (iArr2[i5] == i4) {
                    trackSelection = trackSelectionArr2[i5];
                }
                trackSelectionArr3[i5] = trackSelection;
            }
            ArrayList arrayList2 = arrayList;
            TrackSelection[] trackSelectionArr4 = trackSelectionArr3;
            int i6 = i4;
            long selectTracks = this.periods[i4].selectTracks(trackSelectionArr3, zArr, sampleStreamArr4, zArr2, j2);
            if (i6 == 0) {
                j2 = selectTracks;
            } else if (selectTracks != j2) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z = false;
            for (int i7 = 0; i7 < trackSelectionArr2.length; i7++) {
                boolean z2 = true;
                if (iArr2[i7] == i6) {
                    sampleStreamArr3[i7] = sampleStreamArr4[i7];
                    this.streamPeriodIndices.put((SampleStream) Assertions.checkNotNull(sampleStreamArr4[i7]), Integer.valueOf(i6));
                    z = true;
                } else if (iArr[i7] == i6) {
                    if (sampleStreamArr4[i7] != null) {
                        z2 = false;
                    }
                    Assertions.checkState(z2);
                }
            }
            if (z) {
                arrayList2.add(this.periods[i6]);
            }
            i4 = i6 + 1;
            arrayList = arrayList2;
            trackSelectionArr3 = trackSelectionArr4;
        }
        ArrayList arrayList3 = arrayList;
        System.arraycopy(sampleStreamArr3, 0, sampleStreamArr2, 0, sampleStreamArr3.length);
        this.enabledPeriods = new MediaPeriod[arrayList3.size()];
        arrayList3.toArray(this.enabledPeriods);
        this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(this.enabledPeriods);
        return j2;
    }

    public final void discardBuffer(long j, boolean z) {
        for (MediaPeriod discardBuffer : this.enabledPeriods) {
            discardBuffer.discardBuffer(j, z);
        }
    }

    public final void reevaluateBuffer(long j) {
        this.compositeSequenceableLoader.reevaluateBuffer(j);
    }

    public final boolean continueLoading(long j) {
        if (this.childrenPendingPreparation.isEmpty()) {
            return this.compositeSequenceableLoader.continueLoading(j);
        }
        int size = this.childrenPendingPreparation.size();
        for (int i = 0; i < size; i++) {
            this.childrenPendingPreparation.get(i).continueLoading(j);
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
        long j = -9223372036854775807L;
        for (MediaPeriod mediaPeriod : this.enabledPeriods) {
            long readDiscontinuity = mediaPeriod.readDiscontinuity();
            if (readDiscontinuity != -9223372036854775807L) {
                if (j == -9223372036854775807L) {
                    MediaPeriod[] mediaPeriodArr = this.enabledPeriods;
                    int length = mediaPeriodArr.length;
                    int i = 0;
                    while (i < length) {
                        MediaPeriod mediaPeriod2 = mediaPeriodArr[i];
                        if (mediaPeriod2 == mediaPeriod) {
                            break;
                        } else if (mediaPeriod2.seekToUs(readDiscontinuity) == readDiscontinuity) {
                            i++;
                        } else {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                    j = readDiscontinuity;
                } else if (readDiscontinuity != j) {
                    throw new IllegalStateException("Conflicting discontinuities.");
                }
            } else if (!(j == -9223372036854775807L || mediaPeriod.seekToUs(j) == j)) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
        return j;
    }

    public final long getBufferedPositionUs() {
        return this.compositeSequenceableLoader.getBufferedPositionUs();
    }

    public final long seekToUs(long j) {
        long seekToUs = this.enabledPeriods[0].seekToUs(j);
        int i = 1;
        while (true) {
            MediaPeriod[] mediaPeriodArr = this.enabledPeriods;
            if (i >= mediaPeriodArr.length) {
                return seekToUs;
            }
            if (mediaPeriodArr[i].seekToUs(seekToUs) == seekToUs) {
                i++;
            } else {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
    }

    public final long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        MediaPeriod[] mediaPeriodArr = this.enabledPeriods;
        return (mediaPeriodArr.length > 0 ? mediaPeriodArr[0] : this.periods[0]).getAdjustedSeekPositionUs(j, seekParameters);
    }

    public final void onPrepared(MediaPeriod mediaPeriod) {
        this.childrenPendingPreparation.remove(mediaPeriod);
        if (this.childrenPendingPreparation.isEmpty()) {
            int i = 0;
            for (MediaPeriod trackGroups2 : this.periods) {
                i += trackGroups2.getTrackGroups().length;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i];
            MediaPeriod[] mediaPeriodArr = this.periods;
            int length = mediaPeriodArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                TrackGroupArray trackGroups3 = mediaPeriodArr[i2].getTrackGroups();
                int i4 = trackGroups3.length;
                int i5 = i3;
                int i6 = 0;
                while (i6 < i4) {
                    trackGroupArr[i5] = trackGroups3.get(i6);
                    i6++;
                    i5++;
                }
                i2++;
                i3 = i5;
            }
            this.trackGroups = new TrackGroupArray(trackGroupArr);
            ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onPrepared(this);
        }
    }

    public final void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
    }

    static final class TimeOffsetMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
        private MediaPeriod.Callback callback;
        public final MediaPeriod mediaPeriod;
        private final long timeOffsetUs;

        public TimeOffsetMediaPeriod(MediaPeriod mediaPeriod2, long j) {
            this.mediaPeriod = mediaPeriod2;
            this.timeOffsetUs = j;
        }

        public final void prepare(MediaPeriod.Callback callback2, long j) {
            this.callback = callback2;
            this.mediaPeriod.prepare(this, j - this.timeOffsetUs);
        }

        public final void maybeThrowPrepareError() throws IOException {
            this.mediaPeriod.maybeThrowPrepareError();
        }

        public final TrackGroupArray getTrackGroups() {
            return this.mediaPeriod.getTrackGroups();
        }

        public final List<StreamKey> getStreamKeys(List<TrackSelection> list) {
            return this.mediaPeriod.getStreamKeys(list);
        }

        public final long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
            SampleStream[] sampleStreamArr2 = sampleStreamArr;
            SampleStream[] sampleStreamArr3 = new SampleStream[sampleStreamArr2.length];
            int i = 0;
            while (true) {
                SampleStream sampleStream = null;
                if (i >= sampleStreamArr2.length) {
                    break;
                }
                TimeOffsetSampleStream timeOffsetSampleStream = (TimeOffsetSampleStream) sampleStreamArr2[i];
                if (timeOffsetSampleStream != null) {
                    sampleStream = timeOffsetSampleStream.getChildStream();
                }
                sampleStreamArr3[i] = sampleStream;
                i++;
            }
            long selectTracks = this.mediaPeriod.selectTracks(trackSelectionArr, zArr, sampleStreamArr3, zArr2, j - this.timeOffsetUs);
            for (int i2 = 0; i2 < sampleStreamArr2.length; i2++) {
                SampleStream sampleStream2 = sampleStreamArr3[i2];
                if (sampleStream2 == null) {
                    sampleStreamArr2[i2] = null;
                } else if (sampleStreamArr2[i2] == null || ((TimeOffsetSampleStream) sampleStreamArr2[i2]).getChildStream() != sampleStream2) {
                    sampleStreamArr2[i2] = new TimeOffsetSampleStream(sampleStream2, this.timeOffsetUs);
                }
            }
            return selectTracks + this.timeOffsetUs;
        }

        public final void discardBuffer(long j, boolean z) {
            this.mediaPeriod.discardBuffer(j - this.timeOffsetUs, z);
        }

        public final long readDiscontinuity() {
            long readDiscontinuity = this.mediaPeriod.readDiscontinuity();
            if (readDiscontinuity == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return readDiscontinuity + this.timeOffsetUs;
        }

        public final long seekToUs(long j) {
            return this.mediaPeriod.seekToUs(j - this.timeOffsetUs) + this.timeOffsetUs;
        }

        public final long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
            return this.mediaPeriod.getAdjustedSeekPositionUs(j - this.timeOffsetUs, seekParameters) + this.timeOffsetUs;
        }

        public final long getBufferedPositionUs() {
            long bufferedPositionUs = this.mediaPeriod.getBufferedPositionUs();
            if (bufferedPositionUs == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return bufferedPositionUs + this.timeOffsetUs;
        }

        public final long getNextLoadPositionUs() {
            long nextLoadPositionUs = this.mediaPeriod.getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return nextLoadPositionUs + this.timeOffsetUs;
        }

        public final boolean continueLoading(long j) {
            return this.mediaPeriod.continueLoading(j - this.timeOffsetUs);
        }

        public final boolean isLoading() {
            return this.mediaPeriod.isLoading();
        }

        public final void reevaluateBuffer(long j) {
            this.mediaPeriod.reevaluateBuffer(j - this.timeOffsetUs);
        }

        public final void onPrepared(MediaPeriod mediaPeriod2) {
            ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onPrepared(this);
        }

        public final void onContinueLoadingRequested(MediaPeriod mediaPeriod2) {
            ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
        }
    }

    static final class TimeOffsetSampleStream implements SampleStream {
        private final SampleStream sampleStream;
        private final long timeOffsetUs;

        public TimeOffsetSampleStream(SampleStream sampleStream2, long j) {
            this.sampleStream = sampleStream2;
            this.timeOffsetUs = j;
        }

        public final SampleStream getChildStream() {
            return this.sampleStream;
        }

        public final boolean isReady() {
            return this.sampleStream.isReady();
        }

        public final void maybeThrowError() throws IOException {
            this.sampleStream.maybeThrowError();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.Math.max(long, long):long}
         arg types: [int, long]
         candidates:
          ClspMth{java.lang.Math.max(double, double):double}
          ClspMth{java.lang.Math.max(int, int):int}
          ClspMth{java.lang.Math.max(float, float):float}
          ClspMth{java.lang.Math.max(long, long):long} */
        public final int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
            int readData = this.sampleStream.readData(formatHolder, decoderInputBuffer, z);
            if (readData == -4) {
                decoderInputBuffer.timeUs = Math.max(0L, decoderInputBuffer.timeUs + this.timeOffsetUs);
            }
            return readData;
        }

        public final int skipData(long j) {
            return this.sampleStream.skipData(j - this.timeOffsetUs);
        }
    }
}
