package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.AbstractConcatenatedTimeline;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ConcatenatingMediaSource extends CompositeMediaSource<MediaSourceHolder> {
    private final Set<MediaSourceHolder> enabledMediaSourceHolders;
    private final boolean isAtomic;
    private final Map<MediaPeriod, MediaSourceHolder> mediaSourceByMediaPeriod;
    private final Map<Object, MediaSourceHolder> mediaSourceByUid;
    private final List<MediaSourceHolder> mediaSourceHolders;
    private final List<MediaSourceHolder> mediaSourcesPublic;
    private Set<HandlerAndRunnable> nextTimelineUpdateOnCompletionActions;
    private final Set<HandlerAndRunnable> pendingOnCompletionActions;
    private Handler playbackThreadHandler;
    private ShuffleOrder shuffleOrder;
    private boolean timelineUpdateScheduled;
    private final boolean useLazyPreparation;

    /* access modifiers changed from: protected */
    public final void enableInternal() {
    }

    public final Object getTag() {
        return null;
    }

    public final boolean isSingleWindow() {
        return false;
    }

    public ConcatenatingMediaSource(MediaSource... mediaSourceArr) {
        this(false, mediaSourceArr);
    }

    public ConcatenatingMediaSource(boolean z, MediaSource... mediaSourceArr) {
        this(z, new ShuffleOrder.DefaultShuffleOrder(0), mediaSourceArr);
    }

    public ConcatenatingMediaSource(boolean z, ShuffleOrder shuffleOrder2, MediaSource... mediaSourceArr) {
        this(z, false, shuffleOrder2, mediaSourceArr);
    }

    public ConcatenatingMediaSource(boolean z, boolean z2, ShuffleOrder shuffleOrder2, MediaSource... mediaSourceArr) {
        for (MediaSource checkNotNull : mediaSourceArr) {
            Assertions.checkNotNull(checkNotNull);
        }
        this.shuffleOrder = shuffleOrder2.getLength() > 0 ? shuffleOrder2.cloneAndClear() : shuffleOrder2;
        this.mediaSourceByMediaPeriod = new IdentityHashMap();
        this.mediaSourceByUid = new HashMap();
        this.mediaSourcesPublic = new ArrayList();
        this.mediaSourceHolders = new ArrayList();
        this.nextTimelineUpdateOnCompletionActions = new HashSet();
        this.pendingOnCompletionActions = new HashSet();
        this.enabledMediaSourceHolders = new HashSet();
        this.isAtomic = z;
        this.useLazyPreparation = z2;
        addMediaSources(Arrays.asList(mediaSourceArr));
    }

    public final synchronized Timeline getInitialTimeline() {
        return new ConcatenatedTimeline(this.mediaSourcesPublic, this.shuffleOrder.getLength() != this.mediaSourcesPublic.size() ? this.shuffleOrder.cloneAndClear().cloneAndInsert(0, this.mediaSourcesPublic.size()) : this.shuffleOrder, this.isAtomic);
    }

    public final synchronized void addMediaSource(MediaSource mediaSource) {
        addMediaSource(this.mediaSourcesPublic.size(), mediaSource);
    }

    public final synchronized void addMediaSource(MediaSource mediaSource, Handler handler, Runnable runnable) {
        addMediaSource(this.mediaSourcesPublic.size(), mediaSource, handler, runnable);
    }

    public final synchronized void addMediaSource(int i, MediaSource mediaSource) {
        addPublicMediaSources(i, Collections.singletonList(mediaSource), null, null);
    }

    public final synchronized void addMediaSource(int i, MediaSource mediaSource, Handler handler, Runnable runnable) {
        addPublicMediaSources(i, Collections.singletonList(mediaSource), handler, runnable);
    }

    public final synchronized void addMediaSources(Collection<MediaSource> collection) {
        addPublicMediaSources(this.mediaSourcesPublic.size(), collection, null, null);
    }

    public final synchronized void addMediaSources(Collection<MediaSource> collection, Handler handler, Runnable runnable) {
        addPublicMediaSources(this.mediaSourcesPublic.size(), collection, handler, runnable);
    }

    public final synchronized void addMediaSources(int i, Collection<MediaSource> collection) {
        addPublicMediaSources(i, collection, null, null);
    }

    public final synchronized void addMediaSources(int i, Collection<MediaSource> collection, Handler handler, Runnable runnable) {
        addPublicMediaSources(i, collection, handler, runnable);
    }

    public final synchronized MediaSource removeMediaSource(int i) {
        MediaSource mediaSource;
        mediaSource = getMediaSource(i);
        removePublicMediaSources(i, i + 1, null, null);
        return mediaSource;
    }

    public final synchronized MediaSource removeMediaSource(int i, Handler handler, Runnable runnable) {
        MediaSource mediaSource;
        mediaSource = getMediaSource(i);
        removePublicMediaSources(i, i + 1, handler, runnable);
        return mediaSource;
    }

    public final synchronized void removeMediaSourceRange(int i, int i2) {
        removePublicMediaSources(i, i2, null, null);
    }

    public final synchronized void removeMediaSourceRange(int i, int i2, Handler handler, Runnable runnable) {
        removePublicMediaSources(i, i2, handler, runnable);
    }

    public final synchronized void moveMediaSource(int i, int i2) {
        movePublicMediaSource(i, i2, null, null);
    }

    public final synchronized void moveMediaSource(int i, int i2, Handler handler, Runnable runnable) {
        movePublicMediaSource(i, i2, handler, runnable);
    }

    public final synchronized void clear() {
        removeMediaSourceRange(0, getSize());
    }

    public final synchronized void clear(Handler handler, Runnable runnable) {
        removeMediaSourceRange(0, getSize(), handler, runnable);
    }

    public final synchronized int getSize() {
        return this.mediaSourcesPublic.size();
    }

    public final synchronized MediaSource getMediaSource(int i) {
        return this.mediaSourcesPublic.get(i).mediaSource;
    }

    public final synchronized void setShuffleOrder(ShuffleOrder shuffleOrder2) {
        setPublicShuffleOrder(shuffleOrder2, null, null);
    }

    public final synchronized void setShuffleOrder(ShuffleOrder shuffleOrder2, Handler handler, Runnable runnable) {
        setPublicShuffleOrder(shuffleOrder2, handler, runnable);
    }

    /* access modifiers changed from: protected */
    public final synchronized void prepareSourceInternal(TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        this.playbackThreadHandler = new Handler(new Handler.Callback() {
            /* class com.google.android.exoplayer2.source.$$Lambda$ConcatenatingMediaSource$fl0myfoK2raBckmHYwV9YTd0eeo */

            public final boolean handleMessage(Message message) {
                return ConcatenatingMediaSource.this.handleMessage(message);
            }
        });
        if (this.mediaSourcesPublic.isEmpty()) {
            updateTimelineAndScheduleOnCompletionActions();
            return;
        }
        this.shuffleOrder = this.shuffleOrder.cloneAndInsert(0, this.mediaSourcesPublic.size());
        addMediaSourcesInternal(0, this.mediaSourcesPublic);
        scheduleTimelineUpdate();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.exoplayer2.source.MaskingMediaSource.createPeriod(com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, com.google.android.exoplayer2.upstream.Allocator, long):com.google.android.exoplayer2.source.MaskingMediaPeriod
     arg types: [com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, com.google.android.exoplayer2.upstream.Allocator, long]
     candidates:
      com.google.android.exoplayer2.source.MaskingMediaSource.createPeriod(com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, com.google.android.exoplayer2.upstream.Allocator, long):com.google.android.exoplayer2.source.MediaPeriod
      com.google.android.exoplayer2.source.MediaSource.createPeriod(com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, com.google.android.exoplayer2.upstream.Allocator, long):com.google.android.exoplayer2.source.MediaPeriod
      com.google.android.exoplayer2.source.MaskingMediaSource.createPeriod(com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, com.google.android.exoplayer2.upstream.Allocator, long):com.google.android.exoplayer2.source.MaskingMediaPeriod */
    public final MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        Object mediaSourceHolderUid = getMediaSourceHolderUid(mediaPeriodId.periodUid);
        MediaSource.MediaPeriodId copyWithPeriodUid = mediaPeriodId.copyWithPeriodUid(getChildPeriodUid(mediaPeriodId.periodUid));
        MediaSourceHolder mediaSourceHolder = this.mediaSourceByUid.get(mediaSourceHolderUid);
        if (mediaSourceHolder == null) {
            mediaSourceHolder = new MediaSourceHolder(new DummyMediaSource(), this.useLazyPreparation);
            mediaSourceHolder.isRemoved = true;
            prepareChildSource(mediaSourceHolder, mediaSourceHolder.mediaSource);
        }
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

    /* access modifiers changed from: protected */
    public final void disableInternal() {
        super.disableInternal();
        this.enabledMediaSourceHolders.clear();
    }

    /* access modifiers changed from: protected */
    public final synchronized void releaseSourceInternal() {
        super.releaseSourceInternal();
        this.mediaSourceHolders.clear();
        this.enabledMediaSourceHolders.clear();
        this.mediaSourceByUid.clear();
        this.shuffleOrder = this.shuffleOrder.cloneAndClear();
        if (this.playbackThreadHandler != null) {
            this.playbackThreadHandler.removeCallbacksAndMessages(null);
            this.playbackThreadHandler = null;
        }
        this.timelineUpdateScheduled = false;
        this.nextTimelineUpdateOnCompletionActions.clear();
        dispatchOnCompletionActions(this.pendingOnCompletionActions);
    }

    /* access modifiers changed from: protected */
    public final void onChildSourceInfoRefreshed(MediaSourceHolder mediaSourceHolder, MediaSource mediaSource, Timeline timeline) {
        updateMediaSourceInternal(mediaSourceHolder, timeline);
    }

    /* access modifiers changed from: protected */
    public final MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(MediaSourceHolder mediaSourceHolder, MediaSource.MediaPeriodId mediaPeriodId) {
        for (int i = 0; i < mediaSourceHolder.activeMediaPeriodIds.size(); i++) {
            if (mediaSourceHolder.activeMediaPeriodIds.get(i).windowSequenceNumber == mediaPeriodId.windowSequenceNumber) {
                return mediaPeriodId.copyWithPeriodUid(getPeriodUid(mediaSourceHolder, mediaPeriodId.periodUid));
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final int getWindowIndexForChildWindowIndex(MediaSourceHolder mediaSourceHolder, int i) {
        return i + mediaSourceHolder.firstWindowIndexInChild;
    }

    private void addPublicMediaSources(int i, Collection<MediaSource> collection, Handler handler, Runnable runnable) {
        boolean z = true;
        if ((handler == null) != (runnable == null)) {
            z = false;
        }
        Assertions.checkArgument(z);
        Handler handler2 = this.playbackThreadHandler;
        for (MediaSource checkNotNull : collection) {
            Assertions.checkNotNull(checkNotNull);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (MediaSource mediaSourceHolder : collection) {
            arrayList.add(new MediaSourceHolder(mediaSourceHolder, this.useLazyPreparation));
        }
        this.mediaSourcesPublic.addAll(i, arrayList);
        if (handler2 != null && !collection.isEmpty()) {
            handler2.obtainMessage(0, new MessageData(i, arrayList, createOnCompletionAction(handler, runnable))).sendToTarget();
        } else if (runnable != null && handler != null) {
            handler.post(runnable);
        }
    }

    private void removePublicMediaSources(int i, int i2, Handler handler, Runnable runnable) {
        boolean z = false;
        if ((handler == null) == (runnable == null)) {
            z = true;
        }
        Assertions.checkArgument(z);
        Handler handler2 = this.playbackThreadHandler;
        Util.removeRange(this.mediaSourcesPublic, i, i2);
        if (handler2 != null) {
            handler2.obtainMessage(1, new MessageData(i, Integer.valueOf(i2), createOnCompletionAction(handler, runnable))).sendToTarget();
        } else if (runnable != null && handler != null) {
            handler.post(runnable);
        }
    }

    private void movePublicMediaSource(int i, int i2, Handler handler, Runnable runnable) {
        boolean z = true;
        if ((handler == null) != (runnable == null)) {
            z = false;
        }
        Assertions.checkArgument(z);
        Handler handler2 = this.playbackThreadHandler;
        List<MediaSourceHolder> list = this.mediaSourcesPublic;
        list.add(i2, list.remove(i));
        if (handler2 != null) {
            handler2.obtainMessage(2, new MessageData(i, Integer.valueOf(i2), createOnCompletionAction(handler, runnable))).sendToTarget();
        } else if (runnable != null && handler != null) {
            handler.post(runnable);
        }
    }

    private void setPublicShuffleOrder(ShuffleOrder shuffleOrder2, Handler handler, Runnable runnable) {
        boolean z = true;
        if ((handler == null) != (runnable == null)) {
            z = false;
        }
        Assertions.checkArgument(z);
        Handler handler2 = this.playbackThreadHandler;
        if (handler2 != null) {
            int size = getSize();
            if (shuffleOrder2.getLength() != size) {
                shuffleOrder2 = shuffleOrder2.cloneAndClear().cloneAndInsert(0, size);
            }
            handler2.obtainMessage(3, new MessageData(0, shuffleOrder2, createOnCompletionAction(handler, runnable))).sendToTarget();
            return;
        }
        if (shuffleOrder2.getLength() > 0) {
            shuffleOrder2 = shuffleOrder2.cloneAndClear();
        }
        this.shuffleOrder = shuffleOrder2;
        if (runnable != null && handler != null) {
            handler.post(runnable);
        }
    }

    private HandlerAndRunnable createOnCompletionAction(Handler handler, Runnable runnable) {
        if (handler == null || runnable == null) {
            return null;
        }
        HandlerAndRunnable handlerAndRunnable = new HandlerAndRunnable(handler, runnable);
        this.pendingOnCompletionActions.add(handlerAndRunnable);
        return handlerAndRunnable;
    }

    /* access modifiers changed from: private */
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            MessageData messageData = (MessageData) Util.castNonNull(message.obj);
            this.shuffleOrder = this.shuffleOrder.cloneAndInsert(messageData.index, ((Collection) messageData.customData).size());
            addMediaSourcesInternal(messageData.index, (Collection) messageData.customData);
            scheduleTimelineUpdate(messageData.onCompletionAction);
        } else if (i == 1) {
            MessageData messageData2 = (MessageData) Util.castNonNull(message.obj);
            int i2 = messageData2.index;
            int intValue = ((Integer) messageData2.customData).intValue();
            if (i2 == 0 && intValue == this.shuffleOrder.getLength()) {
                this.shuffleOrder = this.shuffleOrder.cloneAndClear();
            } else {
                this.shuffleOrder = this.shuffleOrder.cloneAndRemove(i2, intValue);
            }
            for (int i3 = intValue - 1; i3 >= i2; i3--) {
                removeMediaSourceInternal(i3);
            }
            scheduleTimelineUpdate(messageData2.onCompletionAction);
        } else if (i == 2) {
            MessageData messageData3 = (MessageData) Util.castNonNull(message.obj);
            this.shuffleOrder = this.shuffleOrder.cloneAndRemove(messageData3.index, messageData3.index + 1);
            this.shuffleOrder = this.shuffleOrder.cloneAndInsert(((Integer) messageData3.customData).intValue(), 1);
            moveMediaSourceInternal(messageData3.index, ((Integer) messageData3.customData).intValue());
            scheduleTimelineUpdate(messageData3.onCompletionAction);
        } else if (i == 3) {
            MessageData messageData4 = (MessageData) Util.castNonNull(message.obj);
            this.shuffleOrder = (ShuffleOrder) messageData4.customData;
            scheduleTimelineUpdate(messageData4.onCompletionAction);
        } else if (i == 4) {
            updateTimelineAndScheduleOnCompletionActions();
        } else if (i == 5) {
            dispatchOnCompletionActions((Set) Util.castNonNull(message.obj));
        } else {
            throw new IllegalStateException();
        }
        return true;
    }

    private void scheduleTimelineUpdate() {
        scheduleTimelineUpdate(null);
    }

    private void scheduleTimelineUpdate(HandlerAndRunnable handlerAndRunnable) {
        if (!this.timelineUpdateScheduled) {
            getPlaybackThreadHandlerOnPlaybackThread().obtainMessage(4).sendToTarget();
            this.timelineUpdateScheduled = true;
        }
        if (handlerAndRunnable != null) {
            this.nextTimelineUpdateOnCompletionActions.add(handlerAndRunnable);
        }
    }

    private void updateTimelineAndScheduleOnCompletionActions() {
        this.timelineUpdateScheduled = false;
        Set<HandlerAndRunnable> set = this.nextTimelineUpdateOnCompletionActions;
        this.nextTimelineUpdateOnCompletionActions = new HashSet();
        refreshSourceInfo(new ConcatenatedTimeline(this.mediaSourceHolders, this.shuffleOrder, this.isAtomic));
        getPlaybackThreadHandlerOnPlaybackThread().obtainMessage(5, set).sendToTarget();
    }

    private Handler getPlaybackThreadHandlerOnPlaybackThread() {
        return (Handler) Assertions.checkNotNull(this.playbackThreadHandler);
    }

    private synchronized void dispatchOnCompletionActions(Set<HandlerAndRunnable> set) {
        for (HandlerAndRunnable dispatch : set) {
            dispatch.dispatch();
        }
        this.pendingOnCompletionActions.removeAll(set);
    }

    private void addMediaSourcesInternal(int i, Collection<MediaSourceHolder> collection) {
        for (MediaSourceHolder addMediaSourceInternal : collection) {
            addMediaSourceInternal(i, addMediaSourceInternal);
            i++;
        }
    }

    private void addMediaSourceInternal(int i, MediaSourceHolder mediaSourceHolder) {
        if (i > 0) {
            MediaSourceHolder mediaSourceHolder2 = this.mediaSourceHolders.get(i - 1);
            mediaSourceHolder.reset(i, mediaSourceHolder2.firstWindowIndexInChild + mediaSourceHolder2.mediaSource.getTimeline().getWindowCount());
        } else {
            mediaSourceHolder.reset(i, 0);
        }
        correctOffsets(i, 1, mediaSourceHolder.mediaSource.getTimeline().getWindowCount());
        this.mediaSourceHolders.add(i, mediaSourceHolder);
        this.mediaSourceByUid.put(mediaSourceHolder.uid, mediaSourceHolder);
        prepareChildSource(mediaSourceHolder, mediaSourceHolder.mediaSource);
        if (!isEnabled() || !this.mediaSourceByMediaPeriod.isEmpty()) {
            disableChildSource(mediaSourceHolder);
        } else {
            this.enabledMediaSourceHolders.add(mediaSourceHolder);
        }
    }

    private void updateMediaSourceInternal(MediaSourceHolder mediaSourceHolder, Timeline timeline) {
        int windowCount;
        if (mediaSourceHolder.childIndex + 1 < this.mediaSourceHolders.size() && (windowCount = timeline.getWindowCount() - (this.mediaSourceHolders.get(mediaSourceHolder.childIndex + 1).firstWindowIndexInChild - mediaSourceHolder.firstWindowIndexInChild)) != 0) {
            correctOffsets(mediaSourceHolder.childIndex + 1, 0, windowCount);
        }
        scheduleTimelineUpdate();
    }

    private void removeMediaSourceInternal(int i) {
        MediaSourceHolder remove = this.mediaSourceHolders.remove(i);
        this.mediaSourceByUid.remove(remove.uid);
        correctOffsets(i, -1, -remove.mediaSource.getTimeline().getWindowCount());
        remove.isRemoved = true;
        maybeReleaseChildSource(remove);
    }

    private void moveMediaSourceInternal(int i, int i2) {
        int min = Math.min(i, i2);
        int max = Math.max(i, i2);
        int i3 = this.mediaSourceHolders.get(min).firstWindowIndexInChild;
        List<MediaSourceHolder> list = this.mediaSourceHolders;
        list.add(i2, list.remove(i));
        while (min <= max) {
            MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(min);
            mediaSourceHolder.childIndex = min;
            mediaSourceHolder.firstWindowIndexInChild = i3;
            i3 += mediaSourceHolder.mediaSource.getTimeline().getWindowCount();
            min++;
        }
    }

    private void correctOffsets(int i, int i2, int i3) {
        while (i < this.mediaSourceHolders.size()) {
            MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(i);
            mediaSourceHolder.childIndex += i2;
            mediaSourceHolder.firstWindowIndexInChild += i3;
            i++;
        }
    }

    private void maybeReleaseChildSource(MediaSourceHolder mediaSourceHolder) {
        if (mediaSourceHolder.isRemoved && mediaSourceHolder.activeMediaPeriodIds.isEmpty()) {
            this.enabledMediaSourceHolders.remove(mediaSourceHolder);
            releaseChildSource(mediaSourceHolder);
        }
    }

    private void enableMediaSource(MediaSourceHolder mediaSourceHolder) {
        this.enabledMediaSourceHolders.add(mediaSourceHolder);
        enableChildSource(mediaSourceHolder);
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

    private static Object getMediaSourceHolderUid(Object obj) {
        return ConcatenatedTimeline.getChildTimelineUidFromConcatenatedUid(obj);
    }

    private static Object getChildPeriodUid(Object obj) {
        return ConcatenatedTimeline.getChildPeriodUidFromConcatenatedUid(obj);
    }

    private static Object getPeriodUid(MediaSourceHolder mediaSourceHolder, Object obj) {
        return ConcatenatedTimeline.getConcatenatedUid(mediaSourceHolder.uid, obj);
    }

    static final class MediaSourceHolder {
        public final List<MediaSource.MediaPeriodId> activeMediaPeriodIds = new ArrayList();
        public int childIndex;
        public int firstWindowIndexInChild;
        public boolean isRemoved;
        public final MaskingMediaSource mediaSource;
        public final Object uid = new Object();

        public MediaSourceHolder(MediaSource mediaSource2, boolean z) {
            this.mediaSource = new MaskingMediaSource(mediaSource2, z);
        }

        public final void reset(int i, int i2) {
            this.childIndex = i;
            this.firstWindowIndexInChild = i2;
            this.isRemoved = false;
            this.activeMediaPeriodIds.clear();
        }
    }

    static final class MessageData<T> {
        public final T customData;
        public final int index;
        public final HandlerAndRunnable onCompletionAction;

        public MessageData(int i, T t, HandlerAndRunnable handlerAndRunnable) {
            this.index = i;
            this.customData = t;
            this.onCompletionAction = handlerAndRunnable;
        }
    }

    static final class ConcatenatedTimeline extends AbstractConcatenatedTimeline {
        private final HashMap<Object, Integer> childIndexByUid = new HashMap<>();
        private final int[] firstPeriodInChildIndices;
        private final int[] firstWindowInChildIndices;
        private final int periodCount;
        private final Timeline[] timelines;
        private final Object[] uids;
        private final int windowCount;

        public ConcatenatedTimeline(Collection<MediaSourceHolder> collection, ShuffleOrder shuffleOrder, boolean z) {
            super(z, shuffleOrder);
            int size = collection.size();
            this.firstPeriodInChildIndices = new int[size];
            this.firstWindowInChildIndices = new int[size];
            this.timelines = new Timeline[size];
            this.uids = new Object[size];
            int i = 0;
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
        public final int getChildIndexByWindowIndex(int i) {
            return Util.binarySearchFloor(this.firstWindowInChildIndices, i + 1, false, false);
        }

        public final int getChildIndexByChildUid(Object obj) {
            Integer num = this.childIndexByUid.get(obj);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        public final Timeline getTimelineByChildIndex(int i) {
            return this.timelines[i];
        }

        public final int getFirstPeriodIndexByChildIndex(int i) {
            return this.firstPeriodInChildIndices[i];
        }

        public final int getFirstWindowIndexByChildIndex(int i) {
            return this.firstWindowInChildIndices[i];
        }

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

    static final class DummyMediaSource extends BaseMediaSource {
        public final Object getTag() {
            return null;
        }

        public final void maybeThrowSourceInfoRefreshError() {
        }

        /* access modifiers changed from: protected */
        public final void prepareSourceInternal(TransferListener transferListener) {
        }

        public final void releasePeriod(MediaPeriod mediaPeriod) {
        }

        /* access modifiers changed from: protected */
        public final void releaseSourceInternal() {
        }

        private DummyMediaSource() {
        }

        public final MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
            throw new UnsupportedOperationException();
        }
    }

    static final class HandlerAndRunnable {
        private final Handler handler;
        private final Runnable runnable;

        public HandlerAndRunnable(Handler handler2, Runnable runnable2) {
            this.handler = handler2;
            this.runnable = runnable2;
        }

        public final void dispatch() {
            this.handler.post(this.runnable);
        }
    }
}
