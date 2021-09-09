package com.xiaomi.smarthome;

import _m_j.gpc;
import android.annotation.SuppressLint;
import android.os.Bundle;
import com.xiaomi.smarthome.framework.page.CommonActivity;

@SuppressLint({"NewApi"})
public class BlankActivity extends CommonActivity {
    public void onBackPressed() {
    }

    public void onCreate(Bundle bundle) {
        gpc.O00000o(this);
        super.onCreate(bundle);
    }

    public void onResume() {
        super.onResume();
        finish();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
