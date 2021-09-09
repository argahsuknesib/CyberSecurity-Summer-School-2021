package _m_j;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.mibi.sdk.channel.wxpay.WxResultHelper;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import java.io.File;

public final class cmb {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile boolean f14118O000000o = false;

    public static boolean O000000o() {
        return cmc.O0000O0o();
    }

    public static void O00000Oo() {
        if (!ftn.O00000oO(ServiceApplication.getAppContext())) {
            try {
                WxResultHelper.setWxAppId("wx54b959a68fb6f580");
                WxResultHelper.setInterceptor($$Lambda$cmb$nK5_aoyFFb2jJucdXFt4AMltll8.INSTANCE);
                if (Build.VERSION.SDK_INT >= 24) {
                    Context appContext = CommonApplication.getAppContext();
                    appContext.getSharedPreferences("WebViewChromiumPrefs", 0).edit().clear().apply();
                    gfo.O000000o(new File(appContext.getDir("webview", 0) + File.separator + "GPUCache"));
                }
            } catch (Exception e) {
                gfo.O000000o(e.getMessage());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (cmd.O000000o() == null) {
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean O000000o(BaseResp baseResp) {
        if (!(baseResp instanceof PayResp)) {
            return false;
        }
        PayResp payResp = (PayResp) baseResp;
        int i = payResp.errCode;
        String str = payResp.returnKey;
        ft O000000o2 = ft.O000000o(ServiceApplication.getAppContext());
        Intent intent = new Intent("com.xiaomi.smarthome.action.WX_PAY_RESULT");
        intent.putExtra("extra_error_code", i);
        intent.putExtra("extra_error_message", str);
        O000000o2.O000000o(intent);
        return true;
    }
}
