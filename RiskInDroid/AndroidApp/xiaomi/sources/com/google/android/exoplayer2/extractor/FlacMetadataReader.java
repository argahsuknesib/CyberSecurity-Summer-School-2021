package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class FlacMetadataReader {

    public static final class FlacStreamMetadataHolder {
        public FlacStreamMetadata flacStreamMetadata;

        public FlacStreamMetadataHolder(FlacStreamMetadata flacStreamMetadata2) {
            this.flacStreamMetadata = flacStreamMetadata2;
        }
    }

    public static Metadata peekId3Metadata(ExtractorInput extractorInput, boolean z) throws IOException {
        Metadata peekId3Data = new Id3Peeker().peekId3Data(extractorInput, z ? null : Id3Decoder.NO_FRAMES_PREDICATE);
        if (peekId3Data == null || peekId3Data.length() == 0) {
            return null;
        }
        return peekId3Data;
    }

    public static boolean checkAndPeekStreamMarker(ExtractorInput extractorInput) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        extractorInput.peekFully(parsableByteArray.data, 0, 4);
        if (parsableByteArray.readUnsignedInt() == 1716281667) {
            return true;
        }
        return false;
    }

    public static Metadata readId3Metadata(ExtractorInput extractorInput, boolean z) throws IOException {
        extractorInput.resetPeekPosition();
        long peekPosition = extractorInput.getPeekPosition();
        Metadata peekId3Metadata = peekId3Metadata(extractorInput, z);
        extractorInput.skipFully((int) (extractorInput.getPeekPosition() - peekPosition));
        return peekId3Metadata;
    }

    public static void readStreamMarker(ExtractorInput extractorInput) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        extractorInput.readFully(parsableByteArray.data, 0, 4);
        if (parsableByteArray.readUnsignedInt() != 1716281667) {
            throw new ParserException("Failed to read FLAC stream marker.");
        }
    }

    public static boolean readMetadataBlock(ExtractorInput extractorInput, FlacStreamMetadataHolder flacStreamMetadataHolder) throws IOException {
        extractorInput.resetPeekPosition();
        ParsableBitArray parsableBitArray = new ParsableBitArray(new byte[4]);
        extractorInput.peekFully(parsableBitArray.data, 0, 4);
        boolean readBit = parsableBitArray.readBit();
        int readBits = parsableBitArray.readBits(7);
        int readBits2 = parsableBitArray.readBits(24) + 4;
        if (readBits == 0) {
            flacStreamMetadataHolder.flacStreamMetadata = readStreamInfoBlock(extractorInput);
        } else {
            FlacStreamMetadata flacStreamMetadata = flacStreamMetadataHolder.flacStreamMetadata;
            if (flacStreamMetadata == null) {
                throw new IllegalArgumentException();
            } else if (readBits == 3) {
                flacStreamMetadataHolder.flacStreamMetadata = flacStreamMetadata.copyWithSeekTable(readSeekTableMetadataBlock(extractorInput, readBits2));
            } else if (readBits == 4) {
                flacStreamMetadataHolder.flacStreamMetadata = flacStreamMetadata.copyWithVorbisComments(readVorbisCommentMetadataBlock(extractorInput, readBits2));
            } else if (readBits == 6) {
                flacStreamMetadataHolder.flacStreamMetadata = flacStreamMetadata.copyWithPictureFrames(Collections.singletonList(readPictureMetadataBlock(extractorInput, readBits2)));
            } else {
                extractorInput.skipFully(readBits2);
            }
        }
        return readBit;
    }

    public static FlacStreamMetadata.SeekTable readSeekTableMetadataBlock(ParsableByteArray parsableByteArray) {
        parsableByteArray.skipBytes(1);
        int readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
        long position = (long) (parsableByteArray.getPosition() + readUnsignedInt24);
        int i = readUnsignedInt24 / 18;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            long readLong = parsableByteArray.readLong();
            if (readLong == -1) {
                jArr = Arrays.copyOf(jArr, i2);
                jArr2 = Arrays.copyOf(jArr2, i2);
                break;
            }
            jArr[i2] = readLong;
            jArr2[i2] = parsableByteArray.readLong();
            parsableByteArray.skipBytes(2);
            i2++;
        }
        parsableByteArray.skipBytes((int) (position - ((long) parsableByteArray.getPosition())));
        return new FlacStreamMetadata.SeekTable(jArr, jArr2);
    }

    public static int getFrameStartMarker(ExtractorInput extractorInput) throws IOException {
        extractorInput.resetPeekPosition();
        ParsableByteArray parsableByteArray = new ParsableByteArray(2);
        extractorInput.peekFully(parsableByteArray.data, 0, 2);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        if ((readUnsignedShort >> 2) == 16382) {
            extractorInput.resetPeekPosition();
            return readUnsignedShort;
        }
        extractorInput.resetPeekPosition();
        throw new ParserException("First frame does not start with sync code.");
    }

    private static FlacStreamMetadata readStreamInfoBlock(ExtractorInput extractorInput) throws IOException {
        byte[] bArr = new byte[38];
        extractorInput.readFully(bArr, 0, 38);
        return new FlacStreamMetadata(bArr, 4);
    }

    private static FlacStreamMetadata.SeekTable readSeekTableMetadataBlock(ExtractorInput extractorInput, int i) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(i);
        extractorInput.readFully(parsableByteArray.data, 0, i);
        return readSeekTableMetadataBlock(parsableByteArray);
    }

    private static List<String> readVorbisCommentMetadataBlock(ExtractorInput extractorInput, int i) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(i);
        extractorInput.readFully(parsableByteArray.data, 0, i);
        parsableByteArray.skipBytes(4);
        return Arrays.asList(VorbisUtil.readVorbisCommentHeader(parsableByteArray, false, false).comments);
    }

    private static PictureFrame readPictureMetadataBlock(ExtractorInput extractorInput, int i) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(i);
        extractorInput.readFully(parsableByteArray.data, 0, i);
        parsableByteArray.skipBytes(4);
        int readInt = parsableByteArray.readInt();
        String readString = parsableByteArray.readString(parsableByteArray.readInt(), Charset.forName("US-ASCII"));
        String readString2 = parsableByteArray.readString(parsableByteArray.readInt());
        int readInt2 = parsableByteArray.readInt();
        int readInt3 = parsableByteArray.readInt();
        int readInt4 = parsableByteArray.readInt();
        int readInt5 = parsableByteArray.readInt();
        int readInt6 = parsableByteArray.readInt();
        byte[] bArr = new byte[readInt6];
        parsableByteArray.readBytes(bArr, 0, readInt6);
        return new PictureFrame(readInt, readString, readString2, readInt2, readInt3, readInt4, readInt5, bArr);
    }

    private FlacMetadataReader() {
    }
}
