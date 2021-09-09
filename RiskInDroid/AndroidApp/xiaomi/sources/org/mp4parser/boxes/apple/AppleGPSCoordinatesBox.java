package org.mp4parser.boxes.apple;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkn;
import _m_j.jku;
import _m_j.jli;
import java.nio.ByteBuffer;

public class AppleGPSCoordinatesBox extends jkn {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    String coords;
    int lang = 5575;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("AppleGPSCoordinatesBox.java", AppleGPSCoordinatesBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getValue", "org.mp4parser.boxes.apple.AppleGPSCoordinatesBox", "", "", "", "java.lang.String"), 22);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setValue", "org.mp4parser.boxes.apple.AppleGPSCoordinatesBox", "java.lang.String", "iso6709String", "", "void"), 26);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.apple.AppleGPSCoordinatesBox", "", "", "", "java.lang.String"), 52);
    }

    public AppleGPSCoordinatesBox() {
        super("©xyz");
    }

    public String getValue() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.coords;
    }

    public void setValue(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.lang = 5575;
        this.coords = str;
    }

    public long getContentSize() {
        return (long) (jli.O00000Oo(this.coords) + 4);
    }

    public void getContent(ByteBuffer byteBuffer) {
        byteBuffer.putShort((short) this.coords.length());
        byteBuffer.putShort((short) this.lang);
        byteBuffer.put(jli.O000000o(this.coords));
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        int i = byteBuffer.getShort();
        this.lang = byteBuffer.getShort();
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        this.coords = jli.O000000o(bArr);
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "AppleGPSCoordinatesBox[" + this.coords + "]";
    }
}
