package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class SampleDependencyTypeBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private List<Entry> entries = new ArrayList();

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("SampleDependencyTypeBox.java", SampleDependencyTypeBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getEntries", "org.mp4parser.boxes.iso14496.part12.SampleDependencyTypeBox", "", "", "", "java.util.List"), 70);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setEntries", "org.mp4parser.boxes.iso14496.part12.SampleDependencyTypeBox", "java.util.List", "entries", "", "void"), 74);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part12.SampleDependencyTypeBox", "", "", "", "java.lang.String"), 79);
    }

    public SampleDependencyTypeBox() {
        super("sdtp");
    }

    public long getContentSize() {
        return (long) (this.entries.size() + 4);
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        for (Entry entry : this.entries) {
            jla.O00000o(byteBuffer, entry.value);
        }
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        while (byteBuffer.remaining() > 0) {
            this.entries.add(new Entry(jky.O000000o(byteBuffer.get())));
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
        return "SampleDependencyTypeBox" + "{entries=" + this.entries + '}';
    }

    public static class Entry {
        public int value;

        public Entry(int i) {
            this.value = i;
        }

        public byte getIsLeading() {
            return (byte) ((this.value >> 6) & 3);
        }

        public void setIsLeading(int i) {
            this.value = ((i & 3) << 6) | (this.value & 63);
        }

        public byte getSampleDependsOn() {
            return (byte) ((this.value >> 4) & 3);
        }

        public void setSampleDependsOn(int i) {
            this.value = ((i & 3) << 4) | (this.value & 207);
        }

        public byte getSampleIsDependedOn() {
            return (byte) ((this.value >> 2) & 3);
        }

        public void setSampleIsDependedOn(int i) {
            this.value = ((i & 3) << 2) | (this.value & 243);
        }

        public byte getSampleHasRedundancy() {
            return (byte) (this.value & 3);
        }

        public void setSampleHasRedundancy(int i) {
            this.value = (i & 3) | (this.value & 252);
        }

        public String toString() {
            return "Entry{isLeading=" + ((int) getIsLeading()) + ", sampleDependsOn=" + ((int) getSampleDependsOn()) + ", sampleIsDependentOn=" + ((int) getSampleIsDependedOn()) + ", sampleHasRedundancy=" + ((int) getSampleHasRedundancy()) + '}';
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.value == ((Entry) obj).value;
        }

        public int hashCode() {
            return this.value;
        }
    }
}
