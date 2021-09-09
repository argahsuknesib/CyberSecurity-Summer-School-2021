package com.google.android.play.core.splitinstall.testing;

import android.content.Intent;
import java.util.List;

final class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f3836a;
    final /* synthetic */ List b;
    final /* synthetic */ List c;
    final /* synthetic */ List d;
    final /* synthetic */ FakeSplitInstallManager e;

    g(FakeSplitInstallManager fakeSplitInstallManager, long j, List list, List list2, List list3) {
        this.e = fakeSplitInstallManager;
        this.f3836a = j;
        this.b = list;
        this.c = list2;
        this.d = list3;
    }

    public final void run() {
        long j = this.f3836a / 3;
        long j2 = 0;
        int i = 0;
        while (((long) i) < 3) {
            j2 = Math.min(this.f3836a, j2 + j);
            this.e.a(2, 0, Long.valueOf(j2), null, null, null, null);
            i++;
            a.a();
        }
        if (this.e.m.get()) {
            this.e.a(6, -6, null, null, null, null, null);
        } else {
            this.e.a((List<Intent>) this.b, (List<String>) this.c, (List<String>) this.d, this.f3836a, false);
        }
    }
}
