package com.google.android.exoplayer2.source;

import android.util.Pair;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class MaskingMediaSource extends CompositeMediaSource<Void> {
    private boolean hasRealTimeline;
    private boolean hasStartedPreparing;
    private boolean isPrepared;
    private final MediaSource mediaSource;
    private final Timeline.Period period;
    private MaskingTimeline timeline;
    private MaskingMediaPeriod unpreparedMaskingMediaPeriod;
    private MediaSourceEventListener.EventDispatcher unpreparedMaskingMediaPeriodEventDispatcher;
    private final boolean useLazyPreparation;
    private final Timeline.Window window;

    public final void maybeThrowSourceInfoRefreshError() {
    }

    public MaskingMediaSource(MediaSource mediaSource2, boolean z) {
        this.mediaSource = mediaSource2;
        this.useLazyPreparation = z && mediaSource2.isSingleWindow();
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        Timeline initialTimeline = mediaSource2.getInitialTimeline();
        if (initialTimeline != null) {
            this.timeline = MaskingTimeline.createWithRealTimeline(initialTimeline, null, null);
            this.hasRealTimeline = true;
            return;
        }
        this.timeline = MaskingTimeline.createWithDummyTimeline(mediaSource2.getTag());
    }

    public final synchronized Timeline getTimeline() {
        return this.timeline;
    }

    public final void prepareSourceInternal(TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        if (!this.useLazyPreparation) {
            this.hasStartedPreparing = true;
            prepareChildSource(null, this.mediaSource);
        }
    }

    public final Object getTag() {
        return this.mediaSource.getTag();
    }

    public final MaskingMediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(this.mediaSource, mediaPeriodId, allocator, j);
        if (this.isPrepared) {
            maskingMediaPeriod.createPeriod(mediaPeriodId.copyWithPeriodUid(getInternalPeriodUid(mediaPeriodId.periodUid)));
        } else {
            this.unpreparedMaskingMediaPeriod = maskingMediaPeriod;
            this.unpreparedMaskingMediaPeriodEventDispatcher = createEventDispatcher(0, mediaPeriodId, 0);
            this.unpreparedMaskingMediaPeriodEventDispatcher.mediaPeriodCreated();
            if (!this.hasStartedPreparing) {
                this.hasStartedPreparing = true;
                prepareChildSource(null, this.mediaSource);
            }
        }
        return maskingMediaPeriod;
    }

    public final void releasePeriod(MediaPeriod mediaPeriod) {
        ((MaskingMediaPeriod) mediaPeriod).releasePeriod();
        if (mediaPeriod == this.unpreparedMaskingMediaPeriod) {
            ((MediaSourceEventListener.EventDispatcher) Assertions.checkNotNull(this.unpreparedMaskingMediaPeriodEventDispatcher)).mediaPeriodReleased();
            this.unpreparedMaskingMediaPeriodEventDispatcher = null;
            this.unpreparedMaskingMediaPeriod = null;
        }
    }

    public final void releaseSourceInternal() {
        this.isPrepared = false;
        this.hasStartedPreparing = false;
        super.releaseSourceInternal();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0085  */
    public final synchronized void onChildSourceInfoRefreshed(Void voidR, MediaSource mediaSource2, Timeline timeline2) {
        long j;
        MaskingTimeline maskingTimeline;
        MaskingTimeline maskingTimeline2;
        MediaSource.MediaPeriodId mediaPeriodId = null;
        if (this.isPrepared) {
            this.timeline = this.timeline.cloneWithUpdatedTimeline(timeline2);
            if (this.unpreparedMaskingMediaPeriod != null) {
                setPreparePositionOverrideToUnpreparedMaskingPeriod(this.unpreparedMaskingMediaPeriod.getPreparePositionOverrideUs());
            }
        } else if (timeline2.isEmpty()) {
            if (this.hasRealTimeline) {
                maskingTimeline2 = this.timeline.cloneWithUpdatedTimeline(timeline2);
            } else {
                maskingTimeline2 = MaskingTimeline.createWithRealTimeline(timeline2, Timeline.Window.SINGLE_WINDOW_UID, MaskingTimeline.DUMMY_EXTERNAL_PERIOD_UID);
            }
            this.timeline = maskingTimeline2;
        } else {
            timeline2.getWindow(0, this.window);
            long defaultPositionUs = this.window.getDefaultPositionUs();
            if (this.unpreparedMaskingMediaPeriod != null) {
                long preparePositionUs = this.unpreparedMaskingMediaPeriod.getPreparePositionUs();
                if (preparePositionUs != 0) {
                    j = preparePositionUs;
                    Object obj = this.window.uid;
                    Pair<Object, Long> periodPosition = timeline2.getPeriodPosition(this.window, this.period, 0, j);
                    Object obj2 = periodPosition.first;
                    long longValue = ((Long) periodPosition.second).longValue();
                    if (!this.hasRealTimeline) {
                        maskingTimeline = this.timeline.cloneWithUpdatedTimeline(timeline2);
                    } else {
                        maskingTimeline = MaskingTimeline.createWithRealTimeline(timeline2, obj, obj2);
                    }
                    this.timeline = maskingTimeline;
                    if (this.unpreparedMaskingMediaPeriod != null) {
                        MaskingMediaPeriod maskingMediaPeriod = this.unpreparedMaskingMediaPeriod;
                        setPreparePositionOverrideToUnpreparedMaskingPeriod(longValue);
                        mediaPeriodId = maskingMediaPeriod.id.copyWithPeriodUid(getInternalPeriodUid(maskingMediaPeriod.id.periodUid));
                    }
                }
            }
            j = defaultPositionUs;
            Object obj3 = this.window.uid;
            Pair<Object, Long> periodPosition2 = timeline2.getPeriodPosition(this.window, this.period, 0, j);
            Object obj22 = periodPosition2.first;
            long longValue2 = ((Long) periodPosition2.second).longValue();
            if (!this.hasRealTimeline) {
            }
            this.timeline = maskingTimeline;
            if (this.unpreparedMaskingMediaPeriod != null) {
            }
        }
        this.hasRealTimeline = true;
        this.isPrepared = true;
        refreshSourceInfo(this.timeline);
        if (mediaPeriodId != null) {
            ((MaskingMediaPeriod) Assertions.checkNotNull(this.unpreparedMaskingMediaPeriod)).createPeriod(mediaPeriodId);
        }
    }

    /* access modifiers changed from: protected */
    public final MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Void voidR, MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId.copyWithPeriodUid(getExternalPeriodUid(mediaPeriodId.periodUid));
    }

    /* access modifiers changed from: protected */
    public final boolean shouldDispatchCreateOrReleaseEvent(MediaSource.MediaPeriodId mediaPeriodId) {
        MaskingMediaPeriod maskingMediaPeriod = this.unpreparedMaskingMediaPeriod;
        return maskingMediaPeriod == null || !mediaPeriodId.equals(maskingMediaPeriod.id);
    }

    private Object getInternalPeriodUid(Object obj) {
        return (this.timeline.replacedInternalPeriodUid == null || !obj.equals(MaskingTimeline.DUMMY_EXTERNAL_PERIOD_UID)) ? obj : this.timeline.replacedInternalPeriodUid;
    }

    private Object getExternalPeriodUid(Object obj) {
        return (this.timeline.replacedInternalPeriodUid == null || !this.timeline.replacedInternalPeriodUid.equals(obj)) ? obj : MaskingTimeline.DUMMY_EXTERNAL_PERIOD_UID;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    private void setPreparePositionOverrideToUnpreparedMaskingPeriod(long j) {
        MaskingMediaPeriod maskingMediaPeriod = this.unpreparedMaskingMediaPeriod;
        int indexOfPeriod = this.timeline.getIndexOfPeriod(maskingMediaPeriod.id.periodUid);
        if (indexOfPeriod != -1) {
            long j2 = this.timeline.getPeriod(indexOfPeriod, this.period).durationUs;
            if (j2 != -9223372036854775807L && j >= j2) {
                j = Math.max(0L, j2 - 1);
            }
            maskingMediaPeriod.overridePreparePositionUs(j);
        }
    }

    static final class MaskingTimeline extends ForwardingTimeline {
        public static final Object DUMMY_EXTERNAL_PERIOD_UID = new Object();
        public final Object replacedInternalPeriodUid;
        private final Object replacedInternalWindowUid;

        public static MaskingTimeline createWithDummyTimeline(Object obj) {
            return new MaskingTimeline(new DummyTimeline(obj), Timeline.Window.SINGLE_WINDOW_UID, DUMMY_EXTERNAL_PERIOD_UID);
        }

        public static MaskingTimeline createWithRealTimeline(Timeline timeline, Object obj, Object obj2) {
            return new MaskingTimeline(timeline, obj, obj2);
        }

        private MaskingTimeline(Timeline timeline, Object obj, Object obj2) {
            super(timeline);
            this.replacedInternalWindowUid = obj;
            this.replacedInternalPeriodUid = obj2;
        }

        public final MaskingTimeline cloneWithUpdatedTimeline(Timeline timeline) {
            return new MaskingTimeline(timeline, this.replacedInternalWindowUid, this.replacedInternalPeriodUid);
        }

        public final Timeline getTimeline() {
            return this.timeline;
        }

        public final Timeline.Window getWindow(int i, Timeline.Window window, long j) {
            this.timeline.getWindow(i, window, j);
            if (Util.areEqual(window.uid, this.replacedInternalWindowUid)) {
                window.uid = Timeline.Window.SINGLE_WINDOW_UID;
            }
            return window;
        }

        public final Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            this.timeline.getPeriod(i, period, z);
            if (Util.areEqual(period.uid, this.replacedInternalPeriodUid) && z) {
                period.uid = DUMMY_EXTERNAL_PERIOD_UID;
            }
            return period;
        }

        public final int getIndexOfPeriod(Object obj) {
            Object obj2;
            Timeline timeline = this.timeline;
            if (DUMMY_EXTERNAL_PERIOD_UID.equals(obj) && (obj2 = this.replacedInternalPeriodUid) != null) {
                obj = obj2;
            }
            return timeline.getIndexOfPeriod(obj);
        }

        public final Object getUidOfPeriod(int i) {
            Object uidOfPeriod = this.timeline.getUidOfPeriod(i);
            return Util.areEqual(uidOfPeriod, this.replacedInternalPeriodUid) ? DUMMY_EXTERNAL_PERIOD_UID : uidOfPeriod;
        }
    }

    public static final class DummyTimeline extends Timeline {
        private final Object tag;

        public final int getPeriodCount() {
            return 1;
        }

        public final int getWindowCount() {
            return 1;
        }

        public DummyTimeline(Object obj) {
            this.tag = obj;
        }

        public final Timeline.Window getWindow(int i, Timeline.Window window, long j) {
            window.set(Timeline.Window.SINGLE_WINDOW_UID, this.tag, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, false, 0, -9223372036854775807L, 0, 0, 0);
            Timeline.Window window2 = window;
            window2.isPlaceholder = true;
            return window2;
        }

        public final Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            Object obj = null;
            Integer num = z ? 0 : null;
            if (z) {
                obj = MaskingTimeline.DUMMY_EXTERNAL_PERIOD_UID;
            }
            return period.set(num, obj, 0, -9223372036854775807L, 0);
        }

        public final int getIndexOfPeriod(Object obj) {
            return obj == MaskingTimeline.DUMMY_EXTERNAL_PERIOD_UID ? 0 : -1;
        }

        public final Object getUidOfPeriod(int i) {
            return MaskingTimeline.DUMMY_EXTERNAL_PERIOD_UID;
        }
    }
}
