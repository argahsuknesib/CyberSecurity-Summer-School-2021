package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

final class Sniffer {
    private static final int[] COMPATIBLE_BRANDS = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153};

    public static boolean sniffFragmented(ExtractorInput extractorInput) throws IOException {
        return sniffInternal(extractorInput, true);
    }

    public static boolean sniffUnfragmented(ExtractorInput extractorInput) throws IOException {
        return sniffInternal(extractorInput, false);
    }

    private static boolean sniffInternal(ExtractorInput extractorInput, boolean z) throws IOException {
        boolean z2;
        ExtractorInput extractorInput2 = extractorInput;
        long length = extractorInput.getLength();
        long j = 4096;
        long j2 = -1;
        if (length != -1 && length <= 4096) {
            j = length;
        }
        int i = (int) j;
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        boolean z3 = false;
        int i2 = i;
        int i3 = 0;
        boolean z4 = false;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            parsableByteArray.reset(8);
            extractorInput2.peekFully(parsableByteArray.data, z3 ? 1 : 0, 8);
            long readUnsignedInt = parsableByteArray.readUnsignedInt();
            int readInt = parsableByteArray.readInt();
            int i4 = 16;
            if (readUnsignedInt == 1) {
                extractorInput2.peekFully(parsableByteArray.data, 8, 8);
                parsableByteArray.setLimit(16);
                readUnsignedInt = parsableByteArray.readLong();
            } else {
                if (readUnsignedInt == 0) {
                    long length2 = extractorInput.getLength();
                    if (length2 != j2) {
                        readUnsignedInt = 8 + (length2 - extractorInput.getPeekPosition());
                    }
                }
                i4 = 8;
            }
            long j3 = (long) i4;
            if (readUnsignedInt >= j3) {
                i3 += i4;
                if (readInt != 1836019574) {
                    if (readInt != 1836019558 && readInt != 1836475768) {
                        long j4 = readUnsignedInt;
                        int i5 = i2;
                        if ((((long) i3) + readUnsignedInt) - j3 >= ((long) i5)) {
                            break;
                        }
                        int i6 = (int) (j4 - j3);
                        i3 += i6;
                        if (readInt == 1718909296) {
                            if (i6 < 8) {
                                return false;
                            }
                            parsableByteArray.reset(i6);
                            extractorInput2.peekFully(parsableByteArray.data, 0, i6);
                            int i7 = i6 / 4;
                            int i8 = 0;
                            while (true) {
                                if (i8 >= i7) {
                                    break;
                                }
                                if (i8 == 1) {
                                    parsableByteArray.skipBytes(4);
                                } else if (isCompatibleBrand(parsableByteArray.readInt())) {
                                    z4 = true;
                                    break;
                                }
                                i8++;
                            }
                            if (!z4) {
                                return false;
                            }
                        } else if (i6 != 0) {
                            extractorInput2.advancePeekPosition(i6);
                        }
                        i2 = i5;
                        j2 = -1;
                        z3 = false;
                    } else {
                        z2 = true;
                    }
                } else {
                    i2 += (int) readUnsignedInt;
                    if (length != -1 && ((long) i2) > length) {
                        i2 = (int) length;
                    }
                    j2 = -1;
                }
            } else {
                return z3;
            }
        }
        z2 = false;
        return z4 && z == z2;
    }

    private static boolean isCompatibleBrand(int i) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        for (int i2 : COMPATIBLE_BRANDS) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private Sniffer() {
    }
}
