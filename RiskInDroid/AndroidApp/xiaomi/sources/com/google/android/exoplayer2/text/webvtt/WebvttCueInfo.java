package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.text.Cue;

public final class WebvttCueInfo {
    public final Cue cue;
    public final long endTimeUs;
    public final long startTimeUs;

    public WebvttCueInfo(Cue cue2, long j, long j2) {
        this.cue = cue2;
        this.startTimeUs = j;
        this.endTimeUs = j2;
    }
}
