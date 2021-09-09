package com.google.android.play.core.assetpacks;

final /* synthetic */ class cy implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final db f3692a;
    private final int b;
    private final String c;

    cy(db dbVar, int i, String str) {
        this.f3692a = dbVar;
        this.b = i;
        this.c = str;
    }

    public final void run() {
        this.f3692a.b(this.b, this.c);
    }
}
