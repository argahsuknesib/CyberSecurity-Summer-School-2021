package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.ParserException;
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
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class TsExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = $$Lambda$TsExtractor$fUE6PC86cqq4VqVoFQnPhfFZ8.INSTANCE;
    private int bytesSinceLastSync;
    private final SparseIntArray continuityCounters;
    private final TsDurationReader durationReader;
    private boolean hasOutputSeekMap;
    public TsPayloadReader id3Reader;
    public final int mode;
    public ExtractorOutput output;
    public final TsPayloadReader.Factory payloadReaderFactory;
    public int pcrPid;
    private boolean pendingSeekToStart;
    public int remainingPmts;
    public final List<TimestampAdjuster> timestampAdjusters;
    public final SparseBooleanArray trackIds;
    public final SparseBooleanArray trackPids;
    public boolean tracksEnded;
    private TsBinarySearchSeeker tsBinarySearchSeeker;
    private final ParsableByteArray tsPacketBuffer;
    public final SparseArray<TsPayloadReader> tsPayloadReaders;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public final void release() {
    }

    static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new TsExtractor()};
    }

    public TsExtractor() {
        this(0);
    }

    public TsExtractor(int i) {
        this(1, i);
    }

    public TsExtractor(int i, int i2) {
        this(i, new TimestampAdjuster(0), new DefaultTsPayloadReaderFactory(i2));
    }

    public TsExtractor(int i, TimestampAdjuster timestampAdjuster, TsPayloadReader.Factory factory) {
        this.payloadReaderFactory = (TsPayloadReader.Factory) Assertions.checkNotNull(factory);
        this.mode = i;
        if (i == 1 || i == 2) {
            this.timestampAdjusters = Collections.singletonList(timestampAdjuster);
        } else {
            this.timestampAdjusters = new ArrayList();
            this.timestampAdjusters.add(timestampAdjuster);
        }
        this.tsPacketBuffer = new ParsableByteArray(new byte[9400], 0);
        this.trackIds = new SparseBooleanArray();
        this.trackPids = new SparseBooleanArray();
        this.tsPayloadReaders = new SparseArray<>();
        this.continuityCounters = new SparseIntArray();
        this.durationReader = new TsDurationReader();
        this.pcrPid = -1;
        resetPayloadReaders();
    }

    public final boolean sniff(ExtractorInput extractorInput) throws IOException {
        boolean z;
        byte[] bArr = this.tsPacketBuffer.data;
        extractorInput.peekFully(bArr, 0, 940);
        for (int i = 0; i < 188; i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= 5) {
                    z = true;
                    break;
                } else if (bArr[(i2 * 188) + i] != 71) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                extractorInput.skipFully(i);
                return true;
            }
        }
        return false;
    }

    public final void init(ExtractorOutput extractorOutput) {
        this.output = extractorOutput;
    }

    public final void seek(long j, long j2) {
        TsBinarySearchSeeker tsBinarySearchSeeker2;
        Assertions.checkState(this.mode != 2);
        int size = this.timestampAdjusters.size();
        for (int i = 0; i < size; i++) {
            TimestampAdjuster timestampAdjuster = this.timestampAdjusters.get(i);
            if ((timestampAdjuster.getTimestampOffsetUs() == -9223372036854775807L) || !(timestampAdjuster.getTimestampOffsetUs() == 0 || timestampAdjuster.getFirstSampleTimestampUs() == j2)) {
                timestampAdjuster.reset();
                timestampAdjuster.setFirstSampleTimestampUs(j2);
            }
        }
        if (!(j2 == 0 || (tsBinarySearchSeeker2 = this.tsBinarySearchSeeker) == null)) {
            tsBinarySearchSeeker2.setSeekTargetUs(j2);
        }
        this.tsPacketBuffer.reset();
        this.continuityCounters.clear();
        for (int i2 = 0; i2 < this.tsPayloadReaders.size(); i2++) {
            this.tsPayloadReaders.valueAt(i2).seek();
        }
        this.bytesSinceLastSync = 0;
    }

    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        ExtractorInput extractorInput2 = extractorInput;
        PositionHolder positionHolder2 = positionHolder;
        long length = extractorInput.getLength();
        if (this.tracksEnded) {
            if (((length == -1 || this.mode == 2) ? false : true) && !this.durationReader.isDurationReadFinished()) {
                return this.durationReader.readDuration(extractorInput2, positionHolder2, this.pcrPid);
            }
            maybeOutputSeekMap(length);
            if (this.pendingSeekToStart) {
                this.pendingSeekToStart = false;
                seek(0, 0);
                if (extractorInput.getPosition() != 0) {
                    positionHolder2.position = 0;
                    return 1;
                }
            }
            TsBinarySearchSeeker tsBinarySearchSeeker2 = this.tsBinarySearchSeeker;
            if (tsBinarySearchSeeker2 != null && tsBinarySearchSeeker2.isSeeking()) {
                return this.tsBinarySearchSeeker.handlePendingSeek(extractorInput2, positionHolder2);
            }
        }
        if (!fillBufferWithAtLeastOnePacket(extractorInput)) {
            return -1;
        }
        int findEndOfFirstTsPacketInBuffer = findEndOfFirstTsPacketInBuffer();
        int limit = this.tsPacketBuffer.limit();
        if (findEndOfFirstTsPacketInBuffer > limit) {
            return 0;
        }
        int readInt = this.tsPacketBuffer.readInt();
        if ((8388608 & readInt) != 0) {
            this.tsPacketBuffer.setPosition(findEndOfFirstTsPacketInBuffer);
            return 0;
        }
        int i = ((4194304 & readInt) != 0 ? 1 : 0) | 0;
        int i2 = (2096896 & readInt) >> 8;
        boolean z = (readInt & 32) != 0;
        TsPayloadReader tsPayloadReader = (readInt & 16) != 0 ? this.tsPayloadReaders.get(i2) : null;
        if (tsPayloadReader == null) {
            this.tsPacketBuffer.setPosition(findEndOfFirstTsPacketInBuffer);
            return 0;
        }
        if (this.mode != 2) {
            int i3 = readInt & 15;
            int i4 = this.continuityCounters.get(i2, i3 - 1);
            this.continuityCounters.put(i2, i3);
            if (i4 == i3) {
                this.tsPacketBuffer.setPosition(findEndOfFirstTsPacketInBuffer);
                return 0;
            } else if (i3 != ((i4 + 1) & 15)) {
                tsPayloadReader.seek();
            }
        }
        if (z) {
            int readUnsignedByte = this.tsPacketBuffer.readUnsignedByte();
            i |= (this.tsPacketBuffer.readUnsignedByte() & 64) != 0 ? 2 : 0;
            this.tsPacketBuffer.skipBytes(readUnsignedByte - 1);
        }
        boolean z2 = this.tracksEnded;
        if (shouldConsumePacketPayload(i2)) {
            this.tsPacketBuffer.setLimit(findEndOfFirstTsPacketInBuffer);
            tsPayloadReader.consume(this.tsPacketBuffer, i);
            this.tsPacketBuffer.setLimit(limit);
        }
        if (this.mode != 2 && !z2 && this.tracksEnded && length != -1) {
            this.pendingSeekToStart = true;
        }
        this.tsPacketBuffer.setPosition(findEndOfFirstTsPacketInBuffer);
        return 0;
    }

    private void maybeOutputSeekMap(long j) {
        if (!this.hasOutputSeekMap) {
            this.hasOutputSeekMap = true;
            if (this.durationReader.getDurationUs() != -9223372036854775807L) {
                this.tsBinarySearchSeeker = new TsBinarySearchSeeker(this.durationReader.getPcrTimestampAdjuster(), this.durationReader.getDurationUs(), j, this.pcrPid);
                this.output.seekMap(this.tsBinarySearchSeeker.getSeekMap());
                return;
            }
            this.output.seekMap(new SeekMap.Unseekable(this.durationReader.getDurationUs()));
        }
    }

    private boolean fillBufferWithAtLeastOnePacket(ExtractorInput extractorInput) throws IOException {
        byte[] bArr = this.tsPacketBuffer.data;
        if (9400 - this.tsPacketBuffer.getPosition() < 188) {
            int bytesLeft = this.tsPacketBuffer.bytesLeft();
            if (bytesLeft > 0) {
                System.arraycopy(bArr, this.tsPacketBuffer.getPosition(), bArr, 0, bytesLeft);
            }
            this.tsPacketBuffer.reset(bArr, bytesLeft);
        }
        while (this.tsPacketBuffer.bytesLeft() < 188) {
            int limit = this.tsPacketBuffer.limit();
            int read = extractorInput.read(bArr, limit, 9400 - limit);
            if (read == -1) {
                return false;
            }
            this.tsPacketBuffer.setLimit(limit + read);
        }
        return true;
    }

    private int findEndOfFirstTsPacketInBuffer() throws ParserException {
        int position = this.tsPacketBuffer.getPosition();
        int limit = this.tsPacketBuffer.limit();
        int findSyncBytePosition = TsUtil.findSyncBytePosition(this.tsPacketBuffer.data, position, limit);
        this.tsPacketBuffer.setPosition(findSyncBytePosition);
        int i = findSyncBytePosition + 188;
        if (i > limit) {
            this.bytesSinceLastSync += findSyncBytePosition - position;
            if (this.mode == 2 && this.bytesSinceLastSync > 376) {
                throw new ParserException("Cannot find sync byte. Most likely not a Transport Stream.");
            }
        } else {
            this.bytesSinceLastSync = 0;
        }
        return i;
    }

    private boolean shouldConsumePacketPayload(int i) {
        if (this.mode == 2 || this.tracksEnded || !this.trackPids.get(i, false)) {
            return true;
        }
        return false;
    }

    private void resetPayloadReaders() {
        this.trackIds.clear();
        this.tsPayloadReaders.clear();
        SparseArray<TsPayloadReader> createInitialPayloadReaders = this.payloadReaderFactory.createInitialPayloadReaders();
        int size = createInitialPayloadReaders.size();
        for (int i = 0; i < size; i++) {
            this.tsPayloadReaders.put(createInitialPayloadReaders.keyAt(i), createInitialPayloadReaders.valueAt(i));
        }
        this.tsPayloadReaders.put(0, new SectionReader(new PatReader()));
        this.id3Reader = null;
    }

    class PatReader implements SectionPayloadReader {
        private final ParsableBitArray patScratch = new ParsableBitArray(new byte[4]);

        public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        }

        public PatReader() {
        }

        public void consume(ParsableByteArray parsableByteArray) {
            if (parsableByteArray.readUnsignedByte() == 0) {
                parsableByteArray.skipBytes(7);
                int bytesLeft = parsableByteArray.bytesLeft() / 4;
                for (int i = 0; i < bytesLeft; i++) {
                    parsableByteArray.readBytes(this.patScratch, 4);
                    int readBits = this.patScratch.readBits(16);
                    this.patScratch.skipBits(3);
                    if (readBits == 0) {
                        this.patScratch.skipBits(13);
                    } else {
                        int readBits2 = this.patScratch.readBits(13);
                        TsExtractor.this.tsPayloadReaders.put(readBits2, new SectionReader(new PmtReader(readBits2)));
                        TsExtractor.this.remainingPmts++;
                    }
                }
                if (TsExtractor.this.mode != 2) {
                    TsExtractor.this.tsPayloadReaders.remove(0);
                }
            }
        }
    }

    class PmtReader implements SectionPayloadReader {
        private final int pid;
        private final ParsableBitArray pmtScratch = new ParsableBitArray(new byte[5]);
        private final SparseIntArray trackIdToPidScratch = new SparseIntArray();
        private final SparseArray<TsPayloadReader> trackIdToReaderScratch = new SparseArray<>();

        public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        }

        public PmtReader(int i) {
            this.pid = i;
        }

        public void consume(ParsableByteArray parsableByteArray) {
            TimestampAdjuster timestampAdjuster;
            TsPayloadReader tsPayloadReader;
            ParsableByteArray parsableByteArray2 = parsableByteArray;
            if (parsableByteArray.readUnsignedByte() == 2) {
                if (TsExtractor.this.mode == 1 || TsExtractor.this.mode == 2 || TsExtractor.this.remainingPmts == 1) {
                    timestampAdjuster = TsExtractor.this.timestampAdjusters.get(0);
                } else {
                    timestampAdjuster = new TimestampAdjuster(TsExtractor.this.timestampAdjusters.get(0).getFirstSampleTimestampUs());
                    TsExtractor.this.timestampAdjusters.add(timestampAdjuster);
                }
                parsableByteArray2.skipBytes(2);
                int readUnsignedShort = parsableByteArray.readUnsignedShort();
                int i = 3;
                parsableByteArray2.skipBytes(3);
                parsableByteArray2.readBytes(this.pmtScratch, 2);
                this.pmtScratch.skipBits(3);
                int i2 = 13;
                TsExtractor.this.pcrPid = this.pmtScratch.readBits(13);
                parsableByteArray2.readBytes(this.pmtScratch, 2);
                int i3 = 4;
                this.pmtScratch.skipBits(4);
                parsableByteArray2.skipBytes(this.pmtScratch.readBits(12));
                if (TsExtractor.this.mode == 2 && TsExtractor.this.id3Reader == null) {
                    TsPayloadReader.EsInfo esInfo = new TsPayloadReader.EsInfo(21, null, null, Util.EMPTY_BYTE_ARRAY);
                    TsExtractor tsExtractor = TsExtractor.this;
                    tsExtractor.id3Reader = tsExtractor.payloadReaderFactory.createPayloadReader(21, esInfo);
                    TsExtractor.this.id3Reader.init(timestampAdjuster, TsExtractor.this.output, new TsPayloadReader.TrackIdGenerator(readUnsignedShort, 21, 8192));
                }
                this.trackIdToReaderScratch.clear();
                this.trackIdToPidScratch.clear();
                int bytesLeft = parsableByteArray.bytesLeft();
                while (bytesLeft > 0) {
                    parsableByteArray2.readBytes(this.pmtScratch, 5);
                    int readBits = this.pmtScratch.readBits(8);
                    this.pmtScratch.skipBits(i);
                    int readBits2 = this.pmtScratch.readBits(i2);
                    this.pmtScratch.skipBits(i3);
                    int readBits3 = this.pmtScratch.readBits(12);
                    TsPayloadReader.EsInfo readEsInfo = readEsInfo(parsableByteArray2, readBits3);
                    if (readBits == 6 || readBits == 5) {
                        readBits = readEsInfo.streamType;
                    }
                    bytesLeft -= readBits3 + 5;
                    int i4 = TsExtractor.this.mode == 2 ? readBits : readBits2;
                    if (!TsExtractor.this.trackIds.get(i4)) {
                        if (TsExtractor.this.mode == 2 && readBits == 21) {
                            tsPayloadReader = TsExtractor.this.id3Reader;
                        } else {
                            tsPayloadReader = TsExtractor.this.payloadReaderFactory.createPayloadReader(readBits, readEsInfo);
                        }
                        if (TsExtractor.this.mode != 2 || readBits2 < this.trackIdToPidScratch.get(i4, 8192)) {
                            this.trackIdToPidScratch.put(i4, readBits2);
                            this.trackIdToReaderScratch.put(i4, tsPayloadReader);
                        }
                    }
                    i = 3;
                    i3 = 4;
                    i2 = 13;
                }
                int size = this.trackIdToPidScratch.size();
                for (int i5 = 0; i5 < size; i5++) {
                    int keyAt = this.trackIdToPidScratch.keyAt(i5);
                    int valueAt = this.trackIdToPidScratch.valueAt(i5);
                    TsExtractor.this.trackIds.put(keyAt, true);
                    TsExtractor.this.trackPids.put(valueAt, true);
                    TsPayloadReader valueAt2 = this.trackIdToReaderScratch.valueAt(i5);
                    if (valueAt2 != null) {
                        if (valueAt2 != TsExtractor.this.id3Reader) {
                            valueAt2.init(timestampAdjuster, TsExtractor.this.output, new TsPayloadReader.TrackIdGenerator(readUnsignedShort, keyAt, 8192));
                        }
                        TsExtractor.this.tsPayloadReaders.put(valueAt, valueAt2);
                    }
                }
                if (TsExtractor.this.mode != 2) {
                    int i6 = 0;
                    TsExtractor.this.tsPayloadReaders.remove(this.pid);
                    TsExtractor tsExtractor2 = TsExtractor.this;
                    if (tsExtractor2.mode != 1) {
                        i6 = TsExtractor.this.remainingPmts - 1;
                    }
                    tsExtractor2.remainingPmts = i6;
                    if (TsExtractor.this.remainingPmts == 0) {
                        TsExtractor.this.output.endTracks();
                        TsExtractor.this.tracksEnded = true;
                    }
                } else if (!TsExtractor.this.tracksEnded) {
                    TsExtractor.this.output.endTracks();
                    TsExtractor tsExtractor3 = TsExtractor.this;
                    tsExtractor3.remainingPmts = 0;
                    tsExtractor3.tracksEnded = true;
                }
            }
        }

        private TsPayloadReader.EsInfo readEsInfo(ParsableByteArray parsableByteArray, int i) {
            int position = parsableByteArray.getPosition();
            int i2 = i + position;
            String str = null;
            int i3 = -1;
            ArrayList arrayList = null;
            while (parsableByteArray.getPosition() < i2) {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                int position2 = parsableByteArray.getPosition() + parsableByteArray.readUnsignedByte();
                if (readUnsignedByte == 5) {
                    long readUnsignedInt = parsableByteArray.readUnsignedInt();
                    if (readUnsignedInt != 1094921523) {
                        if (readUnsignedInt != 1161904947) {
                            if (readUnsignedInt != 1094921524) {
                                if (readUnsignedInt == 1212503619) {
                                    i3 = 36;
                                }
                                parsableByteArray.skipBytes(position2 - parsableByteArray.getPosition());
                            }
                        }
                        i3 = 135;
                        parsableByteArray.skipBytes(position2 - parsableByteArray.getPosition());
                    }
                    i3 = 129;
                    parsableByteArray.skipBytes(position2 - parsableByteArray.getPosition());
                } else {
                    if (readUnsignedByte != 106) {
                        if (readUnsignedByte != 122) {
                            if (readUnsignedByte == 127) {
                                if (parsableByteArray.readUnsignedByte() != 21) {
                                }
                            } else if (readUnsignedByte == 123) {
                                i3 = 138;
                            } else if (readUnsignedByte == 10) {
                                str = parsableByteArray.readString(3).trim();
                            } else if (readUnsignedByte == 89) {
                                ArrayList arrayList2 = new ArrayList();
                                while (parsableByteArray.getPosition() < position2) {
                                    String trim = parsableByteArray.readString(3).trim();
                                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                                    byte[] bArr = new byte[4];
                                    parsableByteArray.readBytes(bArr, 0, 4);
                                    arrayList2.add(new TsPayloadReader.DvbSubtitleInfo(trim, readUnsignedByte2, bArr));
                                }
                                arrayList = arrayList2;
                                i3 = 89;
                            } else if (readUnsignedByte == 111) {
                                i3 = 257;
                            }
                            parsableByteArray.skipBytes(position2 - parsableByteArray.getPosition());
                        }
                        i3 = 135;
                        parsableByteArray.skipBytes(position2 - parsableByteArray.getPosition());
                    }
                    i3 = 129;
                    parsableByteArray.skipBytes(position2 - parsableByteArray.getPosition());
                }
                i3 = 172;
                parsableByteArray.skipBytes(position2 - parsableByteArray.getPosition());
            }
            parsableByteArray.setPosition(i2);
            return new TsPayloadReader.EsInfo(i3, str, arrayList, Arrays.copyOfRange(parsableByteArray.data, position, i2));
        }
    }
}
