package com.google.android.play.core.internal;

import android.os.IBinder;

final /* synthetic */ class ac implements IBinder.DeathRecipient {

    /* renamed from: a  reason: collision with root package name */
    private final ak f3744a;

    ac(ak akVar) {
        this.f3744a = akVar;
    }

    public final void binderDied() {
        this.f3744a.c();
    }
}
