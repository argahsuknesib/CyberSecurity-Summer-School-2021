package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;

final class MediaPeriodQueue {
    private int length;
    private MediaPeriodHolder loading;
    private long nextWindowSequenceNumber;
    private Object oldFrontPeriodUid;
    private long oldFrontPeriodWindowSequenceNumber;
    private final Timeline.Period period = new Timeline.Period();
    private MediaPeriodHolder playing;
    private MediaPeriodHolder reading;
    private int repeatMode;
    private boolean shuffleModeEnabled;
    private final Timeline.Window window = new Timeline.Window();

    private boolean areDurationsCompatible(long j, long j2) {
        return j == -9223372036854775807L || j == j2;
    }

    public final boolean updateRepeatMode(Timeline timeline, int i) {
        this.repeatMode = i;
        return updateForPlaybackModeChange(timeline);
    }

    public final boolean updateShuffleModeEnabled(Timeline timeline, boolean z) {
        this.shuffleModeEnabled = z;
        return updateForPlaybackModeChange(timeline);
    }

    public final boolean isLoading(MediaPeriod mediaPeriod) {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        return mediaPeriodHolder != null && mediaPeriodHolder.mediaPeriod == mediaPeriod;
    }

    public final void reevaluateBuffer(long j) {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder != null) {
            mediaPeriodHolder.reevaluateBuffer(j);
        }
    }

    public final boolean shouldLoadNextMediaPeriod() {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder != null) {
            return !mediaPeriodHolder.info.isFinal && this.loading.isFullyBuffered() && this.loading.info.durationUs != -9223372036854775807L && this.length < 100;
        }
        return true;
    }

    public final MediaPeriodInfo getNextMediaPeriodInfo(long j, PlaybackInfo playbackInfo) {
        if (this.loading == null) {
            return getFirstMediaPeriodInfo(playbackInfo);
        }
        return getFollowingMediaPeriodInfo(playbackInfo.timeline, this.loading, j);
    }

    public final MediaPeriodHolder enqueueNextMediaPeriodHolder(RendererCapabilities[] rendererCapabilitiesArr, TrackSelector trackSelector, Allocator allocator, MediaSourceList mediaSourceList, MediaPeriodInfo mediaPeriodInfo, TrackSelectorResult trackSelectorResult) {
        long j;
        MediaPeriodInfo mediaPeriodInfo2 = mediaPeriodInfo;
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder == null) {
            j = (!mediaPeriodInfo2.id.isAd() || mediaPeriodInfo2.requestedContentPositionUs == -9223372036854775807L) ? 0 : mediaPeriodInfo2.requestedContentPositionUs;
        } else {
            j = (mediaPeriodHolder.getRendererOffset() + this.loading.info.durationUs) - mediaPeriodInfo2.startPositionUs;
        }
        MediaPeriodHolder mediaPeriodHolder2 = new MediaPeriodHolder(rendererCapabilitiesArr, j, trackSelector, allocator, mediaSourceList, mediaPeriodInfo, trackSelectorResult);
        MediaPeriodHolder mediaPeriodHolder3 = this.loading;
        if (mediaPeriodHolder3 != null) {
            mediaPeriodHolder3.setNext(mediaPeriodHolder2);
        } else {
            this.playing = mediaPeriodHolder2;
            this.reading = mediaPeriodHolder2;
        }
        this.oldFrontPeriodUid = null;
        this.loading = mediaPeriodHolder2;
        this.length++;
        return mediaPeriodHolder2;
    }

    public final MediaPeriodHolder getLoadingPeriod() {
        return this.loading;
    }

    public final MediaPeriodHolder getPlayingPeriod() {
        return this.playing;
    }

    public final MediaPeriodHolder getReadingPeriod() {
        return this.reading;
    }

    public final MediaPeriodHolder advanceReadingPeriod() {
        MediaPeriodHolder mediaPeriodHolder = this.reading;
        Assertions.checkState((mediaPeriodHolder == null || mediaPeriodHolder.getNext() == null) ? false : true);
        this.reading = this.reading.getNext();
        return this.reading;
    }

    public final MediaPeriodHolder advancePlayingPeriod() {
        MediaPeriodHolder mediaPeriodHolder = this.playing;
        if (mediaPeriodHolder == null) {
            return null;
        }
        if (mediaPeriodHolder == this.reading) {
            this.reading = mediaPeriodHolder.getNext();
        }
        this.playing.release();
        this.length--;
        if (this.length == 0) {
            this.loading = null;
            this.oldFrontPeriodUid = this.playing.uid;
            this.oldFrontPeriodWindowSequenceNumber = this.playing.info.id.windowSequenceNumber;
        }
        this.playing = this.playing.getNext();
        return this.playing;
    }

    public final boolean removeAfter(MediaPeriodHolder mediaPeriodHolder) {
        boolean z = false;
        Assertions.checkState(mediaPeriodHolder != null);
        this.loading = mediaPeriodHolder;
        while (mediaPeriodHolder.getNext() != null) {
            mediaPeriodHolder = mediaPeriodHolder.getNext();
            if (mediaPeriodHolder == this.reading) {
                this.reading = this.playing;
                z = true;
            }
            mediaPeriodHolder.release();
            this.length--;
        }
        this.loading.setNext(null);
        return z;
    }

    public final void clear() {
        MediaPeriodHolder mediaPeriodHolder = this.playing;
        if (mediaPeriodHolder != null) {
            this.oldFrontPeriodUid = mediaPeriodHolder.uid;
            this.oldFrontPeriodWindowSequenceNumber = mediaPeriodHolder.info.id.windowSequenceNumber;
            removeAfter(mediaPeriodHolder);
            mediaPeriodHolder.release();
        }
        this.playing = null;
        this.loading = null;
        this.reading = null;
        this.length = 0;
    }

    public final boolean updateQueuedPeriods(Timeline timeline, long j, long j2) {
        MediaPeriodInfo mediaPeriodInfo;
        long j3;
        MediaPeriodHolder mediaPeriodHolder = this.playing;
        MediaPeriodHolder mediaPeriodHolder2 = null;
        while (true) {
            MediaPeriodHolder mediaPeriodHolder3 = mediaPeriodHolder2;
            mediaPeriodHolder2 = mediaPeriodHolder;
            MediaPeriodHolder mediaPeriodHolder4 = mediaPeriodHolder3;
            if (mediaPeriodHolder2 == null) {
                return true;
            }
            MediaPeriodInfo mediaPeriodInfo2 = mediaPeriodHolder2.info;
            if (mediaPeriodHolder4 == null) {
                mediaPeriodInfo = getUpdatedMediaPeriodInfo(timeline, mediaPeriodInfo2);
            } else {
                MediaPeriodInfo followingMediaPeriodInfo = getFollowingMediaPeriodInfo(timeline, mediaPeriodHolder4, j);
                if (followingMediaPeriodInfo == null) {
                    if (!removeAfter(mediaPeriodHolder4)) {
                        return true;
                    }
                    return false;
                } else if (canKeepMediaPeriodHolder(mediaPeriodInfo2, followingMediaPeriodInfo)) {
                    mediaPeriodInfo = followingMediaPeriodInfo;
                } else if (!removeAfter(mediaPeriodHolder4)) {
                    return true;
                } else {
                    return false;
                }
            }
            mediaPeriodHolder2.info = mediaPeriodInfo.copyWithRequestedContentPositionUs(mediaPeriodInfo2.requestedContentPositionUs);
            if (!areDurationsCompatible(mediaPeriodInfo2.durationUs, mediaPeriodInfo.durationUs)) {
                if (mediaPeriodInfo.durationUs == -9223372036854775807L) {
                    j3 = Long.MAX_VALUE;
                } else {
                    j3 = mediaPeriodHolder2.toRendererTime(mediaPeriodInfo.durationUs);
                }
                boolean z = mediaPeriodHolder2 == this.reading && (j2 == Long.MIN_VALUE || j2 >= j3);
                if (removeAfter(mediaPeriodHolder2) || z) {
                    return false;
                }
                return true;
            }
            mediaPeriodHolder = mediaPeriodHolder2.getNext();
        }
    }

    public final MediaPeriodInfo getUpdatedMediaPeriodInfo(Timeline timeline, MediaPeriodInfo mediaPeriodInfo) {
        long durationUs;
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.id;
        boolean isLastInPeriod = isLastInPeriod(mediaPeriodId);
        boolean isLastInWindow = isLastInWindow(timeline, mediaPeriodId);
        boolean isLastInTimeline = isLastInTimeline(timeline, mediaPeriodId, isLastInPeriod);
        timeline.getPeriodByUid(mediaPeriodInfo.id.periodUid, this.period);
        if (mediaPeriodId.isAd()) {
            durationUs = this.period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
        } else {
            durationUs = (mediaPeriodInfo.endPositionUs == -9223372036854775807L || mediaPeriodInfo.endPositionUs == Long.MIN_VALUE) ? this.period.getDurationUs() : mediaPeriodInfo.endPositionUs;
        }
        return new MediaPeriodInfo(mediaPeriodId, mediaPeriodInfo.startPositionUs, mediaPeriodInfo.requestedContentPositionUs, mediaPeriodInfo.endPositionUs, durationUs, isLastInPeriod, isLastInWindow, isLastInTimeline);
    }

    public final MediaSource.MediaPeriodId resolveMediaPeriodIdForAds(Timeline timeline, Object obj, long j) {
        return resolveMediaPeriodIdForAds(timeline, obj, j, resolvePeriodIndexToWindowSequenceNumber(timeline, obj), this.period);
    }

    private static MediaSource.MediaPeriodId resolveMediaPeriodIdForAds(Timeline timeline, Object obj, long j, long j2, Timeline.Period period2) {
        timeline.getPeriodByUid(obj, period2);
        int adGroupIndexForPositionUs = period2.getAdGroupIndexForPositionUs(j);
        if (adGroupIndexForPositionUs == -1) {
            return new MediaSource.MediaPeriodId(obj, j2, period2.getAdGroupIndexAfterPositionUs(j));
        }
        return new MediaSource.MediaPeriodId(obj, adGroupIndexForPositionUs, period2.getFirstAdIndexToPlay(adGroupIndexForPositionUs), j2);
    }

    private long resolvePeriodIndexToWindowSequenceNumber(Timeline timeline, Object obj) {
        int indexOfPeriod;
        int i = timeline.getPeriodByUid(obj, this.period).windowIndex;
        Object obj2 = this.oldFrontPeriodUid;
        if (obj2 != null && (indexOfPeriod = timeline.getIndexOfPeriod(obj2)) != -1 && timeline.getPeriod(indexOfPeriod, this.period).windowIndex == i) {
            return this.oldFrontPeriodWindowSequenceNumber;
        }
        for (MediaPeriodHolder mediaPeriodHolder = this.playing; mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.getNext()) {
            if (mediaPeriodHolder.uid.equals(obj)) {
                return mediaPeriodHolder.info.id.windowSequenceNumber;
            }
        }
        for (MediaPeriodHolder mediaPeriodHolder2 = this.playing; mediaPeriodHolder2 != null; mediaPeriodHolder2 = mediaPeriodHolder2.getNext()) {
            int indexOfPeriod2 = timeline.getIndexOfPeriod(mediaPeriodHolder2.uid);
            if (indexOfPeriod2 != -1 && timeline.getPeriod(indexOfPeriod2, this.period).windowIndex == i) {
                return mediaPeriodHolder2.info.id.windowSequenceNumber;
            }
        }
        long j = this.nextWindowSequenceNumber;
        this.nextWindowSequenceNumber = 1 + j;
        if (this.playing == null) {
            this.oldFrontPeriodUid = obj;
            this.oldFrontPeriodWindowSequenceNumber = j;
        }
        return j;
    }

    private boolean canKeepMediaPeriodHolder(MediaPeriodInfo mediaPeriodInfo, MediaPeriodInfo mediaPeriodInfo2) {
        return mediaPeriodInfo.startPositionUs == mediaPeriodInfo2.startPositionUs && mediaPeriodInfo.id.equals(mediaPeriodInfo2.id);
    }

    private boolean updateForPlaybackModeChange(Timeline timeline) {
        MediaPeriodHolder mediaPeriodHolder = this.playing;
        if (mediaPeriodHolder == null) {
            return true;
        }
        int indexOfPeriod = timeline.getIndexOfPeriod(mediaPeriodHolder.uid);
        while (true) {
            indexOfPeriod = timeline.getNextPeriodIndex(indexOfPeriod, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            while (mediaPeriodHolder.getNext() != null && !mediaPeriodHolder.info.isLastInTimelinePeriod) {
                mediaPeriodHolder = mediaPeriodHolder.getNext();
            }
            MediaPeriodHolder next = mediaPeriodHolder.getNext();
            if (indexOfPeriod == -1 || next == null || timeline.getIndexOfPeriod(next.uid) != indexOfPeriod) {
                boolean removeAfter = removeAfter(mediaPeriodHolder);
                mediaPeriodHolder.info = getUpdatedMediaPeriodInfo(timeline, mediaPeriodHolder.info);
            } else {
                mediaPeriodHolder = next;
            }
        }
        boolean removeAfter2 = removeAfter(mediaPeriodHolder);
        mediaPeriodHolder.info = getUpdatedMediaPeriodInfo(timeline, mediaPeriodHolder.info);
        if (!removeAfter2) {
            return true;
        }
        return false;
    }

    private MediaPeriodInfo getFirstMediaPeriodInfo(PlaybackInfo playbackInfo) {
        return getMediaPeriodInfo(playbackInfo.timeline, playbackInfo.periodId, playbackInfo.requestedContentPositionUs, playbackInfo.positionUs);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    private MediaPeriodInfo getFollowingMediaPeriodInfo(Timeline timeline, MediaPeriodHolder mediaPeriodHolder, long j) {
        long j2;
        Timeline timeline2 = timeline;
        MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.info;
        long rendererOffset = (mediaPeriodHolder.getRendererOffset() + mediaPeriodInfo.durationUs) - j;
        if (mediaPeriodInfo.isLastInTimelinePeriod) {
            long j3 = 0;
            int nextPeriodIndex = timeline.getNextPeriodIndex(timeline2.getIndexOfPeriod(mediaPeriodInfo.id.periodUid), this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            if (nextPeriodIndex == -1) {
                return null;
            }
            int i = timeline2.getPeriod(nextPeriodIndex, this.period, true).windowIndex;
            Object obj = this.period.uid;
            long j4 = mediaPeriodInfo.id.windowSequenceNumber;
            if (timeline2.getWindow(i, this.window).firstPeriodIndex == nextPeriodIndex) {
                Pair<Object, Long> periodPosition = timeline.getPeriodPosition(this.window, this.period, i, -9223372036854775807L, Math.max(0L, rendererOffset));
                if (periodPosition == null) {
                    return null;
                }
                obj = periodPosition.first;
                long longValue = ((Long) periodPosition.second).longValue();
                MediaPeriodHolder next = mediaPeriodHolder.getNext();
                if (next == null || !next.uid.equals(obj)) {
                    j4 = this.nextWindowSequenceNumber;
                    this.nextWindowSequenceNumber = 1 + j4;
                } else {
                    j4 = next.info.id.windowSequenceNumber;
                }
                j3 = longValue;
                j2 = -9223372036854775807L;
            } else {
                j2 = 0;
            }
            return getMediaPeriodInfo(timeline, resolveMediaPeriodIdForAds(timeline, obj, j3, j4, this.period), j2, j3);
        }
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.id;
        timeline2.getPeriodByUid(mediaPeriodId.periodUid, this.period);
        if (mediaPeriodId.isAd()) {
            int i2 = mediaPeriodId.adGroupIndex;
            int adCountInAdGroup = this.period.getAdCountInAdGroup(i2);
            if (adCountInAdGroup == -1) {
                return null;
            }
            int nextAdIndexToPlay = this.period.getNextAdIndexToPlay(i2, mediaPeriodId.adIndexInAdGroup);
            if (nextAdIndexToPlay >= adCountInAdGroup) {
                long j5 = mediaPeriodInfo.requestedContentPositionUs;
                if (j5 == -9223372036854775807L) {
                    Timeline.Window window2 = this.window;
                    Timeline.Period period2 = this.period;
                    Pair<Object, Long> periodPosition2 = timeline.getPeriodPosition(window2, period2, period2.windowIndex, -9223372036854775807L, Math.max(0L, rendererOffset));
                    if (periodPosition2 == null) {
                        return null;
                    }
                    j5 = ((Long) periodPosition2.second).longValue();
                }
                return getMediaPeriodInfoForContent(timeline, mediaPeriodId.periodUid, j5, mediaPeriodInfo.requestedContentPositionUs, mediaPeriodId.windowSequenceNumber);
            } else if (!this.period.isAdAvailable(i2, nextAdIndexToPlay)) {
                return null;
            } else {
                return getMediaPeriodInfoForAd(timeline, mediaPeriodId.periodUid, i2, nextAdIndexToPlay, mediaPeriodInfo.requestedContentPositionUs, mediaPeriodId.windowSequenceNumber);
            }
        } else {
            int adGroupIndexForPositionUs = this.period.getAdGroupIndexForPositionUs(mediaPeriodInfo.endPositionUs);
            if (adGroupIndexForPositionUs == -1) {
                return getMediaPeriodInfoForContent(timeline, mediaPeriodId.periodUid, mediaPeriodInfo.durationUs, mediaPeriodInfo.durationUs, mediaPeriodId.windowSequenceNumber);
            }
            int firstAdIndexToPlay = this.period.getFirstAdIndexToPlay(adGroupIndexForPositionUs);
            if (!this.period.isAdAvailable(adGroupIndexForPositionUs, firstAdIndexToPlay)) {
                return null;
            }
            return getMediaPeriodInfoForAd(timeline, mediaPeriodId.periodUid, adGroupIndexForPositionUs, firstAdIndexToPlay, mediaPeriodInfo.durationUs, mediaPeriodId.windowSequenceNumber);
        }
    }

    private MediaPeriodInfo getMediaPeriodInfo(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j, long j2) {
        timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period);
        if (!mediaPeriodId.isAd()) {
            return getMediaPeriodInfoForContent(timeline, mediaPeriodId.periodUid, j2, j, mediaPeriodId.windowSequenceNumber);
        } else if (!this.period.isAdAvailable(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup)) {
            return null;
        } else {
            return getMediaPeriodInfoForAd(timeline, mediaPeriodId.periodUid, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup, j, mediaPeriodId.windowSequenceNumber);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    private MediaPeriodInfo getMediaPeriodInfoForAd(Timeline timeline, Object obj, int i, int i2, long j, long j2) {
        int i3 = i2;
        MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(obj, i, i3, j2);
        long adDurationUs = timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
        long adResumePositionUs = i3 == this.period.getFirstAdIndexToPlay(i) ? this.period.getAdResumePositionUs() : 0;
        return new MediaPeriodInfo(mediaPeriodId, (adDurationUs == -9223372036854775807L || adResumePositionUs < adDurationUs) ? adResumePositionUs : Math.max(0L, adDurationUs - 1), j, -9223372036854775807L, adDurationUs, false, false, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    private MediaPeriodInfo getMediaPeriodInfoForContent(Timeline timeline, Object obj, long j, long j2, long j3) {
        long j4;
        Timeline timeline2 = timeline;
        Object obj2 = obj;
        long j5 = j;
        timeline2.getPeriodByUid(obj2, this.period);
        int adGroupIndexAfterPositionUs = this.period.getAdGroupIndexAfterPositionUs(j5);
        MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(obj2, j3, adGroupIndexAfterPositionUs);
        boolean isLastInPeriod = isLastInPeriod(mediaPeriodId);
        boolean isLastInWindow = isLastInWindow(timeline2, mediaPeriodId);
        boolean isLastInTimeline = isLastInTimeline(timeline2, mediaPeriodId, isLastInPeriod);
        long adGroupTimeUs = adGroupIndexAfterPositionUs != -1 ? this.period.getAdGroupTimeUs(adGroupIndexAfterPositionUs) : -9223372036854775807L;
        if (adGroupTimeUs == -9223372036854775807L || adGroupTimeUs == Long.MIN_VALUE) {
            j4 = this.period.durationUs;
        } else {
            j4 = adGroupTimeUs;
        }
        if (j4 != -9223372036854775807L && j5 >= j4) {
            j5 = Math.max(0L, j4 - 1);
        }
        return new MediaPeriodInfo(mediaPeriodId, j5, j2, adGroupTimeUs, j4, isLastInPeriod, isLastInWindow, isLastInTimeline);
    }

    private boolean isLastInPeriod(MediaSource.MediaPeriodId mediaPeriodId) {
        return !mediaPeriodId.isAd() && mediaPeriodId.nextAdGroupIndex == -1;
    }

    private boolean isLastInWindow(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        if (!isLastInPeriod(mediaPeriodId)) {
            return false;
        }
        int i = timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex;
        if (timeline.getWindow(i, this.window).lastPeriodIndex == timeline.getIndexOfPeriod(mediaPeriodId.periodUid)) {
            return true;
        }
        return false;
    }

    private boolean isLastInTimeline(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, boolean z) {
        int indexOfPeriod = timeline.getIndexOfPeriod(mediaPeriodId.periodUid);
        if (timeline.getWindow(timeline.getPeriod(indexOfPeriod, this.period).windowIndex, this.window).isDynamic) {
            return false;
        }
        return timeline.isLastPeriod(indexOfPeriod, this.period, this.window, this.repeatMode, this.shuffleModeEnabled) && z;
    }
}
