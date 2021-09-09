package _m_j;

import _m_j.fso;
import _m_j.ftg;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.client.IClientCallback;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceSearch;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.miio.device.GeneralAPDevice;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fmm extends DeviceSearch<Device> {
    private static volatile fmm O00000o;

    /* renamed from: O000000o  reason: collision with root package name */
    public SharedPreferences f16654O000000o;
    private HashMap<String, Device> O00000Oo = new HashMap<>();
    private HashMap<String, Boolean> O00000o0 = new HashMap<>();

    public final void O000000o(Device device) {
        super.O000000o(device);
        this.O00000Oo.put(device.model, device);
    }

    public static fmm O00000oo() {
        if (O00000o == null) {
            synchronized (fmm.class) {
                if (O00000o == null) {
                    O00000o = new fmm();
                }
            }
        }
        return O00000o;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fmm.O000000o(boolean, java.lang.String):void
     arg types: [int, java.lang.String]
     candidates:
      _m_j.fmm.O000000o(java.util.Collection<? extends com.xiaomi.smarthome.device.Device>, com.xiaomi.smarthome.device.DeviceSearch$REMOTESTATE):void
      com.xiaomi.smarthome.device.DeviceSearch.O000000o(java.util.Collection<? extends com.xiaomi.smarthome.device.Device>, com.xiaomi.smarthome.device.DeviceSearch$REMOTESTATE):void
      _m_j.fmm.O000000o(boolean, java.lang.String):void */
    public final void O00000Oo(Device device) {
        O000000o(false, device.model);
        CoreApi O000000o2 = CoreApi.O000000o();
        String str = device.model;
        Handler handler = new Handler(Looper.getMainLooper());
        if (!TextUtils.isEmpty(str)) {
            try {
                O000000o2.O00000Oo().deletePlugin(str, new IClientCallback.Stub(null, handler, str) {
                    /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass48 */
                    final /* synthetic */ O00000o val$callback;
                    final /* synthetic */ String val$model;
                    final /* synthetic */ Handler val$uiHandler;

                    {
                        this.val$callback = r2;
                        this.val$uiHandler = r3;
                        this.val$model = r4;
                    }

                    public void onSuccess(Bundle bundle) {
                        if (this.val$callback != null) {
                            this.val$uiHandler.post(new Runnable() {
                                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass48.AnonymousClass1 */

                                public final void run() {
                                }
                            });
                        }
                    }

                    public void onFailure(Bundle bundle) {
                        if (this.val$callback != null) {
                            bundle.setClassLoader(fso.class.getClassLoader());
                            final PluginError pluginError = (PluginError) bundle.getParcelable("error");
                            this.val$uiHandler.post(new Runnable() {
                                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass48.AnonymousClass2 */

                                public final void run() {
                                }
                            });
                            ftg.O000000o("deletePlugin fail", new fso(pluginError.f6718O000000o, pluginError.O00000Oo));
                        }
                    }
                });
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fmm.O000000o(boolean, java.lang.String):void
     arg types: [int, java.lang.String]
     candidates:
      _m_j.fmm.O000000o(java.util.Collection<? extends com.xiaomi.smarthome.device.Device>, com.xiaomi.smarthome.device.DeviceSearch$REMOTESTATE):void
      com.xiaomi.smarthome.device.DeviceSearch.O000000o(java.util.Collection<? extends com.xiaomi.smarthome.device.Device>, com.xiaomi.smarthome.device.DeviceSearch$REMOTESTATE):void
      _m_j.fmm.O000000o(boolean, java.lang.String):void */
    public final void O000000o(Collection<? extends Device> collection, DeviceSearch.REMOTESTATE remotestate) {
        PluginDeviceInfo pluginInfo;
        for (Device device : collection) {
            if ("fimi.camera.c1".equals(device.model)) {
                this.O00000Oo.put(device.model, device);
            } else {
                PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(device.model);
                if (O00000oO != null && O00000oO.O00000o() == 7) {
                    this.O00000Oo.put(device.model, device);
                }
            }
        }
        Map<String, PluginPackageInfo> map = fkl.O000000o().O0000OOo;
        if (map != null) {
            for (Map.Entry<String, PluginPackageInfo> key : map.entrySet()) {
                String str = (String) key.getKey();
                if (!this.O00000Oo.containsKey(str) && (pluginInfo = PluginDeviceManager.instance.getPluginInfo(str)) != null && 7 == pluginInfo.O00000o()) {
                    O000000o(O000000o(str));
                    O000000o(true, str);
                }
            }
        }
    }

    private fmm() {
        ft O000000o2 = ft.O000000o(CommonApplication.getAppContext());
        IntentFilter intentFilter = new IntentFilter("action_on_login_success");
        intentFilter.addAction("action_on_logout");
        O000000o2.O000000o(new O000000o(this, (byte) 0), intentFilter);
        O0000O0o();
    }

    class O000000o extends BroadcastReceiver {
        private O000000o() {
        }

        /* synthetic */ O000000o(fmm fmm, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("action_on_login_success".equals(action)) {
                fmm.this.O0000O0o();
            } else if ("action_on_logout".equals(action)) {
                fmm.this.f16654O000000o = null;
            }
        }
    }

    public final void O0000O0o() {
        gqe.O000000o(new gqe() {
            /* class _m_j.fmm.AnonymousClass1 */

            public final void O000000o() {
                if (CoreApi.O000000o().O0000Ooo()) {
                    String O0000o0 = CoreApi.O000000o().O0000o0();
                    fmm.this.f16654O000000o = CommonApplication.getAppContext().getSharedPreferences("general_ap_device".concat(String.valueOf(O0000o0)), 0);
                } else {
                    fmm.this.f16654O000000o = null;
                }
                if (fmm.this.f16654O000000o != null) {
                    fmm.this.O0000OOo();
                }
            }
        }, AsyncTask.THREAD_POOL_EXECUTOR);
    }

    public static GeneralAPDevice O000000o(String str) {
        return new GeneralAPDevice(str);
    }

    public final void O0000OOo() {
        HashMap<String, Device> hashMap = this.O00000Oo;
        if (hashMap != null) {
            for (String next : hashMap.keySet()) {
                String O00000Oo2 = gpy.O00000Oo(this.f16654O000000o, "key.desc".concat(String.valueOf(next)), "");
                gnk.O00000o0(String.format("getDesc (%s)", O00000Oo2));
                this.O00000Oo.get(next).desc = O00000Oo2;
            }
        }
    }

    public final void O000000o(boolean z, String str) {
        if (this.f16654O000000o != null) {
            gpy.O000000o(this.f16654O000000o, "key.show_general_ap".concat(String.valueOf(str)), z);
            this.O00000o0.put(str, Boolean.valueOf(z));
            if (!z) {
                fno.O000000o().O0000OOo();
            }
        }
    }

    public final void O00000Oo() {
        this.O0000O0o = true;
    }

    public final List<Device> O00000o0() {
        PluginDeviceInfo O00000oO;
        if (this.O00000o0 == null) {
            return Collections.EMPTY_LIST;
        }
        if (!CoreApi.O000000o().O0000Ooo()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        for (String next : this.O00000o0.keySet()) {
            if (this.O00000o0.get(next).booleanValue() && (O00000oO = CoreApi.O000000o().O00000oO(next)) != null) {
                Device device = this.O00000Oo.get(next);
                device.name = O00000oO.O0000Oo0();
                arrayList.add(device);
            }
        }
        return arrayList;
    }
}
