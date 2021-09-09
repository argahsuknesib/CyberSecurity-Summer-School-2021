package com.xiaomi.smarthome.uwb.lib.idm;

import _m_j.ft;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;

public class UwbIdmMonitor {
    private static volatile UwbIdmMonitor sInstance;
    private volatile long mLastPayloadTimestamp = 0;
    private Handler mTimeoutHandler = new Handler(Looper.getMainLooper()) {
        /* class com.xiaomi.smarthome.uwb.lib.idm.UwbIdmMonitor.AnonymousClass1 */

        public void handleMessage(Message message) {
            if (message.what == 1) {
                UwbIdmMonitor.this.handleTimeout();
            }
        }
    };

    private UwbIdmMonitor() {
    }

    public static UwbIdmMonitor getInstance() {
        if (sInstance == null) {
            synchronized (UwbIdmMonitor.class) {
                if (sInstance == null) {
                    sInstance = new UwbIdmMonitor();
                }
            }
        }
        return sInstance;
    }

    public void handleTimeout() {
        ft.O000000o(UwbSdk.getApplication()).O000000o(new Intent("action_uwb_idm_shutdown"));
        UwbLogUtil.e("Mijia-UWB-UwbIdmMonitor", "uwb is idle for " + ((System.currentTimeMillis() - this.mLastPayloadTimestamp) / 1000) + "ms, will shutdown!");
    }

    public void onPayloadSend(int i) {
        this.mLastPayloadTimestamp = System.currentTimeMillis();
        this.mTimeoutHandler.removeMessages(1);
        this.mTimeoutHandler.sendEmptyMessageDelayed(1, 20000);
    }
}
