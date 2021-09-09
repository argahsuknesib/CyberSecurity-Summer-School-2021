package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jhm;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;

public class MovieFragmentHeaderBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private long sequenceNumber;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("MovieFragmentHeaderBox.java", MovieFragmentHeaderBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getSequenceNumber", "org.mp4parser.boxes.iso14496.part12.MovieFragmentHeaderBox", "", "", "", "long"), 59);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setSequenceNumber", "org.mp4parser.boxes.iso14496.part12.MovieFragmentHeaderBox", "long", "sequenceNumber", "", "void"), 63);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part12.MovieFragmentHeaderBox", "", "", "", "java.lang.String"), 68);
    }

    public long getContentSize() {
        return 8;
    }

    public MovieFragmentHeaderBox() {
        super("mfhd");
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O00000Oo(byteBuffer, this.sequenceNumber);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.sequenceNumber = jky.O000000o(byteBuffer);
    }

    public long getSequenceNumber() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.sequenceNumber;
    }

    public void setSequenceNumber(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.sequenceNumber = j;
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "MovieFragmentHeaderBox{sequenceNumber=" + this.sequenceNumber + '}';
    }
}
