package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;
import java.util.Iterator;

public class MediaSourceEventDispatcher {
    protected final CopyOnWriteMultiset<ListenerInfo> listenerInfos;
    public final MediaSource.MediaPeriodId mediaPeriodId;
    protected final long mediaTimeOffsetMs;
    public final int windowIndex;

    public interface EventWithPeriodId<T> {
        void sendTo(T t, int i, MediaSource.MediaPeriodId mediaPeriodId);
    }

    public MediaSourceEventDispatcher() {
        this(new CopyOnWriteMultiset(), 0, null, 0);
    }

    protected MediaSourceEventDispatcher(CopyOnWriteMultiset<ListenerInfo> copyOnWriteMultiset, int i, MediaSource.MediaPeriodId mediaPeriodId2, long j) {
        this.listenerInfos = copyOnWriteMultiset;
        this.windowIndex = i;
        this.mediaPeriodId = mediaPeriodId2;
        this.mediaTimeOffsetMs = j;
    }

    public MediaSourceEventDispatcher withParameters(int i, MediaSource.MediaPeriodId mediaPeriodId2, long j) {
        return new MediaSourceEventDispatcher(this.listenerInfos, i, mediaPeriodId2, j);
    }

    public <T> void addEventListener(Handler handler, T t, Class<T> cls) {
        Assertions.checkNotNull(handler);
        Assertions.checkNotNull(t);
        this.listenerInfos.add(new ListenerInfo(handler, t, cls));
    }

    public <T> void removeEventListener(T t, Class<T> cls) {
        Iterator<ListenerInfo> it = this.listenerInfos.iterator();
        while (it.hasNext()) {
            ListenerInfo next = it.next();
            if (next.listener == t && next.listenerClass.equals(cls)) {
                this.listenerInfos.remove(next);
                return;
            }
        }
    }

    public <T> void dispatch(EventWithPeriodId<T> eventWithPeriodId, Class<T> cls) {
        for (ListenerInfo next : this.listenerInfos.elementSet()) {
            if (next.listenerClass.equals(cls)) {
                postOrRun(next.handler, new Runnable(eventWithPeriodId, next) {
                    /* class com.google.android.exoplayer2.util.$$Lambda$MediaSourceEventDispatcher$oVe2CNLjZgg9BPzLR8rnk1kGcmk */
                    private final /* synthetic */ MediaSourceEventDispatcher.EventWithPeriodId f$1;
                    private final /* synthetic */ MediaSourceEventDispatcher.ListenerInfo f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        MediaSourceEventDispatcher.this.lambda$dispatch$0$MediaSourceEventDispatcher(this.f$1, this.f$2);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$dispatch$0$MediaSourceEventDispatcher(EventWithPeriodId eventWithPeriodId, ListenerInfo listenerInfo) {
        eventWithPeriodId.sendTo(listenerInfo.listener, this.windowIndex, this.mediaPeriodId);
    }

    private static void postOrRun(Handler handler, Runnable runnable) {
        if (handler.getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }

    public static long adjustMediaTime(long j, long j2) {
        long usToMs = C.usToMs(j);
        if (usToMs == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j2 + usToMs;
    }

    public static final class ListenerInfo {
        public final Handler handler;
        public final Object listener;
        public final Class<?> listenerClass;

        public ListenerInfo(Handler handler2, Object obj, Class<?> cls) {
            this.handler = handler2;
            this.listener = obj;
            this.listenerClass = cls;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListenerInfo)) {
                return false;
            }
            ListenerInfo listenerInfo = (ListenerInfo) obj;
            return this.listener.equals(listenerInfo.listener) && this.listenerClass.equals(listenerInfo.listenerClass);
        }

        public final int hashCode() {
            return (this.listener.hashCode() * 31) + (this.listenerClass.hashCode() * 31);
        }
    }
}
