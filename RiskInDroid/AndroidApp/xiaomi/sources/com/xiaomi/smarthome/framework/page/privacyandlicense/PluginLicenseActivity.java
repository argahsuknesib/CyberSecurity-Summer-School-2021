package com.xiaomi.smarthome.framework.page.privacyandlicense;

import _m_j.gpg;
import _m_j.gsy;
import _m_j.gty;
import _m_j.ibh;
import android.content.Intent;
import android.net.Uri;
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
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.webview.SmartHomeWebView;
import com.xiaomi.smarthome.library.log.LogType;
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

public class PluginLicenseActivity extends BaseActivity {
    public Map<String, Long> mTokenRefreshTimeMap = new HashMap();
    public SmartHomeWebView mWebView;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(R.anim.activity_slide_in_right, R.anim.activity_slide_out_left);
        setContentView((int) R.layout.activity_plugin_license);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.privacyandlicense.PluginLicenseActivity.AnonymousClass1 */

            public final void onClick(View view) {
                PluginLicenseActivity.this.finish();
            }
        });
        this.mWebView = (SmartHomeWebView) findViewById(R.id.user_license_info_web);
        this.mWebView.setWebViewClient(new WebViewClient() {
            /* class com.xiaomi.smarthome.framework.page.privacyandlicense.PluginLicenseActivity.AnonymousClass3 */

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (intent.resolveActivity(PluginLicenseActivity.this.getPackageManager()) == null) {
                    return true;
                }
                PluginLicenseActivity.this.startActivity(intent);
                return true;
            }

            public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                if (webResourceResponse.getStatusCode() == 401) {
                    PluginLicenseActivity.this.handleReceiverAuthError(webResourceRequest.getUrl());
                }
            }

            public final void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (i == 401) {
                    PluginLicenseActivity.this.handleReceiverAuthError(Uri.parse(str2));
                }
            }
        });
        MiServiceTokenInfo O000000o2 = CoreApi.O000000o().O000000o("xiaomihome");
        if (O000000o2 == null || TextUtils.isEmpty(O000000o2.O00000o0)) {
            showProgressDialog(getString(R.string.loading_share_info));
            gty.O000000o().refreshServiceToken("xiaomihome", new ibh<MiServiceTokenInfo, Error>() {
                /* class com.xiaomi.smarthome.framework.page.privacyandlicense.PluginLicenseActivity.AnonymousClass2 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    MiServiceTokenInfo miServiceTokenInfo = (MiServiceTokenInfo) obj;
                    if (miServiceTokenInfo == null) {
                        gsy.O00000o0(LogType.PLUGIN, "", "PluginLicenseActivity refresh serviceToken xiaomihome, got no serviceToken!");
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
                    PluginLicenseActivity.this.dismissProgressDialog();
                    PluginLicenseActivity.this.showContent();
                }

                public final void onFailure(Error error) {
                    LogType logType = LogType.PLUGIN;
                    gsy.O00000o0(logType, "", "PluginLicenseActivity refresh serviceToken xiaomihome, got error! " + error.toString());
                    PluginLicenseActivity.this.dismissProgressDialog();
                }
            });
            return;
        }
        showContent();
    }

    public void showContent() {
        MiServiceTokenInfo O000000o2;
        TextView textView = (TextView) findViewById(R.id.user_license_info);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText(getIntent().getStringExtra("title"));
        Spanned spanned = (Spanned) getIntent().getCharSequenceExtra("license_content");
        String stringExtra = getIntent().getStringExtra("license_uri");
        String stringExtra2 = getIntent().getStringExtra("license_html_content");
        int intExtra = getIntent().getIntExtra("license_html_content_res", -1);
        if (!TextUtils.isEmpty(stringExtra) && stringExtra.startsWith("https://home.mi.com") && (O000000o2 = CoreApi.O000000o().O000000o("xiaomihome")) != null && !TextUtils.isEmpty(O000000o2.O00000o0)) {
            if (stringExtra.contains("?")) {
                stringExtra = stringExtra + "&auth=1";
            } else {
                stringExtra = stringExtra + "?auth=1";
            }
        }
        if (!TextUtils.isEmpty(stringExtra2)) {
            findViewById(R.id.user_license).setVisibility(8);
            this.mWebView.loadDataWithBaseURL(null, stringExtra2, "text/html", "charset=utf-8", null);
        } else if (stringExtra != null) {
            URI create = URI.create(stringExtra);
            String scheme = create.getScheme();
            if ("http".equals(scheme) || "https".equals(scheme)) {
                findViewById(R.id.user_license).setVisibility(8);
                this.mWebView.loadUrl(stringExtra);
                return;
            }
            if ("file".equals(scheme)) {
                stringExtra = create.getPath();
            }
            String O000000o3 = O000000o(stringExtra);
            if (O000000o3 != null) {
                findViewById(R.id.user_license).setVisibility(8);
                this.mWebView.loadDataWithBaseURL(null, O000000o3, "text/html", "charset=utf-8", null);
            }
        } else if (spanned != null) {
            this.mWebView.setVisibility(8);
            textView.setText(spanned);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        } else if (intExtra > 0) {
            this.mWebView.setVisibility(0);
            findViewById(R.id.user_license).setVisibility(8);
            this.mWebView.loadDataWithBaseURL(null, gpg.O000000o(getResources(), intExtra), "text/html", "charset=utf-8", null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034 A[Catch:{ Exception -> 0x004e, all -> 0x004c }, LOOP:0: B:11:0x002e->B:14:0x0034, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043 A[SYNTHETIC, Splitter:B:17:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x003d A[EDGE_INSN: B:38:0x003d->B:15:0x003d ?: BREAK  , SYNTHETIC] */
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
                sb.append("\r\n");
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
            sb.append("\r\n");
        }
        String sb22 = sb.toString();
        if (bufferedReader != null) {
        }
        return sb22;
    }

    public void handleReceiverAuthError(Uri uri) {
        if (uri != null && !TextUtils.isEmpty(uri.getHost()) && uri.getHost().endsWith("home.mi.com")) {
            long currentTimeMillis = System.currentTimeMillis() - (this.mTokenRefreshTimeMap.containsKey("xiaomihome") ? this.mTokenRefreshTimeMap.get("xiaomihome").longValue() : 0);
            if (currentTimeMillis < DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS) {
                gsy.O00000o0(LogType.PLUGIN, "", "PluginLicenseActivity,handleReceiverAuthError: refresh too frequent , refreshDiff = ".concat(String.valueOf(currentTimeMillis)));
                return;
            }
            gsy.O00000o0(LogType.PLUGIN, "", "PluginLicenseActivity,handleReceiverAuthError:try to refresh token");
            gty.O000000o().refreshServiceToken("xiaomihome", new ibh<MiServiceTokenInfo, Error>() {
                /* class com.xiaomi.smarthome.framework.page.privacyandlicense.PluginLicenseActivity.AnonymousClass4 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    MiServiceTokenInfo miServiceTokenInfo = (MiServiceTokenInfo) obj;
                    if (miServiceTokenInfo == null) {
                        gsy.O00000o0(LogType.PLUGIN, "", "PluginLicenseActivity refresh serviceToken xiaomihome, got no serviceToken!");
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
                    gsy.O00000o0(LogType.PLUGIN, "", "PluginLicenseActivity,handleReceiverAuthError:token refreshed,try reload");
                    PluginLicenseActivity.this.mWebView.O000000o();
                    if (!PluginLicenseActivity.this.isFinishing()) {
                        PluginLicenseActivity.this.mWebView.reload();
                    }
                    PluginLicenseActivity.this.mTokenRefreshTimeMap.put("xiaomihome", Long.valueOf(System.currentTimeMillis()));
                }

                public final void onFailure(Error error) {
                    LogType logType = LogType.PLUGIN;
                    gsy.O00000o0(logType, "", "PluginLicenseActivity refresh serviceToken xiaomihome, got error! " + error.toString());
                }
            });
        }
    }

    public void onResume() {
        super.onResume();
        SmartHomeWebView smartHomeWebView = this.mWebView;
        if (smartHomeWebView != null) {
            smartHomeWebView.onResume();
        }
    }

    public void onPause() {
        super.onPause();
        SmartHomeWebView smartHomeWebView = this.mWebView;
        if (smartHomeWebView != null) {
            smartHomeWebView.onPause();
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_slide_in_left, R.anim.activity_slide_out_right);
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
