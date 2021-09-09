package com.xiaomi.mico.music.patchwall;

import _m_j.ei;
import android.os.Bundle;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.smarthome.R;

public class MySongsActivity extends MicoBaseActivity {
    TitleBar mTitleBar;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.main_activity);
        this.mTitleBar = (TitleBar) findViewById(R.id.title_bar);
        this.mTitleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.music.patchwall.MySongsActivity.AnonymousClass1 */

            public void onLeftIconClick() {
                MySongsActivity.this.onBackPressed();
            }
        });
        ei O000000o2 = getSupportFragmentManager().O000000o();
        O000000o2.O000000o((int) R.id.fragment_container, new MySongsFragment());
        O000000o2.O00000Oo();
    }
}
