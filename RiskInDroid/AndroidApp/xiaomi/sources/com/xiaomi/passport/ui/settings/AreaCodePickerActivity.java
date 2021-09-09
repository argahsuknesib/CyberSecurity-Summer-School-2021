package com.xiaomi.passport.ui.settings;

import _m_j.eiq;
import _m_j.ejn;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.xiaomi.accountsdk.utils.ParcelableAttackGuardian;

public class AreaCodePickerActivity extends AppCompatActivity {
    public void onCreate(Bundle bundle) {
        setRequestedOrientation(1);
        super.onCreate(bundle);
        if (!new ParcelableAttackGuardian().safeCheck(this)) {
            finish();
            return;
        }
        ejn ejn = new ejn();
        ejn.setArguments(getIntent().getExtras());
        eiq.O000000o(getFragmentManager(), ejn);
    }
}
