package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class AdtsExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = $$Lambda$AdtsExtractor$cqGYwjddB4W6E3ogPGiWfjTa23c.INSTANCE;
    private int averageFrameSize;
    private ExtractorOutput extractorOutput;
    private long firstFramePosition;
    private long firstSampleTimestampUs;
    private final int flags;
    private boolean hasCalculatedAverageFrameSize;
    private boolean hasOutputSeekMap;
    private final ParsableByteArray packetBuffer;
    private final AdtsReader reader;
    private final ParsableByteArray scratch;
    private final ParsableBitArray scratchBits;
    private boolean startedPacket;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public final void release() {
    }

    static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new AdtsExtractor()};
    }

    public AdtsExtractor() {
        this(0);
    }

    public AdtsExtractor(int i) {
        this.flags = i;
        this.reader = new AdtsReader(true);
        this.packetBuffer = new ParsableByteArray(2048);
        this.averageFrameSize = -1;
        this.firstFramePosition = -1;
        this.scratch = new ParsableByteArray(10);
        this.scratchBits = new ParsableBitArray(this.scratch.data);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0021, code lost:
        r9.resetPeekPosition();
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002a, code lost:
        if ((r3 - r0) < 8192) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002c, code lost:
        return false;
     */
    public final boolean sniff(ExtractorInput extractorInput) throws IOException {
        int peekId3Header = peekId3Header(extractorInput);
        int i = peekId3Header;
        while (true) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                extractorInput.peekFully(this.scratch.data, 0, 2);
                this.scratch.setPosition(0);
                if (!AdtsReader.isAdtsSyncWord(this.scratch.readUnsignedShort())) {
                    break;
                }
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                extractorInput.peekFully(this.scratch.data, 0, 4);
                this.scratchBits.setPosition(14);
                int readBits = this.scratchBits.readBits(13);
                if (readBits <= 6) {
                    return false;
                }
                extractorInput.advancePeekPosition(readBits - 6);
                i3 += readBits;
            }
            extractorInput.advancePeekPosition(i);
        }
    }

    public final void init(ExtractorOutput extractorOutput2) {
        this.extractorOutput = extractorOutput2;
        this.reader.createTracks(extractorOutput2, new TsPayloadReader.TrackIdGenerator(0, 1));
        extractorOutput2.endTracks();
    }

    public final void seek(long j, long j2) {
        this.startedPacket = false;
        this.reader.seek();
        this.firstSampleTimestampUs = j2;
    }

    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        Assertions.checkStateNotNull(this.extractorOutput);
        long length = extractorInput.getLength();
        boolean z = ((this.flags & 1) == 0 || length == -1) ? false : true;
        if (z) {
            calculateAverageFrameSize(extractorInput);
        }
        int read = extractorInput.read(this.packetBuffer.data, 0, 2048);
        boolean z2 = read == -1;
        maybeOutputSeekMap(length, z, z2);
        if (z2) {
            return -1;
        }
        this.packetBuffer.setPosition(0);
        this.packetBuffer.setLimit(read);
        if (!this.startedPacket) {
            this.reader.packetStarted(this.firstSampleTimestampUs, 4);
            this.startedPacket = true;
        }
        this.reader.consume(this.packetBuffer);
        return 0;
    }

    private int peekId3Header(ExtractorInput extractorInput) throws IOException {
        int i = 0;
        while (true) {
            extractorInput.peekFully(this.scratch.data, 0, 10);
            this.scratch.setPosition(0);
            if (this.scratch.readUnsignedInt24() != 4801587) {
                break;
            }
            this.scratch.skipBytes(3);
            int readSynchSafeInt = this.scratch.readSynchSafeInt();
            i += readSynchSafeInt + 10;
            extractorInput.advancePeekPosition(readSynchSafeInt);
        }
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(i);
        if (this.firstFramePosition == -1) {
            this.firstFramePosition = (long) i;
        }
        return i;
    }

    private void maybeOutputSeekMap(long j, boolean z, boolean z2) {
        if (!this.hasOutputSeekMap) {
            boolean z3 = z && this.averageFrameSize > 0;
            if (!z3 || this.reader.getSampleDurationUs() != -9223372036854775807L || z2) {
                if (!z3 || this.reader.getSampleDurationUs() == -9223372036854775807L) {
                    this.extractorOutput.seekMap(new SeekMap.Unseekable(-9223372036854775807L));
                } else {
                    this.extractorOutput.seekMap(getConstantBitrateSeekMap(j));
                }
                this.hasOutputSeekMap = true;
            }
        }
    }

    private void calculateAverageFrameSize(ExtractorInput extractorInput) throws IOException {
        if (!this.hasCalculatedAverageFrameSize) {
            this.averageFrameSize = -1;
            extractorInput.resetPeekPosition();
            long j = 0;
            if (extractorInput.getPosition() == 0) {
                peekId3Header(extractorInput);
            }
            int i = 0;
            int i2 = 0;
            while (true) {
                try {
                    if (!extractorInput.peekFully(this.scratch.data, 0, 2, true)) {
                        break;
                    }
                    this.scratch.setPosition(0);
                    if (AdtsReader.isAdtsSyncWord(this.scratch.readUnsignedShort())) {
                        if (!extractorInput.peekFully(this.scratch.data, 0, 4, true)) {
                            break;
                        }
                        this.scratchBits.setPosition(14);
                        int readBits = this.scratchBits.readBits(13);
                        if (readBits > 6) {
                            j += (long) readBits;
                            i2++;
                            if (i2 != 1000) {
                                if (!extractorInput.advancePeekPosition(readBits - 6, true)) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            this.hasCalculatedAverageFrameSize = true;
                            throw new ParserException("Malformed ADTS stream");
                        }
                    } else {
                        break;
                    }
                } catch (EOFException unused) {
                }
            }
            i = i2;
            extractorInput.resetPeekPosition();
            if (i > 0) {
                this.averageFrameSize = (int) (j / ((long) i));
            } else {
                this.averageFrameSize = -1;
            }
            this.hasCalculatedAverageFrameSize = true;
        }
    }

    private SeekMap getConstantBitrateSeekMap(long j) {
        return new ConstantBitrateSeekMap(j, this.firstFramePosition, getBitrateFromFrameSize(this.averageFrameSize, this.reader.getSampleDurationUs()), this.averageFrameSize);
    }

    private static int getBitrateFromFrameSize(int i, long j) {
        return (int) ((((long) (i * 8)) * 1000000) / j);
    }
}
