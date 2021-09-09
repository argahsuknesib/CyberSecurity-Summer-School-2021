package com.xiaomi.smarthome.voice;

import _m_j.fbs;
import _m_j.fbt;
import android.os.Bundle;
import com.xiaomi.smarthome.framework.page.BaseActivity;

public class SmartHomeVoiceLauncherActivity extends BaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        fbt fbt = new fbt(this, "SmartHomeMainActivity");
        fbt.O00000Oo(335544320);
        fbs.O000000o(fbt);
        finish();
    }
}
