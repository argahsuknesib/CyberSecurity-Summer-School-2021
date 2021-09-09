package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.i;
import java.util.List;

final /* synthetic */ class cx implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final db f3691a;
    private final List b;
    private final ba c;
    private final i d;

    cx(db dbVar, List list, ba baVar, i iVar) {
        this.f3691a = dbVar;
        this.b = list;
        this.c = baVar;
        this.d = iVar;
    }

    public final void run() {
        this.f3691a.a(this.b, this.c, this.d);
    }
}
