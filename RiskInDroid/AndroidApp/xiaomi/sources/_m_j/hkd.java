package _m_j;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.WebView;
import com.xiaomi.accountsdk.hasheddeviceidlib.HashedDeviceIdUtil;
import com.xiaomi.accountsdk.utils.WebViewDeviceIdUtil;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/xiaomi/smarthome/operation/helper/WebViewCookieHelper;", "", "()V", "Companion", "app-support-util_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hkd {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f19009O000000o = new O000000o((byte) 0);

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0007J.\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007¨\u0006\u0011"}, d2 = {"Lcom/xiaomi/smarthome/operation/helper/WebViewCookieHelper$Companion;", "", "()V", "injectDeviceId", "", "context", "Landroid/content/Context;", "cookieManager", "Landroid/webkit/CookieManager;", "webView", "Landroid/webkit/WebView;", "injectUidCookie", "domain", "", "setCookie", "name", "value", "app-support-util_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }

        public static void O000000o(CookieManager cookieManager, String str, String str2, String str3) {
            ixe.O00000o(cookieManager, "cookieManager");
            if (str2 != null && str3 != null) {
                cookieManager.setCookie(str3, ((Object) str) + '=' + ((Object) str2) + ";path=/;domain=" + ((Object) str3));
            }
        }
    }

    public static final void O000000o(CookieManager cookieManager, String str) {
        ixe.O00000o(cookieManager, "cookieManager");
        ixe.O00000o(str, "domain");
        if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
            String O0000o = CoreApi.O000000o().O0000o();
            if (!TextUtils.equals(O0000o, "0")) {
                O000000o.O000000o(cookieManager, "cUserId", O0000o, str);
            }
            if (hka.O00000Oo()) {
                String O0000o0 = CoreApi.O000000o().O0000o0();
                if (!TextUtils.equals(O0000o0, "0")) {
                    O000000o.O000000o(cookieManager, "userId", O0000o0, str);
                }
            }
        }
    }

    public static final void O000000o(WebView webView) {
        ixe.O00000o(webView, "webView");
        try {
            new WebViewDeviceIdUtil().setupDeviceIdForAccountWeb(webView);
        } catch (Exception unused) {
        }
    }

    public static final void O000000o(Context context, CookieManager cookieManager) {
        ixe.O00000o(context, "context");
        ixe.O00000o(cookieManager, "cookieManager");
        try {
            O000000o.O000000o(cookieManager, "deviceId ", new HashedDeviceIdUtil(context).getHashedDeviceIdNoThrow(), ".account.xiaomi.com");
        } catch (Exception unused) {
        }
    }
}
