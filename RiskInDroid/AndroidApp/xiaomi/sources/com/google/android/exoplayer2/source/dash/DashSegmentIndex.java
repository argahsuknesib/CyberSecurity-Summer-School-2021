package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.source.dash.manifest.RangedUri;

public interface DashSegmentIndex {
    long getDurationUs(long j, long j2);

    long getFirstSegmentNum();

    int getSegmentCount(long j);

    long getSegmentNum(long j, long j2);

    RangedUri getSegmentUrl(long j);

    long getTimeUs(long j);

    boolean isExplicit();
}
