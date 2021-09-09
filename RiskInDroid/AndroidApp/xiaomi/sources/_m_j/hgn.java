package _m_j;

import _m_j.ekw;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.xiaomi.accountsdk.account.XMPassportSettings;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

public final class hgn {
    public static Observable<String> O000000o() {
        return Observable.create($$Lambda$hgn$1buCMuT_JbYQQ8Ndw5xF7uMVuoc.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ae A[Catch:{ Exception -> 0x0163 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b7 A[Catch:{ Exception -> 0x0163 }] */
    public static /* synthetic */ void O000000o(ObservableEmitter observableEmitter) throws Exception {
        String str;
        boolean z;
        try {
            CommonApplication application = ServiceApplication.getApplication();
            ServiceTokenResult serviceTokenResult = MiAccountManager.O00000Oo(application).O000000o(application, "user_rights").get();
            String O0000o0 = CoreApi.O000000o().O0000o0();
            if (!TextUtils.isEmpty(O0000o0) && !TextUtils.equals(O0000o0, "0") && serviceTokenResult != null) {
                if (serviceTokenResult.O00000o == ServiceTokenResult.ErrorCode.ERROR_NONE) {
                    str = (XMPassportSettings.isLocalStaging(ServiceApplication.getAppContext()) ? "http://account.preview.n.xiaomi.net/pass/auth/rights/unregisterService/index" : "https://account.xiaomi.com/pass/auth/rights/unregisterService/index") + "?userId=" + O0000o0 + "&productId=mijia&locale=" + flk.O000000o(ftn.O00000o0(ServiceApplication.getAppContext()));
                    ekw.O000000o o000000o = new ekw.O000000o();
                    o000000o.f15588O000000o = ServiceApplication.getApplication();
                    o000000o.O00000Oo = "user_rights";
                    o000000o.O00000o0 = str;
                    ekw O000000o2 = o000000o.O000000o();
                    if (!(Looper.myLooper() == Looper.getMainLooper())) {
                        if (MiAccountManager.O00000Oo(O000000o2.f15587O000000o).O00000Oo()) {
                            efh.O000000o();
                            if (!efh.O00000Oo().O00000Oo(O000000o2.f15587O000000o)) {
                                z = false;
                                if (z) {
                                    AccountLog.w("WebSsoCookieUtils", "setCookie error: blocked on old miui versin");
                                } else {
                                    ServiceTokenResult O000000o3 = O000000o2.O000000o(true);
                                    if (O000000o3 != null) {
                                        CookieSyncManager.createInstance(O000000o2.f15587O000000o);
                                        CookieManager instance = CookieManager.getInstance();
                                        instance.setCookie(O000000o2.O00000o0, ekw.O000000o(O000000o2.O00000oO, "cUserId", O000000o3.O0000Oo, O000000o2.O00000o));
                                        instance.setCookie(O000000o2.O00000o0, ekw.O000000o(O000000o2.O00000oO, "serviceToken", O000000o3.O00000Oo, O000000o2.O00000o));
                                        String str2 = O000000o2.O00000o0;
                                        String str3 = O000000o2.O00000oO;
                                        String[] split = str3.split("\\.");
                                        int length = split.length;
                                        if (length > 2) {
                                            str3 = String.format(".%s.%s", split[length - 2], split[length - 1]);
                                        }
                                        instance.setCookie(str2, ekw.O000000o(str3, O000000o2.O00000Oo + "_slh", O000000o3.O0000OOo, O000000o2.O00000o));
                                        instance.setCookie(O000000o2.O00000o0, ekw.O000000o(O000000o2.O00000oO, O000000o2.O00000Oo + "_ph", O000000o3.O0000Oo0, O000000o2.O00000o));
                                        CookieSyncManager.getInstance().sync();
                                    }
                                }
                                observableEmitter.onNext(str);
                                observableEmitter.onComplete();
                            }
                        }
                        z = true;
                        if (z) {
                        }
                        observableEmitter.onNext(str);
                        observableEmitter.onComplete();
                    }
                    throw new IllegalStateException("WebSsoCookieUtils#setCookie() should NOT be called on main thread!");
                }
            }
            str = "";
            observableEmitter.onNext(str);
            observableEmitter.onComplete();
        } catch (Exception e) {
            observableEmitter.onError(e);
        }
    }
}
