package com.xiaomi.accountsdk.request;

import com.xiaomi.accountsdk.account.XMPassportSettings;
import com.xiaomi.accountsdk.account.stat.AccountStatInterface;
import com.xiaomi.accountsdk.utils.VersionUtils;

public class IPStatHelper {
    /* access modifiers changed from: protected */
    public AccountStatInterface getStatInterface() {
        return AccountStatInterface.getInstance();
    }

    /* access modifiers changed from: protected */
    public void statCountEvent(String str, String str2) {
        getStatInterface().statCountEvent(str, str2);
    }

    /* access modifiers changed from: protected */
    public void statDummyUrl(String str) {
        if (!VersionUtils.isMiuiStableVersion()) {
            getStatInterface().statHttpEvent(str, 0);
        }
    }

    /* access modifiers changed from: protected */
    public String getNetworkName() {
        return NetworkUtils.getNetworkNameForMiUrlStat(XMPassportSettings.getApplicationContext());
    }
}
