package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;

public final class VorbisUtil {
    public static int iLog(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    public static final class CommentHeader {
        public final String[] comments;
        public final int length;
        public final String vendor;

        public CommentHeader(String str, String[] strArr, int i) {
            this.vendor = str;
            this.comments = strArr;
            this.length = i;
        }
    }

    public static final class VorbisIdHeader {
        public final int bitrateMaximum;
        public final int bitrateMinimum;
        public final int bitrateNominal;
        public final int blockSize0;
        public final int blockSize1;
        public final int channels;
        public final byte[] data;
        public final boolean framingFlag;
        public final int sampleRate;
        public final int version;

        public VorbisIdHeader(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, byte[] bArr) {
            this.version = i;
            this.channels = i2;
            this.sampleRate = i3;
            this.bitrateMaximum = i4;
            this.bitrateNominal = i5;
            this.bitrateMinimum = i6;
            this.blockSize0 = i7;
            this.blockSize1 = i8;
            this.framingFlag = z;
            this.data = bArr;
        }
    }

    public static final class Mode {
        public final boolean blockFlag;
        public final int mapping;
        public final int transformType;
        public final int windowType;

        public Mode(boolean z, int i, int i2, int i3) {
            this.blockFlag = z;
            this.windowType = i;
            this.transformType = i2;
            this.mapping = i3;
        }
    }

    public static VorbisIdHeader readVorbisIdentificationHeader(ParsableByteArray parsableByteArray) throws ParserException {
        verifyVorbisHeaderCapturePattern(1, parsableByteArray, false);
        int readLittleEndianUnsignedIntToInt = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readLittleEndianUnsignedIntToInt2 = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int readLittleEndianInt = parsableByteArray.readLittleEndianInt();
        int i = readLittleEndianInt <= 0 ? -1 : readLittleEndianInt;
        int readLittleEndianInt2 = parsableByteArray.readLittleEndianInt();
        int i2 = readLittleEndianInt2 <= 0 ? -1 : readLittleEndianInt2;
        int readLittleEndianInt3 = parsableByteArray.readLittleEndianInt();
        int i3 = readLittleEndianInt3 <= 0 ? -1 : readLittleEndianInt3;
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        return new VorbisIdHeader(readLittleEndianUnsignedIntToInt, readUnsignedByte, readLittleEndianUnsignedIntToInt2, i, i2, i3, (int) Math.pow(2.0d, (double) (readUnsignedByte2 & 15)), (int) Math.pow(2.0d, (double) ((readUnsignedByte2 & 240) >> 4)), (parsableByteArray.readUnsignedByte() & 1) > 0, Arrays.copyOf(parsableByteArray.data, parsableByteArray.limit()));
    }

    public static CommentHeader readVorbisCommentHeader(ParsableByteArray parsableByteArray) throws ParserException {
        return readVorbisCommentHeader(parsableByteArray, true, true);
    }

    public static CommentHeader readVorbisCommentHeader(ParsableByteArray parsableByteArray, boolean z, boolean z2) throws ParserException {
        if (z) {
            verifyVorbisHeaderCapturePattern(3, parsableByteArray, false);
        }
        String readString = parsableByteArray.readString((int) parsableByteArray.readLittleEndianUnsignedInt());
        long readLittleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
        String[] strArr = new String[((int) readLittleEndianUnsignedInt)];
        int length = readString.length() + 11 + 4;
        for (int i = 0; ((long) i) < readLittleEndianUnsignedInt; i++) {
            strArr[i] = parsableByteArray.readString((int) parsableByteArray.readLittleEndianUnsignedInt());
            length = length + 4 + strArr[i].length();
        }
        if (!z2 || (parsableByteArray.readUnsignedByte() & 1) != 0) {
            return new CommentHeader(readString, strArr, length + 1);
        }
        throw new ParserException("framing bit expected to be set");
    }

    public static boolean verifyVorbisHeaderCapturePattern(int i, ParsableByteArray parsableByteArray, boolean z) throws ParserException {
        if (parsableByteArray.bytesLeft() < 7) {
            if (z) {
                return false;
            }
            throw new ParserException("too short header: " + parsableByteArray.bytesLeft());
        } else if (parsableByteArray.readUnsignedByte() != i) {
            if (z) {
                return false;
            }
            throw new ParserException("expected header type " + Integer.toHexString(i));
        } else if (parsableByteArray.readUnsignedByte() == 118 && parsableByteArray.readUnsignedByte() == 111 && parsableByteArray.readUnsignedByte() == 114 && parsableByteArray.readUnsignedByte() == 98 && parsableByteArray.readUnsignedByte() == 105 && parsableByteArray.readUnsignedByte() == 115) {
            return true;
        } else {
            if (z) {
                return false;
            }
            throw new ParserException("expected characters 'vorbis'");
        }
    }

    public static Mode[] readVorbisModes(ParsableByteArray parsableByteArray, int i) throws ParserException {
        int i2 = 0;
        verifyVorbisHeaderCapturePattern(5, parsableByteArray, false);
        int readUnsignedByte = parsableByteArray.readUnsignedByte() + 1;
        VorbisBitArray vorbisBitArray = new VorbisBitArray(parsableByteArray.data);
        vorbisBitArray.skipBits(parsableByteArray.getPosition() * 8);
        for (int i3 = 0; i3 < readUnsignedByte; i3++) {
            readBook(vorbisBitArray);
        }
        int readBits = vorbisBitArray.readBits(6) + 1;
        while (i2 < readBits) {
            if (vorbisBitArray.readBits(16) == 0) {
                i2++;
            } else {
                throw new ParserException("placeholder of time domain transforms not zeroed out");
            }
        }
        readFloors(vorbisBitArray);
        readResidues(vorbisBitArray);
        readMappings(i, vorbisBitArray);
        Mode[] readModes = readModes(vorbisBitArray);
        if (vorbisBitArray.readBit()) {
            return readModes;
        }
        throw new ParserException("framing bit after modes not set as expected");
    }

    private static Mode[] readModes(VorbisBitArray vorbisBitArray) {
        int readBits = vorbisBitArray.readBits(6) + 1;
        Mode[] modeArr = new Mode[readBits];
        for (int i = 0; i < readBits; i++) {
            modeArr[i] = new Mode(vorbisBitArray.readBit(), vorbisBitArray.readBits(16), vorbisBitArray.readBits(16), vorbisBitArray.readBits(8));
        }
        return modeArr;
    }

    private static void readMappings(int i, VorbisBitArray vorbisBitArray) throws ParserException {
        int readBits = vorbisBitArray.readBits(6) + 1;
        for (int i2 = 0; i2 < readBits; i2++) {
            int readBits2 = vorbisBitArray.readBits(16);
            if (readBits2 != 0) {
                Log.e("VorbisUtil", "mapping type other than 0 not supported: ".concat(String.valueOf(readBits2)));
            } else {
                int readBits3 = vorbisBitArray.readBit() ? vorbisBitArray.readBits(4) + 1 : 1;
                if (vorbisBitArray.readBit()) {
                    int readBits4 = vorbisBitArray.readBits(8) + 1;
                    for (int i3 = 0; i3 < readBits4; i3++) {
                        int i4 = i - 1;
                        vorbisBitArray.skipBits(iLog(i4));
                        vorbisBitArray.skipBits(iLog(i4));
                    }
                }
                if (vorbisBitArray.readBits(2) == 0) {
                    if (readBits3 > 1) {
                        for (int i5 = 0; i5 < i; i5++) {
                            vorbisBitArray.skipBits(4);
                        }
                    }
                    for (int i6 = 0; i6 < readBits3; i6++) {
                        vorbisBitArray.skipBits(8);
                        vorbisBitArray.skipBits(8);
                        vorbisBitArray.skipBits(8);
                    }
                } else {
                    throw new ParserException("to reserved bits must be zero after mapping coupling steps");
                }
            }
        }
    }

    private static void readResidues(VorbisBitArray vorbisBitArray) throws ParserException {
        int readBits = vorbisBitArray.readBits(6) + 1;
        int i = 0;
        while (i < readBits) {
            if (vorbisBitArray.readBits(16) <= 2) {
                vorbisBitArray.skipBits(24);
                vorbisBitArray.skipBits(24);
                vorbisBitArray.skipBits(24);
                int readBits2 = vorbisBitArray.readBits(6) + 1;
                vorbisBitArray.skipBits(8);
                int[] iArr = new int[readBits2];
                for (int i2 = 0; i2 < readBits2; i2++) {
                    iArr[i2] = ((vorbisBitArray.readBit() ? vorbisBitArray.readBits(5) : 0) * 8) + vorbisBitArray.readBits(3);
                }
                for (int i3 = 0; i3 < readBits2; i3++) {
                    for (int i4 = 0; i4 < 8; i4++) {
                        if ((iArr[i3] & (1 << i4)) != 0) {
                            vorbisBitArray.skipBits(8);
                        }
                    }
                }
                i++;
            } else {
                throw new ParserException("residueType greater than 2 is not decodable");
            }
        }
    }

    private static void readFloors(VorbisBitArray vorbisBitArray) throws ParserException {
        int readBits = vorbisBitArray.readBits(6) + 1;
        for (int i = 0; i < readBits; i++) {
            int readBits2 = vorbisBitArray.readBits(16);
            if (readBits2 == 0) {
                vorbisBitArray.skipBits(8);
                vorbisBitArray.skipBits(16);
                vorbisBitArray.skipBits(16);
                vorbisBitArray.skipBits(6);
                vorbisBitArray.skipBits(8);
                int readBits3 = vorbisBitArray.readBits(4) + 1;
                for (int i2 = 0; i2 < readBits3; i2++) {
                    vorbisBitArray.skipBits(8);
                }
            } else if (readBits2 == 1) {
                int readBits4 = vorbisBitArray.readBits(5);
                int[] iArr = new int[readBits4];
                int i3 = -1;
                for (int i4 = 0; i4 < readBits4; i4++) {
                    iArr[i4] = vorbisBitArray.readBits(4);
                    if (iArr[i4] > i3) {
                        i3 = iArr[i4];
                    }
                }
                int[] iArr2 = new int[(i3 + 1)];
                for (int i5 = 0; i5 < iArr2.length; i5++) {
                    iArr2[i5] = vorbisBitArray.readBits(3) + 1;
                    int readBits5 = vorbisBitArray.readBits(2);
                    if (readBits5 > 0) {
                        vorbisBitArray.skipBits(8);
                    }
                    for (int i6 = 0; i6 < (1 << readBits5); i6++) {
                        vorbisBitArray.skipBits(8);
                    }
                }
                vorbisBitArray.skipBits(2);
                int readBits6 = vorbisBitArray.readBits(4);
                int i7 = 0;
                int i8 = 0;
                for (int i9 = 0; i9 < readBits4; i9++) {
                    i7 += iArr2[iArr[i9]];
                    while (i8 < i7) {
                        vorbisBitArray.skipBits(readBits6);
                        i8++;
                    }
                }
            } else {
                throw new ParserException("floor type greater than 1 not decodable: ".concat(String.valueOf(readBits2)));
            }
        }
    }

    private static CodeBook readBook(VorbisBitArray vorbisBitArray) throws ParserException {
        if (vorbisBitArray.readBits(24) == 5653314) {
            int readBits = vorbisBitArray.readBits(16);
            int readBits2 = vorbisBitArray.readBits(24);
            long[] jArr = new long[readBits2];
            boolean readBit = vorbisBitArray.readBit();
            long j = 0;
            if (!readBit) {
                boolean readBit2 = vorbisBitArray.readBit();
                for (int i = 0; i < readBits2; i++) {
                    if (!readBit2 || vorbisBitArray.readBit()) {
                        jArr[i] = (long) (vorbisBitArray.readBits(5) + 1);
                    } else {
                        jArr[i] = 0;
                    }
                }
            } else {
                int readBits3 = vorbisBitArray.readBits(5) + 1;
                int i2 = 0;
                while (i2 < readBits2) {
                    int readBits4 = vorbisBitArray.readBits(iLog(readBits2 - i2));
                    int i3 = i2;
                    for (int i4 = 0; i4 < readBits4 && i3 < readBits2; i4++) {
                        jArr[i3] = (long) readBits3;
                        i3++;
                    }
                    readBits3++;
                    i2 = i3;
                }
            }
            int readBits5 = vorbisBitArray.readBits(4);
            if (readBits5 <= 2) {
                if (readBits5 == 1 || readBits5 == 2) {
                    vorbisBitArray.skipBits(32);
                    vorbisBitArray.skipBits(32);
                    int readBits6 = vorbisBitArray.readBits(4) + 1;
                    vorbisBitArray.skipBits(1);
                    if (readBits5 != 1) {
                        j = ((long) readBits2) * ((long) readBits);
                    } else if (readBits != 0) {
                        j = mapType1QuantValues((long) readBits2, (long) readBits);
                    }
                    vorbisBitArray.skipBits((int) (j * ((long) readBits6)));
                }
                return new CodeBook(readBits, readBits2, jArr, readBits5, readBit);
            }
            throw new ParserException("lookup type greater than 2 not decodable: ".concat(String.valueOf(readBits5)));
        }
        throw new ParserException("expected code book to start with [0x56, 0x43, 0x42] at " + vorbisBitArray.getPosition());
    }

    private static long mapType1QuantValues(long j, long j2) {
        double d = (double) j2;
        Double.isNaN(d);
        return (long) Math.floor(Math.pow((double) j, 1.0d / d));
    }

    private VorbisUtil() {
    }

    static final class CodeBook {
        public final int dimensions;
        public final int entries;
        public final boolean isOrdered;
        public final long[] lengthMap;
        public final int lookupType;

        public CodeBook(int i, int i2, long[] jArr, int i3, boolean z) {
            this.dimensions = i;
            this.entries = i2;
            this.lengthMap = jArr;
            this.lookupType = i3;
            this.isOrdered = z;
        }
    }
}
