package com.facebook.react.packagerconnection;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;

public class PackagerConnectionSettings {
    private static final String TAG = "PackagerConnectionSettings";
    private final Context mAppContext;
    private final String mPackageName;
    private final SharedPreferences mPreferences;

    public PackagerConnectionSettings(Context context) {
        this.mPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.mPackageName = context.getPackageName();
        this.mAppContext = context;
    }

    public String getDebugServerHost() {
        String string = this.mPreferences.getString("debug_http_host", null);
        if (!TextUtils.isEmpty(string)) {
            return (String) Assertions.assertNotNull(string);
        }
        String serverHost = AndroidInfoHelpers.getServerHost(this.mAppContext);
        if (serverHost.equals("localhost")) {
            String str = TAG;
            FLog.w(str, "You seem to be running on device. Run '" + AndroidInfoHelpers.getAdbReverseTcpCommand(this.mAppContext) + "' to forward the debug server's port to the device.");
        }
        return serverHost;
    }

    public void setDebugServerHost(String str) {
        this.mPreferences.edit().putString("debug_http_host", str).apply();
    }

    public String getInspectorServerHost() {
        return AndroidInfoHelpers.getInspectorProxyHost(this.mAppContext);
    }

    public String getPackageName() {
        return this.mPackageName;
    }
}
