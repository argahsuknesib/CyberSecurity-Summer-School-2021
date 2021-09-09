package com.xiaomi.smarthome.frame.login;

import _m_j.cmc;
import _m_j.cmd;
import _m_j.dgn;
import _m_j.ezo;
import _m_j.flk;
import _m_j.fnh;
import _m_j.fno;
import _m_j.fro;
import _m_j.frp;
import _m_j.fsm;
import _m_j.fsn;
import _m_j.fso;
import _m_j.fsp;
import _m_j.ft;
import _m_j.ftn;
import _m_j.fus;
import _m_j.gfr;
import _m_j.gft;
import _m_j.gfu;
import _m_j.ggb;
import _m_j.gge;
import _m_j.goy;
import _m_j.gpu;
import _m_j.gpv;
import _m_j.grw;
import _m_j.gsy;
import _m_j.gty;
import _m_j.gtz;
import _m_j.gvf;
import _m_j.hje;
import _m_j.hna;
import _m_j.hor;
import _m_j.htv;
import _m_j.htw;
import _m_j.hxi;
import _m_j.ibh;
import _m_j.ibp;
import _m_j.jdc;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import com.tencent.bugly.crashreport.CrashReport;
import com.xiaomi.accountsdk.utils.AccountRecentExceptionRecorder;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.camera.api.CameraRouterFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.redpoint.ServerTimerManager;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.youpin.login.api.manager.LoginManager;
import com.xiaomi.youpin.login.entity.Error;
import com.xiaomi.youpin.login.entity.account.LoginMiAccount;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONObject;

public class MijiaLoginManager extends LoginManager {
    public static volatile long O00000Oo;
    private static final Object O00000oo = new Object();
    private static volatile MijiaLoginManager O0000O0o;

    /* renamed from: O000000o  reason: collision with root package name */
    public List<O000000o> f7521O000000o = new ArrayList();
    private Subject<Integer> O0000OOo = BehaviorSubject.create();
    private volatile boolean O0000Oo0 = false;

    public interface O000000o {
        void O000000o();

        void O00000Oo();
    }

    public MijiaLoginManager(Context context) {
        super(context);
    }

    public static MijiaLoginManager O000000o() {
        if (O0000O0o == null) {
            synchronized (O00000oo) {
                if (O0000O0o == null) {
                    O0000O0o = new MijiaLoginManager(ServiceApplication.getAppContext());
                }
            }
        }
        return O0000O0o;
    }

