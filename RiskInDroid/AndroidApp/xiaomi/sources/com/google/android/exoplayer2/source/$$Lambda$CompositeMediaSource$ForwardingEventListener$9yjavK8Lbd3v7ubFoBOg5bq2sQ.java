package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;

/* renamed from: com.google.android.exoplayer2.source.-$$Lambda$CompositeMediaSource$ForwardingEventListener$9yjavK8Lbd3v7u-bFoBOg5bq2sQ  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$CompositeMediaSource$ForwardingEventListener$9yjavK8Lbd3v7ubFoBOg5bq2sQ implements MediaSourceEventDispatcher.EventWithPeriodId {
    public static final /* synthetic */ $$Lambda$CompositeMediaSource$ForwardingEventListener$9yjavK8Lbd3v7ubFoBOg5bq2sQ INSTANCE = new $$Lambda$CompositeMediaSource$ForwardingEventListener$9yjavK8Lbd3v7ubFoBOg5bq2sQ();

    private /* synthetic */ $$Lambda$CompositeMediaSource$ForwardingEventListener$9yjavK8Lbd3v7ubFoBOg5bq2sQ() {
    }

    public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        ((DrmSessionEventListener) obj).onDrmKeysRestored();
    }
}
