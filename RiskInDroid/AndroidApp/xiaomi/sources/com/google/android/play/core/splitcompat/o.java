package com.google.android.play.core.splitcompat;

import android.util.Log;

final class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SplitCompat f3787a;

    o(SplitCompat splitCompat) {
        this.f3787a = splitCompat;
    }

    public final void run() {
        try {
            this.f3787a.b.a();
        } catch (Exception e) {
            Log.e("SplitCompat", "Failed to cleanup splitcompat storage", e);
        }
    }
}
