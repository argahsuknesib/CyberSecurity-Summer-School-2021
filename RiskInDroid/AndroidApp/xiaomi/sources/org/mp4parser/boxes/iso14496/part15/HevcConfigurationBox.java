package org.mp4parser.boxes.iso14496.part15;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkn;
import _m_j.jku;
import java.nio.ByteBuffer;
import java.util.List;
import org.mp4parser.boxes.iso14496.part15.HevcDecoderConfigurationRecord;

public class HevcConfigurationBox extends jkn {
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
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private static final jhf.O000000o ajc$tjp_7 = null;
    private static final jhf.O000000o ajc$tjp_8 = null;
    private static final jhf.O000000o ajc$tjp_9 = null;
    private HevcDecoderConfigurationRecord hevcDecoderConfigurationRecord = new HevcDecoderConfigurationRecord();

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("HevcConfigurationBox.java", HevcConfigurationBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getHevcDecoderConfigurationRecord", "org.mp4parser.boxes.iso14496.part15.HevcConfigurationBox", "", "", "", "org.mp4parser.boxes.iso14496.part15.HevcDecoderConfigurationRecord"), 37);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setHevcDecoderConfigurationRecord", "org.mp4parser.boxes.iso14496.part15.HevcConfigurationBox", "org.mp4parser.boxes.iso14496.part15.HevcDecoderConfigurationRecord", "hevcDecoderConfigurationRecord", "", "void"), 41);
        ajc$tjp_10 = jho.O000000o("method-execution", jho.O000000o("1", "getGeneral_level_idc", "org.mp4parser.boxes.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 89);
        ajc$tjp_11 = jho.O000000o("method-execution", jho.O000000o("1", "getMin_spatial_segmentation_idc", "org.mp4parser.boxes.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 93);
        ajc$tjp_12 = jho.O000000o("method-execution", jho.O000000o("1", "getParallelismType", "org.mp4parser.boxes.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 97);
        ajc$tjp_13 = jho.O000000o("method-execution", jho.O000000o("1", "getChromaFormat", "org.mp4parser.boxes.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 101);
        ajc$tjp_14 = jho.O000000o("method-execution", jho.O000000o("1", "getBitDepthLumaMinus8", "org.mp4parser.boxes.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 105);
        ajc$tjp_15 = jho.O000000o("method-execution", jho.O000000o("1", "getBitDepthChromaMinus8", "org.mp4parser.boxes.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 109);
        ajc$tjp_16 = jho.O000000o("method-execution", jho.O000000o("1", "getAvgFrameRate", "org.mp4parser.boxes.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 113);
        ajc$tjp_17 = jho.O000000o("method-execution", jho.O000000o("1", "getNumTemporalLayers", "org.mp4parser.boxes.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 117);
        ajc$tjp_18 = jho.O000000o("method-execution", jho.O000000o("1", "getLengthSizeMinusOne", "org.mp4parser.boxes.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 121);
        ajc$tjp_19 = jho.O000000o("method-execution", jho.O000000o("1", "isTemporalIdNested", "org.mp4parser.boxes.iso14496.part15.HevcConfigurationBox", "", "", "", "boolean"), 125);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "equals", "org.mp4parser.boxes.iso14496.part15.HevcConfigurationBox", "java.lang.Object", "o", "", "boolean"), 46);
        ajc$tjp_20 = jho.O000000o("method-execution", jho.O000000o("1", "getConstantFrameRate", "org.mp4parser.boxes.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 129);
        ajc$tjp_21 = jho.O000000o("method-execution", jho.O000000o("1", "getArrays", "org.mp4parser.boxes.iso14496.part15.HevcConfigurationBox", "", "", "", "java.util.List"), 133);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "hashCode", "org.mp4parser.boxes.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 59);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getConfigurationVersion", "org.mp4parser.boxes.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 64);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "getGeneral_profile_space", "org.mp4parser.boxes.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 68);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "isGeneral_tier_flag", "org.mp4parser.boxes.iso14496.part15.HevcConfigurationBox", "", "", "", "boolean"), 72);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "getGeneral_profile_idc", "org.mp4parser.boxes.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 77);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "getGeneral_profile_compatibility_flags", "org.mp4parser.boxes.iso14496.part15.HevcConfigurationBox", "", "", "", "long"), 81);
        ajc$tjp_9 = jho.O000000o("method-execution", jho.O000000o("1", "getGeneral_constraint_indicator_flags", "org.mp4parser.boxes.iso14496.part15.HevcConfigurationBox", "", "", "", "long"), 85);
    }

    public HevcConfigurationBox() {
        super("hvcC");
    }

    public long getContentSize() {
        return (long) this.hevcDecoderConfigurationRecord.getSize();
    }

    public void getContent(ByteBuffer byteBuffer) {
        this.hevcDecoderConfigurationRecord.write(byteBuffer);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        this.hevcDecoderConfigurationRecord.parse(byteBuffer);
    }

    public HevcDecoderConfigurationRecord getHevcDecoderConfigurationRecord() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.hevcDecoderConfigurationRecord;
    }

    public void setHevcDecoderConfigurationRecord(HevcDecoderConfigurationRecord hevcDecoderConfigurationRecord2) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, hevcDecoderConfigurationRecord2);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.hevcDecoderConfigurationRecord = hevcDecoderConfigurationRecord2;
    }

    public boolean equals(Object obj) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this, obj);
        jku.O000000o();
        jku.O000000o(O000000o2);
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HevcConfigurationBox hevcConfigurationBox = (HevcConfigurationBox) obj;
        HevcDecoderConfigurationRecord hevcDecoderConfigurationRecord2 = this.hevcDecoderConfigurationRecord;
        return hevcDecoderConfigurationRecord2 == null ? hevcConfigurationBox.hevcDecoderConfigurationRecord == null : hevcDecoderConfigurationRecord2.equals(hevcConfigurationBox.hevcDecoderConfigurationRecord);
    }

    public int hashCode() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        HevcDecoderConfigurationRecord hevcDecoderConfigurationRecord2 = this.hevcDecoderConfigurationRecord;
        if (hevcDecoderConfigurationRecord2 != null) {
            return hevcDecoderConfigurationRecord2.hashCode();
        }
        return 0;
    }

    public int getConfigurationVersion() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.hevcDecoderConfigurationRecord.configurationVersion;
    }

    public int getGeneral_profile_space() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.hevcDecoderConfigurationRecord.general_profile_space;
    }

    public boolean isGeneral_tier_flag() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.hevcDecoderConfigurationRecord.general_tier_flag;
    }

    public int getGeneral_profile_idc() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.hevcDecoderConfigurationRecord.general_profile_idc;
    }

    public long getGeneral_profile_compatibility_flags() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.hevcDecoderConfigurationRecord.general_profile_compatibility_flags;
    }

    public long getGeneral_constraint_indicator_flags() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_9, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.hevcDecoderConfigurationRecord.general_constraint_indicator_flags;
    }

    public int getGeneral_level_idc() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_10, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.hevcDecoderConfigurationRecord.general_level_idc;
    }

    public int getMin_spatial_segmentation_idc() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_11, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.hevcDecoderConfigurationRecord.min_spatial_segmentation_idc;
    }

    public int getParallelismType() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_12, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.hevcDecoderConfigurationRecord.parallelismType;
    }

    public int getChromaFormat() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_13, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.hevcDecoderConfigurationRecord.chromaFormat;
    }

    public int getBitDepthLumaMinus8() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_14, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.hevcDecoderConfigurationRecord.bitDepthLumaMinus8;
    }

    public int getBitDepthChromaMinus8() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_15, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.hevcDecoderConfigurationRecord.bitDepthChromaMinus8;
    }

    public int getAvgFrameRate() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_16, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.hevcDecoderConfigurationRecord.avgFrameRate;
    }

    public int getNumTemporalLayers() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_17, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.hevcDecoderConfigurationRecord.numTemporalLayers;
    }

    public int getLengthSizeMinusOne() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_18, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.hevcDecoderConfigurationRecord.lengthSizeMinusOne;
    }

    public boolean isTemporalIdNested() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_19, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.hevcDecoderConfigurationRecord.temporalIdNested;
    }

    public int getConstantFrameRate() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_20, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.hevcDecoderConfigurationRecord.constantFrameRate;
    }

    public List<HevcDecoderConfigurationRecord.Array> getArrays() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_21, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.hevcDecoderConfigurationRecord.arrays;
    }
}
