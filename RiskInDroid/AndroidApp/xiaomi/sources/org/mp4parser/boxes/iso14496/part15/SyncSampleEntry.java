package org.mp4parser.boxes.iso14496.part15;

import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;
import org.mp4parser.boxes.samplegrouping.GroupEntry;

public class SyncSampleEntry extends GroupEntry {
    int nalUnitType;
    int reserved;

    public String getType() {
        return "sync";
    }

    public ByteBuffer get() {
        ByteBuffer allocate = ByteBuffer.allocate(1);
        jla.O00000o(allocate, this.nalUnitType + (this.reserved << 6));
        return (ByteBuffer) allocate.rewind();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SyncSampleEntry syncSampleEntry = (SyncSampleEntry) obj;
        return this.nalUnitType == syncSampleEntry.nalUnitType && this.reserved == syncSampleEntry.reserved;
    }

    public int hashCode() {
        return (this.reserved * 31) + this.nalUnitType;
    }

    public int getReserved() {
        return this.reserved;
    }

    public void setReserved(int i) {
        this.reserved = i;
    }

    public int getNalUnitType() {
        return this.nalUnitType;
    }

    public void setNalUnitType(int i) {
        this.nalUnitType = i;
    }

    public String toString() {
        return "SyncSampleEntry{reserved=" + this.reserved + ", nalUnitType=" + this.nalUnitType + '}';
    }

    public void parse(ByteBuffer byteBuffer) {
        int O000000o2 = jky.O000000o(byteBuffer.get());
        this.reserved = (O000000o2 & 192) >> 6;
        this.nalUnitType = O000000o2 & 63;
    }
}
