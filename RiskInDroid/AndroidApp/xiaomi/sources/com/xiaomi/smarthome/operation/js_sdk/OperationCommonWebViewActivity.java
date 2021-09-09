package com.xiaomi.smarthome.operation.js_sdk;

import _m_j.eyk;
import _m_j.gfr;
import _m_j.gsy;
import _m_j.hke;
import _m_j.hlp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.operation.js_sdk.base.BaseFragmentWebViewActivity;

@RouterService
public class OperationCommonWebViewActivity extends BaseFragmentWebViewActivity {
    public int getFragmentContainerId() {
        return R.id.container;
    }

    public static void start(Context context, String str, String str2) {
        Intent intent = new Intent(context, OperationCommonWebViewActivity.class);
        intent.putExtra("url", str);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("title", str2);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("url");
        if (isFullscreenRequested(stringExtra)) {
            getWindow().clearFlags(67108864);
        }
        gfr.O000O0OO = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("title");
        boolean z = false;
        boolean booleanExtra = getIntent().getBooleanExtra("args_from_deep_link", false);
        setContentView((int) R.layout.activity_operation_common_web_view);
        boolean booleanExtra2 = getIntent().getBooleanExtra("args_use_title_bar", true);
        if (!booleanExtra || (URLUtil.isHttpsUrl(stringExtra) && hlp.O00000Oo(stringExtra))) {
            if (booleanExtra2 && !isFullscreenRequested(stringExtra)) {
                z = true;
            }
            openNewWindow(null, hke.newInstance(stringExtra, stringExtra2, z));
            return;
        }
        gsy.O000000o(6, "OperationCommonWebView", "not valid url: ".concat(String.valueOf(stringExtra)));
        eyk.O000000o(this, stringExtra);
        finish();
    }
}
