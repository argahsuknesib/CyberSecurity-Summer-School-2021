package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhc;
import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import _m_j.jli;
import java.nio.ByteBuffer;

public class SchemeTypeBox extends jkp {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    String schemeType = "    ";
    String schemeUri = null;
    long schemeVersion;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("SchemeTypeBox.java", SchemeTypeBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getSchemeType", "org.mp4parser.boxes.iso14496.part12.SchemeTypeBox", "", "", "", "java.lang.String"), 44);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setSchemeType", "org.mp4parser.boxes.iso14496.part12.SchemeTypeBox", "java.lang.String", "schemeType", "", "void"), 48);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getSchemeVersion", "org.mp4parser.boxes.iso14496.part12.SchemeTypeBox", "", "", "", "long"), 53);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setSchemeVersion", "org.mp4parser.boxes.iso14496.part12.SchemeTypeBox", "int", "schemeVersion", "", "void"), 57);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getSchemeUri", "org.mp4parser.boxes.iso14496.part12.SchemeTypeBox", "", "", "", "java.lang.String"), 61);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setSchemeUri", "org.mp4parser.boxes.iso14496.part12.SchemeTypeBox", "java.lang.String", "schemeUri", "", "void"), 65);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part12.SchemeTypeBox", "", "", "", "java.lang.String"), 93);
    }

    public SchemeTypeBox() {
        super("schm");
    }

    public String getSchemeType() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.schemeType;
    }

    public void setSchemeType(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.schemeType = str;
    }

    public long getSchemeVersion() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.schemeVersion;
    }

    public String getSchemeUri() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.schemeUri;
    }

    public void setSchemeUri(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.schemeUri = str;
    }

    public long getContentSize() {
        return (long) (((getFlags() & 1) == 1 ? jli.O00000Oo(this.schemeUri) + 1 : 0) + 12);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.schemeType = jky.O0000OoO(byteBuffer);
        this.schemeVersion = jky.O000000o(byteBuffer);
        if ((getFlags() & 1) == 1) {
            this.schemeUri = jky.O00000oO(byteBuffer);
        }
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(jhc.O000000o(this.schemeType));
        jla.O00000Oo(byteBuffer, this.schemeVersion);
        if ((getFlags() & 1) == 1) {
            byteBuffer.put(jli.O000000o(this.schemeUri));
        }
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "Schema Type Box[" + "schemeUri=" + this.schemeUri + "; " + "schemeType=" + this.schemeType + "; " + "schemeVersion=" + this.schemeVersion + "; " + "]";
    }

    public void setSchemeVersion(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.schemeVersion = (long) i;
    }
}
