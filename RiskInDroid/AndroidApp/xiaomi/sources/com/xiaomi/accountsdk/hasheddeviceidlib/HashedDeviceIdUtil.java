package com.xiaomi.accountsdk.hasheddeviceidlib;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import com.xiaomi.accountsdk.account.exception.IllegalDeviceException;
import com.xiaomi.accountsdk.hasheddeviceidlib.PlainDeviceIdUtil;
import com.xiaomi.accountsdk.utils.AccountLog;
import java.util.UUID;

public class HashedDeviceIdUtil {
    private final Context context;
    private final PlainDeviceIdUtil.IPlainDeviceIdFetcher plainDeviceIdFetcher;

    public enum DeviceIdPolicy {
        RUNTIME_DEVICE_ID_ONLY,
        CACHED_THEN_RUNTIME_THEN_PSEUDO
    }

    public HashedDeviceIdUtil(Context context2) {
        this(context2, PlainDeviceIdUtil.getFetcherInstance());
    }

    public HashedDeviceIdUtil(Context context2, PlainDeviceIdUtil.IPlainDeviceIdFetcher iPlainDeviceIdFetcher) {
        Context context3;
        if (iPlainDeviceIdFetcher != null) {
            if (context2 == null) {
                context3 = null;
            } else {
                context3 = context2.getApplicationContext();
            }
            this.context = context3;
            this.plainDeviceIdFetcher = iPlainDeviceIdFetcher;
            return;
        }
        throw new IllegalArgumentException("plainDeviceIdFetcher == null");
    }

    public static class GlobalConfig {
        public static DeviceIdPolicy DEFAULT_DEVICE_ID_POLICY = DeviceIdPolicy.RUNTIME_DEVICE_ID_ONLY;
        private static final GlobalConfig sInstance = new GlobalConfig();
        public DeviceIdPolicy policy = DEFAULT_DEVICE_ID_POLICY;
        private IUnifiedDeviceIdFetcher unifiedDeviceIdFetcher;

        private GlobalConfig() {
        }

        public static GlobalConfig getInstance() {
            return sInstance;
        }

        public void setPolicy(DeviceIdPolicy deviceIdPolicy) {
            this.policy = deviceIdPolicy;
        }

        public void setUnifiedDeviceIdFetcher(IUnifiedDeviceIdFetcher iUnifiedDeviceIdFetcher) {
            this.unifiedDeviceIdFetcher = iUnifiedDeviceIdFetcher;
        }

        public IUnifiedDeviceIdFetcher getUnifiedDeviceIdFetcher() {
            return this.unifiedDeviceIdFetcher;
        }
    }

    public boolean hasHistoricalHashedDeviceId() {
        return legal(loadHistoricalHashedDeviceId());
    }

    /* access modifiers changed from: package-private */
    public DeviceIdPolicy policy() {
        return GlobalConfig.getInstance().policy;
    }

    public String getHashedDeviceIdThrow() throws IllegalDeviceException {
        String hashedDeviceIdNoThrow = getHashedDeviceIdNoThrow();
        if (hashedDeviceIdNoThrow != null) {
            return hashedDeviceIdNoThrow;
        }
        throw new IllegalDeviceException("null device id");
    }

    @Deprecated
    public synchronized String getHashedDeviceIdNoThrow() {
        return getHashedDeviceId(true);
    }

    public synchronized String getHashedDeviceId(boolean z) {
        IUnifiedDeviceIdFetcher unifiedDeviceIdFetcher;
        DeviceIdPolicy policy = policy();
        if (policy == DeviceIdPolicy.RUNTIME_DEVICE_ID_ONLY) {
            return getRuntimeDeviceIdHashed();
        } else if (policy == DeviceIdPolicy.CACHED_THEN_RUNTIME_THEN_PSEUDO) {
            String loadHistoricalHashedDeviceId = loadHistoricalHashedDeviceId();
            if (!TextUtils.isEmpty(loadHistoricalHashedDeviceId)) {
                return loadHistoricalHashedDeviceId;
            }
            String runtimeDeviceIdHashed = getRuntimeDeviceIdHashed();
            if (runtimeDeviceIdHashed != null) {
                saveHistoricalHashedDeviceId(runtimeDeviceIdHashed);
                return runtimeDeviceIdHashed;
            }
            if (z) {
                if (!isMainThread() && (unifiedDeviceIdFetcher = GlobalConfig.getInstance().getUnifiedDeviceIdFetcher()) != null) {
                    String hashedDeviceId = unifiedDeviceIdFetcher.getHashedDeviceId(this.context);
                    if (!TextUtils.isEmpty(hashedDeviceId)) {
                        saveHistoricalHashedDeviceId(hashedDeviceId);
                        return hashedDeviceId;
                    }
                }
            }
            String oaid = OAIDUtil.getOAID(this.context);
            if (!TextUtils.isEmpty(oaid)) {
                String str = "oa_" + DeviceIDCloudCoder.getDataMd5Digest(oaid.getBytes());
                saveHistoricalHashedDeviceId(str);
                return str;
            }
            String androidID = getAndroidID(this.context);
            if (!TextUtils.isEmpty(androidID)) {
                String str2 = "an_" + DeviceIDCloudCoder.getDataMd5Digest(androidID.getBytes());
                saveHistoricalHashedDeviceId(str2);
                return str2;
            }
            String createPseudoDeviceId = createPseudoDeviceId();
            saveHistoricalHashedDeviceId(createPseudoDeviceId);
            return createPseudoDeviceId;
        } else {
            throw new IllegalStateException("unknown policy ".concat(String.valueOf(policy)));
        }
    }

    private static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* access modifiers changed from: package-private */
    public String getRuntimeDeviceIdHashed() {
        try {
            String userEnvironmentPlainDeviceId = getUserEnvironmentPlainDeviceId();
            if (legal(userEnvironmentPlainDeviceId)) {
                return DeviceIdHasher.hashDeviceInfo(userEnvironmentPlainDeviceId);
            }
            return null;
        } catch (SecurityException e) {
            AccountLog.w("HashedDeviceIdUtil", "can't get deviceid.", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public String getUserEnvironmentPlainDeviceId() {
        return this.plainDeviceIdFetcher.getPlainDeviceId(this.context);
    }

    /* access modifiers changed from: package-private */
    public boolean legal(String str) {
        return !TextUtils.isEmpty(str);
    }

    /* access modifiers changed from: package-private */
    public String createPseudoDeviceId() {
        return String.format("%s%s", "android_", UUID.randomUUID().toString());
    }

    public String loadHistoricalHashedDeviceId() {
        SharedPreferences sp = getSP();
        if (sp == null) {
            return null;
        }
        return sp.getString("hashedDeviceId", null);
    }

    public void saveHistoricalHashedDeviceId(String str) {
        SharedPreferences sp = getSP();
        if (sp != null) {
            sp.edit().putString("hashedDeviceId", str).commit();
        }
    }

    public static String getAndroidID(Context context2) {
        return Settings.Secure.getString(context2.getContentResolver(), "android_id");
    }

    /* access modifiers changed from: package-private */
    public SharedPreferences getSP() {
        Context context2 = this.context;
        if (context2 == null) {
            return null;
        }
        return context2.getSharedPreferences("deviceId", 0);
    }
}
