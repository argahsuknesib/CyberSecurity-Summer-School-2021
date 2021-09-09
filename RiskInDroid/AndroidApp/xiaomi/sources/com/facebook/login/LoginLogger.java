package com.facebook.login;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.login.LoginClient;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class LoginLogger {
    private String applicationId;
    private String facebookVersion;
    private final InternalAppEventsLogger logger;

    LoginLogger(Context context, String str) {
        PackageInfo packageInfo;
        this.applicationId = str;
        this.logger = new InternalAppEventsLogger(context, str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo("com.facebook.katana", 0)) != null) {
                this.facebookVersion = packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    static Bundle newAuthorizationLoggingBundle(String str) {
        Bundle bundle = new Bundle();
        bundle.putLong("1_timestamp_ms", System.currentTimeMillis());
        bundle.putString("0_auth_logger_id", str);
        bundle.putString("3_method", "");
        bundle.putString("2_result", "");
        bundle.putString("5_error_message", "");
        bundle.putString("4_error_code", "");
        bundle.putString("6_extras", "");
        return bundle;
    }

    public void logStartLogin(LoginClient.Request request) {
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(request.getAuthId());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("login_behavior", request.getLoginBehavior().toString());
            jSONObject.put("request_code", LoginClient.getLoginRequestCode());
            jSONObject.put("permissions", TextUtils.join(",", request.getPermissions()));
            jSONObject.put("default_audience", request.getDefaultAudience().toString());
            jSONObject.put("isReauthorize", request.isRerequest());
            if (this.facebookVersion != null) {
                jSONObject.put("facebookVersion", this.facebookVersion);
            }
            newAuthorizationLoggingBundle.putString("6_extras", jSONObject.toString());
        } catch (JSONException unused) {
        }
        this.logger.logEventImplicitly("fb_mobile_login_start", null, newAuthorizationLoggingBundle);
    }

    public void logCompleteLogin(String str, Map<String, String> map, LoginClient.Result.Code code, Map<String, String> map2, Exception exc) {
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
        if (code != null) {
            newAuthorizationLoggingBundle.putString("2_result", code.getLoggingValue());
        }
        if (!(exc == null || exc.getMessage() == null)) {
            newAuthorizationLoggingBundle.putString("5_error_message", exc.getMessage());
        }
        JSONObject jSONObject = null;
        if (!map.isEmpty()) {
            jSONObject = new JSONObject((Map<?, ?>) map);
        }
        if (map2 != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                for (Map.Entry next : map2.entrySet()) {
                    jSONObject.put((String) next.getKey(), next.getValue());
                }
            } catch (JSONException unused) {
            }
        }
        if (jSONObject != null) {
            newAuthorizationLoggingBundle.putString("6_extras", jSONObject.toString());
        }
        this.logger.logEventImplicitly("fb_mobile_login_complete", newAuthorizationLoggingBundle);
    }

    public void logAuthorizationMethodStart(String str, String str2) {
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
        newAuthorizationLoggingBundle.putString("3_method", str2);
        this.logger.logEventImplicitly("fb_mobile_login_method_start", newAuthorizationLoggingBundle);
    }

    public void logAuthorizationMethodComplete(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
        if (str3 != null) {
            newAuthorizationLoggingBundle.putString("2_result", str3);
        }
        if (str4 != null) {
            newAuthorizationLoggingBundle.putString("5_error_message", str4);
        }
        if (str5 != null) {
            newAuthorizationLoggingBundle.putString("4_error_code", str5);
        }
        if (map != null && !map.isEmpty()) {
            newAuthorizationLoggingBundle.putString("6_extras", new JSONObject((Map<?, ?>) map).toString());
        }
        newAuthorizationLoggingBundle.putString("3_method", str2);
        this.logger.logEventImplicitly("fb_mobile_login_method_complete", newAuthorizationLoggingBundle);
    }

    public void logAuthorizationMethodNotTried(String str, String str2) {
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
        newAuthorizationLoggingBundle.putString("3_method", str2);
        this.logger.logEventImplicitly("fb_mobile_login_method_not_tried", newAuthorizationLoggingBundle);
    }

    public void logLoginStatusStart(String str) {
        this.logger.logEventImplicitly("fb_mobile_login_status_start", newAuthorizationLoggingBundle(str));
    }

    public void logLoginStatusSuccess(String str) {
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
        newAuthorizationLoggingBundle.putString("2_result", LoginClient.Result.Code.SUCCESS.getLoggingValue());
        this.logger.logEventImplicitly("fb_mobile_login_status_complete", newAuthorizationLoggingBundle);
    }

    public void logLoginStatusFailure(String str) {
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
        newAuthorizationLoggingBundle.putString("2_result", "failure");
        this.logger.logEventImplicitly("fb_mobile_login_status_complete", newAuthorizationLoggingBundle);
    }

    public void logLoginStatusError(String str, Exception exc) {
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
        newAuthorizationLoggingBundle.putString("2_result", LoginClient.Result.Code.ERROR.getLoggingValue());
        newAuthorizationLoggingBundle.putString("5_error_message", exc.toString());
        this.logger.logEventImplicitly("fb_mobile_login_status_complete", newAuthorizationLoggingBundle);
    }

    public void logUnexpectedError(String str, String str2) {
        logUnexpectedError(str, str2, "");
    }

    public void logUnexpectedError(String str, String str2, String str3) {
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle("");
        newAuthorizationLoggingBundle.putString("2_result", LoginClient.Result.Code.ERROR.getLoggingValue());
        newAuthorizationLoggingBundle.putString("5_error_message", str2);
        newAuthorizationLoggingBundle.putString("3_method", str3);
        this.logger.logEventImplicitly(str, newAuthorizationLoggingBundle);
    }
}
