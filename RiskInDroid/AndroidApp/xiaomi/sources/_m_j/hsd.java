package _m_j;

import _m_j.exo;
import _m_j.hcc;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.miot.service.ICallback;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.card.State;
import java.util.ArrayList;

public final class hsd implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f581O000000o;
    public ICallback O00000Oo;
    private final boolean O00000o0;

    public hsd(String str, boolean z, ICallback iCallback) {
        this.O00000Oo = iCallback;
        this.f581O000000o = str;
        this.O00000o0 = z;
    }

    public final void run() {
        Device O000000o2 = fno.O000000o().O000000o(this.f581O000000o);
        if (O000000o2 == null) {
            gsy.O00000o0(LogType.DEVICE_CONTROL, "DeviceOnTask", "device is null");
            hxi.O00000o.O00000o0((String) null);
            CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new CoreApi.O0000o0() {
                /* class _m_j.hsd.AnonymousClass1 */

                public final void onCoreReady() {
                    int i = ServiceApplication.getStateNotifier().f15923O000000o;
                    if (i == 0 || i == 3) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("error_code", 1);
                        try {
                            gsy.O00000o0(LogType.DEVICE_CONTROL, "DeviceOnTask", "updateDeviceList no login onFailure");
                            hsd.this.O00000Oo.onFailure(bundle);
                        } catch (RemoteException e) {
                            gsy.O00000o0(LogType.DEVICE_CONTROL, "DeviceOnTask", Log.getStackTraceString(e));
                        }
                    } else {
                        ServiceApplication.getStateNotifier().O000000o(new exo.O000000o() {
                            /* class _m_j.hsd.AnonymousClass1.AnonymousClass1 */

                            public final void onLoginSuccess() {
                                gsy.O00000o0(LogType.DEVICE_CONTROL, "DeviceOnTask", "updateDeviceList onLoginSuccess");
                                IntentFilter intentFilter = new IntentFilter("force_update_data_completed");
                                ft.O000000o(ServiceApplication.getAppContext()).O000000o(new BroadcastReceiver() {
                                    /* class _m_j.hsd.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                    public final void onReceive(Context context, Intent intent) {
                                        gsy.O00000o0(LogType.DEVICE_CONTROL, "DeviceOnTask", "updateDeviceList onLoginSuccess onReceive");
                                        ft.O000000o(ServiceApplication.getAppContext()).O000000o(this);
                                        hsd.this.O000000o(fno.O000000o().O000000o(hsd.this.f581O000000o));
                                    }
                                }, intentFilter);
                                ggb.O00000Oo().O0000oO();
                            }

                            public final void onLoginFailed() {
                                Bundle bundle = new Bundle();
                                bundle.putInt("error_code", 2);
                                try {
                                    gsy.O00000o0(LogType.DEVICE_CONTROL, "DeviceOnTask", "updateDeviceList onLoginFailed");
                                    hsd.this.O00000Oo.onFailure(bundle);
                                } catch (RemoteException e) {
                                    gsy.O00000o0(LogType.DEVICE_CONTROL, "DeviceOnTask", Log.getStackTraceString(e));
                                }
                            }
                        });
                    }
                }
            });
            return;
        }
        gsy.O00000o0(LogType.DEVICE_CONTROL, "DeviceOnTask", "updateOpConfig");
        hxi.O00000o.O00000o0(O000000o2.model);
        O000000o(O000000o2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003c A[Catch:{ Exception -> 0x0060 }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d A[Catch:{ Exception -> 0x0060 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0045 A[Catch:{ Exception -> 0x0060 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c A[Catch:{ Exception -> 0x0060 }] */
    public final void O000000o(final Device device) {
        boolean z;
        try {
            hcc gridCard = faw.O00000o0().getGridCard(device);
            final Bundle bundle = new Bundle();
            ArrayList<Pair> deviceRenderData = faw.O00000o0().getDeviceRenderData(device, gridCard);
            bundle.putString("new_description", hsf.O000000o(device));
            boolean z2 = true;
            if (deviceRenderData != null) {
                bundle.putBoolean("fileter_key", false);
                Pair O000000o2 = gzt.O000000o(device, deviceRenderData);
                if (O000000o2 != null && State.SELECTED == O000000o2.first) {
                    z = true;
                    if (!this.O00000o0) {
                        z2 = false;
                    }
                    bundle.putBoolean("new_state", z2);
                    if (z != this.O00000o0) {
                        faw.O00000o0().toggleButton(device, 0, (hcc.O000000o) gridCard.O000000o().get(0), new fsm<Void, fso>() {
                            /* class _m_j.hsd.AnonymousClass2 */

                            public final void onFailure(fso fso) {
                                gsy.O00000o0(LogType.DEVICE_CONTROL, "DeviceOnTask", "updateOpConfig onFailure");
                                try {
                                    Bundle bundle = new Bundle();
                                    bundle.putInt("error_code", fso == null ? -1 : fso.f17063O000000o);
                                    hsd.this.O00000Oo.onFailure(bundle);
                                } catch (RemoteException e) {
                                    gsy.O00000o0(LogType.DEVICE_CONTROL, "DeviceOnTask", Log.getStackTraceString(e));
                                }
                            }

                            public final /* synthetic */ void onSuccess(Object obj) {
                                gsy.O00000o0(LogType.DEVICE_CONTROL, "DeviceOnTask", "updateOpConfig onSuccess");
                                hsd.this.O000000o(bundle);
                            }
                        });
                        return;
                    } else {
                        O000000o(bundle);
                        return;
                    }
                }
            }
            z = false;
            if (!this.O00000o0) {
            }
            bundle.putBoolean("new_state", z2);
            if (z != this.O00000o0) {
            }
        } catch (Exception e) {
            gsy.O00000o0(LogType.DEVICE_CONTROL, "DeviceOnTask", Log.getStackTraceString(e));
            try {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("error_code", -3);
                this.O00000Oo.onFailure(bundle2);
            } catch (RemoteException e2) {
                gsy.O00000o0(LogType.DEVICE_CONTROL, "DeviceOnTask", Log.getStackTraceString(e2));
            }
        }
    }

    public final void O000000o(Bundle bundle) {
        try {
            bundle.putString("packagename", "com.miui.home");
            bundle.putString("current_uid", CoreApi.O000000o().O0000o0());
            this.O00000Oo.onSuccess(bundle);
        } catch (RemoteException e) {
            gsy.O00000o0(LogType.DEVICE_CONTROL, "DeviceOnTask", Log.getStackTraceString(e));
        }
    }
}
