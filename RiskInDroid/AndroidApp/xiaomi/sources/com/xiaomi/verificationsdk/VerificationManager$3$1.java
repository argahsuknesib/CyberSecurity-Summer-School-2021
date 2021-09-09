package com.xiaomi.verificationsdk;

import _m_j.iar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class VerificationManager$3$1 extends WebChromeClient {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ iar.AnonymousClass4 f12043O000000o;

    public VerificationManager$3$1(iar.AnonymousClass4 r1) {
        this.f12043O000000o = r1;
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        String extra = webView.getHitTestResult().getExtra();
        iar iar = iar.this;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(extra));
        Activity O00000oO = iar.O00000oO();
        if (O00000oO == null) {
            return false;
        }
        O00000oO.startActivity(intent);
        return false;
    }
}
