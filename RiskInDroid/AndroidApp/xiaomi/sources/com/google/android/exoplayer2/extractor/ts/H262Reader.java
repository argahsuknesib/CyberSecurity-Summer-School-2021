package com.google.android.exoplayer2.extractor.ts;

import android.support.v4.app.NotificationCompat;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Collections;

public final class H262Reader implements ElementaryStreamReader {
    private static final double[] FRAME_RATE_VALUES = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private final CsdBuffer csdBuffer;
    private String formatId;
    private long frameDurationUs;
    private boolean hasOutputFormat;
    private TrackOutput output;
    private long pesTimeUs;
    private final boolean[] prefixFlags;
    private boolean sampleHasPicture;
    private boolean sampleIsKeyframe;
    private long samplePosition;
    private long sampleTimeUs;
    private boolean startedFirstSample;
    private long totalBytesWritten;
    private final NalUnitTargetBuffer userData;
    private final ParsableByteArray userDataParsable;
    private final UserDataReader userDataReader;

    public final void packetFinished() {
    }

    public H262Reader() {
        this(null);
    }

    H262Reader(UserDataReader userDataReader2) {
        this.userDataReader = userDataReader2;
        this.prefixFlags = new boolean[4];
        this.csdBuffer = new CsdBuffer(NotificationCompat.FLAG_HIGH_PRIORITY);
        if (userDataReader2 != null) {
            this.userData = new NalUnitTargetBuffer(178, NotificationCompat.FLAG_HIGH_PRIORITY);
            this.userDataParsable = new ParsableByteArray();
            return;
        }
        this.userData = null;
        this.userDataParsable = null;
    }

    public final void seek() {
        NalUnitUtil.clearPrefixFlags(this.prefixFlags);
        this.csdBuffer.reset();
        NalUnitTargetBuffer nalUnitTargetBuffer = this.userData;
        if (nalUnitTargetBuffer != null) {
            nalUnitTargetBuffer.reset();
        }
        this.totalBytesWritten = 0;
        this.startedFirstSample = false;
    }

