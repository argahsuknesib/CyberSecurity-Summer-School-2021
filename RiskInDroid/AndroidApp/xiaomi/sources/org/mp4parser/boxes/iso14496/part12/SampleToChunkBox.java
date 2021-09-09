package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jkv;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SampleToChunkBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    List<Entry> entries = Collections.emptyList();

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("SampleToChunkBox.java", SampleToChunkBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getEntries", "org.mp4parser.boxes.iso14496.part12.SampleToChunkBox", "", "", "", "java.util.List"), 41);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setEntries", "org.mp4parser.boxes.iso14496.part12.SampleToChunkBox", "java.util.List", "entries", "", "void"), 45);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part12.SampleToChunkBox", "", "", "", "java.lang.String"), 78);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "blowup", "org.mp4parser.boxes.iso14496.part12.SampleToChunkBox", "int", "chunkCount", "", "[J"), 89);
    }

    public SampleToChunkBox() {
        super("stsc");
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
        return (long) ((this.entries.size() * 12) + 8);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        int O000000o2 = jkv.O000000o(jky.O000000o(byteBuffer));
        this.entries = new ArrayList(O000000o2);
        for (int i = 0; i < O000000o2; i++) {
            this.entries.add(new Entry(jky.O000000o(byteBuffer), jky.O000000o(byteBuffer), jky.O000000o(byteBuffer)));
        }
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O00000Oo(byteBuffer, (long) this.entries.size());
        for (Entry next : this.entries) {
            jla.O00000Oo(byteBuffer, next.getFirstChunk());
            jla.O00000Oo(byteBuffer, next.getSamplesPerChunk());
            jla.O00000Oo(byteBuffer, next.getSampleDescriptionIndex());
        }
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "SampleToChunkBox[entryCount=" + this.entries.size() + "]";
    }

    public static class Entry {
        long firstChunk;
        long sampleDescriptionIndex;
        long samplesPerChunk;

        public Entry(long j, long j2, long j3) {
            this.firstChunk = j;
            this.samplesPerChunk = j2;
            this.sampleDescriptionIndex = j3;
        }

        public long getFirstChunk() {
            return this.firstChunk;
        }

        public void setFirstChunk(long j) {
            this.firstChunk = j;
        }

        public long getSamplesPerChunk() {
            return this.samplesPerChunk;
        }

        public void setSamplesPerChunk(long j) {
            this.samplesPerChunk = j;
        }

        public long getSampleDescriptionIndex() {
            return this.sampleDescriptionIndex;
        }

        public void setSampleDescriptionIndex(long j) {
            this.sampleDescriptionIndex = j;
        }

        public String toString() {
            return "Entry{firstChunk=" + this.firstChunk + ", samplesPerChunk=" + this.samplesPerChunk + ", sampleDescriptionIndex=" + this.sampleDescriptionIndex + '}';
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.firstChunk == entry.firstChunk && this.sampleDescriptionIndex == entry.sampleDescriptionIndex && this.samplesPerChunk == entry.samplesPerChunk;
        }

        public int hashCode() {
            long j = this.firstChunk;
            long j2 = this.samplesPerChunk;
            long j3 = this.sampleDescriptionIndex;
            return (((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)));
        }
    }

    public long[] blowup(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        long[] jArr = new long[i];
        LinkedList linkedList = new LinkedList(this.entries);
        Collections.reverse(linkedList);
        Iterator it = linkedList.iterator();
        Entry entry = (Entry) it.next();
        while (i > 1) {
            jArr[i - 1] = entry.getSamplesPerChunk();
            if (((long) i) == entry.getFirstChunk()) {
                entry = (Entry) it.next();
            }
            i--;
        }
        jArr[0] = entry.getSamplesPerChunk();
        return jArr;
    }
}
