package com.xiaomi.smarthome.application;

import _m_j.exo;
import _m_j.ftn;
import _m_j.gfr;
import android.content.Context;
import android.os.Handler;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;

public abstract class ServiceApplication extends CommonApplication {
    private static volatile IWXAPI sIWXAPI;
    private static final Object sIWXAPILock = new Object();
    protected static volatile exo sNotifier;

    public static Handler getGlobalWorkerHandler() {
        return sGlobalWorkerHandler;
    }

    public static Context getAppContext() {
        return (Context) sInstance.f4211O000000o;
    }

    public static CommonApplication.O000000o<IWXAPI> getIWXAPIGetterCallback() {
        return new CommonApplication.O000000o<IWXAPI>() {
            /* class com.xiaomi.smarthome.application.ServiceApplication.AnonymousClass1 */

            public final /* synthetic */ Object O000000o() {
                return ServiceApplication.getIWXAPI();
            }
        };
    }

    public static IWXAPI getIWXAPI() {
        if (sIWXAPI == null) {
            synchronized (sIWXAPILock) {
                if (sIWXAPI == null) {
                    IWXAPI createWXAPI = WXAPIFactory.createWXAPI(getAppContext(), "wx54b959a68fb6f580", true);
                    sIWXAPI = createWXAPI;
                    createWXAPI.registerApp("wx54b959a68fb6f580");
                }
            }
        }
        return sIWXAPI;
    }

    public static exo getStateNotifier() {
        if (sNotifier == null) {
            synchronized (ServiceApplication.class) {
                if (sNotifier == null) {
                    sNotifier = new exo();
                }
            }
        }
        return sNotifier;
    }

    public static boolean shouldEnableBugly() {
        return !gfr.O0000Ooo ? !isInternationalServer() : !isEurope();
    }

    public static boolean isInternationalServer() {
        if (CoreApi.O000000o().O0000O0o()) {
            return ftn.O00000Oo(CoreApi.O000000o().O0000ooO());
        }
        return ftn.O00000oO(getAppContext());
    }

    public static boolean isEurope() {
        return ftn.O0000O0o(getAppContext());
    }
}
