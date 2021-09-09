package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;

public class SoundMediaHeaderBox extends AbstractMediaHeaderBox {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private float balance;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("SoundMediaHeaderBox.java", SoundMediaHeaderBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getBalance", "org.mp4parser.boxes.iso14496.part12.SoundMediaHeaderBox", "", "", "", "float"), 36);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part12.SoundMediaHeaderBox", "", "", "", "java.lang.String"), 58);
    }

    public long getContentSize() {
        return 8;
    }

    public SoundMediaHeaderBox() {
        super("smhd");
    }

    public float getBalance() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.balance;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.balance = jky.O0000Oo0(byteBuffer);
        jky.O00000o0(byteBuffer);
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O00000o0(byteBuffer, (double) this.balance);
        jla.O00000Oo(byteBuffer, 0);
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "SoundMediaHeaderBox[balance=" + getBalance() + "]";
    }
}
