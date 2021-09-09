package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.Util;

final class IndexSeeker implements Seeker {
    private final long dataEndPosition;
    private long durationUs;
    private final LongArray positions = new LongArray();
    private final LongArray timesUs = new LongArray();

    public final boolean isSeekable() {
        return true;
    }

    public IndexSeeker(long j, long j2, long j3) {
        this.durationUs = j;
        this.dataEndPosition = j3;
        this.timesUs.add(0);
        this.positions.add(j2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.exoplayer2.util.Util.binarySearchFloor(com.google.android.exoplayer2.util.LongArray, long, boolean, boolean):int
     arg types: [com.google.android.exoplayer2.util.LongArray, long, int, int]
     candidates:
      com.google.android.exoplayer2.util.Util.binarySearchFloor(java.util.List, java.lang.Comparable, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchFloor(int[], int, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchFloor(long[], long, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchFloor(com.google.android.exoplayer2.util.LongArray, long, boolean, boolean):int */
    public final long getTimeUs(long j) {
        return this.timesUs.get(Util.binarySearchFloor(this.positions, j, true, true));
    }

    public final long getDataEndPosition() {
        return this.dataEndPosition;
    }

    public final long getDurationUs() {
        return this.durationUs;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.exoplayer2.util.Util.binarySearchFloor(com.google.android.exoplayer2.util.LongArray, long, boolean, boolean):int
     arg types: [com.google.android.exoplayer2.util.LongArray, long, int, int]
     candidates:
      com.google.android.exoplayer2.util.Util.binarySearchFloor(java.util.List, java.lang.Comparable, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchFloor(int[], int, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchFloor(long[], long, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchFloor(com.google.android.exoplayer2.util.LongArray, long, boolean, boolean):int */
    public final SeekMap.SeekPoints getSeekPoints(long j) {
        int binarySearchFloor = Util.binarySearchFloor(this.timesUs, j, true, true);
        SeekPoint seekPoint = new SeekPoint(this.timesUs.get(binarySearchFloor), this.positions.get(binarySearchFloor));
        if (seekPoint.timeUs >= j || binarySearchFloor == this.timesUs.size() - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i = binarySearchFloor + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.timesUs.get(i), this.positions.get(i)));
    }

    public final void maybeAddSeekPoint(long j, long j2) {
        if (!isTimeUsInIndex(j)) {
            this.timesUs.add(j);
            this.positions.add(j2);
        }
    }

    public final boolean isTimeUsInIndex(long j) {
        LongArray longArray = this.timesUs;
        return j - longArray.get(longArray.size() - 1) < 100000;
    }

    /* access modifiers changed from: package-private */
    public final void setDurationUs(long j) {
        this.durationUs = j;
    }
}
