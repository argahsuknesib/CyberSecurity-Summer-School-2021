package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;

public abstract class ChunkOffsetBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("ChunkOffsetBox.java", ChunkOffsetBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part12.ChunkOffsetBox", "", "", "", "java.lang.String"), 18);
    }

    public abstract long[] getChunkOffsets();

    public abstract void setChunkOffsets(long[] jArr);

    public ChunkOffsetBox(String str) {
        super(str);
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return String.valueOf(getClass().getSimpleName()) + "[entryCount=" + getChunkOffsets().length + "]";
    }
}
