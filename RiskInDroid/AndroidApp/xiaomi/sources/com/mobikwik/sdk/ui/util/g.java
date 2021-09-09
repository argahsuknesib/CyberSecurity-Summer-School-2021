package com.mobikwik.sdk.ui.util;

import android.widget.ProgressBar;
import com.mobikwik.sdk.ui.util.d;
import java.util.TimerTask;

class g extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ProgressBar f5344a;
    final /* synthetic */ d.b b;

    g(d.b bVar, ProgressBar progressBar) {
        this.b = bVar;
        this.f5344a = progressBar;
    }

    public void run() {
        this.b.b.runOnUiThread(new h(this));
    }
}
