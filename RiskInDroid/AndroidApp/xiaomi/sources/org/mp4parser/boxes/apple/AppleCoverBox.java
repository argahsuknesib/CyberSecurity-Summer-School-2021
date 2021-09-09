package org.mp4parser.boxes.apple;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jku;
import java.nio.ByteBuffer;

public class AppleCoverBox extends AppleDataBox {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private byte[] data;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("AppleCoverBox.java", AppleCoverBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getCoverData", "org.mp4parser.boxes.apple.AppleCoverBox", "", "", "", "[B"), 20);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setJpg", "org.mp4parser.boxes.apple.AppleCoverBox", "[B", "data", "", "void"), 24);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "setPng", "org.mp4parser.boxes.apple.AppleCoverBox", "[B", "data", "", "void"), 28);
    }

    public AppleCoverBox() {
        super("covr", 1);
    }

    public byte[] getCoverData() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.data;
    }

    public void setJpg(byte[] bArr) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, bArr);
        jku.O000000o();
        jku.O000000o(O000000o2);
        setImageData(bArr, 13);
    }

    public void setPng(byte[] bArr) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this, bArr);
        jku.O000000o();
        jku.O000000o(O000000o2);
        setImageData(bArr, 14);
    }

    /* access modifiers changed from: protected */
    public byte[] writeData() {
        return this.data;
    }

    /* access modifiers changed from: protected */
    public void parseData(ByteBuffer byteBuffer) {
        this.data = new byte[byteBuffer.limit()];
        byteBuffer.get(this.data);
    }

    /* access modifiers changed from: protected */
    public int getDataLength() {
        return this.data.length;
    }

    private void setImageData(byte[] bArr, int i) {
        this.data = bArr;
        this.dataType = i;
    }
}
