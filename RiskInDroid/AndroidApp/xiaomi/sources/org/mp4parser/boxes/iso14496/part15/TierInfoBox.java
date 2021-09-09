package org.mp4parser.boxes.iso14496.part15;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkn;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;

public class TierInfoBox extends jkn {
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
    int constantFrameRate;
    int discardable;
    int frameRate;
    int levelIndication;
    int profileIndication;
    int profile_compatibility;
    int reserved1 = 0;
    int reserved2 = 0;
    int tierID;
    int visualHeight;
    int visualWidth;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("TierInfoBox.java", TierInfoBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getTierID", "org.mp4parser.boxes.iso14496.part15.TierInfoBox", "", "", "", "int"), 69);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setTierID", "org.mp4parser.boxes.iso14496.part15.TierInfoBox", "int", "tierID", "", "void"), 73);
        ajc$tjp_10 = jho.O000000o("method-execution", jho.O000000o("1", "getVisualWidth", "org.mp4parser.boxes.iso14496.part15.TierInfoBox", "", "", "", "int"), 109);
        ajc$tjp_11 = jho.O000000o("method-execution", jho.O000000o("1", "setVisualWidth", "org.mp4parser.boxes.iso14496.part15.TierInfoBox", "int", "visualWidth", "", "void"), 113);
        ajc$tjp_12 = jho.O000000o("method-execution", jho.O000000o("1", "getVisualHeight", "org.mp4parser.boxes.iso14496.part15.TierInfoBox", "", "", "", "int"), 117);
        ajc$tjp_13 = jho.O000000o("method-execution", jho.O000000o("1", "setVisualHeight", "org.mp4parser.boxes.iso14496.part15.TierInfoBox", "int", "visualHeight", "", "void"), 121);
        ajc$tjp_14 = jho.O000000o("method-execution", jho.O000000o("1", "getDiscardable", "org.mp4parser.boxes.iso14496.part15.TierInfoBox", "", "", "", "int"), 125);
        ajc$tjp_15 = jho.O000000o("method-execution", jho.O000000o("1", "setDiscardable", "org.mp4parser.boxes.iso14496.part15.TierInfoBox", "int", "discardable", "", "void"), 129);
        ajc$tjp_16 = jho.O000000o("method-execution", jho.O000000o("1", "getConstantFrameRate", "org.mp4parser.boxes.iso14496.part15.TierInfoBox", "", "", "", "int"), 133);
        ajc$tjp_17 = jho.O000000o("method-execution", jho.O000000o("1", "setConstantFrameRate", "org.mp4parser.boxes.iso14496.part15.TierInfoBox", "int", "constantFrameRate", "", "void"), 137);
        ajc$tjp_18 = jho.O000000o("method-execution", jho.O000000o("1", "getReserved2", "org.mp4parser.boxes.iso14496.part15.TierInfoBox", "", "", "", "int"), 141);
        ajc$tjp_19 = jho.O000000o("method-execution", jho.O000000o("1", "setReserved2", "org.mp4parser.boxes.iso14496.part15.TierInfoBox", "int", "reserved2", "", "void"), 145);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getProfileIndication", "org.mp4parser.boxes.iso14496.part15.TierInfoBox", "", "", "", "int"), 77);
        ajc$tjp_20 = jho.O000000o("method-execution", jho.O000000o("1", "getFrameRate", "org.mp4parser.boxes.iso14496.part15.TierInfoBox", "", "", "", "int"), 149);
        ajc$tjp_21 = jho.O000000o("method-execution", jho.O000000o("1", "setFrameRate", "org.mp4parser.boxes.iso14496.part15.TierInfoBox", "int", "frameRate", "", "void"), 153);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setProfileIndication", "org.mp4parser.boxes.iso14496.part15.TierInfoBox", "int", "profileIndication", "", "void"), 81);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getProfile_compatibility", "org.mp4parser.boxes.iso14496.part15.TierInfoBox", "", "", "", "int"), 85);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setProfile_compatibility", "org.mp4parser.boxes.iso14496.part15.TierInfoBox", "int", "profile_compatibility", "", "void"), 89);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "getLevelIndication", "org.mp4parser.boxes.iso14496.part15.TierInfoBox", "", "", "", "int"), 93);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "setLevelIndication", "org.mp4parser.boxes.iso14496.part15.TierInfoBox", "int", "levelIndication", "", "void"), 97);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "getReserved1", "org.mp4parser.boxes.iso14496.part15.TierInfoBox", "", "", "", "int"), 101);
        ajc$tjp_9 = jho.O000000o("method-execution", jho.O000000o("1", "setReserved1", "org.mp4parser.boxes.iso14496.part15.TierInfoBox", "int", "reserved1", "", "void"), 105);
    }

    public long getContentSize() {
        return 13;
    }

    public TierInfoBox() {
        super("tiri");
    }

    public void getContent(ByteBuffer byteBuffer) {
        jla.O00000Oo(byteBuffer, this.tierID);
        jla.O00000o(byteBuffer, this.profileIndication);
        jla.O00000o(byteBuffer, this.profile_compatibility);
        jla.O00000o(byteBuffer, this.levelIndication);
        jla.O00000o(byteBuffer, this.reserved1);
        jla.O00000Oo(byteBuffer, this.visualWidth);
        jla.O00000Oo(byteBuffer, this.visualHeight);
        jla.O00000o(byteBuffer, (this.discardable << 6) + (this.constantFrameRate << 4) + this.reserved2);
        jla.O00000Oo(byteBuffer, this.frameRate);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        this.tierID = jky.O00000o0(byteBuffer);
        this.profileIndication = jky.O000000o(byteBuffer.get());
        this.profile_compatibility = jky.O000000o(byteBuffer.get());
        this.levelIndication = jky.O000000o(byteBuffer.get());
        this.reserved1 = jky.O000000o(byteBuffer.get());
        this.visualWidth = jky.O00000o0(byteBuffer);
        this.visualHeight = jky.O00000o0(byteBuffer);
        int O000000o2 = jky.O000000o(byteBuffer.get());
        this.discardable = (O000000o2 & 192) >> 6;
        this.constantFrameRate = (O000000o2 & 48) >> 4;
        this.reserved2 = O000000o2 & 15;
        this.frameRate = jky.O00000o0(byteBuffer);
    }

    public int getTierID() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.tierID;
    }

    public int getProfileIndication() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.profileIndication;
    }

    public int getProfile_compatibility() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.profile_compatibility;
    }

    public int getLevelIndication() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.levelIndication;
    }

    public int getReserved1() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.reserved1;
    }

    public int getVisualWidth() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_10, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.visualWidth;
    }

    public int getVisualHeight() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_12, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.visualHeight;
    }

    public int getDiscardable() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_14, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.discardable;
    }

    public int getConstantFrameRate() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_16, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.constantFrameRate;
    }

    public int getReserved2() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_18, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.reserved2;
    }

    public int getFrameRate() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_20, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.frameRate;
    }

    public void setTierID(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.tierID = i;
    }

    public void setProfileIndication(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.profileIndication = i;
    }

    public void setProfile_compatibility(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.profile_compatibility = i;
    }

    public void setLevelIndication(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.levelIndication = i;
    }

    public void setReserved1(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_9, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.reserved1 = i;
    }

    public void setVisualWidth(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_11, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.visualWidth = i;
    }

    public void setVisualHeight(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_13, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.visualHeight = i;
    }

    public void setDiscardable(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_15, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.discardable = i;
    }

    public void setConstantFrameRate(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_17, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.constantFrameRate = i;
    }

    public void setReserved2(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_19, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.reserved2 = i;
    }

    public void setFrameRate(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_21, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.frameRate = i;
    }
}
