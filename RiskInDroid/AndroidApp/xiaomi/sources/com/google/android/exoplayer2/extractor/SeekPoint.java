package com.google.android.exoplayer2.extractor;

public final class SeekPoint {
    public static final SeekPoint START = new SeekPoint(0, 0);
    public final long position;
    public final long timeUs;

    public SeekPoint(long j, long j2) {
        this.timeUs = j;
        this.position = j2;
    }

    public final String toString() {
        return "[timeUs=" + this.timeUs + ", position=" + this.position + "]";
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            SeekPoint seekPoint = (SeekPoint) obj;
            return this.timeUs == seekPoint.timeUs && this.position == seekPoint.position;
        }
    }

    public final int hashCode() {
        return (((int) this.timeUs) * 31) + ((int) this.position);
    }
}
