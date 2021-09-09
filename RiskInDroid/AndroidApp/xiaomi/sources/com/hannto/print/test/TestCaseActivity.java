package com.hannto.print.test;

import _m_j.ayx;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.xiaomi.smarthome.R;

public class TestCaseActivity extends AppCompatActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.ht_activity_test);
        findViewById(R.id.test_result).setOnClickListener(new O000000o());
    }

    public class O000000o implements View.OnClickListener {
        public final void onClick(View view) {
            if (ayx.f12717O000000o == null) {
                ayx.f12717O000000o = new ayx();
            }
        }
    }
}
