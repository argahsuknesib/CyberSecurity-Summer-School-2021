package org.mp4parser.boxes.dolby;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkn;
import _m_j.jku;
import java.nio.ByteBuffer;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.BitReaderBuffer;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.BitWriterBuffer;

public class AC3SpecificBox extends jkn {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_10 = null;
    private static final jhf.O000000o ajc$tjp_11 = null;
    private static final jhf.O000000o ajc$tjp_12 = null;
    private static final jhf.O000000o ajc$tjp_13 = null;
    private static final jhf.O000000o ajc$tjp_14 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private static final jhf.O000000o ajc$tjp_7 = null;
    private static final jhf.O000000o ajc$tjp_8 = null;
    private static final jhf.O000000o ajc$tjp_9 = null;
    int acmod;
    int bitRateCode;
    int bsid;
    int bsmod;
    int fscod;
    int lfeon;
    int reserved;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("AC3SpecificBox.java", AC3SpecificBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getFscod", "org.mp4parser.boxes.dolby.AC3SpecificBox", "", "", "", "int"), 55);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setFscod", "org.mp4parser.boxes.dolby.AC3SpecificBox", "int", "fscod", "", "void"), 59);
        ajc$tjp_10 = jho.O000000o("method-execution", jho.O000000o("1", "getBitRateCode", "org.mp4parser.boxes.dolby.AC3SpecificBox", "", "", "", "int"), 95);
        ajc$tjp_11 = jho.O000000o("method-execution", jho.O000000o("1", "setBitRateCode", "org.mp4parser.boxes.dolby.AC3SpecificBox", "int", "bitRateCode", "", "void"), 99);
        ajc$tjp_12 = jho.O000000o("method-execution", jho.O000000o("1", "getReserved", "org.mp4parser.boxes.dolby.AC3SpecificBox", "", "", "", "int"), 103);
        ajc$tjp_13 = jho.O000000o("method-execution", jho.O000000o("1", "setReserved", "org.mp4parser.boxes.dolby.AC3SpecificBox", "int", "reserved", "", "void"), 107);
        ajc$tjp_14 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.dolby.AC3SpecificBox", "", "", "", "java.lang.String"), 112);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getBsid", "org.mp4parser.boxes.dolby.AC3SpecificBox", "", "", "", "int"), 63);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setBsid", "org.mp4parser.boxes.dolby.AC3SpecificBox", "int", "bsid", "", "void"), 67);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getBsmod", "org.mp4parser.boxes.dolby.AC3SpecificBox", "", "", "", "int"), 71);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setBsmod", "org.mp4parser.boxes.dolby.AC3SpecificBox", "int", "bsmod", "", "void"), 75);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "getAcmod", "org.mp4parser.boxes.dolby.AC3SpecificBox", "", "", "", "int"), 79);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "setAcmod", "org.mp4parser.boxes.dolby.AC3SpecificBox", "int", "acmod", "", "void"), 83);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "getLfeon", "org.mp4parser.boxes.dolby.AC3SpecificBox", "", "", "", "int"), 87);
        ajc$tjp_9 = jho.O000000o("method-execution", jho.O000000o("1", "setLfeon", "org.mp4parser.boxes.dolby.AC3SpecificBox", "int", "lfeon", "", "void"), 91);
    }

    public long getContentSize() {
        return 3;
    }

    public AC3SpecificBox() {
        super("dac3");
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBuffer);
        this.fscod = bitReaderBuffer.readBits(2);
        this.bsid = bitReaderBuffer.readBits(5);
        this.bsmod = bitReaderBuffer.readBits(3);
        this.acmod = bitReaderBuffer.readBits(3);
        this.lfeon = bitReaderBuffer.readBits(1);
        this.bitRateCode = bitReaderBuffer.readBits(5);
        this.reserved = bitReaderBuffer.readBits(5);
    }

    public void getContent(ByteBuffer byteBuffer) {
        BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(byteBuffer);
        bitWriterBuffer.writeBits(this.fscod, 2);
        bitWriterBuffer.writeBits(this.bsid, 5);
        bitWriterBuffer.writeBits(this.bsmod, 3);
        bitWriterBuffer.writeBits(this.acmod, 3);
        bitWriterBuffer.writeBits(this.lfeon, 1);
        bitWriterBuffer.writeBits(this.bitRateCode, 5);
        bitWriterBuffer.writeBits(this.reserved, 5);
    }

    public int getFscod() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.fscod;
    }

    public int getBsid() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.bsid;
    }

    public int getBsmod() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.bsmod;
    }

    public int getAcmod() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.acmod;
    }

    public int getLfeon() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.lfeon;
    }

    public int getBitRateCode() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_10, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.bitRateCode;
    }

    public int getReserved() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_12, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.reserved;
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_14, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "AC3SpecificBox{fscod=" + this.fscod + ", bsid=" + this.bsid + ", bsmod=" + this.bsmod + ", acmod=" + this.acmod + ", lfeon=" + this.lfeon + ", bitRateCode=" + this.bitRateCode + ", reserved=" + this.reserved + '}';
    }

    public void setFscod(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.fscod = i;
    }

    public void setBsid(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.bsid = i;
    }

    public void setBsmod(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.bsmod = i;
    }

    public void setAcmod(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.acmod = i;
    }

    public void setLfeon(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_9, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.lfeon = i;
    }

    public void setBitRateCode(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_11, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.bitRateCode = i;
    }

    public void setReserved(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_13, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.reserved = i;
    }
}
