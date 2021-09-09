package com.xiaomi.mico.music;

import _m_j.hxi;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alipay.sdk.app.H5PayCallback;
import com.alipay.sdk.app.PayTask;
import com.alipay.sdk.util.H5PayResultModel;
import com.xiaomi.mico.MicoMainFragment;
import com.xiaomi.mico.api.ApiConstants;
import com.xiaomi.mico.api.LoginManager;
import com.xiaomi.mico.application.MicoApplication;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.tool.embedded.activity.CommonWebActivity;
import com.xiaomi.smarthome.R;

public class PaymentWebActivity extends CommonWebActivity {
    public void setupWebView(WebView webView) {
        super.setupWebView(webView);
        String userId = LoginManager.getInstance().getPassportInfo().getUserId();
        String serviceToken = LoginManager.getInstance().getServiceInfo(ApiConstants.getMicoSid()).getServiceToken();
        CookieManager.getInstance().setCookie(getStartUrl(), String.format("userId=%s; path=/", userId));
        CookieManager.getInstance().setCookie(getStartUrl(), String.format("serviceToken=%s; path=/", serviceToken));
        CookieManager.getInstance().setCookie(getStartUrl(), String.format("partnerSource=%s; path=/", "mihome"));
    }

    public WebViewClient getWebViewClient() {
        return new PaymentWebViewClient();
    }

    public class PaymentWebViewClient extends CommonWebActivity.CommonWebViewClient {
        public PaymentWebViewClient() {
            super();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            Uri url = webResourceRequest.getUrl();
            Object[] objArr = {"shouldOverrideUrlLoading: %s", url.toString()};
            if (isPaymentIntercepted(webView, url)) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Object[] objArr = {"shouldOverrideUrlLoading: %s", str};
            if (isPaymentIntercepted(webView, Uri.parse(str))) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        private boolean isPaymentIntercepted(final WebView webView, Uri uri) {
            String scheme = uri.getScheme();
            String host = uri.getHost();
            if (host != null && (("mclient.alipay.com".equalsIgnoreCase(host) || host.contains("alipay")) && new PayTask(PaymentWebActivity.this).payInterceptorWithUrl(uri.toString(), true, new H5PayCallback() {
                /* class com.xiaomi.mico.music.PaymentWebActivity.PaymentWebViewClient.AnonymousClass1 */

                public void onPayResult(H5PayResultModel h5PayResultModel) {
                    String returnUrl = h5PayResultModel.getReturnUrl();
                    if (!TextUtils.isEmpty(returnUrl)) {
                        new Object[1][0] = "onPayResult=".concat(String.valueOf(returnUrl));
                        webView.postDelayed(new Runnable() {
                            /* class com.xiaomi.mico.music.PaymentWebActivity.PaymentWebViewClient.AnonymousClass1.AnonymousClass1 */

                            public void run() {
                                PaymentWebActivity.this.finish();
                            }
                        }, 500);
                    }
                }
            }))) {
                webView.loadUrl(PaymentWebActivity.this.mUrl);
                return true;
            } else if (scheme == null) {
                return false;
            } else {
                if (scheme.equalsIgnoreCase("alipays")) {
                    try {
                        Intent intent = new Intent();
                        intent.setData(uri);
                        PaymentWebActivity.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        ToastUtil.showToast(PaymentWebActivity.this.getString(R.string.mico_error_alipay_not_installed));
                    }
                    webView.postDelayed(new Runnable() {
                        /* class com.xiaomi.mico.music.PaymentWebActivity.PaymentWebViewClient.AnonymousClass2 */

                        public void run() {
                            PaymentWebActivity.this.finish();
                        }
                    }, 3000);
                    webView.loadUrl(PaymentWebActivity.this.mUrl);
                    return true;
                } else if (!scheme.equalsIgnoreCase("weixin")) {
                    return false;
                } else {
                    if (!MicoApplication.getInstance().getMicoHelperListener().getIWXAPI().isWXAppInstalled()) {
                        ToastUtil.showToast((int) R.string.mico_error_weixin_not_installed);
                        webView.loadUrl(PaymentWebActivity.this.mUrl);
                        return true;
                    }
                    Intent intent2 = new Intent();
                    intent2.setData(uri);
                    PaymentWebActivity.this.startActivity(intent2);
                    webView.postDelayed(new Runnable() {
                        /* class com.xiaomi.mico.music.PaymentWebActivity.PaymentWebViewClient.AnonymousClass3 */

                        public void run() {
                            PaymentWebActivity.this.finish();
                        }
                    }, 3000);
                    webView.loadUrl(PaymentWebActivity.this.mUrl);
                    return true;
                }
            }
        }
    }

    public void onResume() {
        super.onResume();
        int intExtra = getIntent().getIntExtra("type", -1);
        if (intExtra == -1) {
            String currentPageType = MicoMainFragment.getCurrentPageType();
            if (TextUtils.equals(currentPageType, "kid")) {
                intExtra = 1;
            } else if (TextUtils.equals(currentPageType, "audioBook")) {
                intExtra = 2;
            } else if (TextUtils.equals(currentPageType, "uncleCassie")) {
                intExtra = 3;
            }
        }
        hxi.O00000o0.f957O000000o.O000000o("content_pay_page", "type", Integer.valueOf(intExtra));
    }
}
