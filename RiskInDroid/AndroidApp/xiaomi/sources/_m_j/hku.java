package _m_j;

import _m_j.hku;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.xiaomi.passport.LocalFeatures.LocalFeaturesImpl;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.smarthome.WebViewRouterFactory;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.operation.js_sdk.bridge.CallBackData;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

public final class hku extends hkq {
    public hkr O00000Oo = new hkr() {
        /* class _m_j.hku.AnonymousClass1 */

        public final String O000000o() {
            return "login";
        }

        public final void O00000Oo() {
        }

        public final void O000000o(String str, hko hko) {
            gsy.O000000o(3, "LoginHandlerHelper", "handler: ".concat(String.valueOf(str)));
            if (CoreApi.O000000o().O0000Ooo()) {
                CallBackData callBackData = new CallBackData();
                callBackData.O000000o(0);
                callBackData.data = "";
                hko.O000000o(callBackData);
                return;
            }
            WebViewRouterFactory.getWebViewHelpManager().startLogin(CommonApplication.getAppContext(), 2, new Runnable() {
                /* class _m_j.$$Lambda$hku$1$I1sNSmHYOgwRzVSmE90gJ99hUYY */

                public final void run() {
                    hku.AnonymousClass1.O000000o(hko.this);
                }
            });
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void O000000o(hko hko) {
            CallBackData callBackData = new CallBackData();
            callBackData.O000000o(1);
            callBackData.data = "";
            hko.O000000o(callBackData);
        }
    };
    public hkr O00000o = new hkr() {
        /* class _m_j.hku.AnonymousClass3 */

        public final String O000000o() {
            return "startQRCodeScanResultAuth";
        }

        public final void O00000Oo() {
        }

        public final void O000000o(String str, hko hko) {
            try {
                String optString = new JSONObject(str).optString("url");
                if (TextUtils.isEmpty(optString)) {
                    gsy.O00000o0(LogType.LOG_INTERNAL, "LoginHandlerHelper", "invalid url: ".concat(String.valueOf(str)));
                    gqg.O00000Oo("url is empty!");
                    return;
                }
                LocalFeaturesImpl.O000000o(MiAccountManager.O00000Oo(hku.this.f19019O000000o.getContext()).f6195O000000o).O000000o(optString, (Activity) hku.this.f19019O000000o.getContext(), new eer() {
                    /* class _m_j.$$Lambda$hku$3$do_CNTWYxQUODyErmk_bZ7p_Q74 */

                    public final void run(ees ees) {
                        hku.AnonymousClass3.O000000o(hko.this, ees);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void O000000o(hko hko, ees ees) {
            try {
                Bundle bundle = (Bundle) ees.getResult();
                if (bundle != null) {
                    boolean z = bundle.getBoolean("booleanResult");
                    gsy.O00000o0(LogType.LOG_INTERNAL, "LoginHandlerHelper", "startQRCodeScanResultAuthResult: ".concat(String.valueOf(z)));
                    hlp.O000000o(new Runnable(z, hko) {
                        /* class _m_j.$$Lambda$hku$3$iTa9wAZaw8U9aWUDSlgAlueuYa8 */
                        private final /* synthetic */ boolean f$0;
                        private final /* synthetic */ hko f$1;

                        {
                            this.f$0 = r1;
                            this.f$1 = r2;
                        }

                        public final void run() {
                            hku.AnonymousClass3.O000000o(this.f$0, this.f$1);
                        }
                    });
                }
            } catch (Exception e) {
                hlp.O000000o(new Runnable(e, hko) {
                    /* class _m_j.$$Lambda$hku$3$jAGXKcWnhsVymXVOmzXGYlKLSQ */
                    private final /* synthetic */ Exception f$0;
                    private final /* synthetic */ hko f$1;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                    }

                    public final void run() {
                        hku.AnonymousClass3.O000000o(this.f$0, this.f$1);
                    }
                });
                e.printStackTrace();
                LogType logType = LogType.LOG_INTERNAL;
                gsy.O00000o0(logType, "LoginHandlerHelper", "startLogin: failed:  " + Log.getStackTraceString(e));
            }
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void O000000o(boolean z, hko hko) {
            CallBackData callBackData = new CallBackData();
            callBackData.data = String.valueOf(z);
            callBackData.O000000o(z ? 1 : 0);
            hko.O000000o(callBackData);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void O000000o(Exception exc, hko hko) {
            CallBackData callBackData = new CallBackData();
            callBackData.data = exc.toString();
            callBackData.O000000o(0);
            hko.O000000o(callBackData);
        }
    };
    public hkr O00000o0 = new hkr() {
        /* class _m_j.hku.AnonymousClass2 */
        private CompositeDisposable O00000Oo = new CompositeDisposable();

        public final String O000000o() {
            return "getServiceToken";
        }

        public final void O000000o(String str, hko hko) {
            hlp.O000000o(new Runnable(str, hko) {
                /* class _m_j.$$Lambda$hku$2$EzeVX4rilvjlQ7kVMWj4HmGzY1Y */
                private final /* synthetic */ String f$1;
                private final /* synthetic */ hko f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    hku.AnonymousClass2.this.O00000Oo(this.f$1, this.f$2);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O00000Oo(String str, hko hko) {
            String O000000o2 = hkn.O000000o(str);
            CallBackData callBackData = new CallBackData();
            callBackData.data = "";
            callBackData.O000000o(0);
            if (!hlp.O00000Oo(hku.this.f19019O000000o.getUrl())) {
                hko.O000000o(callBackData);
                return;
            }
            this.O00000Oo.add(WebViewRouterFactory.getWebViewHelpManager().getServiceTokenJson(CommonApplication.getAppContext(), O000000o2).subscribe(new Consumer(hko) {
                /* class _m_j.$$Lambda$hku$2$K_khBJPlrLMGs44NXXiTBqKeCfM */
                private final /* synthetic */ hko f$1;

                {
                    this.f$1 = r2;
                }

                public final void accept(Object obj) {
                    hku.AnonymousClass2.O000000o(CallBackData.this, this.f$1, (String) obj);
                }
            }, new Consumer(hko) {
                /* class _m_j.$$Lambda$hku$2$3Z9b3f9j2VSvVF3F3jfCoU1MNI */
                private final /* synthetic */ hko f$1;

                {
                    this.f$1 = r2;
                }

                public final void accept(Object obj) {
                    hku.AnonymousClass2.O000000o(CallBackData.this, this.f$1, (Throwable) obj);
                }
            }));
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void O000000o(CallBackData callBackData, hko hko, String str) throws Exception {
            callBackData.O000000o(1);
            callBackData.data = str;
            hko.O000000o(callBackData);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void O000000o(CallBackData callBackData, hko hko, Throwable th) throws Exception {
            callBackData.O000000o(0);
            hko.O000000o(callBackData);
        }

        public final void O00000Oo() {
            this.O00000Oo.clear();
        }
    };

    public hku(WebView webView) {
        super(webView);
    }
}
