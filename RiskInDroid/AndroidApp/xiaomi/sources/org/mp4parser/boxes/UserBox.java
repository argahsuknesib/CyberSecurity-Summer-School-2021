package org.mp4parser.boxes;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkn;
import _m_j.jku;
import java.nio.ByteBuffer;

public class UserBox extends jkn {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    byte[] data;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("UserBox.java", UserBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.UserBox", "", "", "", "java.lang.String"), 40);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "getData", "org.mp4parser.boxes.UserBox", "", "", "", "[B"), 47);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "setData", "org.mp4parser.boxes.UserBox", "[B", "data", "", "void"), 51);
    }

    public UserBox(byte[] bArr) {
        super("uuid", bArr);
    }

    public long getContentSize() {
        return (long) this.data.length;
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "UserBox[type=" + getType() + ";userType=" + new String(getUserType()) + ";contentLength=" + this.data.length + "]";
    }

    public byte[] getData() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.data;
    }

    public void setData(byte[] bArr) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this, bArr);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.data = bArr;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        this.data = new byte[byteBuffer.remaining()];
        byteBuffer.get(this.data);
    }

    public void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(this.data);
    }
}
