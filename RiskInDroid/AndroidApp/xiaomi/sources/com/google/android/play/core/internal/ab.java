package com.google.android.play.core.internal;

import com.google.android.play.core.tasks.i;

public abstract class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final i<?> f3743a;

    ab() {
        this.f3743a = null;
    }

    public ab(i<?> iVar) {
        this.f3743a = iVar;
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: package-private */
    public final i<?> b() {
        return this.f3743a;
    }

    public final void run() {
        try {
            a();
        } catch (Exception e) {
            i<?> iVar = this.f3743a;
            if (iVar != null) {
                iVar.b(e);
            }
        }
    }
}
