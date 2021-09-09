package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jli;
import java.nio.ByteBuffer;

public class XmlBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    String xml = "";

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("XmlBox.java", XmlBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getXml", "org.mp4parser.boxes.iso14496.part12.XmlBox", "", "", "", "java.lang.String"), 20);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setXml", "org.mp4parser.boxes.iso14496.part12.XmlBox", "java.lang.String", "xml", "", "void"), 24);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part12.XmlBox", "", "", "", "java.lang.String"), 46);
    }

    public XmlBox() {
        super("xml ");
    }

    public String getXml() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.xml;
    }

    public void setXml(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.xml = str;
    }

    public long getContentSize() {
        return (long) (jli.O00000Oo(this.xml) + 4);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.xml = jky.O000000o(byteBuffer, byteBuffer.remaining());
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(jli.O000000o(this.xml));
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "XmlBox{xml='" + this.xml + '\'' + '}';
    }
}
