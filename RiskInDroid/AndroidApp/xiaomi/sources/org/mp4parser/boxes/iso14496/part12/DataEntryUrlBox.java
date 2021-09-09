package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import java.nio.ByteBuffer;

public class DataEntryUrlBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("DataEntryUrlBox.java", DataEntryUrlBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part12.DataEntryUrlBox", "", "", "", "java.lang.String"), 51);
    }

    public long getContentSize() {
        return 4;
    }

    public DataEntryUrlBox() {
        super("url ");
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "DataEntryUrlBox[]";
    }
}
