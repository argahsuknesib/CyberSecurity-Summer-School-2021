package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import java.util.Collections;
import java.util.List;

public final class PlaybackStats {
    public static final PlaybackStats EMPTY = merge(new PlaybackStats[0]);
    public final int abandonedBeforeReadyCount;
    public final int adPlaybackCount;
    public final List<EventTimeAndFormat> audioFormatHistory;
    public final int backgroundJoiningCount;
    public final int endedCount;
    public final int fatalErrorCount;
    public final List<EventTimeAndException> fatalErrorHistory;
    public final int fatalErrorPlaybackCount;
    public final long firstReportedTimeMs;
    public final int foregroundPlaybackCount;
    public final int initialAudioFormatBitrateCount;
    public final int initialVideoFormatBitrateCount;
    public final int initialVideoFormatHeightCount;
    public final long maxRebufferTimeMs;
    public final List<long[]> mediaTimeHistory;
    public final int nonFatalErrorCount;
    public final List<EventTimeAndException> nonFatalErrorHistory;
    public final int playbackCount;
    private final long[] playbackStateDurationsMs;
    public final List<EventTimeAndPlaybackState> playbackStateHistory;
    public final long totalAudioFormatBitrateTimeProduct;
    public final long totalAudioFormatTimeMs;
    public final long totalAudioUnderruns;
    public final long totalBandwidthBytes;
    public final long totalBandwidthTimeMs;
    public final long totalDroppedFrames;
    public final long totalInitialAudioFormatBitrate;
    public final long totalInitialVideoFormatBitrate;
    public final int totalInitialVideoFormatHeight;
    public final int totalPauseBufferCount;
    public final int totalPauseCount;
    public final int totalRebufferCount;
    public final int totalSeekCount;
    public final long totalValidJoinTimeMs;
    public final long totalVideoFormatBitrateTimeMs;
    public final long totalVideoFormatBitrateTimeProduct;
    public final long totalVideoFormatHeightTimeMs;
    public final long totalVideoFormatHeightTimeProduct;
    public final int validJoinTimeCount;
    public final List<EventTimeAndFormat> videoFormatHistory;

    public static final class EventTimeAndPlaybackState {
        public final AnalyticsListener.EventTime eventTime;
        public final int playbackState;

        public EventTimeAndPlaybackState(AnalyticsListener.EventTime eventTime2, int i) {
            this.eventTime = eventTime2;
            this.playbackState = i;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            EventTimeAndPlaybackState eventTimeAndPlaybackState = (EventTimeAndPlaybackState) obj;
            if (this.playbackState != eventTimeAndPlaybackState.playbackState) {
                return false;
            }
            return this.eventTime.equals(eventTimeAndPlaybackState.eventTime);
        }

        public final int hashCode() {
            return (this.eventTime.hashCode() * 31) + this.playbackState;
        }
    }

    public static final class EventTimeAndFormat {
        public final AnalyticsListener.EventTime eventTime;
        public final Format format;

        public EventTimeAndFormat(AnalyticsListener.EventTime eventTime2, Format format2) {
            this.eventTime = eventTime2;
            this.format = format2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                EventTimeAndFormat eventTimeAndFormat = (EventTimeAndFormat) obj;
                if (!this.eventTime.equals(eventTimeAndFormat.eventTime)) {
                    return false;
                }
                Format format2 = this.format;
                if (format2 != null) {
                    return format2.equals(eventTimeAndFormat.format);
                }
                if (eventTimeAndFormat.format == null) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = this.eventTime.hashCode() * 31;
            Format format2 = this.format;
            return hashCode + (format2 != null ? format2.hashCode() : 0);
        }
    }

    public static final class EventTimeAndException {
        public final AnalyticsListener.EventTime eventTime;
        public final Exception exception;

