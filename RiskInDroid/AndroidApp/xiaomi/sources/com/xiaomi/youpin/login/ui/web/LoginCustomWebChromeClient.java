package com.xiaomi.youpin.login.ui.web;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import java.lang.ref.WeakReference;

public class LoginCustomWebChromeClient extends WebChromeClient {

    /* renamed from: O000000o  reason: collision with root package name */
    ValueCallback<Uri> f12103O000000o;
    ValueCallback<Uri[]> O00000Oo;
    private WeakReference<Activity> O00000o0;

    public LoginCustomWebChromeClient(Activity activity) {
        this.O00000o0 = new WeakReference<>(activity);
    }

    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        callback.invoke(str, true, false);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        Activity activity = this.O00000o0.get();
        if (activity == null) {
            valueCallback.onReceiveValue(null);
            return;
        }
        this.f12103O000000o = valueCallback;
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        activity.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1001);
    }

    public void openFileChooser(ValueCallback valueCallback, String str) {
        Activity activity = this.O00000o0.get();
        if (activity == null) {
            valueCallback.onReceiveValue(null);
            return;
        }
        this.f12103O000000o = valueCallback;
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        activity.startActivityForResult(Intent.createChooser(intent, "File Browser"), 1001);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        Activity activity = this.O00000o0.get();
        if (activity == null) {
            valueCallback.onReceiveValue(null);
            return;
        }
        this.f12103O000000o = valueCallback;
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        activity.startActivityForResult(Intent.createChooser(intent, "File Browser"), 1001);
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        Activity activity = this.O00000o0.get();
        if (activity == null) {
            valueCallback.onReceiveValue(null);
            return false;
        }
        this.O00000Oo = valueCallback;
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        activity.startActivityForResult(Intent.createChooser(intent, "File Browser"), 1001);
        return true;
    }
}
