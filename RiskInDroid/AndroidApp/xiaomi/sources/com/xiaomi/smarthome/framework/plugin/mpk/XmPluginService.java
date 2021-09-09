package com.xiaomi.smarthome.framework.plugin.mpk;

import _m_j.gsy;
import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaomi.plugin.core.XmPluginPackage;
import com.xiaomi.smarthome.device.api.service.IXmPluginHostService;
import com.xiaomi.smarthome.device.api.service.XmPluginBaseService;
import com.xiaomi.smarthome.frame.plugin.PluginRuntimeManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class XmPluginService extends Service implements IXmPluginHostService {
    ArrayList<XmPluginServiceContext> mXmPluginServiceList = new ArrayList<>();
    HashMap<String, XmPluginServiceContext> mXmPluginServiceMap = new HashMap<>();

    public static class XmPluginServiceContext {
        XmPluginPackage mPluginPackage;
        XmPluginBaseService mXmPluginBaseService;
    }

    /* access modifiers changed from: package-private */
    public XmPluginServiceContext createServiceContext(Intent intent) {
        if (intent == null) {
            return null;
        }
        String stringExtra = intent.getStringExtra("extra_package");
        String stringExtra2 = intent.getStringExtra("extra_class");
        gsy.O000000o(3, "XmPluginService", "createServiceContext packageName:" + stringExtra + " className:" + stringExtra2);
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
            XmPluginServiceContext xmPluginServiceContext = this.mXmPluginServiceMap.get(stringExtra);
            if (xmPluginServiceContext != null) {
                return xmPluginServiceContext;
            }
            XmPluginPackage packageFromPackage = PluginRuntimeManager.getInstance().getPackageFromPackage(stringExtra);
            if (packageFromPackage == null) {
                gsy.O000000o(3, "XmPluginService", "XmPluginPackage null");
                return null;
            }
            try {
                XmPluginBaseService xmPluginBaseService = (XmPluginBaseService) packageFromPackage.classLoader.loadClass(stringExtra2).getConstructor(new Class[0]).newInstance(new Object[0]);
                xmPluginBaseService.attach(this, packageFromPackage);
                xmPluginBaseService.onCreate();
                XmPluginServiceContext xmPluginServiceContext2 = new XmPluginServiceContext();
                xmPluginServiceContext2.mPluginPackage = packageFromPackage;
                xmPluginServiceContext2.mXmPluginBaseService = xmPluginBaseService;
                return xmPluginServiceContext2;
            } catch (Exception e) {
                ErrorInfoActivity.showErrorInfo(this, packageFromPackage, e);
            }
        }
        return null;
    }

    public void onCreate() {
        super.onCreate();
        gsy.O000000o(3, "XmPluginService", "onCreate");
    }

    public void onRebind(Intent intent) {
        super.onRebind(intent);
        gsy.O000000o(3, "XmPluginService", "onRebind");
        XmPluginServiceContext createServiceContext = createServiceContext(intent);
        if (createServiceContext != null) {
            createServiceContext.mXmPluginBaseService.onRebind(intent);
        }
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        gsy.O000000o(3, "XmPluginService", "onStart");
        XmPluginServiceContext createServiceContext = createServiceContext(intent);
        if (createServiceContext != null) {
            createServiceContext.mXmPluginBaseService.onStart(intent, i);
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        gsy.O000000o(3, "XmPluginService", "onStartCommand");
        XmPluginServiceContext createServiceContext = createServiceContext(intent);
        if (createServiceContext != null) {
            createServiceContext.mXmPluginBaseService.onStartCommand(intent, i, i2);
        }
        return super.onStartCommand(intent, i, i2);
    }

    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        gsy.O000000o(3, "XmPluginService", "onTaskRemoved");
        XmPluginServiceContext createServiceContext = createServiceContext(intent);
        if (createServiceContext != null) {
            createServiceContext.mXmPluginBaseService.onTaskRemoved(intent);
        }
    }

    public IBinder onBind(Intent intent) {
        gsy.O000000o(3, "XmPluginService", "onBind");
        XmPluginServiceContext createServiceContext = createServiceContext(intent);
        if (createServiceContext != null) {
            return createServiceContext.mXmPluginBaseService.onBind(intent);
        }
        return null;
    }

    public boolean onUnbind(Intent intent) {
        gsy.O000000o(3, "XmPluginService", "onUnbind");
        XmPluginServiceContext createServiceContext = createServiceContext(intent);
        if (createServiceContext != null) {
            return createServiceContext.mXmPluginBaseService.onUnbind(intent);
        }
        return super.onUnbind(intent);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        gsy.O000000o(3, "XmPluginService", "onConfigurationChanged");
        Iterator<XmPluginServiceContext> it = this.mXmPluginServiceList.iterator();
        while (it.hasNext()) {
            try {
                it.next().mXmPluginBaseService.onConfigurationChanged(configuration);
            } catch (Exception unused) {
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        gsy.O000000o(3, "XmPluginService", "onDestroy");
        Iterator<XmPluginServiceContext> it = this.mXmPluginServiceList.iterator();
        while (it.hasNext()) {
            try {
                it.next().mXmPluginBaseService.onDestroy();
            } catch (Exception unused) {
            }
        }
        this.mXmPluginServiceMap.clear();
        this.mXmPluginServiceList.clear();
    }

    public void onLowMemory() {
        super.onLowMemory();
        gsy.O000000o(3, "XmPluginService", "onLowMemory");
        Iterator<XmPluginServiceContext> it = this.mXmPluginServiceList.iterator();
        while (it.hasNext()) {
            try {
                it.next().mXmPluginBaseService.onLowMemory();
            } catch (Exception unused) {
            }
        }
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        gsy.O000000o(3, "XmPluginService", "onTrimMemory");
        Iterator<XmPluginServiceContext> it = this.mXmPluginServiceList.iterator();
        while (it.hasNext()) {
            try {
                it.next().mXmPluginBaseService.onTrimMemory(i);
            } catch (Exception unused) {
            }
        }
    }
}
