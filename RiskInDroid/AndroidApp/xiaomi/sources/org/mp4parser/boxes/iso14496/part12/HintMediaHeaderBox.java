package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;

public class HintMediaHeaderBox extends AbstractMediaHeaderBox {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private long avgBitrate;
    private int avgPduSize;
    private long maxBitrate;
    private int maxPduSize;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("HintMediaHeaderBox.java", HintMediaHeaderBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getMaxPduSize", "org.mp4parser.boxes.iso14496.part12.HintMediaHeaderBox", "", "", "", "int"), 42);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "getAvgPduSize", "org.mp4parser.boxes.iso14496.part12.HintMediaHeaderBox", "", "", "", "int"), 46);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getMaxBitrate", "org.mp4parser.boxes.iso14496.part12.HintMediaHeaderBox", "", "", "", "long"), 50);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "getAvgBitrate", "org.mp4parser.boxes.iso14496.part12.HintMediaHeaderBox", "", "", "", "long"), 54);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part12.HintMediaHeaderBox", "", "", "", "java.lang.String"), 84);
    }

    public long getContentSize() {
        return 20;
    }

    public HintMediaHeaderBox() {
        super("hmhd");
    }

    public int getMaxPduSize() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.maxPduSize;
    }

    public int getAvgPduSize() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.avgPduSize;
    }

    public long getMaxBitrate() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.maxBitrate;
    }

    public long getAvgBitrate() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.avgBitrate;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.maxPduSize = jky.O00000o0(byteBuffer);
        this.avgPduSize = jky.O00000o0(byteBuffer);
        this.maxBitrate = jky.O000000o(byteBuffer);
        this.avgBitrate = jky.O000000o(byteBuffer);
        jky.O000000o(byteBuffer);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jla.O00000Oo(java.nio.ByteBuffer, long):void
     arg types: [java.nio.ByteBuffer, int]
     candidates:
      _m_j.jla.O00000Oo(java.nio.ByteBuffer, double):void
      _m_j.jla.O00000Oo(java.nio.ByteBuffer, int):void
      _m_j.jla.O00000Oo(java.nio.ByteBuffer, java.lang.String):void
      _m_j.jla.O00000Oo(java.nio.ByteBuffer, long):void */
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O00000Oo(byteBuffer, this.maxPduSize);
        jla.O00000Oo(byteBuffer, this.avgPduSize);
        jla.O00000Oo(byteBuffer, this.maxBitrate);
        jla.O00000Oo(byteBuffer, this.avgBitrate);
        jla.O00000Oo(byteBuffer, 0L);
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "HintMediaHeaderBox{maxPduSize=" + this.maxPduSize + ", avgPduSize=" + this.avgPduSize + ", maxBitrate=" + this.maxBitrate + ", avgBitrate=" + this.avgBitrate + '}';
    }
}
