package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jku;
import _m_j.jkv;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;

public class StaticChunkOffsetBox extends ChunkOffsetBox {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private long[] chunkOffsets = new long[0];

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("StaticChunkOffsetBox.java", StaticChunkOffsetBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getChunkOffsets", "org.mp4parser.boxes.iso14496.part12.StaticChunkOffsetBox", "", "", "", "[J"), 38);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setChunkOffsets", "org.mp4parser.boxes.iso14496.part12.StaticChunkOffsetBox", "[J", "chunkOffsets", "", "void"), 43);
    }

    public StaticChunkOffsetBox() {
        super("stco");
    }

    public long[] getChunkOffsets() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.chunkOffsets;
    }

    public void setChunkOffsets(long[] jArr) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, jArr);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.chunkOffsets = jArr;
    }

    public long getContentSize() {
        return (long) ((this.chunkOffsets.length * 4) + 8);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        int O000000o2 = jkv.O000000o(jky.O000000o(byteBuffer));
        this.chunkOffsets = new long[O000000o2];
        for (int i = 0; i < O000000o2; i++) {
            this.chunkOffsets[i] = jky.O000000o(byteBuffer);
        }
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O00000Oo(byteBuffer, (long) this.chunkOffsets.length);
        for (long O00000Oo : this.chunkOffsets) {
            jla.O00000Oo(byteBuffer, O00000Oo);
        }
    }
}
