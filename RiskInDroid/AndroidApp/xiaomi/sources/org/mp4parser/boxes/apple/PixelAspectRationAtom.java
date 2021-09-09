package org.mp4parser.boxes.apple;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkn;
import _m_j.jku;
import java.nio.ByteBuffer;

public class PixelAspectRationAtom extends jkn {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private int hSpacing;
    private int vSpacing;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("PixelAspectRationAtom.java", PixelAspectRationAtom.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "gethSpacing", "org.mp4parser.boxes.apple.PixelAspectRationAtom", "", "", "", "int"), 31);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "sethSpacing", "org.mp4parser.boxes.apple.PixelAspectRationAtom", "int", "hSpacing", "", "void"), 35);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getvSpacing", "org.mp4parser.boxes.apple.PixelAspectRationAtom", "", "", "", "int"), 39);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setvSpacing", "org.mp4parser.boxes.apple.PixelAspectRationAtom", "int", "vSpacing", "", "void"), 43);
    }

    public long getContentSize() {
        return 8;
    }

    public PixelAspectRationAtom() {
        super("pasp");
    }

    public int gethSpacing() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.hSpacing;
    }

    public int getvSpacing() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.vSpacing;
    }

    public void getContent(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.hSpacing);
        byteBuffer.putInt(this.vSpacing);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        this.hSpacing = byteBuffer.getInt();
        this.vSpacing = byteBuffer.getInt();
    }

    public void sethSpacing(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.hSpacing = i;
    }

    public void setvSpacing(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.vSpacing = i;
    }
}
