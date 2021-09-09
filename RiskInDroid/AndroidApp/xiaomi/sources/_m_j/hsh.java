package _m_j;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.miot.service.ICallback;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.youpin.login.entity.account.LoginMiAccount;
import java.util.Map;

public final class hsh implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    public final ICallback f595O000000o;
    private final long O00000Oo = System.currentTimeMillis();

    public hsh(ICallback iCallback) {
        this.f595O000000o = iCallback;
    }

    public final void run() {
        if (!ezu.O000000o()) {
            gsy.O00000o0(LogType.LOGIN, "LoginTask", "ctaPass fail");
            if (this.f595O000000o != null) {
                Bundle bundle = new Bundle();
                try {
                    bundle.putString("LoginTask", "CTA not passed yet");
                    bundle.putInt("error_code", 3);
                    this.f595O000000o.onFailure(bundle);
                } catch (Exception e) {
                    gsy.O00000o0(LogType.LOGIN, "LoginTask", Log.getStackTraceString(e));
                }
            }
        } else {
            String O00000Oo2 = fcn.O000000o().O00000Oo();
            if ("0".equals(O00000Oo2) || TextUtils.isEmpty(O00000Oo2)) {
                gsy.O00000o0(LogType.LOGIN, "LoginTask", "start login task ");
                CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new CoreApi.O0000o0() {
                    /* class _m_j.$$Lambda$hsh$YG4Z46R7RO_Cxyb652uB2_ejWe8 */

                    public final void onCoreReady() {
                        hsh.this.O000000o();
                    }
                });
                return;
            }
            LogType logType = LogType.LOGIN;
            gsy.O00000o0(logType, "LoginTask", "callbackSuccess miId:" + O00000Oo2 + " spend " + (System.currentTimeMillis() - this.O00000Oo));
            O000000o(O00000Oo2);
        }
    }

    /* access modifiers changed from: private */
    public void O000000o() {
        try {
            String miSystemAccountId = gty.O000000o().getMiSystemAccountId();
            if (!TextUtils.isEmpty(miSystemAccountId)) {
                ServiceApplication.getStateNotifier().O00000o();
                gge.O000000o().O00000Oo();
                fno.O000000o().O0000Oo();
                gsy.O000000o(6, "LoginTask", "start login");
                gty.O000000o().startMiuiLogin(ServiceApplication.getAppContext(), null, new ibq() {
                    /* class _m_j.hsh.AnonymousClass1 */

                    public final void O000000o(LoginMiAccount loginMiAccount) {
                        gsy.O00000o0(LogType.LOGIN, "LoginTask", "onLoginSuccess");
                        hsh.this.O000000o(loginMiAccount.O000000o());
                    }

                    public final void O000000o(int i, String str, Map<String, String> map) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("error_code", 2);
                        try {
                            gsy.O00000o0(LogType.LOGIN, "LoginTask", "login onLoginFail");
                            hsh.this.f595O000000o.onFailure(bundle);
                        } catch (RemoteException e) {
                            gsy.O00000o0(LogType.LOGIN, "LoginTask", Log.getStackTraceString(e));
                        }
                    }
                });
                return;
            }
            ServiceApplication.getStateNotifier().O00000oO();
            Bundle bundle = new Bundle();
            bundle.putInt("error_code", 1);
            gsy.O00000o0(LogType.LOGIN, "LoginTask", "login fail".concat(String.valueOf(miSystemAccountId)));
            this.f595O000000o.onFailure(bundle);
        } catch (Exception e) {
            gsy.O00000o0(LogType.LOGIN, "LoginTask", Log.getStackTraceString(e));
        }
    }

    public final void O000000o(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("current_uid", str);
        try {
            ezo.O000000o().registerPushService();
            this.f595O000000o.onSuccess(bundle);
        } catch (Throwable th) {
            gsy.O00000o0(LogType.PUSH, "LoginTask", "fatal", Log.getStackTraceString(th));
        }
    }
}
