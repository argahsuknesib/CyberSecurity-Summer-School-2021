package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;

/* renamed from: com.google.android.exoplayer2.source.-$$Lambda$MediaSourceEventListener$EventDispatcher$BSABueoK3ofLZMEn1Wj6ryFbyrY  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$MediaSourceEventListener$EventDispatcher$BSABueoK3ofLZMEn1Wj6ryFbyrY implements MediaSourceEventDispatcher.EventWithPeriodId {
    public static final /* synthetic */ $$Lambda$MediaSourceEventListener$EventDispatcher$BSABueoK3ofLZMEn1Wj6ryFbyrY INSTANCE = new $$Lambda$MediaSourceEventListener$EventDispatcher$BSABueoK3ofLZMEn1Wj6ryFbyrY();

    private /* synthetic */ $$Lambda$MediaSourceEventListener$EventDispatcher$BSABueoK3ofLZMEn1Wj6ryFbyrY() {
    }

    public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        ((MediaSourceEventListener) obj).onMediaPeriodCreated(i, (MediaSource.MediaPeriodId) Assertions.checkNotNull(mediaPeriodId));
    }
}
