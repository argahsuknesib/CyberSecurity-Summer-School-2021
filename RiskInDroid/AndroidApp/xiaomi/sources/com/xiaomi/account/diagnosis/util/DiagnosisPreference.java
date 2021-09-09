package com.xiaomi.account.diagnosis.util;

import android.content.Context;
import android.content.SharedPreferences;

public class DiagnosisPreference {
    private DiagnosisPreference() {
    }

    private static SharedPreferences getDiagnosisPreference(Context context) {
        return context.getSharedPreferences("passport_diagnosis", 4);
    }

    public static boolean isDiagnosisEnabled(Context context) {
        return getDiagnosisPreference(context).getBoolean("diagnosis_enabled", false);
    }

    public static boolean setDiagnosisEnabled(Context context, boolean z) {
        return getDiagnosisPreference(context).edit().putBoolean("diagnosis_enabled", z).commit();
    }
}
