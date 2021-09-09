package com.xiaomi.smarthome.framework.page;

import _m_j.fut;
import _m_j.gwg;
import _m_j.gwi;
import android.os.Bundle;

public class BaseWhiteActivity extends CommonActivity implements fut {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        gwg.O00000o0(this);
    }

    public void onDestroy() {
        super.onDestroy();
        gwi.O000000o(this);
        gwi.O00000Oo(this);
    }
}
