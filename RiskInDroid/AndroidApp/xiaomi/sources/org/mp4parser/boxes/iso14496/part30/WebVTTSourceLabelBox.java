package org.mp4parser.boxes.iso14496.part30;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkn;
import _m_j.jku;
import _m_j.jky;
import _m_j.jli;
import java.nio.ByteBuffer;

public class WebVTTSourceLabelBox extends jkn {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    String sourceLabel = "";

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("WebVTTSourceLabelBox.java", WebVTTSourceLabelBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getSourceLabel", "org.mp4parser.boxes.iso14496.part30.WebVTTSourceLabelBox", "", "", "", "java.lang.String"), 37);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setSourceLabel", "org.mp4parser.boxes.iso14496.part30.WebVTTSourceLabelBox", "java.lang.String", "sourceLabel", "", "void"), 41);
    }

    public WebVTTSourceLabelBox() {
        super("vlab");
    }

    public long getContentSize() {
        return (long) jli.O00000Oo(this.sourceLabel);
    }

    public void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(jli.O000000o(this.sourceLabel));
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        this.sourceLabel = jky.O000000o(byteBuffer, byteBuffer.remaining());
    }

    public String getSourceLabel() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.sourceLabel;
    }

    public void setSourceLabel(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.sourceLabel = str;
    }
}
