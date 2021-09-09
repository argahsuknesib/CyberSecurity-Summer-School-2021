package org.mp4parser.boxes.iso14496.part15;

import _m_j.jkx;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.BitReaderBuffer;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.BitWriterBuffer;

public class AvcDecoderConfigurationRecord {
    public int avcLevelIndication;
    public int avcProfileIndication;
    public int bitDepthChromaMinus8;
    public int bitDepthChromaMinus8PaddingBits;
    public int bitDepthLumaMinus8;
    public int bitDepthLumaMinus8PaddingBits;
    public int chromaFormat;
    public int chromaFormatPaddingBits;
    public int configurationVersion;
    public boolean hasExts;
    public int lengthSizeMinusOne;
    public int lengthSizeMinusOnePaddingBits;
    public int numberOfSequenceParameterSetsPaddingBits;
    public List<ByteBuffer> pictureParameterSets;
    public int profileCompatibility;
    public List<ByteBuffer> sequenceParameterSetExts;
    public List<ByteBuffer> sequenceParameterSets;

    public AvcDecoderConfigurationRecord() {
        this.sequenceParameterSets = new ArrayList();
        this.pictureParameterSets = new ArrayList();
        this.hasExts = true;
        this.chromaFormat = 1;
        this.bitDepthLumaMinus8 = 0;
        this.bitDepthChromaMinus8 = 0;
        this.sequenceParameterSetExts = new ArrayList();
        this.lengthSizeMinusOnePaddingBits = 63;
        this.numberOfSequenceParameterSetsPaddingBits = 7;
        this.chromaFormatPaddingBits = 31;
        this.bitDepthLumaMinus8PaddingBits = 31;
        this.bitDepthChromaMinus8PaddingBits = 31;
    }

