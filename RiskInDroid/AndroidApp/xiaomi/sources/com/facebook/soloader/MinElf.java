package com.facebook.soloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

public final class MinElf {
    public static String[] extract_DT_NEEDED(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return extract_DT_NEEDED(fileInputStream.getChannel());
        } finally {
            fileInputStream.close();
        }
    }

    public static String[] extract_DT_NEEDED(FileChannel fileChannel) throws IOException {
        long j;
        long j2;
        int i;
        long j3;
        boolean z;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        long j11;
        long j12;
        long j13;
        long j14;
        long j15;
        FileChannel fileChannel2 = fileChannel;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (getu32(fileChannel2, allocate, 0) == 1179403647) {
            boolean z2 = true;
            if (getu8(fileChannel2, allocate, 4) != 1) {
                z2 = false;
            }
            if (getu8(fileChannel2, allocate, 5) == 2) {
                allocate.order(ByteOrder.BIG_ENDIAN);
            }
            if (z2) {
                j = getu32(fileChannel2, allocate, 28);
            } else {
                j = get64(fileChannel2, allocate, 32);
            }
            if (z2) {
                j2 = (long) getu16(fileChannel2, allocate, 44);
            } else {
                j2 = (long) getu16(fileChannel2, allocate, 56);
            }
            if (z2) {
                i = getu16(fileChannel2, allocate, 42);
            } else {
                i = getu16(fileChannel2, allocate, 54);
            }
            if (j2 == 65535) {
                if (z2) {
                    j14 = getu32(fileChannel2, allocate, 32);
                } else {
                    j14 = get64(fileChannel2, allocate, 40);
                }
                if (z2) {
                    j15 = getu32(fileChannel2, allocate, j14 + 28);
                } else {
                    j15 = getu32(fileChannel2, allocate, j14 + 44);
                }
                j2 = j15;
            }
            long j16 = j;
            long j17 = 0;
            while (true) {
                if (j17 >= j2) {
                    j3 = 0;
                    break;
                } else if (getu32(fileChannel2, allocate, j16 + 0) != 2) {
                    j16 += (long) i;
                    j17++;
                } else if (z2) {
                    j3 = getu32(fileChannel2, allocate, j16 + 4);
                } else {
                    j3 = get64(fileChannel2, allocate, j16 + 8);
                }
            }
            long j18 = 0;
            if (j3 != 0) {
                long j19 = j3;
                long j20 = 0;
                int i2 = 0;
                while (true) {
                    if (z2) {
                        z = z2;
                        j4 = getu32(fileChannel2, allocate, j19 + j18);
                    } else {
                        z = z2;
                        j4 = get64(fileChannel2, allocate, j19 + j18);
                    }
                    if (j4 == 1) {
                        j5 = j3;
                        if (i2 != Integer.MAX_VALUE) {
                            i2++;
                        } else {
                            throw new ElfError("malformed DT_NEEDED section");
                        }
                    } else {
                        j5 = j3;
                        if (j4 == 5) {
                            if (z) {
                                j13 = getu32(fileChannel2, allocate, j19 + 4);
                            } else {
                                j13 = get64(fileChannel2, allocate, j19 + 8);
                            }
                            j20 = j13;
                        }
                    }
                    long j21 = 16;
                    j19 += z ? 8 : 16;
                    j18 = 0;
                    if (j4 != 0) {
                        z2 = z;
                        j3 = j5;
                    } else if (j20 != 0) {
                        int i3 = 0;
                        while (true) {
                            if (((long) i3) >= j2) {
                                j6 = 0;
                                break;
                            }
                            if (getu32(fileChannel2, allocate, j + j18) == 1) {
                                if (z) {
                                    j10 = getu32(fileChannel2, allocate, j + 8);
                                } else {
                                    j10 = get64(fileChannel2, allocate, j + j21);
                                }
                                if (z) {
                                    j9 = j2;
                                    j11 = getu32(fileChannel2, allocate, j + 20);
                                } else {
                                    j9 = j2;
                                    j11 = get64(fileChannel2, allocate, j + 40);
                                }
                                if (j10 <= j20 && j20 < j11 + j10) {
                                    if (z) {
                                        j12 = getu32(fileChannel2, allocate, j + 4);
                                    } else {
                                        j12 = get64(fileChannel2, allocate, j + 8);
                                    }
                                    j6 = j12 + (j20 - j10);
                                }
                            } else {
                                j9 = j2;
                            }
                            j += (long) i;
                            i3++;
                            j2 = j9;
                            j21 = 16;
                            j18 = 0;
                        }
                        long j22 = 0;
                        if (j6 != 0) {
                            String[] strArr = new String[i2];
                            int i4 = 0;
                            while (true) {
                                if (z) {
                                    j7 = getu32(fileChannel2, allocate, j5 + j22);
                                } else {
                                    j7 = get64(fileChannel2, allocate, j5 + j22);
                                }
                                if (j7 == 1) {
                                    if (z) {
                                        j8 = getu32(fileChannel2, allocate, j5 + 4);
                                    } else {
                                        j8 = get64(fileChannel2, allocate, j5 + 8);
                                    }
                                    strArr[i4] = getSz(fileChannel2, allocate, j8 + j6);
                                    if (i4 != Integer.MAX_VALUE) {
                                        i4++;
                                    } else {
                                        throw new ElfError("malformed DT_NEEDED section");
                                    }
                                }
                                j5 += z ? 8 : 16;
                                if (j7 != 0) {
                                    j22 = 0;
                                } else if (i4 == strArr.length) {
                                    return strArr;
                                } else {
                                    throw new ElfError("malformed DT_NEEDED section");
                                }
                            }
                        } else {
                            throw new ElfError("did not find file offset of DT_STRTAB table");
                        }
                    } else {
                        throw new ElfError("Dynamic section string-table not found");
                    }
                }
            } else {
                throw new ElfError("ELF file does not contain dynamic linking information");
            }
        } else {
            throw new ElfError("file is not ELF");
        }
    }

    private static String getSz(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j2 = 1 + j;
            short u8Var = getu8(fileChannel, byteBuffer, j);
            if (u8Var == 0) {
                return sb.toString();
            }
            sb.append((char) u8Var);
            j = j2;
        }
    }

    private static void read(FileChannel fileChannel, ByteBuffer byteBuffer, int i, long j) throws IOException {
        int read;
        byteBuffer.position(0);
        byteBuffer.limit(i);
        while (byteBuffer.remaining() > 0 && (read = fileChannel.read(byteBuffer, j)) != -1) {
            j += (long) read;
        }
        if (byteBuffer.remaining() <= 0) {
            byteBuffer.position(0);
            return;
        }
        throw new ElfError("ELF file truncated");
    }

    private static long get64(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(fileChannel, byteBuffer, 8, j);
        return byteBuffer.getLong();
    }

    private static long getu32(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(fileChannel, byteBuffer, 4, j);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    private static int getu16(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(fileChannel, byteBuffer, 2, j);
        return byteBuffer.getShort() & 65535;
    }

    private static short getu8(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(fileChannel, byteBuffer, 1, j);
        return (short) (byteBuffer.get() & 255);
    }

    static class ElfError extends RuntimeException {
        ElfError(String str) {
            super(str);
        }
    }
}
