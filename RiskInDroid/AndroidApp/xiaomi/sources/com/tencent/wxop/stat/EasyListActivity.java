package com.tencent.wxop.stat;

import _m_j.dke;
import android.app.ListActivity;

public class EasyListActivity extends ListActivity {
    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        dke.O000000o(this);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        dke.O00000Oo(this);
    }
}
