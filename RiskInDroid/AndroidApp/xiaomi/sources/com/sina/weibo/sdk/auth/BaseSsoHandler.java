package com.sina.weibo.sdk.auth;

import _m_j.dbl;
import _m_j.dbm;
import _m_j.dbn;
import _m_j.dbt;
import _m_j.dbw;
import _m_j.dby;
import _m_j.dcc;
import _m_j.dch;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.web.WebRequestType;
import com.sina.weibo.sdk.web.WeiboSdkWebActivity;

public class BaseSsoHandler {
    protected final int SSO_TYPE_INVALID = 3;
    protected WbAuthListener authListener;
    protected Context mAuthActivity;
    protected int ssoRequestCode = -1;
    protected int ssoRequestType = 3;

    public enum AuthType {
        ALL,
        SsoOnly,
        WebOnly
    }

    /* access modifiers changed from: protected */
    public void fillExtraIntent(Intent intent, int i) {
    }

    public BaseSsoHandler(Activity activity) {
        this.mAuthActivity = activity;
        dbn.O000000o().O000000o(activity, WbSdk.getAuthInfo().getAppKey());
    }

    public BaseSsoHandler(Context context) {
        this.mAuthActivity = context;
        dbn.O000000o().O000000o(context, WbSdk.getAuthInfo().getAppKey());
    }

    public void authorize(WbAuthListener wbAuthListener) {
        authorize(32973, wbAuthListener, AuthType.ALL);
    }

    public void authorizeClientSso(WbAuthListener wbAuthListener) {
        authorize(32973, wbAuthListener, AuthType.SsoOnly);
    }

    public void authorizeWeb(WbAuthListener wbAuthListener) {
        authorize(32973, wbAuthListener, AuthType.WebOnly);
    }

