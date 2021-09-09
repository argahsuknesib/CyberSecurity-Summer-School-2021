package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.i;
import java.util.List;

final /* synthetic */ class cw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final db f3690a;
    private final List b;
    private final i c;
    private final List d;

    cw(db dbVar, List list, i iVar, List list2) {
        this.f3690a = dbVar;
        this.b = list;
        this.c = iVar;
        this.d = list2;
    }

    public final void run() {
        this.f3690a.a(this.b, this.c, this.d);
    }
}
