package com.google.android.play.core.splitinstall;

final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final u f3817a;
    private final com.google.android.play.core.tasks.i b;

    i(u uVar, com.google.android.play.core.tasks.i iVar) {
        this.f3817a = uVar;
        this.b = iVar;
    }

    public final void run() {
        u uVar = this.f3817a;
        com.google.android.play.core.tasks.i iVar = this.b;
        try {
            iVar.a(uVar.a());
        } catch (Exception e) {
            iVar.a(e);
        }
    }
}
