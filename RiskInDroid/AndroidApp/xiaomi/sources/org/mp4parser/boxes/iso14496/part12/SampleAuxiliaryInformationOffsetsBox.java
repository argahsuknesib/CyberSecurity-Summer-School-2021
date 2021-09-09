package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhc;
import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jkv;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;

public class SampleAuxiliaryInformationOffsetsBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private String auxInfoType;
    private String auxInfoTypeParameter;
    private long[] offsets = new long[0];

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("SampleAuxiliaryInformationOffsetsBox.java", SampleAuxiliaryInformationOffsetsBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getAuxInfoType", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "", "", "", "java.lang.String"), 106);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setAuxInfoType", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "java.lang.String", "auxInfoType", "", "void"), 110);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getAuxInfoTypeParameter", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "", "", "", "java.lang.String"), 114);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setAuxInfoTypeParameter", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "java.lang.String", "auxInfoTypeParameter", "", "void"), 118);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getOffsets", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "", "", "", "[J"), 122);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setOffsets", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "[J", "offsets", "", "void"), 126);
    }

    public SampleAuxiliaryInformationOffsetsBox() {
        super("saio");
    }

    public long getContentSize() {
        int i = 8;
        int length = (getVersion() == 0 ? this.offsets.length * 4 : this.offsets.length * 8) + 8;
        if ((getFlags() & 1) != 1) {
            i = 0;
        }
        return (long) (length + i);
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        if ((getFlags() & 1) == 1) {
            byteBuffer.put(jhc.O000000o(this.auxInfoType));
            byteBuffer.put(jhc.O000000o(this.auxInfoTypeParameter));
        }
        jla.O00000Oo(byteBuffer, (long) this.offsets.length);
        for (long valueOf : this.offsets) {
            Long valueOf2 = Long.valueOf(valueOf);
            if (getVersion() == 0) {
                jla.O00000Oo(byteBuffer, valueOf2.longValue());
            } else {
                jla.O000000o(byteBuffer, valueOf2.longValue());
            }
        }
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if ((getFlags() & 1) == 1) {
            this.auxInfoType = jky.O0000OoO(byteBuffer);
            this.auxInfoTypeParameter = jky.O0000OoO(byteBuffer);
        }
        int O000000o2 = jkv.O000000o(jky.O000000o(byteBuffer));
        this.offsets = new long[O000000o2];
        for (int i = 0; i < O000000o2; i++) {
            if (getVersion() == 0) {
                this.offsets[i] = jky.O000000o(byteBuffer);
            } else {
                this.offsets[i] = jky.O00000oo(byteBuffer);
            }
        }
    }

    public String getAuxInfoType() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.auxInfoType;
    }

    public void setAuxInfoType(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.auxInfoType = str;
    }

    public String getAuxInfoTypeParameter() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.auxInfoTypeParameter;
    }

    public void setAuxInfoTypeParameter(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.auxInfoTypeParameter = str;
    }

    public long[] getOffsets() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.offsets;
    }

    public void setOffsets(long[] jArr) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, jArr);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.offsets = jArr;
    }
}
