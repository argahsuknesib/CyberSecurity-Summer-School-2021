package com.google.android.exoplayer2.extractor.wav;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.WavUtil;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class WavExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = $$Lambda$WavExtractor$5r6M_S0QCNNj_Xavzq9WwuFHep0.INSTANCE;
    private long dataEndPosition = -1;
    private int dataStartPosition = -1;
    private ExtractorOutput extractorOutput;
    private OutputWriter outputWriter;
    private TrackOutput trackOutput;

    interface OutputWriter {
        void init(int i, long j) throws ParserException;

        void reset(long j);

        boolean sampleData(ExtractorInput extractorInput, long j) throws IOException;
    }

    public final void release() {
    }

    static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new WavExtractor()};
    }

    public final boolean sniff(ExtractorInput extractorInput) throws IOException {
        return WavHeaderReader.peek(extractorInput) != null;
    }

    public final void init(ExtractorOutput extractorOutput2) {
        this.extractorOutput = extractorOutput2;
        this.trackOutput = extractorOutput2.track(0, 1);
        extractorOutput2.endTracks();
    }

    public final void seek(long j, long j2) {
        OutputWriter outputWriter2 = this.outputWriter;
        if (outputWriter2 != null) {
            outputWriter2.reset(j2);
        }
    }

    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        assertInitialized();
        if (this.outputWriter == null) {
            WavHeader peek = WavHeaderReader.peek(extractorInput);
            if (peek == null) {
                throw new ParserException("Unsupported or unrecognized wav header.");
            } else if (peek.formatType == 17) {
                this.outputWriter = new ImaAdPcmOutputWriter(this.extractorOutput, this.trackOutput, peek);
            } else if (peek.formatType == 6) {
                this.outputWriter = new PassthroughOutputWriter(this.extractorOutput, this.trackOutput, peek, "audio/g711-alaw", -1);
            } else if (peek.formatType == 7) {
                this.outputWriter = new PassthroughOutputWriter(this.extractorOutput, this.trackOutput, peek, "audio/g711-mlaw", -1);
            } else {
                int pcmEncodingForType = WavUtil.getPcmEncodingForType(peek.formatType, peek.bitsPerSample);
                if (pcmEncodingForType != 0) {
                    this.outputWriter = new PassthroughOutputWriter(this.extractorOutput, this.trackOutput, peek, "audio/raw", pcmEncodingForType);
                } else {
                    throw new ParserException("Unsupported WAV format type: " + peek.formatType);
                }
            }
        }
        if (this.dataStartPosition == -1) {
            Pair<Long, Long> skipToData = WavHeaderReader.skipToData(extractorInput);
            this.dataStartPosition = ((Long) skipToData.first).intValue();
            this.dataEndPosition = ((Long) skipToData.second).longValue();
            this.outputWriter.init(this.dataStartPosition, this.dataEndPosition);
        } else if (extractorInput.getPosition() == 0) {
            extractorInput.skipFully(this.dataStartPosition);
        }
        Assertions.checkState(this.dataEndPosition != -1);
        if (this.outputWriter.sampleData(extractorInput, this.dataEndPosition - extractorInput.getPosition())) {
            return -1;
        }
        return 0;
    }

    private void assertInitialized() {
        Assertions.checkStateNotNull(this.trackOutput);
        Util.castNonNull(this.extractorOutput);
    }

    static final class PassthroughOutputWriter implements OutputWriter {
        private final ExtractorOutput extractorOutput;
        private final Format format;
        private final WavHeader header;
        private long outputFrameCount;
        private int pendingOutputBytes;
        private long startTimeUs;
        private final int targetSampleSizeBytes;
        private final TrackOutput trackOutput;

        public PassthroughOutputWriter(ExtractorOutput extractorOutput2, TrackOutput trackOutput2, WavHeader wavHeader, String str, int i) throws ParserException {
            this.extractorOutput = extractorOutput2;
            this.trackOutput = trackOutput2;
            this.header = wavHeader;
            int i2 = (wavHeader.numChannels * wavHeader.bitsPerSample) / 8;
            if (wavHeader.blockSize == i2) {
                int i3 = wavHeader.frameRateHz * i2 * 8;
                this.targetSampleSizeBytes = Math.max(i2, (wavHeader.frameRateHz * i2) / 10);
                this.format = new Format.Builder().setSampleMimeType(str).setAverageBitrate(i3).setPeakBitrate(i3).setMaxInputSize(this.targetSampleSizeBytes).setChannelCount(wavHeader.numChannels).setSampleRate(wavHeader.frameRateHz).setPcmEncoding(i).build();
                return;
            }
            throw new ParserException("Expected block size: " + i2 + "; got: " + wavHeader.blockSize);
        }

        public final void reset(long j) {
            this.startTimeUs = j;
            this.pendingOutputBytes = 0;
            this.outputFrameCount = 0;
        }

        public final void init(int i, long j) {
            this.extractorOutput.seekMap(new WavSeekMap(this.header, 1, (long) i, j));
            this.trackOutput.format(this.format);
        }

        public final boolean sampleData(ExtractorInput extractorInput, long j) throws IOException {
            int i;
            int i2;
            long j2 = j;
            while (j2 > 0 && (i = this.pendingOutputBytes) < (i2 = this.targetSampleSizeBytes)) {
                int sampleData = this.trackOutput.sampleData(extractorInput, (int) Math.min((long) (i2 - i), j2), true);
                if (sampleData == -1) {
                    j2 = 0;
                } else {
                    this.pendingOutputBytes += sampleData;
                    j2 -= (long) sampleData;
                }
            }
            int i3 = this.header.blockSize;
            int i4 = this.pendingOutputBytes / i3;
            if (i4 > 0) {
                int i5 = i4 * i3;
                int i6 = this.pendingOutputBytes - i5;
                this.trackOutput.sampleMetadata(this.startTimeUs + Util.scaleLargeTimestamp(this.outputFrameCount, 1000000, (long) this.header.frameRateHz), 1, i5, i6, null);
                this.outputFrameCount += (long) i4;
                this.pendingOutputBytes = i6;
            }
            if (j2 <= 0) {
                return true;
            }
            return false;
        }
    }

    static final class ImaAdPcmOutputWriter implements OutputWriter {
        private static final int[] INDEX_TABLE = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
        private static final int[] STEP_TABLE = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
        private final ParsableByteArray decodedData;
        private final ExtractorOutput extractorOutput;
        private final Format format;
        private final int framesPerBlock;
        private final WavHeader header;
        private final byte[] inputData;
        private long outputFrameCount;
        private int pendingInputBytes;
        private int pendingOutputBytes;
        private long startTimeUs;
        private final int targetSampleSizeFrames;
        private final TrackOutput trackOutput;

        private static int numOutputFramesToBytes(int i, int i2) {
            return i * 2 * i2;
        }

        public ImaAdPcmOutputWriter(ExtractorOutput extractorOutput2, TrackOutput trackOutput2, WavHeader wavHeader) throws ParserException {
            this.extractorOutput = extractorOutput2;
            this.trackOutput = trackOutput2;
            this.header = wavHeader;
            this.targetSampleSizeFrames = Math.max(1, wavHeader.frameRateHz / 10);
            ParsableByteArray parsableByteArray = new ParsableByteArray(wavHeader.extraData);
            parsableByteArray.readLittleEndianUnsignedShort();
            this.framesPerBlock = parsableByteArray.readLittleEndianUnsignedShort();
            int i = wavHeader.numChannels;
            int i2 = (((wavHeader.blockSize - (i * 4)) * 8) / (wavHeader.bitsPerSample * i)) + 1;
            int i3 = this.framesPerBlock;
            if (i3 == i2) {
                int ceilDivide = Util.ceilDivide(this.targetSampleSizeFrames, i3);
                this.inputData = new byte[(wavHeader.blockSize * ceilDivide)];
                this.decodedData = new ParsableByteArray(ceilDivide * numOutputFramesToBytes(this.framesPerBlock, i));
                int i4 = ((wavHeader.frameRateHz * wavHeader.blockSize) * 8) / this.framesPerBlock;
                this.format = new Format.Builder().setSampleMimeType("audio/raw").setAverageBitrate(i4).setPeakBitrate(i4).setMaxInputSize(numOutputFramesToBytes(this.targetSampleSizeFrames, i)).setChannelCount(wavHeader.numChannels).setSampleRate(wavHeader.frameRateHz).setPcmEncoding(2).build();
                return;
            }
            throw new ParserException("Expected frames per block: " + i2 + "; got: " + this.framesPerBlock);
        }

        public final void reset(long j) {
            this.pendingInputBytes = 0;
            this.startTimeUs = j;
            this.pendingOutputBytes = 0;
            this.outputFrameCount = 0;
        }

        public final void init(int i, long j) {
            this.extractorOutput.seekMap(new WavSeekMap(this.header, this.framesPerBlock, (long) i, j));
            this.trackOutput.format(this.format);
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x003f A[EDGE_INSN: B:22:0x003f->B:10:0x003f ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:5:0x0021  */
        public final boolean sampleData(ExtractorInput extractorInput, long j) throws IOException {
            boolean z;
            int i;
            int numOutputBytesToFrames;
            int ceilDivide = Util.ceilDivide(this.targetSampleSizeFrames - numOutputBytesToFrames(this.pendingOutputBytes), this.framesPerBlock) * this.header.blockSize;
            if (j != 0) {
                z = false;
                while (true) {
                    if (!z) {
                        int i2 = this.pendingInputBytes;
                        if (i2 >= ceilDivide) {
                            break;
                        }
                        int read = extractorInput.read(this.inputData, this.pendingInputBytes, (int) Math.min((long) (ceilDivide - i2), j));
                        if (read == -1) {
                            break;
                        }
                        this.pendingInputBytes += read;
                        break;
                        break;
                    }
                    break;
                }
                i = this.pendingInputBytes / this.header.blockSize;
                if (i > 0) {
                    decode(this.inputData, i, this.decodedData);
                    this.pendingInputBytes -= i * this.header.blockSize;
                    int limit = this.decodedData.limit();
                    this.trackOutput.sampleData(this.decodedData, limit);
                    this.pendingOutputBytes += limit;
                    int numOutputBytesToFrames2 = numOutputBytesToFrames(this.pendingOutputBytes);
                    int i3 = this.targetSampleSizeFrames;
                    if (numOutputBytesToFrames2 >= i3) {
                        writeSampleMetadata(i3);
                    }
                }
                if (z && (numOutputBytesToFrames = numOutputBytesToFrames(this.pendingOutputBytes)) > 0) {
                    writeSampleMetadata(numOutputBytesToFrames);
                }
                return z;
            }
            z = true;
            while (true) {
                if (!z) {
                }
                this.pendingInputBytes += read;
            }
            i = this.pendingInputBytes / this.header.blockSize;
            if (i > 0) {
            }
            writeSampleMetadata(numOutputBytesToFrames);
            return z;
        }

        private void writeSampleMetadata(int i) {
            long scaleLargeTimestamp = this.startTimeUs + Util.scaleLargeTimestamp(this.outputFrameCount, 1000000, (long) this.header.frameRateHz);
            int numOutputFramesToBytes = numOutputFramesToBytes(i);
            this.trackOutput.sampleMetadata(scaleLargeTimestamp, 1, numOutputFramesToBytes, this.pendingOutputBytes - numOutputFramesToBytes, null);
            this.outputFrameCount += (long) i;
            this.pendingOutputBytes -= numOutputFramesToBytes;
        }

        private void decode(byte[] bArr, int i, ParsableByteArray parsableByteArray) {
            for (int i2 = 0; i2 < i; i2++) {
                for (int i3 = 0; i3 < this.header.numChannels; i3++) {
                    decodeBlockForChannel(bArr, i2, i3, parsableByteArray.data);
                }
            }
            parsableByteArray.reset(numOutputFramesToBytes(this.framesPerBlock * i));
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.Math.min(int, int):int}
         arg types: [byte, int]
         candidates:
          ClspMth{java.lang.Math.min(double, double):double}
          ClspMth{java.lang.Math.min(float, float):float}
          ClspMth{java.lang.Math.min(long, long):long}
          ClspMth{java.lang.Math.min(int, int):int} */
        private void decodeBlockForChannel(byte[] bArr, int i, int i2, byte[] bArr2) {
            int i3 = this.header.blockSize;
            int i4 = this.header.numChannels;
            int i5 = (i * i3) + (i2 * 4);
            int i6 = (i4 * 4) + i5;
            int i7 = (i3 / i4) - 4;
            short s = (short) (((bArr[i5 + 1] & 255) << 8) | (bArr[i5] & 255));
            int min = Math.min((int) (bArr[i5 + 2] & 255), 88);
            int i8 = STEP_TABLE[min];
            int i9 = ((i * this.framesPerBlock * i4) + i2) * 2;
            bArr2[i9] = (byte) (s & 255);
            bArr2[i9 + 1] = (byte) (s >> 8);
            int i10 = s;
            int i11 = i9;
            for (int i12 = 0; i12 < i7 * 2; i12++) {
                byte b = bArr[((i12 / 8) * i4 * 4) + i6 + ((i12 / 2) % 4)] & 255;
                int i13 = i12 % 2 == 0 ? b & 15 : b >> 4;
                int i14 = ((((i13 & 7) * 2) + 1) * i8) >> 3;
                if ((i13 & 8) != 0) {
                    i14 = -i14;
                }
                i10 = Util.constrainValue(i10 + i14, -32768, 32767);
                i11 += i4 * 2;
                bArr2[i11] = (byte) (i10 & 255);
                bArr2[i11 + 1] = (byte) (i10 >> 8);
                min = Util.constrainValue(min + INDEX_TABLE[i13], 0, STEP_TABLE.length - 1);
                i8 = STEP_TABLE[min];
            }
        }

        private int numOutputBytesToFrames(int i) {
            return i / (this.header.numChannels * 2);
        }

        private int numOutputFramesToBytes(int i) {
            return numOutputFramesToBytes(i, this.header.numChannels);
        }
    }
}
