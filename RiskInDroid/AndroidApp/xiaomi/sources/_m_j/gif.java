package _m_j;

import _m_j.ggb;
import _m_j.gtx;
import _m_j.hjl;
import _m_j.ing;
import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;
import com.mibi.sdk.channel.wxpay.WxResultHelper;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.api.CameraRouterFactory;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.operation.js_sdk.base.CommonWebView;
import com.xiaomi.smarthome.screenshot.Screenshot;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.List;
import org.json.JSONObject;

@RouterService
public class gif implements eyf {
    private static final gif INSTANCE = new gif();

    @cug
    public static gif provideInstance() {
        return INSTANCE;
    }

    public boolean isYoupinHost(String str) {
        return cmc.O00000Oo();
    }

    public void openUrl(String str) {
        cmc.O000000o(str);
    }

    public boolean dispatchToShop(String str, String str2) {
        return hjp.O000000o(str, str2);
    }

    public void assistActivity(Activity activity) {
        fxm.O000000o().O000000o(activity);
    }

    public void setShouldFitSoftKeybord(boolean z) {
        fxm.O000000o().O00000oO = z;
    }

    public void cleanInstance() {
        fxm.O000000o().O00000Oo();
    }

    public String getUserId(String str) {
        Device O000000o2 = fno.O000000o().O000000o(str);
        if (O000000o2 == null) {
            return null;
        }
        return O000000o2.userId;
    }

    public void changeHome(final Activity activity, final String str) {
        if (ggb.O00000Oo().O00000o(str) == null) {
            ggb.O00000Oo().O000000o(new ggb.O0000OOo() {
                /* class _m_j.gif.AnonymousClass1 */

                public final void O000000o() {
                    ggb.O00000Oo().O000000o(str, (fsm) null);
                    activity.finish();
                }
            });
            return;
        }
        ggb.O00000Oo().O000000o(str, (fsm) null);
        activity.finish();
    }

    public void removeWXPayCallback() {
        WxResultHelper.removeInterceptor();
    }

    public void startLogin(Context context, int i, final Runnable runnable) {
        gty.O000000o().startLogin(context, i, new gtx.O000000o() {
            /* class _m_j.gif.AnonymousClass2 */

            public final void O000000o() {
                runnable.run();
            }
        });
    }

