package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.offline.StreamKey;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.List;

public final class HlsMediaPlaylist extends HlsPlaylist {
    public final int discontinuitySequence;
    public final long durationUs;
    public final boolean hasDiscontinuitySequence;
    public final boolean hasEndTag;
    public final boolean hasProgramDateTime;
    public final long mediaSequence;
    public final int playlistType;
    public final DrmInitData protectionSchemes;
    public final List<Segment> segments;
    public final long startOffsetUs;
    public final long startTimeUs;
    public final long targetDurationUs;
    public final int version;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlaylistType {
    }

    public final HlsMediaPlaylist copy(List<StreamKey> list) {
        return this;
    }

    public static final class Segment implements Comparable<Long> {
        public final long byteRangeLength;
        public final long byteRangeOffset;
        public final DrmInitData drmInitData;
        public final long durationUs;
        public final String encryptionIV;
        public final String fullSegmentEncryptionKeyUri;
        public final boolean hasGapTag;
        public final Segment initializationSegment;
        public final int relativeDiscontinuitySequence;
        public final long relativeStartTimeUs;
        public final String title;
        public final String url;

        public Segment(String str, long j, long j2, String str2, String str3) {
            this(str, null, "", 0, -1, -9223372036854775807L, null, str2, str3, j, j2, false);
        }

        public Segment(String str, Segment segment, String str2, long j, int i, long j2, DrmInitData drmInitData2, String str3, String str4, long j3, long j4, boolean z) {
            this.url = str;
            this.initializationSegment = segment;
            this.title = str2;
            this.durationUs = j;
            this.relativeDiscontinuitySequence = i;
            this.relativeStartTimeUs = j2;
            this.drmInitData = drmInitData2;
            this.fullSegmentEncryptionKeyUri = str3;
            this.encryptionIV = str4;
            this.byteRangeOffset = j3;
            this.byteRangeLength = j4;
            this.hasGapTag = z;
        }

        public final int compareTo(Long l) {
            if (this.relativeStartTimeUs > l.longValue()) {
                return 1;
            }
            return this.relativeStartTimeUs < l.longValue() ? -1 : 0;
        }
    }

    public HlsMediaPlaylist(int i, String str, List<String> list, long j, long j2, boolean z, int i2, long j3, int i3, long j4, boolean z2, boolean z3, boolean z4, DrmInitData drmInitData, List<Segment> list2) {
        super(str, list, z2);
        this.playlistType = i;
        this.startTimeUs = j2;
        this.hasDiscontinuitySequence = z;
        this.discontinuitySequence = i2;
        this.mediaSequence = j3;
        this.version = i3;
        this.targetDurationUs = j4;
        this.hasEndTag = z3;
        this.hasProgramDateTime = z4;
        this.protectionSchemes = drmInitData;
        this.segments = Collections.unmodifiableList(list2);
        if (!list2.isEmpty()) {
            Segment segment = list2.get(list2.size() - 1);
            this.durationUs = segment.relativeStartTimeUs + segment.durationUs;
        } else {
            this.durationUs = 0;
        }
        this.startOffsetUs = j == -9223372036854775807L ? -9223372036854775807L : j >= 0 ? j : this.durationUs + j;
    }

    public final boolean isNewerThan(HlsMediaPlaylist hlsMediaPlaylist) {
        if (hlsMediaPlaylist != null) {
            long j = this.mediaSequence;
            long j2 = hlsMediaPlaylist.mediaSequence;
            if (j <= j2) {
                if (j < j2) {
                    return false;
                }
                int size = this.segments.size();
                int size2 = hlsMediaPlaylist.segments.size();
                return size > size2 || (size == size2 && this.hasEndTag && !hlsMediaPlaylist.hasEndTag);
            }
        }
    }

    public final long getEndTimeUs() {
        return this.startTimeUs + this.durationUs;
    }

    public final HlsMediaPlaylist copyWith(long j, int i) {
        return new HlsMediaPlaylist(this.playlistType, this.baseUri, this.tags, this.startOffsetUs, j, true, i, this.mediaSequence, this.version, this.targetDurationUs, this.hasIndependentSegments, this.hasEndTag, this.hasProgramDateTime, this.protectionSchemes, this.segments);
    }

    public final HlsMediaPlaylist copyWithEndTag() {
        if (this.hasEndTag) {
            return this;
        }
        HlsMediaPlaylist hlsMediaPlaylist = r2;
        HlsMediaPlaylist hlsMediaPlaylist2 = new HlsMediaPlaylist(this.playlistType, this.baseUri, this.tags, this.startOffsetUs, this.startTimeUs, this.hasDiscontinuitySequence, this.discontinuitySequence, this.mediaSequence, this.version, this.targetDurationUs, this.hasIndependentSegments, true, this.hasProgramDateTime, this.protectionSchemes, this.segments);
        return hlsMediaPlaylist;
    }
}
