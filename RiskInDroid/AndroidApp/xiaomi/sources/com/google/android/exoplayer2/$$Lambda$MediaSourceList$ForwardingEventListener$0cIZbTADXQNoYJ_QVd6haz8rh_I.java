package com.google.android.exoplayer2;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;

/* renamed from: com.google.android.exoplayer2.-$$Lambda$MediaSourceList$ForwardingEventListener$0cIZbTADXQNoYJ_QVd6haz8rh_I  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$MediaSourceList$ForwardingEventListener$0cIZbTADXQNoYJ_QVd6haz8rh_I implements MediaSourceEventDispatcher.EventWithPeriodId {
    public static final /* synthetic */ $$Lambda$MediaSourceList$ForwardingEventListener$0cIZbTADXQNoYJ_QVd6haz8rh_I INSTANCE = new $$Lambda$MediaSourceList$ForwardingEventListener$0cIZbTADXQNoYJ_QVd6haz8rh_I();

    private /* synthetic */ $$Lambda$MediaSourceList$ForwardingEventListener$0cIZbTADXQNoYJ_QVd6haz8rh_I() {
    }

    public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        ((DrmSessionEventListener) obj).onDrmKeysRemoved();
    }
}
