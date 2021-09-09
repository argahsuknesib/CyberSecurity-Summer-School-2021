package com.xiaomi.smarthome.miio.page.usrexpplan;

import _m_j.eyk;
import _m_j.gpc;
import _m_j.gsy;
import _m_j.gty;
import _m_j.gwc;
import _m_j.gwg;
import _m_j.gwi;
import _m_j.hyy;
import _m_j.ibh;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.CommonActivity;
import com.xiaomi.smarthome.framework.webview.SmartHomeWebView;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miio.activity.UserLicense;
import com.xiaomi.youpin.login.entity.Error;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class UsrExpPlanActivity extends CommonActivity {
    public Map<String, Long> mTokenRefreshTimeMap = new HashMap();
    public SmartHomeWebView mWebview;

    public void onCreate(Bundle bundle) {
        MiServiceTokenInfo O000000o2;
        gpc.O00000o(this);
        super.onCreate(bundle);
        gwg.O00000Oo(getWindow());
        setContentView((int) R.layout.activity_usr_exp_plan_layout);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.usrexpplan.UsrExpPlanActivity.AnonymousClass1 */

            public final void onClick(View view) {
                UsrExpPlanActivity.this.finish();
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.usr_exp_plan);
        getWindow().addFlags(524288);
        this.mWebview = (SmartHomeWebView) findViewById(R.id.usr_exp_plan_webview);
        this.mWebview.setWebViewClient(new WebViewClient() {
            /* class com.xiaomi.smarthome.miio.page.usrexpplan.UsrExpPlanActivity.AnonymousClass2 */

            public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                if (webResourceResponse.getStatusCode() == 401) {
                    UsrExpPlanActivity.this.handleReceiverAuthError(webResourceRequest.getUrl());
                }
            }

            public final void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (i == 401) {
                    UsrExpPlanActivity.this.handleReceiverAuthError(Uri.parse(str2));
                }
            }
        });
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("licenseContentUri");
            String stringExtra2 = intent.getStringExtra("usrExpPlanContentRnUri");
            if (!TextUtils.isEmpty(stringExtra2) && stringExtra2.startsWith("https://home.mi.com") && (O000000o2 = CoreApi.O000000o().O000000o("xiaomihome")) != null && !TextUtils.isEmpty(O000000o2.O00000o0)) {
                if (stringExtra2.contains("?")) {
                    stringExtra2 = stringExtra2 + "&auth=1";
                } else {
                    stringExtra2 = stringExtra2 + "?auth=1";
                }
            }
            try {
                Spanned spanned = (Spanned) getIntent().getCharSequenceExtra("usrExpPlanContent");
                if (!TextUtils.isEmpty(stringExtra2)) {
                    URI create = URI.create(stringExtra2);
                    String scheme = create.getScheme();
                    if (!"http".equals(scheme)) {
                        if (!"https".equals(scheme)) {
                            if ("file".equals(scheme)) {
                                stringExtra2 = create.getPath();
                            }
                            String O000000o3 = O000000o(stringExtra2);
                            if (O000000o3 != null) {
                                findViewById(R.id.usr_exp_plan_scrollview).setVisibility(8);
                                this.mWebview.loadDataWithBaseURL(null, O000000o3, "text/html", "charset=utf-8", null);
                                return;
                            }
                            return;
                        }
                    }
                    findViewById(R.id.usr_exp_plan_scrollview).setVisibility(8);
                    this.mWebview.loadUrl(stringExtra2);
                } else if (!TextUtils.isEmpty(stringExtra)) {
                    String O000000o4 = O000000o(stringExtra);
                    if (O000000o4 != null) {
                        this.mWebview.loadDataWithBaseURL(null, O000000o4, "text/html", "charset=utf-8", null);
                    }
                } else if (!TextUtils.isEmpty(spanned)) {
                    this.mWebview.setVisibility(8);
                    findViewById(R.id.usr_exp_plan_scrollview).setVisibility(0);
                    TextView textView = (TextView) findViewById(R.id.usr_exp_plan_info);
                    textView.setText(spanned);
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                } else {
                    eyk.O000000o(this, UserLicense.getUrlByTpye(UserLicense.TYPE_USER_EXPPLANN2));
                    finish();
                }
            } catch (Exception e) {
                e.printStackTrace();
                eyk.O000000o(this, UserLicense.getUrlByTpye(UserLicense.TYPE_USER_EXPPLANN2));
                finish();
            }
        } else {
            eyk.O000000o(this, UserLicense.getUrlByTpye(UserLicense.TYPE_USER_EXPPLANN2));
            finish();
        }
    }

    public void handleReceiverAuthError(Uri uri) {
        if (uri != null && !TextUtils.isEmpty(uri.getHost()) && uri.getHost().endsWith("home.mi.com")) {
            long currentTimeMillis = System.currentTimeMillis() - (this.mTokenRefreshTimeMap.containsKey("xiaomihome") ? this.mTokenRefreshTimeMap.get("xiaomihome").longValue() : 0);
            if (currentTimeMillis < DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS) {
                gsy.O00000o0(LogType.PLUGIN, "", "UsrExpPlanActivity,handleReceiverAuthError: refresh too frequent , refreshDiff = ".concat(String.valueOf(currentTimeMillis)));
                return;
            }
            gsy.O00000o0(LogType.PLUGIN, "", "UsrExpPlanActivity,handleReceiverAuthError:try to refresh token");
            gty.O000000o().refreshServiceToken("xiaomihome", new ibh<MiServiceTokenInfo, Error>() {
                /* class com.xiaomi.smarthome.miio.page.usrexpplan.UsrExpPlanActivity.AnonymousClass3 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    MiServiceTokenInfo miServiceTokenInfo = (MiServiceTokenInfo) obj;
                    if (miServiceTokenInfo == null) {
                        gsy.O00000o0(LogType.PLUGIN, "", "UsrExpPlanActivity refresh serviceToken xiaomihome, got no serviceToken!");
                        return;
                    }
                    MiServiceTokenInfo miServiceTokenInfo2 = new MiServiceTokenInfo();
                    miServiceTokenInfo2.O00000oo = miServiceTokenInfo.O00000oo;
                    miServiceTokenInfo2.O00000Oo = miServiceTokenInfo.O00000Oo;
                    miServiceTokenInfo2.O00000o0 = miServiceTokenInfo.O00000o0;
                    miServiceTokenInfo2.f12086O000000o = miServiceTokenInfo.f12086O000000o;
                    miServiceTokenInfo2.O00000o = miServiceTokenInfo.O00000o;
                    miServiceTokenInfo2.O00000oO = miServiceTokenInfo.O00000oO;
                    CoreApi.O000000o().O0000oOo().O000000o(miServiceTokenInfo2);
                    gsy.O00000o0(LogType.PLUGIN, "", "UsrExpPlanActivity,handleReceiverAuthError:token refreshed,try reload");
                    UsrExpPlanActivity.this.mWebview.O000000o();
                    if (!UsrExpPlanActivity.this.isFinishing()) {
                        UsrExpPlanActivity.this.mWebview.reload();
                    }
                    UsrExpPlanActivity.this.mTokenRefreshTimeMap.put("xiaomihome", Long.valueOf(System.currentTimeMillis()));
                }

                public final void onFailure(Error error) {
                    LogType logType = LogType.PLUGIN;
                    gsy.O00000o0(logType, "", "UsrExpPlanActivity refresh serviceToken xiaomihome, got error! " + error.toString());
                }
            });
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034 A[Catch:{ Exception -> 0x0049, all -> 0x0047 }, LOOP:0: B:11:0x002e->B:14:0x0034, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003e A[SYNTHETIC, Splitter:B:17:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0038 A[EDGE_INSN: B:38:0x0038->B:15:0x0038 ?: BREAK  , SYNTHETIC] */
    private static String O000000o(String str) {
        BufferedReader bufferedReader;
        StringBuilder sb;
        String readLine;
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }
        sb = new StringBuilder();
        while (true) {
            try {
                readLine = bufferedReader.readLine();
                if (readLine != null) {
                    break;
                }
                sb.append(readLine);
            } catch (Exception e3) {
                e3.printStackTrace();
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                return null;
            } catch (Throwable th) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        }
        String sb2 = sb.toString();
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e6) {
                e6.printStackTrace();
            }
        }
        return sb2;
        bufferedReader = null;
        sb = new StringBuilder();
        while (true) {
            readLine = bufferedReader.readLine();
            if (readLine != null) {
            }
            sb.append(readLine);
        }
        String sb22 = sb.toString();
        if (bufferedReader != null) {
        }
        return sb22;
    }

    public boolean isValid() {
        if (isFinishing()) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 17 || !isDestroyed()) {
            return true;
        }
        return false;
    }

    public void onContentChanged() {
        super.onContentChanged();
        if (hyy.O000000o(getIntent())) {
            gwg.O000000o(this, null, 0);
        } else {
            gwg.O00000o(this);
        }
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(gwc.O00000Oo(context));
    }

    public void onDestroy() {
        try {
            gwi.O000000o(this);
            gwi.O00000Oo(this);
            super.onDestroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onResume() {
        super.onResume();
        SmartHomeWebView smartHomeWebView = this.mWebview;
        if (smartHomeWebView != null) {
            smartHomeWebView.onResume();
        }
    }

    public void onPause() {
        super.onPause();
        SmartHomeWebView smartHomeWebView = this.mWebview;
        if (smartHomeWebView != null) {
            smartHomeWebView.onPause();
        }
    }
}
