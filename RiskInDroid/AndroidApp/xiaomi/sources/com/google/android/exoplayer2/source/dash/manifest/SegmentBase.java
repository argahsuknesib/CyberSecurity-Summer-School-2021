package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.util.Util;
import java.util.List;

public abstract class SegmentBase {
    final RangedUri initialization;
    final long presentationTimeOffset;
    final long timescale;

    public SegmentBase(RangedUri rangedUri, long j, long j2) {
        this.initialization = rangedUri;
        this.timescale = j;
        this.presentationTimeOffset = j2;
    }

    public RangedUri getInitialization(Representation representation) {
        return this.initialization;
    }

    public long getPresentationTimeOffsetUs() {
        return Util.scaleLargeTimestamp(this.presentationTimeOffset, 1000000, this.timescale);
    }

    public static class SingleSegmentBase extends SegmentBase {
        final long indexLength;
        final long indexStart;

        public SingleSegmentBase(RangedUri rangedUri, long j, long j2, long j3, long j4) {
            super(rangedUri, j, j2);
            this.indexStart = j3;
            this.indexLength = j4;
        }

        public SingleSegmentBase() {
            this(null, 1, 0, 0, 0);
        }

        public RangedUri getIndex() {
            long j = this.indexLength;
            if (j <= 0) {
                return null;
            }
            return new RangedUri(null, this.indexStart, j);
        }
    }

    public static abstract class MultiSegmentBase extends SegmentBase {
        final long duration;
        final List<SegmentTimelineElement> segmentTimeline;
        final long startNumber;

        public abstract int getSegmentCount(long j);

        public abstract RangedUri getSegmentUrl(Representation representation, long j);

        public MultiSegmentBase(RangedUri rangedUri, long j, long j2, long j3, long j4, List<SegmentTimelineElement> list) {
            super(rangedUri, j, j2);
            this.startNumber = j3;
            this.duration = j4;
            this.segmentTimeline = list;
        }

        public long getSegmentNum(long j, long j2) {
            long firstSegmentNum = getFirstSegmentNum();
            long segmentCount = (long) getSegmentCount(j2);
            if (segmentCount == 0) {
                return firstSegmentNum;
            }
            if (this.segmentTimeline == null) {
                long j3 = this.startNumber + (j / ((this.duration * 1000000) / this.timescale));
                if (j3 < firstSegmentNum) {
                    return firstSegmentNum;
                }
                if (segmentCount == -1) {
                    return j3;
                }
                return Math.min(j3, (firstSegmentNum + segmentCount) - 1);
            }
            long j4 = (segmentCount + firstSegmentNum) - 1;
            long j5 = firstSegmentNum;
            while (j5 <= j4) {
                long j6 = ((j4 - j5) / 2) + j5;
                long segmentTimeUs = getSegmentTimeUs(j6);
                if (segmentTimeUs < j) {
                    j5 = j6 + 1;
                } else if (segmentTimeUs <= j) {
                    return j6;
                } else {
                    j4 = j6 - 1;
                }
            }
            return j5 == firstSegmentNum ? j5 : j4;
        }

        public final long getSegmentDurationUs(long j, long j2) {
            List<SegmentTimelineElement> list = this.segmentTimeline;
            if (list != null) {
                return (list.get((int) (j - this.startNumber)).duration * 1000000) / this.timescale;
            }
            int segmentCount = getSegmentCount(j2);
            return (segmentCount == -1 || j != (getFirstSegmentNum() + ((long) segmentCount)) - 1) ? (this.duration * 1000000) / this.timescale : j2 - getSegmentTimeUs(j);
        }

        public final long getSegmentTimeUs(long j) {
            long j2;
            List<SegmentTimelineElement> list = this.segmentTimeline;
            if (list != null) {
                j2 = list.get((int) (j - this.startNumber)).startTime - this.presentationTimeOffset;
            } else {
                j2 = (j - this.startNumber) * this.duration;
            }
            return Util.scaleLargeTimestamp(j2, 1000000, this.timescale);
        }

        public long getFirstSegmentNum() {
            return this.startNumber;
        }

        public boolean isExplicit() {
            return this.segmentTimeline != null;
        }
    }

    public static final class SegmentList extends MultiSegmentBase {
        final List<RangedUri> mediaSegments;

        public final boolean isExplicit() {
            return true;
        }

        public SegmentList(RangedUri rangedUri, long j, long j2, long j3, long j4, List<SegmentTimelineElement> list, List<RangedUri> list2) {
            super(rangedUri, j, j2, j3, j4, list);
            this.mediaSegments = list2;
        }

        public final RangedUri getSegmentUrl(Representation representation, long j) {
            return this.mediaSegments.get((int) (j - this.startNumber));
        }

        public final int getSegmentCount(long j) {
            return this.mediaSegments.size();
        }
    }

    public static final class SegmentTemplate extends MultiSegmentBase {
        final long endNumber;
        final UrlTemplate initializationTemplate;
        final UrlTemplate mediaTemplate;

        public SegmentTemplate(RangedUri rangedUri, long j, long j2, long j3, long j4, long j5, List<SegmentTimelineElement> list, UrlTemplate urlTemplate, UrlTemplate urlTemplate2) {
            super(rangedUri, j, j2, j3, j5, list);
            this.initializationTemplate = urlTemplate;
            this.mediaTemplate = urlTemplate2;
            this.endNumber = j4;
        }

        public final RangedUri getInitialization(Representation representation) {
            UrlTemplate urlTemplate = this.initializationTemplate;
            if (urlTemplate != null) {
                return new RangedUri(urlTemplate.buildUri(representation.format.id, 0, representation.format.bitrate, 0), 0, -1);
            }
            return super.getInitialization(representation);
        }

        public final RangedUri getSegmentUrl(Representation representation, long j) {
            long j2;
            Representation representation2 = representation;
            if (this.segmentTimeline != null) {
                j2 = ((SegmentTimelineElement) this.segmentTimeline.get((int) (j - this.startNumber))).startTime;
            } else {
                j2 = (j - this.startNumber) * this.duration;
            }
            long j3 = j2;
            return new RangedUri(this.mediaTemplate.buildUri(representation2.format.id, j, representation2.format.bitrate, j3), 0, -1);
        }

        public final int getSegmentCount(long j) {
            if (this.segmentTimeline != null) {
                return this.segmentTimeline.size();
            }
            long j2 = this.endNumber;
            if (j2 != -1) {
                return (int) ((j2 - this.startNumber) + 1);
            }
            if (j != -9223372036854775807L) {
                return (int) Util.ceilDivide(j, (this.duration * 1000000) / this.timescale);
            }
            return -1;
        }
    }

    public static final class SegmentTimelineElement {
        final long duration;
        final long startTime;

        public SegmentTimelineElement(long j, long j2) {
            this.startTime = j;
            this.duration = j2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                SegmentTimelineElement segmentTimelineElement = (SegmentTimelineElement) obj;
                return this.startTime == segmentTimelineElement.startTime && this.duration == segmentTimelineElement.duration;
            }
        }

        public final int hashCode() {
            return (((int) this.startTime) * 31) + ((int) this.duration);
        }
    }
}
