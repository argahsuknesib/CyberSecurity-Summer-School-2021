package org.mp4parser.boxes.dece;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class TrickPlayBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private List<Entry> entries = new ArrayList();

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("TrickPlayBox.java", TrickPlayBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getEntries", "org.mp4parser.boxes.dece.TrickPlayBox", "", "", "", "java.util.List"), 32);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setEntries", "org.mp4parser.boxes.dece.TrickPlayBox", "java.util.List", "entries", "", "void"), 36);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.dece.TrickPlayBox", "", "", "", "java.lang.String"), 62);
    }

    public TrickPlayBox() {
        super("trik");
    }

    public List<Entry> getEntries() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.entries;
    }

    public void setEntries(List<Entry> list) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, list);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.entries = list;
    }

    public long getContentSize() {
        return (long) (this.entries.size() + 4);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        while (byteBuffer.remaining() > 0) {
            this.entries.add(new Entry(jky.O000000o(byteBuffer.get())));
        }
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        for (Entry entry : this.entries) {
            jla.O00000o(byteBuffer, entry.value);
        }
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "TrickPlayBox" + "{entries=" + this.entries + '}';
    }

    public static class Entry {
        public int value;

        public Entry() {
        }

        public Entry(int i) {
            this.value = i;
        }

        public int getPicType() {
            return (this.value >> 6) & 3;
        }

        public void setPicType(int i) {
            this.value &= 31;
            this.value = ((i & 3) << 6) | this.value;
        }

        public int getDependencyLevel() {
            return this.value & 63;
        }

        public void setDependencyLevel(int i) {
            this.value = (i & 63) | this.value;
        }

        public String toString() {
            return "Entry" + "{picType=" + getPicType() + ",dependencyLevel=" + getDependencyLevel() + '}';
        }
    }
}
