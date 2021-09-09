package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;

/* renamed from: com.google.android.exoplayer2.drm.-$$Lambda$DefaultDrmSession$V1j_ZKWSqkMMAMJax6SaOOiUDxA  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$DefaultDrmSession$V1j_ZKWSqkMMAMJax6SaOOiUDxA implements MediaSourceEventDispatcher.EventWithPeriodId {
    public static final /* synthetic */ $$Lambda$DefaultDrmSession$V1j_ZKWSqkMMAMJax6SaOOiUDxA INSTANCE = new $$Lambda$DefaultDrmSession$V1j_ZKWSqkMMAMJax6SaOOiUDxA();

    private /* synthetic */ $$Lambda$DefaultDrmSession$V1j_ZKWSqkMMAMJax6SaOOiUDxA() {
    }

    public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        ((DrmSessionEventListener) obj).onDrmKeysLoaded();
    }
}
