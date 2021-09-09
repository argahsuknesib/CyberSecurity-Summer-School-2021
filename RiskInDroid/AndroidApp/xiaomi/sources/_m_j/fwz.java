package _m_j;

import _m_j.fwy;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import com.facebook.react.bridge.WritableMap;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.plugin.host.PluginHostApi;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class fwz {
    private static volatile fwz O00000oO;

    /* renamed from: O000000o  reason: collision with root package name */
    public fwy f17357O000000o = new fwy();
    public gau O00000Oo;
    BroadcastReceiver O00000o = new BroadcastReceiver() {
        /* class _m_j.fwz.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            ArrayList<String> stringArrayListExtra;
            if ("device_was_deleted".equals(intent.getAction()) && (stringArrayListExtra = intent.getStringArrayListExtra("fold_lists")) != null) {
                for (String str : stringArrayListExtra) {
                    gba.O00000Oo(new File(str + File.separator + "data", "config.xml"));
                }
            }
        }
    };
    public fxb O00000o0 = new fxb();

    private fwz() {
        if (gbt.O000000o()) {
            fxa.O000000o().O000000o(O00000Oo());
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("device_was_deleted");
            CommonApplication.getAppContext().registerReceiver(this.O00000o, intentFilter);
        }
    }

    public static fwz O000000o() {
        if (O00000oO == null) {
            synchronized (fwz.class) {
                if (O00000oO == null) {
                    O00000oO = new fwz();
                }
            }
        }
        return O00000oO;
    }

    public final fwy O00000Oo() {
        if (this.f17357O000000o == null) {
            gbu.O00000oo("RNRuntimeManager getCurrentRNRuntime() RNRuntime null");
            gbu.O00000Oo("RNRuntimeManager getCurrentRNRuntime() RNRuntime null");
            if (gbt.O000000o()) {
                O00000o(true);
                if (fxa.O000000o().O00000o0 != null) {
                    this.f17357O000000o = fxa.O000000o().O00000o0;
                } else {
                    this.f17357O000000o = O00000o0(true);
                }
            } else {
                O00000o(false);
                this.f17357O000000o = O00000o0(true);
            }
            XmPluginHostApi.instance().onRNRuntimeReuseDisable(4);
        }
        return this.f17357O000000o;
    }

    public final void O000000o(String str) {
        O00000Oo();
        fwy.O000000o(str);
    }

    public final void O000000o(boolean z) {
        O00000Oo().O0000ooo = z;
    }

    public final void O000000o(fwy.O000000o o000000o) {
        O00000Oo().O000000o(o000000o);
    }

    public final void O000000o(boolean z, WritableMap writableMap) {
        O00000Oo().O000000o(z, writableMap);
    }

    public final void O00000Oo(boolean z, WritableMap writableMap) {
        O00000Oo().O00000Oo(z, writableMap);
    }

    public final void O00000Oo(boolean z) {
        O00000Oo().O0000oo0 = z;
    }

    public static fwy O00000o0(boolean z) {
        gbu.O00000oo("RNRuntimeManager initClearRNRuntime(),init,ifLoadPluginBundle=".concat(String.valueOf(z)));
        fwy fwy = new fwy();
        fwy.O000000o(z);
        return fwy;
    }

    public final void O000000o(boolean z, int i) {
        gbu.O00000oo("RNRuntimeManager onMemory(),fromSystem=" + z + ",level=" + i);
        Map<String, Object> O00000o02 = O00000o0();
        O00000o02.put("from_system", Integer.valueOf(z ? 1 : 0));
        O00000o02.put("trim_memory_level", Integer.valueOf(i));
        int O00000o2 = gbt.O00000o();
        O00000o02.put("max_memory_percent", Integer.valueOf(O00000o2));
        if (!z) {
            try {
                if (((Integer) O00000o02.get("memory_percent")).intValue() > O00000o2) {
                    z = true;
                }
            } catch (Exception e) {
                fyc.O00000o("miot-rn-plugin", Log.getStackTraceString(e));
            }
        }
        boolean O000000o2 = gbt.O000000o();
        gau gau = this.O00000Oo;
        if (gau != null) {
            O00000o02.put("reuse_switch_status", Integer.valueOf(gau.O00000oO));
            O00000o02.put("reuse_status", Integer.valueOf(this.O00000Oo.O0000O0o));
            O00000o02.put("model_support", Integer.valueOf(this.O00000Oo.O00000oo));
        }
        if (O000000o2) {
            O00000o02.put("cur_cache_size", Integer.valueOf(fxa.O000000o().O00000Oo.size()));
            O00000o02.put("max_cache_size", Integer.valueOf(fxa.O000000o().f17359O000000o));
        } else {
            O00000o02.put("cur_cache_size", Integer.valueOf(gbt.O00000o0()));
            O00000o02.put("max_cache_size", 0);
        }
        if (z) {
            O00000o02.put("low_memory", 1);
            fwy O00000Oo2 = O00000Oo();
            O000000o(O00000Oo2.O0000OoO.O00000Oo(), O00000Oo2.O0000OoO.O000000o(), O00000Oo2.O0000o00.model, O00000Oo2.O0000o00.did, O00000o02);
            gbu.O00000oo("RNRuntimeManager onMemory(),onLowMemory,max=" + O00000o02.get("max_memory") + ",use=" + O00000o02.get("use_memory") + ",percent=" + O00000o02.get("memory_percent"));
            if (O000000o2) {
                fxa.O000000o().O00000Oo();
            }
            XmPluginHostApi.instance().onRNRuntimeReuseDisable(1);
            return;
        }
        O00000o02.put("low_memory", 0);
        fwy O00000Oo3 = O00000Oo();
        O000000o(O00000Oo3.O0000OoO.O00000Oo(), O00000Oo3.O0000OoO.O000000o(), O00000Oo3.O0000o00.model, O00000Oo3.O0000o00.did, O00000o02);
    }

    private static Map<String, Object> O00000o0() {
        try {
            long j = Runtime.getRuntime().totalMemory();
            long freeMemory = j - Runtime.getRuntime().freeMemory();
            long maxMemory = Runtime.getRuntime().maxMemory();
            int i = (int) (j / 1048576);
            int i2 = (int) (freeMemory / 1048576);
            int i3 = (int) (maxMemory / 1048576);
            int i4 = (int) ((freeMemory * 100) / maxMemory);
            HashMap hashMap = new HashMap();
            hashMap.put("total_memory", Integer.valueOf(i));
            hashMap.put("use_memory", Integer.valueOf(i2));
            hashMap.put("max_memory", Integer.valueOf(i3));
            hashMap.put("memory_percent", Integer.valueOf(i4));
            fyc.O00000Oo("miot-rn-plugin", "RNRuntimeManager,getMemoryInfo(),max_memory=" + i3 + ",use_memory=" + i2 + ",memory_percent=" + i4);
            return hashMap;
        } catch (Exception e) {
            fyc.O00000o("miot-rn-plugin", Log.getStackTraceString(e));
            return new HashMap();
        }
    }

    private void O000000o(long j, long j2, String str, String str2, Map<String, Object> map) {
        fxb fxb = this.O00000o0;
        if (fxb != null) {
            map.put("open_count_all", Integer.valueOf(fxb.f17361O000000o));
            map.put("open_count_add_bundle", Integer.valueOf(this.O00000o0.O00000Oo));
            map.put("open_count_multi_disable", Integer.valueOf(this.O00000o0.O00000o0));
            map.put("open_count_cache_hit", Integer.valueOf(this.O00000o0.O00000o));
            map.put("open_count_cache_not_hit_model_support", Integer.valueOf(this.O00000o0.O00000oO));
            map.put("open_count_cache_not_hit_model_not_support", Integer.valueOf(this.O00000o0.O00000oo));
        }
        gav.O000000o(j, j2, str, str2, map);
    }

    private static void O00000o(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("reuse_switch_status", Integer.valueOf(z ? 1 : 0));
        gav.O000000o(hashMap);
    }

    public final void O000000o(boolean z, long j, boolean z2) {
        gau gau = this.O00000Oo;
        if (gau != null) {
            if (z) {
                gau.O0000Oo = 1;
            } else {
                gau.O0000Oo = 0;
            }
            gau gau2 = this.O00000Oo;
            gau2.O0000OoO = j;
            HashMap hashMap = new HashMap();
            hashMap.put("reuse_switch_status", Integer.valueOf(gau2.O00000oO));
            hashMap.put("reuse_status", Integer.valueOf(gau2.O0000O0o));
            hashMap.put("model_support", Integer.valueOf(gau2.O00000oo));
            hashMap.put("cur_cache_size", Integer.valueOf(gau2.O0000Oo0));
            hashMap.put("max_cache_size", Integer.valueOf(gau2.O0000OOo));
            hashMap.put("hot_open", Integer.valueOf(gau2.O0000Oo));
            hashMap.put("open_time_cost", String.valueOf(gau2.O0000OoO));
            hashMap.put("launch_msg_type", Integer.valueOf(gau2.O0000Ooo));
            hashMap.put("cache_hit_type", Integer.valueOf(gau2.O0000o00));
            hashMap.put("clear_hit_type", Integer.valueOf(gau2.O0000o0));
            hashMap.put("re_init_new_enable", Integer.valueOf(gau2.O0000o0O));
            long j2 = gau2.f17472O000000o;
            long j3 = gau2.O00000Oo;
            String str = gau2.O00000o0;
            String str2 = gau2.O00000o;
            hashMap.put("package_id", String.valueOf(j2));
            hashMap.put("plugin_id", String.valueOf(j3));
            hashMap.put("device_id", String.valueOf(str2));
            hashMap.put("device_model", str);
            hashMap.put("sdk_level", 10058);
            if (z2) {
                PluginHostApi.instance().statReport("rn_plugin_framework", "rn_runtime_reuse_status", hashMap);
            } else {
                PluginHostApi.instance().statReport("rn_plugin_framework", "rn_runtime_reuse_status_not_report_so_far", hashMap);
            }
        } else {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("sdk_level", 10058);
            PluginHostApi.instance().statReport("rn_plugin_framework", "rn_runtime_reuse_status_open_time_info_null", hashMap2);
        }
    }

    public static void O000000o(long j, long j2, String str, String str2, Bundle bundle) {
        boolean booleanValue = ((Boolean) gat.O000000o("report_rn_process_reuse_enter_type_enable", Boolean.TRUE)).booleanValue();
        gbu.O00000oo("RnPluginFileUtils-->reportRNProcessReuseEnterTypEnable(),return ".concat(String.valueOf(booleanValue)));
        if (booleanValue) {
            HashMap hashMap = new HashMap();
            if (bundle != null) {
                int i = bundle.getInt("process_reuse_enter_type", 0);
                fyc.O00000Oo("miot-rn-plugin", "RNRuntimeManager,reportRNProcessReuseEnterType(),enterType=".concat(String.valueOf(i)));
                hashMap.put("process_reuse_enter_type", Integer.valueOf(i));
                hashMap.put("package_id", String.valueOf(j));
                hashMap.put("plugin_id", String.valueOf(j2));
                hashMap.put("device_id", String.valueOf(str2));
                hashMap.put("device_model", str);
                hashMap.put("sdk_level", 10058);
                PluginHostApi.instance().statReport("rn_plugin_framework", "rn_process_reuse_enter_type", hashMap);
            }
        }
    }
}
