package com.google.android.exoplayer2.extractor;

public final class DummyExtractorOutput implements ExtractorOutput {
    public final void endTracks() {
    }

    public final void seekMap(SeekMap seekMap) {
    }

    public final TrackOutput track(int i, int i2) {
        return new DummyTrackOutput();
    }
}
