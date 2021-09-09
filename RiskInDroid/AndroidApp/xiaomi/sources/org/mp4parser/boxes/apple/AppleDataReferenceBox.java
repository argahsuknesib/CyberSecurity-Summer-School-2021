package org.mp4parser.boxes.apple;

import _m_j.jhc;
import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jkv;
import _m_j.jky;
import _m_j.jla;
import _m_j.jli;
import java.nio.ByteBuffer;

public class AppleDataReferenceBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private String dataReference;
    private int dataReferenceSize;
    private String dataReferenceType;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("AppleDataReferenceBox.java", AppleDataReferenceBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getDataReferenceSize", "org.mp4parser.boxes.apple.AppleDataReferenceBox", "", "", "", "long"), 62);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "getDataReferenceType", "org.mp4parser.boxes.apple.AppleDataReferenceBox", "", "", "", "java.lang.String"), 66);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getDataReference", "org.mp4parser.boxes.apple.AppleDataReferenceBox", "", "", "", "java.lang.String"), 70);
    }

    public AppleDataReferenceBox() {
        super("rdrf");
    }

    public long getContentSize() {
        return (long) (this.dataReferenceSize + 12);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.dataReferenceType = jky.O0000OoO(byteBuffer);
        this.dataReferenceSize = jkv.O000000o(jky.O000000o(byteBuffer));
        this.dataReference = jky.O000000o(byteBuffer, this.dataReferenceSize);
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(jhc.O000000o(this.dataReferenceType));
        jla.O00000Oo(byteBuffer, (long) this.dataReferenceSize);
        byteBuffer.put(jli.O000000o(this.dataReference));
    }

    public long getDataReferenceSize() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return (long) this.dataReferenceSize;
    }

    public String getDataReferenceType() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.dataReferenceType;
    }

    public String getDataReference() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.dataReference;
    }
}
