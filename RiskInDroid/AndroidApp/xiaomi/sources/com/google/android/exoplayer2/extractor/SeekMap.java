package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.Assertions;

public interface SeekMap {
    long getDurationUs();

    SeekPoints getSeekPoints(long j);

    boolean isSeekable();

    public static class Unseekable implements SeekMap {
        private final long durationUs;
        private final SeekPoints startSeekPoints;

        public boolean isSeekable() {
            return false;
        }

        public Unseekable(long j) {
            this(j, 0);
        }

        public Unseekable(long j, long j2) {
            this.durationUs = j;
            this.startSeekPoints = new SeekPoints(j2 == 0 ? SeekPoint.START : new SeekPoint(0, j2));
        }

        public long getDurationUs() {
            return this.durationUs;
        }

        public SeekPoints getSeekPoints(long j) {
            return this.startSeekPoints;
        }
    }

    public static final class SeekPoints {
        public final SeekPoint first;
        public final SeekPoint second;

        public SeekPoints(SeekPoint seekPoint) {
            this(seekPoint, seekPoint);
        }

        public SeekPoints(SeekPoint seekPoint, SeekPoint seekPoint2) {
            this.first = (SeekPoint) Assertions.checkNotNull(seekPoint);
            this.second = (SeekPoint) Assertions.checkNotNull(seekPoint2);
        }

        public final String toString() {
            String str;
            StringBuilder sb = new StringBuilder("[");
            sb.append(this.first);
            if (this.first.equals(this.second)) {
                str = "";
            } else {
                str = ", " + this.second;
            }
            sb.append(str);
            sb.append("]");
            return sb.toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                SeekPoints seekPoints = (SeekPoints) obj;
                return this.first.equals(seekPoints.first) && this.second.equals(seekPoints.second);
            }
        }

        public final int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }
    }
}
