package com.xiaomi.mico.main;

import android.content.Context;
import android.os.Bundle;

public class MainHelper {
    public static String getTabKeyByIndex(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "settings" : "services" : "smarthome" : "homepage";
    }

    public static void newIntentToMainActivity(String str, Bundle bundle) {
    }

    public static void switchTab(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("key_tab", str);
        newIntentToMainActivity("mico.action.SWITCH_TAB", bundle);
    }
}
