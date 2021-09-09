package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jhm;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jkz;
import _m_j.jla;
import _m_j.jlb;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrackFragmentRandomAccessBox extends jkp {
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
    private List<Entry> entries = Collections.emptyList();
    private int lengthSizeOfSampleNum = 2;
    private int lengthSizeOfTrafNum = 2;
    private int lengthSizeOfTrunNum = 2;
    private int reserved;
    private long trackId;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("TrackFragmentRandomAccessBox.java", TrackFragmentRandomAccessBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getTrackId", "org.mp4parser.boxes.iso14496.part12.TrackFragmentRandomAccessBox", "", "", "", "long"), 125);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setTrackId", "org.mp4parser.boxes.iso14496.part12.TrackFragmentRandomAccessBox", "long", "trackId", "", "void"), 129);
        ajc$tjp_10 = jho.O000000o("method-execution", jho.O000000o("1", "getEntries", "org.mp4parser.boxes.iso14496.part12.TrackFragmentRandomAccessBox", "", "", "", "java.util.List"), 165);
        ajc$tjp_11 = jho.O000000o("method-execution", jho.O000000o("1", "setEntries", "org.mp4parser.boxes.iso14496.part12.TrackFragmentRandomAccessBox", "java.util.List", "entries", "", "void"), 169);
        ajc$tjp_12 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part12.TrackFragmentRandomAccessBox", "", "", "", "java.lang.String"), 174);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getReserved", "org.mp4parser.boxes.iso14496.part12.TrackFragmentRandomAccessBox", "", "", "", "int"), 133);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "getLengthSizeOfTrafNum", "org.mp4parser.boxes.iso14496.part12.TrackFragmentRandomAccessBox", "", "", "", "int"), 137);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "setLengthSizeOfTrafNum", "org.mp4parser.boxes.iso14496.part12.TrackFragmentRandomAccessBox", "int", "lengthSizeOfTrafNum", "", "void"), 141);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "getLengthSizeOfTrunNum", "org.mp4parser.boxes.iso14496.part12.TrackFragmentRandomAccessBox", "", "", "", "int"), 145);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "setLengthSizeOfTrunNum", "org.mp4parser.boxes.iso14496.part12.TrackFragmentRandomAccessBox", "int", "lengthSizeOfTrunNum", "", "void"), 149);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "getLengthSizeOfSampleNum", "org.mp4parser.boxes.iso14496.part12.TrackFragmentRandomAccessBox", "", "", "", "int"), 153);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "setLengthSizeOfSampleNum", "org.mp4parser.boxes.iso14496.part12.TrackFragmentRandomAccessBox", "int", "lengthSizeOfSampleNum", "", "void"), 157);
        ajc$tjp_9 = jho.O000000o("method-execution", jho.O000000o("1", "getNumberOfEntries", "org.mp4parser.boxes.iso14496.part12.TrackFragmentRandomAccessBox", "", "", "", "long"), 161);
    }

    public TrackFragmentRandomAccessBox() {
        super("tfra");
    }

    public long getContentSize() {
        int i;
        if (getVersion() == 1) {
            i = this.entries.size() * 16;
        } else {
            i = this.entries.size() * 8;
        }
        return ((long) i) + 16 + ((long) (this.lengthSizeOfTrafNum * this.entries.size())) + ((long) (this.lengthSizeOfTrunNum * this.entries.size())) + ((long) (this.lengthSizeOfSampleNum * this.entries.size()));
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.trackId = jky.O000000o(byteBuffer);
        long O000000o2 = jky.O000000o(byteBuffer);
        this.reserved = (int) (O000000o2 >> 6);
        this.lengthSizeOfTrafNum = (((int) (63 & O000000o2)) >> 4) + 1;
        this.lengthSizeOfTrunNum = (((int) (12 & O000000o2)) >> 2) + 1;
        this.lengthSizeOfSampleNum = ((int) (O000000o2 & 3)) + 1;
        long O000000o3 = jky.O000000o(byteBuffer);
        this.entries = new ArrayList();
        for (int i = 0; ((long) i) < O000000o3; i++) {
            Entry entry = new Entry();
            if (getVersion() == 1) {
                entry.time = jky.O00000oo(byteBuffer);
                entry.moofOffset = jky.O00000oo(byteBuffer);
            } else {
                entry.time = jky.O000000o(byteBuffer);
                entry.moofOffset = jky.O000000o(byteBuffer);
            }
            entry.trafNumber = jkz.O000000o(byteBuffer, this.lengthSizeOfTrafNum);
            entry.trunNumber = jkz.O000000o(byteBuffer, this.lengthSizeOfTrunNum);
            entry.sampleNumber = jkz.O000000o(byteBuffer, this.lengthSizeOfSampleNum);
            this.entries.add(entry);
        }
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O00000Oo(byteBuffer, this.trackId);
        jla.O00000Oo(byteBuffer, ((long) (this.reserved << 6)) | ((long) (((this.lengthSizeOfTrafNum - 1) & 3) << 4)) | ((long) (((this.lengthSizeOfTrunNum - 1) & 3) << 2)) | ((long) ((this.lengthSizeOfSampleNum - 1) & 3)));
        jla.O00000Oo(byteBuffer, (long) this.entries.size());
        for (Entry next : this.entries) {
            if (getVersion() == 1) {
                jla.O000000o(byteBuffer, next.time);
                jla.O000000o(byteBuffer, next.moofOffset);
            } else {
                jla.O00000Oo(byteBuffer, next.time);
                jla.O00000Oo(byteBuffer, next.moofOffset);
            }
            jlb.O000000o(next.trafNumber, byteBuffer, this.lengthSizeOfTrafNum);
            jlb.O000000o(next.trunNumber, byteBuffer, this.lengthSizeOfTrunNum);
            jlb.O000000o(next.sampleNumber, byteBuffer, this.lengthSizeOfSampleNum);
        }
    }

    public long getTrackId() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.trackId;
    }

    public void setTrackId(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.trackId = j;
    }

    public int getReserved() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.reserved;
    }

    public int getLengthSizeOfTrafNum() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.lengthSizeOfTrafNum;
    }

    public int getLengthSizeOfTrunNum() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.lengthSizeOfTrunNum;
    }

    public int getLengthSizeOfSampleNum() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.lengthSizeOfSampleNum;
    }

    public long getNumberOfEntries() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_9, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return (long) this.entries.size();
    }

    public List<Entry> getEntries() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_10, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return Collections.unmodifiableList(this.entries);
    }

    public void setEntries(List<Entry> list) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_11, this, this, list);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.entries = list;
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_12, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "TrackFragmentRandomAccessBox{trackId=" + this.trackId + ", entries=" + this.entries + '}';
    }

    public static class Entry {
        public long moofOffset;
        public long sampleNumber;
        public long time;
        public long trafNumber;
        public long trunNumber;

        public Entry() {
        }

        public Entry(long j, long j2, long j3, long j4, long j5) {
            this.moofOffset = j2;
            this.sampleNumber = j5;
            this.time = j;
            this.trafNumber = j3;
            this.trunNumber = j4;
        }

        public long getTime() {
            return this.time;
        }

        public void setTime(long j) {
            this.time = j;
        }

        public long getMoofOffset() {
            return this.moofOffset;
        }

        public void setMoofOffset(long j) {
            this.moofOffset = j;
        }

        public long getTrafNumber() {
            return this.trafNumber;
        }

        public void setTrafNumber(long j) {
            this.trafNumber = j;
        }

        public long getTrunNumber() {
            return this.trunNumber;
        }

        public void setTrunNumber(long j) {
            this.trunNumber = j;
        }

        public long getSampleNumber() {
            return this.sampleNumber;
        }

        public void setSampleNumber(long j) {
            this.sampleNumber = j;
        }

        public String toString() {
            return "Entry{time=" + this.time + ", moofOffset=" + this.moofOffset + ", trafNumber=" + this.trafNumber + ", trunNumber=" + this.trunNumber + ", sampleNumber=" + this.sampleNumber + '}';
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.moofOffset == entry.moofOffset && this.sampleNumber == entry.sampleNumber && this.time == entry.time && this.trafNumber == entry.trafNumber && this.trunNumber == entry.trunNumber;
        }

        public int hashCode() {
            long j = this.time;
            long j2 = this.moofOffset;
            long j3 = this.trafNumber;
            long j4 = this.trunNumber;
            long j5 = this.sampleNumber;
            return (((((((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)));
        }
    }

    public void setLengthSizeOfTrafNum(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.lengthSizeOfTrafNum = i;
    }

    public void setLengthSizeOfTrunNum(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.lengthSizeOfTrunNum = i;
    }

    public void setLengthSizeOfSampleNum(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.lengthSizeOfSampleNum = i;
    }
}
