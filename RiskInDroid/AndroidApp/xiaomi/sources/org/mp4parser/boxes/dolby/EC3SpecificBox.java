package org.mp4parser.boxes.dolby;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkn;
import _m_j.jku;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.BitReaderBuffer;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.BitWriterBuffer;

public class EC3SpecificBox extends jkn {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private static final jhf.O000000o ajc$tjp_7 = null;
    private static final jhf.O000000o ajc$tjp_8 = null;
    int dataRate;
    List<Entry> entries = new LinkedList();
    int numIndSub;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("EC3SpecificBox.java", EC3SpecificBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getContentSize", "org.mp4parser.boxes.dolby.EC3SpecificBox", "", "", "", "long"), 25);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "getContent", "org.mp4parser.boxes.dolby.EC3SpecificBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 65);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getEntries", "org.mp4parser.boxes.dolby.EC3SpecificBox", "", "", "", "java.util.List"), 86);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setEntries", "org.mp4parser.boxes.dolby.EC3SpecificBox", "java.util.List", "entries", "", "void"), 90);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "addEntry", "org.mp4parser.boxes.dolby.EC3SpecificBox", "org.mp4parser.boxes.dolby.EC3SpecificBox$Entry", "entry", "", "void"), 94);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "getDataRate", "org.mp4parser.boxes.dolby.EC3SpecificBox", "", "", "", "int"), 98);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "setDataRate", "org.mp4parser.boxes.dolby.EC3SpecificBox", "int", "dataRate", "", "void"), 102);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "getNumIndSub", "org.mp4parser.boxes.dolby.EC3SpecificBox", "", "", "", "int"), 106);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "setNumIndSub", "org.mp4parser.boxes.dolby.EC3SpecificBox", "int", "numIndSub", "", "void"), 110);
    }

    public EC3SpecificBox() {
        super("dec3");
    }

    public long getContentSize() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        long j = 2;
        for (Entry entry : this.entries) {
            j += entry.num_dep_sub > 0 ? 4 : 3;
        }
        return j;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBuffer);
        this.dataRate = bitReaderBuffer.readBits(13);
        this.numIndSub = bitReaderBuffer.readBits(3) + 1;
        for (int i = 0; i < this.numIndSub; i++) {
            Entry entry = new Entry();
            entry.fscod = bitReaderBuffer.readBits(2);
            entry.bsid = bitReaderBuffer.readBits(5);
            entry.bsmod = bitReaderBuffer.readBits(5);
            entry.acmod = bitReaderBuffer.readBits(3);
            entry.lfeon = bitReaderBuffer.readBits(1);
            entry.reserved = bitReaderBuffer.readBits(3);
            entry.num_dep_sub = bitReaderBuffer.readBits(4);
            if (entry.num_dep_sub > 0) {
                entry.chan_loc = bitReaderBuffer.readBits(9);
            } else {
                entry.reserved2 = bitReaderBuffer.readBits(1);
            }
            this.entries.add(entry);
        }
    }

    public void getContent(ByteBuffer byteBuffer) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, byteBuffer);
        jku.O000000o();
        jku.O000000o(O000000o2);
        BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(byteBuffer);
        bitWriterBuffer.writeBits(this.dataRate, 13);
        bitWriterBuffer.writeBits(this.entries.size() - 1, 3);
        for (Entry next : this.entries) {
            bitWriterBuffer.writeBits(next.fscod, 2);
            bitWriterBuffer.writeBits(next.bsid, 5);
            bitWriterBuffer.writeBits(next.bsmod, 5);
            bitWriterBuffer.writeBits(next.acmod, 3);
            bitWriterBuffer.writeBits(next.lfeon, 1);
            bitWriterBuffer.writeBits(next.reserved, 3);
            bitWriterBuffer.writeBits(next.num_dep_sub, 4);
            if (next.num_dep_sub > 0) {
                bitWriterBuffer.writeBits(next.chan_loc, 9);
            } else {
                bitWriterBuffer.writeBits(next.reserved2, 1);
            }
        }
    }

    public List<Entry> getEntries() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.entries;
    }

    public void setEntries(List<Entry> list) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, list);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.entries = list;
    }

    public void addEntry(Entry entry) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this, entry);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.entries.add(entry);
    }

    public int getDataRate() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.dataRate;
    }

    public int getNumIndSub() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.numIndSub;
    }

    public static class Entry {
        public int acmod;
        public int bsid;
        public int bsmod;
        public int chan_loc;
        public int fscod;
        public int lfeon;
        public int num_dep_sub;
        public int reserved;
        public int reserved2;

        public String toString() {
            return "Entry{fscod=" + this.fscod + ", bsid=" + this.bsid + ", bsmod=" + this.bsmod + ", acmod=" + this.acmod + ", lfeon=" + this.lfeon + ", reserved=" + this.reserved + ", num_dep_sub=" + this.num_dep_sub + ", chan_loc=" + this.chan_loc + ", reserved2=" + this.reserved2 + '}';
        }
    }

    public void setDataRate(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.dataRate = i;
    }

    public void setNumIndSub(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.numIndSub = i;
    }
}