    private void authorize(int i, WbAuthListener wbAuthListener, AuthType authType) {
        resetIntentFillData();
        if (wbAuthListener != null) {
            this.authListener = wbAuthListener;
            if (authType == AuthType.WebOnly) {
                startWebAuth();
                return;
            }
            boolean z = false;
            if (authType == AuthType.SsoOnly) {
                z = true;
            }
            WbAppInfo O000000o2 = dbm.O000000o(this.mAuthActivity).O000000o();
            if (isWbAppInstalled() && O000000o2 != null) {
                startClientAuth(i);
            } else if (z) {
                this.authListener.onFailure(new WbConnectErrorMessage());
            } else {
                startWebAuth();
            }
        } else {
            throw new RuntimeException("please set auth listener");
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0071, code lost:
        if (r4.authListener != null) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0073, code lost:
        r4.authListener.onFailure(new com.sina.weibo.sdk.auth.WbConnectErrorMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x006f */
    public void startClientAuth(int i) {
        try {
            WbAppInfo O000000o2 = dbm.O000000o(this.mAuthActivity).O000000o();
            Intent intent = new Intent();
            intent.setClassName(O000000o2.getPackageName(), O000000o2.getAuthActivityName());
            intent.putExtras(WbSdk.getAuthInfo().getAuthBundle());
            intent.putExtra("_weibo_command_type", 3);
            intent.putExtra("_weibo_transaction", String.valueOf(System.currentTimeMillis()));
            intent.putExtra("aid", dby.O00000Oo(this.mAuthActivity, WbSdk.getAuthInfo().getAppKey()));
            if (!dbw.O000000o(this.mAuthActivity, intent)) {
                this.authListener.onFailure(new WbConnectErrorMessage("your install weibo app is counterfeit", "8001"));
                return;
            }
            fillExtraIntent(intent, i);
            ((Activity) this.mAuthActivity).startActivityForResult(intent, this.ssoRequestCode);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void resetIntentFillData() {
        this.ssoRequestCode = 32973;
    }

    /* access modifiers changed from: protected */
    public void startWebAuth() {
        String str;
        AuthInfo authInfo = WbSdk.getAuthInfo();
        WeiboParameters weiboParameters = new WeiboParameters(authInfo.getAppKey());
        weiboParameters.put("client_id", authInfo.getAppKey());
        weiboParameters.put("redirect_uri", authInfo.getRedirectUrl());
        weiboParameters.put("scope", authInfo.getScope());
        weiboParameters.put("response_type", "code");
        weiboParameters.put("version", "0041005000");
        weiboParameters.put("luicode", "10000360");
        Oauth2AccessToken readAccessToken = AccessTokenKeeper.readAccessToken(this.mAuthActivity);
        if (readAccessToken != null && !TextUtils.isEmpty(readAccessToken.getToken())) {
            weiboParameters.put("trans_token", readAccessToken.getToken());
            weiboParameters.put("trans_access_token", readAccessToken.getToken());
        }
        weiboParameters.put("lfid", "OP_" + authInfo.getAppKey());
        String O00000Oo = dby.O00000Oo(this.mAuthActivity, authInfo.getAppKey());
        if (!TextUtils.isEmpty(O00000Oo)) {
            weiboParameters.put("aid", O00000Oo);
        }
        weiboParameters.put("packagename", authInfo.getPackageName());
        weiboParameters.put("key_hash", authInfo.getKeyHash());
        String str2 = "https://open.weibo.cn/oauth2/authorize?" + weiboParameters.encodeUrl();
        Context context = this.mAuthActivity;
        if (!(context == null || context.checkCallingOrSelfPermission("android.permission.INTERNET") == 0)) {
            Context context2 = this.mAuthActivity;
            if (context2 != null) {
                new AlertDialog.Builder(context2).setTitle("Error").setMessage("Application requires permission to access the Internet").create().show();
                return;
            }
            return;
        }
        if (this.authListener != null) {
            dcc O000000o2 = dcc.O000000o();
            String valueOf = String.valueOf(System.currentTimeMillis());
            O000000o2.O000000o(valueOf, this.authListener);
            str = valueOf;
        } else {
            str = null;
        }
        dch dch = new dch(authInfo, WebRequestType.AUTH, str, "微博登录", str2, this.mAuthActivity);
        Intent intent = new Intent(this.mAuthActivity, WeiboSdkWebActivity.class);
        Bundle bundle = new Bundle();
        dch.O00000o0(bundle);
        intent.putExtras(bundle);
        this.mAuthActivity.startActivity(intent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004c  */
    public void authorizeCallBack(int i, int i2, Intent intent) {
        boolean z;
        if (32973 != i) {
            return;
        }
        if (i2 == -1) {
            Context context = this.mAuthActivity;
            WbAppInfo O000000o2 = dbm.O000000o(context).O000000o();
            if ((O000000o2 == null || O000000o2.getSupportVersion() > 10352) && O000000o2 != null) {
                String stringExtra = intent != null ? intent.getStringExtra("_weibo_appPackage") : null;
                if (stringExtra == null || intent.getStringExtra("_weibo_transaction") == null || !dbl.O000000o(context, stringExtra)) {
                    z = false;
                    if (z) {
                        this.authListener.onFailure(new WbConnectErrorMessage("your install weibo app is counterfeit", "8001"));
                        return;
                    }
                    String O00000Oo = dby.O00000Oo(intent.getStringExtra("error"));
                    String O00000Oo2 = dby.O00000Oo(intent.getStringExtra("error_type"));
                    String O00000Oo3 = dby.O00000Oo(intent.getStringExtra("error_description"));
                    dbt.O000000o("BaseSsoHandler", "error: " + O00000Oo + ", error_type: " + O00000Oo2 + ", error_description: " + O00000Oo3);
                    if (TextUtils.isEmpty(O00000Oo) && TextUtils.isEmpty(O00000Oo2) && TextUtils.isEmpty(O00000Oo3)) {
                        Oauth2AccessToken parseAccessToken = Oauth2AccessToken.parseAccessToken(intent.getExtras());
                        if (parseAccessToken != null && parseAccessToken.isSessionValid()) {
                            dbt.O000000o("BaseSsoHandler", "Login Success! " + parseAccessToken.toString());
                            AccessTokenKeeper.writeAccessToken(this.mAuthActivity, parseAccessToken);
                            this.authListener.onSuccess(parseAccessToken);
                            return;
                        }
                        return;
                    } else if ("access_denied".equals(O00000Oo) || "OAuthAccessDeniedException".equals(O00000Oo)) {
                        dbt.O000000o("BaseSsoHandler", "Login canceled by user.");
                        this.authListener.cancel();
                        return;
                    } else {
                        dbt.O000000o("BaseSsoHandler", "Login failed: ".concat(String.valueOf(O00000Oo)));
                        this.authListener.onFailure(new WbConnectErrorMessage(O00000Oo2, O00000Oo3));
                        return;
                    }
                }
            }
            z = true;
            if (z) {
            }
        } else if (i2 == 0) {
            this.authListener.cancel();
        }
    }

    @Deprecated
    public boolean isWbAppInstalled() {
        return WbSdk.isWbInstall(this.mAuthActivity);
    }
}
