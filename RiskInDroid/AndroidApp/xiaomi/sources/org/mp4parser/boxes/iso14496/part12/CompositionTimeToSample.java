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
import java.util.List;

public class CompositionTimeToSample extends jkp {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    List<Entry> entries = Collections.emptyList();

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("CompositionTimeToSample.java", CompositionTimeToSample.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getEntries", "org.mp4parser.boxes.iso14496.part12.CompositionTimeToSample", "", "", "", "java.util.List"), 82);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setEntries", "org.mp4parser.boxes.iso14496.part12.CompositionTimeToSample", "java.util.List", "entries", "", "void"), 86);
    }

    public CompositionTimeToSample() {
        super("ctts");
    }

    public static int[] blowupCompositionTimes(List<Entry> list) {
        long j = 0;
        for (Entry count : list) {
            j += (long) count.getCount();
        }
        int[] iArr = new int[((int) j)];
        int i = 0;
        for (Entry next : list) {
            int i2 = i;
            int i3 = 0;
            while (i3 < next.getCount()) {
                iArr[i2] = next.getOffset();
                i3++;
                i2++;
            }
            i = i2;
        }
        return iArr;
    }

    public long getContentSize() {
        return (long) ((this.entries.size() * 8) + 8);
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
        int O000000o2 = jkv.O000000o(jky.O000000o(byteBuffer));
        this.entries = new ArrayList(O000000o2);
        for (int i = 0; i < O000000o2; i++) {
            this.entries.add(new Entry(jkv.O000000o(jky.O000000o(byteBuffer)), byteBuffer.getInt()));
        }
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O00000Oo(byteBuffer, (long) this.entries.size());
        for (Entry next : this.entries) {
            jla.O00000Oo(byteBuffer, (long) next.getCount());
            byteBuffer.putInt(next.getOffset());
        }
    }

    public static class Entry {
        int count;
        int offset;

        public Entry(int i, int i2) {
            this.count = i;
            this.offset = i2;
        }

        public int getCount() {
            return this.count;
        }

        public void setCount(int i) {
            this.count = i;
        }

        public int getOffset() {
            return this.offset;
        }

        public void setOffset(int i) {
            this.offset = i;
        }

        public String toString() {
            return "Entry{count=" + this.count + ", offset=" + this.offset + '}';
        }
    }
}
