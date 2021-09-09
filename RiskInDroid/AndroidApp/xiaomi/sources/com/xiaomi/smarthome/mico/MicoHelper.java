package com.xiaomi.smarthome.mico;

import _m_j.ftn;
import _m_j.gtx;
import _m_j.gty;
import _m_j.hjp;
import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.xiaomi.mico.application.MicoApplication;
import com.xiaomi.mico.base.MicoHelperListener;
import com.xiaomi.smarthome.application.CommonApplication;

public class MicoHelper implements MicoHelperListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public static volatile boolean f9514O000000o = false;
    private static MicoHelper O00000Oo;

    public void onTokenExpired(String str) {
    }

    public static void O000000o(Context context) {
        if (!f9514O000000o) {
            if (ftn.O00000oO(context) && !ftn.O0000Oo0(context)) {
                return;
            }
            if (O00000Oo == null) {
                O00000Oo = new MicoHelper(context);
                f9514O000000o = true;
                return;
            }
            throw new IllegalStateException("MicoHelper has already been initialized.");
        }
    }

    public MicoHelper(Context context) {
        MicoApplication.init(context, this);
    }

    public void login() {
        gtx O000000o2 = gty.O000000o();
        if (O000000o2 != null) {
            O000000o2.startLogin(CommonApplication.getAppContext(), 5, new gtx.O000000o());
        }
    }

    public IWXAPI getIWXAPI() {
        return CommonApplication.getSHIWXAPI();
    }

    public void jumpSmartHome(String str, String str2) {
        hjp.O000000o(str, str2, new boolean[0]);
    }
}
