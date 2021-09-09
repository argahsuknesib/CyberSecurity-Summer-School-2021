package _m_j;

import _m_j.hlp;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.smarthome.operation.js_sdk.base.CommonWebView;
import com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu;
import com.xiaomi.smarthome.operation.js_sdk.titlebar.WebTitleBarView;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class hkg extends fvm {
    private boolean isShowCustomView;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;
    private View mVideoView;

    public String getDefaultTitle() {
        return "";
    }

    /* access modifiers changed from: protected */
    public abstract String getUrl();

    /* access modifiers changed from: protected */
    public abstract CommonWebView getWebView();

    /* access modifiers changed from: protected */
    public abstract WebTitleBarView getWebViewTitleBar();

    public boolean isFixedTitleText() {
        return false;
    }

    public boolean isUseTitleBar() {
        return true;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        init();
    }

    /* access modifiers changed from: protected */
    public void init() {
        WebTitleBarView.O000000o o000000o;
        WebTitleBarView webViewTitleBar = getWebViewTitleBar();
        final CommonWebView webView = getWebView();
        if (isUseTitleBar()) {
            webViewTitleBar.setVisibility(0);
            webViewTitleBar.setDefaultTitle(getDefaultTitle());
            webViewTitleBar.setFixedTitleText(isFixedTitleText());
            webView.setTitleBarImpl(webViewTitleBar);
            FragmentActivity activity = getActivity();
            if (webView == null || activity == null) {
                o000000o = new WebTitleBarView.O00000Oo();
            } else {
                o000000o = new WebTitleBarView.O000000o(webView, activity) {
                    /* class com.xiaomi.smarthome.operation.js_sdk.titlebar.WebTitleBarView.AnonymousClass3 */

                    /* renamed from: O000000o */
                    final /* synthetic */ CommonWebView f10534O000000o;
                    final /* synthetic */ Activity O00000Oo;

                    {
                        this.f10534O000000o = r2;
                        this.O00000Oo = r3;
                    }

                    public final void O000000o(View view, TitleBarMenu.O000000o o000000o, String str) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("index", o000000o.O00000Oo);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        hlp.O000000o(this.f10534O000000o, "smartHome.dispatchEvent", str, jSONObject.toString());
                    }

                    public final void O00000Oo() {
                        this.f10534O000000o.f10512O000000o.O000000o();
                    }

                    public final void O000000o() {
                        O000000o(false);
                    }

                    public final void O000000o(boolean z) {
                        if (z) {
                            this.O00000Oo.finish();
                        } else {
                            this.O00000Oo.onBackPressed();
                        }
                    }

                    public final void O00000o0() {
                        hlp.O000000o(this.f10534O000000o, "smartHome.dispatchEvent", "titleClick");
                    }
                };
            }
            webViewTitleBar.setTitleBarActionReceiver(new WebTitleBarView.O00000Oo(o000000o) {
                /* class _m_j.hkg.AnonymousClass1 */

                public final void O000000o() {
                    hkj commonWebViewFragmentBridge = hkg.this.getCommonWebViewFragmentBridge();
                    if (commonWebViewFragmentBridge != null) {
                        commonWebViewFragmentBridge.onBackButtonClick();
                    }
                }
            });
        } else {
            webViewTitleBar.setVisibility(8);
        }
        webView.setWebPageActionImpl(new hlb() {
            /* class _m_j.hkg.AnonymousClass2 */

            public final void O000000o(String str) {
                hkj commonWebViewFragmentBridge = hkg.this.getCommonWebViewFragmentBridge();
                if (commonWebViewFragmentBridge != null) {
                    commonWebViewFragmentBridge.popWindow(str);
                }
            }

            public final void O00000Oo(String str) {
                hkj commonWebViewFragmentBridge = hkg.this.getCommonWebViewFragmentBridge();
                if (commonWebViewFragmentBridge != null) {
                    commonWebViewFragmentBridge.pushWindow(str);
                }
            }

            public final void O000000o() {
                hkg.this.doHideCustomView();
            }

            public final void O000000o(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                hkg.this.doShowCustomView(view, customViewCallback);
            }

            public final void O000000o(ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                FragmentActivity activity = hkg.this.getActivity();
                if (activity != null) {
                    hlo.O000000o(activity).O000000o(activity, valueCallback, fileChooserParams);
                }
            }

            public final void O000000o(ValueCallback<Uri> valueCallback, String str) {
                FragmentActivity activity = hkg.this.getActivity();
                if (activity != null) {
                    hlo O000000o2 = hlo.O000000o(activity);
                    O000000o2.O00000Oo = valueCallback;
                    String str2 = str.isEmpty() ? "*/*" : str;
                    if (str.matches("\\.\\w+")) {
                        str2 = hlo.O000000o(str.replace(".", ""));
                    }
                    Intent intent = new Intent("android.intent.action.GET_CONTENT");
                    intent.addCategory("android.intent.category.OPENABLE");
                    intent.setType(str2);
                    Intent createChooser = Intent.createChooser(intent, "");
                    ArrayList arrayList = new ArrayList();
                    String O000000o3 = str.matches("\\.\\w+") ? hlo.O000000o(str.replace(".", "")) : str;
                    boolean z = true;
                    if (O000000o3.isEmpty() || O000000o3.toLowerCase().contains("image")) {
                        arrayList.add(O000000o2.O000000o());
                    }
                    if (str.matches("\\.\\w+")) {
                        str = hlo.O000000o(str.replace(".", ""));
                    }
                    if (!str.isEmpty() && !str.toLowerCase().contains("video")) {
                        z = false;
                    }
                    if (z) {
                        arrayList.add(O000000o2.O00000Oo());
                    }
                    createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
                    if (createChooser.resolveActivity(activity.getPackageManager()) != null) {
                        activity.startActivityForResult(createChooser, 3);
                    } else {
                        gsy.O000000o(5, "FileChooseHelper", "there is no Activity to handle this Intent");
                    }
                }
            }

            public final void O000000o(int i) {
                if (i == 1 || i == 2) {
                    hkg.this.requestOrientationChange(false);
                } else {
                    hkg.this.requestOrientationChange(true);
                }
            }
        });
        webView.loadUrl(getUrl());
    }

    public void doShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.mVideoView = view;
        this.mCustomViewCallback = customViewCallback;
        this.isShowCustomView = true;
        if (getWebViewTitleBar() != null) {
            getWebViewTitleBar().setVisibility(8);
        }
        ViewGroup viewGroup = (ViewGroup) getWebView().getParent();
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ((ViewGroup) viewGroup.getParent()).addView(view);
        viewGroup.setVisibility(8);
    }

    public void doHideCustomView() {
        WebChromeClient.CustomViewCallback customViewCallback;
        if (this.isShowCustomView && (customViewCallback = this.mCustomViewCallback) != null && this.mVideoView != null) {
            this.isShowCustomView = false;
            customViewCallback.onCustomViewHidden();
            if (isUseTitleBar() && getWebViewTitleBar() != null) {
                getWebViewTitleBar().setVisibility(0);
            }
            gwg.O00000Oo(getActivity().getWindow());
            ViewGroup viewGroup = (ViewGroup) getWebView().getParent();
            viewGroup.setVisibility(0);
            ((ViewGroup) viewGroup.getParent()).removeView(this.mVideoView);
            requestOrientationChange(false);
        }
    }

    public void requestOrientationChange(boolean z) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (z) {
                activity.setRequestedOrientation(0);
                activity.getWindow().addFlags(1024);
                activity.getWindow().getDecorView().setSystemUiVisibility(6);
                return;
            }
            activity.setRequestedOrientation(1);
            activity.getWindow().clearFlags(1024);
            View decorView = activity.getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & -7);
        }
    }

    /* access modifiers changed from: protected */
    public hkj getCommonWebViewFragmentBridge() {
        FragmentActivity activity = getActivity();
        if (activity instanceof hkj) {
            return (hkj) activity;
        }
        return null;
    }

    public void onResume() {
        super.onResume();
        gsy.O000000o(3, "CommonWebViewFragment", "onResume: ".concat(String.valueOf(this)));
        getWebView().onResume();
    }

    public void onPause() {
        super.onPause();
        gsy.O000000o(3, "CommonWebViewFragment", "onPause: ".concat(String.valueOf(this)));
        getWebView().onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        CommonWebView webView = getWebView();
        if (webView != null) {
            try {
                Class.forName("android.webkit.WebView").getMethod("onPause", null).invoke(webView, null);
                webView.loadUrl("");
            } catch (Throwable th) {
                th.printStackTrace();
            }
            ViewParent parent = webView.getParent();
            webView.removeAllViews();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(webView);
            }
            webView.destroy();
        }
    }

    public boolean onBackPressed() {
        if (this.isShowCustomView) {
            doHideCustomView();
            return true;
        } else if (getWebView().O00000Oo() || super.onBackPressed()) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean isValidUrl(String str) {
        try {
            if (TextUtils.isEmpty(Uri.parse(str).getHost())) {
                return false;
            }
            return true;
        } catch (Exception e) {
            gsy.O000000o(3, "CommonWebViewFragment", "onCreateView: illegal url: " + str + " error: " + Log.getStackTraceString(e));
            return false;
        }
    }
}
