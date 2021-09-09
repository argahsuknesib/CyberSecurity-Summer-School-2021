package _m_j;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.ximalaya.ting.android.opensdk.auth.component.XmlyBrowserComponent;
import com.ximalaya.ting.android.opensdk.auth.component.c;
import com.ximalaya.ting.android.opensdk.auth.exception.XmlyAuthException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public final class ihz extends iic {
    /* access modifiers changed from: private */
    public Activity O00000Oo;
    /* access modifiers changed from: private */
    public ihy O00000o;
    private c O00000o0;
    private boolean O00000oO = false;

    public ihz(Activity activity, c cVar) {
        this.O00000Oo = activity;
        this.O00000o0 = cVar;
        this.O00000o = cVar.O00000Oo;
    }

    public final void onPageStarted(WebView webView, final String str, Bitmap bitmap) {
        if (this.f1310O000000o != null) {
            this.f1310O000000o.onPageStartedCallBack(webView, str, bitmap);
        }
        if (!str.startsWith(this.O00000o0.f12162O000000o.O00000Oo) || this.O00000oO) {
            super.onPageStarted(webView, str, bitmap);
            return;
        }
        this.O00000oO = true;
        Bundle O000000o2 = iin.O000000o(str);
        String string = O000000o2.getString("error_no");
        String string2 = O000000o2.getString("error_code");
        String string3 = O000000o2.getString("error_desc");
        if (string == null && string2 == null) {
            iii.O000000o("ContentValues", "requestAccessTokenInfo, request: method = get, url = ".concat(String.valueOf(str)));
            new OkHttpClient().newBuilder().connectTimeout(30, TimeUnit.SECONDS).followRedirects(false).build().newCall(new Request.Builder().url(str).build()).enqueue(new Callback() {
                /* class _m_j.ihz.AnonymousClass1 */

                public final void onFailure(Call call, IOException iOException) {
                    if (ihz.this.O00000o != null) {
                        ihy unused = ihz.this.O00000o;
                        new XmlyAuthException(iOException.getMessage(), null, null);
                    }
                    iOException.printStackTrace();
                    iii.O000000o("ContentValues", "requestAccessTokenInfo, request failed, error message = " + iOException.getMessage());
                }

                public final void onResponse(Call call, Response response) throws IOException {
                    int code = response.code();
                    String string = response.body().string();
                    if (response.isSuccessful()) {
                        if (!TextUtils.isEmpty(string)) {
                            iie O000000o2 = iie.O000000o(string);
                            try {
                                int optInt = new JSONObject(string).optInt("expires_in", 0);
                                if (ihz.this.O00000o != null) {
                                    if (O000000o2 == null || !O000000o2.O000000o()) {
                                        ihy unused = ihz.this.O00000o;
                                        new XmlyAuthException(String.valueOf(code), null, null);
                                        iii.O000000o("ContentValues", "Failed to receive access token by Web");
                                    } else {
                                        iii.O000000o("ContentValues", "Login Success! " + O000000o2.toString());
                                        iih.O000000o(ihz.this.O00000Oo);
                                        iih.O000000o(ihz.this.O00000Oo, O000000o2);
                                        O000000o2.O00000o = (long) optInt;
                                        ihy unused2 = ihz.this.O00000o;
                                        O000000o2.O00000Oo();
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            iii.O000000o("ContentValues", "redirectRequestAccessTokenInfo, request success, status code = " + code + ", body = " + string + ", redirectUrl" + str);
                        }
                        ihy unused3 = ihz.this.O00000o;
                        new XmlyAuthException(String.valueOf(code), null, null);
                    } else if (!TextUtils.isEmpty(string)) {
                        iig O000000o3 = iig.O000000o(string);
                        if (O000000o3 != null) {
                            ihy unused4 = ihz.this.O00000o;
                            new XmlyAuthException(O000000o3.f1314O000000o, O000000o3.O00000Oo, O000000o3.O00000o0);
                        } else {
                            ihy unused5 = ihz.this.O00000o;
                            new XmlyAuthException(String.valueOf(code), null, null);
                        }
                    } else {
                        ihy unused6 = ihz.this.O00000o;
                        new XmlyAuthException(String.valueOf(code), null, null);
                    }
                    iii.O000000o("ContentValues", "Failed to receive access token by Web");
                    iii.O000000o("ContentValues", "redirectRequestAccessTokenInfo, request success, status code = " + code + ", body = " + string + ", redirectUrl" + str);
                }
            });
        } else if (this.O00000o != null) {
            new XmlyAuthException(string2, string, string3);
        }
        webView.stopLoading();
        XmlyBrowserComponent.closeBrowser(this.O00000Oo, this.O00000o0.O00000o0);
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.f1310O000000o != null) {
            this.f1310O000000o.shouldOverrideUrlLoadingCallBack(webView, str);
        }
        if (!str.startsWith("ximalaya://browser/close")) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        XmlyBrowserComponent.closeBrowser(this.O00000Oo, this.O00000o0.O00000o0);
        return true;
    }

    public final void onPageFinished(WebView webView, String str) {
        if (this.f1310O000000o != null) {
            this.f1310O000000o.onPageFinishedCallBack(webView, str);
        }
        super.onPageFinished(webView, str);
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        if (this.f1310O000000o != null) {
            this.f1310O000000o.onReceivedErrorCallBack(webView, i, str, str2);
        }
        super.onReceivedError(webView, i, str, str2);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.f1310O000000o != null) {
            this.f1310O000000o.onReceivedSslErrorCallBack(webView, sslErrorHandler, sslError);
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }
}
