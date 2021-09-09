package com.sdu.didi.openapi;

import _m_j.dat;
import _m_j.dau;
import _m_j.dax;
import _m_j.day;
import _m_j.daz;
import _m_j.dbc;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;
import com.sdu.didi.openapi.DIOpenSDK;
import com.sdu.didi.openapi.DiDiWebActivity;
import com.sdu.didi.openapi.pK.a;
import com.sdu.didi.openapi.ss.b;
import com.sdu.didi.openapi.ss.d;
import com.sdu.didi.openapi.utils.Utils;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

public class DiDiWebActivity extends Activity {

    /* renamed from: O000000o  reason: collision with root package name */
    private d f5595O000000o;
    /* access modifiers changed from: private */
    public WebView O00000Oo;
    /* access modifiers changed from: private */
    public dax O00000o;
    /* access modifiers changed from: private */
    public dbc O00000o0;
    private O000000o O00000oO;
    private ArrayList<AsyncTask> O00000oo;
    private View O0000O0o;
    /* access modifiers changed from: private */
    public TextView O0000OOo;
    /* access modifiers changed from: private */
    public boolean O0000Oo0 = false;

    private void O000000o() {
        O000000o o000000o = this.O00000oO;
        if (o000000o != null) {
            o000000o.cancel(true);
            this.O00000oO = null;
        }
        this.O00000oO = new O000000o();
        if (Utils.O000000o()) {
            this.O00000oO.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            this.O00000oO.execute(new Void[0]);
        }
        this.O00000oo.add(this.O00000oO);
        super.onStart();
    }

    @Deprecated
    public static void registerApp(Context context, String str, String str2) {
        DIOpenSDK.registerApp(context, str, str2);
    }

    @Deprecated
    public static void setMapSdkType(DIOpenSDK.MapLocationType mapLocationType) {
        DIOpenSDK.setMapSdkType(mapLocationType);
    }

    @Deprecated
    public static void showDDPage(Context context, HashMap<String, String> hashMap) {
        DIOpenSDK.showDDPage(context, hashMap);
    }

