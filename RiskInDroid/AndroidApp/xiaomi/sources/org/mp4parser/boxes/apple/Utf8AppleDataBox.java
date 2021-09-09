package org.mp4parser.boxes.apple;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jku;
import _m_j.jky;
import _m_j.jli;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public abstract class Utf8AppleDataBox extends AppleDataBox {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    String value;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("Utf8AppleDataBox.java", Utf8AppleDataBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getValue", "org.mp4parser.boxes.apple.Utf8AppleDataBox", "", "", "", "java.lang.String"), 20);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setValue", "org.mp4parser.boxes.apple.Utf8AppleDataBox", "java.lang.String", "value", "", "void"), 28);
    }

    protected Utf8AppleDataBox(String str) {
        super(str, 1);
    }

    public String getValue() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        if (!isParsed()) {
            parseDetails();
        }
        return this.value;
    }

    public void setValue(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.value = str;
    }

    public byte[] writeData() {
        return jli.O000000o(this.value);
    }

    /* access modifiers changed from: protected */
    public int getDataLength() {
        return this.value.getBytes(Charset.forName("UTF-8")).length;
    }

    /* access modifiers changed from: protected */
    public void parseData(ByteBuffer byteBuffer) {
        this.value = jky.O000000o(byteBuffer, byteBuffer.remaining());
    }
}
