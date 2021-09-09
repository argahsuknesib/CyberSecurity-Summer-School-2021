package com.google.android.exoplayer2.util;

import java.nio.ByteBuffer;
import java.util.Arrays;

public final class NalUnitUtil {
    public static final float[] ASPECT_RATIO_IDC_VALUES = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    public static final byte[] NAL_START_CODE = {0, 0, 0, 1};
    private static int[] scratchEscapePositions = new int[10];
    private static final Object scratchEscapePositionsLock = new Object();

    public static final class SpsData {
        public final int constraintsFlagsAndReservedZero2Bits;
        public final boolean deltaPicOrderAlwaysZeroFlag;
        public final boolean frameMbsOnlyFlag;
        public final int frameNumLength;
        public final int height;
        public final int levelIdc;
        public final int picOrderCntLsbLength;
        public final int picOrderCountType;
        public final float pixelWidthAspectRatio;
        public final int profileIdc;
        public final boolean separateColorPlaneFlag;
        public final int seqParameterSetId;
        public final int width;

        public SpsData(int i, int i2, int i3, int i4, int i5, int i6, float f, boolean z, boolean z2, int i7, int i8, int i9, boolean z3) {
            this.profileIdc = i;
            this.constraintsFlagsAndReservedZero2Bits = i2;
            this.levelIdc = i3;
            this.seqParameterSetId = i4;
            this.width = i5;
            this.height = i6;
            this.pixelWidthAspectRatio = f;
            this.separateColorPlaneFlag = z;
            this.frameMbsOnlyFlag = z2;
            this.frameNumLength = i7;
            this.picOrderCountType = i8;
            this.picOrderCntLsbLength = i9;
            this.deltaPicOrderAlwaysZeroFlag = z3;
        }
    }

    public static final class PpsData {
        public final boolean bottomFieldPicOrderInFramePresentFlag;
        public final int picParameterSetId;
        public final int seqParameterSetId;

        public PpsData(int i, int i2, boolean z) {
            this.picParameterSetId = i;
            this.seqParameterSetId = i2;
            this.bottomFieldPicOrderInFramePresentFlag = z;
        }
    }

