package org.mp4parser.boxes.dece;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkn;
import _m_j.jku;
import java.nio.ByteBuffer;
import java.util.List;
import org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox;
import org.mp4parser.boxes.iso14496.part15.AvcDecoderConfigurationRecord;

public class AvcNalUnitStorageBox extends jkn {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    AvcDecoderConfigurationRecord avcDecoderConfigurationRecord;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("AvcNalUnitStorageBox.java", AvcNalUnitStorageBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getAvcDecoderConfigurationRecord", "org.mp4parser.boxes.dece.AvcNalUnitStorageBox", "", "", "", "org.mp4parser.boxes.iso14496.part15.AvcDecoderConfigurationRecord"), 44);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "getLengthSizeMinusOne", "org.mp4parser.boxes.dece.AvcNalUnitStorageBox", "", "", "", "int"), 49);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getSequenceParameterSetsAsStrings", "org.mp4parser.boxes.dece.AvcNalUnitStorageBox", "", "", "", "java.util.List"), 53);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "getSequenceParameterSetExtsAsStrings", "org.mp4parser.boxes.dece.AvcNalUnitStorageBox", "", "", "", "java.util.List"), 57);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getPictureParameterSetsAsStrings", "org.mp4parser.boxes.dece.AvcNalUnitStorageBox", "", "", "", "java.util.List"), 61);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.dece.AvcNalUnitStorageBox", "", "", "", "java.lang.String"), 81);
    }

    public AvcNalUnitStorageBox() {
        super("avcn");
    }

    public AvcNalUnitStorageBox(AvcConfigurationBox avcConfigurationBox) {
        super("avcn");
        this.avcDecoderConfigurationRecord = avcConfigurationBox.getavcDecoderConfigurationRecord();
    }

    public AvcDecoderConfigurationRecord getAvcDecoderConfigurationRecord() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.avcDecoderConfigurationRecord;
    }

    public int getLengthSizeMinusOne() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.avcDecoderConfigurationRecord.lengthSizeMinusOne;
    }

    public List<String> getSequenceParameterSetsAsStrings() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.avcDecoderConfigurationRecord.getSequenceParameterSetsAsStrings();
    }

    public List<String> getSequenceParameterSetExtsAsStrings() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.avcDecoderConfigurationRecord.getSequenceParameterSetExtsAsStrings();
    }

    public List<String> getPictureParameterSetsAsStrings() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.avcDecoderConfigurationRecord.getPictureParameterSetsAsStrings();
    }

    public long getContentSize() {
        return this.avcDecoderConfigurationRecord.getContentSize();
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        this.avcDecoderConfigurationRecord = new AvcDecoderConfigurationRecord(byteBuffer);
    }

    public void getContent(ByteBuffer byteBuffer) {
        this.avcDecoderConfigurationRecord.getContent(byteBuffer);
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "AvcNalUnitStorageBox{SPS=" + this.avcDecoderConfigurationRecord.getSequenceParameterSetsAsStrings() + ",PPS=" + this.avcDecoderConfigurationRecord.getPictureParameterSetsAsStrings() + ",lengthSize=" + (this.avcDecoderConfigurationRecord.lengthSizeMinusOne + 1) + '}';
    }
}
