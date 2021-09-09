package com.xiaomi.smarthome.miio.activity;

import _m_j.fbs;
import _m_j.fbt;
import android.annotation.TargetApi;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;

@Deprecated
public class ClientAllLockedActivity extends FragmentActivity {
    @TargetApi(16)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        fbt fbt = new fbt(this, "SmartHomeMainActivity");
        fbt.O00000Oo(335544320);
        fbs.O000000o(fbt);
        finish();
    }
}
