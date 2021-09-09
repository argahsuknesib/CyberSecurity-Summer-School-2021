package com.xiaomi.smarthome.framework.account;

import _m_j.ezq;
import _m_j.ezt;
import _m_j.ezu;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ftk;
import _m_j.gsy;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.login.MijiaLoginManager;
import com.xiaomi.smarthome.library.log.LogType;

public class MiAccountChangeReceiver extends BroadcastReceiver {
    public void onReceive(final Context context, final Intent intent) {
        if (ezu.O000000o()) {
            ezt.O000000o().startCheck(new ezq() {
                /* class com.xiaomi.smarthome.framework.account.MiAccountChangeReceiver.AnonymousClass1 */

                public final void O000000o() {
                }

                public final void O00000Oo() {
                }

                public final void O00000o0() {
                    MiAccountChangeReceiver miAccountChangeReceiver = MiAccountChangeReceiver.this;
                    CoreApi.O000000o().O000000o(context, new CoreApi.O0000o0() {
                        /* class com.xiaomi.smarthome.framework.account.MiAccountChangeReceiver.AnonymousClass2 */

                        public final void onCoreReady() {
                            if (CoreApi.O000000o().O0000oO0()) {
                                gsy.O000000o(3, "AAAA", "onCoreReady: 系统帐号不一致");
                                String O0000o0 = CoreApi.O000000o().O0000o0();
                                String O00000Oo = ftk.O00000Oo();
                                if (TextUtils.isEmpty(O00000Oo) || (!TextUtils.isEmpty(O00000Oo) && !O00000Oo.equalsIgnoreCase(O0000o0))) {
                                    try {
                                        gsy.O00000Oo(LogType.LOGIN, "MiAccountChangeReceiver", "系统帐号不一致 登出");
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    MijiaLoginManager.O000000o().O000000o((fsm<Void, fso>) null, "MiAccountChangeReceiver#doWork");
                                }
                            }
                        }
                    });
                }
            });
        }
    }
}
