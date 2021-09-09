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
import java.util.List;

public class SubSampleInformationBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private List<SubSampleEntry> entries = new ArrayList();

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("SubSampleInformationBox.java", SubSampleInformationBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getEntries", "org.mp4parser.boxes.iso14496.part12.SubSampleInformationBox", "", "", "", "java.util.List"), 49);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setEntries", "org.mp4parser.boxes.iso14496.part12.SubSampleInformationBox", "java.util.List", "entries", "", "void"), 53);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part12.SubSampleInformationBox", "", "", "", "java.lang.String"), 123);
    }

    public SubSampleInformationBox() {
        super("subs");
    }

    public List<SubSampleEntry> getEntries() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.entries;
    }

    public void setEntries(List<SubSampleEntry> list) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, list);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.entries = list;
    }

    public long getContentSize() {
        long j = 8;
        for (SubSampleEntry next : this.entries) {
            j = j + 4 + 2;
            for (int i = 0; i < next.getSubsampleEntries().size(); i++) {
                j = (getVersion() == 1 ? j + 4 : j + 2) + 2 + 4;
            }
        }
        return j;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        long O000000o2 = jky.O000000o(byteBuffer);
        for (int i = 0; ((long) i) < O000000o2; i++) {
            SubSampleEntry subSampleEntry = new SubSampleEntry();
            subSampleEntry.setSampleDelta(jky.O000000o(byteBuffer));
            int O00000o0 = jky.O00000o0(byteBuffer);
            for (int i2 = 0; i2 < O00000o0; i2++) {
                SubSampleEntry.SubsampleEntry subsampleEntry = new SubSampleEntry.SubsampleEntry();
                subsampleEntry.setSubsampleSize(getVersion() == 1 ? jky.O000000o(byteBuffer) : (long) jky.O00000o0(byteBuffer));
                subsampleEntry.setSubsamplePriority(jky.O000000o(byteBuffer.get()));
                subsampleEntry.setDiscardable(jky.O000000o(byteBuffer.get()));
                subsampleEntry.setReserved(jky.O000000o(byteBuffer));
                subSampleEntry.getSubsampleEntries().add(subsampleEntry);
            }
            this.entries.add(subSampleEntry);
        }
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O00000Oo(byteBuffer, (long) this.entries.size());
        for (SubSampleEntry next : this.entries) {
            jla.O00000Oo(byteBuffer, next.getSampleDelta());
            jla.O00000Oo(byteBuffer, next.getSubsampleCount());
            for (SubSampleEntry.SubsampleEntry next2 : next.getSubsampleEntries()) {
                if (getVersion() == 1) {
                    jla.O00000Oo(byteBuffer, next2.getSubsampleSize());
                } else {
                    jla.O00000Oo(byteBuffer, jkv.O000000o(next2.getSubsampleSize()));
                }
                jla.O00000o(byteBuffer, next2.getSubsamplePriority());
                jla.O00000o(byteBuffer, next2.getDiscardable());
                jla.O00000Oo(byteBuffer, next2.getReserved());
            }
        }
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "SubSampleInformationBox{entryCount=" + this.entries.size() + ", entries=" + this.entries + '}';
    }

    public static class SubSampleEntry {
        private long sampleDelta;
        private List<SubsampleEntry> subsampleEntries = new ArrayList();

        public long getSampleDelta() {
            return this.sampleDelta;
        }

        public void setSampleDelta(long j) {
            this.sampleDelta = j;
        }

        public int getSubsampleCount() {
            return this.subsampleEntries.size();
        }

        public List<SubsampleEntry> getSubsampleEntries() {
            return this.subsampleEntries;
        }

        public String toString() {
            return "SampleEntry{sampleDelta=" + this.sampleDelta + ", subsampleCount=" + this.subsampleEntries.size() + ", subsampleEntries=" + this.subsampleEntries + '}';
        }

        public static class SubsampleEntry {
            private int discardable;
            private long reserved;
            private int subsamplePriority;
            private long subsampleSize;

            public long getSubsampleSize() {
                return this.subsampleSize;
            }

            public void setSubsampleSize(long j) {
                this.subsampleSize = j;
            }

            public int getSubsamplePriority() {
                return this.subsamplePriority;
            }

            public void setSubsamplePriority(int i) {
                this.subsamplePriority = i;
            }

            public int getDiscardable() {
                return this.discardable;
            }

            public void setDiscardable(int i) {
                this.discardable = i;
            }

            public long getReserved() {
                return this.reserved;
            }

            public void setReserved(long j) {
                this.reserved = j;
            }

            public String toString() {
                return "SubsampleEntry{subsampleSize=" + this.subsampleSize + ", subsamplePriority=" + this.subsamplePriority + ", discardable=" + this.discardable + ", reserved=" + this.reserved + '}';
            }
        }
    }
}
