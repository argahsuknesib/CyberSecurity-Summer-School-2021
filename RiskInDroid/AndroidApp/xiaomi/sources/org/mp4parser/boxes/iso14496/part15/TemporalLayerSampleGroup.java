package org.mp4parser.boxes.iso14496.part15;

import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;
import org.mp4parser.boxes.samplegrouping.GroupEntry;

public class TemporalLayerSampleGroup extends GroupEntry {
    int temporalLayerId;
    int tlAvgBitRate;
    int tlAvgFrameRate;
    int tlConstantFrameRate;
    int tlMaxBitRate;
    long tlconstraint_indicator_flags;
    int tllevel_idc;
    long tlprofile_compatibility_flags;
    int tlprofile_idc;
    int tlprofile_space;
    boolean tltier_flag;

    public String getType() {
        return "tscl";
    }

    public int size() {
        return 20;
    }

    public int getTemporalLayerId() {
        return this.temporalLayerId;
    }

    public void setTemporalLayerId(int i) {
        this.temporalLayerId = i;
    }

    public int getTlprofile_space() {
        return this.tlprofile_space;
    }

    public void setTlprofile_space(int i) {
        this.tlprofile_space = i;
    }

    public boolean isTltier_flag() {
        return this.tltier_flag;
    }

    public void setTltier_flag(boolean z) {
        this.tltier_flag = z;
    }

    public int getTlprofile_idc() {
        return this.tlprofile_idc;
    }

    public void setTlprofile_idc(int i) {
        this.tlprofile_idc = i;
    }

    public long getTlprofile_compatibility_flags() {
        return this.tlprofile_compatibility_flags;
    }

    public void setTlprofile_compatibility_flags(long j) {
        this.tlprofile_compatibility_flags = j;
    }

    public long getTlconstraint_indicator_flags() {
        return this.tlconstraint_indicator_flags;
    }

    public void setTlconstraint_indicator_flags(long j) {
        this.tlconstraint_indicator_flags = j;
    }

    public int getTllevel_idc() {
        return this.tllevel_idc;
    }

    public void setTllevel_idc(int i) {
        this.tllevel_idc = i;
    }

    public int getTlMaxBitRate() {
        return this.tlMaxBitRate;
    }

    public void setTlMaxBitRate(int i) {
        this.tlMaxBitRate = i;
    }

    public int getTlAvgBitRate() {
        return this.tlAvgBitRate;
    }

    public void setTlAvgBitRate(int i) {
        this.tlAvgBitRate = i;
    }

    public int getTlConstantFrameRate() {
        return this.tlConstantFrameRate;
    }

    public void setTlConstantFrameRate(int i) {
        this.tlConstantFrameRate = i;
    }

    public int getTlAvgFrameRate() {
        return this.tlAvgFrameRate;
    }

    public void setTlAvgFrameRate(int i) {
        this.tlAvgFrameRate = i;
    }

    public ByteBuffer get() {
        ByteBuffer allocate = ByteBuffer.allocate(20);
        jla.O00000o(allocate, this.temporalLayerId);
        jla.O00000o(allocate, (this.tlprofile_space << 6) + (this.tltier_flag ? 32 : 0) + this.tlprofile_idc);
        jla.O00000Oo(allocate, this.tlprofile_compatibility_flags);
        jla.O00000o(allocate, this.tlconstraint_indicator_flags);
        jla.O00000o(allocate, this.tllevel_idc);
        jla.O00000Oo(allocate, this.tlMaxBitRate);
        jla.O00000Oo(allocate, this.tlAvgBitRate);
        jla.O00000o(allocate, this.tlConstantFrameRate);
        jla.O00000Oo(allocate, this.tlAvgFrameRate);
        return (ByteBuffer) allocate.rewind();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TemporalLayerSampleGroup temporalLayerSampleGroup = (TemporalLayerSampleGroup) obj;
        return this.temporalLayerId == temporalLayerSampleGroup.temporalLayerId && this.tlAvgBitRate == temporalLayerSampleGroup.tlAvgBitRate && this.tlAvgFrameRate == temporalLayerSampleGroup.tlAvgFrameRate && this.tlConstantFrameRate == temporalLayerSampleGroup.tlConstantFrameRate && this.tlMaxBitRate == temporalLayerSampleGroup.tlMaxBitRate && this.tlconstraint_indicator_flags == temporalLayerSampleGroup.tlconstraint_indicator_flags && this.tllevel_idc == temporalLayerSampleGroup.tllevel_idc && this.tlprofile_compatibility_flags == temporalLayerSampleGroup.tlprofile_compatibility_flags && this.tlprofile_idc == temporalLayerSampleGroup.tlprofile_idc && this.tlprofile_space == temporalLayerSampleGroup.tlprofile_space && this.tltier_flag == temporalLayerSampleGroup.tltier_flag;
    }

    public int hashCode() {
        long j = this.tlprofile_compatibility_flags;
        long j2 = this.tlconstraint_indicator_flags;
        return (((((((((((((((((((this.temporalLayerId * 31) + this.tlprofile_space) * 31) + (this.tltier_flag ? 1 : 0)) * 31) + this.tlprofile_idc) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.tllevel_idc) * 31) + this.tlMaxBitRate) * 31) + this.tlAvgBitRate) * 31) + this.tlConstantFrameRate) * 31) + this.tlAvgFrameRate;
    }

    public String toString() {
        return "TemporalLayerSampleGroup{temporalLayerId=" + this.temporalLayerId + ", tlprofile_space=" + this.tlprofile_space + ", tltier_flag=" + this.tltier_flag + ", tlprofile_idc=" + this.tlprofile_idc + ", tlprofile_compatibility_flags=" + this.tlprofile_compatibility_flags + ", tlconstraint_indicator_flags=" + this.tlconstraint_indicator_flags + ", tllevel_idc=" + this.tllevel_idc + ", tlMaxBitRate=" + this.tlMaxBitRate + ", tlAvgBitRate=" + this.tlAvgBitRate + ", tlConstantFrameRate=" + this.tlConstantFrameRate + ", tlAvgFrameRate=" + this.tlAvgFrameRate + '}';
    }

    public void parse(ByteBuffer byteBuffer) {
        this.temporalLayerId = jky.O000000o(byteBuffer.get());
        int O000000o2 = jky.O000000o(byteBuffer.get());
        this.tlprofile_space = (O000000o2 & 192) >> 6;
        this.tltier_flag = (O000000o2 & 32) > 0;
        this.tlprofile_idc = O000000o2 & 31;
        this.tlprofile_compatibility_flags = jky.O000000o(byteBuffer);
        this.tlconstraint_indicator_flags = jky.O0000Ooo(byteBuffer);
        this.tllevel_idc = jky.O000000o(byteBuffer.get());
        this.tlMaxBitRate = jky.O00000o0(byteBuffer);
        this.tlAvgBitRate = jky.O00000o0(byteBuffer);
        this.tlConstantFrameRate = jky.O000000o(byteBuffer.get());
        this.tlAvgFrameRate = jky.O00000o0(byteBuffer);
    }
}
