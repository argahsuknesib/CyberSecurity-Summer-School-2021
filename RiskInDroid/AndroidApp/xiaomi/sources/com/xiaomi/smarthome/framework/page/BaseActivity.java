package com.xiaomi.smarthome.framework.page;

import _m_j.ez;
import _m_j.gwg;
import _m_j.hzf;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class BaseActivity extends CommonActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSystemBar();
    }

    /* access modifiers changed from: protected */
    public void setSystemBar() {
        Window window = getWindow();
        if (window != null) {
            gwg.O00000Oo(window);
            gwg.O000000o(window, (byte) 0, false, null);
        }
    }

    public void addLifecycleObserver(ez ezVar) {
        if (ezVar != null) {
            getLifecycle().O000000o(ezVar);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        hzf.O00000Oo((Activity) this);
        hzf.O000000o((Activity) this);
    }
}
