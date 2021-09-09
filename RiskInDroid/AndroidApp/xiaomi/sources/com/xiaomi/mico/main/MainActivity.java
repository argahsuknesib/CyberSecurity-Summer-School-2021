package com.xiaomi.mico.main;

import _m_j.ei;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.mico.music.patchwall.RadioPatchWallFragment;
import com.xiaomi.smarthome.R;

public class MainActivity extends FragmentActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.main_activity);
        ei O000000o2 = getSupportFragmentManager().O000000o();
        O000000o2.O000000o((int) R.id.fragment_container, new RadioPatchWallFragment());
        O000000o2.O00000Oo();
    }
}
