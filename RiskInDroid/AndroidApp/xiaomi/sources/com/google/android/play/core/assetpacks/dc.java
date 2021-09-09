package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.cg;
import com.google.android.play.core.internal.ci;
import java.io.File;
import java.util.concurrent.Executor;

public final class dc implements ci<db> {

    /* renamed from: a  reason: collision with root package name */
    private final ci<String> f3697a;
    private final ci<ax> b;
    private final ci<cb> c;
    private final ci<Context> d;
    private final ci<dl> e;
    private final ci<Executor> f;

    public dc(ci<String> ciVar, ci<ax> ciVar2, ci<cb> ciVar3, ci<Context> ciVar4, ci<dl> ciVar5, ci<Executor> ciVar6) {
        this.f3697a = ciVar;
        this.b = ciVar2;
        this.c = ciVar3;
        this.d = ciVar4;
        this.e = ciVar5;
        this.f = ciVar6;
    }

    public final /* synthetic */ Object a() {
        String a2 = this.f3697a.a();
        ax a3 = this.b.a();
        cb a4 = this.c.a();
        Context b2 = ((s) this.d).a();
        dl a5 = this.e.a();
        return new db(a2 != null ? new File(b2.getExternalFilesDir(null), a2) : b2.getExternalFilesDir(null), a3, a4, b2, a5, cg.b(this.f));
    }
}