    public AvcDecoderConfigurationRecord(ByteBuffer byteBuffer) {
        int i;
        this.sequenceParameterSets = new ArrayList();
        this.pictureParameterSets = new ArrayList();
        this.hasExts = true;
        this.chromaFormat = 1;
        this.bitDepthLumaMinus8 = 0;
        this.bitDepthChromaMinus8 = 0;
        this.sequenceParameterSetExts = new ArrayList();
        this.lengthSizeMinusOnePaddingBits = 63;
        this.numberOfSequenceParameterSetsPaddingBits = 7;
        this.chromaFormatPaddingBits = 31;
        this.bitDepthLumaMinus8PaddingBits = 31;
        this.bitDepthChromaMinus8PaddingBits = 31;
        this.configurationVersion = jky.O000000o(byteBuffer.get());
        this.avcProfileIndication = jky.O000000o(byteBuffer.get());
        this.profileCompatibility = jky.O000000o(byteBuffer.get());
        this.avcLevelIndication = jky.O000000o(byteBuffer.get());
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBuffer);
        this.lengthSizeMinusOnePaddingBits = bitReaderBuffer.readBits(6);
        this.lengthSizeMinusOne = bitReaderBuffer.readBits(2);
        this.numberOfSequenceParameterSetsPaddingBits = bitReaderBuffer.readBits(3);
        int readBits = bitReaderBuffer.readBits(5);
        for (int i2 = 0; i2 < readBits; i2++) {
            byte[] bArr = new byte[jky.O00000o0(byteBuffer)];
            byteBuffer.get(bArr);
            this.sequenceParameterSets.add(ByteBuffer.wrap(bArr));
        }
        long O000000o2 = (long) jky.O000000o(byteBuffer.get());
        for (int i3 = 0; ((long) i3) < O000000o2; i3++) {
            byte[] bArr2 = new byte[jky.O00000o0(byteBuffer)];
            byteBuffer.get(bArr2);
            this.pictureParameterSets.add(ByteBuffer.wrap(bArr2));
        }
        if (byteBuffer.remaining() < 4) {
            this.hasExts = false;
        }
        if (!this.hasExts || !((i = this.avcProfileIndication) == 100 || i == 110 || i == 122 || i == 144)) {
            this.chromaFormat = -1;
            this.bitDepthLumaMinus8 = -1;
            this.bitDepthChromaMinus8 = -1;
            return;
        }
        BitReaderBuffer bitReaderBuffer2 = new BitReaderBuffer(byteBuffer);
        this.chromaFormatPaddingBits = bitReaderBuffer2.readBits(6);
        this.chromaFormat = bitReaderBuffer2.readBits(2);
        this.bitDepthLumaMinus8PaddingBits = bitReaderBuffer2.readBits(5);
        this.bitDepthLumaMinus8 = bitReaderBuffer2.readBits(3);
        this.bitDepthChromaMinus8PaddingBits = bitReaderBuffer2.readBits(5);
        this.bitDepthChromaMinus8 = bitReaderBuffer2.readBits(3);
        long O000000o3 = (long) jky.O000000o(byteBuffer.get());
        for (int i4 = 0; ((long) i4) < O000000o3; i4++) {
            byte[] bArr3 = new byte[jky.O00000o0(byteBuffer)];
            byteBuffer.get(bArr3);
            this.sequenceParameterSetExts.add(ByteBuffer.wrap(bArr3));
        }
    }

    public void getContent(ByteBuffer byteBuffer) {
        jla.O00000o(byteBuffer, this.configurationVersion);
        jla.O00000o(byteBuffer, this.avcProfileIndication);
        jla.O00000o(byteBuffer, this.profileCompatibility);
        jla.O00000o(byteBuffer, this.avcLevelIndication);
        BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(byteBuffer);
        bitWriterBuffer.writeBits(this.lengthSizeMinusOnePaddingBits, 6);
        bitWriterBuffer.writeBits(this.lengthSizeMinusOne, 2);
        bitWriterBuffer.writeBits(this.numberOfSequenceParameterSetsPaddingBits, 3);
        bitWriterBuffer.writeBits(this.pictureParameterSets.size(), 5);
        for (ByteBuffer next : this.sequenceParameterSets) {
            jla.O00000Oo(byteBuffer, next.limit());
            byteBuffer.put((ByteBuffer) next.rewind());
        }
        jla.O00000o(byteBuffer, this.pictureParameterSets.size());
        for (ByteBuffer next2 : this.pictureParameterSets) {
            jla.O00000Oo(byteBuffer, next2.limit());
            byteBuffer.put((ByteBuffer) next2.rewind());
        }
        if (this.hasExts) {
            int i = this.avcProfileIndication;
            if (i == 100 || i == 110 || i == 122 || i == 144) {
                BitWriterBuffer bitWriterBuffer2 = new BitWriterBuffer(byteBuffer);
                bitWriterBuffer2.writeBits(this.chromaFormatPaddingBits, 6);
                bitWriterBuffer2.writeBits(this.chromaFormat, 2);
                bitWriterBuffer2.writeBits(this.bitDepthLumaMinus8PaddingBits, 5);
                bitWriterBuffer2.writeBits(this.bitDepthLumaMinus8, 3);
                bitWriterBuffer2.writeBits(this.bitDepthChromaMinus8PaddingBits, 5);
                bitWriterBuffer2.writeBits(this.bitDepthChromaMinus8, 3);
                for (ByteBuffer next3 : this.sequenceParameterSetExts) {
                    jla.O00000Oo(byteBuffer, next3.limit());
                    byteBuffer.put((ByteBuffer) next3.reset());
                }
            }
        }
    }

    public long getContentSize() {
        long j;
        int i;
        long j2 = 6;
        for (ByteBuffer limit : this.sequenceParameterSets) {
            j2 = j2 + 2 + ((long) limit.limit());
        }
        long j3 = j2 + 1;
        for (ByteBuffer limit2 : this.pictureParameterSets) {
            j3 = j + 2 + ((long) limit2.limit());
        }
        if (this.hasExts && ((i = this.avcProfileIndication) == 100 || i == 110 || i == 122 || i == 144)) {
            j += 4;
            for (ByteBuffer limit3 : this.sequenceParameterSetExts) {
                j = j + 2 + ((long) limit3.limit());
            }
        }
        return j;
    }

    public List<String> getSequenceParameterSetsAsStrings() {
        ArrayList arrayList = new ArrayList(this.sequenceParameterSets.size());
        for (ByteBuffer O000000o2 : this.sequenceParameterSets) {
            arrayList.add(jkx.O000000o(O000000o2));
        }
        return arrayList;
    }

    public List<String> getSequenceParameterSetExtsAsStrings() {
        ArrayList arrayList = new ArrayList(this.sequenceParameterSetExts.size());
        for (ByteBuffer O000000o2 : this.sequenceParameterSetExts) {
            arrayList.add(jkx.O000000o(O000000o2));
        }
        return arrayList;
    }

    public List<String> getPictureParameterSetsAsStrings() {
        ArrayList arrayList = new ArrayList(this.pictureParameterSets.size());
        for (ByteBuffer O000000o2 : this.pictureParameterSets) {
            arrayList.add(jkx.O000000o(O000000o2));
        }
        return arrayList;
    }

    public String toString() {
        return "AvcDecoderConfigurationRecord{configurationVersion=" + this.configurationVersion + ", avcProfileIndication=" + this.avcProfileIndication + ", profileCompatibility=" + this.profileCompatibility + ", avcLevelIndication=" + this.avcLevelIndication + ", lengthSizeMinusOne=" + this.lengthSizeMinusOne + ", hasExts=" + this.hasExts + ", chromaFormat=" + this.chromaFormat + ", bitDepthLumaMinus8=" + this.bitDepthLumaMinus8 + ", bitDepthChromaMinus8=" + this.bitDepthChromaMinus8 + ", lengthSizeMinusOnePaddingBits=" + this.lengthSizeMinusOnePaddingBits + ", numberOfSequenceParameterSetsPaddingBits=" + this.numberOfSequenceParameterSetsPaddingBits + ", chromaFormatPaddingBits=" + this.chromaFormatPaddingBits + ", bitDepthLumaMinus8PaddingBits=" + this.bitDepthLumaMinus8PaddingBits + ", bitDepthChromaMinus8PaddingBits=" + this.bitDepthChromaMinus8PaddingBits + '}';
    }
}
