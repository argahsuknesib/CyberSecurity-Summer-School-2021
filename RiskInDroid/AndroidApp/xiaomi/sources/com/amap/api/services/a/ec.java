package com.amap.api.services.a;

public abstract class ec {

    /* renamed from: a  reason: collision with root package name */
    ec f3415a;

    /* access modifiers changed from: protected */
    public abstract boolean a();

    public ec() {
    }

    public ec(ec ecVar) {
        this.f3415a = ecVar;
    }

    public boolean c() {
        if (!d()) {
            return false;
        }
        return a();
    }

    private boolean d() {
        ec ecVar = this.f3415a;
        if (ecVar != null) {
            return ecVar.c();
        }
        return true;
    }

    public void a(boolean z) {
        ec ecVar = this.f3415a;
        if (ecVar != null) {
            ecVar.a(z);
        }
    }

    public int b() {
        ec ecVar = this.f3415a;
        return Math.min(Integer.MAX_VALUE, ecVar != null ? ecVar.b() : Integer.MAX_VALUE);
    }

    public void a(int i) {
        ec ecVar = this.f3415a;
        if (ecVar != null) {
            ecVar.a(i);
        }
    }
}
