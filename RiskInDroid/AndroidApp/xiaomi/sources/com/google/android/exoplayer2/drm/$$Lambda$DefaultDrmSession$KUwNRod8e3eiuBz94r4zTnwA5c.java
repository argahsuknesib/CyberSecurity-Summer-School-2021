package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;

/* renamed from: com.google.android.exoplayer2.drm.-$$Lambda$DefaultDrmSession$KUwNRod8e3eiuBz94r-4zTnwA5c  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$DefaultDrmSession$KUwNRod8e3eiuBz94r4zTnwA5c implements MediaSourceEventDispatcher.EventWithPeriodId {
    public static final /* synthetic */ $$Lambda$DefaultDrmSession$KUwNRod8e3eiuBz94r4zTnwA5c INSTANCE = new $$Lambda$DefaultDrmSession$KUwNRod8e3eiuBz94r4zTnwA5c();

    private /* synthetic */ $$Lambda$DefaultDrmSession$KUwNRod8e3eiuBz94r4zTnwA5c() {
    }

    public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        ((DrmSessionEventListener) obj).onDrmSessionAcquired();
    }
}
