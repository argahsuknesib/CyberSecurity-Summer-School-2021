package org.mp4parser.boxes.apple;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;

public class CleanApertureAtom extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    double height;
    double width;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("CleanApertureAtom.java", CleanApertureAtom.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getWidth", "org.mp4parser.boxes.apple.CleanApertureAtom", "", "", "", "double"), 45);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setWidth", "org.mp4parser.boxes.apple.CleanApertureAtom", "double", "width", "", "void"), 49);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getHeight", "org.mp4parser.boxes.apple.CleanApertureAtom", "", "", "", "double"), 53);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setHeight", "org.mp4parser.boxes.apple.CleanApertureAtom", "double", "height", "", "void"), 57);
    }

    public long getContentSize() {
        return 12;
    }

    public CleanApertureAtom() {
        super("clef");
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O000000o(byteBuffer, this.width);
        jla.O000000o(byteBuffer, this.height);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.width = jky.O0000O0o(byteBuffer);
        this.height = jky.O0000O0o(byteBuffer);
    }

    public double getWidth() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.width;
    }

    public double getHeight() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.height;
    }

    public void setWidth(double d) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, Double.valueOf(d));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.width = d;
    }

    public void setHeight(double d) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, Double.valueOf(d));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.height = d;
    }
}
