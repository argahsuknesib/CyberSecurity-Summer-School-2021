package com.xiaomi.smarthome.device.choosedevice;

import _m_j.fpq;
import _m_j.fqg;
import _m_j.gqg;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;

public class ResetPageRoute extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f7257O000000o = false;
    public fpq mChooseDeviceHelper;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fpq.O000000o(com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo, android.content.Intent, boolean):boolean
     arg types: [com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo, android.content.Intent, int]
     candidates:
      _m_j.fpq.O000000o(java.lang.String, boolean, android.content.Intent):void
      _m_j.fpq.O000000o(java.util.List, _m_j.fpq$O000000o, java.util.List):void
      _m_j.fpq.O000000o(com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo, android.content.Intent, boolean):boolean */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("extra_model");
        if (TextUtils.isEmpty(stringExtra)) {
            gqg.O00000Oo((int) R.string.failed);
            finish();
            return;
        }
        setContentView(new FrameLayout(this));
        this.mChooseDeviceHelper = new fpq();
        this.mChooseDeviceHelper.O000000o(this, null);
        final PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(stringExtra);
        if (O00000oO == null) {
            gqg.O00000Oo((int) R.string.failed);
        } else if (O00000oO.O0000o() != Device.PID_SUBDEVICE) {
            this.mChooseDeviceHelper.O000000o(O00000oO, getIntent(), false);
        } else if (fqg.O00000Oo.f16899O000000o.O000000o()) {
            this.mChooseDeviceHelper.O000000o(O00000oO, getIntent(), false);
        } else {
            fqg.O00000Oo.f16899O000000o.O000000o(new fqg.O00000o0() {
                /* class com.xiaomi.smarthome.device.choosedevice.ResetPageRoute.AnonymousClass1 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.fpq.O000000o(com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo, android.content.Intent, boolean):boolean
                 arg types: [com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo, android.content.Intent, int]
                 candidates:
                  _m_j.fpq.O000000o(java.lang.String, boolean, android.content.Intent):void
                  _m_j.fpq.O000000o(java.util.List, _m_j.fpq$O000000o, java.util.List):void
                  _m_j.fpq.O000000o(com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo, android.content.Intent, boolean):boolean */
                public final void O000000o() {
                    fqg.O00000Oo.f16899O000000o.O00000Oo(this);
                    if (!ResetPageRoute.this.f7257O000000o) {
                        ResetPageRoute resetPageRoute = ResetPageRoute.this;
                        resetPageRoute.f7257O000000o = true;
                        resetPageRoute.mChooseDeviceHelper.O000000o(O00000oO, ResetPageRoute.this.getIntent(), false);
                    }
                }
            });
        }
        finish();
    }

    public void onDestroy() {
        super.onDestroy();
        fpq fpq = this.mChooseDeviceHelper;
        if (fpq != null && fpq.f16876O000000o != null && fpq.f16876O000000o.isShowing()) {
            fpq.f16876O000000o.dismiss();
        }
    }
}
