package com.google.android.play.core.splitcompat;

import android.util.Log;
import java.util.Set;

final class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Set f3788a;
    final /* synthetic */ SplitCompat b;

    p(SplitCompat splitCompat, Set set) {
        this.b = splitCompat;
        this.f3788a = set;
    }

    public final void run() {
        try {
            for (String f : this.f3788a) {
                this.b.b.f(f);
            }
        } catch (Exception e) {
            Log.e("SplitCompat", "Failed to remove from splitcompat storage split that is already installed", e);
        }
    }
}
