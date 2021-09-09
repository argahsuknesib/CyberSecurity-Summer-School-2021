package org.mp4parser.boxes.apple;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkn;
import _m_j.jku;
import android.support.v4.app.NotificationCompat;
import java.nio.ByteBuffer;

public class GenericMediaHeaderTextAtom extends jkn {
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
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private static final jhf.O000000o ajc$tjp_7 = null;
    private static final jhf.O000000o ajc$tjp_8 = null;
    private static final jhf.O000000o ajc$tjp_9 = null;
    int unknown_1 = 65536;
    int unknown_2;
    int unknown_3;
    int unknown_4;
    int unknown_5 = 65536;
    int unknown_6;
    int unknown_7;
    int unknown_8;
    int unknown_9 = 1073741824;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("GenericMediaHeaderTextAtom.java", GenericMediaHeaderTextAtom.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getUnknown_1", "org.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "", "", "", "int"), 60);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setUnknown_1", "org.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "int", "unknown_1", "", "void"), 64);
        ajc$tjp_10 = jho.O000000o("method-execution", jho.O000000o("1", "getUnknown_6", "org.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "", "", "", "int"), 100);
        ajc$tjp_11 = jho.O000000o("method-execution", jho.O000000o("1", "setUnknown_6", "org.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "int", "unknown_6", "", "void"), 104);
        ajc$tjp_12 = jho.O000000o("method-execution", jho.O000000o("1", "getUnknown_7", "org.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "", "", "", "int"), 108);
        ajc$tjp_13 = jho.O000000o("method-execution", jho.O000000o("1", "setUnknown_7", "org.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "int", "unknown_7", "", "void"), 112);
        ajc$tjp_14 = jho.O000000o("method-execution", jho.O000000o("1", "getUnknown_8", "org.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "", "", "", "int"), 116);
        ajc$tjp_15 = jho.O000000o("method-execution", jho.O000000o("1", "setUnknown_8", "org.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "int", "unknown_8", "", "void"), 120);
        ajc$tjp_16 = jho.O000000o("method-execution", jho.O000000o("1", "getUnknown_9", "org.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "", "", "", "int"), 124);
        ajc$tjp_17 = jho.O000000o("method-execution", jho.O000000o("1", "setUnknown_9", "org.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "int", "unknown_9", "", "void"), (int) NotificationCompat.FLAG_HIGH_PRIORITY);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getUnknown_2", "org.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "", "", "", "int"), 68);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setUnknown_2", "org.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "int", "unknown_2", "", "void"), 72);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getUnknown_3", "org.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "", "", "", "int"), 76);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setUnknown_3", "org.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "int", "unknown_3", "", "void"), 80);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "getUnknown_4", "org.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "", "", "", "int"), 84);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "setUnknown_4", "org.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "int", "unknown_4", "", "void"), 88);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "getUnknown_5", "org.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "", "", "", "int"), 92);
        ajc$tjp_9 = jho.O000000o("method-execution", jho.O000000o("1", "setUnknown_5", "org.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "int", "unknown_5", "", "void"), 96);
    }

    public long getContentSize() {
        return 36;
    }

    public GenericMediaHeaderTextAtom() {
        super("text");
    }

    public void getContent(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.unknown_1);
        byteBuffer.putInt(this.unknown_2);
        byteBuffer.putInt(this.unknown_3);
        byteBuffer.putInt(this.unknown_4);
        byteBuffer.putInt(this.unknown_5);
        byteBuffer.putInt(this.unknown_6);
        byteBuffer.putInt(this.unknown_7);
        byteBuffer.putInt(this.unknown_8);
        byteBuffer.putInt(this.unknown_9);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        this.unknown_1 = byteBuffer.getInt();
        this.unknown_2 = byteBuffer.getInt();
        this.unknown_3 = byteBuffer.getInt();
        this.unknown_4 = byteBuffer.getInt();
        this.unknown_5 = byteBuffer.getInt();
        this.unknown_6 = byteBuffer.getInt();
        this.unknown_7 = byteBuffer.getInt();
        this.unknown_8 = byteBuffer.getInt();
        this.unknown_9 = byteBuffer.getInt();
    }

    public int getUnknown_1() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.unknown_1;
    }

    public int getUnknown_2() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.unknown_2;
    }

    public int getUnknown_3() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.unknown_3;
    }

    public int getUnknown_4() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.unknown_4;
    }

    public int getUnknown_5() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.unknown_5;
    }

    public int getUnknown_6() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_10, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.unknown_6;
    }

    public int getUnknown_7() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_12, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.unknown_7;
    }

    public int getUnknown_8() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_14, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.unknown_8;
    }

    public int getUnknown_9() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_16, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.unknown_9;
    }

    public void setUnknown_1(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.unknown_1 = i;
    }

    public void setUnknown_2(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.unknown_2 = i;
    }

    public void setUnknown_3(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.unknown_3 = i;
    }

    public void setUnknown_4(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.unknown_4 = i;
    }

    public void setUnknown_5(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_9, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.unknown_5 = i;
    }

    public void setUnknown_6(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_11, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.unknown_6 = i;
    }

    public void setUnknown_7(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_13, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.unknown_7 = i;
    }

    public void setUnknown_8(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_15, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.unknown_8 = i;
    }

    public void setUnknown_9(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_17, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.unknown_9 = i;
    }
}
