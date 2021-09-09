package _m_j;

import _m_j.ccp;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.mi.global.shop.newmodel.domain.DomainModel;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.youpin.login.entity.Error;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class hth {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Map<String, String> f619O000000o;
    private static ccq O00000Oo;
    private static boolean O00000o = false;
    private static boolean O00000o0 = false;

    static {
        HashMap hashMap = new HashMap();
        f619O000000o = hashMap;
        hashMap.put("IN", cad.O00000o);
        f619O000000o.put("TW", cad.O00000oO);
        f619O000000o.put("HK", cad.O00000oo);
        f619O000000o.put("RU", cad.O0000OoO);
        f619O000000o.put("FR", cad.O0000Oo0);
        f619O000000o.put("ES", cad.O0000OOo);
        f619O000000o.put("ID", cad.O0000O0o);
        f619O000000o.put("GB", cad.O0000Ooo);
        f619O000000o.put("IT", cad.O0000Oo);
    }

    public static String O000000o(ServerBean serverBean) {
        String O000000o2 = O000000o(serverBean.O00000Oo);
        String str = TextUtils.equals(O000000o2, cad.O00000oO) ? "/service" : "/about";
        return "https://mobile.mi.com/" + O000000o2 + str + "/privacy";
    }

    public static boolean O00000Oo(ServerBean serverBean) {
        return !TextUtils.isEmpty(O000000o(serverBean.O00000Oo));
    }

    public static boolean O000000o(Context context) {
        return !TextUtils.isEmpty(O00000Oo(context));
    }

    public static String O00000Oo(Context context) {
        ServerBean O000000o2 = fdc.O000000o().O000000o(context);
        if (O000000o2 == null) {
            return "";
        }
        return O000000o(O000000o2.O00000Oo);
    }

    public static String O000000o(String str) {
        if (f619O000000o.containsKey(str)) {
            return f619O000000o.get(str);
        }
        return null;
    }

    public static void O000000o() {
        try {
            if (ftm.O000000o(CommonApplication.getAppContext())) {
                gsy.O00000Oo(LogType.GENERAL, "ShopGlobalHelper", "onLogout ");
                if (!O000000o(CommonApplication.getAppContext())) {
                    return;
                }
                if (O00000o) {
                    gsy.O00000Oo(LogType.GENERAL, "MijiaShopApp", "ShopApp.logout");
                    byl.O0000o00();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void O00000Oo() {
        try {
            if (ftm.O000000o(CommonApplication.getAppContext())) {
                gsy.O00000Oo(LogType.GENERAL, "ShopGlobalHelper", "onLoginSuccess");
                if (O000000o(CommonApplication.getAppContext())) {
                    O000000o(false);
                    if (!O00000o0()) {
                        O000000o(null, null);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void O00000o0(final ServerBean serverBean) {
        try {
            if (ftm.O000000o(CommonApplication.getAppContext()) && O000000o(CommonApplication.getAppContext())) {
                LogType logType = LogType.GENERAL;
                gsy.O00000Oo(logType, "ShopGlobalHelper", "afterSwitchRegionClean " + O00000Oo(CommonApplication.getApplication()));
                boolean z = false;
                O00000o0 = false;
                if (gfr.O0000OOo || gfr.O0000Ooo) {
                    z = true;
                }
                gsy.O00000Oo("ShopGlobalHelper", "ShopApp.printLog=".concat(String.valueOf(z)));
                byl.O000000o(z);
                byl.O000000o(O00000Oo(CommonApplication.getAppContext()), f619O000000o.get(serverBean) != null ? f619O000000o.get(serverBean) : cad.O00000o0, new cco() {
                    /* class _m_j.hth.AnonymousClass1 */

                    public final void O000000o() {
                        if (hth.f619O000000o.containsKey(serverBean) && !TextUtils.equals(hth.f619O000000o.get(serverBean), hth.O00000Oo(CommonApplication.getAppContext()))) {
                            LogType logType = LogType.GENERAL;
                            gsy.O00000Oo(logType, "ShopGlobalHelper", "cleanOver done, will init " + hth.f619O000000o.get(serverBean));
                            hth.O000000o(false);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x008e A[Catch:{ Throwable -> 0x0071, Throwable -> 0x00d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cf A[Catch:{ Throwable -> 0x0071, Throwable -> 0x00d9 }] */
    public static void O000000o(boolean z) {
        boolean z2;
        gsy.O000000o(3, "ShopGlobalHelper", "initMiShopGlobalSDK force=" + z + ",sShopGlobalInitiled=" + O00000o0);
        if (z || !O00000o0) {
            if (!z) {
                try {
                    if (!ftm.O000000o(CommonApplication.getAppContext())) {
                        return;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    LogType logType = LogType.GENERAL;
                    gsy.O00000Oo(logType, "ShopGlobalHelper", "initMiShopGlobalSDK exception " + th.getMessage());
                    return;
                }
            }
            boolean z3 = true;
            O00000o0 = true;
            if (!z) {
                if (!O000000o(CommonApplication.getAppContext())) {
                    z2 = false;
                    gsy.O00000Oo(LogType.GENERAL, "ShopGlobalHelper", "initMiShopGlobalSDK ".concat(String.valueOf(z2)));
                    if (!z2) {
                        O000000o(null, null);
                        if (!gfr.O0000OOo) {
                            if (!gfr.O0000Ooo) {
                                z3 = false;
                            }
                        }
                        gsy.O00000Oo("ShopGlobalHelper", "ShopApp.printLog=".concat(String.valueOf(z3)));
                        byl.O000000o(z3);
                        byl.O0000o0();
                        O00000Oo = new ccq() {
                            /* class _m_j.hth.AnonymousClass2 */

                            public final void O000000o(String str) {
                                gsy.O00000Oo(LogType.GENERAL, "ShopGlobalHelper", "onNeedLogin ".concat(String.valueOf(str)));
                                if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
                                    hth.O00000Oo(str);
                                    return;
                                }
                                gtx O000000o2 = gty.O000000o();
                                if (O000000o2 != null) {
                                    O000000o2.startLogin(CommonApplication.getAppContext(), 5, null);
                                }
                            }
                        };
                        LogType logType2 = LogType.GENERAL;
                        gsy.O00000Oo(logType2, "MijiaShopApp", "ShopApp.tokenExpiredListener " + O00000Oo);
                        byl.O00000oo = O00000Oo;
                        return;
                    }
                    gsy.O00000Oo(LogType.GENERAL, "MijiaShopApp", "ShopApp.tokenExpiredListener set null");
                    byl.O00000oo = null;
                    return;
                }
            }
            String O00000Oo2 = O00000Oo(CommonApplication.getAppContext());
            gsy.O00000Oo(LogType.GENERAL, "MijiaShopApp", "ShopApp.init ".concat(String.valueOf(O00000Oo2)));
            O00000o = false;
            byl.O000000o((Application) CommonApplication.getAppContext(), O00000Oo2, "mihome_sdk");
            exx.O000000o(true);
            O00000o = true;
            z2 = true;
            gsy.O00000Oo(LogType.GENERAL, "ShopGlobalHelper", "initMiShopGlobalSDK ".concat(String.valueOf(z2)));
            if (!z2) {
            }
        }
    }

    public static boolean O00000o0() {
        try {
            gsy.O00000Oo(LogType.GENERAL, "ShopGlobalHelper", "preFetchSidToken");
            if (!O000000o(CommonApplication.getAppContext()) || ServiceApplication.getStateNotifier().f15923O000000o != 4) {
                return false;
            }
            ArrayList<DomainModel> arrayList = null;
            arrayList = byl.O000000o();
            if (arrayList != null) {
                if (!arrayList.isEmpty()) {
                    String str = "";
                    if (O000000o(CommonApplication.getAppContext())) {
                        str = cad.O00000Oo(O00000Oo(CommonApplication.getAppContext()));
                    }
                    gsy.O00000Oo(LogType.GENERAL, "ShopGlobalHelper", "preFetchSidToken found sid=".concat(String.valueOf(str)));
                    if (TextUtils.isEmpty(str)) {
                        return false;
                    }
                    return O00000Oo(str);
                }
            }
            return false;
        } catch (Throwable th) {
            th.getMessage();
            LogType logType = LogType.GENERAL;
            gsy.O00000Oo(logType, "ShopGlobalHelper", "preFetchSidToken exception " + th.getMessage());
            return false;
        }
    }

    public static void O000000o(String str, final ExtendedAuthToken extendedAuthToken) {
        String str2;
        if (O00000o) {
            try {
                LogType logType = LogType.GENERAL;
                StringBuilder sb = new StringBuilder("setLoginData sid=");
                sb.append(str);
                sb.append(",");
                sb.append(extendedAuthToken == null ? null : extendedAuthToken.toPlain());
                gsy.O00000Oo(logType, "ShopGlobalHelper", sb.toString());
                ccp.O000000o o000000o = new ccp.O000000o("mihome_sdk", O000000o(CommonApplication.getAppContext()) ? O00000Oo(CommonApplication.getAppContext()) : "");
                o000000o.f13637O000000o = str;
                if (O000000o(CommonApplication.getAppContext())) {
                    str2 = O00000Oo(CommonApplication.getAppContext());
                } else {
                    str2 = "";
                }
                o000000o.O00000o = str2;
                o000000o.O00000o0 = extendedAuthToken;
                if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
                    o000000o.O00000Oo = CoreApi.O000000o().O0000o0();
                } else {
                    o000000o.O00000Oo = "";
                }
                final ccp O000000o2 = o000000o.O000000o();
                gsy.O00000Oo(LogType.GENERAL, "MijiaShopApp", "ShopApp.paramGroup write ".concat(String.valueOf(O000000o2)));
                byl.O0000O0o = O000000o2;
                goq.O000000o(new Runnable() {
                    /* class _m_j.hth.AnonymousClass3 */

                    public final void run() {
                        gsy.O00000Oo(LogType.GENERAL, "MijiaShopApp", "ShopApp.setLoginData paramGroup");
                        try {
                            byl.O000000o(CoreApi.O000000o().O0000oO0(), O000000o2.O00000Oo, extendedAuthToken);
                        } catch (Throwable th) {
                            gsy.O00000o0(LogType.MAIN_PAGE, "ShopGlobalHelper", Log.getStackTraceString(th));
                        }
                    }
                });
            } catch (Throwable th) {
                th.getMessage();
                LogType logType2 = LogType.GENERAL;
                gsy.O00000Oo(logType2, "ShopGlobalHelper", "setLoginData exception " + th.getMessage());
            }
        }
    }

    public static boolean O00000Oo(final String str) {
        try {
            gsy.O00000Oo(LogType.GENERAL, "ShopGlobalHelper", "refreshToken ".concat(String.valueOf(str)));
            if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
                return false;
            }
            gtx O000000o2 = gty.O000000o();
            if (O000000o2 == null) {
                return true;
            }
            O000000o2.refreshServiceToken(str, new ibh<MiServiceTokenInfo, Error>() {
                /* class _m_j.hth.AnonymousClass4 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    MiServiceTokenInfo miServiceTokenInfo = (MiServiceTokenInfo) obj;
                    if (gfr.O0000Ooo) {
                        gsy.O000000o(3, "ShopGlobalFragment", "global shop token onSuccess");
                    }
                    hth.O000000o(str, ExtendedAuthToken.build(miServiceTokenInfo.O00000o0, miServiceTokenInfo.O00000o));
                }

                public final void onFailure(Error error) {
                    if (gfr.O0000Ooo) {
                        gsy.O000000o(3, "ShopGlobalFragment", "global shop token fail:".concat(String.valueOf(error)));
                    }
                    hth.O000000o(str, null);
                }
            });
            return true;
        } catch (Throwable th) {
            th.getMessage();
            LogType logType = LogType.GENERAL;
            gsy.O00000Oo(logType, "ShopGlobalHelper", "refreshToken exception " + th.getMessage());
            return false;
        }
    }
}
