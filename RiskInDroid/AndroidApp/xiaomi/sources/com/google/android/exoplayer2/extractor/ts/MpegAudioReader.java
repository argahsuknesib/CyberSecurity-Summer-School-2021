package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class MpegAudioReader implements ElementaryStreamReader {
    private String formatId;
    private int frameBytesRead;
    private long frameDurationUs;
    private int frameSize;
    private boolean hasOutputFormat;
    private final MpegAudioUtil.Header header;
    private final ParsableByteArray headerScratch;
    private final String language;
    private boolean lastByteWasFF;
    private TrackOutput output;
    private int state;
    private long timeUs;

    public final void packetFinished() {
    }

    public MpegAudioReader() {
        this(null);
    }

    public MpegAudioReader(String str) {
        this.state = 0;
        this.headerScratch = new ParsableByteArray(4);
        this.headerScratch.data[0] = -1;
        this.header = new MpegAudioUtil.Header();
        this.language = str;
    }

    public final void seek() {
        this.state = 0;
        this.frameBytesRead = 0;
        this.lastByteWasFF = false;
    }

    public final void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
    }

    public final void packetStarted(long j, int i) {
        this.timeUs = j;
    }

    public final void consume(ParsableByteArray parsableByteArray) {
        Assertions.checkStateNotNull(this.output);
        while (parsableByteArray.bytesLeft() > 0) {
            int i = this.state;
            if (i == 0) {
                findHeader(parsableByteArray);
            } else if (i == 1) {
                readHeaderRemainder(parsableByteArray);
            } else if (i == 2) {
                readFrameRemainder(parsableByteArray);
            } else {
                throw new IllegalStateException();
            }
        }
    }

    private void findHeader(ParsableByteArray parsableByteArray) {
        byte[] bArr = parsableByteArray.data;
        int limit = parsableByteArray.limit();
        for (int position = parsableByteArray.getPosition(); position < limit; position++) {
            boolean z = (bArr[position] & 255) == 255;
            boolean z2 = this.lastByteWasFF && (bArr[position] & 224) == 224;
            this.lastByteWasFF = z;
            if (z2) {
                parsableByteArray.setPosition(position + 1);
                this.lastByteWasFF = false;
                this.headerScratch.data[1] = bArr[position];
                this.frameBytesRead = 2;
                this.state = 1;
                return;
            }
        }
        parsableByteArray.setPosition(limit);
    }

    private void readHeaderRemainder(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.bytesLeft(), 4 - this.frameBytesRead);
        parsableByteArray.readBytes(this.headerScratch.data, this.frameBytesRead, min);
        this.frameBytesRead += min;
        if (this.frameBytesRead >= 4) {
            this.headerScratch.setPosition(0);
            if (!this.header.setForHeaderData(this.headerScratch.readInt())) {
                this.frameBytesRead = 0;
                this.state = 1;
                return;
            }
            this.frameSize = this.header.frameSize;
            if (!this.hasOutputFormat) {
                this.frameDurationUs = (((long) this.header.samplesPerFrame) * 1000000) / ((long) this.header.sampleRate);
                this.output.format(new Format.Builder().setId(this.formatId).setSampleMimeType(this.header.mimeType).setMaxInputSize(4096).setChannelCount(this.header.channels).setSampleRate(this.header.sampleRate).setLanguage(this.language).build());
                this.hasOutputFormat = true;
            }
            this.headerScratch.setPosition(0);
            this.output.sampleData(this.headerScratch, 4);
            this.state = 2;
        }
    }

    private void readFrameRemainder(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.bytesLeft(), this.frameSize - this.frameBytesRead);
        this.output.sampleData(parsableByteArray, min);
        this.frameBytesRead += min;
        int i = this.frameBytesRead;
        int i2 = this.frameSize;
        if (i >= i2) {
            this.output.sampleMetadata(this.timeUs, 1, i2, 0, null);
            this.timeUs += this.frameDurationUs;
            this.frameBytesRead = 0;
            this.state = 0;
        }
    }
}
