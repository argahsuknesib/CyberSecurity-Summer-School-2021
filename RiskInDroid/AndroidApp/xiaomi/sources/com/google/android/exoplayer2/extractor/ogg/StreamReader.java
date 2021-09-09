package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

abstract class StreamReader {
    private long currentGranule;
    private ExtractorOutput extractorOutput;
    private boolean formatSet;
    private long lengthOfReadPacket;
    private final OggPacket oggPacket = new OggPacket();
    private OggSeeker oggSeeker;
    private long payloadStartPosition;
    private int sampleRate;
    private boolean seekMapSet;
    private SetupData setupData;
    private int state;
    private long targetGranule;
    private TrackOutput trackOutput;

    /* access modifiers changed from: protected */
    public abstract long preparePayload(ParsableByteArray parsableByteArray);

    /* access modifiers changed from: protected */
    public abstract boolean readHeaders(ParsableByteArray parsableByteArray, long j, SetupData setupData2) throws IOException;

    static class SetupData {
        Format format;
        OggSeeker oggSeeker;

        SetupData() {
        }
    }

    /* access modifiers changed from: package-private */
    public void init(ExtractorOutput extractorOutput2, TrackOutput trackOutput2) {
        this.extractorOutput = extractorOutput2;
        this.trackOutput = trackOutput2;
        reset(true);
    }

    /* access modifiers changed from: protected */
    public void reset(boolean z) {
        if (z) {
            this.setupData = new SetupData();
            this.payloadStartPosition = 0;
            this.state = 0;
        } else {
            this.state = 1;
        }
        this.targetGranule = -1;
        this.currentGranule = 0;
    }

    /* access modifiers changed from: package-private */
    public final void seek(long j, long j2) {
        this.oggPacket.reset();
        if (j == 0) {
            reset(!this.seekMapSet);
        } else if (this.state != 0) {
            this.targetGranule = convertTimeToGranule(j2);
            this.oggSeeker.startSeek(this.targetGranule);
            this.state = 2;
        }
    }

    /* access modifiers changed from: package-private */
    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i = this.state;
        if (i == 0) {
            return readHeaders(extractorInput);
        }
        if (i == 1) {
            extractorInput.skipFully((int) this.payloadStartPosition);
            this.state = 2;
            return 0;
        } else if (i == 2) {
            return readPayload(extractorInput, positionHolder);
        } else {
            throw new IllegalStateException();
        }
    }

    private int readHeaders(ExtractorInput extractorInput) throws IOException {
        boolean z = true;
        while (z) {
            if (!this.oggPacket.populate(extractorInput)) {
                this.state = 3;
                return -1;
            }
            this.lengthOfReadPacket = extractorInput.getPosition() - this.payloadStartPosition;
            z = readHeaders(this.oggPacket.getPayload(), this.payloadStartPosition, this.setupData);
            if (z) {
                this.payloadStartPosition = extractorInput.getPosition();
            }
        }
        this.sampleRate = this.setupData.format.sampleRate;
        if (!this.formatSet) {
            this.trackOutput.format(this.setupData.format);
            this.formatSet = true;
        }
        if (this.setupData.oggSeeker != null) {
            this.oggSeeker = this.setupData.oggSeeker;
        } else if (extractorInput.getLength() == -1) {
            this.oggSeeker = new UnseekableOggSeeker();
        } else {
            OggPageHeader pageHeader = this.oggPacket.getPageHeader();
            this.oggSeeker = new DefaultOggSeeker(this, this.payloadStartPosition, extractorInput.getLength(), (long) (pageHeader.headerSize + pageHeader.bodySize), pageHeader.granulePosition, (pageHeader.type & 4) != 0);
        }
        this.setupData = null;
        this.state = 2;
        this.oggPacket.trimPayload();
        return 0;
    }

    private int readPayload(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        ExtractorInput extractorInput2 = extractorInput;
        long read = this.oggSeeker.read(extractorInput2);
        if (read >= 0) {
            positionHolder.position = read;
            return 1;
        }
        if (read < -1) {
            onSeekEnd(-(read + 2));
        }
        if (!this.seekMapSet) {
            this.extractorOutput.seekMap((SeekMap) Assertions.checkStateNotNull(this.oggSeeker.createSeekMap()));
            this.seekMapSet = true;
        }
        if (this.lengthOfReadPacket > 0 || this.oggPacket.populate(extractorInput2)) {
            this.lengthOfReadPacket = 0;
            ParsableByteArray payload = this.oggPacket.getPayload();
            long preparePayload = preparePayload(payload);
            if (preparePayload >= 0) {
                long j = this.currentGranule;
                if (j + preparePayload >= this.targetGranule) {
                    long convertGranuleToTime = convertGranuleToTime(j);
                    this.trackOutput.sampleData(payload, payload.limit());
                    this.trackOutput.sampleMetadata(convertGranuleToTime, 1, payload.limit(), 0, null);
                    this.targetGranule = -1;
                }
            }
            this.currentGranule += preparePayload;
            return 0;
        }
        this.state = 3;
        return -1;
    }

    /* access modifiers changed from: protected */
    public long convertGranuleToTime(long j) {
        return (j * 1000000) / ((long) this.sampleRate);
    }

    /* access modifiers changed from: protected */
    public long convertTimeToGranule(long j) {
        return (((long) this.sampleRate) * j) / 1000000;
    }

    /* access modifiers changed from: protected */
    public void onSeekEnd(long j) {
        this.currentGranule = j;
    }

    static final class UnseekableOggSeeker implements OggSeeker {
        public final long read(ExtractorInput extractorInput) {
            return -1;
        }

        public final void startSeek(long j) {
        }

        private UnseekableOggSeeker() {
        }

        public final SeekMap createSeekMap() {
            return new SeekMap.Unseekable(-9223372036854775807L);
        }
    }
}
