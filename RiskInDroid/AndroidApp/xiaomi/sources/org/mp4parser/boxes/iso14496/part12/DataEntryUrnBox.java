package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jli;
import java.nio.ByteBuffer;

public class DataEntryUrnBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private String location;
    private String name;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("DataEntryUrnBox.java", DataEntryUrnBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getName", "org.mp4parser.boxes.iso14496.part12.DataEntryUrnBox", "", "", "", "java.lang.String"), 40);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "getLocation", "org.mp4parser.boxes.iso14496.part12.DataEntryUrnBox", "", "", "", "java.lang.String"), 44);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part12.DataEntryUrnBox", "", "", "", "java.lang.String"), 67);
    }

    public DataEntryUrnBox() {
        super("urn ");
    }

    public String getName() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.name;
    }

    public String getLocation() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.location;
    }

    public long getContentSize() {
        return (long) (jli.O00000Oo(this.name) + 1 + jli.O00000Oo(this.location) + 1);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        this.name = jky.O00000oO(byteBuffer);
        this.location = jky.O00000oO(byteBuffer);
    }

    public void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(jli.O000000o(this.name));
        byteBuffer.put((byte) 0);
        byteBuffer.put(jli.O000000o(this.location));
        byteBuffer.put((byte) 0);
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "DataEntryUrlBox[name=" + getName() + ";location=" + getLocation() + "]";
    }
}
