package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jkv;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

public class EditListBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private List<Entry> entries = new LinkedList();

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("EditListBox.java", EditListBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getEntries", "org.mp4parser.boxes.iso14496.part12.EditListBox", "", "", "", "java.util.List"), 67);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setEntries", "org.mp4parser.boxes.iso14496.part12.EditListBox", "java.util.List", "entries", "", "void"), 71);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part12.EditListBox", "", "", "", "java.lang.String"), 107);
    }

    public EditListBox() {
        super("elst");
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
        int i;
        if (getVersion() == 1) {
            i = this.entries.size() * 20;
        } else {
            i = this.entries.size() * 12;
        }
        return ((long) i) + 8;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        int O000000o2 = jkv.O000000o(jky.O000000o(byteBuffer));
        this.entries = new LinkedList();
        for (int i = 0; i < O000000o2; i++) {
            this.entries.add(new Entry(this, byteBuffer));
        }
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O00000Oo(byteBuffer, (long) this.entries.size());
        for (Entry content : this.entries) {
            content.getContent(byteBuffer);
        }
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "EditListBox{entries=" + this.entries + '}';
    }

    public static class Entry {
        EditListBox editListBox;
        private double mediaRate;
        private long mediaTime;
        private long segmentDuration;

        public Entry(EditListBox editListBox2, long j, long j2, double d) {
            this.segmentDuration = j;
            this.mediaTime = j2;
            this.mediaRate = d;
            this.editListBox = editListBox2;
        }

        public Entry(EditListBox editListBox2, ByteBuffer byteBuffer) {
            if (editListBox2.getVersion() == 1) {
                this.segmentDuration = jky.O00000oo(byteBuffer);
                this.mediaTime = byteBuffer.getLong();
                this.mediaRate = jky.O0000O0o(byteBuffer);
            } else {
                this.segmentDuration = jky.O000000o(byteBuffer);
                this.mediaTime = (long) byteBuffer.getInt();
                this.mediaRate = jky.O0000O0o(byteBuffer);
            }
            this.editListBox = editListBox2;
        }

        public long getSegmentDuration() {
            return this.segmentDuration;
        }

        public void setSegmentDuration(long j) {
            this.segmentDuration = j;
        }

        public long getMediaTime() {
            return this.mediaTime;
        }

        public void setMediaTime(long j) {
            this.mediaTime = j;
        }

        public double getMediaRate() {
            return this.mediaRate;
        }

        public void setMediaRate(double d) {
            this.mediaRate = d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.mediaTime == entry.mediaTime && this.segmentDuration == entry.segmentDuration;
        }

        public int hashCode() {
            long j = this.segmentDuration;
            long j2 = this.mediaTime;
            return (((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)));
        }

        public void getContent(ByteBuffer byteBuffer) {
            if (this.editListBox.getVersion() == 1) {
                jla.O000000o(byteBuffer, this.segmentDuration);
                byteBuffer.putLong(this.mediaTime);
            } else {
                jla.O00000Oo(byteBuffer, (long) jkv.O000000o(this.segmentDuration));
                byteBuffer.putInt(jkv.O000000o(this.mediaTime));
            }
            jla.O000000o(byteBuffer, this.mediaRate);
        }

        public String toString() {
            return "Entry{segmentDuration=" + this.segmentDuration + ", mediaTime=" + this.mediaTime + ", mediaRate=" + this.mediaRate + '}';
        }
    }
}
