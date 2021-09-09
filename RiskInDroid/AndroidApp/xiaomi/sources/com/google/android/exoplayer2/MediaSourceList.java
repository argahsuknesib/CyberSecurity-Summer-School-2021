package com.google.android.exoplayer2;

import android.os.Handler;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MaskingMediaPeriod;
import com.google.android.exoplayer2.source.MaskingMediaSource;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class MediaSourceList {
    private final HashMap<MediaSourceHolder, MediaSourceAndListener> childSources = new HashMap<>();
    private final Set<MediaSourceHolder> enabledMediaSourceHolders = new HashSet();
    public final MediaSourceEventListener.EventDispatcher eventDispatcher = new MediaSourceEventListener.EventDispatcher();
    private boolean isPrepared;
    private final Map<MediaPeriod, MediaSourceHolder> mediaSourceByMediaPeriod = new IdentityHashMap();
    private final Map<Object, MediaSourceHolder> mediaSourceByUid = new HashMap();
    private final List<MediaSourceHolder> mediaSourceHolders = new ArrayList();
    private final MediaSourceListInfoRefreshListener mediaSourceListInfoListener;
    private TransferListener mediaTransferListener;
    private ShuffleOrder shuffleOrder = new ShuffleOrder.DefaultShuffleOrder(0);

    public interface MediaSourceListInfoRefreshListener {
        void onPlaylistUpdateRequested();
    }

    public MediaSourceList(MediaSourceListInfoRefreshListener mediaSourceListInfoRefreshListener) {
        this.mediaSourceListInfoListener = mediaSourceListInfoRefreshListener;
    }

    public final Timeline setMediaSources(List<MediaSourceHolder> list, ShuffleOrder shuffleOrder2) {
        removeMediaSourcesInternal(0, this.mediaSourceHolders.size());
        return addMediaSources(this.mediaSourceHolders.size(), list, shuffleOrder2);
    }

    public final Timeline addMediaSources(int i, List<MediaSourceHolder> list, ShuffleOrder shuffleOrder2) {
        if (!list.isEmpty()) {
            this.shuffleOrder = shuffleOrder2;
            for (int i2 = i; i2 < list.size() + i; i2++) {
                MediaSourceHolder mediaSourceHolder = list.get(i2 - i);
                if (i2 > 0) {
                    MediaSourceHolder mediaSourceHolder2 = this.mediaSourceHolders.get(i2 - 1);
                    mediaSourceHolder.reset(mediaSourceHolder2.firstWindowIndexInChild + mediaSourceHolder2.mediaSource.getTimeline().getWindowCount());
                } else {
                    mediaSourceHolder.reset(0);
                }
                correctOffsets(i2, mediaSourceHolder.mediaSource.getTimeline().getWindowCount());
                this.mediaSourceHolders.add(i2, mediaSourceHolder);
                this.mediaSourceByUid.put(mediaSourceHolder.uid, mediaSourceHolder);
                if (this.isPrepared) {
                    prepareChildSource(mediaSourceHolder);
                    if (this.mediaSourceByMediaPeriod.isEmpty()) {
                        this.enabledMediaSourceHolders.add(mediaSourceHolder);
                    } else {
                        disableChildSource(mediaSourceHolder);
                    }
                }
            }
        }
        return createTimeline();
    }

    public final Timeline removeMediaSourceRange(int i, int i2, ShuffleOrder shuffleOrder2) {
        Assertions.checkArgument(i >= 0 && i <= i2 && i2 <= getSize());
        this.shuffleOrder = shuffleOrder2;
        removeMediaSourcesInternal(i, i2);
        return createTimeline();
    }

    public final Timeline moveMediaSource(int i, int i2, ShuffleOrder shuffleOrder2) {
        return moveMediaSourceRange(i, i + 1, i2, shuffleOrder2);
    }

    public Timeline moveMediaSourceRange(int i, int i2, int i3, ShuffleOrder shuffleOrder2) {
        Assertions.checkArgument(i >= 0 && i <= i2 && i2 <= getSize() && i3 >= 0);
        this.shuffleOrder = shuffleOrder2;
        if (i == i2 || i == i3) {
            return createTimeline();
        }
        int min = Math.min(i, i3);
        int max = Math.max(((i2 - i) + i3) - 1, i2 - 1);
        int i4 = this.mediaSourceHolders.get(min).firstWindowIndexInChild;
        moveMediaSourceHolders(this.mediaSourceHolders, i, i2, i3);
        while (min <= max) {
            MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(min);
            mediaSourceHolder.firstWindowIndexInChild = i4;
            i4 += mediaSourceHolder.mediaSource.getTimeline().getWindowCount();
            min++;
        }
        return createTimeline();
    }

    public final Timeline clear(ShuffleOrder shuffleOrder2) {
        if (shuffleOrder2 == null) {
            shuffleOrder2 = this.shuffleOrder.cloneAndClear();
        }
        this.shuffleOrder = shuffleOrder2;
        removeMediaSourcesInternal(0, getSize());
        return createTimeline();
    }

    public final boolean isPrepared() {
        return this.isPrepared;
    }

    public final int getSize() {
        return this.mediaSourceHolders.size();
    }

    public final void setAnalyticsCollector(Handler handler, AnalyticsCollector analyticsCollector) {
        this.eventDispatcher.addEventListener(handler, analyticsCollector, MediaSourceEventListener.class);
        this.eventDispatcher.addEventListener(handler, analyticsCollector, DrmSessionEventListener.class);
    }

    public final Timeline setShuffleOrder(ShuffleOrder shuffleOrder2) {
        int size = getSize();
        if (shuffleOrder2.getLength() != size) {
            shuffleOrder2 = shuffleOrder2.cloneAndClear().cloneAndInsert(0, size);
        }
        this.shuffleOrder = shuffleOrder2;
        return createTimeline();
    }

    public final void prepare(TransferListener transferListener) {
        Assertions.checkState(!this.isPrepared);
        this.mediaTransferListener = transferListener;
        for (int i = 0; i < this.mediaSourceHolders.size(); i++) {
            MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(i);
            prepareChildSource(mediaSourceHolder);
            this.enabledMediaSourceHolders.add(mediaSourceHolder);
        }
        this.isPrepared = true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.exoplayer2.source.MaskingMediaSource.createPeriod(com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, com.google.android.exoplayer2.upstream.Allocator, long):com.google.android.exoplayer2.source.MaskingMediaPeriod
     arg types: [com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, com.google.android.exoplayer2.upstream.Allocator, long]
     candidates:
      com.google.android.exoplayer2.source.MaskingMediaSource.createPeriod(com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, com.google.android.exoplayer2.upstream.Allocator, long):com.google.android.exoplayer2.source.MediaPeriod
      com.google.android.exoplayer2.source.MediaSource.createPeriod(com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, com.google.android.exoplayer2.upstream.Allocator, long):com.google.android.exoplayer2.source.MediaPeriod
      com.google.android.exoplayer2.source.MaskingMediaSource.createPeriod(com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, com.google.android.exoplayer2.upstream.Allocator, long):com.google.android.exoplayer2.source.MaskingMediaPeriod */
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        Object mediaSourceHolderUid = getMediaSourceHolderUid(mediaPeriodId.periodUid);
        MediaSource.MediaPeriodId copyWithPeriodUid = mediaPeriodId.copyWithPeriodUid(getChildPeriodUid(mediaPeriodId.periodUid));
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) Assertions.checkNotNull(this.mediaSourceByUid.get(mediaSourceHolderUid));
        enableMediaSource(mediaSourceHolder);
        mediaSourceHolder.activeMediaPeriodIds.add(copyWithPeriodUid);
        MaskingMediaPeriod createPeriod = mediaSourceHolder.mediaSource.createPeriod(copyWithPeriodUid, allocator, j);
        this.mediaSourceByMediaPeriod.put(createPeriod, mediaSourceHolder);
        disableUnusedMediaSources();
        return createPeriod;
    }

    public final void releasePeriod(MediaPeriod mediaPeriod) {
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) Assertions.checkNotNull(this.mediaSourceByMediaPeriod.remove(mediaPeriod));
        mediaSourceHolder.mediaSource.releasePeriod(mediaPeriod);
        mediaSourceHolder.activeMediaPeriodIds.remove(((MaskingMediaPeriod) mediaPeriod).id);
        if (!this.mediaSourceByMediaPeriod.isEmpty()) {
            disableUnusedMediaSources();
        }
        maybeReleaseChildSource(mediaSourceHolder);
    }

    public final void release() {
        for (MediaSourceAndListener next : this.childSources.values()) {
            next.mediaSource.releaseSource(next.caller);
            next.mediaSource.removeEventListener(next.eventListener);
        }
        this.childSources.clear();
        this.enabledMediaSourceHolders.clear();
        this.isPrepared = false;
    }

    public final void maybeThrowSourceInfoRefreshError() throws IOException {
        for (MediaSourceAndListener mediaSourceAndListener : this.childSources.values()) {
            mediaSourceAndListener.mediaSource.maybeThrowSourceInfoRefreshError();
        }
    }

    public final Timeline createTimeline() {
        if (this.mediaSourceHolders.isEmpty()) {
            return Timeline.EMPTY;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.mediaSourceHolders.size(); i2++) {
            MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(i2);
            mediaSourceHolder.firstWindowIndexInChild = i;
            i += mediaSourceHolder.mediaSource.getTimeline().getWindowCount();
        }
        return new PlaylistTimeline(this.mediaSourceHolders, this.shuffleOrder);
    }

    private void enableMediaSource(MediaSourceHolder mediaSourceHolder) {
        this.enabledMediaSourceHolders.add(mediaSourceHolder);
        MediaSourceAndListener mediaSourceAndListener = this.childSources.get(mediaSourceHolder);
        if (mediaSourceAndListener != null) {
            mediaSourceAndListener.mediaSource.enable(mediaSourceAndListener.caller);
        }
    }

    private void disableUnusedMediaSources() {
        Iterator<MediaSourceHolder> it = this.enabledMediaSourceHolders.iterator();
        while (it.hasNext()) {
            MediaSourceHolder next = it.next();
            if (next.activeMediaPeriodIds.isEmpty()) {
                disableChildSource(next);
                it.remove();
            }
        }
    }

    private void disableChildSource(MediaSourceHolder mediaSourceHolder) {
        MediaSourceAndListener mediaSourceAndListener = this.childSources.get(mediaSourceHolder);
        if (mediaSourceAndListener != null) {
            mediaSourceAndListener.mediaSource.disable(mediaSourceAndListener.caller);
        }
    }

    private void removeMediaSourcesInternal(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            MediaSourceHolder remove = this.mediaSourceHolders.remove(i3);
            this.mediaSourceByUid.remove(remove.uid);
            correctOffsets(i3, -remove.mediaSource.getTimeline().getWindowCount());
            remove.isRemoved = true;
            if (this.isPrepared) {
                maybeReleaseChildSource(remove);
            }
        }
    }

    private void correctOffsets(int i, int i2) {
        while (i < this.mediaSourceHolders.size()) {
            this.mediaSourceHolders.get(i).firstWindowIndexInChild += i2;
            i++;
        }
    }

    public static MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(MediaSourceHolder mediaSourceHolder, MediaSource.MediaPeriodId mediaPeriodId) {
        for (int i = 0; i < mediaSourceHolder.activeMediaPeriodIds.size(); i++) {
            if (mediaSourceHolder.activeMediaPeriodIds.get(i).windowSequenceNumber == mediaPeriodId.windowSequenceNumber) {
                return mediaPeriodId.copyWithPeriodUid(getPeriodUid(mediaSourceHolder, mediaPeriodId.periodUid));
            }
        }
        return null;
    }

    public static int getWindowIndexForChildWindowIndex(MediaSourceHolder mediaSourceHolder, int i) {
        return i + mediaSourceHolder.firstWindowIndexInChild;
    }

    private void prepareChildSource(MediaSourceHolder mediaSourceHolder) {
        MaskingMediaSource maskingMediaSource = mediaSourceHolder.mediaSource;
        $$Lambda$MediaSourceList$DRc4hnLQZlnNtTKBH8S6xSAkIcU r1 = new MediaSource.MediaSourceCaller() {
            /* class com.google.android.exoplayer2.$$Lambda$MediaSourceList$DRc4hnLQZlnNtTKBH8S6xSAkIcU */

            public final void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline) {
                MediaSourceList.this.lambda$prepareChildSource$0$MediaSourceList(mediaSource, timeline);
            }
        };
        ForwardingEventListener forwardingEventListener = new ForwardingEventListener(mediaSourceHolder);
        this.childSources.put(mediaSourceHolder, new MediaSourceAndListener(maskingMediaSource, r1, forwardingEventListener));
        maskingMediaSource.addEventListener(Util.createHandler(), forwardingEventListener);
        maskingMediaSource.addDrmEventListener(Util.createHandler(), forwardingEventListener);
        maskingMediaSource.prepareSource(r1, this.mediaTransferListener);
    }

    public /* synthetic */ void lambda$prepareChildSource$0$MediaSourceList(MediaSource mediaSource, Timeline timeline) {
        this.mediaSourceListInfoListener.onPlaylistUpdateRequested();
    }

    private void maybeReleaseChildSource(MediaSourceHolder mediaSourceHolder) {
        if (mediaSourceHolder.isRemoved && mediaSourceHolder.activeMediaPeriodIds.isEmpty()) {
            MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) Assertions.checkNotNull(this.childSources.remove(mediaSourceHolder));
            mediaSourceAndListener.mediaSource.releaseSource(mediaSourceAndListener.caller);
            mediaSourceAndListener.mediaSource.removeEventListener(mediaSourceAndListener.eventListener);
            this.enabledMediaSourceHolders.remove(mediaSourceHolder);
        }
    }

    private static Object getMediaSourceHolderUid(Object obj) {
        return PlaylistTimeline.getChildTimelineUidFromConcatenatedUid(obj);
    }

    private static Object getChildPeriodUid(Object obj) {
        return PlaylistTimeline.getChildPeriodUidFromConcatenatedUid(obj);
    }

    private static Object getPeriodUid(MediaSourceHolder mediaSourceHolder, Object obj) {
        return PlaylistTimeline.getConcatenatedUid(mediaSourceHolder.uid, obj);
    }

    static void moveMediaSourceHolders(List<MediaSourceHolder> list, int i, int i2, int i3) {
        MediaSourceHolder[] mediaSourceHolderArr = new MediaSourceHolder[(i2 - i)];
        for (int length = mediaSourceHolderArr.length - 1; length >= 0; length--) {
            mediaSourceHolderArr[length] = list.remove(i + length);
        }
        list.addAll(Math.min(i3, list.size()), Arrays.asList(mediaSourceHolderArr));
    }

    static final class MediaSourceHolder {
        public final List<MediaSource.MediaPeriodId> activeMediaPeriodIds = new ArrayList();
        public int firstWindowIndexInChild;
        public boolean isRemoved;
        public final MaskingMediaSource mediaSource;
        public final Object uid = new Object();

        public MediaSourceHolder(MediaSource mediaSource2, boolean z) {
            this.mediaSource = new MaskingMediaSource(mediaSource2, z);
        }

        public final void reset(int i) {
            this.firstWindowIndexInChild = i;
            this.isRemoved = false;
            this.activeMediaPeriodIds.clear();
        }
    }

    static final class PlaylistTimeline extends AbstractConcatenatedTimeline {
        private final HashMap<Object, Integer> childIndexByUid = new HashMap<>();
        private final int[] firstPeriodInChildIndices;
        private final int[] firstWindowInChildIndices;
        private final int periodCount;
        private final Timeline[] timelines;
        private final Object[] uids;
        private final int windowCount;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PlaylistTimeline(Collection<MediaSourceHolder> collection, ShuffleOrder shuffleOrder) {
            super(false, shuffleOrder);
            int i = 0;
            int size = collection.size();
            this.firstPeriodInChildIndices = new int[size];
            this.firstWindowInChildIndices = new int[size];
            this.timelines = new Timeline[size];
            this.uids = new Object[size];
            int i2 = 0;
            int i3 = 0;
            for (MediaSourceHolder next : collection) {
                this.timelines[i3] = next.mediaSource.getTimeline();
                this.firstWindowInChildIndices[i3] = i;
                this.firstPeriodInChildIndices[i3] = i2;
                i += this.timelines[i3].getWindowCount();
                i2 += this.timelines[i3].getPeriodCount();
                this.uids[i3] = next.uid;
                this.childIndexByUid.put(this.uids[i3], Integer.valueOf(i3));
                i3++;
            }
            this.windowCount = i;
            this.periodCount = i2;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.android.exoplayer2.util.Util.binarySearchFloor(int[], int, boolean, boolean):int
         arg types: [int[], int, int, int]
         candidates:
          com.google.android.exoplayer2.util.Util.binarySearchFloor(com.google.android.exoplayer2.util.LongArray, long, boolean, boolean):int
          com.google.android.exoplayer2.util.Util.binarySearchFloor(java.util.List, java.lang.Comparable, boolean, boolean):int
          com.google.android.exoplayer2.util.Util.binarySearchFloor(long[], long, boolean, boolean):int
          com.google.android.exoplayer2.util.Util.binarySearchFloor(int[], int, boolean, boolean):int */
        /* access modifiers changed from: protected */
        public final int getChildIndexByPeriodIndex(int i) {
            return Util.binarySearchFloor(this.firstPeriodInChildIndices, i + 1, false, false);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.android.exoplayer2.util.Util.binarySearchFloor(int[], int, boolean, boolean):int
         arg types: [int[], int, int, int]
         candidates:
          com.google.android.exoplayer2.util.Util.binarySearchFloor(com.google.android.exoplayer2.util.LongArray, long, boolean, boolean):int
          com.google.android.exoplayer2.util.Util.binarySearchFloor(java.util.List, java.lang.Comparable, boolean, boolean):int
          com.google.android.exoplayer2.util.Util.binarySearchFloor(long[], long, boolean, boolean):int
          com.google.android.exoplayer2.util.Util.binarySearchFloor(int[], int, boolean, boolean):int */
        /* access modifiers changed from: protected */
        public final int getChildIndexByWindowIndex(int i) {
            return Util.binarySearchFloor(this.firstWindowInChildIndices, i + 1, false, false);
        }

        /* access modifiers changed from: protected */
        public final int getChildIndexByChildUid(Object obj) {
            Integer num = this.childIndexByUid.get(obj);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        /* access modifiers changed from: protected */
        public final Timeline getTimelineByChildIndex(int i) {
            return this.timelines[i];
        }

        /* access modifiers changed from: protected */
        public final int getFirstPeriodIndexByChildIndex(int i) {
            return this.firstPeriodInChildIndices[i];
        }

        /* access modifiers changed from: protected */
        public final int getFirstWindowIndexByChildIndex(int i) {
            return this.firstWindowInChildIndices[i];
        }

        /* access modifiers changed from: protected */
        public final Object getChildUidByChildIndex(int i) {
            return this.uids[i];
        }

        public final int getWindowCount() {
            return this.windowCount;
        }

        public final int getPeriodCount() {
            return this.periodCount;
        }
    }

    static final class MediaSourceAndListener {
        public final MediaSource.MediaSourceCaller caller;
        public final MediaSourceEventListener eventListener;
        public final MediaSource mediaSource;

        public MediaSourceAndListener(MediaSource mediaSource2, MediaSource.MediaSourceCaller mediaSourceCaller, MediaSourceEventListener mediaSourceEventListener) {
            this.mediaSource = mediaSource2;
            this.caller = mediaSourceCaller;
            this.eventListener = mediaSourceEventListener;
        }
    }

    final class ForwardingEventListener implements DrmSessionEventListener, MediaSourceEventListener {
        private MediaSourceEventListener.EventDispatcher eventDispatcher;
        private final MediaSourceHolder id;

        public ForwardingEventListener(MediaSourceHolder mediaSourceHolder) {
            this.eventDispatcher = MediaSourceList.this.eventDispatcher;
            this.id = mediaSourceHolder;
        }

        public final void onMediaPeriodCreated(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            if (maybeUpdateEventDispatcher(i, mediaPeriodId)) {
                this.eventDispatcher.mediaPeriodCreated();
            }
        }

        public final void onMediaPeriodReleased(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            if (maybeUpdateEventDispatcher(i, mediaPeriodId)) {
                this.eventDispatcher.mediaPeriodReleased();
            }
        }

        public final void onLoadStarted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (maybeUpdateEventDispatcher(i, mediaPeriodId)) {
                this.eventDispatcher.loadStarted(loadEventInfo, mediaLoadData);
            }
        }

        public final void onLoadCompleted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (maybeUpdateEventDispatcher(i, mediaPeriodId)) {
                this.eventDispatcher.loadCompleted(loadEventInfo, mediaLoadData);
            }
        }

        public final void onLoadCanceled(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (maybeUpdateEventDispatcher(i, mediaPeriodId)) {
                this.eventDispatcher.loadCanceled(loadEventInfo, mediaLoadData);
            }
        }

        public final void onLoadError(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
            if (maybeUpdateEventDispatcher(i, mediaPeriodId)) {
                this.eventDispatcher.loadError(loadEventInfo, mediaLoadData, iOException, z);
            }
        }

        public final void onReadingStarted(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            if (maybeUpdateEventDispatcher(i, mediaPeriodId)) {
                this.eventDispatcher.readingStarted();
            }
        }

        public final void onUpstreamDiscarded(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            if (maybeUpdateEventDispatcher(i, mediaPeriodId)) {
                this.eventDispatcher.upstreamDiscarded(mediaLoadData);
            }
        }

        public final void onDownstreamFormatChanged(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            if (maybeUpdateEventDispatcher(i, mediaPeriodId)) {
                this.eventDispatcher.downstreamFormatChanged(mediaLoadData);
            }
        }

        public final void onDrmSessionAcquired() {
            this.eventDispatcher.dispatch($$Lambda$MediaSourceList$ForwardingEventListener$k6gBPDyTZPquiBICVzFS0Muqc.INSTANCE, DrmSessionEventListener.class);
        }

        public final void onDrmKeysLoaded() {
            this.eventDispatcher.dispatch($$Lambda$MediaSourceList$ForwardingEventListener$fhb2exUjBHzBGHhRT9m02bpjsZo.INSTANCE, DrmSessionEventListener.class);
        }

        public final void onDrmSessionManagerError(Exception exc) {
            this.eventDispatcher.dispatch(new MediaSourceEventDispatcher.EventWithPeriodId(exc) {
                /* class com.google.android.exoplayer2.$$Lambda$MediaSourceList$ForwardingEventListener$PjSBoEQLDOIx6CDODyIkm8pIcc */
                private final /* synthetic */ Exception f$0;

                {
                    this.f$0 = r1;
                }

                public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                    ((DrmSessionEventListener) obj).onDrmSessionManagerError(this.f$0);
                }
            }, DrmSessionEventListener.class);
        }

        public final void onDrmKeysRestored() {
            this.eventDispatcher.dispatch($$Lambda$MediaSourceList$ForwardingEventListener$Pdwjbl5YO7SnUtondGShL1q9k5Y.INSTANCE, DrmSessionEventListener.class);
        }

        public final void onDrmKeysRemoved() {
            this.eventDispatcher.dispatch($$Lambda$MediaSourceList$ForwardingEventListener$0cIZbTADXQNoYJ_QVd6haz8rh_I.INSTANCE, DrmSessionEventListener.class);
        }

        public final void onDrmSessionReleased() {
            this.eventDispatcher.dispatch($$Lambda$MediaSourceList$ForwardingEventListener$CCkS6axdUAsnmpFXwDvZ8kN82g.INSTANCE, DrmSessionEventListener.class);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.withParameters(int, com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, long):com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher
         arg types: [int, com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, int]
         candidates:
          com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.withParameters(int, com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, long):com.google.android.exoplayer2.util.MediaSourceEventDispatcher
          com.google.android.exoplayer2.util.MediaSourceEventDispatcher.withParameters(int, com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, long):com.google.android.exoplayer2.util.MediaSourceEventDispatcher
          com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.withParameters(int, com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, long):com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher */
        private boolean maybeUpdateEventDispatcher(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            MediaSource.MediaPeriodId mediaPeriodId2;
            if (mediaPeriodId != null) {
                mediaPeriodId2 = MediaSourceList.getMediaPeriodIdForChildMediaPeriodId(this.id, mediaPeriodId);
                if (mediaPeriodId2 == null) {
                    return false;
                }
            } else {
                mediaPeriodId2 = null;
            }
            int windowIndexForChildWindowIndex = MediaSourceList.getWindowIndexForChildWindowIndex(this.id, i);
            if (this.eventDispatcher.windowIndex == windowIndexForChildWindowIndex && Util.areEqual(this.eventDispatcher.mediaPeriodId, mediaPeriodId2)) {
                return true;
            }
            this.eventDispatcher = MediaSourceList.this.eventDispatcher.withParameters(windowIndexForChildWindowIndex, mediaPeriodId2, 0L);
            return true;
        }
    }
}
