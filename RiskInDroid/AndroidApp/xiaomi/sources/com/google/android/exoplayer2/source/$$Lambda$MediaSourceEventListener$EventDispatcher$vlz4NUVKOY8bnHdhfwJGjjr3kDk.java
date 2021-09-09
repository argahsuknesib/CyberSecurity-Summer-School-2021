package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;

/* renamed from: com.google.android.exoplayer2.source.-$$Lambda$MediaSourceEventListener$EventDispatcher$vlz4NUVKOY8bnHdhfwJGjjr3kDk  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$MediaSourceEventListener$EventDispatcher$vlz4NUVKOY8bnHdhfwJGjjr3kDk implements MediaSourceEventDispatcher.EventWithPeriodId {
    public static final /* synthetic */ $$Lambda$MediaSourceEventListener$EventDispatcher$vlz4NUVKOY8bnHdhfwJGjjr3kDk INSTANCE = new $$Lambda$MediaSourceEventListener$EventDispatcher$vlz4NUVKOY8bnHdhfwJGjjr3kDk();

    private /* synthetic */ $$Lambda$MediaSourceEventListener$EventDispatcher$vlz4NUVKOY8bnHdhfwJGjjr3kDk() {
    }

    public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        ((MediaSourceEventListener) obj).onMediaPeriodReleased(i, (MediaSource.MediaPeriodId) Assertions.checkNotNull(mediaPeriodId));
    }
}
