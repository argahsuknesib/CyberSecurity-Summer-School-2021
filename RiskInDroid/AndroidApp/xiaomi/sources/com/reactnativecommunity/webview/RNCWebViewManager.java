package com.reactnativecommunity.webview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.JavascriptInterface;
import android.webkit.PermissionRequest;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.ContentSizeChangeEvent;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.views.scroll.OnScrollDispatchHelper;
import com.facebook.react.views.scroll.ScrollEvent;
import com.facebook.react.views.scroll.ScrollEventType;
import com.google.android.exoplayer2.C;
import com.reactnativecommunity.webview.events.TopHttpErrorEvent;
import com.reactnativecommunity.webview.events.TopLoadingErrorEvent;
import com.reactnativecommunity.webview.events.TopLoadingFinishEvent;
import com.reactnativecommunity.webview.events.TopLoadingProgressEvent;
import com.reactnativecommunity.webview.events.TopLoadingStartEvent;
import com.reactnativecommunity.webview.events.TopMessageEvent;
import com.reactnativecommunity.webview.events.TopShouldStartLoadWithRequestEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@ReactModule(name = "RNCWebView")
public class RNCWebViewManager extends SimpleViewManager<WebView> {
    public static String activeUrl;
    protected Method allowSetFileAccessMethod;
    protected Method getHtmlStr;
    protected Method isDarkMode;
    protected Method isInWhiteListMethod;
    protected boolean mAllowsFullscreenVideo;
    protected String mUserAgent;
    protected String mUserAgentWithApplicationName;
    protected RNCWebChromeClient mWebChromeClient;
    protected WebViewConfig mWebViewConfig;
    protected Method reportMethod;

    public String getName() {
        return "RNCWebView";
    }

