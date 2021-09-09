package org.mp4parser.boxes.iso14496.part15;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkn;
import _m_j.jku;
import android.support.v4.app.NotificationCompat;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class AvcConfigurationBox extends jkn {
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
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private static final jhf.O000000o ajc$tjp_7 = null;
    private static final jhf.O000000o ajc$tjp_8 = null;
    private static final jhf.O000000o ajc$tjp_9 = null;
    public AvcDecoderConfigurationRecord avcDecoderConfigurationRecord = new AvcDecoderConfigurationRecord();

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("AvcConfigurationBox.java", AvcConfigurationBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getConfigurationVersion", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 44);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setConfigurationVersion", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "int", "configurationVersion", "", "void"), 48);
        ajc$tjp_10 = jho.O000000o("method-execution", jho.O000000o("1", "getSequenceParameterSets", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 84);
        ajc$tjp_11 = jho.O000000o("method-execution", jho.O000000o("1", "setSequenceParameterSets", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "java.util.List", "sequenceParameterSets", "", "void"), 88);
        ajc$tjp_12 = jho.O000000o("method-execution", jho.O000000o("1", "getPictureParameterSets", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 92);
        ajc$tjp_13 = jho.O000000o("method-execution", jho.O000000o("1", "setPictureParameterSets", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "java.util.List", "pictureParameterSets", "", "void"), 96);
        ajc$tjp_14 = jho.O000000o("method-execution", jho.O000000o("1", "getChromaFormat", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 100);
        ajc$tjp_15 = jho.O000000o("method-execution", jho.O000000o("1", "setChromaFormat", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "int", "chromaFormat", "", "void"), 104);
        ajc$tjp_16 = jho.O000000o("method-execution", jho.O000000o("1", "getBitDepthLumaMinus8", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 108);
        ajc$tjp_17 = jho.O000000o("method-execution", jho.O000000o("1", "setBitDepthLumaMinus8", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "int", "bitDepthLumaMinus8", "", "void"), 112);
        ajc$tjp_18 = jho.O000000o("method-execution", jho.O000000o("1", "getBitDepthChromaMinus8", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 116);
        ajc$tjp_19 = jho.O000000o("method-execution", jho.O000000o("1", "setBitDepthChromaMinus8", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "int", "bitDepthChromaMinus8", "", "void"), 120);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getAvcProfileIndication", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 52);
        ajc$tjp_20 = jho.O000000o("method-execution", jho.O000000o("1", "getSequenceParameterSetExts", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 124);
        ajc$tjp_21 = jho.O000000o("method-execution", jho.O000000o("1", "setSequenceParameterSetExts", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "java.util.List", "sequenceParameterSetExts", "", "void"), (int) NotificationCompat.FLAG_HIGH_PRIORITY);
        ajc$tjp_22 = jho.O000000o("method-execution", jho.O000000o("1", "hasExts", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "boolean"), 132);
        ajc$tjp_23 = jho.O000000o("method-execution", jho.O000000o("1", "setHasExts", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "boolean", "hasExts", "", "void"), 136);
        ajc$tjp_24 = jho.O000000o("method-execution", jho.O000000o("1", "getContentSize", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "long"), 147);
        ajc$tjp_25 = jho.O000000o("method-execution", jho.O000000o("1", "getContent", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 153);
        ajc$tjp_26 = jho.O000000o("method-execution", jho.O000000o("1", "getavcDecoderConfigurationRecord", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "org.mp4parser.boxes.iso14496.part15.AvcDecoderConfigurationRecord"), 158);
        ajc$tjp_27 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "java.lang.String"), 163);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setAvcProfileIndication", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "int", "avcProfileIndication", "", "void"), 56);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getProfileCompatibility", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 60);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setProfileCompatibility", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "int", "profileCompatibility", "", "void"), 64);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "getAvcLevelIndication", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 68);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "setAvcLevelIndication", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "int", "avcLevelIndication", "", "void"), 72);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "getLengthSizeMinusOne", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 76);
        ajc$tjp_9 = jho.O000000o("method-execution", jho.O000000o("1", "setLengthSizeMinusOne", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "int", "lengthSizeMinusOne", "", "void"), 80);
    }

    public AvcConfigurationBox() {
        super("avcC");
    }

    public final int getConfigurationVersion() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.avcDecoderConfigurationRecord.configurationVersion;
    }

    public final int getAvcProfileIndication() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.avcDecoderConfigurationRecord.avcProfileIndication;
    }

    public final int getProfileCompatibility() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.avcDecoderConfigurationRecord.profileCompatibility;
    }

    public final int getAvcLevelIndication() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.avcDecoderConfigurationRecord.avcLevelIndication;
    }

    public final int getLengthSizeMinusOne() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.avcDecoderConfigurationRecord.lengthSizeMinusOne;
    }

    public final List<ByteBuffer> getSequenceParameterSets() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_10, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return Collections.unmodifiableList(this.avcDecoderConfigurationRecord.sequenceParameterSets);
    }

    public final void setSequenceParameterSets(List<ByteBuffer> list) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_11, this, this, list);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.avcDecoderConfigurationRecord.sequenceParameterSets = list;
    }

    public final List<ByteBuffer> getPictureParameterSets() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_12, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return Collections.unmodifiableList(this.avcDecoderConfigurationRecord.pictureParameterSets);
    }

    public final void setPictureParameterSets(List<ByteBuffer> list) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_13, this, this, list);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.avcDecoderConfigurationRecord.pictureParameterSets = list;
    }

    public final int getChromaFormat() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_14, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.avcDecoderConfigurationRecord.chromaFormat;
    }

    public final int getBitDepthLumaMinus8() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_16, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.avcDecoderConfigurationRecord.bitDepthLumaMinus8;
    }

    public final int getBitDepthChromaMinus8() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_18, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.avcDecoderConfigurationRecord.bitDepthChromaMinus8;
    }

    public final List<ByteBuffer> getSequenceParameterSetExts() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_20, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.avcDecoderConfigurationRecord.sequenceParameterSetExts;
    }

    public final void setSequenceParameterSetExts(List<ByteBuffer> list) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_21, this, this, list);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.avcDecoderConfigurationRecord.sequenceParameterSetExts = list;
    }

    public final boolean hasExts() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_22, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.avcDecoderConfigurationRecord.hasExts;
    }

    public final void _parseDetails(ByteBuffer byteBuffer) {
        this.avcDecoderConfigurationRecord = new AvcDecoderConfigurationRecord(byteBuffer);
    }

    public final long getContentSize() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_24, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.avcDecoderConfigurationRecord.getContentSize();
    }

    public final void getContent(ByteBuffer byteBuffer) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_25, this, this, byteBuffer);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.avcDecoderConfigurationRecord.getContent(byteBuffer);
    }

    public final AvcDecoderConfigurationRecord getavcDecoderConfigurationRecord() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_26, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.avcDecoderConfigurationRecord;
    }

    public final String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_27, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "AvcConfigurationBox{avcDecoderConfigurationRecord=" + this.avcDecoderConfigurationRecord + '}';
    }

    public final void setConfigurationVersion(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.avcDecoderConfigurationRecord.configurationVersion = i;
    }

    public final void setAvcProfileIndication(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.avcDecoderConfigurationRecord.avcProfileIndication = i;
    }

    public final void setProfileCompatibility(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.avcDecoderConfigurationRecord.profileCompatibility = i;
    }

    public final void setAvcLevelIndication(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.avcDecoderConfigurationRecord.avcLevelIndication = i;
    }

    public final void setLengthSizeMinusOne(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_9, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.avcDecoderConfigurationRecord.lengthSizeMinusOne = i;
    }

    public final void setChromaFormat(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_15, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.avcDecoderConfigurationRecord.chromaFormat = i;
    }

    public final void setBitDepthLumaMinus8(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_17, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.avcDecoderConfigurationRecord.bitDepthLumaMinus8 = i;
    }

    public final void setBitDepthChromaMinus8(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_19, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.avcDecoderConfigurationRecord.bitDepthChromaMinus8 = i;
    }

    public final void setHasExts(boolean z) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_23, this, this, Boolean.valueOf(z));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.avcDecoderConfigurationRecord.hasExts = z;
    }
}