    public void onBackPressed() {
        View view = this.O0000O0o;
        if (view != null) {
            view.performClick();
        } else {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        ArrayList<AsyncTask> arrayList = this.O00000oo;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<AsyncTask> it = this.O00000oo.iterator();
            while (it.hasNext()) {
                it.next().cancel(true);
            }
        }
        WebView webView = this.O00000Oo;
        if (webView != null) {
            ((ViewGroup) webView.getParent()).removeView(this.O00000Oo);
            this.O00000Oo.destroy();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        if (Build.VERSION.SDK_INT >= 11) {
            this.O00000Oo.onPause();
        }
        super.onPause();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr != null && iArr.length != 0 && i == 10010) {
            int length = iArr.length;
            boolean z = false;
            for (int i2 = 0; i2 < length; i2++) {
                z = iArr[i2] == -1;
                if (z) {
                    break;
                }
            }
            if (z) {
                Toast.makeText(this, "请给予程序必要的权限", 1).show();
                finish();
                return;
            }
            O000000o();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        if (Build.VERSION.SDK_INT >= 11) {
            this.O00000Oo.onResume();
        }
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        this.O0000Oo0 = true;
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            int checkSelfPermission = checkSelfPermission("android.permission.ACCESS_FINE_LOCATION");
            int checkSelfPermission2 = checkSelfPermission("android.permission.READ_PHONE_STATE");
            int checkSelfPermission3 = checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
            if (checkSelfPermission == -1) {
                arrayList.add("android.permission.ACCESS_FINE_LOCATION");
            }
            if (checkSelfPermission2 == -1) {
                arrayList.add("android.permission.READ_PHONE_STATE");
            }
            if (checkSelfPermission3 == -1) {
                arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
            }
            if (!arrayList.isEmpty()) {
                requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), 10010);
                super.onStart();
            }
        }
        O000000o();
        super.onStart();
    }

    class O000000o extends AsyncTask<Void, Void, String> {

        /* renamed from: O000000o  reason: collision with root package name */
        a f5600O000000o;

        O000000o() {
        }

        /* access modifiers changed from: protected */
        public final void onPreExecute() {
            if (!isCancelled()) {
                this.f5600O000000o = new a(DiDiWebActivity.this);
                this.f5600O000000o.setTitle("正在载入滴滴出行");
                this.f5600O000000o.setCancelable(false);
                this.f5600O000000o.show();
            }
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onCancelled(Object obj) {
            a aVar = this.f5600O000000o;
            if (aVar != null) {
                aVar.dismiss();
            }
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            String str = (String) obj;
            a aVar = this.f5600O000000o;
            if (aVar != null && aVar.isShowing()) {
                this.f5600O000000o.dismiss();
            }
            WebView O000000o2 = DiDiWebActivity.this.O00000Oo;
            if (TextUtils.isEmpty(str)) {
                str = Uri.parse("https://static.udache.com/gulfstream/webapp/pages/sdk/error.html").buildUpon().appendQueryParameter("errorcode", "1001").toString();
            }
            O000000o2.loadUrl(str);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            a aVar;
            if (!isCancelled() || (aVar = this.f5600O000000o) == null) {
                HashMap hashMap = (HashMap) DiDiWebActivity.this.getIntent().getSerializableExtra("params");
                if (hashMap == null || !hashMap.containsKey("special_url")) {
                    dax unused = DiDiWebActivity.this.O00000o = dau.O000000o().O000000o(DiDiWebActivity.this);
                    if (!DiDiWebActivity.this.O00000o.O000000o()) {
                        return Uri.parse("https://static.udache.com/gulfstream/webapp/pages/sdk/error.html").buildUpon().appendQueryParameter("errorcode", "1001").toString();
                    }
                    if (TextUtils.isEmpty(dat.O000000o().O000000o(DiDiWebActivity.this))) {
                        return Uri.parse("https://static.udache.com/gulfstream/webapp/pages/sdk/error.html").buildUpon().appendQueryParameter("errorcode", "1001").toString();
                    }
                    hashMap.put("openid", DiDiWebActivity.this.O00000o.f14425O000000o);
                    String O000000o2 = daz.O000000o().O000000o("https://api.xiaojukeji.com/v1/permit/pGetConfig", hashMap);
                    if (TextUtils.isEmpty(O000000o2)) {
                        return "";
                    }
                    day day = new day();
                    day.O000000o(O000000o2);
                    String str = day.f14426O000000o;
                    if (TextUtils.isEmpty(str)) {
                        return "";
                    }
                    Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                    buildUpon.appendQueryParameter("openid", DiDiWebActivity.this.O00000o.f14425O000000o);
                    buildUpon.appendQueryParameter("channel", DiDiWebActivity.this.O00000o.O00000Oo);
                    String timestamp = Utils.getTimestamp();
                    buildUpon.appendQueryParameter("timestamp", timestamp);
                    StringBuilder sb = new StringBuilder();
                    DIOpenSDK instance = DIOpenSDK.getInstance();
                    sb.append(instance.getSDKSign(DiDiWebActivity.this.O00000o.f14425O000000o + DIOpenSDK.getSecrectStr(DiDiWebActivity.this.getBaseContext()) + DiDiWebActivity.this.O00000o.O00000Oo));
                    sb.append(timestamp);
                    buildUpon.appendQueryParameter("sign", sb.toString());
                    if (hashMap != null) {
                        for (Map.Entry entry : hashMap.entrySet()) {
                            buildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
                        }
                    }
                    return buildUpon.build().toString();
                }
                Uri.Builder buildUpon2 = Uri.parse((String) hashMap.get("special_url")).buildUpon();
                for (Map.Entry entry2 : hashMap.entrySet()) {
                    buildUpon2.appendQueryParameter((String) entry2.getKey(), (String) entry2.getValue());
                }
                return buildUpon2.build().toString();
            }
            aVar.dismiss();
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5595O000000o = new d(this);
        d dVar = this.f5595O000000o;
        int identifier = dVar.O00000Oo.getIdentifier("activity_di_di_web", "layout", dVar.f5606O000000o.getPackageName());
        if (identifier != 0) {
            setContentView(identifier);
            this.O00000Oo = (WebView) findViewById(this.f5595O000000o.O000000o("didi_webview"));
            if (Build.VERSION.SDK_INT > 10 && Build.VERSION.SDK_INT < 17) {
                this.O00000Oo.removeJavascriptInterface("searchBoxJavaBridge_");
            }
            this.O0000O0o = findViewById(this.f5595O000000o.O000000o("didi_toolbar_back"));
            this.O0000OOo = (TextView) findViewById(this.f5595O000000o.O000000o("didi_webview_title"));
            this.O0000O0o.setOnClickListener(new View.OnClickListener() {
                /* class com.sdu.didi.openapi.DiDiWebActivity.AnonymousClass1 */

                public final void onClick(View view) {
                    if (DiDiWebActivity.this.O00000Oo == null || !DiDiWebActivity.this.O00000Oo.canGoBack()) {
                        DiDiWebActivity.this.finish();
                    } else {
                        DiDiWebActivity.this.O00000Oo.goBack();
                    }
                }
            });
            this.O00000o0 = new dbc(this.O00000Oo);
            this.O00000oo = new ArrayList<>();
            this.O00000o0.f14431O000000o = this.O00000oo;
            this.O00000Oo.setWebChromeClient(new WebChromeClient() {
                /* class com.sdu.didi.openapi.DiDiWebActivity.AnonymousClass2 */

                public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                    new b(webView.getContext()).O000000o(str2);
                    jsResult.confirm();
                    return true;
                }

                public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                    jsPromptResult.confirm("prompt ok");
                    dbc O00000Oo = DiDiWebActivity.this.O00000o0;
                    dbc.AnonymousClass1 r6 = new AsyncTask<String, Void, String>(DiDiWebActivity.this) {
                        /* class _m_j.dbc.AnonymousClass1 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ DiDiWebActivity f14432O000000o;

                        {
                            this.f14432O000000o = r2;
                        }

                        /* access modifiers changed from: protected */
                        public final /* synthetic */ void onPostExecute(Object obj) {
                            String str = (String) obj;
                            if (!str.equals("success")) {
                                dbd.O000000o("jscalljava", str);
                                dbc.this.f14431O000000o.remove(this);
                                if (TextUtils.isEmpty(str)) {
                                    dbd.O000000o("processRequest", "onPostExecute return null");
                                    return;
                                }
                                dbc.this.O00000Oo.loadUrl(String.format("javascript:window.didi&&window.didi.sdk&&window.didi.sdk._callback(%s);", str));
                            }
                        }

                        /* access modifiers changed from: protected */
                        public final /* synthetic */ Object doInBackground(Object[] objArr) {
                            String[] strArr = (String[]) objArr;
                            return (strArr == null || strArr.length == 0 || isCancelled()) ? "" : dba.O000000o(strArr[0], this.f14432O000000o);
                        }
                    };
                    if (Utils.O000000o()) {
                        r6.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, str2);
                    } else {
                        r6.execute(str2);
                    }
                    O00000Oo.f14431O000000o.add(r6);
                    return true;
                }
            });
            this.O00000Oo.setWebViewClient(new WebViewClient() {
                /* class com.sdu.didi.openapi.DiDiWebActivity.AnonymousClass3 */

                public final void onPageFinished(WebView webView, String str) {
                    super.onPageFinished(webView, str);
                    if (DiDiWebActivity.this.O0000Oo0) {
                        webView.clearHistory();
                        boolean unused = DiDiWebActivity.this.O0000Oo0 = false;
                    }
                    if (DiDiWebActivity.this.O0000OOo != null && webView != null) {
                        String title = webView.getTitle();
                        TextView O00000oO = DiDiWebActivity.this.O0000OOo;
                        if (!Pattern.compile("[\\u4e00-\\u9fa5]").matcher(TextUtils.isEmpty(title) ? "" : title).find()) {
                            title = "滴滴出行";
                        }
                        O00000oO.setText(title);
                    }
                }

                public final void onReceivedError(WebView webView, int i, String str, String str2) {
                    WebView O000000o2 = DiDiWebActivity.this.O00000Oo;
                    O000000o2.loadDataWithBaseURL("", "<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><title>暂时无法使用滴滴出行</title><meta name=\"viewport\" content=\"width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no\"><meta name=\"apple-mobile-web-app-capable\" content=\"yes\"><style>html,body{position:relative;height:100%;width:100%;padding:0;margin:0;background:#fafafa}body{-webkit-user-select:none;-webkit-text-size-adjust:100%!important;background-color:#fafafa;font-size-adjust:none;text-align:center;margin:0 auto;font-family:'Microsoft YaHei',arial,sans-serif,'Droid Sans Fallback'}#main{padding:0;width:100%;margin:0}section{padding:10px 0}.icon{display:block;width:60px;height:60px;border-radius:30px;overflow:hidden;margin-top:100px;margin:20% auto 10px auto;background-size:auto 60px}.h1{max-height:25px;padding:5px 0;line-height:20px;font-size:17px;color:#333}.h3{line-height:20px;font-size:12px;color:#999;word-break:break-all;max-height:80px;overflow:hidden;text-overflow:ellipsis;padding:0 20px}.btn{display:inline-block;height:30px;line-height:30px;border:1px solid #ccc;padding:0 15px;border-radius:3px;color:#888;background:#fcfcfc}</style></head><body><div class=\"main\" id=\"main\"><section id=\"main-page\"><div class=\"icon\"><img widht=\"60\" height=\"60\" src=\"data:image/gif;base64,R0lGODlheAB4AKIAAP////39/fz8/O/v79TU1NPT08zMzAAAACwAAAAAeAB4AAAD/2i63P4wykmrvTjrzbv/YCiOZGmeaKqubOu+cCzPdG3feK7vfO//wKBwSCwaj8ikcslsOp/QqHRKrVqv2Kx2y+0qCgOBYFDwjggCgBogIJhDg/V68Aal5YBA/YNf7z19an8dgQCDHIWHG4mKGYyNF4+QFZKTE5WWEZiZD5ucDZ6fC6GiBqSip5+pnKuZrZavk7GQs421ireHuYO7f717v3XBb8NmxV7HXclcy1vNWs9Z0VjTV9VW11XZVHdyeqUQcXh04A9ocm3lEARhY27q8PHy8z1gYmT0Cudr6fTicuTmdVvzTWCfgvL+zcm3T00/euzuvctHsaLFixgzatzIsRijx48gQ4ocSbKkyZMoU6pcybKly5cGEgAAOw==\"></div><p class=\"h1 center\"></p><p class=\"h3 center\"></p><span class=\"btn\">重试</span></section></div><script>!function(){\"use strict\";var t=function(t){return document.querySelector(t)},e=function(t){for(var e,n={},r=window.location.search.replace(/^\\?/,\"\").split(\"&\"),o=r.length,i=0;o>i;i++)r[i]&&(e=r[i].split(\"=\"),n[decodeURIComponent(e[0])]=decodeURIComponent(r[i].substr(e[0].length+1)));return n[t]||\"\"},n=t(\".h1\"),r=t(\".h3\"),o={404:{title:\"暂时无法展示此页面[404]\"},500:{title:\"暂时无法展示此页面[500]\"}},i=\"" + str + "\",c=e(\"status\")||e(\"errno\")||e(\"errstatus\"),s=\"" + str2 + "\";c&&o[c]&&(i=o[c].title),n.innerHTML=i,s&&(r.innerHTML=s||\"\"),t(\".btn\").addEventListener(\"touchend\",function(){s?window.location.replace(s):window.history.back()})}();</script></body></html>", "text/html", "UTF-8", null);
                    if (!URLUtil.isHttpUrl(DiDiWebActivity.this.O00000Oo.getUrl()) || !URLUtil.isHttpsUrl(DiDiWebActivity.this.O00000Oo.getUrl())) {
                        DiDiWebActivity.this.O00000Oo.clearHistory();
                    }
                }

                /* JADX WARNING: Removed duplicated region for block: B:37:0x009a A[Catch:{ Exception -> 0x00b6 }] */
                /* JADX WARNING: Removed duplicated region for block: B:42:0x00a7 A[Catch:{ Exception -> 0x00b6 }] */
                public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    try {
                        String scheme = URI.create(str).getScheme();
                        char c = 0;
                        if (!scheme.equals("weixin")) {
                            if (!scheme.equals("alipays")) {
                                if (!scheme.equals("didipasnger")) {
                                    if (!scheme.equals("tel")) {
                                        return false;
                                    }
                                    Intent intent = new Intent();
                                    intent.setAction("android.intent.action.DIAL");
                                    intent.setData(Uri.parse(str));
                                    DiDiWebActivity.this.startActivity(intent);
                                    return true;
                                }
                            }
                        }
                        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                        if (intent2.resolveActivity(DiDiWebActivity.this.getPackageManager()) != null) {
                            DiDiWebActivity.this.startActivity(intent2);
                        } else {
                            Uri.Builder buildUpon = Uri.parse("https://static.udache.com/gulfstream/webapp/pages/sdk/error.html").buildUpon();
                            int hashCode = scheme.hashCode();
                            if (hashCode != -1303110466) {
                                if (hashCode != -914104471) {
                                    if (hashCode == -791575966) {
                                        if (scheme.equals("weixin")) {
                                            buildUpon.appendQueryParameter("errorcode", c == 0 ? c != 1 ? c != 2 ? "1001" : "2003" : "2002" : "2001");
                                            webView.loadUrl(buildUpon.toString());
                                        }
                                    }
                                } else if (scheme.equals("alipays")) {
                                    c = 1;
                                    buildUpon.appendQueryParameter("errorcode", c == 0 ? c != 1 ? c != 2 ? "1001" : "2003" : "2002" : "2001");
                                    webView.loadUrl(buildUpon.toString());
                                }
                            } else if (scheme.equals("didipasnger")) {
                                c = 2;
                                buildUpon.appendQueryParameter("errorcode", c == 0 ? c != 1 ? c != 2 ? "1001" : "2003" : "2002" : "2001");
                                webView.loadUrl(buildUpon.toString());
                            }
                            c = 65535;
                            buildUpon.appendQueryParameter("errorcode", c == 0 ? c != 1 ? c != 2 ? "1001" : "2003" : "2002" : "2001");
                            webView.loadUrl(buildUpon.toString());
                        }
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return super.shouldOverrideUrlLoading(webView, str);
                    }
                }
            });
            this.O00000Oo.setDownloadListener(new DownloadListener() {
                /* class com.sdu.didi.openapi.DiDiWebActivity.AnonymousClass4 */

                public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    if (DiDiWebActivity.this.O00000o0 != null) {
                        dbc O00000Oo = DiDiWebActivity.this.O00000o0;
                        try {
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                            intent.addFlags(268435456);
                            O00000Oo.O00000Oo.getContext().startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            return;
        }
        throw new Resources.NotFoundException("activity_di_di_web");
    }
}
