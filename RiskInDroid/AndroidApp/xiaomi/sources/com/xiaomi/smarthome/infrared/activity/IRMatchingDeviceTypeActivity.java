package com.xiaomi.smarthome.infrared.activity;

import _m_j.gin;
import _m_j.gir;
import _m_j.gje;
import _m_j.gsy;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.infrared.bean.IRType;
import java.util.Arrays;
import java.util.List;

public class IRMatchingDeviceTypeActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private List<gir> f9001O000000o;
    private int O00000Oo;
    private DeviceStat O00000o0;

    public static void showMatchingDeviceTypeActivity(Activity activity, DeviceStat deviceStat, int i, String[] strArr, Bundle bundle) {
        if (strArr == null || strArr.length != 1) {
            Intent intent = new Intent(activity, IRMatchingDeviceTypeActivity.class);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            intent.putExtra("extra_device", deviceStat);
            intent.putExtra("infrared_model", strArr);
            intent.putExtra("extra_type", i);
            activity.startActivityForResult(intent, C.MSG_CUSTOM_BASE);
            return;
        }
        O000000o(activity, deviceStat, i, strArr[0], bundle);
    }

    private static void O000000o(Activity activity, DeviceStat deviceStat, int i, String str, Bundle bundle) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra("extra_device", deviceStat);
        intent.putExtra("intent_device_type_key", IRType.valueOfModel(str).value());
        if ("miir.remote.ir01".equals(str)) {
            intent.setClass(activity, IRStudyActivity.class);
        } else if (i == 0) {
            if ("miir.stb.ir01".equals(str)) {
                intent.setClass(activity, IRMatchBranchSetTopBoxActivity.class);
            } else {
                intent.setClass(activity, IRMatchingBrandActivity.class);
            }
        } else if ("miir.aircondition.ir01".equals(str) || "miir.aircondition.ir02".equals(str)) {
            intent.setClass(activity, IRStudyFailTipsActivity.class);
        } else {
            intent.setClass(activity, IRStudyActivity.class);
        }
        activity.startActivityForResult(intent, C.MSG_CUSTOM_BASE);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.O00000o0 = (DeviceStat) intent.getParcelableExtra("extra_device");
        String[] stringArrayExtra = intent.getStringArrayExtra("infrared_model");
        this.O00000Oo = intent.getIntExtra("extra_type", 0);
        if (this.O00000o0 == null) {
            gsy.O000000o(6, "openIRController", "XmPluginHostApi.instance().openIRController first param is null");
            finish();
            return;
        }
        setContentView((int) R.layout.activity_ir_matching_devices);
        View findViewById = findViewById(R.id.module_a_3_return_btn);
        findViewById(R.id.module_a_3_return_more_more_btn).setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.module_a_3_return_title);
        if (this.O00000Oo == 0) {
            textView.setText((int) R.string.ir_matching_controller);
        } else {
            textView.setText((int) R.string.ir_study_controller_title);
        }
        GridView gridView = (GridView) findViewById(R.id.ir_matching_device_grid);
        gsy.O00000Oo("IRMatchingDeviceTypeActivity", "openAddIRController " + Arrays.toString(stringArrayExtra));
        if (stringArrayExtra != null && stringArrayExtra.length != 0) {
            this.f9001O000000o = gje.O000000o(stringArrayExtra);
        } else if (this.O00000Oo == 0) {
            this.f9001O000000o = gje.O000000o();
        } else {
            this.f9001O000000o = gje.O00000Oo();
        }
        gridView.setAdapter((ListAdapter) new gin(this, this.f9001O000000o));
        gridView.setOnItemClickListener(this);
        findViewById.setOnClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        O000000o(this, this.O00000o0, this.O00000Oo, this.f9001O000000o.get(i).f17814O000000o, getIntent().getExtras());
    }

    public void onClick(View view) {
        if (view.getId() == R.id.module_a_3_return_btn) {
            onBackPressed();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && intent.getBooleanExtra("infrared_finish", false)) {
            setResult(-1, intent);
            finish();
        }
    }
}
