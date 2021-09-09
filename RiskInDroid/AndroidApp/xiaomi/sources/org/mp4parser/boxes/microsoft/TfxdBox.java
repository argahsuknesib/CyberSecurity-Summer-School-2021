package org.mp4parser.boxes.microsoft;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;

public class TfxdBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    public long fragmentAbsoluteDuration;
    public long fragmentAbsoluteTime;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("TfxdBox.java", TfxdBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getFragmentAbsoluteTime", "org.mp4parser.boxes.microsoft.TfxdBox", "", "", "", "long"), 79);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "getFragmentAbsoluteDuration", "org.mp4parser.boxes.microsoft.TfxdBox", "", "", "", "long"), 83);
    }

    public TfxdBox() {
        super("uuid");
    }

    public byte[] getUserType() {
        return new byte[]{109, 29, -101, 5, 66, -43, 68, -26, Byte.MIN_VALUE, -30, 20, 29, -81, -9, 87, -78};
    }

    public long getContentSize() {
        return (long) (getVersion() == 1 ? 20 : 12);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            this.fragmentAbsoluteTime = jky.O00000oo(byteBuffer);
            this.fragmentAbsoluteDuration = jky.O00000oo(byteBuffer);
            return;
        }
        this.fragmentAbsoluteTime = jky.O000000o(byteBuffer);
        this.fragmentAbsoluteDuration = jky.O000000o(byteBuffer);
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            jla.O000000o(byteBuffer, this.fragmentAbsoluteTime);
            jla.O000000o(byteBuffer, this.fragmentAbsoluteDuration);
            return;
        }
        jla.O00000Oo(byteBuffer, this.fragmentAbsoluteTime);
        jla.O00000Oo(byteBuffer, this.fragmentAbsoluteDuration);
    }

    public long getFragmentAbsoluteTime() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.fragmentAbsoluteTime;
    }

    public long getFragmentAbsoluteDuration() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.fragmentAbsoluteDuration;
    }
}
