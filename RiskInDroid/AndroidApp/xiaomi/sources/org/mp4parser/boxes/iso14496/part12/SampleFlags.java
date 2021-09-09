package org.mp4parser.boxes.iso14496.part12;

import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;

public class SampleFlags {
    private byte isLeading;
    private byte reserved;
    private int sampleDegradationPriority;
    private byte sampleDependsOn;
    private byte sampleHasRedundancy;
    private byte sampleIsDependedOn;
    private boolean sampleIsDifferenceSample;
    private byte samplePaddingValue;

    public SampleFlags() {
    }

    public SampleFlags(ByteBuffer byteBuffer) {
        long O000000o2 = jky.O000000o(byteBuffer);
        this.reserved = (byte) ((int) ((-268435456 & O000000o2) >> 28));
        this.isLeading = (byte) ((int) ((201326592 & O000000o2) >> 26));
        this.sampleDependsOn = (byte) ((int) ((50331648 & O000000o2) >> 24));
        this.sampleIsDependedOn = (byte) ((int) ((12582912 & O000000o2) >> 22));
        this.sampleHasRedundancy = (byte) ((int) ((3145728 & O000000o2) >> 20));
        this.samplePaddingValue = (byte) ((int) ((917504 & O000000o2) >> 17));
        this.sampleIsDifferenceSample = ((65536 & O000000o2) >> 16) > 0;
        this.sampleDegradationPriority = (int) (O000000o2 & 65535);
    }

    public void getContent(ByteBuffer byteBuffer) {
        jla.O00000Oo(byteBuffer, ((long) (this.reserved << 28)) | 0 | ((long) (this.isLeading << 26)) | ((long) (this.sampleDependsOn << 24)) | ((long) (this.sampleIsDependedOn << 22)) | ((long) (this.sampleHasRedundancy << 20)) | ((long) (this.samplePaddingValue << 17)) | ((long) ((this.sampleIsDifferenceSample ? 1 : 0) << true)) | ((long) this.sampleDegradationPriority));
    }

    public int getReserved() {
        return this.reserved;
    }

    public void setReserved(int i) {
        this.reserved = (byte) i;
    }

    public byte getIsLeading() {
        return this.isLeading;
    }

    public void setIsLeading(byte b) {
        this.isLeading = b;
    }

    public int getSampleDependsOn() {
        return this.sampleDependsOn;
    }

    public void setSampleDependsOn(int i) {
        this.sampleDependsOn = (byte) i;
    }

    public int getSampleIsDependedOn() {
        return this.sampleIsDependedOn;
    }

    public void setSampleIsDependedOn(int i) {
        this.sampleIsDependedOn = (byte) i;
    }

    public int getSampleHasRedundancy() {
        return this.sampleHasRedundancy;
    }

    public void setSampleHasRedundancy(int i) {
        this.sampleHasRedundancy = (byte) i;
    }

    public int getSamplePaddingValue() {
        return this.samplePaddingValue;
    }

    public void setSamplePaddingValue(int i) {
        this.samplePaddingValue = (byte) i;
    }

    public boolean isSampleIsDifferenceSample() {
        return this.sampleIsDifferenceSample;
    }

    public void setSampleIsDifferenceSample(boolean z) {
        this.sampleIsDifferenceSample = z;
    }

    public int getSampleDegradationPriority() {
        return this.sampleDegradationPriority;
    }

    public void setSampleDegradationPriority(int i) {
        this.sampleDegradationPriority = i;
    }

    public String toString() {
        return "SampleFlags{reserved=" + ((int) this.reserved) + ", isLeading=" + ((int) this.isLeading) + ", depOn=" + ((int) this.sampleDependsOn) + ", isDepOn=" + ((int) this.sampleIsDependedOn) + ", hasRedundancy=" + ((int) this.sampleHasRedundancy) + ", padValue=" + ((int) this.samplePaddingValue) + ", isDiffSample=" + this.sampleIsDifferenceSample + ", degradPrio=" + this.sampleDegradationPriority + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SampleFlags sampleFlags = (SampleFlags) obj;
        return this.isLeading == sampleFlags.isLeading && this.reserved == sampleFlags.reserved && this.sampleDegradationPriority == sampleFlags.sampleDegradationPriority && this.sampleDependsOn == sampleFlags.sampleDependsOn && this.sampleHasRedundancy == sampleFlags.sampleHasRedundancy && this.sampleIsDependedOn == sampleFlags.sampleIsDependedOn && this.sampleIsDifferenceSample == sampleFlags.sampleIsDifferenceSample && this.samplePaddingValue == sampleFlags.samplePaddingValue;
    }

    public int hashCode() {
        return (((((((((((((this.reserved * 31) + this.isLeading) * 31) + this.sampleDependsOn) * 31) + this.sampleIsDependedOn) * 31) + this.sampleHasRedundancy) * 31) + this.samplePaddingValue) * 31) + (this.sampleIsDifferenceSample ? 1 : 0)) * 31) + this.sampleDegradationPriority;
    }
}
