package com.xiaomi.smarthome.camera.v4.activity;

import _m_j.gsy;
import _m_j.hke;
import _m_j.hkw;
import android.os.Bundle;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;

public class OpenNativeWebViewFragment extends hke {
    public static final String TAG = "com.xiaomi.smarthome.camera.v4.activity.OpenNativeWebViewFragment";

    public static OpenNativeWebViewFragment newInstance(String str, String str2, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("arg_url", str);
        bundle.putString("arg_title", str2);
        bundle.putBoolean("arg_use_title_bar", z);
        OpenNativeWebViewFragment openNativeWebViewFragment = new OpenNativeWebViewFragment();
        openNativeWebViewFragment.setArguments(bundle);
        return openNativeWebViewFragment;
    }

    public void init() {
        getWebView().O000000o(NativeUrlInterceptor.class.getSimpleName(), new NativeUrlInterceptor());
        super.init();
    }

    public OpenNativeBridge getBridge() {
        FragmentActivity activity = getActivity();
        if (activity instanceof OpenNativeBridge) {
            return (OpenNativeBridge) activity;
        }
        return null;
    }

    class NativeUrlInterceptor extends hkw {
        NativeUrlInterceptor() {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            gsy.O00000Oo(OpenNativeWebViewFragment.TAG, "cameratip shouldOverrideUrlLoading: ".concat(String.valueOf(str)));
            if (OpenNativeWebViewFragment.this.getBridge() != null) {
                return OpenNativeWebViewFragment.this.getBridge().tryOpenNative(str);
            }
            return false;
        }
    }
}
