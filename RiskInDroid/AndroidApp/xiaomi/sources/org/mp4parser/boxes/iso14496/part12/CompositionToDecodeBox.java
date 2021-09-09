package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import java.nio.ByteBuffer;

public class CompositionToDecodeBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private static final jhf.O000000o ajc$tjp_7 = null;
    private static final jhf.O000000o ajc$tjp_8 = null;
    private static final jhf.O000000o ajc$tjp_9 = null;
    int compositionOffsetToDisplayOffsetShift;
    int displayEndTime;
    int displayStartTime;
    int greatestDisplayOffset;
    int leastDisplayOffset;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("CompositionToDecodeBox.java", CompositionToDecodeBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getCompositionOffsetToDisplayOffsetShift", "org.mp4parser.boxes.iso14496.part12.CompositionToDecodeBox", "", "", "", "int"), 60);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setCompositionOffsetToDisplayOffsetShift", "org.mp4parser.boxes.iso14496.part12.CompositionToDecodeBox", "int", "compositionOffsetToDisplayOffsetShift", "", "void"), 64);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getLeastDisplayOffset", "org.mp4parser.boxes.iso14496.part12.CompositionToDecodeBox", "", "", "", "int"), 68);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setLeastDisplayOffset", "org.mp4parser.boxes.iso14496.part12.CompositionToDecodeBox", "int", "leastDisplayOffset", "", "void"), 72);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getGreatestDisplayOffset", "org.mp4parser.boxes.iso14496.part12.CompositionToDecodeBox", "", "", "", "int"), 76);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setGreatestDisplayOffset", "org.mp4parser.boxes.iso14496.part12.CompositionToDecodeBox", "int", "greatestDisplayOffset", "", "void"), 80);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "getDisplayStartTime", "org.mp4parser.boxes.iso14496.part12.CompositionToDecodeBox", "", "", "", "int"), 84);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "setDisplayStartTime", "org.mp4parser.boxes.iso14496.part12.CompositionToDecodeBox", "int", "displayStartTime", "", "void"), 88);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "getDisplayEndTime", "org.mp4parser.boxes.iso14496.part12.CompositionToDecodeBox", "", "", "", "int"), 92);
        ajc$tjp_9 = jho.O000000o("method-execution", jho.O000000o("1", "setDisplayEndTime", "org.mp4parser.boxes.iso14496.part12.CompositionToDecodeBox", "int", "displayEndTime", "", "void"), 96);
    }

    public long getContentSize() {
        return 24;
    }

    public CompositionToDecodeBox() {
        super("cslg");
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.compositionOffsetToDisplayOffsetShift = byteBuffer.getInt();
        this.leastDisplayOffset = byteBuffer.getInt();
        this.greatestDisplayOffset = byteBuffer.getInt();
        this.displayStartTime = byteBuffer.getInt();
        this.displayEndTime = byteBuffer.getInt();
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.putInt(this.compositionOffsetToDisplayOffsetShift);
        byteBuffer.putInt(this.leastDisplayOffset);
        byteBuffer.putInt(this.greatestDisplayOffset);
        byteBuffer.putInt(this.displayStartTime);
        byteBuffer.putInt(this.displayEndTime);
    }

    public int getCompositionOffsetToDisplayOffsetShift() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.compositionOffsetToDisplayOffsetShift;
    }

    public int getLeastDisplayOffset() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.leastDisplayOffset;
    }

    public int getGreatestDisplayOffset() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.greatestDisplayOffset;
    }

    public int getDisplayStartTime() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.displayStartTime;
    }

    public int getDisplayEndTime() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.displayEndTime;
    }

    public void setCompositionOffsetToDisplayOffsetShift(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.compositionOffsetToDisplayOffsetShift = i;
    }

    public void setLeastDisplayOffset(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.leastDisplayOffset = i;
    }

    public void setGreatestDisplayOffset(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.greatestDisplayOffset = i;
    }

    public void setDisplayStartTime(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.displayStartTime = i;
    }

    public void setDisplayEndTime(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_9, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.displayEndTime = i;
    }
}