        public EventTimeAndException(AnalyticsListener.EventTime eventTime2, Exception exc) {
            this.eventTime = eventTime2;
            this.exception = exc;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            EventTimeAndException eventTimeAndException = (EventTimeAndException) obj;
            if (!this.eventTime.equals(eventTimeAndException.eventTime)) {
                return false;
            }
            return this.exception.equals(eventTimeAndException.exception);
        }

        public final int hashCode() {
            return (this.eventTime.hashCode() * 31) + this.exception.hashCode();
        }
    }

    public static PlaybackStats merge(PlaybackStats... playbackStatsArr) {
        int i;
        PlaybackStats[] playbackStatsArr2 = playbackStatsArr;
        int i2 = 16;
        long[] jArr = new long[16];
        int length = playbackStatsArr2.length;
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        long j10 = 0;
        int i3 = -1;
        long j11 = -9223372036854775807L;
        int i4 = 0;
        int i5 = 0;
        long j12 = -9223372036854775807L;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        long j13 = -9223372036854775807L;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        long j14 = -1;
        int i18 = 0;
        long j15 = -1;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        while (i4 < length) {
            PlaybackStats playbackStats = playbackStatsArr2[i4];
            i5 += playbackStats.playbackCount;
            for (int i22 = 0; i22 < i2; i22++) {
                jArr[i22] = jArr[i22] + playbackStats.playbackStateDurationsMs[i22];
            }
            if (j12 == -9223372036854775807L) {
                j12 = playbackStats.firstReportedTimeMs;
                i = length;
            } else {
                i = length;
                long j16 = playbackStats.firstReportedTimeMs;
                if (j16 != -9223372036854775807L) {
                    j12 = Math.min(j12, j16);
                }
            }
            i6 += playbackStats.foregroundPlaybackCount;
            i7 += playbackStats.abandonedBeforeReadyCount;
            i8 += playbackStats.endedCount;
            i9 += playbackStats.backgroundJoiningCount;
            if (j13 == -9223372036854775807L) {
                j13 = playbackStats.totalValidJoinTimeMs;
            } else {
                long j17 = playbackStats.totalValidJoinTimeMs;
                if (j17 != -9223372036854775807L) {
                    j13 += j17;
                }
            }
            i10 += playbackStats.validJoinTimeCount;
            i11 += playbackStats.totalPauseCount;
            i12 += playbackStats.totalPauseBufferCount;
            i13 += playbackStats.totalSeekCount;
            i14 += playbackStats.totalRebufferCount;
            if (j11 == -9223372036854775807L) {
                j11 = playbackStats.maxRebufferTimeMs;
            } else {
                long j18 = playbackStats.maxRebufferTimeMs;
                if (j18 != -9223372036854775807L) {
                    j11 = Math.max(j11, j18);
                }
            }
            i15 += playbackStats.adPlaybackCount;
            j += playbackStats.totalVideoFormatHeightTimeMs;
            j2 += playbackStats.totalVideoFormatHeightTimeProduct;
            j3 += playbackStats.totalVideoFormatBitrateTimeMs;
            j4 += playbackStats.totalVideoFormatBitrateTimeProduct;
            j5 += playbackStats.totalAudioFormatTimeMs;
            j6 += playbackStats.totalAudioFormatBitrateTimeProduct;
            i16 += playbackStats.initialVideoFormatHeightCount;
            i17 += playbackStats.initialVideoFormatBitrateCount;
            if (i3 == -1) {
                i3 = playbackStats.totalInitialVideoFormatHeight;
            } else {
                int i23 = playbackStats.totalInitialVideoFormatHeight;
                if (i23 != -1) {
                    i3 += i23;
                }
            }
            if (j14 == -1) {
                j14 = playbackStats.totalInitialVideoFormatBitrate;
            } else {
                long j19 = playbackStats.totalInitialVideoFormatBitrate;
                if (j19 != -1) {
                    j14 += j19;
                }
            }
            i18 += playbackStats.initialAudioFormatBitrateCount;
            if (j15 == -1) {
                j15 = playbackStats.totalInitialAudioFormatBitrate;
            } else {
                long j20 = playbackStats.totalInitialAudioFormatBitrate;
                if (j20 != -1) {
                    j15 += j20;
                }
            }
            j7 += playbackStats.totalBandwidthTimeMs;
            j8 += playbackStats.totalBandwidthBytes;
            j9 += playbackStats.totalDroppedFrames;
            j10 += playbackStats.totalAudioUnderruns;
            i19 += playbackStats.fatalErrorPlaybackCount;
            i20 += playbackStats.fatalErrorCount;
            i21 += playbackStats.nonFatalErrorCount;
            i4++;
            length = i;
            i2 = 16;
        }
        return new PlaybackStats(i5, jArr, Collections.emptyList(), Collections.emptyList(), j12, i6, i7, i8, i9, j13, i10, i11, i12, i13, i14, j11, i15, Collections.emptyList(), Collections.emptyList(), j, j2, j3, j4, j5, j6, i16, i17, i3, j14, i18, j15, j7, j8, j9, j10, i19, i20, i21, Collections.emptyList(), Collections.emptyList());
    }

