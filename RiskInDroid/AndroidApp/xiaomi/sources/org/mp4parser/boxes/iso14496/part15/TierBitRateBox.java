package org.mp4parser.boxes.iso14496.part15;

import _m_j.jhf;
import _m_j.jhm;
import _m_j.jho;
import _m_j.jkn;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;

public class TierBitRateBox extends jkn {
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
    long avgBitRate;
    long baseBitRate;
    long maxBitRate;
    long tierAvgBitRate;
    long tierBaseBitRate;
    long tierMaxBitRate;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("TierBitRateBox.java", TierBitRateBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getBaseBitRate", "org.mp4parser.boxes.iso14496.part15.TierBitRateBox", "", "", "", "long"), 52);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setBaseBitRate", "org.mp4parser.boxes.iso14496.part15.TierBitRateBox", "long", "baseBitRate", "", "void"), 56);
        ajc$tjp_10 = jho.O000000o("method-execution", jho.O000000o("1", "getTierAvgBitRate", "org.mp4parser.boxes.iso14496.part15.TierBitRateBox", "", "", "", "long"), 92);
        ajc$tjp_11 = jho.O000000o("method-execution", jho.O000000o("1", "setTierAvgBitRate", "org.mp4parser.boxes.iso14496.part15.TierBitRateBox", "long", "tierAvgBitRate", "", "void"), 96);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getMaxBitRate", "org.mp4parser.boxes.iso14496.part15.TierBitRateBox", "", "", "", "long"), 60);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setMaxBitRate", "org.mp4parser.boxes.iso14496.part15.TierBitRateBox", "long", "maxBitRate", "", "void"), 64);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getAvgBitRate", "org.mp4parser.boxes.iso14496.part15.TierBitRateBox", "", "", "", "long"), 68);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setAvgBitRate", "org.mp4parser.boxes.iso14496.part15.TierBitRateBox", "long", "avgBitRate", "", "void"), 72);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "getTierBaseBitRate", "org.mp4parser.boxes.iso14496.part15.TierBitRateBox", "", "", "", "long"), 76);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "setTierBaseBitRate", "org.mp4parser.boxes.iso14496.part15.TierBitRateBox", "long", "tierBaseBitRate", "", "void"), 80);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "getTierMaxBitRate", "org.mp4parser.boxes.iso14496.part15.TierBitRateBox", "", "", "", "long"), 84);
        ajc$tjp_9 = jho.O000000o("method-execution", jho.O000000o("1", "setTierMaxBitRate", "org.mp4parser.boxes.iso14496.part15.TierBitRateBox", "long", "tierMaxBitRate", "", "void"), 88);
    }

    public long getContentSize() {
        return 24;
    }

    public TierBitRateBox() {
        super("tibr");
    }

    public void getContent(ByteBuffer byteBuffer) {
        jla.O00000Oo(byteBuffer, this.baseBitRate);
        jla.O00000Oo(byteBuffer, this.maxBitRate);
        jla.O00000Oo(byteBuffer, this.avgBitRate);
        jla.O00000Oo(byteBuffer, this.tierBaseBitRate);
        jla.O00000Oo(byteBuffer, this.tierMaxBitRate);
        jla.O00000Oo(byteBuffer, this.tierAvgBitRate);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        this.baseBitRate = jky.O000000o(byteBuffer);
        this.maxBitRate = jky.O000000o(byteBuffer);
        this.avgBitRate = jky.O000000o(byteBuffer);
        this.tierBaseBitRate = jky.O000000o(byteBuffer);
        this.tierMaxBitRate = jky.O000000o(byteBuffer);
        this.tierAvgBitRate = jky.O000000o(byteBuffer);
    }

    public long getBaseBitRate() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.baseBitRate;
    }

    public void setBaseBitRate(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.baseBitRate = j;
    }

    public long getMaxBitRate() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.maxBitRate;
    }

    public void setMaxBitRate(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.maxBitRate = j;
    }

    public long getAvgBitRate() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.avgBitRate;
    }

    public void setAvgBitRate(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.avgBitRate = j;
    }

    public long getTierBaseBitRate() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.tierBaseBitRate;
    }

    public void setTierBaseBitRate(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.tierBaseBitRate = j;
    }

    public long getTierMaxBitRate() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.tierMaxBitRate;
    }

    public void setTierMaxBitRate(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_9, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.tierMaxBitRate = j;
    }

    public long getTierAvgBitRate() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_10, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.tierAvgBitRate;
    }

    public void setTierAvgBitRate(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_11, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.tierAvgBitRate = j;
    }
}
