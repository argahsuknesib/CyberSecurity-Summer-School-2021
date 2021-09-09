package com.xiaomi.smarthome.framework.navigate;

import _m_j.gpc;
import _m_j.hjp;
import android.net.Uri;
import android.os.Bundle;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.framework.page.CommonActivity;

@RouterService
public class ShopLauncherMiddle extends CommonActivity {
    public void onCreate(Bundle bundle) {
        gpc.O00000o(this);
        super.onCreate(bundle);
        Uri data = getIntent().getData();
        if (data != null) {
            hjp.O000000o(data.toString());
        }
        finish();
    }
}