    public RNCWebViewManager() {
        this.mWebChromeClient = null;
        this.mAllowsFullscreenVideo = false;
        this.mUserAgent = null;
        this.mUserAgentWithApplicationName = null;
        this.reportMethod = null;
        this.isInWhiteListMethod = null;
        this.getHtmlStr = null;
        this.allowSetFileAccessMethod = null;
        this.isDarkMode = null;
        this.mWebViewConfig = new WebViewConfig() {
            /* class com.reactnativecommunity.webview.RNCWebViewManager.AnonymousClass1 */

            public final void configWebView(WebView webView) {
            }
        };
        try {
            Class<?> cls = Class.forName("com.xiaomi.smarthome.framework.plugin.rn.report.RnNetReport");
            this.reportMethod = cls.getMethod("reportWebViewURL", String.class);
            this.isInWhiteListMethod = cls.getMethod("isInWhiteListHost", String.class);
            this.getHtmlStr = cls.getMethod("getInterceptHtmlStr", Context.class);
            this.allowSetFileAccessMethod = cls.getMethod("allowSetFileAccess", new Class[0]);
            this.isDarkMode = cls.getMethod("isDarkMode", new Class[0]);
        } catch (ClassNotFoundException e) {
            this.reportMethod = null;
            this.isInWhiteListMethod = null;
            this.getHtmlStr = null;
            this.allowSetFileAccessMethod = null;
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            this.reportMethod = null;
            this.isInWhiteListMethod = null;
            this.getHtmlStr = null;
            this.allowSetFileAccessMethod = null;
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public boolean allowSetFileAccess() {
        Method method = this.allowSetFileAccessMethod;
        if (method == null) {
            return true;
        }
        try {
            return ((Boolean) method.invoke(null, new Object[0])).booleanValue();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return true;
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public RNCWebViewManager(WebViewConfig webViewConfig) {
        this.mWebChromeClient = null;
        this.mAllowsFullscreenVideo = false;
        this.mUserAgent = null;
        this.mUserAgentWithApplicationName = null;
        this.reportMethod = null;
        this.isInWhiteListMethod = null;
        this.getHtmlStr = null;
        this.allowSetFileAccessMethod = null;
        this.isDarkMode = null;
        this.mWebViewConfig = webViewConfig;
    }

    protected static void dispatchEvent(WebView webView, Event event) {
        ((UIManagerModule) ((ReactContext) webView.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(event);
    }

    /* access modifiers changed from: protected */
    public RNCWebView createRNCWebViewInstance(ThemedReactContext themedReactContext) {
        return new RNCWebView(themedReactContext);
    }

    /* access modifiers changed from: protected */
    @TargetApi(21)
    public WebView createViewInstance(final ThemedReactContext themedReactContext) {
        Method method;
        RNCWebView createRNCWebViewInstance = createRNCWebViewInstance(themedReactContext);
        setupWebChromeClient(themedReactContext, createRNCWebViewInstance);
        themedReactContext.addLifecycleEventListener(createRNCWebViewInstance);
        this.mWebViewConfig.configWebView(createRNCWebViewInstance);
        WebSettings settings = createRNCWebViewInstance.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            setAllowUniversalAccessFromFileURLs(createRNCWebViewInstance, false);
        }
        if (Build.VERSION.SDK_INT >= 29 && (method = this.isDarkMode) != null) {
            try {
                if (((Boolean) method.invoke(null, new Object[0])).booleanValue()) {
                    settings.setForceDark(2);
                } else {
                    settings.setForceDark(0);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
        setMixedContentMode(createRNCWebViewInstance, "never");
        createRNCWebViewInstance.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        createRNCWebViewInstance.setDownloadListener(new DownloadListener() {
            /* class com.reactnativecommunity.webview.RNCWebViewManager.AnonymousClass2 */

            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                RNCWebViewModule module = RNCWebViewManager.getModule(themedReactContext);
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
                String guessFileName = URLUtil.guessFileName(str, str3, str4);
                String concat = "Downloading ".concat(String.valueOf(guessFileName));
                try {
                    URL url = new URL(str);
                    String cookie = CookieManager.getInstance().getCookie(url.getProtocol() + "://" + url.getHost());
                    request.addRequestHeader("Cookie", cookie);
                    System.out.println("Got cookie for DownloadManager: ".concat(String.valueOf(cookie)));
                } catch (MalformedURLException e) {
                    PrintStream printStream = System.out;
                    printStream.println("Error getting cookie for DownloadManager: " + e.toString());
                    e.printStackTrace();
                }
                request.addRequestHeader("User-Agent", str2);
                request.setTitle(guessFileName);
                request.setDescription(concat);
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(1);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, guessFileName);
                module.setDownloadRequest(request);
                if (module.grantFileDownloaderPermissions()) {
                    module.downloadFile();
                }
            }
        });
        return createRNCWebViewInstance;
    }

    @ReactProp(name = "javaScriptEnabled")
    public void setJavaScriptEnabled(WebView webView, boolean z) {
        webView.getSettings().setJavaScriptEnabled(z);
    }

    @ReactProp(name = "showsHorizontalScrollIndicator")
    public void setShowsHorizontalScrollIndicator(WebView webView, boolean z) {
        webView.setHorizontalScrollBarEnabled(z);
    }

    @ReactProp(name = "showsVerticalScrollIndicator")
    public void setShowsVerticalScrollIndicator(WebView webView, boolean z) {
        webView.setVerticalScrollBarEnabled(z);
    }

    @ReactProp(name = "cacheEnabled")
    public void setCacheEnabled(WebView webView, boolean z) {
        if (z) {
            Context context = webView.getContext();
            if (context != null) {
                webView.getSettings().setAppCachePath(context.getCacheDir().getAbsolutePath());
                webView.getSettings().setCacheMode(-1);
                webView.getSettings().setAppCacheEnabled(true);
                return;
            }
            return;
        }
        webView.getSettings().setCacheMode(2);
        webView.getSettings().setAppCacheEnabled(false);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @ReactProp(name = "cacheMode")
    public void setCacheMode(WebView webView, String str) {
        char c;
        Integer num;
        switch (str.hashCode()) {
            case -2059164003:
                if (str.equals("LOAD_NO_CACHE")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1215135800:
                if (str.equals("LOAD_DEFAULT")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -873877826:
                if (str.equals("LOAD_CACHE_ELSE_NETWORK")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1548620642:
                if (str.equals("LOAD_CACHE_ONLY")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            num = 3;
        } else if (c == 1) {
            num = 1;
        } else if (c != 2) {
            num = -1;
        } else {
            num = 2;
        }
        webView.getSettings().setCacheMode(num.intValue());
    }

    @ReactProp(name = "androidHardwareAccelerationDisabled")
    public void setHardwareAccelerationDisabled(WebView webView, boolean z) {
        if (z) {
            webView.setLayerType(1, null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0044  */
    @ReactProp(name = "overScrollMode")
    public void setOverScrollMode(WebView webView, String str) {
        char c;
        Integer num;
        int hashCode = str.hashCode();
        if (hashCode != -1414557169) {
            if (hashCode != 104712844) {
                if (hashCode == 951530617 && str.equals("content")) {
                    c = 1;
                    if (c != 0) {
                        num = 2;
                    } else if (c != 1) {
                        num = 0;
                    } else {
                        num = 1;
                    }
                    webView.setOverScrollMode(num.intValue());
                }
            } else if (str.equals("never")) {
                c = 0;
                if (c != 0) {
                }
                webView.setOverScrollMode(num.intValue());
            }
        } else if (str.equals("always")) {
            c = 2;
            if (c != 0) {
            }
            webView.setOverScrollMode(num.intValue());
        }
        c = 65535;
        if (c != 0) {
        }
        webView.setOverScrollMode(num.intValue());
    }

    @ReactProp(name = "thirdPartyCookiesEnabled")
    public void setThirdPartyCookiesEnabled(WebView webView, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, z);
        }
    }

    @ReactProp(name = "textZoom")
    public void setTextZoom(WebView webView, int i) {
        webView.getSettings().setTextZoom(i);
    }

    @ReactProp(name = "scalesPageToFit")
    public void setScalesPageToFit(WebView webView, boolean z) {
        webView.getSettings().setLoadWithOverviewMode(z);
        webView.getSettings().setUseWideViewPort(z);
    }

    @ReactProp(name = "domStorageEnabled")
    public void setDomStorageEnabled(WebView webView, boolean z) {
        webView.getSettings().setDomStorageEnabled(z);
    }

    @ReactProp(name = "userAgent")
    public void setUserAgent(WebView webView, String str) {
        if (str != null) {
            this.mUserAgent = str;
        } else {
            this.mUserAgent = null;
        }
        setUserAgentString(webView);
    }

    @ReactProp(name = "applicationNameForUserAgent")
    public void setApplicationNameForUserAgent(WebView webView, String str) {
        if (str == null) {
            this.mUserAgentWithApplicationName = null;
        } else if (Build.VERSION.SDK_INT >= 17) {
            String defaultUserAgent = WebSettings.getDefaultUserAgent(webView.getContext());
            this.mUserAgentWithApplicationName = defaultUserAgent + " " + str;
        }
        setUserAgentString(webView);
    }

    /* access modifiers changed from: protected */
    public void setUserAgentString(WebView webView) {
        if (this.mUserAgent != null) {
            webView.getSettings().setUserAgentString(this.mUserAgent);
        } else if (this.mUserAgentWithApplicationName != null) {
            webView.getSettings().setUserAgentString(this.mUserAgentWithApplicationName);
        } else if (Build.VERSION.SDK_INT >= 17) {
            webView.getSettings().setUserAgentString(WebSettings.getDefaultUserAgent(webView.getContext()));
        }
    }

    @ReactProp(name = "mediaPlaybackRequiresUserAction")
    @TargetApi(17)
    public void setMediaPlaybackRequiresUserAction(WebView webView, boolean z) {
        webView.getSettings().setMediaPlaybackRequiresUserGesture(z);
    }

    @ReactProp(name = "allowFileAccessFromFileURLs")
    public void setAllowFileAccessFromFileURLs(WebView webView, boolean z) {
        if (allowSetFileAccess()) {
            webView.getSettings().setAllowFileAccessFromFileURLs(z);
        }
    }

    @ReactProp(name = "allowUniversalAccessFromFileURLs")
    public void setAllowUniversalAccessFromFileURLs(WebView webView, boolean z) {
        if (allowSetFileAccess()) {
            webView.getSettings().setAllowUniversalAccessFromFileURLs(z);
        }
    }

    @ReactProp(name = "saveFormDataDisabled")
    public void setSaveFormDataDisabled(WebView webView, boolean z) {
        webView.getSettings().setSaveFormData(!z);
    }

    @ReactProp(name = "injectedJavaScript")
    public void setInjectedJavaScript(WebView webView, String str) {
        ((RNCWebView) webView).setInjectedJavaScript(str);
    }

    @ReactProp(name = "injectedJavaScriptBeforeContentLoaded")
    public void setInjectedJavaScriptBeforeContentLoaded(WebView webView, String str) {
        ((RNCWebView) webView).setInjectedJavaScriptBeforeContentLoaded(str);
    }

    @ReactProp(name = "messagingEnabled")
    public void setMessagingEnabled(WebView webView, boolean z) {
        ((RNCWebView) webView).setMessagingEnabled(z);
    }

    @ReactProp(name = "incognito")
    public void setIncognito(WebView webView, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().removeAllCookies(null);
        } else {
            CookieManager.getInstance().removeAllCookie();
        }
        webView.getSettings().setCacheMode(2);
        webView.getSettings().setAppCacheEnabled(!z);
        webView.clearHistory();
        webView.clearCache(z);
        webView.clearFormData();
        webView.getSettings().setSavePassword(!z);
        webView.getSettings().setSaveFormData(!z);
    }

    @ReactProp(name = "source")
    public void setSource(WebView webView, ReadableMap readableMap) {
        if (readableMap != null) {
            if (readableMap.hasKey("html")) {
                webView.loadDataWithBaseURL(readableMap.hasKey("baseUrl") ? readableMap.getString("baseUrl") : "", readableMap.getString("html"), "text/html", "UTF-8", null);
                return;
            } else if (readableMap.hasKey("uri")) {
                String string = readableMap.getString("uri");
                Method method = this.reportMethod;
                byte[] bArr = null;
                if (method != null) {
                    try {
                        method.invoke(null, string);
                        if (string != null && ((string.startsWith("http://") || string.startsWith("https://")) && this.isInWhiteListMethod != null)) {
                            if (!((Boolean) this.isInWhiteListMethod.invoke(null, string)).booleanValue() && this.getHtmlStr != null) {
                                String str = (String) this.getHtmlStr.invoke(null, webView.getContext());
                                if (!TextUtils.isEmpty(str)) {
                                    webView.loadDataWithBaseURL("", str, "text/html", "UTF-8", null);
                                    return;
                                }
                            }
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e2) {
                        e2.printStackTrace();
                    }
                }
                String url = webView.getUrl();
                if (url != null && url.equals(string)) {
                    return;
                }
                if (!TextUtils.isEmpty(string) && string.startsWith("file:///") && readableMap.hasKey("__packager_asset") && readableMap.getBoolean("__packager_asset")) {
                    webView.loadDataWithBaseURL("", readFileContent(Uri.parse(string).getPath()), "text/html", "UTF-8", null);
                    return;
                } else if (!readableMap.hasKey("method") || !readableMap.getString("method").equalsIgnoreCase("POST")) {
                    HashMap hashMap = new HashMap();
                    if (readableMap.hasKey("headers")) {
                        ReadableMap map = readableMap.getMap("headers");
                        ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
                        while (keySetIterator.hasNextKey()) {
                            String nextKey = keySetIterator.nextKey();
                            if (!"user-agent".equals(nextKey.toLowerCase(Locale.ENGLISH))) {
                                hashMap.put(nextKey, map.getString(nextKey));
                            } else if (webView.getSettings() != null) {
                                webView.getSettings().setUserAgentString(map.getString(nextKey));
                            }
                        }
                    }
                    webView.loadUrl(string, hashMap);
                    return;
                } else {
                    if (readableMap.hasKey("body")) {
                        String string2 = readableMap.getString("body");
                        try {
                            bArr = string2.getBytes("UTF-8");
                        } catch (UnsupportedEncodingException unused) {
                            bArr = string2.getBytes();
                        }
                    }
                    if (bArr == null) {
                        bArr = new byte[0];
                    }
                    webView.postUrl(string, bArr);
                    return;
                }
            }
        }
        webView.loadUrl("about:blank");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034 A[Catch:{ Exception -> 0x004e, all -> 0x004c }, LOOP:0: B:11:0x002e->B:14:0x0034, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043 A[SYNTHETIC, Splitter:B:17:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x003d A[EDGE_INSN: B:38:0x003d->B:15:0x003d ?: BREAK  , SYNTHETIC] */
    private String readFileContent(String str) {
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

    @ReactProp(name = "onContentSizeChange")
    public void setOnContentSizeChange(WebView webView, boolean z) {
        ((RNCWebView) webView).setSendContentSizeChangeEvents(z);
    }

    @ReactProp(name = "mixedContentMode")
    public void setMixedContentMode(WebView webView, String str) {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (str == null || "never".equals(str)) {
            webView.getSettings().setMixedContentMode(1);
        } else if ("always".equals(str)) {
            webView.getSettings().setMixedContentMode(0);
        } else if ("compatibility".equals(str)) {
            webView.getSettings().setMixedContentMode(2);
        }
    }

    @ReactProp(name = "urlPrefixesForDefaultIntent")
    public void setUrlPrefixesForDefaultIntent(WebView webView, ReadableArray readableArray) {
        RNCWebViewClient rNCWebViewClient = ((RNCWebView) webView).getRNCWebViewClient();
        if (rNCWebViewClient != null && readableArray != null) {
            rNCWebViewClient.setUrlPrefixesForDefaultIntent(readableArray);
        }
    }

    @ReactProp(name = "allowsFullscreenVideo")
    public void setAllowsFullscreenVideo(WebView webView, Boolean bool) {
        this.mAllowsFullscreenVideo = bool != null && bool.booleanValue();
        setupWebChromeClient((ReactContext) webView.getContext(), webView);
    }

    @ReactProp(name = "allowFileAccess")
    public void setAllowFileAccess(WebView webView, Boolean bool) {
        if (allowSetFileAccess()) {
            webView.getSettings().setAllowFileAccess(bool != null && bool.booleanValue());
        }
    }

    @ReactProp(name = "geolocationEnabled")
    public void setGeolocationEnabled(WebView webView, Boolean bool) {
        webView.getSettings().setGeolocationEnabled(bool != null && bool.booleanValue());
    }

    @ReactProp(name = "onScroll")
    public void setOnScroll(WebView webView, boolean z) {
        ((RNCWebView) webView).setHasScrollEvent(z);
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(ThemedReactContext themedReactContext, WebView webView) {
        webView.setWebViewClient(new RNCWebViewClient());
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        Map exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = MapBuilder.newHashMap();
        }
        exportedCustomDirectEventTypeConstants.put("topLoadingProgress", MapBuilder.of("registrationName", "onLoadingProgress"));
        exportedCustomDirectEventTypeConstants.put("topShouldStartLoadWithRequest", MapBuilder.of("registrationName", "onShouldStartLoadWithRequest"));
        exportedCustomDirectEventTypeConstants.put(ScrollEventType.getJSEventName(ScrollEventType.SCROLL), MapBuilder.of("registrationName", "onScroll"));
        exportedCustomDirectEventTypeConstants.put("topHttpError", MapBuilder.of("registrationName", "onHttpError"));
        return exportedCustomDirectEventTypeConstants;
    }

    public Map<String, Integer> getCommandsMap() {
        Map<String, Integer> of = MapBuilder.of("goBack", 1, "goForward", 2, "reload", 3, "stopLoading", 4, "postMessage", 5, "injectJavaScript", 6, "loadUrl", 7);
        of.put("requestFocus", 8);
        return of;
    }

    public void receiveCommand(WebView webView, int i, ReadableArray readableArray) {
        switch (i) {
            case 1:
                webView.goBack();
                return;
            case 2:
                webView.goForward();
                return;
            case 3:
                webView.reload();
                return;
            case 4:
                webView.stopLoading();
                return;
            case 5:
                try {
                    RNCWebView rNCWebView = (RNCWebView) webView;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("data", readableArray.getString(0));
                    rNCWebView.evaluateJavascriptWithFallback("(function () {var event;var data = " + jSONObject.toString() + ";try {event = new MessageEvent('message', data);} catch (e) {event = document.createEvent('MessageEvent');event.initMessageEvent('message', true, true, data.data, data.origin, data.lastEventId, data.source);}document.dispatchEvent(event);})();");
                    rNCWebView.evaluateJavascriptWithFallback("(function () {var event;var data = " + jSONObject.toString() + ";try {event = new MessageEvent('message', data);} catch (e) {event = document.createEvent('MessageEvent');event.initMessageEvent('message', true, true, data.data, data.origin, data.lastEventId, data.source);}window.dispatchEvent(event);})();");
                    return;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            case 6:
                ((RNCWebView) webView).evaluateJavascriptWithFallback(readableArray.getString(0));
                return;
            case 7:
                if (readableArray != null) {
                    webView.loadUrl(readableArray.getString(0));
                    return;
                }
                throw new RuntimeException("Arguments for loading an url are null!");
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                webView.requestFocus();
                return;
            default:
                return;
        }
    }

    public void onDropViewInstance(WebView webView) {
        super.onDropViewInstance((View) webView);
        RNCWebView rNCWebView = (RNCWebView) webView;
        ((ThemedReactContext) webView.getContext()).removeLifecycleEventListener(rNCWebView);
        rNCWebView.cleanupCallbacksAndDestroy();
    }

    public static RNCWebViewModule getModule(ReactContext reactContext) {
        return (RNCWebViewModule) reactContext.getNativeModule(RNCWebViewModule.class);
    }

    /* access modifiers changed from: protected */
    public void setupWebChromeClient(ReactContext reactContext, WebView webView) {
        if (this.mAllowsFullscreenVideo) {
            final int requestedOrientation = reactContext.getCurrentActivity().getRequestedOrientation();
            this.mWebChromeClient = new RNCWebChromeClient(reactContext, webView) {
                /* class com.reactnativecommunity.webview.RNCWebViewManager.AnonymousClass3 */

                public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                    if (this.mVideoView != null) {
                        customViewCallback.onCustomViewHidden();
                        return;
                    }
                    this.mVideoView = view;
                    this.mCustomViewCallback = customViewCallback;
                    this.mReactContext.getCurrentActivity().setRequestedOrientation(-1);
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.mVideoView.setSystemUiVisibility(7942);
                        this.mReactContext.getCurrentActivity().getWindow().setFlags(512, 512);
                    }
                    this.mVideoView.setBackgroundColor(-16777216);
                    getRootView().addView(this.mVideoView, FULLSCREEN_LAYOUT_PARAMS);
                    this.mWebView.setVisibility(8);
                    this.mReactContext.addLifecycleEventListener(this);
                }

                public void onHideCustomView() {
                    if (this.mVideoView != null) {
                        this.mVideoView.setVisibility(8);
                        getRootView().removeView(this.mVideoView);
                        this.mCustomViewCallback.onCustomViewHidden();
                        this.mVideoView = null;
                        this.mCustomViewCallback = null;
                        this.mWebView.setVisibility(0);
                        if (Build.VERSION.SDK_INT >= 19) {
                            this.mReactContext.getCurrentActivity().getWindow().clearFlags(512);
                        }
                        this.mReactContext.getCurrentActivity().setRequestedOrientation(requestedOrientation);
                        this.mReactContext.removeLifecycleEventListener(this);
                    }
                }
            };
            webView.setWebChromeClient(this.mWebChromeClient);
            return;
        }
        RNCWebChromeClient rNCWebChromeClient = this.mWebChromeClient;
        if (rNCWebChromeClient != null) {
            rNCWebChromeClient.onHideCustomView();
        }
        this.mWebChromeClient = new RNCWebChromeClient(reactContext, webView);
        webView.setWebChromeClient(this.mWebChromeClient);
    }

    public static class RNCWebViewClient extends WebViewClient {
        protected boolean mLastLoadFailed = false;
        protected ReadableArray mUrlPrefixesForDefaultIntent;

        protected RNCWebViewClient() {
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (!this.mLastLoadFailed) {
                RNCWebView rNCWebView = (RNCWebView) webView;
                rNCWebView.callInjectedJavaScript();
                rNCWebView.linkBridge();
                emitFinishEvent(webView, str);
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            this.mLastLoadFailed = false;
            ((RNCWebView) webView).callInjectedJavaScriptBeforeContentLoaded();
            RNCWebViewManager.dispatchEvent(webView, new TopLoadingStartEvent(webView.getId(), createWebViewEvent(webView, str)));
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            RNCWebViewManager.activeUrl = str;
            RNCWebViewManager.dispatchEvent(webView, new TopShouldStartLoadWithRequestEvent(webView.getId(), createWebViewEvent(webView, str)));
            return true;
        }

        @TargetApi(24)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            this.mLastLoadFailed = true;
            emitFinishEvent(webView, str2);
            WritableMap createWebViewEvent = createWebViewEvent(webView, str2);
            createWebViewEvent.putDouble("code", (double) i);
            createWebViewEvent.putString("description", str);
            RNCWebViewManager.dispatchEvent(webView, new TopLoadingErrorEvent(webView.getId(), createWebViewEvent));
        }

        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (webResourceRequest.isForMainFrame()) {
                WritableMap createWebViewEvent = createWebViewEvent(webView, webResourceRequest.getUrl().toString());
                createWebViewEvent.putInt("statusCode", webResourceResponse.getStatusCode());
                createWebViewEvent.putString("description", webResourceResponse.getReasonPhrase());
                RNCWebViewManager.dispatchEvent(webView, new TopHttpErrorEvent(webView.getId(), createWebViewEvent));
            }
        }

        /* access modifiers changed from: protected */
        public void emitFinishEvent(WebView webView, String str) {
            RNCWebViewManager.dispatchEvent(webView, new TopLoadingFinishEvent(webView.getId(), createWebViewEvent(webView, str)));
        }

        /* access modifiers changed from: protected */
        public WritableMap createWebViewEvent(WebView webView, String str) {
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("target", (double) webView.getId());
            createMap.putString("url", str);
            createMap.putBoolean("loading", !this.mLastLoadFailed && webView.getProgress() != 100);
            createMap.putString("title", webView.getTitle());
            createMap.putBoolean("canGoBack", webView.canGoBack());
            createMap.putBoolean("canGoForward", webView.canGoForward());
            return createMap;
        }

        public void setUrlPrefixesForDefaultIntent(ReadableArray readableArray) {
            this.mUrlPrefixesForDefaultIntent = readableArray;
        }
    }

    public static class RNCWebChromeClient extends WebChromeClient implements LifecycleEventListener {
        protected static final FrameLayout.LayoutParams FULLSCREEN_LAYOUT_PARAMS = new FrameLayout.LayoutParams(-1, -1, 17);
        protected WebChromeClient.CustomViewCallback mCustomViewCallback;
        protected ReactContext mReactContext;
        protected View mVideoView;
        protected View mWebView;

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return true;
        }

        public void onHostDestroy() {
        }

        public void onHostPause() {
        }

        public RNCWebChromeClient(ReactContext reactContext, WebView webView) {
            this.mReactContext = reactContext;
            this.mWebView = webView;
        }

        @TargetApi(21)
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            String[] resources = permissionRequest.getResources();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < resources.length; i++) {
                if (resources[i].equals("android.webkit.resource.AUDIO_CAPTURE")) {
                    arrayList.add("android.permission.RECORD_AUDIO");
                } else if (resources[i].equals("android.webkit.resource.VIDEO_CAPTURE")) {
                    arrayList.add("android.permission.CAMERA");
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (ContextCompat.O000000o(this.mReactContext, (String) arrayList.get(i2)) == 0) {
                    if (((String) arrayList.get(i2)).equals("android.permission.RECORD_AUDIO")) {
                        arrayList2.add("android.webkit.resource.AUDIO_CAPTURE");
                    } else if (((String) arrayList.get(i2)).equals("android.permission.CAMERA")) {
                        arrayList2.add("android.webkit.resource.VIDEO_CAPTURE");
                    }
                }
            }
            if (arrayList2.isEmpty()) {
                permissionRequest.deny();
            } else {
                permissionRequest.grant((String[]) arrayList2.toArray(new String[arrayList2.size()]));
            }
        }

        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            String url = webView.getUrl();
            if (url == null || RNCWebViewManager.activeUrl == null || url.equals(RNCWebViewManager.activeUrl)) {
                WritableMap createMap = Arguments.createMap();
                createMap.putDouble("target", (double) webView.getId());
                createMap.putString("title", webView.getTitle());
                createMap.putString("url", url);
                createMap.putBoolean("canGoBack", webView.canGoBack());
                createMap.putBoolean("canGoForward", webView.canGoForward());
                createMap.putDouble("progress", (double) (((float) i) / 100.0f));
                RNCWebViewManager.dispatchEvent(webView, new TopLoadingProgressEvent(webView.getId(), createMap));
            }
        }

        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            callback.invoke(str, true, false);
        }

        /* access modifiers changed from: protected */
        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            RNCWebViewManager.getModule(this.mReactContext).startPhotoPickerIntent(valueCallback, str);
        }

        /* access modifiers changed from: protected */
        public void openFileChooser(ValueCallback<Uri> valueCallback) {
            RNCWebViewManager.getModule(this.mReactContext).startPhotoPickerIntent(valueCallback, "");
        }

        /* access modifiers changed from: protected */
        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            RNCWebViewManager.getModule(this.mReactContext).startPhotoPickerIntent(valueCallback, str);
        }

        @TargetApi(21)
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            String[] acceptTypes = fileChooserParams.getAcceptTypes();
            boolean z = true;
            if (fileChooserParams.getMode() != 1) {
                z = false;
            }
            return RNCWebViewManager.getModule(this.mReactContext).startPhotoPickerIntent(valueCallback, fileChooserParams.createIntent(), acceptTypes, z);
        }

        public void onHostResume() {
            View view;
            if (Build.VERSION.SDK_INT >= 19 && (view = this.mVideoView) != null && view.getSystemUiVisibility() != 7942) {
                this.mVideoView.setSystemUiVisibility(7942);
            }
        }

        /* access modifiers changed from: protected */
        public ViewGroup getRootView() {
            return (ViewGroup) this.mReactContext.getCurrentActivity().findViewById(16908290);
        }
    }

    public static class RNCWebView extends WebView implements LifecycleEventListener {
        protected boolean hasScrollEvent = false;
        protected String injectedJS;
        protected String injectedJSBeforeContentLoaded;
        private OnScrollDispatchHelper mOnScrollDispatchHelper;
        protected RNCWebViewClient mRNCWebViewClient;
        protected boolean messagingEnabled = false;
        protected boolean sendContentSizeChangeEvents = false;

        public void onHostPause() {
        }

        public void onHostResume() {
        }

        public RNCWebView(ThemedReactContext themedReactContext) {
            super(themedReactContext);
        }

        public void setSendContentSizeChangeEvents(boolean z) {
            this.sendContentSizeChangeEvents = z;
        }

        public void setHasScrollEvent(boolean z) {
            this.hasScrollEvent = z;
        }

        public void onHostDestroy() {
            cleanupCallbacksAndDestroy();
        }

        /* access modifiers changed from: protected */
        public void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            if (this.sendContentSizeChangeEvents) {
                RNCWebViewManager.dispatchEvent(this, new ContentSizeChangeEvent(getId(), i, i2));
            }
        }

        public void setWebViewClient(WebViewClient webViewClient) {
            super.setWebViewClient(webViewClient);
            this.mRNCWebViewClient = (RNCWebViewClient) webViewClient;
        }

        public RNCWebViewClient getRNCWebViewClient() {
            return this.mRNCWebViewClient;
        }

        public void setInjectedJavaScript(String str) {
            this.injectedJS = str;
        }

        public void setInjectedJavaScriptBeforeContentLoaded(String str) {
            this.injectedJSBeforeContentLoaded = str;
        }

        /* access modifiers changed from: protected */
        public RNCWebViewBridge createRNCWebViewBridge(RNCWebView rNCWebView) {
            return new RNCWebViewBridge(rNCWebView);
        }

        /* access modifiers changed from: protected */
        public RNCWebViewBridgeOld createRNCWebViewBridgeOld(RNCWebView rNCWebView) {
            return new RNCWebViewBridgeOld(rNCWebView);
        }

        @SuppressLint({"AddJavascriptInterface"})
        public void setMessagingEnabled(boolean z) {
            if (this.messagingEnabled != z) {
                this.messagingEnabled = z;
                if (z) {
                    addJavascriptInterface(createRNCWebViewBridge(this), "ReactNativeWebView");
                    addJavascriptInterface(createRNCWebViewBridgeOld(this), "REACT_WEB_VIEW_BRIDGE");
                    linkBridge();
                    return;
                }
                removeJavascriptInterface("ReactNativeWebView");
                removeJavascriptInterface("REACT_WEB_VIEW_BRIDGE");
            }
        }

        public void linkBridge() {
            if (this.messagingEnabled) {
                evaluateJavascriptWithFallback("(function(){window.originalPostMessage = window.postMessage;window.postMessage = function(data) { window.REACT_WEB_VIEW_BRIDGE.postMessage(String(data));}})();");
            }
        }

        /* access modifiers changed from: protected */
        public void evaluateJavascriptWithFallback(String str) {
            if (Build.VERSION.SDK_INT >= 19) {
                evaluateJavascript(str, null);
                return;
            }
            try {
                loadUrl("javascript:" + URLEncoder.encode(str, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }

        public void callInjectedJavaScript() {
            String str;
            if (getSettings().getJavaScriptEnabled() && (str = this.injectedJS) != null && !TextUtils.isEmpty(str)) {
                evaluateJavascriptWithFallback("(function() {\n" + this.injectedJS + ";\n})();");
            }
        }

        public void callInjectedJavaScriptBeforeContentLoaded() {
            String str;
            if (getSettings().getJavaScriptEnabled() && (str = this.injectedJSBeforeContentLoaded) != null && !TextUtils.isEmpty(str)) {
                evaluateJavascriptWithFallback("(function() {\n" + this.injectedJSBeforeContentLoaded + ";\n})();");
            }
        }

        public void onMessage(final String str) {
            if (this.mRNCWebViewClient != null) {
                post(new Runnable() {
                    /* class com.reactnativecommunity.webview.RNCWebViewManager.RNCWebView.AnonymousClass1 */

                    public final void run() {
                        if (RNCWebView.this.mRNCWebViewClient != null) {
                            RNCWebViewClient rNCWebViewClient = RNCWebView.this.mRNCWebViewClient;
                            WebView webView = this;
                            WritableMap createWebViewEvent = rNCWebViewClient.createWebViewEvent(webView, webView.getUrl());
                            createWebViewEvent.putString("data", str);
                            WebView webView2 = this;
                            RNCWebViewManager.dispatchEvent(webView2, new TopMessageEvent(webView2.getId(), createWebViewEvent));
                        }
                    }
                });
                return;
            }
            WritableMap createMap = Arguments.createMap();
            createMap.putString("data", str);
            RNCWebViewManager.dispatchEvent(this, new TopMessageEvent(getId(), createMap));
        }

        /* access modifiers changed from: protected */
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            super.onScrollChanged(i, i2, i3, i4);
            if (this.hasScrollEvent) {
                if (this.mOnScrollDispatchHelper == null) {
                    this.mOnScrollDispatchHelper = new OnScrollDispatchHelper();
                }
                if (this.mOnScrollDispatchHelper.onScrollChanged(i, i2)) {
                    RNCWebViewManager.dispatchEvent(this, ScrollEvent.obtain(getId(), ScrollEventType.SCROLL, i, i2, this.mOnScrollDispatchHelper.getXFlingVelocity(), this.mOnScrollDispatchHelper.getYFlingVelocity(), computeHorizontalScrollRange(), computeVerticalScrollRange(), getWidth(), getHeight()));
                }
            }
        }

        /* access modifiers changed from: protected */
        public void cleanupCallbacksAndDestroy() {
            setWebViewClient(null);
            destroy();
        }

        public class RNCWebViewBridgeOld {
            RNCWebView mContext;

            RNCWebViewBridgeOld(RNCWebView rNCWebView) {
                this.mContext = rNCWebView;
            }

            @JavascriptInterface
            public void postMessage(String str) {
                this.mContext.onMessage(str);
            }
        }

        public class RNCWebViewBridge {
            RNCWebView mContext;

            RNCWebViewBridge(RNCWebView rNCWebView) {
                this.mContext = rNCWebView;
            }

            @JavascriptInterface
            public void postMessage(String str) {
                this.mContext.onMessage(str);
            }
        }
    }
}
