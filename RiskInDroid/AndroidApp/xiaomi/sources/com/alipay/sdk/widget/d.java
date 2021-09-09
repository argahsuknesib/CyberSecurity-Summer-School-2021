package com.alipay.sdk.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.ImageView;
import com.alipay.sdk.app.d;
import com.alipay.sdk.util.l;
import com.alipay.sdk.widget.e;
import com.google.android.exoplayer2.C;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends c implements e.b, e.c, e.d {
    /* access modifiers changed from: private */
    public boolean A = false;
    /* access modifiers changed from: private */
    public final com.alipay.sdk.sys.a B;
    private boolean C;
    /* access modifiers changed from: private */
    public e D = null;
    private f E = new f();
    private boolean y = true;
    private String z = "GET";

    public synchronized boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.A) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public d(Activity activity, com.alipay.sdk.sys.a aVar, String str) {
        super(activity, str);
        this.B = aVar;
        e();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003f, code lost:
        return false;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    private synchronized boolean e() {
        this.D = new e(this.f3216a, this.B, new e.a(!c(), !c()));
        this.D.setChromeProxy(this);
        this.D.setWebClientProxy(this);
        this.D.setWebEventProxy(this);
        addView(this.D);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001b, code lost:
        return;
     */
    private synchronized void f() {
        Activity activity = this.f3216a;
        e eVar = this.D;
        if (activity != null) {
            if (eVar != null) {
                if (this.y) {
                    activity.finish();
                } else {
                    eVar.a("javascript:window.AlipayJSBridge.callListener('h5BackAction');");
                }
            }
        }
    }

    private synchronized void g() {
        WebView webView = this.D.getWebView();
        if (webView.canGoBack()) {
            webView.goBack();
        } else if (this.E == null || this.E.b()) {
            a(false);
        } else {
            h();
        }
    }

    public synchronized void a(String str, String str2, boolean z2) {
        this.z = str2;
        this.D.getTitle().setText(str);
        this.y = z2;
    }

    private synchronized void a(boolean z2) {
        com.alipay.sdk.app.b.a(z2);
        this.f3216a.finish();
    }

    public synchronized void a(String str) {
        if ("POST".equals(this.z)) {
            this.D.a(str, (byte[]) null);
        } else {
            this.D.a(str);
        }
        a(this.D.getWebView());
    }

    public synchronized void a() {
        this.D.a();
        this.E.c();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0061, code lost:
        return true;
     */
    public synchronized boolean b() {
        Activity activity = this.f3216a;
        if (activity == null) {
            return true;
        }
        if (c()) {
            e eVar = this.D;
            if (eVar != null) {
                if (eVar.getWebView() != null) {
                    if (!eVar.getWebView().canGoBack()) {
                        com.alipay.sdk.app.b.a(com.alipay.sdk.app.b.c());
                        activity.finish();
                    } else if (d()) {
                        com.alipay.sdk.app.c b2 = com.alipay.sdk.app.c.b(com.alipay.sdk.app.c.NETWORK_ERROR.a());
                        com.alipay.sdk.app.b.a(com.alipay.sdk.app.b.a(b2.a(), b2.b(), ""));
                        activity.finish();
                    }
                }
            }
            activity.finish();
            return true;
        } else if (!this.A) {
            f();
        }
    }

    public synchronized boolean a(e eVar, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (str2.startsWith("<head>") && str2.contains("sdk_result_code:")) {
            this.f3216a.runOnUiThread(new Runnable() {
                /* class com.alipay.sdk.widget.d.AnonymousClass1 */

                public void run() {
                    d.this.f3216a.finish();
                }
            });
        }
        jsPromptResult.cancel();
        return true;
    }

    public synchronized void a(e eVar, String str) {
        if (!str.startsWith("http") && !eVar.getUrl().endsWith(str)) {
            this.D.getTitle().setText(str);
        }
    }

    private synchronized boolean h() {
        if (this.E.b()) {
            this.f3216a.finish();
        } else {
            this.A = true;
            final e eVar = this.D;
            this.D = this.E.a();
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(400);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new a() {
                /* class com.alipay.sdk.widget.d.AnonymousClass2 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: com.alipay.sdk.widget.d.a(com.alipay.sdk.widget.d, boolean):boolean
                 arg types: [com.alipay.sdk.widget.d, int]
                 candidates:
                  com.alipay.sdk.widget.d.a(com.alipay.sdk.widget.e, java.lang.String):void
                  com.alipay.sdk.widget.c.a(java.lang.String, java.lang.String):void
                  com.alipay.sdk.widget.e.b.a(com.alipay.sdk.widget.e, java.lang.String):void
                  com.alipay.sdk.widget.d.a(com.alipay.sdk.widget.d, boolean):boolean */
                public void onAnimationEnd(Animation animation) {
                    eVar.a();
                    boolean unused = d.this.A = false;
                }
            });
            eVar.setAnimation(translateAnimation);
            removeView(eVar);
            addView(this.D);
        }
        return true;
    }

    private synchronized boolean b(String str, String str2) {
        final e eVar = this.D;
        try {
            this.D = new e(this.f3216a, this.B, new e.a(!c(), !c()));
            this.D.setChromeProxy(this);
            this.D.setWebClientProxy(this);
            this.D.setWebEventProxy(this);
            if (!TextUtils.isEmpty(str2)) {
                this.D.getTitle().setText(str2);
            }
            this.A = true;
            this.E.a(eVar);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(400);
            translateAnimation.setFillAfter(false);
            final String str3 = str;
            translateAnimation.setAnimationListener(new a() {
                /* class com.alipay.sdk.widget.d.AnonymousClass3 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: com.alipay.sdk.widget.d.a(com.alipay.sdk.widget.d, boolean):boolean
                 arg types: [com.alipay.sdk.widget.d, int]
                 candidates:
                  com.alipay.sdk.widget.d.a(com.alipay.sdk.widget.e, java.lang.String):void
                  com.alipay.sdk.widget.c.a(java.lang.String, java.lang.String):void
                  com.alipay.sdk.widget.e.b.a(com.alipay.sdk.widget.e, java.lang.String):void
                  com.alipay.sdk.widget.d.a(com.alipay.sdk.widget.d, boolean):boolean */
                public void onAnimationEnd(Animation animation) {
                    d.this.removeView(eVar);
                    d.this.D.a(str3);
                    boolean unused = d.this.A = false;
                }
            });
            this.D.setAnimation(translateAnimation);
            addView(this.D);
        } catch (Throwable unused) {
            return false;
        }
        return true;
    }

    public synchronized boolean b(e eVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Activity activity = this.f3216a;
        if (activity == null) {
            return true;
        }
        if (l.a(this.B, str, activity)) {
            return true;
        }
        if (str.startsWith("alipayjsbridge://")) {
            b(str.substring(17));
        } else if (TextUtils.equals(str, "sdklite://h5quit")) {
            a(false);
        } else if (str.startsWith("http://") || str.startsWith("https://")) {
            this.D.a(str);
        } else {
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                activity.startActivity(intent);
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(this.B, "biz", th);
            }
        }
        return true;
    }

    private void i() {
        e eVar = this.D;
        if (eVar != null) {
            eVar.getWebView().loadUrl("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n;window.AlipayJSBridge.callListener('h5PageFinished');");
        }
    }

    public synchronized boolean c(e eVar, String str) {
        com.alipay.sdk.sys.a aVar = this.B;
        com.alipay.sdk.app.statistic.a.b(aVar, "biz", "h5ld", SystemClock.elapsedRealtime() + "|" + l.e(str));
        i();
        return false;
    }

    public synchronized boolean d(e eVar, String str) {
        com.alipay.sdk.sys.a aVar = this.B;
        com.alipay.sdk.app.statistic.a.b(aVar, "biz", "h5ldd", SystemClock.elapsedRealtime() + "|" + l.e(str));
        i();
        eVar.getRefreshButton().setVisibility(0);
        return true;
    }

    public synchronized boolean a(e eVar, int i, String str, String str2) {
        this.C = true;
        com.alipay.sdk.app.statistic.a.a(this.B, "net", "SSLError", "onReceivedError:".concat(String.valueOf(str2)));
        eVar.getRefreshButton().setVisibility(0);
        return false;
    }

    public synchronized boolean a(e eVar, final SslErrorHandler sslErrorHandler, SslError sslError) {
        final Activity activity = this.f3216a;
        if (activity == null) {
            return true;
        }
        com.alipay.sdk.app.statistic.a.a(this.B, "net", "SSLError", "2-".concat(String.valueOf(sslError)));
        activity.runOnUiThread(new Runnable() {
            /* class com.alipay.sdk.widget.d.AnonymousClass4 */

            public void run() {
                b.a(activity, "安全警告", "安全连接证书校验无效，将无法保证访问数据的安全性，请安装支付宝后重试。", "确定", new DialogInterface.OnClickListener() {
                    /* class com.alipay.sdk.widget.d.AnonymousClass4.AnonymousClass1 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        sslErrorHandler.cancel();
                        com.alipay.sdk.app.statistic.a.a(d.this.B, "net", "SSLDenied", "2");
                        com.alipay.sdk.app.b.a(com.alipay.sdk.app.b.c());
                        activity.finish();
                    }
                }, null, null);
            }
        });
        return true;
    }

    public boolean d() {
        return this.C;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00d3, code lost:
        return;
     */
    private synchronized void b(String str) {
        Map<String, String> a2 = l.a(this.B, str);
        if (str.startsWith("callNativeFunc")) {
            a(a2.get("func"), a2.get("cbId"), a2.get("data"));
        } else if (str.startsWith("onBack")) {
            g();
        } else if (str.startsWith("setTitle") && a2.containsKey("title")) {
            this.D.getTitle().setText(a2.get("title"));
        } else if (str.startsWith("onRefresh")) {
            this.D.getWebView().reload();
        } else if (str.startsWith("showBackButton") && a2.containsKey("bshow")) {
            this.D.getBackButton().setVisibility(TextUtils.equals("true", a2.get("bshow")) ? 0 : 4);
        } else if (str.startsWith("onExit")) {
            com.alipay.sdk.app.b.a(a2.get("result"));
            a(TextUtils.equals("true", a2.get("bsucc")));
        } else if (str.startsWith("onLoadJs")) {
            this.D.a("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01ae, code lost:
        return;
     */
    private synchronized void a(String str, String str2, String str3) {
        e eVar = this.D;
        if (eVar != null) {
            JSONObject c2 = l.c(str3);
            b bVar = new b(eVar, str, str2, c2);
            Context context = eVar.getContext();
            try {
                String str4 = bVar.b;
                char c3 = 65535;
                int i = 4;
                switch (str4.hashCode()) {
                    case -1785164386:
                        if (str4.equals("canUseTaoLogin")) {
                            c3 = 8;
                            break;
                        }
                        break;
                    case -552487705:
                        if (str4.equals("taoLogin")) {
                            c3 = 9;
                            break;
                        }
                        break;
                    case 3015911:
                        if (str4.equals("back")) {
                            c3 = 2;
                            break;
                        }
                        break;
                    case 3127582:
                        if (str4.equals("exit")) {
                            c3 = 3;
                            break;
                        }
                        break;
                    case 110371416:
                        if (str4.equals("title")) {
                            c3 = 0;
                            break;
                        }
                        break;
                    case 1085444827:
                        if (str4.equals("refresh")) {
                            c3 = 1;
                            break;
                        }
                        break;
                    case 1703426986:
                        if (str4.equals("pushWindow")) {
                            c3 = 6;
                            break;
                        }
                        break;
                    case 1906413305:
                        if (str4.equals("backButton")) {
                            c3 = 4;
                            break;
                        }
                        break;
                    case 1947723784:
                        if (str4.equals("sdkInfo")) {
                            c3 = 7;
                            break;
                        }
                        break;
                    case 2033767917:
                        if (str4.equals("refreshButton")) {
                            c3 = 5;
                            break;
                        }
                        break;
                }
                switch (c3) {
                    case 0:
                        if (c2.has("title")) {
                            eVar.getTitle().setText(c2.optString("title", ""));
                            return;
                        }
                        break;
                    case 1:
                        eVar.getWebView().reload();
                        return;
                    case 2:
                        g();
                        return;
                    case 3:
                        com.alipay.sdk.app.b.a(c2.optString("result", null));
                        a(c2.optBoolean("success", false));
                        return;
                    case 4:
                        boolean optBoolean = c2.optBoolean("show", true);
                        ImageView backButton = eVar.getBackButton();
                        if (optBoolean) {
                            i = 0;
                        }
                        backButton.setVisibility(i);
                        return;
                    case 5:
                        boolean optBoolean2 = c2.optBoolean("show", true);
                        ImageView refreshButton = eVar.getRefreshButton();
                        if (optBoolean2) {
                            i = 0;
                        }
                        refreshButton.setVisibility(i);
                        return;
                    case 6:
                        b(c2.optString("url"), c2.optString("title", ""));
                        return;
                    case 7:
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("sdk_version", "15.8.00");
                        jSONObject.put("app_name", this.B.b());
                        jSONObject.put("app_version", this.B.c());
                        bVar.a(jSONObject);
                        return;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                        String url = eVar.getUrl();
                        if (!l.e(this.B, url)) {
                            com.alipay.sdk.app.statistic.a.a(this.B, "biz", "jsUrlErr", url);
                            return;
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("enabled", com.alipay.sdk.app.d.a(this.B, context));
                        bVar.a(jSONObject2);
                        return;
                    case 9:
                        String url2 = eVar.getUrl();
                        if (l.e(this.B, url2)) {
                            String optString = c2.optString("random");
                            JSONObject optJSONObject = c2.optJSONObject("options");
                            if (!TextUtils.isEmpty("random") && optJSONObject != null) {
                                String optString2 = optJSONObject.optString("url");
                                String optString3 = optJSONObject.optString("action");
                                if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && (context instanceof Activity)) {
                                    com.alipay.sdk.app.d.a(this.B, (Activity) context, 1010, optString2, optString3, new c(bVar, optString));
                                    break;
                                }
                            }
                        } else {
                            com.alipay.sdk.app.statistic.a.a(this.B, "biz", "jsUrlErr", url2);
                            return;
                        }
                }
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(this.B, "biz", "jInfoErr", th, str);
            }
        }
    }

    public synchronized void a(e eVar) {
        f();
    }

    public synchronized void b(e eVar) {
        eVar.getWebView().reload();
        eVar.getRefreshButton().setVisibility(4);
    }

    static abstract class a implements Animation.AnimationListener {
        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }

        private a() {
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<e> f3222a;
        final String b;
        final String c;
        final JSONObject d;
        private boolean e = false;

        b(e eVar, String str, String str2, JSONObject jSONObject) {
            this.f3222a = new WeakReference<>(eVar);
            this.b = str;
            this.c = str2;
            this.d = jSONObject;
        }

        /* access modifiers changed from: package-private */
        public void a(JSONObject jSONObject) {
            e eVar;
            if (!this.e && (eVar = (e) l.a(this.f3222a)) != null) {
                this.e = true;
                eVar.a(String.format("javascript:window.AlipayJSBridge.callBackFromNativeFunc('%s','%s');", a(this.c), a(jSONObject.toString())));
            }
        }

        private static String a(String str) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return str.replace("'", "");
        }
    }

    static class c implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private final b f3223a;
        private final String b;

        public c(b bVar, String str) {
            this.f3223a = bVar;
            this.b = str;
        }

        public void a(boolean z, JSONObject jSONObject, String str) {
            try {
                this.f3223a.a(new JSONObject().put("success", z).put("random", this.b).put("code", jSONObject).put("status", str));
            } catch (JSONException unused) {
            }
        }
    }
}
