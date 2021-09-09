package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;

public final class WXAppLaunchData {
    public int launchType;
    public String message;

    public static class Builder {
        public static WXAppLaunchData fromBundle(Bundle bundle) {
            WXAppLaunchData wXAppLaunchData = new WXAppLaunchData();
            wXAppLaunchData.launchType = bundle.getInt("_wxapplaunchdata_launchType");
            wXAppLaunchData.message = bundle.getString("_wxapplaunchdata_message");
            return wXAppLaunchData;
        }

        public static Bundle toBundle(WXAppLaunchData wXAppLaunchData) {
            Bundle bundle = new Bundle();
            bundle.putInt("_wxapplaunchdata_launchType", wXAppLaunchData.launchType);
            bundle.putString("_wxapplaunchdata_message", wXAppLaunchData.message);
            return bundle;
        }
    }
}
