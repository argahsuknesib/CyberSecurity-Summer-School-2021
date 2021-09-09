package com.google.android.exoplayer2.audio;

import android.support.v4.app.NotificationCompat;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

public final class Ac3Util {
    private static final int[] BITRATE_BY_HALF_FRMSIZECOD = {32, 40, 48, 56, 64, 80, 96, 112, NotificationCompat.FLAG_HIGH_PRIORITY, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD = {1, 2, 3, 6};
    private static final int[] CHANNEL_COUNT_BY_ACMOD = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] SAMPLE_RATE_BY_FSCOD = {48000, 44100, 32000};
    private static final int[] SAMPLE_RATE_BY_FSCOD2 = {24000, 22050, 16000};
    private static final int[] SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1 = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static final class SyncFrameInfo {
        public final int channelCount;
        public final int frameSize;
        public final String mimeType;
        public final int sampleCount;
        public final int sampleRate;
        public final int streamType;

        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface StreamType {
        }

        private SyncFrameInfo(String str, int i, int i2, int i3, int i4, int i5) {
            this.mimeType = str;
            this.streamType = i;
            this.channelCount = i2;
            this.sampleRate = i3;
            this.frameSize = i4;
            this.sampleCount = i5;
        }
    }

    public static Format parseAc3AnnexFFormat(ParsableByteArray parsableByteArray, String str, String str2, DrmInitData drmInitData) {
        int i = SAMPLE_RATE_BY_FSCOD[(parsableByteArray.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i2 = CHANNEL_COUNT_BY_ACMOD[(readUnsignedByte & 56) >> 3];
        if ((readUnsignedByte & 4) != 0) {
            i2++;
        }
        return new Format.Builder().setId(str).setSampleMimeType("audio/ac3").setChannelCount(i2).setSampleRate(i).setDrmInitData(drmInitData).setLanguage(str2).build();
    }

    public static Format parseEAc3AnnexFFormat(ParsableByteArray parsableByteArray, String str, String str2, DrmInitData drmInitData) {
        parsableByteArray.skipBytes(2);
        int i = SAMPLE_RATE_BY_FSCOD[(parsableByteArray.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i2 = CHANNEL_COUNT_BY_ACMOD[(readUnsignedByte & 14) >> 1];
        if ((readUnsignedByte & 1) != 0) {
            i2++;
        }
        if (((parsableByteArray.readUnsignedByte() & 30) >> 1) > 0 && (2 & parsableByteArray.readUnsignedByte()) != 0) {
            i2 += 2;
        }
        return new Format.Builder().setId(str).setSampleMimeType((parsableByteArray.bytesLeft() <= 0 || (parsableByteArray.readUnsignedByte() & 1) == 0) ? "audio/eac3" : "audio/eac3-joc").setChannelCount(i2).setSampleRate(i).setDrmInitData(drmInitData).setLanguage(str2).build();
    }

    public static SyncFrameInfo parseAc3SyncframeInfo(ParsableBitArray parsableBitArray) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        String str;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        ParsableBitArray parsableBitArray2 = parsableBitArray;
        int position = parsableBitArray.getPosition();
        parsableBitArray2.skipBits(40);
        boolean z = parsableBitArray2.readBits(5) > 10;
        parsableBitArray2.setPosition(position);
        int i12 = -1;
        if (z) {
            parsableBitArray2.skipBits(16);
            int readBits = parsableBitArray2.readBits(2);
            if (readBits == 0) {
                i12 = 0;
            } else if (readBits == 1) {
                i12 = 1;
            } else if (readBits == 2) {
                i12 = 2;
            }
            parsableBitArray2.skipBits(3);
            int readBits2 = (parsableBitArray2.readBits(11) + 1) * 2;
            int readBits3 = parsableBitArray2.readBits(2);
            if (readBits3 == 3) {
                i6 = SAMPLE_RATE_BY_FSCOD2[parsableBitArray2.readBits(2)];
                i8 = 3;
                i7 = 6;
            } else {
                i8 = parsableBitArray2.readBits(2);
                i7 = BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[i8];
                i6 = SAMPLE_RATE_BY_FSCOD[readBits3];
            }
            int i13 = i7 * 256;
            int readBits4 = parsableBitArray2.readBits(3);
            boolean readBit = parsableBitArray.readBit();
            int i14 = CHANNEL_COUNT_BY_ACMOD[readBits4] + (readBit ? 1 : 0);
            parsableBitArray2.skipBits(10);
            if (parsableBitArray.readBit()) {
                parsableBitArray2.skipBits(8);
            }
            if (readBits4 == 0) {
                parsableBitArray2.skipBits(5);
                if (parsableBitArray.readBit()) {
                    parsableBitArray2.skipBits(8);
                }
            }
            if (i12 == 1 && parsableBitArray.readBit()) {
                parsableBitArray2.skipBits(16);
            }
            if (parsableBitArray.readBit()) {
                if (readBits4 > 2) {
                    parsableBitArray2.skipBits(2);
                }
                if ((readBits4 & 1) == 0 || readBits4 <= 2) {
                    i10 = 6;
                } else {
                    i10 = 6;
                    parsableBitArray2.skipBits(6);
                }
                if ((readBits4 & 4) != 0) {
                    parsableBitArray2.skipBits(i10);
                }
                if (readBit && parsableBitArray.readBit()) {
                    parsableBitArray2.skipBits(5);
                }
                if (i12 == 0) {
                    if (parsableBitArray.readBit()) {
                        i11 = 6;
                        parsableBitArray2.skipBits(6);
                    } else {
                        i11 = 6;
                    }
                    if (readBits4 == 0 && parsableBitArray.readBit()) {
                        parsableBitArray2.skipBits(i11);
                    }
                    if (parsableBitArray.readBit()) {
                        parsableBitArray2.skipBits(i11);
                    }
                    int readBits5 = parsableBitArray2.readBits(2);
                    if (readBits5 == 1) {
                        parsableBitArray2.skipBits(5);
                    } else if (readBits5 == 2) {
                        parsableBitArray2.skipBits(12);
                    } else if (readBits5 == 3) {
                        int readBits6 = parsableBitArray2.readBits(5);
                        if (parsableBitArray.readBit()) {
                            parsableBitArray2.skipBits(5);
                            if (parsableBitArray.readBit()) {
                                parsableBitArray2.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray2.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray2.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray2.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray2.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray2.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray2.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray2.skipBits(4);
                                }
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray2.skipBits(4);
                                }
                            }
                        }
                        if (parsableBitArray.readBit()) {
                            parsableBitArray2.skipBits(5);
                            if (parsableBitArray.readBit()) {
                                parsableBitArray2.skipBits(7);
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray2.skipBits(8);
                                }
                            }
                        }
                        parsableBitArray2.skipBits((readBits6 + 2) * 8);
                        parsableBitArray.byteAlign();
                    }
                    if (readBits4 < 2) {
                        if (parsableBitArray.readBit()) {
                            parsableBitArray2.skipBits(14);
                        }
                        if (readBits4 == 0 && parsableBitArray.readBit()) {
                            parsableBitArray2.skipBits(14);
                        }
                    }
                    if (parsableBitArray.readBit()) {
                        if (i8 == 0) {
                            parsableBitArray2.skipBits(5);
                        } else {
                            for (int i15 = 0; i15 < i7; i15++) {
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray2.skipBits(5);
                                }
                            }
                        }
                    }
                }
            }
            if (parsableBitArray.readBit()) {
                parsableBitArray2.skipBits(5);
                if (readBits4 == 2) {
                    parsableBitArray2.skipBits(4);
                }
                if (readBits4 >= 6) {
                    parsableBitArray2.skipBits(2);
                }
                if (parsableBitArray.readBit()) {
                    parsableBitArray2.skipBits(8);
                }
                if (readBits4 == 0 && parsableBitArray.readBit()) {
                    parsableBitArray2.skipBits(8);
                }
                if (readBits3 < 3) {
                    parsableBitArray.skipBit();
                }
            }
            if (i12 == 0 && i8 != 3) {
                parsableBitArray.skipBit();
            }
            if (i12 != 2 || (i8 != 3 && !parsableBitArray.readBit())) {
                i9 = 6;
            } else {
                i9 = 6;
                parsableBitArray2.skipBits(6);
            }
            str = (parsableBitArray.readBit() && parsableBitArray2.readBits(i9) == 1 && parsableBitArray2.readBits(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i5 = i12;
            i = i13;
            i2 = readBits2;
            i3 = i6;
            i4 = i14;
        } else {
            parsableBitArray2.skipBits(32);
            int readBits7 = parsableBitArray2.readBits(2);
            String str2 = readBits7 == 3 ? null : "audio/ac3";
            int ac3SyncframeSize = getAc3SyncframeSize(readBits7, parsableBitArray2.readBits(6));
            parsableBitArray2.skipBits(8);
            int readBits8 = parsableBitArray2.readBits(3);
            if (!((readBits8 & 1) == 0 || readBits8 == 1)) {
                parsableBitArray2.skipBits(2);
            }
            if ((readBits8 & 4) != 0) {
                parsableBitArray2.skipBits(2);
            }
            if (readBits8 == 2) {
                parsableBitArray2.skipBits(2);
            }
            int[] iArr = SAMPLE_RATE_BY_FSCOD;
            str = str2;
            i2 = ac3SyncframeSize;
            i3 = readBits7 < iArr.length ? iArr[readBits7] : -1;
            i4 = CHANNEL_COUNT_BY_ACMOD[readBits8] + (parsableBitArray.readBit() ? 1 : 0);
            i5 = -1;
            i = 1536;
        }
        return new SyncFrameInfo(str, i5, i4, i3, i2, i);
    }

    public static int parseAc3SyncframeSize(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (!(((bArr[5] & 248) >> 3) > 10)) {
            return getAc3SyncframeSize((bArr[4] & 192) >> 6, bArr[4] & 63);
        }
        return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
    }

    public static int parseAc3SyncframeAudioSampleCount(ByteBuffer byteBuffer) {
        int i = 3;
        if (!(((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10)) {
            return 1536;
        }
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i = (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4;
        }
        return BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[i] * 256;
    }

    public static int findTrueHdSyncframeOffset(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit() - 10;
        for (int i = position; i <= limit; i++) {
            if ((byteBuffer.getInt(i + 4) & -16777217) == -1167101192) {
                return i - position;
            }
        }
        return -1;
    }

    public static int parseTrueHdSyncframeAudioSampleCount(byte[] bArr) {
        boolean z = false;
        if (bArr[4] != -8 || bArr[5] != 114 || bArr[6] != 111 || (bArr[7] & 254) != 186) {
            return 0;
        }
        if ((bArr[7] & 255) == 187) {
            z = true;
        }
        return 40 << ((bArr[z ? (char) 9 : 8] >> 4) & 7);
    }

    public static int parseTrueHdSyncframeAudioSampleCount(ByteBuffer byteBuffer, int i) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i) + ((byteBuffer.get((byteBuffer.position() + i) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }

    private static int getAc3SyncframeSize(int i, int i2) {
        int i3 = i2 / 2;
        if (i < 0) {
            return -1;
        }
        int[] iArr = SAMPLE_RATE_BY_FSCOD;
        if (i >= iArr.length || i2 < 0) {
            return -1;
        }
        int[] iArr2 = SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1;
        if (i3 >= iArr2.length) {
            return -1;
        }
        int i4 = iArr[i];
        if (i4 == 44100) {
            return (iArr2[i3] + (i2 % 2)) * 2;
        }
        int i5 = BITRATE_BY_HALF_FRMSIZECOD[i3];
        return i4 == 32000 ? i5 * 6 : i5 * 4;
    }

    private Ac3Util() {
    }
}
