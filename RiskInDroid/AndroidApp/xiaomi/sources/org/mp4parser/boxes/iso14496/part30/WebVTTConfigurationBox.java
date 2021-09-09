package org.mp4parser.boxes.iso14496.part30;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkn;
import _m_j.jku;
import _m_j.jky;
import _m_j.jli;
import java.nio.ByteBuffer;

public class WebVTTConfigurationBox extends jkn {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    String config = "";

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("WebVTTConfigurationBox.java", WebVTTConfigurationBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getConfig", "org.mp4parser.boxes.iso14496.part30.WebVTTConfigurationBox", "", "", "", "java.lang.String"), 36);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setConfig", "org.mp4parser.boxes.iso14496.part30.WebVTTConfigurationBox", "java.lang.String", "config", "", "void"), 40);
    }

    public WebVTTConfigurationBox() {
        super("vttC");
    }

    public long getContentSize() {
        return (long) jli.O00000Oo(this.config);
    }

    public void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(jli.O000000o(this.config));
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        this.config = jky.O000000o(byteBuffer, byteBuffer.remaining());
    }

    public String getConfig() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.config;
    }

    public void setConfig(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.config = str;
    }
}
