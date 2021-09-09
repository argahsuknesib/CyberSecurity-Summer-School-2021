package com.xiaomi.account.openauth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.UUID;

public class HashedDeviceIdUtil {
    private final Context mContext;

    public HashedDeviceIdUtil(Context context) {
        this.mContext = context;
    }

    public String getHashedDeviceIdNoThrow() {
        String loadHistoricalHashedDeviceId = loadHistoricalHashedDeviceId();
        if (legal(loadHistoricalHashedDeviceId)) {
            return loadHistoricalHashedDeviceId;
        }
        String deviceIdHashed = getDeviceIdHashed();
        if (deviceIdHashed != null) {
            saveHistoricalHashedDeviceId(deviceIdHashed);
            return deviceIdHashed;
        }
        String androidId = getAndroidId();
        if (legal(androidId)) {
            saveHistoricalHashedDeviceId(androidId);
            return androidId;
        }
        String createPseudoDeviceId = createPseudoDeviceId();
        saveHistoricalHashedDeviceId(createPseudoDeviceId);
        return createPseudoDeviceId;
    }

    private String createPseudoDeviceId() {
        return String.format("%s%s", "android_pseudo_", UUID.randomUUID().toString());
    }

    private String loadHistoricalHashedDeviceId() {
        SharedPreferences sp = getSP();
        if (sp == null) {
            return null;
        }
        return sp.getString("hashedDeviceId", null);
    }

    private SharedPreferences getSP() {
        Context context = this.mContext;
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("deviceId", 0);
    }

    private void saveHistoricalHashedDeviceId(String str) {
        SharedPreferences sp = getSP();
        if (sp != null) {
            sp.edit().putString("hashedDeviceId", str).commit();
        }
    }

    private String getDeviceIdHashed() {
        try {
            String deviceId = getDeviceId();
            if (legal(deviceId)) {
                return DeviceIdHasher.hashDeviceInfo(deviceId);
            }
            return null;
        } catch (SecurityException unused) {
            return null;
        }
    }

    private String getDeviceId() {
        return ((TelephonyManager) this.mContext.getSystemService("phone")).getDeviceId();
    }

    private String getAndroidId() {
        return String.format("%s%s", "android_id_", Settings.Secure.getString(this.mContext.getContentResolver(), "android_id"));
    }

    private boolean legal(String str) {
        return !TextUtils.isEmpty(str);
    }
}
