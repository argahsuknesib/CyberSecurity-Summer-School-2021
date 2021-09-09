package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;

public final class PassthroughSectionPayloadReader implements SectionPayloadReader {
    private Format format;
    private TrackOutput output;
    private TimestampAdjuster timestampAdjuster;

    public PassthroughSectionPayloadReader(String str) {
        this.format = new Format.Builder().setSampleMimeType(str).build();
    }

    public final void init(TimestampAdjuster timestampAdjuster2, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.timestampAdjuster = timestampAdjuster2;
        trackIdGenerator.generateNewId();
        this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 4);
        this.output.format(this.format);
    }

    public final void consume(ParsableByteArray parsableByteArray) {
        assertInitialized();
        long timestampOffsetUs = this.timestampAdjuster.getTimestampOffsetUs();
        if (timestampOffsetUs != -9223372036854775807L) {
            if (timestampOffsetUs != this.format.subsampleOffsetUs) {
                this.format = this.format.buildUpon().setSubsampleOffsetUs(timestampOffsetUs).build();
                this.output.format(this.format);
            }
            int bytesLeft = parsableByteArray.bytesLeft();
            this.output.sampleData(parsableByteArray, bytesLeft);
            this.output.sampleMetadata(this.timestampAdjuster.getLastAdjustedTimestampUs(), 1, bytesLeft, 0, null);
        }
    }

    private void assertInitialized() {
        Assertions.checkStateNotNull(this.timestampAdjuster);
        Util.castNonNull(this.output);
    }
}
