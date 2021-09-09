package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;
import com.google.android.exoplayer2.util.UnknownNull;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.HashMap;

public abstract class CompositeMediaSource<T> extends BaseMediaSource {
    private final HashMap<T, MediaSourceAndListener> childSources = new HashMap<>();
    private Handler eventHandler;
    private TransferListener mediaTransferListener;

    /* access modifiers changed from: protected */
    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(@UnknownNull Object obj, MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId;
    }

    /* access modifiers changed from: protected */
    public long getMediaTimeForChildMediaTime(@UnknownNull T t, long j) {
        return j;
    }

    /* access modifiers changed from: protected */
    public int getWindowIndexForChildWindowIndex(@UnknownNull T t, int i) {
        return i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: onChildSourceInfoRefreshed */
    public abstract void lambda$prepareChildSource$0$CompositeMediaSource(@UnknownNull Object obj, MediaSource mediaSource, Timeline timeline);

    /* access modifiers changed from: protected */
    public boolean shouldDispatchCreateOrReleaseEvent(MediaSource.MediaPeriodId mediaPeriodId) {
        return true;
    }

    protected CompositeMediaSource() {
    }

    /* access modifiers changed from: protected */
    public void prepareSourceInternal(TransferListener transferListener) {
        this.mediaTransferListener = transferListener;
        this.eventHandler = Util.createHandler();
    }

    public void maybeThrowSourceInfoRefreshError() throws IOException {
        for (MediaSourceAndListener mediaSourceAndListener : this.childSources.values()) {
            mediaSourceAndListener.mediaSource.maybeThrowSourceInfoRefreshError();
        }
    }

    /* access modifiers changed from: protected */
    public void enableInternal() {
        for (MediaSourceAndListener next : this.childSources.values()) {
            next.mediaSource.enable(next.caller);
        }
    }

    /* access modifiers changed from: protected */
    public void disableInternal() {
        for (MediaSourceAndListener next : this.childSources.values()) {
            next.mediaSource.disable(next.caller);
        }
    }

    /* access modifiers changed from: protected */
    public void releaseSourceInternal() {
        for (MediaSourceAndListener next : this.childSources.values()) {
            next.mediaSource.releaseSource(next.caller);
            next.mediaSource.removeEventListener(next.eventListener);
        }
        this.childSources.clear();
    }

    /* access modifiers changed from: protected */
    public final void prepareChildSource(@UnknownNull T t, MediaSource mediaSource) {
        Assertions.checkArgument(!this.childSources.containsKey(t));
        $$Lambda$CompositeMediaSource$XIMxMigUUqAS2WvqSyL5xh9sCFo r0 = new MediaSource.MediaSourceCaller(t) {
            /* class com.google.android.exoplayer2.source.$$Lambda$CompositeMediaSource$XIMxMigUUqAS2WvqSyL5xh9sCFo */
            private final /* synthetic */ Object f$1;

            {
                this.f$1 = r2;
            }

            public final void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline) {
                CompositeMediaSource.this.lambda$prepareChildSource$0$CompositeMediaSource(this.f$1, mediaSource, timeline);
            }
        };
        ForwardingEventListener forwardingEventListener = new ForwardingEventListener(t);
        this.childSources.put(t, new MediaSourceAndListener(mediaSource, r0, forwardingEventListener));
        mediaSource.addEventListener((Handler) Assertions.checkNotNull(this.eventHandler), forwardingEventListener);
        mediaSource.addDrmEventListener((Handler) Assertions.checkNotNull(this.eventHandler), forwardingEventListener);
        mediaSource.prepareSource(r0, this.mediaTransferListener);
        if (!isEnabled()) {
            mediaSource.disable(r0);
        }
    }

