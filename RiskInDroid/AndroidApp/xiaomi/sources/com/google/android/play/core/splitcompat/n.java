package com.google.android.play.core.splitcompat;

import android.content.Context;
import com.google.android.play.core.splitinstall.ac;

final class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f3786a;

    n(Context context) {
        this.f3786a = context;
    }

    public final void run() {
        ac.a(this.f3786a).a(true);
    }
}