    private void O00000o() {
        int i = 0;
        while (i < this.f7521O000000o.size()) {
            try {
                O000000o o000000o = this.f7521O000000o.get(i);
                if (o000000o != null) {
                    o000000o.O000000o();
                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        gsy.O00000Oo(LogType.LOGIN, "LoginManager", "notifyLoginSuccess 4");
        this.O0000OOo.onNext(4);
    }

    public final void O00000Oo() {
        int i = 0;
        while (i < this.f7521O000000o.size()) {
            try {
                O000000o o000000o = this.f7521O000000o.get(i);
                if (o000000o != null) {
                    o000000o.O00000Oo();
                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        gsy.O00000Oo(LogType.LOGIN, "LoginManager", "notifyLogout 3");
        this.O0000OOo.onNext(3);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, com.xiaomi.smarthome.frame.core.CoreApi$O000O0o0):void
     arg types: [int, com.xiaomi.smarthome.frame.login.MijiaLoginManager$5]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.account.OAuthAccount, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.frame.server_compact.ServerBean, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.youpin.login.entity.account.LoginMiAccount, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<com.xiaomi.smarthome.core.server.internal.device.BatchRpcParam>, _m_j.fsm<org.json.JSONObject, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.Locale, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader):com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(long, long):java.lang.String
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o00):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o0):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O00oOooO):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest, com.xiaomi.smarthome.core.server.bluetooth.SearchResponse):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, byte[]):byte[]
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, com.xiaomi.smarthome.frame.core.CoreApi$O000O0o0):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpu.O000000o(android.content.Context, boolean):void
     arg types: [android.content.Context, int]
     candidates:
      _m_j.gpu.O000000o(android.content.Context, int):boolean
      _m_j.gpu.O000000o(android.content.Context, boolean):void */
    public final void O000000o(int i) {
        gfu O000000o2;
        gsy.O00000Oo(LogType.LOGIN, "LoginManager", "onLoginSuccess");
        O00000Oo = System.currentTimeMillis();
        Context appContext = ServiceApplication.getAppContext();
        if (gpv.O00000Oo(appContext, "message_center_new_msg_timestamp" + CoreApi.O000000o().O0000o0(), -1) == -1) {
            Context appContext2 = ServiceApplication.getAppContext();
            gpv.O000000o(appContext2, "message_center_new_msg_timestamp" + CoreApi.O000000o().O0000o0(), (System.currentTimeMillis() + ServerTimerManager.O000000o(CommonApplication.getAppContext()).O00000Oo()) / 1000);
        }
        Context appContext3 = ServiceApplication.getAppContext();
        if (gpv.O00000Oo(appContext3, "setting_main_new_msg_timestamp" + CoreApi.O000000o().O0000o0(), -1) == -1) {
            Context appContext4 = ServiceApplication.getAppContext();
            gpv.O000000o(appContext4, "setting_main_new_msg_timestamp" + CoreApi.O000000o().O0000o0(), (System.currentTimeMillis() + ServerTimerManager.O000000o(CommonApplication.getAppContext()).O00000Oo()) / 1000);
        }
        ServiceApplication.getGlobalHandler().postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.frame.login.MijiaLoginManager.AnonymousClass4 */

            public final void run() {
                gsy.O00000Oo(LogType.LOGIN, "PushManager", "onLoginSuccess : registerPushId");
                ezo.O000000o().registerPushId();
            }
        }, 5000);
        if (cmd.O000000o() != null) {
            gsy.O00000Oo("YoupinApiHelper", "onLoginSuccess");
        }
        ServiceApplication.getStateNotifier().O00000o0();
        fus.O000000o();
        ServiceApplication.getAppContext().sendBroadcast(new Intent("update_remote_wifi_log"));
        ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("action_on_login_success"));
        O00000o();
        ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("com.xiaomi.youpin.action.on_login"));
        LoginMiAccount O0000oOo = CoreApi.O000000o().O0000oOo();
        if (O0000oOo != null) {
            ServiceApplication.getAppContext();
            hje.O000000o();
            O0000oOo.O00000oO();
            hje.O00000Oo();
        }
        if (i != 1) {
            fno.O000000o().O0000o0O();
            hor.O000000o().clearSceneManager();
            hor.O000000o().updateTemplate();
            CoreApi.O000000o().O000000o(true, (CoreApi.O000O0o0) new CoreApi.O000O0o0() {
                /* class com.xiaomi.smarthome.frame.login.MijiaLoginManager.AnonymousClass5 */

                public final void O000000o(boolean z) {
                    if (z) {
                        fno.O000000o().O0000Ooo();
                    }
                }
            });
            try {
                CoreApi.O000000o().O00000Oo().updateWhiteList(true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        ServiceApplication.getGlobalHandler().postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.frame.login.MijiaLoginManager.AnonymousClass6 */

            public final void run() {
                if (!goy.O000000o(ServiceApplication.getAppContext())) {
                    return;
                }
                if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                    cmc.O00000o0();
                } else if (cmd.O000000o() != null) {
                    gsy.O00000Oo("YoupinApiHelper", "updateAccount");
                }
            }
        }, 1000);
        try {
            if (gfr.O0000oO0 && (O000000o2 = gft.O000000o()) != null) {
                O000000o2.onLoginSuccess();
            }
            Context appContext5 = ServiceApplication.getAppContext();
            int i2 = 10008;
            if (Build.VERSION.SDK_INT < 23) {
                i2 = 50;
            }
            if (!gpu.O000000o(appContext5, i2)) {
                gpu.O000000o(ServiceApplication.getAppContext(), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final fsn O000000o(final fsm<Void, fso> fsm, String str) {
        LogType logType = LogType.LOGIN;
        gsy.O00000o0(logType, "LoginManager", "logout start: " + str + " stack:" + Log.getStackTraceString(new Exception()));
        return ezo.O000000o().unregisterPushId(new fsm<Void, fso>() {
            /* class com.xiaomi.smarthome.frame.login.MijiaLoginManager.AnonymousClass8 */

            public final void onFailure(fso fso) {
                fsm fsm = fsm;
                if (fsm != null) {
                    fsm.sendFailureMessage(new fso(-9999, ""));
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                gty.O000000o().startLogout(true, new ibh<Void, Error>() {
                    /* class com.xiaomi.smarthome.frame.login.MijiaLoginManager.AnonymousClass8.AnonymousClass1 */

                    public final void onFailure(Error error) {
                        if (fsm != null) {
                            fsm.sendFailureMessage(new fso(-9999, ""));
                        }
                        gsy.O00000Oo(4000, "4000.2.1", "");
                    }

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.gpv.O00000Oo(java.lang.String, boolean):void
                     arg types: [java.lang.String, int]
                     candidates:
                      _m_j.gpv.O00000Oo(android.content.Context, java.lang.String):void
                      _m_j.gpv.O00000Oo(java.lang.String, java.lang.String):void
                      _m_j.gpv.O00000Oo(java.lang.String, boolean):void */
                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.gpu.O000000o(android.content.Context, boolean):void
                     arg types: [android.content.Context, int]
                     candidates:
                      _m_j.gpu.O000000o(android.content.Context, int):boolean
                      _m_j.gpu.O000000o(android.content.Context, boolean):void */
                    public final /* synthetic */ void onSuccess(Object obj) {
                        try {
                            hna.O00000o0().clearDevicePushBind();
                            gge.O000000o().O00000Oo();
                            fno.O000000o().O0000Oo();
                            hor.O000000o().clearSceneManager();
                        } catch (Exception e) {
                            e.printStackTrace();
                            try {
                                LogType logType = LogType.LOGIN;
                                gsy.O00000Oo(logType, "LoginManager", "logout exception " + e.getMessage());
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        try {
                            CoreApi.O000000o().O000O0o0();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        try {
                            ServiceApplication.getStateNotifier().O0000O0o();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                        ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("update_remote_wifi_log"));
                        try {
                            CameraRouterFactory.getCameraManagerApi().cameraFrameManagerDestroyAllContext(ServiceApplication.getAppContext());
                            CameraRouterFactory.getCameraManagerApi().cameraInfoRefreshManagerClear();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                        try {
                            ezo.O000000o().clearRegedPushIDAndDeviceID();
                            htw O000000o2 = htv.O000000o();
                            if (O000000o2 != null) {
                                O000000o2.stopScanNewDevice();
                            }
                            fus.O000000o();
                            ServiceApplication.getAppContext();
                            hje.O000000o();
                            hje.O00000o0();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                        ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("action_on_logout"));
                        try {
                            MijiaLoginManager.this.O00000Oo();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                        }
                        ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("com.xiaomi.youpin.action.on_logout"));
                        gpv.O00000Oo("message_center_red_dot_clicked", true);
                        gpv.O00000Oo("my_home_red_dot_clicked", true);
                        try {
                            CookieManager.getInstance().removeAllCookie();
                            cmc.O00000o0();
                            fnh.O000000o().O00000Oo();
                            hor.O000000o().clearLiteSceneManager();
                            gvf.O000000o().clear();
                            hor.O000000o().clearRecommendSceneManager();
                        } catch (Exception e8) {
                            e8.printStackTrace();
                        }
                        try {
                            if (fsm != null) {
                                fsm.sendSuccessMessage(null);
                            }
                        } catch (Exception e9) {
                            e9.printStackTrace();
                        }
                        try {
                            gpu.O000000o(ServiceApplication.getAppContext(), false);
                            fno.O000000o().O0000Oo0();
                            frp O000000o3 = fro.O000000o();
                            if (O000000o3 != null) {
                                O000000o3.logOut();
                            }
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    public final void O00000o0() {
        fsp.O000000o().O00000oo.O000000o();
    }

    public final void O000000o(String str, LoginMiAccount loginMiAccount, Map<String, String> map, ibp ibp) {
        this.O0000Oo0 = false;
        final LoginMiAccount loginMiAccount2 = loginMiAccount;
        final String str2 = str;
        final Map<String, String> map2 = map;
        final ibp ibp2 = ibp;
        CoreApi.O000000o().O000000o(loginMiAccount, new fsm<Void, fso>() {
            /* class com.xiaomi.smarthome.frame.login.MijiaLoginManager.AnonymousClass2 */

            public final void onFailure(fso fso) {
                MijiaLoginManager.super.O000000o(str2, fso.f17063O000000o, fso.O00000Oo, map2, ibp2);
                MijiaLoginManager.this.O000000o(str2, loginMiAccount2, map2, fso, "Core-setMiAccount");
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                String O00000Oo2 = grw.O00000Oo(loginMiAccount2.O000000o());
                if (ServiceApplication.shouldEnableBugly() && !TextUtils.isEmpty(O00000Oo2)) {
                    CrashReport.O000000o(O00000Oo2);
                }
                gtz gtz = fsp.O000000o().O00000oo;
                gtz.O000000o("login success loginType " + str2);
                MijiaLoginManager.super.O000000o(str2, loginMiAccount2, map2, ibp2);
            }
        });
    }

    public final void O000000o(String str, int i, String str2, Map<String, String> map, ibp ibp) {
        super.O000000o(str, i, str2, map, ibp);
        if (i != 4) {
            O000000o(str, (LoginMiAccount) null, map, new fso(i, str2), "onManagerLoginFail");
        }
    }

    public final void O000000o(String str, LoginMiAccount loginMiAccount, Map<String, String> map, fso fso, String str2) {
        String str3;
        try {
            StringBuilder sb = new StringBuilder();
            JSONObject jSONObject = new JSONObject();
            sb.append("-------------------login fail start----------------\r\n");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            sb.append("GMT time=" + simpleDateFormat.format(new Date()) + "\r\n");
            jSONObject.put("time", System.currentTimeMillis());
            if (fso != null) {
                sb.append("errorcode=" + fso.f17063O000000o + "\r\n");
                sb.append("errordetail=" + fso.O00000Oo + "\r\n");
                jSONObject.put("err_code", fso.f17063O000000o);
                jSONObject.put("err_msg", fso.O00000Oo);
            }
            sb.append("extra=" + str2 + "\r\n");
            sb.append("loginType=" + str + "\r\n");
            jSONObject.put("extra", str2);
            jSONObject.put("loginType", str);
            if (loginMiAccount != null) {
                String O00000Oo2 = grw.O00000Oo(loginMiAccount.O000000o());
                sb.append("userid=" + O00000Oo2 + "\r\n");
                sb.append("isSystemAccount=" + loginMiAccount.O00000Oo() + "\r\n");
                jSONObject.put("uid", O00000Oo2);
                jSONObject.put("isSystemAccount", loginMiAccount.O00000Oo());
            }
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    sb.append(((String) next.getKey()) + "=" + ((String) next.getValue()) + "\r\n");
                    jSONObject.put((String) next.getKey(), next.getValue());
                }
            }
            ServerBean O000000o2 = ftn.O000000o(ServiceApplication.getAppContext());
            if (O000000o2 == null) {
                str3 = null;
            } else {
                str3 = O000000o2.f7546O000000o + ":" + O000000o2.O00000Oo + ":" + O000000o2.O00000o0;
            }
            sb.append("server=".concat(String.valueOf(str3)));
            jSONObject.put("server", str3);
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) ServiceApplication.getAppContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                sb.append("network=" + activeNetworkInfo.getType() + "\r\n");
                jSONObject.put("network", activeNetworkInfo.getType());
            } else {
                sb.append("activeNetwork is null\r\n");
                jSONObject.put("network", "unknown");
            }
            Locale O000000o3 = flk.O000000o();
            if (O000000o3 != null) {
                jSONObject.put("locale", O000000o3.toString());
            }
            sb.append(O00000oO());
            sb.append("-------------------login fail end----------------\r\n");
            String sb2 = sb.toString();
            gsy.O00000Oo("login", sb2);
            if (ServiceApplication.shouldEnableBugly()) {
                dgn.O00000Oo("login", sb2);
                if (ggb.O0000o00()) {
                    CrashReport.O000000o(new InternationalLoginException(sb2));
                } else {
                    CrashReport.O000000o(new LoginException(sb2));
                }
            }
            gsy.O00000Oo(LogType.LOG_INTERNAL, "login", "login fail:".concat(String.valueOf(sb2)));
            if (this.O0000Oo0) {
                hxi.O0000OOo.O000000o(jSONObject);
            }
            this.O0000Oo0 = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String O00000oO() {
        try {
            LinkedList accountRequestExceptions = AccountRecentExceptionRecorder.getInstance().getAccountRequestExceptions();
            if (accountRequestExceptions == null || accountRequestExceptions.isEmpty()) {
                return null;
            }
            jdc jdc = new jdc("-------------passport exceptions begin--------------\n");
            Iterator it = accountRequestExceptions.iterator();
            while (it.hasNext()) {
                jdc.O000000o("exception begin>>>>>>\n");
                jdc.O000000o(Log.getStackTraceString((Exception) it.next()));
                jdc.O000000o("exception end<<<<<<<<\n");
            }
            return jdc.O000000o("-------------passport exceptions end--------------\n").toString();
        } catch (Exception e) {
            gsy.O000000o(6, "LoginManager", Log.getStackTraceString(e));
            return null;
        }
    }

    public static class LoginException extends Exception {
        public LoginException(String str) {
            super(str);
        }
    }

    public static class InternationalLoginException extends Exception {
        public InternationalLoginException(String str) {
            super(str);
        }
    }
}
