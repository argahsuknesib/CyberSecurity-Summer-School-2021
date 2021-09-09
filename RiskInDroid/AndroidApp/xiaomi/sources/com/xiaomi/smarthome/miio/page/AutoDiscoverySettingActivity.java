package com.xiaomi.smarthome.miio.page;

import _m_j.goy;
import _m_j.gpc;
import _m_j.gpv;
import _m_j.gpy;
import _m_j.gwc;
import _m_j.gwg;
import _m_j.hxi;
import _m_j.hzf;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.framework.page.CommonActivity;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;

public class AutoDiscoverySettingActivity extends CommonActivity {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
    public void onCreate(Bundle bundle) {
        gpc.O00000o(this);
        super.onCreate(bundle);
        gwg.O00000Oo(getWindow());
        setContentView((int) R.layout.activity_discovery_device_auto_layout);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.AutoDiscoverySettingActivity.AnonymousClass1 */

            public final void onClick(View view) {
                AutoDiscoverySettingActivity.this.finish();
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.about_miui_auto_discovery_name);
        View findViewById = findViewById(R.id.wifi_discovery_auto_container);
        findViewById.setVisibility(0);
        final SwitchButton switchButton = (SwitchButton) findViewById(R.id.wifi_discovery_auto_switch);
        switchButton.setOnTouchEnable(false);
        switchButton.setChecked(gpy.O00000o0(ServiceApplication.getAppContext(), "prefs_lite_config", "miui_auto_discovery", false));
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.AutoDiscoverySettingActivity.AnonymousClass2 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.gpv.O00000Oo(java.lang.String, boolean):void
             arg types: [java.lang.String, int]
             candidates:
              _m_j.gpv.O00000Oo(android.content.Context, java.lang.String):void
              _m_j.gpv.O00000Oo(java.lang.String, java.lang.String):void
              _m_j.gpv.O00000Oo(java.lang.String, boolean):void */
            public final void onClick(View view) {
                hxi.O00000o.f952O000000o.O000000o("set_found_model", "type", Integer.valueOf(!switchButton.isChecked() ? 1 : 2));
                gpv.O00000Oo("open_find_device_tips", false);
                SwitchButton switchButton = switchButton;
                switchButton.setChecked(!switchButton.isChecked());
                hzf.O000000o((CompoundButton) switchButton);
                gpy.O000000o(ServiceApplication.getAppContext(), "prefs_lite_config", "miui_auto_discovery", switchButton.isChecked());
            }
        });
        hxi.O00000o0.f957O000000o.O000000o("set_found_modelpop", "type", Integer.valueOf(switchButton.isChecked() ? 1 : 2));
        View findViewById2 = findViewById(R.id.ble_discovery_auto_container);
        findViewById2.setVisibility(0);
        final SwitchButton switchButton2 = (SwitchButton) findViewById(R.id.ble_discovery_auto_switch);
        switchButton2.setOnTouchEnable(false);
        switchButton2.setChecked(gpy.O00000o0(ServiceApplication.getAppContext(), "prefs_lite_config", "nearby_auto_discovery", true));
        findViewById2.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.AutoDiscoverySettingActivity.AnonymousClass3 */

            public final void onClick(View view) {
                SwitchButton switchButton = switchButton2;
                switchButton.setChecked(!switchButton.isChecked());
                hzf.O000000o((CompoundButton) switchButton2);
                hxi.O00000o.f952O000000o.O000000o("set_found_modelbleclick", "type", Integer.valueOf(switchButton2.isChecked() ? 1 : 2));
                gpy.O000000o(ServiceApplication.getAppContext(), "prefs_lite_config", "nearby_auto_discovery", switchButton2.isChecked());
            }
        });
        hxi.O00000oO.f958O000000o.O000000o("ignore_device_pop", "type", Integer.valueOf(switchButton2.isChecked() ? 1 : 2));
        if (!goy.O00000Oo()) {
            findViewById.setVisibility(8);
        }
    }

    public void onContentChanged() {
        super.onContentChanged();
        gwg.O00000o(this);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(gwc.O00000Oo(context));
    }
}
