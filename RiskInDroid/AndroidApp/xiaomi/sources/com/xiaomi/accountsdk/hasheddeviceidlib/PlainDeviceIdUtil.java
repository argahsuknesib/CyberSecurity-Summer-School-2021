package com.xiaomi.accountsdk.hasheddeviceidlib;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

public final class PlainDeviceIdUtil {

    public interface IPlainDeviceIdFetcher {
        String getPlainDeviceId(Context context);
    }

    static class FetcherHolder {
        public static volatile IPlainDeviceIdFetcher sInstance = new PlainDeviceIdUtilImplDefault();

        private FetcherHolder() {
        }
    }

    public static IPlainDeviceIdFetcher getFetcherInstance() {
        return FetcherHolder.sInstance;
    }

    public static void setFetcherInstance(IPlainDeviceIdFetcher iPlainDeviceIdFetcher) {
        FetcherHolder.sInstance = iPlainDeviceIdFetcher;
    }

    public static final class PlainDeviceIdUtilImplDefault implements IPlainDeviceIdFetcher {
        public final String getPlainDeviceId(Context context) {
            if (context == null) {
                return null;
            }
            String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            return TextUtils.isEmpty(deviceId) ? MacAddressUtil.getMacAddress(context) : deviceId;
        }
    }
}
