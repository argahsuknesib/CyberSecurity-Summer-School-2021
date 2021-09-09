package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;

/* renamed from: com.google.android.exoplayer2.source.-$$Lambda$CompositeMediaSource$ForwardingEventListener$l8RQcDm4DVKK72r2AbxnHR4LoSA  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$CompositeMediaSource$ForwardingEventListener$l8RQcDm4DVKK72r2AbxnHR4LoSA implements MediaSourceEventDispatcher.EventWithPeriodId {
    public static final /* synthetic */ $$Lambda$CompositeMediaSource$ForwardingEventListener$l8RQcDm4DVKK72r2AbxnHR4LoSA INSTANCE = new $$Lambda$CompositeMediaSource$ForwardingEventListener$l8RQcDm4DVKK72r2AbxnHR4LoSA();

    private /* synthetic */ $$Lambda$CompositeMediaSource$ForwardingEventListener$l8RQcDm4DVKK72r2AbxnHR4LoSA() {
    }

    public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        ((DrmSessionEventListener) obj).onDrmSessionAcquired();
    }
}
