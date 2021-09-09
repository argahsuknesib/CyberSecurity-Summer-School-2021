package com.google.android.exoplayer2.util;

import android.os.Handler;
import com.google.android.exoplayer2.util.EventDispatcher;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class EventDispatcher<T> {
    private final CopyOnWriteArrayList<HandlerAndListener<T>> listeners = new CopyOnWriteArrayList<>();

    public interface Event<T> {
        void sendTo(T t);
    }

    public final void addListener(Handler handler, T t) {
        Assertions.checkArgument((handler == null || t == null) ? false : true);
        removeListener(t);
        this.listeners.add(new HandlerAndListener(handler, t));
    }

    public final void removeListener(T t) {
        Iterator<HandlerAndListener<T>> it = this.listeners.iterator();
        while (it.hasNext()) {
            HandlerAndListener next = it.next();
            if (next.listener == t) {
                next.release();
                this.listeners.remove(next);
            }
        }
    }

    public final void dispatch(Event<T> event) {
        Iterator<HandlerAndListener<T>> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().dispatch(event);
        }
    }

    static final class HandlerAndListener<T> {
        private final Handler handler;
        public final T listener;
        private boolean released;

        public HandlerAndListener(Handler handler2, T t) {
            this.handler = handler2;
            this.listener = t;
        }

        public final void release() {
            this.released = true;
        }

        public final void dispatch(Event<T> event) {
            this.handler.post(new Runnable(event) {
                /* class com.google.android.exoplayer2.util.$$Lambda$EventDispatcher$HandlerAndListener$uD_JKgYUi0f_RBL7K02WSc4AoE4 */
                private final /* synthetic */ EventDispatcher.Event f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    EventDispatcher.HandlerAndListener.this.lambda$dispatch$0$EventDispatcher$HandlerAndListener(this.f$1);
                }
            });
        }

        public /* synthetic */ void lambda$dispatch$0$EventDispatcher$HandlerAndListener(Event event) {
            if (!this.released) {
                event.sendTo(this.listener);
            }
        }
    }
}
