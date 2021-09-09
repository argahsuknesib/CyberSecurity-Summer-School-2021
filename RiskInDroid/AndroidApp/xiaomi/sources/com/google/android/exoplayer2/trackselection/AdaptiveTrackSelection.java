package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Util;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AdaptiveTrackSelection extends BaseTrackSelection {
    private final BandwidthProvider bandwidthProvider;
    private final float bufferedFractionToLiveEdgeForQualityIncrease;
    private final Clock clock;
    private long lastBufferEvaluationMs;
    private final long maxDurationForQualityDecreaseUs;
    private final long minDurationForQualityIncreaseUs;
    private final long minDurationToRetainAfterDiscardUs;
    private final long minTimeBetweenBufferReevaluationMs;
    private float playbackSpeed;
    private int reason;
    private int selectedIndex;

    interface BandwidthProvider {
        long getAllocatedBandwidth();
    }

    public Object getSelectionData() {
        return null;
    }

    public static class Factory implements TrackSelection.Factory {
        private final float bandwidthFraction;
        private final BandwidthMeter bandwidthMeter;
        private final float bufferedFractionToLiveEdgeForQualityIncrease;
        private final Clock clock;
        private final int maxDurationForQualityDecreaseMs;
        private final int minDurationForQualityIncreaseMs;
        private final int minDurationToRetainAfterDiscardMs;
        private final long minTimeBetweenBufferReevaluationMs;

        public Factory() {
            this(C.MSG_CUSTOM_BASE, 25000, 25000, 0.7f, 0.75f, 2000, Clock.DEFAULT);
        }

        @Deprecated
        public Factory(BandwidthMeter bandwidthMeter2) {
            this(bandwidthMeter2, C.MSG_CUSTOM_BASE, 25000, 25000, 0.7f, 0.75f, 2000, Clock.DEFAULT);
        }

        public Factory(int i, int i2, int i3, float f) {
            this(i, i2, i3, f, 0.75f, 2000, Clock.DEFAULT);
        }

        @Deprecated
        public Factory(BandwidthMeter bandwidthMeter2, int i, int i2, int i3, float f) {
            this(bandwidthMeter2, i, i2, i3, f, 0.75f, 2000, Clock.DEFAULT);
        }

        public Factory(int i, int i2, int i3, float f, float f2, long j, Clock clock2) {
            this(null, i, i2, i3, f, f2, j, clock2);
        }

        @Deprecated
        public Factory(BandwidthMeter bandwidthMeter2, int i, int i2, int i3, float f, float f2, long j, Clock clock2) {
            this.bandwidthMeter = bandwidthMeter2;
            this.minDurationForQualityIncreaseMs = i;
            this.maxDurationForQualityDecreaseMs = i2;
            this.minDurationToRetainAfterDiscardMs = i3;
            this.bandwidthFraction = f;
            this.bufferedFractionToLiveEdgeForQualityIncrease = f2;
            this.minTimeBetweenBufferReevaluationMs = j;
            this.clock = clock2;
        }

        public final TrackSelection[] createTrackSelections(TrackSelection.Definition[] definitionArr, BandwidthMeter bandwidthMeter2) {
            BandwidthMeter bandwidthMeter3 = this.bandwidthMeter;
            if (bandwidthMeter3 != null) {
                bandwidthMeter2 = bandwidthMeter3;
            }
            TrackSelection[] trackSelectionArr = new TrackSelection[definitionArr.length];
            int i = 0;
            for (int i2 = 0; i2 < definitionArr.length; i2++) {
                TrackSelection.Definition definition = definitionArr[i2];
                if (definition != null && definition.tracks.length == 1) {
                    trackSelectionArr[i2] = new FixedTrackSelection(definition.group, definition.tracks[0], definition.reason, definition.data);
                    int i3 = definition.group.getFormat(definition.tracks[0]).bitrate;
                    if (i3 != -1) {
                        i += i3;
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < definitionArr.length; i4++) {
                TrackSelection.Definition definition2 = definitionArr[i4];
                if (definition2 != null && definition2.tracks.length > 1) {
                    AdaptiveTrackSelection createAdaptiveTrackSelection = createAdaptiveTrackSelection(definition2.group, bandwidthMeter2, definition2.tracks, i);
                    arrayList.add(createAdaptiveTrackSelection);
                    trackSelectionArr[i4] = createAdaptiveTrackSelection;
                }
            }
            if (arrayList.size() > 1) {
                long[][] jArr = new long[arrayList.size()][];
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    AdaptiveTrackSelection adaptiveTrackSelection = (AdaptiveTrackSelection) arrayList.get(i5);
                    jArr[i5] = new long[adaptiveTrackSelection.length()];
                    for (int i6 = 0; i6 < adaptiveTrackSelection.length(); i6++) {
                        jArr[i5][i6] = (long) adaptiveTrackSelection.getFormat((adaptiveTrackSelection.length() - i6) - 1).bitrate;
                    }
                }
                long[][][] allocationCheckpoints = AdaptiveTrackSelection.getAllocationCheckpoints(jArr);
                for (int i7 = 0; i7 < arrayList.size(); i7++) {
                    ((AdaptiveTrackSelection) arrayList.get(i7)).experimental_setBandwidthAllocationCheckpoints(allocationCheckpoints[i7]);
                }
            }
            return trackSelectionArr;
        }

        /* access modifiers changed from: protected */
        public AdaptiveTrackSelection createAdaptiveTrackSelection(TrackGroup trackGroup, BandwidthMeter bandwidthMeter2, int[] iArr, int i) {
            return new AdaptiveTrackSelection(trackGroup, iArr, new DefaultBandwidthProvider(bandwidthMeter2, this.bandwidthFraction, (long) i), (long) this.minDurationForQualityIncreaseMs, (long) this.maxDurationForQualityDecreaseMs, (long) this.minDurationToRetainAfterDiscardMs, this.bufferedFractionToLiveEdgeForQualityIncrease, this.minTimeBetweenBufferReevaluationMs, this.clock);
        }
    }

    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, BandwidthMeter bandwidthMeter) {
        this(trackGroup, iArr, bandwidthMeter, 0, 10000, 25000, 25000, 0.7f, 0.75f, 2000, Clock.DEFAULT);
    }

    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, BandwidthMeter bandwidthMeter, long j, long j2, long j3, long j4, float f, float f2, long j5, Clock clock2) {
        this(trackGroup, iArr, new DefaultBandwidthProvider(bandwidthMeter, f, j), j2, j3, j4, f2, j5, clock2);
    }

    private AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, BandwidthProvider bandwidthProvider2, long j, long j2, long j3, float f, long j4, Clock clock2) {
        super(trackGroup, iArr);
        this.bandwidthProvider = bandwidthProvider2;
        this.minDurationForQualityIncreaseUs = j * 1000;
        this.maxDurationForQualityDecreaseUs = j2 * 1000;
        this.minDurationToRetainAfterDiscardUs = j3 * 1000;
        this.bufferedFractionToLiveEdgeForQualityIncrease = f;
        this.minTimeBetweenBufferReevaluationMs = j4;
        this.clock = clock2;
        this.playbackSpeed = 1.0f;
        this.reason = 0;
        this.lastBufferEvaluationMs = -9223372036854775807L;
    }

    public void experimental_setBandwidthAllocationCheckpoints(long[][] jArr) {
        ((DefaultBandwidthProvider) this.bandwidthProvider).experimental_setBandwidthAllocationCheckpoints(jArr);
    }

    public void enable() {
        this.lastBufferEvaluationMs = -9223372036854775807L;
    }

    public void onPlaybackSpeed(float f) {
        this.playbackSpeed = f;
    }

    public void updateSelectedTrack(long j, long j2, long j3, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
        long elapsedRealtime = this.clock.elapsedRealtime();
        if (this.reason == 0) {
            this.reason = 1;
            this.selectedIndex = determineIdealSelectedIndex(elapsedRealtime);
            return;
        }
        int i = this.selectedIndex;
        this.selectedIndex = determineIdealSelectedIndex(elapsedRealtime);
        if (this.selectedIndex != i) {
            if (!isBlacklisted(i, elapsedRealtime)) {
                Format format = getFormat(i);
                Format format2 = getFormat(this.selectedIndex);
                if (format2.bitrate > format.bitrate && j2 < minDurationForQualityIncreaseUs(j3)) {
                    this.selectedIndex = i;
                } else if (format2.bitrate < format.bitrate && j2 >= this.maxDurationForQualityDecreaseUs) {
                    this.selectedIndex = i;
                }
            }
            if (this.selectedIndex != i) {
                this.reason = 3;
            }
        }
    }

    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    public int getSelectionReason() {
        return this.reason;
    }

    public int evaluateQueueSize(long j, List<? extends MediaChunk> list) {
        long elapsedRealtime = this.clock.elapsedRealtime();
        if (!shouldEvaluateQueueSize(elapsedRealtime)) {
            return list.size();
        }
        this.lastBufferEvaluationMs = elapsedRealtime;
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long playoutDurationForMediaDuration = Util.getPlayoutDurationForMediaDuration(((MediaChunk) list.get(size - 1)).startTimeUs - j, this.playbackSpeed);
        long minDurationToRetainAfterDiscardUs2 = getMinDurationToRetainAfterDiscardUs();
        if (playoutDurationForMediaDuration < minDurationToRetainAfterDiscardUs2) {
            return size;
        }
        Format format = getFormat(determineIdealSelectedIndex(elapsedRealtime));
        for (int i = 0; i < size; i++) {
            MediaChunk mediaChunk = (MediaChunk) list.get(i);
            Format format2 = mediaChunk.trackFormat;
            if (Util.getPlayoutDurationForMediaDuration(mediaChunk.startTimeUs - j, this.playbackSpeed) >= minDurationToRetainAfterDiscardUs2 && format2.bitrate < format.bitrate && format2.height != -1 && format2.height < 720 && format2.width != -1 && format2.width < 1280 && format2.height < format.height) {
                return i;
            }
        }
        return size;
    }

    /* access modifiers changed from: protected */
    public boolean canSelectFormat(Format format, int i, float f, long j) {
        return ((long) Math.round(((float) i) * f)) <= j;
    }

    /* access modifiers changed from: protected */
    public boolean shouldEvaluateQueueSize(long j) {
        long j2 = this.lastBufferEvaluationMs;
        return j2 == -9223372036854775807L || j - j2 >= this.minTimeBetweenBufferReevaluationMs;
    }

    /* access modifiers changed from: protected */
    public long getMinDurationToRetainAfterDiscardUs() {
        return this.minDurationToRetainAfterDiscardUs;
    }

    private int determineIdealSelectedIndex(long j) {
        long allocatedBandwidth = this.bandwidthProvider.getAllocatedBandwidth();
        int i = 0;
        for (int i2 = 0; i2 < this.length; i2++) {
            if (j == Long.MIN_VALUE || !isBlacklisted(i2, j)) {
                Format format = getFormat(i2);
                if (canSelectFormat(format, format.bitrate, this.playbackSpeed, allocatedBandwidth)) {
                    return i2;
                }
                i = i2;
            }
        }
        return i;
    }

    private long minDurationForQualityIncreaseUs(long j) {
        return (j > -9223372036854775807L ? 1 : (j == -9223372036854775807L ? 0 : -1)) != 0 && (j > this.minDurationForQualityIncreaseUs ? 1 : (j == this.minDurationForQualityIncreaseUs ? 0 : -1)) <= 0 ? (long) (((float) j) * this.bufferedFractionToLiveEdgeForQualityIncrease) : this.minDurationForQualityIncreaseUs;
    }

    static final class DefaultBandwidthProvider implements BandwidthProvider {
        private long[][] allocationCheckpoints;
        private final float bandwidthFraction;
        private final BandwidthMeter bandwidthMeter;
        private final long reservedBandwidth;

        DefaultBandwidthProvider(BandwidthMeter bandwidthMeter2, float f, long j) {
            this.bandwidthMeter = bandwidthMeter2;
            this.bandwidthFraction = f;
            this.reservedBandwidth = j;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.Math.max(long, long):long}
         arg types: [int, long]
         candidates:
          ClspMth{java.lang.Math.max(double, double):double}
          ClspMth{java.lang.Math.max(int, int):int}
          ClspMth{java.lang.Math.max(float, float):float}
          ClspMth{java.lang.Math.max(long, long):long} */
        public final long getAllocatedBandwidth() {
            long max = Math.max(0L, ((long) (((float) this.bandwidthMeter.getBitrateEstimate()) * this.bandwidthFraction)) - this.reservedBandwidth);
            if (this.allocationCheckpoints == null) {
                return max;
            }
            int i = 1;
            while (true) {
                long[][] jArr = this.allocationCheckpoints;
                if (i >= jArr.length - 1 || jArr[i][0] >= max) {
                    long[][] jArr2 = this.allocationCheckpoints;
                    long[] jArr3 = jArr2[i - 1];
                    long[] jArr4 = jArr2[i];
                } else {
                    i++;
                }
            }
            long[][] jArr22 = this.allocationCheckpoints;
            long[] jArr32 = jArr22[i - 1];
            long[] jArr42 = jArr22[i];
            return jArr32[1] + ((long) ((((float) (max - jArr32[0])) / ((float) (jArr42[0] - jArr32[0]))) * ((float) (jArr42[1] - jArr32[1]))));
        }

        /* access modifiers changed from: package-private */
        public final void experimental_setBandwidthAllocationCheckpoints(long[][] jArr) {
            Assertions.checkArgument(jArr.length >= 2);
            this.allocationCheckpoints = jArr;
        }
    }

    public static long[][][] getAllocationCheckpoints(long[][] jArr) {
        int i;
        double[][] logArrayValues = getLogArrayValues(jArr);
        double[][] switchPoints = getSwitchPoints(logArrayValues);
        int countArrayElements = countArrayElements(switchPoints) + 3;
        long[][][] jArr2 = (long[][][]) Array.newInstance(long.class, logArrayValues.length, countArrayElements, 2);
        int[] iArr = new int[logArrayValues.length];
        setCheckpointValues(jArr2, 1, jArr, iArr);
        int i2 = 2;
        while (true) {
            i = countArrayElements - 1;
            if (i2 >= i) {
                break;
            }
            double d = Double.MAX_VALUE;
            int i3 = 0;
            for (int i4 = 0; i4 < logArrayValues.length; i4++) {
                if (iArr[i4] + 1 != logArrayValues[i4].length) {
                    double d2 = switchPoints[i4][iArr[i4]];
                    if (d2 < d) {
                        i3 = i4;
                        d = d2;
                    }
                }
            }
            iArr[i3] = iArr[i3] + 1;
            setCheckpointValues(jArr2, i2, jArr, iArr);
            i2++;
        }
        for (long[][] jArr3 : jArr2) {
            int i5 = countArrayElements - 2;
            jArr3[i][0] = jArr3[i5][0] * 2;
            jArr3[i][1] = jArr3[i5][1] * 2;
        }
        return jArr2;
    }

    private static double[][] getLogArrayValues(long[][] jArr) {
        double[][] dArr = new double[jArr.length][];
        for (int i = 0; i < jArr.length; i++) {
            dArr[i] = new double[jArr[i].length];
            for (int i2 = 0; i2 < jArr[i].length; i2++) {
                dArr[i][i2] = jArr[i][i2] == -1 ? 0.0d : Math.log((double) jArr[i][i2]);
            }
        }
        return dArr;
    }

    private static double[][] getSwitchPoints(double[][] dArr) {
        double[][] dArr2 = new double[dArr.length][];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = new double[(dArr[i].length - 1)];
            if (dArr2[i].length != 0) {
                double d = dArr[i][dArr[i].length - 1] - dArr[i][0];
                int i2 = 0;
                while (i2 < dArr[i].length - 1) {
                    int i3 = i2 + 1;
                    dArr2[i][i2] = d == 0.0d ? 1.0d : (((dArr[i][i2] + dArr[i][i3]) * 0.5d) - dArr[i][0]) / d;
                    i2 = i3;
                }
            }
        }
        return dArr2;
    }

    private static int countArrayElements(double[][] dArr) {
        int i = 0;
        for (double[] length : dArr) {
            i += length.length;
        }
        return i;
    }

    private static void setCheckpointValues(long[][][] jArr, int i, long[][] jArr2, int[] iArr) {
        long j = 0;
        for (int i2 = 0; i2 < jArr.length; i2++) {
            jArr[i2][i][1] = jArr2[i2][iArr[i2]];
            j += jArr[i2][i][1];
        }
        for (long[][] jArr3 : jArr) {
            jArr3[i][0] = j;
        }
    }
}
