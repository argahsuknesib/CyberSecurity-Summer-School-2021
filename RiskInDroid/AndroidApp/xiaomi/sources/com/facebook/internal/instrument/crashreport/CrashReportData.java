package com.facebook.internal.instrument.crashreport;

import android.os.Build;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentUtility;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public final class CrashReportData {
    private String appVersion;
    private String cause;
    private String filename;
    private String stackTrace;
    private Long timestamp;

    public CrashReportData(Throwable th) {
        this.appVersion = Utility.getAppVersion();
        this.cause = InstrumentUtility.getCause(th);
        this.stackTrace = InstrumentUtility.getStackTrace(th);
        this.timestamp = Long.valueOf(System.currentTimeMillis() / 1000);
        StringBuffer stringBuffer = new StringBuffer("crash_log_");
        stringBuffer.append(this.timestamp.toString());
        stringBuffer.append(".json");
        this.filename = stringBuffer.toString();
    }

    public CrashReportData(File file) {
        this.filename = file.getName();
        JSONObject readFile = InstrumentUtility.readFile(this.filename, true);
        if (readFile != null) {
            this.appVersion = readFile.optString("app_version", null);
            this.cause = readFile.optString("reason", null);
            this.stackTrace = readFile.optString("callstack", null);
            this.timestamp = Long.valueOf(readFile.optLong("timestamp", 0));
        }
    }

    public final int compareTo(CrashReportData crashReportData) {
        Long l = this.timestamp;
        if (l == null) {
            return -1;
        }
        Long l2 = crashReportData.timestamp;
        if (l2 == null) {
            return 1;
        }
        return l2.compareTo(l);
    }

    public final boolean isValid() {
        return (this.stackTrace == null || this.timestamp == null) ? false : true;
    }

    public final void save() {
        if (isValid()) {
            InstrumentUtility.writeFile(this.filename, toString());
        }
    }

    public final void clear() {
        InstrumentUtility.deleteFile(this.filename);
    }

    public final String toString() {
        JSONObject parameters = getParameters();
        if (parameters == null) {
            return null;
        }
        return parameters.toString();
    }

    public final JSONObject getParameters() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_os_version", Build.VERSION.RELEASE);
            jSONObject.put("device_model", Build.MODEL);
            if (this.appVersion != null) {
                jSONObject.put("app_version", this.appVersion);
            }
            if (this.timestamp != null) {
                jSONObject.put("timestamp", this.timestamp);
            }
            if (this.cause != null) {
                jSONObject.put("reason", this.cause);
            }
            if (this.stackTrace != null) {
                jSONObject.put("callstack", this.stackTrace);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
