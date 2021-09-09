package com.google.android.play.core.internal;

import com.google.android.play.core.listener.StateUpdatedListener;
import java.util.HashSet;
import java.util.Set;

public final class z<StateT> {

    /* renamed from: a  reason: collision with root package name */
    protected final Set<StateUpdatedListener<StateT>> f3769a = new HashSet();

    public final synchronized void a(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.f3769a.add(stateUpdatedListener);
    }

    public final synchronized void a(StateT statet) {
        for (StateUpdatedListener<StateT> onStateUpdate : this.f3769a) {
            onStateUpdate.onStateUpdate(statet);
        }
    }

    public final synchronized void b(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.f3769a.remove(stateUpdatedListener);
    }
}