    public static int unescapeStream(byte[] bArr, int i) {
        int i2;
        synchronized (scratchEscapePositionsLock) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                try {
                    i3 = findNextUnescapeIndex(bArr, i3, i);
                    if (i3 < i) {
                        if (scratchEscapePositions.length <= i4) {
                            int[] iArr = scratchEscapePositions;
                            scratchEscapePositions = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        scratchEscapePositions[i4] = i3;
                        i3 += 3;
                        i4++;
                    }
                } finally {
                }
            }
            i2 = i - i4;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = scratchEscapePositions[i7] - i6;
                System.arraycopy(bArr, i6, bArr, i5, i8);
                int i9 = i5 + i8;
                int i10 = i9 + 1;
                bArr[i9] = 0;
                i5 = i10 + 1;
                bArr[i10] = 0;
                i6 += i8 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i5, i2 - i5);
        }
        return i2;
    }

    public static void discardToSps(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i + 1;
            if (i3 < position) {
                byte b = byteBuffer.get(i) & 255;
                if (i2 == 3) {
                    if (b == 1 && (byteBuffer.get(i3) & 31) == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(i - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                } else if (b == 0) {
                    i2++;
                }
                if (b != 0) {
                    i2 = 0;
                }
                i = i3;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }

    public static boolean isNalUnitSei(String str, byte b) {
        if ((!"video/avc".equals(str) || (b & 31) != 6) && (!"video/hevc".equals(str) || ((b & 126) >> 1) != 39)) {
            return false;
        }
        return true;
    }

    public static int getNalUnitType(byte[] bArr, int i) {
        return bArr[i + 3] & 31;
    }

    public static int getH265NalUnitType(byte[] bArr, int i) {
        return (bArr[i + 3] & 126) >> 1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0145  */
    public static SpsData parseSpsNalUnit(byte[] bArr, int i, int i2) {
        boolean z;
        int i3;
        boolean z2;
        int i4;
        boolean readBit;
        float f;
        int readBits;
        int i5;
        int i6;
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i, i2);
        parsableNalUnitBitArray.skipBits(8);
        int readBits2 = parsableNalUnitBitArray.readBits(8);
        int readBits3 = parsableNalUnitBitArray.readBits(8);
        int readBits4 = parsableNalUnitBitArray.readBits(8);
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int i7 = 1;
        if (readBits2 == 100 || readBits2 == 110 || readBits2 == 122 || readBits2 == 244 || readBits2 == 44 || readBits2 == 83 || readBits2 == 86 || readBits2 == 118 || readBits2 == 128 || readBits2 == 138) {
            i3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            z = i3 == 3 ? parsableNalUnitBitArray.readBit() : false;
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.skipBit();
            if (parsableNalUnitBitArray.readBit()) {
                int i8 = i3 != 3 ? 8 : 12;
                int i9 = 0;
                while (i9 < i8) {
                    if (parsableNalUnitBitArray.readBit()) {
                        skipScalingList(parsableNalUnitBitArray, i9 < 6 ? 16 : 64);
                    }
                    i9++;
                }
            }
        } else {
            i3 = 1;
            z = false;
        }
        int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 4;
        int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (readUnsignedExpGolombCodedInt3 == 0) {
            i4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 4;
        } else if (readUnsignedExpGolombCodedInt3 == 1) {
            boolean readBit2 = parsableNalUnitBitArray.readBit();
            parsableNalUnitBitArray.readSignedExpGolombCodedInt();
            parsableNalUnitBitArray.readSignedExpGolombCodedInt();
            long readUnsignedExpGolombCodedInt4 = (long) parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            for (int i10 = 0; ((long) i10) < readUnsignedExpGolombCodedInt4; i10++) {
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            }
            z2 = readBit2;
            i4 = 0;
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.skipBit();
            int readUnsignedExpGolombCodedInt5 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
            readBit = parsableNalUnitBitArray.readBit();
            int readUnsignedExpGolombCodedInt6 = (true - (readBit ? 1 : 0)) * (parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1);
            if (!readBit) {
                parsableNalUnitBitArray.skipBit();
            }
            parsableNalUnitBitArray.skipBit();
            int i11 = readUnsignedExpGolombCodedInt5 * 16;
            int i12 = readUnsignedExpGolombCodedInt6 * 16;
            if (parsableNalUnitBitArray.readBit()) {
                int readUnsignedExpGolombCodedInt7 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int readUnsignedExpGolombCodedInt8 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int readUnsignedExpGolombCodedInt9 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int readUnsignedExpGolombCodedInt10 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                if (i3 == 0) {
                    i5 = true - readBit;
                    i6 = 1;
                } else {
                    i6 = i3 == 3 ? 1 : 2;
                    if (i3 == 1) {
                        i7 = 2;
                    }
                    i5 = i7 * (true - readBit);
                }
                i11 -= (readUnsignedExpGolombCodedInt7 + readUnsignedExpGolombCodedInt8) * i6;
                i12 -= (readUnsignedExpGolombCodedInt9 + readUnsignedExpGolombCodedInt10) * i5;
            }
            int i13 = i11;
            float f2 = 1.0f;
            if (parsableNalUnitBitArray.readBit() && parsableNalUnitBitArray.readBit()) {
                readBits = parsableNalUnitBitArray.readBits(8);
                if (readBits != 255) {
                    int readBits5 = parsableNalUnitBitArray.readBits(16);
                    int readBits6 = parsableNalUnitBitArray.readBits(16);
                    if (!(readBits5 == 0 || readBits6 == 0)) {
                        f2 = ((float) readBits5) / ((float) readBits6);
                    }
                    f = f2;
                } else {
                    float[] fArr = ASPECT_RATIO_IDC_VALUES;
                    if (readBits < fArr.length) {
                        f = fArr[readBits];
                    } else {
                        Log.w("NalUnitUtil", "Unexpected aspect_ratio_idc value: ".concat(String.valueOf(readBits)));
                    }
                }
                return new SpsData(readBits2, readBits3, readBits4, readUnsignedExpGolombCodedInt, i13, i12, f, z, readBit, readUnsignedExpGolombCodedInt2, readUnsignedExpGolombCodedInt3, i4, z2);
            }
            f = 1.0f;
            return new SpsData(readBits2, readBits3, readBits4, readUnsignedExpGolombCodedInt, i13, i12, f, z, readBit, readUnsignedExpGolombCodedInt2, readUnsignedExpGolombCodedInt3, i4, z2);
        } else {
            i4 = 0;
        }
        z2 = false;
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.skipBit();
        int readUnsignedExpGolombCodedInt52 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
        readBit = parsableNalUnitBitArray.readBit();
        int readUnsignedExpGolombCodedInt62 = (true - (readBit ? 1 : 0)) * (parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1);
        if (!readBit) {
        }
        parsableNalUnitBitArray.skipBit();
        int i112 = readUnsignedExpGolombCodedInt52 * 16;
        int i122 = readUnsignedExpGolombCodedInt62 * 16;
        if (parsableNalUnitBitArray.readBit()) {
        }
        int i132 = i112;
        float f22 = 1.0f;
        readBits = parsableNalUnitBitArray.readBits(8);
        if (readBits != 255) {
        }
        return new SpsData(readBits2, readBits3, readBits4, readUnsignedExpGolombCodedInt, i132, i122, f, z, readBit, readUnsignedExpGolombCodedInt2, readUnsignedExpGolombCodedInt3, i4, z2);
    }

    public static PpsData parsePpsNalUnit(byte[] bArr, int i, int i2) {
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i, i2);
        parsableNalUnitBitArray.skipBits(8);
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.skipBit();
        return new PpsData(readUnsignedExpGolombCodedInt, readUnsignedExpGolombCodedInt2, parsableNalUnitBitArray.readBit());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0096, code lost:
        r8 = true;
     */
    public static int findNalUnit(byte[] bArr, int i, int i2, boolean[] zArr) {
        int i3 = i2 - i;
        boolean z = false;
        Assertions.checkState(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr != null) {
            if (zArr[0]) {
                clearPrefixFlags(zArr);
                return i - 3;
            } else if (i3 > 1 && zArr[1] && bArr[i] == 1) {
                clearPrefixFlags(zArr);
                return i - 2;
            } else if (i3 > 2 && zArr[2] && bArr[i] == 0 && bArr[i + 1] == 1) {
                clearPrefixFlags(zArr);
                return i - 1;
            }
        }
        int i4 = i2 - 1;
        int i5 = i + 2;
        while (i5 < i4) {
            if ((bArr[i5] & 254) == 0) {
                int i6 = i5 - 2;
                if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && bArr[i5] == 1) {
                    if (zArr != null) {
                        clearPrefixFlags(zArr);
                    }
                    return i6;
                }
                i5 -= 2;
            }
            i5 += 3;
        }
        if (zArr != null) {
            if (i3 > 2) {
            }
            boolean z2 = false;
            zArr[0] = z2;
            zArr[1] = i3 <= 1 ? !(!zArr[2] || bArr[i4] != 0) : bArr[i2 + -2] == 0 && bArr[i4] == 0;
            if (bArr[i4] == 0) {
                z = true;
            }
            zArr[2] = z;
        }
        return i2;
    }

    public static void clearPrefixFlags(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    private static int findNextUnescapeIndex(byte[] bArr, int i, int i2) {
        while (i < i2 - 2) {
            if (bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 3) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static void skipScalingList(ParsableNalUnitBitArray parsableNalUnitBitArray, int i) {
        int i2 = 8;
        int i3 = 8;
        for (int i4 = 0; i4 < i; i4++) {
            if (i2 != 0) {
                i2 = ((parsableNalUnitBitArray.readSignedExpGolombCodedInt() + i3) + 256) % 256;
            }
            if (i2 != 0) {
                i3 = i2;
            }
        }
    }

    private NalUnitUtil() {
    }
}
