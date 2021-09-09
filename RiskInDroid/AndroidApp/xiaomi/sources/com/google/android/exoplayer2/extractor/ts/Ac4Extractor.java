package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

public final class Ac4Extractor implements Extractor {
    public static final ExtractorsFactory FACTORY = $$Lambda$Ac4Extractor$zjW7KSyjAevbDDyNCjGHEbZskt8.INSTANCE;
    private final Ac4Reader reader = new Ac4Reader();
    private final ParsableByteArray sampleData = new ParsableByteArray(16384);
    private boolean startedPacket;

    public final void release() {
    }

    static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new Ac4Extractor()};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0048, code lost:
        r9.resetPeekPosition();
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0051, code lost:
        if ((r4 - r3) < 8192) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0053, code lost:
        return false;
     */
    public final boolean sniff(ExtractorInput extractorInput) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        int i = 0;
        while (true) {
            extractorInput.peekFully(parsableByteArray.data, 0, 10);
            parsableByteArray.setPosition(0);
            if (parsableByteArray.readUnsignedInt24() != 4801587) {
                break;
            }
            parsableByteArray.skipBytes(3);
            int readSynchSafeInt = parsableByteArray.readSynchSafeInt();
            i += readSynchSafeInt + 10;
            extractorInput.advancePeekPosition(readSynchSafeInt);
        }
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(i);
        int i2 = i;
        while (true) {
            int i3 = 0;
            while (true) {
                extractorInput.peekFully(parsableByteArray.data, 0, 7);
                parsableByteArray.setPosition(0);
                int readUnsignedShort = parsableByteArray.readUnsignedShort();
                if (readUnsignedShort != 44096 && readUnsignedShort != 44097) {
                    break;
                }
                i3++;
                if (i3 >= 4) {
                    return true;
                }
                int parseAc4SyncframeSize = Ac4Util.parseAc4SyncframeSize(parsableByteArray.data, readUnsignedShort);
                if (parseAc4SyncframeSize == -1) {
                    return false;
                }
                extractorInput.advancePeekPosition(parseAc4SyncframeSize - 7);
            }
            extractorInput.advancePeekPosition(i2);
        }
    }

    public final void init(ExtractorOutput extractorOutput) {
        this.reader.createTracks(extractorOutput, new TsPayloadReader.TrackIdGenerator(0, 1));
        extractorOutput.endTracks();
        extractorOutput.seekMap(new SeekMap.Unseekable(-9223372036854775807L));
    }

    public final void seek(long j, long j2) {
        this.startedPacket = false;
        this.reader.seek();
    }

    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int read = extractorInput.read(this.sampleData.data, 0, 16384);
        if (read == -1) {
            return -1;
        }
        this.sampleData.setPosition(0);
        this.sampleData.setLimit(read);
        if (!this.startedPacket) {
            this.reader.packetStarted(0, 4);
            this.startedPacket = true;
        }
        this.reader.consume(this.sampleData);
        return 0;
    }
}
