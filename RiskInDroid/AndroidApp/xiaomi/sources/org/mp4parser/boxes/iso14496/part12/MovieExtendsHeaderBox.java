package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jhm;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;

public class MovieExtendsHeaderBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private long fragmentDuration;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("MovieExtendsHeaderBox.java", MovieExtendsHeaderBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getFragmentDuration", "org.mp4parser.boxes.iso14496.part12.MovieExtendsHeaderBox", "", "", "", "long"), 65);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setFragmentDuration", "org.mp4parser.boxes.iso14496.part12.MovieExtendsHeaderBox", "long", "fragmentDuration", "", "void"), 69);
    }

    public MovieExtendsHeaderBox() {
        super("mehd");
    }

    public long getContentSize() {
        return (long) (getVersion() == 1 ? 12 : 8);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.fragmentDuration = getVersion() == 1 ? jky.O00000oo(byteBuffer) : jky.O000000o(byteBuffer);
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            jla.O000000o(byteBuffer, this.fragmentDuration);
        } else {
            jla.O00000Oo(byteBuffer, this.fragmentDuration);
        }
    }

    public long getFragmentDuration() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.fragmentDuration;
    }

    public void setFragmentDuration(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.fragmentDuration = j;
    }
}
