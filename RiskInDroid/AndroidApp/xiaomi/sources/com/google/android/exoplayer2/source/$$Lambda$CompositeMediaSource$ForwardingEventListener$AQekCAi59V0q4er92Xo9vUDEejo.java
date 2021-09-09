package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;

/* renamed from: com.google.android.exoplayer2.source.-$$Lambda$CompositeMediaSource$ForwardingEventListener$AQekCAi59V0q4er92Xo9vUDEejo  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$CompositeMediaSource$ForwardingEventListener$AQekCAi59V0q4er92Xo9vUDEejo implements MediaSourceEventDispatcher.EventWithPeriodId {
    public static final /* synthetic */ $$Lambda$CompositeMediaSource$ForwardingEventListener$AQekCAi59V0q4er92Xo9vUDEejo INSTANCE = new $$Lambda$CompositeMediaSource$ForwardingEventListener$AQekCAi59V0q4er92Xo9vUDEejo();

    private /* synthetic */ $$Lambda$CompositeMediaSource$ForwardingEventListener$AQekCAi59V0q4er92Xo9vUDEejo() {
    }

    public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        ((DrmSessionEventListener) obj).onDrmSessionReleased();
    }
}
