package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;

/* renamed from: com.google.android.exoplayer2.source.-$$Lambda$MediaSourceEventListener$EventDispatcher$N1B7VYHNXvjDJdSJHEaHdlLEKBo  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$MediaSourceEventListener$EventDispatcher$N1B7VYHNXvjDJdSJHEaHdlLEKBo implements MediaSourceEventDispatcher.EventWithPeriodId {
    public static final /* synthetic */ $$Lambda$MediaSourceEventListener$EventDispatcher$N1B7VYHNXvjDJdSJHEaHdlLEKBo INSTANCE = new $$Lambda$MediaSourceEventListener$EventDispatcher$N1B7VYHNXvjDJdSJHEaHdlLEKBo();

    private /* synthetic */ $$Lambda$MediaSourceEventListener$EventDispatcher$N1B7VYHNXvjDJdSJHEaHdlLEKBo() {
    }

    public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        ((MediaSourceEventListener) obj).onReadingStarted(i, (MediaSource.MediaPeriodId) Assertions.checkNotNull(mediaPeriodId));
    }
}
