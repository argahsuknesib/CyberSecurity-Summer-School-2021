package _m_j;

import _m_j.exo;
import _m_j.far;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import com.xiaomi.miot.DeviceInfo;
import com.xiaomi.miot.service.ICallback;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.controls.AllReadyCallback;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.GridViewData;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.List;

public class hse implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    protected ICallback f586O000000o;
    protected boolean O00000Oo;

    public hse(ICallback iCallback, boolean z) {
        this.f586O000000o = iCallback;
        this.O00000Oo = z;
        fad.O000000o().notifyEnable(false);
    }

    public void run() {
        LogType logType = LogType.DEVICE_CONTROL;
        gsy.O00000o0(logType, "GetCommonDeviceTask", "receive device refresh forceRefresh:" + this.O00000Oo);
        if (this.O00000Oo) {
            CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new CoreApi.O0000o0() {
                /* class _m_j.hse.AnonymousClass2 */

                public final void onCoreReady() {
                    int i = ServiceApplication.getStateNotifier().f15923O000000o;
                    if (i == 0 || i == 3) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("error_code", 1);
                        try {
                            hse.this.f586O000000o.onFailure(bundle);
                        } catch (Throwable th) {
                            gsy.O00000o0(LogType.DEVICE_CONTROL, "GetCommonDeviceTask", "run", Log.getStackTraceString(th));
                        }
                    } else {
                        ServiceApplication.getStateNotifier().O000000o(new exo.O000000o() {
                            /* class _m_j.hse.AnonymousClass2.AnonymousClass1 */

                            public final void onLoginSuccess() {
                                gsy.O00000o0(LogType.DEVICE_CONTROL, "GetCommonDeviceTask", "login success");
                                if (far.O000000o().O00000Oo()) {
                                    far.O000000o().O000000o(new far.O000000o() {
                                        /* class _m_j.hse.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                        public final void O000000o() {
                                            hse.this.O000000o(far.O000000o().O00000o0());
                                            fad.O000000o().notifyEnable(true);
                                        }
                                    });
                                    return;
                                }
                                IntentFilter intentFilter = new IntentFilter("force_update_data_completed");
                                ft.O000000o(ServiceApplication.getAppContext()).O000000o(new BroadcastReceiver() {
                                    /* class _m_j.hse.AnonymousClass2.AnonymousClass1.AnonymousClass2 */

                                    public final void onReceive(Context context, Intent intent) {
                                        gsy.O00000o0(LogType.DEVICE_CONTROL, "GetCommonDeviceTask", "receive device refresh success");
                                        ft.O000000o(ServiceApplication.getAppContext()).O000000o(this);
                                        hse.this.O000000o(ggb.O00000Oo().O0000o0());
                                        fad.O000000o().notifyEnable(true);
                                    }
                                }, intentFilter);
                                ggb.O00000Oo().O0000oO();
                            }

                            public final void onLoginFailed() {
                                Bundle bundle = new Bundle();
                                bundle.setClassLoader(DeviceInfo.class.getClassLoader());
                                bundle.putInt("error_code", 2);
                                try {
                                    hse.this.f586O000000o.onFailure(bundle);
                                } catch (Throwable th) {
                                    gsy.O00000o0(LogType.DEVICE_CONTROL, "GetCommonDeviceTask", "run", Log.getStackTraceString(th));
                                }
                            }
                        });
                    }
                }
            });
        } else if (far.O000000o().O00000Oo()) {
            new AllReadyCallback(1, new Runnable() {
                /* class _m_j.hse.AnonymousClass1 */

                public final void run() {
                    hse.this.O000000o(far.O000000o().O00000o0());
                }
            });
        } else {
            new AllReadyCallback(new Runnable() {
                /* class _m_j.$$Lambda$hse$1XSfDpGLsaGp8ugGqp1L3V4Edo */

                public final void run() {
                    hse.this.O000000o();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o() {
        gsy.O00000o0(LogType.DEVICE_CONTROL, "GetCommonDeviceTask", "receive device refresh  AllReadyCallback");
        O000000o(ggb.O00000Oo().O0000o0());
    }

    public void O000000o(List<GridViewData> list) {
        int i;
        Bundle bundle = new Bundle();
        bundle.setClassLoader(DeviceInfo.class.getClassLoader());
        bundle.putString("current_uid", CoreApi.O000000o().O0000o0());
        if (list == null) {
            i = 0;
        } else {
            i = list.size();
        }
        bundle.putInt("device_count", i);
        LogType logType = LogType.DEVICE_CONTROL;
        gsy.O00000o0(logType, "GetCommonDeviceTask", "notify success onCommonUseDevices return " + Base64.encodeToString(String.valueOf(list).getBytes(), 2));
        try {
            if (this.f586O000000o != null) {
                this.f586O000000o.onSuccess(bundle);
            }
        } catch (Throwable th) {
            gsy.O00000o0(LogType.DEVICE_CONTROL, "GetCommonDeviceTask", "onCommonUseDevices", Log.getStackTraceString(th));
        }
    }
}
