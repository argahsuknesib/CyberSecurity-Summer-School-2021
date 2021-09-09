package com.google.android.exoplayer2.text.dvb;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import java.util.List;

final class DvbSubtitle implements Subtitle {
    private final List<Cue> cues;

    public final long getEventTime(int i) {
        return 0;
    }

    public final int getEventTimeCount() {
        return 1;
    }

    public final int getNextEventTimeIndex(long j) {
        return -1;
    }

    public DvbSubtitle(List<Cue> list) {
        this.cues = list;
    }

    public final List<Cue> getCues(long j) {
        return this.cues;
    }
}