    public void startScreenShot(final Activity activity, final CommonWebView commonWebView) {
        final File file = new File(gpi.O00000Oo, "screenshot.jpg");
        Screenshot.Builder builder = new Screenshot.Builder(activity);
        builder.O00000Oo = commonWebView;
        builder.O00000o = true;
        builder.O00000o0 = file.getAbsolutePath();
        builder.O00000oO = new hry() {
            /* class _m_j.gif.AnonymousClass3 */

            public final void O000000o(Bitmap bitmap) {
                gsy.O000000o(6, "CommonWebViewActivity", "onSuccess");
                gqg.O000000o(activity.getString(R.string.image_saved) + gpi.f18123O000000o + activity.getString(R.string.file_directory), 1);
                try {
                    gpi.O000000o(file);
                    commonWebView.loadUrl("javascript:_hideImgDownloader()");
                    if (bitmap != null && !bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public final void O000000o(String str) {
                gsy.O000000o(6, "CommonWebViewActivity", "onFail = ".concat(String.valueOf(str)));
                gqg.O000000o((int) R.string.save_fail);
            }

            public final void O000000o() {
                gsy.O000000o(6, "CommonWebViewActivity", "onPreStart");
            }
        };
        builder.O000000o().O000000o();
    }

    @SuppressLint({"CheckResult"})
    public void getLocationRx(String str, final hkk<String, String> hkk) {
        hjl.O000000o().O000000o(str).subscribe(new Consumer<hjl.O00000o0>() {
            /* class _m_j.gif.AnonymousClass4 */

            public final /* synthetic */ void accept(Object obj) throws Exception {
                hkk.O00000Oo(((hjl.O00000o0) obj).toString());
            }
        }, new Consumer<Throwable>() {
            /* class _m_j.gif.AnonymousClass5 */

            public final /* synthetic */ void accept(Object obj) throws Exception {
                hkk.O000000o(((Throwable) obj).getLocalizedMessage());
            }
        });
    }

    public void onReceivedLoginRequest(Context context, final WebView webView, String str, String str2, String str3) {
        if ("com.xiaomi".equals(str)) {
            try {
                MiAccountManager O00000Oo = MiAccountManager.O00000Oo(context.getApplicationContext());
                Account[] O000000o2 = O00000Oo.O000000o("com.xiaomi");
                if (O000000o2.length != 0) {
                    O00000Oo.O000000o(O000000o2[0], "weblogin:".concat(String.valueOf(str3)), (Bundle) null, (Activity) context, new AccountManagerCallback<Bundle>() {
                        /* class _m_j.gif.AnonymousClass6 */

                        public final void run(AccountManagerFuture<Bundle> accountManagerFuture) {
                            String str = null;
                            if (accountManagerFuture != null) {
                                try {
                                    Bundle result = accountManagerFuture.getResult();
                                    if (result != null) {
                                        str = result.getString("authtoken");
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            if (str == null) {
                                gsy.O000000o(3, "LoginInterceptor", "web sso failed.");
                                return;
                            }
                            webView.loadUrl(str);
                            gsy.O000000o(3, "LoginInterceptor", "web sso succeed.");
                        }
                    }, (Handler) null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void payWithMipayChinaMainland(Context context, String str, boolean z) {
        CameraRouterFactory.getCameraManagerApi().payWithMipayChinaMainland(context, str, z);
    }

    public void requestCapturePermissions(Activity activity, SingleEmitter singleEmitter) {
        ind.O00000Oo(activity).O000000o(ing.O000000o.O00000Oo).O000000o(new inc() {
            /* class _m_j.$$Lambda$gif$FA1bZPb5ni8l4AJqQA9IWOKzIiY */

            public final void onAction(List list) {
                SingleEmitter.this.onSuccess(Boolean.TRUE);
            }
        }).O00000Oo(new inc() {
            /* class _m_j.$$Lambda$gif$aQw3ASlufSyvQpb8IXYCUJY4M */

            public final void onAction(List list) {
                SingleEmitter.this.onSuccess(Boolean.FALSE);
            }
        }).O000000o();
    }

    public Single<String> getServiceTokenJson(Context context, String str) {
        return Single.create(new SingleOnSubscribe(context, str) {
            /* class _m_j.$$Lambda$gif$qfDqjcNkGdIqgSv9nyzkGkH4X2Q */
            private final /* synthetic */ Context f$0;
            private final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void subscribe(SingleEmitter singleEmitter) {
                gif.lambda$getServiceTokenJson$2(this.f$0, this.f$1, singleEmitter);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    static /* synthetic */ void lambda$getServiceTokenJson$2(Context context, String str, SingleEmitter singleEmitter) throws Exception {
        if (!singleEmitter.isDisposed()) {
            try {
                MiAccountManager O00000Oo = MiAccountManager.O00000Oo(context);
                ServiceTokenResult serviceTokenResult = O00000Oo.O000000o(context, str).get();
                ServiceTokenResult.O000000o o000000o = new ServiceTokenResult.O000000o(str);
                o000000o.O00000Oo = serviceTokenResult.O00000Oo;
                o000000o.O00000o0 = serviceTokenResult.O00000o0;
                O00000Oo.O000000o(context, o000000o.O000000o()).get();
                ServiceTokenResult serviceTokenResult2 = O00000Oo.O000000o(context, str).get();
                if (serviceTokenResult2.O00000o == ServiceTokenResult.ErrorCode.ERROR_NONE) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("cUserId", serviceTokenResult2.O0000Oo);
                    jSONObject.put("sid_slh", serviceTokenResult2.O0000OOo);
                    jSONObject.put("sid_ph", serviceTokenResult2.O0000Oo0);
                    jSONObject.put("sid_serviceToken", serviceTokenResult2.O00000Oo);
                    singleEmitter.onSuccess(jSONObject.toString());
                } else if (serviceTokenResult2.O00000o == ServiceTokenResult.ErrorCode.ERROR_USER_INTERACTION_NEEDED) {
                    singleEmitter.onSuccess("");
                }
            } catch (Exception e) {
                singleEmitter.onError(e);
            }
        }
    }

    public List<String> getOptionalSids(Context context) {
        if (ftn.O00000oo(context)) {
            return ibm.f1156O000000o.O0000Oo0;
        }
        return ibm.f1156O000000o.O0000Oo;
    }
}
