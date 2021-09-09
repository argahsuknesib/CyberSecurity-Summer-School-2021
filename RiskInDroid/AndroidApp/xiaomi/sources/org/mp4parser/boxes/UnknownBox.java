package org.mp4parser.boxes;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkn;
import _m_j.jku;
import java.nio.ByteBuffer;

public class UnknownBox extends jkn {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    ByteBuffer data;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("UnknownBox.java", UnknownBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getData", "org.mp4parser.boxes.UnknownBox", "", "", "", "java.nio.ByteBuffer"), 52);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setData", "org.mp4parser.boxes.UnknownBox", "java.nio.ByteBuffer", "data", "", "void"), 56);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.UnknownBox", "", "", "", "java.lang.String"), 61);
    }

    public UnknownBox(String str) {
        super(str);
    }

    public long getContentSize() {
        return (long) this.data.limit();
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        this.data = byteBuffer;
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
    }

    public void getContent(ByteBuffer byteBuffer) {
        this.data.rewind();
        byteBuffer.put(this.data);
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

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "UnknownBox{type=" + this.type + '}';
    }
}
