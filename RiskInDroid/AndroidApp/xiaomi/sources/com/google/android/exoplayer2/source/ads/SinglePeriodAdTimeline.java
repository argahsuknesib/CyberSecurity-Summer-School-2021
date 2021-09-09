package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ForwardingTimeline;
import com.google.android.exoplayer2.util.Assertions;

public final class SinglePeriodAdTimeline extends ForwardingTimeline {
    private final AdPlaybackState adPlaybackState;

    public SinglePeriodAdTimeline(Timeline timeline, AdPlaybackState adPlaybackState2) {
        super(timeline);
        boolean z = false;
        Assertions.checkState(timeline.getPeriodCount() == 1);
        Assertions.checkState(timeline.getWindowCount() == 1 ? true : z);
        this.adPlaybackState = adPlaybackState2;
    }

    public final Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
        this.timeline.getPeriod(i, period, z);
        period.set(period.id, period.uid, period.windowIndex, period.durationUs, period.getPositionInWindowUs(), this.adPlaybackState);
        return period;
    }

    public final Timeline.Window getWindow(int i, Timeline.Window window, long j) {
        Timeline.Window window2 = super.getWindow(i, window, j);
        if (window2.durationUs == -9223372036854775807L) {
            window2.durationUs = this.adPlaybackState.contentDurationUs;
        }
        return window2;
    }
}
