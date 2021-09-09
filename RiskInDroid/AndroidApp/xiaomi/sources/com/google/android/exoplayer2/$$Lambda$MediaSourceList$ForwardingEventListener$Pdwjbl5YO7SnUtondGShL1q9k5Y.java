package com.google.android.exoplayer2;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;

/* renamed from: com.google.android.exoplayer2.-$$Lambda$MediaSourceList$ForwardingEventListener$Pdwjbl5YO7SnUtondGShL1q9k5Y  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$MediaSourceList$ForwardingEventListener$Pdwjbl5YO7SnUtondGShL1q9k5Y implements MediaSourceEventDispatcher.EventWithPeriodId {
    public static final /* synthetic */ $$Lambda$MediaSourceList$ForwardingEventListener$Pdwjbl5YO7SnUtondGShL1q9k5Y INSTANCE = new $$Lambda$MediaSourceList$ForwardingEventListener$Pdwjbl5YO7SnUtondGShL1q9k5Y();

    private /* synthetic */ $$Lambda$MediaSourceList$ForwardingEventListener$Pdwjbl5YO7SnUtondGShL1q9k5Y() {
    }

    public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        ((DrmSessionEventListener) obj).onDrmKeysRestored();
    }
}
