package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;

final class PlaybackInfo {
    private static final MediaSource.MediaPeriodId DUMMY_MEDIA_PERIOD_ID = new MediaSource.MediaPeriodId(new Object());
    public volatile long bufferedPositionUs;
    public final boolean isLoading;
    public final MediaSource.MediaPeriodId loadingMediaPeriodId;
    public final MediaSource.MediaPeriodId periodId;
    public final boolean playWhenReady;
    public final ExoPlaybackException playbackError;
    public final int playbackState;
    public final int playbackSuppressionReason;
    public volatile long positionUs;
    public final long requestedContentPositionUs;
    public final Timeline timeline;
    public volatile long totalBufferedDurationUs;
    public final TrackGroupArray trackGroups;
    public final TrackSelectorResult trackSelectorResult;

    public static PlaybackInfo createDummy(TrackSelectorResult trackSelectorResult2) {
        return new PlaybackInfo(Timeline.EMPTY, DUMMY_MEDIA_PERIOD_ID, -9223372036854775807L, 1, null, false, TrackGroupArray.EMPTY, trackSelectorResult2, DUMMY_MEDIA_PERIOD_ID, false, 0, 0, 0, 0);
    }

    public PlaybackInfo(Timeline timeline2, MediaSource.MediaPeriodId mediaPeriodId, long j, int i, ExoPlaybackException exoPlaybackException, boolean z, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult2, MediaSource.MediaPeriodId mediaPeriodId2, boolean z2, int i2, long j2, long j3, long j4) {
        this.timeline = timeline2;
        this.periodId = mediaPeriodId;
        this.requestedContentPositionUs = j;
        this.playbackState = i;
        this.playbackError = exoPlaybackException;
        this.isLoading = z;
        this.trackGroups = trackGroupArray;
        this.trackSelectorResult = trackSelectorResult2;
        this.loadingMediaPeriodId = mediaPeriodId2;
        this.playWhenReady = z2;
        this.playbackSuppressionReason = i2;
        this.bufferedPositionUs = j2;
        this.totalBufferedDurationUs = j3;
        this.positionUs = j4;
    }

    public static MediaSource.MediaPeriodId getDummyPeriodForEmptyTimeline() {
        return DUMMY_MEDIA_PERIOD_ID;
    }

    public final PlaybackInfo copyWithNewPosition(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, long j3, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult2) {
        long j4 = j2;
        long j5 = j3;
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        TrackSelectorResult trackSelectorResult3 = trackSelectorResult2;
        return new PlaybackInfo(this.timeline, mediaPeriodId, j4, this.playbackState, this.playbackError, this.isLoading, trackGroupArray2, trackSelectorResult3, this.loadingMediaPeriodId, this.playWhenReady, this.playbackSuppressionReason, this.bufferedPositionUs, j5, j);
    }

    public final PlaybackInfo copyWithTimeline(Timeline timeline2) {
        return new PlaybackInfo(timeline2, this.periodId, this.requestedContentPositionUs, this.playbackState, this.playbackError, this.isLoading, this.trackGroups, this.trackSelectorResult, this.loadingMediaPeriodId, this.playWhenReady, this.playbackSuppressionReason, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs);
    }

    public final PlaybackInfo copyWithPlaybackState(int i) {
        Timeline timeline2 = this.timeline;
        return new PlaybackInfo(timeline2, this.periodId, this.requestedContentPositionUs, i, this.playbackError, this.isLoading, this.trackGroups, this.trackSelectorResult, this.loadingMediaPeriodId, this.playWhenReady, this.playbackSuppressionReason, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs);
    }

    public final PlaybackInfo copyWithPlaybackError(ExoPlaybackException exoPlaybackException) {
        Timeline timeline2 = this.timeline;
        return new PlaybackInfo(timeline2, this.periodId, this.requestedContentPositionUs, this.playbackState, exoPlaybackException, this.isLoading, this.trackGroups, this.trackSelectorResult, this.loadingMediaPeriodId, this.playWhenReady, this.playbackSuppressionReason, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs);
    }

    public final PlaybackInfo copyWithIsLoading(boolean z) {
        Timeline timeline2 = this.timeline;
        return new PlaybackInfo(timeline2, this.periodId, this.requestedContentPositionUs, this.playbackState, this.playbackError, z, this.trackGroups, this.trackSelectorResult, this.loadingMediaPeriodId, this.playWhenReady, this.playbackSuppressionReason, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs);
    }

    public final PlaybackInfo copyWithLoadingMediaPeriodId(MediaSource.MediaPeriodId mediaPeriodId) {
        Timeline timeline2 = this.timeline;
        return new PlaybackInfo(timeline2, this.periodId, this.requestedContentPositionUs, this.playbackState, this.playbackError, this.isLoading, this.trackGroups, this.trackSelectorResult, mediaPeriodId, this.playWhenReady, this.playbackSuppressionReason, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs);
    }

    public final PlaybackInfo copyWithPlayWhenReady(boolean z, int i) {
        Timeline timeline2 = this.timeline;
        return new PlaybackInfo(timeline2, this.periodId, this.requestedContentPositionUs, this.playbackState, this.playbackError, this.isLoading, this.trackGroups, this.trackSelectorResult, this.loadingMediaPeriodId, z, i, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs);
    }
}
