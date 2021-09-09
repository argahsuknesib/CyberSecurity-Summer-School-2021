package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.common.internal.GmsLogger;
import java.io.IOException;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class FlacFrameReader {

    public static final class SampleNumberHolder {
        public long sampleNumber;
    }

    public static boolean checkAndReadFrameHeader(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int i, SampleNumberHolder sampleNumberHolder) {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        FlacStreamMetadata flacStreamMetadata2 = flacStreamMetadata;
        int position = parsableByteArray.getPosition();
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        long j = readUnsignedInt >>> 16;
        if (j != ((long) i)) {
            return false;
        }
        return checkChannelAssignment((int) (15 & (readUnsignedInt >> 4)), flacStreamMetadata2) && checkBitsPerSample((int) ((readUnsignedInt >> 1) & 7), flacStreamMetadata2) && !(((readUnsignedInt & 1) > 1 ? 1 : ((readUnsignedInt & 1) == 1 ? 0 : -1)) == 0) && checkAndReadFirstSampleNumber(parsableByteArray2, flacStreamMetadata2, ((j & 1) > 1 ? 1 : ((j & 1) == 1 ? 0 : -1)) == 0, sampleNumberHolder) && checkAndReadBlockSizeSamples(parsableByteArray2, flacStreamMetadata2, (int) ((readUnsignedInt >> 12) & 15)) && checkAndReadSampleRate(parsableByteArray2, flacStreamMetadata2, (int) ((readUnsignedInt >> 8) & 15)) && checkAndReadCrc(parsableByteArray2, position);
    }

    public static boolean checkFrameHeaderFromPeek(ExtractorInput extractorInput, FlacStreamMetadata flacStreamMetadata, int i, SampleNumberHolder sampleNumberHolder) throws IOException {
        long peekPosition = extractorInput.getPeekPosition();
        byte[] bArr = new byte[2];
        extractorInput.peekFully(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
            extractorInput.resetPeekPosition();
            extractorInput.advancePeekPosition((int) (peekPosition - extractorInput.getPosition()));
            return false;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        System.arraycopy(bArr, 0, parsableByteArray.data, 0, 2);
        parsableByteArray.setLimit(ExtractorUtil.peekToLength(extractorInput, parsableByteArray.data, 2, 14));
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition((int) (peekPosition - extractorInput.getPosition()));
        return checkAndReadFrameHeader(parsableByteArray, flacStreamMetadata, i, sampleNumberHolder);
    }

    public static long getFirstSampleNumber(ExtractorInput extractorInput, FlacStreamMetadata flacStreamMetadata) throws IOException {
        extractorInput.resetPeekPosition();
        boolean z = true;
        extractorInput.advancePeekPosition(1);
        byte[] bArr = new byte[1];
        extractorInput.peekFully(bArr, 0, 1);
        if ((bArr[0] & 1) != 1) {
            z = false;
        }
        extractorInput.advancePeekPosition(2);
        int i = z ? 7 : 6;
        ParsableByteArray parsableByteArray = new ParsableByteArray(i);
        parsableByteArray.setLimit(ExtractorUtil.peekToLength(extractorInput, parsableByteArray.data, 0, i));
        extractorInput.resetPeekPosition();
        SampleNumberHolder sampleNumberHolder = new SampleNumberHolder();
        if (checkAndReadFirstSampleNumber(parsableByteArray, flacStreamMetadata, z, sampleNumberHolder)) {
            return sampleNumberHolder.sampleNumber;
        }
        throw new ParserException();
    }

    public static int readFrameBlockSizeSamplesFromKey(ParsableByteArray parsableByteArray, int i) {
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return parsableByteArray.readUnsignedByte() + 1;
            case 7:
                return parsableByteArray.readUnsignedShort() + 1;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
            case 9:
            case 10:
            case 11:
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
            case 13:
            case 14:
            case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }

    private static boolean checkChannelAssignment(int i, FlacStreamMetadata flacStreamMetadata) {
        return i <= 7 ? i == flacStreamMetadata.channels - 1 : i <= 10 && flacStreamMetadata.channels == 2;
    }

    private static boolean checkBitsPerSample(int i, FlacStreamMetadata flacStreamMetadata) {
        return i == 0 || i == flacStreamMetadata.bitsPerSampleLookupKey;
    }

    private static boolean checkAndReadFirstSampleNumber(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, boolean z, SampleNumberHolder sampleNumberHolder) {
        try {
            long readUtf8EncodedLong = parsableByteArray.readUtf8EncodedLong();
            if (!z) {
                readUtf8EncodedLong *= (long) flacStreamMetadata.maxBlockSizeSamples;
            }
            sampleNumberHolder.sampleNumber = readUtf8EncodedLong;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    private static boolean checkAndReadBlockSizeSamples(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int i) {
        int readFrameBlockSizeSamplesFromKey = readFrameBlockSizeSamplesFromKey(parsableByteArray, i);
        return readFrameBlockSizeSamplesFromKey != -1 && readFrameBlockSizeSamplesFromKey <= flacStreamMetadata.maxBlockSizeSamples;
    }

    private static boolean checkAndReadSampleRate(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int i) {
        int i2 = flacStreamMetadata.sampleRate;
        if (i == 0) {
            return true;
        }
        if (i <= 11) {
            return i == flacStreamMetadata.sampleRateLookupKey;
        }
        if (i == 12) {
            return parsableByteArray.readUnsignedByte() * 1000 == i2;
        }
        if (i <= 14) {
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            if (i == 14) {
                readUnsignedShort *= 10;
            }
            if (readUnsignedShort == i2) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkAndReadCrc(ParsableByteArray parsableByteArray, int i) {
        return parsableByteArray.readUnsignedByte() == Util.crc8(parsableByteArray.data, i, parsableByteArray.getPosition() - 1, 0);
    }

    private FlacFrameReader() {
    }
}
