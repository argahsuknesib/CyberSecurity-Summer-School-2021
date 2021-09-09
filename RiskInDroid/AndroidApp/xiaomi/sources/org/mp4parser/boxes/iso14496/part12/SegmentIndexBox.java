package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jhm;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import android.support.v4.app.NotificationCompat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.BitReaderBuffer;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.BitWriterBuffer;

public class SegmentIndexBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_10 = null;
    private static final jhf.O000000o ajc$tjp_11 = null;
    private static final jhf.O000000o ajc$tjp_12 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private static final jhf.O000000o ajc$tjp_7 = null;
    private static final jhf.O000000o ajc$tjp_8 = null;
    private static final jhf.O000000o ajc$tjp_9 = null;
    long earliestPresentationTime;
    List<Entry> entries = new ArrayList();
    long firstOffset;
    long referenceId;
    int reserved;
    long timeScale;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("SegmentIndexBox.java", SegmentIndexBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getEntries", "org.mp4parser.boxes.iso14496.part12.SegmentIndexBox", "", "", "", "java.util.List"), (int) NotificationCompat.FLAG_HIGH_PRIORITY);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setEntries", "org.mp4parser.boxes.iso14496.part12.SegmentIndexBox", "java.util.List", "entries", "", "void"), 132);
        ajc$tjp_10 = jho.O000000o("method-execution", jho.O000000o("1", "getReserved", "org.mp4parser.boxes.iso14496.part12.SegmentIndexBox", "", "", "", "int"), 168);
        ajc$tjp_11 = jho.O000000o("method-execution", jho.O000000o("1", "setReserved", "org.mp4parser.boxes.iso14496.part12.SegmentIndexBox", "int", "reserved", "", "void"), 172);
        ajc$tjp_12 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part12.SegmentIndexBox", "", "", "", "java.lang.String"), 177);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getReferenceId", "org.mp4parser.boxes.iso14496.part12.SegmentIndexBox", "", "", "", "long"), 136);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setReferenceId", "org.mp4parser.boxes.iso14496.part12.SegmentIndexBox", "long", "referenceId", "", "void"), 140);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getTimeScale", "org.mp4parser.boxes.iso14496.part12.SegmentIndexBox", "", "", "", "long"), 144);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setTimeScale", "org.mp4parser.boxes.iso14496.part12.SegmentIndexBox", "long", "timeScale", "", "void"), 148);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "getEarliestPresentationTime", "org.mp4parser.boxes.iso14496.part12.SegmentIndexBox", "", "", "", "long"), 152);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "setEarliestPresentationTime", "org.mp4parser.boxes.iso14496.part12.SegmentIndexBox", "long", "earliestPresentationTime", "", "void"), 156);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "getFirstOffset", "org.mp4parser.boxes.iso14496.part12.SegmentIndexBox", "", "", "", "long"), 160);
        ajc$tjp_9 = jho.O000000o("method-execution", jho.O000000o("1", "setFirstOffset", "org.mp4parser.boxes.iso14496.part12.SegmentIndexBox", "long", "firstOffset", "", "void"), 164);
    }

    public SegmentIndexBox() {
        super("sidx");
    }

    public long getContentSize() {
        return ((long) (getVersion() == 0 ? 8 : 16)) + 12 + 2 + 2 + ((long) (this.entries.size() * 12));
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O00000Oo(byteBuffer, this.referenceId);
        jla.O00000Oo(byteBuffer, this.timeScale);
        if (getVersion() == 0) {
            jla.O00000Oo(byteBuffer, this.earliestPresentationTime);
            jla.O00000Oo(byteBuffer, this.firstOffset);
        } else {
            jla.O000000o(byteBuffer, this.earliestPresentationTime);
            jla.O000000o(byteBuffer, this.firstOffset);
        }
        jla.O00000Oo(byteBuffer, this.reserved);
        jla.O00000Oo(byteBuffer, this.entries.size());
        for (Entry next : this.entries) {
            BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(byteBuffer);
            bitWriterBuffer.writeBits(next.getReferenceType(), 1);
            bitWriterBuffer.writeBits(next.getReferencedSize(), 31);
            jla.O00000Oo(byteBuffer, next.getSubsegmentDuration());
            BitWriterBuffer bitWriterBuffer2 = new BitWriterBuffer(byteBuffer);
            bitWriterBuffer2.writeBits(next.getStartsWithSap(), 1);
            bitWriterBuffer2.writeBits(next.getSapType(), 3);
            bitWriterBuffer2.writeBits(next.getSapDeltaTime(), 28);
        }
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.referenceId = jky.O000000o(byteBuffer);
        this.timeScale = jky.O000000o(byteBuffer);
        if (getVersion() == 0) {
            this.earliestPresentationTime = jky.O000000o(byteBuffer);
            this.firstOffset = jky.O000000o(byteBuffer);
        } else {
            this.earliestPresentationTime = jky.O00000oo(byteBuffer);
            this.firstOffset = jky.O00000oo(byteBuffer);
        }
        this.reserved = jky.O00000o0(byteBuffer);
        int O00000o0 = jky.O00000o0(byteBuffer);
        for (int i = 0; i < O00000o0; i++) {
            BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBuffer);
            Entry entry = new Entry();
            entry.setReferenceType((byte) bitReaderBuffer.readBits(1));
            entry.setReferencedSize(bitReaderBuffer.readBits(31));
            entry.setSubsegmentDuration(jky.O000000o(byteBuffer));
            BitReaderBuffer bitReaderBuffer2 = new BitReaderBuffer(byteBuffer);
            entry.setStartsWithSap((byte) bitReaderBuffer2.readBits(1));
            entry.setSapType((byte) bitReaderBuffer2.readBits(3));
            entry.setSapDeltaTime(bitReaderBuffer2.readBits(28));
            this.entries.add(entry);
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

    public long getReferenceId() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.referenceId;
    }

    public void setReferenceId(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.referenceId = j;
    }

    public long getTimeScale() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.timeScale;
    }

    public void setTimeScale(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.timeScale = j;
    }

    public long getEarliestPresentationTime() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.earliestPresentationTime;
    }

    public void setEarliestPresentationTime(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.earliestPresentationTime = j;
    }

    public long getFirstOffset() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.firstOffset;
    }

    public void setFirstOffset(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_9, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.firstOffset = j;
    }

    public int getReserved() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_10, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.reserved;
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_12, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "SegmentIndexBox{entries=" + this.entries + ", referenceId=" + this.referenceId + ", timeScale=" + this.timeScale + ", earliestPresentationTime=" + this.earliestPresentationTime + ", firstOffset=" + this.firstOffset + ", reserved=" + this.reserved + '}';
    }

    public static class Entry {
        byte referenceType;
        int referencedSize;
        int sapDeltaTime;
        byte sapType;
        byte startsWithSap;
        long subsegmentDuration;

        public Entry() {
        }

        public Entry(int i, int i2, long j, boolean z, int i3, int i4) {
            this.referenceType = (byte) i;
            this.referencedSize = i2;
            this.subsegmentDuration = j;
            this.startsWithSap = z ? (byte) 1 : 0;
            this.sapType = (byte) i3;
            this.sapDeltaTime = i4;
        }

        public byte getReferenceType() {
            return this.referenceType;
        }

        public void setReferenceType(byte b) {
            this.referenceType = b;
        }

        public int getReferencedSize() {
            return this.referencedSize;
        }

        public void setReferencedSize(int i) {
            this.referencedSize = i;
        }

        public long getSubsegmentDuration() {
            return this.subsegmentDuration;
        }

        public void setSubsegmentDuration(long j) {
            this.subsegmentDuration = j;
        }

        public byte getStartsWithSap() {
            return this.startsWithSap;
        }

        public void setStartsWithSap(byte b) {
            this.startsWithSap = b;
        }

        public byte getSapType() {
            return this.sapType;
        }

        public void setSapType(byte b) {
            this.sapType = b;
        }

        public int getSapDeltaTime() {
            return this.sapDeltaTime;
        }

        public void setSapDeltaTime(int i) {
            this.sapDeltaTime = i;
        }

        public String toString() {
            return "Entry{referenceType=" + ((int) this.referenceType) + ", referencedSize=" + this.referencedSize + ", subsegmentDuration=" + this.subsegmentDuration + ", startsWithSap=" + ((int) this.startsWithSap) + ", sapType=" + ((int) this.sapType) + ", sapDeltaTime=" + this.sapDeltaTime + '}';
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.referenceType == entry.referenceType && this.referencedSize == entry.referencedSize && this.sapDeltaTime == entry.sapDeltaTime && this.sapType == entry.sapType && this.startsWithSap == entry.startsWithSap && this.subsegmentDuration == entry.subsegmentDuration;
        }

        public int hashCode() {
            long j = this.subsegmentDuration;
            return (((((((((this.referenceType * 31) + this.referencedSize) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.startsWithSap) * 31) + this.sapType) * 31) + this.sapDeltaTime;
        }
    }

    public void setReserved(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_11, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.reserved = i;
    }
}
