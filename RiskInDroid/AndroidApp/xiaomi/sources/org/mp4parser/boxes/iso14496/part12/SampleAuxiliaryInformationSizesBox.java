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

public class SampleAuxiliaryInformationSizesBox extends jkp {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_10 = null;
    private static final jhf.O000000o ajc$tjp_11 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private static final jhf.O000000o ajc$tjp_7 = null;
    private static final jhf.O000000o ajc$tjp_8 = null;
    private static final jhf.O000000o ajc$tjp_9 = null;
    private String auxInfoType;
    private String auxInfoTypeParameter;
    private short defaultSampleInfoSize;
    private int sampleCount;
    private short[] sampleInfoSizes = new short[0];

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("SampleAuxiliaryInformationSizesBox.java", SampleAuxiliaryInformationSizesBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getSize", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationSizesBox", "int", "index", "", "short"), 55);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "getAuxInfoType", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "java.lang.String"), 104);
        ajc$tjp_10 = jho.O000000o("method-execution", jho.O000000o("1", "setSampleCount", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationSizesBox", "int", "sampleCount", "", "void"), 144);
        ajc$tjp_11 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "java.lang.String"), 149);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "setAuxInfoType", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationSizesBox", "java.lang.String", "auxInfoType", "", "void"), 108);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "getAuxInfoTypeParameter", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "java.lang.String"), 112);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "setAuxInfoTypeParameter", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationSizesBox", "java.lang.String", "auxInfoTypeParameter", "", "void"), 116);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "getDefaultSampleInfoSize", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "int"), 120);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "setDefaultSampleInfoSize", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationSizesBox", "int", "defaultSampleInfoSize", "", "void"), 124);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "getSampleInfoSizes", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "[S"), 129);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "setSampleInfoSizes", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationSizesBox", "[S", "sampleInfoSizes", "", "void"), 135);
        ajc$tjp_9 = jho.O000000o("method-execution", jho.O000000o("1", "getSampleCount", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "int"), 140);
    }

    public SampleAuxiliaryInformationSizesBox() {
        super("saiz");
    }

    public long getContentSize() {
        return (long) (((getFlags() & 1) == 1 ? 12 : 4) + 5 + (this.defaultSampleInfoSize == 0 ? this.sampleInfoSizes.length : 0));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jla.O00000o(java.nio.ByteBuffer, int):void
     arg types: [java.nio.ByteBuffer, short]
     candidates:
      _m_j.jla.O00000o(java.nio.ByteBuffer, long):void
      _m_j.jla.O00000o(java.nio.ByteBuffer, int):void */
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        if ((getFlags() & 1) == 1) {
            byteBuffer.put(jhc.O000000o(this.auxInfoType));
            byteBuffer.put(jhc.O000000o(this.auxInfoTypeParameter));
        }
        jla.O00000o(byteBuffer, (int) this.defaultSampleInfoSize);
        if (this.defaultSampleInfoSize == 0) {
            jla.O00000Oo(byteBuffer, (long) this.sampleInfoSizes.length);
            for (short s : this.sampleInfoSizes) {
                jla.O00000o(byteBuffer, (int) s);
            }
            return;
        }
        jla.O00000Oo(byteBuffer, (long) this.sampleCount);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if ((getFlags() & 1) == 1) {
            this.auxInfoType = jky.O0000OoO(byteBuffer);
            this.auxInfoTypeParameter = jky.O0000OoO(byteBuffer);
        }
        this.defaultSampleInfoSize = (short) jky.O000000o(byteBuffer.get());
        this.sampleCount = jkv.O000000o(jky.O000000o(byteBuffer));
        if (this.defaultSampleInfoSize == 0) {
            this.sampleInfoSizes = new short[this.sampleCount];
            for (int i = 0; i < this.sampleCount; i++) {
                this.sampleInfoSizes[i] = (short) jky.O000000o(byteBuffer.get());
            }
        }
    }

    public String getAuxInfoType() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.auxInfoType;
    }

    public void setAuxInfoType(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.auxInfoType = str;
    }

    public String getAuxInfoTypeParameter() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.auxInfoTypeParameter;
    }

    public void setAuxInfoTypeParameter(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.auxInfoTypeParameter = str;
    }

    public int getDefaultSampleInfoSize() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.defaultSampleInfoSize;
    }

    public short[] getSampleInfoSizes() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        short[] sArr = this.sampleInfoSizes;
        short[] sArr2 = new short[sArr.length];
        System.arraycopy(sArr, 0, sArr2, 0, sArr.length);
        return sArr2;
    }

    public void setSampleInfoSizes(short[] sArr) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this, sArr);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.sampleInfoSizes = new short[sArr.length];
        System.arraycopy(sArr, 0, this.sampleInfoSizes, 0, sArr.length);
    }

    public int getSampleCount() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_9, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.sampleCount;
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_11, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "SampleAuxiliaryInformationSizesBox{defaultSampleInfoSize=" + ((int) this.defaultSampleInfoSize) + ", sampleCount=" + this.sampleCount + ", auxInfoType='" + this.auxInfoType + '\'' + ", auxInfoTypeParameter='" + this.auxInfoTypeParameter + '\'' + '}';
    }

    public short getSize(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        if (getDefaultSampleInfoSize() == 0) {
            return this.sampleInfoSizes[i];
        }
        return this.defaultSampleInfoSize;
    }

    public void setDefaultSampleInfoSize(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.defaultSampleInfoSize = (short) i;
    }

    public void setSampleCount(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_10, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.sampleCount = i;
    }
}
