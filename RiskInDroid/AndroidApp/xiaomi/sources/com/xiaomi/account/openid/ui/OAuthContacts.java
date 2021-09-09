package com.xiaomi.account.openid.ui;

import android.os.Bundle;
import com.xiaomi.account.openid.OauthAccount;
import java.util.Map;

public class OAuthContacts {

    interface Presenter {
    }

    interface View {
        void loadUrl(String str);

        void login(OauthAccount oauthAccount);

        void setCookie(Map<String, String> map);

        void setResultAndFinish(int i, Bundle bundle);

        void showProgress();
    }
}
