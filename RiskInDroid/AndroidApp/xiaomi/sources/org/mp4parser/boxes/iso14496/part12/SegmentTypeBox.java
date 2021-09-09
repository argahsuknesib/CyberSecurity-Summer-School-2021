package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhc;
import _m_j.jhf;
import _m_j.jhm;
import _m_j.jho;
import _m_j.jkn;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SegmentTypeBox extends jkn {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private List<String> compatibleBrands = Collections.emptyList();
    private String majorBrand;
    private long minorVersion;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("SegmentTypeBox.java", SegmentTypeBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getMajorBrand", "org.mp4parser.boxes.iso14496.part12.SegmentTypeBox", "", "", "", "java.lang.String"), 85);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setMajorBrand", "org.mp4parser.boxes.iso14496.part12.SegmentTypeBox", "java.lang.String", "majorBrand", "", "void"), 94);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getMinorVersion", "org.mp4parser.boxes.iso14496.part12.SegmentTypeBox", "", "", "", "long"), 104);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setMinorVersion", "org.mp4parser.boxes.iso14496.part12.SegmentTypeBox", "long", "minorVersion", "", "void"), 113);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getCompatibleBrands", "org.mp4parser.boxes.iso14496.part12.SegmentTypeBox", "", "", "", "java.util.List"), 122);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setCompatibleBrands", "org.mp4parser.boxes.iso14496.part12.SegmentTypeBox", "java.util.List", "compatibleBrands", "", "void"), 126);
    }

    public SegmentTypeBox() {
        super("styp");
    }

    public SegmentTypeBox(String str, long j, List<String> list) {
        super("styp");
        this.majorBrand = str;
        this.minorVersion = j;
        this.compatibleBrands = list;
    }

    public long getContentSize() {
        return (long) ((this.compatibleBrands.size() * 4) + 8);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        this.majorBrand = jky.O0000OoO(byteBuffer);
        this.minorVersion = jky.O000000o(byteBuffer);
        int remaining = byteBuffer.remaining() / 4;
        this.compatibleBrands = new LinkedList();
        for (int i = 0; i < remaining; i++) {
            this.compatibleBrands.add(jky.O0000OoO(byteBuffer));
        }
    }

    public void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(jhc.O000000o(this.majorBrand));
        jla.O00000Oo(byteBuffer, this.minorVersion);
        for (String O000000o2 : this.compatibleBrands) {
            byteBuffer.put(jhc.O000000o(O000000o2));
        }
    }

    public String getMajorBrand() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.majorBrand;
    }

    public void setMajorBrand(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.majorBrand = str;
    }

    public long getMinorVersion() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.minorVersion;
    }

    public void setMinorVersion(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.minorVersion = j;
    }

    public List<String> getCompatibleBrands() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.compatibleBrands;
    }

    public void setCompatibleBrands(List<String> list) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, list);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.compatibleBrands = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SegmentTypeBox[");
        sb.append("majorBrand=");
        sb.append(getMajorBrand());
        sb.append(";");
        sb.append("minorVersion=");
        sb.append(getMinorVersion());
        for (String append : this.compatibleBrands) {
            sb.append(";");
            sb.append("compatibleBrand=");
            sb.append(append);
        }
        sb.append("]");
        return sb.toString();
    }
}
