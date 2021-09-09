package _m_j;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.mibi.sdk.common.LocalBroadcastManager;
import com.miot.spec.SpecManager;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.xiaomi.account.openid.OauthAccountManager;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.SHApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.auth.OAuthXiaomiAccount;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.youpin.login.entity.Error;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import com.xiaomi.youpin.login.entity.error.ExceptionError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class faa {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile boolean f15991O000000o = false;

    /* JADX WARNING: Can't wrap try/catch for region: R(10:8|9|10|11|12|(1:14)|15|(1:17)(1:18)|19|(7:21|(1:23)(1:24)|25|(4:28|(2:30|44)(1:43)|41|26)|42|31|(1:33))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003f */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00ba  */
    public static void O000000o(final Context context, boolean z) {
        fci fci;
        List<String> list;
        if (!f15991O000000o) {
            synchronized (faa.class) {
                if (!f15991O000000o) {
                    if (z) {
                        hyv.O000000o().initFloatView();
                        CommonApplication.getGlobalWorkerHandler().postDelayed(new Runnable() {
                            /* class _m_j.faa.AnonymousClass6 */

                            public final void run() {
                                try {
                                    OauthAccountManager.setOauthAccount(new OAuthXiaomiAccount(CommonApplication.getAppContext()));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    gsy.O00000o0(LogType.STARTUP, "OAuth", e.getMessage());
                                }
                            }
                        }, 1000);
                        exx.O000000o(false);
                        gsv.O000000o(context);
                        gwa.O000000o().initMicoHelper(context);
                        SHApplication.getApplication().registerActivityLifecycleCallbacks(gwa.O000000o().getMicoActivityLifecycleMonitor());
                        if (!ggb.O0000o00()) {
                            CommonApplication.getGlobalWorkerHandler().postDelayed(new Runnable() {
                                /* class _m_j.faa.AnonymousClass5 */

                                public final void run() {
                                    try {
                                        WbSdk.install(context, new AuthInfo(context, "916875316", "https://api.weibo.com/oauth2/default.html", ""));
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }
                            }, 3000);
                        }
                        dco O000000o2 = dco.O000000o();
                        if (fbs.O000000o(fci.class, "com.xiaomi.smarthome.connect.home.IMiConnectBridgeApi") == null) {
                            fci = (fci) fbs.O000000o(fci.class, "com.xiaomi.smarthome.connect.home.IMiConnectBridgeApi");
                        } else {
                            fci = new fch();
                        }
                        O000000o2.O000000o(fci.getIotHomeCallBack());
                        SHApplication.getGlobalWorkerHandler().postDelayed(new Runnable() {
                            /* class _m_j.faa.AnonymousClass1 */

                            public final void run() {
                                etx.O000000o().O00000Oo();
                                try {
                                    SpecManager specManager = SpecManager.O000000o.f5247O000000o;
                                    SpecManager.O00000oo = SHApplication.getAppContext();
                                    cnd.O000000o("SpecManager", "init", new Object[0]);
                                    if (specManager.O0000O0o == null) {
                                        specManager.O0000O0o = new SpecManager.SpecReceiver();
                                        IntentFilter intentFilter = new IntentFilter("action.miot.receive.specv2.ble.data");
                                        intentFilter.addAction("action.miot.write.specv2.ble.data.resp");
                                        intentFilter.addAction("com.xiaomi.smarthome.support.ble.spec.protocol");
                                        intentFilter.addAction("com.xiaomi.smarthome.bluetooth.connect_status_changed");
                                        SpecManager.O00000oo.registerReceiver(specManager.O0000O0o, intentFilter);
                                    }
                                    faa.O000000o();
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                        }, 2000);
                        hsw.O000000o().getShareManagerInstance();
                        goq.O00000o(new Runnable() {
                            /* class _m_j.faa.AnonymousClass2 */

                            public final void run() {
                                gue.O000000o().getCommonDeviceModel();
                            }
                        });
                        CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
                            /* class _m_j.faa.AnonymousClass3 */

                            public final void run() {
                                if (!fkl.O000000o().O00000o0()) {
                                    PluginDeviceManager.instance.updateConfig(false, null);
                                    fkl.O000000o().O00000Oo();
                                }
                            }
                        });
                        CommonApplication.enterForeground();
                        CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
                            /* class _m_j.faa.AnonymousClass4 */

                            public final void run() {
                                LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("ACTION_APP_HAS_ENTERED_FOREGROUND"));
                            }
                        });
                        if (CoreApi.O000000o().O0000Ooo()) {
                            gsy.O00000Oo(LogType.LOGIN, "Request-Optional-Sids", "syncServiceTokenIfNeeded");
                            if (ftn.O00000oo(ServiceApplication.getAppContext())) {
                                list = ibm.f1156O000000o.O0000Oo0;
                            } else {
                                list = ibm.f1156O000000o.O0000Oo;
                            }
                            ArrayList arrayList = new ArrayList();
                            for (String str : list) {
                                if (CoreApi.O000000o().O000000o(str) == null) {
                                    arrayList.add(str);
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                LogType logType = LogType.LOGIN;
                                gsy.O00000Oo(logType, "Request-Optional-Sids", "sync optional sids: " + Arrays.deepToString(arrayList.toArray()));
                                ick.O000000o(ServiceApplication.getAppContext(), arrayList, new ibh<List<MiServiceTokenInfo>, ExceptionError>() {
                                    /* class _m_j.ftk.AnonymousClass3 */

                                    public final /* bridge */ /* synthetic */ void onFailure(Error error) {
                                    }

                                    public final /* synthetic */ void onSuccess(Object obj) {
                                        List<MiServiceTokenInfo> list = (List) obj;
                                        LogType logType = LogType.LOGIN;
                                        gsy.O00000Oo(logType, "Request-Optional-Sids", "sync optional sid success: " + Arrays.deepToString(list.toArray()));
                                        for (MiServiceTokenInfo O000000o2 : list) {
                                            CoreApi.O000000o().O000000o(O000000o2, (fsm<Void, fso>) null);
                                        }
                                    }
                                });
                            }
                        }
                    }
                    f15991O000000o = true;
                }
            }
        }
    }

    public static void O000000o() {
        frp O000000o2 = fro.O000000o();
        if (O000000o2 != null) {
            O000000o2.initFacebookSdk(gfr.O0000Ooo || gfr.O0000OOo);
        }
    }
}
