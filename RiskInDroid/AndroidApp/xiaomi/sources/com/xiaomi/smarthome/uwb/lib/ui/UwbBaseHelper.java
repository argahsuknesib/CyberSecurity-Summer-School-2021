package com.xiaomi.smarthome.uwb.lib.ui;

import _m_j.gsy;
import _m_j.gwg;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import com.xiaomi.smarthome.uwb.lib.UwbApi;
import com.xiaomi.smarthome.uwb.lib.utils.UIUtils;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;

public class UwbBaseHelper {
    private UwbBaseCallback callback;
    HomeWatcherReceiver mHomeKeyReceiver;

    public void onCreate(UwbBaseCallback uwbBaseCallback, Activity activity) {
        gsy.O000000o(3, "Mijia-UWB-UwbBaseHelper", "registerHomeKeyReceiver");
        this.callback = uwbBaseCallback;
        this.mHomeKeyReceiver = new HomeWatcherReceiver(activity);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        activity.getApplicationContext().registerReceiver(this.mHomeKeyReceiver, intentFilter);
        gwg.O00000o0(activity);
    }

    public void onDestroy(Activity activity) {
        UwbLogUtil.d("Mijia-UWB-UwbBaseHelper", "onDestroy start: " + activity.getClass().getSimpleName());
        unregisterHomeKeyReceiver(activity);
        if (this.callback.needExitUwb()) {
            UwbDeviceUtil.sendUwbShutdownBroadCast(activity);
            clearUwbTask(activity);
            UwbApi.getInstance().destroy();
        }
        UwbLogUtil.d("Mijia-UWB-UwbBaseHelper", "onDestroy end: " + activity.getClass().getSimpleName());
    }

    /* access modifiers changed from: package-private */
    public void clearUwbTask(Activity activity) {
        UwbBaseCallback uwbBaseCallback = this.callback;
        if (uwbBaseCallback != null && !uwbBaseCallback.isPlugin()) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.xiaomi.smarthome", "com.smarthome.uwb.ui.ClearUwbTaskActivity"));
                activity.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void unregisterHomeKeyReceiver(Context context) {
        gsy.O000000o(3, "Mijia-UWB-UwbBaseHelper", "unregisterHomeKeyReceiver");
        if (this.mHomeKeyReceiver != null) {
            context.getApplicationContext().unregisterReceiver(this.mHomeKeyReceiver);
        }
    }

    class HomeWatcherReceiver extends BroadcastReceiver {
        private final Activity activity;

        public HomeWatcherReceiver(Activity activity2) {
            this.activity = activity2;
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            UwbLogUtil.w("Mijia-UWB-UwbBaseHelper", "UwbLogUtilPlus HomeWatcherReceiver onReceive: action: ".concat(String.valueOf(action)));
            if (action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                String stringExtra = intent.getStringExtra("reason");
                UwbLogUtil.w("Mijia-UWB-UwbBaseHelper", "UwbLogUtilPlus HomeWatcherReceiver onReceive: reason: ".concat(String.valueOf(stringExtra)));
                if (stringExtra != null && stringExtra.equalsIgnoreCase("homekey")) {
                    this.activity.finish();
                }
            } else if (action.equalsIgnoreCase("android.intent.action.SCREEN_OFF")) {
                this.activity.finish();
            }
        }
    }

    public void startShowAni(View view, View view2, View view3) {
        UIUtils.startShowAni(view, view2, view3);
    }
}
