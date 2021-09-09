package _m_j;

import android.text.TextUtils;
import com.facebook.react.bridge.ReadableMap;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.frame.plugin.host.PluginHostApi;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class gav {
    public static void O000000o(String str, int i) {
        Observable.just(0).subscribeOn(Schedulers.io()).doOnNext(new Consumer(str, i) {
            /* class _m_j.$$Lambda$gav$v6V9bF8308duehNYuF2ne2KCoCQ */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ int f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                gav.O000000o(this.f$0, this.f$1, (Integer) obj);
            }
        }).subscribe();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(String str, int i, Integer num) throws Exception {
        HashMap hashMap = new HashMap();
        hashMap.put("device_model", str);
        hashMap.put("code", Integer.valueOf(i));
        hashMap.put("sdk_level", 10058);
        PluginHostApi.instance().statReport("rn_plugin_framework", "rn_plugin_open_error", hashMap);
    }

    public static void O000000o(String str, String str2, int i, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("task_type", str);
        hashMap.put("device_model", str2);
        hashMap.put("code", Integer.valueOf(i));
        hashMap.put("cost", Long.valueOf(j));
        hashMap.put("sdk_level", 10058);
        hashMap.put("tip", "6.0.0.0.151");
        PluginHostApi.instance().statReport("rn_plugin_framework", "rn_load_plugin_sdk", hashMap);
    }

    public static void O000000o(long j, long j2, String str, String str2, ReadableMap readableMap) {
        Observable.just(0).subscribeOn(Schedulers.io()).map(new Function(j, j2, str, str2) {
            /* class _m_j.$$Lambda$gav$Lh93BJAsr70FhLVeAYSPZ0gM8Zw */
            private final /* synthetic */ long f$1;
            private final /* synthetic */ long f$2;
            private final /* synthetic */ String f$3;
            private final /* synthetic */ String f$4;

            {
                this.f$1 = r2;
                this.f$2 = r4;
                this.f$3 = r6;
                this.f$4 = r7;
            }

            public final Object apply(Object obj) {
                return gav.O000000o(ReadableMap.this, this.f$1, this.f$2, this.f$3, this.f$4, (Integer) obj);
            }
        }).subscribe();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Integer O000000o(ReadableMap readableMap, long j, long j2, String str, String str2, Integer num) throws Exception {
        HashMap hashMap = new HashMap();
        if (readableMap != null) {
            Iterator<Map.Entry<String, Object>> entryIterator = readableMap.getEntryIterator();
            while (entryIterator.hasNext()) {
                Map.Entry next = entryIterator.next();
                hashMap.put((String) next.getKey(), next.getValue());
            }
        }
        hashMap.put("package_id", String.valueOf(j));
        hashMap.put("plugin_id", String.valueOf(j2));
        hashMap.put("device_model", str);
        hashMap.put("package_name", str2);
        hashMap.put("sdk_level", 10058);
        hashMap.put("sdk_version_name", gbw.O000000o());
        PluginHostApi.instance().statReport("rn_plugin_framework", "rn_plugin_api", hashMap);
        return num;
    }

    public static void O000000o(long j, long j2, String str, Map<String, Object> map) {
        map.put("package_id", String.valueOf(j));
        map.put("plugin_id", String.valueOf(j2));
        map.put("device_model", str);
        map.put("sdk_level", 10058);
        PluginHostApi.instance().statReport("rn_plugin_framework", "rn_plugin_open_status", map);
    }

    public static void O000000o(long j, long j2, String str, String str2, Map<String, Object> map) {
        map.put("package_id", String.valueOf(j));
        map.put("plugin_id", String.valueOf(j2));
        map.put("device_id", String.valueOf(str2));
        map.put("device_model", str);
        map.put("sdk_level", 10058);
        PluginHostApi.instance().statReport("rn_plugin_framework", "rn_runtime_reuse_memory_status", map);
    }

    public static void O000000o(Map<String, Object> map) {
        map.put("sdk_level", 10058);
        PluginHostApi.instance().statReport("rn_plugin_framework", "rn_runtime_reuse_null", map);
    }

    public static void O000000o(String str, PluginPackageInfo pluginPackageInfo, String str2) {
        if (!TextUtils.isEmpty(str) && pluginPackageInfo != null) {
            Observable.just(0).subscribeOn(Schedulers.io()).doOnNext(new Consumer(str, pluginPackageInfo, str2) {
                /* class _m_j.$$Lambda$gav$N3hsdqjbpZtHQQLaAG8_Rk5QMqA */
                private final /* synthetic */ String f$0;
                private final /* synthetic */ PluginPackageInfo f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void accept(Object obj) {
                    gav.O000000o(this.f$0, this.f$1, this.f$2, (Integer) obj);
                }
            }).subscribe();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(String str, PluginPackageInfo pluginPackageInfo, String str2, Integer num) throws Exception {
        HashMap hashMap = new HashMap();
        hashMap.put("device_model", str);
        hashMap.put("plugin_id", String.valueOf(pluginPackageInfo.O000000o()));
        hashMap.put("package_id", String.valueOf(pluginPackageInfo.O00000Oo()));
        hashMap.put("plugin_open_action", str2);
        hashMap.put("sdk_level", "10058");
        PluginHostApi.instance().statReport("rn_plugin_framework", "plugin_open_trace", hashMap);
    }

    public static void O000000o(DeviceStat deviceStat) {
        if (deviceStat != null && !TextUtils.isEmpty(deviceStat.model) && !TextUtils.isEmpty(deviceStat.did)) {
            Observable.just(0).subscribeOn(Schedulers.io()).doOnNext(new Consumer() {
                /* class _m_j.$$Lambda$gav$BzSvPJODssFKQwnZ8_G90m5cnU0 */

                public final void accept(Object obj) {
                    gav.O000000o(DeviceStat.this, (Integer) obj);
                }
            }).subscribe();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(DeviceStat deviceStat, Integer num) throws Exception {
        HashMap hashMap = new HashMap();
        hashMap.put("device_model", deviceStat.model);
        hashMap.put("source", 0);
        hashMap.put("online_status", Integer.valueOf(deviceStat.isOnline ? 1 : 0));
        hashMap.put("pid", Integer.valueOf(deviceStat.pid));
        hashMap.put("did", deviceStat.did);
        hashMap.put("sdk_level", "10058");
        PluginHostApi.instance().statReport("rn_plugin_framework", "offline_enter_stat", hashMap);
    }

    public static void O000000o(String str, String str2, long j, long j2, String str3, String str4, String str5, int i, ReadableMap readableMap) {
        HashMap hashMap = new HashMap();
        if (readableMap != null) {
            Iterator<Map.Entry<String, Object>> entryIterator = readableMap.getEntryIterator();
            while (entryIterator.hasNext()) {
                Map.Entry next = entryIterator.next();
                String str6 = (String) next.getKey();
                if (!TextUtils.equals(str6, "enableOldTrack") && !TextUtils.equals(str6, "keyName")) {
                    hashMap.put(str6, next.getValue());
                }
            }
        }
        hashMap.put("did", str2);
        hashMap.put("package_id", Long.valueOf(j));
        hashMap.put("plugin_id", Long.valueOf(j2));
        hashMap.put("device_model", str3);
        hashMap.put("device_name", str4);
        hashMap.put("plugin_version", str5);
        hashMap.put("sdk_level", 10058);
        PluginHostApi.instance().statReport(String.valueOf(i), str, hashMap);
    }
}
