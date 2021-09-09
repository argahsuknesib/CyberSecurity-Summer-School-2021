package com.xiaomi.account.openid;

import android.app.Activity;
import android.webkit.ValueCallback;
import com.xiaomi.account.openauth.AccountAuth;

public interface OauthAccount extends AccountAuth {

    public interface LoginFinishedListener {
        void canceled();

        void onSuccess();
    }

    void getLoginStatus(ValueCallback<Boolean> valueCallback);

    void login(Activity activity, LoginFinishedListener loginFinishedListener);
}
