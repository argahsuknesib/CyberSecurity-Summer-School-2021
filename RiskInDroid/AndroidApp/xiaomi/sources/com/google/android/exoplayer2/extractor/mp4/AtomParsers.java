package com.google.android.exoplayer2.extractor.mp4;

import android.support.v4.app.NotificationCompat;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.AvcConfig;
import com.google.android.exoplayer2.video.DolbyVisionConfig;
import com.google.android.exoplayer2.video.HevcConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class AtomParsers {
    private static final byte[] opusMagic = Util.getUtf8Bytes("OpusHead");

    interface SampleSizeBox {
        int getSampleCount();

        boolean isFixedSampleSize();

        int readNextSampleSize();
    }

    private static int getTrackTypeForHdlr(int i) {
        if (i == 1936684398) {
            return 1;
        }
        if (i == 1986618469) {
            return 2;
        }
        if (i == 1952807028 || i == 1935832172 || i == 1937072756 || i == 1668047728) {
            return 3;
        }
        return i == 1835365473 ? 4 : -1;
    }

    public static Track parseTrak(Atom.ContainerAtom containerAtom, Atom.LeafAtom leafAtom, long j, DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        long j2;
        Atom.LeafAtom leafAtom2;
        long[] jArr;
        long[] jArr2;
        Atom.ContainerAtom containerAtomOfType;
        Pair<long[], long[]> parseEdts;
        Atom.ContainerAtom containerAtom2 = containerAtom;
        Atom.ContainerAtom containerAtomOfType2 = containerAtom2.getContainerAtomOfType(1835297121);
        int trackTypeForHdlr = getTrackTypeForHdlr(parseHdlr(containerAtomOfType2.getLeafAtomOfType(1751411826).data));
        if (trackTypeForHdlr == -1) {
            return null;
        }
        TkhdData parseTkhd = parseTkhd(containerAtom2.getLeafAtomOfType(1953196132).data);
        long j3 = -9223372036854775807L;
        if (j == -9223372036854775807L) {
            j2 = parseTkhd.duration;
            leafAtom2 = leafAtom;
        } else {
            leafAtom2 = leafAtom;
            j2 = j;
        }
        long parseMvhd = parseMvhd(leafAtom2.data);
        if (j2 != -9223372036854775807L) {
            j3 = Util.scaleLargeTimestamp(j2, 1000000, parseMvhd);
        }
        long j4 = j3;
        Atom.ContainerAtom containerAtomOfType3 = containerAtomOfType2.getContainerAtomOfType(1835626086).getContainerAtomOfType(1937007212);
        Pair<Long, String> parseMdhd = parseMdhd(containerAtomOfType2.getLeafAtomOfType(1835296868).data);
        StsdData parseStsd = parseStsd(containerAtomOfType3.getLeafAtomOfType(1937011556).data, parseTkhd.id, parseTkhd.rotationDegrees, (String) parseMdhd.second, drmInitData, z2);
        if (z || (containerAtomOfType = containerAtom2.getContainerAtomOfType(1701082227)) == null || (parseEdts = parseEdts(containerAtomOfType)) == null) {
            jArr2 = null;
            jArr = null;
        } else {
            jArr = (long[]) parseEdts.second;
            jArr2 = (long[]) parseEdts.first;
        }
        if (parseStsd.format == null) {
            return null;
        }
        return new Track(parseTkhd.id, trackTypeForHdlr, ((Long) parseMdhd.first).longValue(), parseMvhd, j4, parseStsd.format, parseStsd.requiredSampleTransformation, parseStsd.trackEncryptionBoxes, parseStsd.nalUnitLengthFieldLength, jArr2, jArr);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.exoplayer2.util.Util.binarySearchFloor(long[], long, boolean, boolean):int
     arg types: [long[], long, int, int]
     candidates:
      com.google.android.exoplayer2.util.Util.binarySearchFloor(com.google.android.exoplayer2.util.LongArray, long, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchFloor(java.util.List, java.lang.Comparable, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchFloor(int[], int, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchFloor(long[], long, boolean, boolean):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.exoplayer2.util.Util.binarySearchCeil(long[], long, boolean, boolean):int
     arg types: [long[], long, boolean, int]
     candidates:
      com.google.android.exoplayer2.util.Util.binarySearchCeil(java.util.List, java.lang.Comparable, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchCeil(int[], int, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchCeil(long[], long, boolean, boolean):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    public static TrackSampleTable parseStbl(Track track, Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder) throws ParserException {
        SampleSizeBox sampleSizeBox;
        boolean z;
        int i;
        int i2;
        int i3;
        boolean z2;
        int i4;
        long j;
        int[] iArr;
        long[] jArr;
        int i5;
        int[] iArr2;
        long[] jArr2;
        long[] jArr3;
        int[] iArr3;
        int[] iArr4;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z3;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        Track track2 = track;
        Atom.ContainerAtom containerAtom2 = containerAtom;
        Atom.LeafAtom leafAtomOfType = containerAtom2.getLeafAtomOfType(1937011578);
        if (leafAtomOfType != null) {
            sampleSizeBox = new StszSampleSizeBox(leafAtomOfType);
        } else {
            Atom.LeafAtom leafAtomOfType2 = containerAtom2.getLeafAtomOfType(1937013298);
            if (leafAtomOfType2 != null) {
                sampleSizeBox = new Stz2SampleSizeBox(leafAtomOfType2);
            } else {
                throw new ParserException("Track has no sample table size information");
            }
        }
        int sampleCount = sampleSizeBox.getSampleCount();
        if (sampleCount == 0) {
            return new TrackSampleTable(track, new long[0], new int[0], 0, new long[0], new int[0], -9223372036854775807L);
        }
        Atom.LeafAtom leafAtomOfType3 = containerAtom2.getLeafAtomOfType(1937007471);
        if (leafAtomOfType3 == null) {
            leafAtomOfType3 = containerAtom2.getLeafAtomOfType(1668232756);
            z = true;
        } else {
            z = false;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType3.data;
        ParsableByteArray parsableByteArray2 = containerAtom2.getLeafAtomOfType(1937011555).data;
        ParsableByteArray parsableByteArray3 = containerAtom2.getLeafAtomOfType(1937011827).data;
        Atom.LeafAtom leafAtomOfType4 = containerAtom2.getLeafAtomOfType(1937011571);
        ParsableByteArray parsableByteArray4 = leafAtomOfType4 != null ? leafAtomOfType4.data : null;
        Atom.LeafAtom leafAtomOfType5 = containerAtom2.getLeafAtomOfType(1668576371);
        ParsableByteArray parsableByteArray5 = leafAtomOfType5 != null ? leafAtomOfType5.data : null;
        ChunkIterator chunkIterator = new ChunkIterator(parsableByteArray2, parsableByteArray, z);
        parsableByteArray3.setPosition(12);
        int readUnsignedIntToInt = parsableByteArray3.readUnsignedIntToInt() - 1;
        int readUnsignedIntToInt2 = parsableByteArray3.readUnsignedIntToInt();
        int readUnsignedIntToInt3 = parsableByteArray3.readUnsignedIntToInt();
        if (parsableByteArray5 != null) {
            parsableByteArray5.setPosition(12);
            i = parsableByteArray5.readUnsignedIntToInt();
        } else {
            i = 0;
        }
        int i15 = -1;
        if (parsableByteArray4 != null) {
            parsableByteArray4.setPosition(12);
            i2 = parsableByteArray4.readUnsignedIntToInt();
            if (i2 > 0) {
                i15 = parsableByteArray4.readUnsignedIntToInt() - 1;
            } else {
                parsableByteArray4 = null;
            }
        } else {
            i2 = 0;
        }
        if (sampleSizeBox.isFixedSampleSize() && "audio/raw".equals(track2.format.sampleMimeType) && readUnsignedIntToInt == 0 && i == 0 && i2 == 0) {
            i3 = readUnsignedIntToInt;
            z2 = true;
        } else {
            i3 = readUnsignedIntToInt;
            z2 = false;
        }
        if (!z2) {
            long[] jArr4 = new long[sampleCount];
            int[] iArr5 = new int[sampleCount];
            long[] jArr5 = new long[sampleCount];
            int[] iArr6 = new int[sampleCount];
            int i16 = i3;
            ParsableByteArray parsableByteArray6 = parsableByteArray3;
            int i17 = readUnsignedIntToInt3;
            int i18 = i;
            int i19 = 0;
            long j2 = 0;
            long j3 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = i2;
            int i23 = readUnsignedIntToInt2;
            int i24 = i15;
            int i25 = 0;
            int i26 = 0;
            while (true) {
                if (i25 >= sampleCount) {
                    i4 = sampleCount;
                    i8 = i22;
                    i9 = i23;
                    break;
                }
                long j4 = j3;
                boolean z4 = true;
                while (i26 == 0) {
                    z4 = chunkIterator.moveNext();
                    if (!z4) {
                        break;
                    }
                    int i27 = i22;
                    long j5 = chunkIterator.offset;
                    i26 = chunkIterator.numSamples;
                    j4 = j5;
                    i22 = i27;
                    i23 = i23;
                    sampleCount = sampleCount;
                }
                int i28 = sampleCount;
                i8 = i22;
                i9 = i23;
                if (!z4) {
                    Log.w("AtomParsers", "Unexpected end of chunk data");
                    jArr4 = Arrays.copyOf(jArr4, i25);
                    iArr5 = Arrays.copyOf(iArr5, i25);
                    jArr5 = Arrays.copyOf(jArr5, i25);
                    iArr6 = Arrays.copyOf(iArr6, i25);
                    i4 = i25;
                    break;
                }
                if (parsableByteArray5 != null) {
                    int i29 = i18;
                    while (i20 == 0 && i29 > 0) {
                        i20 = parsableByteArray5.readUnsignedIntToInt();
                        i21 = parsableByteArray5.readInt();
                        i29--;
                    }
                    i20--;
                    i12 = i29;
                } else {
                    i12 = i18;
                }
                int i30 = i21;
                jArr4[i25] = j4;
                iArr5[i25] = sampleSizeBox.readNextSampleSize();
                if (iArr5[i25] > i19) {
                    i19 = iArr5[i25];
                }
                jArr5[i25] = j2 + ((long) i30);
                iArr6[i25] = parsableByteArray4 == null ? 1 : 0;
                if (i25 == i24) {
                    iArr6[i25] = 1;
                    int i31 = i8 - 1;
                    if (i31 > 0) {
                        i24 = parsableByteArray4.readUnsignedIntToInt() - 1;
                    }
                    i13 = i19;
                    i22 = i31;
                    i14 = i30;
                } else {
                    i13 = i19;
                    i14 = i30;
                    i22 = i8;
                }
                j2 += (long) i17;
                int i32 = i9 - 1;
                if (i32 == 0 && i16 > 0) {
                    i32 = parsableByteArray6.readUnsignedIntToInt();
                    i16--;
                    i17 = parsableByteArray6.readInt();
                }
                i26--;
                i25++;
                i21 = i14;
                i23 = i32;
                j3 = j4 + ((long) iArr5[i25]);
                i19 = i13;
                i18 = i12;
                sampleCount = i28;
            }
            int i33 = i26;
            long j6 = j2 + ((long) i21);
            int i34 = i18;
            while (true) {
                if (i34 <= 0) {
                    z3 = true;
                    break;
                } else if (parsableByteArray5.readUnsignedIntToInt() != 0) {
                    z3 = false;
                    break;
                } else {
                    parsableByteArray5.readInt();
                    i34--;
                }
            }
            if (i8 == 0 && i9 == 0 && i33 == 0 && i16 == 0) {
                i11 = i20;
                if (i11 == 0 && z3) {
                    i10 = i19;
                    track2 = track;
                    jArr2 = jArr4;
                    jArr = jArr5;
                    iArr = iArr6;
                    i5 = i10;
                    iArr2 = iArr5;
                    j = j6;
                }
            } else {
                i11 = i20;
            }
            StringBuilder sb = new StringBuilder("Inconsistent stbl box for track ");
            i10 = i19;
            track2 = track;
            sb.append(track2.id);
            sb.append(": remainingSynchronizationSamples ");
            sb.append(i8);
            sb.append(", remainingSamplesAtTimestampDelta ");
            sb.append(i9);
            sb.append(", remainingSamplesInChunk ");
            sb.append(i33);
            sb.append(", remainingTimestampDeltaChanges ");
            sb.append(i16);
            sb.append(", remainingSamplesAtTimestampOffset ");
            sb.append(i11);
            sb.append(!z3 ? ", ctts invalid" : "");
            Log.w("AtomParsers", sb.toString());
            jArr2 = jArr4;
            jArr = jArr5;
            iArr = iArr6;
            i5 = i10;
            iArr2 = iArr5;
            j = j6;
        } else {
            i4 = sampleCount;
            long[] jArr6 = new long[chunkIterator.length];
            int[] iArr7 = new int[chunkIterator.length];
            while (chunkIterator.moveNext()) {
                jArr6[chunkIterator.index] = chunkIterator.offset;
                iArr7[chunkIterator.index] = chunkIterator.numSamples;
            }
            FixedSampleSizeRechunker.Results rechunk = FixedSampleSizeRechunker.rechunk(Util.getPcmFrameSize(track2.format.pcmEncoding, track2.format.channelCount), jArr6, iArr7, (long) readUnsignedIntToInt3);
            jArr2 = rechunk.offsets;
            iArr2 = rechunk.sizes;
            i5 = rechunk.maximumSize;
            jArr = rechunk.timestamps;
            iArr = rechunk.flags;
            j = rechunk.duration;
        }
        int i35 = i4;
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(j, 1000000, track2.timescale);
        if (track2.editListDurations == null) {
            Util.scaleLargeTimestampsInPlace(jArr, 1000000, track2.timescale);
            return new TrackSampleTable(track, jArr2, iArr2, i5, jArr, iArr, scaleLargeTimestamp);
        }
        if (track2.editListDurations.length == 1 && track2.type == 1 && jArr.length >= 2) {
            long j7 = track2.editListMediaTimes[0];
            long scaleLargeTimestamp2 = Util.scaleLargeTimestamp(track2.editListDurations[0], track2.timescale, track2.movieTimescale) + j7;
            if (canApplyEditWithGaplessInfo(jArr, j, j7, scaleLargeTimestamp2)) {
                long j8 = j - scaleLargeTimestamp2;
                long scaleLargeTimestamp3 = Util.scaleLargeTimestamp(j7 - jArr[0], (long) track2.format.sampleRate, track2.timescale);
                long scaleLargeTimestamp4 = Util.scaleLargeTimestamp(j8, (long) track2.format.sampleRate, track2.timescale);
                if (!(scaleLargeTimestamp3 == 0 && scaleLargeTimestamp4 == 0) && scaleLargeTimestamp3 <= 2147483647L && scaleLargeTimestamp4 <= 2147483647L) {
                    GaplessInfoHolder gaplessInfoHolder2 = gaplessInfoHolder;
                    gaplessInfoHolder2.encoderDelay = (int) scaleLargeTimestamp3;
                    gaplessInfoHolder2.encoderPadding = (int) scaleLargeTimestamp4;
                    Util.scaleLargeTimestampsInPlace(jArr, 1000000, track2.timescale);
                    return new TrackSampleTable(track, jArr2, iArr2, i5, jArr, iArr, Util.scaleLargeTimestamp(track2.editListDurations[0], 1000000, track2.movieTimescale));
                }
            }
        }
        if (track2.editListDurations.length == 1 && track2.editListDurations[0] == 0) {
            long j9 = track2.editListMediaTimes[0];
            for (int i36 = 0; i36 < jArr.length; i36++) {
                jArr[i36] = Util.scaleLargeTimestamp(jArr[i36] - j9, 1000000, track2.timescale);
            }
            return new TrackSampleTable(track, jArr2, iArr2, i5, jArr, iArr, Util.scaleLargeTimestamp(j - j9, 1000000, track2.timescale));
        }
        boolean z5 = track2.type == 1;
        int[] iArr8 = new int[track2.editListDurations.length];
        int[] iArr9 = new int[track2.editListDurations.length];
        int i37 = 0;
        boolean z6 = false;
        int i38 = 0;
        int i39 = 0;
        while (i37 < track2.editListDurations.length) {
            int i40 = i38;
            long j10 = track2.editListMediaTimes[i37];
            if (j10 != -1) {
                i6 = i5;
                int i41 = i39;
                iArr4 = iArr2;
                long scaleLargeTimestamp5 = Util.scaleLargeTimestamp(track2.editListDurations[i37], track2.timescale, track2.movieTimescale);
                iArr8[i37] = Util.binarySearchFloor(jArr, j10, true, true);
                iArr9[i37] = Util.binarySearchCeil(jArr, j10 + scaleLargeTimestamp5, z5, false);
                while (iArr8[i37] < iArr9[i37] && (iArr[iArr8[i37]] & 1) == 0) {
                    iArr8[i37] = iArr8[i37] + 1;
                }
                i38 = i40 + (iArr9[i37] - iArr8[i37]);
                boolean z7 = i41 != iArr8[i37];
                i7 = iArr9[i37];
                z6 = z7 | z6;
            } else {
                iArr4 = iArr2;
                i6 = i5;
                i7 = i39;
                i38 = i40;
            }
            i37++;
            iArr2 = iArr4;
            i39 = i7;
            i5 = i6;
        }
        int[] iArr10 = iArr2;
        int i42 = i5;
        int i43 = 0;
        boolean z8 = true;
        if (i38 == i35) {
            z8 = false;
        }
        boolean z9 = z6 | z8;
        long[] jArr7 = z9 ? new long[i38] : jArr2;
        int[] iArr11 = z9 ? new int[i38] : iArr10;
        if (z9) {
            i42 = 0;
        }
        int[] iArr12 = z9 ? new int[i38] : iArr;
        long[] jArr8 = new long[i38];
        int i44 = i42;
        int i45 = 0;
        long j11 = 0;
        while (i43 < track2.editListDurations.length) {
            long j12 = track2.editListMediaTimes[i43];
            int i46 = iArr8[i43];
            int i47 = iArr9[i43];
            if (z9) {
                int i48 = i47 - i46;
                System.arraycopy(jArr2, i46, jArr7, i45, i48);
                jArr3 = jArr2;
                iArr3 = iArr10;
                System.arraycopy(iArr3, i46, iArr11, i45, i48);
                System.arraycopy(iArr, i46, iArr12, i45, i48);
            } else {
                jArr3 = jArr2;
                iArr3 = iArr10;
            }
            int i49 = i46;
            int i50 = i44;
            int i51 = i45;
            int i52 = i50;
            while (i49 < i47) {
                int[] iArr13 = iArr8;
                int[] iArr14 = iArr9;
                int[] iArr15 = iArr;
                int i53 = i52;
                int i54 = i47;
                int i55 = i49;
                jArr8[i51] = Util.scaleLargeTimestamp(j11, 1000000, track2.movieTimescale) + Util.scaleLargeTimestamp(Math.max(0L, jArr[i55] - j12), 1000000, track2.timescale);
                if (z9 && iArr11[i51] > i53) {
                    i53 = iArr3[i55];
                }
                i52 = i53;
                i51++;
                i49 = i55 + 1;
                iArr8 = iArr13;
                iArr9 = iArr14;
                iArr = iArr15;
                i47 = i54;
            }
            int[] iArr16 = iArr;
            int i56 = i52;
            j11 += track2.editListDurations[i43];
            i43++;
            iArr10 = iArr3;
            i45 = i51;
            iArr8 = iArr8;
            jArr2 = jArr3;
            i44 = i56;
            iArr = iArr16;
        }
        return new TrackSampleTable(track, jArr7, iArr11, i44, jArr8, iArr12, Util.scaleLargeTimestamp(j11, 1000000, track2.movieTimescale));
    }

    public static Metadata parseUdta(Atom.LeafAtom leafAtom, boolean z) {
        if (z) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtom.data;
        parsableByteArray.setPosition(8);
        while (parsableByteArray.bytesLeft() >= 8) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1835365473) {
                parsableByteArray.setPosition(position);
                return parseUdtaMeta(parsableByteArray, position + readInt);
            }
            parsableByteArray.setPosition(position + readInt);
        }
        return null;
    }

    public static Metadata parseMdtaFromMeta(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(1751411826);
        Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(1801812339);
        Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(1768715124);
        if (leafAtomOfType == null || leafAtomOfType2 == null || leafAtomOfType3 == null || parseHdlr(leafAtomOfType.data) != 1835299937) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType2.data;
        parsableByteArray.setPosition(12);
        int readInt = parsableByteArray.readInt();
        String[] strArr = new String[readInt];
        for (int i = 0; i < readInt; i++) {
            int readInt2 = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            strArr[i] = parsableByteArray.readString(readInt2 - 8);
        }
        ParsableByteArray parsableByteArray2 = leafAtomOfType3.data;
        parsableByteArray2.setPosition(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray2.bytesLeft() > 8) {
            int position = parsableByteArray2.getPosition();
            int readInt3 = parsableByteArray2.readInt();
            int readInt4 = parsableByteArray2.readInt() - 1;
            if (readInt4 < 0 || readInt4 >= readInt) {
                Log.w("AtomParsers", "Skipped metadata with unknown key index: ".concat(String.valueOf(readInt4)));
            } else {
                MdtaMetadataEntry parseMdtaMetadataEntryFromIlst = MetadataUtil.parseMdtaMetadataEntryFromIlst(parsableByteArray2, position + readInt3, strArr[readInt4]);
                if (parseMdtaMetadataEntryFromIlst != null) {
                    arrayList.add(parseMdtaMetadataEntryFromIlst);
                }
            }
            parsableByteArray2.setPosition(position + readInt3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static Metadata parseUdtaMeta(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(12);
        while (parsableByteArray.getPosition() < i) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1768715124) {
                parsableByteArray.setPosition(position);
                return parseIlst(parsableByteArray, position + readInt);
            }
            parsableByteArray.setPosition(position + readInt);
        }
        return null;
    }

    private static Metadata parseIlst(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.getPosition() < i) {
            Metadata.Entry parseIlstElement = MetadataUtil.parseIlstElement(parsableByteArray);
            if (parseIlstElement != null) {
                arrayList.add(parseIlstElement);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static long parseMvhd(ParsableByteArray parsableByteArray) {
        int i = 8;
        parsableByteArray.setPosition(8);
        if (Atom.parseFullAtomVersion(parsableByteArray.readInt()) != 0) {
            i = 16;
        }
        parsableByteArray.skipBytes(i);
        return parsableByteArray.readUnsignedInt();
    }

    private static TkhdData parseTkhd(ParsableByteArray parsableByteArray) {
        boolean z;
        int i = 8;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 8 : 16);
        int readInt = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int position = parsableByteArray.getPosition();
        if (parseFullAtomVersion == 0) {
            i = 4;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= i) {
                z = true;
                break;
            } else if (parsableByteArray.data[position + i3] != -1) {
                z = false;
                break;
            } else {
                i3++;
            }
        }
        long j = -9223372036854775807L;
        if (z) {
            parsableByteArray.skipBytes(i);
        } else {
            long readUnsignedInt = parseFullAtomVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
            if (readUnsignedInt != 0) {
                j = readUnsignedInt;
            }
        }
        parsableByteArray.skipBytes(16);
        int readInt2 = parsableByteArray.readInt();
        int readInt3 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int readInt4 = parsableByteArray.readInt();
        int readInt5 = parsableByteArray.readInt();
        if (readInt2 == 0 && readInt3 == 65536 && readInt4 == -65536 && readInt5 == 0) {
            i2 = 90;
        } else if (readInt2 == 0 && readInt3 == -65536 && readInt4 == 65536 && readInt5 == 0) {
            i2 = 270;
        } else if (readInt2 == -65536 && readInt3 == 0 && readInt4 == 0 && readInt5 == -65536) {
            i2 = 180;
        }
        return new TkhdData(readInt, j, i2);
    }

    private static int parseHdlr(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(16);
        return parsableByteArray.readInt();
    }

    private static Pair<Long, String> parseMdhd(ParsableByteArray parsableByteArray) {
        int i = 8;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 8 : 16);
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        if (parseFullAtomVersion == 0) {
            i = 4;
        }
        parsableByteArray.skipBytes(i);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        StringBuilder sb = new StringBuilder();
        sb.append((char) (((readUnsignedShort >> 10) & 31) + 96));
        sb.append((char) (((readUnsignedShort >> 5) & 31) + 96));
        sb.append((char) ((readUnsignedShort & 31) + 96));
        return Pair.create(Long.valueOf(readUnsignedInt), sb.toString());
    }

    private static StsdData parseStsd(ParsableByteArray parsableByteArray, int i, int i2, String str, DrmInitData drmInitData, boolean z) throws ParserException {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        parsableByteArray2.setPosition(12);
        int readInt = parsableByteArray.readInt();
        StsdData stsdData = new StsdData(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            int position = parsableByteArray.getPosition();
            int readInt2 = parsableByteArray.readInt();
            Assertions.checkState(readInt2 > 0, "childAtomSize should be positive");
            int readInt3 = parsableByteArray.readInt();
            if (readInt3 == 1635148593 || readInt3 == 1635148595 || readInt3 == 1701733238 || readInt3 == 1836070006 || readInt3 == 1752589105 || readInt3 == 1751479857 || readInt3 == 1932670515 || readInt3 == 1987063864 || readInt3 == 1987063865 || readInt3 == 1635135537 || readInt3 == 1685479798 || readInt3 == 1685479729 || readInt3 == 1685481573 || readInt3 == 1685481521) {
                parseVideoSampleEntry(parsableByteArray, readInt3, position, readInt2, i, i2, drmInitData, stsdData, i3);
            } else if (readInt3 == 1836069985 || readInt3 == 1701733217 || readInt3 == 1633889587 || readInt3 == 1700998451 || readInt3 == 1633889588 || readInt3 == 1685353315 || readInt3 == 1685353317 || readInt3 == 1685353320 || readInt3 == 1685353324 || readInt3 == 1935764850 || readInt3 == 1935767394 || readInt3 == 1819304813 || readInt3 == 1936684916 || readInt3 == 1953984371 || readInt3 == 778924083 || readInt3 == 1634492771 || readInt3 == 1634492791 || readInt3 == 1970037111 || readInt3 == 1332770163 || readInt3 == 1716281667) {
                parseAudioSampleEntry(parsableByteArray, readInt3, position, readInt2, i, str, z, drmInitData, stsdData, i3);
            } else if (readInt3 == 1414810956 || readInt3 == 1954034535 || readInt3 == 2004251764 || readInt3 == 1937010800 || readInt3 == 1664495672) {
                parseTextSampleEntry(parsableByteArray, readInt3, position, readInt2, i, str, stsdData);
            } else if (readInt3 == 1667329389) {
                stsdData.format = new Format.Builder().setId(i).setSampleMimeType("application/x-camera-motion").build();
            }
            parsableByteArray2.setPosition(position + readInt2);
        }
        return stsdData;
    }

    private static void parseTextSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, StsdData stsdData) {
        parsableByteArray.setPosition(i2 + 8 + 8);
        String str2 = "application/ttml+xml";
        List list = null;
        long j = Long.MAX_VALUE;
        if (i != 1414810956) {
            if (i == 1954034535) {
                int i5 = (i3 - 8) - 8;
                byte[] bArr = new byte[i5];
                parsableByteArray.readBytes(bArr, 0, i5);
                list = Collections.singletonList(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i == 2004251764) {
                str2 = "application/x-mp4-vtt";
            } else if (i == 1937010800) {
                j = 0;
            } else if (i == 1664495672) {
                stsdData.requiredSampleTransformation = 1;
                str2 = "application/x-mp4-cea-608";
            } else {
                throw new IllegalStateException();
            }
        }
        stsdData.format = new Format.Builder().setId(i4).setSampleMimeType(str2).setLanguage(str).setSubsampleOffsetUs(j).setInitializationData(list).build();
    }

    private static void parseVideoSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, int i5, DrmInitData drmInitData, StsdData stsdData, int i6) throws ParserException {
        DrmInitData drmInitData2;
        List<byte[]> list;
        List<byte[]> list2;
        String str;
        String str2;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i7 = i2;
        int i8 = i3;
        DrmInitData drmInitData3 = drmInitData;
        StsdData stsdData2 = stsdData;
        parsableByteArray2.setPosition(i7 + 8 + 8);
        parsableByteArray2.skipBytes(16);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
        parsableByteArray2.skipBytes(50);
        int position = parsableByteArray.getPosition();
        String str3 = null;
        int i9 = i;
        if (i9 == 1701733238) {
            Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray2, i7, i8);
            if (parseSampleEntryEncryptionData != null) {
                i9 = ((Integer) parseSampleEntryEncryptionData.first).intValue();
                if (drmInitData3 == null) {
                    drmInitData3 = null;
                } else {
                    drmInitData3 = drmInitData3.copyWithSchemeType(((TrackEncryptionBox) parseSampleEntryEncryptionData.second).schemeType);
                }
                stsdData2.trackEncryptionBoxes[i6] = (TrackEncryptionBox) parseSampleEntryEncryptionData.second;
            }
            parsableByteArray2.setPosition(position);
        }
        float f = 1.0f;
        byte[] bArr = null;
        List<byte[]> list3 = null;
        String str4 = null;
        int i10 = -1;
        boolean z = false;
        while (true) {
            if (position - i7 >= i8) {
                drmInitData2 = drmInitData3;
                list = list3;
                break;
            }
            parsableByteArray2.setPosition(position);
            int position2 = parsableByteArray.getPosition();
            drmInitData2 = drmInitData3;
            int readInt = parsableByteArray.readInt();
            if (readInt == 0) {
                list = list3;
                if (parsableByteArray.getPosition() - i7 == i8) {
                    break;
                }
            } else {
                list = list3;
            }
            Assertions.checkState(readInt > 0, "childAtomSize should be positive");
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == 1635148611) {
                Assertions.checkState(str4 == null);
                parsableByteArray2.setPosition(position2 + 8);
                AvcConfig parse = AvcConfig.parse(parsableByteArray);
                list2 = parse.initializationData;
                stsdData2.nalUnitLengthFieldLength = parse.nalUnitLengthFieldLength;
                if (!z) {
                    f = parse.pixelWidthAspectRatio;
                }
                str = "video/avc";
            } else if (readInt2 == 1752589123) {
                Assertions.checkState(str4 == null);
                parsableByteArray2.setPosition(position2 + 8);
                HevcConfig parse2 = HevcConfig.parse(parsableByteArray);
                list2 = parse2.initializationData;
                stsdData2.nalUnitLengthFieldLength = parse2.nalUnitLengthFieldLength;
                str = "video/hevc";
            } else {
                if (readInt2 == 1685480259 || readInt2 == 1685485123) {
                    DolbyVisionConfig parse3 = DolbyVisionConfig.parse(parsableByteArray);
                    if (parse3 != null) {
                        str3 = parse3.codecs;
                        str4 = "video/dolby-vision";
                    }
                } else {
                    if (readInt2 == 1987076931) {
                        Assertions.checkState(str4 == null);
                        str2 = i9 == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                    } else if (readInt2 == 1635135811) {
                        Assertions.checkState(str4 == null);
                        str2 = "video/av01";
                    } else if (readInt2 == 1681012275) {
                        Assertions.checkState(str4 == null);
                        str2 = "video/3gpp";
                    } else {
                        if (readInt2 == 1702061171) {
                            Assertions.checkState(str4 == null);
                            Pair<String, byte[]> parseEsdsFromParent = parseEsdsFromParent(parsableByteArray2, position2);
                            String str5 = (String) parseEsdsFromParent.first;
                            byte[] bArr2 = (byte[]) parseEsdsFromParent.second;
                            list3 = bArr2 != null ? Collections.singletonList(bArr2) : list;
                            str4 = str5;
                        } else if (readInt2 == 1885434736) {
                            list3 = list;
                            f = parsePaspFromParent(parsableByteArray2, position2);
                            z = true;
                        } else if (readInt2 == 1937126244) {
                            list3 = list;
                            bArr = parseProjFromParent(parsableByteArray2, position2, readInt);
                        } else if (readInt2 == 1936995172) {
                            int readUnsignedByte = parsableByteArray.readUnsignedByte();
                            parsableByteArray2.skipBytes(3);
                            if (readUnsignedByte == 0) {
                                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                                if (readUnsignedByte2 == 0) {
                                    list3 = list;
                                    i10 = 0;
                                } else if (readUnsignedByte2 == 1) {
                                    list3 = list;
                                    i10 = 1;
                                } else if (readUnsignedByte2 == 2) {
                                    list3 = list;
                                    i10 = 2;
                                } else if (readUnsignedByte2 == 3) {
                                    list3 = list;
                                    i10 = 3;
                                }
                            }
                        }
                        position += readInt;
                        i7 = i2;
                        i8 = i3;
                        drmInitData3 = drmInitData2;
                    }
                    list3 = list;
                    str4 = str2;
                    position += readInt;
                    i7 = i2;
                    i8 = i3;
                    drmInitData3 = drmInitData2;
                }
                list3 = list;
                position += readInt;
                i7 = i2;
                i8 = i3;
                drmInitData3 = drmInitData2;
            }
            str4 = str;
            list3 = list2;
            position += readInt;
            i7 = i2;
            i8 = i3;
            drmInitData3 = drmInitData2;
        }
        if (str4 != null) {
            stsdData2.format = new Format.Builder().setId(i4).setSampleMimeType(str4).setCodecs(str3).setWidth(readUnsignedShort).setHeight(readUnsignedShort2).setPixelWidthHeightRatio(f).setRotationDegrees(i5).setProjectionData(bArr).setStereoMode(i10).setInitializationData(list).setDrmInitData(drmInitData2).build();
        }
    }

    private static Pair<long[], long[]> parseEdts(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(1701606260);
        if (leafAtomOfType == null) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType.data;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[readUnsignedIntToInt];
        long[] jArr2 = new long[readUnsignedIntToInt];
        int i = 0;
        while (i < readUnsignedIntToInt) {
            jArr[i] = parseFullAtomVersion == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
            jArr2[i] = parseFullAtomVersion == 1 ? parsableByteArray.readLong() : (long) parsableByteArray.readInt();
            if (parsableByteArray.readShort() == 1) {
                parsableByteArray.skipBytes(2);
                i++;
            } else {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
        }
        return Pair.create(jArr, jArr2);
    }

    private static float parsePaspFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8);
        return ((float) parsableByteArray.readUnsignedIntToInt()) / ((float) parsableByteArray.readUnsignedIntToInt());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v5, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x029c A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:142:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0133  */
    private static void parseAudioSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, boolean z, DrmInitData drmInitData, StsdData stsdData, int i5) throws ParserException {
        int i6;
        int i7;
        int i8;
        DrmInitData drmInitData2;
        int i9;
        List list;
        int i10;
        boolean z2;
        String str2;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        String str3 = str;
        DrmInitData drmInitData3 = drmInitData;
        StsdData stsdData2 = stsdData;
        parsableByteArray2.setPosition(i11 + 8 + 8);
        if (z) {
            i6 = parsableByteArray.readUnsignedShort();
            parsableByteArray2.skipBytes(6);
        } else {
            parsableByteArray2.skipBytes(8);
            i6 = 0;
        }
        boolean z3 = true;
        if (i6 == 0 || i6 == 1) {
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            parsableByteArray2.skipBytes(6);
            int readUnsignedFixedPoint1616 = parsableByteArray.readUnsignedFixedPoint1616();
            if (i6 == 1) {
                parsableByteArray2.skipBytes(16);
            }
            i7 = readUnsignedFixedPoint1616;
            i8 = readUnsignedShort;
        } else if (i6 == 2) {
            parsableByteArray2.skipBytes(16);
            i7 = (int) Math.round(parsableByteArray.readDouble());
            i8 = parsableByteArray.readUnsignedIntToInt();
            parsableByteArray2.skipBytes(20);
        } else {
            return;
        }
        int position = parsableByteArray.getPosition();
        int i14 = i;
        if (i14 == 1701733217) {
            Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray2, i11, i12);
            if (parseSampleEntryEncryptionData != null) {
                i14 = ((Integer) parseSampleEntryEncryptionData.first).intValue();
                if (drmInitData3 == null) {
                    drmInitData2 = null;
                } else {
                    drmInitData2 = drmInitData3.copyWithSchemeType(((TrackEncryptionBox) parseSampleEntryEncryptionData.second).schemeType);
                }
                stsdData2.trackEncryptionBoxes[i5] = (TrackEncryptionBox) parseSampleEntryEncryptionData.second;
            } else {
                drmInitData2 = drmInitData3;
            }
            parsableByteArray2.setPosition(position);
        } else {
            drmInitData2 = drmInitData3;
        }
        String str4 = "audio/raw";
        if (i14 == 1633889587) {
            str2 = "audio/ac3";
        } else if (i14 == 1700998451) {
            str2 = "audio/eac3";
        } else if (i14 == 1633889588) {
            str2 = "audio/ac4";
        } else if (i14 == 1685353315) {
            str2 = "audio/vnd.dts";
        } else if (i14 == 1685353320 || i14 == 1685353324) {
            str2 = "audio/vnd.dts.hd";
        } else if (i14 == 1685353317) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (i14 == 1935764850) {
            str2 = "audio/3gpp";
        } else if (i14 == 1935767394) {
            str2 = "audio/amr-wb";
        } else if (i14 == 1819304813 || i14 == 1936684916) {
            i9 = 2;
            int i15 = i8;
            int i16 = i7;
            String str5 = str4;
            String str6 = null;
            byte[] bArr = null;
            while (position - i11 < i12) {
                parsableByteArray2.setPosition(position);
                int readInt = parsableByteArray.readInt();
                if (readInt <= 0) {
                    z3 = false;
                }
                Assertions.checkState(z3, "childAtomSize should be positive");
                int readInt2 = parsableByteArray.readInt();
                if (readInt2 == 1702061171) {
                    z2 = true;
                    i10 = 1702061171;
                } else if (!z || readInt2 != 2002876005) {
                    if (readInt2 == 1684103987) {
                        parsableByteArray2.setPosition(position + 8);
                        stsdData2.format = Ac3Util.parseAc3AnnexFFormat(parsableByteArray2, Integer.toString(i4), str3, drmInitData2);
                    } else if (readInt2 == 1684366131) {
                        parsableByteArray2.setPosition(position + 8);
                        stsdData2.format = Ac3Util.parseEAc3AnnexFFormat(parsableByteArray2, Integer.toString(i4), str3, drmInitData2);
                    } else if (readInt2 == 1684103988) {
                        parsableByteArray2.setPosition(position + 8);
                        stsdData2.format = Ac4Util.parseAc4AnnexEFormat(parsableByteArray2, Integer.toString(i4), str3, drmInitData2);
                    } else if (readInt2 == 1684305011) {
                        stsdData2.format = new Format.Builder().setId(i13).setSampleMimeType(str5).setChannelCount(i15).setSampleRate(i16).setDrmInitData(drmInitData2).setLanguage(str3).build();
                    } else if (readInt2 == 1682927731) {
                        int i17 = readInt - 8;
                        byte[] bArr2 = opusMagic;
                        byte[] bArr3 = new byte[(bArr2.length + i17)];
                        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
                        parsableByteArray2.setPosition(position + 8);
                        parsableByteArray2.readBytes(bArr3, opusMagic.length, i17);
                        bArr = bArr3;
                        z3 = true;
                        position += readInt;
                        i11 = i2;
                        i12 = i3;
                        str3 = str;
                    } else {
                        if (readInt2 == 1684425825) {
                            int i18 = readInt - 12;
                            byte[] bArr4 = new byte[(i18 + 4)];
                            bArr4[0] = 102;
                            z3 = true;
                            bArr4[1] = 76;
                            bArr4[2] = 97;
                            bArr4[3] = 67;
                            parsableByteArray2.setPosition(position + 12);
                            parsableByteArray2.readBytes(bArr4, 4, i18);
                            bArr = bArr4;
                        } else {
                            z3 = true;
                            if (readInt2 == 1634492771) {
                                int i19 = readInt - 12;
                                byte[] bArr5 = new byte[i19];
                                parsableByteArray2.setPosition(position + 12);
                                parsableByteArray2.readBytes(bArr5, 0, i19);
                                Pair<Integer, Integer> parseAlacAudioSpecificConfig = CodecSpecificDataUtil.parseAlacAudioSpecificConfig(bArr5);
                                i16 = ((Integer) parseAlacAudioSpecificConfig.first).intValue();
                                i15 = ((Integer) parseAlacAudioSpecificConfig.second).intValue();
                                bArr = bArr5;
                            }
                        }
                        position += readInt;
                        i11 = i2;
                        i12 = i3;
                        str3 = str;
                    }
                    z3 = true;
                    position += readInt;
                    i11 = i2;
                    i12 = i3;
                    str3 = str;
                } else {
                    i10 = 1702061171;
                    z2 = true;
                }
                int findEsdsPosition = readInt2 == i10 ? position : findEsdsPosition(parsableByteArray2, position, readInt);
                if (findEsdsPosition != -1) {
                    Pair<String, byte[]> parseEsdsFromParent = parseEsdsFromParent(parsableByteArray2, findEsdsPosition);
                    str5 = (String) parseEsdsFromParent.first;
                    bArr = parseEsdsFromParent.second;
                    if ("audio/mp4a-latm".equals(str5) && bArr != null) {
                        AacUtil.Config parseAudioSpecificConfig = AacUtil.parseAudioSpecificConfig(bArr);
                        i16 = parseAudioSpecificConfig.sampleRateHz;
                        i15 = parseAudioSpecificConfig.channelCount;
                        str6 = parseAudioSpecificConfig.codecs;
                    }
                }
                position += readInt;
                i11 = i2;
                i12 = i3;
                str3 = str;
            }
            if (stsdData2.format != null && str5 != null) {
                Format.Builder pcmEncoding = new Format.Builder().setId(i13).setSampleMimeType(str5).setCodecs(str6).setChannelCount(i15).setSampleRate(i16).setPcmEncoding(i9);
                if (bArr == null) {
                    list = null;
                } else {
                    list = Collections.singletonList(bArr);
                }
                stsdData2.format = pcmEncoding.setInitializationData(list).setDrmInitData(drmInitData2).setLanguage(str).build();
                return;
            }
            return;
        } else {
            if (i14 == 1953984371) {
                i9 = 268435456;
            } else if (i14 == 778924083) {
                str2 = "audio/mpeg";
            } else if (i14 == 1634492771) {
                str2 = "audio/alac";
            } else if (i14 == 1634492791) {
                str2 = "audio/g711-alaw";
            } else if (i14 == 1970037111) {
                str2 = "audio/g711-mlaw";
            } else if (i14 == 1332770163) {
                str2 = "audio/opus";
            } else if (i14 == 1716281667) {
                str2 = "audio/flac";
            } else {
                i9 = -1;
                str4 = null;
            }
            int i152 = i8;
            int i162 = i7;
            String str52 = str4;
            String str62 = null;
            byte[] bArr6 = null;
            while (position - i11 < i12) {
            }
            if (stsdData2.format != null) {
                return;
            }
            return;
        }
        str4 = str2;
        i9 = -1;
        int i1522 = i8;
        int i1622 = i7;
        String str522 = str4;
        String str622 = null;
        byte[] bArr62 = null;
        while (position - i11 < i12) {
        }
        if (stsdData2.format != null) {
        }
    }

    private static int findEsdsPosition(ParsableByteArray parsableByteArray, int i, int i2) {
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            Assertions.checkState(readInt > 0, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == 1702061171) {
                return position;
            }
            position += readInt;
        }
        return -1;
    }

    private static Pair<String, byte[]> parseEsdsFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8 + 4);
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((readUnsignedByte & NotificationCompat.FLAG_HIGH_PRIORITY) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        String mimeTypeFromMp4ObjectType = MimeTypes.getMimeTypeFromMp4ObjectType(parsableByteArray.readUnsignedByte());
        if ("audio/mpeg".equals(mimeTypeFromMp4ObjectType) || "audio/vnd.dts".equals(mimeTypeFromMp4ObjectType) || "audio/vnd.dts.hd".equals(mimeTypeFromMp4ObjectType)) {
            return Pair.create(mimeTypeFromMp4ObjectType, null);
        }
        parsableByteArray.skipBytes(12);
        parsableByteArray.skipBytes(1);
        int parseExpandableClassSize = parseExpandableClassSize(parsableByteArray);
        byte[] bArr = new byte[parseExpandableClassSize];
        parsableByteArray.readBytes(bArr, 0, parseExpandableClassSize);
        return Pair.create(mimeTypeFromMp4ObjectType, bArr);
    }

    private static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int i, int i2) {
        Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent;
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            Assertions.checkState(readInt > 0, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == 1936289382 && (parseCommonEncryptionSinfFromParent = parseCommonEncryptionSinfFromParent(parsableByteArray, position, readInt)) != null) {
                return parseCommonEncryptionSinfFromParent;
            }
            position += readInt;
        }
        return null;
    }

    static Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        boolean z = false;
        String str = null;
        Integer num = null;
        int i4 = -1;
        int i5 = 0;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int readInt = parsableByteArray.readInt();
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == 1718775137) {
                num = Integer.valueOf(parsableByteArray.readInt());
            } else if (readInt2 == 1935894637) {
                parsableByteArray.skipBytes(4);
                str = parsableByteArray.readString(4);
            } else if (readInt2 == 1935894633) {
                i4 = i3;
                i5 = readInt;
            }
            i3 += readInt;
        }
        if (!"cenc".equals(str) && !"cbc1".equals(str) && !"cens".equals(str) && !"cbcs".equals(str)) {
            return null;
        }
        Assertions.checkStateNotNull(num, "frma atom is mandatory");
        if (i4 != -1) {
            z = true;
        }
        Assertions.checkState(z, "schi atom is mandatory");
        return Pair.create(num, (TrackEncryptionBox) Assertions.checkStateNotNull(parseSchiFromParent(parsableByteArray, i4, i5, str), "tenc atom is mandatory"));
    }

    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsableByteArray, int i, int i2, String str) {
        int i3;
        int i4;
        int i5 = i + 8;
        while (true) {
            byte[] bArr = null;
            if (i5 - i >= i2) {
                return null;
            }
            parsableByteArray.setPosition(i5);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1952804451) {
                int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
                parsableByteArray.skipBytes(1);
                if (parseFullAtomVersion == 0) {
                    parsableByteArray.skipBytes(1);
                    i4 = 0;
                    i3 = 0;
                } else {
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    i3 = readUnsignedByte & 15;
                    i4 = (readUnsignedByte & 240) >> 4;
                }
                boolean z = parsableByteArray.readUnsignedByte() == 1;
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                parsableByteArray.readBytes(bArr2, 0, 16);
                if (z && readUnsignedByte2 == 0) {
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    bArr = new byte[readUnsignedByte3];
                    parsableByteArray.readBytes(bArr, 0, readUnsignedByte3);
                }
                return new TrackEncryptionBox(z, str, readUnsignedByte2, bArr2, i4, i3, bArr);
            }
            i5 += readInt;
        }
    }

    private static byte[] parseProjFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1886547818) {
                return Arrays.copyOfRange(parsableByteArray.data, i3, readInt + i3);
            }
            i3 += readInt;
        }
        return null;
    }

    private static int parseExpandableClassSize(ParsableByteArray parsableByteArray) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i = readUnsignedByte & 127;
        while ((readUnsignedByte & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
            readUnsignedByte = parsableByteArray.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & 127);
        }
        return i;
    }

    private static boolean canApplyEditWithGaplessInfo(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        return jArr[0] <= j2 && j2 < jArr[Util.constrainValue(4, 0, length)] && jArr[Util.constrainValue(jArr.length - 4, 0, length)] < j3 && j3 <= j;
    }

    private AtomParsers() {
    }

    static final class ChunkIterator {
        private final ParsableByteArray chunkOffsets;
        private final boolean chunkOffsetsAreLongs;
        public int index;
        public final int length;
        private int nextSamplesPerChunkChangeIndex;
        public int numSamples;
        public long offset;
        private int remainingSamplesPerChunkChanges;
        private final ParsableByteArray stsc;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z) {
            this.stsc = parsableByteArray;
            this.chunkOffsets = parsableByteArray2;
            this.chunkOffsetsAreLongs = z;
            parsableByteArray2.setPosition(12);
            this.length = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray.setPosition(12);
            this.remainingSamplesPerChunkChanges = parsableByteArray.readUnsignedIntToInt();
            Assertions.checkState(parsableByteArray.readInt() != 1 ? false : true, "first_chunk must be 1");
            this.index = -1;
        }

        public final boolean moveNext() {
            long j;
            int i = this.index + 1;
            this.index = i;
            if (i == this.length) {
                return false;
            }
            if (this.chunkOffsetsAreLongs) {
                j = this.chunkOffsets.readUnsignedLongToLong();
            } else {
                j = this.chunkOffsets.readUnsignedInt();
            }
            this.offset = j;
            if (this.index == this.nextSamplesPerChunkChangeIndex) {
                this.numSamples = this.stsc.readUnsignedIntToInt();
                this.stsc.skipBytes(4);
                int i2 = this.remainingSamplesPerChunkChanges - 1;
                this.remainingSamplesPerChunkChanges = i2;
                this.nextSamplesPerChunkChangeIndex = i2 > 0 ? this.stsc.readUnsignedIntToInt() - 1 : -1;
            }
            return true;
        }
    }

    static final class TkhdData {
        public final long duration;
        public final int id;
        public final int rotationDegrees;

        public TkhdData(int i, long j, int i2) {
            this.id = i;
            this.duration = j;
            this.rotationDegrees = i2;
        }
    }

    static final class StsdData {
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation = 0;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int i) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[i];
        }
    }

    static final class StszSampleSizeBox implements SampleSizeBox {
        private final ParsableByteArray data;
        private final int fixedSampleSize = this.data.readUnsignedIntToInt();
        private final int sampleCount = this.data.readUnsignedIntToInt();

        public StszSampleSizeBox(Atom.LeafAtom leafAtom) {
            this.data = leafAtom.data;
            this.data.setPosition(12);
        }

        public final int getSampleCount() {
            return this.sampleCount;
        }

        public final int readNextSampleSize() {
            int i = this.fixedSampleSize;
            return i == 0 ? this.data.readUnsignedIntToInt() : i;
        }

        public final boolean isFixedSampleSize() {
            return this.fixedSampleSize != 0;
        }
    }

    static final class Stz2SampleSizeBox implements SampleSizeBox {
        private int currentByte;
        private final ParsableByteArray data;
        private final int fieldSize = (this.data.readUnsignedIntToInt() & 255);
        private final int sampleCount = this.data.readUnsignedIntToInt();
        private int sampleIndex;

        public final boolean isFixedSampleSize() {
            return false;
        }

        public Stz2SampleSizeBox(Atom.LeafAtom leafAtom) {
            this.data = leafAtom.data;
            this.data.setPosition(12);
        }

        public final int getSampleCount() {
            return this.sampleCount;
        }

        public final int readNextSampleSize() {
            int i = this.fieldSize;
            if (i == 8) {
                return this.data.readUnsignedByte();
            }
            if (i == 16) {
                return this.data.readUnsignedShort();
            }
            int i2 = this.sampleIndex;
            this.sampleIndex = i2 + 1;
            if (i2 % 2 != 0) {
                return this.currentByte & 15;
            }
            this.currentByte = this.data.readUnsignedByte();
            return (this.currentByte & 240) >> 4;
        }
    }
}
