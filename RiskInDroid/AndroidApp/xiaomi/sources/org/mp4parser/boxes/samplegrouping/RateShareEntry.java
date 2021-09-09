package org.mp4parser.boxes.samplegrouping;

import _m_j.jkv;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

public class RateShareEntry extends GroupEntry {
    private short discardPriority;
    private List<Entry> entries = new LinkedList();
    private int maximumBitrate;
    private int minimumBitrate;
    private short operationPointCut;
    private short targetRateShare;

    public String getType() {
        return "rash";
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    public void parse(ByteBuffer byteBuffer) {
        this.operationPointCut = byteBuffer.getShort();
        short s = this.operationPointCut;
        if (s == 1) {
            this.targetRateShare = byteBuffer.getShort();
        } else {
            while (true) {
                ? r1 = s - 1;
                if (s <= 0) {
                    break;
                }
                this.entries.add(new Entry(jkv.O000000o(jky.O000000o(byteBuffer)), byteBuffer.getShort()));
                s = r1;
            }
        }
        this.maximumBitrate = jkv.O000000o(jky.O000000o(byteBuffer));
        this.minimumBitrate = jkv.O000000o(jky.O000000o(byteBuffer));
        this.discardPriority = (short) jky.O000000o(byteBuffer.get());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jla.O00000o(java.nio.ByteBuffer, int):void
     arg types: [java.nio.ByteBuffer, short]
     candidates:
      _m_j.jla.O00000o(java.nio.ByteBuffer, long):void
      _m_j.jla.O00000o(java.nio.ByteBuffer, int):void */
    public ByteBuffer get() {
        short s = this.operationPointCut;
        ByteBuffer allocate = ByteBuffer.allocate(s == 1 ? 13 : (s * 6) + 11);
        allocate.putShort(this.operationPointCut);
        if (this.operationPointCut == 1) {
            allocate.putShort(this.targetRateShare);
        } else {
            for (Entry next : this.entries) {
                allocate.putInt(next.getAvailableBitrate());
                allocate.putShort(next.getTargetRateShare());
            }
        }
        allocate.putInt(this.maximumBitrate);
        allocate.putInt(this.minimumBitrate);
        jla.O00000o(allocate, (int) this.discardPriority);
        allocate.rewind();
        return allocate;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RateShareEntry rateShareEntry = (RateShareEntry) obj;
        if (this.discardPriority != rateShareEntry.discardPriority || this.maximumBitrate != rateShareEntry.maximumBitrate || this.minimumBitrate != rateShareEntry.minimumBitrate || this.operationPointCut != rateShareEntry.operationPointCut || this.targetRateShare != rateShareEntry.targetRateShare) {
            return false;
        }
        List<Entry> list = this.entries;
        return list == null ? rateShareEntry.entries == null : list.equals(rateShareEntry.entries);
    }

    public int hashCode() {
        int i = ((this.operationPointCut * 31) + this.targetRateShare) * 31;
        List<Entry> list = this.entries;
        return ((((((i + (list != null ? list.hashCode() : 0)) * 31) + this.maximumBitrate) * 31) + this.minimumBitrate) * 31) + this.discardPriority;
    }

    public short getOperationPointCut() {
        return this.operationPointCut;
    }

    public void setOperationPointCut(short s) {
        this.operationPointCut = s;
    }

    public short getTargetRateShare() {
        return this.targetRateShare;
    }

    public void setTargetRateShare(short s) {
        this.targetRateShare = s;
    }

    public List<Entry> getEntries() {
        return this.entries;
    }

    public void setEntries(List<Entry> list) {
        this.entries = list;
    }

    public int getMaximumBitrate() {
        return this.maximumBitrate;
    }

    public void setMaximumBitrate(int i) {
        this.maximumBitrate = i;
    }

    public int getMinimumBitrate() {
        return this.minimumBitrate;
    }

    public void setMinimumBitrate(int i) {
        this.minimumBitrate = i;
    }

    public short getDiscardPriority() {
        return this.discardPriority;
    }

    public void setDiscardPriority(short s) {
        this.discardPriority = s;
    }

    public static class Entry {
        int availableBitrate;
        short targetRateShare;

        public Entry(int i, short s) {
            this.availableBitrate = i;
            this.targetRateShare = s;
        }

        public String toString() {
            return "{availableBitrate=" + this.availableBitrate + ", targetRateShare=" + ((int) this.targetRateShare) + '}';
        }

        public int getAvailableBitrate() {
            return this.availableBitrate;
        }

        public void setAvailableBitrate(int i) {
            this.availableBitrate = i;
        }

        public short getTargetRateShare() {
            return this.targetRateShare;
        }

        public void setTargetRateShare(short s) {
            this.targetRateShare = s;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.availableBitrate == entry.availableBitrate && this.targetRateShare == entry.targetRateShare;
        }

        public int hashCode() {
            return (this.availableBitrate * 31) + this.targetRateShare;
        }
    }
}
