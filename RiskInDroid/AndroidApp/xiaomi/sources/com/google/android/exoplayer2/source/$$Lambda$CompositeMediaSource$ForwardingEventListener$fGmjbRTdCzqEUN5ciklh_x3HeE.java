package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;

/* renamed from: com.google.android.exoplayer2.source.-$$Lambda$CompositeMediaSource$ForwardingEventListener$-fGmjbRTdCzqEUN5ciklh_x3HeE  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$CompositeMediaSource$ForwardingEventListener$fGmjbRTdCzqEUN5ciklh_x3HeE implements MediaSourceEventDispatcher.EventWithPeriodId {
    public static final /* synthetic */ $$Lambda$CompositeMediaSource$ForwardingEventListener$fGmjbRTdCzqEUN5ciklh_x3HeE INSTANCE = new $$Lambda$CompositeMediaSource$ForwardingEventListener$fGmjbRTdCzqEUN5ciklh_x3HeE();

    private /* synthetic */ $$Lambda$CompositeMediaSource$ForwardingEventListener$fGmjbRTdCzqEUN5ciklh_x3HeE() {
    }

    public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        ((DrmSessionEventListener) obj).onDrmKeysRemoved();
    }
}
