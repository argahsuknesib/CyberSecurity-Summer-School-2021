package com.xiaomi.smarthome.uwb.lib.keyretriever;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.uwb.lib.processor.engine.IEngineSpecificKeyRetriever;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;

public abstract class BaseMitvSpecificKeyRetriever implements IEngineSpecificKeyRetriever {
    public static int MITV_DEFAULT_TIMEOUT = 30000;
    public static String TAG = "BaseMitvSpecificKeyRetriever";
    private static volatile MitvSpecificKeyCallback sGlobalMitvSpecificKeyCallback;
    public final Handler mHandler = new Handler(Looper.getMainLooper()) {
        /* class com.xiaomi.smarthome.uwb.lib.keyretriever.BaseMitvSpecificKeyRetriever.AnonymousClass1 */

        public void handleMessage(Message message) {
            if (message.what == 4096) {
                UwbLogUtil.w(BaseMitvSpecificKeyRetriever.TAG, "UwbLogUtilPlus retrieve did timeout");
                BaseMitvSpecificKeyRetriever.this.onFailed(-2);
            }
        }
    };

    public static void setGlobalMitvSpecificKeyCallback(MitvSpecificKeyCallback mitvSpecificKeyCallback) {
        sGlobalMitvSpecificKeyCallback = mitvSpecificKeyCallback;
    }

    /* access modifiers changed from: package-private */
    public void onFailed(int i) {
        UwbLogUtil.e(LogType.LOG_UWB, TAG, "onFailed: ".concat(String.valueOf(i)));
        this.mHandler.removeMessages(4096);
        MitvSpecificKeyCallback mitvSpecificKeyCallback = sGlobalMitvSpecificKeyCallback;
        if (mitvSpecificKeyCallback != null) {
            mitvSpecificKeyCallback.onFailed(i);
        }
    }

    public void onStartKeyRetrieve(String str, String str2) {
        this.mHandler.removeMessages(4096);
        MitvSpecificKeyCallback mitvSpecificKeyCallback = sGlobalMitvSpecificKeyCallback;
        if (mitvSpecificKeyCallback != null) {
            Bundle bundle = new Bundle();
            bundle.putString("UID", str);
            bundle.putString("TVKey", str2);
            mitvSpecificKeyCallback.onSuccess(12288, bundle);
        }
    }
}
