package com.google.android.exoplayer2.extractor.rawcc;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

public final class RawCcExtractor implements Extractor {
    private final ParsableByteArray dataScratch = new ParsableByteArray(9);
    private final Format format;
    private int parserState = 0;
    private int remainingSampleCount;
    private int sampleBytesWritten;
    private long timestampUs;
    private TrackOutput trackOutput;
    private int version;

    public final void release() {
    }

    public RawCcExtractor(Format format2) {
        this.format = format2;
    }

    public final void init(ExtractorOutput extractorOutput) {
        extractorOutput.seekMap(new SeekMap.Unseekable(-9223372036854775807L));
        this.trackOutput = extractorOutput.track(0, 3);
        extractorOutput.endTracks();
        this.trackOutput.format(this.format);
    }

    public final boolean sniff(ExtractorInput extractorInput) throws IOException {
        this.dataScratch.reset();
        extractorInput.peekFully(this.dataScratch.data, 0, 8);
        if (this.dataScratch.readInt() == 1380139777) {
            return true;
        }
        return false;
    }

    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        Assertions.checkStateNotNull(this.trackOutput);
        while (true) {
            int i = this.parserState;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        parseSamples(extractorInput);
                        this.parserState = 1;
                        return 0;
                    }
                    throw new IllegalStateException();
                } else if (parseTimestampAndSampleCount(extractorInput)) {
                    this.parserState = 2;
                } else {
                    this.parserState = 0;
                    return -1;
                }
            } else if (!parseHeader(extractorInput)) {
                return -1;
            } else {
                this.parserState = 1;
            }
        }
    }

    public final void seek(long j, long j2) {
        this.parserState = 0;
    }

    private boolean parseHeader(ExtractorInput extractorInput) throws IOException {
        this.dataScratch.reset();
        if (!extractorInput.readFully(this.dataScratch.data, 0, 8, true)) {
            return false;
        }
        if (this.dataScratch.readInt() == 1380139777) {
            this.version = this.dataScratch.readUnsignedByte();
            return true;
        }
        throw new IOException("Input not RawCC");
    }

    private boolean parseTimestampAndSampleCount(ExtractorInput extractorInput) throws IOException {
        this.dataScratch.reset();
        int i = this.version;
        if (i == 0) {
            if (!extractorInput.readFully(this.dataScratch.data, 0, 5, true)) {
                return false;
            }
            this.timestampUs = (this.dataScratch.readUnsignedInt() * 1000) / 45;
        } else if (i != 1) {
            throw new ParserException("Unsupported version number: " + this.version);
        } else if (!extractorInput.readFully(this.dataScratch.data, 0, 9, true)) {
            return false;
        } else {
            this.timestampUs = this.dataScratch.readLong();
        }
        this.remainingSampleCount = this.dataScratch.readUnsignedByte();
        this.sampleBytesWritten = 0;
        return true;
    }

    private void parseSamples(ExtractorInput extractorInput) throws IOException {
        while (this.remainingSampleCount > 0) {
            this.dataScratch.reset();
            extractorInput.readFully(this.dataScratch.data, 0, 3);
            this.trackOutput.sampleData(this.dataScratch, 3);
            this.sampleBytesWritten += 3;
            this.remainingSampleCount--;
        }
        int i = this.sampleBytesWritten;
        if (i > 0) {
            this.trackOutput.sampleMetadata(this.timestampUs, 1, i, 0, null);
        }
    }
}
