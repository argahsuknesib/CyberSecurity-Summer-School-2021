package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkn;
import _m_j.jku;
import java.nio.ByteBuffer;

public class ItemDataBox extends jkn {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    ByteBuffer data = ByteBuffer.allocate(0);

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("ItemDataBox.java", ItemDataBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getData", "org.mp4parser.boxes.iso14496.part12.ItemDataBox", "", "", "", "java.nio.ByteBuffer"), 19);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setData", "org.mp4parser.boxes.iso14496.part12.ItemDataBox", "java.nio.ByteBuffer", "data", "", "void"), 23);
    }

    public ItemDataBox() {
        super("idat");
    }

    public ByteBuffer getData() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.data;
    }

    public void setData(ByteBuffer byteBuffer) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, byteBuffer);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.data = byteBuffer;
    }

    public long getContentSize() {
        return (long) this.data.limit();
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        this.data = byteBuffer.slice();
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
    }

    public void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(this.data);
    }
}
