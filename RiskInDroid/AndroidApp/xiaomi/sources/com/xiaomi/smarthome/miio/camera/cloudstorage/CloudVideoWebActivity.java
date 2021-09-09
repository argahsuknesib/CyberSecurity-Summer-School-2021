package com.xiaomi.smarthome.miio.camera.cloudstorage;

import _m_j.cki;
import _m_j.gsy;
import _m_j.hkh;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.operation.js_sdk.base.BaseFragmentWebViewActivity;
import com.xiaomi.smarthome.operation.js_sdk.base.CommonWebView;
import org.json.JSONException;
import org.json.JSONObject;

public class CloudVideoWebActivity extends BaseFragmentWebViewActivity {
    private String mDid;

    public int getFragmentContainerId() {
        return R.id.container;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.cs_web_activity);
        String stringExtra = getIntent().getStringExtra("url");
        String stringExtra2 = getIntent().getStringExtra("title");
        hkh.O00000o0 = getIntent().getBooleanExtra("is_hs_panorama_video", false);
        this.mDid = getIntent().getStringExtra("did");
        if (!TextUtils.isEmpty(stringExtra)) {
            openNewWindow(null, CloudWebViewFragmentCompat.newInstance(stringExtra, stringExtra2, this.mDid));
        } else {
            finish();
        }
    }

    public void onStart() {
        super.onStart();
        try {
            if (((ActivityManager) getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getClassName().startsWith("com.mibi")) {
                Intent intent = new Intent(this, CloudVideoWebActivity.class);
                intent.addFlags(603979776);
                startActivity(intent);
            }
        } catch (Exception e) {
            cki.O00000o("CloudVideoWebActivity", "Exception:" + e.getLocalizedMessage());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        handlePaymentResult(i, i2, intent);
    }

    private void reloadWebView() {
        try {
            CommonWebView webView = getLatestFragment().getWebView();
            webView.setDid(this.mDid);
            webView.O000000o();
            webView.reload();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handlePaymentResult(int i, int i2, Intent intent) {
        ServerBean O0000ooO;
        if (CoreApi.O000000o().O0000O0o() && CoreApi.O000000o().O0000ooO() != null && (O0000ooO = CoreApi.O000000o().O0000ooO()) != null && !TextUtils.isEmpty(O0000ooO.O00000Oo)) {
            if (O0000ooO.O00000Oo.equalsIgnoreCase("in")) {
                handleIndiaPaymentResult(i, i2, intent);
            } else if (O0000ooO.O00000Oo.equalsIgnoreCase("cn")) {
                handleChinaMainlandPaymentResult(i, i2, intent);
            }
        }
    }

    private void handleIndiaPaymentResult(int i, int i2, Intent intent) {
        LogType logType = LogType.CAMERA;
        gsy.O00000o0(logType, "CloudVideoWebActivity", "handleIndiaPaymentResult requestCode:" + i + " resultCode:" + i2);
        if (i2 == -1) {
            if (intent == null) {
                gsy.O00000o0(LogType.CAMERA, "CloudVideoWebActivity", "Intent data null");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(intent.getStringExtra("returnData"));
                jSONObject.getString("txnId");
                jSONObject.getString("status");
                jSONObject.getString("returnUrl");
                finish();
            } catch (JSONException e) {
                reloadWebView();
                LogType logType2 = LogType.CAMERA;
                gsy.O000000o(logType2, "CloudVideoWebActivity", "JSONException:" + e.getLocalizedMessage());
            }
        } else if (i2 == 0) {
            reloadWebView();
            gsy.O00000Oo("CloudVideoWebActivity", "India pay canceled resultCode = ".concat(String.valueOf(i2)));
        }
    }

    private void handleChinaMainlandPaymentResult(int i, int i2, Intent intent) {
        LogType logType = LogType.CAMERA;
        gsy.O00000o0(logType, "CloudVideoWebActivity", "handleChinaMainlandPaymentResult requestCode:" + i + " resultCode:" + i2);
        if (i == 100) {
            gsy.O000000o(4, "CloudVideoWebActivity", "requestCode:100 , resultCode:".concat(String.valueOf(i2)));
            if (i2 == -1) {
                gsy.O00000Oo("CloudVideoWebActivity", "pay success");
                finish();
            } else if (i2 == 0) {
                reloadWebView();
                gsy.O00000Oo("CloudVideoWebActivity", "pay canceled resultCode = ".concat(String.valueOf(i2)));
            } else {
                reloadWebView();
                gsy.O00000Oo("CloudVideoWebActivity", "pay failed resultCode = ".concat(String.valueOf(i2)));
            }
        } else if (i == 201) {
            gsy.O000000o(4, "CloudVideoWebActivity", "requestCode:201 , resultCode:".concat(String.valueOf(i2)));
            if (i2 == -1) {
                gsy.O00000Oo("CloudVideoWebActivity", "sign deduct success");
                finish();
            } else if (i2 == 0) {
                reloadWebView();
                gsy.O00000Oo("CloudVideoWebActivity", "sign deduct canceled resultCode = ".concat(String.valueOf(i2)));
            } else {
                reloadWebView();
                gsy.O00000Oo("CloudVideoWebActivity", "sign deduct failed resultCode = ".concat(String.valueOf(i2)));
            }
        }
    }
}
