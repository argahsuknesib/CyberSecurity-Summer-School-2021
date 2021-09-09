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

public class TrackRunBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_10 = null;
    private static final jhf.O000000o ajc$tjp_11 = null;
    private static final jhf.O000000o ajc$tjp_12 = null;
    private static final jhf.O000000o ajc$tjp_13 = null;
    private static final jhf.O000000o ajc$tjp_14 = null;
    private static final jhf.O000000o ajc$tjp_15 = null;
    private static final jhf.O000000o ajc$tjp_16 = null;
    private static final jhf.O000000o ajc$tjp_17 = null;
    private static final jhf.O000000o ajc$tjp_18 = null;
    private static final jhf.O000000o ajc$tjp_19 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private static final jhf.O000000o ajc$tjp_7 = null;
    private static final jhf.O000000o ajc$tjp_8 = null;
    private static final jhf.O000000o ajc$tjp_9 = null;
    private int dataOffset;
    private List<Entry> entries = new ArrayList();
    private SampleFlags firstSampleFlags;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("TrackRunBox.java", TrackRunBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getEntries", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "", "", "", "java.util.List"), 60);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setEntries", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "java.util.List", "entries", "", "void"), 64);
        ajc$tjp_10 = jho.O000000o("method-execution", jho.O000000o("1", "setSampleDurationPresent", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "boolean", "v", "", "void"), 210);
        ajc$tjp_11 = jho.O000000o("method-execution", jho.O000000o("1", "isSampleFlagsPresent", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "", "", "", "boolean"), 219);
        ajc$tjp_12 = jho.O000000o("method-execution", jho.O000000o("1", "setSampleFlagsPresent", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "boolean", "v", "", "void"), 223);
        ajc$tjp_13 = jho.O000000o("method-execution", jho.O000000o("1", "isSampleCompositionTimeOffsetPresent", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "", "", "", "boolean"), 231);
        ajc$tjp_14 = jho.O000000o("method-execution", jho.O000000o("1", "setSampleCompositionTimeOffsetPresent", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "boolean", "v", "", "void"), 235);
        ajc$tjp_15 = jho.O000000o("method-execution", jho.O000000o("1", "getDataOffset", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "", "", "", "int"), 244);
        ajc$tjp_16 = jho.O000000o("method-execution", jho.O000000o("1", "setDataOffset", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "int", "dataOffset", "", "void"), 248);
        ajc$tjp_17 = jho.O000000o("method-execution", jho.O000000o("1", "getFirstSampleFlags", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "", "", "", "org.mp4parser.boxes.iso14496.part12.SampleFlags"), 257);
        ajc$tjp_18 = jho.O000000o("method-execution", jho.O000000o("1", "setFirstSampleFlags", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "org.mp4parser.boxes.iso14496.part12.SampleFlags", "firstSampleFlags", "", "void"), 261);
        ajc$tjp_19 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "", "", "", "java.lang.String"), 271);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getSampleCompositionTimeOffsets", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "", "", "", "[J"), 68);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "getSampleCount", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "", "", "", "long"), 173);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "isDataOffsetPresent", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "", "", "", "boolean"), 177);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setDataOffsetPresent", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "boolean", "v", "", "void"), 181);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "isFirstSampleFlagsPresent", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "", "", "", "boolean"), 189);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "isSampleSizePresent", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "", "", "", "boolean"), 194);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "setSampleSizePresent", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "boolean", "v", "", "void"), 198);
        ajc$tjp_9 = jho.O000000o("method-execution", jho.O000000o("1", "isSampleDurationPresent", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "", "", "", "boolean"), 206);
    }

    public TrackRunBox() {
        super("trun");
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

    public long[] getSampleCompositionTimeOffsets() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        if (!isSampleCompositionTimeOffsetPresent()) {
            return null;
        }
        long[] jArr = new long[this.entries.size()];
        for (int i = 0; i < jArr.length; i++) {
            jArr[i] = this.entries.get(i).getSampleCompositionTimeOffset();
        }
        return jArr;
    }

    public long getContentSize() {
        int flags = getFlags();
        long j = (flags & 1) == 1 ? 12 : 8;
        if ((flags & 4) == 4) {
            j += 4;
        }
        long j2 = 0;
        if ((flags & 256) == 256) {
            j2 = 4;
        }
        if ((flags & 512) == 512) {
            j2 += 4;
        }
        if ((flags & 1024) == 1024) {
            j2 += 4;
        }
        if ((flags & 2048) == 2048) {
            j2 += 4;
        }
        return j + (j2 * ((long) this.entries.size()));
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O00000Oo(byteBuffer, (long) this.entries.size());
        int flags = getFlags();
        if ((flags & 1) == 1) {
            jla.O00000Oo(byteBuffer, (long) this.dataOffset);
        }
        if ((flags & 4) == 4) {
            this.firstSampleFlags.getContent(byteBuffer);
        }
        for (Entry next : this.entries) {
            if ((flags & 256) == 256) {
                jla.O00000Oo(byteBuffer, next.sampleDuration);
            }
            if ((flags & 512) == 512) {
                jla.O00000Oo(byteBuffer, next.sampleSize);
            }
            if ((flags & 1024) == 1024) {
                next.sampleFlags.getContent(byteBuffer);
            }
            if ((flags & 2048) == 2048) {
                if (getVersion() == 0) {
                    jla.O00000Oo(byteBuffer, next.sampleCompositionTimeOffset);
                } else {
                    byteBuffer.putInt((int) next.sampleCompositionTimeOffset);
                }
            }
        }
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        long O000000o2 = jky.O000000o(byteBuffer);
        if ((getFlags() & 1) == 1) {
            this.dataOffset = jkv.O000000o(jky.O000000o(byteBuffer));
        } else {
            this.dataOffset = -1;
        }
        if ((getFlags() & 4) == 4) {
            this.firstSampleFlags = new SampleFlags(byteBuffer);
        }
        for (int i = 0; ((long) i) < O000000o2; i++) {
            Entry entry = new Entry();
            if ((getFlags() & 256) == 256) {
                entry.sampleDuration = jky.O000000o(byteBuffer);
            }
            if ((getFlags() & 512) == 512) {
                entry.sampleSize = jky.O000000o(byteBuffer);
            }
            if ((getFlags() & 1024) == 1024) {
                entry.sampleFlags = new SampleFlags(byteBuffer);
            }
            if ((getFlags() & 2048) == 2048) {
                entry.sampleCompositionTimeOffset = (long) byteBuffer.getInt();
            }
            this.entries.add(entry);
        }
    }

    public long getSampleCount() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return (long) this.entries.size();
    }

    public boolean isDataOffsetPresent() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return (getFlags() & 1) == 1;
    }

    public boolean isFirstSampleFlagsPresent() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return (getFlags() & 4) == 4;
    }

    public boolean isSampleSizePresent() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return (getFlags() & 512) == 512;
    }

    public boolean isSampleDurationPresent() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_9, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return (getFlags() & 256) == 256;
    }

    public boolean isSampleFlagsPresent() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_11, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return (getFlags() & 1024) == 1024;
    }

    public boolean isSampleCompositionTimeOffsetPresent() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_13, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return (getFlags() & 2048) == 2048;
    }

    public int getDataOffset() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_15, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.dataOffset;
    }

    public SampleFlags getFirstSampleFlags() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_17, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.firstSampleFlags;
    }

    public void setFirstSampleFlags(SampleFlags sampleFlags) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_18, this, this, sampleFlags);
        jku.O000000o();
        jku.O000000o(O000000o2);
        if (sampleFlags == null) {
            setFlags(getFlags() & 16777211);
        } else {
            setFlags(getFlags() | 4);
        }
        this.firstSampleFlags = sampleFlags;
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_19, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "TrackRunBox" + "{sampleCount=" + this.entries.size() + ", dataOffset=" + this.dataOffset + ", dataOffsetPresent=" + isDataOffsetPresent() + ", sampleSizePresent=" + isSampleSizePresent() + ", sampleDurationPresent=" + isSampleDurationPresent() + ", sampleFlagsPresentPresent=" + isSampleFlagsPresent() + ", sampleCompositionTimeOffsetPresent=" + isSampleCompositionTimeOffsetPresent() + ", firstSampleFlags=" + this.firstSampleFlags + '}';
    }

    public static class Entry {
        public long sampleCompositionTimeOffset;
        public long sampleDuration;
        public SampleFlags sampleFlags;
        public long sampleSize;

        public Entry() {
        }

        public Entry(long j, long j2, SampleFlags sampleFlags2, int i) {
            this.sampleDuration = j;
            this.sampleSize = j2;
            this.sampleFlags = sampleFlags2;
            this.sampleCompositionTimeOffset = (long) i;
        }

        public long getSampleDuration() {
            return this.sampleDuration;
        }

        public void setSampleDuration(long j) {
            this.sampleDuration = j;
        }

        public long getSampleSize() {
            return this.sampleSize;
        }

        public void setSampleSize(long j) {
            this.sampleSize = j;
        }

        public SampleFlags getSampleFlags() {
            return this.sampleFlags;
        }

        public void setSampleFlags(SampleFlags sampleFlags2) {
            this.sampleFlags = sampleFlags2;
        }

        public long getSampleCompositionTimeOffset() {
            return this.sampleCompositionTimeOffset;
        }

        public void setSampleCompositionTimeOffset(int i) {
            this.sampleCompositionTimeOffset = (long) i;
        }

        public String toString() {
            return "Entry{duration=" + this.sampleDuration + ", size=" + this.sampleSize + ", dlags=" + this.sampleFlags + ", compTimeOffset=" + this.sampleCompositionTimeOffset + '}';
        }
    }

    public void setDataOffsetPresent(boolean z) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, Boolean.valueOf(z));
        jku.O000000o();
        jku.O000000o(O000000o2);
        if (z) {
            setFlags(getFlags() | 1);
        } else {
            setFlags(getFlags() & 16777214);
        }
    }

    public void setSampleSizePresent(boolean z) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this, Boolean.valueOf(z));
        jku.O000000o();
        jku.O000000o(O000000o2);
        if (z) {
            setFlags(getFlags() | 512);
        } else {
            setFlags(getFlags() & 16776703);
        }
    }

    public void setSampleDurationPresent(boolean z) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_10, this, this, Boolean.valueOf(z));
        jku.O000000o();
        jku.O000000o(O000000o2);
        if (z) {
            setFlags(getFlags() | 256);
        } else {
            setFlags(getFlags() & 16776959);
        }
    }

    public void setSampleFlagsPresent(boolean z) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_12, this, this, Boolean.valueOf(z));
        jku.O000000o();
        jku.O000000o(O000000o2);
        if (z) {
            setFlags(getFlags() | 1024);
        } else {
            setFlags(getFlags() & 16776191);
        }
    }

    public void setSampleCompositionTimeOffsetPresent(boolean z) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_14, this, this, Boolean.valueOf(z));
        jku.O000000o();
        jku.O000000o(O000000o2);
        if (z) {
            setFlags(getFlags() | 2048);
        } else {
            setFlags(getFlags() & 16775167);
        }
    }

    public void setDataOffset(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_16, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        if (i == -1) {
            setFlags(getFlags() & 16777214);
        } else {
            setFlags(getFlags() | 1);
        }
        this.dataOffset = i;
    }
}
