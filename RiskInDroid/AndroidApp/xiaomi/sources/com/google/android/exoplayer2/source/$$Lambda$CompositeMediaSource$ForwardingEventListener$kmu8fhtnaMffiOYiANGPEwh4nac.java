package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;

/* renamed from: com.google.android.exoplayer2.source.-$$Lambda$CompositeMediaSource$ForwardingEventListener$kmu8fhtnaMffiOYiANGPEwh4nac  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$CompositeMediaSource$ForwardingEventListener$kmu8fhtnaMffiOYiANGPEwh4nac implements MediaSourceEventDispatcher.EventWithPeriodId {
    public static final /* synthetic */ $$Lambda$CompositeMediaSource$ForwardingEventListener$kmu8fhtnaMffiOYiANGPEwh4nac INSTANCE = new $$Lambda$CompositeMediaSource$ForwardingEventListener$kmu8fhtnaMffiOYiANGPEwh4nac();

    private /* synthetic */ $$Lambda$CompositeMediaSource$ForwardingEventListener$kmu8fhtnaMffiOYiANGPEwh4nac() {
    }

    public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        ((DrmSessionEventListener) obj).onDrmKeysLoaded();
    }
}
