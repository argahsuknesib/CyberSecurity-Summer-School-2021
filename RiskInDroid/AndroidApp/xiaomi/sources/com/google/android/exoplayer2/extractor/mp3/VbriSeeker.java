package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

final class VbriSeeker implements Seeker {
    private final long dataEndPosition;
    private final long durationUs;
    private final long[] positions;
    private final long[] timesUs;

    public final boolean isSeekable() {
        return true;
    }

    public static VbriSeeker create(long j, long j2, MpegAudioUtil.Header header, ParsableByteArray parsableByteArray) {
        int i;
        long j3 = j;
        MpegAudioUtil.Header header2 = header;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        parsableByteArray2.skipBytes(10);
        int readInt = parsableByteArray.readInt();
        if (readInt <= 0) {
            return null;
        }
        int i2 = header2.sampleRate;
        long scaleLargeTimestamp = Util.scaleLargeTimestamp((long) readInt, 1000000 * ((long) (i2 >= 32000 ? 1152 : 576)), (long) i2);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
        int readUnsignedShort3 = parsableByteArray.readUnsignedShort();
        parsableByteArray2.skipBytes(2);
        long j4 = j2 + ((long) header2.frameSize);
        long[] jArr = new long[readUnsignedShort];
        long[] jArr2 = new long[readUnsignedShort];
        int i3 = 0;
        long j5 = j2;
        while (i3 < readUnsignedShort) {
            int i4 = readUnsignedShort2;
            jArr[i3] = (((long) i3) * scaleLargeTimestamp) / ((long) readUnsignedShort);
            long j6 = j4;
            jArr2[i3] = Math.max(j5, j6);
            if (readUnsignedShort3 == 1) {
                i = parsableByteArray.readUnsignedByte();
            } else if (readUnsignedShort3 == 2) {
                i = parsableByteArray.readUnsignedShort();
            } else if (readUnsignedShort3 == 3) {
                i = parsableByteArray.readUnsignedInt24();
            } else if (readUnsignedShort3 != 4) {
                return null;
            } else {
                i = parsableByteArray.readUnsignedIntToInt();
            }
            j5 += (long) (i * i4);
            i3++;
            j4 = j6;
            readUnsignedShort2 = i4;
        }
        if (!(j3 == -1 || j3 == j5)) {
            Log.w("VbriSeeker", "VBRI data size mismatch: " + j3 + ", " + j5);
        }
        return new VbriSeeker(jArr, jArr2, scaleLargeTimestamp, j5);
    }

    private VbriSeeker(long[] jArr, long[] jArr2, long j, long j2) {
        this.timesUs = jArr;
        this.positions = jArr2;
        this.durationUs = j;
        this.dataEndPosition = j2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.exoplayer2.util.Util.binarySearchFloor(long[], long, boolean, boolean):int
     arg types: [long[], long, int, int]
     candidates:
      com.google.android.exoplayer2.util.Util.binarySearchFloor(com.google.android.exoplayer2.util.LongArray, long, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchFloor(java.util.List, java.lang.Comparable, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchFloor(int[], int, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchFloor(long[], long, boolean, boolean):int */
    public final SeekMap.SeekPoints getSeekPoints(long j) {
        int binarySearchFloor = Util.binarySearchFloor(this.timesUs, j, true, true);
        SeekPoint seekPoint = new SeekPoint(this.timesUs[binarySearchFloor], this.positions[binarySearchFloor]);
        if (seekPoint.timeUs < j) {
            long[] jArr = this.timesUs;
            if (binarySearchFloor != jArr.length - 1) {
                int i = binarySearchFloor + 1;
                return new SeekMap.SeekPoints(seekPoint, new SeekPoint(jArr[i], this.positions[i]));
            }
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.exoplayer2.util.Util.binarySearchFloor(long[], long, boolean, boolean):int
     arg types: [long[], long, int, int]
     candidates:
      com.google.android.exoplayer2.util.Util.binarySearchFloor(com.google.android.exoplayer2.util.LongArray, long, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchFloor(java.util.List, java.lang.Comparable, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchFloor(int[], int, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchFloor(long[], long, boolean, boolean):int */
    public final long getTimeUs(long j) {
        return this.timesUs[Util.binarySearchFloor(this.positions, j, true, true)];
    }

    public final long getDurationUs() {
        return this.durationUs;
    }

    public final long getDataEndPosition() {
        return this.dataEndPosition;
    }
}
