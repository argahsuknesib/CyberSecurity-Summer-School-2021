package org.mp4parser.boxes.iso14496.part15;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkn;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;

public class PriotityRangeBox extends jkn {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private static final jhf.O000000o ajc$tjp_7 = null;
    int max_priorityId;
    int min_priorityId;
    int reserved1 = 0;
    int reserved2 = 0;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("PriotityRangeBox.java", PriotityRangeBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getReserved1", "org.mp4parser.boxes.iso14496.part15.PriotityRangeBox", "", "", "", "int"), 45);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setReserved1", "org.mp4parser.boxes.iso14496.part15.PriotityRangeBox", "int", "reserved1", "", "void"), 49);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getMin_priorityId", "org.mp4parser.boxes.iso14496.part15.PriotityRangeBox", "", "", "", "int"), 53);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setMin_priorityId", "org.mp4parser.boxes.iso14496.part15.PriotityRangeBox", "int", "min_priorityId", "", "void"), 57);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getReserved2", "org.mp4parser.boxes.iso14496.part15.PriotityRangeBox", "", "", "", "int"), 61);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setReserved2", "org.mp4parser.boxes.iso14496.part15.PriotityRangeBox", "int", "reserved2", "", "void"), 65);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "getMax_priorityId", "org.mp4parser.boxes.iso14496.part15.PriotityRangeBox", "", "", "", "int"), 69);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "setMax_priorityId", "org.mp4parser.boxes.iso14496.part15.PriotityRangeBox", "int", "max_priorityId", "", "void"), 73);
    }

    public long getContentSize() {
        return 2;
    }

    public PriotityRangeBox() {
        super("svpr");
    }

    public void getContent(ByteBuffer byteBuffer) {
        jla.O00000o(byteBuffer, (this.reserved1 << 6) + this.min_priorityId);
        jla.O00000o(byteBuffer, (this.reserved2 << 6) + this.max_priorityId);
    }

    public int getReserved1() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.reserved1;
    }

    public int getMin_priorityId() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.min_priorityId;
    }

    public int getReserved2() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.reserved2;
    }

    public int getMax_priorityId() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.max_priorityId;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        this.min_priorityId = jky.O000000o(byteBuffer.get());
        int i = this.min_priorityId;
        this.reserved1 = (i & 192) >> 6;
        this.min_priorityId = i & 63;
        this.max_priorityId = jky.O000000o(byteBuffer.get());
        int i2 = this.max_priorityId;
        this.reserved2 = (i2 & 192) >> 6;
        this.max_priorityId = i2 & 63;
    }

    public void setReserved1(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.reserved1 = i;
    }

    public void setMin_priorityId(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.min_priorityId = i;
    }

    public void setReserved2(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.reserved2 = i;
    }

    public void setMax_priorityId(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.max_priorityId = i;
    }
}