    PlaybackStats(int i, long[] jArr, List<EventTimeAndPlaybackState> list, List<long[]> list2, long j, int i2, int i3, int i4, int i5, long j2, int i6, int i7, int i8, int i9, int i10, long j3, int i11, List<EventTimeAndFormat> list3, List<EventTimeAndFormat> list4, long j4, long j5, long j6, long j7, long j8, long j9, int i12, int i13, int i14, long j10, int i15, long j11, long j12, long j13, long j14, long j15, int i16, int i17, int i18, List<EventTimeAndException> list5, List<EventTimeAndException> list6) {
        this.playbackCount = i;
        this.playbackStateDurationsMs = jArr;
        this.playbackStateHistory = Collections.unmodifiableList(list);
        this.mediaTimeHistory = Collections.unmodifiableList(list2);
        this.firstReportedTimeMs = j;
        this.foregroundPlaybackCount = i2;
        this.abandonedBeforeReadyCount = i3;
        this.endedCount = i4;
        this.backgroundJoiningCount = i5;
        this.totalValidJoinTimeMs = j2;
        this.validJoinTimeCount = i6;
        this.totalPauseCount = i7;
        this.totalPauseBufferCount = i8;
        this.totalSeekCount = i9;
        this.totalRebufferCount = i10;
        this.maxRebufferTimeMs = j3;
        this.adPlaybackCount = i11;
        this.videoFormatHistory = Collections.unmodifiableList(list3);
        this.audioFormatHistory = Collections.unmodifiableList(list4);
        this.totalVideoFormatHeightTimeMs = j4;
        this.totalVideoFormatHeightTimeProduct = j5;
        this.totalVideoFormatBitrateTimeMs = j6;
        this.totalVideoFormatBitrateTimeProduct = j7;
        this.totalAudioFormatTimeMs = j8;
        this.totalAudioFormatBitrateTimeProduct = j9;
        this.initialVideoFormatHeightCount = i12;
        this.initialVideoFormatBitrateCount = i13;
        this.totalInitialVideoFormatHeight = i14;
        this.totalInitialVideoFormatBitrate = j10;
        this.initialAudioFormatBitrateCount = i15;
        this.totalInitialAudioFormatBitrate = j11;
        this.totalBandwidthTimeMs = j12;
        this.totalBandwidthBytes = j13;
        this.totalDroppedFrames = j14;
        this.totalAudioUnderruns = j15;
        this.fatalErrorPlaybackCount = i16;
        this.fatalErrorCount = i17;
        this.nonFatalErrorCount = i18;
        this.fatalErrorHistory = Collections.unmodifiableList(list5);
        this.nonFatalErrorHistory = Collections.unmodifiableList(list6);
    }

    public final long getPlaybackStateDurationMs(int i) {
        return this.playbackStateDurationsMs[i];
    }

