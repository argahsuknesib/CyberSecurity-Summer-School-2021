package com.xiaomi.account.diagnosis;

import com.xiaomi.accountsdk.account.XMPassportSettings;
import java.io.File;

public class DiagnosisConstants {
    private DiagnosisConstants() {
    }

    public static File getPassportCacheDir() {
        return new File(XMPassportSettings.getApplicationContext().getCacheDir(), ".XMPassport");
    }

    public static File getLogcatSubDir() {
        return new File(getPassportCacheDir(), "logcat");
    }

    public static File getZipSubDir() {
        return new File(getPassportCacheDir(), "zip");
    }
}
