package com.xiaomi.smarthome.device.choosedevice;

import _m_j.gpc;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import java.util.ArrayList;

public class CannotFindDeviceChildActivity extends BaseActivity {
    @BindView(5071)
    Button mBtnSure;
    @BindView(5488)
    LinearLayout mLayoutModelParent;
    @BindView(6211)
    TextView mTxtItemTitle;

    public static void invokeActivity(String str, ArrayList<String> arrayList, Context context) {
        Intent intent = new Intent(context, CannotFindDeviceChildActivity.class);
        intent.putExtra("EXTRA_COMPANY_NAME", str);
        intent.putStringArrayListExtra("EXTRA_COMPANY_MODELS", arrayList);
        context.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_cannot_find_device_child);
        ButterKnife.bind(this);
        findViewById(R.id.module_a_3_right_iv_setting_btn).setVisibility(4);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.choosedevice.CannotFindDeviceChildActivity.AnonymousClass1 */

            public final void onClick(View view) {
                CannotFindDeviceChildActivity.this.finish();
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.cannot_find_device_title);
        this.mTxtItemTitle.setText(getString(R.string.models_belong_to_company, new Object[]{getIntent().getStringExtra("EXTRA_COMPANY_NAME")}));
        this.mBtnSure.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.choosedevice.CannotFindDeviceChildActivity.AnonymousClass2 */

            public final void onClick(View view) {
                CannotFindDeviceChildActivity.this.finish();
            }
        });
        final ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("EXTRA_COMPANY_MODELS");
        if (!this.mIsDestroyed && stringArrayListExtra != null) {
            runOnUiThread(new Runnable() {
                /* class com.xiaomi.smarthome.device.choosedevice.CannotFindDeviceChildActivity.AnonymousClass3 */

                public final void run() {
                    String str;
                    if (stringArrayListExtra.size() > 0) {
                        CannotFindDeviceChildActivity.this.mLayoutModelParent.removeAllViews();
                    }
                    for (String str2 : stringArrayListExtra) {
                        PluginDeviceInfo pluginInfo = PluginDeviceManager.instance.getPluginInfo(str2);
                        if (pluginInfo == null) {
                            str = "null";
                        } else {
                            str = pluginInfo.O0000Oo0();
                        }
                        CannotFindDeviceChildActivity.this.mLayoutModelParent.addView(CannotFindDeviceChildActivity.this.buildItemView("(" + str + ")" + str2));
                    }
                }
            });
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpc.O000000o(android.app.Activity, float):int
     arg types: [com.xiaomi.smarthome.device.choosedevice.CannotFindDeviceChildActivity, int]
     candidates:
      _m_j.gpc.O000000o(android.content.Context, float):int
      _m_j.gpc.O000000o(android.view.View, int):void
      _m_j.gpc.O000000o(android.app.Activity, float):int */
    public TextView buildItemView(String str) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, gpc.O000000o((Activity) this, 50.0f));
        TextView textView = new TextView(this);
        textView.setLayoutParams(layoutParams);
        textView.setText(str);
        textView.setTextSize(15.0f);
        textView.setTextColor(-16777216);
        textView.setGravity(16);
        return textView;
    }
}
