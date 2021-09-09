package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jhm;
import _m_j.jho;
import _m_j.jkn;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;

public final class BitRateBox extends jkn {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private long avgBitrate;
    private long bufferSizeDb;
    private long maxBitrate;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("BitRateBox.java", BitRateBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getBufferSizeDb", "org.mp4parser.boxes.iso14496.part12.BitRateBox", "", "", "", "long"), 75);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setBufferSizeDb", "org.mp4parser.boxes.iso14496.part12.BitRateBox", "long", "bufferSizeDb", "", "void"), 84);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getMaxBitrate", "org.mp4parser.boxes.iso14496.part12.BitRateBox", "", "", "", "long"), 93);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setMaxBitrate", "org.mp4parser.boxes.iso14496.part12.BitRateBox", "long", "maxBitrate", "", "void"), 102);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getAvgBitrate", "org.mp4parser.boxes.iso14496.part12.BitRateBox", "", "", "", "long"), 111);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setAvgBitrate", "org.mp4parser.boxes.iso14496.part12.BitRateBox", "long", "avgBitrate", "", "void"), 120);
    }

    public final long getContentSize() {
        return 12;
    }

    public BitRateBox() {
        super("btrt");
    }

    public final void _parseDetails(ByteBuffer byteBuffer) {
        this.bufferSizeDb = jky.O000000o(byteBuffer);
        this.maxBitrate = jky.O000000o(byteBuffer);
        this.avgBitrate = jky.O000000o(byteBuffer);
    }

    public final void getContent(ByteBuffer byteBuffer) {
        jla.O00000Oo(byteBuffer, this.bufferSizeDb);
        jla.O00000Oo(byteBuffer, this.maxBitrate);
        jla.O00000Oo(byteBuffer, this.avgBitrate);
    }

    public final long getBufferSizeDb() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.bufferSizeDb;
    }

    public final void setBufferSizeDb(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.bufferSizeDb = j;
    }

    public final long getMaxBitrate() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.maxBitrate;
    }

    public final void setMaxBitrate(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.maxBitrate = j;
    }

    public final long getAvgBitrate() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.avgBitrate;
    }

    public final void setAvgBitrate(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.avgBitrate = j;
    }
}
