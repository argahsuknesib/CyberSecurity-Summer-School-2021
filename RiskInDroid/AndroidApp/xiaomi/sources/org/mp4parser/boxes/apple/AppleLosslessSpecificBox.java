package org.mp4parser.boxes.apple;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;

public final class AppleLosslessSpecificBox extends jkp {
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
    private long bitRate;
    private int channels;
    private int historyMult;
    private int initialHistory;
    private int kModifier;
    private long maxCodedFrameSize;
    private long maxSamplePerFrame;
    private long sampleRate;
    private int sampleSize;
    private int unknown1;
    private int unknown2;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("AppleLosslessSpecificBox.java", AppleLosslessSpecificBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getMaxSamplePerFrame", "org.mp4parser.boxes.apple.AppleLosslessSpecificBox", "", "", "", "long"), 38);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setMaxSamplePerFrame", "org.mp4parser.boxes.apple.AppleLosslessSpecificBox", "int", "maxSamplePerFrame", "", "void"), 42);
        ajc$tjp_10 = jho.O000000o("method-execution", jho.O000000o("1", "getKModifier", "org.mp4parser.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 78);
        ajc$tjp_11 = jho.O000000o("method-execution", jho.O000000o("1", "setKModifier", "org.mp4parser.boxes.apple.AppleLosslessSpecificBox", "int", "kModifier", "", "void"), 82);
        ajc$tjp_12 = jho.O000000o("method-execution", jho.O000000o("1", "getChannels", "org.mp4parser.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 86);
        ajc$tjp_13 = jho.O000000o("method-execution", jho.O000000o("1", "setChannels", "org.mp4parser.boxes.apple.AppleLosslessSpecificBox", "int", "channels", "", "void"), 90);
        ajc$tjp_14 = jho.O000000o("method-execution", jho.O000000o("1", "getUnknown2", "org.mp4parser.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 94);
        ajc$tjp_15 = jho.O000000o("method-execution", jho.O000000o("1", "setUnknown2", "org.mp4parser.boxes.apple.AppleLosslessSpecificBox", "int", "unknown2", "", "void"), 98);
        ajc$tjp_16 = jho.O000000o("method-execution", jho.O000000o("1", "getMaxCodedFrameSize", "org.mp4parser.boxes.apple.AppleLosslessSpecificBox", "", "", "", "long"), 102);
        ajc$tjp_17 = jho.O000000o("method-execution", jho.O000000o("1", "setMaxCodedFrameSize", "org.mp4parser.boxes.apple.AppleLosslessSpecificBox", "int", "maxCodedFrameSize", "", "void"), 106);
        ajc$tjp_18 = jho.O000000o("method-execution", jho.O000000o("1", "getBitRate", "org.mp4parser.boxes.apple.AppleLosslessSpecificBox", "", "", "", "long"), 110);
        ajc$tjp_19 = jho.O000000o("method-execution", jho.O000000o("1", "setBitRate", "org.mp4parser.boxes.apple.AppleLosslessSpecificBox", "int", "bitRate", "", "void"), 114);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getUnknown1", "org.mp4parser.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 46);
        ajc$tjp_20 = jho.O000000o("method-execution", jho.O000000o("1", "getSampleRate", "org.mp4parser.boxes.apple.AppleLosslessSpecificBox", "", "", "", "long"), 118);
        ajc$tjp_21 = jho.O000000o("method-execution", jho.O000000o("1", "setSampleRate", "org.mp4parser.boxes.apple.AppleLosslessSpecificBox", "int", "sampleRate", "", "void"), 122);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setUnknown1", "org.mp4parser.boxes.apple.AppleLosslessSpecificBox", "int", "unknown1", "", "void"), 50);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getSampleSize", "org.mp4parser.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 54);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setSampleSize", "org.mp4parser.boxes.apple.AppleLosslessSpecificBox", "int", "sampleSize", "", "void"), 58);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "getHistoryMult", "org.mp4parser.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 62);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "setHistoryMult", "org.mp4parser.boxes.apple.AppleLosslessSpecificBox", "int", "historyMult", "", "void"), 66);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "getInitialHistory", "org.mp4parser.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 70);
        ajc$tjp_9 = jho.O000000o("method-execution", jho.O000000o("1", "setInitialHistory", "org.mp4parser.boxes.apple.AppleLosslessSpecificBox", "int", "initialHistory", "", "void"), 74);
    }

    public final long getContentSize() {
        return 28;
    }

    public AppleLosslessSpecificBox() {
        super("alac");
    }

    public final long getMaxSamplePerFrame() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.maxSamplePerFrame;
    }

    public final int getUnknown1() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.unknown1;
    }

    public final int getSampleSize() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.sampleSize;
    }

    public final int getHistoryMult() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.historyMult;
    }

    public final int getInitialHistory() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.initialHistory;
    }

    public final int getKModifier() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_10, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.kModifier;
    }

    public final int getChannels() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_12, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.channels;
    }

    public final int getUnknown2() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_14, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.unknown2;
    }

    public final long getMaxCodedFrameSize() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_16, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.maxCodedFrameSize;
    }

    public final long getBitRate() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_18, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.bitRate;
    }

    public final long getSampleRate() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_20, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.sampleRate;
    }

    public final void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.maxSamplePerFrame = jky.O000000o(byteBuffer);
        this.unknown1 = jky.O000000o(byteBuffer.get());
        this.sampleSize = jky.O000000o(byteBuffer.get());
        this.historyMult = jky.O000000o(byteBuffer.get());
        this.initialHistory = jky.O000000o(byteBuffer.get());
        this.kModifier = jky.O000000o(byteBuffer.get());
        this.channels = jky.O000000o(byteBuffer.get());
        this.unknown2 = jky.O00000o0(byteBuffer);
        this.maxCodedFrameSize = jky.O000000o(byteBuffer);
        this.bitRate = jky.O000000o(byteBuffer);
        this.sampleRate = jky.O000000o(byteBuffer);
    }

    public final void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O00000Oo(byteBuffer, this.maxSamplePerFrame);
        jla.O00000o(byteBuffer, this.unknown1);
        jla.O00000o(byteBuffer, this.sampleSize);
        jla.O00000o(byteBuffer, this.historyMult);
        jla.O00000o(byteBuffer, this.initialHistory);
        jla.O00000o(byteBuffer, this.kModifier);
        jla.O00000o(byteBuffer, this.channels);
        jla.O00000Oo(byteBuffer, this.unknown2);
        jla.O00000Oo(byteBuffer, this.maxCodedFrameSize);
        jla.O00000Oo(byteBuffer, this.bitRate);
        jla.O00000Oo(byteBuffer, this.sampleRate);
    }

    public final void setMaxSamplePerFrame(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.maxSamplePerFrame = (long) i;
    }

    public final void setUnknown1(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.unknown1 = i;
    }

    public final void setSampleSize(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.sampleSize = i;
    }

    public final void setHistoryMult(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.historyMult = i;
    }

    public final void setInitialHistory(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_9, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.initialHistory = i;
    }

    public final void setKModifier(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_11, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.kModifier = i;
    }

    public final void setChannels(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_13, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.channels = i;
    }

    public final void setUnknown2(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_15, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.unknown2 = i;
    }

    public final void setMaxCodedFrameSize(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_17, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.maxCodedFrameSize = (long) i;
    }

    public final void setBitRate(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_19, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.bitRate = (long) i;
    }

    public final void setSampleRate(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_21, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.sampleRate = (long) i;
    }
}
