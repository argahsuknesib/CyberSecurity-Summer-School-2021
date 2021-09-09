package org.mp4parser.boxes.apple;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;

public class AppleDataRateBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private long dataRate;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("AppleDataRateBox.java", AppleDataRateBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getDataRate", "org.mp4parser.boxes.apple.AppleDataRateBox", "", "", "", "long"), 53);
    }

    public long getContentSize() {
        return 8;
    }

    public AppleDataRateBox() {
        super("rmdr");
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.dataRate = jky.O000000o(byteBuffer);
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O00000Oo(byteBuffer, this.dataRate);
    }

    public long getDataRate() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.dataRate;
    }
}
