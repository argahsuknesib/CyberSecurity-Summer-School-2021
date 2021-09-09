package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jkv;
import _m_j.jky;
import _m_j.jla;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class TimeToSampleBox extends jkp {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    static Map<List<Entry>, SoftReference<long[]>> cache = new WeakHashMap();
    List<Entry> entries = Collections.emptyList();

    private static void ajc$preClinit() {
        jho jho = new jho("TimeToSampleBox.java", TimeToSampleBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getEntries", "org.mp4parser.boxes.iso14496.part12.TimeToSampleBox", "", "", "", "java.util.List"), 111);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setEntries", "org.mp4parser.boxes.iso14496.part12.TimeToSampleBox", "java.util.List", "entries", "", "void"), 115);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part12.TimeToSampleBox", "", "", "", "java.lang.String"), 119);
    }

    static {
        ajc$preClinit();
    }

    public TimeToSampleBox() {
        super("stts");
    }

    public static synchronized long[] blowupTimeToSamples(List<Entry> list) {
        long[] jArr;
        synchronized (TimeToSampleBox.class) {
            SoftReference softReference = cache.get(list);
            if (softReference != null && (jArr = (long[]) softReference.get()) != null) {
                return jArr;
            }
            long j = 0;
            for (Entry count : list) {
                j += count.getCount();
            }
            long[] jArr2 = new long[((int) j)];
            int i = 0;
            for (Entry next : list) {
                int i2 = i;
                int i3 = 0;
                while (((long) i3) < next.getCount()) {
                    jArr2[i2] = next.getDelta();
                    i3++;
                    i2++;
                }
                i = i2;
            }
            cache.put(list, new SoftReference(jArr2));
            return jArr2;
        }
    }

    public long getContentSize() {
        return (long) ((this.entries.size() * 8) + 8);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        int O000000o2 = jkv.O000000o(jky.O000000o(byteBuffer));
        this.entries = new ArrayList(O000000o2);
        for (int i = 0; i < O000000o2; i++) {
            this.entries.add(new Entry(jky.O000000o(byteBuffer), jky.O000000o(byteBuffer)));
        }
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O00000Oo(byteBuffer, (long) this.entries.size());
        for (Entry next : this.entries) {
            jla.O00000Oo(byteBuffer, next.getCount());
            jla.O00000Oo(byteBuffer, next.getDelta());
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

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "TimeToSampleBox[entryCount=" + this.entries.size() + "]";
    }

    public static class Entry {
        long count;
        long delta;

        public Entry(long j, long j2) {
            this.count = j;
            this.delta = j2;
        }

        public long getCount() {
            return this.count;
        }

        public void setCount(long j) {
            this.count = j;
        }

        public long getDelta() {
            return this.delta;
        }

        public void setDelta(long j) {
            this.delta = j;
        }

        public String toString() {
            return "Entry{count=" + this.count + ", delta=" + this.delta + '}';
        }
    }
}
