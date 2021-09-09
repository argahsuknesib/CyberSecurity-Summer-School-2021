package com.google.android.exoplayer2.audio;

import android.support.v4.app.NotificationCompat;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.ParsableBitArray;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class DtsUtil {
    private static final int[] CHANNELS_BY_AMODE = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] SAMPLE_RATE_BY_SFREQ = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] TWICE_BITRATE_KBPS_BY_RATE = {64, 112, NotificationCompat.FLAG_HIGH_PRIORITY, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static boolean isSyncWord(int i) {
        return i == 2147385345 || i == -25230976 || i == 536864768 || i == -14745368;
    }

    public static Format parseDtsFormat(byte[] bArr, String str, String str2, DrmInitData drmInitData) {
        ParsableBitArray normalizedFrameHeader = getNormalizedFrameHeader(bArr);
        normalizedFrameHeader.skipBits(60);
        int i = CHANNELS_BY_AMODE[normalizedFrameHeader.readBits(6)];
        int i2 = SAMPLE_RATE_BY_SFREQ[normalizedFrameHeader.readBits(4)];
        int readBits = normalizedFrameHeader.readBits(5);
        int[] iArr = TWICE_BITRATE_KBPS_BY_RATE;
        int i3 = readBits >= iArr.length ? -1 : (iArr[readBits] * 1000) / 2;
        normalizedFrameHeader.skipBits(10);
        return new Format.Builder().setId(str).setSampleMimeType("audio/vnd.dts").setAverageBitrate(i3).setChannelCount(i + (normalizedFrameHeader.readBits(2) > 0 ? 1 : 0)).setSampleRate(i2).setDrmInitData(drmInitData).setLanguage(str2).build();
    }

    public static int parseDtsAudioSampleCount(byte[] bArr) {
        int i;
        byte b;
        byte b2;
        int i2;
        byte b3;
        byte b4 = bArr[0];
        if (b4 != -2) {
            if (b4 == -1) {
                i2 = (bArr[4] & 7) << 4;
                b3 = bArr[7];
            } else if (b4 != 31) {
                i = (bArr[4] & 1) << 6;
                b = bArr[5];
            } else {
                i2 = (bArr[5] & 7) << 4;
                b3 = bArr[6];
            }
            b2 = b3 & 60;
            return (((b2 >> 2) | i2) + 1) * 32;
        }
        i = (bArr[5] & 1) << 6;
        b = bArr[4];
        b2 = b & 252;
        return (((b2 >> 2) | i2) + 1) * 32;
    }

    public static int parseDtsAudioSampleCount(ByteBuffer byteBuffer) {
        int i;
        byte b;
        byte b2;
        int i2;
        byte b3;
        int position = byteBuffer.position();
        byte b4 = byteBuffer.get(position);
        if (b4 != -2) {
            if (b4 == -1) {
                i2 = (byteBuffer.get(position + 4) & 7) << 4;
                b3 = byteBuffer.get(position + 7);
            } else if (b4 != 31) {
                i = (byteBuffer.get(position + 4) & 1) << 6;
                b = byteBuffer.get(position + 5);
            } else {
                i2 = (byteBuffer.get(position + 5) & 7) << 4;
                b3 = byteBuffer.get(position + 6);
            }
            b2 = b3 & 60;
            return (((b2 >> 2) | i2) + 1) * 32;
        }
        i = (byteBuffer.get(position + 5) & 1) << 6;
        b = byteBuffer.get(position + 4);
        b2 = b & 252;
        return (((b2 >> 2) | i2) + 1) * 32;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    public static int getDtsFrameSize(byte[] bArr) {
        int i;
        int i2;
        byte b;
        byte b2;
        int i3;
        boolean z = false;
        byte b3 = bArr[0];
        if (b3 != -2) {
            if (b3 == -1) {
                i3 = ((bArr[7] & 3) << 12) | ((bArr[6] & 255) << 4);
                b2 = bArr[9];
            } else if (b3 != 31) {
                i2 = ((bArr[5] & 3) << 12) | ((bArr[6] & 255) << 4);
                b = bArr[7];
            } else {
                i3 = ((bArr[6] & 3) << 12) | ((bArr[7] & 255) << 4);
                b2 = bArr[8];
            }
            i = (((b2 & 60) >> 2) | i3) + 1;
            z = true;
            return !z ? (i * 16) / 14 : i;
        }
        i2 = ((bArr[4] & 3) << 12) | ((bArr[7] & 255) << 4);
        b = bArr[6];
        i = (((b & 240) >> 4) | i2) + 1;
        if (!z) {
        }
    }

    private static ParsableBitArray getNormalizedFrameHeader(byte[] bArr) {
        if (bArr[0] == Byte.MAX_VALUE) {
            return new ParsableBitArray(bArr);
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        if (isLittleEndianFrameHeader(copyOf)) {
            for (int i = 0; i < copyOf.length - 1; i += 2) {
                byte b = copyOf[i];
                int i2 = i + 1;
                copyOf[i] = copyOf[i2];
                copyOf[i2] = b;
            }
        }
        ParsableBitArray parsableBitArray = new ParsableBitArray(copyOf);
        if (copyOf[0] == 31) {
            ParsableBitArray parsableBitArray2 = new ParsableBitArray(copyOf);
            while (parsableBitArray2.bitsLeft() >= 16) {
                parsableBitArray2.skipBits(2);
                parsableBitArray.putInt(parsableBitArray2.readBits(14), 14);
            }
        }
        parsableBitArray.reset(copyOf);
        return parsableBitArray;
    }

    private static boolean isLittleEndianFrameHeader(byte[] bArr) {
        return bArr[0] == -2 || bArr[0] == -1;
    }

    private DtsUtil() {
    }
}
