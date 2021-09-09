package org.mp4parser.boxes.samplegrouping;

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

public class SampleToGroupBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    List<Entry> entries = new LinkedList();
    private String groupingType;
    private String groupingTypeParameter;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("SampleToGroupBox.java", SampleToGroupBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getGroupingType", "org.mp4parser.boxes.samplegrouping.SampleToGroupBox", "", "", "", "java.lang.String"), 84);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setGroupingType", "org.mp4parser.boxes.samplegrouping.SampleToGroupBox", "java.lang.String", "groupingType", "", "void"), 88);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getGroupingTypeParameter", "org.mp4parser.boxes.samplegrouping.SampleToGroupBox", "", "", "", "java.lang.String"), 92);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setGroupingTypeParameter", "org.mp4parser.boxes.samplegrouping.SampleToGroupBox", "java.lang.String", "groupingTypeParameter", "", "void"), 96);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getEntries", "org.mp4parser.boxes.samplegrouping.SampleToGroupBox", "", "", "", "java.util.List"), 100);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setEntries", "org.mp4parser.boxes.samplegrouping.SampleToGroupBox", "java.util.List", "entries", "", "void"), 104);
    }

    public SampleToGroupBox() {
        super("sbgp");
    }

    public long getContentSize() {
        return (long) (getVersion() == 1 ? (this.entries.size() * 8) + 16 : (this.entries.size() * 8) + 12);
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(this.groupingType.getBytes());
        if (getVersion() == 1) {
            byteBuffer.put(this.groupingTypeParameter.getBytes());
        }
        jla.O00000Oo(byteBuffer, (long) this.entries.size());
        for (Entry next : this.entries) {
            jla.O00000Oo(byteBuffer, next.getSampleCount());
            jla.O00000Oo(byteBuffer, (long) next.getGroupDescriptionIndex());
        }
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.groupingType = jky.O0000OoO(byteBuffer);
        if (getVersion() == 1) {
            this.groupingTypeParameter = jky.O0000OoO(byteBuffer);
        }
        long O000000o2 = jky.O000000o(byteBuffer);
        while (true) {
            long j = O000000o2 - 1;
            if (O000000o2 > 0) {
                this.entries.add(new Entry((long) jkv.O000000o(jky.O000000o(byteBuffer)), jkv.O000000o(jky.O000000o(byteBuffer))));
                O000000o2 = j;
            } else {
                return;
            }
        }
    }

    public String getGroupingType() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.groupingType;
    }

    public void setGroupingType(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.groupingType = str;
    }

    public String getGroupingTypeParameter() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.groupingTypeParameter;
    }

    public void setGroupingTypeParameter(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.groupingTypeParameter = str;
    }

    public List<Entry> getEntries() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.entries;
    }

    public void setEntries(List<Entry> list) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, list);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.entries = list;
    }

    public static class Entry {
        private int groupDescriptionIndex;
        private long sampleCount;

        public Entry(long j, int i) {
            this.sampleCount = j;
            this.groupDescriptionIndex = i;
        }

        public long getSampleCount() {
            return this.sampleCount;
        }

        public void setSampleCount(long j) {
            this.sampleCount = j;
        }

        public int getGroupDescriptionIndex() {
            return this.groupDescriptionIndex;
        }

        public void setGroupDescriptionIndex(int i) {
            this.groupDescriptionIndex = i;
        }

        public String toString() {
            return "Entry{sampleCount=" + this.sampleCount + ", groupDescriptionIndex=" + this.groupDescriptionIndex + '}';
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.groupDescriptionIndex == entry.groupDescriptionIndex && this.sampleCount == entry.sampleCount;
        }

        public int hashCode() {
            long j = this.sampleCount;
            return (((int) (j ^ (j >>> 32))) * 31) + this.groupDescriptionIndex;
        }
    }
}
