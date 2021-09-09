package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public abstract class BaseMediaSource implements MediaSource {
    private final HashSet<MediaSource.MediaSourceCaller> enabledMediaSourceCallers = new HashSet<>(1);
    private final MediaSourceEventListener.EventDispatcher eventDispatcher = new MediaSourceEventListener.EventDispatcher();
    private Looper looper;
    private final ArrayList<MediaSource.MediaSourceCaller> mediaSourceCallers = new ArrayList<>(1);
    private Timeline timeline;

    /* access modifiers changed from: protected */
    public void disableInternal() {
    }

    /* access modifiers changed from: protected */
    public void enableInternal() {
    }

    public /* synthetic */ Timeline getInitialTimeline() {
        return MediaSource.CC.$default$getInitialTimeline(this);
    }

    public /* synthetic */ Object getTag() {
        return MediaSource.CC.$default$getTag(this);
    }

    public /* synthetic */ boolean isSingleWindow() {
        return MediaSource.CC.$default$isSingleWindow(this);
    }

    /* access modifiers changed from: protected */
    public abstract void prepareSourceInternal(TransferListener transferListener);

    /* access modifiers changed from: protected */
    public abstract void releaseSourceInternal();

    /* access modifiers changed from: protected */
    public final void refreshSourceInfo(Timeline timeline2) {
        this.timeline = timeline2;
        Iterator<MediaSource.MediaSourceCaller> it = this.mediaSourceCallers.iterator();
        while (it.hasNext()) {
            it.next().onSourceInfoRefreshed(this, timeline2);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.withParameters(int, com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, long):com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher
     arg types: [int, com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, int]
     candidates:
      com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.withParameters(int, com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, long):com.google.android.exoplayer2.util.MediaSourceEventDispatcher
      com.google.android.exoplayer2.util.MediaSourceEventDispatcher.withParameters(int, com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, long):com.google.android.exoplayer2.util.MediaSourceEventDispatcher
      com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.withParameters(int, com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, long):com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher */
    public final MediaSourceEventListener.EventDispatcher createEventDispatcher(MediaSource.MediaPeriodId mediaPeriodId) {
        return this.eventDispatcher.withParameters(0, mediaPeriodId, 0L);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.withParameters(int, com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, long):com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher
     arg types: [int, com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, long]
     candidates:
      com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.withParameters(int, com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, long):com.google.android.exoplayer2.util.MediaSourceEventDispatcher
      com.google.android.exoplayer2.util.MediaSourceEventDispatcher.withParameters(int, com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, long):com.google.android.exoplayer2.util.MediaSourceEventDispatcher
      com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.withParameters(int, com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, long):com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher */
    /* access modifiers changed from: protected */
    public final MediaSourceEventListener.EventDispatcher createEventDispatcher(MediaSource.MediaPeriodId mediaPeriodId, long j) {
        Assertions.checkNotNull(mediaPeriodId);
        return this.eventDispatcher.withParameters(0, mediaPeriodId, j);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.withParameters(int, com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, long):com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher
     arg types: [int, com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, long]
     candidates:
      com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.withParameters(int, com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, long):com.google.android.exoplayer2.util.MediaSourceEventDispatcher
      com.google.android.exoplayer2.util.MediaSourceEventDispatcher.withParameters(int, com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, long):com.google.android.exoplayer2.util.MediaSourceEventDispatcher
      com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.withParameters(int, com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, long):com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher */
    /* access modifiers changed from: protected */
    public final MediaSourceEventListener.EventDispatcher createEventDispatcher(int i, MediaSource.MediaPeriodId mediaPeriodId, long j) {
        return this.eventDispatcher.withParameters(i, mediaPeriodId, j);
    }

    /* access modifiers changed from: protected */
    public final boolean isEnabled() {
        return !this.enabledMediaSourceCallers.isEmpty();
    }

    public final void addEventListener(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
        this.eventDispatcher.addEventListener(handler, mediaSourceEventListener);
    }

    public final void removeEventListener(MediaSourceEventListener mediaSourceEventListener) {
        this.eventDispatcher.removeEventListener(mediaSourceEventListener);
    }

    public final void addDrmEventListener(Handler handler, DrmSessionEventListener drmSessionEventListener) {
        this.eventDispatcher.addEventListener(handler, drmSessionEventListener, DrmSessionEventListener.class);
    }

    public final void removeDrmEventListener(DrmSessionEventListener drmSessionEventListener) {
        this.eventDispatcher.removeEventListener(drmSessionEventListener, DrmSessionEventListener.class);
    }

    public final void prepareSource(MediaSource.MediaSourceCaller mediaSourceCaller, TransferListener transferListener) {
        Looper myLooper = Looper.myLooper();
        Looper looper2 = this.looper;
        Assertions.checkArgument(looper2 == null || looper2 == myLooper);
        Timeline timeline2 = this.timeline;
        this.mediaSourceCallers.add(mediaSourceCaller);
        if (this.looper == null) {
            this.looper = myLooper;
            this.enabledMediaSourceCallers.add(mediaSourceCaller);
            prepareSourceInternal(transferListener);
        } else if (timeline2 != null) {
            enable(mediaSourceCaller);
            mediaSourceCaller.onSourceInfoRefreshed(this, timeline2);
        }
    }

    public final void enable(MediaSource.MediaSourceCaller mediaSourceCaller) {
        Assertions.checkNotNull(this.looper);
        boolean isEmpty = this.enabledMediaSourceCallers.isEmpty();
        this.enabledMediaSourceCallers.add(mediaSourceCaller);
        if (isEmpty) {
            enableInternal();
        }
    }

    public final void disable(MediaSource.MediaSourceCaller mediaSourceCaller) {
        boolean z = !this.enabledMediaSourceCallers.isEmpty();
        this.enabledMediaSourceCallers.remove(mediaSourceCaller);
        if (z && this.enabledMediaSourceCallers.isEmpty()) {
            disableInternal();
        }
    }

    public final void releaseSource(MediaSource.MediaSourceCaller mediaSourceCaller) {
        this.mediaSourceCallers.remove(mediaSourceCaller);
        if (this.mediaSourceCallers.isEmpty()) {
            this.looper = null;
            this.timeline = null;
            this.enabledMediaSourceCallers.clear();
            releaseSourceInternal();
            return;
        }
        disable(mediaSourceCaller);
    }
}
