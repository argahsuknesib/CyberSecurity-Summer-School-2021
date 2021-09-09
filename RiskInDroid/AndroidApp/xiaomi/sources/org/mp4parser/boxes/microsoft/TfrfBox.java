package org.mp4parser.boxes.microsoft;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class TfrfBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    public List<Entry> entries = new ArrayList();

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("TfrfBox.java", TfrfBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getFragmentCount", "org.mp4parser.boxes.microsoft.TfrfBox", "", "", "", "long"), 91);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "getEntries", "org.mp4parser.boxes.microsoft.TfrfBox", "", "", "", "java.util.List"), 95);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.microsoft.TfrfBox", "", "", "", "java.lang.String"), 100);
    }

    public TfrfBox() {
        super("uuid");
    }

    public byte[] getUserType() {
        return new byte[]{-44, Byte.MIN_VALUE, 126, -14, -54, 57, 70, -107, -114, 84, 38, -53, -98, 70, -89, -97};
    }

    public long getContentSize() {
        return (long) ((this.entries.size() * (getVersion() == 1 ? 16 : 8)) + 5);
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O00000o(byteBuffer, this.entries.size());
        for (Entry next : this.entries) {
            if (getVersion() == 1) {
                jla.O000000o(byteBuffer, next.fragmentAbsoluteTime);
                jla.O000000o(byteBuffer, next.fragmentAbsoluteDuration);
            } else {
                jla.O00000Oo(byteBuffer, next.fragmentAbsoluteTime);
                jla.O00000Oo(byteBuffer, next.fragmentAbsoluteDuration);
            }
        }
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        int O000000o2 = jky.O000000o(byteBuffer.get());
        for (int i = 0; i < O000000o2; i++) {
            Entry entry = new Entry();
            if (getVersion() == 1) {
                entry.fragmentAbsoluteTime = jky.O00000oo(byteBuffer);
                entry.fragmentAbsoluteDuration = jky.O00000oo(byteBuffer);
            } else {
                entry.fragmentAbsoluteTime = jky.O000000o(byteBuffer);
                entry.fragmentAbsoluteDuration = jky.O000000o(byteBuffer);
            }
            this.entries.add(entry);
        }
    }

    public long getFragmentCount() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return (long) this.entries.size();
    }

    public List<Entry> getEntries() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.entries;
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "TfrfBox" + "{entries=" + this.entries + '}';
    }

    public class Entry {
        long fragmentAbsoluteDuration;
        long fragmentAbsoluteTime;

        public Entry() {
        }

        public long getFragmentAbsoluteTime() {
            return this.fragmentAbsoluteTime;
        }

        public long getFragmentAbsoluteDuration() {
            return this.fragmentAbsoluteDuration;
        }

        public String toString() {
            return "Entry" + "{fragmentAbsoluteTime=" + this.fragmentAbsoluteTime + ", fragmentAbsoluteDuration=" + this.fragmentAbsoluteDuration + '}';
        }
    }
}
