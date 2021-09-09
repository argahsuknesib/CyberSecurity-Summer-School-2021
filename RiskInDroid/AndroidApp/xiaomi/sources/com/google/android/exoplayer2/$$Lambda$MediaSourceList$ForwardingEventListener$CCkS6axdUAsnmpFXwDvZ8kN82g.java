package com.google.android.exoplayer2;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;

/* renamed from: com.google.android.exoplayer2.-$$Lambda$MediaSourceList$ForwardingEventListener$CCkS-6axdUAsnmpFXwDvZ8kN82g  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$MediaSourceList$ForwardingEventListener$CCkS6axdUAsnmpFXwDvZ8kN82g implements MediaSourceEventDispatcher.EventWithPeriodId {
    public static final /* synthetic */ $$Lambda$MediaSourceList$ForwardingEventListener$CCkS6axdUAsnmpFXwDvZ8kN82g INSTANCE = new $$Lambda$MediaSourceList$ForwardingEventListener$CCkS6axdUAsnmpFXwDvZ8kN82g();

    private /* synthetic */ $$Lambda$MediaSourceList$ForwardingEventListener$CCkS6axdUAsnmpFXwDvZ8kN82g() {
    }

    public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        ((DrmSessionEventListener) obj).onDrmSessionReleased();
    }
}
