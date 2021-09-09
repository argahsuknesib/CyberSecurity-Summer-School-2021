package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

final class TrackFragment {
    public long atomPosition;
    public long auxiliaryDataPosition;
    public long dataPosition;
    public boolean definesEncryptionData;
    public DefaultSampleValues header;
    public long nextFragmentDecodeTime;
    public int[] sampleCompositionTimeOffsetTable = new int[0];
    public int sampleCount;
    public long[] sampleDecodingTimeTable = new long[0];
    public final ParsableByteArray sampleEncryptionData = new ParsableByteArray();
    public boolean sampleEncryptionDataNeedsFill;
    public boolean[] sampleHasSubsampleEncryptionTable = new boolean[0];
    public boolean[] sampleIsSyncFrameTable = new boolean[0];
    public int[] sampleSizeTable = new int[0];
    public TrackEncryptionBox trackEncryptionBox;
    public int trunCount;
    public long[] trunDataPosition = new long[0];
    public int[] trunLength = new int[0];

    public final void reset() {
        this.trunCount = 0;
        this.nextFragmentDecodeTime = 0;
        this.definesEncryptionData = false;
        this.sampleEncryptionDataNeedsFill = false;
        this.trackEncryptionBox = null;
    }

    public final void initTables(int i, int i2) {
        this.trunCount = i;
        this.sampleCount = i2;
        if (this.trunLength.length < i) {
            this.trunDataPosition = new long[i];
            this.trunLength = new int[i];
        }
        if (this.sampleSizeTable.length < i2) {
            int i3 = (i2 * 125) / 100;
            this.sampleSizeTable = new int[i3];
            this.sampleCompositionTimeOffsetTable = new int[i3];
            this.sampleDecodingTimeTable = new long[i3];
            this.sampleIsSyncFrameTable = new boolean[i3];
            this.sampleHasSubsampleEncryptionTable = new boolean[i3];
        }
    }

    public final void initEncryptionData(int i) {
        this.sampleEncryptionData.reset(i);
        this.definesEncryptionData = true;
        this.sampleEncryptionDataNeedsFill = true;
    }

    public final void fillEncryptionData(ExtractorInput extractorInput) throws IOException {
        extractorInput.readFully(this.sampleEncryptionData.data, 0, this.sampleEncryptionData.limit());
        this.sampleEncryptionData.setPosition(0);
        this.sampleEncryptionDataNeedsFill = false;
    }

    public final void fillEncryptionData(ParsableByteArray parsableByteArray) {
        parsableByteArray.readBytes(this.sampleEncryptionData.data, 0, this.sampleEncryptionData.limit());
        this.sampleEncryptionData.setPosition(0);
        this.sampleEncryptionDataNeedsFill = false;
    }

    public final long getSamplePresentationTime(int i) {
        return this.sampleDecodingTimeTable[i] + ((long) this.sampleCompositionTimeOffsetTable[i]);
    }

    public final boolean sampleHasSubsampleEncryptionTable(int i) {
        return this.definesEncryptionData && this.sampleHasSubsampleEncryptionTable[i];
    }
}
