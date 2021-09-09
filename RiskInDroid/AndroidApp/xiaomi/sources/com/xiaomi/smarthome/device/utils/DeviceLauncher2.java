package com.xiaomi.smarthome.device.utils;

import _m_j.eya;
import _m_j.ezq;
import _m_j.ezt;
import _m_j.ezu;
import _m_j.gpc;
import _m_j.gsy;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.DeviceMainPageRouterFactory;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.log.LogType;

@RouterService
public class DeviceLauncher2 extends FragmentActivity {
    private boolean fromCtaPassed = true;

    public void onCreate(Bundle bundle) {
        gpc.O00000o(this);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT != 26 || !gpc.O00000o0(this)) {
            setRequestedOrientation(1);
        }
        setContentView((int) R.layout.scene_launcher_layout);
        gsy.O00000o0(LogType.PAGE_SWITCH, "DeviceLauncher2", "onCreate");
        if (!(getIntent() == null || getIntent().getStringExtra("search_word") == null)) {
            LogType logType = LogType.PAGE_SWITCH;
            gsy.O00000o0(logType, "DeviceLauncher2", "onCreate search word = " + getIntent().getStringExtra("search_word"));
        }
        Intent intent = getIntent();
        if (intent != null) {
            gsy.O000000o(6, "hzd1", "DeviceLauncher2: uwb_device_address=" + intent.getStringExtra("uwb_device_address"));
        }
        this.fromCtaPassed = ezu.O000000o();
        ezt.O000000o().startCheck(new ezq() {
            /* class com.xiaomi.smarthome.device.utils.DeviceLauncher2.AnonymousClass1 */

            public final void O000000o() {
                DeviceLauncher2.this.finish();
            }

            public final void O00000Oo() {
                DeviceLauncher2.this.finish();
            }

            public final void O00000o0() {
                DeviceLauncher2 deviceLauncher2 = DeviceLauncher2.this;
                deviceLauncher2.doWork(deviceLauncher2.getIntent());
            }
        });
        eya.O000000o().f15942O000000o = false;
    }

    public void doWork(Intent intent) {
        intent.putExtra("sh_is_from_cta_passed_state", this.fromCtaPassed);
        DeviceMainPageRouterFactory.getDeviceMainPageHelper().doSmartHomeJumper(this, intent);
    }

    public void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        gsy.O00000o0(LogType.PAGE_SWITCH, "DeviceLauncher2", "onNewIntent");
        if (!(intent == null || intent.getStringExtra("search_word") == null)) {
            LogType logType = LogType.PAGE_SWITCH;
            gsy.O00000o0(logType, "DeviceLauncher2", "onNewIntent search word = " + intent.getStringExtra("search_word"));
        }
        ezt.O000000o().startCheck(new ezq() {
            /* class com.xiaomi.smarthome.device.utils.DeviceLauncher2.AnonymousClass2 */

            public final void O000000o() {
                DeviceLauncher2.this.finish();
            }

            public final void O00000Oo() {
                DeviceLauncher2.this.finish();
            }

            public final void O00000o0() {
                DeviceLauncher2.this.doWork(intent);
            }
        });
    }

    public void onResume() {
        super.onResume();
    }
}
