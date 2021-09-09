package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhc;
import _m_j.jhf;
import _m_j.jho;
import _m_j.jkn;
import _m_j.jku;
import _m_j.jky;
import java.nio.ByteBuffer;

public class OriginalFormatBox extends jkn {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private String dataFormat = "    ";

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("OriginalFormatBox.java", OriginalFormatBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getDataFormat", "org.mp4parser.boxes.iso14496.part12.OriginalFormatBox", "", "", "", "java.lang.String"), 42);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setDataFormat", "org.mp4parser.boxes.iso14496.part12.OriginalFormatBox", "java.lang.String", "dataFormat", "", "void"), 47);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part12.OriginalFormatBox", "", "", "", "java.lang.String"), 67);
    }

    public long getContentSize() {
        return 4;
    }

    public OriginalFormatBox() {
        super("frma");
    }

    public String getDataFormat() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.dataFormat;
    }

    public void setDataFormat(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.dataFormat = str;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        this.dataFormat = jky.O0000OoO(byteBuffer);
    }

    public void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(jhc.O000000o(this.dataFormat));
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "OriginalFormatBox[dataFormat=" + getDataFormat() + "]";
    }
}
