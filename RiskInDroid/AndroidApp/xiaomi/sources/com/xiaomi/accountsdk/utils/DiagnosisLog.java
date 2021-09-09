package com.xiaomi.accountsdk.utils;

import java.util.List;
import java.util.Map;

public class DiagnosisLog {
    private static DiagnosisLogInterface sLogger = new DiagnosisLogInterface() {
        /* class com.xiaomi.accountsdk.utils.DiagnosisLog.AnonymousClass1 */

        public final String logGetRequest(String str, Map<String, String> map, String str2, Map<String, String> map2, Map<String, String> map3) {
            return null;
        }

        public final String logPostRequest(String str, Map<String, String> map, String str2, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4) {
            return null;
        }

        public final void logRequestException(Exception exc) {
        }

        public final void logResponse(String str, String str2, Map<String, List<String>> map, Map<String, String> map2) {
        }

        public final void logResponseCode(String str, int i) {
        }

        public final void logResponseDecryptedBody(String str) {
        }
    };

    private DiagnosisLog() {
    }

    public static void set(DiagnosisLogInterface diagnosisLogInterface) {
        sLogger = diagnosisLogInterface;
    }

    public static DiagnosisLogInterface get() {
        return sLogger;
    }
}
