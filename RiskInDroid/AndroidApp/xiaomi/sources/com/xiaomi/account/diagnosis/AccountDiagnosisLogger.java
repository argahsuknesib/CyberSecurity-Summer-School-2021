package com.xiaomi.account.diagnosis;

import android.content.Context;
import com.xiaomi.account.diagnosis.util.DiagnosisPreference;
import com.xiaomi.accountsdk.utils.DiagnosisLogInterface;
import java.util.List;
import java.util.Map;

public class AccountDiagnosisLogger implements DiagnosisLogInterface {
    private static DiagnosisLogInterface sEmptyDiagnosisLogger = new EmptyDiagnosisLogger();
    private static DiagnosisLogInterface sRealDiagnosisLogger = new RealDiagnosisLogger();
    private Context mContext;

    public AccountDiagnosisLogger(Context context) {
        this.mContext = context;
    }

    private DiagnosisLogInterface getInstance() {
        return isDiagnosisEnabled(this.mContext) ? sRealDiagnosisLogger : sEmptyDiagnosisLogger;
    }

    private static boolean isDiagnosisEnabled(Context context) {
        return DiagnosisPreference.isDiagnosisEnabled(context);
    }

    public void logResponseCode(String str, int i) {
        getInstance().logResponseCode(str, i);
    }

    public void logResponseDecryptedBody(String str) {
        getInstance().logResponseDecryptedBody(str);
    }

    public void logResponse(String str, String str2, Map<String, List<String>> map, Map<String, String> map2) {
        getInstance().logResponse(str, str2, map, map2);
    }

    public void logRequestException(Exception exc) {
        getInstance().logRequestException(exc);
    }

    public String logGetRequest(String str, Map<String, String> map, String str2, Map<String, String> map2, Map<String, String> map3) {
        return getInstance().logGetRequest(str, map, str2, map2, map3);
    }

    public String logPostRequest(String str, Map<String, String> map, String str2, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4) {
        return getInstance().logPostRequest(str, map, str2, map2, map3, map4);
    }
}
