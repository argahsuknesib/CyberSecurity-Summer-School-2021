package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Assertions;

public final class SinglePeriodTimeline extends Timeline {
    private static final Object UID = new Object();
    private final long elapsedRealtimeEpochOffsetMs;
    private final boolean isDynamic;
    private final boolean isLive;
    private final boolean isSeekable;
    private final Object manifest;
    private final long periodDurationUs;
    private final long presentationStartTimeMs;
    private final Object tag;
    private final long windowDefaultStartPositionUs;
    private final long windowDurationUs;
    private final long windowPositionInPeriodUs;
    private final long windowStartTimeMs;

    public final int getPeriodCount() {
        return 1;
    }

    public final int getWindowCount() {
        return 1;
    }

    public SinglePeriodTimeline(long j, boolean z, boolean z2, boolean z3) {
        this(j, z, z2, z3, null, null);
    }

    public SinglePeriodTimeline(long j, boolean z, boolean z2, boolean z3, Object obj, Object obj2) {
        this(j, j, 0, 0, z, z2, z3, obj, obj2);
    }

    public SinglePeriodTimeline(long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, Object obj, Object obj2) {
        this(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j, j2, j3, j4, z, z2, z3, obj, obj2);
    }

    public SinglePeriodTimeline(long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2, boolean z3, Object obj, Object obj2) {
        this.presentationStartTimeMs = j;
        this.windowStartTimeMs = j2;
        this.elapsedRealtimeEpochOffsetMs = j3;
        this.periodDurationUs = j4;
        this.windowDurationUs = j5;
        this.windowPositionInPeriodUs = j6;
        this.windowDefaultStartPositionUs = j7;
        this.isSeekable = z;
        this.isDynamic = z2;
        this.isLive = z3;
        this.manifest = obj;
        this.tag = obj2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0027, code lost:
        if (r1 > r6) goto L_0x0020;
     */
    public final Timeline.Window getWindow(int i, Timeline.Window window, long j) {
        long j2;
        Assertions.checkIndex(i, 0, 1);
        long j3 = this.windowDefaultStartPositionUs;
        if (this.isDynamic && j != 0) {
            long j4 = this.windowDurationUs;
            if (j4 != -9223372036854775807L) {
                j3 += j;
            }
            j2 = -9223372036854775807L;
            return window.set(Timeline.Window.SINGLE_WINDOW_UID, this.tag, this.manifest, this.presentationStartTimeMs, this.windowStartTimeMs, this.elapsedRealtimeEpochOffsetMs, this.isSeekable, this.isDynamic, this.isLive, j2, this.windowDurationUs, 0, 0, this.windowPositionInPeriodUs);
        }
        j2 = j3;
        return window.set(Timeline.Window.SINGLE_WINDOW_UID, this.tag, this.manifest, this.presentationStartTimeMs, this.windowStartTimeMs, this.elapsedRealtimeEpochOffsetMs, this.isSeekable, this.isDynamic, this.isLive, j2, this.windowDurationUs, 0, 0, this.windowPositionInPeriodUs);
    }

    public final Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
        Assertions.checkIndex(i, 0, 1);
        return period.set(null, z ? UID : null, 0, this.periodDurationUs, -this.windowPositionInPeriodUs);
    }

    public final int getIndexOfPeriod(Object obj) {
        return UID.equals(obj) ? 0 : -1;
    }

    public final Object getUidOfPeriod(int i) {
        Assertions.checkIndex(i, 0, 1);
        return UID;
    }
}
