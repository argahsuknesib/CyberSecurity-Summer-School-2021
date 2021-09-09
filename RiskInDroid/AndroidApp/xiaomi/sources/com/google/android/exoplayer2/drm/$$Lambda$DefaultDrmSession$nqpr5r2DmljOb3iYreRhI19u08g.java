package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;

/* renamed from: com.google.android.exoplayer2.drm.-$$Lambda$DefaultDrmSession$nqpr5r2DmljOb3iYreRhI19u08g  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$DefaultDrmSession$nqpr5r2DmljOb3iYreRhI19u08g implements MediaSourceEventDispatcher.EventWithPeriodId {
    public static final /* synthetic */ $$Lambda$DefaultDrmSession$nqpr5r2DmljOb3iYreRhI19u08g INSTANCE = new $$Lambda$DefaultDrmSession$nqpr5r2DmljOb3iYreRhI19u08g();

    private /* synthetic */ $$Lambda$DefaultDrmSession$nqpr5r2DmljOb3iYreRhI19u08g() {
    }

    public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        ((DrmSessionEventListener) obj).onDrmSessionAcquired();
    }
}
