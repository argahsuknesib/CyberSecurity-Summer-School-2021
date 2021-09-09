package com.alipay.sdk.widget;

import java.util.Iterator;
import java.util.Stack;

class f {

    /* renamed from: a  reason: collision with root package name */
    private Stack<e> f3231a = new Stack<>();

    f() {
    }

    /* access modifiers changed from: package-private */
    public e a() {
        return this.f3231a.pop();
    }

    /* access modifiers changed from: package-private */
    public void a(e eVar) {
        this.f3231a.push(eVar);
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f3231a.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (!b()) {
            Iterator<e> it = this.f3231a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.f3231a.clear();
        }
    }
}
