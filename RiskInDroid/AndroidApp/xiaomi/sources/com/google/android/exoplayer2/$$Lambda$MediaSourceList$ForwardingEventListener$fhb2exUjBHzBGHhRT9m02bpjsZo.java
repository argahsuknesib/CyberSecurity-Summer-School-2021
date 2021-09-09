package com.google.android.exoplayer2;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;

/* renamed from: com.google.android.exoplayer2.-$$Lambda$MediaSourceList$ForwardingEventListener$fhb2exUjBHzBGHhRT9m02bpjsZo  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$MediaSourceList$ForwardingEventListener$fhb2exUjBHzBGHhRT9m02bpjsZo implements MediaSourceEventDispatcher.EventWithPeriodId {
    public static final /* synthetic */ $$Lambda$MediaSourceList$ForwardingEventListener$fhb2exUjBHzBGHhRT9m02bpjsZo INSTANCE = new $$Lambda$MediaSourceList$ForwardingEventListener$fhb2exUjBHzBGHhRT9m02bpjsZo();

    private /* synthetic */ $$Lambda$MediaSourceList$ForwardingEventListener$fhb2exUjBHzBGHhRT9m02bpjsZo() {
    }

    public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        ((DrmSessionEventListener) obj).onDrmKeysLoaded();
    }
}
