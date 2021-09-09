package com.xiaomi.smarthome.device.bluetooth.connect;

import _m_j.ddc;
import _m_j.ez;
import _m_j.gpx;
import _m_j.gsy;
import _m_j.gwg;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.xiaomi.smarthome.framework.page.CommonActivity;
import com.xiaomi.smarthome.library.log.LogType;
import java.lang.reflect.Field;

public class ConnectBaseActivity extends CommonActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        gwg.O00000Oo(getWindow());
    }

    public void addLifecycleObserver(ez ezVar) {
        if (ezVar != null) {
            getLifecycle().O000000o(ezVar);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            gpx.O000000o(inputMethodManager, "windowDismissed", new gpx.O000000o(getWindow().getDecorView().getWindowToken(), IBinder.class));
            gpx.O000000o(inputMethodManager, "startGettingWindowFocus", new gpx.O000000o(null, View.class));
            String[] strArr = {"mCurRootView", "mServedView", "mNextServedView"};
            for (int i = 0; i < 3; i++) {
                try {
                    Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i]);
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    Object obj = declaredField.get(inputMethodManager);
                    if (obj != null && (obj instanceof View)) {
                        if (((View) obj).getContext() == this) {
                            declaredField.set(inputMethodManager, null);
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        try {
            ddc.O000000o(getWindow().getDecorView().findViewById(16908290));
        } catch (Exception e) {
            gsy.O00000o0(LogType.GENERAL, "", e.getMessage());
        }
    }
}
