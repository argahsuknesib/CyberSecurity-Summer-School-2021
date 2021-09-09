package com.xiaomi.smarthome.uwb.kuailian.builtin;

import _m_j.hna;
import com.xiaomi.smarthome.uwb.kuailian.callback.IConfigCompletionHandler;

public class KuailianUwbBuiltinManager {
    private static KuailianUwbBuiltinManager sInstance;

    private KuailianUwbBuiltinManager() {
    }

    public static KuailianUwbBuiltinManager getInstance() {
        if (sInstance == null) {
            synchronized (KuailianUwbBuiltinManager.class) {
                if (sInstance == null) {
                    sInstance = new KuailianUwbBuiltinManager();
                }
            }
        }
        return sInstance;
    }

    public void doOpenUwbBleConfigActivity(String str, String str2, IConfigCompletionHandler iConfigCompletionHandler) {
        hna.O00000o0().doOpenUwbBleConfigActivity(str, str2, iConfigCompletionHandler);
    }
}
