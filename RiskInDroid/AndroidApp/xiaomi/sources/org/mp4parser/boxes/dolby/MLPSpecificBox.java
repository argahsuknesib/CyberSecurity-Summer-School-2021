package org.mp4parser.boxes.dolby;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkn;
import _m_j.jku;
import java.nio.ByteBuffer;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.BitReaderBuffer;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.BitWriterBuffer;

public class MLPSpecificBox extends jkn {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private static final jhf.O000000o ajc$tjp_7 = null;
    int format_info;
    int peak_data_rate;
    int reserved;
    int reserved2;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("MLPSpecificBox.java", MLPSpecificBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getFormat_info", "org.mp4parser.boxes.dolby.MLPSpecificBox", "", "", "", "int"), 49);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setFormat_info", "org.mp4parser.boxes.dolby.MLPSpecificBox", "int", "format_info", "", "void"), 53);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getPeak_data_rate", "org.mp4parser.boxes.dolby.MLPSpecificBox", "", "", "", "int"), 57);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setPeak_data_rate", "org.mp4parser.boxes.dolby.MLPSpecificBox", "int", "peak_data_rate", "", "void"), 61);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getReserved", "org.mp4parser.boxes.dolby.MLPSpecificBox", "", "", "", "int"), 65);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setReserved", "org.mp4parser.boxes.dolby.MLPSpecificBox", "int", "reserved", "", "void"), 69);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "getReserved2", "org.mp4parser.boxes.dolby.MLPSpecificBox", "", "", "", "int"), 73);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "setReserved2", "org.mp4parser.boxes.dolby.MLPSpecificBox", "int", "reserved2", "", "void"), 77);
    }

    public long getContentSize() {
        return 10;
    }

    public MLPSpecificBox() {
        super("dmlp");
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBuffer);
        this.format_info = bitReaderBuffer.readBits(32);
        this.peak_data_rate = bitReaderBuffer.readBits(15);
        this.reserved = bitReaderBuffer.readBits(1);
        this.reserved2 = bitReaderBuffer.readBits(32);
    }

    public void getContent(ByteBuffer byteBuffer) {
        BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(byteBuffer);
        bitWriterBuffer.writeBits(this.format_info, 32);
        bitWriterBuffer.writeBits(this.peak_data_rate, 15);
        bitWriterBuffer.writeBits(this.reserved, 1);
        bitWriterBuffer.writeBits(this.reserved2, 32);
    }

    public int getFormat_info() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.format_info;
    }

    public int getPeak_data_rate() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.peak_data_rate;
    }

    public int getReserved() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.reserved;
    }

    public int getReserved2() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.reserved2;
    }

    public void setFormat_info(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.format_info = i;
    }

    public void setPeak_data_rate(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.peak_data_rate = i;
    }

    public void setReserved(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.reserved = i;
    }

    public void setReserved2(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.reserved2 = i;
    }
}
