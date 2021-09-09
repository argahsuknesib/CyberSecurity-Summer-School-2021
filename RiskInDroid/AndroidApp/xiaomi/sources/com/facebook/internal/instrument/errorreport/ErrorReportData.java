package com.facebook.internal.instrument.errorreport;

import com.facebook.internal.instrument.InstrumentUtility;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public final class ErrorReportData {
    private String errorMessage;
    private String filename;
    private Long timestamp;

    public ErrorReportData(String str) {
        this.timestamp = Long.valueOf(System.currentTimeMillis() / 1000);
        this.errorMessage = str;
        StringBuffer stringBuffer = new StringBuffer("error_log_");
        stringBuffer.append(this.timestamp);
        stringBuffer.append(".json");
        this.filename = stringBuffer.toString();
    }

    public ErrorReportData(File file) {
        this.filename = file.getName();
        JSONObject readFile = InstrumentUtility.readFile(this.filename, true);
        if (readFile != null) {
            this.timestamp = Long.valueOf(readFile.optLong("timestamp", 0));
            this.errorMessage = readFile.optString("error_message", null);
        }
    }

    public final int compareTo(ErrorReportData errorReportData) {
        Long l = this.timestamp;
        if (l == null) {
            return -1;
        }
        Long l2 = errorReportData.timestamp;
        if (l2 == null) {
            return 1;
        }
        return l2.compareTo(l);
    }

    public final boolean isValid() {
        return (this.errorMessage == null || this.timestamp == null) ? false : true;
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
            if (this.timestamp != null) {
                jSONObject.put("timestamp", this.timestamp);
            }
            jSONObject.put("error_message", this.errorMessage);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
