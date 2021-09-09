package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

class FacebookSDKJSInterface {
    public static final String TAG = "FacebookSDKJSInterface";
    private Context context;

    @JavascriptInterface
    public String getProtocol() {
        return "fbmq-0.1";
    }

    public FacebookSDKJSInterface(Context context2) {
        this.context = context2;
    }

    private static Bundle jsonToBundle(JSONObject jSONObject) throws JSONException {
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            bundle.putString(next, jSONObject.getString(next));
        }
        return bundle;
    }

    private static Bundle jsonStringToBundle(String str) {
        try {
            return jsonToBundle(new JSONObject(str));
        } catch (JSONException unused) {
            return new Bundle();
        }
    }

    @JavascriptInterface
    public void sendEvent(String str, String str2, String str3) {
        if (str == null) {
            Logger.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "Can't bridge an event without a referral Pixel ID. Check your webview Pixel configuration");
            return;
        }
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(this.context);
        Bundle jsonStringToBundle = jsonStringToBundle(str3);
        jsonStringToBundle.putString("_fb_pixel_referral_id", str);
        internalAppEventsLogger.logEvent(str2, jsonStringToBundle);
    }
}
