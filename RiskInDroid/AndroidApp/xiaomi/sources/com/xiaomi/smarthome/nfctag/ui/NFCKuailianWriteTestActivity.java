package com.xiaomi.smarthome.nfctag.ui;

import _m_j.hig;
import _m_j.hiv;
import _m_j.hte;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import butterknife.OnClick;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class NFCKuailianWriteTestActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    EditText f10424O000000o;
    EditText O00000Oo;
    EditText O00000o0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_nfc_kuailian_write_test);
        this.f10424O000000o = (EditText) findViewById(R.id.et_model);
        this.O00000Oo = (EditText) findViewById(R.id.et_did);
        this.O00000o0 = (EditText) findViewById(R.id.et_extra);
        this.f10424O000000o.setText("yeelink.light.bslamp3");
        this.O00000Oo.setText("105379089");
        this.O00000o0.setText("40313C3188B5");
        findViewById(R.id.btn_write).setOnClickListener(this);
    }

    @OnClick({4992})
    public void onClick(View view) {
        if (view.getId() == R.id.btn_write) {
            this.f10424O000000o.getText();
            this.O00000Oo.getText();
            this.O00000o0.getText();
            Intent intent = new Intent(this, NFCWriteActivity.class);
            hig.f18961O000000o = 8;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("next_action_type", hiv.O00000Oo);
                jSONObject.put("did", "105379089");
                jSONObject.put("model", "yeelink.light.bslamp3");
                jSONObject.put("mac", "40313C3188B5");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (jSONObject.keys().hasNext()) {
                hig.O00000o0 = jSONObject.toString();
                startActivity(intent);
                finish();
                return;
            }
            hte.O000000o(this, (int) R.string.save_fail);
        }
    }
}
