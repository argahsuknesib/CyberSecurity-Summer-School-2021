package com.hzy.tvmao.offline;

import com.hzy.tvmao.offline.SDKSwitcher;

/* synthetic */ class z {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f4463a = new int[SDKSwitcher.Mode.values().length];

    /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
    static {
        f4463a[SDKSwitcher.Mode.OnlineFirst.ordinal()] = 1;
        f4463a[SDKSwitcher.Mode.OnlineOnly.ordinal()] = 2;
        try {
            f4463a[SDKSwitcher.Mode.OfflineOnly.ordinal()] = 3;
        } catch (NoSuchFieldError unused) {
        }
    }
}
