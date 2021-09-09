package com.xiaomi.mico.main;

import _m_j.ei;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.mico.MicoMainFragment;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.smarthome.R;

public class MicoMainActivity extends MicoBaseActivity {
    MicoMainFragment fragment;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.mico_main_activity);
        ei O000000o2 = getSupportFragmentManager().O000000o();
        this.fragment = new MicoMainFragment();
        String stringExtra = getIntent().getStringExtra("did");
        String stringExtra2 = getIntent().getStringExtra("from");
        Bundle bundle2 = new Bundle();
        bundle2.putString("from", stringExtra2);
        if (!TextUtils.isEmpty(stringExtra)) {
            bundle2.putString("did", stringExtra);
        }
        this.fragment.setArguments(bundle2);
        O000000o2.O000000o((int) R.id.fragment_container, this.fragment);
        O000000o2.O00000Oo();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.fragment.onActivityResult(i, i2, intent);
    }
}
