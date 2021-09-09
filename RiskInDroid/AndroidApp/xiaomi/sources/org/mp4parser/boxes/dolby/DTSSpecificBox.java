package org.mp4parser.boxes.dolby;

import _m_j.jhf;
import _m_j.jhm;
import _m_j.jho;
import _m_j.jkn;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import android.support.v4.app.NotificationCompat;
import java.nio.ByteBuffer;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.BitReaderBuffer;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.BitWriterBuffer;

public class DTSSpecificBox extends jkn {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_10 = null;
    private static final jhf.O000000o ajc$tjp_11 = null;
    private static final jhf.O000000o ajc$tjp_12 = null;
    private static final jhf.O000000o ajc$tjp_13 = null;
    private static final jhf.O000000o ajc$tjp_14 = null;
    private static final jhf.O000000o ajc$tjp_15 = null;
    private static final jhf.O000000o ajc$tjp_16 = null;
    private static final jhf.O000000o ajc$tjp_17 = null;
    private static final jhf.O000000o ajc$tjp_18 = null;
    private static final jhf.O000000o ajc$tjp_19 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_20 = null;
    private static final jhf.O000000o ajc$tjp_21 = null;
    private static final jhf.O000000o ajc$tjp_22 = null;
    private static final jhf.O000000o ajc$tjp_23 = null;
    private static final jhf.O000000o ajc$tjp_24 = null;
    private static final jhf.O000000o ajc$tjp_25 = null;
    private static final jhf.O000000o ajc$tjp_26 = null;
    private static final jhf.O000000o ajc$tjp_27 = null;
    private static final jhf.O000000o ajc$tjp_28 = null;
    private static final jhf.O000000o ajc$tjp_29 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_30 = null;
    private static final jhf.O000000o ajc$tjp_31 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private static final jhf.O000000o ajc$tjp_7 = null;
    private static final jhf.O000000o ajc$tjp_8 = null;
    private static final jhf.O000000o ajc$tjp_9 = null;
    long DTSSamplingFrequency;
    int LBRDurationMod;
    long avgBitRate;
    int channelLayout;
    int coreLFEPresent;
    int coreLayout;
    int coreSize;
    int frameDuration;
    long maxBitRate;
    int multiAssetFlag;
    int pcmSampleDepth;
    int representationType;
    int reserved;
    int reservedBoxPresent;
    int stereoDownmix;
    int streamConstruction;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("DTSSpecificBox.java", DTSSpecificBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getAvgBitRate", "org.mp4parser.boxes.dolby.DTSSpecificBox", "", "", "", "long"), 89);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setAvgBitRate", "org.mp4parser.boxes.dolby.DTSSpecificBox", "long", "avgBitRate", "", "void"), 93);
        ajc$tjp_10 = jho.O000000o("method-execution", jho.O000000o("1", "getStreamConstruction", "org.mp4parser.boxes.dolby.DTSSpecificBox", "", "", "", "int"), 129);
        ajc$tjp_11 = jho.O000000o("method-execution", jho.O000000o("1", "setStreamConstruction", "org.mp4parser.boxes.dolby.DTSSpecificBox", "int", "streamConstruction", "", "void"), 133);
        ajc$tjp_12 = jho.O000000o("method-execution", jho.O000000o("1", "getCoreLFEPresent", "org.mp4parser.boxes.dolby.DTSSpecificBox", "", "", "", "int"), 137);
        ajc$tjp_13 = jho.O000000o("method-execution", jho.O000000o("1", "setCoreLFEPresent", "org.mp4parser.boxes.dolby.DTSSpecificBox", "int", "coreLFEPresent", "", "void"), 141);
        ajc$tjp_14 = jho.O000000o("method-execution", jho.O000000o("1", "getCoreLayout", "org.mp4parser.boxes.dolby.DTSSpecificBox", "", "", "", "int"), 145);
        ajc$tjp_15 = jho.O000000o("method-execution", jho.O000000o("1", "setCoreLayout", "org.mp4parser.boxes.dolby.DTSSpecificBox", "int", "coreLayout", "", "void"), 149);
        ajc$tjp_16 = jho.O000000o("method-execution", jho.O000000o("1", "getCoreSize", "org.mp4parser.boxes.dolby.DTSSpecificBox", "", "", "", "int"), 153);
        ajc$tjp_17 = jho.O000000o("method-execution", jho.O000000o("1", "setCoreSize", "org.mp4parser.boxes.dolby.DTSSpecificBox", "int", "coreSize", "", "void"), 157);
        ajc$tjp_18 = jho.O000000o("method-execution", jho.O000000o("1", "getStereoDownmix", "org.mp4parser.boxes.dolby.DTSSpecificBox", "", "", "", "int"), 161);
        ajc$tjp_19 = jho.O000000o("method-execution", jho.O000000o("1", "setStereoDownmix", "org.mp4parser.boxes.dolby.DTSSpecificBox", "int", "stereoDownmix", "", "void"), 165);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getDTSSamplingFrequency", "org.mp4parser.boxes.dolby.DTSSpecificBox", "", "", "", "long"), 97);
        ajc$tjp_20 = jho.O000000o("method-execution", jho.O000000o("1", "getRepresentationType", "org.mp4parser.boxes.dolby.DTSSpecificBox", "", "", "", "int"), 169);
        ajc$tjp_21 = jho.O000000o("method-execution", jho.O000000o("1", "setRepresentationType", "org.mp4parser.boxes.dolby.DTSSpecificBox", "int", "representationType", "", "void"), 173);
        ajc$tjp_22 = jho.O000000o("method-execution", jho.O000000o("1", "getChannelLayout", "org.mp4parser.boxes.dolby.DTSSpecificBox", "", "", "", "int"), 177);
        ajc$tjp_23 = jho.O000000o("method-execution", jho.O000000o("1", "setChannelLayout", "org.mp4parser.boxes.dolby.DTSSpecificBox", "int", "channelLayout", "", "void"), 181);
        ajc$tjp_24 = jho.O000000o("method-execution", jho.O000000o("1", "getMultiAssetFlag", "org.mp4parser.boxes.dolby.DTSSpecificBox", "", "", "", "int"), 185);
        ajc$tjp_25 = jho.O000000o("method-execution", jho.O000000o("1", "setMultiAssetFlag", "org.mp4parser.boxes.dolby.DTSSpecificBox", "int", "multiAssetFlag", "", "void"), 189);
        ajc$tjp_26 = jho.O000000o("method-execution", jho.O000000o("1", "getLBRDurationMod", "org.mp4parser.boxes.dolby.DTSSpecificBox", "", "", "", "int"), 193);
        ajc$tjp_27 = jho.O000000o("method-execution", jho.O000000o("1", "setLBRDurationMod", "org.mp4parser.boxes.dolby.DTSSpecificBox", "int", "LBRDurationMod", "", "void"), 197);
        ajc$tjp_28 = jho.O000000o("method-execution", jho.O000000o("1", "getReserved", "org.mp4parser.boxes.dolby.DTSSpecificBox", "", "", "", "int"), 201);
        ajc$tjp_29 = jho.O000000o("method-execution", jho.O000000o("1", "setReserved", "org.mp4parser.boxes.dolby.DTSSpecificBox", "int", "reserved", "", "void"), 205);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setDTSSamplingFrequency", "org.mp4parser.boxes.dolby.DTSSpecificBox", "long", "DTSSamplingFrequency", "", "void"), 101);
        ajc$tjp_30 = jho.O000000o("method-execution", jho.O000000o("1", "getReservedBoxPresent", "org.mp4parser.boxes.dolby.DTSSpecificBox", "", "", "", "int"), 209);
        ajc$tjp_31 = jho.O000000o("method-execution", jho.O000000o("1", "setReservedBoxPresent", "org.mp4parser.boxes.dolby.DTSSpecificBox", "int", "reservedBoxPresent", "", "void"), 213);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getMaxBitRate", "org.mp4parser.boxes.dolby.DTSSpecificBox", "", "", "", "long"), 105);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setMaxBitRate", "org.mp4parser.boxes.dolby.DTSSpecificBox", "long", "maxBitRate", "", "void"), 109);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "getPcmSampleDepth", "org.mp4parser.boxes.dolby.DTSSpecificBox", "", "", "", "int"), 113);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "setPcmSampleDepth", "org.mp4parser.boxes.dolby.DTSSpecificBox", "int", "pcmSampleDepth", "", "void"), 117);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "getFrameDuration", "org.mp4parser.boxes.dolby.DTSSpecificBox", "", "", "", "int"), 121);
        ajc$tjp_9 = jho.O000000o("method-execution", jho.O000000o("1", "setFrameDuration", "org.mp4parser.boxes.dolby.DTSSpecificBox", "int", "frameDuration", "", "void"), 125);
    }

    public long getContentSize() {
        return 20;
    }

    public DTSSpecificBox() {
        super("ddts");
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        this.DTSSamplingFrequency = jky.O000000o(byteBuffer);
        this.maxBitRate = jky.O000000o(byteBuffer);
        this.avgBitRate = jky.O000000o(byteBuffer);
        this.pcmSampleDepth = jky.O000000o(byteBuffer.get());
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBuffer);
        this.frameDuration = bitReaderBuffer.readBits(2);
        this.streamConstruction = bitReaderBuffer.readBits(5);
        this.coreLFEPresent = bitReaderBuffer.readBits(1);
        this.coreLayout = bitReaderBuffer.readBits(6);
        this.coreSize = bitReaderBuffer.readBits(14);
        this.stereoDownmix = bitReaderBuffer.readBits(1);
        this.representationType = bitReaderBuffer.readBits(3);
        this.channelLayout = bitReaderBuffer.readBits(16);
        this.multiAssetFlag = bitReaderBuffer.readBits(1);
        this.LBRDurationMod = bitReaderBuffer.readBits(1);
        this.reservedBoxPresent = bitReaderBuffer.readBits(1);
        this.reserved = bitReaderBuffer.readBits(5);
    }

    public void getContent(ByteBuffer byteBuffer) {
        jla.O00000Oo(byteBuffer, this.DTSSamplingFrequency);
        jla.O00000Oo(byteBuffer, this.maxBitRate);
        jla.O00000Oo(byteBuffer, this.avgBitRate);
        jla.O00000o(byteBuffer, this.pcmSampleDepth);
        BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(byteBuffer);
        bitWriterBuffer.writeBits(this.frameDuration, 2);
        bitWriterBuffer.writeBits(this.streamConstruction, 5);
        bitWriterBuffer.writeBits(this.coreLFEPresent, 1);
        bitWriterBuffer.writeBits(this.coreLayout, 6);
        bitWriterBuffer.writeBits(this.coreSize, 14);
        bitWriterBuffer.writeBits(this.stereoDownmix, 1);
        bitWriterBuffer.writeBits(this.representationType, 3);
        bitWriterBuffer.writeBits(this.channelLayout, 16);
        bitWriterBuffer.writeBits(this.multiAssetFlag, 1);
        bitWriterBuffer.writeBits(this.LBRDurationMod, 1);
        bitWriterBuffer.writeBits(this.reservedBoxPresent, 1);
        bitWriterBuffer.writeBits(this.reserved, 5);
    }

    public long getAvgBitRate() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.avgBitRate;
    }

    public void setAvgBitRate(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.avgBitRate = j;
    }

    public long getDTSSamplingFrequency() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.DTSSamplingFrequency;
    }

    public void setDTSSamplingFrequency(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.DTSSamplingFrequency = j;
    }

    public long getMaxBitRate() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.maxBitRate;
    }

    public void setMaxBitRate(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.maxBitRate = j;
    }

    public int getPcmSampleDepth() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.pcmSampleDepth;
    }

    public int getFrameDuration() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.frameDuration;
    }

    public int getStreamConstruction() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_10, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.streamConstruction;
    }

    public int getCoreLFEPresent() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_12, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.coreLFEPresent;
    }

    public int getCoreLayout() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_14, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.coreLayout;
    }

    public int getCoreSize() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_16, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.coreSize;
    }

    public int getStereoDownmix() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_18, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.stereoDownmix;
    }

    public int getRepresentationType() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_20, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.representationType;
    }

    public int getChannelLayout() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_22, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.channelLayout;
    }

    public int getMultiAssetFlag() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_24, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.multiAssetFlag;
    }

    public int getLBRDurationMod() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_26, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.LBRDurationMod;
    }

    public int getReserved() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_28, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.reserved;
    }

    public int getReservedBoxPresent() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_30, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.reservedBoxPresent;
    }

    public int[] getDashAudioChannelConfiguration() {
        int i;
        int i2;
        int channelLayout2 = getChannelLayout();
        if ((channelLayout2 & 1) == 1) {
            i2 = 1;
            i = 4;
        } else {
            i2 = 0;
            i = 0;
        }
        if ((channelLayout2 & 2) == 2) {
            i2 += 2;
            i = i | 1 | 2;
        }
        if ((channelLayout2 & 4) == 4) {
            i2 += 2;
            i = i | 16 | 32;
        }
        if ((channelLayout2 & 8) == 8) {
            i2++;
            i |= 8;
        }
        if ((channelLayout2 & 16) == 16) {
            i2++;
            i |= 256;
        }
        if ((channelLayout2 & 32) == 32) {
            i2 += 2;
            i = i | 4096 | 16384;
        }
        if ((channelLayout2 & 64) == 64) {
            i2 += 2;
            i = i | 16 | 32;
        }
        if ((channelLayout2 & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
            i2++;
            i |= 8192;
        }
        if ((channelLayout2 & 256) == 256) {
            i2++;
            i |= 2048;
        }
        if ((channelLayout2 & 512) == 512) {
            i2 += 2;
            i = i | 64 | NotificationCompat.FLAG_HIGH_PRIORITY;
        }
        if ((channelLayout2 & 1024) == 1024) {
            i2 += 2;
            i = i | 512 | 1024;
        }
        if ((channelLayout2 & 2048) == 2048) {
            i2 += 2;
            i = i | 16 | 32;
        }
        if ((channelLayout2 & 4096) == 4096) {
            i2++;
            i |= 8;
        }
        if ((channelLayout2 & 8192) == 8192) {
            i2 += 2;
            i = i | 16 | 32;
        }
        if ((channelLayout2 & 16384) == 16384) {
            i2++;
            i |= 65536;
        }
        if ((32768 & channelLayout2) == 32768) {
            i2 += 2;
            i = 131072 | 32768 | i;
        }
        if ((65536 & channelLayout2) == 65536) {
            i2++;
        }
        if ((channelLayout2 & 131072) == 131072) {
            i2 += 2;
        }
        return new int[]{i2, i};
    }

    public void setPcmSampleDepth(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.pcmSampleDepth = i;
    }

    public void setFrameDuration(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_9, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.frameDuration = i;
    }

    public void setStreamConstruction(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_11, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.streamConstruction = i;
    }

    public void setCoreLFEPresent(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_13, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.coreLFEPresent = i;
    }

    public void setCoreLayout(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_15, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.coreLayout = i;
    }

    public void setCoreSize(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_17, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.coreSize = i;
    }

    public void setStereoDownmix(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_19, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.stereoDownmix = i;
    }

    public void setRepresentationType(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_21, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.representationType = i;
    }

    public void setChannelLayout(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_23, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.channelLayout = i;
    }

    public void setMultiAssetFlag(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_25, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.multiAssetFlag = i;
    }

    public void setLBRDurationMod(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_27, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.LBRDurationMod = i;
    }

    public void setReserved(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_29, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.reserved = i;
    }

    public void setReservedBoxPresent(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_31, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.reservedBoxPresent = i;
    }
}
