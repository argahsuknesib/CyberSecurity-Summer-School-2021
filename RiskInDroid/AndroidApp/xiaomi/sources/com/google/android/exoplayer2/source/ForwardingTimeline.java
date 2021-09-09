package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;

public abstract class ForwardingTimeline extends Timeline {
    protected final Timeline timeline;

    public ForwardingTimeline(Timeline timeline2) {
        this.timeline = timeline2;
    }

    public int getWindowCount() {
        return this.timeline.getWindowCount();
    }

    public int getNextWindowIndex(int i, int i2, boolean z) {
        return this.timeline.getNextWindowIndex(i, i2, z);
    }

    public int getPreviousWindowIndex(int i, int i2, boolean z) {
        return this.timeline.getPreviousWindowIndex(i, i2, z);
    }

    public int getLastWindowIndex(boolean z) {
        return this.timeline.getLastWindowIndex(z);
    }

    public int getFirstWindowIndex(boolean z) {
        return this.timeline.getFirstWindowIndex(z);
    }

    public Timeline.Window getWindow(int i, Timeline.Window window, long j) {
        return this.timeline.getWindow(i, window, j);
    }

    public int getPeriodCount() {
        return this.timeline.getPeriodCount();
    }

    public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
        return this.timeline.getPeriod(i, period, z);
    }

    public int getIndexOfPeriod(Object obj) {
        return this.timeline.getIndexOfPeriod(obj);
    }

    public Object getUidOfPeriod(int i) {
        return this.timeline.getUidOfPeriod(i);
    }
}
