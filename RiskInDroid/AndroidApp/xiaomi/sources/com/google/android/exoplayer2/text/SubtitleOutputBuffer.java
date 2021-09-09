package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.util.List;

public abstract class SubtitleOutputBuffer extends OutputBuffer implements Subtitle {
    private long subsampleOffsetUs;
    private Subtitle subtitle;

    public void setContent(long j, Subtitle subtitle2, long j2) {
        this.timeUs = j;
        this.subtitle = subtitle2;
        if (j2 == Long.MAX_VALUE) {
            j2 = this.timeUs;
        }
        this.subsampleOffsetUs = j2;
    }

    public int getEventTimeCount() {
        return ((Subtitle) Assertions.checkNotNull(this.subtitle)).getEventTimeCount();
    }

    public long getEventTime(int i) {
        return ((Subtitle) Assertions.checkNotNull(this.subtitle)).getEventTime(i) + this.subsampleOffsetUs;
    }

    public int getNextEventTimeIndex(long j) {
        return ((Subtitle) Assertions.checkNotNull(this.subtitle)).getNextEventTimeIndex(j - this.subsampleOffsetUs);
    }

    public List<Cue> getCues(long j) {
        return ((Subtitle) Assertions.checkNotNull(this.subtitle)).getCues(j - this.subsampleOffsetUs);
    }

    public void clear() {
        super.clear();
        this.subtitle = null;
    }
}
