package com.google.android.play.core.assetpacks;

import android.content.Intent;

final /* synthetic */ class da implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final db f3695a;
    private final Intent b;

    da(db dbVar, Intent intent) {
        this.f3695a = dbVar;
        this.b = intent;
    }

    public final void run() {
        this.f3695a.a(this.b);
    }
}
