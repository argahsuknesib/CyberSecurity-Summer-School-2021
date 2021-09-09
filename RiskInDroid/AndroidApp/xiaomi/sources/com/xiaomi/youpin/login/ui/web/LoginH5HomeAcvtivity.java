package com.xiaomi.youpin.login.ui.web;

import _m_j.ft;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.CookieManager;
import java.util.HashMap;
import java.util.Map;

public class LoginH5HomeAcvtivity extends LoginAutoLoginBaseActivity {
    @SuppressLint({"HandlerLeak"})
    public Handler mCookieCheckHandler = new Handler() {
        /* class com.xiaomi.youpin.login.ui.web.LoginH5HomeAcvtivity.AnonymousClass1 */

        public final void handleMessage(Message message) {
            if (message.what == 100) {
                LoginH5HomeAcvtivity.this.mCookieCheckHandler.sendEmptyMessageDelayed(100, 1000);
                Map<String, String> cookieAsMap = LoginH5HomeAcvtivity.getCookieAsMap("https://account.xiaomi.com");
                if (cookieAsMap != null && !cookieAsMap.isEmpty()) {
                    String str = cookieAsMap.get("passInfo");
                    if (!TextUtils.isEmpty(str) && str.contains("need-relogin")) {
                        ft.O000000o(LoginH5HomeAcvtivity.this.O00000o0.getApplicationContext()).O000000o(new Intent("login_need_relogin"));
                        LoginH5HomeAcvtivity.this.finish();
                    }
                }
            }
        }
    };

    public static Map<String, String> getCookieAsMap(String str) {
        String cookie = CookieManager.getInstance().getCookie(str);
        if (TextUtils.isEmpty(cookie)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String split : cookie.split(";")) {
            String[] split2 = split.split("=");
            if (split2.length > 1) {
                hashMap.put(split2[0].trim(), split2[1].trim());
            }
        }
        return hashMap;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.O0000Oo.setOnCloseClickListener(new View.OnClickListener() {
            /* class com.xiaomi.youpin.login.ui.web.LoginH5HomeAcvtivity.AnonymousClass2 */

            public final void onClick(View view) {
                LoginH5HomeAcvtivity.this.finish();
            }
        });
    }

    public void onResume() {
        super.onResume();
        this.mCookieCheckHandler.sendEmptyMessageDelayed(100, 1000);
    }

    public void onPause() {
        this.mCookieCheckHandler.removeMessages(100);
        super.onPause();
    }

    public void onDestroy() {
        this.mCookieCheckHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}
