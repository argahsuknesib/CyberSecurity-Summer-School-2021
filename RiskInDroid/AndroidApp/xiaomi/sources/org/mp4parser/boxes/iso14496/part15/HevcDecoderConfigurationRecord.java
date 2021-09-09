package org.mp4parser.boxes.iso14496.part15;

import _m_j.jky;
import _m_j.jla;
import android.support.v4.app.NotificationCompat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class HevcDecoderConfigurationRecord {
    List<Array> arrays = new ArrayList();
    int avgFrameRate;
    int bitDepthChromaMinus8;
    int bitDepthLumaMinus8;
    int chromaFormat;
    int configurationVersion;
    int constantFrameRate;
    boolean frame_only_constraint_flag;
    long general_constraint_indicator_flags;
    int general_level_idc;
    long general_profile_compatibility_flags;
    int general_profile_idc;
    int general_profile_space;
    boolean general_tier_flag;
    boolean interlaced_source_flag;
    int lengthSizeMinusOne;
    int min_spatial_segmentation_idc;
    boolean non_packed_constraint_flag;
    int numTemporalLayers;
    int parallelismType;
    boolean progressive_source_flag;
    int reserved1 = 15;
    int reserved2 = 63;
    int reserved3 = 63;
    int reserved4 = 31;
    int reserved5 = 31;
    boolean temporalIdNested;

    public void write(ByteBuffer byteBuffer) {
        jla.O00000o(byteBuffer, this.configurationVersion);
        jla.O00000o(byteBuffer, (this.general_profile_space << 6) + (this.general_tier_flag ? 32 : 0) + this.general_profile_idc);
        jla.O00000Oo(byteBuffer, this.general_profile_compatibility_flags);
        long j = this.general_constraint_indicator_flags;
        if (this.frame_only_constraint_flag) {
            j |= 140737488355328L;
        }
        if (this.non_packed_constraint_flag) {
            j |= 70368744177664L;
        }
        if (this.interlaced_source_flag) {
            j |= 35184372088832L;
        }
        if (this.progressive_source_flag) {
            j |= 17592186044416L;
        }
        jla.O00000o(byteBuffer, j);
        jla.O00000o(byteBuffer, this.general_level_idc);
        jla.O00000Oo(byteBuffer, (this.reserved1 << 12) + this.min_spatial_segmentation_idc);
        jla.O00000o(byteBuffer, (this.reserved2 << 2) + this.parallelismType);
        jla.O00000o(byteBuffer, (this.reserved3 << 2) + this.chromaFormat);
        jla.O00000o(byteBuffer, (this.reserved4 << 3) + this.bitDepthLumaMinus8);
        jla.O00000o(byteBuffer, (this.reserved5 << 3) + this.bitDepthChromaMinus8);
        jla.O00000Oo(byteBuffer, this.avgFrameRate);
        jla.O00000o(byteBuffer, (this.constantFrameRate << 6) + (this.numTemporalLayers << 3) + (this.temporalIdNested ? 4 : 0) + this.lengthSizeMinusOne);
        jla.O00000o(byteBuffer, this.arrays.size());
        for (Array next : this.arrays) {
            jla.O00000o(byteBuffer, (next.array_completeness ? NotificationCompat.FLAG_HIGH_PRIORITY : 0) + (next.reserved ? 64 : 0) + next.nal_unit_type);
            jla.O00000Oo(byteBuffer, next.nalUnits.size());
            for (byte[] next2 : next.nalUnits) {
                jla.O00000Oo(byteBuffer, next2.length);
                byteBuffer.put(next2);
            }
        }
    }

    public int getSize() {
        int i = 23;
        for (Array array : this.arrays) {
            i += 3;
            for (byte[] length : array.nalUnits) {
                i = i + 2 + length.length;
            }
        }
        return i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HevcDecoderConfigurationRecord hevcDecoderConfigurationRecord = (HevcDecoderConfigurationRecord) obj;
        if (this.avgFrameRate != hevcDecoderConfigurationRecord.avgFrameRate || this.bitDepthChromaMinus8 != hevcDecoderConfigurationRecord.bitDepthChromaMinus8 || this.bitDepthLumaMinus8 != hevcDecoderConfigurationRecord.bitDepthLumaMinus8 || this.chromaFormat != hevcDecoderConfigurationRecord.chromaFormat || this.configurationVersion != hevcDecoderConfigurationRecord.configurationVersion || this.constantFrameRate != hevcDecoderConfigurationRecord.constantFrameRate || this.general_constraint_indicator_flags != hevcDecoderConfigurationRecord.general_constraint_indicator_flags || this.general_level_idc != hevcDecoderConfigurationRecord.general_level_idc || this.general_profile_compatibility_flags != hevcDecoderConfigurationRecord.general_profile_compatibility_flags || this.general_profile_idc != hevcDecoderConfigurationRecord.general_profile_idc || this.general_profile_space != hevcDecoderConfigurationRecord.general_profile_space || this.general_tier_flag != hevcDecoderConfigurationRecord.general_tier_flag || this.lengthSizeMinusOne != hevcDecoderConfigurationRecord.lengthSizeMinusOne || this.min_spatial_segmentation_idc != hevcDecoderConfigurationRecord.min_spatial_segmentation_idc || this.numTemporalLayers != hevcDecoderConfigurationRecord.numTemporalLayers || this.parallelismType != hevcDecoderConfigurationRecord.parallelismType || this.reserved1 != hevcDecoderConfigurationRecord.reserved1 || this.reserved2 != hevcDecoderConfigurationRecord.reserved2 || this.reserved3 != hevcDecoderConfigurationRecord.reserved3 || this.reserved4 != hevcDecoderConfigurationRecord.reserved4 || this.reserved5 != hevcDecoderConfigurationRecord.reserved5 || this.temporalIdNested != hevcDecoderConfigurationRecord.temporalIdNested) {
            return false;
        }
        List<Array> list = this.arrays;
        return list == null ? hevcDecoderConfigurationRecord.arrays == null : list.equals(hevcDecoderConfigurationRecord.arrays);
    }

    public int hashCode() {
        long j = this.general_profile_compatibility_flags;
        long j2 = this.general_constraint_indicator_flags;
        int i = ((((((((((((((((((((((((((((((((((((((((((this.configurationVersion * 31) + this.general_profile_space) * 31) + (this.general_tier_flag ? 1 : 0)) * 31) + this.general_profile_idc) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.general_level_idc) * 31) + this.reserved1) * 31) + this.min_spatial_segmentation_idc) * 31) + this.reserved2) * 31) + this.parallelismType) * 31) + this.reserved3) * 31) + this.chromaFormat) * 31) + this.reserved4) * 31) + this.bitDepthLumaMinus8) * 31) + this.reserved5) * 31) + this.bitDepthChromaMinus8) * 31) + this.avgFrameRate) * 31) + this.constantFrameRate) * 31) + this.numTemporalLayers) * 31) + (this.temporalIdNested ? 1 : 0)) * 31) + this.lengthSizeMinusOne) * 31;
        List<Array> list = this.arrays;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        String str;
        String str2;
        String str3;
        String str4;
        StringBuilder sb = new StringBuilder("HEVCDecoderConfigurationRecord{configurationVersion=");
        sb.append(this.configurationVersion);
        sb.append(", general_profile_space=");
        sb.append(this.general_profile_space);
        sb.append(", general_tier_flag=");
        sb.append(this.general_tier_flag);
        sb.append(", general_profile_idc=");
        sb.append(this.general_profile_idc);
        sb.append(", general_profile_compatibility_flags=");
        sb.append(this.general_profile_compatibility_flags);
        sb.append(", general_constraint_indicator_flags=");
        sb.append(this.general_constraint_indicator_flags);
        sb.append(", general_level_idc=");
        sb.append(this.general_level_idc);
        String str5 = "";
        if (this.reserved1 != 15) {
            str = ", reserved1=" + this.reserved1;
        } else {
            str = str5;
        }
        sb.append(str);
        sb.append(", min_spatial_segmentation_idc=");
        sb.append(this.min_spatial_segmentation_idc);
        if (this.reserved2 != 63) {
            str2 = ", reserved2=" + this.reserved2;
        } else {
            str2 = str5;
        }
        sb.append(str2);
        sb.append(", parallelismType=");
        sb.append(this.parallelismType);
        if (this.reserved3 != 63) {
            str3 = ", reserved3=" + this.reserved3;
        } else {
            str3 = str5;
        }
        sb.append(str3);
        sb.append(", chromaFormat=");
        sb.append(this.chromaFormat);
        if (this.reserved4 != 31) {
            str4 = ", reserved4=" + this.reserved4;
        } else {
            str4 = str5;
        }
        sb.append(str4);
        sb.append(", bitDepthLumaMinus8=");
        sb.append(this.bitDepthLumaMinus8);
        if (this.reserved5 != 31) {
            str5 = ", reserved5=" + this.reserved5;
        }
        sb.append(str5);
        sb.append(", bitDepthChromaMinus8=");
        sb.append(this.bitDepthChromaMinus8);
        sb.append(", avgFrameRate=");
        sb.append(this.avgFrameRate);
        sb.append(", constantFrameRate=");
        sb.append(this.constantFrameRate);
        sb.append(", numTemporalLayers=");
        sb.append(this.numTemporalLayers);
        sb.append(", temporalIdNested=");
        sb.append(this.temporalIdNested);
        sb.append(", lengthSizeMinusOne=");
        sb.append(this.lengthSizeMinusOne);
        sb.append(", arrays=");
        sb.append(this.arrays);
        sb.append('}');
        return sb.toString();
    }

    public int getConfigurationVersion() {
        return this.configurationVersion;
    }

    public void setConfigurationVersion(int i) {
        this.configurationVersion = i;
    }

    public int getGeneral_profile_space() {
        return this.general_profile_space;
    }

    public void setGeneral_profile_space(int i) {
        this.general_profile_space = i;
    }

    public boolean isGeneral_tier_flag() {
        return this.general_tier_flag;
    }

    public void setGeneral_tier_flag(boolean z) {
        this.general_tier_flag = z;
    }

    public int getGeneral_profile_idc() {
        return this.general_profile_idc;
    }

    public void setGeneral_profile_idc(int i) {
        this.general_profile_idc = i;
    }

    public long getGeneral_profile_compatibility_flags() {
        return this.general_profile_compatibility_flags;
    }

    public void setGeneral_profile_compatibility_flags(long j) {
        this.general_profile_compatibility_flags = j;
    }

    public long getGeneral_constraint_indicator_flags() {
        return this.general_constraint_indicator_flags;
    }

    public void setGeneral_constraint_indicator_flags(long j) {
        this.general_constraint_indicator_flags = j;
    }

    public int getGeneral_level_idc() {
        return this.general_level_idc;
    }

    public void setGeneral_level_idc(int i) {
        this.general_level_idc = i;
    }

    public int getMin_spatial_segmentation_idc() {
        return this.min_spatial_segmentation_idc;
    }

    public void setMin_spatial_segmentation_idc(int i) {
        this.min_spatial_segmentation_idc = i;
    }

    public int getParallelismType() {
        return this.parallelismType;
    }

    public void setParallelismType(int i) {
        this.parallelismType = i;
    }

    public int getChromaFormat() {
        return this.chromaFormat;
    }

    public void setChromaFormat(int i) {
        this.chromaFormat = i;
    }

    public int getBitDepthLumaMinus8() {
        return this.bitDepthLumaMinus8;
    }

    public void setBitDepthLumaMinus8(int i) {
        this.bitDepthLumaMinus8 = i;
    }

    public int getBitDepthChromaMinus8() {
        return this.bitDepthChromaMinus8;
    }

    public void setBitDepthChromaMinus8(int i) {
        this.bitDepthChromaMinus8 = i;
    }

    public int getAvgFrameRate() {
        return this.avgFrameRate;
    }

    public void setAvgFrameRate(int i) {
        this.avgFrameRate = i;
    }

    public int getNumTemporalLayers() {
        return this.numTemporalLayers;
    }

    public void setNumTemporalLayers(int i) {
        this.numTemporalLayers = i;
    }

    public int getLengthSizeMinusOne() {
        return this.lengthSizeMinusOne;
    }

    public void setLengthSizeMinusOne(int i) {
        this.lengthSizeMinusOne = i;
    }

    public boolean isTemporalIdNested() {
        return this.temporalIdNested;
    }

    public void setTemporalIdNested(boolean z) {
        this.temporalIdNested = z;
    }

    public int getConstantFrameRate() {
        return this.constantFrameRate;
    }

    public void setConstantFrameRate(int i) {
        this.constantFrameRate = i;
    }

    public List<Array> getArrays() {
        return this.arrays;
    }

    public void setArrays(List<Array> list) {
        this.arrays = list;
    }

    public boolean isFrame_only_constraint_flag() {
        return this.frame_only_constraint_flag;
    }

    public void setFrame_only_constraint_flag(boolean z) {
        this.frame_only_constraint_flag = z;
    }

    public boolean isNon_packed_constraint_flag() {
        return this.non_packed_constraint_flag;
    }

    public void setNon_packed_constraint_flag(boolean z) {
        this.non_packed_constraint_flag = z;
    }

    public boolean isInterlaced_source_flag() {
        return this.interlaced_source_flag;
    }

    public void setInterlaced_source_flag(boolean z) {
        this.interlaced_source_flag = z;
    }

    public boolean isProgressive_source_flag() {
        return this.progressive_source_flag;
    }

    public void setProgressive_source_flag(boolean z) {
        this.progressive_source_flag = z;
    }

    public static class Array {
        public boolean array_completeness;
        public List<byte[]> nalUnits;
        public int nal_unit_type;
        public boolean reserved;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                Array array = (Array) obj;
                if (this.array_completeness != array.array_completeness || this.nal_unit_type != array.nal_unit_type || this.reserved != array.reserved) {
                    return false;
                }
                ListIterator<byte[]> listIterator = this.nalUnits.listIterator();
                ListIterator<byte[]> listIterator2 = array.nalUnits.listIterator();
                while (listIterator.hasNext() && listIterator2.hasNext()) {
                    byte[] next = listIterator.next();
                    byte[] next2 = listIterator2.next();
                    if (next == null) {
                        if (next2 != null) {
                        }
                    } else if (!Arrays.equals(next, next2)) {
                    }
                    return false;
                }
                return !listIterator.hasNext() && !listIterator2.hasNext();
            }
        }

        public int hashCode() {
            int i = (((((this.array_completeness ? 1 : 0) * true) + (this.reserved ? 1 : 0)) * 31) + this.nal_unit_type) * 31;
            List<byte[]> list = this.nalUnits;
            return i + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "Array{nal_unit_type=" + this.nal_unit_type + ", reserved=" + this.reserved + ", array_completeness=" + this.array_completeness + ", num_nals=" + this.nalUnits.size() + '}';
        }
    }

    public void parse(ByteBuffer byteBuffer) {
        this.configurationVersion = jky.O000000o(byteBuffer.get());
        int O000000o2 = jky.O000000o(byteBuffer.get());
        this.general_profile_space = (O000000o2 & 192) >> 6;
        this.general_tier_flag = (O000000o2 & 32) > 0;
        this.general_profile_idc = O000000o2 & 31;
        this.general_profile_compatibility_flags = jky.O000000o(byteBuffer);
        this.general_constraint_indicator_flags = jky.O0000Ooo(byteBuffer);
        this.frame_only_constraint_flag = ((this.general_constraint_indicator_flags >> 44) & 8) > 0;
        this.non_packed_constraint_flag = ((this.general_constraint_indicator_flags >> 44) & 4) > 0;
        this.interlaced_source_flag = ((this.general_constraint_indicator_flags >> 44) & 2) > 0;
        this.progressive_source_flag = ((this.general_constraint_indicator_flags >> 44) & 1) > 0;
        this.general_constraint_indicator_flags &= 140737488355327L;
        this.general_level_idc = jky.O000000o(byteBuffer.get());
        int O00000o0 = jky.O00000o0(byteBuffer);
        this.reserved1 = (61440 & O00000o0) >> 12;
        this.min_spatial_segmentation_idc = O00000o0 & 4095;
        int O000000o3 = jky.O000000o(byteBuffer.get());
        this.reserved2 = (O000000o3 & 252) >> 2;
        this.parallelismType = O000000o3 & 3;
        int O000000o4 = jky.O000000o(byteBuffer.get());
        this.reserved3 = (O000000o4 & 252) >> 2;
        this.chromaFormat = O000000o4 & 3;
        int O000000o5 = jky.O000000o(byteBuffer.get());
        this.reserved4 = (O000000o5 & 248) >> 3;
        this.bitDepthLumaMinus8 = O000000o5 & 7;
        int O000000o6 = jky.O000000o(byteBuffer.get());
        this.reserved5 = (O000000o6 & 248) >> 3;
        this.bitDepthChromaMinus8 = O000000o6 & 7;
        this.avgFrameRate = jky.O00000o0(byteBuffer);
        int O000000o7 = jky.O000000o(byteBuffer.get());
        this.constantFrameRate = (O000000o7 & 192) >> 6;
        this.numTemporalLayers = (O000000o7 & 56) >> 3;
        this.temporalIdNested = (O000000o7 & 4) > 0;
        this.lengthSizeMinusOne = O000000o7 & 3;
        int O000000o8 = jky.O000000o(byteBuffer.get());
        this.arrays = new ArrayList();
        for (int i = 0; i < O000000o8; i++) {
            Array array = new Array();
            int O000000o9 = jky.O000000o(byteBuffer.get());
            array.array_completeness = (O000000o9 & NotificationCompat.FLAG_HIGH_PRIORITY) > 0;
            array.reserved = (O000000o9 & 64) > 0;
            array.nal_unit_type = O000000o9 & 63;
            int O00000o02 = jky.O00000o0(byteBuffer);
            array.nalUnits = new ArrayList();
            for (int i2 = 0; i2 < O00000o02; i2++) {
                byte[] bArr = new byte[jky.O00000o0(byteBuffer)];
                byteBuffer.get(bArr);
                array.nalUnits.add(bArr);
            }
            this.arrays.add(array);
        }
    }
}
