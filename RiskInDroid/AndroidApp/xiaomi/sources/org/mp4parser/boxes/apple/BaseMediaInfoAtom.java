package org.mp4parser.boxes.apple;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;

public class BaseMediaInfoAtom extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_10 = null;
    private static final jhf.O000000o ajc$tjp_11 = null;
    private static final jhf.O000000o ajc$tjp_12 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private static final jhf.O000000o ajc$tjp_7 = null;
    private static final jhf.O000000o ajc$tjp_8 = null;
    private static final jhf.O000000o ajc$tjp_9 = null;
    short balance;
    short graphicsMode = 64;
    int opColorB = 32768;
    int opColorG = 32768;
    int opColorR = 32768;
    short reserved;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("BaseMediaInfoAtom.java", BaseMediaInfoAtom.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getGraphicsMode", "org.mp4parser.boxes.apple.BaseMediaInfoAtom", "", "", "", "short"), 54);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setGraphicsMode", "org.mp4parser.boxes.apple.BaseMediaInfoAtom", "short", "graphicsMode", "", "void"), 58);
        ajc$tjp_10 = jho.O000000o("method-execution", jho.O000000o("1", "getReserved", "org.mp4parser.boxes.apple.BaseMediaInfoAtom", "", "", "", "short"), 94);
        ajc$tjp_11 = jho.O000000o("method-execution", jho.O000000o("1", "setReserved", "org.mp4parser.boxes.apple.BaseMediaInfoAtom", "short", "reserved", "", "void"), 98);
        ajc$tjp_12 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.apple.BaseMediaInfoAtom", "", "", "", "java.lang.String"), 103);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getOpColorR", "org.mp4parser.boxes.apple.BaseMediaInfoAtom", "", "", "", "int"), 62);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setOpColorR", "org.mp4parser.boxes.apple.BaseMediaInfoAtom", "int", "opColorR", "", "void"), 66);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getOpColorG", "org.mp4parser.boxes.apple.BaseMediaInfoAtom", "", "", "", "int"), 70);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setOpColorG", "org.mp4parser.boxes.apple.BaseMediaInfoAtom", "int", "opColorG", "", "void"), 74);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "getOpColorB", "org.mp4parser.boxes.apple.BaseMediaInfoAtom", "", "", "", "int"), 78);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "setOpColorB", "org.mp4parser.boxes.apple.BaseMediaInfoAtom", "int", "opColorB", "", "void"), 82);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "getBalance", "org.mp4parser.boxes.apple.BaseMediaInfoAtom", "", "", "", "short"), 86);
        ajc$tjp_9 = jho.O000000o("method-execution", jho.O000000o("1", "setBalance", "org.mp4parser.boxes.apple.BaseMediaInfoAtom", "short", "balance", "", "void"), 90);
    }

    public long getContentSize() {
        return 16;
    }

    public BaseMediaInfoAtom() {
        super("gmin");
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.putShort(this.graphicsMode);
        jla.O00000Oo(byteBuffer, this.opColorR);
        jla.O00000Oo(byteBuffer, this.opColorG);
        jla.O00000Oo(byteBuffer, this.opColorB);
        byteBuffer.putShort(this.balance);
        byteBuffer.putShort(this.reserved);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.graphicsMode = byteBuffer.getShort();
        this.opColorR = jky.O00000o0(byteBuffer);
        this.opColorG = jky.O00000o0(byteBuffer);
        this.opColorB = jky.O00000o0(byteBuffer);
        this.balance = byteBuffer.getShort();
        this.reserved = byteBuffer.getShort();
    }

    public short getGraphicsMode() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.graphicsMode;
    }

    public int getOpColorR() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.opColorR;
    }

    public int getOpColorG() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.opColorG;
    }

    public int getOpColorB() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.opColorB;
    }

    public short getBalance() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.balance;
    }

    public short getReserved() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_10, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.reserved;
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_12, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "BaseMediaInfoAtom{graphicsMode=" + ((int) this.graphicsMode) + ", opColorR=" + this.opColorR + ", opColorG=" + this.opColorG + ", opColorB=" + this.opColorB + ", balance=" + ((int) this.balance) + ", reserved=" + ((int) this.reserved) + '}';
    }

    public void setGraphicsMode(short s) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, Short.valueOf(s));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.graphicsMode = s;
    }

    public void setOpColorR(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.opColorR = i;
    }

    public void setOpColorG(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.opColorG = i;
    }

    public void setOpColorB(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.opColorB = i;
    }

    public void setBalance(short s) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_9, this, this, Short.valueOf(s));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.balance = s;
    }

    public void setReserved(short s) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_11, this, this, Short.valueOf(s));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.reserved = s;
    }
}
