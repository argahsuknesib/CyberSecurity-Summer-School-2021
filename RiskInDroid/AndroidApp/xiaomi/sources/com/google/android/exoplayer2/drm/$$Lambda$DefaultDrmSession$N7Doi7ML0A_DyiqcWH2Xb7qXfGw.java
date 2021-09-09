package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;

/* renamed from: com.google.android.exoplayer2.drm.-$$Lambda$DefaultDrmSession$N7Doi7ML0A_DyiqcWH2Xb7qXfGw  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$DefaultDrmSession$N7Doi7ML0A_DyiqcWH2Xb7qXfGw implements MediaSourceEventDispatcher.EventWithPeriodId {
    public static final /* synthetic */ $$Lambda$DefaultDrmSession$N7Doi7ML0A_DyiqcWH2Xb7qXfGw INSTANCE = new $$Lambda$DefaultDrmSession$N7Doi7ML0A_DyiqcWH2Xb7qXfGw();

    private /* synthetic */ $$Lambda$DefaultDrmSession$N7Doi7ML0A_DyiqcWH2Xb7qXfGw() {
    }

    public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        ((DrmSessionEventListener) obj).onDrmKeysRestored();
    }
}
