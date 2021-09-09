package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookWebFallbackDialog extends WebDialog {
    private static final String TAG = "com.facebook.internal.FacebookWebFallbackDialog";
    private boolean waitingForDialogToClose;

    public static FacebookWebFallbackDialog newInstance(Context context, String str, String str2) {
        WebDialog.initDefaultTheme(context);
        return new FacebookWebFallbackDialog(context, str, str2);
    }

    private FacebookWebFallbackDialog(Context context, String str, String str2) {
        super(context, str);
        setExpectedRedirectUrl(str2);
    }

    /* access modifiers changed from: protected */
    public Bundle parseResponseUri(String str) {
        Bundle parseUrlQueryString = Utility.parseUrlQueryString(Uri.parse(str).getQuery());
        String string = parseUrlQueryString.getString("bridge_args");
        parseUrlQueryString.remove("bridge_args");
        if (!Utility.isNullOrEmpty(string)) {
            try {
                parseUrlQueryString.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", BundleJSONConverter.convertToBundle(new JSONObject(string)));
            } catch (JSONException e) {
                Utility.logd(TAG, "Unable to parse bridge_args JSON", e);
            }
        }
        String string2 = parseUrlQueryString.getString("method_results");
        parseUrlQueryString.remove("method_results");
        if (!Utility.isNullOrEmpty(string2)) {
            if (Utility.isNullOrEmpty(string2)) {
                string2 = "{}";
            }
            try {
                parseUrlQueryString.putBundle("com.facebook.platform.protocol.RESULT_ARGS", BundleJSONConverter.convertToBundle(new JSONObject(string2)));
            } catch (JSONException e2) {
                Utility.logd(TAG, "Unable to parse bridge_args JSON", e2);
            }
        }
        parseUrlQueryString.remove("version");
        parseUrlQueryString.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", NativeProtocol.getLatestKnownVersion());
        return parseUrlQueryString;
    }

    public void cancel() {
        WebView webView = getWebView();
        if (!isPageFinished() || isListenerCalled() || webView == null || !webView.isShown()) {
            super.cancel();
        } else if (!this.waitingForDialogToClose) {
            this.waitingForDialogToClose = true;
            webView.loadUrl("javascript:".concat("(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();"));
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                /* class com.facebook.internal.FacebookWebFallbackDialog.AnonymousClass1 */

                public void run() {
                    FacebookWebFallbackDialog.super.cancel();
                }
            }, 1500);
        }
    }
}
