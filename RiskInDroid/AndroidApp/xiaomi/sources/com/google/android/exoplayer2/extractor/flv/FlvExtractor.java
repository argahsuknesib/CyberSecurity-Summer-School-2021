package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

public final class FlvExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = $$Lambda$FlvExtractor$bd1zICO7fFQot_hbozdu7LjVyE.INSTANCE;
    private AudioTagPayloadReader audioReader;
    private int bytesToNextTagHeader;
    private ExtractorOutput extractorOutput;
    private final ParsableByteArray headerBuffer = new ParsableByteArray(9);
    private long mediaTagTimestampOffsetUs;
    private final ScriptTagPayloadReader metadataReader = new ScriptTagPayloadReader();
    private boolean outputFirstSample;
    private boolean outputSeekMap;
    private final ParsableByteArray scratch = new ParsableByteArray(4);
    private int state = 1;
    private final ParsableByteArray tagData = new ParsableByteArray();
    private int tagDataSize;
    private final ParsableByteArray tagHeaderBuffer = new ParsableByteArray(11);
    private long tagTimestampUs;
    private int tagType;
    private VideoTagPayloadReader videoReader;

    public final void release() {
    }

    static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new FlvExtractor()};
    }

    public final boolean sniff(ExtractorInput extractorInput) throws IOException {
        extractorInput.peekFully(this.scratch.data, 0, 3);
        this.scratch.setPosition(0);
        if (this.scratch.readUnsignedInt24() != 4607062) {
            return false;
        }
        extractorInput.peekFully(this.scratch.data, 0, 2);
        this.scratch.setPosition(0);
        if ((this.scratch.readUnsignedShort() & 250) != 0) {
            return false;
        }
        extractorInput.peekFully(this.scratch.data, 0, 4);
        this.scratch.setPosition(0);
        int readInt = this.scratch.readInt();
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(readInt);
        extractorInput.peekFully(this.scratch.data, 0, 4);
        this.scratch.setPosition(0);
        if (this.scratch.readInt() == 0) {
            return true;
        }
        return false;
    }

    public final void init(ExtractorOutput extractorOutput2) {
        this.extractorOutput = extractorOutput2;
    }

    public final void seek(long j, long j2) {
        this.state = 1;
        this.outputFirstSample = false;
        this.bytesToNextTagHeader = 0;
    }

    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        Assertions.checkStateNotNull(this.extractorOutput);
        while (true) {
            int i = this.state;
            if (i != 1) {
                if (i == 2) {
                    skipToTagHeader(extractorInput);
                } else if (i != 3) {
                    if (i != 4) {
                        throw new IllegalStateException();
                    } else if (readTagData(extractorInput)) {
                        return 0;
                    }
                } else if (!readTagHeader(extractorInput)) {
                    return -1;
                }
            } else if (!readFlvHeader(extractorInput)) {
                return -1;
            }
        }
    }

    private boolean readFlvHeader(ExtractorInput extractorInput) throws IOException {
        boolean z = false;
        if (!extractorInput.readFully(this.headerBuffer.data, 0, 9, true)) {
            return false;
        }
        this.headerBuffer.setPosition(0);
        this.headerBuffer.skipBytes(4);
        int readUnsignedByte = this.headerBuffer.readUnsignedByte();
        boolean z2 = (readUnsignedByte & 4) != 0;
        if ((readUnsignedByte & 1) != 0) {
            z = true;
        }
        if (z2 && this.audioReader == null) {
            this.audioReader = new AudioTagPayloadReader(this.extractorOutput.track(8, 1));
        }
        if (z && this.videoReader == null) {
            this.videoReader = new VideoTagPayloadReader(this.extractorOutput.track(9, 2));
        }
        this.extractorOutput.endTracks();
        this.bytesToNextTagHeader = (this.headerBuffer.readInt() - 9) + 4;
        this.state = 2;
        return true;
    }

    private void skipToTagHeader(ExtractorInput extractorInput) throws IOException {
        extractorInput.skipFully(this.bytesToNextTagHeader);
        this.bytesToNextTagHeader = 0;
        this.state = 3;
    }

    private boolean readTagHeader(ExtractorInput extractorInput) throws IOException {
        if (!extractorInput.readFully(this.tagHeaderBuffer.data, 0, 11, true)) {
            return false;
        }
        this.tagHeaderBuffer.setPosition(0);
        this.tagType = this.tagHeaderBuffer.readUnsignedByte();
        this.tagDataSize = this.tagHeaderBuffer.readUnsignedInt24();
        this.tagTimestampUs = (long) this.tagHeaderBuffer.readUnsignedInt24();
        this.tagTimestampUs = (((long) (this.tagHeaderBuffer.readUnsignedByte() << 24)) | this.tagTimestampUs) * 1000;
        this.tagHeaderBuffer.skipBytes(3);
        this.state = 4;
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0083  */
    private boolean readTagData(ExtractorInput extractorInput) throws IOException {
        boolean z;
        long currentTimestampUs = getCurrentTimestampUs();
        boolean z2 = false;
        if (this.tagType == 8 && this.audioReader != null) {
            ensureReadyForMediaOutput();
            z2 = this.audioReader.consume(prepareTagData(extractorInput), currentTimestampUs);
        } else if (this.tagType == 9 && this.videoReader != null) {
            ensureReadyForMediaOutput();
            z2 = this.videoReader.consume(prepareTagData(extractorInput), currentTimestampUs);
        } else if (this.tagType != 18 || this.outputSeekMap) {
            extractorInput.skipFully(this.tagDataSize);
            z = false;
            if (!this.outputFirstSample && z2) {
                this.outputFirstSample = true;
                this.mediaTagTimestampOffsetUs = this.metadataReader.getDurationUs() != -9223372036854775807L ? -this.tagTimestampUs : 0;
            }
            this.bytesToNextTagHeader = 4;
            this.state = 2;
            return z;
        } else {
            z2 = this.metadataReader.consume(prepareTagData(extractorInput), currentTimestampUs);
            long durationUs = this.metadataReader.getDurationUs();
            if (durationUs != -9223372036854775807L) {
                this.extractorOutput.seekMap(new SeekMap.Unseekable(durationUs));
                this.outputSeekMap = true;
            }
        }
        z = true;
        this.outputFirstSample = true;
        this.mediaTagTimestampOffsetUs = this.metadataReader.getDurationUs() != -9223372036854775807L ? -this.tagTimestampUs : 0;
        this.bytesToNextTagHeader = 4;
        this.state = 2;
        return z;
    }

    private ParsableByteArray prepareTagData(ExtractorInput extractorInput) throws IOException {
        if (this.tagDataSize > this.tagData.capacity()) {
            ParsableByteArray parsableByteArray = this.tagData;
            parsableByteArray.reset(new byte[Math.max(parsableByteArray.capacity() * 2, this.tagDataSize)], 0);
        } else {
            this.tagData.setPosition(0);
        }
        this.tagData.setLimit(this.tagDataSize);
        extractorInput.readFully(this.tagData.data, 0, this.tagDataSize);
        return this.tagData;
    }

    private void ensureReadyForMediaOutput() {
        if (!this.outputSeekMap) {
            this.extractorOutput.seekMap(new SeekMap.Unseekable(-9223372036854775807L));
            this.outputSeekMap = true;
        }
    }

    private long getCurrentTimestampUs() {
        if (this.outputFirstSample) {
            return this.mediaTagTimestampOffsetUs + this.tagTimestampUs;
        }
        if (this.metadataReader.getDurationUs() == -9223372036854775807L) {
            return 0;
        }
        return this.tagTimestampUs;
    }
}
