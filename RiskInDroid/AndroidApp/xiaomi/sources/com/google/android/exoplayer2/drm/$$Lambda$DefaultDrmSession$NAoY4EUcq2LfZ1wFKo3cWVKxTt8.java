package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;

/* renamed from: com.google.android.exoplayer2.drm.-$$Lambda$DefaultDrmSession$NAoY4EUcq2LfZ1wFKo3cWVKxTt8  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$DefaultDrmSession$NAoY4EUcq2LfZ1wFKo3cWVKxTt8 implements MediaSourceEventDispatcher.EventWithPeriodId {
    public static final /* synthetic */ $$Lambda$DefaultDrmSession$NAoY4EUcq2LfZ1wFKo3cWVKxTt8 INSTANCE = new $$Lambda$DefaultDrmSession$NAoY4EUcq2LfZ1wFKo3cWVKxTt8();

    private /* synthetic */ $$Lambda$DefaultDrmSession$NAoY4EUcq2LfZ1wFKo3cWVKxTt8() {
    }

    public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        ((DrmSessionEventListener) obj).onDrmKeysRestored();
    }
}
