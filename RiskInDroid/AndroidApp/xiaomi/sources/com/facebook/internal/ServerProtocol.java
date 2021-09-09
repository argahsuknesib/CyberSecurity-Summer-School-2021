package com.facebook.internal;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import java.util.Collection;
import org.json.JSONException;
import org.json.JSONObject;

public final class ServerProtocol {
    private static final String TAG = "com.facebook.internal.ServerProtocol";
    public static final Collection<String> errorsProxyAuthDisabled = Utility.unmodifiableCollection("service_disabled", "AndroidAuthKillSwitchException");
    public static final Collection<String> errorsUserCanceled = Utility.unmodifiableCollection("access_denied", "OAuthAccessDeniedException");

    public static final String getDefaultAPIVersion() {
        return "v5.0";
    }

    public static final String getDialogAuthority() {
        return String.format("m.%s", FacebookSdk.getFacebookDomain());
    }

    public static final String getGraphUrlBase() {
        return String.format("https://graph.%s", FacebookSdk.getFacebookDomain());
    }

    public static final String getGraphVideoUrlBase() {
        return String.format("https://graph-video.%s", FacebookSdk.getFacebookDomain());
    }

    public static Bundle getQueryParamsForPlatformActivityIntentWebFallback(String str, int i, Bundle bundle) {
        String applicationSignature = FacebookSdk.getApplicationSignature(FacebookSdk.getApplicationContext());
        if (Utility.isNullOrEmpty(applicationSignature)) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("android_key_hash", applicationSignature);
        bundle2.putString("app_id", FacebookSdk.getApplicationId());
        bundle2.putInt("version", i);
        bundle2.putString("display", "touch");
        Bundle bundle3 = new Bundle();
        bundle3.putString("action_id", str);
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            JSONObject convertToJSON = BundleJSONConverter.convertToJSON(bundle3);
            JSONObject convertToJSON2 = BundleJSONConverter.convertToJSON(bundle);
            if (convertToJSON != null) {
                if (convertToJSON2 != null) {
                    bundle2.putString("bridge_args", convertToJSON.toString());
                    bundle2.putString("method_args", convertToJSON2.toString());
                    return bundle2;
                }
            }
            return null;
        } catch (JSONException e) {
            Logger.log(LoggingBehavior.DEVELOPER_ERRORS, 6, TAG, "Error creating Url -- ".concat(String.valueOf(e)));
            return null;
        }
    }
}
