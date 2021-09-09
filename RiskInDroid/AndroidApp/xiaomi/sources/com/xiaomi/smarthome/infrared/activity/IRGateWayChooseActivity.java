package com.xiaomi.smarthome.infrared.activity;

import _m_j.fno;
import _m_j.gik;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import java.util.ArrayList;
import java.util.Map;

public class IRGateWayChooseActivity extends BaseActivity implements gik.O000000o, View.OnClickListener {
    public static void showIRGateWayChooseActivity(Activity activity, String str) {
        Intent intent = new Intent(activity, IRGateWayChooseActivity.class);
        intent.putExtra("model", str);
        activity.startActivityForResult(intent, C.MSG_CUSTOM_BASE);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_ir_gateway_choose);
        View findViewById = findViewById(R.id.module_a_3_return_btn);
        View findViewById2 = findViewById(R.id.module_a_3_return_more_more_btn);
        findViewById2.setVisibility(8);
        ListView listView = (ListView) findViewById(R.id.ir_gateway_choose_list_view);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.get_way_choose_title);
        View findViewById3 = findViewById(R.id.no_gateway_root);
        TextView textView = (TextView) findViewById(R.id.gateway_go_shop);
        textView.getPaint().setFlags(8);
        Map<String, Device> O0000O0o = fno.O000000o().O0000O0o();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Device> value : O0000O0o.entrySet()) {
            Device device = (Device) value.getValue();
            PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(device.model);
            if (O00000oO != null && O00000oO.O0000o(16)) {
                arrayList.add(DeviceRouterFactory.getDeviceWrapper().newDeviceStat(device));
            }
        }
        if (arrayList.size() == 0) {
            findViewById3.setVisibility(0);
        } else {
            listView.setAdapter((ListAdapter) new gik(this, arrayList, this));
        }
        findViewById.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.module_a_3_return_btn) {
            onBackPressed();
        }
    }

    public void onClick(View view, DeviceStat deviceStat) {
        String stringExtra = getIntent().getStringExtra("model");
        boolean equals = "miir.remote.ir01".equals(stringExtra);
        IRMatchingDeviceTypeActivity.showMatchingDeviceTypeActivity(this, deviceStat, equals ? 1 : 0, new String[]{stringExtra}, getIntent().getExtras());
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && intent.getBooleanExtra("infrared_finish", false)) {
            setResult(-1, intent);
            finish();
        }
    }
}
