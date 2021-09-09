package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.source.dash.DashSegmentIndex;

final class SingleSegmentIndex implements DashSegmentIndex {
    private final RangedUri uri;

    public final long getDurationUs(long j, long j2) {
        return j2;
    }

    public final long getFirstSegmentNum() {
        return 0;
    }

    public final int getSegmentCount(long j) {
        return 1;
    }

    public final long getSegmentNum(long j, long j2) {
        return 0;
    }

    public final long getTimeUs(long j) {
        return 0;
    }

    public final boolean isExplicit() {
        return true;
    }

    public SingleSegmentIndex(RangedUri rangedUri) {
        this.uri = rangedUri;
    }

    public final RangedUri getSegmentUrl(long j) {
        return this.uri;
    }
}
