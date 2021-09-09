package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jhm;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;

public class MovieFragmentRandomAccessOffsetBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private long mfraSize;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("MovieFragmentRandomAccessOffsetBox.java", MovieFragmentRandomAccessOffsetBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getMfraSize", "org.mp4parser.boxes.iso14496.part12.MovieFragmentRandomAccessOffsetBox", "", "", "", "long"), 56);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setMfraSize", "org.mp4parser.boxes.iso14496.part12.MovieFragmentRandomAccessOffsetBox", "long", "mfraSize", "", "void"), 60);
    }

    public long getContentSize() {
        return 8;
    }

    public MovieFragmentRandomAccessOffsetBox() {
        super("mfro");
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.mfraSize = jky.O000000o(byteBuffer);
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O00000Oo(byteBuffer, this.mfraSize);
    }

    public long getMfraSize() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.mfraSize;
    }

    public void setMfraSize(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.mfraSize = j;
    }
}
