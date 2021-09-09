package com.google.android.exoplayer2.extractor.mp3;

import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.util.Util;

final class MlltSeeker implements Seeker {
    private final long durationUs;
    private final long[] referencePositions;
    private final long[] referenceTimesMs;

    public final long getDataEndPosition() {
        return -1;
    }

    public final boolean isSeekable() {
        return true;
    }

    public static MlltSeeker create(long j, MlltFrame mlltFrame) {
        int length = mlltFrame.bytesDeviations.length;
        int i = length + 1;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        jArr[0] = j;
        long j2 = 0;
        jArr2[0] = 0;
        for (int i2 = 1; i2 <= length; i2++) {
            int i3 = i2 - 1;
            j += (long) (mlltFrame.bytesBetweenReference + mlltFrame.bytesDeviations[i3]);
            j2 += (long) (mlltFrame.millisecondsBetweenReference + mlltFrame.millisecondsDeviations[i3]);
            jArr[i2] = j;
            jArr2[i2] = j2;
        }
        return new MlltSeeker(jArr, jArr2);
    }

    private MlltSeeker(long[] jArr, long[] jArr2) {
        this.referencePositions = jArr;
        this.referenceTimesMs = jArr2;
        this.durationUs = C.msToUs(jArr2[jArr2.length - 1]);
    }

    public final SeekMap.SeekPoints getSeekPoints(long j) {
        Pair<Long, Long> linearlyInterpolate = linearlyInterpolate(C.usToMs(Util.constrainValue(j, 0, this.durationUs)), this.referenceTimesMs, this.referencePositions);
        return new SeekMap.SeekPoints(new SeekPoint(C.msToUs(((Long) linearlyInterpolate.first).longValue()), ((Long) linearlyInterpolate.second).longValue()));
    }

    public final long getTimeUs(long j) {
        return C.msToUs(((Long) linearlyInterpolate(j, this.referencePositions, this.referenceTimesMs).second).longValue());
    }

    public final long getDurationUs() {
        return this.durationUs;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.exoplayer2.util.Util.binarySearchFloor(long[], long, boolean, boolean):int
     arg types: [long[], long, int, int]
     candidates:
      com.google.android.exoplayer2.util.Util.binarySearchFloor(com.google.android.exoplayer2.util.LongArray, long, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchFloor(java.util.List, java.lang.Comparable, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchFloor(int[], int, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchFloor(long[], long, boolean, boolean):int */
    private static Pair<Long, Long> linearlyInterpolate(long j, long[] jArr, long[] jArr2) {
        double d;
        int binarySearchFloor = Util.binarySearchFloor(jArr, j, true, true);
        long j2 = jArr[binarySearchFloor];
        long j3 = jArr2[binarySearchFloor];
        int i = binarySearchFloor + 1;
        if (i == jArr.length) {
            return Pair.create(Long.valueOf(j2), Long.valueOf(j3));
        }
        long j4 = jArr[i];
        long j5 = jArr2[i];
        if (j4 == j2) {
            d = 0.0d;
        } else {
            double d2 = (double) j;
            double d3 = (double) j2;
            Double.isNaN(d2);
            Double.isNaN(d3);
            double d4 = (double) (j4 - j2);
            Double.isNaN(d4);
            d = (d2 - d3) / d4;
        }
        double d5 = (double) (j5 - j3);
        Double.isNaN(d5);
        return Pair.create(Long.valueOf(j), Long.valueOf(((long) (d * d5)) + j3));
    }
}
