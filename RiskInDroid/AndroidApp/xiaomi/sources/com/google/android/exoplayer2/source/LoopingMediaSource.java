package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.AbstractConcatenatedTimeline;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.util.HashMap;
import java.util.Map;

public final class LoopingMediaSource extends CompositeMediaSource<Void> {
    private final Map<MediaSource.MediaPeriodId, MediaSource.MediaPeriodId> childMediaPeriodIdToMediaPeriodId;
    private final int loopCount;
    private final MaskingMediaSource maskingMediaSource;
    private final Map<MediaPeriod, MediaSource.MediaPeriodId> mediaPeriodToChildMediaPeriodId;

    public final boolean isSingleWindow() {
        return false;
    }

    public LoopingMediaSource(MediaSource mediaSource) {
        this(mediaSource, Integer.MAX_VALUE);
    }

    public LoopingMediaSource(MediaSource mediaSource, int i) {
        Assertions.checkArgument(i > 0);
        this.maskingMediaSource = new MaskingMediaSource(mediaSource, false);
        this.loopCount = i;
        this.childMediaPeriodIdToMediaPeriodId = new HashMap();
        this.mediaPeriodToChildMediaPeriodId = new HashMap();
    }

    public final Object getTag() {
        return this.maskingMediaSource.getTag();
    }

    public final Timeline getInitialTimeline() {
        if (this.loopCount != Integer.MAX_VALUE) {
            return new LoopingTimeline(this.maskingMediaSource.getTimeline(), this.loopCount);
        }
        return new InfinitelyLoopingTimeline(this.maskingMediaSource.getTimeline());
    }

    /* access modifiers changed from: protected */
    public final void prepareSourceInternal(TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        prepareChildSource(null, this.maskingMediaSource);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.exoplayer2.source.MaskingMediaSource.createPeriod(com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, com.google.android.exoplayer2.upstream.Allocator, long):com.google.android.exoplayer2.source.MaskingMediaPeriod
     arg types: [com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, com.google.android.exoplayer2.upstream.Allocator, long]
     candidates:
      com.google.android.exoplayer2.source.MaskingMediaSource.createPeriod(com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, com.google.android.exoplayer2.upstream.Allocator, long):com.google.android.exoplayer2.source.MediaPeriod
      com.google.android.exoplayer2.source.MediaSource.createPeriod(com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, com.google.android.exoplayer2.upstream.Allocator, long):com.google.android.exoplayer2.source.MediaPeriod
      com.google.android.exoplayer2.source.MaskingMediaSource.createPeriod(com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, com.google.android.exoplayer2.upstream.Allocator, long):com.google.android.exoplayer2.source.MaskingMediaPeriod */
    public final MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        if (this.loopCount == Integer.MAX_VALUE) {
            return this.maskingMediaSource.createPeriod(mediaPeriodId, allocator, j);
        }
        MediaSource.MediaPeriodId copyWithPeriodUid = mediaPeriodId.copyWithPeriodUid(LoopingTimeline.getChildPeriodUidFromConcatenatedUid(mediaPeriodId.periodUid));
        this.childMediaPeriodIdToMediaPeriodId.put(copyWithPeriodUid, mediaPeriodId);
        MaskingMediaPeriod createPeriod = this.maskingMediaSource.createPeriod(copyWithPeriodUid, allocator, j);
        this.mediaPeriodToChildMediaPeriodId.put(createPeriod, copyWithPeriodUid);
        return createPeriod;
    }

    public final void releasePeriod(MediaPeriod mediaPeriod) {
        this.maskingMediaSource.releasePeriod(mediaPeriod);
        MediaSource.MediaPeriodId remove = this.mediaPeriodToChildMediaPeriodId.remove(mediaPeriod);
        if (remove != null) {
            this.childMediaPeriodIdToMediaPeriodId.remove(remove);
        }
    }

    /* access modifiers changed from: protected */
    public final void onChildSourceInfoRefreshed(Void voidR, MediaSource mediaSource, Timeline timeline) {
        int i = this.loopCount;
        refreshSourceInfo(i != Integer.MAX_VALUE ? new LoopingTimeline(timeline, i) : new InfinitelyLoopingTimeline(timeline));
    }

    /* access modifiers changed from: protected */
    public final MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Void voidR, MediaSource.MediaPeriodId mediaPeriodId) {
        return this.loopCount != Integer.MAX_VALUE ? this.childMediaPeriodIdToMediaPeriodId.get(mediaPeriodId) : mediaPeriodId;
    }

    static final class LoopingTimeline extends AbstractConcatenatedTimeline {
        private final int childPeriodCount;
        private final Timeline childTimeline;
        private final int childWindowCount;
        private final int loopCount;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoopingTimeline(Timeline timeline, int i) {
            super(false, new ShuffleOrder.UnshuffledShuffleOrder(i));
            boolean z = false;
            this.childTimeline = timeline;
            this.childPeriodCount = timeline.getPeriodCount();
            this.childWindowCount = timeline.getWindowCount();
            this.loopCount = i;
            int i2 = this.childPeriodCount;
            if (i2 > 0) {
                Assertions.checkState(i <= Integer.MAX_VALUE / i2 ? true : z, "LoopingMediaSource contains too many periods");
            }
        }

        public final int getWindowCount() {
            return this.childWindowCount * this.loopCount;
        }

        public final int getPeriodCount() {
            return this.childPeriodCount * this.loopCount;
        }

        public final int getChildIndexByPeriodIndex(int i) {
            return i / this.childPeriodCount;
        }

        public final int getChildIndexByWindowIndex(int i) {
            return i / this.childWindowCount;
        }

        public final int getChildIndexByChildUid(Object obj) {
            if (!(obj instanceof Integer)) {
                return -1;
            }
            return ((Integer) obj).intValue();
        }

        public final Timeline getTimelineByChildIndex(int i) {
            return this.childTimeline;
        }

        public final int getFirstPeriodIndexByChildIndex(int i) {
            return i * this.childPeriodCount;
        }

        public final int getFirstWindowIndexByChildIndex(int i) {
            return i * this.childWindowCount;
        }

        public final Object getChildUidByChildIndex(int i) {
            return Integer.valueOf(i);
        }
    }

    static final class InfinitelyLoopingTimeline extends ForwardingTimeline {
        public InfinitelyLoopingTimeline(Timeline timeline) {
            super(timeline);
        }

        public final int getNextWindowIndex(int i, int i2, boolean z) {
            int nextWindowIndex = this.timeline.getNextWindowIndex(i, i2, z);
            return nextWindowIndex == -1 ? getFirstWindowIndex(z) : nextWindowIndex;
        }

        public final int getPreviousWindowIndex(int i, int i2, boolean z) {
            int previousWindowIndex = this.timeline.getPreviousWindowIndex(i, i2, z);
            return previousWindowIndex == -1 ? getLastWindowIndex(z) : previousWindowIndex;
        }
    }
}
