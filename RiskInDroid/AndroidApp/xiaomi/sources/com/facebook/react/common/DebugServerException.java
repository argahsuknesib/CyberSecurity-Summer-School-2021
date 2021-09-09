package com.facebook.react.common;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.common.logging.FLog;
import org.json.JSONException;
import org.json.JSONObject;

public class DebugServerException extends RuntimeException {
    public static DebugServerException makeGeneric(String str, String str2, Throwable th) {
        return makeGeneric(str, str2, "", th);
    }

    public static DebugServerException makeGeneric(String str, String str2, String str3, Throwable th) {
        String replace = "\n\nTry the following to fix the issue:\n• Ensure that the packager server is running\n• Ensure that your device/emulator is connected to your machine and has USB debugging enabled - run 'adb devices' to see a list of connected devices\n• Ensure Airplane Mode is disabled\n• If you're on a physical device connected to the same machine, run 'adb reverse tcp:<PORT> tcp:<PORT>' to forward requests from your device\n• If your device is on the same Wi-Fi network, set 'Debug server host & port for device' in 'Dev settings' to your machine's IP address and the port of the local dev server - e.g. 10.0.1.1:<PORT>\n\n".replace("<PORT>", String.valueOf(Uri.parse(str).getPort()));
        return new DebugServerException(str2 + replace + str3, th);
    }

    private DebugServerException(String str, String str2, int i, int i2) {
        super(str + "\n  at " + str2 + ":" + i + ":" + i2);
    }

    public DebugServerException(String str) {
        super(str);
    }

    public DebugServerException(String str, Throwable th) {
        super(str, th);
    }

    public static DebugServerException parse(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            return new DebugServerException(jSONObject.getString("message"), shortenFileName(jSONObject.getString("filename")), jSONObject.getInt("lineNumber"), jSONObject.getInt("column"));
        } catch (JSONException e) {
            FLog.w("ReactNative", "Could not parse DebugServerException from: ".concat(String.valueOf(str2)), e);
            return null;
        }
    }

    private static String shortenFileName(String str) {
        String[] split = str.split("/");
        return split[split.length - 1];
    }
}
