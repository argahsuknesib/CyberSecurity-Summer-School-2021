package com.xiaomi.accountsdk.account.stat;

import android.os.SystemClock;
import com.xiaomi.accountsdk.account.XMPassportSettings;
import com.xiaomi.accountsdk.hasheddeviceidlib.HashedDeviceIdUtil;

public class CustomizedUrlStatUtil {
    private boolean hasError = false;
    private long startTs = -1;
    private final String url;

    public CustomizedUrlStatUtil(String str, String str2) {
        if (str != null) {
            this.url = String.format("http://dummyurl/%s/_ver=%s&hdid=%s", str, str2, new HashedDeviceIdUtil(XMPassportSettings.getApplicationContext()).getHashedDeviceIdNoThrow());
            return;
        }
        throw new IllegalArgumentException("url can't be null");
    }

    public void startStat() {
        this.startTs = SystemClock.elapsedRealtime();
    }

    public void finishStat() {
        AccountStatInterface instance;
        if (!this.hasError && (instance = AccountStatInterface.getInstance()) != null) {
            instance.statHttpEvent(this.url, SystemClock.elapsedRealtime() - this.startTs);
        }
    }

    public void statError(Exception exc) {
        this.hasError = true;
        AccountStatInterface instance = AccountStatInterface.getInstance();
        if (exc != null && instance != null) {
            instance.statHttpEvent(this.url, exc);
        }
    }
}
