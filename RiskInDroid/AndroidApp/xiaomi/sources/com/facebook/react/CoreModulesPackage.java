package com.facebook.react;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.ExceptionsManagerModule;
import com.facebook.react.modules.core.HeadlessJsTaskSupportModule;
import com.facebook.react.modules.core.Timing;
import com.facebook.react.modules.debug.DevSettingsModule;
import com.facebook.react.modules.debug.SourceCodeModule;
import com.facebook.react.modules.deviceinfo.DeviceInfoModule;
import com.facebook.react.modules.systeminfo.AndroidInfoModule;
import com.facebook.react.uimanager.UIImplementationProvider;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.systrace.Systrace;
import com.google.android.exoplayer2.C;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CoreModulesPackage extends TurboReactPackage implements ReactPackageLogger {
    private final DefaultHardwareBackBtnHandler mHardwareBackBtnHandler;
    private final boolean mLazyViewManagersEnabled;
    private final int mMinTimeLeftInFrameForNonBatchedOperationMs;
    public final ReactInstanceManager mReactInstanceManager;

    CoreModulesPackage(ReactInstanceManager reactInstanceManager, DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler, UIImplementationProvider uIImplementationProvider, boolean z, int i) {
        this.mReactInstanceManager = reactInstanceManager;
        this.mHardwareBackBtnHandler = defaultHardwareBackBtnHandler;
        this.mLazyViewManagersEnabled = z;
        this.mMinTimeLeftInFrameForNonBatchedOperationMs = i;
    }

    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        try {
            return (ReactModuleInfoProvider) Class.forName("com.facebook.react.CoreModulesPackage$$ReactModuleInfoProvider").newInstance();
        } catch (ClassNotFoundException unused) {
            Class[] clsArr = {AndroidInfoModule.class, DeviceEventManagerModule.class, DeviceInfoModule.class, DevSettingsModule.class, ExceptionsManagerModule.class, HeadlessJsTaskSupportModule.class, SourceCodeModule.class, Timing.class, UIManagerModule.class};
            final HashMap hashMap = new HashMap();
            for (int i = 0; i < 9; i++) {
                Class cls = clsArr[i];
                ReactModule reactModule = (ReactModule) cls.getAnnotation(ReactModule.class);
                hashMap.put(reactModule.name(), new ReactModuleInfo(reactModule.name(), cls.getName(), reactModule.canOverrideExistingModule(), reactModule.needsEagerInit(), reactModule.hasConstants(), reactModule.isCxxModule(), false));
            }
            return new ReactModuleInfoProvider() {
                /* class com.facebook.react.CoreModulesPackage.AnonymousClass1 */

                public Map<String, ReactModuleInfo> getReactModuleInfos() {
                    return hashMap;
                }
            };
        } catch (InstantiationException e) {
            throw new RuntimeException("No ReactModuleInfoProvider for CoreModulesPackage$$ReactModuleInfoProvider", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("No ReactModuleInfoProvider for CoreModulesPackage$$ReactModuleInfoProvider", e2);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        char c;
        switch (str.hashCode()) {
            case -1789797270:
                if (str.equals("Timing")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1633589448:
                if (str.equals("DevSettings")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1520650172:
                if (str.equals("DeviceInfo")) {
                    c = 8;
                    break;
                }
                c = 65535;
                break;
            case -1037217463:
                if (str.equals("DeviceEventManager")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -790603268:
                if (str.equals("PlatformConstants")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 512434409:
                if (str.equals("ExceptionsManager")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 881516744:
                if (str.equals("SourceCode")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1256514152:
                if (str.equals("HeadlessJsTaskSupport")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1861242489:
                if (str.equals("UIManager")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return new AndroidInfoModule(reactApplicationContext);
            case 1:
                return new DeviceEventManagerModule(reactApplicationContext, this.mHardwareBackBtnHandler);
            case 2:
                return new DevSettingsModule(this.mReactInstanceManager.getDevSupportManager());
            case 3:
                return new ExceptionsManagerModule(this.mReactInstanceManager.getDevSupportManager());
            case 4:
                return new HeadlessJsTaskSupportModule(reactApplicationContext);
            case 5:
                return new SourceCodeModule(reactApplicationContext);
            case 6:
                return new Timing(reactApplicationContext, this.mReactInstanceManager.getDevSupportManager());
            case 7:
                return createUIManager(reactApplicationContext);
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                return new DeviceInfoModule(reactApplicationContext);
            default:
                throw new IllegalArgumentException("In CoreModulesPackage, could not find Native module for ".concat(String.valueOf(str)));
        }
    }

    private UIManagerModule createUIManager(ReactApplicationContext reactApplicationContext) {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_START);
        Systrace.beginSection(0, "createUIManagerModule");
        try {
            if (this.mLazyViewManagersEnabled) {
                return new UIManagerModule(reactApplicationContext, new UIManagerModule.ViewManagerResolver() {
                    /* class com.facebook.react.CoreModulesPackage.AnonymousClass2 */

                    public ViewManager getViewManager(String str) {
                        return CoreModulesPackage.this.mReactInstanceManager.createViewManager(str);
                    }

                    public List<String> getViewManagerNames() {
                        return CoreModulesPackage.this.mReactInstanceManager.getViewManagerNames();
                    }
                }, this.mMinTimeLeftInFrameForNonBatchedOperationMs);
            }
            UIManagerModule uIManagerModule = new UIManagerModule(reactApplicationContext, this.mReactInstanceManager.getOrCreateViewManagers(reactApplicationContext), this.mMinTimeLeftInFrameForNonBatchedOperationMs);
            Systrace.endSection(0);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_END);
            return uIManagerModule;
        } finally {
            Systrace.endSection(0);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_END);
        }
    }

    public void startProcessPackage() {
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_CORE_REACT_PACKAGE_START);
    }

    public void endProcessPackage() {
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_CORE_REACT_PACKAGE_END);
    }
}
