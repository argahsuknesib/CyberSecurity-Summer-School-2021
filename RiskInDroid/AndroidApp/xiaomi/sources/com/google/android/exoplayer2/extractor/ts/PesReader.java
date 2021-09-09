package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public final class PesReader implements TsPayloadReader {
    private int bytesRead;
    private boolean dataAlignmentIndicator;
    private boolean dtsFlag;
    private int extendedHeaderLength;
    private int payloadSize;
    private final ParsableBitArray pesScratch = new ParsableBitArray(new byte[10]);
    private boolean ptsFlag;
    private final ElementaryStreamReader reader;
    private boolean seenFirstDts;
    private int state = 0;
    private long timeUs;
    private TimestampAdjuster timestampAdjuster;

    public PesReader(ElementaryStreamReader elementaryStreamReader) {
        this.reader = elementaryStreamReader;
    }

    public final void init(TimestampAdjuster timestampAdjuster2, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.timestampAdjuster = timestampAdjuster2;
        this.reader.createTracks(extractorOutput, trackIdGenerator);
    }

    public final void seek() {
        this.state = 0;
        this.bytesRead = 0;
        this.seenFirstDts = false;
        this.reader.seek();
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e1 A[SYNTHETIC] */
    public final void consume(com.google.android.exoplayer2.util.ParsableByteArray r9, int r10) throws com.google.android.exoplayer2.ParserException {
        /*
            r8 = this;
            com.google.android.exoplayer2.util.TimestampAdjuster r0 = r8.timestampAdjuster
            com.google.android.exoplayer2.util.Assertions.checkStateNotNull(r0)
            r0 = r10 & 1
            r1 = -1
            r2 = 3
            r3 = 2
            r4 = 1
            if (r0 == 0) goto L_0x0049
            int r0 = r8.state
            if (r0 == 0) goto L_0x0046
            if (r0 == r4) goto L_0x0046
            java.lang.String r5 = "PesReader"
            if (r0 == r3) goto L_0x0041
            if (r0 != r2) goto L_0x003b
            int r0 = r8.payloadSize
            if (r0 == r1) goto L_0x0035
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r6 = "Unexpected start indicator: expected "
            r0.<init>(r6)
            int r6 = r8.payloadSize
            r0.append(r6)
            java.lang.String r6 = " more bytes"
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            com.google.android.exoplayer2.util.Log.w(r5, r0)
        L_0x0035:
            com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader r0 = r8.reader
            r0.packetFinished()
            goto L_0x0046
        L_0x003b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>()
            throw r9
        L_0x0041:
            java.lang.String r0 = "Unexpected start indicator reading extended header"
            com.google.android.exoplayer2.util.Log.w(r5, r0)
        L_0x0046:
            r0 = r10
            r10 = r8
            goto L_0x0087
        L_0x0049:
            r0 = r10
            r10 = r8
        L_0x004b:
            int r5 = r9.bytesLeft()
            if (r5 <= 0) goto L_0x00e1
            int r5 = r10.state
            if (r5 == 0) goto L_0x00d8
            r6 = 0
            if (r5 == r4) goto L_0x00c0
            if (r5 == r3) goto L_0x0091
            if (r5 != r2) goto L_0x008b
            int r5 = r9.bytesLeft()
            int r7 = r10.payloadSize
            if (r7 != r1) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            int r6 = r5 - r7
        L_0x0067:
            if (r6 <= 0) goto L_0x0072
            int r5 = r5 - r6
            int r6 = r9.getPosition()
            int r6 = r6 + r5
            r9.setLimit(r6)
        L_0x0072:
            com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader r6 = r10.reader
            r6.consume(r9)
            int r6 = r10.payloadSize
            if (r6 == r1) goto L_0x004b
            int r6 = r6 - r5
            r10.payloadSize = r6
            int r5 = r10.payloadSize
            if (r5 != 0) goto L_0x004b
            com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader r5 = r10.reader
            r5.packetFinished()
        L_0x0087:
            r10.setState(r4)
            goto L_0x004b
        L_0x008b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>()
            throw r9
        L_0x0091:
            r5 = 10
            int r7 = r10.extendedHeaderLength
            int r5 = java.lang.Math.min(r5, r7)
            com.google.android.exoplayer2.util.ParsableBitArray r7 = r10.pesScratch
            byte[] r7 = r7.data
            boolean r5 = r10.continueRead(r9, r7, r5)
            if (r5 == 0) goto L_0x004b
            r5 = 0
            int r7 = r10.extendedHeaderLength
            boolean r5 = r10.continueRead(r9, r5, r7)
            if (r5 == 0) goto L_0x004b
            r10.parseHeaderExtension()
            boolean r5 = r10.dataAlignmentIndicator
            if (r5 == 0) goto L_0x00b4
            r6 = 4
        L_0x00b4:
            r0 = r0 | r6
            com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader r5 = r10.reader
            long r6 = r10.timeUs
            r5.packetStarted(r6, r0)
            r10.setState(r2)
            goto L_0x004b
        L_0x00c0:
            com.google.android.exoplayer2.util.ParsableBitArray r5 = r10.pesScratch
            byte[] r5 = r5.data
            r7 = 9
            boolean r5 = r10.continueRead(r9, r5, r7)
            if (r5 == 0) goto L_0x004b
            boolean r5 = r10.parseHeader()
            if (r5 == 0) goto L_0x00d3
            r6 = 2
        L_0x00d3:
            r10.setState(r6)
            goto L_0x004b
        L_0x00d8:
            int r5 = r9.bytesLeft()
            r9.skipBytes(r5)
            goto L_0x004b
        L_0x00e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.PesReader.consume(com.google.android.exoplayer2.util.ParsableByteArray, int):void");
    }

    private void setState(int i) {
        this.state = i;
        this.bytesRead = 0;
    }

    private boolean continueRead(ParsableByteArray parsableByteArray, byte[] bArr, int i) {
        int min = Math.min(parsableByteArray.bytesLeft(), i - this.bytesRead);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            parsableByteArray.skipBytes(min);
        } else {
            parsableByteArray.readBytes(bArr, this.bytesRead, min);
        }
        this.bytesRead += min;
        if (this.bytesRead == i) {
            return true;
        }
        return false;
    }

    private boolean parseHeader() {
        this.pesScratch.setPosition(0);
        int readBits = this.pesScratch.readBits(24);
        if (readBits != 1) {
            Log.w("PesReader", "Unexpected start code prefix: ".concat(String.valueOf(readBits)));
            this.payloadSize = -1;
            return false;
        }
        this.pesScratch.skipBits(8);
        int readBits2 = this.pesScratch.readBits(16);
        this.pesScratch.skipBits(5);
        this.dataAlignmentIndicator = this.pesScratch.readBit();
        this.pesScratch.skipBits(2);
        this.ptsFlag = this.pesScratch.readBit();
        this.dtsFlag = this.pesScratch.readBit();
        this.pesScratch.skipBits(6);
        this.extendedHeaderLength = this.pesScratch.readBits(8);
        if (readBits2 == 0) {
            this.payloadSize = -1;
        } else {
            this.payloadSize = ((readBits2 + 6) - 9) - this.extendedHeaderLength;
        }
        return true;
    }

    private void parseHeaderExtension() {
        this.pesScratch.setPosition(0);
        this.timeUs = -9223372036854775807L;
        if (this.ptsFlag) {
            this.pesScratch.skipBits(4);
            this.pesScratch.skipBits(1);
            this.pesScratch.skipBits(1);
            long readBits = (((long) this.pesScratch.readBits(3)) << 30) | ((long) (this.pesScratch.readBits(15) << 15)) | ((long) this.pesScratch.readBits(15));
            this.pesScratch.skipBits(1);
            if (!this.seenFirstDts && this.dtsFlag) {
                this.pesScratch.skipBits(4);
                this.pesScratch.skipBits(1);
                this.pesScratch.skipBits(1);
                this.pesScratch.skipBits(1);
                this.timestampAdjuster.adjustTsTimestamp((((long) this.pesScratch.readBits(3)) << 30) | ((long) (this.pesScratch.readBits(15) << 15)) | ((long) this.pesScratch.readBits(15)));
                this.seenFirstDts = true;
            }
            this.timeUs = this.timestampAdjuster.adjustTsTimestamp(readBits);
        }
    }
}
