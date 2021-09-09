package com.google.android.exoplayer2;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;

/* renamed from: com.google.android.exoplayer2.-$$Lambda$MediaSourceList$ForwardingEventListener$k6gBPDyTZP-quiB-ICVzFS0Muqc  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$MediaSourceList$ForwardingEventListener$k6gBPDyTZPquiBICVzFS0Muqc implements MediaSourceEventDispatcher.EventWithPeriodId {
    public static final /* synthetic */ $$Lambda$MediaSourceList$ForwardingEventListener$k6gBPDyTZPquiBICVzFS0Muqc INSTANCE = new $$Lambda$MediaSourceList$ForwardingEventListener$k6gBPDyTZPquiBICVzFS0Muqc();

    private /* synthetic */ $$Lambda$MediaSourceList$ForwardingEventListener$k6gBPDyTZPquiBICVzFS0Muqc() {
    }

    public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        ((DrmSessionEventListener) obj).onDrmSessionAcquired();
    }
}