    public final int getPlaybackStateAtTime(long j) {
        int i = 0;
        for (EventTimeAndPlaybackState next : this.playbackStateHistory) {
            if (next.eventTime.realtimeMs > j) {
                break;
            }
            i = next.playbackState;
        }
        return i;
    }

    public final long getMediaTimeMsAtRealtimeMs(long j) {
        if (this.mediaTimeHistory.isEmpty()) {
            return -9223372036854775807L;
        }
        int i = 0;
        while (i < this.mediaTimeHistory.size() && this.mediaTimeHistory.get(i)[0] <= j) {
            i++;
        }
        if (i == 0) {
            return this.mediaTimeHistory.get(0)[1];
        }
        if (i == this.mediaTimeHistory.size()) {
            List<long[]> list = this.mediaTimeHistory;
            return list.get(list.size() - 1)[1];
        }
        int i2 = i - 1;
        long j2 = this.mediaTimeHistory.get(i2)[0];
        long j3 = this.mediaTimeHistory.get(i2)[1];
        long j4 = this.mediaTimeHistory.get(i)[0];
        long j5 = this.mediaTimeHistory.get(i)[1];
        long j6 = j4 - j2;
        if (j6 == 0) {
            return j3;
        }
        return j3 + ((long) (((float) (j5 - j3)) * (((float) (j - j2)) / ((float) j6))));
    }

    public final long getMeanJoinTimeMs() {
        int i = this.validJoinTimeCount;
        if (i == 0) {
            return -9223372036854775807L;
        }
        return this.totalValidJoinTimeMs / ((long) i);
    }

    public final long getTotalJoinTimeMs() {
        return getPlaybackStateDurationMs(2);
    }

    public final long getTotalPlayTimeMs() {
        return getPlaybackStateDurationMs(3);
    }

    public final long getMeanPlayTimeMs() {
        if (this.foregroundPlaybackCount == 0) {
            return -9223372036854775807L;
        }
        return getTotalPlayTimeMs() / ((long) this.foregroundPlaybackCount);
    }

    public final long getTotalPausedTimeMs() {
        return getPlaybackStateDurationMs(4) + getPlaybackStateDurationMs(7);
    }

    public final long getMeanPausedTimeMs() {
        if (this.foregroundPlaybackCount == 0) {
            return -9223372036854775807L;
        }
        return getTotalPausedTimeMs() / ((long) this.foregroundPlaybackCount);
    }

    public final long getTotalRebufferTimeMs() {
        return getPlaybackStateDurationMs(6);
    }

    public final long getMeanRebufferTimeMs() {
        if (this.foregroundPlaybackCount == 0) {
            return -9223372036854775807L;
        }
        return getTotalRebufferTimeMs() / ((long) this.foregroundPlaybackCount);
    }

    public final long getMeanSingleRebufferTimeMs() {
        if (this.totalRebufferCount == 0) {
            return -9223372036854775807L;
        }
        return (getPlaybackStateDurationMs(6) + getPlaybackStateDurationMs(7)) / ((long) this.totalRebufferCount);
    }

    public final long getTotalSeekTimeMs() {
        return getPlaybackStateDurationMs(5) + getPlaybackStateDurationMs(8);
    }

    public final long getMeanSeekTimeMs() {
        if (this.foregroundPlaybackCount == 0) {
            return -9223372036854775807L;
        }
        return getTotalSeekTimeMs() / ((long) this.foregroundPlaybackCount);
    }

    public final long getMeanSingleSeekTimeMs() {
        if (this.totalSeekCount == 0) {
            return -9223372036854775807L;
        }
        return getTotalSeekTimeMs() / ((long) this.totalSeekCount);
    }

    public final long getTotalWaitTimeMs() {
        return getPlaybackStateDurationMs(2) + getPlaybackStateDurationMs(6) + getPlaybackStateDurationMs(5) + getPlaybackStateDurationMs(8);
    }

