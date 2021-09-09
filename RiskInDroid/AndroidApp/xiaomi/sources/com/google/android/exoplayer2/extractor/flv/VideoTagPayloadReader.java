package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.video.AvcConfig;

final class VideoTagPayloadReader extends TagPayloadReader {
    private int frameType;
    private boolean hasOutputFormat;
    private boolean hasOutputKeyframe;
    private final ParsableByteArray nalLength = new ParsableByteArray(4);
    private final ParsableByteArray nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
    private int nalUnitLengthFieldLength;

    public VideoTagPayloadReader(TrackOutput trackOutput) {
        super(trackOutput);
    }

    public final void seek() {
        this.hasOutputKeyframe = false;
    }

    /* access modifiers changed from: protected */
    public final boolean parseHeader(ParsableByteArray parsableByteArray) throws TagPayloadReader.UnsupportedFormatException {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i = (readUnsignedByte >> 4) & 15;
        int i2 = readUnsignedByte & 15;
        if (i2 == 7) {
            this.frameType = i;
            return i != 5;
        }
        throw new TagPayloadReader.UnsupportedFormatException("Video format not supported: ".concat(String.valueOf(i2)));
    }

    /* access modifiers changed from: protected */
    public final boolean parsePayload(ParsableByteArray parsableByteArray, long j) throws ParserException {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        long readInt24 = j + (((long) parsableByteArray.readInt24()) * 1000);
        if (readUnsignedByte == 0 && !this.hasOutputFormat) {
            ParsableByteArray parsableByteArray2 = new ParsableByteArray(new byte[parsableByteArray.bytesLeft()]);
            parsableByteArray.readBytes(parsableByteArray2.data, 0, parsableByteArray.bytesLeft());
            AvcConfig parse = AvcConfig.parse(parsableByteArray2);
            this.nalUnitLengthFieldLength = parse.nalUnitLengthFieldLength;
            this.output.format(new Format.Builder().setSampleMimeType("video/avc").setWidth(parse.width).setHeight(parse.height).setPixelWidthHeightRatio(parse.pixelWidthAspectRatio).setInitializationData(parse.initializationData).build());
            this.hasOutputFormat = true;
            return false;
        } else if (readUnsignedByte != 1 || !this.hasOutputFormat) {
            return false;
        } else {
            int i = this.frameType == 1 ? 1 : 0;
            if (!this.hasOutputKeyframe && i == 0) {
                return false;
            }
            byte[] bArr = this.nalLength.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i2 = 4 - this.nalUnitLengthFieldLength;
            int i3 = 0;
            while (parsableByteArray.bytesLeft() > 0) {
                parsableByteArray.readBytes(this.nalLength.data, i2, this.nalUnitLengthFieldLength);
                this.nalLength.setPosition(0);
                int readUnsignedIntToInt = this.nalLength.readUnsignedIntToInt();
                this.nalStartCode.setPosition(0);
                this.output.sampleData(this.nalStartCode, 4);
                this.output.sampleData(parsableByteArray, readUnsignedIntToInt);
                i3 = i3 + 4 + readUnsignedIntToInt;
            }
            this.output.sampleMetadata(readInt24, i, i3, 0, null);
            this.hasOutputKeyframe = true;
            return true;
        }
    }
}