    /* access modifiers changed from: protected */
    public final void enableChildSource(@UnknownNull T t) {
        MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) Assertions.checkNotNull(this.childSources.get(t));
        mediaSourceAndListener.mediaSource.enable(mediaSourceAndListener.caller);
    }

    /* access modifiers changed from: protected */
    public final void disableChildSource(@UnknownNull T t) {
        MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) Assertions.checkNotNull(this.childSources.get(t));
        mediaSourceAndListener.mediaSource.disable(mediaSourceAndListener.caller);
    }

    /* access modifiers changed from: protected */
    public final void releaseChildSource(@UnknownNull T t) {
        MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) Assertions.checkNotNull(this.childSources.remove(t));
        mediaSourceAndListener.mediaSource.releaseSource(mediaSourceAndListener.caller);
        mediaSourceAndListener.mediaSource.removeEventListener(mediaSourceAndListener.eventListener);
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
        @UnknownNull
        private final T id;

        public ForwardingEventListener(T t) {
            this.eventDispatcher = CompositeMediaSource.this.createEventDispatcher(null);
            this.id = t;
        }

        public final void onMediaPeriodCreated(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            if (maybeUpdateEventDispatcher(i, mediaPeriodId) && CompositeMediaSource.this.shouldDispatchCreateOrReleaseEvent((MediaSource.MediaPeriodId) Assertions.checkNotNull(this.eventDispatcher.mediaPeriodId))) {
                this.eventDispatcher.mediaPeriodCreated();
            }
        }

        public final void onMediaPeriodReleased(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            if (maybeUpdateEventDispatcher(i, mediaPeriodId) && CompositeMediaSource.this.shouldDispatchCreateOrReleaseEvent((MediaSource.MediaPeriodId) Assertions.checkNotNull(this.eventDispatcher.mediaPeriodId))) {
                this.eventDispatcher.mediaPeriodReleased();
            }
        }

        public final void onLoadStarted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (maybeUpdateEventDispatcher(i, mediaPeriodId)) {
                this.eventDispatcher.loadStarted(loadEventInfo, maybeUpdateMediaLoadData(mediaLoadData));
            }
        }

        public final void onLoadCompleted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (maybeUpdateEventDispatcher(i, mediaPeriodId)) {
                this.eventDispatcher.loadCompleted(loadEventInfo, maybeUpdateMediaLoadData(mediaLoadData));
            }
        }

        public final void onLoadCanceled(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (maybeUpdateEventDispatcher(i, mediaPeriodId)) {
                this.eventDispatcher.loadCanceled(loadEventInfo, maybeUpdateMediaLoadData(mediaLoadData));
            }
        }

        public final void onLoadError(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
            if (maybeUpdateEventDispatcher(i, mediaPeriodId)) {
                this.eventDispatcher.loadError(loadEventInfo, maybeUpdateMediaLoadData(mediaLoadData), iOException, z);
            }
        }

        public final void onReadingStarted(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            if (maybeUpdateEventDispatcher(i, mediaPeriodId)) {
                this.eventDispatcher.readingStarted();
            }
        }

        public final void onUpstreamDiscarded(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            if (maybeUpdateEventDispatcher(i, mediaPeriodId)) {
                this.eventDispatcher.upstreamDiscarded(maybeUpdateMediaLoadData(mediaLoadData));
            }
        }

        public final void onDownstreamFormatChanged(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            if (maybeUpdateEventDispatcher(i, mediaPeriodId)) {
                this.eventDispatcher.downstreamFormatChanged(maybeUpdateMediaLoadData(mediaLoadData));
            }
        }

        public final void onDrmSessionAcquired() {
            this.eventDispatcher.dispatch($$Lambda$CompositeMediaSource$ForwardingEventListener$l8RQcDm4DVKK72r2AbxnHR4LoSA.INSTANCE, DrmSessionEventListener.class);
        }

        public final void onDrmKeysLoaded() {
            this.eventDispatcher.dispatch($$Lambda$CompositeMediaSource$ForwardingEventListener$kmu8fhtnaMffiOYiANGPEwh4nac.INSTANCE, DrmSessionEventListener.class);
        }

        public final void onDrmSessionManagerError(Exception exc) {
            this.eventDispatcher.dispatch(new MediaSourceEventDispatcher.EventWithPeriodId(exc) {
                /* class com.google.android.exoplayer2.source.$$Lambda$CompositeMediaSource$ForwardingEventListener$xGdoDtQIsCz4CfZ832oA36VsFYQ */
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
            this.eventDispatcher.dispatch($$Lambda$CompositeMediaSource$ForwardingEventListener$9yjavK8Lbd3v7ubFoBOg5bq2sQ.INSTANCE, DrmSessionEventListener.class);
        }

        public final void onDrmKeysRemoved() {
            this.eventDispatcher.dispatch($$Lambda$CompositeMediaSource$ForwardingEventListener$fGmjbRTdCzqEUN5ciklh_x3HeE.INSTANCE, DrmSessionEventListener.class);
        }

        public final void onDrmSessionReleased() {
            this.eventDispatcher.dispatch($$Lambda$CompositeMediaSource$ForwardingEventListener$AQekCAi59V0q4er92Xo9vUDEejo.INSTANCE, DrmSessionEventListener.class);
        }

        private boolean maybeUpdateEventDispatcher(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            MediaSource.MediaPeriodId mediaPeriodId2;
            if (mediaPeriodId != null) {
                mediaPeriodId2 = CompositeMediaSource.this.getMediaPeriodIdForChildMediaPeriodId(this.id, mediaPeriodId);
                if (mediaPeriodId2 == null) {
                    return false;
                }
            } else {
                mediaPeriodId2 = null;
            }
            int windowIndexForChildWindowIndex = CompositeMediaSource.this.getWindowIndexForChildWindowIndex(this.id, i);
            if (this.eventDispatcher.windowIndex == windowIndexForChildWindowIndex && Util.areEqual(this.eventDispatcher.mediaPeriodId, mediaPeriodId2)) {
                return true;
            }
            this.eventDispatcher = CompositeMediaSource.this.createEventDispatcher(windowIndexForChildWindowIndex, mediaPeriodId2, 0);
            return true;
        }

        private MediaLoadData maybeUpdateMediaLoadData(MediaLoadData mediaLoadData) {
            long mediaTimeForChildMediaTime = CompositeMediaSource.this.getMediaTimeForChildMediaTime(this.id, mediaLoadData.mediaStartTimeMs);
            long mediaTimeForChildMediaTime2 = CompositeMediaSource.this.getMediaTimeForChildMediaTime(this.id, mediaLoadData.mediaEndTimeMs);
            if (mediaTimeForChildMediaTime == mediaLoadData.mediaStartTimeMs && mediaTimeForChildMediaTime2 == mediaLoadData.mediaEndTimeMs) {
                return mediaLoadData;
            }
            return new MediaLoadData(mediaLoadData.dataType, mediaLoadData.trackType, mediaLoadData.trackFormat, mediaLoadData.trackSelectionReason, mediaLoadData.trackSelectionData, mediaTimeForChildMediaTime, mediaTimeForChildMediaTime2);
        }
    }
}