    public final void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
        UserDataReader userDataReader2 = this.userDataReader;
        if (userDataReader2 != null) {
            userDataReader2.createTracks(extractorOutput, trackIdGenerator);
        }
    }

    public final void packetStarted(long j, int i) {
        this.pesTimeUs = j;
    }

    public final void consume(ParsableByteArray parsableByteArray) {
        int i;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        Assertions.checkStateNotNull(this.output);
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        byte[] bArr = parsableByteArray2.data;
        this.totalBytesWritten += (long) parsableByteArray.bytesLeft();
        this.output.sampleData(parsableByteArray2, parsableByteArray.bytesLeft());
        while (true) {
            int findNalUnit = NalUnitUtil.findNalUnit(bArr, position, limit, this.prefixFlags);
            if (findNalUnit == limit) {
                break;
            }
            int i2 = findNalUnit + 3;
            byte b = parsableByteArray2.data[i2] & 255;
            int i3 = findNalUnit - position;
            boolean z = false;
            if (!this.hasOutputFormat) {
                if (i3 > 0) {
                    this.csdBuffer.onData(bArr, position, findNalUnit);
                }
                if (this.csdBuffer.onStartCode(b, i3 < 0 ? -i3 : 0)) {
                    Pair<Format, Long> parseCsdBuffer = parseCsdBuffer(this.csdBuffer, this.formatId);
                    this.output.format((Format) parseCsdBuffer.first);
                    this.frameDurationUs = ((Long) parseCsdBuffer.second).longValue();
                    this.hasOutputFormat = true;
                }
            }
            NalUnitTargetBuffer nalUnitTargetBuffer = this.userData;
            if (nalUnitTargetBuffer != null) {
                if (i3 > 0) {
                    nalUnitTargetBuffer.appendToNalUnit(bArr, position, findNalUnit);
                    i = 0;
                } else {
                    i = -i3;
                }
                if (this.userData.endNalUnit(i)) {
                    ((ParsableByteArray) Util.castNonNull(this.userDataParsable)).reset(this.userData.nalData, NalUnitUtil.unescapeStream(this.userData.nalData, this.userData.nalLength));
                    ((UserDataReader) Util.castNonNull(this.userDataReader)).consume(this.sampleTimeUs, this.userDataParsable);
                }
                if (b == 178 && parsableByteArray2.data[findNalUnit + 2] == 1) {
                    this.userData.startNalUnit(b);
                }
            }
            if (b == 0 || b == 179) {
                int i4 = limit - findNalUnit;
                if (this.startedFirstSample && this.sampleHasPicture && this.hasOutputFormat) {
                    this.output.sampleMetadata(this.sampleTimeUs, this.sampleIsKeyframe ? 1 : 0, ((int) (this.totalBytesWritten - this.samplePosition)) - i4, i4, null);
                }
                if (!this.startedFirstSample || this.sampleHasPicture) {
                    this.samplePosition = this.totalBytesWritten - ((long) i4);
                    long j = this.pesTimeUs;
                    if (j == -9223372036854775807L) {
                        j = this.startedFirstSample ? this.sampleTimeUs + this.frameDurationUs : 0;
                    }
                    this.sampleTimeUs = j;
                    this.sampleIsKeyframe = false;
                    this.pesTimeUs = -9223372036854775807L;
                    this.startedFirstSample = true;
                }
                if (b == 0) {
                    z = true;
                }
                this.sampleHasPicture = z;
            } else if (b == 184) {
                this.sampleIsKeyframe = true;
            }
            position = i2;
        }
        if (!this.hasOutputFormat) {
            this.csdBuffer.onData(bArr, position, limit);
        }
        NalUnitTargetBuffer nalUnitTargetBuffer2 = this.userData;
        if (nalUnitTargetBuffer2 != null) {
            nalUnitTargetBuffer2.appendToNalUnit(bArr, position, limit);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0075  */
    private static Pair<Format, Long> parseCsdBuffer(CsdBuffer csdBuffer2, String str) {
        float f;
        int i;
        int i2;
        float f2;
        byte[] copyOf = Arrays.copyOf(csdBuffer2.data, csdBuffer2.length);
        byte b = copyOf[5] & 255;
        int i3 = ((copyOf[4] & 255) << 4) | (b >> 4);
        byte b2 = ((b & 15) << 8) | (copyOf[6] & 255);
        int i4 = (copyOf[7] & 240) >> 4;
        if (i4 == 2) {
            f2 = (float) (b2 * 4);
            i2 = i3 * 3;
        } else if (i4 == 3) {
            f2 = (float) (b2 * 16);
            i2 = i3 * 9;
        } else if (i4 != 4) {
            f = 1.0f;
            Format build = new Format.Builder().setId(str).setSampleMimeType("video/mpeg2").setWidth(i3).setHeight(b2).setPixelWidthHeightRatio(f).setInitializationData(Collections.singletonList(copyOf)).build();
            long j = 0;
            i = (copyOf[7] & 15) - 1;
            if (i >= 0) {
                double[] dArr = FRAME_RATE_VALUES;
                if (i < dArr.length) {
                    double d = dArr[i];
                    int i5 = csdBuffer2.sequenceExtensionPosition + 9;
                    int i6 = (copyOf[i5] & 96) >> 5;
                    byte b3 = copyOf[i5] & 31;
                    if (i6 != b3) {
                        double d2 = (double) i6;
                        Double.isNaN(d2);
                        double d3 = (double) (b3 + 1);
                        Double.isNaN(d3);
                        d *= (d2 + 1.0d) / d3;
                    }
                    j = (long) (1000000.0d / d);
                }
            }
            return Pair.create(build, Long.valueOf(j));
        } else {
            f2 = (float) (b2 * 121);
            i2 = i3 * 100;
        }
        f = f2 / ((float) i2);
        Format build2 = new Format.Builder().setId(str).setSampleMimeType("video/mpeg2").setWidth(i3).setHeight(b2).setPixelWidthHeightRatio(f).setInitializationData(Collections.singletonList(copyOf)).build();
        long j2 = 0;
        i = (copyOf[7] & 15) - 1;
        if (i >= 0) {
        }
        return Pair.create(build2, Long.valueOf(j2));
    }

    static final class CsdBuffer {
        private static final byte[] START_CODE = {0, 0, 1};
        public byte[] data;
        private boolean isFilling;
        public int length;
        public int sequenceExtensionPosition;

        public CsdBuffer(int i) {
            this.data = new byte[i];
        }

        public final void reset() {
            this.isFilling = false;
            this.length = 0;
            this.sequenceExtensionPosition = 0;
        }

        public final boolean onStartCode(int i, int i2) {
            if (this.isFilling) {
                this.length -= i2;
                if (this.sequenceExtensionPosition == 0 && i == 181) {
                    this.sequenceExtensionPosition = this.length;
                } else {
                    this.isFilling = false;
                    return true;
                }
            } else if (i == 179) {
                this.isFilling = true;
            }
            byte[] bArr = START_CODE;
            onData(bArr, 0, bArr.length);
            return false;
        }

        public final void onData(byte[] bArr, int i, int i2) {
            if (this.isFilling) {
                int i3 = i2 - i;
                byte[] bArr2 = this.data;
                int length2 = bArr2.length;
                int i4 = this.length;
                if (length2 < i4 + i3) {
                    this.data = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.data, this.length, i3);
                this.length += i3;
            }
        }
    }
}
