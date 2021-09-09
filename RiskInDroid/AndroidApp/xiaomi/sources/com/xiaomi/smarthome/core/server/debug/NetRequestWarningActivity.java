package com.xiaomi.smarthome.core.server.debug;

import _m_j.gpc;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class NetRequestWarningActivity extends Activity {

    /* renamed from: O000000o  reason: collision with root package name */
    TextView f6794O000000o;
    String O00000Oo = "";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        gpc.O00000o(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.net_request_warning_activity);
        this.f6794O000000o = (TextView) findViewById(R.id.text);
        O000000o(getIntent());
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        O000000o(intent);
    }

    private void O000000o(Intent intent) {
        String stringExtra = intent.getStringExtra("item");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.O00000Oo += "\n\n" + stringExtra;
        }
        this.f6794O000000o.setText(this.O00000Oo);
    }
}
