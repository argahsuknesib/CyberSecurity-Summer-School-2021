package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ProgressiveDownloadInformationBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    List<Entry> entries = Collections.emptyList();

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("ProgressiveDownloadInformationBox.java", ProgressiveDownloadInformationBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getEntries", "org.mp4parser.boxes.iso14496.part12.ProgressiveDownloadInformationBox", "", "", "", "java.util.List"), 38);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setEntries", "org.mp4parser.boxes.iso14496.part12.ProgressiveDownloadInformationBox", "java.util.List", "entries", "", "void"), 42);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part12.ProgressiveDownloadInformationBox", "", "", "", "java.lang.String"), 57);
    }

    public ProgressiveDownloadInformationBox() {
        super("pdin");
    }

    public long getContentSize() {
        return (long) ((this.entries.size() * 8) + 4);
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        for (Entry next : this.entries) {
            jla.O00000Oo(byteBuffer, next.getRate());
            jla.O00000Oo(byteBuffer, next.getInitialDelay());
        }
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

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.entries = new LinkedList();
        while (byteBuffer.remaining() >= 8) {
            this.entries.add(new Entry(jky.O000000o(byteBuffer), jky.O000000o(byteBuffer)));
        }
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "ProgressiveDownloadInfoBox{entries=" + this.entries + '}';
    }

    public static class Entry {
        long initialDelay;
        long rate;

        public Entry(long j, long j2) {
            this.rate = j;
            this.initialDelay = j2;
        }

        public long getRate() {
            return this.rate;
        }

        public void setRate(long j) {
            this.rate = j;
        }

        public long getInitialDelay() {
            return this.initialDelay;
        }

        public void setInitialDelay(long j) {
            this.initialDelay = j;
        }

        public String toString() {
            return "Entry{rate=" + this.rate + ", initialDelay=" + this.initialDelay + '}';
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.initialDelay == entry.initialDelay && this.rate == entry.rate;
        }

        public int hashCode() {
            long j = this.rate;
            long j2 = this.initialDelay;
            return (((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)));
        }
    }
}
