package _m_j;

import android.content.Context;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.operation.helper.HttpApiHomeMiCookieHelper$Companion$cookieManager$2;
import com.xiaomi.smarthome.operation.helper.HttpApiHomeMiCookieHelper$Companion$host$2;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/xiaomi/smarthome/operation/helper/HttpApiHomeMiCookieHelper;", "", "()V", "Companion", "app-support-util_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hjx {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f19006O000000o = new O000000o((byte) 0);
    public static final itz<CookieManager> O00000Oo = iua.O000000o(HttpApiHomeMiCookieHelper$Companion$cookieManager$2.f10506O000000o);
    public static final itz<String> O00000o0 = iua.O000000o(HttpApiHomeMiCookieHelper$Companion$host$2.f10507O000000o);

    public static final void O00000Oo() {
        f19006O000000o.O00000Oo();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\b\u0010\u0015\u001a\u00020\u0011H\u0007J\b\u0010\u0016\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/xiaomi/smarthome/operation/helper/HttpApiHomeMiCookieHelper$Companion;", "", "()V", "TAG", "", "cookieManager", "Ljava/net/CookieManager;", "getCookieManager", "()Ljava/net/CookieManager;", "cookieManager$delegate", "Lkotlin/Lazy;", "domain", "host", "getHost", "()Ljava/lang/String;", "host$delegate", "clearAll", "", "install", "name", "value", "installCommonOnce", "installUidAndToken", "app-support-util_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ ixy<Object>[] f19007O000000o = {ixf.O000000o(new PropertyReference1Impl(ixf.O000000o(O000000o.class), "cookieManager", "getCookieManager()Ljava/net/CookieManager;")), ixf.O000000o(new PropertyReference1Impl(ixf.O000000o(O000000o.class), "host", "getHost()Ljava/lang/String;"))};

        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }

        static CookieManager O000000o() {
            return hjx.O00000Oo.O000000o();
        }

        private static String O00000o0() {
            String O000000o2 = hjx.O00000o0.O000000o();
            ixe.O00000Oo(O000000o2, "<get-host>(...)");
            return O000000o2;
        }

        public final void O00000Oo() {
            if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
                String O0000o = CoreApi.O000000o().O0000o();
                if (O0000o.length() > 1) {
                    ixe.O00000Oo(O0000o, "cUserId");
                    O000000o("cUserId", O0000o);
                }
                if (hka.O00000Oo()) {
                    String O0000o0 = CoreApi.O000000o().O0000o0();
                    if (O0000o0.length() > 1) {
                        ixe.O00000Oo(O0000o0, "userId");
                        O000000o("userId", O0000o0);
                    }
                }
                try {
                    MiServiceTokenInfo O000000o2 = CoreApi.O000000o().O000000o("xiaomiio");
                    if (O000000o2 != null) {
                        O000000o o000000o = hjx.f19006O000000o;
                        String encode = URLEncoder.encode(O000000o2.O00000o0, "UTF-8");
                        ixe.O00000Oo(encode, "encode(it.serviceToken, \"UTF-8\")");
                        O000000o("yetAnotherServiceToken", encode);
                        gsy.O00000Oo(LogType.WEBVIEW, "HttpApiHomeMiCookieHelp", "initUidAndTokenCookieForHomeMi: ioServiceToken : ");
                    }
                    MiServiceTokenInfo O000000o3 = CoreApi.O000000o().O000000o("xiaomihome");
                    if (O000000o3 != null) {
                        O000000o o000000o2 = hjx.f19006O000000o;
                        String encode2 = URLEncoder.encode(O000000o3.O00000o0, "UTF-8");
                        ixe.O00000Oo(encode2, "encode(it.serviceToken, \"UTF-8\")");
                        O000000o("serviceToken", encode2);
                        gsy.O00000Oo(LogType.WEBVIEW, "HttpApiHomeMiCookieHelp", "initUidAndTokenCookieForHomeMi: miHomeServiceToken : ");
                    }
                } catch (Exception e) {
                    gsy.O00000Oo(LogType.WEBVIEW, "HttpApiHomeMiCookieHelp", e.getMessage());
                }
            }
        }

        public static void O000000o(String str, String str2) {
            ixe.O00000o(str, "name");
            ixe.O00000o(str2, "value");
            CookieManager O000000o2 = O000000o();
            if (O000000o2 != null) {
                hjy.O000000o(O000000o2, O00000o0(), str, str2, ".home.mi.com", "/");
            }
        }
    }

    public static final void O000000o() {
        CookieStore cookieStore;
        CookieManager O000000o2 = O000000o.O000000o();
        if (O000000o2 != null && (cookieStore = O000000o2.getCookieStore()) != null) {
            cookieStore.removeAll();
        }
    }

    public static final void O00000o0() {
        Context appContext = CommonApplication.getAppContext();
        ServerBean O000000o2 = ftn.O000000o(appContext);
        if (O000000o2 != null) {
            String str = O000000o2.O00000Oo;
            ixe.O00000Oo(str, "it.countryCode");
            O000000o.O000000o("countryCode", str);
        }
        String O000000o3 = flk.O000000o(ftn.O00000o0(appContext));
        ixe.O00000Oo(O000000o3, "getNewCodeLocaleString(ServerCompact.getGlobalSettingLocale(context))");
        O000000o.O000000o("locale", O000000o3);
        String str2 = gfr.O0000o0O;
        ixe.O00000Oo(str2, "CHANNEL");
        O000000o.O000000o("channel", str2);
    }
}
