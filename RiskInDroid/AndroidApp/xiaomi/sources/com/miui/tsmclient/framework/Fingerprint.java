package com.miui.tsmclient.framework;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;

public class Fingerprint {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: android.hardware.fingerprint.FingerprintManager} */
    /* JADX WARNING: Multi-variable type inference failed */
    public static void resetTimeout(Context context, FingerprintManager fingerprintManager) {
        if (fingerprintManager == null) {
            fingerprintManager = context.getSystemService("fingerprint");
        }
        fingerprintManager.resetTimeout(null);
    }
}
