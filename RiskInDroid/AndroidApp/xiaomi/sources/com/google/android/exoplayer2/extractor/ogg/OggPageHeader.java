package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;

final class OggPageHeader {
    public int bodySize;
    public long granulePosition;
    public int headerSize;
    public final int[] laces = new int[255];
    public long pageChecksum;
    public int pageSegmentCount;
    public long pageSequenceNumber;
    public int revision;
    private final ParsableByteArray scratch = new ParsableByteArray(255);
    public long streamSerialNumber;
    public int type;

    OggPageHeader() {
    }

    public final void reset() {
        this.revision = 0;
        this.type = 0;
        this.granulePosition = 0;
        this.streamSerialNumber = 0;
        this.pageSequenceNumber = 0;
        this.pageChecksum = 0;
        this.pageSegmentCount = 0;
        this.headerSize = 0;
        this.bodySize = 0;
    }

    public final boolean populate(ExtractorInput extractorInput, boolean z) throws IOException {
        this.scratch.reset();
        reset();
        if (!(extractorInput.getLength() == -1 || extractorInput.getLength() - extractorInput.getPeekPosition() >= 27) || !extractorInput.peekFully(this.scratch.data, 0, 27, true)) {
            if (z) {
                return false;
            }
            throw new EOFException();
        } else if (this.scratch.readUnsignedInt() == 1332176723) {
            this.revision = this.scratch.readUnsignedByte();
            if (this.revision == 0) {
                this.type = this.scratch.readUnsignedByte();
                this.granulePosition = this.scratch.readLittleEndianLong();
                this.streamSerialNumber = this.scratch.readLittleEndianUnsignedInt();
                this.pageSequenceNumber = this.scratch.readLittleEndianUnsignedInt();
                this.pageChecksum = this.scratch.readLittleEndianUnsignedInt();
                this.pageSegmentCount = this.scratch.readUnsignedByte();
                this.headerSize = this.pageSegmentCount + 27;
                this.scratch.reset();
                extractorInput.peekFully(this.scratch.data, 0, this.pageSegmentCount);
                for (int i = 0; i < this.pageSegmentCount; i++) {
                    this.laces[i] = this.scratch.readUnsignedByte();
                    this.bodySize += this.laces[i];
                }
                return true;
            } else if (z) {
                return false;
            } else {
                throw new ParserException("unsupported bit stream revision");
            }
        } else if (z) {
            return false;
        } else {
            throw new ParserException("expected OggS capture pattern at begin of page");
        }
    }
}