    public final long getMeanWaitTimeMs() {
        if (this.foregroundPlaybackCount == 0) {
            return -9223372036854775807L;
        }
        return getTotalWaitTimeMs() / ((long) this.foregroundPlaybackCount);
    }

    public final long getTotalPlayAndWaitTimeMs() {
        return getTotalPlayTimeMs() + getTotalWaitTimeMs();
    }

    public final long getMeanPlayAndWaitTimeMs() {
        if (this.foregroundPlaybackCount == 0) {
            return -9223372036854775807L;
        }
        return getTotalPlayAndWaitTimeMs() / ((long) this.foregroundPlaybackCount);
    }

    public final long getTotalElapsedTimeMs() {
        long j = 0;
        for (int i = 0; i < 16; i++) {
            j += this.playbackStateDurationsMs[i];
        }
        return j;
    }

    public final long getMeanElapsedTimeMs() {
        if (this.playbackCount == 0) {
            return -9223372036854775807L;
        }
        return getTotalElapsedTimeMs() / ((long) this.playbackCount);
    }

    public final float getAbandonedBeforeReadyRatio() {
        int i = this.abandonedBeforeReadyCount;
        int i2 = this.playbackCount;
        int i3 = this.foregroundPlaybackCount;
        int i4 = i - (i2 - i3);
        if (i3 == 0) {
            return 0.0f;
        }
        return ((float) i4) / ((float) i3);
    }

    public final float getEndedRatio() {
        int i = this.foregroundPlaybackCount;
        if (i == 0) {
            return 0.0f;
        }
        return ((float) this.endedCount) / ((float) i);
    }

    public final float getMeanPauseCount() {
        int i = this.foregroundPlaybackCount;
        if (i == 0) {
            return 0.0f;
        }
        return ((float) this.totalPauseCount) / ((float) i);
    }

    public final float getMeanPauseBufferCount() {
        int i = this.foregroundPlaybackCount;
        if (i == 0) {
            return 0.0f;
        }
        return ((float) this.totalPauseBufferCount) / ((float) i);
    }

    public final float getMeanSeekCount() {
        int i = this.foregroundPlaybackCount;
        if (i == 0) {
            return 0.0f;
        }
        return ((float) this.totalSeekCount) / ((float) i);
    }

    public final float getMeanRebufferCount() {
        int i = this.foregroundPlaybackCount;
        if (i == 0) {
            return 0.0f;
        }
        return ((float) this.totalRebufferCount) / ((float) i);
    }

    public final float getWaitTimeRatio() {
        long totalPlayAndWaitTimeMs = getTotalPlayAndWaitTimeMs();
        if (totalPlayAndWaitTimeMs == 0) {
            return 0.0f;
        }
        return ((float) getTotalWaitTimeMs()) / ((float) totalPlayAndWaitTimeMs);
    }

    public final float getJoinTimeRatio() {
        long totalPlayAndWaitTimeMs = getTotalPlayAndWaitTimeMs();
        if (totalPlayAndWaitTimeMs == 0) {
            return 0.0f;
        }
        return ((float) getTotalJoinTimeMs()) / ((float) totalPlayAndWaitTimeMs);
    }

    public final float getRebufferTimeRatio() {
        long totalPlayAndWaitTimeMs = getTotalPlayAndWaitTimeMs();
        if (totalPlayAndWaitTimeMs == 0) {
            return 0.0f;
        }
        return ((float) getTotalRebufferTimeMs()) / ((float) totalPlayAndWaitTimeMs);
    }

    public final float getSeekTimeRatio() {
        long totalPlayAndWaitTimeMs = getTotalPlayAndWaitTimeMs();
        if (totalPlayAndWaitTimeMs == 0) {
            return 0.0f;
        }
        return ((float) getTotalSeekTimeMs()) / ((float) totalPlayAndWaitTimeMs);
    }

