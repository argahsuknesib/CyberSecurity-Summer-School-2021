package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.cf;
import com.google.android.play.core.internal.cg;
import com.google.android.play.core.internal.ci;
import com.google.android.play.core.splitinstall.z;
import java.util.concurrent.Executor;

public final class bu implements a {

    /* renamed from: a  reason: collision with root package name */
    private final n f3664a;
    private ci<Context> b;
    private ci<dl> c = cg.a(new dm(this.b));
    private ci<bc> d = cg.a(new bd(this.b, this.c));
    private ci<cb> e = cg.a(cc.f3673a);
    private ci<as> f = cg.a(new at(this.b, this.e));
    private ci<String> g = cg.a(new t(this.b));
    private ci<x> h = new cf();
    private ci<Executor> i = cg.a(o.f3728a);
    private ci<cr> j = cg.a(new cs(this.d, this.h, this.e, this.i));
    private ci<ax> k = new cf();
    private ci<bw> l = cg.a(new bx(this.d, this.h, this.k, this.e));
    private ci<dv> m = cg.a(new dw(this.d));
    private ci<df> n = cg.a(new dg(this.d));
    private ci<dj> o = cg.a(new dk(this.d, this.h, this.j, this.i, this.e));
    private ci<Cdo> p = cg.a(new dp(this.d, this.h));
    private ci<bn> q = cg.a(new bo(this.h));
    private ci<cu> r = cg.a(new cv(this.j, this.d, this.q));
    private ci<bz> s = cg.a(new ca(this.j, this.h, this.l, this.m, this.n, this.o, this.p, this.r));
    private ci<bq> t = cg.a(br.f3662a);
    private ci<Executor> u = cg.a(v.f3734a);
    private ci<db> v;
    private ci<z> w;
    private ci<j> x;
    private ci<AssetPackManager> y;

    /* synthetic */ bu(n nVar) {
        this.f3664a = nVar;
        this.b = new s(nVar);
        cf.a(this.k, cg.a(new ay(this.b, this.j, this.s, this.h, this.e, this.t, this.i, this.u)));
        this.v = cg.a(new dc(this.g, this.k, this.e, this.b, this.c, this.i));
        cf.a(this.h, cg.a(new r(this.b, this.f, this.v)));
        this.w = cg.a(new u(this.b));
        this.x = cg.a(new k(this.d, this.h, this.k, this.w, this.j, this.e, this.t, this.i));
        this.y = cg.a(new q(this.x, this.b));
    }

    public final AssetPackManager a() {
        return this.y.a();
    }

    public final void a(AssetPackExtractionService assetPackExtractionService) {
        assetPackExtractionService.f3624a = s.a(this.f3664a);
        assetPackExtractionService.b = this.x.a();
        assetPackExtractionService.c = this.d.a();
    }
}
