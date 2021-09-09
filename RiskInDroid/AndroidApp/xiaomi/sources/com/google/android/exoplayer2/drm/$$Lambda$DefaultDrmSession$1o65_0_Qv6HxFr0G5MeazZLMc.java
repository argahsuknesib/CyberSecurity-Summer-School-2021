package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;

/* renamed from: com.google.android.exoplayer2.drm.-$$Lambda$DefaultDrmSession$1o65_0_Qv6Hx-Fr0-G5MeazZLMc  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$DefaultDrmSession$1o65_0_Qv6HxFr0G5MeazZLMc implements MediaSourceEventDispatcher.EventWithPeriodId {
    public static final /* synthetic */ $$Lambda$DefaultDrmSession$1o65_0_Qv6HxFr0G5MeazZLMc INSTANCE = new $$Lambda$DefaultDrmSession$1o65_0_Qv6HxFr0G5MeazZLMc();

    private /* synthetic */ $$Lambda$DefaultDrmSession$1o65_0_Qv6HxFr0G5MeazZLMc() {
    }

    public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        ((DrmSessionEventListener) obj).onDrmSessionReleased();
    }
}
