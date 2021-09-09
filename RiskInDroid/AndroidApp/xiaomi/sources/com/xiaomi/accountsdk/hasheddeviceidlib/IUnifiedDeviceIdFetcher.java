package com.xiaomi.accountsdk.hasheddeviceidlib;

import android.content.Context;

public interface IUnifiedDeviceIdFetcher {
    String getHashedDeviceId(Context context);
}
