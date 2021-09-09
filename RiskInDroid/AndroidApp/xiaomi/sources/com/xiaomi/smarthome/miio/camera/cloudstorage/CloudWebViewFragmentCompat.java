package com.xiaomi.smarthome.miio.camera.cloudstorage;

import _m_j.gsy;
import _m_j.hke;
import android.os.Bundle;
import com.xiaomi.smarthome.operation.js_sdk.base.CommonWebView;

public class CloudWebViewFragmentCompat extends hke {
    public static CloudWebViewFragmentCompat newInstance(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("arg_url", str);
        bundle.putString("arg_title", str2);
        bundle.putBoolean("arg_use_title_bar", true);
        bundle.putString("arg_did", str3);
        CloudWebViewFragmentCompat cloudWebViewFragmentCompat = new CloudWebViewFragmentCompat();
        cloudWebViewFragmentCompat.setArguments(bundle);
        return cloudWebViewFragmentCompat;
    }

    public void init() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("arg_did");
            CommonWebView webView = getWebView();
            if (webView == null) {
                gsy.O00000Oo("CloudWebViewFragmentCom", "onViewCreated: webView is null on webView#setDid");
                return;
            }
            webView.setDid(string);
        }
        super.init();
    }
}
