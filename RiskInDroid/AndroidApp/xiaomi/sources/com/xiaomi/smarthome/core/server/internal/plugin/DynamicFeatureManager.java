package com.xiaomi.smarthome.core.server.internal.plugin;

import _m_j.fkf;
import _m_j.fkv;
import _m_j.o0O0OOO0;
import com.xiaomi.smarthome.ExternalLoadManager;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.core.server.internal.plugin.DynamicFeatureManager;
import java.util.Map;

public enum DynamicFeatureManager {
    instance;
    
    private final Map<String, PluginPackageInfo> mMap = new o0O0OOO0();

    public final void cancelPluginDownload(String str, PluginDownloadTask pluginDownloadTask, fkf fkf) {
    }

    public final void downloadPlugin(String str, O000000o o000000o) {
        if (o000000o != null) {
            String featurePackageName = getFeaturePackageName(str);
            if (isInstalled(featurePackageName)) {
                o000000o.onSuccess(featurePackageName, getPluginPackageInfo(featurePackageName));
            } else {
                ExternalLoadManager.instance.loadExternal(featurePackageName, new fkv(o000000o) {
                    /* class com.xiaomi.smarthome.core.server.internal.plugin.$$Lambda$DynamicFeatureManager$KLlRxzn9nqs9XSizjt96yZtpY */
                    private final /* synthetic */ DynamicFeatureManager.O000000o f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final Object call(Object obj) {
                        return DynamicFeatureManager.this.lambda$downloadPlugin$0$DynamicFeatureManager(this.f$1, (ExternalLoadManager.O000000o) obj);
                    }
                });
            }
        }
    }

    public final void installPlugin(String str, O000000o o000000o) {
        downloadPlugin(str, o000000o);
    }

    public final boolean isDynamicFeature(String str) {
        return getFeatureInfo(str) != null;
    }

    public final boolean isInstalled(String str) {
        PluginPackageInfo featureInfo = getFeatureInfo(str);
        boolean z = false;
        if (featureInfo == null) {
            return false;
        }
        if (ExternalLoadManager.instance.getLoadInfo(str).f4013O000000o == 3) {
            z = true;
        }
        if (z) {
            return z;
        }
        try {
            Class.forName(featureInfo.O00000oo());
            return true;
        } catch (ClassNotFoundException unused) {
            return z;
        }
    }

    private String getFeaturePackageName(String str) {
        PluginPackageInfo featureInfo = getFeatureInfo(str);
        if (featureInfo == null) {
            return null;
        }
        return featureInfo.O00000o().replace("df://", "");
    }

    public final int getFeatureSize() {
        Map<String, PluginPackageInfo> map = this.mMap;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    private PluginPackageInfo getFeatureInfo(String str) {
        Map<String, PluginPackageInfo> map = this.mMap;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public final PluginPackageInfo getPluginPackageInfo(String str) {
        Map<String, PluginPackageInfo> map = this.mMap;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public final boolean isDynamicFeaturePath(String str) {
        return str != null && str.startsWith("df://");
    }

    public final PluginPackageInfo getDownloadPluginPackageInfo(long j) {
        Map<String, PluginPackageInfo> map = this.mMap;
        if (map == null) {
            return null;
        }
        for (Map.Entry next : map.entrySet()) {
            PluginPackageInfo pluginPackageInfo = (PluginPackageInfo) next.getValue();
            if (isInstalled((String) next.getKey()) && pluginPackageInfo.O00000Oo() == j) {
                return pluginPackageInfo;
            }
        }
        return null;
    }

    public static abstract class O000000o {
        public final String info;

        public void onCancel(String str) {
        }

        public abstract void onFailure(String str, int i);

        public void onProgress(String str, float f) {
        }

        public abstract void onSuccess(String str, PluginPackageInfo pluginPackageInfo);

        public O000000o(String str) {
            this.info = str;
        }
    }
}
