package _m_j;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.image.ReactImageManager;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.plugin.rn.fixbug.image.FixReactImageManager;
import com.xiaomi.smarthome.framework.plugin.rn.fixbug.statusbar.FixStatusBarModule;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.net.HttpCookie;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public final class fxn extends MainReactPackage {
    public final NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        if ("StatusBarManager".equals(str)) {
            return new FixStatusBarModule(reactApplicationContext);
        }
        return super.getModule(str, reactApplicationContext);
    }

    public final List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        HttpCookie O000000o2;
        O000000o o000000o = new O000000o((byte) 0);
        if (!o000000o.f17377O000000o) {
            o000000o.f17377O000000o = true;
            CookieSyncManager.createInstance(reactApplicationContext);
            CookieManager instance = CookieManager.getInstance();
            String O0000oO = CoreApi.O000000o().O0000oO();
            if (TextUtils.isEmpty(O0000oO) && (O000000o2 = icp.O000000o(icf.O000000o().f1176O000000o, "passToken", "")) != null) {
                O0000oO = O000000o2.getValue();
            }
            if (!TextUtils.isEmpty(O0000oO)) {
                O000000o.O000000o(instance, "passToken", O0000oO, ".account.xiaomi.com");
            }
            hkd.O000000o(instance, ".home.mi.com");
            hkd.O000000o(instance, ".account.xiaomi.com");
            hkd.O000000o(reactApplicationContext, instance);
            try {
                MiServiceTokenInfo O000000o3 = CoreApi.O000000o().O000000o("xiaomiio");
                if (O000000o3 != null) {
                    O000000o.O000000o(instance, "serviceToken", URLEncoder.encode(O000000o3.O00000o0, "UTF-8"), ".io.mi.com");
                }
                MiServiceTokenInfo O000000o4 = CoreApi.O000000o().O000000o("xiaomihome");
                if (O000000o4 != null) {
                    O000000o.O000000o(instance, "serviceToken", URLEncoder.encode(O000000o4.O00000o0, "UTF-8"), ".home.mi.com");
                }
                MiServiceTokenInfo O000000o5 = CoreApi.O000000o().O000000o("i.ai.mi.com");
                if (O000000o5 != null) {
                    O000000o.O000000o(instance, "serviceToken", O000000o5.O00000o0, ".i.ai.mi.com");
                    O000000o.O000000o(instance, "userId", URLEncoder.encode(CoreApi.O000000o().O0000o0(), "UTF-8"), ".i.ai.mi.com");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ArrayList<Pair> arrayList = new ArrayList<>();
        List<ViewManager> createViewManagers = super.createViewManagers(reactApplicationContext);
        for (ViewManager next : createViewManagers) {
            if (next instanceof ReactImageManager) {
                gbu.O000000o("will replace ReactImageManager...");
                arrayList.add(new Pair(next, new FixReactImageManager()));
            }
        }
        for (Pair pair : arrayList) {
            createViewManagers.remove(pair.first);
            createViewManagers.add(pair.second);
        }
        return createViewManagers;
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f17377O000000o;

        private O000000o() {
            this.f17377O000000o = false;
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }

        static void O000000o(CookieManager cookieManager, String str, String str2, String str3) {
            if (str2 != null) {
                cookieManager.setCookie(str3, str + "=" + str2 + "; domain=" + str3);
            }
        }
    }
}
