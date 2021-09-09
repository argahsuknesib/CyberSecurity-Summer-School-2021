package _m_j;

import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class fkc {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile fkc f16511O000000o;
    private HashMap<String, PluginPackageInfo> O00000Oo = new HashMap<>();

    private fkc() {
        this.O00000Oo.clear();
        HashMap<String, PluginPackageInfo> hashMap = this.O00000Oo;
        hashMap.put("xiaomi.router.rmo15", O000000o(1004103, 1157046, 10048, "rn_plugins" + File.separator + "xiaomi.router.rmo15.zip", "com.xiaomi.routerinitial", 17, Arrays.asList("xiaomi.router.rmo15")));
        HashMap<String, PluginPackageInfo> hashMap2 = this.O00000Oo;
        hashMap2.put("miot.clock.mijia", O000000o(1005378, 1202724, 10053, "rn_plugins" + File.separator + "miot.clock.mijia.zip", "com.smarthome.spec.scene", 14, Arrays.asList("miot.clock.mijia")));
    }

    public static fkc O000000o() {
        if (f16511O000000o == null) {
            synchronized (fkc.class) {
                if (f16511O000000o == null) {
                    f16511O000000o = new fkc();
                }
            }
        }
        return f16511O000000o;
    }

    private static PluginPackageInfo O000000o(long j, long j2, int i, String str, String str2, int i2, List<String> list) {
        PluginPackageInfo pluginPackageInfo = new PluginPackageInfo();
        pluginPackageInfo.O000000o(j);
        pluginPackageInfo.O00000Oo(j2);
        pluginPackageInfo.O00000o(1);
        pluginPackageInfo.O00000Oo(i);
        pluginPackageInfo.O00000o("android");
        pluginPackageInfo.O000000o(i2);
        pluginPackageInfo.O00000o0("rn");
        pluginPackageInfo.O000000o(str);
        pluginPackageInfo.O00000Oo(str2);
        pluginPackageInfo.O000000o(list);
        pluginPackageInfo.O00000o0(System.currentTimeMillis());
        return pluginPackageInfo;
    }

    public final boolean O000000o(String str) {
        return this.O00000Oo.containsKey(str);
    }

    public final PluginPackageInfo O00000Oo(String str) {
        return this.O00000Oo.get(str);
    }

    public final List<String> O00000Oo() {
        ArrayList arrayList = new ArrayList();
        HashMap<String, PluginPackageInfo> hashMap = this.O00000Oo;
        if (hashMap != null) {
            for (String add : hashMap.keySet()) {
                arrayList.add(add);
            }
        }
        return arrayList;
    }
}
