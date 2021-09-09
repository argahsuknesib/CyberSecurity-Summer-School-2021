package com.xiaomi.smarthome.framework.plugin.rn.nativemodule.jsi;

import _m_j.fyc;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;

public class MIOTTurboModuleManager {
    private static volatile MIOTTurboModuleManager sInstance;

    private native void initJniEnv();

    static {
        System.loadLibrary("rnsdk");
    }

    public static MIOTTurboModuleManager instance() {
        if (sInstance == null) {
            synchronized ("MIOTTurboModuleManager") {
                if (sInstance == null) {
                    sInstance = new MIOTTurboModuleManager();
                }
            }
        }
        return sInstance;
    }

    public boolean isRemoteJSDebugEnabled(ReactInstanceManager reactInstanceManager) {
        DevSupportManager devSupportManager;
        DeveloperSettings devSettings;
        if (reactInstanceManager == null || (devSupportManager = reactInstanceManager.getDevSupportManager()) == null || (devSettings = devSupportManager.getDevSettings()) == null) {
            return false;
        }
        return devSettings.isRemoteJSDebugEnabled();
    }

    public void installBinding(ReactInstanceManager reactInstanceManager) {
        if (reactInstanceManager == null) {
            fyc.O000000o("MIOTTurboModuleManager", "installBinding,instanceManager is null");
        } else if (isRemoteJSDebugEnabled(reactInstanceManager)) {
            fyc.O00000o0("MIOTTurboModuleManager", "installBinding,turbo module is not supported while remote js debug is enabled");
        } else {
            ReactContext currentReactContext = reactInstanceManager.getCurrentReactContext();
            if (currentReactContext == null) {
                fyc.O00000o0("MIOTTurboModuleManager", "installBinding,ReactContext is null,call this after ReactContext initialized");
                return;
            }
            JavaScriptContextHolder javaScriptContextHolder = currentReactContext.getJavaScriptContextHolder();
            if (javaScriptContextHolder != null) {
                try {
                    currentReactContext.getCatalystInstance().getReactQueueConfiguration().getJSQueueThread().runOnQueue(new Runnable(javaScriptContextHolder) {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.jsi.$$Lambda$MIOTTurboModuleManager$x6wiD9WGi0SfHQKSC3evF_8Ufx0 */
                        private final /* synthetic */ JavaScriptContextHolder f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            MIOTTurboModuleManager.this.lambda$installBinding$0$MIOTTurboModuleManager(this.f$1);
                        }
                    });
                } catch (Throwable unused) {
                    fyc.O00000o("MIOTTurboModuleManager", "installBinding error");
                }
            }
        }
    }

    public /* synthetic */ void lambda$installBinding$0$MIOTTurboModuleManager(JavaScriptContextHolder javaScriptContextHolder) {
        installBinding(javaScriptContextHolder.get());
    }

    private synchronized void installBinding(long j) {
        fyc.O000000o("MIOTTurboModuleManager", "installBinding:".concat(String.valueOf(j)));
        initJniEnv();
        new MIOTBluetoothStateTurbo().installBinding(j);
    }
}
