package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;

public class VideoMediaHeaderBox extends AbstractMediaHeaderBox {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private int graphicsmode = 0;
    private int[] opcolor = new int[3];

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("VideoMediaHeaderBox.java", VideoMediaHeaderBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getGraphicsmode", "org.mp4parser.boxes.iso14496.part12.VideoMediaHeaderBox", "", "", "", "int"), 39);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setGraphicsmode", "org.mp4parser.boxes.iso14496.part12.VideoMediaHeaderBox", "int", "graphicsmode", "", "void"), 43);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getOpcolor", "org.mp4parser.boxes.iso14496.part12.VideoMediaHeaderBox", "", "", "", "[I"), 47);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setOpcolor", "org.mp4parser.boxes.iso14496.part12.VideoMediaHeaderBox", "[I", "opcolor", "", "void"), 51);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part12.VideoMediaHeaderBox", "", "", "", "java.lang.String"), 78);
    }

    public long getContentSize() {
        return 12;
    }

    public VideoMediaHeaderBox() {
        super("vmhd");
        setFlags(1);
    }

    public int getGraphicsmode() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.graphicsmode;
    }

    public int[] getOpcolor() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.opcolor;
    }

    public void setOpcolor(int[] iArr) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, iArr);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.opcolor = iArr;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.graphicsmode = jky.O00000o0(byteBuffer);
        this.opcolor = new int[3];
        for (int i = 0; i < 3; i++) {
            this.opcolor[i] = jky.O00000o0(byteBuffer);
        }
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O00000Oo(byteBuffer, this.graphicsmode);
        for (int O00000Oo : this.opcolor) {
            jla.O00000Oo(byteBuffer, O00000Oo);
        }
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "VideoMediaHeaderBox[graphicsmode=" + getGraphicsmode() + ";opcolor0=" + getOpcolor()[0] + ";opcolor1=" + getOpcolor()[1] + ";opcolor2=" + getOpcolor()[2] + "]";
    }

    public void setGraphicsmode(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.graphicsmode = i;
    }
}
