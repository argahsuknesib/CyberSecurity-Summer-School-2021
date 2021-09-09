package com.mobikwik.sdk.ui.util;

import android.text.Html;

class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f5345a;

    h(g gVar) {
        this.f5345a = gVar;
    }

    public void run() {
        this.f5345a.f5344a.incrementProgressBy(1);
        this.f5345a.b.d.setMessage(Html.fromHtml(this.f5345a.b.a(this.f5345a.f5344a.getMax() - this.f5345a.f5344a.getProgress())));
        if (this.f5345a.f5344a.getProgress() >= d.f5340a) {
            this.f5345a.b.f();
            this.f5345a.b.b();
            this.f5345a.b.e();
        }
    }
}