    public final float getRebufferRate() {
        long totalPlayTimeMs = getTotalPlayTimeMs();
        if (totalPlayTimeMs == 0) {
            return 0.0f;
        }
        return (((float) this.totalRebufferCount) * 1000.0f) / ((float) totalPlayTimeMs);
    }

    public final float getMeanTimeBetweenRebuffers() {
        return 1.0f / getRebufferRate();
    }

    public final int getMeanInitialVideoFormatHeight() {
        int i = this.initialVideoFormatHeightCount;
        if (i == 0) {
            return -1;
        }
        return this.totalInitialVideoFormatHeight / i;
    }

    public final int getMeanInitialVideoFormatBitrate() {
        int i = this.initialVideoFormatBitrateCount;
        if (i == 0) {
            return -1;
        }
        return (int) (this.totalInitialVideoFormatBitrate / ((long) i));
    }

    public final int getMeanInitialAudioFormatBitrate() {
        int i = this.initialAudioFormatBitrateCount;
        if (i == 0) {
            return -1;
        }
        return (int) (this.totalInitialAudioFormatBitrate / ((long) i));
    }

    public final int getMeanVideoFormatHeight() {
        long j = this.totalVideoFormatHeightTimeMs;
        if (j == 0) {
            return -1;
        }
        return (int) (this.totalVideoFormatHeightTimeProduct / j);
    }

    public final int getMeanVideoFormatBitrate() {
        long j = this.totalVideoFormatBitrateTimeMs;
        if (j == 0) {
            return -1;
        }
        return (int) (this.totalVideoFormatBitrateTimeProduct / j);
    }

    public final int getMeanAudioFormatBitrate() {
        long j = this.totalAudioFormatTimeMs;
        if (j == 0) {
            return -1;
        }
        return (int) (this.totalAudioFormatBitrateTimeProduct / j);
    }

    public final int getMeanBandwidth() {
        long j = this.totalBandwidthTimeMs;
        if (j == 0) {
            return -1;
        }
        return (int) ((this.totalBandwidthBytes * 8000) / j);
    }

    public final float getDroppedFramesRate() {
        long totalPlayTimeMs = getTotalPlayTimeMs();
        if (totalPlayTimeMs == 0) {
            return 0.0f;
        }
        return (((float) this.totalDroppedFrames) * 1000.0f) / ((float) totalPlayTimeMs);
    }

    public final float getAudioUnderrunRate() {
        long totalPlayTimeMs = getTotalPlayTimeMs();
        if (totalPlayTimeMs == 0) {
            return 0.0f;
        }
        return (((float) this.totalAudioUnderruns) * 1000.0f) / ((float) totalPlayTimeMs);
    }

    public final float getFatalErrorRatio() {
        int i = this.foregroundPlaybackCount;
        if (i == 0) {
            return 0.0f;
        }
        return ((float) this.fatalErrorPlaybackCount) / ((float) i);
    }

    public final float getFatalErrorRate() {
        long totalPlayTimeMs = getTotalPlayTimeMs();
        if (totalPlayTimeMs == 0) {
            return 0.0f;
        }
        return (((float) this.fatalErrorCount) * 1000.0f) / ((float) totalPlayTimeMs);
    }

    public final float getMeanTimeBetweenFatalErrors() {
        return 1.0f / getFatalErrorRate();
    }

    public final float getMeanNonFatalErrorCount() {
        int i = this.foregroundPlaybackCount;
        if (i == 0) {
            return 0.0f;
        }
        return ((float) this.nonFatalErrorCount) / ((float) i);
    }

    public final float getNonFatalErrorRate() {
        long totalPlayTimeMs = getTotalPlayTimeMs();
        if (totalPlayTimeMs == 0) {
            return 0.0f;
        }
        return (((float) this.nonFatalErrorCount) * 1000.0f) / ((float) totalPlayTimeMs);
    }

    public final float getMeanTimeBetweenNonFatalErrors() {
        return 1.0f / getNonFatalErrorRate();
    }
}
