package com.mobikwik.sdk;

import android.content.Intent;

class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f5287a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ PGWebView d;

    i(PGWebView pGWebView, Intent intent, String str, String str2) {
        this.d = pGWebView;
        this.f5287a = intent;
        this.b = str;
        this.c = str2;
    }

    public void run() {
        Intent intent = new Intent();
        Intent intent2 = this.f5287a;
        if (intent2 != null) {
            intent = new Intent(intent2);
        } else {
            intent.putExtra("statuscode", this.b);
            intent.putExtra("statusmessage", this.c);
        }
        this.d.setResult(1, intent);
        this.d.finish();
    }
}
