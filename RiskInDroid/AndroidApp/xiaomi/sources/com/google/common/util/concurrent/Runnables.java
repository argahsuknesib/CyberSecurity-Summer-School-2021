package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@Beta
public final class Runnables {
    private static final Runnable EMPTY_RUNNABLE = new Runnable() {
        /* class com.google.common.util.concurrent.Runnables.AnonymousClass1 */

        public final void run() {
        }
    };

    public static Runnable doNothing() {
        return EMPTY_RUNNABLE;
    }

    private Runnables() {
    }
}
