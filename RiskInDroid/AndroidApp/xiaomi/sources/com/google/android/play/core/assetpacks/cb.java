package com.google.android.play.core.assetpacks;

import java.util.HashMap;
import java.util.Map;

final class cb {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Double> f3672a = new HashMap();

    cb() {
    }

    /* access modifiers changed from: package-private */
    public final synchronized double a(String str, ct ctVar) {
        double d;
        d = 1.0d;
        if (ctVar instanceof bv) {
            double d2 = (double) ((bv) ctVar).e;
            Double.isNaN(d2);
            double d3 = d2 + 1.0d;
            double d4 = (double) ((bv) ctVar).f;
            Double.isNaN(d4);
            d = d3 / d4;
        }
        this.f3672a.put(str, Double.valueOf(d));
        return d;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(String str) {
        this.f3672a.put(str, Double.valueOf(0.0d));
    }

    /* access modifiers changed from: package-private */
    public final synchronized double b(String str) {
        Double d = this.f3672a.get(str);
        if (d == null) {
            return 0.0d;
        }
        return d.doubleValue();
    }
}
